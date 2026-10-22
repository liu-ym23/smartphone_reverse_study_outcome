package rx1;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: classes8.dex */
public final class h implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f539771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f539772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f539773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f539774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f539775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f539776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g f539777g;

    public h(g r100) {
        this.f539777g = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r110, MotionEvent r111) {
        int r100 = r111.getAction();
        if (r100 == 0) goto L78;
        boolean r101 = false;
        if (r100 == 1) goto L34;
        if (r100 != 2) goto L85;
        this.f539773c = r111.getRawX() - this.f539771a;
        this.f539774d = r111.getRawY() - this.f539772b;
        if (Math.abs(this.f539773c) <= 0.0f) goto L11;
    L12:
        r101 = true;
    L13:
        if (r101 == false) goto L33;
        g r102 = this.f539777g;
        f r103 = r102.f539751a;
        int r104 = (int) (r103.f539748d + this.f539773c);
        this.f539775e = r104;
        this.f539776f = (int) (r103.f539749e + this.f539774d);
        l.a r105 = r102.f539752b;
        if (r105.f539802t == false) goto L28;
        int r106 = r105.f539788f;
        if (r104 >= r106) goto L19;
        this.f539775e = r106;
    L19:
        int r107 = this.f539775e;
        int r108 = r102.f539763m - r110.getWidth();
        g r109 = this.f539777g;
        int r112 = r109.f539752b.f539789g;
        if (r107 <= (r108 - r112)) goto L22;
        this.f539775e = (r109.f539763m - r112) - r110.getWidth();
    L22:
        int r113 = this.f539776f;
        g r114 = this.f539777g;
        int r115 = r114.f539752b.f539790h;
        if (r113 >= r115) goto L25;
        this.f539776f = r115;
    L25:
        int r116 = this.f539776f;
        int r117 = r114.f539764n - r110.getHeight();
        g r118 = this.f539777g;
        int r119 = r118.f539752b.f539791i;
        if (r116 <= (r117 - r119)) goto L28;
        this.f539776f = (r118.f539764n - r119) - r110.getHeight();
    L28:
        g r120 = this.f539777g;
        if (r120.f539752b.f539787e == 5) goto L33;
        r120.f539751a.a(this.f539775e, this.f539776f);
        e r121 = this.f539777g.f539752b.f539801s;
        if (r121 == null) goto L33;
        r121.d();
    L33:
        this.f539771a = r111.getRawX();
        this.f539772b = r111.getRawY();
        goto L85
    L11:
        if (Math.abs(this.f539774d) <= 0.0f) goto L13;
    L85:
        return this.f539777g.f539759i;
    L34:
        this.f539777g.f539757g = r111.getRawX();
        this.f539777g.f539758h = r111.getRawY();
        g r122 = this.f539777g;
        float r123 = Math.abs(r122.f539757g - r122.f539755e);
        g r124 = this.f539777g;
        if (r123 <= r124.f539760j) goto L37;
    L40:
        boolean r125 = true;
    L41:
        r122.f539759i = r125;
        g r126 = this.f539777g;
        l.a r127 = r126.f539752b;
        int r128 = r127.f539787e;
        if (r128 == 3) goto L48;
        if (r128 != 4) goto L69;
        PropertyValuesHolder r129 = PropertyValuesHolder.ofInt("x", new int[]{r126.f539751a.f539748d, 0});
        r126.f539752b.getClass();
        ValueAnimator r130 = ObjectAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{r129, PropertyValuesHolder.ofInt("y", new int[]{r126.f539751a.f539749e, 0})});
        r126.f539753c = r130;
        r130.addUpdateListener(new i(r126));
        r126.f();
    L69:
        if (r126.f539759i == true) goto L74;
        e r131 = r127.f539801s;
        if (r131 == null) goto L74;
        r131.onClick();
    L74:
        if (r126.f539759i == false) goto L85;
        e r132 = r126.f539752b.f539801s;
        if (r132 == null) goto L85;
        r132.a();
        goto L85
    L48:
        if (r126.f539759i == false) goto L69;
        int r133 = r126.f539751a.f539748d;
        if (((r133 * 2) + r110.getWidth()) <= UIUtils.getScreenWidth(r126.f539752b.f539783a)) goto L52;
        int r134 = (UIUtils.getScreenWidth(r126.f539752b.f539783a) - r110.getWidth()) - r126.f539766p;
    L53:
        int r135 = r126.f539751a.f539749e;
        int r136 = r126.f539767q;
        if (r135 < r136) goto L61;
        if (r135 <= (s1.w() - r126.f539768r)) goto L59;
        r136 = s1.w() - r126.f539768r;
        goto L61
    L59:
        r136 = r135;
    L61:
        if (r126.f539768r == 0) goto L63;
    L64:
        if (r135 == r136) goto L66;
        ValueAnimator r137 = ObjectAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("x", new int[]{r133, r134}), PropertyValuesHolder.ofInt("y", new int[]{r135, r136})});
        r126.f539753c = r137;
        r137.addUpdateListener(new j(r126));
    L67:
        r126.f();
    L66:
        ValueAnimator r138 = ObjectAnimator.ofInt(new int[]{r133, r134});
        r126.f539753c = r138;
        r138.addUpdateListener(new k(r126));
        goto L67
    L63:
        if (r126.f539767q == 0) goto L66;
    L52:
        r134 = r126.f539765o;
        goto L53
    L37:
        if (Math.abs(r124.f539758h - r124.f539756f) > this.f539777g.f539760j) goto L40;
        r125 = false;
        goto L41
    L78:
        this.f539777g.f539755e = r111.getRawX();
        this.f539777g.f539756f = r111.getRawY();
        this.f539771a = r111.getRawX();
        this.f539772b = r111.getRawY();
        g r139 = this.f539777g;
        ValueAnimator r140 = r139.f539753c;
        if (r140 != null) goto L81;
    L83:
        g r141 = this.f539777g;
        r141.f539764n = UIUtils.getScreenHeight(r141.f539752b.f539783a);
        g r142 = this.f539777g;
        r142.f539763m = UIUtils.getScreenWidth(r142.f539752b.f539783a);
        goto L85
    L81:
        if (r140.isRunning() == false) goto L83;
        r139.f539753c.cancel();
        goto L83
    }
}
