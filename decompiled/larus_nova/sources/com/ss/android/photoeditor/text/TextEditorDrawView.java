package com.ss.android.photoeditor.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import pfc.k;
import pfc.u;

/* JADX INFO: loaded from: classes38.dex */
public class TextEditorDrawView extends AppCompatImageView {
    public static final /* synthetic */ int D = 0;
    public final Map<wfc.e, g> A;
    public k.a B;
    public b C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f449424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f449425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f449426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public pfc.f.a f449427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f449428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f449429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f449430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f449431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Bitmap f449432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Canvas f449433j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Canvas f449434k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Canvas f449435l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RectF f449436m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float[] f449437n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f449438o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f449439p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public wfc.e f449440q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<wfc.e> f449441r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public f f449442s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public RectF f449443t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public pfc.b f449444u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f449445v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public d f449446w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public RectF f449447x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public e f449448y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f449449z;

    public class a extends pfc.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextEditorDrawView f449450a;

        public a(TextEditorDrawView r100) {
            this.f449450a = r100;
        }

        @Override // pfc.b.c
        public final void d(RectF r100) {
            this.f449450a.f449443t.set(r100);
            this.f449450a.invalidate();
        }
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RectF f449451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RectF f449452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f449453c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RectF f449454d;

        public e() {
        }
    }

    public class f implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextEditorDrawView f449455a;

        public final f b() {
            TextEditorDrawView r100 = this.f449455a;
            if (r100.f449449z == false) goto L5;
            r100.m(true);
        L6:
            TextEditorDrawView r101 = this.f449455a;
            r101.f449449z = false;
            r101.invalidate();
            return this;
        L5:
            r100.m(false);
            goto L6
        }

        public f(TextEditorDrawView r100) {
            this.f449455a = r100;
        }

        public final float c(float r100) {
            TextEditorDrawView r101 = this.f449455a;
            return (r100 - r101.f449443t.left) * (r101.f449447x.width() / this.f449455a.f449443t.width());
        }

        public final float d(float r100) {
            TextEditorDrawView r101 = this.f449455a;
            return (r100 - r101.f449443t.top) * (r101.f449447x.height() / this.f449455a.f449443t.height());
        }

        public final f e(wfc.e r100) {
            if (r100 == null) goto L12;
            ((ArrayList) this.f449455a.f449441r).remove(r100);
            if (((HashMap) this.f449455a.A).containsKey(r100) == false) goto L9;
            g r101 = (g) ((HashMap) this.f449455a.A).get(r100);
            if (r101 == null) goto L8;
            r101.f449456c = false;
            r101.f449458e = null;
        L8:
            ((HashMap) this.f449455a.A).remove(r100);
        L9:
            TextEditorDrawView r102 = this.f449455a;
            if (r102.f449440q != r100) goto L12;
            r102.f449440q = null;
        L12:
            return this;
        }

        public final void h(boolean r100) {
            d r101 = this.f449455a.f449446w;
            if (r101 == null) goto L9;
            h r102 = (h) r101;
            if (r100 == false) goto L7;
            r102.f449539a.f449515c.b();
            return;
        L7:
            r102.f449539a.f449515c.a();
            return;
        }

        public final f i(wfc.e r100) {
            TextEditorDrawView r101 = this.f449455a;
            if (r100 == r101.f449440q) goto L10;
            r101.f449449z = true;
            r101.f449440q = r100;
            b r102 = r101.C;
            if (r102 == null) goto L10;
            if (r100 == null) goto L10;
            int r103 = r100.f559517i;
            TextEditorView.a r104 = ((com.ss.android.photoeditor.text.e) r102).f449534a.f449495e;
            if (r104 == null) goto L10;
            com.ss.android.photoeditor.text.g r105 = (com.ss.android.photoeditor.text.g) r104;
            r105.f449538b.f449514b.setOnColorChangedListener(null);
            r105.f449538b.f449514b.a(r103);
            r105.f449538b.f449514b.setOnColorChangedListener(r105.f449537a);
        L10:
            return this;
        }

        public final wfc.e a(int r110, int r111) {
            if (((ArrayList) this.f449455a.f449441r).size() < 15) goto L5;
            return null;
        L5:
            int r100 = 0;
        L7:
            if (r100 >= ((ArrayList) this.f449455a.f449441r).size()) goto L12;
            if (((wfc.e) ListProtector.get(this.f449455a.f449441r, r100)).f559512d == false) goto L10;
            r100 = r100 + 1;
            goto L7
        L10:
            return null;
        L12:
            int r101 = (int) c(r110);
            int r102 = (int) d(r111);
            float r103 = this.f449455a.f449447x.width() / this.f449455a.f449443t.width();
            TextEditorDrawView r104 = this.f449455a;
            wfc.e r105 = new wfc.e(r104, r101, r102, r104.getContext().getString(R.string.Lark_Legacy_ClickToEnter), r103, 0, this.f449455a.f449445v);
            ((ArrayList) this.f449455a.f449441r).add(r105);
            pfc.f.b r106 = pfc.f.i().d();
            TextEditorDrawView r107 = this.f449455a;
            g r108 = new g(r107, r107.f449447x, r105, r107.f449442s, r106.f529058a, r106.f529059b, r106.f529060c);
            ((HashMap) this.f449455a.A).put(r105, r108);
            pfc.f.i().a(r108);
            return r105;
        }

        public final wfc.e f(float r100, float r101) {
            float r102 = c(r100);
            float r103 = d(r101);
            int r104 = ((ArrayList) this.f449455a.f449441r).size();
        L3:
            r104 = r104 - 1;
            if (r104 < 0) goto L8;
            wfc.e r105 = (wfc.e) ListProtector.get(this.f449455a.f449441r, r104);
            if (r105.a(r102, r103) == false) goto L3;
            return r105;
        L8:
            return null;
        }

        public final f j(wfc.e r100, boolean r101) {
            if (r100 == null) goto L6;
            TextEditorDrawView r102 = this.f449455a;
            int r103 = TextEditorDrawView.D;
            r102.getClass();
            if (r100.f559525q == r101) goto L6;
            r100.f559525q = r101;
            r100.b();
        L6:
            return this;
        }

        public final boolean g(wfc.e r100, float r101, float r102) {
            float r103 = c(r101);
            float r104 = d(r102);
            float r105 = r100.f559509a * 10.0f;
            return new RectF(r100.f559527s.x - com.ss.android.photoeditor.util.d.a(r105), r100.f559527s.y - com.ss.android.photoeditor.util.d.a(r105), r100.f559527s.x + com.ss.android.photoeditor.util.d.a(r105), r100.f559527s.y + com.ss.android.photoeditor.util.d.a(r105)).contains(r103, r104);
        }
    }

    public static class g extends pfc.f.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f449456c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RectF f449457d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public wfc.e f449458e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public RectF f449459f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public RectF f449460g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f449461h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final f f449462i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final TextEditorDrawView f449463j;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f449464a;

            @Override // java.lang.Runnable
            public final void run() {
                f r100 = this.f449464a.f449462i;     // Catch: Throwable -> L7
                wfc.e r101 = r100.f449455a.f449440q;     // Catch: Throwable -> L7
                if (r101 == null) goto L5;
                r100.j(r101, false);     // Catch: Throwable -> L7
            L5:
                g r102 = this.f449464a;     // Catch: Throwable -> L7
                f r103 = r102.f449462i;     // Catch: Throwable -> L7
                r103.j(r102.f449458e, true);     // Catch: Throwable -> L7
                r103.i(this.f449464a.f449458e);     // Catch: Throwable -> L7
                r103.b();     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L11;
                return;
            L11:
                throw th;
            }

            public a(g r100) {
                this.f449464a = r100;
            }
        }

        @Override // pfc.f.a
        public final pfc.f.b c(pfc.f.b r100) {
            return r100;
        }

        @Override // pfc.f.a
        public final Bitmap d() {
            return null;
        }

        @Override // pfc.f.a
        public final RectF e() {
            return null;
        }

        @Override // pfc.f.a
        public final RectF f() {
            return null;
        }

        @Override // pfc.f.a
        public final void a() {
            ((u) this.f449463j.B).a(TextPhotoEditorPlugin.class);
            this.f449463j.post(new a(this));
        }

        @Override // pfc.f.a
        public final boolean j() {
            if (this.f449458e == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // pfc.f.a
        public final void k() {
            wfc.e r100 = this.f449458e;
            f r101 = this.f449462i;
            if (r100 != r101.f449455a.f449440q) goto L5;
            r101.i(null);
        L5:
            f r102 = this.f449462i;
            r102.e(this.f449458e);
            r102.b();
        }

        @Override // pfc.f.a
        public final boolean g() {
            return this.f449456c;
        }

        @Override // pfc.f.a
        public final void b(Canvas r110) {
            wfc.e r100 = this.f449458e;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.f559512d == false) goto L14;
            long r101 = System.currentTimeMillis();
            RectF r102 = new RectF(this.f449459f);
            RectF r103 = new RectF(this.f449460g);
            float r104 = r110.getWidth() / r103.width();
            com.ss.android.photoeditor.util.b.f(r102, 0.0f, 0.0f, r104, r104);
            com.ss.android.photoeditor.util.b.f(r103, 0.0f, 0.0f, r104, r104);
            float r105 = -r103.left;
            float r106 = -r103.top;
            r102.offset(r105, r106);
            r103.offset(r105, r106);
            if (((this.f449461h / 90) % 2) != 0) goto L10;
            float r107 = r102.width();
            float r108 = this.f449457d.width();
        L11:
            float r109 = r107 / r108;
            RectF r111 = new RectF(this.f449457d);
            wfc.e r112 = this.f449458e;
            TextEditorDrawView r113 = r112.f559519k;
            PointF r114 = r112.f559510b;
            wfc.e r115 = new wfc.e(r113, (int) r114.x, (int) r114.y, r112.f559515g, r112.f559509a, r112.f559511c, r112.f559517i);
            com.ss.android.photoeditor.util.b.f(r111, 0.0f, 0.0f, r109, r109);
            r115.update(0.0f, 0.0f, r109);
            float r116 = r102.centerX() - r111.centerX();
            float r117 = r102.centerY() - r111.centerY();
            r111.offset(r116, r117);
            PointF r118 = r115.f559510b;
            r115.update(r118.x + r116, r118.y + r117, r115.f559511c, r115.f559509a);
            float r119 = r102.centerX();
            float r120 = r102.centerY();
            int r121 = -this.f449461h;
            com.ss.android.photoeditor.util.b.c(r115.f559510b, r119, r120, r121);
            r115.f559511c += r121;
            r115.f();
            r115.d(r110);
            Log.d("drawOnCanvas", "user time" + (System.currentTimeMillis() - r101));
            return;
        L10:
            r107 = r102.height();
            r108 = this.f449457d.width();
            goto L11
        }

        @Override // pfc.f.a
        public final boolean h(PointF r100, RectF r101) {
            PointF r102 = new PointF(r100.x, r100.y);
            RectF r103 = new RectF(r101);
            RectF r104 = new RectF(this.f449459f);
            float r105 = this.f449460g.width() / r103.width();
            com.ss.android.photoeditor.util.b.f(r103, 0.0f, 0.0f, r105, r105);
            r102.x *= r105;
            r102.y *= r105;
            float r106 = this.f449460g.centerX() - r103.centerX();
            float r107 = this.f449460g.centerY() - r103.centerY();
            r103.offset(r106, r107);
            r102.x += r106;
            r102.y += r107;
            if (((this.f449461h / 90) % 2) != 0) goto L5;
            float r108 = this.f449457d.width();
            float r109 = r104.width();
        L6:
            float r110 = r108 / r109;
            com.ss.android.photoeditor.util.b.f(r104, 0.0f, 0.0f, r110, r110);
            com.ss.android.photoeditor.util.b.f(r103, 0.0f, 0.0f, r110, r110);
            r102.x *= r110;
            r102.y *= r110;
            float r111 = this.f449457d.centerX() - r104.centerX();
            float r112 = this.f449457d.centerY() - r104.centerY();
            r104.offset(r111, r112);
            r103.offset(r111, r112);
            r102.x += r111;
            r102.y += r112;
            com.ss.android.photoeditor.util.b.d(r104, this.f449461h, r104.centerX(), r104.centerY());
            com.ss.android.photoeditor.util.b.d(r103, this.f449461h, r104.centerX(), r104.centerY());
            com.ss.android.photoeditor.util.b.c(r102, r104.centerX(), r104.centerY(), this.f449461h);
            float r113 = r102.x;
            RectF r114 = this.f449457d;
            float r115 = r113 - r114.left;
            r102.x = r115;
            float r116 = r102.y - r114.top;
            r102.y = r116;
            return this.f449458e.a(r115, r116);
        L5:
            r108 = this.f449457d.height();
            r109 = r104.width();
            goto L6
        }

        public g(TextEditorDrawView r100, RectF r101, wfc.e r102, f r103, RectF r104, RectF r105, int r106) {
            this.f449456c = true;
            this.f449457d = new RectF(r101);
            this.f449458e = r102;
            this.f449462i = r103;
            this.f449459f = new RectF(r104);
            this.f449460g = new RectF(r105);
            this.f449461h = r106;
            new RectF();
            this.f449463j = r100;
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return false;
    }

    public final void init() {
        setBackgroundColor(-16777216);
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f449444u = new pfc.b(new a(this));
    }

    public final void n() {
        this.f449436m = new RectF();
        float r100 = getDrawable().getIntrinsicWidth();
        float r101 = getDrawable().getIntrinsicHeight();
        float r102 = getWidth();
        float r103 = getHeight();
        Matrix r104 = getImageMatrix();
        r104.getValues(this.f449437n);
        float[] r105 = this.f449437n;
        float r106 = r105[0];
        r104.getValues(r105);
        float r107 = this.f449437n[4];
        this.f449438o = r106 * r100;
        this.f449439p = r101 * r107;
        Log.d("TextEditorView", "imageRect ImageShowWidth：imageWidth：viewWidth=" + this.f449438o + ":" + r100 + "：" + r102);
        if (Math.abs(this.f449438o - r102) >= 3.0f) goto L5;
        RectF r108 = this.f449436m;
        float r109 = this.f449439p;
        float r110 = (r103 - r109) / 2.0f;
        r108.set(0.0f, r110, r102, r109 + r110);
        return;
    L5:
        RectF r111 = this.f449436m;
        float r112 = this.f449438o;
        float r113 = (r102 - r112) / 2.0f;
        r111.set(r113, 0.0f, r112 + r113, r103);
    }

    public final void o() {
        RectF r100 = this.f449425b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f449426c == true) goto L7;
        this.f449444u.b(new RectF(this.f449425b), this.f449436m, 250);
    L8:
        this.f449425b = null;
        return;
    L7:
        this.f449443t.set(r100);
        goto L8
    }

    public wfc.e getCurrTextSticker() {
        return this.f449440q;
    }

    public RectF getImageRect() {
        return this.f449436m;
    }

    public RectF getLocation() {
        return this.f449443t;
    }

    public c getTextStickerController() {
        return this.f449442s;
    }

    public TextEditorDrawView(Context r100) {
        super(r100);
        this.f449424a = new Matrix();
        this.f449437n = new float[9];
        this.A = new HashMap();
        init();
    }

    public final void m(boolean r100) {
        this.f449433j.drawColor(0, PorterDuff.Mode.CLEAR);
        wfc.e r101 = this.f449440q;
        if (r101 == null) goto L5;
        r101.d(this.f449433j);
    L5:
        if (r100 == false) goto L13;
        this.f449435l.drawColor(0, PorterDuff.Mode.CLEAR);
        int r102 = 0;
    L8:
        if (r102 >= ((ArrayList) this.f449441r).size()) goto L13;
        wfc.e r103 = (wfc.e) ListProtector.get(this.f449441r, r102);
        if (r103 == this.f449440q) goto L12;
        r103.d(this.f449435l);
    L12:
        r102 = r102 + 1;
    L13:
        new Matrix();
        this.f449434k.drawColor(0, PorterDuff.Mode.CLEAR);
        this.f449434k.drawBitmap(this.f449432i, 0.0f, 0.0f, null);
        this.f449434k.drawBitmap(this.f449430g, 0.0f, 0.0f, null);
        this.f449434k.drawBitmap(this.f449429f, 0.0f, 0.0f, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (r100 != null) goto L5;
        return;
    L5:
        r100.drawColor(-16777216);
        com.ss.android.photoeditor.util.b.g(this.f449424a, this.f449431h, this.f449443t);
        r100.drawBitmap(this.f449431h, this.f449424a, null);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        this.f449428e = r100;
        super.setImageBitmap(r100);
    }

    public void setOnColorChangedListener(b r100) {
        this.C = r100;
    }

    public void setPaintColor(int r100) {
        this.f449445v = r100;
        if (this.f449440q == null) goto L6;
        c r101 = getTextStickerController();
        wfc.e r102 = this.f449440q;
        f r103 = (f) r101;
        r103.f449455a.getClass();
        r102.update(r100);
        r103.b();
        return;
    }

    public void setPluginContext(k.a r100) {
        this.B = r100;
    }

    public void setToolBarVisibleCallback(d r100) {
        this.f449446w = r100;
    }

    public TextEditorDrawView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f449424a = new Matrix();
        this.f449437n = new float[9];
        this.A = new HashMap();
        init();
    }

    public static void j(TextEditorDrawView r100, float r101) {
        Iterator r102 = ((ArrayList) r100.f449441r).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((wfc.e) r102.next()).update(0.0f, 0.0f, r101);
        goto L4
    }

    public TextEditorDrawView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f449424a = new Matrix();
        this.f449437n = new float[9];
        this.A = new HashMap();
        init();
    }

    public static void l(TextEditorDrawView r100, float r101, float r102) {
        Iterator r103 = ((ArrayList) r100.f449441r).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        wfc.e r104 = (wfc.e) r103.next();
        PointF r105 = r104.f559510b;
        r104.update(r105.x + r101, r105.y + r102, r104.f559511c, r104.f559509a);
        goto L4
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int r100, int r101, int r102, int r103) {
        boolean r104 = super.setFrame(r100, r101, r102, r103);
        if (this.f449447x == null) goto L5;
        n();
        com.ss.android.photoeditor.util.c.a(this, new com.ss.android.photoeditor.text.a(this, new wfc.a(this)));
    L5:
        return r104;
    }
}
