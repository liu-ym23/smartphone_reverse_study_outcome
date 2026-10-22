package org.apache.commons.compress.archivers.tar;

import androidx.collection.SieveCacheKt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes42.dex */
public class TarArchiveInputStream extends ArchiveInputStream {
    private final int blockSize;
    private TarArchiveEntry currEntry;
    final String encoding;
    private long entryOffset;
    private long entrySize;
    private Map<String, String> globalPaxHeaders;
    private boolean hasHitEOF;

    /* JADX INFO: renamed from: is, reason: collision with root package name */
    private final InputStream f525008is;
    private final int recordSize;
    private final byte[] smallBuf;
    private final ZipEncoding zipEncoding;

    @Override // java.io.InputStream
    public void mark(int r100) {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        monitor-exit(this);
    }

    private boolean isDirectory() {
        TarArchiveEntry r100 = this.currEntry;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isDirectory() == false) goto L7;
        return true;
    }

    private void readOldGNUSparse() throws IOException {
        if (this.currEntry.isExtended() == false) goto L9;
    L4:
        byte[] r100 = getRecord();
        if (r100 == null) goto L6;
        if (new TarArchiveSparseEntry(r100).isExtended() == true) goto L4;
        return;
    L6:
        this.currEntry = null;
        return;
    }

    private void tryToConsumeSecondEOFRecord() throws IOException {
        boolean r100 = this.f525008is.markSupported();
        if (r100 == false) goto L15;
        this.f525008is.mark(this.recordSize);
    L15:
        if ((!isEOFRecord(readRecord())) == false) goto L17;
        if (r100 == false) goto L18;
        pushedBackBytes(this.recordSize);
        this.f525008is.reset();
        return;
    L18:
        return;
    L17:
        return;
    L11:
        th = move-exception;
        if (r100 == false) goto L14;
        pushedBackBytes(this.recordSize);
        this.f525008is.reset();
    L14:
        throw th;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f525008is.close();
    }

    public byte[] getLongNameData() throws IOException {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
    L3:
        int r101 = read(this.smallBuf);
        if (r101 < 0) goto L6;
        r100.write(this.smallBuf, 0, r101);
        goto L3
    L6:
        getNextEntry();
        if (this.currEntry != null) goto L10;
        return null;
    L10:
        byte[] r102 = r100.toByteArray();
        int r103 = r102.length;
    L11:
        if (r103 <= 0) goto L16;
        if (r102[r103 - 1] != 0) goto L16;
        r103 = r103 - 1;
    L16:
        if (r103 == r102.length) goto L22;
        byte[] r104 = new byte[r103];
        System.arraycopy(r102, 0, r104, 0, r103);
        return r104;
    L22:
        return r102;
    }

    public byte[] readRecord() throws IOException {
        byte[] r100 = new byte[this.recordSize];
        int r101 = IOUtils.readFully(this.f525008is, r100);
        count(r101);
        if (r101 == this.recordSize) goto L6;
        return null;
    L6:
        return r100;
    }

    private void consumeRemainderOfLastBlock() throws IOException {
        long r100 = getBytesRead();
        int r101 = this.blockSize;
        long r102 = r100 % ((long) r101);
        if (r102 <= 0) goto L6;
        count(IOUtils.skip(this.f525008is, ((long) r101) - r102));
        return;
    }

    private byte[] getRecord() throws IOException {
        byte[] r100 = readRecord();
        setAtEOF(isEOFRecord(r100));
        if (isAtEOF() == false) goto L7;
        if (r100 == null) goto L8;
        tryToConsumeSecondEOFRecord();
        consumeRemainderOfLastBlock();
        return null;
    L8:
        return r100;
    L7:
        return r100;
    }

    private void paxHeaders() throws IOException {
        Map<String, String> r100 = parsePaxHeaders(this);
        getNextEntry();
        applyPaxHeadersToCurrentEntry(r100);
    }

    private void readGlobalPaxHeaders() throws IOException {
        this.globalPaxHeaders = parsePaxHeaders(this);
        getNextEntry();
    }

    private void skipRecordPadding() throws IOException {
        if (isDirectory() == true) goto L10;
        long r100 = this.entrySize;
        if (r100 <= 0) goto L11;
        int r101 = this.recordSize;
        if ((r100 % ((long) r101)) == 0) goto L12;
        long r102 = (((r100 / ((long) r101)) + 1) * ((long) r101)) - r100;
        count(IOUtils.skip(this.f525008is, r102));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (isDirectory() == false) goto L6;
        return 0;
    L6:
        long r100 = this.entrySize;
        long r101 = this.entryOffset;
        if ((r100 - r101) <= SieveCacheKt.NodeLinkMask) goto L11;
        return Integer.MAX_VALUE;
    L11:
        return (int) (r100 - r101);
    }

    public ArchiveEntry getNextEntry() throws IOException {
        return getNextTarEntry();
    }

    public TarArchiveEntry getNextTarEntry() throws IOException {
        if (isAtEOF() == false) goto L6;
        return null;
    L6:
        if (this.currEntry == null) goto L8;
        IOUtils.skip(this, Long.MAX_VALUE);
        skipRecordPadding();
    L8:
        byte[] r100 = getRecord();
        if (r100 != null) goto L42;
        this.currEntry = null;
        return null;
    L42:
        TarArchiveEntry r101 = new TarArchiveEntry(r100, this.zipEncoding);     // Catch: IllegalArgumentException -> L39
        this.currEntry = r101;     // Catch: IllegalArgumentException -> L39
        this.entryOffset = 0;
        this.entrySize = r101.getSize();
        if (this.currEntry.isGNULongLinkEntry() == false) goto L20;
        byte[] r102 = getLongNameData();
        if (r102 != null) goto L18;
        return null;
    L18:
        this.currEntry.setLinkName(this.zipEncoding.decode(r102));
    L20:
        if (this.currEntry.isGNULongNameEntry() == false) goto L26;
        byte[] r103 = getLongNameData();
        if (r103 != null) goto L24;
        return null;
    L24:
        this.currEntry.setName(this.zipEncoding.decode(r103));
    L26:
        if (this.currEntry.isGlobalPaxHeader() == false) goto L29;
        readGlobalPaxHeaders();
    L29:
        if (this.currEntry.isPaxHeader() == false) goto L32;
        paxHeaders();
    L35:
        if (this.currEntry.isOldGNUSparse() == false) goto L37;
        readOldGNUSparse();
    L37:
        this.entrySize = this.currEntry.getSize();
        return this.currEntry;
    L32:
        if (this.globalPaxHeaders.isEmpty() == true) goto L35;
        applyPaxHeadersToCurrentEntry(this.globalPaxHeaders);
    L39:
        e = move-exception;
        throw new IOException("Error detected parsing the header", e);
    }

    public final boolean isAtEOF() {
        return this.hasHitEOF;
    }

    public TarArchiveInputStream(InputStream r100) {
        this(r100, 10240, 512);
    }

    private void applyPaxHeadersToCurrentEntry(Map<String, String> r100) {
        this.currEntry.updateEntryFromPaxHeaders(r100);
    }

    public boolean isEOFRecord(byte[] r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (ArchiveUtils.isArrayZero(r100, this.recordSize) == true) goto L7;
        return false;
    }

    public Map<String, String> parsePaxHeaders(InputStream r110) throws IOException {
        HashMap r100 = new HashMap(this.globalPaxHeaders);
    L3:
        int r101 = 0;
        int r102 = 0;
    L4:
        int r103 = r110.read();
        if (r103 == (-1)) goto L27;
        r101 = r101 + 1;
        if (r103 == 10) goto L27;
        if (r103 == 32) goto L11;
        r102 = (r102 * 10) + (r103 - 48);
        goto L4
    L11:
        ByteArrayOutputStream r104 = new ByteArrayOutputStream();
    L12:
        int r105 = r110.read();
        if (r105 == (-1)) goto L25;
        r101 = r101 + 1;
        if (r105 == 61) goto L16;
        r104.write((byte) r105);
        goto L12
    L16:
        String r106 = r104.toString("UTF-8");
        int r107 = r102 - r101;
        if (r107 != 1) goto L19;
        r100.remove(r106);
        goto L25
    L19:
        byte[] r108 = new byte[r107];
        int r109 = IOUtils.readFully(r110, r108);
        if (r109 != r107) goto L23;
        r100.put(r106, new String(r108, 0, r107 - 1, "UTF-8"));
        goto L25
    L23:
        throw new IOException("Failed to read Paxheader. Expected " + r107 + " bytes, read " + r109);
    L25:
        r103 = r105;
    L27:
        if (r103 != (-1)) goto L3;
        return r100;
    }

    public final void setAtEOF(boolean r100) {
        this.hasHitEOF = r100;
    }

    @Override // java.io.InputStream
    public long skip(long r100) throws IOException {
        if (r100 > 0) goto L5;
    L9:
        return 0;
    L5:
        if (isDirectory() == true) goto L9;
        long r101 = IOUtils.skip(this.f525008is, Math.min(r100, this.entrySize - this.entryOffset));
        count(r101);
        this.entryOffset += r101;
        return r101;
    }

    public TarArchiveInputStream(InputStream r100, int r101, int r102) {
        this(r100, r101, r102, null);
    }

    @Override // java.io.InputStream
    public int read(byte[] r100, int r101, int r102) throws IOException {
        if (isAtEOF() == false) goto L5;
    L21:
        return -1;
    L5:
        if (isDirectory() == true) goto L21;
        if (this.entryOffset >= this.entrySize) goto L21;
        if (this.currEntry == null) goto L20;
        int r103 = Math.min(r102, available());
        int r104 = this.f525008is.read(r100, r101, r103);
        if (r104 != (-1)) goto L17;
        if (r103 > 0) goto L16;
        setAtEOF(true);
    L18:
        return r104;
    L16:
        throw new IOException("Truncated TAR archive");
    L17:
        count(r104);
        this.entryOffset += (long) r104;
        goto L18
    L20:
        throw new IllegalStateException("No current tar entry");
    }

    public TarArchiveInputStream(InputStream r100, int r101, int r102, String r103) {
        this.smallBuf = new byte[256];
        this.globalPaxHeaders = new HashMap();
        this.f525008is = r100;
        this.hasHitEOF = false;
        this.encoding = r103;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(r103);
        this.recordSize = r102;
        this.blockSize = r101;
    }
}
