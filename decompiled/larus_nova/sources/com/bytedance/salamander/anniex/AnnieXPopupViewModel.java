package com.bytedance.salamander.anniex;

import androidx.camera.video.AudioStats;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.relax.relaxframework.RelaxFrameworkKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class AnnieXPopupViewModel extends AnnieXCommonUIViewModel {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f267844s = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<? extends w0> f267845n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function1<? super Function1<? super w0, ? extends w0>, Unit> f267846o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final x0 f267847p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.relax.relaxframework.x6 f267848q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f267849r;

    public static final class a {
        public a() {
        }

        public static final w0 a(y0 r210, f3 r211) {
            int r100 = AnnieXPopupViewModel.f267844s;
            double r101 = r211.l();
            double r102 = r211.getContainerWidth();
            if (r101 > r102) goto L5;
            boolean r103 = true;
        L6:
            double r104 = r101 - r211.b();
            if (r210.f268140i == PadAdapterStyle.UNIFORM_STYLE) goto L9;
        L11:
            boolean r110 = false;
        L13:
            if (r210.f268519z == AnnieXPopupType.BOTTOM) goto L25;
            int r111 = r210.G;
            if (r111 == 0) goto L17;
            double r112 = (com.bytedance.rts.foundation.k.b(IntCompanionObject.INSTANCE, r111) * r102) / ((double) 100);
        L26:
            double r113 = r211.a();
            if (r210.f268516w == true) goto L30;
            r104 = r101;
        L30:
            double r105 = r104 - r113;
            int r106 = r210.B;
            if (r106 == 0) goto L33;
            boolean r114 = r103;
            double r115 = (com.bytedance.rts.foundation.k.b(IntCompanionObject.INSTANCE, r106) * r105) / ((double) 100);
        L45:
            Double r107 = r210.E;
            Double r108 = r210.C;
            if (r114 == false) goto L50;
            if (r108 == null) goto L50;
            r107 = r108;
        L50:
            if (r107 != null) goto L53;
            if (r110 == false) goto L53;
            r107 = Double.valueOf(m0.f268228f);
        L53:
            if (r107 == null) goto L55;
            double r109 = r107.doubleValue();
        L56:
            AnnieXPopupType r116 = r210.f268519z;
            AnnieXPopupType r117 = AnnieXPopupType.CENTER;
            double r118 = r109;
            if (r116 != r117) goto L59;
            double r119 = r118;
        L60:
            double r120 = r102 - r112;
            double r121 = r119;
            double r122 = 2;
            double r212 = r120 / r122;
            if (r116 == AnnieXPopupType.RIGHT) goto L64;
            r120 = r212;
        L64:
            double r213 = r105 - r115;
            double r123 = r213 / r122;
            if (r116 == r117) goto L67;
            r123 = r213;
        L67:
            double r214 = 0.8d * r115;
            int r124 = r210.f268514u;
            if (r124 == 0) goto L70;
            r214 = com.bytedance.rts.foundation.k.b(IntCompanionObject.INSTANCE, r124);
        L70:
            double r125 = r214;
            double r126 = r115 - (0.6d * r115);
            int r127 = r210.f268515v;
            if (r127 == 0) goto L73;
            r126 = com.bytedance.rts.foundation.k.b(IntCompanionObject.INSTANCE, r127);
        L73:
            double r215 = r123;
            double r128 = r101 / ((double) 10);
            int r129 = r210.f268517x;
            if (r129 == 0) goto L76;
            r128 = com.bytedance.rts.foundation.k.b(IntCompanionObject.INSTANCE, r129);
        L76:
            w0 r130 = new w0();
            Boolean r131 = r210.f268518y;
            if (r131 == null) goto L79;
            boolean r132 = r131.booleanValue();
        L80:
            r130.f268461a = r132;
            r130.f268462b = !r210.f268513t;
            r130.f268463c = r115;
            r130.f268464d = r112;
            r130.f268465e = r125;
            r130.f268466f = r126;
            r130.f268467g = r128;
            g r133 = r210.D;
            Intrinsics.checkNotNullParameter(r133, "maskBgColor");
            r130.f268468h = r133;
            r130.f268469i = r120;
            r130.f268470j = r215;
            r130.f268471k = r118;
            r130.f268472l = r121;
            r130.f268473m = r105;
            r130.f268474n = AudioStats.AUDIO_AMPLITUDE_NONE;
            r130.f268475o = AudioStats.AUDIO_AMPLITUDE_NONE;
            return r130;
        L79:
            r132 = Intrinsics.areEqual(r210.f268512s, Boolean.TRUE);
            goto L80
        L59:
            r119 = 0;
            goto L60
        L55:
            r109 = 8;
            goto L56
        L33:
            r114 = r103;
            int r134 = r210.A;
            if (r134 == 0) goto L36;
            r115 = com.bytedance.rts.foundation.k.b(IntCompanionObject.INSTANCE, r134);
            goto L45
        L36:
            double r135 = r210.f268511r;
            if (r135 <= 0) goto L39;
            r115 = r112 * r135;
            goto L45
        L39:
            if (r110 == true) goto L41;
            r115 = r105;
            goto L45
        L41:
            if (r101 >= m0.f268223a) goto L43;
            int r136 = com.bytedance.rts.foundation.h.f267580a;
            r115 = Math.max(0.73d * r105, m0.f268226d);
            goto L45
        L43:
            r115 = m0.f268227e;
            goto L45
        L17:
            int r137 = r210.F;
            if (r137 == 0) goto L20;
            r112 = com.bytedance.rts.foundation.k.b(IntCompanionObject.INSTANCE, r137);
            goto L26
        L20:
            if (r110 == false) goto L25;
            if (r102 >= m0.f268225c) goto L24;
            r112 = m0.f268229g;
            goto L26
        L24:
            r112 = m0.f268230h;
        L25:
            r112 = r102;
            goto L26
        L9:
            if (r102 <= m0.f268224b) goto L11;
            r110 = true;
            goto L13
        L5:
            r103 = false;
            goto L6
        }
    }

    static {
        new a();
    }

    public final Function0<w0> u() {
        Function0 r100 = this.f267845n;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_popupModelGetter");
        return null;
    L6:
        return r100;
    }

    public final void x() {
        Function1<? super Function1<? super w0, ? extends w0>, Unit> r100 = this.f267846o;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_popupModelSetter");
        r100 = null;
    L5:
        r100.invoke(new AnnieXPopupViewModel$updatePopupView$1(this));
    }

    @Override // com.bytedance.salamander.anniex.AnnieXCommonUIViewModel
    public final AnnieXUIComponentType g() {
        return AnnieXUIComponentType.POPUP;
    }

    public final void v(final boolean r100) {
        Function0<? extends w0> r101 = this.f267845n;
        Function1<? super Function1<? super w0, ? extends w0>, Unit> r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_popupModelGetter");
        r101 = null;
    L6:
        if (r101.invoke().f268461a == r100) goto L13;
        Function1<? super Function1<? super w0, ? extends w0>, Unit> r103 = this.f267846o;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("_popupModelSetter");
    L11:
        r102.invoke(new AnnieXPopupViewModel$setCloseByGesture$1(r100));
        return;
    L10:
        r102 = r103;
        goto L11
    }

    public final void w(final boolean r100) {
        Function0<? extends w0> r101 = this.f267845n;
        Function1<? super Function1<? super w0, ? extends w0>, Unit> r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_popupModelGetter");
        r101 = null;
    L6:
        if (r101.invoke().f268462b == r100) goto L13;
        Function1<? super Function1<? super w0, ? extends w0>, Unit> r103 = this.f267846o;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("_popupModelSetter");
    L11:
        r102.invoke(new AnnieXPopupViewModel$setCloseByMask$1(r100));
        return;
    L10:
        r102 = r103;
        goto L11
    }

    public AnnieXPopupViewModel(x0 r100, com.bytedance.android.anniex.salamander.c r101) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        Intrinsics.checkNotNullParameter(r101, "coordinator");
        super(r100, r101);
        y0 r102 = r100.f268499k;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("popupSchema");
        r102 = null;
    L6:
        w0 r103 = a.a(r102, r101);
        Object[] r104 = RelaxFrameworkKt.i0(r103);
        Object r105 = r104[0];
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Function0<com.bytedance.salamander.anniex.AnnieXPopupModel>{ com.relax.relaxframework.RelaxFrameworkKt.StateGetter<com.bytedance.salamander.anniex.AnnieXPopupModel> }");
        Function0<? extends w0> r106 = (Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r105, 0);
        Object r107 = r104[1];
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"fn\")] kotlin.Function1<@[ParameterName(name = \"v\")] com.bytedance.salamander.anniex.AnnieXPopupModel, com.bytedance.salamander.anniex.AnnieXPopupModel>, kotlin.Unit>{ com.relax.relaxframework.RelaxFrameworkKt.StateSetter<com.bytedance.salamander.anniex.AnnieXPopupModel> }");
        Function1<? super Function1<? super w0, ? extends w0>, Unit> r108 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r107, 1);
        this.f267845n = r106;
        this.f267846o = r108;
        this.f267847p = r100;
        double r109 = r103.f268474n;
    }
}
