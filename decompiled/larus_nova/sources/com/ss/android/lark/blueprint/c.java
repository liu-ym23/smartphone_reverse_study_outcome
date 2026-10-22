package com.ss.android.lark.blueprint;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c extends wza.a<Object, Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<g, i<Object, Object>> f410636c;

    @Override // wza.a
    public final i<Object, Object> b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f410636c.invoke(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(j r100, Function1<? super g, ? extends i<Object, Object>> r101) {
        this.f410636c = r101;
        super(r100);
    }
}
