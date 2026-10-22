package com.lynx.tasm.behavior;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.config.LynxLiteConfigs;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.render.NativePaintingContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public class LynxUIRenderer implements ILynxUIRenderer {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Object f381914p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static PthreadHandlerThreadV2 f381915q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<LynxContext> f381916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LynxUIOwner f381917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b1 f381918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v0 f381919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f381920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f381921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f381922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LynxBooleanOption f381923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f381924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f381925j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f381926k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f381927l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f381928m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f381929n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f381930o;

    private static native long nativeCreateUIDelegate(long r100, long r101);

    private static native void nativeDestroyUIDelegate(long r100);

    static {
        f381914p = new Object();
        f381915q = null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class b() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.view.ViewRootImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.ViewRootImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.ViewRootImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.view.ViewRootImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.ViewRootImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.ViewRootImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.ViewRootImpl");
    }

    public static synchronized void n() {
        monitor-enter(LynxUIRenderer.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f381915q != null) goto L7;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("PixelCopier");     // Catch: Throwable -> L9
        f381915q = r100;     // Catch: Throwable -> L9
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(LynxUIRenderer.class);
    }

    public final void a() {
        LynxUIOwner r100 = this.f381917b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f381918c != null) goto L33;
        b1 r101 = new b1(r100);
        this.f381918c = r101;
        boolean r102 = this.f381917b.getHasTouchPseudo();
        boolean r103 = true;
        if (r101.f381989w == true) goto L11;
        if (r102 == true) goto L11;
        boolean r104 = false;
    L12:
        r101.f381989w = r104;
        if (this.f381924i == false) goto L34;
        this.f381924i = false;
        if (this.f381917b.getContext() == null) goto L35;
        LynxContext r105 = this.f381917b.getContext();
        r105.setTouchEventDispatcher(this.f381918c);
        String r106 = this.f381925j;
        if (r106 != null) goto L19;
    L21:
        b1 r107 = this.f381918c;
        boolean r108 = this.f381927l;
        if (r107.f381989w == true) goto L26;
        if (r108 == true) goto L26;
        r103 = false;
    L26:
        r107.f381989w = r103;
        r107.f381992z = this.f381926k;
        r107.f381990x = this.f381929n;
        if (this.f381928m == true) goto L29;
        return;
    L29:
        if (LynxLiteConfigs.enableNewGesture() == false) goto L37;
        b1 r109 = this.f381918c;
        r109.f381977k = this.f381917b.getGestureArenaManager();
        return;
    L37:
        return;
    L19:
        if (r106.equals("50px") == true) goto L21;
        b1 r110 = this.f381918c;
        r110.f381981o = com.lynx.tasm.utils.n.e(r106, 0.0f, r105.getScreenMetrics());
        goto L21
    L35:
        return;
    L34:
        return;
    L11:
        r104 = true;
        goto L12
    }

    public final Bitmap f() {
        LynxView r100 = this.f381916a.get().getLynxView();
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.getWidth() > 0) goto L7;
        return null;
    L7:
        if (r100.getHeight() <= 0) goto L14;
        Bitmap r101 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r102 = new Canvas(r101);
        r102.drawColor(h(r100));
        d(r100, r102);
        return r101;
    L14:
        return null;
    }

    public final UIBody g() {
        LynxUIOwner r100 = this.f381917b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRootUI();
    }

    public final long j() {
        if (this.f381921f != 0) goto L18;
        l r100 = this.f381920e;
        if (r100 == null) goto L7;
        long r101 = r100.a();
    L8:
        v0 r102 = this.f381919d;
        if (r102 == null) goto L11;
        long r103 = r102.f381878c;
    L13:
        if (r101 == 0) goto L18;
        if (r103 == 0) goto L18;
        this.f381921f = nativeCreateUIDelegate(r101, r103);
        goto L18
    L11:
        r103 = 0;
        goto L13
    L7:
        r101 = 0;
    L18:
        return this.f381921f;
    }

    public final void l() {
        v0 r100 = this.f381919d;
        if (r100 == null) goto L5;
        r100.b();
        this.f381919d = null;
    L5:
        l r101 = this.f381920e;
        if (r101 == null) goto L8;
        r101.destroy();
        this.f381920e = null;
    L8:
        LynxUIOwner r102 = this.f381917b;
        if (r102 == null) goto L11;
        r102.setPaintingContext(null);
    L11:
        long r103 = this.f381921f;
        if (r103 == 0) goto L15;
        nativeDestroyUIDelegate(r103);
        this.f381921f = 0;
        return;
    }

    public LynxUIRenderer() {
        this.f381921f = 0;
        this.f381922g = "fullscreen";
        this.f381925j = "50px";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int h(View r100) {
        ViewParent r101 = r100.getParent();     // Catch: Throwable -> L11
    L4:
        if ((r101 instanceof View) == false) goto L21;
        ViewParent r102 = r101.getParent();     // Catch: Throwable -> L11
        Drawable r103 = ((View) r101).getBackground();     // Catch: Throwable -> L11
        if ((r103 instanceof ColorDrawable) == false) goto L10;
        int r104 = ((ColorDrawable) r103).getColor();     // Catch: Throwable -> L11
        if (r104 == 0) goto L10;
        return r104;
    L10:
        r101 = r102;
        goto L4
    L21:
        return -1;
    L11:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public final void d(View r110, Canvas r111) {
    L36:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (LynxEnv.inst().isPixelCopyEnabled() == false) goto L34;
        int r100 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L36
        if (r100 < 26) goto L34;
        int[] r101 = new int[2];     // Catch: Throwable -> L36
        if (r100 < 29) goto L9;
        r110.getLocationInSurface(r101);     // Catch: Throwable -> L36
    L10:
        Field r102 = b().getDeclaredField("mSurface");     // Catch: Throwable -> L36
        if (r110.getRootView().getParent() != null) goto L14;
        r110.draw(r111);     // Catch: Throwable -> L36
        return;
    L14:
        Surface r103 = (Surface) r102.get(r110.getRootView().getParent());     // Catch: Throwable -> L36
        DisplayMetrics r104 = DisplayMetricsHolder.getRealScreenDisplayMetrics(r110.getContext());     // Catch: Throwable -> L36
        int r105 = r104.widthPixels;     // Catch: Throwable -> L36
        int r106 = r104.heightPixels;     // Catch: Throwable -> L36
        int r107 = Math.max(0, r101[0]);     // Catch: Throwable -> L36
        int r108 = Math.max(0, r101[1]);     // Catch: Throwable -> L36
        Rect r109 = new Rect(r107, r108, Math.min(r101[0] + r110.getWidth(), r105), Math.min(r101[1] + r110.getHeight(), r106));     // Catch: Throwable -> L36
        int r112 = Math.max(0, r109.width());     // Catch: Throwable -> L36
        int r113 = Math.max(0, r109.height());     // Catch: Throwable -> L36
        if (r112 <= 0) goto L32;
        if (r113 <= 0) goto L32;
        Bitmap r114 = Bitmap.createBitmap(r112, r113, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L36
        n();     // Catch: Throwable -> L36
        Object r115 = f381914p;     // Catch: Throwable -> L36
        monitor-enter(r115);     // Catch: Throwable -> L36
        PixelCopy.request(r103, r109, r114, new k0(), new Handler(f381915q.getLooper()));     // Catch: Throwable -> L29
        r115.wait(10000);     // Catch: InterruptedException -> L24 Throwable -> L29
    L26:
        monitor-exit(r115);     // Catch: Throwable -> L29
        r111.drawBitmap(r114, r107 - r101[0], r108 - r101[1], null);     // Catch: Throwable -> L36
        r114.recycle();     // Catch: Throwable -> L36
        return;
    L24:
        e = move-exception;
        LLog.e("DevTool Screenshot", e.toString());     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L32:
        r111.drawColor(0);     // Catch: Throwable -> L36
        return;
    L9:
        r110.getLocationInWindow(r101);     // Catch: Throwable -> L36
    L34:
        r110.draw(r111);     // Catch: Throwable -> L36
    }

    public final float[] i(int r110, float[] r111) {
        float[] r100 = new float[32];
        l r101 = this.f381920e;
        if (r101 != null) goto L6;
        LLog.e("LynxUIRenderer", "getTransformValue failed since mPaintingContext is null.");
        return r100;
    L6:
        int r102 = r101.b(r110);
        int r103 = this.f381920e.h(r110);
        int r104 = 0;
    L8:
        if (r104 >= 4) goto L20;
        if (r104 != 0) goto L13;
        float r105 = (r111[BoxModelOffset.PAD_LEFT.ordinal()] + r111[BoxModelOffset.BORDER_LEFT.ordinal()]) + r111[BoxModelOffset.LAYOUT_LEFT.ordinal()];
        float r106 = ((r102 - r111[BoxModelOffset.PAD_RIGHT.ordinal()]) - r111[BoxModelOffset.BORDER_RIGHT.ordinal()]) - r111[BoxModelOffset.LAYOUT_RIGHT.ordinal()];
        float r107 = (r111[BoxModelOffset.PAD_TOP.ordinal()] + r111[BoxModelOffset.BORDER_TOP.ordinal()]) + r111[BoxModelOffset.LAYOUT_TOP.ordinal()];
        float r108 = (r103 - r111[BoxModelOffset.PAD_BOTTOM.ordinal()]) - r111[BoxModelOffset.BORDER_BOTTOM.ordinal()];
        float r109 = r111[BoxModelOffset.LAYOUT_BOTTOM.ordinal()];
    L11:
        float r112 = r108 - r109;
        PointF r113 = this.f381920e.g(r110, new PointF(r105, r107));
        PointF r114 = this.f381920e.g(r110, new PointF(r106, r107));
        PointF r115 = this.f381920e.g(r110, new PointF(r105, r112));
        PointF r116 = this.f381920e.g(r110, new PointF(r106, r112));
        int r117 = r104 * 8;
        r100[r117] = r113.x;
        r100[r117 + 1] = r113.y;
        r100[r117 + 2] = r114.x;
        r100[r117 + 3] = r114.y;
        r100[r117 + 4] = r116.x;
        r100[r117 + 5] = r116.y;
        r100[r117 + 6] = r115.x;
        r100[r117 + 7] = r115.y;
        r104 = r104 + 1;
        goto L8
    L13:
        if (r104 != 1) goto L16;
        r105 = r111[BoxModelOffset.BORDER_LEFT.ordinal()] + r111[BoxModelOffset.LAYOUT_LEFT.ordinal()];
        r106 = (r102 - r111[BoxModelOffset.BORDER_RIGHT.ordinal()]) - r111[BoxModelOffset.LAYOUT_RIGHT.ordinal()];
        r107 = r111[BoxModelOffset.BORDER_TOP.ordinal()] + r111[BoxModelOffset.LAYOUT_TOP.ordinal()];
        r108 = r103 - r111[BoxModelOffset.BORDER_BOTTOM.ordinal()];
        r109 = r111[BoxModelOffset.LAYOUT_BOTTOM.ordinal()];
        goto L11
    L16:
        if (r104 != 2) goto L18;
        r105 = r111[BoxModelOffset.LAYOUT_LEFT.ordinal()];
        r106 = r102 - r111[BoxModelOffset.LAYOUT_RIGHT.ordinal()];
        r107 = r111[BoxModelOffset.LAYOUT_TOP.ordinal()];
        r108 = r103;
        r109 = r111[BoxModelOffset.LAYOUT_BOTTOM.ordinal()];
        goto L11
    L18:
        r105 = (-r111[BoxModelOffset.MARGIN_LEFT.ordinal()]) + r111[BoxModelOffset.LAYOUT_LEFT.ordinal()];
        r106 = (r102 + r111[BoxModelOffset.MARGIN_RIGHT.ordinal()]) - r111[BoxModelOffset.LAYOUT_RIGHT.ordinal()];
        r107 = (-r111[BoxModelOffset.MARGIN_TOP.ordinal()]) + r111[BoxModelOffset.LAYOUT_TOP.ordinal()];
        r108 = r103 + r111[BoxModelOffset.MARGIN_BOTTOM.ordinal()];
        r109 = r111[BoxModelOffset.LAYOUT_BOTTOM.ordinal()];
        goto L11
    L20:
        return r100;
    }

    public final void c(UIBody.UIBodyView r100, LynxContext r101, Context r102) {
        if (r101 == null) goto L12;
        this.f381916a = new WeakReference(r101);
        r101.setLynxUIOwner(this.f381917b);
        r101.setUIBody(this.f381917b.getRootUI());
        r101.setBaseContext(r102);
        r101.setUIBodyView(r100);
        b1 r103 = this.f381918c;
        if (r103 == null) goto L12;
        k r104 = r103.f381968b;
        if (r104 == null) goto L11;
        if (r102 != null) goto L9;
        int r105 = ViewConfiguration.getTouchSlop();
    L10:
        r104.f382093a = r105 * r105;
        goto L11
    L9:
        r105 = ViewConfiguration.get(r102).getScaledTouchSlop();
    L11:
        r101.setTouchEventDispatcher(this.f381918c);
    L12:
        LynxUIOwner r106 = this.f381917b;
        if (r106 == null) goto L16;
        r106.attachLynxContext(r101);
        this.f381917b.attachUIBodyView(r100);
        return;
    }

    public final int e(float r100, float r101, int r102, String r103) {
        LynxUIOwner r104 = this.f381917b;
        if (r104 == null) goto L19;
        if (r102 != 0) goto L6;
        LynxBaseUI r105 = r104.getRootUI();
    L9:
        if (r105 == null) goto L19;
        float[] r106 = {r100, r101};
        if (r103 != null) goto L13;
    L15:
        EventTarget r107 = r105.hitTest(r106[0], r106[1], true);
        if (r107 == null) goto L19;
        return r107.getSign();
    L13:
        if (r103.equals("fullscreen") == false) goto L15;
        r106 = new float[]{r100, r101};
        float[] r108 = r105.getLocationOnScreen(new float[2]);
        r106[0] = r106[0] - r108[0];
        r106[1] = r106[1] - r108[1];
        goto L15
    L6:
        r105 = r104.getNode(r102);
        if (r105 == null) goto L9;
        r105 = ((LynxUI) r105).getTransitionUI();
    L19:
        return 0;
    }

    public final void k(LynxContext r100, ThreadStrategyForRendering r101, c r102, y6a.f r103) {
        if (this.f381917b != null) goto L6;
        return;
    L6:
        if (this.f381920e == null) goto L8;
    L12:
        this.f381917b.setPaintingContext(this.f381920e);
        if (this.f381919d != null) goto L15;
        this.f381919d = new v0(r100, r102, r103);
    L15:
        r100.setShadowNodeOwner(this.f381919d);
        return;
    L8:
        if (r100.isFragmentLayerRenderOn() == false) goto L10;
        l r104 = new NativePaintingContext(this.f381917b.getRootUI().getBodyView(), r100, r102);
    L11:
        this.f381920e = r104;
        goto L12
    L10:
        r104 = new PaintingContext(this.f381917b, r101.id());
        goto L11
    }

    public final void m(LynxContext r100, c r101, UIBody.UIBodyView r102, LynxBooleanOption r103) {
        if (this.f381930o == true) goto L5;
        this.f381917b = new LynxUIOwner(r100, r101, r102);
    L7:
        if (r102 != null) goto L9;
        this.f381917b.setContextFree(true);
    L9:
        r100.setLynxUIOwner(this.f381917b);
        r100.setUIBody(this.f381917b.getRootUI());
        r100.setUIBodyView(r102);
        this.f381916a = new WeakReference(r100);
        this.f381923h = r103;
        this.f381930o = true;
        return;
    L5:
        this.f381917b.attachLynxContext(r100);
        this.f381917b.attachUIBodyView(r102);
        goto L7
    }
}
