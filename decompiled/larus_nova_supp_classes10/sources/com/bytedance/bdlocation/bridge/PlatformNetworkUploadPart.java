package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class PlatformNetworkUploadPart {
    public final String contentType;
    public final String fileName;
    public final String[] headerNames;
    public final String[] headerValues;
    public final String name;
    public final PlatformNetworkUploadSource source;

    public PlatformNetworkUploadPart(String r1, String r2, String r3, String[] r4, String[] r5, PlatformNetworkUploadSource r6) {
        this.name = r1;
        this.fileName = r2;
        this.contentType = r3;
        if (r4 != null) goto L5;
        r4 = new String[0];
    L5:
        this.headerNames = r4;
        if (r5 != null) goto L8;
        r5 = new String[0];
    L8:
        this.headerValues = r5;
        this.source = r6;
    }
}
