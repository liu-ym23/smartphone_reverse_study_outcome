package io.github.alexzhirkevich.compottie.internal.animation.expressions.operations.composition;

import io.github.alexzhirkevich.compottie.internal.effects.LayerEffect;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public abstract class h implements io.github.alexzhirkevich.compottie.internal.animation.expressions.l<LayerEffect> {
    public h() {
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.l
    public final io.github.alexzhirkevich.compottie.internal.animation.expressions.f b(String r100, List<? extends io.github.alexzhirkevich.compottie.internal.animation.expressions.f> r101) {
        if (r100 != null) goto L6;
        io.github.alexzhirkevich.compottie.internal.animation.expressions.v.a(r101, 1, "()");
        return new k(this, io.github.alexzhirkevich.compottie.internal.animation.expressions.m.a(r101, 0));
    L6:
        if (Intrinsics.areEqual(r100, "active") == false) goto L9;
        return io.github.alexzhirkevich.compottie.internal.animation.expressions.l.a.a(this, new g());
    L9:
        if (Intrinsics.areEqual(r100, "param") == false) goto L11;
        io.github.alexzhirkevich.compottie.internal.animation.expressions.v.a(r101, 1, r100);
        return new k(this, io.github.alexzhirkevich.compottie.internal.animation.expressions.m.a(r101, 0));
    L11:
        return null;
    }
}
