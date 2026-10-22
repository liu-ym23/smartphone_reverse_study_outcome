package ss;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f543305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f543306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f543307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f543308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f543309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f543310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ e f543311g;

    public f(e r100) {
        this.f543311g = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = r101.getAction();
        if (r102 == 0) goto L59;
        boolean r103 = true;
        if (r102 == 1) goto L33;
        if (r102 != 2) goto L66;
        this.f543307c = r101.getRawX() - this.f543305a;
        this.f543308d = r101.getRawY() - this.f543306b;
        if (Math.abs(this.f543307c) <= 0.0f) goto L11;
    L14:
        if (r103 == false) goto L32;
        e r104 = this.f543311g;
        d r105 = r104.f543287a;
        int r106 = (int) (r105.f543284d + this.f543307c);
        this.f543309e = r106;
        this.f543310f = (int) (r105.f543285e + this.f543308d);
        i.a r107 = r104.f543288b;
        if (r107.f543329n == false) goto L29;
        int r108 = r107.f543323h;
        if (r106 >= r108) goto L20;
        this.f543309e = r108;
    L20:
        int r109 = this.f543309e;
        int r110 = r104.f543299m - r100.getWidth();
        e r111 = this.f543311g;
        int r112 = r111.f543288b.f543324i;
        if (r109 <= (r110 - r112)) goto L23;
        this.f543309e = (r111.f543299m - r112) - r100.getWidth();
    L23:
        int r113 = this.f543310f;
        this.f543311g.f543288b.getClass();
        if (r113 >= 0) goto L26;
        this.f543311g.f543288b.getClass();
        this.f543310f = 0;
    L26:
        int r114 = this.f543310f;
        int r115 = this.f543311g.f543300n - r100.getHeight();
        this.f543311g.f543288b.getClass();
        if (r114 <= (r115 - 0)) goto L29;
        e r116 = this.f543311g;
        int r117 = r116.f543300n;
        r116.f543288b.getClass();
        this.f543310f = (r117 - 0) - r100.getHeight();
    L29:
        e r118 = this.f543311g;
        if (r118.f543288b.f543322g == 5) goto L32;
        r118.f543287a.a(this.f543309e, this.f543310f);
        this.f543311g.f543288b.getClass();
    L32:
        this.f543305a = r101.getRawX();
        this.f543306b = r101.getRawY();
        goto L66
    L11:
        if (Math.abs(this.f543308d) > 0.0f) goto L14;
        r103 = false;
    L66:
        return this.f543311g.f543295i;
    L33:
        this.f543311g.f543293g = r101.getRawX();
        this.f543311g.f543294h = r101.getRawY();
        e r119 = this.f543311g;
        float r120 = Math.abs(r119.f543293g - r119.f543291e);
        e r121 = this.f543311g;
        if (r120 <= r121.f543296j) goto L36;
    L39:
        boolean r122 = true;
    L40:
        r119.f543295i = r122;
        e r123 = this.f543311g;
        i.a r124 = r123.f543288b;
        int r125 = r124.f543322g;
        if (r125 == 3) goto L47;
        if (r125 != 4) goto L66;
        ValueAnimator r126 = ObjectAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("x", new int[]{r123.f543287a.f543284d, r124.f543320e}), PropertyValuesHolder.ofInt("y", new int[]{r123.f543287a.f543285e, r123.f543288b.f543321f})});
        r123.f543289c = r126;
        r126.addUpdateListener(new g(r123));
        r123.e();
        goto L66
    L47:
        if (r123.f543295i == false) goto L66;
        int r127 = r123.f543287a.f543284d;
        if (((r127 * 2) + r100.getWidth()) <= UIUtils.getScreenWidth(r123.f543288b.f543316a)) goto L51;
        int r128 = (UIUtils.getScreenWidth(r123.f543288b.f543316a) - r100.getWidth()) - r123.f543302p;
    L52:
        int r129 = r123.f543287a.f543285e;
        if (r129 >= 0) goto L56;
    L58:
        ValueAnimator r130 = ObjectAnimator.ofInt(new int[]{r127, r128});
        r123.f543289c = r130;
        r130.addUpdateListener(new h(r123));
        r123.e();
        goto L66
    L56:
        if (r129 <= (y0.f() - 0)) goto L58;
        y0.f();
        goto L58
    L51:
        r128 = r123.f543301o;
        goto L52
    L36:
        if (Math.abs(r121.f543294h - r121.f543292f) > this.f543311g.f543296j) goto L39;
        r122 = false;
        goto L40
    L59:
        this.f543311g.f543291e = r101.getRawX();
        this.f543311g.f543292f = r101.getRawY();
        this.f543305a = r101.getRawX();
        this.f543306b = r101.getRawY();
        e r131 = this.f543311g;
        ValueAnimator r132 = r131.f543289c;
        if (r132 != null) goto L62;
    L64:
        e r133 = this.f543311g;
        r133.f543300n = UIUtils.getScreenHeight(r133.f543288b.f543316a);
        e r134 = this.f543311g;
        r134.f543299m = UIUtils.getScreenWidth(r134.f543288b.f543316a);
        goto L66
    L62:
        if (r132.isRunning() == false) goto L64;
        r131.f543289c.cancel();
        goto L64
    }
}
