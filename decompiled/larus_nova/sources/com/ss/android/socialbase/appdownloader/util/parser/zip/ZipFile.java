package com.ss.android.socialbase.appdownloader.util.parser.zip;

import androidx.collection.SieveCacheKt;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes38.dex */
public class ZipFile implements Closeable {
    static final int BYTE_SHIFT = 8;
    private static final int CFD_LOCATOR_OFFSET = 16;
    private static final int CFH_LEN = 42;
    private static final long CFH_SIG = 0;
    private static final int HASH_SIZE = 509;
    private static final long LFH_OFFSET_FOR_FILENAME_LENGTH = 26;
    private static final int MAX_EOCD_SIZE = 65557;
    private static final int MIN_EOCD_SIZE = 22;
    static final int NIBLET_MASK = 15;
    private static final int POS_0 = 0;
    private static final int POS_1 = 1;
    private static final int POS_2 = 2;
    private static final int POS_3 = 3;
    private static final int ZIP64_EOCDL_LENGTH = 20;
    private static final int ZIP64_EOCDL_LOCATOR_OFFSET = 8;
    private static final int ZIP64_EOCD_CFD_LOCATOR_OFFSET = 48;
    private final byte[] CFH_BUF;
    private final byte[] DWORD_BUF;
    private final Comparator<ZipEntry> OFFSET_COMPARATOR;
    private final byte[] SHORT_BUF;
    private final byte[] WORD_BUF;
    private final RandomAccessFile archive;
    private final String archiveName;
    private volatile boolean closed;
    private final String encoding;
    private final List<ZipEntry> entries;
    private final Map<String, LinkedList<ZipEntry>> nameMap;
    private final boolean useUnicodeExtraFields;
    private final ZipEncoding zipEncoding;

    public class BoundedInputStream extends InputStream {
        private boolean addDummyByte;

        /* JADX INFO: renamed from: loc, reason: collision with root package name */
        private long f449575loc;
        private long remaining;
        final /* synthetic */ ZipFile this$0;

        public void addDummy() {
            this.addDummyByte = true;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            long r100 = this.remaining;
            this.remaining = r100 - 1;
            if (r100 <= 0) goto L5;
            RandomAccessFile r101 = ZipFile.access$600(this.this$0);
            monitor-enter(r101);
            RandomAccessFile r102 = ZipFile.access$600(this.this$0);     // Catch: Throwable -> L15
            long r103 = this.f449575loc;     // Catch: Throwable -> L15
            this.f449575loc = 1 + r103;     // Catch: Throwable -> L15
            r102.seek(r103);     // Catch: Throwable -> L15
            int r104 = ZipFile.access$600(this.this$0).read();     // Catch: Throwable -> L15
            monitor-exit(r101);     // Catch: Throwable -> L15
            return r104;
        L15:
            th = move-exception;
            throw th;
        L5:
            if (this.addDummyByte == false) goto L8;
            this.addDummyByte = false;
            return 0;
        L8:
            return -1;
        }

        public BoundedInputStream(ZipFile r100, long r101, long r102) {
            this.this$0 = r100;
            this.addDummyByte = false;
            this.remaining = r102;
            this.f449575loc = r101;
        }

        @Override // java.io.InputStream
        public int read(byte[] r100, int r101, int r102) throws IOException {
            long r103 = this.remaining;
            if (r103 <= 0) goto L5;
            if (r102 > 0) goto L13;
            return 0;
        L13:
            if (r102 <= r103) goto L15;
            r102 = (int) r103;
        L15:
            RandomAccessFile r104 = ZipFile.access$600(this.this$0);
            monitor-enter(r104);
            ZipFile.access$600(this.this$0).seek(this.f449575loc);     // Catch: Throwable -> L22
            int r105 = ZipFile.access$600(this.this$0).read(r100, r101, r102);     // Catch: Throwable -> L22
            monitor-exit(r104);     // Catch: Throwable -> L22
            if (r105 <= 0) goto L21;
            long r106 = r105;
            this.f449575loc += r106;
            this.remaining -= r106;
        L21:
            return r105;
        L22:
            th = move-exception;
            throw th;
        L5:
            if (this.addDummyByte == false) goto L8;
            this.addDummyByte = false;
            r100[r101] = 0;
            return 1;
        L8:
            return -1;
        }
    }

