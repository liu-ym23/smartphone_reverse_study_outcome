package com.relax.relaxframework;

import com.facebook.keyframes.model.KFAnimation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class ModifierEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f404789a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f404790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Integer, ArrayList<Object[]>> f404791c = null;

    public static final class Companion {
        public Companion() {
        }

        public static int e() {
            int r100 = ModifierEngine.f404790b + 1;
            ModifierEngine.f404790b = r100;
            return r100;
        }

        public static void f(int r100, Object[] r101) {
            Intrinsics.checkNotNullParameter(r101, "interp");
            Map<Integer, ArrayList<Object[]>> r102 = ModifierEngine.f404791c;
            LinkedHashMap r103 = (LinkedHashMap) r102;
            ArrayList r104 = (ArrayList) r103.get(Integer.valueOf(r100));
            if (r104 != null) goto L5;
            r104 = com.bytedance.rts.foundation.j.k(new Object[0][]);
            Integer r105 = Integer.valueOf(r100);
            Intrinsics.checkNotNull(r104);
            com.bytedance.rts.foundation.m.e(r102, r105, r104);
        L5:
            com.bytedance.rts.foundation.j.j(r104, r101);
            RelaxInstance.Companion.getClass();
            if (RelaxInstance.access$getCurrentInstance$cp() == null) goto L9;
            RelaxInstance r106 = RelaxInstance.access$getCurrentInstance$cp();
            Intrinsics.checkNotNull(r106);
            r106.collectModifierToClean(r100);
            return;
        }

        public static void k(int r110, p r111) {
            Intrinsics.checkNotNullParameter(r111, "value");
            f0 r112 = r111.b();
            ArrayList<Double> r100 = com.bytedance.rts.foundation.j.k(new Double[]{Double.valueOf(r112.f405080a)});
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Double>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Double> }");
            ArrayList<Integer> r101 = com.bytedance.rts.foundation.j.k(new Integer[]{Integer.valueOf(r112.f405083d)});
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Int> }");
            ArrayList<Double> r102 = com.bytedance.rts.foundation.j.k(new Double[]{Double.valueOf(r112.f405082c)});
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Double>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Double> }");
            ArrayList<Integer> r103 = com.bytedance.rts.foundation.j.k(new Integer[]{Integer.valueOf(r112.f405083d)});
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Int> }");
            RelaxInstance.Companion.getClass();
            RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().o0(r110, r100, r101, r102, r103);
        }

        public static void p(int r110, z r111) {
            Intrinsics.checkNotNullParameter(r111, "value");
            f8 r112 = r111.b();
            ArrayList<ArrayList<Double>> r100 = com.bytedance.rts.foundation.j.k(new ArrayList[]{r112.f405085a});
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.util.ArrayList<java.util.ArrayList<kotlin.Double>>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<java.util.ArrayList<kotlin.Double>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Double> }> }");
            ArrayList<ArrayList<Integer>> r101 = com.bytedance.rts.foundation.j.k(new ArrayList[]{r112.f405086b});
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.util.ArrayList<java.util.ArrayList<kotlin.Int>>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<java.util.ArrayList<kotlin.Int>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Int> }> }");
            ArrayList<Double> r102 = com.bytedance.rts.foundation.j.k(new Double[]{Double.valueOf(r112.f405087c)});
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Double>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Double> }");
            ArrayList<Integer> r103 = com.bytedance.rts.foundation.j.k(new Integer[]{Integer.valueOf(r112.f405088d)});
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Int> }");
            ArrayList<Long> r113 = com.bytedance.rts.foundation.j.k(new Long[]{Long.valueOf(r112.f405089e)});
            Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Long>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Long> }");
            RelaxInstance.Companion.getClass();
            RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().x0(r110, r100, r101, r102, r103, r113);
        }

        public static void b(int r100, g2 r101, final d3 r102) {
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r102, "value");
            Companion r103 = ModifierEngine.f404789a;
            Object[] r104 = {InterpolationType.Raw, Integer.valueOf(r101.f405102a), new ModifierEngine$Companion$collectModifierProperty$2(r102), r102.f405056b};
            r103.getClass();
            f(r100, r104);
        }

        public static void c(int r100, g2 r101, final e3 r102) {
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r102, "value");
            Companion r103 = ModifierEngine.f404789a;
            Object[] r104 = {InterpolationType.Reactive, Integer.valueOf(r101.f405102a), new ModifierEngine$Companion$collectModifierProperty$4(r102), r102.f405069b};
            r103.getClass();
            f(r100, r104);
        }

        public static void g(int r100, g2 r101, q r102) {
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r102, "value");
            f0 r103 = r102.b();
            Companion r104 = ModifierEngine.f404789a;
            ArrayList r105 = com.bytedance.rts.foundation.j.k(new Double[]{Double.valueOf(r103.f405080a), Double.valueOf(r103.f405082c)});
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Double>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Double> }");
            ArrayList r106 = com.bytedance.rts.foundation.j.k(new Integer[]{Integer.valueOf(r103.f405081b), Integer.valueOf(r103.f405083d)});
            Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Int> }");
            r104.getClass();
            l(r100, r101, r105, r106);
        }

        public static void h(final int r100, final g2 r101, final Function0 r102) {
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r102, "value");
            RelaxFrameworkKt.K(new ModifierEngine$Companion$setBorderDirectionRadiusValue$1(r102, r100, r101));
        }

        public static void i(int r100, g2 r101, ModifierValue_BackgroundClip r102) {
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r102, "value");
            int r103 = com.bytedance.rts.foundation.d.f267577a;
            ArrayList r104 = com.bytedance.rts.foundation.j.k(new Double[]{Double.valueOf(r102.getValue())});
            Companion r105 = ModifierEngine.f404789a;
            ArrayList r106 = com.bytedance.rts.foundation.j.k(new Integer[]{Integer.valueOf(ModifierValuePattern.ENUM.getValue())});
            Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Int> }");
            r105.getClass();
            l(r100, r101, r104, r106);
        }

        public static void j(int r100, g2 r101, k r102) {
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r102, "value");
            if ((r102 instanceof w8) == false) goto L6;
            ((w8) r102).getClass();
            qpa.d.g(r100, r101.f405102a, null);
            return;
        L6:
            if ((r102 instanceof v) == false) goto L9;
            ModifierEngine.f404789a.getClass();
            n(r100, r101, (v) r102);
            return;
        L9:
            if ((r102 instanceof x) == false) goto L12;
            ModifierEngine.f404789a.getClass();
            o(r100, r101, (x) r102);
            return;
        L12:
            if ((r102 instanceof t) == false) goto L18;
            ModifierEngine.f404789a.getClass();
            m(r100, r101, (t) r102);
            return;
        }

        public static void m(int r100, g2 r101, t r110) {
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r110, "value");
            r110.getClass();
            IntCompanionObject r102 = IntCompanionObject.INSTANCE;
            int r103 = com.bytedance.rts.foundation.j.d(r110.f405270a);
            com.bytedance.rts.foundation.k.c(r102, r103);
            if (r103 != 0) goto L5;
            int r104 = com.bytedance.rts.foundation.d.f267577a;
            ModifierValue_BackgroundPosition r105 = ModifierValue_BackgroundPosition.Center;
            r110.f405270a = com.bytedance.rts.foundation.j.k(new Double[]{Double.valueOf(r105.getValue()), Double.valueOf(r105.getValue())});
        L5:
            int r106 = com.bytedance.rts.foundation.j.d(r110.f405271b);
            com.bytedance.rts.foundation.k.c(r102, r106);
            if (r106 != 0) goto L8;
            ModifierValuePattern r107 = ModifierValuePattern.ENUM;
            r110.f405271b = com.bytedance.rts.foundation.j.k(new ModifierValuePattern[]{r107, r107});
        L8:
            ArrayList r108 = com.bytedance.rts.foundation.j.k(new Integer[0]);
            Iterator<T> r109 = r110.f405271b.iterator();
        L10:
            if (r109.hasNext() == false) goto L12;
            com.bytedance.rts.foundation.j.j(r108, Integer.valueOf(((ModifierValuePattern) r109.next()).getValue()));
            goto L10
        L12:
            ArrayList<Double> r111 = r110.f405270a;
            ArrayList<Long> r112 = r110.f405272c;
            ArrayList<ArrayList<Double>> r113 = r110.f405273d;
            Intrinsics.checkNotNullParameter(r111, "positionValues");
            Intrinsics.checkNotNullParameter(r108, "positionPatterns");
            Intrinsics.checkNotNullParameter(r112, "colors");
            Intrinsics.checkNotNullParameter(r113, "colorDegrees");
            int r114 = r101.f405102a;
            RelaxInstance.Companion.getClass();
            RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().q0(r100, r114, r111, r108, r112, r113);
        }

        public static void n(int r110, g2 r111, v r112) {
            Intrinsics.checkNotNullParameter(r111, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r112, "value");
            ArrayList<h0> r100 = r112.f405308a;
            if (r100 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("colorStopList");
            r100 = null;
        L6:
            Object[] r101 = RelaxFrameworkKt.P(r100);
            Object r102 = r101[0];
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Long>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Long> }");
            ArrayList<Long> r103 = (ArrayList) r102;
            Object r104 = r101[1];
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Double>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Double> }");
            ArrayList<Double> r105 = (ArrayList) r104;
            double r106 = r112.f405309b;
            Intrinsics.checkNotNullParameter(r103, "colors");
            Intrinsics.checkNotNullParameter(r105, "stops");
            int r107 = r111.f405102a;
            RelaxInstance.Companion.getClass();
            RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().s0(r110, r107, r106, r103, r105);
        }

        public static void o(int r110, g2 r111, x r112) {
            Intrinsics.checkNotNullParameter(r111, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r112, "value");
            ArrayList<h0> r100 = r112.f405344a;
            if (r100 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("colorStopList");
            r100 = null;
        L6:
            Object[] r101 = RelaxFrameworkKt.P(r100);
            Object r102 = r101[0];
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Long>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Long> }");
            ArrayList<Long> r113 = (ArrayList) r102;
            Object r103 = r101[1];
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Double>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Double> }");
            ArrayList<Double> r114 = (ArrayList) r103;
            RadialGradientShape r104 = r112.f405345b;
            if (r104 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("shapeValue");
            r104 = null;
        L10:
            long r115 = r104.getValue();
            Object r105 = r112.a()[0];
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.relax.relaxframework.ModifierType_WithPattern");
            int r106 = com.bytedance.rts.foundation.d.f267577a;
            Object r107 = r112.a()[0];
            Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type com.relax.relaxframework.ModifierType_WithPattern");
            Object r108 = r112.a()[1];
            Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.relax.relaxframework.ModifierType_WithPattern");
            Object r109 = r112.a()[1];
            Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.relax.relaxframework.ModifierType_WithPattern");
            ArrayList<Double> r116 = com.bytedance.rts.foundation.j.k(new Double[]{Double.valueOf(((d3) r105).f405055a), Double.valueOf(((d3) r107).f405056b.getValue()), Double.valueOf(((d3) r108).f405055a), Double.valueOf(((d3) r109).f405056b.getValue())});
            ArrayList<Double> r117 = r112.f405347d;
            if (r117 == null) goto L13;
            ArrayList<Double> r118 = r117;
        L14:
            Intrinsics.checkNotNullParameter(r113, "colors");
            Intrinsics.checkNotNullParameter(r114, "stops");
            Intrinsics.checkNotNullParameter(r116, "size");
            Intrinsics.checkNotNullParameter(r118, "position");
            int r119 = r111.f405102a;
            RelaxInstance.Companion.getClass();
            RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().u0(r110, r119, r113, r114, r115, r116, r118);
            return;
        L13:
            Intrinsics.throwUninitializedPropertyAccessException("positionList");
            r118 = null;
            goto L14
        }

        public static void q(int r100, g2 r101, b2 r102) {
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r102, "value");
            o8 r103 = r102.b();
            int r104 = r101.f405102a;
            ArrayList<Integer> r105 = com.bytedance.rts.foundation.j.k(new Integer[]{Integer.valueOf(r103.getType())});
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Int> }");
            ArrayList<ArrayList<Double>> r106 = com.bytedance.rts.foundation.j.k(new ArrayList[]{r103.f405208b});
            Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type java.util.ArrayList<java.util.ArrayList<kotlin.Double>>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<java.util.ArrayList<kotlin.Double>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Double> }> }");
            RelaxInstance.Companion.getClass();
            RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().y0(r100, r104, r105, r106);
        }

        public static void a(int r100, g2 r101, final s0 r102, ModifierValuePattern r103) {
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r102, "value");
            Intrinsics.checkNotNullParameter(r103, "pattern");
            Companion r104 = ModifierEngine.f404789a;
            Object[] r105 = {InterpolationType.Raw, Integer.valueOf(r101.f405102a), new ModifierEngine$Companion$collectModifierProperty$1(r102), r103};
            r104.getClass();
            f(r100, r105);
        }

        public static void d(int r100, g2 r101, final Function0 r102, ModifierValuePattern r103) {
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r102, "value");
            Intrinsics.checkNotNullParameter(r103, "pattern");
            Companion r104 = ModifierEngine.f404789a;
            Object[] r105 = {InterpolationType.Reactive, Integer.valueOf(r101.f405102a), new ModifierEngine$Companion$collectModifierProperty$5(r102), r103};
            r104.getClass();
            f(r100, r105);
        }

        public static void l(int r100, g2 r101, ArrayList r102, ArrayList r103) {
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r102, "values");
            Intrinsics.checkNotNullParameter(r103, "patterns");
            int r104 = r101.f405102a;
            RelaxInstance.Companion.getClass();
            RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().m0(r100, r104, r102, r103);
        }
    }

    static {
        f404789a = new Companion();
        f404791c = new LinkedHashMap();
    }
}
