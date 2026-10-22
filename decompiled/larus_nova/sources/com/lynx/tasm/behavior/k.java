package com.lynx.tasm.behavior;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes32.dex */
public final class k {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f382091n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f382092o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f382093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f382094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f382095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f382096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f382097e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f382098f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f382099g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MotionEvent f382100h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MotionEvent f382101i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f382102j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f382103k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f382104l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f382105m;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f382106a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != 1) goto L5;
            this.f382106a.f382095c.getClass();
            return;
        L5:
            if (r101 == 2) goto L14;
            if (r101 != 3) goto L13;
            k r102 = this.f382106a;
            b r103 = r102.f382096d;
            if (r103 != null) goto L10;
            return;
        L10:
            if (r102.f382097e == true) goto L18;
            r103.a();
            return;
        L18:
            return;
        L13:
            throw new RuntimeException("Unknown message " + r100);
        L14:
            k r104 = this.f382106a;
            r104.f382094b.removeMessages(3);
            r104.f382098f = true;
            c r105 = r104.f382095c;
            ((b1.c) r105).f381997a.o(r104.f382100h);
        }

        public a(k r100, Handler r101) {
            this.f382106a = r100;
            super(r101.getLooper());
        }
    }

    public interface b {
        void a();
    }

    public interface c {
    }

    public static class d implements c, b {
        public d() {
        }

        @Override // com.lynx.tasm.behavior.k.b
        public final void a() {
        }
    }

    public final void a() {
        this.f382094b.removeMessages(1);
        this.f382094b.removeMessages(2);
        this.f382094b.removeMessages(3);
        this.f382097e = false;
        this.f382099g = false;
        if (this.f382098f == false) goto L6;
        this.f382098f = false;
        return;
    }

    static {
        f382091n = ViewConfiguration.getLongPressTimeout();
        f382092o = ViewConfiguration.getTapTimeout();
    }

    public final void b(MotionEvent r100) {
        int r101 = r100.getAction();
        float r102 = r100.getY();
        float r103 = r100.getX();
        int r104 = r101 & 255;
        int r105 = 0;
        if (r104 != 0) goto L5;
        this.f382103k = r103;
        this.f382102j = r102;
        MotionEvent r106 = this.f382100h;
        if (r106 == null) goto L55;
        r106.recycle();
    L55:
        this.f382100h = MotionEvent.obtain(r100);
        this.f382099g = true;
        this.f382097e = true;
        this.f382098f = false;
        if (this.f382104l == false) goto L58;
        this.f382094b.removeMessages(2);
        this.f382094b.sendEmptyMessageAtTime(2, (this.f382100h.getDownTime() + ((long) f382092o)) + ((long) f382091n));
    L58:
        this.f382094b.sendEmptyMessageAtTime(1, this.f382100h.getDownTime() + ((long) f382092o));
        this.f382095c.getClass();
        return;
    L5:
        if (r104 == 1) goto L42;
        if (r104 == 2) goto L26;
        if (r104 != 3) goto L9;
        a();
        return;
    L9:
        if (r104 == 5) goto L22;
        if (r104 == 6) goto L14;
        return;
    L14:
        if (this.f382105m == true) goto L16;
        return;
    L16:
        if (r100.getPointerCount() == 2) goto L18;
        return;
    L18:
        if (((r101 & 65280) >> 8) != 0) goto L20;
        r105 = 1;
    L20:
        this.f382103k = r100.getX(r105);
        this.f382102j = r100.getY(r105);
        return;
    L22:
        if (this.f382105m == false) goto L63;
        a();
        return;
    L63:
        return;
    L26:
        if (this.f382098f == false) goto L28;
        return;
    L28:
        if (this.f382105m == true) goto L30;
    L32:
        float r107 = this.f382103k - r103;
        float r108 = this.f382102j - r102;
        if (this.f382099g == false) goto L38;
        int r109 = (int) (r103 - this.f382100h.getX());
        int r110 = (int) (r102 - this.f382100h.getY());
        if (((r109 * r109) + (r110 * r110)) <= this.f382093a) goto L67;
        this.f382095c.getClass();
        this.f382103k = r103;
        this.f382102j = r102;
        this.f382099g = false;
        this.f382094b.removeMessages(3);
        this.f382094b.removeMessages(1);
        this.f382094b.removeMessages(2);
        return;
    L67:
        return;
    L38:
        if (Math.abs(r107) < 1.0f) goto L40;
    L41:
        this.f382095c.getClass();
        this.f382103k = r103;
        this.f382102j = r102;
        return;
    L40:
        if (Math.abs(r108) >= 1.0f) goto L41;
        return;
    L30:
        if (r100.getPointerCount() <= 1) goto L32;
        return;
    L42:
        this.f382097e = false;
        MotionEvent r111 = MotionEvent.obtain(r100);
        if (this.f382098f == false) goto L46;
        this.f382094b.removeMessages(3);
        this.f382098f = false;
    L48:
        MotionEvent r112 = this.f382101i;
        if (r112 == null) goto L51;
        r112.recycle();
    L51:
        this.f382101i = r111;
        this.f382094b.removeMessages(1);
        this.f382094b.removeMessages(2);
        return;
    L46:
        if (this.f382099g == false) goto L48;
        this.f382095c.getClass();
        goto L48
    }

    public k(LynxContext r100, b1.c r101, Handler r102) {
        if (r100 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        this.f382094b = new a(this, r102);
        this.f382095c = r101;
        this.f382096d = r101;
        this.f382104l = true;
        this.f382105m = r103;
        if (r100 != null) goto L11;
        int r104 = ViewConfiguration.getTouchSlop();
    L12:
        this.f382093a = r104 * r104;
        return;
    L11:
        r104 = ViewConfiguration.get(r100).getScaledTouchSlop();
        goto L12
    L5:
        if (r100.getApplicationInfo().targetSdkVersion < 8) goto L7;
        r103 = true;
        goto L8
    }
}
