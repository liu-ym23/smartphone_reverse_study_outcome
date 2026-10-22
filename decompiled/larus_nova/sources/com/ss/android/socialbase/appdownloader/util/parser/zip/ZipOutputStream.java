package com.ss.android.socialbase.appdownloader.util.parser.zip;

import com.obric.aivoice.core.data.NameKeys;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.ZipException;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes38.dex */
public class ZipOutputStream extends FilterOutputStream {
    private static final int BUFFER_SIZE = 512;
    private static final int CFH_COMMENT_LENGTH_OFFSET = 32;
    private static final int CFH_COMPRESSED_SIZE_OFFSET = 20;
    private static final int CFH_CRC_OFFSET = 16;
    private static final int CFH_DISK_NUMBER_OFFSET = 34;
    private static final int CFH_EXTERNAL_ATTRIBUTES_OFFSET = 38;
    private static final int CFH_EXTRA_LENGTH_OFFSET = 30;
    private static final int CFH_FILENAME_LENGTH_OFFSET = 28;
    private static final int CFH_FILENAME_OFFSET = 46;
    private static final int CFH_GPB_OFFSET = 8;
    private static final int CFH_INTERNAL_ATTRIBUTES_OFFSET = 36;
    private static final int CFH_LFH_OFFSET = 42;
    private static final int CFH_METHOD_OFFSET = 10;
    private static final int CFH_ORIGINAL_SIZE_OFFSET = 24;
    protected static final byte[] CFH_SIG = null;
    private static final int CFH_SIG_OFFSET = 0;
    private static final int CFH_TIME_OFFSET = 12;
    private static final int CFH_VERSION_MADE_BY_OFFSET = 4;
    private static final int CFH_VERSION_NEEDED_OFFSET = 6;
    protected static final byte[] DD_SIG = null;
    public static final int DEFAULT_COMPRESSION = -1;
    static final String DEFAULT_ENCODING = null;
    public static final int DEFLATED = 8;
    private static final int DEFLATER_BLOCK_SIZE = 8192;
    public static final int EFS_FLAG = 2048;
    private static final byte[] EMPTY = null;
    protected static final byte[] EOCD_SIG = null;
    private static final int LFH_COMPRESSED_SIZE_OFFSET = 18;
    private static final int LFH_CRC_OFFSET = 14;
    private static final int LFH_EXTRA_LENGTH_OFFSET = 28;
    private static final int LFH_FILENAME_LENGTH_OFFSET = 26;
    private static final int LFH_FILENAME_OFFSET = 30;
    private static final int LFH_GPB_OFFSET = 6;
    private static final int LFH_METHOD_OFFSET = 8;
    private static final int LFH_ORIGINAL_SIZE_OFFSET = 22;
    protected static final byte[] LFH_SIG = null;
    private static final int LFH_SIG_OFFSET = 0;
    private static final int LFH_TIME_OFFSET = 10;
    private static final int LFH_VERSION_NEEDED_OFFSET = 4;
    private static final byte[] LZERO = null;
    private static final byte[] ONE = null;
    public static final int STORED = 0;
    private static final byte[] ZERO = null;
    static final byte[] ZIP64_EOCD_LOC_SIG = null;
    static final byte[] ZIP64_EOCD_SIG = null;
    protected byte[] buf;
    private final Calendar calendarInstance;
    private long cdLength;
    private long cdOffset;
    private String comment;

