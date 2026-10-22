package com.lark.wire;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e0 implements Function1<j0, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProtoAdapter<Object> f282756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f282757b;

    public e0(ProtoAdapter<Object> r100, Object r101) {
        this.f282756a = r100;
        this.f282757b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(j0 r100) {
        j0 r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "forwardWriter");
        this.f282756a.f(r101, this.f282757b);
        return Unit.INSTANCE;
    }
}
