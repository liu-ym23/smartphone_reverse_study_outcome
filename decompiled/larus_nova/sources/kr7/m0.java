package kr7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.xelement.markdown.Markdown;
import com.bytedance.xelement.markdown.MarkdownDocument;
import com.bytedance.xelement.markdown.MarkdownShadowNode;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.textra.TTTextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes22.dex */
public final class m0 extends com.lynx.tasm.behavior.ui.view.a implements lr7.b {
    public static final int R = 0;
    public static final int S = 0;
    public int A;
    public ReadableArray B;
    public ReadableArray C;
    public float D;
    public float E;
    public float F;
    public float G;
    public long H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f505773J;
    public boolean K;
    public l0 L;
    public RectF M;
    public boolean N;
    public d O;
    public final HashMap<Integer, c> P;
    public final HashMap<Integer, b> Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f505774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<LynxBaseUI> f505775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<String> f505776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f505777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f505778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f505779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f505780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f505781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f505782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f505783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f505784k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f505785l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f505786m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f505787n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f505788o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f505789p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f505790q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final PointF f505791r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final PointF f505792s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final PointF f505793t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final PointF f505794u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f505795v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f505796w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f505797x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f505798y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a f505799z;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f505800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f505801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m0 f505802c;

        public final void a() {
            m0 r100 = this.f505802c;
            r100.f505795v = true;
            r100.f505791r.set(this.f505800a, this.f505801b);
            this.f505802c.f505792s.set(this.f505800a, this.f505801b);
            m0 r101 = this.f505802c;
            int r102 = r101.getOffsetForPosition(this.f505800a, this.f505801b);
            r101.f505787n = r102;
            r101.f505788o = r102;
            m0 r103 = this.f505802c;
            r103.f505798y = true;
            r103.requestDisallowInterceptTouchEvent(true);
            this.f505802c.f505799z = null;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(m0 r100, float r101, float r102) {
            this.f505802c = r100;
            this.f505800a = r101;
            this.f505801b = r102;
        }
    }

    public static class b extends View implements lr7.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f505803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l f505804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final lr7.e f505805c;

        @Override // lr7.b
        public final void b(r r100, Rect r101) {
        }

        @Override // android.view.View
        public final void onDraw(Canvas r100) {
            super.onDraw(r100);
            if (this.f505804b != null) goto L5;
            return;
        L5:
            this.f505805c.f(r100);
            this.f505804b.f505760a.drawExtraContent(this.f505805c, this.f505803a);
        }

