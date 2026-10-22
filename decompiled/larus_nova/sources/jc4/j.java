package jc4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public final class j extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f498118n;

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
    public final String g() {
        return "login";
    }

    @Override // jc4.a
    public int getType() {
        return 15;
    }

    public j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "toastContent");
        this.f498118n = r100;
    }
}
