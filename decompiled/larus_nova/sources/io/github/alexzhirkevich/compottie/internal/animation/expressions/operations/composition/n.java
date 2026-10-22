package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.composition;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class n extends u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490858a;

    public n(io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100) {
        this.f490858a = r100;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2 r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r103 = this.f490858a;
        if (r103 == null) goto L6;
        Object r104 = r103.a(r100, r101, r102);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type io.github.alexzhirkevich.compottie.internal.animation.RawProperty<*>");
        return (k2) r104;
    L6:
        return r100;
    }
}
