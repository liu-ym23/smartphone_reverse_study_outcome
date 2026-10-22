package io.github.alexzhirkevich.compottie.internal.animation;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class v1 extends ouc.i0<List<? extends Float>> {
    public v1() {
        Intrinsics.checkNotNullParameter(FloatCompanionObject.INSTANCE, "<this>");
        super(kuc.a.b(nuc.l0.f520731a));
    }

    @Override // ouc.i0
    public final ouc.i a(ouc.i r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        if ((r100 instanceof ouc.g0) == true) goto L5;
        return r100;
    L5:
        return new ouc.b(CollectionsKt.listOf(r100));
    }
}
