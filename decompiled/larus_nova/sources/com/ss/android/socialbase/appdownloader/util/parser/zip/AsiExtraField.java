package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes38.dex */
public class AsiExtraField implements ZipExtraField, UnixStat, Cloneable {
    private static final ZipShort HEADER_ID = null;
    private static final int WORD = 4;

    /* JADX INFO: renamed from: crc, reason: collision with root package name */
    private CRC32 f449573crc;
    private boolean dirFlag;
    private int gid;
    private String link;
    private int mode;
    private int uid;

    static {
        HEADER_ID = new ZipShort(30062);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(getLinkedFile().getBytes().length + 14);
    }

    public boolean isDirectory() {
        if (this.dirFlag == true) goto L5;
    L7:
        return false;
    L5:
        if (isLink() == true) goto L7;
        return true;
    }

    public AsiExtraField() {
        this.mode = 0;
        this.uid = 0;
        this.gid = 0;
        this.link = "";
        this.dirFlag = false;
        this.f449573crc = new CRC32();
    }

    public Object clone() {
        AsiExtraField r100 = (AsiExtraField) super.clone();     // Catch: CloneNotSupportedException -> L4
        r100.f449573crc = new CRC32();     // Catch: CloneNotSupportedException -> L4
        return r100;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return getLocalFileDataData();
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return getLocalFileDataLength();
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        int r100 = getLocalFileDataLength().getValue() - 4;
        byte[] r101 = new byte[r100];
        System.arraycopy(ZipShort.getBytes(getMode()), 0, r101, 0, 2);
        byte[] r102 = getLinkedFile().getBytes();
        System.arraycopy(ZipLong.getBytes(r102.length), 0, r101, 2, 4);
        System.arraycopy(ZipShort.getBytes(getUserId()), 0, r101, 6, 2);
        System.arraycopy(ZipShort.getBytes(getGroupId()), 0, r101, 8, 2);
        System.arraycopy(r102, 0, r101, 10, r102.length);
        this.f449573crc.reset();
        this.f449573crc.update(r101);
        byte[] r103 = new byte[r100 + 4];
        System.arraycopy(ZipLong.getBytes(this.f449573crc.getValue()), 0, r103, 0, 4);
        System.arraycopy(r101, 0, r103, 4, r100);
        return r103;
    }

    public boolean isLink() {
        return !getLinkedFile().isEmpty();
    }

    public int getGroupId() {
        return this.gid;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public String getLinkedFile() {
        return this.link;
    }

    public int getMode() {
        return this.mode;
    }

    public int getUserId() {
        return this.uid;
    }

    public int getMode(int r100) {
        if (isLink() == false) goto L6;
        int r101 = UnixStat.LINK_FLAG;
    L10:
        return (r100 & UnixStat.PERM_MASK) | r101;
    L6:
        if (isDirectory() == false) goto L8;
        r101 = 16384;
        goto L10
    L8:
        r101 = 32768;
        goto L10
    }

    public void setDirectory(boolean r100) {
        this.dirFlag = r100;
        this.mode = getMode(this.mode);
    }

    public void setGroupId(int r100) {
        this.gid = r100;
    }

    public void setLinkedFile(String r100) {
        this.link = r100;
        this.mode = getMode(this.mode);
    }

    public void setMode(int r100) {
        this.mode = getMode(r100);
    }

    public void setUserId(int r100) {
        this.uid = r100;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] r100, int r101, int r102) throws ZipException {
        long r103 = ZipLong.getValue(r100, r101);
        int r104 = r102 - 4;
        byte[] r105 = new byte[r104];
        boolean r106 = false;
        System.arraycopy(r100, r101 + 4, r105, 0, r104);
        this.f449573crc.reset();
        this.f449573crc.update(r105);
        long r107 = this.f449573crc.getValue();
        if (r103 != r107) goto L20;
        int r108 = ZipShort.getValue(r105, 0);
        int r109 = (int) ZipLong.getValue(r105, 2);
        if (r109 < 0) goto L18;
        if (r109 > (r104 - 10)) goto L18;
        this.uid = ZipShort.getValue(r105, 6);
        this.gid = ZipShort.getValue(r105, 8);
        if (r109 != 0) goto L11;
        this.link = "";
    L13:
        if ((r108 & 16384) == 0) goto L15;
        r106 = true;
    L15:
        setDirectory(r106);
        setMode(r108);
        return;
    L11:
        byte[] r110 = new byte[r109];
        System.arraycopy(r105, 10, r110, 0, r109);
        this.link = new String(r110);
    L18:
        throw new ZipException("Bad symbolic link name length " + r109 + " in ASI extra field");
    L20:
        throw new ZipException("bad CRC checksum " + Long.toHexString(r103) + " instead of " + Long.toHexString(r107));
    }
}
