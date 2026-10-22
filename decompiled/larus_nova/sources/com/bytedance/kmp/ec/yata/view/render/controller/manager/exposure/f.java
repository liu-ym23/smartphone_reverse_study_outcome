package com.bytedance.kmp.ec.yata.view.render.controller.manager.exposure;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.view.c f251882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<String, Unit> f251883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Map<String, Boolean>> f251884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, List<Map<String, Boolean>>> f251885d;

    /* JADX WARN: Multi-variable type inference failed */
    public f(com.bytedance.kmp.ec.yata.view.c r100, Function1<? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "viewWrapper");
        Intrinsics.checkNotNullParameter(r101, "exposureListener");
        this.f251882a = r100;
        this.f251883b = r101;
        this.f251884c = new LinkedHashMap();
        this.f251885d = new LinkedHashMap();
    }
}
