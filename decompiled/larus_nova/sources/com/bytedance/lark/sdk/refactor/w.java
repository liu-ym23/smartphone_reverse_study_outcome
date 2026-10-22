package com.bytedance.lark.sdk.refactor;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class w<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w<T, R> f254356a = null;

    static {
        f254356a = new w();
    }

    public w() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((com.bytedance.lark.rustclient.api.x) r100, "it");
        return new com.bytedance.lark.sdk.refactor.state.h(true, null, null);
    }
}
