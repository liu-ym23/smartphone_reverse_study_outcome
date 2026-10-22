package yt7;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import muc.e;
import nuc.f;

/* JADX INFO: loaded from: classes23.dex */
public final class a<T> implements juc.d<CopyOnWriteArrayList<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f569144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final luc.f f569145b;

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.f569145b;
    }

    public a(juc.d<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "elementSerializer");
        f r101 = kuc.a.b(r100);
        this.f569144a = r101;
        this.f569145b = r101.f520671b;
    }

    @Override // juc.c
    public final Object deserialize(e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return new CopyOnWriteArrayList((Collection) this.f569144a.deserialize(r100));
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        CopyOnWriteArrayList r102 = (CopyOnWriteArrayList) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        this.f569144a.serialize(r100, r102);
    }
}
