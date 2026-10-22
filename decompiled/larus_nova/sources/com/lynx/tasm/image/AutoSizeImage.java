package com.lynx.tasm.image;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.group.d;
import y6a.h;
import y6a.i;

/* JADX INFO: loaded from: classes32.dex */
public class AutoSizeImage extends ShadowNode implements h {
    public Handler A;
    public a B;
    public String C;
    public final Object D;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f383452v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f383453w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f383454x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f383455y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f383456z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f383457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f383458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f383459c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f383460d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f383461e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ AutoSizeImage f383462f;

        @Override // java.lang.Runnable
        public final void run() {
            AutoSizeImage.C(this.f383462f, this.f383457a, this.f383458b, this.f383459c, this.f383460d, this.f383461e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(AutoSizeImage r100, boolean r101, int r102, int r103, int r104, int r105) {
            this.f383462f = r100;
            this.f383457a = r101;
            this.f383458b = r102;
            this.f383459c = r103;
            this.f383460d = r104;
            this.f383461e = r105;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f383463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f383464b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f383465c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f383466d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f383467e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ AutoSizeImage f383468f;

        @Override // java.lang.Runnable
        public final void run() {
            AutoSizeImage.C(this.f383468f, this.f383463a, this.f383464b, this.f383465c, this.f383466d, this.f383467e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(AutoSizeImage r100, boolean r101, int r102, int r103, int r104, int r105) {
            this.f383468f = r100;
            this.f383463a = r101;
            this.f383464b = r102;
            this.f383465c = r103;
            this.f383466d = r104;
            this.f383467e = r105;
        }
    }

    public AutoSizeImage() {
        this.f383452v = false;
        this.f383453w = false;
        this.f383456z = true;
        this.D = new Object();
        i(this);
    }

    @LynxProp(name = "src")
    public void setSrc(String r100) {
        this.C = r100;
    }

    public final void D(boolean r110, int r111, int r112, int r113, int r114) {
        Object r100 = this.D;
        monitor-enter(r100);
        Handler r101 = this.A;     // Catch: Throwable -> L10
        if (r101 != null) goto L7;
        this.B = new a(this, r110, r111, r112, r113, r114);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L7:
        r101.post(new b(this, r110, r111, r112, r113, r114));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // y6a.h
    public final long c(LayoutNode r100, float r101, MeasureMode r110, float r111, MeasureMode r112) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        String r102 = "AutoSizeImage Measure: " + r101 + ":" + r110.intValue() + " - " + r111 + ":" + r112.intValue() + " " + this.C;
        TraceEvent.beginSection(r102);
    L6:
        Object r103 = this.D;
        monitor-enter(r103);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.A != null) goto L15;
        Handler r104 = new Handler(Looper.myLooper());     // Catch: Throwable -> L13
        this.A = r104;     // Catch: Throwable -> L13
        a r105 = this.B;     // Catch: Throwable -> L13
        if (r105 == null) goto L15;
        r104.post(r105);     // Catch: Throwable -> L13
        this.B = null;     // Catch: Throwable -> L13
    L15:
        monitor-exit(r103);     // Catch: Throwable -> L13
        MeasureMode r106 = MeasureMode.EXACTLY;
        boolean r107 = false;
        if (r110 != r106) goto L20;
        if (r112 != r106) goto L20;
        boolean r108 = true;
    L21:
        this.f383456z = r108;
        if (r108 == true) goto L24;
        LynxContext r109 = this.f382220m;
        if (r109 == null) goto L33;
        d r113 = r109.getRuntimeCacheManager();
        if (r113 == null) goto L33;
        r113.d();
    L33:
        int r114 = this.f383454x;
        int r115 = this.f383455y;
        if (r101 != 0.0f) goto L38;
        if (r110 == MeasureMode.UNDEFINED) goto L38;
    L41:
        r107 = true;
    L42:
        this.f383456z = r107;
        if (this.f383452v == false) goto L82;
        if (r114 <= 0) goto L82;
        if (r115 <= 0) goto L82;
        if (r107 == true) goto L82;
        if (r110 != r106) goto L57;
        float r116 = (r115 / r114) * r101;
        if (r112 != MeasureMode.AT_MOST) goto L55;
        if (r111 <= r116) goto L77;
    L56:
        r111 = r116;
    L77:
        if (TraceEvent.isTracingStarted() == false) goto L80;
        TraceEvent.endSection(r102);
    L80:
        return i.a(r101, r111);
    L55:
        if (r112 != MeasureMode.UNDEFINED) goto L77;
    L57:
        MeasureMode r117 = MeasureMode.UNDEFINED;
        if (r110 != r117) goto L60;
        r101 = 65535;
    L60:
        if (r112 != r117) goto L62;
        r111 = 65535;
    L62:
        float r118 = r114;
        if (r112 != r106) goto L68;
        float r119 = (r118 / r115) * r111;
        if (r101 <= r119) goto L77;
        r101 = r119;
        goto L77
    L68:
        if (r118 > r101) goto L72;
        float r120 = r115;
        if (r120 > r111) goto L72;
        r101 = r118;
        r111 = r120;
    L72:
        float r121 = r115 / r118;
        if ((r111 / r101) >= r121) goto L75;
        r101 = r111 / r121;
        goto L77
    L75:
        r111 = r121 * r101;
    L82:
        if (TraceEvent.isTracingStarted() == false) goto L84;
        TraceEvent.endSection(r102);
    L84:
        if (r110 == r106) goto L87;
        r101 = 0.0f;
    L87:
        if (r112 == r106) goto L91;
        r111 = 0.0f;
    L91:
        return i.a(r101, r111);
    L38:
        if (r111 != 0.0f) goto L42;
        if (r112 == MeasureMode.UNDEFINED) goto L42;
    L24:
        if (TraceEvent.isTracingStarted() == false) goto L26;
        TraceEvent.endSection(r102);
    L26:
        this.f383453w = true;
        return i.a(r101, r111);
    L20:
        r108 = false;
        goto L21
    L5:
        r102 = null;
        goto L6
    }

    public static void C(AutoSizeImage r100, boolean r101, int r102, int r103, int r104, int r105) {
        boolean r106 = r100.f383452v;
        r100.f383452v = r101;
        r100.f383454x = r102;
        r100.f383455y = r103;
        if (r102 != 0) goto L6;
        if (r103 != 0) goto L6;
        return;
    L6:
        LynxContext r107 = r100.f382220m;
        if (r107 != null) goto L9;
    L13:
        if (r106 == r101) goto L16;
        r100.q();
        return;
    L16:
        if (r100.f383456z == true) goto L34;
        if (r101 == false) goto L28;
        if (r102 <= 0) goto L29;
        if (r103 <= 0) goto L30;
        if (r104 == 0) goto L25;
        if (r105 == 0) goto L25;
        if (Math.abs((r104 / r105) - (r102 / r103)) > 0.05d) goto L25;
        return;
    L25:
        r100.q();
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L34:
        return;
    L9:
        if (r107.isEmbeddedModeOn() == false) goto L13;
        if (r100.f383453w == false) goto L13;
    }
}
