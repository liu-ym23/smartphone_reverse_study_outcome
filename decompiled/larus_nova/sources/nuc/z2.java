package nuc;

import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes42.dex */
public final class z2<A, B, C> implements juc.d<Triple<? extends A, ? extends B, ? extends C>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final juc.d<A> f520809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final juc.d<B> f520810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final juc.d<C> f520811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final luc.i f520812d;

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.f520812d;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r110) {
        Intrinsics.checkNotNullParameter(r110, "decoder");
        muc.c r111 = r110.beginStructure(this.f520812d);
        if (r111.decodeSequentially() == false) goto L5;
        Object r100 = r111.decodeSerializableElement(this.f520812d, 0, this.f520809a, null);
        Object r101 = r111.decodeSerializableElement(this.f520812d, 1, this.f520810b, null);
        Object r102 = r111.decodeSerializableElement(this.f520812d, 2, this.f520811c, null);
        r111.endStructure(this.f520812d);
        return new Triple(r100, r101, r102);
    L5:
        Object r103 = a3.f520643a;
        Object r104 = r103;
        Object r105 = r104;
    L6:
        int r106 = r111.decodeElementIndex(this.f520812d);
        if (r106 == (-1)) goto L16;
        if (r106 != 0) goto L9;
        r103 = r111.decodeSerializableElement(this.f520812d, 0, this.f520809a, null);
        goto L6
    L9:
        if (r106 != 1) goto L10;
        r104 = r111.decodeSerializableElement(this.f520812d, 1, this.f520810b, null);
        goto L6
    L10:
        if (r106 != 2) goto L13;
        r105 = r111.decodeSerializableElement(this.f520812d, 2, this.f520811c, null);
        goto L6
    L13:
        throw new SerializationException("Unexpected index " + r106);
    L16:
        r111.endStructure(this.f520812d);
        Object r112 = a3.f520643a;
        if (r103 == r112) goto L27;
        if (r104 == r112) goto L25;
        if (r105 == r112) goto L23;
        return new Triple(r103, r104, r105);
    L23:
        throw new SerializationException("Element 'third' is missing");
    L25:
        throw new SerializationException("Element 'second' is missing");
    L27:
        throw new SerializationException("Element 'first' is missing");
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        Triple r102 = (Triple) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        muc.d r103 = r100.beginStructure(this.f520812d);
        r103.encodeSerializableElement(this.f520812d, 0, this.f520809a, r102.getFirst());
        r103.encodeSerializableElement(this.f520812d, 1, this.f520810b, r102.getSecond());
        r103.encodeSerializableElement(this.f520812d, 2, this.f520811c, r102.getThird());
        r103.endStructure(this.f520812d);
    }

    public z2(juc.d<A> r100, juc.d<B> r101, juc.d<C> r102) {
        Intrinsics.checkNotNullParameter(r100, "aSerializer");
        Intrinsics.checkNotNullParameter(r101, "bSerializer");
        Intrinsics.checkNotNullParameter(r102, "cSerializer");
        this.f520809a = r100;
        this.f520810b = r101;
        this.f520811c = r102;
        this.f520812d = luc.n.c("kotlin.Triple", new luc.f[0], new y2(this));
    }
}
