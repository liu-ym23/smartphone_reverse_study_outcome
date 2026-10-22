package io.github.alexzhirkevich.compottie.internal.animation;

import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class s2 extends ouc.i0<Float> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s2 f491159b = null;

    static {
        f491159b = new s2();
    }

    public s2() {
        Intrinsics.checkNotNullParameter(FloatCompanionObject.INSTANCE, "<this>");
        super(nuc.l0.f520731a);
    }

    @Override // ouc.i0
    public final ouc.i a(ouc.i r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        if ((r100 instanceof ouc.b) == true) goto L5;
        return r100;
    L5:
        return ((ouc.b) r100).a(0);
    }
}
