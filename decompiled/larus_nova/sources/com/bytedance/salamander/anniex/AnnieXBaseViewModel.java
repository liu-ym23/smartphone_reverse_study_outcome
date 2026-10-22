package com.bytedance.salamander.anniex;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.relax.relaxframework.RelaxFrameworkKt;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes20.dex */
public class AnnieXBaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<? extends e> f267807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<? super Function1<? super e, ? extends e>, Unit> f267808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f0 f267809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g2 f267810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AnnieXSLEngineType f267811e;

    public final o a() {
        AnnieXSLEngineType r100 = this.f267811e;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("engineType");
        r100 = null;
    L6:
        if (r100 != AnnieXSLEngineType.lynx) goto L9;
        f0 r101 = this.f267809c;
        Intrinsics.checkNotNull(r101);
        return r101;
    L9:
        g2 r102 = this.f267810d;
        Intrinsics.checkNotNull(r102);
        return r102;
    }

    public AnnieXBaseViewModel(f r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_PROPS);
        Object[] r100 = RelaxFrameworkKt.i0(new e());
        Object r101 = r100[0];
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Function0<com.bytedance.salamander.anniex.AnnieXBaseModel>{ com.relax.relaxframework.RelaxFrameworkKt.StateGetter<com.bytedance.salamander.anniex.AnnieXBaseModel> }");
        Function0<? extends e> r102 = (Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r101, 0);
        Object r103 = r100[1];
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"fn\")] kotlin.Function1<@[ParameterName(name = \"v\")] com.bytedance.salamander.anniex.AnnieXBaseModel, com.bytedance.salamander.anniex.AnnieXBaseModel>, kotlin.Unit>{ com.relax.relaxframework.RelaxFrameworkKt.StateSetter<com.bytedance.salamander.anniex.AnnieXBaseModel> }");
        Function1<? super Function1<? super e, ? extends e>, Unit> r104 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r103, 1);
        this.f267807a = r102;
        this.f267808b = r104;
        String r105 = r110.f268053c;
        Map<String, Object> r106 = r110.f268056f;
        AnnieXSLEngineType r107 = null;
        if (r106 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("globalProps");
        r106 = null;
    L6:
        t0 r108 = r110.a();
        String r109 = r110.f268054d;
        String r111 = r110.f268055e;
        g0 r112 = r110.f268058h;
        if (r112 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("lynxProps");
        r112 = null;
    L10:
        AnnieXSLEngineType r113 = b2.f267974c.a(r105);
        this.f267811e = r113;
        if (r113 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("engineType");
    L15:
        if (r107 != AnnieXSLEngineType.lynx) goto L17;
        e0 r114 = new e0(r105, r106, r108);
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r114.f268246b = r111;
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        Intrinsics.checkNotNullParameter(r112.f268076a, "<set-?>");
        Intrinsics.checkNotNullParameter(r112.f268077b, "<set-?>");
        int r115 = AnnieXSalamanderAbility.f267859a;
        Intrinsics.checkNotNullParameter(r114, SlcElement.KEY_PROPS);
        this.f267809c = new f0(new d0(r114), r114);
        return;
    L17:
        f2 r116 = new f2(r105, r106, r108);
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r116.f268246b = r111;
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        int r117 = AnnieXSalamanderAbility.f267859a;
        Intrinsics.checkNotNullParameter(r116, SlcElement.KEY_PROPS);
        this.f267810d = new g2(new AnnieXWebEngine(r116), r116);
        return;
    L13:
        r107 = r113;
        goto L15
    }

    public final void b(final boolean r100) {
        o r101 = a();
        Function0<? extends m> r102 = r101.f268261b;
        Function1<? super Function1<? super m, ? extends m>, Unit> r103 = null;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_stateGetter");
        r102 = null;
    L6:
        if (r102.invoke().f268222b == r100) goto L14;
        Function1<? super Function1<? super m, ? extends m>, Unit> r104 = r101.f268262c;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("_stateSetter");
    L12:
        r103.invoke(new AnnieXEngineViewModel$setVisible$1(r100));
        return;
    L11:
        r103 = r104;
        goto L12
    }

    public final void c(final AnnieXLoadStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "loadStatus");
        Function1<? super Function1<? super e, ? extends e>, Unit> r101 = this.f267808b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_baseModelSetter");
        r101 = null;
    L5:
        r101.invoke(new AnnieXBaseViewModel$updateLoadStatus$1(r100));
    }
}
