package t98;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f545118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f545119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f545120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f545121d;

    public f(i r100) {
        d r101 = new d(0);
        c r102 = new c();
        b r103 = new e();
        Intrinsics.checkNotNullParameter(r100, "snapshotSource");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "policy");
        Intrinsics.checkNotNullParameter(r103, "clock");
        this.f545118a = r100;
        this.f545119b = r101;
        this.f545120c = r102;
        this.f545121d = r103;
    }
}
