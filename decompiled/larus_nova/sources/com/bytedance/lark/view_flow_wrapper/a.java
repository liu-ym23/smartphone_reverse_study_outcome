package com.bytedance.lark.view_flow_wrapper;

import com.bytedance.lark.view_flow_wrapper.h;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public abstract class a<S extends h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<S> f254411a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends S> r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceProvider");
        this.f254411a = r100;
    }
}
