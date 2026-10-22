package com.ss.android.lark.im.sdk.service;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<T, R> f426100a = null;

    static {
        f426100a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.lark.rustclient.api.s r101 = (com.bytedance.lark.rustclient.api.s) r100;
        Intrinsics.checkNotNullParameter(r101, "r");
        return com.bytedance.lark.rustclient.api.t.e(r101, ImSdkChatServiceImplV2$isSelfInChat$1$1.INSTANCE);
    }
}
