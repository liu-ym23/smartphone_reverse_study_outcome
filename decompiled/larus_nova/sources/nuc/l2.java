package nuc;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import nuc.j2;

/* JADX INFO: loaded from: classes5.dex */
public abstract class l2<Element, Array, Builder extends j2<Array>> extends v<Element, Array, Builder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k2 f520733b;

    public abstract Array k();

    public abstract void l(muc.d r100, Array r101, int r102);

    @Override // nuc.a
    public final Object a() {
        return i(k());
    }

    @Override // nuc.v, juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.f520733b;
    }

    public l2(juc.d<Element> r100) {
        Intrinsics.checkNotNullParameter(r100, "primitiveSerializer");
        super(r100);
        this.f520733b = new k2(r100.getDescriptor());
    }

    @Override // nuc.a
    public final int b(Object r100) {
        j2 r101 = (j2) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.d();
    }

    @Override // nuc.a
    public final Iterator<Element> d(Array r100) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString());
    }

    @Override // nuc.a, juc.c
    public final Array deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return (Array) f(r100);
    }

    @Override // nuc.a
    public final Object j(Object r100) {
        j2 r101 = (j2) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.a();
    }

    @Override // nuc.a
    public final void c(Object r100, int r101) {
        j2 r102 = (j2) r100;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        r102.b(r101);
    }

    @Override // nuc.v, juc.n
    public final void serialize(muc.f r100, Array r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        int r102 = e(r101);
        k2 r103 = this.f520733b;
        muc.d r104 = r100.beginCollection(r103, r102);
        l(r104, r101, r102);
        r104.endStructure(r103);
    }

    public final void insert(Builder r100, int r101, Element r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nuc.v
    public /* bridge */ /* synthetic */ void insert(Object r100, int r101, Object r102) {
        insert((j2) r100, r101, r102);
    }
}
