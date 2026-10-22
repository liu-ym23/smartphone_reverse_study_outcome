package v5a;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformViewPlugin;
import com.lynx.clay.embedding.engine.sharedimage.SurfaceTexturePlatformWrapper;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import n5a.n;

/* JADX INFO: loaded from: classes32.dex */
public final class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f553282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f553283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f553284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f553285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SurfaceTexture f553286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Surface f553287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f553288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f553289h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f553290i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f553291j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f553292k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f553293l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f553294m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e f553295n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f553296o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f553297p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f553298q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final C7963b f553299r;

    public class a implements ComponentCallbacks2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f553300a;

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r100) {
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public a(b r100) {
            this.f553300a = r100;
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int r100) {
            if (r100 == 80) goto L5;
            return;
        L5:
            if (Build.VERSION.SDK_INT < 29) goto L9;
            this.f553300a.f553291j = true;
            return;
        }
    }

    /* JADX INFO: renamed from: v5a.b$b, reason: collision with other inner class name */
    public class C7963b implements SurfaceTexturePlatformWrapper.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f553301a;

        @Override // com.lynx.clay.embedding.engine.sharedimage.SurfaceTexturePlatformWrapper.a
        public final void a() {
            if (Build.VERSION.SDK_INT == 29) goto L5;
            return;
        L5:
            if (this.f553301a.f553289h.decrementAndGet() >= 0) goto L7;
            this.f553301a.f553289h.set(0);
        L7:
            this.f553301a.f553290i.set(0);
        }

        public C7963b(b r100) {
            this.f553301a = r100;
        }
    }

    public class c implements ViewTreeObserver.OnGlobalFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnFocusChangeListener f553302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f553303b;

        public c(b r100, View.OnFocusChangeListener r101) {
            this.f553303b = r100;
            this.f553302a = r101;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public final void onGlobalFocusChanged(View r100, View r101) {
            View.OnFocusChangeListener r102 = this.f553302a;
            b r103 = this.f553303b;
            r102.onFocusChange(r103, com.lynx.clay.util.d.b(r103, new com.lynx.clay.util.b()));
        }
    }

    public interface d {
    }

    public interface e {
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return false;
    }

    public final void a() {
        if (this.f553296o == false) goto L11;
        int r100 = this.f553297p;
        if (r100 <= 0) goto L13;
        int r101 = r100 - 1;
        this.f553297p = r101;
        if (r101 <= 0) goto L12;
        postInvalidateOnAnimation();
        return;
    L12:
        return;
    L13:
        return;
    }

    public int getBufferHeight() {
        return this.f553285d;
    }

    public int getBufferWidth() {
        return this.f553284c;
    }

    public SurfaceTexture getTexture() {
        return this.f553286e;
    }

    public b(Context r100) {
        super(r100);
        this.f553289h = new AtomicLong(0);
        this.f553290i = new AtomicInteger(0);
        this.f553291j = false;
        this.f553292k = false;
        this.f553293l = true;
        this.f553296o = false;
        this.f553297p = 0;
        a r101 = new a(this);
        this.f553298q = r101;
        this.f553299r = new C7963b(this);
        setWillNotDraw(false);
        r100.registerComponentCallbacks(r101);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f553292k == true) goto L5;
        return false;
    L5:
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L15;
        e r102 = this.f553295n;
        if (r102 != null) goto L10;
    L13:
        boolean r103 = true;
    L14:
        this.f553293l = r103;
        goto L15
    L10:
        if (PlatformViewPlugin.a(((n) r102).f518064a, r100, Math.round(this.f553282a + r100.getX(r100.getActionIndex())), Math.round(this.f553283b + r100.getY(r100.getActionIndex()))) == true) goto L13;
        r103 = false;
    L15:
        boolean r104 = this.f553293l;
        if (r101 != 1) goto L18;
    L19:
        this.f553293l = true;
    L20:
        if (r104 == true) goto L22;
        return false;
    L22:
        boolean r105 = super.dispatchTouchEvent(r100);
        d r106 = this.f553294m;
        if (r106 == null) goto L25;
        PlatformViewPlugin.access$000(((PlatformViewPlugin.a) r106).f380852a, r100, r105);
    L25:
        return r105;
    L18:
        if (r101 != 3) goto L20;
        goto L19
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Surface r101 = this.f553287f;
        if (r101 != null) goto L7;
        super.draw(r100);
        c5a.c.d(6, "PlatformViewWrapper", "Platform view cannot be composed without a surface.");
        return;
    L7:
        if (r101.isValid() == true) goto L10;
        c5a.c.d(6, "PlatformViewWrapper", "Invalid surface. The platform view cannot be displayed.");
        return;
    L10:
        SurfaceTexture r102 = this.f553286e;
        if (r102 != null) goto L13;
    L42:
        c5a.c.d(6, "PlatformViewWrapper", "Invalid texture. The platform view cannot be displayed.");
        return;
    L13:
        if (r102.isReleased() == true) goto L42;
        int r103 = Build.VERSION.SDK_INT;
        if (r103 == 29) goto L18;
    L24:
        boolean r104 = true;
    L25:
        if (r104 == true) goto L28;
        postInvalidateOnAnimation();
        return;
    L28:
        if (this.f553291j == false) goto L33;
        Surface r105 = this.f553287f;
        if (r105 == null) goto L32;
        r105.release();
    L32:
        this.f553287f = new Surface(this.f553286e);
        this.f553291j = false;
    L33:
        Canvas r106 = this.f553287f.lockHardwareCanvas();
        r106.drawColor(0, PorterDuff.Mode.CLEAR);     // Catch: Throwable -> L39
        super.draw(r106);     // Catch: Throwable -> L39
        if (r103 != 29) goto L37;
        this.f553289h.incrementAndGet();     // Catch: Throwable -> L39
    L37:
        this.f553287f.unlockCanvasAndPost(r106);
        a();
        return;
    L39:
        th = move-exception;
        this.f553287f.unlockCanvasAndPost(r106);
        a();
        throw th;
    L18:
        if (this.f553289h.get() > 0) goto L21;
        this.f553290i.set(0);
        goto L24
    L21:
        if (this.f553290i.incrementAndGet() < 3) goto L23;
        this.f553289h.set(0);
        this.f553290i.set(0);
        goto L24
    L23:
        r104 = false;
        goto L25
    }

    public void setLayoutParams(FrameLayout.LayoutParams r100) {
        setLayoutParams(r100);
        this.f553282a = r100.leftMargin;
        this.f553283b = r100.topMargin;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener r100) {
        ViewTreeObserver r101 = getViewTreeObserver();
        if (r101.isAlive() == false) goto L7;
        c r102 = this.f553288g;
        if (r102 == null) goto L7;
        this.f553288g = null;
        r101.removeOnGlobalFocusChangeListener(r102);
    L7:
        ViewTreeObserver r103 = getViewTreeObserver();
        if (r103.isAlive() == true) goto L10;
        return;
    L10:
        if (this.f553288g != null) goto L14;
        c r104 = new c(this, r100);
        this.f553288g = r104;
        r103.addOnGlobalFocusChangeListener(r104);
        return;
    }

    public void setPendingFramesCountForTesting(long r100) {
        this.f553289h.set(r100);
        this.f553290i.set(0);
    }

    public void setPostDrawRedrawEnabled(boolean r100) {
        this.f553296o = r100;
        if (r100 == true) goto L6;
        this.f553297p = 0;
        return;
    }

    public void setSystemTouchDispatchEnabled(boolean r100) {
        this.f553292k = r100;
        if (r100 == true) goto L6;
        this.f553293l = true;
        return;
    }

    public void setTexture(SurfaceTexture r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        c5a.c.d(6, "PlatformViewWrapper", "Platform views cannot be displayed below API level 23. You can prevent this issue by setting `minSdkVersion: 23` in build.gradle.");
        return;
    L6:
        this.f553286e = r100;
        C7963b r101 = this.f553299r;
        WeakHashMap<SurfaceTexture, SurfaceTexturePlatformWrapper.a> r102 = SurfaceTexturePlatformWrapper.f380942c;
        monitor-enter(r102);
        r102.put(r100, r101);     // Catch: Throwable -> L25
        monitor-exit(r102);     // Catch: Throwable -> L25
        int r103 = this.f553284c;
        if (r103 <= 0) goto L15;
        int r104 = this.f553285d;
        if (r104 <= 0) goto L15;
        this.f553286e.setDefaultBufferSize(r103, r104);
    L15:
        Surface r105 = this.f553287f;
        if (r105 == null) goto L18;
        r105.release();
    L18:
        Surface r106 = new Surface(r100);
        this.f553287f = r106;
        Canvas r107 = r106.lockHardwareCanvas();
        r107.drawColor(0, PorterDuff.Mode.CLEAR);     // Catch: Throwable -> L22
        this.f553287f.unlockCanvasAndPost(r107);
        a();
        return;
    L22:
        th = move-exception;
        this.f553287f.unlockCanvasAndPost(r107);
        a();
        throw th;
    L25:
        th = move-exception;
        throw th;
    }

    public void setTouchDispatchResultListener(d r100) {
        this.f553294m = r100;
    }

    public void setTouchDispatchTargetChecker(e r100) {
        this.f553295n = r100;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ViewParent invalidateChildInParent(int[] r100, Rect r101) {
        invalidate();
        return super.invalidateChildInParent(r100, r101);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onDescendantInvalidated(View r100, View r101) {
        super.onDescendantInvalidated(r100, r101);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestSendAccessibilityEvent(View r100, AccessibilityEvent r101) {
        View r102 = getChildAt(0);
        if (r102 == null) goto L8;
        if (r102.getImportantForAccessibility() != 4) goto L8;
        return false;
    L8:
        return super.requestSendAccessibilityEvent(r100, r101);
    }
}
