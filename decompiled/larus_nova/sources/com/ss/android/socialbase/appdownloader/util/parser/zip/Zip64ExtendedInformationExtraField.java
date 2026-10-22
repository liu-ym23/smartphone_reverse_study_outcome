package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes38.dex */
public class Zip64ExtendedInformationExtraField implements CentralDirectoryParsingZipExtraField {
    private static final byte[] EMPTY = null;
    static final ZipShort HEADER_ID = null;
    private static final String LFH_MUST_HAVE_BOTH_SIZES_MSG = "Zip64 extended information must contain both size values in the local file header.";
    private ZipEightByteInteger compressedSize;
    private ZipLong diskStart;
    private byte[] rawCentralDirectoryData;
    private ZipEightByteInteger relativeHeaderOffset;
    private ZipEightByteInteger size;

    public Zip64ExtendedInformationExtraField() {
    }

    static {
        HEADER_ID = new ZipShort(1);
        EMPTY = new byte[0];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        int r100 = 8;
        int r101 = 0;
        if (this.size == null) goto L5;
        int r102 = 8;
    L7:
        if (this.compressedSize == null) goto L9;
        int r103 = 8;
    L10:
        int r104 = r102 + r103;
        if (this.relativeHeaderOffset != null) goto L14;
        r100 = 0;
    L14:
        int r105 = r104 + r100;
        if (this.diskStart == null) goto L18;
        r101 = 4;
    L18:
        return new ZipShort(r105 + r101);
    L9:
        r103 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L7
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        ZipEightByteInteger r100 = this.size;
        if (r100 == null) goto L5;
    L9:
        if (r100 == null) goto L15;
        if (this.compressedSize == null) goto L15;
        byte[] r101 = new byte[16];
        addSizes(r101);
        return r101;
    L15:
        throw new IllegalArgumentException(LFH_MUST_HAVE_BOTH_SIZES_MSG);
    L5:
        if (this.compressedSize != null) goto L9;
        return EMPTY;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        if (this.size == null) goto L5;
        int r100 = 16;
    L7:
        return new ZipShort(r100);
    L5:
        r100 = 0;
        goto L7
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] r100 = new byte[getCentralDirectoryLength().getValue()];
        int r101 = addSizes(r100);
        ZipEightByteInteger r102 = this.relativeHeaderOffset;
        if (r102 == null) goto L5;
        System.arraycopy(r102.getBytes(), 0, r100, r101, 8);
        r101 = r101 + 8;
    L5:
        ZipLong r103 = this.diskStart;
        if (r103 == null) goto L8;
        System.arraycopy(r103.getBytes(), 0, r100, r101, 4);
    L8:
        return r100;
    }

    public ZipEightByteInteger getCompressedSize() {
        return this.compressedSize;
    }

    public ZipLong getDiskStartNumber() {
        return this.diskStart;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public ZipEightByteInteger getRelativeHeaderOffset() {
        return this.relativeHeaderOffset;
    }

    public ZipEightByteInteger getSize() {
        return this.size;
    }

    private int addSizes(byte[] r100) {
        ZipEightByteInteger r101 = this.size;
        if (r101 == null) goto L5;
        System.arraycopy(r101.getBytes(), 0, r100, 0, 8);
        int r102 = 8;
    L6:
        ZipEightByteInteger r103 = this.compressedSize;
        if (r103 == null) goto L10;
        System.arraycopy(r103.getBytes(), 0, r100, r102, 8);
        return r102 + 8;
    L10:
        return r102;
    L5:
        r102 = 0;
        goto L6
    }

    public void setCompressedSize(ZipEightByteInteger r100) {
        this.compressedSize = r100;
    }

    public void setDiskStartNumber(ZipLong r100) {
        this.diskStart = r100;
    }

    public void setRelativeHeaderOffset(ZipEightByteInteger r100) {
        this.relativeHeaderOffset = r100;
    }

    public void setSize(ZipEightByteInteger r100) {
        this.size = r100;
    }

    public Zip64ExtendedInformationExtraField(ZipEightByteInteger r100, ZipEightByteInteger r101) {
        this(r100, r101, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.CentralDirectoryParsingZipExtraField
    public void parseFromCentralDirectoryData(byte[] r100, int r101, int r102) throws ZipException {
        byte[] r103 = new byte[r102];
        this.rawCentralDirectoryData = r103;
        System.arraycopy(r100, r101, r103, 0, r102);
        if (r102 < 28) goto L6;
        parseFromLocalFileData(r100, r101, r102);
        return;
    L6:
        if (r102 != 24) goto L9;
        this.size = new ZipEightByteInteger(r100, r101);
        int r104 = r101 + 8;
        this.compressedSize = new ZipEightByteInteger(r100, r104);
        this.relativeHeaderOffset = new ZipEightByteInteger(r100, r104 + 8);
        return;
    L9:
        if ((r102 % 8) != 4) goto L14;
        this.diskStart = new ZipLong(r100, (r101 + r102) - 4);
        return;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] r100, int r101, int r102) throws ZipException {
        if (r102 != 0) goto L5;
        return;
    L5:
        if (r102 < 16) goto L14;
        this.size = new ZipEightByteInteger(r100, r101);
        int r103 = r101 + 8;
        this.compressedSize = new ZipEightByteInteger(r100, r103);
        int r104 = r103 + 8;
        int r105 = r102 - 16;
        if (r105 < 8) goto L10;
        this.relativeHeaderOffset = new ZipEightByteInteger(r100, r104);
        r104 = r104 + 8;
        r105 = r105 - 8;
    L10:
        if (r105 < 4) goto L15;
        this.diskStart = new ZipLong(r100, r104);
        return;
    L15:
        return;
    L14:
        throw new ZipException(LFH_MUST_HAVE_BOTH_SIZES_MSG);
    }

    public Zip64ExtendedInformationExtraField(ZipEightByteInteger r100, ZipEightByteInteger r101, ZipEightByteInteger r102, ZipLong r103) {
        this.size = r100;
        this.compressedSize = r101;
        this.relativeHeaderOffset = r102;
        this.diskStart = r103;
    }

    public void reparseCentralDirectoryData(boolean r100, boolean r101, boolean r102, boolean r103) throws ZipException {
        byte[] r104 = this.rawCentralDirectoryData;
        if (r104 == null) goto L31;
        int r105 = 0;
        if (r100 == false) goto L7;
        int r106 = 8;
    L8:
        if (r101 == false) goto L10;
        int r107 = 8;
    L11:
        int r108 = r106 + r107;
        if (r102 == false) goto L14;
        int r109 = 8;
    L15:
        int r110 = r108 + r109;
        if (r103 == false) goto L18;
        int r111 = 4;
    L19:
        int r112 = r110 + r111;
        if (r104.length < r112) goto L30;
        if (r100 == false) goto L23;
        this.size = new ZipEightByteInteger(this.rawCentralDirectoryData, 0);
        r105 = 8;
    L23:
        if (r101 == false) goto L25;
        this.compressedSize = new ZipEightByteInteger(this.rawCentralDirectoryData, r105);
        r105 = r105 + 8;
    L25:
        if (r102 == false) goto L27;
        this.relativeHeaderOffset = new ZipEightByteInteger(this.rawCentralDirectoryData, r105);
        r105 = r105 + 8;
    L27:
        if (r103 == false) goto L32;
        this.diskStart = new ZipLong(this.rawCentralDirectoryData, r105);
        return;
    L32:
        return;
    L30:
        throw new ZipException("central directory zip64 extended information extra field's length doesn't match central directory data.  Expected length " + r112 + " but is " + this.rawCentralDirectoryData.length);
    L18:
        r111 = 0;
        goto L19
    L14:
        r109 = 0;
        goto L15
    L10:
        r107 = 0;
        goto L11
    L7:
        r106 = 0;
        goto L8
    }
}