    /* JADX INFO: renamed from: crc, reason: collision with root package name */
    private final CRC32 f449576crc;
    private UnicodeExtraFieldPolicy createUnicodeExtraFields;
    protected final Deflater def;
    private String encoding;
    private final List<ZipEntry> entries;
    private CurrentEntry entry;
    private boolean fallbackToUTF8;
    private boolean finished;
    private boolean hasCompressionLevelChanged;
    private boolean hasUsedZip64;
    private int level;
    private int method;
    private final Map<ZipEntry, Long> offsets;
    private final byte[] oneByte;
    private final RandomAccessFile raf;
    private boolean useUTF8Flag;
    private long written;
    private Zip64Mode zip64Mode;
    private ZipEncoding zipEncoding;

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.util.parser.zip.ZipOutputStream$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class CurrentEntry {
        private long bytesRead;
        private boolean causedUseOfZip64;
        private long dataStart;
        private final ZipEntry entry;
        private boolean hasWritten;
        private long localDataStart;

        private CurrentEntry(ZipEntry r100) {
            this.localDataStart = 0;
            this.dataStart = 0;
            this.bytesRead = 0;
            this.causedUseOfZip64 = false;
            this.entry = r100;
        }

        public static /* synthetic */ ZipEntry access$000(CurrentEntry r100) {
            return r100.entry;
        }

        public static /* synthetic */ long access$100(CurrentEntry r100) {
            return r100.dataStart;
        }

        public static /* synthetic */ boolean access$200(CurrentEntry r100) {
            return r100.hasWritten;
        }

        public static /* synthetic */ long access$300(CurrentEntry r100) {
            return r100.bytesRead;
        }

        public static /* synthetic */ long access$400(CurrentEntry r100) {
            return r100.localDataStart;
        }

        public static /* synthetic */ boolean access$500(CurrentEntry r100) {
            return r100.causedUseOfZip64;
        }

        public /* synthetic */ CurrentEntry(ZipEntry r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static /* synthetic */ long access$102(CurrentEntry r100, long r101) {
            r100.dataStart = r101;
            return r101;
        }

        public static /* synthetic */ boolean access$202(CurrentEntry r100, boolean r101) {
            r100.hasWritten = r101;
            return r101;
        }

        public static /* synthetic */ long access$302(CurrentEntry r100, long r101) {
            r100.bytesRead = r101;
            return r101;
        }

        public static /* synthetic */ long access$402(CurrentEntry r100, long r101) {
            r100.localDataStart = r101;
            return r101;
        }

        public static /* synthetic */ boolean access$502(CurrentEntry r100, boolean r101) {
            r100.causedUseOfZip64 = r101;
            return r101;
        }
    }

    public static final class UnicodeExtraFieldPolicy {
        public static final UnicodeExtraFieldPolicy ALWAYS = null;
        public static final UnicodeExtraFieldPolicy NEVER = null;
        public static final UnicodeExtraFieldPolicy NOT_ENCODEABLE = null;
        private final String name;

        static {
            ALWAYS = new UnicodeExtraFieldPolicy(NameKeys.LoadStrategy_Always);
            NEVER = new UnicodeExtraFieldPolicy("never");
            NOT_ENCODEABLE = new UnicodeExtraFieldPolicy("not encodeable");
        }

        public String toString() {
            return this.name;
        }

        private UnicodeExtraFieldPolicy(String r100) {
            this.name = r100;
        }
    }

    static {
        EMPTY = new byte[0];
        ZERO = new byte[]{0, 0};
        LZERO = new byte[]{0, 0, 0, 0};
        ONE = ZipLong.getBytes(1);
        LFH_SIG = ZipLong.LFH_SIG.getBytes();
        DD_SIG = ZipLong.DD_SIG.getBytes();
        CFH_SIG = ZipLong.CFH_SIG.getBytes();
        EOCD_SIG = ZipLong.getBytes(101010256);
        ZIP64_EOCD_SIG = ZipLong.getBytes(101075792);
        ZIP64_EOCD_LOC_SIG = ZipLong.getBytes(117853008);
    }

    private void deflateUntilInputIsNeeded() throws IOException {
    L3:
        if (this.def.needsInput() == true) goto L5;
        deflate();
        goto L3
    }

    private void flushDeflater() throws IOException {
        if (CurrentEntry.access$000(this.entry).getMethod() != 8) goto L8;
        this.def.finish();
    L6:
        if (this.def.finished() == true) goto L10;
        deflate();
        goto L6
    L10:
        return;
    }

    private void preClose() throws IOException {
        if (this.finished == true) goto L13;
        CurrentEntry r100 = this.entry;
        if (r100 == null) goto L11;
        if (CurrentEntry.access$200(r100) == true) goto L14;
        write(EMPTY, 0, 0);
        return;
    L14:
        return;
    L11:
        throw new IOException("No current entry to close");
    L13:
        throw new IOException("Stream has already been finished");
    }

    private void writeCentralDirectoryInChunks() throws IOException {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream(TTVideoEngineInterface.GLOBAL_ENGINE_OPTION_MIN);
        Iterator<ZipEntry> r101 = this.entries.iterator();
    L3:
        int r102 = 0;
    L5:
        if (r101.hasNext() == false) goto L9;
        r100.write(createCentralFileHeader(r101.next()));
        r102 = r102 + 1;
        if (r102 <= 1000) goto L5;
        writeCounted(r100.toByteArray());
        r100.reset();
        goto L3
    L9:
        writeCounted(r100.toByteArray());
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.finished == true) goto L5;
        finish();
    L5:
        destroy();
    }

    public final void deflate() throws IOException {
        Deflater r100 = this.def;
        byte[] r101 = this.buf;
        int r102 = r100.deflate(r101, 0, r101.length);
        if (r102 <= 0) goto L6;
        writeCounted(this.buf, 0, r102);
        return;
    }

    public void destroy() throws IOException {
        RandomAccessFile r100 = this.raf;
        if (r100 == null) goto L5;
        r100.close();
    L5:
        OutputStream r101 = ((FilterOutputStream) this).out;
        if (r101 == null) goto L9;
        r101.close();
        return;
    }

    public void finish() throws IOException {
        if (this.finished == true) goto L10;
        if (this.entry == null) goto L7;
        closeEntry();
    L7:
        this.cdOffset = this.written;
        writeCentralDirectoryInChunks();
        this.cdLength = this.written - this.cdOffset;
        writeZip64CentralDirectory();
        writeCentralDirectoryEnd();
        this.offsets.clear();
        this.entries.clear();
        this.def.end();
        this.finished = true;
        return;
    L10:
        throw new IOException("This archive has already been finished");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        OutputStream r100 = ((FilterOutputStream) this).out;
        if (r100 == null) goto L6;
        r100.flush();
        return;
    }

