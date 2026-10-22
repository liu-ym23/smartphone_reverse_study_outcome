package com.bytedance.kmp.ec.yata.store.core;

import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final YataStoreWrapper f251752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f251753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f251754c;

    public m(YataStoreWrapper r100, j r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "storeWrapper");
        Intrinsics.checkNotNullParameter(r101, "nodeInterceptorCenter");
        this.f251752a = r100;
        this.f251753b = r101;
        this.f251754c = r102;
    }
}
