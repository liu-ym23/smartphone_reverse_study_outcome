package t7a;

import android.view.MotionEvent;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxTouchEvent;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class b extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, Object> f544909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f544910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f544911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f544912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f544913k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f544914l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LynxTouchEvent f544915m;

    @Override // t7a.a
    public final void a() {
        throw null;
    }

    @Override // t7a.a
    public final void m() {
        this.f544904b = 0;
        this.f544910h = 0.0f;
        this.f544911i = 0.0f;
        this.f544912j = false;
        this.f544913k = false;
    }

    @Override // t7a.a
    public final void d() {
        super.d();
        LynxTouchEvent r100 = this.f544915m;
        if (r100 != null) goto L5;
        q(null);
        return;
    L5:
        q(r100);
    }

    @Override // t7a.a
    public final void e() {
        super.e();
        LynxTouchEvent r100 = this.f544915m;
        if (r100 != null) goto L5;
        q(null);
        return;
    L5:
        q(r100);
    }

    public final void p(LynxTouchEvent r100) {
        if (g() == true) goto L5;
        return;
    L5:
        if (this.f544912j == true) goto L10;
        this.f544912j = true;
        n("onBegin", o(0.0f, 0.0f));
        return;
    }

    public final void q(LynxTouchEvent r100) {
        if (h() == true) goto L5;
        return;
    L5:
        if (this.f544913k == false) goto L7;
        return;
    L7:
        if (this.f544912j == false) goto L13;
        this.f544913k = true;
        n("onEnd", o(0.0f, 0.0f));
        return;
    }

    public final HashMap<String, Object> o(float r100, float r101) {
        this.f544909g.put("scrollX", Integer.valueOf(l(this.f544908f.getMemberScrollX())));
        this.f544909g.put("scrollY", Integer.valueOf(l(this.f544908f.getMemberScrollY())));
        this.f544909g.put("deltaX", Integer.valueOf(l(r100)));
        this.f544909g.put("deltaY", Integer.valueOf(l(r101)));
        this.f544909g.put("isAtStart", Boolean.valueOf(this.f544908f.isAtBorder(true)));
        this.f544909g.put("isAtEnd", Boolean.valueOf(this.f544908f.isAtBorder(false)));
        return this.f544909g;
    }

    public final void r(float r100, float r101, r7a.a r102) {
        p7a.a r103 = this.f544908f;
        if (r103 == null) goto L5;
        r103.onGestureScrollBy(r100, r101);
    L5:
        if (r102 == null) goto L8;
        r102.f536477d = true;
        r102.f536475b = r100;
        r102.f536476c = r101;
    L8:
        if (Math.abs((int) r100) <= this.f544914l) goto L10;
    L11:
        this.f544905c.onGestureRecognized(this.f544903a);
    L13:
        if (j() == true) goto L15;
        return;
    L15:
        n("onUpdate", o(r100, r101));
        return;
    L10:
        if (Math.abs((int) r101) <= this.f544914l) goto L13;
        goto L11
    }

    public final boolean s(float r100, float r101, r7a.a r102) {
        if (r102 == null) goto L17;
        p7a.a r103 = this.f544908f;
        if (r103 == null) goto L17;
        if (r102.f536474a != (-1)) goto L12;
        if (r103.getScrollContainerDirection() == (-1)) goto L12;
        return true;
    L12:
        if (r102.f536474a != 1) goto L17;
        if (this.f544908f.getScrollContainerDirection() == 1) goto L17;
        return true;
    L17:
        return !this.f544908f.canConsumeGesture(r100, r101);
    }

    public b(int r100, LynxContext r101, s7a.a r102, p7a.a r103) {
        super(r100, r101, r102, r103);
        this.f544910h = 0.0f;
        this.f544911i = 0.0f;
        this.f544912j = false;
        this.f544913k = false;
        this.f544914l = 3;
        ReadableMap r104 = r102.f540936e;
        if (r104 == null) goto L6;
        this.f544914l = r104.getInt("tapSlop", 3);
    L6:
        this.f544909g = new HashMap();
    }

    @Override // t7a.a
    public final void k(MotionEvent r100, LynxTouchEvent r101, float r110, float r111, boolean r112, r7a.a r113) {
        this.f544915m = r101;
        if (r112 == false) goto L12;
        if (r113 == null) goto L12;
        if (r113.f536477d == false) goto L103;
        p7a.a r102 = this.f544908f;
        if (r102 == null) goto L104;
        r102.onGestureScrollBy(r113.f536475b, r113.f536476c);
        this.f544908f.onInvalidate();
        return;
    L104:
        return;
    L103:
        return;
    L12:
        if (this.f544904b < 3) goto L15;
        q(r101);
        return;
    L15:
        float r103 = 0.0f;
        if (r100 == null) goto L66;
        int r104 = r100.getActionMasked();
        if (r104 == 0) goto L65;
        if (r104 == 1) goto L59;
        if (r104 != 2) goto L112;
        float r114 = this.f544910h - r100.getX();
        float r115 = this.f544911i - r100.getY();
        if (r114 == 0.0f) goto L25;
    L27:
        if (r113 != null) goto L29;
    L35:
        if (r113 == null) goto L40;
        int r105 = r113.f536474a;
        if (r105 == 0) goto L40;
        if (r105 != (-1)) goto L42;
        r103 = r114;
        r115 = 0.0f;
    L42:
        if (this.f544904b != 0) goto L47;
        p(r101);
        if (this.f544904b > 1) goto L57;
        super.a();
    L57:
        this.f544910h = r100.getX();
        this.f544911i = r100.getY();
        return;
    L47:
        if (s(r103, r115, r113) == false) goto L56;
        p7a.a r116 = this.f544908f;
        if (r116 != null) goto L51;
    L55:
        e();
        q(r101);
        goto L57
    L51:
        if (r116.isAtBorder(true) == true) goto L55;
        if (this.f544908f.isAtBorder(false) == true) goto L55;
        r(r103, r115, r113);
        goto L55
    L56:
        super.a();
        r(r103, r115, r113);
    L40:
        r103 = r114;
        goto L42
    L29:
        if (r113.f536474a != 0) goto L35;
        if (Math.abs(r114) <= Math.abs(r115)) goto L33;
        int r106 = -1;
    L34:
        r113.f536474a = r106;
        goto L35
    L33:
        r106 = 1;
        goto L34
    L25:
        if (r115 != 0.0f) goto L27;
        return;
    L112:
        return;
    L59:
        if (this.f544904b == 2) goto L61;
        return;
    L61:
        if (r110 == Float.MIN_VALUE) goto L63;
        return;
    L63:
        if (r111 != Float.MIN_VALUE) goto L108;
        e();
        q(null);
        return;
    L108:
        return;
    L65:
        this.f544910h = r100.getX();
        this.f544911i = r100.getY();
        this.f544913k = false;
        b();
        p(r101);
        return;
    L66:
        p7a.a r107 = this.f544908f;
        if (r107 == null) goto L70;
        r107.onInvalidate();
    L70:
        if (this.f544904b == 2) goto L72;
    L77:
        if (r113 == null) goto L84;
        int r108 = r113.f536474a;
        if (r108 == 0) goto L84;
        if (r108 != (-1)) goto L82;
        r111 = 0.0f;
        goto L84
    L82:
        r110 = 0.0f;
    L84:
        if (s(r110, r111, r113) == false) goto L94;
        p7a.a r109 = this.f544908f;
        if (r109 != null) goto L88;
    L92:
        e();
        q(null);
    L99:
        p7a.a r117 = this.f544908f;
        if (r117 == null) goto L111;
        r117.onInvalidate();
        return;
    L111:
        return;
    L88:
        if (r109.isAtBorder(true) == true) goto L92;
        if (this.f544908f.isAtBorder(false) == true) goto L92;
        r(r110, r111, r113);
        goto L92
    L94:
        if (this.f544904b != 0) goto L98;
        p(r101);
        if (this.f544904b > 1) goto L98;
        super.a();
    L98:
        r(r110, r111, r113);
        goto L99
    L72:
        if (r110 != Float.MIN_VALUE) goto L77;
        if (r111 != Float.MIN_VALUE) goto L77;
        e();
        q(null);
    }
}
