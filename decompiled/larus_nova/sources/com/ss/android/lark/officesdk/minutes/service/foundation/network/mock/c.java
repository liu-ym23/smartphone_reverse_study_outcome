package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gvb.a f433941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f433942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmHttpMethod f433943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f433944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f433945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f433946f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f433941a, r101.f433941a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f433942b, r101.f433942b) == true) goto L15;
        return false;
    L15:
        if (this.f433943c == r101.f433943c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f433944d, r101.f433944d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f433945e, r101.f433945e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f433946f, r101.f433946f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f433941a.hashCode() * 31) + this.f433942b.hashCode()) * 31) + this.f433943c.hashCode()) * 31) + this.f433944d.hashCode()) * 31) + this.f433945e.hashCode()) * 31;
        String r101 = this.f433946f;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MmMockHttpRequestContext(request=" + this.f433941a + ", path=" + this.f433942b + ", method=" + this.f433943c + ", query=" + this.f433944d + ", body=" + this.f433945e + ", rawBody=" + this.f433946f + ')';
    }

    public c(gvb.a r100, String r101, MmHttpMethod r102, Map<String, String> r103, Map<String, String> r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r102, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r103, "query");
        Intrinsics.checkNotNullParameter(r104, ContainerPosition.BODY);
        this.f433941a = r100;
        this.f433942b = r101;
        this.f433943c = r102;
        this.f433944d = r103;
        this.f433945e = r104;
        this.f433946f = r105;
    }
}
