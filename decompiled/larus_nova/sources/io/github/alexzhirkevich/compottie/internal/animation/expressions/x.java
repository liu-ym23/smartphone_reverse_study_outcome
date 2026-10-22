package io.github.alexzhirkevich.compottie.internal.animation.expressions;

import io.github.alexzhirkevich.compottie.internal.animation.k2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class x implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f490999a = null;

    static {
        f490999a = new x();
    }

    public x() {
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.n
    public final Object a(k2<?> r100, prc.f r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "state");
        return r100.d(r101);
    }
}
