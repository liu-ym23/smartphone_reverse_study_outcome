package nuc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
@InternalSerializationApi
public final class f<E> extends w<E, List<? extends E>, ArrayList<E>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f520671b;

    @Override // nuc.a
    public final Object a() {
        return new ArrayList();
    }

    @Override // nuc.v, juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.f520671b;
    }

    public f(juc.d<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        super(r100);
        this.f520671b = new e(r100.getDescriptor());
    }

    @Override // nuc.a
    public final int b(Object r100) {
        ArrayList r101 = (ArrayList) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.size();
    }

    @Override // nuc.a
    public final Object i(Object r100) {
        Intrinsics.checkNotNullParameter(null, "<this>");
        return new ArrayList(null);
    }

    @Override // nuc.a
    public final Object j(Object r100) {
        ArrayList r101 = (ArrayList) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101;
    }

    @Override // nuc.a
    public final void c(Object r100, int r101) {
        ArrayList r102 = (ArrayList) r100;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        r102.ensureCapacity(r101);
    }

    public void insert(ArrayList<E> r100, int r101, E r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ListProtector.add(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nuc.v
    public /* bridge */ /* synthetic */ void insert(Object r100, int r101, Object r102) {
        insert((ArrayList) r100, r101, r102);
    }
}
