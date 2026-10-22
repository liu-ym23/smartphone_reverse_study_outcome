package com.bytedance.kmp.ec.yata.common.biz.callback;

import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import com.bytedance.kmp.ec.yata.common.utils.YataCopyOnWriteSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final YataStoreWrapper f251373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final YataCopyOnWriteSet<e> f251374b;

    public g(YataStoreWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, "storeWrapper");
        this.f251373a = r100;
        this.f251374b = new YataCopyOnWriteSet();
    }
}
