package s95;

import android.content.Context;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f541068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f541069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScaleGestureDetector f541070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VelocityTracker f541071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f541072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f541073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f541074g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f541075h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f541076i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f541077j;

    public final void a(MotionEvent r210) {
        int r100 = r210.getAction() & 255;
        int r101 = 0;
        if (r100 == 0) goto L95;
        int r102 = 1;
        if (r100 != 1) goto L7;
        this.f541068a = -1;
        if (this.f541072e == true) goto L66;
    L92:
        VelocityTracker r103 = this.f541071d;
        if (r103 == null) goto L106;
        r103.recycle();
        this.f541071d = null;
    L106:
        int r104 = this.f541068a;
        if (r104 == (-1)) goto L109;
        r101 = r104;
    L109:
        this.f541069b = r210.findPointerIndex(r101);
        return;
    L66:
        if (this.f541071d == null) goto L92;
        float r105 = r210.getX(this.f541069b);     // Catch: Exception -> L69
    L70:
        this.f541073f = r105;
        float r106 = r210.getY(this.f541069b);     // Catch: Exception -> L73
    L74:
        this.f541074g = r106;
        this.f541071d.addMovement(r210);
        this.f541071d.computeCurrentVelocity(1000);
        float r107 = this.f541071d.getXVelocity();
        float r108 = this.f541071d.getYVelocity();
        if (Math.max(Math.abs(r107), Math.abs(r108)) < this.f541076i) goto L92;
        j.a r109 = (j.a) this.f541077j;
        j r110 = r109.f541104a;
        r110.f541098u = new j.f(r110, r110.f541085h.getContext());
        j r111 = r109.f541104a;
        j.f r112 = r111.f541098u;
        int r113 = j.f(r111.f541085h);
        ImageView r114 = r109.f541104a.f541085h;
        int r115 = (r114.getHeight() - r114.getPaddingTop()) - r114.getPaddingBottom();
        int r116 = (int) (-r107);
        int r117 = (int) (-r108);
        RectF r118 = r112.f541117d.c();
        if (r118 == null) goto L91;
        int r119 = Math.round(-r118.left);
        float r120 = r113;
        if (r120 >= r118.width()) goto L82;
        int r121 = Math.round(r118.width() - r120);
        int r122 = 0;
    L83:
        int r123 = Math.round(-r118.top);
        float r124 = r115;
        if (r124 >= r118.height()) goto L86;
        int r125 = Math.round(r118.height() - r124);
        int r126 = 0;
    L87:
        r112.f541115b = r119;
        r112.f541116c = r123;
        if (r119 != r121) goto L90;
        if (r123 == r125) goto L91;
    L90:
        r112.f541114a.fling(r119, r123, r116, r117, r122, r121, r126, r125, 0, 0);
        goto L91
    L86:
        r125 = r123;
        r126 = r125;
        goto L87
    L82:
        r121 = r119;
        r122 = r121;
    L91:
        j r127 = r109.f541104a;
        r127.f541085h.post(r127.f541098u);
        r109.f541104a.h();
    L73:
        r106 = r210.getY();
    L69:
        r105 = r210.getX();
        goto L70
    L7:
        if (r100 != 2) goto L9;
        float r128 = r210.getX(this.f541069b);     // Catch: Exception -> L24
    L121:
        float r129 = r210.getY(this.f541069b);     // Catch: Exception -> L27
    L28:
        float r130 = r128 - this.f541073f;
        float r131 = r129 - this.f541074g;
        if (this.f541072e == true) goto L36;
        if (Math.sqrt((r130 * r130) + (r131 * r131)) < this.f541075h) goto L33;
        boolean r132 = true;
    L34:
        this.f541072e = r132;
        goto L36
    L33:
        r132 = false;
    L36:
        if (this.f541072e == false) goto L106;
        j.a r133 = (j.a) this.f541077j;
        if (r133.f541104a.f541087j.f541070c.isInProgress() == true) goto L60;
        r133.f541104a.getClass();
        r133.f541104a.f541090m.postTranslate(r130, r131);
        r133.f541104a.a();
        ViewParent r134 = r133.f541104a.f541085h.getParent();
        j r135 = r133.f541104a;
        if (r135.f541083f == true) goto L43;
    L57:
        if (r134 == null) goto L59;
        r134.requestDisallowInterceptTouchEvent(true);
    L59:
        r133.f541104a.h();
        goto L60
    L43:
        if (r135.f541087j.f541070c.isInProgress() == true) goto L57;
        j r136 = r133.f541104a;
        if (r136.f541084g == true) goto L57;
        RectF r137 = r136.c();
        if (r137 == null) goto L59;
        if (r134 == null) goto L59;
        int r138 = (int) r137.left;
        int r139 = (int) r137.right;
        int r140 = j.f(r133.f541104a.f541085h);
        if (r138 >= 0) goto L52;
    L53:
        if (r139 > r140) goto L59;
        if (r130 >= 0.0f) goto L59;
    L56:
        r134.requestDisallowInterceptTouchEvent(false);
        goto L59
    L52:
        if (r130 > 0.0f) goto L56;
    L60:
        this.f541073f = r128;
        this.f541074g = r129;
        VelocityTracker r141 = this.f541071d;
        if (r141 == null) goto L106;
        r141.addMovement(r210);
    L27:
        r129 = r210.getY();
    L24:
        r128 = r210.getX();
        goto L121
    L9:
        if (r100 != 3) goto L11;
        this.f541068a = -1;
        VelocityTracker r142 = this.f541071d;
        if (r142 == null) goto L106;
        r142.recycle();
        this.f541071d = null;
        goto L106
    L11:
        if (r100 != 6) goto L106;
        int r143 = (r210.getAction() & 65280) >> 8;
        if (r210.getPointerId(r143) != this.f541068a) goto L106;
        if (r143 == 0) goto L18;
        r102 = 0;
    L18:
        this.f541068a = r210.getPointerId(r102);
        this.f541073f = r210.getX(r102);
        this.f541074g = r210.getY(r102);
        goto L106
    L95:
        this.f541068a = r210.getPointerId(0);
        VelocityTracker r144 = VelocityTracker.obtain();
        this.f541071d = r144;
        if (r144 == null) goto L113;
        r144.addMovement(r210);
    L113:
        float r145 = r210.getX(this.f541069b);     // Catch: Exception -> L100
    L101:
        this.f541073f = r145;
        float r146 = r210.getY(this.f541069b);     // Catch: Exception -> L104
    L105:
        this.f541074g = r146;
        this.f541072e = false;
    L104:
        r146 = r210.getY();
    L100:
        r145 = r210.getX();
        goto L101
    }

    public b(Context r100, j.a r101) {
        this.f541068a = -1;
        this.f541069b = 0;
        ViewConfiguration r102 = ViewConfiguration.get(r100);
        this.f541076i = r102.getScaledMinimumFlingVelocity();
        this.f541075h = r102.getScaledTouchSlop();
        this.f541077j = r101;
        this.f541070c = new ScaleGestureDetector(r100, new a(this));
    }
}
