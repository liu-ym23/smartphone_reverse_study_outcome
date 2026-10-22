package com.bytedance.kmp.ec.yata.common.biz.callback;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f251377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final YataRequestEventParams f251378b;

    public i(String r100, YataRequestEventParams r101) {
        Intrinsics.checkNotNullParameter(r100, "triggerType");
        Intrinsics.checkNotNullParameter(r101, "eventParams");
        this.f251377a = r100;
        this.f251378b = r101;
    }
}
