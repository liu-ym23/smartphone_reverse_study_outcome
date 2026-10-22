package xt3;

import android.util.Pair;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements vu3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f565069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f565070b;

    /* JADX INFO: renamed from: xt3.a$a, reason: collision with other inner class name */
    public static final class C8273a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f565071a = null;

        static {
            f565071a = new a();
        }
    }

    public a() {
        this.f565069a = -1.0d;
        this.f565070b = -1.0d;
        new Pair(0L, new LinkedList());
        new Pair(0L, new LinkedList());
    }

    @Override // vu3.a
    public final double getCpuRate() {
        return this.f565069a;
    }

    @Override // vu3.a
    public final double getCpuSpeed() {
        return this.f565070b;
    }

    public final synchronized void a(LinkedList<vu3.a.C8043a> r100) {
        monitor-enter(this);
        new Pair(Long.valueOf(System.currentTimeMillis()), r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
