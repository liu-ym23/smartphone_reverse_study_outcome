package mu7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class j {
    public final String a;
    public final String b;
    public volatile boolean c;
    public final b d;

    public final synchronized void a() {
        monitor-enter(this);
        this.c = true;     // Catch: Throwable -> L7
        this.d.a();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "Step(" + this.a + ", " + this.b + ')';
    }

    public j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.a = r2;
        this.b = null;
        this.d = new b();
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof j) == false) goto L10;
        j r5 = (j) r4;
        if (Intrinsics.areEqual(this.a, r5.a) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(this.b, r5.b) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}
