package com.flow.performance.thermal;

import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.larus.common.apphost.AppHost;
import com.larus.network.util.ScreenStateManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes23.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f274208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f274209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f274210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f274211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f274212e;

    public static final class a {
    }

    public static final class b implements ScreenStateManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f274213a;

        @Override // com.larus.network.util.ScreenStateManager.b
        public final void onScreenOff() {
            g.a(this.f274213a, "off");
        }

        @Override // com.larus.network.util.ScreenStateManager.b
        public final void onScreenOn() {
            g.a(this.f274213a, "on");
        }

        @Override // com.larus.network.util.ScreenStateManager.b
        public final void onUserPresent() {
            g.a(this.f274213a, "on");
        }

        public b(g r100) {
            this.f274213a = r100;
        }
    }

    static {
    }

    public final synchronized void b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f274211d == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f274211d = true;     // Catch: Throwable -> L11
        c(System.currentTimeMillis());     // Catch: Throwable -> L11
        ScreenStateManager r100 = ScreenStateManager.f360254a;     // Catch: Throwable -> L11
        ScreenStateManager.a(this.f274212e);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public g() {
        this.f274212e = new b(this);
    }

    public final synchronized void c(long r100) {
        monitor-enter(this);
        this.f274208a = r100;     // Catch: Throwable -> L23
        this.f274209b = 0;     // Catch: Throwable -> L23
        if (this.f274210c != null) goto L21;
        fu7.h r101 = fu7.h.f478911a;     // Catch: Throwable -> L23
        String r102 = fu7.h.f478912b.c();     // Catch: Throwable -> L23
        if (r102 != null) goto L20;
        Object r103 = AppHost.f326268a.getApplication().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Throwable -> L23
        if ((r103 instanceof PowerManager) == false) goto L11;
        PowerManager r104 = (PowerManager) r103;     // Catch: Throwable -> L23
    L12:
        if (r104 == null) goto L16;
        boolean r105 = true;
        if (r104.isInteractive() != true) goto L16;
    L17:
        if (r105 == false) goto L19;
        r102 = "on";
        goto L20
    L19:
        r102 = "off";
    L16:
        r105 = false;
        goto L17
    L11:
        r104 = null;
    L20:
        this.f274210c = r102;     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public static final void a(g r100, String r101) {
        monitor-enter(r100);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (Intrinsics.areEqual(r100.f274210c, r101) == false) goto L7;
        monitor-exit(r100);
        return;
    L7:
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L13
        if (Intrinsics.areEqual(r100.f274210c, "on") == false) goto L10;
        r100.f274209b += RangesKt.coerceAtLeast(r102 - r100.f274208a, 0);     // Catch: Throwable -> L13
    L10:
        r100.f274210c = r101;     // Catch: Throwable -> L13
        r100.f274208a = r102;     // Catch: Throwable -> L13
        monitor-exit(r100);
    }
}
