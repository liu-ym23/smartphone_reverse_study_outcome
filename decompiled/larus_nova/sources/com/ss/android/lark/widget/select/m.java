package com.ss.android.lark.widget.select;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spannable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes38.dex */
public final class m implements com.ss.android.lark.widget.select.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f448438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f448439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q f448440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f448441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Spannable f448442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f448443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f448444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f448445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f448446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f448447j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f448448k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h f448449l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f448450m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c f448451n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public r f448452o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f448453p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f448454q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public j f448455r;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f448456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Activity f448457b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f448458c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f448459d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public r f448460e;

        public a(q r100, Activity r101) {
            this.f448456a = r100;
            this.f448457b = r101;
        }
    }

    public class b extends View {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final /* synthetic */ int f448461q = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PopupWindow f448462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f448463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f448464c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f448465d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f448466e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f448467f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f448468g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int[] f448469h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f448470i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f448471j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f448472k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f448473l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f448474m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int[] f448475n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int[] f448476o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ m f448477p;

        public final int a() {
            return (this.f448475n[0] - this.f448467f) + this.f448477p.f448441d.getPaddingLeft();
        }

        public final void d() {
            this.f448477p.f448441d.getLocationInWindow(this.f448475n);
            CharSequence r100 = this.f448477p.f448440c.getContent();
            Layout r101 = this.f448477p.f448440c.getLayout();
            if (r101 != null) goto L6;
            return;
        L6:
            if (this.f448468g == false) goto L8;
            int r102 = this.f448477p.f448449l.f448433a;
            int r103 = (((int) r101.getPrimaryHorizontal(r102)) - this.f448465d) + a();
            int r104 = r101.getLineForOffset(r102);
            int r105 = (((r101.getLineTop(r104) + r101.getLineBottom(r104)) / 2) + (this.f448475n[1] + this.f448477p.f448441d.getPaddingTop())) - this.f448467f;
        L17:
            if (this.f448462a.isShowing() == false) goto L19;
        L35:
            PopupWindow r106 = this.f448462a;
            if ((r106 instanceof PopupWindow) == false) goto L41;
            if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r106) == false) goto L41;
            r106.update(r103, r105, -1, -1);
            return;
        L41:
            if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r106, r103, r105, -1, -1) == true) goto L48;
            r106.update(r103, r105, -1, -1);
            return;
        L48:
            return;
        L19:
            if (getParent() != null) goto L35;
            m r107 = this.f448477p;
            if (r107.f448453p == null) goto L35;
            if (r107.f448452o == null) goto L35;
            r107.f448441d.getLocationOnScreen(this.f448476o);
            if (this.f448477p.f448452o.a((this.f448476o[1] + this.f448477p.f448441d.getPaddingTop()) + ((r101.getLineTop(r104) + r101.getLineBottom(r104)) / 2)) == false) goto L35;
            b(null);
            if (this.f448462a.isShowing() == false) goto L35;
            m r108 = this.f448477p;
            if (this != r108.f448444g) goto L33;
            r108.f448447j = true;
            goto L35
        L33:
            if (this != r108.f448445h) goto L35;
            r108.f448448k = true;
            goto L35
        L8:
            int r109 = this.f448477p.f448449l.f448434b;
        L9:
            if (r109 <= 0) goto L13;
            int r110 = r109 - 1;
            if ('\n' != r100.charAt(r110)) goto L13;
            r109 = r110;
        L13:
            if (r109 > 0) goto L15;
            r109 = 0;
        L15:
            this.f448477p.f448449l.f448434b = r109;
            int r111 = ((int) r101.getPrimaryHorizontal(r109)) + a();
            int r112 = r101.getLineForOffset(r109);
            r105 = (((r101.getLineTop(r112) + r101.getLineBottom(r112)) / 2) + (this.f448475n[1] + this.f448477p.f448441d.getPaddingTop())) - this.f448467f;
            r103 = r111;
            r104 = r112;
            goto L17
        }

        @Override // android.view.View
        public final boolean performClick() {
            return super.performClick();
        }

        public final void b(int[] r110) {
            Layout r100 = this.f448477p.f448440c.getLayout();
            if (r100 != null) goto L6;
            return;
        L6:
            if (this.f448468g == false) goto L8;
            int r101 = this.f448477p.f448449l.f448433a;
        L9:
            int r102 = r100.getLineForOffset(r101);
            if (r101 > r100.getText().length()) goto L42;
            if (r102 > r100.getLineCount()) goto L42;
            int r103 = (int) r100.getPrimaryHorizontal(r101);
            int r104 = ((r100.getLineTop(r102) + r100.getLineBottom(r102)) / 2) - this.f448467f;
            this.f448477p.f448441d.getLocationInWindow(this.f448475n);
            if (this.f448468g == false) goto L17;
            int r105 = this.f448465d;
        L18:
            int r106 = t.a(r104 + (this.f448475n[1] + this.f448477p.f448441d.getPaddingTop()), this.f448477p.f448439b.f448457b);
            if (r110 != null) goto L21;
        L28:
            PopupWindow r111 = this.f448462a;
            View r107 = this.f448477p.f448441d;
            int r108 = (r103 - r105) + a();
            if (PopupWindowLancet.hasSubWindowToken(r107) == false) goto L32;
            return;
        L32:
            if ((r111 instanceof PopupWindow) == true) goto L34;
        L36:
            OverlaySource r109 = PopupWindowLancet.resolveSource(r107);
            if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r111, r107, r109, 0, r108, r106) == true) goto L47;
            r111.showAtLocation(r107, 0, r108, r106);
            PopupWindowLancet.trackAfterShow(r111, r109, r107);
            return;
        L47:
            return;
        L34:
            if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r111) == false) goto L36;
            r111.showAtLocation(r107, 0, r108, r106);
            return;
        L21:
            if (r110.length != 2) goto L28;
            int r112 = r110[0];
            int r113 = r110[1];
            if (r106 <= r112) goto L26;
            if (r106 >= r113) goto L26;
            return;
        L26:
            if (((this.f448466e + r106) + this.f448467f) <= r112) goto L28;
            return;
        L17:
            r105 = 0;
        L42:
            return;
        L8:
            r101 = this.f448477p.f448449l.f448434b;
            goto L9
        }

        @Override // android.view.View
        public final void onDraw(Canvas r110) {
            int r100 = this.f448464c;
            int r101 = this.f448467f;
            r110.drawCircle(r100 + r101, r101 + r100, r100, this.f448463b);
            if (this.f448468g == false) goto L5;
            int r102 = this.f448464c;
            int r103 = this.f448467f;
            r110.drawRect(r102 + r103, r103, (r102 * 2) + r103, r102 + r103, this.f448463b);
            return;
        L5:
            int r104 = this.f448467f;
            int r105 = this.f448464c;
            r110.drawRect(r104, r104, r105 + r104, r105 + r104, this.f448463b);
        }

        @Override // android.view.View
        public final boolean onTouchEvent(MotionEvent r100) {
            int r101 = r100.getAction();
            if (r101 != 0) goto L5;
            h r102 = this.f448477p.f448449l;
            this.f448472k = r102.f448433a;
            this.f448473l = r102.f448434b;
            this.f448470i = (int) r100.getX();
            this.f448471j = (int) r100.getY();
            this.f448474m = true;
            this.f448477p.f448453p = this;
        L27:
            return true;
        L5:
            if (r101 != 1) goto L7;
            r r103 = this.f448477p.f448452o;
            if (r103 == null) goto L23;
            r103.c(r100);
        L23:
            super.performClick();
            this.f448474m = false;
            this.f448477p.j();
            m r104 = this.f448477p;
            if (r104.f448453p != this) goto L27;
            r104.f448453p = null;
            goto L27
        L7:
            if (r101 != 2) goto L9;
            c(r100.getRawX(), r100.getRawY(), 0);
            r r105 = this.f448477p.f448452o;
            if (r105 == null) goto L27;
            r105.c(r100);
            goto L27
        L9:
            if (r101 != 3) goto L27;
            r r106 = this.f448477p.f448452o;
            if (r106 == null) goto L14;
            r106.c(r100);
        L14:
            this.f448474m = false;
            this.f448477p.j();
            m r107 = this.f448477p;
            if (r107.f448453p != this) goto L27;
            r107.f448453p = null;
            goto L27
        }

        public b(m r100, boolean r101) {
            this.f448477p = r100;
            super(r100.f448438a);
            int r102 = (int) (r100.f448439b.f448459d / 2.0f);
            this.f448464c = r102;
            int r103 = r102 * 2;
            this.f448465d = r103;
            this.f448466e = r103;
            int r104 = UIHelper.dp2px(20.0f);
            this.f448467f = r104;
            this.f448469h = new int[2];
            this.f448475n = new int[2];
            this.f448476o = new int[2];
            this.f448468g = r101;
            Paint r105 = new Paint(1);
            this.f448463b = r105;
            r105.setColor(r100.f448439b.f448458c);
            int r106 = f.f448424a;
            this.f448469h = f.a(r100.f448439b.f448457b);
            PopupWindow r107 = new PopupWindow(this);
            this.f448462a = r107;
            r107.setClippingEnabled(false);
            int r108 = r103 + (r104 * 2);
            r107.setWidth(r108);
            r107.setHeight(r108);
            invalidate();
        }

        public void update(int r100, int r101) {
            update(r100, r101, 0);
        }

        private void update(int r100, int r101, int r102) {
            c r103 = this.f448477p.f448451n;
            if (r103 == null) goto L5;
            r103.b();
        L5:
            this.f448477p.f448441d.getLocationInWindow(this.f448475n);
            if (this.f448468g == false) goto L8;
            int r104 = this.f448477p.f448449l.f448433a;
        L9:
            int[] r105 = this.f448475n;
            int r106 = r100 - r105[0];
            int r107 = r101 - r105[1];
            Layout r108 = this.f448477p.f448440c.getLayout();
            if (r108 != null) goto L12;
            return;
        L12:
            int r109 = Math.max(0, r108.getLineForVertical(r107) - 1);
            int r110 = i.a(this.f448477p.f448440c.getLayout(), r106, r107 - (r108.getLineBottom(r109) - r108.getLineTop(r109)), r104);
            if (r102 <= 0) goto L15;
            r110 = Math.max(r110, r104);
        L18:
            if (r110 == r104) goto L39;
            m r111 = this.f448477p;
            r111.f448449l.getClass();
            r111.f448440c.clearSelection();
            boolean r112 = this.f448468g;
            if (r112 == true) goto L22;
            int r113 = this.f448472k;
            if (r110 >= r113) goto L37;
            m r114 = this.f448477p;
            b r115 = r114.f448444g;
            if (r115.f448468g == true) goto L36;
            r115 = r114.f448445h;
        L36:
            r115.f448468g = !r115.f448468g;
            r115.invalidate();
            this.f448468g = !this.f448468g;
            invalidate();
            int r116 = this.f448472k;
            this.f448473l = r116;
            this.f448477p.k(r110, r116);
            r115.d();
        L38:
            d();
            goto L39
        L37:
            this.f448477p.k(r113, r110);
            goto L38
        L22:
            if (r110 <= this.f448473l) goto L28;
            m r117 = this.f448477p;
            b r118 = r117.f448444g;
            if (r118.f448468g == false) goto L27;
            r118 = r117.f448445h;
        L27:
            this.f448468g = !r112;
            invalidate();
            r118.f448468g = !r118.f448468g;
            r118.invalidate();
            int r119 = this.f448473l;
            this.f448472k = r119;
            this.f448477p.k(r119, r110);
            r118.d();
        L29:
            d();
            goto L39
        L28:
            this.f448477p.k(r110, -1);
        L39:
            c r120 = this.f448477p.f448451n;
            if (r120 == null) goto L43;
            r120.a();
            return;
        L43:
            return;
        L15:
            if (r102 >= 0) goto L18;
            r110 = Math.min(r110, r104);
            goto L18
        L8:
            r104 = this.f448477p.f448449l.f448434b;
            goto L9
        }

        public final void c(float r100, float r101, int r102) {
            int[] r103 = this.f448469h;
            int r104 = ((int) r100) - r103[0];
            int r105 = ((int) r101) - r103[1];
            update((r104 + this.f448470i) - this.f448465d, (r105 + this.f448471j) - this.f448466e, r102);
        }
    }

    public interface c {
        void a();

        void b();
    }

    public interface d {
        void a(g r100);
    }

    @Override // com.ss.android.lark.widget.select.a
    public final g c() {
        CharSequence r100 = this.f448440c.getContent();     // Catch: Exception -> L47
        if (r100 != null) goto L6;
    L46:
        return null;
    L6:
        if (this.f448442e == null) goto L46;
        if (this.f448449l.f448434b > r100.length()) goto L46;
        h r101 = this.f448449l;     // Catch: Exception -> L47
        if (r101.f448433a >= 0) goto L13;
    L49:
        return null;
    L13:
        if (r101.f448434b > this.f448442e.length()) goto L49;
        Spannable r102 = this.f448442e;     // Catch: Exception -> L47
        h r103 = this.f448449l;     // Catch: Exception -> L47
        CharSequence r104 = r102.subSequence(r103.f448433a, r103.f448434b);     // Catch: Exception -> L47
        int[] r105 = new int[2];     // Catch: Exception -> L47
        this.f448441d.getLocationInWindow(r105);     // Catch: Exception -> L47
        Layout r106 = this.f448440c.getLayout();     // Catch: Exception -> L47
        if (r106 != null) goto L17;
        int r107 = -1;
    L18:
        int[] r108 = new int[2];     // Catch: Exception -> L47
        this.f448441d.getLocationInWindow(r108);     // Catch: Exception -> L47
        Layout r109 = this.f448440c.getLayout();     // Catch: Exception -> L47
        if (r109 != null) goto L21;
        int r110 = -1;
    L22:
        int r111 = this.f448449l.f448433a;     // Catch: Exception -> L47
        Layout r112 = this.f448440c.getLayout();     // Catch: Exception -> L47
        if (r112 != null) goto L25;
        int r113 = -1;
    L26:
        int r114 = this.f448449l.f448434b;     // Catch: Exception -> L47
        Layout r115 = this.f448440c.getLayout();     // Catch: Exception -> L47
        if (r115 != null) goto L29;
        int r116 = -1;
    L30:
        h r117 = this.f448449l;     // Catch: Exception -> L47
        int r118 = r117.f448433a;     // Catch: Exception -> L47
        int r119 = r117.f448434b;     // Catch: Exception -> L47
        Layout r120 = this.f448440c.getLayout();     // Catch: Exception -> L47
        if (r120 != null) goto L34;
    L36:
        boolean r121 = false;
    L37:
        h r122 = this.f448449l;     // Catch: Exception -> L47
        if (r122.f448433a <= 0) goto L40;
    L43:
        boolean r123 = true;
    L44:
        int r124 = r107;
        boolean r125 = r121;
        return new g(r104, r124, r110, r113, r116, r125, r123, i.b(this.f448443f, r122));
    L40:
        if (r122.f448434b < this.f448443f) goto L43;
        r123 = false;
        goto L44
    L34:
        if (r120.getLineForOffset(r118) != r120.getLineForOffset(r119)) goto L36;
        r121 = true;
        goto L37
    L29:
        r116 = (int) r115.getPrimaryHorizontal(r114);     // Catch: Exception -> L47
        goto L30
    L25:
        r113 = (int) r112.getPrimaryHorizontal(r111);     // Catch: Exception -> L47
        goto L26
    L21:
        r110 = r109.getLineBottom(r109.getLineForOffset(this.f448449l.f448434b)) + r108[1];     // Catch: Exception -> L47
        goto L22
    L17:
        r107 = r106.getLineTop(r106.getLineForOffset(this.f448449l.f448433a)) + r105[1];     // Catch: Exception -> L47
    L47:
        e = move-exception;
        Log.getStackTraceString(e);
        goto L49
    }

    @Override // com.ss.android.lark.widget.select.a
    public final void f() {
        this.f448447j = false;
        this.f448448k = false;
        PopupWindow r100 = this.f448444g.f448462a;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
        PopupWindow r101 = this.f448445h.f448462a;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
    }

    @Override // com.ss.android.lark.widget.select.a
    public final void a() {
        if (this.f448444g.f448474m == false) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L12;
        h();
        return;
    L12:
        return;
    L5:
        if (this.f448445h.f448474m == true) goto L8;
        r100 = false;
        goto L9
    }

    @Override // com.ss.android.lark.widget.select.a
    public final void b() {
        this.f448441d.getViewTreeObserver().removeOnScrollChangedListener(this.f448455r);
    }

    public final void h() {
        r r100 = this.f448452o;
        if (r100 == null) goto L5;
        r100.stop();
    L5:
        this.f448446i = false;
        this.f448447j = false;
        this.f448448k = false;
        this.f448449l.getClass();
        this.f448440c.clearSelection();
        f();
    }

    public final void i() {
        if (this.f448440c.getContent() != null) goto L5;
        return;
    L5:
        this.f448443f = this.f448440c.getContent().length();
        if ((this.f448440c.getContent() instanceof Spannable) == false) goto L9;
        this.f448442e = (Spannable) this.f448440c.getContent();
        return;
    }

    public final void j() {
    L8:
        e = move-exception;
        Log.getStackTraceString(e);
        return;
    L3:
        if (this.f448450m == null) goto L13;
        g r100 = c();     // Catch: Exception -> L8
        if (r100 == null) goto L14;
        this.f448450m.a(r100);     // Catch: Exception -> L8
        return;
    L14:
        return;
    }

    @Override // com.ss.android.lark.widget.select.a
    public final void show() {
        i();
        int r100 = this.f448443f;     // Catch: Exception -> L5
        h();     // Catch: Exception -> L5
        this.f448446i = true;     // Catch: Exception -> L5
        k(0, r100);     // Catch: Exception -> L5
        this.f448447j = true;     // Catch: Exception -> L5
        this.f448448k = true;     // Catch: Exception -> L5
        this.f448444g.b(null);     // Catch: Exception -> L5
        this.f448445h.b(null);     // Catch: Exception -> L5
        j();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.getStackTraceString(e);
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [com.ss.android.lark.widget.select.j] */
    public m(a r100) {
        this.f448446i = false;
        this.f448447j = false;
        this.f448448k = false;
        this.f448449l = new h();
        this.f448439b = r100;
        View r101 = r100.f448456a.getView();
        this.f448441d = r101;
        this.f448438a = r101.getContext();
        this.f448440c = r100.f448456a;
        this.f448444g = new b(this, true);
        this.f448445h = new b(this, false);
        r r102 = r100.f448460e;
        this.f448452o = r102;
        if (r102 == null) goto L6;
        r102.b(this.f448441d, new k(this));
    L6:
        this.f448441d.addOnAttachStateChangeListener(new l(this));
        this.f448455r = new j(this);
        this.f448441d.getViewTreeObserver().addOnScrollChangedListener(this.f448455r);
    }

    @Override // com.ss.android.lark.widget.select.a
    public final void d(com.larksuite.component.card.utils.c.a r100) {
        this.f448450m = r100;
    }

    @Override // com.ss.android.lark.widget.select.a
    public final void e(com.larksuite.component.card.utils.c.b r100) {
        this.f448451n = r100;
    }

    @Override // com.ss.android.lark.widget.select.a
    public final void g(int[] r100) {
        if (this.f448447j == false) goto L6;
        PopupWindow r101 = this.f448444g.f448462a;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
    L6:
        if (this.f448448k == false) goto L8;
        PopupWindow r102 = this.f448445h.f448462a;
        PopupWindowLancet.handleDismissBeforeOrigin(r102);
        r102.dismiss();
    L8:
        this.f448447j = true;
        this.f448448k = true;
        this.f448444g.b(r100);
        this.f448445h.b(r100);
    }

    public final void k(int r100, int r101) {
        if (r100 == (-1)) goto L5;
        this.f448449l.f448433a = r100;
    L5:
        if (r101 == (-1)) goto L7;
        this.f448449l.f448434b = r101;
    L7:
        h r102 = this.f448449l;
        int r103 = r102.f448433a;
        int r104 = r102.f448434b;
        if (r103 <= r104) goto L10;
        r102.f448433a = r104;
        r102.f448434b = r103;
    L10:
        CharSequence r105 = this.f448440c.getContent();
        if (r105 == null) goto L27;
        Layout r106 = this.f448440c.getLayout();
        int r107 = r105.length();
        if (r106 == null) goto L17;
        r107 = Math.min(r107, r106.getText().length());
    L17:
        h r108 = this.f448449l;
        int r109 = r108.f448433a;
        int r110 = r108.f448434b;
        r108.f448433a = Math.max(0, Math.min(r109, r107));
        h r111 = this.f448449l;
        r111.f448434b = Math.max(0, Math.min(r111.f448434b, r107));
        h r112 = this.f448449l;
        int r113 = r112.f448433a;
        int r114 = r112.f448434b;
        if (r113 <= r114) goto L21;
        r112.f448433a = r114;
        r112.f448434b = r113;
    L21:
        if (this.f448454q == true) goto L27;
        if (r109 == r112.f448433a) goto L25;
    L26:
        this.f448454q = true;
        com.ss.android.lark.log.Log.e("TextSelectHelper", "custom_error=text_select_helper_selection_offset_clamped, start=" + r109 + ", end=" + r110 + ", safeStart=" + this.f448449l.f448433a + ", safeEnd=" + this.f448449l.f448434b + ", length=" + r107, new RuntimeException("text select helper selection offset clamped"), true);
        goto L27
    L25:
        if (r110 != r112.f448434b) goto L26;
    L27:
        q r115 = this.f448440c;
        h r116 = this.f448449l;
        r115.setSelection(r116.f448433a, r116.f448434b);
    }

    public final void l(int r100, int r101) {
        i();
        if (r100 >= 0) goto L15;
    L10:
        int r102 = this.f448443f;     // Catch: Exception -> L8
        h();     // Catch: Exception -> L8
        this.f448446i = true;     // Catch: Exception -> L8
        k(0, r102);     // Catch: Exception -> L8
        this.f448447j = true;     // Catch: Exception -> L8
        this.f448448k = true;     // Catch: Exception -> L8
        this.f448444g.b(null);     // Catch: Exception -> L8
        this.f448445h.b(null);     // Catch: Exception -> L8
    L11:
        j();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.toString();
        return;
    L15:
        if (r101 > this.f448443f) goto L10;
        h();     // Catch: Exception -> L8
        this.f448446i = true;     // Catch: Exception -> L8
        k(r100, r101);     // Catch: Exception -> L8
        this.f448447j = true;     // Catch: Exception -> L8
        this.f448448k = true;     // Catch: Exception -> L8
        this.f448444g.b(null);     // Catch: Exception -> L8
        this.f448445h.b(null);     // Catch: Exception -> L8
        goto L11
    }

    public final void m(boolean r100, boolean r101) {
        b r102 = this.f448444g;
        boolean r103 = this.f448447j;
        if (r102.f448474m == true) goto L9;
        if (r103 == false) goto L7;
        PopupWindow r104 = r102.f448462a;
        PopupWindowLancet.handleDismissBeforeOrigin(r104);
        r104.dismiss();
    L7:
        if (r100 == false) goto L9;
        r102.b(null);
    L9:
        b r105 = this.f448445h;
        boolean r106 = this.f448448k;
        if (r105.f448474m == true) goto L17;
        if (r106 == false) goto L14;
        PopupWindow r107 = r105.f448462a;
        PopupWindowLancet.handleDismissBeforeOrigin(r107);
        r107.dismiss();
    L14:
        if (r101 == false) goto L17;
        r105.b(null);
    L17:
        if (this.f448444g.f448474m == true) goto L20;
        this.f448447j = r100;
    L20:
        if (this.f448445h.f448474m == true) goto L23;
        this.f448448k = r101;
        return;
    }
}
