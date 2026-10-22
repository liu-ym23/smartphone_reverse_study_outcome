package com.ss.android.photoeditor.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.ss.android.lark.log.Log;
import pfc.k;
import pfc.m;
import pfc.u;

/* JADX INFO: loaded from: classes38.dex */
public class TextEditorGestureView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pfc.g f449465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f449466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f449467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f449468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextEditorDrawView.c f449469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f449470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f449471g;

    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wfc.e f449472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PointF f449473b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f449474c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f449475d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f449476e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f449477f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f449478g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f449479h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f449480i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f449481j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f449482k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f449483l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f449484m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ TextEditorGestureView f449485n;

        @Override // com.ss.android.photoeditor.text.TextEditorGestureView.d
        public final int b() {
            return 1;
        }

        public a(TextEditorGestureView r100) {
            this.f449485n = r100;
            this.f449480i = 0;
            this.f449481j = true;
            this.f449484m = false;
        }

        @Override // com.ss.android.photoeditor.text.TextEditorGestureView.d
        public final void a(MotionEvent r210) {
            int r100 = r210.getAction();
            boolean r101 = false;
            if (r100 != 0) goto L5;
            this.f449481j = true;
            this.f449484m = false;
            this.f449480i = 0;
            TextEditorDrawView.f r102 = (TextEditorDrawView.f) this.f449485n.f449469e;
            wfc.e r103 = r102.f449455a.f449440q;
            if (r103 != null) goto L89;
            r103 = r102.f(r210.getX(), r210.getY());
            this.f449472a = r103;
            if (r103 != null) goto L89;
        L105:
            this.f449482k = r210.getX();
            this.f449483l = r210.getY();
            return;
        L89:
            TextEditorDrawView.c r104 = this.f449485n.f449469e;
            float r105 = r210.getX();
            float r106 = r210.getY();
            TextEditorDrawView.f r107 = (TextEditorDrawView.f) r104;
            float r108 = r107.c(r105);
            float r109 = r107.d(r106);
            float r110 = r103.f559509a * 10.0f;
            if (new RectF(r103.f559529u.x - com.ss.android.photoeditor.util.d.a(r110), r103.f559529u.y - com.ss.android.photoeditor.util.d.a(r110), r103.f559529u.x + com.ss.android.photoeditor.util.d.a(r110), r103.f559529u.y + com.ss.android.photoeditor.util.d.a(r110)).contains(r108, r109) == false) goto L93;
            this.f449480i |= 2;
        L104:
            this.f449474c = r210.getX();
            this.f449475d = r210.getY();
            this.f449476e = r103.f559509a;
            this.f449477f = r103.f559511c;
            PointF r111 = r103.f559510b;
            this.f449473b = new PointF(r111.x, r111.y);
            TextEditorDrawView.f r112 = (TextEditorDrawView.f) this.f449485n.f449469e;
            r112.getClass();
            PointF r113 = r103.f559510b;
            float r114 = r113.x;
            float r115 = r113.y;
            float r116 = r112.f449455a.f449443t.width() / r112.f449455a.f449447x.width();
            RectF r117 = r112.f449455a.f449443t;
            PointF r118 = new PointF((r114 * r116) + r117.left, (r115 * r116) + r117.top);
            this.f449478g = r118.x;
            this.f449479h = r118.y;
            Log.d("TextEditorGestureView", "selected ：" + r103);
            goto L105
        L93:
            if (((TextEditorDrawView.f) this.f449485n.f449469e).g(r103, r210.getX(), r210.getY()) == false) goto L95;
            this.f449480i |= 4;
            goto L104
        L95:
            TextEditorDrawView.c r119 = this.f449485n.f449469e;
            TextEditorDrawView.f r120 = (TextEditorDrawView.f) r119;
            if (r103.a(r120.c(r210.getX()), r120.d(r210.getY())) == false) goto L99;
            this.f449480i = 1 | this.f449480i;
            goto L104
        L99:
            if (r103.f559512d == false) goto L105;
            r103 = ((TextEditorDrawView.f) this.f449485n.f449469e).f(r210.getX(), r210.getY());
            this.f449472a = r103;
            if (r103 == null) goto L105;
            this.f449480i = 1 | this.f449480i;
            goto L104
        L5:
            if (r100 == 1) goto L29;
            if (r100 == 2) goto L12;
            if (r100 != 3) goto L119;
            this.f449485n.f449466b = null;
            return;
        L119:
            return;
        L12:
            if (this.f449484m == false) goto L14;
        L15:
            this.f449481j = false;
            this.f449484m = true;
            ((TextEditorDrawView.f) this.f449485n.f449469e).h(false);
            TextEditorDrawView.f r121 = (TextEditorDrawView.f) this.f449485n.f449469e;
            wfc.e r122 = r121.f449455a.f449440q;
            if (r122 == null) goto L18;
        L20:
            wfc.e r123 = this.f449472a;
            if (r123 == null) goto L23;
            r121.i(r123);
            r121.j(r122, false);
            r121.j(this.f449472a, true);
            r121.b();
            r122 = this.f449472a;
            this.f449472a = null;
        L23:
            float r124 = r210.getX();
            float r125 = r210.getY();
            int r126 = this.f449480i;
            if ((r126 & 1) == 0) goto L27;
            TextEditorDrawView.c r127 = this.f449485n.f449469e;
            PointF r128 = this.f449473b;
            PointF r129 = new PointF(r128.x, r128.y);
            float r130 = r124 - this.f449474c;
            float r131 = r125 - this.f449475d;
            TextEditorDrawView.f r132 = (TextEditorDrawView.f) r127;
            float r133 = r132.f449455a.f449447x.width() / r132.f449455a.f449443t.width();
            TextEditorDrawView r134 = r132.f449455a;
            float r135 = r129.x + (r130 * r133);
            float r136 = r129.y + (r131 * r133);
            int r137 = r122.f559511c;
            float r138 = r122.f559509a;
            r134.getClass();
            r122.update(r135, r136, r137, r138);
            ((TextEditorDrawView.f) this.f449485n.f449469e).b();
            return;
        L27:
            if ((2 & r126) == 0) goto L110;
            float r139 = (float) Math.sqrt(Math.pow(r124 - this.f449478g, 2.0d) + Math.pow(r125 - this.f449479h, 2.0d));
            float r140 = this.f449474c;
            float r141 = this.f449475d;
            float r142 = r139 / ((float) Math.sqrt(Math.pow(r140 - this.f449478g, 2.0d) + Math.pow(r141 - this.f449479h, 2.0d)));
            PointF r143 = new PointF(this.f449474c, this.f449475d);
            PointF r144 = new PointF(r124, r125);
            PointF r145 = new PointF(this.f449478g, this.f449479h);
            double r146 = Math.atan2(r143.y - r145.y, r143.x - r145.x);
            double r147 = Math.atan2(r144.y - r145.y, r144.x - r145.x);
            Log.i("PhotoEditorUtil", "start angle = " + ((r146 / 3.141592653589793d) * 180.0d) + " , end angle = " + ((r147 / 3.141592653589793d) * 180.0d));
            TextEditorDrawView.c r148 = this.f449485n.f449469e;
            int r149 = this.f449477f + ((int) ((float) (((r147 - r146) / 3.141592653589793d) * 180.0d)));
            float r150 = this.f449476e * r142;
            TextEditorDrawView r151 = ((TextEditorDrawView.f) r148).f449455a;
            PointF r152 = r122.f559510b;
            float r153 = r152.x;
            float r154 = r152.y;
            int r155 = TextEditorDrawView.D;
            r151.getClass();
            r122.update(r153, r154, r149, r150);
            ((TextEditorDrawView.f) this.f449485n.f449469e).b();
            sfc.a.f541747a.getClass();
            sfc.a.f541754h = true;
            return;
        L110:
            return;
        L18:
            if (this.f449472a != null) goto L20;
            return;
        L14:
            if (pfc.a.a(this.f449485n.getContext(), this.f449482k, this.f449483l, r210.getX(), r210.getY()) == true) goto L15;
            return;
        L29:
            TextEditorGestureView r156 = this.f449485n;
            r156.f449466b = null;
            if (this.f449481j == true) goto L32;
            ((TextEditorDrawView.f) r156.f449469e).h(true);
            return;
        L32:
            if ((this.f449480i & 4) == 0) goto L39;
            float r157 = r210.getX();
            float r158 = r210.getY();
            TextEditorDrawView.f r159 = (TextEditorDrawView.f) this.f449485n.f449469e;
            wfc.e r160 = r159.f449455a.f449440q;
            if (r160 != null) goto L36;
            return;
        L36:
            if (r159.g(r160, r157, r158) == false) goto L113;
            TextEditorDrawView.f r161 = (TextEditorDrawView.f) this.f449485n.f449469e;
            r161.e(r160);
            r161.i(null);
            r161.b();
            return;
        L113:
            return;
        L39:
            if (((TextEditorDrawView.f) r156.f449469e).f449455a.f449440q != null) goto L50;
            float r162 = r210.getX();
            float r163 = r210.getY();
            wfc.e r164 = ((TextEditorDrawView.f) this.f449485n.f449469e).f(r162, r163);
            if (r164 == null) goto L43;
            TextEditorDrawView.f r165 = (TextEditorDrawView.f) this.f449485n.f449469e;
            r165.j(r164, true);
            r165.i(r164);
            ((TextEditorDrawView.f) this.f449485n.f449469e).b();
        L46:
            TextEditorDrawView.f r166 = (TextEditorDrawView.f) this.f449485n.f449469e;
            TextEditorDrawView.d r167 = r166.f449455a.f449446w;
            if (r167 == null) goto L49;
            r101 = ((h) r167).f449539a.f449515c.f529038b;
        L49:
            r166.h(true ^ r101);
            return;
        L43:
            wfc.e r168 = ((TextEditorDrawView.f) this.f449485n.f449469e).a((int) r162, (int) r163);
            if (r168 == null) goto L46;
            TextEditorDrawView.f r169 = (TextEditorDrawView.f) this.f449485n.f449469e;
            r169.j(r168, true);
            r169.i(r168);
            ((TextEditorDrawView.f) this.f449485n.f449469e).b();
            goto L46
        L50:
            float r170 = r210.getX();
            float r171 = r210.getY();
            TextEditorDrawView.f r172 = (TextEditorDrawView.f) this.f449485n.f449469e;
            wfc.e r173 = r172.f449455a.f449440q;
            if (r173 != null) goto L54;
            return;
        L54:
            if (r173.a(r172.c(r170), r172.d(r171)) == false) goto L69;
            com.ss.android.photoeditor.text.b r174 = (com.ss.android.photoeditor.text.b) this.f449485n.f449467c;
            r174.getClass();
            if (r173.f559512d == true) goto L58;
            r174.f449531a.f449493c.setText("");
        L59:
            r174.f449531a.f449493c.setTextColor(r173.f559517i);
            r174.f449531a.f449493c.setVisibility(0);
            TextInputView r175 = r174.f449531a.f449493c;
            if (r175.f449505h == null) goto L65;
            r175.f449503f.setFocusable(true);
            r175.f449503f.setFocusableInTouchMode(true);
            r175.f449503f.requestFocus();
            InputMethodManager r176 = (InputMethodManager) r175.f449503f.getContext().getSystemService("input_method");
            if (r176 == null) goto L65;
            r176.showSoftInput(r175.f449503f, 0);
        L65:
            k.a r177 = r174.f449531a.f449494d;
            if (r177 == null) goto L68;
            ((u) r177).f529098a.f529106h.setVisibility(8);
        L68:
            r174.f449531a.f449497g = false;
            return;
        L58:
            r174.f449531a.f449493c.setText(r173.f559515g);
            goto L59
        L69:
            TextEditorDrawView.f r178 = (TextEditorDrawView.f) this.f449485n.f449469e;
            wfc.e r179 = r178.f449455a.f449440q;
            if (r179 != null) goto L73;
            return;
        L73:
            if (r179.f559512d == true) goto L75;
            r179.update(r178.c(r170), r178.d(r171), r179.f559511c, r179.f559509a);
        L79:
            TextEditorDrawView.f r180 = (TextEditorDrawView.f) this.f449485n.f449469e;
            TextEditorDrawView.d r181 = r180.f449455a.f449446w;
            if (r181 == null) goto L82;
            r101 = ((h) r181).f449539a.f449515c.f529038b;
        L82:
            r180.h(true ^ r101);
            ((TextEditorDrawView.f) this.f449485n.f449469e).b();
            return;
        L75:
            r178.j(r179, false);
            wfc.e r182 = ((TextEditorDrawView.f) this.f449485n.f449469e).f(r170, r171);
            if (r182 == null) goto L78;
            ((TextEditorDrawView.f) this.f449485n.f449469e).j(r182, true);
        L78:
            ((TextEditorDrawView.f) this.f449485n.f449469e).i(r182);
            goto L79
        }
    }

    public class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m f449486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public m f449487b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public wfc.e f449488c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TextEditorGestureView f449489d;

        @Override // com.ss.android.photoeditor.text.TextEditorGestureView.d
        public final int b() {
            return 2;
        }

        public b(TextEditorGestureView r100) {
            this.f449489d = r100;
        }

        @Override // com.ss.android.photoeditor.text.TextEditorGestureView.d
        public final void a(MotionEvent r100) {
            TextEditorGestureView r101 = this.f449489d;
            if (((TextEditorDrawView.f) r101.f449469e).f449455a.f449440q != null) goto L6;
            r101.f449465a.a(r100);
            return;
        L6:
            int r102 = r100.getAction() & 255;
            if (r102 != 0) goto L9;
            ((TextEditorDrawView.f) this.f449489d.f449469e).h(false);
            return;
        L9:
            if (r102 != 1) goto L11;
        L33:
            ((TextEditorDrawView.f) this.f449489d.f449469e).h(true);
            this.f449489d.f449466b = null;
            return;
        L11:
            if (r102 == 2) goto L19;
            if (r102 != 5) goto L15;
            this.f449488c = ((TextEditorDrawView.f) this.f449489d.f449469e).f449455a.f449440q;
            this.f449486a = new m(r100.getX(), r100.getY(), r100.getX(1), r100.getY(1));
            return;
        L15:
            if (r102 == 6) goto L33;
            return;
        L19:
            if (r100.getPointerCount() != 2) goto L40;
            ((TextEditorDrawView.f) this.f449489d.f449469e).h(false);
            m r103 = this.f449487b;
            if (r103 != null) goto L24;
            this.f449487b = new m(r100.getX(), r100.getY(), r100.getX(1), r100.getY(1));
        L25:
            m r104 = this.f449486a;
            m r105 = this.f449487b;
            r104.getClass();
            float r106 = r105.a() / r104.a();
            m r107 = this.f449486a;
            m r108 = this.f449487b;
            float r109 = 0.0f;
            if ((r107.b() * r108.b()) < 0.0f) goto L29;
            r109 = ((r108.b() - r107.b()) / 3.1415927f) * 180.0f;
        L29:
            wfc.e r110 = this.f449488c;
            if (r110 == null) goto L32;
            TextEditorDrawView.c r111 = this.f449489d.f449469e;
            int r112 = ((int) r109) + r110.f559511c;
            float r113 = r106 * r110.f559509a;
            TextEditorDrawView.f r114 = (TextEditorDrawView.f) r111;
            TextEditorDrawView r115 = r114.f449455a;
            PointF r116 = r110.f559510b;
            float r117 = r116.x;
            float r118 = r116.y;
            int r119 = TextEditorDrawView.D;
            r115.getClass();
            r110.update(r117, r118, r112, r113);
            r114.b();
        L32:
            this.f449486a.d(this.f449487b);
            return;
        L24:
            r103.c(r100.getX(), r100.getY(), r100.getX(1), r100.getY(1));
            goto L25
        }
    }

    public class c extends pfc.g.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextEditorGestureView f449490a;

        @Override // pfc.g.d
        public final void b() {
            this.f449490a.f449469e.getClass();
            this.f449490a.f449466b = null;
        }

        public c(TextEditorGestureView r100) {
            this.f449490a = r100;
        }

        @Override // pfc.g.d
        public final void a(RectF r100) {
            TextEditorDrawView.f r101 = (TextEditorDrawView.f) this.f449490a.f449469e;
            r101.f449455a.f449443t.set(r100);
            r101.f449455a.invalidate();
        }

        @Override // pfc.g.d
        public final void c(RectF r100) {
            this.f449490a.getClass();
        }
    }

    public interface d {
        void a(MotionEvent r100);

        int b();
    }

    public interface e {
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
    }

    public TextEditorGestureView(Context r100) {
        super(r100);
        this.f449470f = new a(this);
        this.f449471g = new b(this);
        setBackgroundColor(0);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f449468d == false) goto L20;
        d r101 = this.f449466b;
        if (r101 != null) goto L7;
        int r102 = r100.getPointerCount();
        if (r102 == 1) goto L15;
        if (r102 != 2) goto L20;
        b r103 = this.f449471g;
        this.f449466b = r103;
        r103.a(r100);
        Log.d("TextEditorGestureView", "double point touch");
        goto L20
    L15:
        if (r100.getAction() != 0) goto L17;
        a r104 = this.f449470f;
        this.f449466b = r104;
        r104.a(r100);
    L17:
        Log.d("TextEditorGestureView", "single point touch");
        goto L20
    L7:
        if (r101.b() == 1) goto L9;
    L11:
        this.f449466b.a(r100);
        goto L20
    L9:
        if (r100.getPointerCount() != 2) goto L11;
        b r105 = this.f449471g;
        this.f449466b = r105;
        r105.a(r100);
    L20:
        return true;
    }

    public void setOnEditTextListener(e r100) {
        this.f449467c = r100;
    }

    public void setTextEditorView(TextEditorDrawView.c r100) {
        this.f449469e = r100;
        this.f449465a = new pfc.g(((TextEditorDrawView.f) r100).f449455a.f449436m, ((TextEditorDrawView.f) r100).f449455a.f449443t, new c(this), null);
    }

    public TextEditorGestureView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f449470f = new a(this);
        this.f449471g = new b(this);
        setBackgroundColor(0);
    }

    public TextEditorGestureView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f449470f = new a(this);
        this.f449471g = new b(this);
        setBackgroundColor(0);
    }
}
