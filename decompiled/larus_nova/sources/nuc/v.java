package nuc;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class v<Element, Collection, Builder> extends a<Element, Collection, Builder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final juc.d<Element> f520786a;

    @Override // juc.d, juc.n, juc.c
    public abstract luc.f getDescriptor();

    public abstract void insert(Builder r100, int r101, Element r102);

    public v(juc.d r100) {
        this.f520786a = r100;
    }

    @Override // juc.n
    public void serialize(muc.f r100, Collection r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        int r102 = e(r101);
        luc.f r103 = getDescriptor();
        muc.d r104 = r100.beginCollection(r103, r102);
        Iterator<Element> r105 = d(r101);
        int r106 = 0;
    L3:
        if (r106 >= r102) goto L5;
        r104.encodeSerializableElement(getDescriptor(), r106, this.f520786a, r105.next());
        r106 = r106 + 1;
        goto L3
    L5:
        r104.endStructure(r103);
    }

    @Override // nuc.a
    public final void g(muc.c r100, Builder r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        if (r103 < 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L12;
        int r105 = 0;
    L8:
        if (r105 >= r103) goto L10;
        h(r100, r102 + r105, r101, false);
        r105 = r105 + 1;
        goto L8
    L10:
        return;
    L12:
        throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
    L5:
        r104 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nuc.a
    public void h(muc.c r100, int r101, Builder r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        insert(r102, r101, r100.decodeSerializableElement(getDescriptor(), r101, this.f520786a, null));
    }
}
