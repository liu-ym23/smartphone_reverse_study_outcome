package rp9;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MotionEvent f538886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MotionEvent f538887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f538888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f538889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f538890e;

    /* JADX INFO: renamed from: rp9.a$a, reason: collision with other inner class name */
    public static final class C7514a {
    }

    static {
    }

    public final void b() {
        MotionEvent r100 = this.f538886a;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        r100.recycle();
        this.f538886a = null;
    L5:
        MotionEvent r101 = this.f538887b;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNull(r101);
        r101.recycle();
        this.f538887b = null;
    L8:
        this.f538890e = false;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
    }

    public final void a(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getAction() & 255;
        if (this.f538890e == true) goto L18;
        c r102 = (c) this;
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r101 == 0) goto L17;
        if (r101 != 2) goto L36;
        c.b r103 = r102.f538894f;
        MotionEvent r104 = r102.f538886a;
        if (r104 == null) goto L12;
        r104.getX();
    L12:
        MotionEvent r105 = r102.f538886a;
        if (r105 == null) goto L16;
        r105.getY();
    L16:
        r103.c(r102);
        r102.f538890e = true;
        return;
    L36:
        return;
    L17:
        r102.b();
        PointF r106 = r102.f538897i;
        r106.x = 0.0f;
        r106.y = 0.0f;
        r102.f538886a = MotionEvent.obtain(r100);
        r102.d(r100);
        return;
    L18:
        c r107 = (c) this;
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r101 == 1) goto L30;
        if (r101 == 2) goto L25;
        if (r101 == 3) goto L30;
        return;
    L25:
        if (r107.f538886a != null) goto L27;
        r107.f538886a = MotionEvent.obtain(r100);
    L27:
        r107.d(r100);
        if ((r107.f538888c / r107.f538889d) <= 0.67f) goto L34;
        r100.getPointerCount();
        r107.f538894f.b(r107);
        MotionEvent r108 = r107.f538886a;
        Intrinsics.checkNotNull(r108);
        r108.recycle();
        r107.f538886a = MotionEvent.obtain(r100);
        return;
    L34:
        return;
    L30:
        r107.f538894f.a(r107);
        r107.b();
    }
}
