package uga;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f550066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f550067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f550068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f550069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f550070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f550071f;

    public final boolean c() {
        Object r100 = this.f550067b;
        monitor-enter(r100);
        boolean r101 = false;
        if (this.f550071f == true) goto L10;
        this.f550071f = true;     // Catch: Throwable -> L12
        if (this.f550068c == true) goto L10;
        r101 = true;
    L10:
        monitor-exit(r100);
        return r101;
    L12:
        th = move-exception;
        throw th;
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "attemptId");
        this.f550066a = r100;
        this.f550067b = new Object();
    }

    public final void a(boolean r100) {
        Object r101 = this.f550067b;
        monitor-enter(r101);
        if (r100 == false) goto L19;
    L17:
        monitor-exit(r101);
        return;
    L19:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (this.f550071f == true) goto L17;
        int r102 = this.f550070e + 1;     // Catch: Throwable -> L14
        this.f550070e = r102;     // Catch: Throwable -> L14
        if (r102 >= RangesKt.coerceAtLeast(3, 1)) goto L11;
        this.f550069d = false;     // Catch: Throwable -> L14
    L11:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r101);
    }

    public final boolean b(boolean r100) {
        Object r101 = this.f550067b;
        monitor-enter(r101);
        boolean r102 = false;
        if (r100 == true) goto L19;
    L17:
        monitor-exit(r101);
        return r102;
    L19:
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.f550071f == true) goto L17;
        this.f550068c = true;     // Catch: Throwable -> L14
        if (this.f550069d == true) goto L17;
        this.f550069d = true;     // Catch: Throwable -> L14
        r102 = true;
        goto L17
    }
}
