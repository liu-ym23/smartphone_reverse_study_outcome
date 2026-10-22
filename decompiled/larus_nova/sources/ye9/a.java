package ye9;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f567422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f567423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f567424c;

    /* JADX INFO: renamed from: ye9.a$a, reason: collision with other inner class name */
    public static final class C8337a {
    }

    static {
    }

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f567422a, r101.f567422a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f567423b, r101.f567423b) == true) goto L15;
        return false;
    L15:
        if (this.f567424c == r101.f567424c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f567422a.hashCode() * 31) + this.f567423b.hashCode()) * 31) + this.f567424c;
    }

    public final String toString() {
        return "ProtocolContext(formatter=" + this.f567422a + ", encoders=" + this.f567423b + ", version=" + this.f567424c + ')';
    }

    public a(Object r100) {
        c.a r101 = new c.a();
        List<b> r102 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r101, "formatter");
        Intrinsics.checkNotNullParameter(r102, "encoders");
        this.f567422a = r101;
        this.f567423b = r102;
        this.f567424c = 1;
    }
}
