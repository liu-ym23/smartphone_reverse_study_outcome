package com.bytedance.salamander.anniex;

import com.relax.relaxframework.RelaxFrameworkKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class AnnieXNavBarViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<? extends i0> f267833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<? super Function1<? super i0, ? extends i0>, Unit> f267834b;

    public AnnieXNavBarViewModel(i0 r100) {
        Intrinsics.checkNotNullParameter(r100, "navBarModel");
        Object[] r101 = RelaxFrameworkKt.i0(r100);
        Object r102 = r101[0];
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Function0<com.bytedance.salamander.anniex.AnnieXNavBarModel>{ com.relax.relaxframework.RelaxFrameworkKt.StateGetter<com.bytedance.salamander.anniex.AnnieXNavBarModel> }");
        Function0<? extends i0> r103 = (Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r102, 0);
        Object r104 = r101[1];
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"fn\")] kotlin.Function1<@[ParameterName(name = \"v\")] com.bytedance.salamander.anniex.AnnieXNavBarModel, com.bytedance.salamander.anniex.AnnieXNavBarModel>, kotlin.Unit>{ com.relax.relaxframework.RelaxFrameworkKt.StateSetter<com.bytedance.salamander.anniex.AnnieXNavBarModel> }");
        Function1<? super Function1<? super i0, ? extends i0>, Unit> r105 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r104, 1);
        this.f267833a = r103;
        this.f267834b = r105;
    }

    public final void a(final boolean r100) {
        Function0<? extends i0> r101 = this.f267833a;
        Function1<? super Function1<? super i0, ? extends i0>, Unit> r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_stateGetter");
        r101 = null;
    L6:
        if (r101.invoke().f268107c == r100) goto L13;
        Function1<? super Function1<? super i0, ? extends i0>, Unit> r103 = this.f267834b;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("_stateSetter");
    L11:
        r102.invoke(new AnnieXNavBarViewModel$setHidden$1(r100));
        return;
    L10:
        r102 = r103;
        goto L11
    }
}
