package com.larus.network.http;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/network/http/HttpRequestMethod;", "", com.alipay.sdk.m.p.e.f25671s, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMethod", "()Ljava/lang/String;", "GET", "POST", "HEAD", "PUT", "DELETE", "OPTIONS", "PATCH", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HttpRequestMethod extends Enum<HttpRequestMethod> {
    public static final HttpRequestMethod DELETE = null;
    public static final HttpRequestMethod GET = null;
    public static final HttpRequestMethod HEAD = null;
    public static final HttpRequestMethod OPTIONS = null;
    public static final HttpRequestMethod PATCH = null;
    public static final HttpRequestMethod POST = null;
    public static final HttpRequestMethod PUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HttpRequestMethod[] f360129a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f360130b = null;
    private final String method;

    public static EnumEntries<HttpRequestMethod> getEntries() {
        return f360130b;
    }

    static {
        HttpRequestMethod r100 = new HttpRequestMethod("GET", 0, "GET");
        GET = r100;
        HttpRequestMethod r101 = new HttpRequestMethod("POST", 1, "POST");
        POST = r101;
        HttpRequestMethod r102 = new HttpRequestMethod("HEAD", 2, "HEAD");
        HEAD = r102;
        HttpRequestMethod r103 = new HttpRequestMethod("PUT", 3, "PUT");
        PUT = r103;
        HttpRequestMethod r104 = new HttpRequestMethod("DELETE", 4, "DELETE");
        DELETE = r104;
        HttpRequestMethod r105 = new HttpRequestMethod("OPTIONS", 5, "OPTIONS");
        OPTIONS = r105;
        HttpRequestMethod r110 = new HttpRequestMethod("PATCH", 6, "PATCH");
        PATCH = r110;
        HttpRequestMethod[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f360129a = r111;
        f360130b = EnumEntriesKt.enumEntries(r111);
    }

    public static HttpRequestMethod[] values() {
        return (HttpRequestMethod[]) f360129a.clone();
    }

    public final String getMethod() {
        return this.method;
    }

    public static HttpRequestMethod valueOf(String r100) {
        return (HttpRequestMethod) r27.a.a(HttpRequestMethod.class, r100);
    }

    public HttpRequestMethod(String r100, int r101, String r102) {
        super(r100, r101);
        this.method = r102;
    }
}
