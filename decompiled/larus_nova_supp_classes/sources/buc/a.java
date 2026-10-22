package buc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static final AtomicIntegerFieldUpdater<a> b = null;
    private volatile int _value;
    public final f a;

    /* JADX INFO: renamed from: buc.a$a, reason: collision with other inner class name */
    public static final class C0002a {
    }

    static {
        b = AtomicIntegerFieldUpdater.newUpdater(a.class, "_value");
    }

    public final boolean c() {
        if (this._value == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        return String.valueOf(c());
    }

    public final boolean b(boolean r5) {
        int r0 = b.getAndSet(this, r5 ? 1 : 0);
        f r1 = this.a;
        if (r1 == f.a.a) goto L6;
        r1.getClass();
        f.a("getAndSet(" + r5 + "):" + r0);
    L6:
        if (r0 == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public final void d(boolean r4) {
        this._value = r4 ? 1 : 0;
        f r0 = this.a;
        if (r0 == f.a.a) goto L6;
        r0.getClass();
        f.a("set(" + r4 + ')');
        return;
    }

    public a(boolean r2, f.a r3) {
        Intrinsics.checkNotNullParameter(r3, "trace");
        this.a = r3;
        this._value = r2 ? 1 : 0;
    }

    public final boolean a(boolean r5, boolean r6) {
        boolean r0 = b.compareAndSet(this, r5 ? 1 : 0, r6 ? 1 : 0);
        if (r0 == false) goto L7;
        f r1 = this.a;
        if (r1 == f.a.a) goto L7;
        r1.getClass();
        f.a("CAS(" + r5 + ", " + r6 + ')');
    L7:
        return r0;
    }
}
