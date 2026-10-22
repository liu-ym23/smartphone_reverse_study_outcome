package nuc;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes42.dex */
public abstract class y0<K, V, R> implements juc.d<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final juc.d<K> f520804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final juc.d<V> f520805b;

    public abstract K a(R r100);

    public abstract V b(R r100);

    public abstract R c(K r100, V r101);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // juc.c
    public final R deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        luc.f r101 = getDescriptor();
        muc.c r102 = r100.beginStructure(r101);
        if (r102.decodeSequentially() == false) goto L5;
        R r103 = (R) c(r102.decodeSerializableElement(getDescriptor(), 0, this.f520804a, null), r102.decodeSerializableElement(getDescriptor(), 1, this.f520805b, null));
    L18:
        r102.endStructure(r101);
        return r103;
    L5:
        Object r104 = a3.f520643a;
        Object r105 = r104;
    L6:
        int r106 = r102.decodeElementIndex(getDescriptor());
        if (r106 == (-1)) goto L14;
        if (r106 != 0) goto L9;
        r104 = r102.decodeSerializableElement(getDescriptor(), 0, this.f520804a, null);
        goto L6
    L9:
        if (r106 != 1) goto L12;
        r105 = r102.decodeSerializableElement(getDescriptor(), 1, this.f520805b, null);
        goto L6
    L12:
        throw new SerializationException("Invalid index: " + r106);
    L14:
        Object r107 = a3.f520643a;
        if (r104 == r107) goto L23;
        if (r105 == r107) goto L21;
        r103 = (R) c(r104, r105);
        goto L18
    L21:
        throw new SerializationException("Element 'value' is missing");
    L23:
        throw new SerializationException("Element 'key' is missing");
    }

    public y0(juc.d r100, juc.d r101) {
        this.f520804a = r100;
        this.f520805b = r101;
    }

    @Override // juc.n
    public final void serialize(muc.f r100, R r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        muc.d r102 = r100.beginStructure(getDescriptor());
        r102.encodeSerializableElement(getDescriptor(), 0, this.f520804a, a(r101));
        r102.encodeSerializableElement(getDescriptor(), 1, this.f520805b, b(r101));
        r102.endStructure(getDescriptor());
    }
}
