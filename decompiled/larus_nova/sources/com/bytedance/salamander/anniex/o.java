package com.bytedance.salamander.anniex;

import android.view.View;
import com.relax.relaxframework.RelaxFrameworkKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes20.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g3 f268260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<? extends m> f268261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<? super Function1<? super m, ? extends m>, Unit> f268262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.relax.relaxframework.f5 f268263d;

    public final g3 a() {
        g3 r100 = this.f268260a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_engine");
        return null;
    L6:
        return r100;
    }

    public final View b() {
        g3 r100 = this.f268260a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_engine");
        r100 = null;
    L6:
        return r100.getEngineView();
    }

    public o(String r100, g3 r101) {
        Intrinsics.checkNotNullParameter(r100, "containerId");
        Intrinsics.checkNotNullParameter(r101, "engine");
        this.f268260a = r101;
        Object[] r102 = RelaxFrameworkKt.i0(new m(r100, true));
        Object r103 = r102[0];
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Function0<com.bytedance.salamander.anniex.AnnieXEngineModel>{ com.relax.relaxframework.RelaxFrameworkKt.StateGetter<com.bytedance.salamander.anniex.AnnieXEngineModel> }");
        Function0<? extends m> r104 = (Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r103, 0);
        Object r105 = r102[1];
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"fn\")] kotlin.Function1<@[ParameterName(name = \"v\")] com.bytedance.salamander.anniex.AnnieXEngineModel, com.bytedance.salamander.anniex.AnnieXEngineModel>, kotlin.Unit>{ com.relax.relaxframework.RelaxFrameworkKt.StateSetter<com.bytedance.salamander.anniex.AnnieXEngineModel> }");
        Function1<? super Function1<? super m, ? extends m>, Unit> r106 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r105, 1);
        this.f268261b = r104;
        this.f268262c = r106;
    }
}
