package io.github.alexzhirkevich.compottie.internal.animation.expressions;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class c extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f490818c;

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.e
    public final w a() {
        return this.f490818c.a();
    }

    public c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f490818c = r100;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.b, io.github.alexzhirkevich.compottie.internal.animation.expressions.e
    public final Object d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (this.f490816a.containsKey(r100) == false) goto L6;
        return super.d(r100);
    L6:
        return this.f490818c.d(r100);
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.b, io.github.alexzhirkevich.compottie.internal.animation.expressions.e
    public final void c(String r100, Object r101, VariableType r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (r102 != VariableType.Var) goto L5;
        this.f490818c.c(r100, r101, r102);
        return;
    L5:
        if (r102 == null) goto L7;
    L10:
        super.c(r100, r101, r102);
        return;
    L7:
        if (this.f490816a.containsKey(r100) == true) goto L10;
        this.f490818c.c(r100, r101, r102);
    }
}
