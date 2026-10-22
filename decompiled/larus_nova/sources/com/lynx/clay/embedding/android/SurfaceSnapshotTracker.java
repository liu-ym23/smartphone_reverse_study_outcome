package com.lynx.clay.embedding.android;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.PixelCopy;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class SurfaceSnapshotTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterSurfaceView f380606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f380607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Runnable> f380608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f380609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f380610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f380611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f380612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f380613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f380614i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f380615j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f380616k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public double f380617l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f380618m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FlutterSurfaceView.c f380619n;

    public static final enum FlutterUiDisplayResult extends Enum<FlutterUiDisplayResult> {
        public static final FlutterUiDisplayResult DISPLAYED = null;
        public static final FlutterUiDisplayResult REJECTED = null;
        public static final FlutterUiDisplayResult WAITING_FOR_SURFACE_CONNECTION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FlutterUiDisplayResult[] f380620a = null;

        static {
            FlutterUiDisplayResult r100 = new FlutterUiDisplayResult("DISPLAYED", 0);
            DISPLAYED = r100;
            FlutterUiDisplayResult r101 = new FlutterUiDisplayResult("WAITING_FOR_SURFACE_CONNECTION", 1);
            WAITING_FOR_SURFACE_CONNECTION = r101;
            FlutterUiDisplayResult r102 = new FlutterUiDisplayResult("REJECTED", 2);
            REJECTED = r102;
            f380620a = new FlutterUiDisplayResult[]{r100, r101, r102};
        }

        public static FlutterUiDisplayResult[] values() {
            return (FlutterUiDisplayResult[]) f380620a.clone();
        }

        public static FlutterUiDisplayResult valueOf(String r100) {
            return (FlutterUiDisplayResult) r27.a.a(FlutterUiDisplayResult.class, r100);
        }

        public FlutterUiDisplayResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        private a() {
        }

        public static void a(SurfaceView r100, boolean r101) {
            r100.setSecure(r101);
        }
    }

    public static final class b {
        private b() {
        }

        public static /* synthetic */ void a(c r100, SurfaceSnapshotTracker r101, int r102) {
            b(r100, r101, r102);
        }

        public static void c(final SurfaceSnapshotTracker r100, final c r101) {
            if (r100.e(r101) == true) goto L5;
            return;
        L5:
            SurfaceHolder r102 = r100.f380606a.getHolder();
            if (r102 != null) goto L8;
        L25:
            SurfaceSnapshotTracker.a(r100, r101, 4, Double.NaN);
            return;
        L8:
            if (r102.getSurface() == null) goto L25;
            if (r102.getSurface().isValid() == false) goto L25;
            r101.f380623c++;
            Bitmap r103 = r101.f380626f;     // Catch: Throwable -> L20 IllegalArgumentException -> L22
            if (r103 != null) goto L16;
        L17:
            r101.f380626f = Bitmap.createBitmap(8, 8, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L20 IllegalArgumentException -> L22
        L18:
            Bitmap r104 = r101.f380626f;     // Catch: Throwable -> L20 IllegalArgumentException -> L22
            r101.f380624d = true;     // Catch: Throwable -> L20 IllegalArgumentException -> L22
            PixelCopy.request(r100.f380606a, r104, new v(r101, r100), r100.f380607b);     // Catch: Throwable -> L20 IllegalArgumentException -> L22
            return;
        L16:
            if (r103.isRecycled() == false) goto L18;
        L20:
            e = move-exception;
            r101.f380624d = false;
            r101.a();
            c5a.c.f("FlutterSurfaceSnapshot", "Failed to request Surface frame PixelCopy.", e);
            SurfaceSnapshotTracker.a(r100, r101, 4, Double.NaN);
        }

        private static void b(c r110, SurfaceSnapshotTracker r111, int r112) {
            boolean r100 = false;
            r110.f380624d = false;
            r110.a();
            if (r111.e(r110) == true) goto L6;
            r110.f380625e = true;
            r110.a();
            return;
        L6:
            if (r112 != 0) goto L25;
            Bitmap r101 = r110.f380626f;
            if (r101 == null) goto L25;
            if (r101.isRecycled() == true) goto L25;
        L23:
            e = move-exception;
            c5a.c.f("FlutterSurfaceSnapshot", "Failed to sample Surface frame luminance.", e);
            goto L25
        L13:
            if (r110.f380627g != null) goto L15;
            r110.f380627g = new int[64];     // Catch: RuntimeException -> L23
        L15:
            int[] r102 = r110.f380627g;     // Catch: RuntimeException -> L23
            r101.getPixels(r102, 0, r101.getWidth(), 0, 0, r101.getWidth(), r101.getHeight());     // Catch: RuntimeException -> L23
            int r103 = r102.length;     // Catch: RuntimeException -> L23
            long r104 = 0;
            int r105 = 0;
        L16:
            if (r105 >= r103) goto L19;
            int r113 = r102[r105];     // Catch: RuntimeException -> L23
            r104 = r104 + ((((((long) Color.red(r113)) * 299) + (((long) Color.green(r113)) * 587)) + (((long) Color.blue(r113)) * 114)) / 1000);     // Catch: RuntimeException -> L23
            r105 = r105 + 1;     // Catch: RuntimeException -> L23
            goto L16
        L19:
            if (r102.length == 0) goto L25;
            double r106 = r104 / ((double) r102.length);
        L27:
            if (Double.isNaN(r111.f380617l) == false) goto L29;
        L31:
            boolean r107 = false;
        L33:
            if (Double.isNaN(r106) == false) goto L35;
        L37:
            if (r112 == 0) goto L39;
        L43:
            SurfaceSnapshotTracker.a(r111, r110, r112, r106);
            return;
        L39:
            if (Double.isNaN(r106) == true) goto L43;
            if (r107 == false) goto L42;
            if (r100 == true) goto L43;
        L42:
            r111.f(r110);
            return;
        L35:
            if (r106 > 8.0d) goto L37;
            r100 = true;
            goto L37
        L29:
            if (r111.f380617l < 32.0d) goto L31;
            r107 = true;
        L25:
            r106 = Double.NaN;
            goto L27
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f380621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f380622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f380623c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f380624d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f380625e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Bitmap f380626f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int[] f380627g;

        public final void a() {
            if (this.f380625e == true) goto L5;
            return;
        L5:
            if (this.f380624d == true) goto L15;
            Bitmap r100 = this.f380626f;
            if (r100 != null) goto L10;
        L12:
            this.f380626f = null;
            this.f380627g = null;
            return;
        L10:
            if (r100.isRecycled() == true) goto L12;
            this.f380626f.recycle();
            goto L12
        }

        public c(int r100) {
            this.f380622b = SystemClock.uptimeMillis();
            this.f380623c = 0;
            this.f380624d = false;
            this.f380625e = false;
            this.f380621a = r100;
        }
    }

    public final void c() {
        if (this.f380608c.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r100 = new ArrayList(this.f380608c);
        this.f380608c.clear();
        Iterator r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((Runnable) r101.next()).run();
        goto L7
    }

    public final void i() {
        c r100 = this.f380618m;
        this.f380618m = null;
        this.f380616k = -1;
        if (r100 == null) goto L6;
        r100.f380625e = true;
        r100.a();
        return;
    }

    public final void j() {
        if (this.f380610e == true) goto L5;
        return;
    L5:
        this.f380606a.setZOrderOnTop(false);
        this.f380610e = false;
    }

    public SurfaceSnapshotTracker(FlutterSurfaceView r100) {
        this.f380607b = new Handler(Looper.getMainLooper());
        this.f380608c = new ArrayList();
        this.f380609d = false;
        this.f380610e = false;
        this.f380611f = 0;
        this.f380612g = -1;
        this.f380613h = -1;
        this.f380614i = -1;
        this.f380615j = -1;
        this.f380616k = -1;
        this.f380617l = Double.NaN;
        this.f380606a = r100;
        int r101 = Build.VERSION.SDK_INT;
        a.a(r100, false);
        if (r101 < 34) goto L14;
        SurfaceView.class.getMethod("setSurfaceLifecycle", new Class[]{Integer.TYPE}).invoke(r100, new Object[]{2});     // Catch: Throwable -> L7 ReflectiveOperationException -> L9
        return;
    L7:
        e = move-exception;
        c5a.c.d(5, "FlutterSurfaceSnapshot", "Failed to use attachment-bound SurfaceView lifecycle: " + e.getMessage());
        return;
    }

    public static double b(Bitmap r210) {
        if (r210.isRecycled() == false) goto L5;
    L30:
        return Double.NaN;
    L5:
        if (r210.getWidth() <= 0) goto L30;
        if (r210.getHeight() <= 0) goto L30;
        int r100 = Math.min(5, r210.getWidth());     // Catch: RuntimeException -> L28
        int r101 = Math.min(5, r210.getHeight());     // Catch: RuntimeException -> L28
        long r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L10:
        if (r103 >= r101) goto L24;
        int r105 = 1;
        if (r101 != 1) goto L14;
        int r110 = 0;
    L15:
        int r111 = 0;
    L16:
        if (r111 >= r100) goto L23;
        if (r100 != r105) goto L20;
        int r112 = 0;
    L21:
        int r113 = r210.getPixel(r112, r110);     // Catch: RuntimeException -> L28
        int r114 = r110;
        r102 = r102 + ((((((long) Color.red(r113)) * 299) + (((long) Color.green(r113)) * 587)) + (((long) Color.blue(r113)) * 114)) / 1000);
        r104 = r104 + 1;
        r111 = r111 + 1;
        r110 = r114;
        r105 = 1;
        goto L16
    L20:
        r112 = ((r210.getWidth() - r105) * r111) / (r100 - 1);     // Catch: RuntimeException -> L28
        goto L21
    L23:
        r103 = r103 + 1;
        goto L10
    L14:
        r110 = ((r210.getHeight() - 1) * r103) / (r101 - 1);     // Catch: RuntimeException -> L28
        goto L15
    L24:
        if (r104 != 0) goto L27;
        return Double.NaN;
    L27:
        return r102 / ((double) r104);
    L28:
        e = move-exception;
        c5a.c.f("FlutterSurfaceSnapshot", "Failed to sample bitmap luminance.", e);
        goto L30
    }

    public final void d(int r100) {
        if (this.f380615j == r100) goto L5;
        return;
    L5:
        this.f380615j = -1;
        FlutterSurfaceView.c r101 = this.f380619n;
        if (r101 == null) goto L15;
        SurfaceSnapshotController r102 = (SurfaceSnapshotController) r101;
        if (r100 != r102.f380600j) goto L15;
        if (r102.j() == false) goto L15;
        if (r102.f(1) == false) goto L15;
        r102.f380599i |= 2;
        r102.k();
        r102.l();
    L15:
        h(r100);
        c();
    }

    public final boolean e(c r100) {
        if (this.f380618m == r100) goto L5;
    L11:
        return false;
    L5:
        if (r100.f380621a != this.f380611f) goto L11;
        if (this.f380606a.f380500c == false) goto L11;
        if (this.f380609d == false) goto L11;
        return true;
    }

    public final void f(c r100) {
        if (e(r100) == true) goto L5;
        return;
    L5:
        this.f380618m = null;
        this.f380616k = r100.f380621a;
        r100.f380625e = true;
        r100.a();
        FlutterSurfaceView.c r101 = this.f380619n;
        if (r101 == null) goto L14;
        SurfaceSnapshotController r102 = (SurfaceSnapshotController) r101;
        if (r100.f380621a == r102.f380600j) goto L10;
        return;
    L10:
        if (r102.j() == false) goto L16;
        r102.f380599i |= 4;
        r102.k();
        r102.l();
        return;
    L16:
        return;
    }

    public final void g(final Runnable r100) {
        if (this.f380606a.f380500c == false) goto L14;
        final int r101 = this.f380611f;
        if (r101 <= 0) goto L14;
        this.f380615j = r101;
        if (r100 == null) goto L11;
        this.f380608c.add(r100);
        this.f380606a.postDelayed(new u(this, r100, r101), 1000);
    L11:
        if (this.f380614i != r101) goto L17;
        d(r101);
        return;
    L17:
        return;
    L14:
        if (r100 == null) goto L18;
        r100.run();
        return;
    }

    public final void h(int r100) {
        if (this.f380609d == true) goto L5;
        return;
    L5:
        if (this.f380619n != null) goto L7;
        return;
    L7:
        if (r100 == this.f380611f) goto L9;
        return;
    L9:
        if (this.f380606a.f380500c == true) goto L11;
        return;
    L11:
        if (this.f380616k != r100) goto L13;
        return;
    L13:
        if (this.f380618m != null) goto L38;
        c r101 = new c(r100);
        this.f380618m = r101;
        int r102 = Build.VERSION.SDK_INT;
        if (r102 >= 24) goto L18;
    L30:
        f(r101);
        return;
    L18:
        if (com.lynx.clay.util.d.a(this.f380606a) == false) goto L30;
        if (Double.isNaN(this.f380617l) == false) goto L23;
    L26:
        if (r102 >= 24) goto L28;
        f(r101);
        return;
    L28:
        b.c(this, r101);
        return;
    L23:
        if (this.f380617l >= 32.0d) goto L26;
        f(r101);
        return;
    }

    public static void a(final SurfaceSnapshotTracker r100, final c r101, int r102, double r103) {
        if (r100.e(r101) == false) goto L21;
        long r104 = SystemClock.uptimeMillis() - r101.f380622b;
        int r105 = r101.f380623c;
        if (r105 < 12) goto L8;
    L18:
        c5a.c.d(5, "FlutterSurfaceSnapshot", "Surface frame remains unverified; reveal it after verification limit, generation=" + r101.f380621a + ", result=" + r102 + ", surfaceLuminance=" + r103 + ", snapshotLuminance=" + r100.f380617l + ", pixelCopyAttempts=" + r101.f380623c);
        r100.f(r101);
        return;
    L8:
        if (r104 >= 3000) goto L18;
        Handler r106 = r100.f380607b;
        Runnable r107 = new t(r100, r101);
        if (r105 > 3) goto L14;
        long r108 = 32;
    L17:
        r106.postDelayed(r107, r108);
        return;
    L14:
        if (r105 > 6) goto L16;
        r108 = 64;
        goto L17
    L16:
        r108 = 128;
        goto L17
    }
}
