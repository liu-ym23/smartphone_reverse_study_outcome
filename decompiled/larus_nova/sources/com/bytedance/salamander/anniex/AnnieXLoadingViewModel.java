package com.bytedance.salamander.anniex;

import com.relax.relaxframework.RelaxFrameworkKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class AnnieXLoadingViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f267828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<? extends a0> f267829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<? super Function1<? super a0, ? extends a0>, Unit> f267830c;

    public AnnieXLoadingViewModel(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "containerId");
        this.f267828a = r101;
        Object[] r102 = RelaxFrameworkKt.i0(new a0(r100, null, false));
        Object r103 = r102[0];
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Function0<com.bytedance.salamander.anniex.AnnieXLoadingModel>{ com.relax.relaxframework.RelaxFrameworkKt.StateGetter<com.bytedance.salamander.anniex.AnnieXLoadingModel> }");
        Function0<? extends a0> r104 = (Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r103, 0);
        Object r105 = r102[1];
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"fn\")] kotlin.Function1<@[ParameterName(name = \"v\")] com.bytedance.salamander.anniex.AnnieXLoadingModel, com.bytedance.salamander.anniex.AnnieXLoadingModel>, kotlin.Unit>{ com.relax.relaxframework.RelaxFrameworkKt.StateSetter<com.bytedance.salamander.anniex.AnnieXLoadingModel> }");
        Function1<? super Function1<? super a0, ? extends a0>, Unit> r106 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r105, 1);
        this.f267829b = r104;
        this.f267830c = r106;
    }

    public final void a(final String r100, final boolean r101, boolean r102) {
        if (r102 == false) goto L4;
    L6:
        Function0<? extends a0> r103 = this.f267829b;
        Function1<? super Function1<? super a0, ? extends a0>, Unit> r104 = null;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("_stateGetter");
        r103 = null;
    L10:
        if (r103.invoke().f267933c != r101) goto L12;
        return;
    L12:
        Function1<? super Function1<? super a0, ? extends a0>, Unit> r105 = this.f267830c;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("_stateSetter");
    L16:
        r104.invoke(new AnnieXLoadingViewModel$changeState$1(r100, r101));
        return;
    L15:
        r104 = r105;
        goto L16
    L4:
        if (this.f267828a == true) goto L6;
    }
}
