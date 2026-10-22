package com.ss.bytertc.ktv.data;

/* JADX INFO: loaded from: classes40.dex */
public class DownloadResult {
    public String filePath;
    public DownloadFileType fileType;
    public String musicId;

    public String toString() {
        StringBuilder r100 = new StringBuilder("DownloadResult{musicId='");
        r100.append(this.musicId);
        r100.append("', fileType=");
        r100.append(this.fileType);
        if (DownloadFileType.MUSIC != this.fileType) goto L5;
        String r101 = "";
    L6:
        r100.append(r101);
        r100.append('}');
        return r100.toString();
    L5:
        r101 = ", filePath='" + this.filePath + '\'';
        goto L6
    }

    public DownloadResult(String r100, DownloadFileType r101, String r102) {
        this.musicId = r100;
        this.fileType = r101;
        this.filePath = r102;
    }
}
