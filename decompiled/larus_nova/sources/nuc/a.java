package nuc;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
@InternalSerializationApi
public abstract class a<Element, Collection, Builder> implements juc.d<Collection> {
    public abstract Builder a();

    public abstract int b(Builder r100);

    public abstract void c(Builder r100, int r101);

    public abstract Iterator<Element> d(Collection r100);

    public abstract int e(Collection r100);

    public abstract void g(muc.c r100, Builder r101, int r102, int r103);

    public abstract void h(muc.c r100, int r101, Builder r102, boolean r103);

    public abstract Builder i(Collection r100);

    public abstract Collection j(Builder r100);

    public a() {
    }

    @Override // juc.c
    public Collection deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return (Collection) f(r100);
    }

    @InternalSerializationApi
    public final Object f(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Builder r101 = a();
        int r102 = b(r101);
        muc.c r103 = r100.beginStructure(getDescriptor());
        if (r103.decodeSequentially() == false) goto L5;
        int r104 = r103.decodeCollectionSize(getDescriptor());
        c(r101, r104);
        g(r103, r101, r102, r104);
    L8:
        r103.endStructure(getDescriptor());
        return j(r101);
    L5:
        int r105 = r103.decodeElementIndex(getDescriptor());
        if (r105 == (-1)) goto L8;
        h(r103, r105 + r102, r101, true);
        goto L5
    }
}
