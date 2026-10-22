package com.bytedance.article.common.monitor.stack;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final enum HttpUtil$CompressType extends Enum<HttpUtil$CompressType> {
    public static final HttpUtil$CompressType DEFLATER = null;
    public static final HttpUtil$CompressType GZIP = null;
    public static final HttpUtil$CompressType NONE = null;
    public static final /* synthetic */ HttpUtil$CompressType[] a = null;
    final int nativeInt;

    static {
        HttpUtil$CompressType r0 = new HttpUtil$CompressType("NONE", 0, 0);
        NONE = r0;
        HttpUtil$CompressType r1 = new HttpUtil$CompressType("GZIP", 1, 1);
        GZIP = r1;
        HttpUtil$CompressType r3 = new HttpUtil$CompressType("DEFLATER", 2, 2);
        DEFLATER = r3;
        a = new HttpUtil$CompressType[]{r0, r1, r3};
    }

    public static HttpUtil$CompressType[] values() {
        return (HttpUtil$CompressType[]) a.clone();
    }

    public static HttpUtil$CompressType valueOf(String r1) {
        return (HttpUtil$CompressType) r27.a.a(HttpUtil$CompressType.class, r1);
    }

    public HttpUtil$CompressType(String r1, int r2, int r3) {
        super(r1, r2);
        this.nativeInt = r3;
    }
}
