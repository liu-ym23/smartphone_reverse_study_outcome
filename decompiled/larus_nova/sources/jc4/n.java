package jc4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public final class n extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f498124n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f498125o;

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
        return 18;
    }

    @Override // jc4.a
    public final String g() {
        return this.f498124n;
    }

    /* JADX INFO: renamed from: getType, reason: collision with other method in class */
    public final String m9444getType() {
        return this.f498124n;
    }

    public n(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "detail");
        this.f498124n = r100;
        this.f498125o = r101;
    }
}
