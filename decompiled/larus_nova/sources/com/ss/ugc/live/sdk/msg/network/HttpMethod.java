package com.ss.ugc.live.sdk.msg.network;

/* JADX INFO: loaded from: classes36.dex */
public final enum HttpMethod extends Enum<HttpMethod> {
    public static final HttpMethod GET = null;
    public static final HttpMethod POST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HttpMethod[] f458281a = null;

    static {
        HttpMethod r100 = new HttpMethod("POST", 0);
        POST = r100;
        HttpMethod r101 = new HttpMethod("GET", 1);
        GET = r101;
        f458281a = new HttpMethod[]{r100, r101};
    }

    public static HttpMethod[] values() {
        return (HttpMethod[]) f458281a.clone();
    }

    public static HttpMethod valueOf(String r100) {
        return (HttpMethod) r27.a.a(HttpMethod.class, r100);
    }

    public HttpMethod(String r100, int r101) {
        super(r100, r101);
    }
}
