package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o extends g04.a<jz3.a> {
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a e;
    public final l14.c f;
    public final Handler g;
    public final long h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final b l;

    public static final class a implements Runnable {
        public final /* synthetic */ o a;
        public final /* synthetic */ com.bytedance.awemeopen.infra.base.player.g b;

        @Override // java.lang.Runnable
        public final void run() {
            o r0 = this.a;     // Catch: Throwable -> L7
            if (r0.i == false) goto L5;
            l14.c r1 = r0.f;     // Catch: Throwable -> L7
            this.b.getCurrentPosition();     // Catch: Throwable -> L7
            this.b.getDuration();     // Catch: Throwable -> L7
            r1.i();     // Catch: Throwable -> L7
        L5:
            o r2 = this.a;     // Catch: Throwable -> L7
            r2.g.postDelayed(this, r2.h);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public a(o r1, com.bytedance.awemeopen.infra.base.player.g r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements com.bytedance.awemeopen.infra.base.player.k {
        public final /* synthetic */ o a;

        public final void c(String r1) {
        }

        public final void d(String r1, long r2, int r4) {
        }

        public final void f(String r1, boolean r2, int r3, int r4) {
        }

        public final void g(String r1, boolean r2, String r3) {
        }

        public final void onPlayPrepare(String r1) {
        }

        public b(o r1) {
            this.a = r1;
        }

        public final void h(String r2) {
            com.bytedance.awemeopen.infra.base.player.g r3 = this.a.e.c.getPlayer();
            l14.c r0 = this.a.f;
            if (r0 == null) goto L5;
            r3.getCurrentPosition();
            r3.getDuration();
            r0.l();
        L5:
            this.a.i = false;
        }

        public final void onPlaying(String r3) {
            com.bytedance.awemeopen.infra.base.player.g r4 = this.a.e.c.getPlayer();
            o r0 = this.a;
            if (r0.k == false) goto L7;
            r0.k = false;
            l14.c r1 = r0.f;
            if (r1 == null) goto L10;
            r4.getDuration();
            r1.j();
        L10:
            this.a.i = true;
            return;
        L7:
            l14.c r2 = r0.f;
            if (r2 == null) goto L10;
            r4.getCurrentPosition();
            r4.getDuration();
            r2.m();
            goto L10
        }

        public final void l(String r4, final com.bytedance.awemeopen.infra.base.player.l r5) {
            Intrinsics.checkNotNullParameter(r5, "playerStatusInfo");
            final com.bytedance.awemeopen.infra.base.player.g r6 = this.a.e.c.getPlayer();
            l14.c r0 = this.a.f;
            if (r0 == null) goto L5;
            r6.getDuration();
            r0.a();
        L5:
            final o r1 = this.a;
            r1.g.postDelayed(new p(r1, r5, r6), r1.h);
        }

        public final void e(String r1, int r2, String r3) {
            this.a.i = false;
        }
    }

    @Override // g04.a
    public final void g() {
        if (this.j == true) goto L5;
        return;
    L5:
        if (this.f == null) goto L10;
        this.k = true;
        com.bytedance.awemeopen.infra.base.player.g r0 = this.e.c.getPlayer();
        this.e.c.addPlayStateListener(this.l);
        this.g.postDelayed(new a(this, r0), this.h);
        return;
    }

    @Override // g04.a
    public final void i() {
        if (this.j == true) goto L5;
        return;
    L5:
        if (this.f == null) goto L10;
        this.g.removeCallbacksAndMessages(null);
        this.e.c.removePlayStateListener(this.l);
        return;
    }

    @Override // g04.a
    public final void f(jz3.a r2) {
        jz3.a r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "data");
        d14.a r0 = b14.a.a;
        this.j = b14.a.a(l24.c.class).a(r3.a);
    }

    public o(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r2, l14.c r3) {
        Intrinsics.checkNotNullParameter(r2, "feedGroupParameters");
        super(r2.a);
        this.e = r2;
        this.f = r3;
        this.g = new Handler(Looper.getMainLooper());
        this.h = 250;
        this.k = true;
        this.l = new b(this);
    }
}
