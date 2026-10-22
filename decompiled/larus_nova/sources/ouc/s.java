package ouc;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class s implements luc.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f526861a;

    @Override // luc.f
    public final boolean a() {
        return false;
    }

    @Override // luc.f
    public final boolean isInline() {
        return false;
    }

    public final luc.f c() {
        return (luc.f) this.f526861a.getValue();
    }

    @Override // luc.f
    public final int d() {
        return c().d();
    }

    @Override // luc.f
    public final String f() {
        return c().f();
    }

    @Override // luc.f
    public final List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // luc.f
    public final luc.o getKind() {
        return c().getKind();
    }

    public s(Function0<? extends luc.f> r100) {
        this.f526861a = LazyKt.lazy(r100);
    }

    @Override // luc.f
    public final String b(int r100) {
        return c().b(r100);
    }

    @Override // luc.f
    public final List<Annotation> e(int r100) {
        return c().e(r100);
    }

    @Override // luc.f
    public final int g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return c().g(r100);
    }

    @Override // luc.f
    public final luc.f h(int r100) {
        return c().h(r100);
    }

    @Override // luc.f
    public final boolean i(int r100) {
        return c().i(r100);
    }
}
