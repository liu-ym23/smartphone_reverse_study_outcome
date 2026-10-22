package yt7;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import luc.f;
import muc.e;
import nuc.c1;

/* JADX INFO: loaded from: classes23.dex */
public final class b<T> implements juc.d<vt7.b<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1 f569146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f569147b;

    @Override // juc.d, juc.n, juc.c
    public final f getDescriptor() {
        return this.f569147b;
    }

    public b(juc.d<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "elementSerializer");
        Intrinsics.checkNotNullParameter(r100, "elementSerializer");
        c1 r101 = new c1(r100);
        this.f569146a = r101;
        this.f569147b = r101.f520650b;
    }

    @Override // juc.c
    public final Object deserialize(e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return new vt7.b((Collection) this.f569146a.deserialize(r100));
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        vt7.b r102 = (vt7.b) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        this.f569146a.serialize(r100, r102);
    }
}