    public boolean isSeekable() {
        if (this.raf == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void writeCentralDirectoryEnd() throws IOException {
        writeCounted(EOCD_SIG);
        byte[] r100 = ZERO;
        writeCounted(r100);
        writeCounted(r100);
        int r101 = this.entries.size();
        if (r101 <= 65535) goto L10;
        if (this.zip64Mode != Zip64Mode.Never) goto L10;
        throw new Zip64RequiredException("archive contains more than 65535 entries.");
    L10:
        if (this.cdOffset > BodyPartID.bodyIdMax) goto L12;
    L16:
        byte[] r102 = ZipShort.getBytes(Math.min(r101, 65535));
        writeCounted(r102);
        writeCounted(r102);
        writeCounted(ZipLong.getBytes(Math.min(this.cdLength, BodyPartID.bodyIdMax)));
        writeCounted(ZipLong.getBytes(Math.min(this.cdOffset, BodyPartID.bodyIdMax)));
        ByteBuffer r103 = this.zipEncoding.encode(this.comment);
        int r104 = r103.limit() - r103.position();
        writeCounted(ZipShort.getBytes(r104));
        writeCounted(r103.array(), r103.arrayOffset(), r104);
        return;
    L12:
        if (this.zip64Mode != Zip64Mode.Never) goto L16;
        throw new Zip64RequiredException("archive's size exceeds the limit of 4GByte.");
    }

    public void writeZip64CentralDirectory() throws IOException {
        if (this.zip64Mode != Zip64Mode.Never) goto L6;
        return;
    L6:
        if (this.hasUsedZip64 == true) goto L15;
        if (this.cdOffset < BodyPartID.bodyIdMax) goto L10;
    L13:
        this.hasUsedZip64 = true;
        goto L15
    L10:
        if (this.cdLength >= BodyPartID.bodyIdMax) goto L13;
        if (this.entries.size() >= 65535) goto L13;
    L15:
        if (this.hasUsedZip64 == true) goto L17;
        return;
    L17:
        long r100 = this.written;
        writeOut(ZIP64_EOCD_SIG);
        writeOut(ZipEightByteInteger.getBytes(44));
        writeOut(ZipShort.getBytes(45));
        writeOut(ZipShort.getBytes(45));
        byte[] r101 = LZERO;
        writeOut(r101);
        writeOut(r101);
        byte[] r102 = ZipEightByteInteger.getBytes(this.entries.size());
        writeOut(r102);
        writeOut(r102);
        writeOut(ZipEightByteInteger.getBytes(this.cdLength));
        writeOut(ZipEightByteInteger.getBytes(this.cdOffset));
        writeOut(ZIP64_EOCD_LOC_SIG);
        writeOut(r101);
        writeOut(ZipEightByteInteger.getBytes(r100));
        writeOut(ONE);
    }

    public void closeEntry() throws IOException {
        preClose();
        flushDeflater();
        Zip64Mode r100 = getEffectiveZip64Mode(CurrentEntry.access$000(this.entry));
        long r101 = this.written - CurrentEntry.access$100(this.entry);
        long r102 = this.f449576crc.getValue();
        this.f449576crc.reset();
        closeEntry(handleSizesAndCrc(r101, r102, r100));
    }

    public String getEncoding() {
        return this.encoding;
    }

    public ZipOutputStream(File r100) throws IOException {
        RandomAccessFile r101 = null;
        super(null);
        this.finished = false;
        this.comment = "";
        this.level = -1;
        this.hasCompressionLevelChanged = false;
        this.method = 8;
        this.entries = new LinkedList();
        this.f449576crc = new CRC32();
        this.written = 0;
        this.cdOffset = 0;
        this.cdLength = 0;
        this.offsets = new HashMap();
        this.encoding = null;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);
        this.def = new Deflater(this.level, true);
        this.buf = new byte[512];
        this.useUTF8Flag = true;
        this.fallbackToUTF8 = false;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.hasUsedZip64 = false;
        this.zip64Mode = Zip64Mode.AsNeeded;
        this.calendarInstance = Calendar.getInstance();
        this.oneByte = new byte[1];
        RandomAccessFile r102 = new RandomAccessFile(r100, "rw");     // Catch: IOException -> L7
        r102.setLength(0);     // Catch: IOException -> L6
    L13:
        this.raf = r102;
        return;
    L8:
        if (r102 != null) goto L16;
        r101 = r102;
    L12:
        ((FilterOutputStream) this).out = Files.newOutputStream(r100.toPath(), new OpenOption[0]);
        r102 = r101;
        goto L13
    L16:
        r102.close();     // Catch: IOException -> L15
    L7:
        r102 = null;
        goto L8
    }

    public static long adjustToLong(int r100) {
        return ZipUtil.adjustToLong(r100);
    }

    private boolean checkIfNeedsZip64(Zip64Mode r100) throws ZipException {
        boolean r101 = isZip64Required(CurrentEntry.access$000(this.entry), r100);
        if (r101 == true) goto L5;
    L9:
        return r101;
    L5:
        if (r100 != Zip64Mode.Never) goto L9;
        throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(CurrentEntry.access$000(this.entry)));
    }

