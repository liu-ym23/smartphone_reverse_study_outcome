package com.ss.android.lark.im.sdk.service;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class v<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f426114a;

    public v(z r100) {
        this.f426114a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((com.bytedance.lark.rustclient.api.x) r100, "it");
        this.f426114a.f426119a.getId();
        return new y4b.a();
    }
}
