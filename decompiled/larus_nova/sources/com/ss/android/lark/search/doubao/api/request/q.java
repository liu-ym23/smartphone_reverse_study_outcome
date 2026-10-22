package com.ss.android.lark.search.doubao.api.request;

import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@SearchDsl
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f439986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f439987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f439988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o f439989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k f439990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f439991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t f439992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f439993h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i f439994i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g f439995j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m f439996k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public v f439997l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f439998m;

    public q() {
    }

    public static void a(q r100) {
        SearchRequestBuilder$userGroup$1 r101 = SearchRequestBuilder$userGroup$1.INSTANCE;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "block");
        v r102 = r100.f439997l;
        if (r102 != null) goto L5;
        r102 = new v();
    L5:
        r101.invoke(r102);
        r100.f439997l = r102;
    }

    public final q query(String r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f439986a = r100;
        return this;
    }
}
