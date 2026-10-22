package com.relax.relaxframework;

import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class l0 extends e5 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<? extends ArrayList<p6>> f405173g;

    public l0() {
        super(CSSModifierProperty.None, RxModifierType.Computed);
    }

    @Override // com.relax.relaxframework.e5
    public final ArrayList<p6> e() {
        Function0<? extends ArrayList<p6>> r100 = this.f405173g;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        return r100.invoke();
    L6:
        return null;
    }
}
