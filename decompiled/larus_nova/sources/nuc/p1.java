package nuc;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class p1 implements luc.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p1 f520751a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final luc.p.d f520752b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f520753c = null;

    public p1() {
    }

    @Override // luc.f
    public final boolean a() {
        return false;
    }

    @Override // luc.f
    public final int d() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // luc.f
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return "NothingSerialDescriptor";
    }

    static {
        f520751a = new p1();
        f520752b = luc.p.d.f510880a;
        f520753c = "kotlin.Nothing";
    }

    public final int hashCode() {
        return f520753c.hashCode() + (f520752b.hashCode() * 31);
    }

    @Override // luc.f
    public final List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // luc.f
    public final String f() {
        return f520753c;
    }

    @Override // luc.f
    public final luc.o getKind() {
        return f520752b;
    }

    @Override // luc.f
    public final String b(int r100) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // luc.f
    public final List<Annotation> e(int r100) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // luc.f
    public final int g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // luc.f
    public final luc.f h(int r100) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // luc.f
    public final boolean i(int r100) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }
}
