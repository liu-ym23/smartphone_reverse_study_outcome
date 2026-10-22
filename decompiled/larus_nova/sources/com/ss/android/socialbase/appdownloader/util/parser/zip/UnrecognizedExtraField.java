package com.ss.android.socialbase.appdownloader.util.parser.zip;

/* JADX INFO: loaded from: classes38.dex */
public class UnrecognizedExtraField implements CentralDirectoryParsingZipExtraField {
    private byte[] centralData;
    private ZipShort headerId;
    private byte[] localData;

    public UnrecognizedExtraField() {
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] r100 = this.centralData;
        if (r100 == null) goto L7;
        return ZipUtil.copy(r100);
    L7:
        return getLocalFileDataData();
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        byte[] r100 = this.centralData;
        if (r100 == null) goto L7;
        return new ZipShort(r100.length);
    L7:
        return getLocalFileDataLength();
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return ZipUtil.copy(this.localData);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(this.localData.length);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return this.headerId;
    }

    public void setCentralDirectoryData(byte[] r100) {
        this.centralData = ZipUtil.copy(r100);
    }

    public void setHeaderId(ZipShort r100) {
        this.headerId = r100;
    }

    public void setLocalFileDataData(byte[] r100) {
        this.localData = ZipUtil.copy(r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.CentralDirectoryParsingZipExtraField
    public void parseFromCentralDirectoryData(byte[] r100, int r101, int r102) {
        byte[] r103 = new byte[r102];
        System.arraycopy(r100, r101, r103, 0, r102);
        setCentralDirectoryData(r103);
        if (this.localData != null) goto L6;
        setLocalFileDataData(r103);
        return;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] r100, int r101, int r102) {
        byte[] r103 = new byte[r102];
        System.arraycopy(r100, r101, r103, 0, r102);
        setLocalFileDataData(r103);
    }
}
