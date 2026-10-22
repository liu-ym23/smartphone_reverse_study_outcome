package com.ss.android.lark.conditional.access.display;

import com.bytedance.lark.pb.security.v1.CustomDisplayModelResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T, R> f418054a = null;

    static {
        f418054a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        CustomDisplayModelResponse r101 = (CustomDisplayModelResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.config;
    }
}
