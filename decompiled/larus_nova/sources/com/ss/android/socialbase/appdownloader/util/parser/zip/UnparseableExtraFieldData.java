package com.ss.android.socialbase.appdownloader.util.parser.zip;

/* JADX INFO: loaded from: classes38.dex */
public final class UnparseableExtraFieldData implements CentralDirectoryParsingZipExtraField {
    private static final ZipShort HEADER_ID = null;
    private byte[] centralDirectoryData;
    private byte[] localFileData;

    public UnparseableExtraFieldData() {
    }

    static {
        HEADER_ID = new ZipShort(44225);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] r100 = this.centralDirectoryData;
        if (r100 != null) goto L6;
        return getLocalFileDataData();
    L6:
        return ZipUtil.copy(r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        byte[] r100 = this.centralDirectoryData;
        if (r100 != null) goto L6;
        return getLocalFileDataLength();
    L6:
        return new ZipShort(r100.length);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return ZipUtil.copy(this.localFileData);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        byte[] r100 = this.localFileData;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return new ZipShort(r101);
    L5:
        r101 = r100.length;
        goto L7
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.CentralDirectoryParsingZipExtraField
    public void parseFromCentralDirectoryData(byte[] r100, int r101, int r102) {
        byte[] r103 = new byte[r102];
        this.centralDirectoryData = r103;
        System.arraycopy(r100, r101, r103, 0, r102);
        if (this.localFileData != null) goto L6;
        parseFromLocalFileData(r100, r101, r102);
        return;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] r100, int r101, int r102) {
        byte[] r103 = new byte[r102];
        this.localFileData = r103;
        System.arraycopy(r100, r101, r103, 0, r102);
    }
}
