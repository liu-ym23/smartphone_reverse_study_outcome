package n8a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RenderNode;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.utils.BlurUtils;
import com.lynx.xelement.blur.LynxUIBlurView;

/* JADX INFO: loaded from: classes32.dex */
public class a extends com.lynx.tasm.behavior.ui.view.a implements ViewTreeObserver.OnPreDrawListener {
    public static final String B = null;
    public boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RenderNode f518333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f518334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f518335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f518336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f518337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f518338f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f518339g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f518340h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f518341i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f518342j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LynxUIBlurView f518343k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f518344l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f518345m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f518346n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f518347o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f518348p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f518349q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Object f518350r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile RenderScript f518351s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile ScriptIntrinsicBlur f518352t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile boolean f518353u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Allocation f518354v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f518355w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f518356x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f518357y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile boolean f518358z;

    /* JADX INFO: renamed from: n8a.a$a, reason: collision with other inner class name */
    public class RunnableC6906a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f518359a;

        public final void a() {
            a r100 = this.f518359a;
            if (r100.f518353u == true) goto L48;
            TraceEvent.beginSection("BlurView.createRenderScript");
            RenderScript r101 = RenderScript.create(r100.getContext());     // Catch: RuntimeException -> L32 Throwable -> L36
            ScriptIntrinsicBlur r102 = ScriptIntrinsicBlur.create(r101, Element.U8_4(r101));     // Catch: RuntimeException -> L30 Throwable -> L36
            TraceEvent.endSection("BlurView.createRenderScript");
            Object r103 = r100.f518350r;
            monitor-enter(r103);
        L27:
            th = move-exception;
            throw th;
        L11:
            if (r100.f518353u == false) goto L14;
            monitor-exit(r103);     // Catch: Throwable -> L27
            boolean r104 = false;
        L17:
            if (r104 == true) goto L23;
            if (r101 == null) goto L20;
            r101.destroy();
        L20:
            if (r102 == null) goto L46;
            r102.destroy();
            return;
        L46:
            return;
        L23:
            if (r100.f518358z == false) goto L49;
            r100.post(new n8a.b(r100));
            return;
        L49:
            return;
        L14:
            r100.f518351s = r101;     // Catch: Throwable -> L27
            r100.f518352t = r102;     // Catch: Throwable -> L27
            monitor-exit(r103);     // Catch: Throwable -> L27
            r104 = true;
        L30:
            e = e;
        L34:
            if (r101 == null) goto L38;
            r101.destroy();     // Catch: Throwable -> L36
        L38:
            throw e;     // Catch: Throwable -> L36
        L32:
            e = e;
            r101 = null;
        L36:
            th = move-exception;
            TraceEvent.endSection("BlurView.createRenderScript");
            throw th;
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

        public RunnableC6906a(a r100) {
            this.f518359a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f518360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f518361b;

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f518361b;     // Catch: Throwable -> L8
            boolean r101 = this.f518360a;     // Catch: Throwable -> L8
            r100.f518335c = r101;     // Catch: Throwable -> L8
            if (r101 == false) goto L5;
            a.c(r100);     // Catch: Throwable -> L8
            a r102 = this.f518361b;     // Catch: Throwable -> L8
            r102.f(r102.getWidth(), this.f518361b.getHeight());     // Catch: Throwable -> L8
        L6:
            this.f518361b.invalidate();     // Catch: Throwable -> L8
            return;
        L5:
            r100.getViewTreeObserver().removeOnPreDrawListener(r100);     // Catch: Throwable -> L8
            r100.f518347o = false;     // Catch: Throwable -> L8
            r100.f518349q = false;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }

        public b(a r100, boolean r101) {
            this.f518361b = r100;
            this.f518360a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f518362a;

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f518362a;     // Catch: Throwable -> L6
            if (r100.A == false) goto L9;
            r100.updateBlur();     // Catch: Throwable -> L6
            a r101 = this.f518362a;     // Catch: Throwable -> L6
            r101.A = false;     // Catch: Throwable -> L6
            r101.invalidate();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public c(a r100) {
            this.f518362a = r100;
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

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    static {
        B = a.class.getSimpleName();
    }

    private void getTargetParent() {
        TraceEvent.beginSection("BlurView.getTargetParent");
        LynxUIBlurView r100 = this.f518343k;
        if (r100 != null) goto L6;
        TraceEvent.endSection("BlurView.getTargetParent");
        return;
    L6:
        View r101 = r100.N();
        if (r101 == null) goto L10;
        this.f518344l = r101;
        TraceEvent.endSection("BlurView.getTargetParent");
        return;
    L10:
        this.f518345m.setEmpty();
        this.f518346n = false;
        setTargetBlurParent(this.f518343k.O());
        TraceEvent.endSection("BlurView.getTargetParent");
    }

    public final void e() {
        boolean r100 = true;
        if (this.f518351s == null) goto L35;
        if (this.f518352t == null) goto L35;
        if (this.f518338f != null) goto L10;
        return;
    L10:
        if (this.f518334b == 0.0f) goto L40;
        Allocation r101 = Allocation.createFromBitmap(this.f518351s, this.f518338f);
        Bitmap r102 = this.f518338f;     // Catch: Throwable -> L26 RSRuntimeException -> L28
        if (r102.getHeight() == this.f518356x) goto L16;
    L18:
        r100 = false;
    L19:
        if (r100 == true) goto L24;
        Allocation r103 = this.f518354v;     // Catch: Throwable -> L26 RSRuntimeException -> L28
        if (r103 == null) goto L23;
        r103.destroy();     // Catch: Throwable -> L26 RSRuntimeException -> L28
    L23:
        this.f518354v = Allocation.createTyped(this.f518351s, r101.getType());     // Catch: Throwable -> L26 RSRuntimeException -> L28
        this.f518355w = this.f518338f.getWidth();     // Catch: Throwable -> L26 RSRuntimeException -> L28
        this.f518356x = this.f518338f.getHeight();     // Catch: Throwable -> L26 RSRuntimeException -> L28
    L24:
        this.f518352t.setRadius(this.f518334b);     // Catch: Throwable -> L26 RSRuntimeException -> L28
        this.f518352t.setInput(r101);     // Catch: Throwable -> L26 RSRuntimeException -> L28
        this.f518352t.forEach(this.f518354v);     // Catch: Throwable -> L26 RSRuntimeException -> L28
        this.f518354v.copyTo(this.f518338f);     // Catch: Throwable -> L26 RSRuntimeException -> L28
    L29:
        r101.destroy();
        return;
    L16:
        if (r102.getWidth() != this.f518355w) goto L18;
    L26:
        th = move-exception;
        r101.destroy();
        throw th;
    L28:
        BlurUtils.iterativeBoxBlur(this.f518338f, (int) this.f518334b);     // Catch: Throwable -> L26
        goto L29
    L40:
        return;
    L35:
        if (Build.VERSION.SDK_INT >= 31) goto L41;
        this.f518357y = true;
        return;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        TraceEvent.beginSection("BlurView.updateBlur");
        View r100 = this.f518344l;
        if (r100 != null) goto L5;
    L7:
        TraceEvent.endSection("BlurView.updateBlur");
        return true;
    L5:
        if (r100.isDirty() == false) goto L7;
        this.A = true;
        post(new c(this));
        goto L7
    }

    public final void updateBlur() {
        if (this.f518335c == true) goto L5;
        return;
    L5:
        if (this.f518336d == true) goto L8;
        return;
    L8:
        if (this.f518346n == false) goto L10;
        getTargetParent();
    L10:
        this.f518338f.eraseColor(0);
        this.f518339g.save();
        if (this.f518346n == true) goto L14;
        boolean r100 = true;
    L17:
        if (r100 == false) goto L32;
        int[] r101 = this.f518341i;
        if (r101 == null) goto L28;
        int[] r102 = this.f518342j;
        if (r102 == null) goto L28;
        if (r101.length < 2) goto L28;
        if (r102.length < 2) goto L28;
        int r103 = r102[0] - r101[0];
        int r104 = r102[1] - r101[1];
        float r105 = getHeight() / this.f518338f.getHeight();
        float r106 = getWidth() / this.f518338f.getWidth();
        this.f518339g.translate((-r103) / r106, (-r104) / r105);
        this.f518339g.scale(1.0f / r106, 1.0f / r105);
    L28:
        TraceEvent.beginSection("BlurView.draw");
        View r107 = this.f518344l;
        if (r107 == null) goto L31;
        r107.draw(this.f518339g);
    L31:
        TraceEvent.endSection("BlurView.draw");
    L32:
        this.f518339g.restore();
        TraceEvent.beginSection("BlurView.blur");
        if (BlurUtils.createEffect(this.f518333a, this.f518334b) == true) goto L35;
        e();
    L35:
        RenderNode r108 = this.f518333a;
        if (r108 == null) goto L38;
        r108.beginRecording().drawBitmap(this.f518338f, 0.0f, 0.0f, null);
        this.f518333a.endRecording();
    L38:
        TraceEvent.endSection("BlurView.blur");
        return;
    L14:
        if (this.f518345m.isEmpty() == false) goto L16;
        r100 = false;
        goto L17
    L16:
        float r109 = getHeight() / this.f518338f.getHeight();
        float r110 = getWidth() / this.f518338f.getWidth();
        d r111 = this.f518339g;
        Rect r112 = this.f518345m;
        r100 = r111.clipRect(r112.left / r110, r112.top / r109, r112.right / r110, r112.bottom / r109);
        goto L17
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f518358z = true;
        if (this.f518335c == true) goto L5;
        return;
    L5:
        if (isHardwareAccelerated() == true) goto L8;
        LLog.e(B, "BlurView can't be used in not hardware-accelerated window!");
        return;
    L8:
        if (this.f518349q == false) goto L13;
        getViewTreeObserver().addOnPreDrawListener(this);
        this.f518349q = false;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f518358z = false;
        if (this.f518347o == false) goto L6;
        getViewTreeObserver().removeOnPreDrawListener(this);
        this.f518349q = true;
        return;
    }

    public a(Context r100) {
        super(r100);
        this.f518335c = true;
        this.f518337e = 6.0f;
        this.f518340h = false;
        this.f518345m = new Rect();
        this.f518348p = true;
        this.f518350r = new Object();
        this.f518353u = false;
        this.f518357y = false;
        this.f518358z = false;
        this.A = false;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 29) goto L6;
        this.f518333a = new RenderNode("BlurView");
    L6:
        if (r101 >= 23) goto L9;
        this.f518335c = false;
        return;
    L9:
        if (r101 >= 31) goto L13;
        LynxThreadPool.b().execute(new RunnableC6906a(this));
        return;
    }

    public static /* synthetic */ void c(a r100) {
        r100.getTargetParent();
    }

    private void setTargetBlurParent(LynxBaseUI r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFlatten() == false) goto L10;
        if ((r100.getDrawParent() instanceof LynxUI) == false) goto L10;
        this.f518344l = ((LynxUI) r100.getDrawParent()).getView();
        return;
    L10:
        if ((r100 instanceof LynxUI) == false) goto L14;
        this.f518344l = ((LynxUI) r100).getView();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public final void draw(Canvas r100) {
        if (this.f518334b != 0.0f) goto L5;
    L34:
        boolean r101 = true;
    L35:
        if (r101 == false) goto L38;
        super.draw(r100);
        return;
    L38:
        return;
    L5:
        if (this.f518336d == false) goto L34;
        if (this.f518357y == true) goto L34;
        if ((r100 instanceof d) == false) goto L12;
        r101 = false;
        goto L35
    L12:
        float r102 = getHeight() / this.f518338f.getHeight();
        float r103 = getWidth() / this.f518338f.getWidth();
        r100.save();
        if (this.f518340h == false) goto L24;
        LynxUIBlurView r104 = this.f518343k;
        if (r104 == null) goto L24;
        if (r104.getLynxBackground() == null) goto L19;
        BackgroundDrawable r105 = (BackgroundDrawable) this.f518343k.getLynxBackground().f383142b;
    L20:
        if (r105 == null) goto L24;
        Path r106 = r105.l();
        if (r106 == null) goto L24;
        r100.clipPath(r106);
        goto L24
    L19:
        r105 = null;
    L24:
        r100.scale(r103, r102);
        if (this.f518338f == null) goto L33;
        TraceEvent.beginSection("BlurView.innerDraw");
        if (this.f518333a != null) goto L29;
    L31:
        r100.drawBitmap(this.f518338f, 0.0f, 0.0f, null);
    L32:
        TraceEvent.endSection("BlurView.innerDraw");
        goto L33
    L29:
        if (r100.isHardwareAccelerated() == false) goto L31;
        r100.drawRenderNode(this.f518333a);
    L33:
        r100.restore();
        goto L34
    }

    public void setBlurRadius(float r100) {
        if (r100 >= 0.0f) goto L6;
        r100 = 0.0f;
    L6:
        if (this.f518334b == r100) goto L9;
        this.f518334b = r100;
        postInvalidate();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a
    public void setBlurSampling(int r100) {
        super.setBlurSampling(r100);
        this.f518337e = r100;
    }

    public void setBlurViewLocation(int[] r100) {
        this.f518342j = r100;
    }

    public void setEnableBlurAutoUpdate(boolean r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        r100 = false;
    L6:
        if (this.f518335c == r100) goto L9;
        post(new b(this, r100));
        return;
    }

    public void setExperimentalUpdateBlurRadius(boolean r100) {
        this.f518348p = r100;
    }

    public void setHasRadiusIfRadiusChanged(boolean r100) {
        if (this.f518340h == r100) goto L6;
        this.f518340h = r100;
        return;
    }

    public void setLynxBaseUI(LynxUIBlurView r100) {
        this.f518343k = r100;
    }

    public void setRootLocation(int[] r100) {
        this.f518341i = r100;
    }

    public final void f(int r100, int r101) {
        if (this.f518347o == false) goto L5;
    L7:
        float r102 = r100;
        if (((int) Math.ceil(r102 / this.f518337e)) == 0) goto L33;
        float r103 = r101;
        if (((int) Math.ceil(r103 / this.f518337e)) == 0) goto L33;
        int r104 = (int) Math.ceil(r102 / this.f518337e);
        int r105 = r104 % 64;
        if (r105 == 0) goto L16;
        r104 = (r104 - r105) + 64;
    L16:
        int r106 = (int) Math.ceil(r103 / (r102 / r104));
        if (r104 <= 0) goto L31;
        if (r106 <= 0) goto L31;
        setWillNotDraw(false);
        Bitmap r107 = this.f518338f;
        if (r107 != null) goto L23;
    L26:
        TraceEvent.beginSection("BlurView.createBitmap");
        this.f518338f = Bitmap.createBitmap(r104, r106, Bitmap.Config.ARGB_8888);
        TraceEvent.endSection("BlurView.createBitmap");
        this.f518339g = new d(this.f518338f);
        RenderNode r108 = this.f518333a;
        if (r108 == null) goto L29;
        r108.setPosition(0, 0, this.f518338f.getWidth(), this.f518338f.getHeight());
    L29:
        this.f518336d = true;
        return;
    L23:
        if (r107.getHeight() != r106) goto L26;
        if (this.f518338f.getWidth() == r104) goto L29;
    L31:
        setWillNotDraw(true);
        return;
    L33:
        setWillNotDraw(true);
        return;
    L5:
        if (this.f518335c == false) goto L7;
        getViewTreeObserver().addOnPreDrawListener(this);
        this.f518347o = true;
        goto L7
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.f518335c == false) goto L10;
        if (this.f518340h == false) goto L10;
        if (getBackground() == null) goto L10;
        getBackground().setBounds(0, 0, r100, r101);
    L10:
        if (this.f518348p == true) goto L13;
        f(r100, r101);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f518335c == false) goto L6;
        getTargetParent();
        return;
    }
}
