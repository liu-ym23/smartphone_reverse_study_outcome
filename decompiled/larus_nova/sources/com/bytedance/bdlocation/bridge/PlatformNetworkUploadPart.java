package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: classes10.dex */
public final class PlatformNetworkUploadPart {
    public final String contentType;
    public final String fileName;
    public final String[] headerNames;
    public final String[] headerValues;
    public final String name;
    public final PlatformNetworkUploadSource source;

    public PlatformNetworkUploadPart(String r100, String r101, String r102, String[] r103, String[] r104, PlatformNetworkUploadSource r105) {
        this.name = r100;
        this.fileName = r101;
        this.contentType = r102;
        if (r103 != null) goto L5;
        r103 = new String[0];
    L5:
        this.headerNames = r103;
        if (r104 != null) goto L8;
        r104 = new String[0];
    L8:
        this.headerValues = r104;
        this.source = r105;
    }
}
