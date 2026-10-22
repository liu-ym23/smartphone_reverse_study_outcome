package nuc;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
public final class p2 implements luc.f, n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final luc.f f520754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f520755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f520756c;

    @Override // luc.f
    public final boolean a() {
        return true;
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final String b(int r100) {
        return this.f520754a.b(r100);
    }

    @Override // luc.f
    public final int d() {
        return this.f520754a.d();
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final List<Annotation> e(int r100) {
        return this.f520754a.e(r100);
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final int g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f520754a.g(r100);
    }

    @Override // luc.f
    public final List<Annotation> getAnnotations() {
        return this.f520754a.getAnnotations();
    }

    @Override // luc.f
    public final luc.o getKind() {
        return this.f520754a.getKind();
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final luc.f h(int r100) {
        return this.f520754a.h(r100);
    }

    @Override // luc.f
    @ExperimentalSerializationApi
    public final boolean i(int r100) {
        return this.f520754a.i(r100);
    }

    @Override // luc.f
    public final boolean isInline() {
        return this.f520754a.isInline();
    }

    public final int hashCode() {
        return this.f520754a.hashCode() * 31;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f520754a);
        r100.append('?');
        return r100.toString();
    }

    @Override // nuc.n
    public final Set<String> c() {
        return this.f520756c;
    }

    @Override // luc.f
    public final String f() {
        return this.f520755b;
    }

    public p2(luc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f520754a = r100;
        this.f520755b = r100.f() + '?';
        this.f520756c = a2.a(r100);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p2) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f520754a, ((p2) r100).f520754a) == true) goto L11;
        return false;
    L11:
        return true;
    }
}
