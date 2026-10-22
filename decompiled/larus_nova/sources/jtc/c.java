package jtc;

import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f500389a;

    public final int hashCode() {
        return this.f500389a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "ArrayBasedTraceState{entries=" + this.f500389a + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // jtc.a
    public final List<String> a() {
        return this.f500389a;
    }

    public c(List<String> r100) {
        if (r100 == null) goto L7;
        this.f500389a = r100;
        return;
    L7:
        throw new NullPointerException("Null entries");
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        return this.f500389a.equals(((a) r100).a());
    }
}