        public b(Context r100, l r101, int r102) {
            super(r100);
            setWillNotDraw(false);
            this.f505804b = r101;
            this.f505803a = r102;
            this.f505805c = new lr7.e(null, r101.f505760a.getResourceManager(), this);
        }
    }

    public static class c extends View implements lr7.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f505806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l f505807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final m0 f505808c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final lr7.e f505809d;

        @Override // android.view.View
        public final void onDraw(Canvas r100) {
            super.onDraw(r100);
            if (this.f505807b != null) goto L5;
            return;
        L5:
            this.f505809d.f(r100);
            float[] r101 = this.f505807b.f505760a.getRegionRect(this.f505806a);
            float r102 = r101[0];
            r100.translate(-r102, -r101[1]);
            l r103 = this.f505807b;
            if (r103.f505761b != 0) goto L8;
            r103.f505760a.drawRegion(this.f505809d, this.f505806a);
            return;
        L8:
            r103.f505760a.drawTypewriterRegion(this.f505809d, this.f505806a, this.f505808c.f505773J, r103.f505767h);
        }

        @Override // lr7.b
        public final void b(r r100, Rect r101) {
            if (r100.f505833e.equals(this.f505807b.f505769j) == false) goto L24;
            LynxBaseUI r102 = r100.f505834f;
            if (r102 != null) goto L17;
            String r103 = r100.f505833e;
            LynxBaseUI r104 = this.f505808c.f505775b.get();
            if (r104 == null) goto L16;
            Iterator<LynxBaseUI> r105 = r104.getChildren().iterator();
        L12:
            if (r105.hasNext() == false) goto L16;
            LynxBaseUI r106 = r105.next();
            if (r103.equals(r106.getIdSelector()) == false) goto L12;
            r102 = r106;
        L16:
            r102 = null;
        L17:
            if (r102 != null) goto L19;
            return;
        L19:
            r102.setLeft(r101.left);
            r102.setTop(r101.top);
            return;
        }

        public c(Context r100, l r101, m0 r102, int r103) {
            super(r100);
            setWillNotDraw(false);
            this.f505808c = r102;
            this.f505807b = r101;
            this.f505806a = r103;
            this.f505809d = new lr7.e(null, r101.f505760a.getResourceManager(), this);
        }
    }

    public static class d extends ViewGroup {
        public d(Context r100) {
            super(r100);
            setWillNotDraw(true);
            setClipChildren(true);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
            setClipBounds(new Rect(r101, r102, r103, r104));
        }
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    public void setAnimationFrameRate(int r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    static {
        R = Color.argb(20, 27, 125, 240);
        S = Color.argb(255, 27, 125, 240);
    }

    public final void c() {
        if (this.L == null) goto L5;
        Choreographer.getInstance().removeFrameCallback(this.L);
        this.L = null;
    L5:
        d r100 = this.O;
        if (r100 == null) goto L9;
        r100.removeAllViews();
        this.P.clear();
        this.Q.clear();
        removeView(this.O);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [kr7.l0] */
    public final void e() {
        if (this.L != null) goto L5;
        this.L = new l0(this);
        Choreographer.getInstance().postFrameCallback(this.L);
    L5:
        View r100 = this.O;
        if (r100 != null) goto L8;
        d r101 = new d(getContext());
        this.O = r101;
        addView(r101);
        return;
    L8:
        removeView(r100);
        addView(this.O, 0);
    }

    public final void f() {
        Iterator<c> r100 = this.P.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().invalidate();
        goto L4
    L6:
        Iterator<b> r101 = this.Q.values().iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        r101.next().invalidate();
        goto L8
    }

    public ArrayList<Float>[] getHandlesInfo() {
        if (this.f505795v == false) goto L5;
        ArrayList<Float> r100 = new ArrayList();
        r100.add(Float.valueOf(this.f505793t.x));
        r100.add(Float.valueOf(this.f505793t.y));
        r100.add(Float.valueOf(50.0f));
        ArrayList<Float> r101 = new ArrayList();
        r101.add(Float.valueOf(this.f505794u.x));
        r101.add(Float.valueOf(this.f505794u.y));
        r101.add(Float.valueOf(50.0f));
        return new ArrayList[]{r100, r101};
    L5:
        return new ArrayList[0];
    }

    public String getSelectedText() {
        int r100 = this.f505787n;
        if (r100 < 0) goto L9;
        int r101 = this.f505788o;
        if (r101 <= 0) goto L11;
        if (r101 > r100) goto L8;
        return "";
    L8:
        return this.f505774a.f505760a.getContentByCharRange(r100, r101);
    L11:
        return "";
    L9:
        return "";
    }

    public final void i() {
        l r100 = this.f505774a;
        if (r100 == null) goto L6;
        r100.f505760a.clearTextMarkAttachment();
        this.f505774a.f505760a.addTextMarkAttachment(this.C);
        this.f505774a.f505760a.addTextMarkAttachment(this.B);
        invalidate();
        return;
    }

    public final void j() {
        l r100 = this.f505774a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f505760a == null) goto L55;
        RectF r101 = getViewRectInScreen();
        float r102 = r101.top;
        RectF r103 = this.M;
        float r104 = r102 - r103.top;
        float r105 = r101.bottom - r103.bottom;
        if (r104 >= 5.0f) goto L19;
        if (r105 >= 5.0f) goto L19;
        if (r104 <= (-5.0f)) goto L19;
        if (r105 <= (-5.0f)) goto L19;
        if (this.N == true) goto L19;
        return;
    L19:
        if (this.N == false) goto L21;
        this.N = false;
        this.O.removeAllViews();
        this.P.clear();
        this.Q.clear();
    L21:
        this.M = r101;
        MarkdownDocument r106 = this.f505774a.f505760a;
        float r107 = r101.top - 5.0f;
        float r108 = this.E;
        int[] r109 = r106.getShowedRegion(r107 + r108, (r101.bottom + 5.0f) + r108);
        int r110 = this.f505774a.f505760a.getRegionCount();
        LLog.d("MarkdownView", "updateRegionView: rect=" + r101 + ", regionRange=[" + r109[0] + ", " + r109[1] + "], regionCount=" + r110);
        int r111 = 0;
    L23:
        if (r111 >= r110) goto L33;
        c r112 = this.P.get(Integer.valueOf(r111));
        if (r111 >= r109[0]) goto L27;
    L30:
        if (r112 == null) goto L32;
        this.O.removeView(r112);
        this.P.remove(Integer.valueOf(r111));
    L32:
        r111 = r111 + 1;
        goto L23
    L27:
        if (r111 > r109[1]) goto L30;
        if (r112 != null) goto L32;
        float[] r113 = this.f505774a.f505760a.getRegionRect(r111);
        c r114 = new c(getContext(), this.f505774a, this, r111);
        r114.setLeft((int) (r113[0] + this.D));
        r114.setTop((int) (r113[1] + this.E));
        r114.setRight((int) (r113[2] + this.D));
        r114.setBottom((int) (r113[3] + this.E));
        this.P.put(Integer.valueOf(r111), r114);
        this.O.addView(r114);
        r114.invalidate();
        goto L32
    L33:
        MarkdownDocument r115 = this.f505774a.f505760a;
        float r116 = r101.top - 5.0f;
        float r117 = this.E;
        int[] r118 = r115.getShowedExtraContent(r116 + r117, (r101.bottom + 5.0f) + r117);
        int r119 = this.f505774a.f505760a.getExtraContentCount();
        int r120 = 0;
    L34:
        if (r120 >= r119) goto L56;
        b r121 = this.Q.get(Integer.valueOf(r120));
        if (r120 >= r118[0]) goto L38;
    L41:
        if (r121 == null) goto L43;
        this.O.removeView(r121);
        this.Q.remove(Integer.valueOf(r120));
    L43:
        r120 = r120 + 1;
        goto L34
    L38:
        if (r120 > r118[1]) goto L41;
        if (r121 != null) goto L43;
        float[] r122 = this.f505774a.f505760a.getExtraContentRect(r120);
        b r123 = new b(getContext(), this.f505774a, r120);
        r123.setLeft((int) (r122[0] + this.D));
        r123.setTop((int) (r122[1] + this.E));
        r123.setRight((int) (r122[2] + this.D));
        r123.setBottom((int) (r122[3] + this.E));
        this.Q.put(Integer.valueOf(r120), r123);
        this.O.addView(r123);
        r123.invalidate();
        goto L43
    L56:
        return;
    }

    public final void onSelectionChange() {
        l r100 = this.f505774a;
        if (r100 == null) goto L17;
        MarkdownShadowNode r101 = r100.f505764e.get();
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L18;
        MarkdownShadowNode r103 = this.f505774a.f505764e.get();
        int r104 = this.f505787n;
        int r105 = this.f505788o;
        boolean r106 = this.f505777d;
        m7a.a r107 = new m7a.a(r103.f382203b, "selectionchange");
        r107.a("start", Integer.valueOf(r104));
        r107.a("end", Integer.valueOf(r105));
        if (r106 == false) goto L14;
        String r108 = "forward";
    L15:
        r107.a("direction", r108);
        UIThreadUtils.runOnUiThread(new k(r103, r107));
        return;
    L14:
        r108 = "backward";
        goto L15
    L18:
        return;
    L7:
        if (r101.E("selectionchange") == false) goto L9;
        r102 = true;
        goto L10
    }

    public final void removeCheckLongPressCallback() {
        a r100 = this.f505799z;
        if (r100 != null) goto L5;
        return;
    L5:
        removeCallbacks(r100);
        this.f505799z = null;
    }

    public final void updateSelectStartEnd() {
        int r100 = this.f505789p;
        boolean r101 = false;
        if (r100 != (-1)) goto L8;
        if (this.f505788o > this.f505787n) goto L11;
    L12:
        this.f505777d = r101;
        int r102 = Math.min(this.f505787n, this.f505788o);
        int r103 = Math.max(this.f505787n, this.f505788o);
        this.f505788o = r103;
        this.f505787n = r102;
        this.f505789p = r102;
        this.f505790q = r103;
        onSelectionChange();
        return;
    L11:
        r101 = true;
        goto L12
    L8:
        if (r100 < this.f505787n) goto L11;
        if (this.f505790q >= this.f505788o) goto L12;
        goto L11
    }

    public final void clearSelection() {
        removeCheckLongPressCallback();
        this.f505797x = false;
        this.f505798y = false;
        this.f505796w = false;
        this.f505791r.set(-1.0f, -1.0f);
        this.f505792s.set(-1.0f, -1.0f);
        this.f505787n = -1;
        this.f505788o = -1;
        this.f505789p = -1;
        this.f505790q = -1;
        this.f505779f.reset();
        if (this.f505795v == false) goto L5;
        invalidate();
        onSelectionChange();
    L5:
        this.f505795v = false;
    }

    public RectF getViewRectInScreen() {
        View r100 = getRootView();
        float r101 = r100.getWidth();
        float r102 = r100.getHeight();
        PointF r103 = com.lynx.tasm.behavior.ui.utils.o.a(r100, this, new PointF(0.0f, 0.0f));
        PointF r104 = com.lynx.tasm.behavior.ui.utils.o.a(r100, this, new PointF(r101, r102));
        return new RectF(Math.max(0.0f, Math.min(r103.x, r104.x)), Math.max(0.0f, Math.min(r103.y, r104.y)), Math.min(getWidth(), Math.max(r103.x, r104.x)), Math.min(getHeight(), Math.max(r103.y, r104.y)));
    }

    @Override // android.view.View
    public final void invalidate() {
        super.invalidate();
        if (this.K == false) goto L6;
        f();
        return;
    }

    public m0(Context r100) {
        super(r100);
        this.f505777d = true;
        this.f505778e = false;
        this.f505779f = new Path();
        this.f505780g = new Paint();
        this.f505787n = -1;
        this.f505788o = -1;
        this.f505789p = -1;
        this.f505790q = -1;
        this.f505791r = new PointF(-1.0f, -1.0f);
        this.f505792s = new PointF(-1.0f, -1.0f);
        this.f505793t = new PointF(-1.0f, -1.0f);
        this.f505794u = new PointF(-1.0f, -1.0f);
        this.f505795v = false;
        this.f505796w = false;
        this.f505797x = false;
        this.f505798y = false;
        this.f505799z = null;
        this.A = 0;
        this.B = null;
        this.C = null;
        this.D = 0.0f;
        this.E = 0.0f;
        this.f505773J = 0;
        this.K = false;
        this.L = null;
        this.M = new RectF();
        this.N = false;
        this.P = new HashMap();
        this.Q = new HashMap();
        Markdown.ensureInitialized();
        setWillNotDraw(false);
        this.f505776c = new HashSet();
        this.f505781h = R;
        this.f505782i = S;
        int r101 = Math.round(((LynxContext) r100).getScreenMetrics().density * 15.0f);
        this.f505784k = r101;
        this.f505783j = r101;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        super.dispatchDraw(r100);
        if (this.f505779f.isEmpty() == true) goto L6;
        int r101 = r100.save();
        r100.translate(this.D, this.E);
        r100.drawPath(this.f505779f, this.f505780g);
        r100.save();
        r100.translate(this.f505793t.x - (this.f505785l.getBounds().width() / 2.0f), this.f505793t.y - (this.f505785l.getBounds().height() / 2.0f));
        this.f505785l.draw(r100);
        r100.restore();
        r100.save();
        r100.translate(this.f505794u.x - (this.f505786m.getBounds().width() / 2.0f), this.f505794u.y - (this.f505786m.getBounds().height() / 2.0f));
        this.f505786m.draw(r100);
        r100.restore();
        r100.restoreToCount(r101);
        return;
    }

    public final void h(int r100) {
        l r101 = this.f505774a;
        if (r101 != null) goto L5;
        return;
    L5:
        int[] r102 = r101.f505760a.getTypewriterChangedRegions(this.f505773J, r100);
        LLog.d("MarkdownView", "updateAnimationStep: from=" + this.f505773J + ", to=" + r100 + ", changedRange=[" + r102[0] + ", " + r102[1] + "]");
        int r103 = r102[0];
    L7:
        if (r103 > r102[1]) goto L12;
        c r104 = this.P.get(Integer.valueOf(r103));
        if (r104 == null) goto L11;
        r104.invalidate();
    L11:
        r103 = r103 + 1;
        goto L7
    L12:
        this.f505773J = r100;
        this.A = r100;
        l r105 = this.f505774a;
        if (r105.f505761b != 0) goto L15;
        String[] r106 = r105.f505760a.getVisibleInlineViews(Integer.MAX_VALUE, true);
    L16:
        HashSet r107 = new HashSet(Arrays.asList(r106));
        Iterator<LynxBaseUI> r108 = this.f505775b.get().getChildren().iterator();
    L18:
        if (r108.hasNext() == false) goto L25;
        LynxBaseUI r109 = r108.next();
        if ((r109 instanceof LynxUI) == false) goto L18;
        LynxUI r110 = (LynxUI) r109;
        if (r107.contains(r109.getIdSelector()) == true) goto L23;
        r110.setVisibilityForView(4);
        goto L18
    L23:
        r110.setVisibilityForView(0);
        goto L18
    L25:
        return;
    L15:
        r106 = r105.f505760a.getVisibleInlineViews(r100, r105.f505767h);
        goto L16
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public final void onDraw(Canvas r100) {
        if (this.K == false) goto L6;
        return;
    L6:
        if (this.f505774a == null) goto L50;
        Markdown.ensureInitialized();
        TraceEvent.beginSection("x-markdown.View.draw");
        int r101 = r100.save();
        r100.translate(this.D, this.E);
        l r102 = this.f505774a;
        r100.clipRect(0.0f, 0.0f, r102.f505765f, r102.f505766g);
        lr7.e r103 = new lr7.e(r100, this.f505774a.f505760a.getResourceManager(), this);
        this.f505776c.clear();
        l r104 = this.f505774a;
        int r105 = r104.f505761b;
        if (r105 != 1) goto L10;
    L13:
        r104.f505760a.drawWithCursor(r103, r104.f505762c, !r104.f505767h);
    L14:
        LynxBaseUI r106 = this.f505775b.get();
        if (r106 == null) goto L32;
        Iterator<LynxBaseUI> r107 = r106.getChildren().iterator();
    L18:
        if (r107.hasNext() == false) goto L32;
        LynxBaseUI r108 = r107.next();
        if ((r108 instanceof LynxUI) == false) goto L18;
        final LynxUI r109 = (LynxUI) r108;
        if (r108.getIdSelector() == null) goto L30;
        if (this.f505776c.contains(r108.getIdSelector()) == false) goto L30;
        if (r109.getVisibility() == true) goto L18;
        UIThreadUtils.runOnUiThreadImmediately(new i0(r109));
    L30:
        if (r109.getVisibility() == false) goto L18;
        UIThreadUtils.runOnUiThreadImmediately(new h0(r109));
    L32:
        r100.restoreToCount(r101);
        final MarkdownShadowNode r110 = this.f505774a.f505764e.get();
        if (r110 == null) goto L35;
        r110.I(new a0(r110));
    L35:
        TraceEvent.endSection("x-markdown.View.draw");
        return;
    L10:
        if (r105 == 2) goto L13;
        r104.f505760a.draw(r103);
        goto L14
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        l r100 = this.f505774a;
        if (r100 == null) goto L5;
        final MarkdownShadowNode r101 = r100.f505764e.get();
        float r102 = r110.getX();
        float r103 = r110.getY();
        float r104 = r102 - this.D;
        float r105 = r103 - this.E;
        int r106 = r110.getAction();
        if (r106 == 0) goto L22;
        if (r106 == 1) goto L20;
        if (r106 != 2) goto L11;
        float r107 = Math.abs(r104 - this.F);
        float r111 = Math.abs(r105 - this.G);
        float r112 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (r107 <= r112) goto L17;
    L18:
        this.I = false;
    L24:
        if (this.f505795v == true) goto L49;
        if (r110.getAction() != 1) goto L49;
        if (this.I == false) goto L49;
        String[] r108 = this.f505774a.f505760a.getLinkByTouchPosition(r104, r105);
        if (r108 != null) goto L32;
    L42:
        String r109 = this.f505774a.f505760a.getImageByTouchPosition(r104, r105);
        if (r109 == null) goto L45;
        final m7a.a r113 = new m7a.a(r101.f382203b, "imageTap");
        r113.a("url", r109);
        UIThreadUtils.runOnUiThread(new e(r101, r113));
    L45:
        String r114 = this.f505774a.f505760a.getTextClickByPoint(r104, r105);
        if (r114 == null) goto L49;
        final m7a.a r115 = new m7a.a(r101.f382203b, "textClick");
        r115.a("id", r114);
        UIThreadUtils.runOnUiThread(new kr7.d(r101, r115));
        goto L49
    L32:
        if (r108.length < 2) goto L42;
        String r116 = r108[0];
        String r117 = r108[1];
        if (r101 != null) goto L36;
    L38:
        boolean r118 = false;
    L39:
        if (r118 == false) goto L42;
        m7a.a r119 = new m7a.a(r101.f382203b, "link");
        r119.a("url", r116);
        r119.a("content", r117);
        UIThreadUtils.runOnUiThread(new j(r101, r119));
        goto L42
    L36:
        if (r101.E("link") == false) goto L38;
        r118 = true;
    L49:
        if (this.f505798y == true) goto L90;
        if (this.f505797x == true) goto L90;
        l r120 = this.f505774a;
        if (r120 == null) goto L65;
        MarkdownDocument r121 = r120.f505760a;
        if (r121 == null) goto L65;
        if (r121.touchPointCanScroll(this.F, this.G, TTTextUtils.Dp2Px(20.0f)) == false) goto L65;
        float r122 = Math.abs(r104 - this.F);
        float r123 = Math.abs(r105 - this.G);
        if (r122 <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L65;
        if (r122 < r123) goto L65;
        boolean r124 = true;
    L67:
        if (this.f505774a.f505760a.onTouchEvent(r110.getAction(), r104, r105) != 1) goto L86;
        requestDisallowInterceptTouchEvent(true);
        if (this.f505795v == false) goto L71;
        updateSelectionRange(this.f505787n, this.f505788o);
    L71:
        Iterator<LynxBaseUI> r125 = this.f505775b.get().getChildren().iterator();
    L73:
        if (r125.hasNext() == false) goto L85;
        LynxBaseUI r126 = r125.next();
        String r127 = r126.getIdSelector();
        if (r127 == null) goto L73;
        if (r127.isEmpty() == true) goto L73;
        if (r127.equals(this.f505774a.f505769j) == true) goto L73;
        float[] r128 = this.f505774a.f505760a.getInlineViewOrigin(r127);
        if (r128[0] != r126.getOriginLeft()) goto L84;
        if (r128[1] == r126.getOriginTop()) goto L73;
    L84:
        r126.setLeft((int) r128[0]);
        r126.setTop((int) r128[1]);
        goto L73
    L85:
        this.f505775b.get().requestLayout();
        invalidate();
        f();
        goto L90
    L86:
        if (r124 == false) goto L88;
        requestDisallowInterceptTouchEvent(true);
        goto L90
    L88:
        requestDisallowInterceptTouchEvent(false);
    L65:
        r124 = false;
    L90:
        if (this.f505778e == false) goto L130;
        if (r110.getAction() != 0) goto L108;
        if (this.f505795v == false) goto L103;
        this.f505796w = true;
        PointF r129 = this.f505793t;
        if (Math.sqrt(Math.pow(r129.x - r104, 2.0d) + Math.pow(r129.y - r105, 2.0d)) >= 50.0d) goto L98;
        adjustStartPosition(r104, r105);
        requestDisallowInterceptTouchEvent(true);
        goto L103
    L98:
        PointF r130 = this.f505794u;
        if (Math.sqrt(Math.pow(r130.x - r104, 2.0d) + Math.pow(r130.y - r105, 2.0d)) >= 50.0d) goto L101;
        adjustEndPosition(r104, r105);
        requestDisallowInterceptTouchEvent(true);
        goto L103
    L101:
        this.f505796w = false;
    L103:
        if (this.f505798y == true) goto L130;
        if (this.f505797x == true) goto L130;
        removeCheckLongPressCallback();
        a r131 = new a(this, r104, r105);
        this.f505799z = r131;
        postDelayed(r131, ViewConfiguration.getLongPressTimeout());
        goto L130
    L108:
        if (r110.getAction() != 2) goto L123;
        a r132 = this.f505799z;
        if (r132 == null) goto L117;
        if (Math.abs(r104 - r132.f505800a) <= 1.0f) goto L114;
    L115:
        removeCheckLongPressCallback();
        goto L117
    L114:
        if (Math.abs(r105 - this.f505799z.f505801b) > 1.0f) goto L115;
    L117:
        if (this.f505797x == false) goto L120;
        adjustStartPosition(r104, r105);
        goto L130
    L120:
        if (this.f505798y == false) goto L130;
        adjustEndPosition(r104, r105);
        goto L130
    L123:
        if (r110.getAction() != 1) goto L126;
        performEndSelection(r104, r105);
        goto L130
    L126:
        if (this.f505796w == false) goto L128;
        performEndSelection(r104, r105);
        goto L130
    L128:
        removeCheckLongPressCallback();
    L130:
        if (r110.getAction() != 1) goto L132;
        this.F = 0.0f;
        this.G = 0.0f;
        this.H = 0;
        this.I = false;
    L132:
        return true;
    L17:
        if (r111 <= r112) goto L24;
    L11:
        if (r106 != 3) goto L24;
        this.F = 0.0f;
        this.G = 0.0f;
        this.H = 0;
        this.I = false;
        goto L24
    L20:
        if ((System.currentTimeMillis() - this.H) <= ViewConfiguration.getLongPressTimeout()) goto L24;
        this.I = false;
        goto L24
    L22:
        this.F = r104;
        this.G = r105;
        this.H = System.currentTimeMillis();
        this.I = true;
        goto L24
    L5:
        return super.onTouchEvent(r110);
    }

    public void setEffect(ReadableArray r100) {
        this.B = r100;
        i();
    }

    public void setEnableTextSelection(boolean r100) {
        this.f505778e = r100;
    }

    public void setTextMarkAttachments(ReadableArray r100) {
        this.C = r100;
        i();
    }

    public void setVSyncAnimation(final boolean r100) {
        this.K = r100;
        UIThreadUtils.runOnUiThreadImmediately(new k0(this, r100));
    }

    public final void adjustEndPosition(float r100, float r101) {
        this.f505798y = true;
        int r102 = getOffsetForPosition(r100, r101);
        int r103 = this.f505787n;
        if (r102 == r103) goto L5;
    L12:
        updateSelectionRange(r103, r102);
        return;
    L5:
        if (r102 != this.A) goto L7;
    L11:
        r102 = r102 - 1;
        goto L12
    L7:
        if (r100 >= this.f505791r.x) goto L10;
        if (r102 > 0) goto L11;
    L10:
        r102 = r102 + 1;
        goto L12
    }

    public final void adjustStartPosition(float r100, float r101) {
        this.f505797x = true;
        int r102 = getOffsetForPosition(r100, r101);
        int r103 = this.f505788o;
        if (r103 == r102) goto L5;
    L12:
        updateSelectionRange(r102, r103);
        return;
    L5:
        if (r102 != this.A) goto L7;
    L11:
        r102 = r102 - 1;
        goto L12
    L7:
        if (r100 >= this.f505792s.x) goto L10;
        if (r102 > 0) goto L11;
    L10:
        r102 = r102 + 1;
        goto L12
    }

    @Override // lr7.b
    public final void b(r r100, Rect r101) {
        this.f505776c.add(r100.f505833e);
    }

    public final int getOffsetForPosition(float r100, float r101) {
        l r102 = this.f505774a;
        if (r102 == null) goto L14;
        MarkdownDocument r103 = r102.f505760a;
        if (r103 == null) goto L14;
        int[] r104 = r103.getCharRangeByPoint(r100, r101, 0);
        if (r104 == null) goto L14;
        if (r104.length < 1) goto L14;
        return Math.min(r104[0], this.A);
    L14:
        return -1;
    }

    public final void performEndSelection(float r100, float r101) {
        requestDisallowInterceptTouchEvent(false);
        if (this.f505795v == true) goto L6;
        removeCheckLongPressCallback();
        return;
    L6:
        boolean r102 = this.f505798y;
        if (r102 == true) goto L15;
        if (this.f505797x == true) goto L15;
        if (this.I == false) goto L15;
        clearSelection();
        return;
    L15:
        if (this.f505797x == false) goto L17;
        adjustStartPosition(r100, r101);
        updateSelectStartEnd();
    L19:
        this.f505797x = false;
        this.f505798y = false;
        return;
    L17:
        if (r102 == false) goto L19;
        adjustEndPosition(r100, r101);
        updateSelectStartEnd();
        goto L19
    }

    public final void updateSelectionRange(int r100, int r101) {
        if (this.f505785l != null) goto L5;
        Context r102 = getContext();
        this.f505785l = r102.getResources().getDrawable(R.drawable.lynx_text_select_handle_left_material);
        this.f505786m = r102.getResources().getDrawable(R.drawable.lynx_text_select_handle_right_material);
        this.f505780g.setStyle(Paint.Style.FILL);
    L5:
        Drawable r103 = this.f505785l;
        int r104 = this.f505783j;
        int r105 = 0;
        r103.setBounds(0, 0, r104, r104);
        Drawable r106 = this.f505786m;
        int r107 = this.f505783j;
        r106.setBounds(0, 0, r107, r107);
        this.f505785l.setTint(this.f505782i);
        this.f505786m.setTint(this.f505782i);
        this.f505780g.setColor(this.f505781h);
        this.f505787n = r100;
        this.f505788o = r101;
        if (r100 < 0) goto L24;
        if (r101 < 0) goto L25;
        ArrayList<RectF> r108 = this.f505774a.f505760a.getSelectionRectByCharPos(Math.min(r100, r101), Math.max(this.f505787n, this.f505788o));
        if (r108.size() <= 0) goto L26;
        this.f505779f.reset();
        RectF r109 = null;
        RectF r110 = null;
    L12:
        if (r105 >= r108.size()) goto L19;
        if (r105 != 0) goto L16;
        r109 = (RectF) ListProtector.get(r108, r105);
    L16:
        if (r105 != (r108.size() - 1)) goto L18;
        r110 = (RectF) ListProtector.get(r108, r105);
    L18:
        this.f505779f.addRect((RectF) ListProtector.get(r108, r105), Path.Direction.CW);
        r105 = r105 + 1;
        goto L12
    L19:
        this.f505779f.close();
        invalidate();
        this.f505791r.set(r109.left, r109.bottom);
        this.f505792s.set(r110.right, r110.bottom);
        this.f505793t.set(this.f505791r.x - (this.f505785l.getBounds().width() / 2.0f), this.f505791r.y + (this.f505785l.getBounds().height() / 2.0f));
        this.f505794u.set(this.f505792s.x + (this.f505786m.getBounds().width() / 2.0f), this.f505792s.y + (this.f505786m.getBounds().height() / 2.0f));
        return;
    L26:
        return;
    L25:
        return;
    }

    public final ArrayList<RectF> g(float r100, float r101, float r102, float r103, int r104) {
        if (r100 >= 0.0f) goto L5;
    L40:
        clearSelection();
        return new ArrayList();
    L5:
        if (r101 < 0.0f) goto L40;
        if (r102 < 0.0f) goto L40;
        if (r103 < 0.0f) goto L40;
        if (this.f505774a == null) goto L40;
        if (Float.compare(r100, r102) == 0) goto L16;
    L18:
        int r105 = getOffsetForPosition(r100, r101);
        int r106 = getOffsetForPosition(r102, r103);
    L19:
        if (r105 < 0) goto L38;
        if (r106 < 0) goto L38;
        if (r105 == r106) goto L24;
    L31:
        this.f505795v = true;
        updateSelectionRange(r105, r106);
        updateSelectStartEnd();
        int r107 = this.f505787n;
        int r108 = this.f505788o;
        if (r107 > r108) goto L37;
        if (r107 < 0) goto L37;
        return this.f505774a.f505760a.getSelectionRectByCharPos(r107, r108);
    L37:
        return new ArrayList();
    L24:
        if (r105 == this.A) goto L30;
        if (r105 > 0) goto L27;
    L29:
        r106 = r106 + 1;
        goto L31
    L27:
        if (r100 >= r102) goto L29;
    L30:
        r105 = r105 - 1;
    L38:
        clearSelection();
        return new ArrayList();
    L16:
        if (Float.compare(r101, r103) != 0) goto L18;
        int[] r109 = this.f505774a.f505760a.getCharRangeByPoint(r100, r101, r104);
        r109[0] = Math.min(r109[0], this.A);
        r106 = Math.min(r109[1], this.A);
        r109[1] = r106;
        r105 = r109[0];
        goto L19
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.K == false) goto L7;
        if (r100 == false) goto L8;
        this.O.layout(0, 0, r103 - r101, r104 - r102);
        return;
    L8:
        return;
    }
}
