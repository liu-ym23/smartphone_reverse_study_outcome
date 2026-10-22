package com.ss.android.lark.forseti.util.dragging;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import androidx.window.layout.WindowMetricsCalculator;
import cib.f;
import cib.g;
import com.larus.nova.R;
import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ForsetiColumnsDraggingHelper {
    public float A;
    public final Paint B;
    public final Paint C;
    public final Paint D;
    public final Paint E;
    public final Paint F;
    public final Paint G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f424581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f424582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f424583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f424584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f424585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f424586f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f424587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f424588h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f424589i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f424590j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f424591k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f424592l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f424593m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f424594n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f424595o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f424596p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f424597q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f424598r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f424599s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f424600t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f424601u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f424602v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f424603w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f424604x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f424605y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f424606z;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f424607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f424608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f424609c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f424610d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Float.compare(this.f424607a, r101.f424607a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f424608b, r101.f424608b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f424609c, r101.f424609c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f424610d, r101.f424610d) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.f424607a) * 31) + Float.floatToIntBits(this.f424608b)) * 31) + Float.floatToIntBits(this.f424609c)) * 31) + Float.floatToIntBits(this.f424610d);
        }

        public final String toString() {
            return "Region(left=" + this.f424607a + ", top=" + this.f424608b + ", right=" + this.f424609c + ", bottom=" + this.f424610d + ')';
        }

        public b(float r100, float r101, float r102, float r103) {
            this.f424607a = r100;
            this.f424608b = r101;
            this.f424609c = r102;
            this.f424610d = r103;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f424611a = null;

        static {
            int[] r100 = new int[ForsetiWidth.values().length];
            r100[ForsetiWidth.FULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r100[ForsetiWidth.FIXED_LEVEL1_IN_NARROW_SCREEN_RIGHT_SIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r100[ForsetiWidth.FIXED_LEVEL1_IN_WIDE_SCREEN_RIGHT_SIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[ForsetiWidth.AVERAGE_LEVEL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[ForsetiWidth.FIXED_LEVEL2_IN_NARROW_SCREEN_RIGHT_SIDE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r100[ForsetiWidth.FIXED_LEVEL2_IN_WIDE_SCREEN_RIGHT_SIDE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r100[ForsetiWidth.FIXED_LEVEL1_IN_NARROW_SCREEN_LEFT_SIDE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r100[ForsetiWidth.FIXED_LEVEL1_IN_WIDE_SCREEN_LEFT_SIDE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r100[ForsetiWidth.FIXED_LEVEL2_IN_NARROW_SCREEN_LEFT_SIDE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[ForsetiWidth.FIXED_LEVEL2_IN_WIDE_SCREEN_LEFT_SIDE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f424611a = r100;
        }
    }

    static {
    }

    public static boolean h(float r100) {
        if (r100 > 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public final ForsetiWidth d() {
        int r100 = f.a(this.f424581a, 750.0f);
        Rect r101 = WindowMetricsCalculator.Companion.getOrCreate().computeCurrentWindowMetrics(ContextsKt.requireActivity(this.f424581a)).getBounds();
        float r102 = r101.width();
        if (r101.width() <= r100) goto L12;
        if (r102 > this.f424585e) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L14;
        return ForsetiWidth.FIXED_LEVEL1_IN_NARROW_SCREEN_LEFT_SIDE;
    L14:
        return ForsetiWidth.FIXED_LEVEL1_IN_WIDE_SCREEN_LEFT_SIDE;
    L7:
        r103 = false;
        goto L8
    L12:
        return ForsetiWidth.AVERAGE_LEVEL;
    }

    public final boolean e() {
        return ((Boolean) this.f424582b.getValue()).booleanValue();
    }

    public final boolean f() {
        return ((Boolean) this.f424583c.getValue()).booleanValue();
    }

    public final Context getContext() {
        return this.f424581a;
    }

    public ForsetiColumnsDraggingHelper(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f424581a = r100;
        this.f424582b = LazyKt.lazy(ForsetiColumnsDraggingHelper$optimizeDraggingViewDisabled$2.INSTANCE);
        this.f424583c = LazyKt.lazy(ForsetiColumnsDraggingHelper$optimizeDraggingViewUnderKeyboardDisabled$2.INSTANCE);
        this.f424585e = f.a(r100, 1194.0f);
        this.f424586f = f.a(r100, 318.0f);
        this.f424587g = f.a(r100, 376.0f);
        this.f424588h = f.a(r100, 100.0f);
        this.f424589i = f.a(r100, 24.0f);
        this.f424590j = f.a(r100, 32.0f);
        int r101 = f.a(r100, 0.5f);
        this.f424591k = r101;
        this.f424592l = f.a(r100, 48.0f);
        this.f424593m = f.a(r100, 12.0f);
        this.f424594n = f.a(r100, 8.0f);
        this.f424595o = f.a(r100, 16.0f);
        this.f424596p = f.a(r100, 28.0f);
        this.f424597q = f.a(r100, 2.0f);
        this.f424598r = f.a(r100, 2.0f);
        this.f424599s = f.a(r100, 32.0f);
        this.f424600t = f.a(r100, 12.0f);
        this.f424601u = f.a(r100, 48.0f);
        this.f424602v = f.a(r100, 502.0f);
        this.f424603w = R.color.ud_N300;
        this.f424604x = R.color.ud_N400;
        Paint r102 = new Paint();
        r102.setColor(f.b(r100, R.color.ud_N300));
        float r103 = r101;
        r102.setStrokeWidth(r103);
        this.B = r102;
        Paint r104 = new Paint();
        r104.setStyle(Paint.Style.FILL);
        r104.setColor(f.b(r100, R.color.ud_N300));
        r104.setAntiAlias(true);
        this.C = r104;
        Paint r105 = new Paint();
        r105.setColor(f.b(r100, R.color.ud_N300));
        r105.setStrokeWidth(r103);
        this.D = r105;
        Paint r106 = new Paint();
        r106.setColor(f.b(r100, R.color.token_switch_handle_disabled));
        this.E = r106;
        Paint r107 = new Paint();
        r107.setStyle(Paint.Style.FILL);
        r107.setColor(f.b(r100, R.color.outer_rect_paint_color));
        r107.setAntiAlias(true);
        this.F = r107;
        Paint r108 = new Paint();
        r108.setColor(f.b(r100, R.color.inner_rect_paint_color));
        this.G = r108;
    }

    public static ForsetiWidth c(ForsetiWidth r100) {
        if (r100 != null) goto L5;
        int r101 = -1;
    L6:
        if (r101 == (-1)) goto L18;
        if (r101 == 4) goto L18;
        switch(r101) {
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L21;
            default: goto L10;
        };
    L10:
        d.f424619a.getClass();
        ForsetiWidth r102 = d.f424621c;
        if (r102 == null) goto L20;
        return r102;
    L20:
        return ForsetiWidth.AVERAGE_LEVEL;
    L21:
        return ForsetiWidth.FIXED_LEVEL2_IN_WIDE_SCREEN_RIGHT_SIDE;
    L22:
        return ForsetiWidth.FIXED_LEVEL2_IN_NARROW_SCREEN_RIGHT_SIDE;
    L23:
        return ForsetiWidth.FIXED_LEVEL1_IN_WIDE_SCREEN_RIGHT_SIDE;
    L24:
        return ForsetiWidth.FIXED_LEVEL1_IN_NARROW_SCREEN_RIGHT_SIDE;
    L18:
        return ForsetiWidth.AVERAGE_LEVEL;
    L5:
        r101 = c.f424611a[r100.ordinal()];
        goto L6
    }

    public final ForsetiWidth a(ForsetiWidth r100) {
        if (r100 != null) goto L5;
        int r101 = -1;
    L6:
        if (r101 == (-1)) goto L26;
        if (r101 == 2) goto L33;
        if (r101 == 3) goto L32;
        if (r101 == 4) goto L31;
        if (r101 == 5) goto L30;
        if (r101 == 6) goto L29;
        d.f424619a.getClass();
        ForsetiWidth r102 = d.f424620b;
        if (r102 == null) goto L28;
        return r102;
    L28:
        return d();
    L29:
        return ForsetiWidth.FIXED_LEVEL2_IN_WIDE_SCREEN_LEFT_SIDE;
    L30:
        return ForsetiWidth.FIXED_LEVEL2_IN_NARROW_SCREEN_LEFT_SIDE;
    L31:
        return ForsetiWidth.AVERAGE_LEVEL;
    L32:
        return ForsetiWidth.FIXED_LEVEL1_IN_WIDE_SCREEN_LEFT_SIDE;
    L33:
        return ForsetiWidth.FIXED_LEVEL1_IN_NARROW_SCREEN_LEFT_SIDE;
    L26:
        return d();
    L5:
        r101 = c.f424611a[r100.ordinal()];
        goto L6
    }

    public final ForsetiWidth b(float r100) {
        if (r100 > this.f424585e) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        int r102 = this.f424586f;
    L9:
        float r103 = r102;
        float r104 = r103 / 2.0f;
        float r105 = this.A;
        float r106 = r105 / 2.0f;
        float r107 = ((r106 - r103) / 2.0f) + r103;
        float r108 = (((r105 - r103) - r106) / 2.0f) + r106;
        if (r100 >= r104) goto L13;
        return ForsetiWidth.FULL;
    L13:
        if (r100 >= r107) goto L18;
        if (r101 == false) goto L26;
        return ForsetiWidth.FIXED_LEVEL1_IN_NARROW_SCREEN_RIGHT_SIDE;
    L26:
        return ForsetiWidth.FIXED_LEVEL1_IN_WIDE_SCREEN_RIGHT_SIDE;
    L18:
        if (r100 < r108) goto L27;
        if (r101 == false) goto L23;
        return ForsetiWidth.FIXED_LEVEL2_IN_NARROW_SCREEN_RIGHT_SIDE;
    L23:
        return ForsetiWidth.FIXED_LEVEL2_IN_WIDE_SCREEN_RIGHT_SIDE;
    L27:
        return ForsetiWidth.AVERAGE_LEVEL;
    L8:
        r102 = this.f424587g;
        goto L9
    L5:
        r101 = false;
        goto L6
    }

    public final float j(ForsetiWidth r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L6:
        switch(r101) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L17;
        };
    L8:
        float r102 = this.A;
        int r103 = this.f424587g;
    L18:
        return r102 - r103;
    L9:
        r102 = this.A;
        r103 = this.f424586f;
        goto L18
    L11:
        float r104 = this.A;
    L19:
        return r104 / 2.0f;
    L13:
        int r105 = this.f424587g;
    L20:
        return r105;
    L14:
        r105 = this.f424586f;
        goto L20
    L16:
        return 0.0f;
    L17:
        r104 = this.A;
        goto L19
    L4:
        r101 = c.f424611a[r100.ordinal()];
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void i(View r100, boolean r101) {
        if (r100 != null) goto L6;
        Log.w("ForsetiColumnsDraggingHelper", "renderView is null, cannot apply blur effect.");
        return;
    L6:
        int r102 = Build.VERSION.SDK_INT;
        RenderScript r103 = 0;
        RenderEffect r104 = null;
        Bitmap r105 = null;
        r105 = null;
        if (r102 < 31) goto L13;
        Log.d("ForsetiColumnsDraggingHelper", "Applying blur effect using RenderEffect.");
        if (r101 == false) goto L11;
        r104 = RenderEffect.createBlurEffect(50.0f, 50.0f, Shader.TileMode.CLAMP);
    L11:
        r100.setRenderEffect(r104);
        return;
    L13:
        if (r102 < 23) goto L57;
        Log.d("ForsetiColumnsDraggingHelper", "Applying blur effect using RenderScript for pre Android 12 devices.");
        int r106 = g.f23905a;
        Intrinsics.checkNotNullParameter(r100, "renderView");
        if (r101 == true) goto L52;
        Log.d("ViewBlurUtil", "Removing RenderScript blur effect.");
        r100.setForeground(null);
        return;
    L52:
        Bitmap r107 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Exception -> L19
        r100.draw(new Canvas(r107));     // Catch: Exception -> L19
    L21:
        if (r107 != null) goto L23;
        Log.w("ViewBlurUtil", "Failed to convert view to bitmap for RenderScript blur.");
        return;
    L23:
        Context r108 = r100.getContext();
        RenderScript r109 = RenderScript.create(r108);     // Catch: Throwable -> L37 Exception -> L39
        Allocation r110 = Allocation.createFromBitmap(r109, r107);     // Catch: Throwable -> L33 Exception -> L35
        Allocation r111 = Allocation.createTyped(r109, r110.getType());     // Catch: Throwable -> L33 Exception -> L35
        ScriptIntrinsicBlur r112 = ScriptIntrinsicBlur.create(r109, Element.U8_4(r109));     // Catch: Throwable -> L33 Exception -> L35
        r112.setRadius(25.0f);     // Catch: Throwable -> L33 Exception -> L35
        r112.setInput(r110);     // Catch: Throwable -> L33 Exception -> L35
        r112.forEach(r111);     // Catch: Throwable -> L33 Exception -> L35
        Bitmap.Config r113 = r107.getConfig();     // Catch: Throwable -> L33 Exception -> L35
        if (r113 == null) goto L28;
        Bitmap r114 = Bitmap.createBitmap(r107.getWidth(), r107.getHeight(), r113);     // Catch: Throwable -> L33 Exception -> L35
    L29:
        r111.copyTo(r114);     // Catch: Throwable -> L33 Exception -> L35
        if (r109 == null) goto L32;
        r109.destroy();
    L32:
        r105 = r114;
    L44:
        if (r105 == null) goto L46;
        r100.setForeground(new BitmapDrawable(r100.getResources(), r105));
        Log.d("ViewBlurUtil", "RenderScript blur effect applied successfully.");
        return;
    L46:
        Log.e("ViewBlurUtil", "Failed to apply RenderScript blur effect.");
        return;
    L28:
        r114 = null;
    L35:
        e = e;
    L41:
        Log.e("ViewBlurUtil", "Error during RenderScript blur: " + e.getMessage());     // Catch: Throwable -> L33
        if (r109 == null) goto L44;
        r109.destroy();
        goto L44
    L33:
        th = th;
        r103 = r108;
    L47:
        if (r103 == 0) goto L49;
        r103.destroy();
    L49:
        throw th;
    L39:
        e = e;
        r109 = null;
    L37:
        th = th;
    L19:
        e = move-exception;
        Log.e("ViewBlurUtil", "Error capturing bitmap from view: " + e.getMessage());
        r107 = null;
        goto L21
    }

    public final int g(int r100, ForsetiWidth r101) {
        if (r101 != null) goto L4;
        int r102 = -1;
    L5:
        switch(r102) {
            case 1: goto L13;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L14;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L10;
            case 10: goto L9;
            default: goto L14;
        };
    L9:
        int r103 = this.f424587g;
    L17:
        return r100 - r103;
    L10:
        r103 = this.f424586f;
        goto L17
    L14:
        return (int) (r100 * 0.5f);
    L15:
        return this.f424587g;
    L16:
        return this.f424586f;
    L13:
        return r100 * 1;
    L4:
        r102 = c.f424611a[r101.ordinal()];
        goto L5
    }
}
