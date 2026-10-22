package eab;

import kotlin.jvm.internal.Intrinsics;
import v7b.f0;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class f extends s {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f471746j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f471747k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f471748l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f471749m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f471750n;

    @Override // v7b.s
    public final s h() {
        return new f(this.f471746j, this.f471747k, this.f471748l, this.f471749m, this.f471750n);
    }

    @Override // v7b.s
    public final void c(f0 r100) {
        if (r100 == null) goto L5;
        r100.a(this);
        return;
    }

    public f(String r100, String r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "token");
        this.f471746j = r100;
        this.f471747k = r101;
        this.f471748l = r102;
        this.f471749m = r103;
        this.f471750n = r104;
    }
}
