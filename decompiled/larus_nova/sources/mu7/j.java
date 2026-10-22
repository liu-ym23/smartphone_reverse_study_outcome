package mu7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f515811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f515812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f515813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f515814d;

    public final synchronized void a() {
        monitor-enter(this);
        this.f515813c = true;     // Catch: Throwable -> L7
        this.f515814d.a();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final int hashCode() {
        int r100 = this.f515811a.hashCode() * 31;
        String r101 = this.f515812b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "Step(" + this.f515811a + ", " + this.f515812b + ')';
    }

    public j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f515811a = r100;
        this.f515812b = null;
        this.f515814d = new b();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof j) == false) goto L10;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f515811a, r101.f515811a) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(this.f515812b, r101.f515812b) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}
