package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.composition;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class l extends j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f f490847b;

    public /* synthetic */ l(io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100, int r101) {
        if ((r101 & 2) == 0) goto L5;
        r100 = null;
    L5:
        this(null, r100);
    }

    public l(io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.f r101) {
        this.f490846a = r100;
        this.f490847b = r101;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2 r100, io.github.alexzhirkevich.compottie.internal.animation.expressions.e r101, prc.f r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "state");
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r103 = this.f490847b;
        if (r103 == null) goto L27;
        Object r104 = r103.a(r100, r101, r102);
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r105 = this.f490846a;
        if (r105 == null) goto L9;
        Object r106 = r105.a(r100, r101, r102);
        if (r106 == null) goto L9;
    L11:
        if ((r106 instanceof io.github.alexzhirkevich.compottie.internal.animation.expressions.g) == false) goto L26;
        if ((r104 instanceof String) == false) goto L16;
        dsc.s r107 = ((io.github.alexzhirkevich.compottie.internal.animation.expressions.g) r106).c().get(r104);
    L18:
        if (r107 == null) goto L22;
        return r107;
    L22:
        throw new IllegalStateException(("Layer with name(index) '" + this.f490847b + "' wasn't found in composition " + ((io.github.alexzhirkevich.compottie.internal.animation.expressions.g) r106).getName()).toString());
    L16:
        if ((r104 instanceof Number) == false) goto L24;
        r107 = ((io.github.alexzhirkevich.compottie.internal.animation.expressions.g) r106).d().get(Integer.valueOf(((Number) r104).intValue()));
        goto L18
    L24:
        throw new IllegalStateException(("layer(.) takes string or number argument but got " + r104).toString());
    L26:
        throw new IllegalArgumentException(("Failed to cast " + r106 + " to Composition").toString());
    L9:
        r106 = r102.f530391a.f490698e;
        goto L11
    L27:
        return r102.f530403m;
    }
}
