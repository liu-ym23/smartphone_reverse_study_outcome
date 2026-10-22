package com.ss.android.ugc.aweme.search.vision.widget.blur;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.home.impl.utils.c;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class RealtimeBlurView extends View {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f454080p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f454081q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final StopException f454082r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f454083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f454084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f454085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BlurImpl f454086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f454087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f454088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f454089g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Canvas f454090h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f454091i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f454092j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f454093k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f454094l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f454095m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f454096n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ViewTreeObserver.OnPreDrawListener f454097o;

    public static class StopException extends RuntimeException {
        private StopException() {
        }

        public /* synthetic */ StopException(AnonymousClass1 r100) {
            this();
        }
    }

    static {
        f454082r = new StopException(null);
    }

    public final void c() {
        Bitmap r100 = this.f454088f;
        if (r100 == null) goto L5;
        r100.recycle();
        this.f454088f = null;
    L5:
        Bitmap r101 = this.f454089g;
        if (r101 == null) goto L9;
        r101.recycle();
        this.f454089g = null;
        return;
    }

    public BlurImpl getBlurImpl() {
        if (f454081q != 0) goto L8;
        AndroidStockBlurImpl r100 = new AndroidStockBlurImpl();     // Catch: Throwable -> L6
        Bitmap r101 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L6
        r100.a(getContext(), r101, 4.0f);     // Catch: Throwable -> L6
        r100.release();     // Catch: Throwable -> L6
        r101.recycle();     // Catch: Throwable -> L6
        f454081q = 3;     // Catch: Throwable -> L6
    L8:
        if (f454081q != 0) goto L13;
        a(getClass().getClassLoader(), "androidx.renderscript.RenderScript");     // Catch: Throwable -> L11
        AndroidXBlurImpl r102 = new AndroidXBlurImpl();     // Catch: Throwable -> L11
        Bitmap r103 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L11
        r102.a(getContext(), r103, 4.0f);     // Catch: Throwable -> L11
        r102.release();     // Catch: Throwable -> L11
        r103.recycle();     // Catch: Throwable -> L11
        f454081q = 1;     // Catch: Throwable -> L11
    L13:
        if (f454081q != 0) goto L18;
        a(getClass().getClassLoader(), "android.support.v8.renderscript.RenderScript");     // Catch: Throwable -> L16
        SupportLibraryBlurImpl r104 = new SupportLibraryBlurImpl();     // Catch: Throwable -> L16
        Bitmap r105 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L16
        r104.a(getContext(), r105, 4.0f);     // Catch: Throwable -> L16
        r104.release();     // Catch: Throwable -> L16
        r105.recycle();     // Catch: Throwable -> L16
        f454081q = 2;     // Catch: Throwable -> L16
    L18:
        if (f454081q != 0) goto L20;
        f454081q = -1;
    L20:
        int r106 = f454081q;
        if (r106 == 1) goto L31;
        if (r106 == 2) goto L29;
        if (r106 == 3) goto L27;
        return new EmptyBlurImpl();
    L27:
        return new AndroidStockBlurImpl();
    L29:
        return new SupportLibraryBlurImpl();
    L31:
        return new AndroidXBlurImpl();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        View r100 = this.f454095m;
        if (r100 == null) goto L5;
        r100.getViewTreeObserver().removeOnPreDrawListener(this.f454097o);
    L5:
        b();
        super.onDetachedFromWindow();
    }

    public final void b() {
        c();
        this.f454086d.release();
    }

    public View getActivityDecorView() {
        Context r100 = getContext();
        int r101 = 0;
    L4:
        if (r101 >= 4) goto L12;
        if (r100 == null) goto L12;
        if ((r100 instanceof Activity) == true) goto L12;
        if ((r100 instanceof ContextWrapper) == false) goto L12;
        r100 = ((ContextWrapper) r100).getBaseContext();
        r101 = r101 + 1;
    L12:
        if ((r100 instanceof Activity) == false) goto L19;
        View r102 = ((Activity) r100).getWindow().getDecorView();
        if (c.f346345e == false) goto L18;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == c.f346341a) goto L18;
        c.a(r103, "getDecorView");
    L18:
        return r102;
    L19:
        return null;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View r100 = getActivityDecorView();
        this.f454095m = r100;
        boolean r101 = false;
        if (r100 == null) goto L10;
        r100.getViewTreeObserver().addOnPreDrawListener(this.f454097o);
        if (this.f454095m.getRootView() == getRootView()) goto L7;
        r101 = true;
    L7:
        this.f454096n = r101;
        if (r101 == false) goto L12;
        this.f454095m.postInvalidate();
        return;
    L12:
        return;
    L10:
        this.f454096n = false;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        if (this.f454091i == true) goto L10;
        if (f454080p > 0) goto L11;
        super.draw(r100);
        return;
    L11:
        return;
    L10:
        throw f454082r;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        Bitmap r101 = this.f454089g;
        int r102 = this.f454084b;
        if (r101 == null) goto L5;
        Rect r103 = this.f454093k;
        r103.right = r101.getWidth();
        Rect r104 = this.f454093k;
        r104.bottom = r101.getHeight();
        Rect r105 = this.f454094l;
        r105.right = getWidth();
        Rect r106 = this.f454094l;
        r106.bottom = getHeight();
        r100.drawBitmap(r101, this.f454093k, this.f454094l, null);
    L5:
        this.f454092j.setColor(r102);
        r100.drawRect(this.f454094l, this.f454092j);
    }

    public void setBlurRadius(float r100) {
        if (this.f454085c == r100) goto L6;
        this.f454085c = r100;
        this.f454087e = true;
        invalidate();
        return;
    }

    public void setDownsampleFactor(float r100) {
        if (r100 <= 0.0f) goto L9;
        if (this.f454083a == r100) goto L10;
        this.f454083a = r100;
        this.f454087e = true;
        c();
        invalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Downsample factor must be greater than 0.");
    }

    public void setOverlayColor(int r100) {
        if (this.f454084b == r100) goto L6;
        this.f454084b = r100;
        invalidate();
        return;
    }

    public RealtimeBlurView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f454093k = new Rect();
        this.f454094l = new Rect();
        this.f454097o = new AnonymousClass1(this);
        this.f454086d = getBlurImpl();
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.realtimeBlurRadius, R.attr.realtimeDownsampleFactor, R.attr.realtimeOverlayColor});
        Resources r103 = r100.getResources();
        this.f454085c = r102.getDimension(0, TypedValue.applyDimension(1, 10.0f, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        this.f454083a = r102.getFloat(1, 4.0f);
        this.f454084b = r102.getColor(2, -1426063361);
        r102.recycle();
        this.f454092j = new Paint();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static void a(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.loadClass(r101);
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }
}
