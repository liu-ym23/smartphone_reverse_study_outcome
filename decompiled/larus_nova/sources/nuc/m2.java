package nuc;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class m2 implements luc.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final luc.e f520737b;

    @Override // luc.f
    public final boolean a() {
        return false;
    }

    @Override // luc.f
    public final int d() {
        return 0;
    }

    @Override // luc.f
    public final boolean isInline() {
        return false;
    }

    public final int hashCode() {
        return this.f520736a.hashCode() + (this.f520737b.hashCode() * 31);
    }

    public final String toString() {
        return "PrimitiveDescriptor(" + this.f520736a + ')';
    }

    @Override // luc.f
    public final List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // luc.f
    public final String f() {
        return this.f520736a;
    }

    @Override // luc.f
    public final luc.o getKind() {
        return this.f520737b;
    }

    @Override // luc.f
    public final String b(int r100) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // luc.f
    public final List<Annotation> e(int r100) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m2) == true) goto L8;
        return false;
    L8:
        m2 r101 = (m2) r100;
        if (Intrinsics.areEqual(this.f520736a, r101.f520736a) == true) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(this.f520737b, r101.f520737b) == false) goto L13;
        return true;
    }

    @Override // luc.f
    public final int g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // luc.f
    public final luc.f h(int r100) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // luc.f
    public final boolean i(int r100) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public m2(String r100, luc.e r101) {
        Intrinsics.checkNotNullParameter(r100, "serialName");
        Intrinsics.checkNotNullParameter(r101, "kind");
        this.f520736a = r100;
        this.f520737b = r101;
    }
}
