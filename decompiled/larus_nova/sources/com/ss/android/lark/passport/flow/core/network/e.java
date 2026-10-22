package com.ss.android.lark.passport.flow.core.network;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f437755i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f437756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PassportHttpMethod f437757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f437758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f437759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f437760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f437761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f437762g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f437763h;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("PassportHttpRequest(method=");
        r100.append(this.f437757b);
        r100.append(", requestId=");
        r100.append(this.f437758c);
        r100.append(", headerNames=");
        r100.append(((LinkedHashMap) this.f437762g).keySet());
        r100.append(", bodyBytes=");
        byte[] r101 = this.f437763h;
        if (r101 == null) goto L5;
        int r102 = r101.length;
    L6:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = 0;
        goto L6
    }

    public e(String r100, PassportHttpMethod r101, Map r102, byte[] r103, String r104, int r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r102, "headers");
        Intrinsics.checkNotNullParameter(r104, "requestId");
        this.f437756a = r100;
        this.f437757b = r101;
        this.f437758c = r104;
        this.f437759d = r105;
        this.f437760e = false;
        this.f437761f = r106;
        this.f437762g = new LinkedHashMap(r102);
        if (r103 == null) goto L5;
        byte[] r107 = Arrays.copyOf(r103, r103.length);
    L6:
        this.f437763h = r107;
        return;
    L5:
        r107 = null;
        goto L6
    }
}
