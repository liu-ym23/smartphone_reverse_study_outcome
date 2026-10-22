package io.github.alexzhirkevich.compottie.internal.animation;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public abstract class g2<T> implements b0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f491031a;

    public abstract String f();

    public abstract T h(Object r100);

    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.n g() {
        return (io.github.alexzhirkevich.compottie.internal.animation.expressions.n) this.f491031a.getValue();
    }

    public g2() {
        this.f491031a = LazyKt.lazy(new f2(this));
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.b0
    public T b(prc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Object r101 = g().a(this, r100);
        if ((r101 instanceof b0) == false) goto L6;
        T r102 = (T) ((b0) r101).b(r100);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type T of io.github.alexzhirkevich.compottie.internal.animation.ExpressionProperty");
        return r102;
    L6:
        return h(r101);
    }
}
