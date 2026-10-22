package v49;

import android.content.Context;
import android.view.VelocityTracker;
import android.view.animation.LinearInterpolator;
import android.widget.OverScroller;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larus.dora.impl.device.settings.lab.env.timer.reels.views.WheelView;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class g extends OverScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f553140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f553141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f553142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f553143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VelocityTracker f553144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f553145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v49.a f553146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f553147h;

    public static final class a {
    }

    static {
    }

    public final void e() {
        this.f553143d = false;
        this.f553141b = 0;
        this.f553147h = -1;
        d(BasicTestActionHandler.TEST_ACTION_RESET);
        forceFinished(true);
    }

    public final int b() {
        int r100 = this.f553140a.getItemHeightPx();
        int r101 = this.f553140a.getItemSize();
        if (r101 != 0) goto L6;
        return -1;
    L6:
        int r102 = this.f553141b;
        if (r102 >= 0) goto L9;
        int r103 = (r102 - (r100 / 2)) / r100;
    L10:
        int r104 = r103 % r101;
        if (this.f553140a.f334689r == true) goto L14;
        if (r103 < r101) goto L14;
        r104 = r101 - 1;
    L14:
        if (r104 < 0) goto L16;
        return r104;
    L16:
        return r104 + r101;
    L9:
        r103 = (r102 + (r100 / 2)) / r100;
        goto L10
    }

    public static void c(g r100) {
        int r101 = r100.f553140a.getItemHeightPx();
        int r102 = r100.f553141b % r101;
        if (r102 != 0) goto L8;
        v49.a r103 = r100.f553146g;
        if (r103 == null) goto L8;
        r103.a(r100.f553147h);
    L8:
        if (r102 <= 0) goto L13;
        if (r102 >= (r101 / 2)) goto L13;
        r100.f553143d = true;
        r100.g(r100.f553141b, -r102, 200, "justify");
        r100.f553140a.invalidate();
        return;
    L13:
        if (r102 < (r101 / 2)) goto L15;
        r100.f553143d = true;
        r100.g(r100.f553141b, r101 - r102, 200, "justify");
        r100.f553140a.invalidate();
        return;
    L15:
        if (r102 < 0) goto L17;
    L19:
        int r104 = -r101;
        if (r102 > (r104 / 2)) goto L26;
        r100.f553143d = true;
        r100.g(r100.f553141b, r104 - r102, 200, "justify");
        r100.f553140a.invalidate();
        return;
    L26:
        return;
    L17:
        if (r102 <= ((-r101) / 2)) goto L19;
        r100.f553143d = true;
        r100.g(r100.f553141b, -r102, 200, "justify");
        r100.f553140a.invalidate();
    }

    public final void d(String r100) {
        int r101 = this.f553147h;
        int r102 = b();
        if (r101 == r102) goto L21;
        this.f553147h = r102;
        this.f553140a.getContext();
        g49.d.a("WheelScroller", "performVibrateEffect, scene: [" + r100 + ']');
        if (Intrinsics.areEqual(r100, "computeScroll") == false) goto L7;
    L8:
        int r103 = s49.a.f540678a;
        WheelView r104 = this.f553140a;
        if (r104 != null) goto L19;
    L15:
        v49.a r105 = this.f553146g;
        if (r105 == null) goto L22;
        r105.onChanged();
        return;
    L22:
        return;
    L19:
        r104.performHapticFeedback(26);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        g49.d.b("VibratorSmt", "performHapticFeedbackAOSP error: " + e);
        goto L15
    L7:
        if (Intrinsics.areEqual(r100, "touchEvent") == false) goto L15;
    }

    public g(Context r100, WheelView r101) {
        Intrinsics.checkNotNullParameter(r101, "mWheelView");
        super(r100, new LinearInterpolator());
        this.f553140a = r101;
    L13:
        e = move-exception;
        g49.d.c("ScrollerExt", "init reflect error", e);
        f.f553139d = false;
    L15:
        this.f553147h = -1;
        return;
    L4:
        if (f.f553136a != null) goto L7;
        f.f553136a = f.a();     // Catch: Exception -> L13
    L7:
        if (f.f553137b != null) goto L11;
        Class<?> r102 = f.f553136a;     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r102);     // Catch: Exception -> L13
        Method r103 = r102.getDeclaredMethod("getSplineFlingDistance", new Class[]{Integer.TYPE});     // Catch: Exception -> L13
        f.f553137b = r103;     // Catch: Exception -> L13
        if (r103 == null) goto L11;
        r103.setAccessible(true);     // Catch: Exception -> L13
    L11:
        f.f553139d = true;     // Catch: Exception -> L13
        goto L15
    }

    public final void a(int r100, String r101) {
        this.f553141b += r100;
        WheelView r102 = this.f553140a;
        if (r102.f334689r == true) goto L10;
        int r103 = (r102.getItemSize() - 1) * this.f553140a.getItemHeightPx();
        int r104 = this.f553140a.getItemHeightPx() * 0;
        int r105 = this.f553141b;
        int r106 = -r104;
        if (r105 >= r106) goto L7;
        this.f553141b = r106;
        goto L10
    L7:
        int r107 = r103 + r104;
        if (r105 <= r107) goto L10;
        this.f553141b = r107;
    L10:
        d(r101);
    }

    public final void f(int r100, boolean r101) {
        int r102 = r100 * this.f553140a.getItemHeightPx();
        int r103 = this.f553141b;
        int r104 = r102 - r103;
        if (r104 != 0) goto L6;
        return;
    L6:
        if (r101 == false) goto L8;
        this.f553143d = true;
        g(r103, r104, 200, "setCurrentIndex");
        this.f553140a.invalidate();
        return;
    L8:
        a(r104, "setCurrentIndex");
        this.f553140a.invalidate();
    }

    public final void g(int r100, int r101, int r102, String r110) {
        g49.d.a("WheelScroller", "startScrollInternal, startX: 0, startY: " + r100 + ", dx: 0, dy: " + r101 + ", duration: " + r102 + ", scene: " + r110);
        startScroll(0, r100, 0, r101, r102);
    }
}
