package t7a;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxTouchEvent;

/* JADX INFO: loaded from: classes32.dex */
public final class f extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f544935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f544936h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Handler f544937i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f544938j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f544939k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f544940l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f544941m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LynxTouchEvent f544942n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f544943o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e f544944p;

    @Override // t7a.a
    public final void m() {
        this.f544904b = 0;
        this.f544943o = false;
    }

    @Override // t7a.a
    public final void d() {
        super.d();
        LynxTouchEvent r100 = this.f544942n;
        if (h() == true) goto L5;
        return;
    L5:
        if (this.f544943o == true) goto L10;
        this.f544943o = true;
        n("onEnd", f(r100));
        return;
    }

    @Override // t7a.a
    public final void e() {
        super.e();
        LynxTouchEvent r100 = this.f544942n;
        if (h() == true) goto L5;
        return;
    L5:
        if (this.f544943o == true) goto L10;
        this.f544943o = true;
        n("onEnd", f(r100));
        return;
    }

    /* JADX WARN: Type inference failed for: r7v5, types: [t7a.e] */
    public f(int r100, LynxContext r101, s7a.a r102, p7a.a r103) {
        super(r100, r101, r102, r103);
        this.f544935g = 500;
        this.f544936h = com.lynx.tasm.utils.i.b(10.0f, 0.0f);
        this.f544937i = null;
        this.f544938j = 0.0f;
        this.f544939k = 0.0f;
        this.f544940l = 0.0f;
        this.f544941m = 0.0f;
        this.f544942n = null;
        this.f544943o = false;
        this.f544944p = new e(this);
        ReadableMap r104 = r102.f540936e;
        if (r104 == null) goto L7;
        this.f544935g = r104.getLong("minDuration", 500);
        this.f544936h = com.lynx.tasm.utils.i.b(r104.getLong("maxDistance", 10), 0.0f);
        return;
    }

    @Override // t7a.a
    public final void k(MotionEvent r100, LynxTouchEvent r101, float r102, float r103, boolean r104, r7a.a r105) {
        this.f544942n = r101;
        if (r100 != null) goto L7;
        this.f544904b = 6;
        return;
    L7:
        if (this.f544904b < 3) goto L12;
        Handler r106 = this.f544937i;
        if (r106 == null) goto L42;
        r106.removeCallbacksAndMessages(null);
        this.f544937i = null;
        return;
    L42:
        return;
    L12:
        int r107 = r100.getActionMasked();
        boolean r108 = false;
        if (r107 != 0) goto L15;
        this.f544938j = r100.getX();
        this.f544939k = r100.getY();
        this.f544943o = false;
        b();
        if (g() == false) goto L36;
        n("onBegin", f(r101));
    L36:
        Handler r109 = this.f544937i;
        if (r109 != null) goto L39;
        this.f544937i = new Handler(Looper.getMainLooper());
    L40:
        this.f544937i.postDelayed(this.f544944p, this.f544935g);
        return;
    L39:
        r109.removeCallbacksAndMessages(null);
        goto L40
    L15:
        if (r107 != 1) goto L17;
        Handler r110 = this.f544937i;
        if (r110 == null) goto L31;
        r110.removeCallbacksAndMessages(null);
        this.f544937i = null;
    L31:
        e();
        return;
    L17:
        if (r107 != 2) goto L47;
        this.f544940l = r100.getX();
        this.f544941m = r100.getY();
        float r111 = Math.abs(this.f544940l - this.f544938j);
        float r112 = Math.abs(this.f544941m - this.f544939k);
        float r113 = this.f544936h;
        if (r111 <= r113) goto L22;
    L23:
        r108 = true;
    L24:
        if (r108 == false) goto L43;
        e();
        Handler r114 = this.f544937i;
        if (r114 == null) goto L44;
        r114.removeCallbacksAndMessages(null);
        this.f544937i = null;
        return;
    L44:
        return;
    L43:
        return;
    L22:
        if (r112 <= r113) goto L24;
    }
}
