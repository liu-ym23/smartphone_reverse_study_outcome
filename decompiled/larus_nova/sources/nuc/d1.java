package nuc;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
@ExperimentalSerializationApi
public abstract class d1 implements luc.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final luc.f f520658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f520659b;

    @Override // luc.f
    public final boolean a() {
        return false;
    }

    @Override // luc.f
    public final boolean isInline() {
        return false;
    }

    public final int hashCode() {
        return (this.f520658a.hashCode() * 31) + f().hashCode();
    }

    public final String toString() {
        return f() + '(' + this.f520658a + ')';
    }

    @Override // luc.f
    public final List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // luc.f
    public final int d() {
        return this.f520659b;
    }

    @Override // luc.f
    public final luc.o getKind() {
        return luc.p.b.f510878a;
    }

    public d1(luc.f r100) {
        this.f520658a = r100;
        this.f520659b = 1;
    }

    @Override // luc.f
    public final String b(int r100) {
        return String.valueOf(r100);
    }

    @Override // luc.f
    public final List<Annotation> e(int r100) {
        if (r100 < 0) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == false) goto L9;
        return CollectionsKt.emptyList();
    L9:
        throw new IllegalArgumentException(("Illegal index " + r100 + ", " + f() + " expects only non-negative indices").toString());
    L4:
        r101 = false;
        goto L5
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d1) == true) goto L8;
        return false;
    L8:
        d1 r101 = (d1) r100;
        if (Intrinsics.areEqual(this.f520658a, r101.f520658a) == true) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(f(), r101.f()) == false) goto L13;
        return true;
    }

    @Override // luc.f
    public final int g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        throw new IllegalArgumentException(r100 + " is not a valid list index");
    }

    @Override // luc.f
    public final luc.f h(int r100) {
        if (r100 < 0) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == false) goto L9;
        return this.f520658a;
    L9:
        throw new IllegalArgumentException(("Illegal index " + r100 + ", " + f() + " expects only non-negative indices").toString());
    L4:
        r101 = false;
        goto L5
    }

    @Override // luc.f
    public final boolean i(int r100) {
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return false;
    L9:
        throw new IllegalArgumentException(("Illegal index " + r100 + ", " + f() + " expects only non-negative indices").toString());
    L5:
        r101 = false;
        goto L6
    }
}
