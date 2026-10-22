package com.vivo.push.restructure;

import android.content.Context;
import com.vivo.push.k;
import com.vivo.push.restructure.a.a.d;
import com.vivo.push.restructure.b.b;
import com.vivo.push.restructure.b.f;
import com.vivo.push.util.z;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f462436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.vivo.push.restructure.c.a f462437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f462438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.vivo.push.restructure.b.a f462439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f462440e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.vivo.push.c.a f462441f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private k f462442g;

    /* JADX INFO: renamed from: com.vivo.push.restructure.a$a, reason: collision with other inner class name */
    public static class C5551a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static a f462443a;

        static {
            f462443a = new a(0);
        }
    }

    public final synchronized Context b() {
        monitor-enter(this);
        Context r100 = this.f462436a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized com.vivo.push.restructure.b.a e() {
        monitor-enter(this);
        com.vivo.push.restructure.b.a r100 = this.f462439d;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    private a() {
    }

    public static a a() {
        return C5551a.f462443a;
    }

    public final com.vivo.push.restructure.c.a c() {
        return this.f462437b;
    }

    public final d d() {
        return this.f462438c;
    }

    public final b f() {
        return this.f462440e;
    }

    public final com.vivo.push.c.a g() {
        return this.f462441f;
    }

    public final k h() {
        return this.f462442g;
    }

    public /* synthetic */ a(byte r100) {
        this();
    }

    public final synchronized void a(Context r100) {
        monitor-enter(this);
        if (r100 != null) goto L14;
        monitor-exit(this);
        return;
    L14:
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f462436a != null) goto L9;
        this.f462436a = r100;     // Catch: Throwable -> L11
        com.vivo.push.restructure.b.d r101 = new com.vivo.push.restructure.b.d(new z(r100));     // Catch: Throwable -> L11
        this.f462439d = r101;     // Catch: Throwable -> L11
        this.f462437b = new com.vivo.push.restructure.c.b(r101);     // Catch: Throwable -> L11
        this.f462438c = new d();     // Catch: Throwable -> L11
        this.f462440e = new f();     // Catch: Throwable -> L11
        com.vivo.push.c.a r102 = new com.vivo.push.c.a(r100);     // Catch: Throwable -> L11
        this.f462441f = r102;     // Catch: Throwable -> L11
        this.f462442g = new com.vivo.push.z(r102, e());     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
    }
}
