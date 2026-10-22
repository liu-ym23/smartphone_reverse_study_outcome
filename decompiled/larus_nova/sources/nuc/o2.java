package nuc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes42.dex */
public final class o2<ElementKlass, Element extends ElementKlass> extends v<Element, Element[], ArrayList<Element>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KClass<ElementKlass> f520747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f520748c;

    @Override // nuc.a
    public final Object a() {
        return new ArrayList();
    }

    @Override // nuc.v, juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.f520748c;
    }

    @Override // nuc.a
    public final int b(Object r100) {
        ArrayList r101 = (ArrayList) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.size();
    }

    @Override // nuc.a
    public final Iterator d(Object r100) {
        Object[] r101 = (Object[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return ArrayIteratorKt.iterator(r101);
    }

    @Override // nuc.a
    public final int e(Object r100) {
        Object[] r101 = (Object[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.length;
    }

    @Override // nuc.a
    public final Object i(Object r100) {
        Intrinsics.checkNotNullParameter(null, "<this>");
        return new ArrayList(ArraysKt.asList(null));
    }

    @Override // nuc.a
    public final Object j(Object r100) {
        ArrayList r101 = (ArrayList) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        KClass<ElementKlass> r102 = this.f520747b;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(r102, "eClass");
        Object r103 = Array.newInstance(JvmClassMappingKt.getJavaClass(r102), r101.size());
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        return r101.toArray((Object[]) r103);
    }

    public o2(KClass<ElementKlass> r100, juc.d<Element> r101) {
        Intrinsics.checkNotNullParameter(r100, "kClass");
        Intrinsics.checkNotNullParameter(r101, "eSerializer");
        super(r101);
        this.f520747b = r100;
        this.f520748c = new d(r101.getDescriptor());
    }

    @Override // nuc.a
    public final void c(Object r100, int r101) {
        ArrayList r102 = (ArrayList) r100;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        r102.ensureCapacity(r101);
    }

    public void insert(ArrayList<Element> r100, int r101, Element r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ListProtector.add(r100, r101, r102);
    }

    @Override // nuc.v
    public /* bridge */ /* synthetic */ void insert(Object r100, int r101, Object r102) {
        insert((ArrayList) r100, r101, r102);
    }
}
