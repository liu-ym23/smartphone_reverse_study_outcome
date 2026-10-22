package com.relax.relaxframework;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class ModifierCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p6 f404788a;

    public p6 f(CSSModifierProperty r100, RxModifierType r101, c2 r102) {
        throw null;
    }

    public final p6 i() {
        p6 r100 = this.f404788a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_modifier");
        return null;
    L6:
        return r100;
    }

    public ModifierCreator(p6 r100) {
        Intrinsics.checkNotNullParameter(r100, "modifier");
        this.f404788a = r100;
    }

    public final <T extends p6> T c(CSSModifierProperty r100, double r101) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        RxModifierType r102 = RxModifierType.Static;
        y3 r103 = new y3(PropertyValueType.DOUBLE);
        r103.f405318c = r101;
        T r104 = (T) f(r100, r102, new w7(r100, r103, RelaxFrameworkKt.f404886p));
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type T of com.relax.relaxframework.ModifierCreator.makeDoubleModifier");
        return r104;
    }

    public final <T extends p6> T d(CSSModifierProperty r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        RxModifierType r102 = RxModifierType.Static;
        int r103 = y3.f405359e;
        T r104 = (T) f(r100, r102, new w7(r100, y3.a.a(r101), RelaxFrameworkKt.f404885o));
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type T of com.relax.relaxframework.ModifierCreator.makeIntModifier");
        return r104;
    }

    public final <T extends p6> T e(CSSModifierProperty r100, final Function0<Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "value");
        T r102 = (T) f(r100, RxModifierType.Reactive, new q7(r100, new ModifierCreator$makeIntSignalModifier$1(r101), RelaxFrameworkKt.f404885o));
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type T of com.relax.relaxframework.ModifierCreator.makeIntSignalModifier");
        return r102;
    }

    public final <T extends p6> T a(CSSModifierProperty r100, y3 r101, y3 r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        T r103 = (T) f(r100, RxModifierType.Static, new w7(r100, r101, r102));
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type T of com.relax.relaxframework.ModifierCreator.makeComplexModifier");
        return r103;
    }

    public final <T extends p6> T b(CSSModifierProperty r100, Function0<? extends y3> r101, y3 r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        T r103 = (T) f(r100, RxModifierType.Reactive, new q7(r100, r101, r102));
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type T of com.relax.relaxframework.ModifierCreator.makeComplexSignalModifier");
        return r103;
    }

    public final <T extends p6> T g(CSSModifierProperty r100, double r101, ModifierValuePattern r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r102, "pattern");
        RxModifierType r103 = RxModifierType.Static;
        int r104 = y3.f405359e;
        T r105 = (T) f(r100, r103, new w7(r100, y3.a.c(r101, r102), RelaxFrameworkKt.f404884n));
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type T of com.relax.relaxframework.ModifierCreator.makePatternModifier");
        return r105;
    }

    public final <T extends p6> T h(CSSModifierProperty r100, final Function0<Double> r101, final ModifierValuePattern r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "pattern");
        T r103 = (T) f(r100, RxModifierType.Reactive, new q7(r100, new ModifierCreator$makeSignalModifier$1(r101, r102), RelaxFrameworkKt.f404884n));
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type T of com.relax.relaxframework.ModifierCreator.makeSignalModifier");
        return r103;
    }
}
