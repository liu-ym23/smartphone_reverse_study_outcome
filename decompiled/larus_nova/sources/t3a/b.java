package t3a;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f544493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f544494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f544495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f544496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f544497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f544498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f544499g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f544500h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WindowManager.LayoutParams f544501i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WindowManager f544502j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f544503k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f544504l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f544505m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f544506n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f544507o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f544508p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f544509q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f544510r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f544511s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f544512t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f544513u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f544514v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f544515w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f544516x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f544517y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a f544518z;

    public interface a {
        void a(View r100);

        void onClick(View r100);

        void onLongClick(View r100);
    }

    /* JADX INFO: renamed from: t3a.b$b, reason: collision with other inner class name */
    public static final class ViewOnTouchListenerC7683b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f544519a;

        public ViewOnTouchListenerC7683b(b r100) {
            this.f544519a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r110, MotionEvent r111) {
            Intrinsics.checkNotNullParameter(r110, "view");
            Intrinsics.checkNotNullParameter(r111, "motionEvent");
            int r112 = r111.getAction();
            if (r112 != 0) goto L5;
            b r113 = this.f544519a;
            r113.f544512t = true;
            r113.f544506n = r111.getRawX();
            this.f544519a.f544507o = r111.getRawY();
            this.f544519a.f544510r = System.currentTimeMillis();
            final b r114 = this.f544519a;
            r114.f544505m.postDelayed(new c(r114), r114.f544515w);
            final b r115 = this.f544519a;
            if (r115.f544513u == false) goto L48;
            r115.f544513u = false;
            r115.f544505m.postDelayed(new d(r115), r115.f544516x);
        L48:
            return false;
        L5:
            if (r112 == 1) goto L24;
            if (r112 != 2) goto L48;
            b r116 = this.f544519a;
            float r100 = r111.getRawX();
            float r101 = r111.getRawY();
            WindowManager.LayoutParams r102 = r116.f544501i;
            int r103 = r102.x;
            float r104 = r116.f544508p;
            if (r104 >= 0.0f) goto L11;
            int r105 = 0;
        L12:
            r102.x = r103 + r105;
            int r106 = r102.y;
            float r107 = r116.f544509q;
            if (r107 >= 0.0f) goto L15;
            int r108 = 0;
        L16:
            r102.y = r106 + r108;
            WindowManager r109 = r116.f544502j;
            if (r109 == null) goto L19;
            r109.updateViewLayout(r116.f544494b, r102);
        L19:
            this.f544519a.f544508p = r111.getRawX();
            this.f544519a.f544509q = r111.getRawY();
            b r117 = this.f544519a;
            float r118 = Math.abs(r117.f544506n - r117.f544508p);
            b r119 = this.f544519a;
            if (r118 <= r119.f544503k) goto L22;
        L23:
            this.f544519a.f544512t = false;
            goto L48
        L22:
            if (Math.abs(r119.f544507o - r119.f544509q) <= this.f544519a.f544503k) goto L48;
        L15:
            r108 = (int) (r101 - r107);
            goto L16
        L11:
            r105 = (int) (r100 - r104);
            goto L12
        L24:
            b r120 = this.f544519a;
            r120.f544512t = false;
            r120.f544508p = r111.getRawX();
            this.f544519a.f544509q = r111.getRawY();
            this.f544519a.f544511s = System.currentTimeMillis();
            b r121 = this.f544519a;
            float r122 = Math.abs(r121.f544506n - r121.f544508p);
            b r123 = this.f544519a;
            if (r122 >= r123.f544503k) goto L31;
            float r124 = Math.abs(r123.f544507o - r123.f544509q);
            b r125 = this.f544519a;
            if (r124 >= r125.f544503k) goto L31;
            if ((r125.f544511s - r125.f544510r) >= r125.f544517y) goto L31;
            r125.f544514v++;
        L31:
            final b r126 = this.f544519a;
            if (r126.f544504l == 0) goto L44;
            final int r127 = r126.f544501i.x;
            int r128 = r126.f544496d;
            int r129 = (r126.f544499g - r126.f544494b.getMeasuredWidth()) - r126.f544496d;
            if (r126.f544501i.x <= ((r126.f544499g - r126.f544494b.getMeasuredWidth()) / 2)) goto L36;
            final int r130 = r129;
        L37:
            final int r131 = r126.f544501i.y;
            int r132 = r126.f544497e;
            int r133 = ((r126.f544498f - r126.f544500h) - r126.f544494b.getMeasuredHeight()) - r126.f544497e;
            int r134 = r126.f544501i.y;
            if (r134 <= r133) goto L40;
            final int r135 = r133;
        L43:
            ValueAnimator r136 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r136.setDuration(300);
            r136.addUpdateListener(new t3a.a(r126, r127, r130, r131, r135));
            r136.setInterpolator(new AccelerateDecelerateInterpolator());
            r136.start();
            goto L44
        L40:
            if (r134 >= r132) goto L42;
            r135 = r132;
            goto L43
        L42:
            r135 = r134;
            goto L43
        L36:
            r130 = r128;
        L44:
            b r137 = this.f544519a;
            r137.f544508p = -1.0f;
            r137.f544509q = -1.0f;
            goto L48
        }
    }

    public final void b() {
        WindowManager.LayoutParams r100 = this.f544501i;
        r100.x = (this.f544499g - this.f544496d) - r100.width;
        e r101 = this.f544495c;
        r100.y = r101.f544525d;
        if ((!r101.f544526e) == false) goto L6;
        r100.flags |= 16;
        return;
    }

    public final void a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if ((r101 instanceof WindowManager) == false) goto L5;
        WindowManager r102 = (WindowManager) r101;
    L6:
        this.f544502j = r102;
        this.f544501i.token = null;
        if ((!this.f544495c.f544526e) == false) goto L9;
        b();
    L13:
        if (this.f544502j == null) goto L31;
        int r103 = hashCode();
        if (r103 != this.f544504l) goto L18;
        return;
    L18:
        if (this.f544494b.getParent() == null) goto L20;
        c(this.f544494b);
    L20:
        View r104 = this.f544494b;
        WindowManager.LayoutParams r105 = this.f544501i;
        WindowManager r106 = this.f544502j;     // Catch: Exception -> L25
        if (r106 == null) goto L27;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r104, r105);     // Catch: Exception -> L25
        r106.addView(r104, r105);     // Catch: Exception -> L25
    L27:
        this.f544504l = r103;
        return;
    L25:
        e = move-exception;
        FLogger.f375446a.i("FloatingWindow", "addWindowView error " + e.getMessage());
        goto L27
    L31:
        return;
    L9:
        int r107 = com.larus.utils.i.c(this.f544493a);
        if (r107 == this.f544498f) goto L13;
        this.f544498f = r107;
        this.f544499g = com.larus.utils.i.d(this.f544493a);
        this.f544500h = com.larus.utils.i.e(this.f544493a);
        b();
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    public final void c(View r100) {
        WindowManager r101 = this.f544502j;     // Catch: Exception -> L6
        if (r101 == null) goto L11;
        r101.removeViewImmediate(r100);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        FLogger.f375446a.i("FloatingWindow", "removeWindowView error " + e.getMessage());
    }

    public b(Context r100, View r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "floatingView");
        Intrinsics.checkNotNullParameter(r102, "config");
        this.f544493a = r100;
        this.f544494b = r101;
        this.f544495c = r102;
        this.f544496d = 32;
        this.f544497e = 32;
        this.f544498f = com.larus.utils.i.c(r100);
        this.f544499g = com.larus.utils.i.d(r100);
        this.f544500h = com.larus.utils.i.e(r100);
        WindowManager.LayoutParams r103 = new WindowManager.LayoutParams();
        this.f544501i = r103;
        this.f544503k = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f544505m = new Handler(Looper.getMainLooper());
        this.f544506n = -1.0f;
        this.f544507o = -1.0f;
        this.f544508p = -1.0f;
        this.f544509q = -1.0f;
        this.f544513u = true;
        this.f544515w = 500;
        this.f544516x = 300;
        this.f544517y = 200;
        r103.type = 2;
        r103.flags = 552;
        r103.format = 1;
        r103.gravity = 8388659;
        r103.width = r102.f544522a;
        r103.height = r102.f544523b;
        if ((true ^ r102.f544526e) == false) goto L5;
        ViewOnTouchListenerC7683b r104 = null;
    L6:
        if (r104 == null) goto L8;
        r101.setOnTouchListener(r104);
    L8:
        b();
        return;
    L5:
        r104 = new ViewOnTouchListenerC7683b(this);
        goto L6
    }
}
