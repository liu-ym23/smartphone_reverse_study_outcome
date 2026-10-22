package io.github.alexzhirkevich.compottie.internal.animation;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class d2 extends ouc.i0<bsc.d> {
    public d2() {
        super(bsc.d.Companion.serializer());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ouc.i0
    public final ouc.i a(ouc.i r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        if ((r100 instanceof ouc.b) == true) goto L5;
        return r100;
    L5:
        return (ouc.i) CollectionsKt.first((List) r100);
    }
}
