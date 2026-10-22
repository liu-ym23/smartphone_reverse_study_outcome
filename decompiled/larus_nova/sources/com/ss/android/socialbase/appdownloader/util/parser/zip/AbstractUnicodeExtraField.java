package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes38.dex */
public abstract class AbstractUnicodeExtraField implements ZipExtraField {
    private byte[] data;
    private long nameCRC32;
    private byte[] unicodeName;

    private void assembleData() {
        byte[] r100 = this.unicodeName;
        if (r100 != null) goto L5;
        return;
    L5:
        byte[] r101 = new byte[r100.length + 5];
        this.data = r101;
        r101[0] = 1;
        System.arraycopy(ZipLong.getBytes(this.nameCRC32), 0, this.data, 1, 4);
        byte[] r102 = this.unicodeName;
        System.arraycopy(r102, 0, this.data, 5, r102.length);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        if (this.data != null) goto L5;
        assembleData();
    L5:
        byte[] r100 = this.data;
        if (r100 == null) goto L8;
        int r101 = r100.length;
        byte[] r102 = new byte[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    L8:
        return null;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        if (this.data != null) goto L6;
        assembleData();
    L6:
        return new ZipShort(this.data.length);
    }

    public byte[] getUnicodeName() {
        byte[] r100 = this.unicodeName;
        if (r100 == null) goto L5;
        int r101 = r100.length;
        byte[] r102 = new byte[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    L5:
        return null;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return getCentralDirectoryData();
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return getCentralDirectoryLength();
    }

    public AbstractUnicodeExtraField() {
    }

    public long getNameCRC32() {
        return this.nameCRC32;
    }

    public void setNameCRC32(long r100) {
        this.nameCRC32 = r100;
        this.data = null;
    }

    public void setUnicodeName(byte[] r100) {
        if (r100 == null) goto L5;
        byte[] r101 = new byte[r100.length];
        this.unicodeName = r101;
        System.arraycopy(r100, 0, r101, 0, r100.length);
    L6:
        this.data = null;
        return;
    L5:
        this.unicodeName = null;
        goto L6
    }

    public AbstractUnicodeExtraField(String r100, byte[] r101) {
        this(r100, r101, 0, r101.length);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] r100, int r101, int r102) throws ZipException {
        if (r102 < 5) goto L11;
        byte r103 = r100[r101];
        if (r103 != 1) goto L9;
        this.nameCRC32 = ZipLong.getValue(r100, r101 + 1);
        int r104 = r102 - 5;
        byte[] r105 = new byte[r104];
        this.unicodeName = r105;
        System.arraycopy(r100, r101 + 5, r105, 0, r104);
        this.data = null;
        return;
    L9:
        throw new ZipException("Unsupported version [" + r103 + "] for UniCode path extra data.");
    L11:
        throw new ZipException("UniCode path extra data must have at least 5 bytes.");
    }

    public AbstractUnicodeExtraField(String r100, byte[] r101, int r102, int r103) {
        CRC32 r104 = new CRC32();
        r104.update(r101, r102, r103);
        this.nameCRC32 = r104.getValue();
        this.unicodeName = r100.getBytes(StandardCharsets.UTF_8);
    }
}
