package com.ss.ugc.live.barrage.util;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;

/* JADX INFO: loaded from: classes36.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f458150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f458151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f458152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f458153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f458154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f458155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f458156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f458157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f458158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f458159j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f458160k;

    public static final class a implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f458161a;

        public final String toString() {
            return "Scheduled " + this.f458161a;
        }

        public a(d r100) {
            this.f458161a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            d r101 = this.f458161a;
            if (r101.f458154e == false) goto L5;
            r101.f458154e = false;
            r101.f458152c = System.currentTimeMillis() - r101.f458153d;
            r101.b();
        L22:
            a r102 = this.f458161a.f458150a;
            if (r102 == null) goto L26;
            Choreographer.getInstance().postFrameCallback(r102);
            return;
        L26:
            return;
        L5:
            double r103 = System.currentTimeMillis() - r101.f458152c;
            if (r103 < 0) goto L22;
            int r104 = r101.f458157h;
            long r105 = (long) ((r103 * ((double) r104)) / ((double) r101.f458158i));
            boolean r106 = r101.f458159j;
            if (r106 == false) goto L12;
            r105 = r105 % ((long) r104);
        L12:
            if (r105 == r101.f458151b) goto L22;
            if (r106 == false) goto L16;
        L21:
            r101.f458151b = (int) r105;
            r101.b();
            goto L22
        L16:
            if (r105 < r104) goto L21;
            a r107 = r101.f458150a;
            if (r107 == null) goto L20;
            Choreographer.getInstance().removeFrameCallback(r107);
            r101.f458150a = null;
        L20:
            r101.f458155f.post(new c(r101));
            goto L22
        }
    }

    public abstract void a(int r100, int r101);

    public final void b() {
        if (this.f458160k == false) goto L5;
        int r100 = this.f458151b;
    L6:
        a(r100, this.f458157h);
        return;
    L5:
        r100 = (this.f458157h - this.f458151b) - 1;
        goto L6
    }

    public final void c() {
        if (this.f458158i != 0) goto L9;
        this.f458151b = this.f458157h - 1;
        b();
        a r100 = this.f458150a;
        if (r100 == null) goto L7;
        Choreographer.getInstance().removeFrameCallback(r100);
        this.f458150a = null;
    L7:
        this.f458155f.post(new c(this));
        return;
    L9:
        if (this.f458150a != null) goto L13;
        this.f458150a = new a(this);
        Choreographer.getInstance().postFrameCallback(this.f458150a);
        return;
    }

    public final String toString() {
        a r100 = this.f458150a;
        StringBuilder r101 = new StringBuilder("FrameAnimator '");
        r101.append(this.f458156g);
        r101.append("' @");
        r101.append(System.identityHashCode(this));
        if (r100 != null) goto L5;
        String r102 = " (stopped)";
    L6:
        r101.append(r102);
        return r101.toString();
    L5:
        r102 = " (running " + this.f458151b + '/' + this.f458157h + " frame)";
        goto L6
    }

    public d() {
        this.f458156g = "BarrageAnimator";
        this.f458157h = 60;
        this.f458158i = 1000;
        this.f458159j = true;
        this.f458160k = true;
        this.f458155f = new Handler(Looper.getMainLooper());
        this.f458151b = 0;
        this.f458153d = 0;
        this.f458154e = true;
    }
}
