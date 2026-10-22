package nuc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class r1<T> implements juc.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final juc.d<T> f520764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p2 f520765b;

    public final int hashCode() {
        return this.f520764a.hashCode();
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.f520765b;
    }

    public r1(juc.d<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "serializer");
        this.f520764a = r100;
        this.f520765b = new p2(r100.getDescriptor());
    }

    @Override // juc.c
    public final T deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        if (r100.decodeNotNullMark() == false) goto L6;
        return (T) r100.decodeSerializableValue(this.f520764a);
    L6:
        return (T) r100.decodeNull();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L14:
        return false;
    L8:
        if (r1.class != r100.getClass()) goto L14;
        if (Intrinsics.areEqual(this.f520764a, ((r1) r100).f520764a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // juc.n
    public final void serialize(muc.f r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        if (r101 == null) goto L5;
        r100.encodeNotNullMark();
        r100.encodeSerializableValue(this.f520764a, r101);
        return;
    L5:
        r100.encodeNull();
    }
}
