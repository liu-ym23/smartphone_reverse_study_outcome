package nuc;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class j1 implements luc.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final luc.f f520717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final luc.f f520718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f520719d;

    @Override // luc.f
    public final boolean a() {
        return false;
    }

    @Override // luc.f
    public final boolean isInline() {
        return false;
    }

    public final int hashCode() {
        return (((this.f520716a.hashCode() * 31) + this.f520717b.hashCode()) * 31) + this.f520718c.hashCode();
    }

    public final String toString() {
        return this.f520716a + '(' + this.f520717b + ", " + this.f520718c + ')';
    }

    @Override // luc.f
    public final List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // luc.f
    public final int d() {
        return this.f520719d;
    }

    @Override // luc.f
    public final String f() {
        return this.f520716a;
    }

    @Override // luc.f
    public final luc.o getKind() {
        return luc.p.c.f510879a;
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
        throw new IllegalArgumentException(("Illegal index " + r100 + ", " + this.f520716a + " expects only non-negative indices").toString());
    L4:
        r101 = false;
        goto L5
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j1) == true) goto L8;
        return false;
    L8:
        j1 r101 = (j1) r100;
        if (Intrinsics.areEqual(this.f520716a, r101.f520716a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520717b, r101.f520717b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f520718c, r101.f520718c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // luc.f
    public final int g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        throw new IllegalArgumentException(r100 + " is not a valid map index");
    }

    @Override // luc.f
    public final luc.f h(int r100) {
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L16;
        int r102 = r100 % 2;
        if (r102 == 0) goto L14;
        if (r102 != 1) goto L12;
        return this.f520718c;
    L12:
        throw new IllegalStateException("Unreached".toString());
    L14:
        return this.f520717b;
    L16:
        throw new IllegalArgumentException(("Illegal index " + r100 + ", " + this.f520716a + " expects only non-negative indices").toString());
    L5:
        r101 = false;
        goto L6
    }

    @Override // luc.f
    public final boolean i(int r100) {
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return false;
    L9:
        throw new IllegalArgumentException(("Illegal index " + r100 + ", " + this.f520716a + " expects only non-negative indices").toString());
    L5:
        r101 = false;
        goto L6
    }

    public j1(String r100, luc.f r101, luc.f r102) {
        this.f520716a = r100;
        this.f520717b = r101;
        this.f520718c = r102;
        this.f520719d = 2;
    }
}
