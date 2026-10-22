package rx1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.android.livesdk.floatwindow.FloatWindowLifecycle;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.HashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class g extends rx1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f539751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l.a f539752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f539753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimeInterpolator f539754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f539755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f539756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f539757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f539758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f539759i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f539760j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f539761k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f539762l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f539763m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f539764n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f539765o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f539766p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f539767q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f539768r;

    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f539769a;

        public final void a() {
            g r100 = this.f539769a;
            if (r100.f539752b.f539800r == true) goto L5;
            r100.c();
        L5:
            e r101 = this.f539769a.f539752b.f539801s;
            if (r101 == null) goto L9;
            r101.b();
            return;
        }

        public a(g r100) {
            this.f539769a = r100;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f539770a;

        public b(g r100) {
            this.f539770a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f539770a.f539753c.removeAllUpdateListeners();
            this.f539770a.f539753c.removeAllListeners();
            g r101 = this.f539770a;
            r101.f539753c = null;
            e r102 = r101.f539752b.f539801s;
            if (r102 == null) goto L6;
            r102.a();
            return;
        }
    }

    public final void a() {
        String r100 = this.f539752b.f539799q;
        ((HashMap) l.f539781a).remove(r100);
        f r101 = this.f539751a;
        if (r101.f539750f == true) goto L6;
        r101.f539750f = true;
        r101.f539745a.removeView(r101.f539747c);
    L6:
        this.f539762l = false;
        e r102 = this.f539752b.f539801s;
        if (r102 == null) goto L10;
        r102.onDismiss();
        return;
    }

    public final View b() {
        this.f539760j = ViewConfiguration.get(this.f539752b.f539783a).getScaledTouchSlop();
        return this.f539752b.f539784b;
    }

    public final void c() {
        if (this.f539761k == false) goto L5;
        return;
    L5:
        if (this.f539762l == false) goto L13;
        b().setVisibility(4);
        this.f539762l = false;
        e r100 = this.f539752b.f539801s;
        if (r100 == null) goto L12;
        r100.onHide();
        return;
    L12:
        return;
    }

    public final void e() {
        if (this.f539761k == false) goto L20;
        f r100 = this.f539751a;
        if (Build.VERSION.SDK_INT < 26) goto L7;
        r100.f539746b.type = 2038;
    L8:
        LocalTestManager.a(new Class[]{wy.a.class});
        WindowManager r101 = r100.f539745a;     // Catch: IllegalStateException -> L11
        View r102 = r100.f539747c;     // Catch: IllegalStateException -> L11
        WindowManager.LayoutParams r103 = r100.f539746b;     // Catch: IllegalStateException -> L11
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r102, r103);     // Catch: IllegalStateException -> L11
        r101.addView(r102, r103);     // Catch: IllegalStateException -> L11
    L17:
        r100.f539750f = false;
        this.f539761k = false;
        this.f539762l = true;
    L23:
        e r104 = this.f539752b.f539801s;
        if (r104 == null) goto L26;
        r104.onShow();
    L26:
        this.f539752b.getClass();
        return;
    L11:
        e = move-exception;
        String r105 = e.getMessage();
        if (r105 != null) goto L15;
    L18:
        throw e;
    L15:
        if (r105.contains("has already been added to the window manager") == false) goto L18;
        r100.f539745a.removeView(r100.f539747c);
        WindowManager r106 = r100.f539745a;
        View r107 = r100.f539747c;
        WindowManager.LayoutParams r108 = r100.f539746b;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r107, r108);
        r106.addView(r107, r108);
        goto L17
    L7:
        r100.f539746b.type = 2002;
        goto L8
    L20:
        if (this.f539762l == false) goto L22;
        return;
    L22:
        b().setVisibility(0);
        this.f539762l = true;
        goto L23
    }

    public final void f() {
        if (this.f539752b.f539798p == null) goto L5;
    L8:
        this.f539753c.setInterpolator(this.f539752b.f539798p);
        this.f539753c.addListener(new b(this));
        this.f539753c.setDuration(this.f539752b.f539797o).start();
        e r100 = this.f539752b.f539801s;
        if (r100 == null) goto L12;
        r100.c();
        return;
    L12:
        return;
    L5:
        if (this.f539754d != null) goto L7;
        this.f539754d = new DecelerateInterpolator();
    L7:
        l.a r101 = this.f539752b;
        r101.f539798p = this.f539754d;
        goto L8
    }

    public g() {
        this.f539759i = false;
        this.f539761k = true;
    }

    public g(l.a r100) {
        this.f539759i = false;
        this.f539761k = true;
        this.f539752b = r100;
        f r101 = new f(r100.f539783a);
        this.f539751a = r101;
        b().setOnTouchListener(new h(this));
        int r102 = r100.f539785c;
        int r103 = r100.f539786d;
        WindowManager.LayoutParams r104 = r101.f539746b;
        r104.width = r102;
        r104.height = r103;
        r104.gravity = 8388659;
        r104.x = 0;
        r101.f539748d = 0;
        r104.y = 0;
        r101.f539749e = 0;
        r101.f539747c = r100.f539784b;
        if (r100.f539803u == false) goto L6;
        r104.flags |= 8192;
    L6:
        if (r100.f539804v.isEmpty() == true) goto L11;
        String r105 = r100.f539804v;
        if (r105.isEmpty() == true) goto L11;
        r101.f539746b.setTitle(r105);
    L11:
        int r106 = r100.f539805w;
        if (r106 == (-1)) goto L16;
        if (r106 == (-1)) goto L16;
        r101.f539746b.flags = r106;
    L16:
        new FloatWindowLifecycle(r100.f539783a, new a(this));
        boolean r107 = r100.f539796n;
        if (r107 == false) goto L19;
        int r108 = r100.f539791i;
    L20:
        this.f539768r = r108;
        if (r107 == false) goto L23;
        int r109 = r100.f539790h;
    L24:
        this.f539767q = r109;
        if (r107 == false) goto L27;
        int r110 = r100.f539788f;
    L28:
        this.f539765o = r110;
        if (r107 == false) goto L31;
        int r111 = r100.f539789g;
    L32:
        this.f539766p = r111;
        return;
    L31:
        r111 = r100.f539793k;
        goto L32
    L27:
        r110 = r100.f539792j;
        goto L28
    L23:
        r109 = r100.f539794l;
        goto L24
    L19:
        r108 = r100.f539795m;
        goto L20
    }

    public final void d(Configuration r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (b() == null) goto L25;
        f r111 = this.f539751a;
        if (r111 == null) goto L27;
        int r100 = r111.f539748d;
        int r112 = r111.f539749e;
        int r101 = b().getWidth();
        int r102 = b().getHeight();
        int r103 = UIUtils.getScreenWidth(this.f539752b.f539783a);
        int r104 = UIUtils.getScreenHeight(this.f539752b.f539783a);
        int r105 = this.f539765o;
        boolean r106 = true;
        if (r100 >= r105) goto L11;
        r100 = r105;
        boolean r107 = true;
    L12:
        int r108 = this.f539766p;
        if (r100 <= ((r103 - r101) - r108)) goto L15;
        r100 = (r103 - r108) - r101;
        r107 = true;
    L15:
        if (r112 >= 0) goto L17;
        r112 = 0;
        r107 = true;
    L17:
        int r109 = r104 - r102;
        if (r112 <= r109) goto L20;
        r112 = r109;
    L21:
        if (r106 == false) goto L26;
        this.f539751a.a(r100, r112);
        return;
    L26:
        return;
    L20:
        r106 = r107;
        goto L21
    L11:
        r107 = false;
        goto L12
    L27:
        return;
    }
}
