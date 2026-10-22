package com.bytedance.ee.bear.drive.view.preview.ttreader;

import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public long a;
    public PointF b;
    public PointF c;
    public c d;
    public long e;
    public final HandlerC0183a f;
    public boolean g;
    public b h;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.ttreader.a$a, reason: collision with other inner class name */
    public class HandlerC0183a extends Handler {
        public final /* synthetic */ a a;

        @Override // android.os.Handler
        public final void handleMessage(Message r4) {
            a r0 = this.a;
            c r1 = r0.d;
            if (r1 != null) goto L5;
            return;
        L5:
            int r5 = r4.what;
            if (r5 != 0) goto L8;
            r1.toggle();
            return;
        L8:
            if (r5 != 1) goto L10;
            r0.e = System.currentTimeMillis();
            this.a.d.b();
            return;
        L10:
            if (r5 != 2) goto L18;
            r1.a();
            return;
        }

        public HandlerC0183a(a r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static class b {
        public final boolean a;
        public final boolean b;
        public final boolean c;

        public b() {
            this.a = true;
            this.b = true;
            this.c = true;
        }

        public b(boolean r2, boolean r3) {
            this.a = false;
            this.b = r2;
            this.c = r3;
        }
    }

    public interface c {
        void a();

        void b();

        void toggle();
    }

    public a() {
        this.e = 0;
        this.f = new HandlerC0183a(this, Looper.getMainLooper());
        this.g = false;
        this.h = new b();
    }

    public final void a(MotionEvent r9) {
        tt5.a.b("TTClickHelper", "onInterceptTouchEvent: " + r9);
        int r0 = r9.getAction();
        if (r0 != 0) goto L5;
        this.g = false;
        this.a = System.currentTimeMillis();
        this.b = new PointF(r9.getX(), r9.getY());
        return;
    L5:
        if (r0 == 1) goto L26;
        if (r0 == 2) goto L9;
        return;
    L9:
        if (this.d != null) goto L11;
        return;
    L11:
        if (this.g == true) goto L55;
        this.f.removeMessages(0);
        this.f.removeMessages(1);
        this.f.removeMessages(2);
        PointF r1 = this.b;
        if (r1 == null) goto L56;
        float r2 = r1.y - r9.getY();
        if (Math.abs(r2) <= n.d(20)) goto L45;
        this.g = true;
        if (r2 <= 0.0f) goto L24;
        if (this.h.b == false) goto L46;
        this.f.sendEmptyMessage(1);
        return;
    L46:
        return;
    L24:
        if (this.h.c == false) goto L48;
        this.f.sendEmptyMessage(2);
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
        this.c = new PointF(r9.getX(), r9.getY());
        long r4 = System.currentTimeMillis() - this.a;
        if (this.d == null) goto L57;
        this.f.removeMessages(0);
        this.f.removeMessages(1);
        this.f.removeMessages(2);
        PointF r10 = this.b;
        if (r10 == null) goto L50;
        PointF r3 = this.c;
        if (r3 == null) goto L58;
        float r11 = Math.abs(r10.x - r3.x);
        float r5 = Math.abs(this.b.y - this.c.y);
        if (r4 <= 150) goto L37;
        return;
    L37:
        if (Math.max(r11, r5) <= 10.0f) goto L40;
        return;
    L40:
        if (this.h.a == false) goto L52;
        this.f.sendEmptyMessageDelayed(0, 150);
        return;
    L52:
        return;
    L58:
        return;
    L50:
        return;
    }
}
