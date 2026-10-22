package io.github.alexzhirkevich.compottie.internal.animation;

import com.amap.api.col.s.ce;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class y extends ouc.i0<x.c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f491193b = null;

    static {
        f491193b = new y();
    }

    public y() {
        super(x.c.Companion.serializer());
    }

    @Override // ouc.i0
    public final ouc.i a(ouc.i r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        return new ouc.d0(MapsKt.mapOf(TuplesKt.to(ce.f26396k, r100)));
    }
}
