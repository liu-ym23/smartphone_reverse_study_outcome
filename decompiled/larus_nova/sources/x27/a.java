package x27;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import androidx.core.location.LocationManagerCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.Npth;
import com.bytedance.navigation.kmp.capability.location_status.LocationSwitchMonitor$start$1;
import com.bytedance.navigation.kmp.listener.d;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import d37.i;
import defpackage.m;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LocationSwitchMonitor$start$1 f562252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f562253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f562254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f562255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f562256e;

    public final boolean d() {
        boolean r100 = false;
        Context r101 = this.f562255d;     // Catch: Throwable -> L27
        ContentResolver r102 = null;
        if (r101 == null) goto L6;
        Object r103 = r101.getSystemService("location");     // Catch: Throwable -> L27
    L8:
        if ((r103 instanceof LocationManager) == false) goto L10;
        LocationManager r104 = (LocationManager) r103;     // Catch: Throwable -> L27
    L11:
        if (r104 != null) goto L15;
        i r105 = i.f466749a;     // Catch: Throwable -> L27
        i.c("[LocationSwitchMonitor] LocationManager is null, treat as disabled.");     // Catch: Throwable -> L27
        return false;
    L15:
        if (Build.VERSION.SDK_INT >= 28) goto L34;
        r100 = LocationManagerCompat.isLocationEnabled(r104);     // Catch: Throwable -> L20
    L35:
        return r100;
    L20:
        Context r106 = this.f562255d;     // Catch: Throwable -> L27
        if (r106 == null) goto L24;
        r102 = r106.getContentResolver();     // Catch: Throwable -> L27
    L24:
        if (Settings.Secure.getInt(r102, LocationMonitorConst.LOCATION_MODE, 0) == 0) goto L33;
        return true;
    L33:
        return false;
    L34:
        return r104.isLocationEnabled();
    L10:
        r104 = null;
        goto L11
    L6:
        r103 = null;
    L27:
        th = move-exception;
        i r107 = i.f466749a;
        i.e("[LocationSwitchMonitor] queryEnabled error", th);
        return r100;
    }

    public final void e() {
        if (this.f562253b == true) goto L28;
        return;
    L28:
        LocationSwitchMonitor$start$1 r100 = this.f562252a;     // Catch: Throwable -> L20
        if (r100 == null) goto L27;
        Context r101 = this.f562255d;     // Catch: Throwable -> L20
        if (r101 == null) goto L27;
        ReceiverRegisterLancet.loge(r100, false);     // Catch: Throwable -> L20
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L32;
        r101.unregisterReceiver(r100);     // Catch: Throwable -> L20
        goto L27
    L32:
    L16:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r100.toString());     // Catch: Throwable -> L20
        e.printStackTrace();     // Catch: Throwable -> L20
        goto L27
    L13:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r100, r101) == false) goto L27;
        r101.unregisterReceiver(r100);     // Catch: Exception -> L16 Throwable -> L20
    L27:
    L22:
        this.f562252a = null;
        this.f562253b = false;
        this.f562254c = null;
        this.f562256e = null;
        return;
    L20:
        th = move-exception;
        i r102 = i.f466749a;     // Catch: Throwable -> L24
        i.e("[LocationSwitchMonitor] unregisterReceiver failed", th);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        this.f562252a = null;
        this.f562253b = false;
        this.f562254c = null;
        this.f562256e = null;
        throw th;
    }

    public a() {
        this.f562255d = m.f511444a.getContext();
    }

    public final void c(boolean r100) {
        Boolean r101 = this.f562254c;
        if (r101 != null) goto L5;
    L7:
        this.f562254c = Boolean.valueOf(r100);
        d r102 = this.f562256e;
        if (r102 != null) goto L15;
    L13:
        i r103 = i.f466749a;
        i.g("[LocationSwitchMonitor] locationEnabled=" + r100);
        return;
    L15:
        r102.a(r100);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        i r104 = i.f466749a;
        i.e("[LocationSwitchMonitor] listener.onLocationSwitchChanged error", th);
        goto L13
    L5:
        if (Intrinsics.areEqual(r101, Boolean.valueOf(r100)) == false) goto L7;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r100, LocationSwitchMonitor$start$1 r110, IntentFilter r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L29;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L29:
    L23:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L28;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r111, null, null, 2);
        return;
    L28:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L9;
    L21:
        r100.registerReceiver(r110, r111, null, null, 2);     // Catch: Exception -> L23
        return;
    L9:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L21;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r111, 2, null, null, 5, r100).result;     // Catch: Exception -> L23
        if (r101 == 1) goto L19;
        if (r101 != 2) goto L14;
        new Intent();     // Catch: Exception -> L23
        return;
    L14:
        if (r101 == 3) goto L30;
        r100.registerReceiver(r110, r111, null, null, 2);     // Catch: Exception -> L23
        return;
    L30:
        return;
    L19:
        r100.registerReceiver(r110, r111, null, null, 2);     // Catch: Exception -> L23
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Context r100, LocationSwitchMonitor$start$1 r110, IntentFilter r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L30;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L30:
    L24:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L29;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r111, null, null);
        return;
    L29:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L9;
    L22:
        r100.registerReceiver(r110, r111, null, null);     // Catch: Exception -> L24
        return;
    L9:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L22;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r111, 0, null, null, 4, r100).result;     // Catch: Exception -> L24
        if (r101 != 1) goto L13;
        r100.registerReceiver(r110, r111, null, null);     // Catch: Exception -> L24
        return;
    L13:
        if (r101 != 2) goto L15;
        new Intent();     // Catch: Exception -> L24
        return;
    L15:
        if (r101 == 3) goto L31;
        r100.registerReceiver(r110, r111, null, null);     // Catch: Exception -> L24
        return;
    }
}
