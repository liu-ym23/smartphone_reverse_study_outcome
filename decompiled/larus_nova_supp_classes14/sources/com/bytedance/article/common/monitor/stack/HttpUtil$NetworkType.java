package com.bytedance.article.common.monitor.stack;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final enum HttpUtil$NetworkType extends Enum<HttpUtil$NetworkType> {
    public static final HttpUtil$NetworkType MOBILE = null;
    public static final HttpUtil$NetworkType MOBILE_2G = null;
    public static final HttpUtil$NetworkType MOBILE_3G = null;
    public static final HttpUtil$NetworkType MOBILE_4G = null;
    public static final HttpUtil$NetworkType NONE = null;
    public static final HttpUtil$NetworkType WIFI = null;
    public static final /* synthetic */ HttpUtil$NetworkType[] a = null;
    final int nativeInt;

    static {
        HttpUtil$NetworkType r0 = new HttpUtil$NetworkType("NONE", 0, 0);
        NONE = r0;
        HttpUtil$NetworkType r1 = new HttpUtil$NetworkType("MOBILE", 1, 1);
        MOBILE = r1;
        HttpUtil$NetworkType r3 = new HttpUtil$NetworkType("MOBILE_2G", 2, 2);
        MOBILE_2G = r3;
        HttpUtil$NetworkType r5 = new HttpUtil$NetworkType("MOBILE_3G", 3, 3);
        MOBILE_3G = r5;
        HttpUtil$NetworkType r7 = new HttpUtil$NetworkType("WIFI", 4, 4);
        WIFI = r7;
        HttpUtil$NetworkType r9 = new HttpUtil$NetworkType("MOBILE_4G", 5, 5);
        MOBILE_4G = r9;
        a = new HttpUtil$NetworkType[]{r0, r1, r3, r5, r7, r9};
    }

    public static HttpUtil$NetworkType[] values() {
        return (HttpUtil$NetworkType[]) a.clone();
    }

    public int getValue() {
        return this.nativeInt;
    }

    public static HttpUtil$NetworkType valueOf(String r1) {
        return (HttpUtil$NetworkType) r27.a.a(HttpUtil$NetworkType.class, r1);
    }

    public HttpUtil$NetworkType(String r1, int r2, int r3) {
        super(r1, r2);
        this.nativeInt = r3;
    }
}
