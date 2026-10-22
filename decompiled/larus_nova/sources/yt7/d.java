package yt7;

import kotlin.jvm.internal.Intrinsics;
import luc.e;
import luc.f;
import luc.n;
import nuc.m2;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements juc.d<StringBuilder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f569149a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f569150b = null;

    public d() {
    }

    static {
        f569149a = new d();
        f569150b = n.a("StringBuilder", e.i.f510857a);
    }

    @Override // juc.d, juc.n, juc.c
    public final f getDescriptor() {
        return f569150b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return new StringBuilder(r100.decodeString());
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        StringBuilder r102 = (StringBuilder) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.encodeString(r102.toString());
    }
}
