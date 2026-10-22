package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.composition;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import io.github.alexzhirkevich.compottie.internal.effects.EffectValue;
import io.github.alexzhirkevich.compottie.internal.effects.LayerEffect;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class k extends u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490841b;

    public k(io.github.alexzhirkevich.compottie.internal.animation.expressions.l r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r101) {
        Intrinsics.checkNotNullParameter(r100, "effect");
        Intrinsics.checkNotNullParameter(r101, "nameOrIndex");
        this.f490840a = r100;
        this.f490841b = r101;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2 r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        Object r103 = this.f490840a.a(r100, r101, r102);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type io.github.alexzhirkevich.compottie.internal.effects.LayerEffect");
        LayerEffect r104 = (LayerEffect) r103;
        Object r105 = this.f490841b.a(r100, r101, r102);
        if ((r105 instanceof String) == false) goto L6;
        EffectValue r106 = (EffectValue) ((Map) r104.f491300a.getValue()).get(r105);
    L8:
        if (r106 == null) goto L10;
        k2 r107 = r106.getValue();
    L11:
        if (r107 == null) goto L14;
        return r107;
    L14:
        throw new IllegalStateException(("Effect value with name or index '" + this.f490841b + "' wasn't found in Effect").toString());
    L10:
        r107 = null;
        goto L11
    L6:
        if ((r105 instanceof Number) == false) goto L16;
        r106 = (EffectValue) ((Map) r104.f491301b.getValue()).get(Integer.valueOf(((Number) r105).intValue()));
        goto L8
    L16:
        throw new IllegalStateException(("Effect.value(.) can take string (name) or number(index) but " + r105 + " got").toString());
    }
}