    public static class Entry extends ZipEntry {
        private final OffsetEntry offsetEntry;

        @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipEntry, java.util.zip.ZipEntry
        public int hashCode() {
            return (super.hashCode() * 3) + ((int) (OffsetEntry.access$200(this.offsetEntry) % SieveCacheKt.NodeLinkMask));
        }

        public OffsetEntry getOffsetEntry() {
            return this.offsetEntry;
        }

        public Entry(OffsetEntry r100) {
            this.offsetEntry = r100;
        }

        @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipEntry
        public boolean equals(Object r100) {
            if (super.equals(r100) == false) goto L10;
            Entry r101 = (Entry) r100;
            if (OffsetEntry.access$200(this.offsetEntry) == OffsetEntry.access$200(r101.offsetEntry)) goto L7;
            return false;
        L7:
            if (OffsetEntry.access$000(this.offsetEntry) != OffsetEntry.access$000(r101.offsetEntry)) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }
    }

    public static final class NameAndComment {
        private final byte[] comment;
        private final byte[] name;

        public static /* synthetic */ byte[] access$400(NameAndComment r100) {
            return r100.name;
        }

        public static /* synthetic */ byte[] access$500(NameAndComment r100) {
            return r100.comment;
        }

        private NameAndComment(byte[] r100, byte[] r101) {
            this.name = r100;
            this.comment = r101;
        }

