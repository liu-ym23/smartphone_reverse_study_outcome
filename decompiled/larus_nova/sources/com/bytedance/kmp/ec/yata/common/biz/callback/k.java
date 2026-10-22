package com.bytedance.kmp.ec.yata.common.biz.callback;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v96.j f251382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f251383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f251384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f251385d;

    public k(v96.j r100, String r101, ea6.c r102, Map r103, a r104) {
        Intrinsics.checkNotNullParameter(r100, "api");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "yataParam");
        Intrinsics.checkNotNullParameter(r103, "requestBody");
        Intrinsics.checkNotNullParameter(r104, "fetchCallbackModel");
        this.f251382a = r100;
        this.f251383b = r101;
        this.f251384c = r103;
        this.f251385d = r104;
    }
}
