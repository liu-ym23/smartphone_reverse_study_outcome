package com.xiaomi.push;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes41.dex */
public class aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<a> f463160a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final aw f463161a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f254a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f255a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f256a;

        static {
            f463161a = new aw();
        }

        public static /* synthetic */ aw a() {
            return f463161a;
        }

        public a(int r100, Object r101) {
            this.f254a = r100;
            this.f255a = r101;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m8826a() {
        if (this.f463160a.size() <= 100) goto L6;
        this.f463160a.removeFirst();
        return;
    }

    public aw() {
        this.f463160a = new LinkedList();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized LinkedList<a> m8828a() {
        monitor-enter(this);
        LinkedList<a> r100 = this.f463160a;     // Catch: Throwable -> L6
        this.f463160a = new LinkedList();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized int m8827a() {
        monitor-enter(this);
        int r100 = this.f463160a.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public static aw a() {
        return a.a();
    }

    public synchronized void a(Object r100) {
        monitor-enter(this);
        this.f463160a.add(new a(0, r100));     // Catch: Throwable -> L6
        m8826a();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
