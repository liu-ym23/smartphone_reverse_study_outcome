package com.lynx.tasm.behavior.ui;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class m implements IDrawChildHook {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.lynx.tasm.behavior.ui.a f382808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f382809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f382810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f382811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f382812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f382813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i7a.a f382814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f382815h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f382816i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f382817j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f382818k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Path f382819l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Rect f382820m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Rect f382821n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f382822o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<a> f382823p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d7a.f f382824q;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f382825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f382826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f382827c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f382828d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d7a.f f382829e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Layout f382830f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f382831g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f382832h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f382833i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f382834j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f382835k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f382836l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f382837m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f382838n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f382839o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f382840p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f382841q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final com.lynx.tasm.behavior.ui.utils.e f382842r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f382843s;

        public a(boolean r100, Rect r101, com.lynx.tasm.behavior.ui.utils.e r102) {
            this.f382829e = null;
            this.f382830f = null;
            this.f382831g = 0;
            this.f382832h = 0;
            this.f382833i = 0;
            this.f382834j = 0;
            this.f382839o = 1.0f;
            this.f382840p = 0;
            this.f382841q = 0;
            this.f382842r = null;
            this.f382843s = false;
            this.f382827c = r100;
            this.f382828d = r101;
            this.f382842r = r102;
        }

        public a(Rect r100, m r101, View r102) {
            this(true, r100, null);
            this.f382825a = r101;
            this.f382826b = r102;
        }
    }

    public final void d() {
        Iterator<a> r100 = this.f382823p.iterator();
    L4:
        if (r100.hasNext() == false) goto L12;
        a r101 = r100.next();
        if (r101.f382827c == false) goto L4;
        if (r101.f382825a == null) goto L4;
        View r102 = r101.f382826b;
        if (r102 == null) goto L4;
        int r103 = r101.f382831g;
        int r104 = r101.f382832h;
        r102.layout(r103, r104, r101.f382833i + r103, r101.f382834j + r104);
        r101.f382825a.d();
        goto L4
    }

    public final void e() {
        Iterator<a> r100 = this.f382823p.iterator();
    L4:
        if (r100.hasNext() == false) goto L12;
        a r101 = r100.next();
        if (r101.f382827c == false) goto L4;
        if (r101.f382825a == null) goto L4;
        View r102 = r101.f382826b;
        if (r102 == null) goto L4;
        int r103 = r101.f382833i;
        int r104 = r101.f382834j;
        r102.measure(View.MeasureSpec.makeMeasureSpec(r103, 1073741824), View.MeasureSpec.makeMeasureSpec(r104, 1073741824));
        r101.f382825a.e();
        goto L4
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final void performLayoutChildrenUI() {
        com.lynx.tasm.behavior.ui.a r100 = this.f382808a;
        if (r100 == null) goto L6;
        r100.processLayoutChildren();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final void performMeasureChildrenUI() {
        com.lynx.tasm.behavior.ui.a r100 = this.f382808a;
        if (r100 == null) goto L6;
        r100.processMeasureChildren();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final boolean hasOverlappingRendering() {
        return this.f382816i;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final void afterDispatchDraw(Canvas r100) {
        com.lynx.tasm.behavior.ui.a r101 = this.f382808a;
        if (r101 == null) goto L6;
        r101.afterDispatchProcessViewInfo(this);
    L6:
        if (this.f382822o >= this.f382823p.size()) goto L8;
        b((a) ListProtector.get(this.f382823p, this.f382822o), r100);
        this.f382822o++;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final void afterDraw(Canvas r100) {
        com.lynx.tasm.behavior.ui.a r101 = this.f382808a;
        if (r101 == null) goto L6;
        r101.afterProcessViewInfo(this);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final void beforeDispatchDraw(Canvas r100) {
        com.lynx.tasm.behavior.ui.a r101 = this.f382808a;
        if (r101 == null) goto L5;
        r101.beforeDispatchProcessViewInfo(this);
    L5:
        this.f382822o = 0;
        if (this.f382818k == false) goto L13;
        Path r102 = this.f382819l;
        if (r102 == null) goto L10;
        r100.clipPath(r102);
        goto L13
    L10:
        Rect r103 = this.f382820m;
        if (r103 == null) goto L13;
        r100.clipRect(r103);
    L13:
        Rect r104 = this.f382821n;
        if (r104 == null) goto L17;
        r100.clipRect(r104);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final void beforeDraw(Canvas r100) {
        com.lynx.tasm.behavior.ui.a r101 = this.f382808a;
        if (r101 == null) goto L5;
        r101.beforeProcessViewInfo(this);
    L5:
        d7a.f r102 = this.f382824q;
        if (r102 == null) goto L8;
        r102.i(r100);
    L8:
        float r103 = this.f382812e;
        if (r103 == 0.0f) goto L11;
    L12:
        r100.skew(r103, this.f382813f);
        r100.translate((-this.f382809b.getPivotY()) * this.f382812e, (-this.f382809b.getPivotX()) * this.f382813f);
    L13:
        i7a.a r104 = this.f382814g;
        if (r104 == null) goto L19;
        Path r105 = r104.c(this.f382810c, this.f382811d);
        if (r105 == null) goto L20;
        r100.clipPath(r105);
        return;
    L20:
        return;
    L19:
        return;
    L11:
        if (this.f382813f == 0.0f) goto L13;
        goto L12
    }

    public m(com.lynx.tasm.behavior.ui.a r100, View r101) {
        this.f382817j = false;
        this.f382822o = 0;
        this.f382823p = new ArrayList();
        this.f382808a = r100;
        this.f382809b = r101;
    }

    public static void b(a r110, Canvas r111) {
        Rect r100 = r110.f382828d;
        int r101 = r111.save();
        if (r100 == null) goto L5;
        r111.clipRect(r100);
    L5:
        int r102 = r110.f382831g;
        if (r102 == 0) goto L8;
    L9:
        r111.translate(r102, r110.f382832h);
    L10:
        float r103 = r110.f382839o;
        if (r103 >= 1.0f) goto L13;
        r111.saveLayerAlpha(0.0f, 0.0f, r110.f382833i, r110.f382834j, (int) (r103 * 255.0f), 31);
    L13:
        com.lynx.tasm.behavior.ui.utils.e r104 = r110.f382842r;
        int r105 = 0;
        if (r104 == null) goto L22;
        T r106 = r104.f383142b;
        if (((BackgroundDrawable) r106) == null) goto L22;
        float r107 = r110.f382837m;
        float r108 = r110.f382836l;
        float r109 = r110.f382838n;
        float r112 = r110.f382835k;
        if (r106 == 0) goto L20;
        r106.d(r107, r108, r109, r112);
    L20:
        BackgroundDrawable r113 = (BackgroundDrawable) r110.f382842r.f383142b;
        r113.setBounds(0, 0, r110.f382833i, r110.f382834j);
        r113.draw(r111);
    L22:
        if (r110.f382830f == null) goto L35;
        r111.translate(r110.f382840p, r110.f382841q);
        int r114 = r110.f382833i;
        if (r114 <= 0) goto L28;
        int r115 = r110.f382834j;
        if (r115 <= 0) goto L28;
        r111.clipRect(0, 0, r114, r115);
    L28:
        Spanned r116 = (Spanned) r110.f382830f.getText();
        int r117 = com.lynx.tasm.behavior.ui.text.a.f383080p;
        if (r116 == null) goto L34;
        com.lynx.tasm.behavior.ui.text.a[] r118 = (com.lynx.tasm.behavior.ui.text.a[]) r116.getSpans(0, r116.length(), com.lynx.tasm.behavior.ui.text.a.class);
        int r119 = r118.length;
    L32:
        if (r105 >= r119) goto L34;
        r118[r105].d();
        r105 = r105 + 1;
    L34:
        r110.f382830f.draw(r111);
    L35:
        d7a.f r120 = r110.f382829e;
        if (r120 == null) goto L38;
        r120.i(r111);
    L38:
        r111.restoreToCount(r101);
        return;
    L8:
        if (r110.f382832h == 0) goto L10;
        goto L9
    }

    public final void a(int r100, a r101) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        int r102 = this.f382823p.size();
        if (r100 <= r102) goto L10;
        int r103 = r100 - r102;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L9;
        this.f382823p.add(null);
        r104 = r104 + 1;
        goto L7
    L9:
        this.f382823p.add(r101);
        return;
    L10:
        ListProtector.add(this.f382823p, r100, r101);
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final int getChildDrawingOrder(int r100, int r101) {
        int[] r102 = this.f382815h;
        if (r102 != null) goto L5;
    L9:
        return r101;
    L5:
        if (r101 >= r102.length) goto L9;
        return r102[r101];
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final void afterDrawChild(Canvas r100, View r101, long r102) {
        com.lynx.tasm.behavior.ui.a r103 = this.f382808a;
        if (r103 == null) goto L6;
        r103.afterProcessChildViewInfo(this, r101, r102);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public final Rect beforeDrawChild(Canvas r100, View r101, long r102) {
        com.lynx.tasm.behavior.ui.a r103 = this.f382808a;
        if (r103 == null) goto L6;
        r103.beforeProcessChildViewInfo(this, r101, r102);
    L6:
        if (this.f382822o >= this.f382823p.size()) goto L15;
        a r104 = (a) ListProtector.get(this.f382823p, this.f382822o);
        if (r104 != null) goto L11;
        LLog.e("ViewInfo", "drawWithSubDrawInfo: info is null");
    L14:
        this.f382822o++;
        goto L6
    L11:
        if (r104.f382827c == true) goto L12;
        b(r104, r100);
        goto L14
    L12:
        Rect r105 = r104.f382828d;
        this.f382822o++;
        return r105;
    L15:
        return null;
    }

    public final void c(int r100, int r101, ArrayList<e> r110) {
        View r102 = this.f382809b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.getLeft();
    L6:
        int r105 = r100 + r104;
        View r106 = this.f382809b;
        if (r106 == null) goto L9;
        r103 = r106.getTop();
    L9:
        int r107 = r101 + r103;
        View r108 = this.f382809b;
        if (r108 != null) goto L12;
    L17:
        Iterator<a> r109 = this.f382823p.iterator();
    L19:
        if (r109.hasNext() == false) goto L34;
        a r111 = r109.next();
        if (r111 == null) goto L19;
        KeyEvent.Callback r112 = r111.f382826b;
        if ((r112 instanceof e.a) == true) goto L25;
        if (r111.f382843s == false) goto L19;
        int r113 = r111.f382831g + r105;
        int r114 = r111.f382832h + r107;
        int r115 = r111.f382833i;
        int r116 = r111.f382834j;
        d7a.f r117 = r111.f382829e;
        if (r117 == null) goto L33;
        r117.e().booleanValue();
    L33:
        r110.add(new e(r113, r114, r115, r116));
        goto L19
    L25:
        e.a r118 = (e.a) r112;
        if ((r118.getDrawChildHook() instanceof m) == false) goto L19;
        ((m) r118.getDrawChildHook()).c(r105, r107, r110);
        goto L19
    L34:
        return;
    L12:
        if (this.f382817j == false) goto L17;
        int r119 = r108.getWidth();
        int r120 = this.f382809b.getHeight();
        d7a.f r121 = this.f382824q;
        if (r121 == null) goto L16;
        r121.e().booleanValue();
    L16:
        e r122 = new e(r105, r107, r119, r120);
        this.f382809b.getAlpha();
        this.f382809b.getScaleX();
        this.f382809b.getScaleY();
        this.f382809b.getVisibility();
        r110.add(r122);
        goto L17
    L5:
        r104 = 0;
        goto L6
    }
}
