package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.url.v1.MGetUrlPreviewResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a1<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a1<T, R> f411567a = null;

    static {
        f411567a = new a1();
    }

    public a1() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.lark.rustclient.api.x r101 = (com.bytedance.lark.rustclient.api.x) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return (MGetUrlPreviewResponse) r101.f253935c;
    }
}
