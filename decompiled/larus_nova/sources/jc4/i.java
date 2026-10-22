package jc4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public final class i extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f498116n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f498117o;

    @Override // jc4.a
    public final void a(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "queryBuilder");
    }

    @Override // jc4.a
    public final int c() {
        return 6000;
    }

    @Override // jc4.a
    public final String e() {
        return "";
    }

    @Override // jc4.a
    public int getType() {
        return 16;
    }

    @Override // jc4.a
    public final boolean b() {
        return vb4.e.e();
    }

    @Override // jc4.a
    public final String g() {
        return this.f498117o;
    }

    /* JADX INFO: renamed from: getType, reason: collision with other method in class */
    public final String m9443getType() {
        return this.f498117o;
    }

    public i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "detail");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f498116n = r100;
        this.f498117o = r101;
    }
}
