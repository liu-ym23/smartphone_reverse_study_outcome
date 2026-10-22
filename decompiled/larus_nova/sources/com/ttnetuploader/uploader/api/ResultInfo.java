package com.ttnetuploader.uploader.api;

/* JADX INFO: loaded from: classes41.dex */
public class ResultInfo {
    public final String clientIpv4;
    public final int code;
    public final String filePath;
    private String mUploadLog;
    public final long remainDisk;
    private String stringBody;
    public final long totalDisk;
    public final long totalLen;
    public final long uploadId;
    public final long uploadedLen;
    public final String url;

    public String getUploadLog() {
        monitor-enter(this);
        String r100 = this.mUploadLog;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public String getStringBody() {
        return this.stringBody;
    }

    public void addLog(String r100) {
        monitor-enter(this);
        this.mUploadLog += "," + r100;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setStringBody(String r100) {
        this.stringBody = r100;
    }

    public ResultInfo(long r100, long r101, long r102, int r110, String r111, String r112, String r113, long r114, long r115, String r116) {
        String r103 = "";
        this.mUploadLog = "";
        this.stringBody = "";
        this.uploadId = r100;
        this.clientIpv4 = r116;
        this.uploadedLen = r101;
        this.totalLen = r102;
        this.code = r110;
        if (r111 != null) goto L5;
        String r104 = "";
    L6:
        this.url = r104;
        if (r112 != null) goto L9;
        String r105 = "";
    L10:
        this.filePath = r105;
        if (r113 == null) goto L14;
        r103 = r113;
    L14:
        this.mUploadLog = r103;
        this.remainDisk = r114;
        this.totalDisk = r115;
        return;
    L9:
        r105 = r112;
        goto L10
    L5:
        r104 = r111;
        goto L6
    }
}
