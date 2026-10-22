package com.ss.android.lark.widget.select;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.common.utility.Logger;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes38.dex */
public final class p implements com.ss.android.lark.widget.select.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f448480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f448481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f448482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Spannable f448483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BackgroundColorSpan f448484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f448485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f448486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f448487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f448488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h f448489j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m.d f448490k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public m.c f448491l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f448492m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public n f448493n;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f448494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Activity f448495b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f448496c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f448497d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f448498e;

        public a(TextView r100, Activity r101) {
            this.f448494a = r100;
            this.f448495b = r101;
        }
    }

    public class b extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PopupWindow f448499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f448500b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f448501c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f448502d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f448503e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f448504f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f448505g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int[] f448506h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f448507i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f448508j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f448509k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f448510l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f448511m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int[] f448512n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ p f448513o;

        public final int a() {
            return (this.f448512n[0] - this.f448504f) + this.f448513o.f448482c.getPaddingLeft();
        }

        public final void c() {
            this.f448513o.f448482c.getLocationInWindow(this.f448512n);
            CharSequence r100 = this.f448513o.f448482c.getText();
            Layout r101 = this.f448513o.f448482c.getLayout();
            if (r101 != null) goto L6;
            return;
        L6:
            if (this.f448505g == false) goto L8;
            int r102 = this.f448513o.f448489j.f448433a;
            int r103 = (((int) r101.getPrimaryHorizontal(r102)) - this.f448502d) + a();
            int r104 = r101.getLineForOffset(r102);
            int r105 = (((r101.getLineTop(r104) + r101.getLineBottom(r104)) / 2) + (this.f448512n[1] + this.f448513o.f448482c.getPaddingTop())) - this.f448504f;
        L16:
            PopupWindow r106 = this.f448499a;
            if ((r106 instanceof PopupWindow) == false) goto L22;
            if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r106) == false) goto L22;
            r106.update(r103, r105, -1, -1);
            return;
        L22:
            if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r106, r103, r105, -1, -1) == true) goto L29;
            r106.update(r103, r105, -1, -1);
            return;
        L29:
            return;
        L8:
            int r107 = this.f448513o.f448489j.f448434b;
        L9:
            if (r107 <= 0) goto L13;
            int r108 = r107 - 1;
            if ('\n' != r100.charAt(r108)) goto L13;
            r107 = r108;
        L13:
            if (r107 > 0) goto L15;
            r107 = 0;
        L15:
            this.f448513o.f448489j.f448434b = r107;
            int r109 = ((int) r101.getPrimaryHorizontal(r107)) + a();
            int r110 = r101.getLineForOffset(r107);
            r105 = (((r101.getLineTop(r110) + r101.getLineBottom(r110)) / 2) + (this.f448512n[1] + this.f448513o.f448482c.getPaddingTop())) - this.f448504f;
            r103 = r109;
            goto L16
        }

        @Override // android.view.View
        public final boolean performClick() {
            return super.performClick();
        }

        public final void b(int[] r110) {
            Layout r100 = this.f448513o.f448482c.getLayout();
            if (r100 != null) goto L6;
            return;
        L6:
            if (this.f448505g == false) goto L8;
            int r101 = this.f448513o.f448489j.f448433a;
        L9:
            int r102 = r100.getLineForOffset(r101);
            int r103 = (int) r100.getPrimaryHorizontal(r101);
            int r104 = ((r100.getLineTop(r102) + r100.getLineBottom(r102)) / 2) - this.f448504f;
            this.f448513o.f448482c.getLocationInWindow(this.f448512n);
            if (this.f448505g == false) goto L12;
            int r105 = this.f448502d;
        L13:
            int r106 = t.a(r104 + (this.f448512n[1] + this.f448513o.f448482c.getPaddingTop()), this.f448513o.f448481b.f448495b);
            if (r110 != null) goto L16;
        L23:
            PopupWindow r111 = this.f448499a;
            TextView r107 = this.f448513o.f448482c;
            int r108 = (r103 - r105) + a();
            if (PopupWindowLancet.hasSubWindowToken(r107) == false) goto L27;
            return;
        L27:
            if ((r111 instanceof PopupWindow) == true) goto L29;
        L31:
            OverlaySource r109 = PopupWindowLancet.resolveSource(r107);
            if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r111, r107, r109, 0, r108, r106) == true) goto L40;
            r111.showAtLocation(r107, 0, r108, r106);
            PopupWindowLancet.trackAfterShow(r111, r109, r107);
            return;
        L40:
            return;
        L29:
            if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r111) == false) goto L31;
            r111.showAtLocation(r107, 0, r108, r106);
            return;
        L16:
            if (r110.length != 2) goto L23;
            int r112 = r110[0];
            int r113 = r110[1];
            if (r106 <= r112) goto L21;
            if (r106 >= r113) goto L21;
            return;
        L21:
            if (((this.f448503e + r106) + this.f448504f) <= r112) goto L23;
            return;
        L12:
            r105 = 0;
            goto L13
        L8:
            r101 = this.f448513o.f448489j.f448434b;
            goto L9
        }

        @Override // android.view.View
        public final void onDraw(Canvas r110) {
            int r100 = this.f448501c;
            int r101 = this.f448504f;
            r110.drawCircle(r100 + r101, r101 + r100, r100, this.f448500b);
            if (this.f448505g == false) goto L5;
            int r102 = this.f448501c;
            int r103 = this.f448504f;
            r110.drawRect(r102 + r103, r103, (r102 * 2) + r103, r102 + r103, this.f448500b);
            return;
        L5:
            int r104 = this.f448504f;
            int r105 = this.f448501c;
            r110.drawRect(r104, r104, r105 + r104, r105 + r104, this.f448500b);
        }

        @Override // android.view.View
        public final boolean onTouchEvent(MotionEvent r100) {
            int r101 = r100.getAction();
            if (r101 != 0) goto L5;
            h r102 = this.f448513o.f448489j;
            this.f448509k = r102.f448433a;
            this.f448510l = r102.f448434b;
            this.f448507i = (int) r100.getX();
            this.f448508j = (int) r100.getY();
            this.f448511m = true;
        L15:
            return true;
        L5:
            if (r101 != 1) goto L7;
            super.performClick();
            this.f448511m = false;
            this.f448513o.h();
            goto L15
        L7:
            if (r101 != 2) goto L9;
            int r103 = ((int) r100.getRawX()) - this.f448506h[0];
            int r104 = ((int) r100.getRawY()) - this.f448506h[1];
            update((r103 + this.f448507i) - this.f448502d, (r104 + this.f448508j) - this.f448503e);
            goto L15
        L9:
            if (r101 != 3) goto L15;
            this.f448511m = false;
            this.f448513o.h();
            goto L15
        }

        public b(p r100, boolean r101) {
            this.f448513o = r100;
            super(r100.f448480a);
            int r102 = (int) (r100.f448481b.f448498e / 2.0f);
            this.f448501c = r102;
            int r103 = r102 * 2;
            this.f448502d = r103;
            this.f448503e = r103;
            int r104 = UIHelper.dp2px(20.0f);
            this.f448504f = r104;
            this.f448506h = new int[2];
            this.f448512n = new int[2];
            this.f448505g = r101;
            Paint r105 = new Paint(1);
            this.f448500b = r105;
            r105.setColor(r100.f448481b.f448496c);
            int r106 = f.f448424a;
            this.f448506h = f.a(r100.f448481b.f448495b);
            PopupWindow r107 = new PopupWindow(this);
            this.f448499a = r107;
            r107.setClippingEnabled(false);
            int r108 = r103 + (r104 * 2);
            r107.setWidth(r108);
            r107.setHeight(r108);
            invalidate();
        }

        public void update(int r100, int r101) {
            m.c r102 = this.f448513o.f448491l;
            if (r102 == null) goto L5;
            r102.b();
        L5:
            this.f448513o.f448482c.getLocationInWindow(this.f448512n);
            if (this.f448505g == false) goto L8;
            int r103 = this.f448513o.f448489j.f448433a;
        L9:
            int[] r104 = this.f448512n;
            int r105 = r100 - r104[0];
            int r106 = r101 - r104[1];
            Layout r107 = this.f448513o.f448482c.getLayout();
            int r108 = r107.getLineForVertical(r106);
            int r109 = i.a(this.f448513o.f448482c.getLayout(), r105, r106 - (r107.getLineBottom(r108) - r107.getLineTop(r108)), r103);
            if (r109 == r103) goto L38;
            p r110 = this.f448513o;
            r110.f448489j.getClass();
            Spannable r111 = r110.f448483d;
            if (r111 == null) goto L17;
            Selection.removeSelection(r111);
            BackgroundColorSpan r112 = r110.f448484e;
            if (r112 == null) goto L16;
            r110.f448483d.removeSpan(r112);
        L16:
            r110.f448482c.invalidate();
        L17:
            boolean r113 = this.f448505g;
            if (r113 == true) goto L20;
            int r114 = this.f448509k;
            if (r109 >= r114) goto L35;
            p r115 = this.f448513o;
            b r116 = r115.f448486g;
            if (r116.f448505g == true) goto L34;
            r116 = r115.f448487h;
        L34:
            r116.f448505g = !r116.f448505g;
            r116.invalidate();
            this.f448505g = !this.f448505g;
            invalidate();
            int r117 = this.f448509k;
            this.f448510l = r117;
            this.f448513o.i(r109, r117);
            r116.c();
        L36:
            c();
            return;
        L35:
            this.f448513o.i(r114, r109);
            goto L36
        L20:
            if (r109 <= this.f448510l) goto L26;
            p r118 = this.f448513o;
            b r119 = r118.f448486g;
            if (r119.f448505g == false) goto L25;
            r119 = r118.f448487h;
        L25:
            this.f448505g = !r113;
            invalidate();
            r119.f448505g = !r119.f448505g;
            r119.invalidate();
            int r120 = this.f448510l;
            this.f448509k = r120;
            this.f448513o.i(r120, r109);
            r119.c();
        L27:
            c();
            return;
        L26:
            this.f448513o.i(r109, -1);
            goto L27
        L38:
            return;
        L8:
            r103 = this.f448513o.f448489j.f448434b;
            goto L9
        }
    }

    @Override // com.ss.android.lark.widget.select.a
    public final g c() {
        Spannable r100 = this.f448483d;     // Catch: Exception -> L48
        if (r100 == null) goto L47;
        h r101 = this.f448489j;     // Catch: Exception -> L48
        if (r101.f448433a < 0) goto L47;
        if (r101.f448434b > r100.length()) goto L47;
        h r102 = this.f448489j;     // Catch: Exception -> L48
        int r103 = r102.f448433a;     // Catch: Exception -> L48
        int r104 = r102.f448434b;     // Catch: Exception -> L48
        if (r103 > r104) goto L47;
        CharSequence r105 = this.f448483d.subSequence(r103, r104);     // Catch: Exception -> L48
        if (TextUtils.isEmpty(r105) == false) goto L15;
        return null;
    L15:
        int[] r106 = new int[2];     // Catch: Exception -> L48
        this.f448482c.getLocationInWindow(r106);     // Catch: Exception -> L48
        Layout r107 = this.f448482c.getLayout();     // Catch: Exception -> L48
        if (r107 != null) goto L18;
        int r108 = -1;
    L19:
        int[] r109 = new int[2];     // Catch: Exception -> L48
        this.f448482c.getLocationInWindow(r109);     // Catch: Exception -> L48
        Layout r110 = this.f448482c.getLayout();     // Catch: Exception -> L48
        if (r110 != null) goto L22;
        int r111 = -1;
    L23:
        int r112 = this.f448489j.f448433a;     // Catch: Exception -> L48
        Layout r113 = this.f448482c.getLayout();     // Catch: Exception -> L48
        if (r113 != null) goto L26;
        int r114 = -1;
    L27:
        int r115 = this.f448489j.f448434b;     // Catch: Exception -> L48
        Layout r116 = this.f448482c.getLayout();     // Catch: Exception -> L48
        if (r116 != null) goto L30;
        int r117 = -1;
    L31:
        h r118 = this.f448489j;     // Catch: Exception -> L48
        int r119 = r118.f448433a;     // Catch: Exception -> L48
        int r120 = r118.f448434b;     // Catch: Exception -> L48
        Layout r121 = this.f448482c.getLayout();     // Catch: Exception -> L48
        if (r121 != null) goto L35;
    L37:
        boolean r122 = false;
    L38:
        h r123 = this.f448489j;     // Catch: Exception -> L48
        if (r123.f448433a <= 0) goto L41;
    L44:
        boolean r124 = true;
    L45:
        int r125 = r108;
        boolean r126 = r122;
        return new g(r105, r125, r111, r114, r117, r126, r124, i.b(this.f448485f, r123));
    L41:
        if (r123.f448434b < this.f448485f) goto L44;
        r124 = false;
        goto L45
    L35:
        if (r121.getLineForOffset(r119) != r121.getLineForOffset(r120)) goto L37;
        r122 = true;
        goto L38
    L30:
        r117 = (int) r116.getPrimaryHorizontal(r115);     // Catch: Exception -> L48
        goto L31
    L26:
        r114 = (int) r113.getPrimaryHorizontal(r112);     // Catch: Exception -> L48
        goto L27
    L22:
        r111 = r110.getLineBottom(r110.getLineForOffset(this.f448489j.f448434b)) + r109[1];     // Catch: Exception -> L48
        goto L23
    L18:
        r108 = r107.getLineTop(r107.getLineForOffset(this.f448489j.f448433a)) + r106[1];     // Catch: Exception -> L48
    L47:
        return null;
    L48:
        e = move-exception;
        Log.e("TextSelectHelper2", e);
        return null;
    }

    @Override // com.ss.android.lark.widget.select.a
    public final void f() {
        this.f448488i = false;
        PopupWindow r100 = this.f448486g.f448499a;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
        PopupWindow r101 = this.f448487h.f448499a;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
    }

    @Override // com.ss.android.lark.widget.select.a
    public final void a() {
        if (this.f448486g.f448511m == false) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L18;
        this.f448488i = false;
        this.f448489j.getClass();
        Spannable r101 = this.f448483d;
        if (r101 == null) goto L16;
        Selection.removeSelection(r101);
        BackgroundColorSpan r102 = this.f448484e;
        if (r102 == null) goto L15;
        this.f448483d.removeSpan(r102);
    L15:
        this.f448482c.invalidate();
    L16:
        f();
        return;
    L18:
        return;
    L5:
        if (this.f448487h.f448511m == true) goto L8;
        r100 = false;
        goto L9
    }

    @Override // com.ss.android.lark.widget.select.a
    public final void b() {
        this.f448482c.getViewTreeObserver().removeOnScrollChangedListener(this.f448493n);
    }

    public final void h() {
    L8:
        e = move-exception;
        Log.e("TextSelectHelper2", e);
        return;
    L3:
        if (this.f448490k == null) goto L13;
        g r100 = c();     // Catch: Exception -> L8
        if (r100 == null) goto L14;
        this.f448490k.a(r100);     // Catch: Exception -> L8
        return;
    L14:
        return;
    }

    @Override // com.ss.android.lark.widget.select.a
    public final void show() {
        if (this.f448482c.getText() != null) goto L5;
        Log.e("TextSelectHelper2", "content is empty, skip show");
    L19:
        int r100 = this.f448485f;     // Catch: Exception -> L16
        this.f448488i = false;     // Catch: Exception -> L16
        this.f448489j.getClass();     // Catch: Exception -> L16
        Spannable r101 = this.f448483d;     // Catch: Exception -> L16
        if (r101 == null) goto L14;
        Selection.removeSelection(r101);     // Catch: Exception -> L16
        BackgroundColorSpan r102 = this.f448484e;     // Catch: Exception -> L16
        if (r102 == null) goto L13;
        this.f448483d.removeSpan(r102);     // Catch: Exception -> L16
    L13:
        this.f448482c.invalidate();     // Catch: Exception -> L16
    L14:
        f();     // Catch: Exception -> L16
        i(0, r100);     // Catch: Exception -> L16
        this.f448488i = true;     // Catch: Exception -> L16
        this.f448486g.b(null);     // Catch: Exception -> L16
        this.f448487h.b(null);     // Catch: Exception -> L16
        h();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        Log.e("TextSelectHelper2", e);
        return;
    L5:
        this.f448485f = this.f448482c.getText().length();
        if ((this.f448482c.getText() instanceof Spannable) == false) goto L19;
        this.f448483d = (Spannable) this.f448482c.getText();
        goto L19
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.ss.android.lark.widget.select.n] */
    public p(a r100) {
        this.f448488i = false;
        this.f448489j = new h();
        this.f448481b = r100;
        TextView r101 = r100.f448494a;
        this.f448482c = r101;
        this.f448480a = r101.getContext();
        this.f448486g = new b(this, true);
        this.f448487h = new b(this, false);
        this.f448482c.addOnAttachStateChangeListener(new o(this));
        this.f448493n = new n(this);
        this.f448482c.getViewTreeObserver().addOnScrollChangedListener(this.f448493n);
    }

    @Override // com.ss.android.lark.widget.select.a
    public final void d(com.larksuite.component.card.utils.c.a r100) {
        this.f448490k = r100;
    }

    @Override // com.ss.android.lark.widget.select.a
    public final void e(com.larksuite.component.card.utils.c.b r100) {
        this.f448491l = r100;
    }

    @Override // com.ss.android.lark.widget.select.a
    public final void g(int[] r100) {
        if (this.f448488i == false) goto L5;
        f();
    L5:
        this.f448488i = true;
        this.f448486g.b(r100);
        this.f448487h.b(r100);
    }

    public final void i(int r100, int r101) {
        if (r100 == (-1)) goto L5;
        this.f448489j.f448433a = r100;
    L5:
        if (r101 == (-1)) goto L7;
        this.f448489j.f448434b = r101;
    L7:
        h r102 = this.f448489j;
        int r103 = r102.f448433a;
        int r104 = r102.f448434b;
        if (r103 <= r104) goto L11;
        r102.f448433a = r104;
        r102.f448434b = r103;
    L11:
        if (this.f448483d == null) goto L37;
        Layout r105 = this.f448482c.getLayout();
        if (r105 != null) goto L15;
        int r106 = this.f448483d.length();
    L16:
        h r107 = this.f448489j;
        int r108 = r107.f448433a;
        int r109 = r107.f448434b;
        r107.f448433a = Math.max(0, Math.min(r108, r106));
        h r110 = this.f448489j;
        r110.f448434b = Math.max(0, Math.min(r110.f448434b, r106));
        h r111 = this.f448489j;
        int r112 = r111.f448433a;
        int r113 = r111.f448434b;
        if (r112 <= r113) goto L20;
        r111.f448433a = r113;
        r111.f448434b = r112;
    L20:
        if (this.f448492m == true) goto L27;
        if (r108 == r111.f448433a) goto L24;
    L25:
        this.f448492m = true;
        Log.e("TextSelectHelper2", "custom_error=text_select_helper2_selection_offset_clamped, start=" + r108 + ", end=" + r109 + ", safeStart=" + this.f448489j.f448433a + ", safeEnd=" + this.f448489j.f448434b + ", length=" + r106, new RuntimeException("text select helper2 selection offset clamped"), true);
        goto L27
    L24:
        if (r109 != r111.f448434b) goto L25;
    L27:
        if (this.f448484e != null) goto L35;
        this.f448484e = new BackgroundColorSpan(this.f448481b.f448497d);
    L35:
        Spannable r114 = this.f448483d;     // Catch: IndexOutOfBoundsException -> L31
        BackgroundColorSpan r115 = this.f448484e;     // Catch: IndexOutOfBoundsException -> L31
        h r116 = this.f448489j;     // Catch: IndexOutOfBoundsException -> L31
        r114.setSpan(r115, r116.f448433a, r116.f448434b, 17);     // Catch: IndexOutOfBoundsException -> L31
    L33:
        Spannable r117 = this.f448483d;
        h r118 = this.f448489j;
        Selection.setSelection(r117, r118.f448433a, r118.f448434b);
        this.f448482c.invalidate();
        return;
    L31:
        e = move-exception;
        Logger.e("TextSelectHelper2", "selectTextByPosition error:" + e.getMessage());
        goto L33
    L15:
        r106 = Math.min(this.f448483d.length(), r105.getText().length());
        goto L16
    }
}
