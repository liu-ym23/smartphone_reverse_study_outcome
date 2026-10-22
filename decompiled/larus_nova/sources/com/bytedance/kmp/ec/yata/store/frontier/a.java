package com.bytedance.kmp.ec.yata.store.frontier;

import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrontierMessageHandleType f251765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final YataStoreWrapper f251766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f251767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f251768d;

    public final FrontierMessageHandleType getType() {
        return this.f251765a;
    }

    public a(FrontierMessageHandleType r100, YataStoreWrapper r101, String r102, Long r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r102, "detail");
        this.f251765a = r100;
        this.f251766b = r101;
        this.f251767c = r102;
        this.f251768d = r103;
    }
}