        public /* synthetic */ NameAndComment(byte[] r100, byte[] r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public static final class OffsetEntry {
        private long dataOffset;
        private long headerOffset;

        private OffsetEntry() {
            this.headerOffset = -1;
            this.dataOffset = -1;
        }

        public /* synthetic */ OffsetEntry(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ long access$000(OffsetEntry r100) {
            return r100.dataOffset;
        }

        public static /* synthetic */ long access$200(OffsetEntry r100) {
            return r100.headerOffset;
        }

        public static /* synthetic */ long access$002(OffsetEntry r100, long r101) {
            r100.dataOffset = r101;
            return r101;
        }

        public static /* synthetic */ long access$202(OffsetEntry r100, long r101) {
            r100.headerOffset = r101;
            return r101;
        }
    }

    private void positionAtCentralDirectory64() throws IOException {
        skipBytes(4);
        this.archive.readFully(this.DWORD_BUF);
        this.archive.seek(ZipEightByteInteger.getLongValue(this.DWORD_BUF));
        this.archive.readFully(this.WORD_BUF);
        if (Arrays.equals(this.WORD_BUF, ZipOutputStream.ZIP64_EOCD_SIG) == false) goto L7;
        skipBytes(44);
        this.archive.readFully(this.DWORD_BUF);
        this.archive.seek(ZipEightByteInteger.getLongValue(this.DWORD_BUF));
        return;
    L7:
        throw new ZipException("archive's ZIP64 end of central directory locator is corrupt.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        this.archive.close();
    }

    static {
        CFH_SIG = ZipLong.getValue(ZipOutputStream.CFH_SIG);
    }

    private Map<ZipEntry, NameAndComment> populateFromCentralDirectory() throws IOException {
        HashMap r100 = new HashMap();
        positionAtCentralDirectory();
        this.archive.readFully(this.WORD_BUF);
        long r101 = ZipLong.getValue(this.WORD_BUF);
        if (r101 == CFH_SIG) goto L10;
        if (startsWithLocalFileHeader() == false) goto L10;
        throw new IOException("central directory is empty, can't expand corrupt archive.");
    L10:
        if (r101 != CFH_SIG) goto L12;
        readCentralDirectoryEntry(r100);
        this.archive.readFully(this.WORD_BUF);
        r101 = ZipLong.getValue(this.WORD_BUF);
        goto L10
    L12:
        return r100;
    }

    private void positionAtCentralDirectory32() throws IOException {
        skipBytes(16);
        this.archive.readFully(this.WORD_BUF);
        this.archive.seek(ZipLong.getValue(this.WORD_BUF));
    }

    private void positionAtEndOfCentralDirectoryRecord() throws IOException {
        if (tryToLocateSignature(22, 65557, ZipOutputStream.EOCD_SIG) == false) goto L6;
        return;
    L6:
        throw new ZipException("archive is not a ZIP archive");
    }

    private boolean startsWithLocalFileHeader() throws IOException {
        this.archive.seek(0);
        this.archive.readFully(this.WORD_BUF);
        return Arrays.equals(this.WORD_BUF, ZipOutputStream.LFH_SIG);
    }

    public void finalize() throws Throwable {
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    L3:
        if (this.closed == true) goto L5;
        System.err.printf("Cleaning up unclosed %s for archive %s%n", new Object[]{getClass().getSimpleName(), this.archiveName});     // Catch: Throwable -> L7
        close();     // Catch: Throwable -> L7
    L5:
        super.finalize();
    }

    public Enumeration<ZipEntry> getEntries() {
        return Collections.enumeration(this.entries);
    }

    public Enumeration<ZipEntry> getEntriesInPhysicalOrder() {
        ZipEntry[] r100 = (ZipEntry[]) this.entries.toArray(new ZipEntry[0]);
        Arrays.sort(r100, this.OFFSET_COMPARATOR);
        return Collections.enumeration(Arrays.asList(r100));
    }

    private void positionAtCentralDirectory() throws IOException {
        positionAtEndOfCentralDirectoryRecord();
        boolean r100 = false;
        if (this.archive.getFilePointer() <= 20) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        RandomAccessFile r102 = this.archive;
        r102.seek(r102.getFilePointer() - 20);
        this.archive.readFully(this.WORD_BUF);
        r100 = Arrays.equals(ZipOutputStream.ZIP64_EOCD_LOC_SIG, this.WORD_BUF);
    L8:
        if (r100 == true) goto L12;
        if (r101 == false) goto L11;
        skipBytes(16);
    L11:
        positionAtCentralDirectory32();
        return;
    L12:
        positionAtCentralDirectory64();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public String getEncoding() {
        return this.encoding;
    }

    public String getName() {
        return this.archiveName;
    }

    public ZipFile(String r100) throws IOException {
        this(new PolarisFileWrapper(r100), null);
    }

    public static /* synthetic */ RandomAccessFile access$600(ZipFile r100) {
        return r100.archive;
    }

    public static void closeQuietly(ZipFile r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    private void readCentralDirectoryEntry(Map<ZipEntry, NameAndComment> r110) throws IOException {
        this.archive.readFully(this.CFH_BUF);
        AnonymousClass1 r100 = null;
        OffsetEntry r101 = new OffsetEntry(r100);
        Entry r102 = new Entry(r101);
        r102.setPlatform((ZipShort.getValue(this.CFH_BUF, 0) >> 8) & 15);
        GeneralPurposeBit r103 = GeneralPurposeBit.parse(this.CFH_BUF, 4);
        boolean r104 = r103.usesUTF8ForNames();
        if (r104 == false) goto L5;
        ZipEncoding r105 = ZipEncodingHelper.UTF8_ZIP_ENCODING;
    L6:
        r102.setGeneralPurposeBit(r103);
        r102.setMethod(ZipShort.getValue(this.CFH_BUF, 6));
        r102.setTime(ZipUtil.dosToJavaTime(ZipLong.getValue(this.CFH_BUF, 8)));
        r102.setCrc(ZipLong.getValue(this.CFH_BUF, 12));
        r102.setCompressedSize(ZipLong.getValue(this.CFH_BUF, 16));
        r102.setSize(ZipLong.getValue(this.CFH_BUF, 20));
        int r106 = ZipShort.getValue(this.CFH_BUF, 24);
        int r107 = ZipShort.getValue(this.CFH_BUF, 26);
        int r108 = ZipShort.getValue(this.CFH_BUF, 28);
        int r109 = ZipShort.getValue(this.CFH_BUF, 30);
        r102.setInternalAttributes(ZipShort.getValue(this.CFH_BUF, 32));
        r102.setExternalAttributes(ZipLong.getValue(this.CFH_BUF, 34));
        if ((this.archive.length() - this.archive.getFilePointer()) < r106) goto L23;
        byte[] r111 = new byte[r106];
        this.archive.readFully(r111);
        r102.setName(r105.decode(r111), r111);
        OffsetEntry.access$202(r101, ZipLong.getValue(this.CFH_BUF, 38));
        this.entries.add(r102);
        if ((this.archive.length() - this.archive.getFilePointer()) < r107) goto L21;
        byte[] r112 = new byte[r107];
        this.archive.readFully(r112);
        r102.setCentralDirectoryExtra(r112);
        setSizesAndOffsetFromZip64Extra(r102, r101, r109);
        if ((this.archive.length() - this.archive.getFilePointer()) < r108) goto L19;
        byte[] r113 = new byte[r108];
        this.archive.readFully(r113);
        r102.setComment(r105.decode(r113));
        if (r104 == false) goto L15;
        return;
    L15:
        if (this.useUnicodeExtraFields == false) goto L25;
        r110.put(r102, new NameAndComment(r111, r113, r100));
        return;
    L25:
        return;
    L19:
        throw new EOFException();
    L21:
        throw new EOFException();
    L23:
        throw new EOFException();
    L5:
        r105 = this.zipEncoding;
        goto L6
    }

    private void resolveLocalFileHeaderData(Map<ZipEntry, NameAndComment> r110) throws IOException {
        Iterator<ZipEntry> r100 = this.entries.iterator();
    L4:
        if (r100.hasNext() == false) goto L28;
        Entry r101 = (Entry) r100.next();
        OffsetEntry r102 = r101.getOffsetEntry();
        long r103 = OffsetEntry.access$200(r102);
        RandomAccessFile r104 = this.archive;
        long r105 = r103 + LFH_OFFSET_FOR_FILENAME_LENGTH;
        r104.seek(r105);
        this.archive.readFully(this.SHORT_BUF);
        int r106 = ZipShort.getValue(this.SHORT_BUF);
        this.archive.readFully(this.SHORT_BUF);
        int r107 = ZipShort.getValue(this.SHORT_BUF);
        int r108 = r106;
    L6:
        if (r108 <= 0) goto L12;
        int r109 = this.archive.skipBytes(r108);
        if (r109 <= 0) goto L11;
        r108 = r108 - r109;
        goto L6
    L11:
        throw new IOException("failed to skip file name in local file header");
    L12:
        long r111 = r107;
        if ((this.archive.length() - this.archive.getFilePointer()) < r111) goto L27;
        byte[] r112 = new byte[r107];
        this.archive.readFully(r112);
        r101.setExtra(r112);     // Catch: RuntimeException -> L23
        OffsetEntry.access$002(r102, (((r105 + 2) + 2) + ((long) r106)) + r111);
        if (r110.containsKey(r101) == false) goto L19;
        NameAndComment r113 = r110.get(r101);
        ZipUtil.setNameAndCommentFromExtraFields(r101, NameAndComment.access$400(r113), NameAndComment.access$500(r113));
    L19:
        String r114 = r101.getName();
        LinkedList<ZipEntry> r115 = this.nameMap.get(r114);
        if (r115 != null) goto L22;
        r115 = new LinkedList();
        this.nameMap.put(r114, r115);
    L22:
        r115.addLast(r101);
    L23:
        e = move-exception;
        ZipException r116 = new ZipException("Invalid extra data in entry " + r101.getName());
        r116.initCause(e);
        throw r116;
    L27:
        throw new EOFException();
    }

    private void skipBytes(int r100) throws IOException {
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L9;
        int r102 = this.archive.skipBytes(r100 - r101);
        if (r102 <= 0) goto L8;
        r101 = r101 + r102;
        goto L3
    L8:
        throw new EOFException();
    }

    public boolean canReadEntryData(ZipEntry r100) {
        return ZipUtil.canHandleEntryData(r100);
    }

    public Iterable<ZipEntry> getEntries(String r100) {
        LinkedList<ZipEntry> r101 = this.nameMap.get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return Collections.emptyList();
    }

    public Iterable<ZipEntry> getEntriesInPhysicalOrder(String r100) {
        ZipEntry[] r101 = new ZipEntry[0];
        if (this.nameMap.containsKey(r100) == false) goto L6;
        r101 = (ZipEntry[]) this.nameMap.get(r100).toArray(r101);
        Arrays.sort(r101, this.OFFSET_COMPARATOR);
    L6:
        return Arrays.asList(r101);
    }

    public ZipEntry getEntry(String r100) {
        LinkedList<ZipEntry> r101 = this.nameMap.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getFirst();
    }

    public InputStream getInputStream(ZipEntry r100) throws IOException, ZipException {
        if ((r100 instanceof Entry) == true) goto L6;
        return null;
    L6:
        OffsetEntry r101 = ((Entry) r100).getOffsetEntry();
        ZipUtil.checkRequestedFeatures(r100);
        final BoundedInputStream r102 = new BoundedInputStream(this, OffsetEntry.access$000(r101), r100.getCompressedSize());
        int r103 = r100.getMethod();
        if (r103 != 0) goto L9;
        return r102;
    L9:
        if (r103 != 8) goto L13;
        r102.addDummy();
        final Inflater r104 = new Inflater(true);
        return new AnonymousClass1(this, r102, r104, r104);
    L13:
        throw new ZipException("Found unsupported compression method " + r100.getMethod());
    }

    public ZipFile(File r100) throws IOException {
        this(r100, null);
    }

    public ZipFile(String r100, String r101) throws IOException {
        this(new PolarisFileWrapper(r100), r101, true);
    }

    public ZipFile(File r100, String r101) throws IOException {
        this(r100, r101, true);
    }

    public ZipFile(File r100, String r101, boolean r102) throws IOException {
        this.entries = new LinkedList();
        this.nameMap = new HashMap(509);
        this.DWORD_BUF = new byte[8];
        this.WORD_BUF = new byte[4];
        this.CFH_BUF = new byte[42];
        this.SHORT_BUF = new byte[2];
        this.OFFSET_COMPARATOR = new AnonymousClass2(this);
        this.archiveName = r100.getAbsolutePath();
        this.encoding = r101;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(r101);
        this.useUnicodeExtraFields = r102;
        this.archive = new RandomAccessFile(r100, "r");
        resolveLocalFileHeaderData(populateFromCentralDirectory());     // Catch: Throwable -> L6
        this.closed = false;
        return;
    L6:
        th = move-exception;
        this.closed = true;
        this.archive.close();     // Catch: IOException -> L10
    L9:
        throw th;
    }

    private void setSizesAndOffsetFromZip64Extra(ZipEntry r110, OffsetEntry r111, int r112) throws IOException {
        Zip64ExtendedInformationExtraField r100 = (Zip64ExtendedInformationExtraField) r110.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (r100 == null) goto L32;
        boolean r101 = true;
        if (r110.getSize() != BodyPartID.bodyIdMax) goto L7;
        boolean r102 = true;
    L9:
        if (r110.getCompressedSize() != BodyPartID.bodyIdMax) goto L11;
        boolean r103 = true;
    L13:
        if (OffsetEntry.access$200(r111) != BodyPartID.bodyIdMax) goto L15;
        boolean r104 = true;
    L17:
        if (r112 == 65535) goto L20;
        r101 = false;
    L20:
        r100.reparseCentralDirectoryData(r102, r103, r104, r101);
        if (r102 == false) goto L23;
        r110.setSize(r100.getSize().getLongValue());
    L25:
        if (r103 == false) goto L27;
        r110.setCompressedSize(r100.getCompressedSize().getLongValue());
    L29:
        if (r104 == false) goto L33;
        OffsetEntry.access$202(r111, r100.getRelativeHeaderOffset().getLongValue());
        return;
    L33:
        return;
    L27:
        if (r102 == false) goto L29;
        r100.setCompressedSize(new ZipEightByteInteger(r110.getCompressedSize()));
        goto L29
    L23:
        if (r103 == false) goto L25;
        r100.setSize(new ZipEightByteInteger(r110.getSize()));
        goto L25
    L15:
        r104 = false;
        goto L17
    L11:
        r103 = false;
        goto L13
    L7:
        r102 = false;
        goto L9
    }

    private boolean tryToLocateSignature(long r100, long r101, byte[] r102) throws IOException {
        long r103 = this.archive.length() - r100;
        long r104 = Math.max(0, this.archive.length() - r101);
        boolean r105 = false;
        if (r103 >= 0) goto L5;
    L19:
        if (r105 == false) goto L21;
        this.archive.seek(r103);
    L21:
        return r105;
    L5:
        if (r103 < r104) goto L19;
        this.archive.seek(r103);
        int r106 = this.archive.read();
        if (r106 == (-1)) goto L19;
        if (r106 != r102[0]) goto L18;
        if (this.archive.read() != r102[1]) goto L18;
        if (this.archive.read() != r102[2]) goto L18;
        if (this.archive.read() != r102[3]) goto L18;
        r105 = true;
    L18:
        r103 = r103 - 1;
        goto L5
    }
}
