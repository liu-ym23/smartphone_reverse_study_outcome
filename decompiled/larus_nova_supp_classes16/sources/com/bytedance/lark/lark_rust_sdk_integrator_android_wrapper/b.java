package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import com.bytedance.lark.view_flow_wrapper.MoltenService;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends MoltenService<com.bytedance.lark.lark_rust_sdk_integrator_android.b> implements c {
    public b(Function1<? super Continuation<? super com.bytedance.lark.lark_rust_sdk_integrator_android.b>, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceProvider");
        super(r2);
    }
}
