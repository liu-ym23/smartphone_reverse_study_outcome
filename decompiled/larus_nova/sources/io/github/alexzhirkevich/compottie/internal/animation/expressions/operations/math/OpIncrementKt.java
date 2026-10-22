package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.math;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class OpIncrementKt {
    public static final io.github.alexzhirkevich.compottie.internal.animation.expressions.f a(io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100) {
        Intrinsics.checkNotNullParameter(r100, "variable");
        return b(r100, OpIncrementKt$OpDecrement$1.INSTANCE, "decrement");
    }

    public static final io.github.alexzhirkevich.compottie.internal.animation.expressions.f c(io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100) {
        Intrinsics.checkNotNullParameter(r100, "variable");
        return b(r100, OpIncrementKt$OpIncrement$1.INSTANCE, "increment");
    }

    public static final boolean d(io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof wrc.m) == false) goto L7;
        if (((wrc.m) r100).f560936b != null) goto L7;
    L10:
        return true;
    L7:
        if ((r100 instanceof wrc.n) == true) goto L9;
    L11:
        return false;
    L9:
        if ((((wrc.n) r100).f560937a instanceof wrc.m) == false) goto L11;
        goto L10
    }

    public static final io.github.alexzhirkevich.compottie.internal.animation.expressions.f b(final io.github.alexzhirkevich.compottie.internal.animation.expressions.f r100, final Function1<Object, ? extends Object> r101, String r110) {
        if ((r100 instanceof wrc.m) == false) goto L8;
        wrc.m r102 = (wrc.m) r100;
        if (r102.f560936b != null) goto L8;
        return new wrc.a(null, r102.f560935a, new h(r101, r100), null);
    L8:
        if ((r100 instanceof wrc.n) == false) goto L14;
        wrc.n r103 = (wrc.n) r100;
        io.github.alexzhirkevich.compottie.internal.animation.expressions.f r104 = r103.f560937a;
        if ((r104 instanceof wrc.m) == false) goto L14;
        return new wrc.b(((wrc.m) r104).f560935a, null, r103.f560938b, new i(r101, r100), null);
    L14:
        throw new IllegalStateException(("Can't " + r110 + ' ' + r100).toString());
    }
}
