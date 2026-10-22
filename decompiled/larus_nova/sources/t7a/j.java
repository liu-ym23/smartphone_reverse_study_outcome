package t7a;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxTouchEvent;

/* JADX INFO: loaded from: classes32.dex */
public final class j extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f544956g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f544957h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f544958i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f544959j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f544960k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f544961l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f544962m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LynxTouchEvent f544963n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Handler f544964o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final i f544965p;

    @Override // t7a.a
    public final void m() {
        this.f544904b = 0;
        this.f544962m = false;
    }

    @Override // t7a.a
    public final void d() {
        super.d();
        o(this.f544963n);
    }

    @Override // t7a.a
    public final void e() {
        super.e();
        o(this.f544963n);
    }

    public final void o(LynxTouchEvent r100) {
        if (h() == true) goto L5;
        return;
    L5:
        if (this.f544962m == true) goto L10;
        this.f544962m = true;
        n("onEnd", f(r100));
        return;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [t7a.i] */
    public j(int r100, LynxContext r101, s7a.a r102, p7a.a r103) {
        super(r100, r101, r102, r103);
        this.f544956g = com.lynx.tasm.utils.i.b(10.0f, 0.0f);
        this.f544957h = 500;
        this.f544958i = 0.0f;
        this.f544959j = 0.0f;
        this.f544960k = 0.0f;
        this.f544961l = 0.0f;
        this.f544962m = false;
        this.f544963n = null;
        this.f544964o = null;
        this.f544965p = new i(this);
        ReadableMap r104 = r102.f540936e;
        if (r104 == null) goto L7;
        this.f544957h = r104.getLong("maxDuration", 500);
        this.f544956g = com.lynx.tasm.utils.i.b(r104.getLong("maxDistance", 10), 0.0f);
        return;
    }

    @Override // t7a.a
    public final void k(MotionEvent r100, LynxTouchEvent r101, float r102, float r103, boolean r104, r7a.a r105) {
        this.f544963n = r101;
        if (r100 != null) goto L9;
        this.f544904b = 6;
        Handler r106 = this.f544964o;
        if (r106 == null) goto L49;
        r106.removeCallbacksAndMessages(null);
        this.f544964o = null;
        return;
    L49:
        return;
    L9:
        if (this.f544904b < 3) goto L14;
        Handler r107 = this.f544964o;
        if (r107 == null) goto L50;
        r107.removeCallbacksAndMessages(null);
        this.f544964o = null;
        return;
    L50:
        return;
    L14:
        int r108 = r100.getActionMasked();
        boolean r109 = false;
        if (r108 != 0) goto L17;
        this.f544958i = r100.getX();
        this.f544959j = r100.getY();
        this.f544962m = false;
        b();
        if (g() == false) goto L43;
        n("onBegin", f(r101));
    L43:
        Handler r110 = this.f544964o;
        if (r110 != null) goto L46;
        this.f544964o = new Handler(Looper.getMainLooper());
    L47:
        this.f544964o.postDelayed(this.f544965p, this.f544957h);
        return;
    L46:
        r110.removeCallbacksAndMessages(null);
        goto L47
    L17:
        if (r108 != 1) goto L19;
        this.f544960k = r100.getX();
        this.f544961l = r100.getY();
        if (this.f544904b < 3) goto L31;
        e();
    L36:
        Handler r111 = this.f544964o;
        if (r111 == null) goto L53;
        r111.removeCallbacksAndMessages(null);
        this.f544964o = null;
        return;
    L53:
        return;
    L31:
        a();
        if (i() == false) goto L35;
        n(WidgetCostModule.TYPE_ON_START, f(r101));
    L35:
        o(r101);
        goto L36
    L19:
        if (r108 != 2) goto L55;
        this.f544960k = r100.getX();
        this.f544961l = r100.getY();
        float r112 = Math.abs(this.f544960k - this.f544958i);
        float r113 = Math.abs(this.f544961l - this.f544959j);
        float r114 = this.f544956g;
        if (r112 <= r114) goto L24;
    L25:
        r109 = true;
    L26:
        if (r109 == false) goto L51;
        e();
        return;
    L51:
        return;
    L24:
        if (r113 <= r114) goto L26;
    }
}
