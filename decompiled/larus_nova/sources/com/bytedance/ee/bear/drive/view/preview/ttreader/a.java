package com.bytedance.ee.bear.drive.view.preview.ttreader;

import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f225206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PointF f225207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PointF f225208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f225209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f225210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HandlerC3239a f225211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f225212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f225213h;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.ttreader.a$a, reason: collision with other inner class name */
    public class HandlerC3239a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f225214a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            a r101 = this.f225214a;
            c r102 = r101.f225209d;
            if (r102 != null) goto L5;
            return;
        L5:
            int r103 = r100.what;
            if (r103 != 0) goto L8;
            r102.toggle();
            return;
        L8:
            if (r103 != 1) goto L10;
            r101.f225210e = System.currentTimeMillis();
            this.f225214a.f225209d.b();
            return;
        L10:
            if (r103 != 2) goto L18;
            r102.a();
            return;
        }

        public HandlerC3239a(a r100, Looper r101) {
            this.f225214a = r100;
            super(r101);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f225215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f225216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f225217c;

        public b() {
            this.f225215a = true;
            this.f225216b = true;
            this.f225217c = true;
        }

        public b(boolean r100, boolean r101) {
            this.f225215a = false;
            this.f225216b = r100;
            this.f225217c = r101;
        }
    }

    public interface c {
        void a();

        void b();

        void toggle();
    }

    public a() {
        this.f225210e = 0;
        this.f225211f = new HandlerC3239a(this, Looper.getMainLooper());
        this.f225212g = false;
        this.f225213h = new b();
    }

    public final void a(MotionEvent r100) {
        tt5.a.b("TTClickHelper", "onInterceptTouchEvent: " + r100);
        int r101 = r100.getAction();
        if (r101 != 0) goto L5;
        this.f225212g = false;
        this.f225206a = System.currentTimeMillis();
        this.f225207b = new PointF(r100.getX(), r100.getY());
        return;
    L5:
        if (r101 == 1) goto L26;
        if (r101 == 2) goto L9;
        return;
    L9:
        if (this.f225209d != null) goto L11;
        return;
    L11:
        if (this.f225212g == true) goto L55;
        this.f225211f.removeMessages(0);
        this.f225211f.removeMessages(1);
        this.f225211f.removeMessages(2);
        PointF r102 = this.f225207b;
        if (r102 == null) goto L56;
        float r103 = r102.y - r100.getY();
        if (Math.abs(r103) <= n.d(20)) goto L45;
        this.f225212g = true;
        if (r103 <= 0.0f) goto L24;
        if (this.f225213h.f225216b == false) goto L46;
        this.f225211f.sendEmptyMessage(1);
        return;
    L46:
        return;
    L24:
        if (this.f225213h.f225217c == false) goto L48;
        this.f225211f.sendEmptyMessage(2);
        return;
    L48:
        return;
    L45:
        return;
    L56:
        return;
    L55:
        return;
    L26:
        this.f225208c = new PointF(r100.getX(), r100.getY());
        long r104 = System.currentTimeMillis() - this.f225206a;
        if (this.f225209d == null) goto L57;
        this.f225211f.removeMessages(0);
        this.f225211f.removeMessages(1);
        this.f225211f.removeMessages(2);
        PointF r105 = this.f225207b;
        if (r105 == null) goto L50;
        PointF r106 = this.f225208c;
        if (r106 == null) goto L58;
        float r107 = Math.abs(r105.x - r106.x);
        float r108 = Math.abs(this.f225207b.y - this.f225208c.y);
        if (r104 <= 150) goto L37;
        return;
    L37:
        if (Math.max(r107, r108) <= 10.0f) goto L40;
        return;
    L40:
        if (this.f225213h.f225215a == false) goto L52;
        this.f225211f.sendEmptyMessageDelayed(0, 150);
        return;
    L52:
        return;
    L58:
        return;
    L50:
        return;
    }
}
