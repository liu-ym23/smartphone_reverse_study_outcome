package ss;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.android.gamecp.business.floatwindow.FloatWindowLifecycle;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import java.util.HashMap;

/* JADX INFO: loaded from: classes44.dex */
public final class e extends ss.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f543287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i.a f543288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f543289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimeInterpolator f543290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f543291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f543292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f543293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f543294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f543295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f543296j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f543297k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f543298l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f543299m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f543300n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f543301o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f543302p;

    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f543303a;

        public final void a() {
            e r100 = this.f543303a;
            if (r100.f543288b.f543328m == false) goto L5;
        L10:
            this.f543303a.f543288b.getClass();
            return;
        L5:
            if (r100.f543297k == true) goto L10;
            if (r100.f543298l == false) goto L10;
            r100.d().setVisibility(4);
            r100.f543298l = false;
            r100.f543288b.getClass();
            goto L10
        }

        public a(e r100) {
            this.f543303a = r100;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f543304a;

        public b(e r100) {
            this.f543304a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f543304a.f543289c.removeAllUpdateListeners();
            this.f543304a.f543289c.removeAllListeners();
            e r101 = this.f543304a;
            r101.f543289c = null;
            r101.f543288b.getClass();
        }
    }

    @Override // ss.b
    public final void a() {
        String r100 = this.f543288b.f543327l;
        ((HashMap) i.f543314a).remove(r100);
        d r101 = this.f543287a;
        if (r101.f543286f == true) goto L6;
        r101.f543286f = true;
        r101.f543281a.removeView(r101.f543283c);
    L6:
        this.f543298l = false;
        this.f543288b.getClass();
    }

    @Override // ss.b
    public final void c() {
        if (this.f543297k == false) goto L19;
        d r100 = this.f543287a;
        if (Build.VERSION.SDK_INT < 26) goto L7;
        r100.f543282b.type = 2038;
    L24:
        WindowManager r101 = r100.f543281a;     // Catch: IllegalStateException -> L10
        View r102 = r100.f543283c;     // Catch: IllegalStateException -> L10
        WindowManager.LayoutParams r103 = r100.f543282b;     // Catch: IllegalStateException -> L10
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r102, r103);     // Catch: IllegalStateException -> L10
        r101.addView(r102, r103);     // Catch: IllegalStateException -> L10
    L16:
        r100.f543286f = false;
        this.f543297k = false;
        this.f543298l = true;
    L22:
        this.f543288b.getClass();
        this.f543288b.getClass();
        return;
    L10:
        e = move-exception;
        String r104 = e.getMessage();
        if (r104 != null) goto L14;
    L17:
        throw e;
    L14:
        if (r104.contains("has already been added to the window manager") == false) goto L17;
        r100.f543281a.removeView(r100.f543283c);
        WindowManager r105 = r100.f543281a;
        View r106 = r100.f543283c;
        WindowManager.LayoutParams r107 = r100.f543282b;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r106, r107);
        r105.addView(r106, r107);
        goto L16
    L7:
        r100.f543282b.type = 2003;
        goto L24
    L19:
        if (this.f543298l == false) goto L21;
        return;
    L21:
        d().setVisibility(0);
        this.f543298l = true;
        goto L22
    }

    public final View d() {
        this.f543296j = ViewConfiguration.get(this.f543288b.f543316a).getScaledTouchSlop();
        return this.f543288b.f543317b;
    }

    public final void e() {
        if (this.f543288b.f543326k == null) goto L5;
    L8:
        this.f543289c.setInterpolator(this.f543288b.f543326k);
        this.f543289c.addListener(new b(this));
        this.f543289c.setDuration(this.f543288b.f543325j).start();
        this.f543288b.getClass();
        return;
    L5:
        if (this.f543290d != null) goto L7;
        this.f543290d = new DecelerateInterpolator();
    L7:
        i.a r100 = this.f543288b;
        r100.f543326k = this.f543290d;
        goto L8
    }

    @Override // ss.b
    public final boolean b() {
        return this.f543298l;
    }

    public e(i.a r100) {
        this.f543295i = false;
        this.f543297k = true;
        this.f543288b = r100;
        d r101 = new d(r100.f543316a);
        this.f543287a = r101;
        d().setOnTouchListener(new f(this));
        int r102 = r100.f543318c;
        int r103 = r100.f543319d;
        WindowManager.LayoutParams r104 = r101.f543282b;
        r104.width = r102;
        r104.height = r103;
        int r105 = r100.f543320e;
        int r106 = r100.f543321f;
        r104.gravity = 8388659;
        r104.x = r105;
        r101.f543284d = r105;
        r104.y = r106;
        r101.f543285e = r106;
        r101.f543283c = r100.f543317b;
        new FloatWindowLifecycle(r100.f543316a, new a(this));
        this.f543301o = r100.f543323h;
        this.f543302p = r100.f543324i;
    }
}
