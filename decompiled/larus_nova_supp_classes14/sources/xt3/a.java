package xt3;

import android.util.Pair;
import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements vu3.a {
    public double a;
    public double b;

    /* JADX INFO: renamed from: xt3.a$a, reason: collision with other inner class name */
    public static final class C0186a {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    public a() {
        this.a = -1.0d;
        this.b = -1.0d;
        new Pair(0L, new LinkedList());
        new Pair(0L, new LinkedList());
    }

    public final double getCpuRate() {
        return this.a;
    }

    public final double getCpuSpeed() {
        return this.b;
    }

    public final synchronized void a(LinkedList<vu3.a$a> r4) {
        monitor-enter(this);
        new Pair(Long.valueOf(System.currentTimeMillis()), r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
