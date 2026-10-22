package s95;

import android.content.Context;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public int a;
    public int b;
    public final ScaleGestureDetector c;
    public VelocityTracker d;
    public boolean e;
    public float f;
    public float g;
    public final float h;
    public final float i;
    public final c j;

    public final void a(MotionEvent r24) {
        int r2 = r24.getAction() & 255;
        int r4 = 0;
        if (r2 == 0) goto L95;
        int r5 = 1;
        if (r2 != 1) goto L7;
        this.a = -1;
        if (this.e == true) goto L66;
    L92:
        VelocityTracker r3 = this.d;
        if (r3 == null) goto L106;
        r3.recycle();
        this.d = null;
    L106:
        int r6 = this.a;
        if (r6 == (-1)) goto L109;
        r4 = r6;
    L109:
        this.b = r24.findPointerIndex(r4);
        return;
    L66:
        if (this.d == null) goto L92;
        float r7 = r24.getX(this.b);     // Catch: Exception -> L69
    L70:
        this.f = r7;
        float r8 = r24.getY(this.b);     // Catch: Exception -> L73
    L74:
        this.g = r8;
        this.d.addMovement(r24);
        this.d.computeCurrentVelocity(UploadResult.UPLOAD_CACELL);
        float r9 = this.d.getXVelocity();
        float r10 = this.d.getYVelocity();
        if (Math.max(Math.abs(r9), Math.abs(r10)) < this.i) goto L92;
        j.a r11 = (j.a) this.j;
        j r12 = r11.a;
        r12.u = new j.f(r12, r12.h.getContext());
        j r13 = r11.a;
        j.f r14 = r13.u;
        int r16 = j.f(r13.h);
        ImageView r17 = r11.a.h;
        int r18 = (r17.getHeight() - r17.getPaddingTop()) - r17.getPaddingBottom();
        int r19 = (int) (-r9);
        int r20 = (int) (-r10);
        RectF r21 = r14.d.c();
        if (r21 == null) goto L91;
        int r110 = Math.round(-r21.left);
        float r22 = r16;
        if (r22 >= r21.width()) goto L82;
        int r23 = Math.round(r21.width() - r22);
        int r111 = 0;
    L83:
        int r112 = Math.round(-r21.top);
        float r113 = r18;
        if (r113 >= r21.height()) goto L86;
        int r26 = Math.round(r21.height() - r113);
        int r114 = 0;
    L87:
        r14.b = r110;
        r14.c = r112;
        if (r110 != r23) goto L90;
        if (r112 == r26) goto L91;
    L90:
        r14.a.fling(r110, r112, r19, r20, r111, r23, r114, r26, 0, 0);
        goto L91
    L86:
        r26 = r112;
        r114 = r26;
        goto L87
    L82:
        r23 = r110;
        r111 = r23;
    L91:
        j r27 = r11.a;
        r27.h.post(r27.u);
        r11.a.h();
    L73:
        r8 = r24.getY();
    L69:
        r7 = r24.getX();
        goto L70
    L7:
        if (r2 != 2) goto L9;
        float r28 = r24.getX(this.b);     // Catch: Exception -> L24
    L121:
        float r29 = r24.getY(this.b);     // Catch: Exception -> L27
    L28:
        float r30 = r28 - this.f;
        float r31 = r29 - this.g;
        if (this.e == true) goto L36;
        if (Math.sqrt((r30 * r30) + (r31 * r31)) < this.h) goto L33;
        boolean r32 = true;
    L34:
        this.e = r32;
        goto L36
    L33:
        r32 = false;
    L36:
        if (this.e == false) goto L106;
        j.a r33 = (j.a) this.j;
        if (r33.a.j.c.isInProgress() == true) goto L60;
        r33.a.getClass();
        r33.a.m.postTranslate(r30, r31);
        r33.a.a();
        ViewParent r34 = r33.a.h.getParent();
        j r115 = r33.a;
        if (r115.f == true) goto L43;
    L57:
        if (r34 == null) goto L59;
        r34.requestDisallowInterceptTouchEvent(true);
    L59:
        r33.a.h();
        goto L60
    L43:
        if (r115.j.c.isInProgress() == true) goto L57;
        j r116 = r33.a;
        if (r116.g == true) goto L57;
        RectF r36 = r116.c();
        if (r36 == null) goto L59;
        if (r34 == null) goto L59;
        int r117 = (int) r36.left;
        int r37 = (int) r36.right;
        int r118 = j.f(r33.a.h);
        if (r117 >= 0) goto L52;
    L53:
        if (r37 > r118) goto L59;
        if (r30 >= 0.0f) goto L59;
    L56:
        r34.requestDisallowInterceptTouchEvent(false);
        goto L59
    L52:
        if (r30 > 0.0f) goto L56;
    L60:
        this.f = r28;
        this.g = r29;
        VelocityTracker r38 = this.d;
        if (r38 == null) goto L106;
        r38.addMovement(r24);
    L27:
        r29 = r24.getY();
    L24:
        r28 = r24.getX();
        goto L121
    L9:
        if (r2 != 3) goto L11;
        this.a = -1;
        VelocityTracker r39 = this.d;
        if (r39 == null) goto L106;
        r39.recycle();
        this.d = null;
        goto L106
    L11:
        if (r2 != 6) goto L106;
        int r40 = (r24.getAction() & 65280) >> 8;
        if (r24.getPointerId(r40) != this.a) goto L106;
        if (r40 == 0) goto L18;
        r5 = 0;
    L18:
        this.a = r24.getPointerId(r5);
        this.f = r24.getX(r5);
        this.g = r24.getY(r5);
        goto L106
    L95:
        this.a = r24.getPointerId(0);
        VelocityTracker r41 = VelocityTracker.obtain();
        this.d = r41;
        if (r41 == null) goto L113;
        r41.addMovement(r24);
    L113:
        float r42 = r24.getX(this.b);     // Catch: Exception -> L100
    L101:
        this.f = r42;
        float r43 = r24.getY(this.b);     // Catch: Exception -> L104
    L105:
        this.g = r43;
        this.e = false;
    L104:
        r43 = r24.getY();
    L100:
        r42 = r24.getX();
        goto L101
    }

    public b(Context r3, j.a r4) {
        this.a = -1;
        this.b = 0;
        ViewConfiguration r0 = ViewConfiguration.get(r3);
        this.i = r0.getScaledMinimumFlingVelocity();
        this.h = r0.getScaledTouchSlop();
        this.j = r4;
        this.c = new ScaleGestureDetector(r3, new a(this));
    }
}
