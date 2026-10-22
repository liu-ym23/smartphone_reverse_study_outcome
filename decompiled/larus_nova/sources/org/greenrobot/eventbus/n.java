package org.greenrobot.eventbus;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes42.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f525817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadMode f525818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class<?> f525819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f525820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f525821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f525822f;

    public synchronized void a() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f525822f != null) goto L6;
        StringBuilder r100 = new StringBuilder(64);     // Catch: Throwable -> L8
        r100.append(this.f525817a.getDeclaringClass().getName());     // Catch: Throwable -> L8
        r100.append('#');     // Catch: Throwable -> L8
        r100.append(this.f525817a.getName());     // Catch: Throwable -> L8
        r100.append('(');     // Catch: Throwable -> L8
        r100.append(this.f525819c.getName());     // Catch: Throwable -> L8
        this.f525822f = r100.toString();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public int hashCode() {
        return this.f525817a.hashCode();
    }

    public Method b() {
        return this.f525817a;
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == false) goto L9;
        a();
        n r101 = (n) r100;
        r101.a();
        return this.f525822f.equals(r101.f525822f);
    L9:
        return false;
    }

    public n(Method r100, Class<?> r101, ThreadMode r102, int r103, boolean r104) {
        this.f525817a = r100;
        this.f525818b = r102;
        this.f525819c = r101;
        this.f525820d = r103;
        this.f525821e = r104;
    }
}