    private void closeEntry(boolean r100) throws IOException {
        if (this.raf == null) goto L5;
        rewriteSizesAndCrc(r100);
    L5:
        writeDataDescriptor(CurrentEntry.access$000(this.entry));
        this.entry = null;
    }

    private byte[] createCentralFileHeader(ZipEntry r100) throws IOException {
        long r101 = this.offsets.get(r100).longValue();
        if (hasZip64Extra(r100) == false) goto L5;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == true) goto L17;
    L21:
        handleZip64Extra(r100, r101, r102);
        return createCentralFileHeader(r100, getName(r100), r101, r102);
    L17:
        if (this.zip64Mode != Zip64Mode.Never) goto L21;
        throw new Zip64RequiredException("archive's size exceeds the limit of 4GByte.");
    L5:
        if (r100.getCompressedSize() >= BodyPartID.bodyIdMax) goto L14;
        if (r100.getSize() >= BodyPartID.bodyIdMax) goto L14;
        if (r101 >= BodyPartID.bodyIdMax) goto L14;
        if (this.zip64Mode == Zip64Mode.Always) goto L14;
        r102 = false;
        goto L15
    }

    private Zip64Mode getEffectiveZip64Mode(ZipEntry r100) {
        if (this.zip64Mode != Zip64Mode.AsNeeded) goto L14;
        if (this.raf != null) goto L14;
        if (r100.getMethod() != 8) goto L14;
        if (r100.getSize() != (-1)) goto L14;
        return Zip64Mode.Never;
    L14:
        return this.zip64Mode;
    }

    private ZipEncoding getEntryEncoding(ZipEntry r100) {
        if (this.zipEncoding.canEncode(r100.getName()) == true) goto L8;
        if (this.fallbackToUTF8 == false) goto L8;
        return ZipEncodingHelper.UTF8_ZIP_ENCODING;
    L8:
        return this.zipEncoding;
    }

    private ByteBuffer getName(ZipEntry r100) throws IOException {
        return getEntryEncoding(r100).encode(r100.getName());
    }

    private Zip64ExtendedInformationExtraField getZip64Extra(ZipEntry r100) {
        CurrentEntry r101 = this.entry;
        if (r101 == null) goto L5;
        CurrentEntry.access$502(r101, !this.hasUsedZip64);
    L5:
        this.hasUsedZip64 = true;
        Zip64ExtendedInformationExtraField r102 = (Zip64ExtendedInformationExtraField) r100.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (r102 != null) goto L8;
        r102 = new Zip64ExtendedInformationExtraField();
    L8:
        r100.addAsFirstExtraField(r102);
        return r102;
    }

    private boolean hasZip64Extra(ZipEntry r100) {
        if (r100.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isDeflatedToOutputStream(int r100) {
        if (r100 == 8) goto L5;
    L7:
        return false;
    L5:
        if (this.raf != null) goto L7;
        return true;
    }

    private boolean isTooLageForZip32(ZipEntry r100) {
        if (r100.getSize() < BodyPartID.bodyIdMax) goto L5;
    L8:
        return true;
    L5:
        if (r100.getCompressedSize() >= BodyPartID.bodyIdMax) goto L8;
        return false;
    }

    private void rewriteSizesAndCrc(boolean r110) throws IOException {
        long r100 = this.raf.getFilePointer();
        this.raf.seek(CurrentEntry.access$400(this.entry));
        writeOut(ZipLong.getBytes(CurrentEntry.access$000(this.entry).getCrc()));
        if (hasZip64Extra(CurrentEntry.access$000(this.entry)) == false) goto L7;
        if (r110 == false) goto L7;
        ZipLong r101 = ZipLong.ZIP64_MAGIC;
        writeOut(r101.getBytes());
        writeOut(r101.getBytes());
    L9:
        if (hasZip64Extra(CurrentEntry.access$000(this.entry)) == false) goto L15;
        this.raf.seek((((CurrentEntry.access$400(this.entry) + 12) + 4) + ((long) getName(CurrentEntry.access$000(this.entry)).limit())) + 4);
        writeOut(ZipEightByteInteger.getBytes(CurrentEntry.access$000(this.entry).getSize()));
        writeOut(ZipEightByteInteger.getBytes(CurrentEntry.access$000(this.entry).getCompressedSize()));
        if (r110 == true) goto L15;
        this.raf.seek(CurrentEntry.access$400(this.entry) - 10);
        writeOut(ZipShort.getBytes(10));
        CurrentEntry.access$000(this.entry).removeExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        CurrentEntry.access$000(this.entry).setExtra();
        if (CurrentEntry.access$500(this.entry) == false) goto L15;
        this.hasUsedZip64 = false;
    L15:
        this.raf.seek(r100);
        return;
    L7:
        writeOut(ZipLong.getBytes(CurrentEntry.access$000(this.entry).getCompressedSize()));
        writeOut(ZipLong.getBytes(CurrentEntry.access$000(this.entry).getSize()));
        goto L9
    }

    private void setDefaults(ZipEntry r100) {
        if (r100.getMethod() != (-1)) goto L6;
        r100.setMethod(this.method);
    L6:
        if (r100.getTime() != (-1)) goto L9;
        r100.setTime(System.currentTimeMillis());
        return;
    }

    public static ZipLong toDosTime(Date r100) {
        return ZipUtil.toDosTime(r100);
    }

    private void validateSizeInformation(Zip64Mode r100) throws ZipException {
        if (CurrentEntry.access$000(this.entry).getMethod() != 0) goto L16;
        if (this.raf != null) goto L16;
        if (CurrentEntry.access$000(this.entry).getSize() == (-1)) goto L14;
        if (CurrentEntry.access$000(this.entry).getCrc() == (-1)) goto L12;
        CurrentEntry.access$000(this.entry).setCompressedSize(CurrentEntry.access$000(this.entry).getSize());
        goto L16
    L12:
        throw new ZipException("crc checksum is required for STORED method when not writing to a file");
    L14:
        throw new ZipException("uncompressed size is required for STORED method when not writing to a file");
    L16:
        if (CurrentEntry.access$000(this.entry).getSize() >= BodyPartID.bodyIdMax) goto L20;
        if (CurrentEntry.access$000(this.entry).getCompressedSize() >= BodyPartID.bodyIdMax) goto L20;
        return;
    L20:
        if (r100 == Zip64Mode.Never) goto L23;
        return;
    L23:
        throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(CurrentEntry.access$000(this.entry)));
    }

    private void writeCounted(byte[] r100) throws IOException {
        writeCounted(r100, 0, r100.length);
    }

    public boolean canWriteEntryData(ZipEntry r100) {
        return ZipUtil.canHandleEntryData(r100);
    }

    public byte[] getBytes(String r100) throws ZipException {
        ByteBuffer r101 = ZipEncodingHelper.getZipEncoding(this.encoding).encode(r100);     // Catch: IOException -> L4
        int r102 = r101.limit();     // Catch: IOException -> L4
        byte[] r103 = new byte[r102];     // Catch: IOException -> L4
        System.arraycopy(r101.array(), r101.arrayOffset(), r103, 0, r102);     // Catch: IOException -> L4
        return r103;
    L4:
        e = move-exception;
        throw new ZipException("Failed to encode name: " + e.getMessage());
    }

    public void putNextEntry(ZipEntry r100) throws IOException {
        if (this.finished == true) goto L23;
        if (this.entry == null) goto L7;
        closeEntry();
    L7:
        CurrentEntry r101 = new CurrentEntry(r100, null);
        this.entry = r101;
        this.entries.add(CurrentEntry.access$000(r101));
        setDefaults(CurrentEntry.access$000(this.entry));
        Zip64Mode r102 = getEffectiveZip64Mode(CurrentEntry.access$000(this.entry));
        validateSizeInformation(r102);
        if (shouldAddZip64Extra(CurrentEntry.access$000(this.entry), r102) == false) goto L16;
        Zip64ExtendedInformationExtraField r103 = getZip64Extra(CurrentEntry.access$000(this.entry));
        ZipEightByteInteger r104 = ZipEightByteInteger.ZERO;
        if (CurrentEntry.access$000(this.entry).getMethod() == 0) goto L12;
    L14:
        r103.setSize(r104);
        r103.setCompressedSize(r104);
        CurrentEntry.access$000(this.entry).setExtra();
        goto L16
    L12:
        if (CurrentEntry.access$000(this.entry).getSize() == (-1)) goto L14;
        r104 = new ZipEightByteInteger(CurrentEntry.access$000(this.entry).getSize());
    L16:
        if (CurrentEntry.access$000(this.entry).getMethod() == 8) goto L18;
    L20:
        writeLocalFileHeader(CurrentEntry.access$000(this.entry));
        return;
    L18:
        if (this.hasCompressionLevelChanged == false) goto L20;
        this.def.setLevel(this.level);
        this.hasCompressionLevelChanged = false;
        goto L20
    L23:
        throw new IOException("Stream has already been finished");
    }

    public void setComment(String r100) {
        this.comment = r100;
    }

    public void setCreateUnicodeExtraFields(UnicodeExtraFieldPolicy r100) {
        this.createUnicodeExtraFields = r100;
    }

    public void setEncoding(String r100) {
        this.encoding = r100;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(r100);
        if (this.useUTF8Flag == true) goto L5;
        return;
    L5:
        if (ZipEncodingHelper.isUTF8(r100) == true) goto L9;
        this.useUTF8Flag = false;
        return;
    }

    public void setFallbackToUTF8(boolean r100) {
        this.fallbackToUTF8 = r100;
    }

    public void setLevel(int r100) {
        if (r100 < (-1)) goto L12;
        if (r100 > 9) goto L12;
        if (this.level != r100) goto L9;
        return;
    L9:
        this.hasCompressionLevelChanged = true;
        this.level = r100;
        return;
    L12:
        throw new IllegalArgumentException("Invalid compression level: " + r100);
    }

    public void setMethod(int r100) {
        this.method = r100;
    }

    public void setUseLanguageEncodingFlag(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        boolean r101 = false;
    L7:
        this.useUTF8Flag = r101;
        return;
    L4:
        if (ZipEncodingHelper.isUTF8(this.encoding) == false) goto L6;
        r101 = true;
        goto L7
    }

    public void setUseZip64(Zip64Mode r100) {
        this.zip64Mode = r100;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r100) throws IOException {
        byte[] r101 = this.oneByte;
        r101[0] = (byte) (r100 & 255);
        write(r101, 0, 1);
    }

    public void writeCentralFileHeader(ZipEntry r100) throws IOException {
        writeCounted(createCentralFileHeader(r100));
    }

    public void writeDataDescriptor(ZipEntry r100) throws IOException {
        if (r100.getMethod() == 8) goto L5;
        return;
    L5:
        if (this.raf != null) goto L14;
        writeCounted(DD_SIG);
        writeCounted(ZipLong.getBytes(r100.getCrc()));
        if (hasZip64Extra(r100) == true) goto L10;
        writeCounted(ZipLong.getBytes(r100.getCompressedSize()));
        writeCounted(ZipLong.getBytes(r100.getSize()));
        return;
    L10:
        writeCounted(ZipEightByteInteger.getBytes(r100.getCompressedSize()));
        writeCounted(ZipEightByteInteger.getBytes(r100.getSize()));
        return;
    }

    public void writeLocalFileHeader(ZipEntry r100) throws IOException {
        boolean r101 = this.zipEncoding.canEncode(r100.getName());
        ByteBuffer r102 = getName(r100);
        if (this.createUnicodeExtraFields == UnicodeExtraFieldPolicy.NEVER) goto L5;
        addUnicodeExtraFields(r100, r101, r102);
    L5:
        byte[] r103 = createLocalFileHeader(r100, r102, r101);
        long r104 = this.written;
        this.offsets.put(r100, Long.valueOf(r104));
        CurrentEntry.access$402(this.entry, r104 + 14);
        writeCounted(r103);
        CurrentEntry.access$102(this.entry, this.written);
    }

    public final void writeOut(byte[] r100) throws IOException {
        writeOut(r100, 0, r100.length);
    }

    public ZipOutputStream(OutputStream r100) {
        super(r100);
        this.finished = false;
        this.comment = "";
        this.level = -1;
        this.hasCompressionLevelChanged = false;
        this.method = 8;
        this.entries = new LinkedList();
        this.f449576crc = new CRC32();
        this.written = 0;
        this.cdOffset = 0;
        this.cdLength = 0;
        this.offsets = new HashMap();
        this.encoding = null;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);
        this.def = new Deflater(this.level, true);
        this.buf = new byte[512];
        this.useUTF8Flag = true;
        this.fallbackToUTF8 = false;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.hasUsedZip64 = false;
        this.zip64Mode = Zip64Mode.AsNeeded;
        this.calendarInstance = Calendar.getInstance();
        this.oneByte = new byte[1];
        this.raf = null;
    }

    public static byte[] toDosTime(long r100) {
        return ZipUtil.toDosTime(r100);
    }

    private GeneralPurposeBit getGeneralPurposeBits(int r100, boolean r101) {
        GeneralPurposeBit r102 = new GeneralPurposeBit();
        if (this.useUTF8Flag == true) goto L7;
        if (r101 == true) goto L7;
        boolean r103 = false;
    L8:
        r102.useUTF8ForNames(r103);
        if (isDeflatedToOutputStream(r100) == false) goto L11;
        r102.useDataDescriptor(true);
    L11:
        return r102;
    L7:
        r103 = true;
        goto L8
    }

    private boolean isZip64Required(ZipEntry r100, Zip64Mode r101) {
        if (r101 != Zip64Mode.Always) goto L5;
    L8:
        return true;
    L5:
        if (isTooLageForZip32(r100) == true) goto L8;
        return false;
    }

    private boolean shouldAddZip64Extra(ZipEntry r100, Zip64Mode r101) {
        if (r101 != Zip64Mode.Always) goto L5;
    L16:
        return true;
    L5:
        if (r100.getSize() >= BodyPartID.bodyIdMax) goto L16;
        if (r100.getCompressedSize() >= BodyPartID.bodyIdMax) goto L16;
        if (r100.getSize() == (-1)) goto L11;
    L15:
        return false;
    L11:
        if (this.raf == null) goto L15;
        if (r101 == Zip64Mode.Never) goto L15;
        goto L15
    }

    private int versionNeededToExtract(int r100, boolean r101) {
        if (r101 == false) goto L6;
        return 45;
    L6:
        if (isDeflatedToOutputStream(r100) == false) goto L8;
        return 20;
    L8:
        return 10;
    }

    private void addUnicodeExtraFields(ZipEntry r100, boolean r101, ByteBuffer r102) throws IOException {
        UnicodeExtraFieldPolicy r103 = this.createUnicodeExtraFields;
        UnicodeExtraFieldPolicy r104 = UnicodeExtraFieldPolicy.ALWAYS;
        if (r103 == r104) goto L5;
        if (r101 == false) goto L5;
    L6:
        String r105 = r100.getComment();
        if (r105 != null) goto L9;
        return;
    L9:
        if (r105.isEmpty() == false) goto L12;
        return;
    L12:
        if (this.createUnicodeExtraFields != r104) goto L14;
    L15:
        ByteBuffer r106 = getEntryEncoding(r100).encode(r105);
        r100.addExtraField(new UnicodeCommentExtraField(r105, r106.array(), r106.arrayOffset(), r106.limit() - r106.position()));
        return;
    L14:
        if (this.zipEncoding.canEncode(r105) == false) goto L15;
        return;
    L5:
        r100.addExtraField(new UnicodePathExtraField(r100.getName(), r102.array(), r102.arrayOffset(), r102.limit() - r102.position()));
        goto L6
    }

    private byte[] createLocalFileHeader(ZipEntry r110, ByteBuffer r111, boolean r112) {
        byte[] r100 = r110.getLocalFileDataExtra();
        int r101 = r111.limit() - r111.position();
        int r102 = r101 + 30;
        byte[] r103 = new byte[r100.length + r102];
        System.arraycopy(LFH_SIG, 0, r103, 0, 4);
        int r104 = r110.getMethod();
        ZipShort.putShort(versionNeededToExtract(r104, hasZip64Extra(r110)), r103, 4);
        if (r112 == false) goto L5;
    L7:
        boolean r113 = false;
    L8:
        getGeneralPurposeBits(r104, r113).encode(r103, 6);
        ZipShort.putShort(r104, r103, 8);
        ZipUtil.toDosTime(this.calendarInstance, r110.getTime(), r103, 10);
        if (r104 != 8) goto L11;
    L14:
        System.arraycopy(LZERO, 0, r103, 14, 4);
    L16:
        if (hasZip64Extra(CurrentEntry.access$000(this.entry)) == false) goto L18;
        ZipLong r114 = ZipLong.ZIP64_MAGIC;
        r114.putLong(r103, 18);
        r114.putLong(r103, 22);
    L24:
        ZipShort.putShort(r101, r103, 26);
        ZipShort.putShort(r100.length, r103, 28);
        System.arraycopy(r111.array(), r111.arrayOffset(), r103, 30, r101);
        System.arraycopy(r100, 0, r103, r102, r100.length);
        return r103;
    L18:
        if (r104 != 8) goto L20;
    L23:
        byte[] r115 = LZERO;
        System.arraycopy(r115, 0, r103, 18, 4);
        System.arraycopy(r115, 0, r103, 22, 4);
        goto L24
    L20:
        if (this.raf != null) goto L23;
        ZipLong.putLong(r110.getSize(), r103, 18);
        ZipLong.putLong(r110.getSize(), r103, 22);
        goto L24
    L11:
        if (this.raf != null) goto L14;
        ZipLong.putLong(r110.getCrc(), r103, 14);
        goto L16
    L5:
        if (this.fallbackToUTF8 == false) goto L7;
        r113 = true;
        goto L8
    }

    private boolean handleSizesAndCrc(long r100, long r101, Zip64Mode r110) throws ZipException {
        if (CurrentEntry.access$000(this.entry).getMethod() != 8) goto L6;
        CurrentEntry.access$000(this.entry).setSize(CurrentEntry.access$300(this.entry));
        CurrentEntry.access$000(this.entry).setCompressedSize(r100);
        CurrentEntry.access$000(this.entry).setCrc(r101);
        this.def.reset();
    L18:
        return checkIfNeedsZip64(r110);
    L6:
        if (this.raf == null) goto L8;
        CurrentEntry.access$000(this.entry).setSize(r100);
        CurrentEntry.access$000(this.entry).setCompressedSize(r100);
        CurrentEntry.access$000(this.entry).setCrc(r101);
        goto L18
    L8:
        if (CurrentEntry.access$000(this.entry).getCrc() != r101) goto L15;
        if (CurrentEntry.access$000(this.entry).getSize() == r100) goto L18;
        throw new ZipException("bad size for entry " + CurrentEntry.access$000(this.entry).getName() + ": " + CurrentEntry.access$000(this.entry).getSize() + " instead of " + r100);
    L15:
        throw new ZipException("bad CRC checksum for entry " + CurrentEntry.access$000(this.entry).getName() + ": " + Long.toHexString(CurrentEntry.access$000(this.entry).getCrc()) + " instead of " + Long.toHexString(r101));
    }

    private void handleZip64Extra(ZipEntry r100, long r101, boolean r110) {
        if (r110 == false) goto L19;
        Zip64ExtendedInformationExtraField r111 = getZip64Extra(r100);
        if (r100.getCompressedSize() < BodyPartID.bodyIdMax) goto L6;
    L11:
        r111.setCompressedSize(new ZipEightByteInteger(r100.getCompressedSize()));
        r111.setSize(new ZipEightByteInteger(r100.getSize()));
    L13:
        if (r101 < BodyPartID.bodyIdMax) goto L15;
    L16:
        r111.setRelativeHeaderOffset(new ZipEightByteInteger(r101));
    L17:
        r100.setExtra();
        return;
    L15:
        if (this.zip64Mode != Zip64Mode.Always) goto L17;
    L6:
        if (r100.getSize() >= BodyPartID.bodyIdMax) goto L11;
        if (this.zip64Mode == Zip64Mode.Always) goto L11;
        r111.setCompressedSize(null);
        r111.setSize(null);
        goto L13
    }

    private void writeCounted(byte[] r100, int r101, int r102) throws IOException {
        writeOut(r100, r101, r102);
        this.written += (long) r102;
    }

    private void writeDeflated(byte[] r100, int r101, int r102) throws IOException {
        if (r102 > 0) goto L4;
        return;
    L4:
        if (this.def.finished() == true) goto L17;
        CurrentEntry r103 = this.entry;
        CurrentEntry.access$302(r103, CurrentEntry.access$300(r103) + ((long) r102));
        if (r102 > 8192) goto L8;
        this.def.setInput(r100, r101, r102);
        deflateUntilInputIsNeeded();
        return;
    L8:
        int r104 = r102 / 8192;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L11;
        this.def.setInput(r100, (r105 * 8192) + r101, 8192);
        deflateUntilInputIsNeeded();
        r105 = r105 + 1;
        goto L9
    L11:
        int r106 = r104 * 8192;
        if (r106 >= r102) goto L19;
        this.def.setInput(r100, r101 + r106, r102 - r106);
        deflateUntilInputIsNeeded();
        return;
    L19:
        return;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        CurrentEntry r103 = this.entry;
        if (r103 == null) goto L11;
        ZipUtil.checkRequestedFeatures(CurrentEntry.access$000(r103));
        CurrentEntry.access$202(this.entry, true);
        if (CurrentEntry.access$000(this.entry).getMethod() != 8) goto L7;
        writeDeflated(r100, r101, r102);
    L8:
        this.f449576crc.update(r100, r101, r102);
        return;
    L7:
        writeCounted(r100, r101, r102);
        goto L8
    L11:
        throw new IllegalStateException("No current entry");
    }

    public final void writeOut(byte[] r100, int r101, int r102) throws IOException {
        RandomAccessFile r103 = this.raf;
        if (r103 == null) goto L5;
        r103.write(r100, r101, r102);
        return;
    L5:
        ((FilterOutputStream) this).out.write(r100, r101, r102);
    }

    private byte[] createCentralFileHeader(ZipEntry r110, ByteBuffer r111, long r112, boolean r210) throws IOException {
        byte[] r100 = r110.getCentralDirectoryExtra();
        String r101 = r110.getComment();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        ByteBuffer r102 = getEntryEncoding(r110).encode(r101);
        int r103 = r111.limit() - r111.position();
        int r104 = r102.limit() - r102.position();
        int r105 = r103 + 46;
        byte[] r106 = new byte[(r100.length + r105) + r104];
        System.arraycopy(CFH_SIG, 0, r106, 0, 4);
        int r107 = r110.getPlatform() << 8;
        if (this.hasUsedZip64 == true) goto L8;
        int r113 = 20;
    L9:
        ZipShort.putShort(r107 | r113, r106, 4);
        int r108 = r110.getMethod();
        boolean r114 = this.zipEncoding.canEncode(r110.getName());
        ZipShort.putShort(versionNeededToExtract(r108, r210), r106, 6);
        if (r114 == false) goto L12;
    L14:
        boolean r115 = false;
    L15:
        getGeneralPurposeBits(r108, r115).encode(r106, 8);
        ZipShort.putShort(r108, r106, 10);
        ZipUtil.toDosTime(this.calendarInstance, r110.getTime(), r106, 12);
        ZipLong.putLong(r110.getCrc(), r106, 16);
        if (r110.getCompressedSize() < BodyPartID.bodyIdMax) goto L18;
    L23:
        ZipLong r116 = ZipLong.ZIP64_MAGIC;
        r116.putLong(r106, 20);
        r116.putLong(r106, 24);
    L24:
        ZipShort.putShort(r103, r106, 28);
        ZipShort.putShort(r100.length, r106, 30);
        ZipShort.putShort(r104, r106, 32);
        System.arraycopy(ZERO, 0, r106, 34, 2);
        ZipShort.putShort(r110.getInternalAttributes(), r106, 36);
        ZipLong.putLong(r110.getExternalAttributes(), r106, 38);
        if (r112 < BodyPartID.bodyIdMax) goto L27;
    L30:
        ZipLong.putLong(BodyPartID.bodyIdMax, r106, 42);
    L31:
        System.arraycopy(r111.array(), r111.arrayOffset(), r106, 46, r103);
        System.arraycopy(r100, 0, r106, r105, r100.length);
        int r109 = r105 + r100.length;
        System.arraycopy(r102.array(), r102.arrayOffset(), r106, r109, r104);
        return r106;
    L27:
        if (this.zip64Mode == Zip64Mode.Always) goto L30;
        ZipLong.putLong(Math.min(r112, BodyPartID.bodyIdMax), r106, 42);
        goto L31
    L18:
        if (r110.getSize() >= BodyPartID.bodyIdMax) goto L23;
        if (this.zip64Mode == Zip64Mode.Always) goto L23;
        ZipLong.putLong(r110.getCompressedSize(), r106, 20);
        ZipLong.putLong(r110.getSize(), r106, 24);
        goto L24
    L12:
        if (this.fallbackToUTF8 == false) goto L14;
        r115 = true;
        goto L15
    L8:
        r113 = 45;
        goto L9
    }
}
