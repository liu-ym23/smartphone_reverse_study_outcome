package t7a;

import android.view.MotionEvent;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxTouchEvent;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class c extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f544916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f544917h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f544918i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashMap<String, Object> f544919j;

    @Override // t7a.a
    public final void m() {
        this.f544904b = 0;
        this.f544916g = false;
        this.f544917h = false;
        this.f544918i = false;
    }

    @Override // t7a.a
    public final void d() {
        super.d();
        p(null);
    }

    @Override // t7a.a
    public final void e() {
        super.e();
        p(null);
    }

    public final void p(LynxTouchEvent r100) {
        if (h() == true) goto L5;
        return;
    L5:
        if (this.f544918i == false) goto L7;
        return;
    L7:
        if (this.f544916g == false) goto L13;
        this.f544918i = true;
        n("onEnd", o(0.0f, 0.0f));
        return;
    }

    public final HashMap<String, Object> o(float r100, float r101) {
        this.f544919j.put("scrollX", Integer.valueOf(l(this.f544908f.getMemberScrollX())));
        this.f544919j.put("scrollY", Integer.valueOf(l(this.f544908f.getMemberScrollY())));
        this.f544919j.put("deltaX", Integer.valueOf(l(r100)));
        this.f544919j.put("deltaY", Integer.valueOf(l(r101)));
        this.f544919j.put("isAtStart", Boolean.valueOf(this.f544908f.isAtBorder(true)));
        this.f544919j.put("isAtEnd", Boolean.valueOf(this.f544908f.isAtBorder(false)));
        return this.f544919j;
    }

    public c(int r100, LynxContext r101, s7a.a r102, p7a.a r103) {
        super(r100, r101, r102, r103);
        this.f544916g = false;
        this.f544917h = false;
        this.f544918i = false;
        this.f544919j = new HashMap();
    }

    @Override // t7a.a
    public final void k(MotionEvent r100, LynxTouchEvent r101, float r102, float r103, boolean r104, r7a.a r110) {
        p7a.a r105 = this.f544908f;
        if (r105 == null) goto L6;
        r105.onInvalidate();
    L6:
        if (r100 == null) goto L14;
        if (r100.getActionMasked() != 0) goto L10;
    L11:
        this.f544904b = 6;
        return;
    L10:
        if (r100.getActionMasked() == 2) goto L11;
    L14:
        if (r100 != null) goto L16;
    L24:
        int r106 = this.f544904b;
        if (r106 < 3) goto L31;
        if (r106 > 5) goto L31;
        p(null);
        return;
    L31:
        if (r102 == Float.MIN_VALUE) goto L33;
    L36:
        if (r106 == 0) goto L44;
        if (r106 == 6) goto L44;
        if (j() == false) goto L61;
        n("onUpdate", o(r102, r103));
        return;
    L61:
        return;
    L44:
        b();
        a();
        if (g() == false) goto L51;
        if (this.f544916g == true) goto L51;
        this.f544916g = true;
        n("onBegin", o(0.0f, 0.0f));
    L51:
        if (i() == true) goto L53;
        return;
    L53:
        if (this.f544917h == false) goto L55;
        return;
    L55:
        if (this.f544916g == false) goto L64;
        this.f544917h = true;
        n(WidgetCostModule.TYPE_ON_START, o(0.0f, 0.0f));
        return;
    L64:
        return;
    L33:
        if (r103 != Float.MIN_VALUE) goto L36;
        e();
        p(null);
        return;
    L16:
        if (r100.getActionMasked() != 1) goto L24;
        b();
        if (g() == true) goto L20;
        return;
    L20:
        if (this.f544916g == true) goto L60;
        this.f544916g = true;
        n("onBegin", o(0.0f, 0.0f));
        return;
    }
}
