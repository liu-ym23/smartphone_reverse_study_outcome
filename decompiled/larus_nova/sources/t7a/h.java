package t7a;

import android.view.MotionEvent;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxTouchEvent;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public class h extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, Object> f544945g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f544946h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f544947i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f544948j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f544949k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f544950l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LynxTouchEvent f544951m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f544952n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f544953o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f544954p;

    @Override // t7a.a
    public final void m() {
        this.f544904b = 0;
        this.f544952n = false;
        this.f544953o = false;
        this.f544954p = false;
    }

    @Override // t7a.a
    public final void d() {
        super.d();
        p(this.f544951m);
    }

    @Override // t7a.a
    public final void e() {
        super.e();
        p(this.f544951m);
    }

    public final HashMap<String, Object> o(LynxTouchEvent r100) {
        this.f544945g.put("scrollX", Integer.valueOf(l(this.f544908f.getMemberScrollX())));
        this.f544945g.put("scrollY", Integer.valueOf(l(this.f544908f.getMemberScrollY())));
        this.f544945g.put("isAtStart", Boolean.valueOf(this.f544908f.isAtBorder(true)));
        this.f544945g.put("isAtEnd", Boolean.valueOf(this.f544908f.isAtBorder(false)));
        this.f544945g.putAll(f(r100));
        return this.f544945g;
    }

    public final void p(LynxTouchEvent r100) {
        if (h() == true) goto L5;
        return;
    L5:
        if (this.f544954p == false) goto L7;
        return;
    L7:
        if (this.f544952n == false) goto L13;
        this.f544954p = true;
        n("onEnd", o(r100));
        return;
    }

    public h(int r100, LynxContext r101, s7a.a r102, p7a.a r103) {
        super(r100, r101, r102, r103);
        this.f544946h = com.lynx.tasm.utils.i.b(0.0f, 0.0f);
        this.f544947i = 0.0f;
        this.f544948j = 0.0f;
        this.f544949k = 0.0f;
        this.f544950l = 0.0f;
        this.f544952n = false;
        this.f544953o = false;
        this.f544954p = false;
        ReadableMap r104 = r102.f540936e;
        if (r104 == null) goto L6;
        this.f544946h = com.lynx.tasm.utils.i.b(r104.getLong("minDistance", 0), 0.0f);
    L6:
        this.f544945g = new HashMap();
    }

    @Override // t7a.a
    public final void k(MotionEvent r100, LynxTouchEvent r101, float r102, float r103, boolean r104, r7a.a r105) {
        if (r101 == null) goto L4;
        this.f544951m = r101;
    L4:
        if (r100 != null) goto L8;
        this.f544904b = 6;
        return;
    L8:
        if (this.f544904b < 3) goto L10;
        return;
    L10:
        int r106 = r100.getActionMasked();
        boolean r107 = false;
        if (r106 == 0) goto L51;
        if (r106 != 1) goto L14;
        e();
        p(this.f544951m);
        return;
    L14:
        if (r106 != 2) goto L63;
        this.f544949k = r100.getX();
        this.f544950l = r100.getY();
        if (this.f544904b != 0) goto L26;
        b();
        if (this.f544952n == true) goto L26;
        this.f544952n = true;
        if (g() == false) goto L26;
        n("onBegin", o(r101));
    L26:
        if (this.f544904b >= 3) goto L33;
        float r108 = Math.abs(this.f544949k - this.f544947i);
        float r109 = Math.abs(this.f544950l - this.f544948j);
        float r110 = this.f544946h;
        if (r108 <= r110) goto L31;
    L32:
        r107 = true;
        goto L33
    L31:
        if (r109 > r110) goto L32;
    L33:
        if (r107 == false) goto L42;
        a();
        if (i() == false) goto L42;
        if (this.f544953o == true) goto L42;
        if (this.f544952n == false) goto L42;
        this.f544953o = true;
        n(WidgetCostModule.TYPE_ON_START, o(r101));
    L42:
        int r111 = this.f544904b;
        if (r111 == 2) goto L45;
        if (r111 < 3) goto L60;
        p(r101);
        return;
    L60:
        return;
    L45:
        if (j() == false) goto L64;
        n("onUpdate", o(r101));
        return;
    L64:
        return;
    L63:
        return;
    L51:
        this.f544947i = r100.getX();
        this.f544948j = r100.getY();
        this.f544954p = false;
        b();
        if (this.f544952n == true) goto L65;
        this.f544952n = true;
        if (g() == false) goto L66;
        n("onBegin", o(r101));
        return;
    L66:
        return;
    }
}
