package com.ss.android.lark.chat.api.service.impl;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f1<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e1 f411590a;

    public f1(e1 r100) {
        this.f411590a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.lark.rustclient.api.s r101 = (com.bytedance.lark.rustclient.api.s) r100;
        Intrinsics.checkNotNullParameter(r101, "r");
        final e1 r102 = this.f411590a;
        return com.bytedance.lark.rustclient.api.t.e(r101, new PrivateDescriptionRepository$pullUserPrivateDescriptions$2$1(r102));
    }
}
