package com.bytedance.sync.v2.compensate;

import android.os.Handler;
import com.bytedance.sync.v2.protocal.BsyncProtocol;
import com.larus.apm.impl.protector.RunnableProtector;
import hg7.k;
import xf7.n;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Rotation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fg7.e f270395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n<Handler> f270396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f270397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f270398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f270399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f270400f;

    /* JADX INFO: loaded from: classes22.dex */
    public @interface Type {
        public static final int TYPE_POLL = 2;
        public static final int TYPE_SYNC = 1;
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rotation f270401a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f270401a.b();     // Catch: Throwable -> L4
            this.f270401a.e();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Rotation r100) {
            this.f270401a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f270402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f270403b;

        public b() {
        }
    }

    public abstract void a();

    public abstract void b();

    public abstract int c();

    public abstract boolean d(BsyncProtocol r100);

    public final void e() {
        if (this.f270395a.isForeground() == false) goto L5;
        long r100 = this.f270399e.f270402a;
    L6:
        long r101 = r100 * 1000;
        zf7.b.a(this.f270398d + "next time to request: " + (r101 / 1000) + "s");
        if (r101 >= 0) goto L9;
        return;
    L9:
        this.f270396b.b(new Object[0]).postDelayed(this.f270400f, r101);
        return;
    L5:
        r100 = this.f270399e.f270403b;
        goto L6
    }

    public final void f(boolean r100) {
        if (r100 == true) goto L4;
        b();
    L4:
        e();
    }

    public final void g(BsyncProtocol r100) {
        if (d(r100) == false) goto L6;
        zf7.b.a(this.f270398d + "receive data, do reset rotate");
        this.f270396b.b(new Object[0]).removeCallbacks(this.f270400f);
        e();
        return;
    }

    public Rotation(String r100, fg7.e r101, k r102, n<Handler> r103, b r104) {
        this.f270400f = new a(this);
        this.f270398d = r100;
        this.f270395a = r101;
        this.f270397c = r102;
        this.f270396b = r103;
        this.f270399e = r104;
    }
}
