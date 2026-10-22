package com.larus.navigation.impl.location;

import androidx.camera.video.AudioStats;
import com.android.ttcjpaysdk.base.weboffline.CJPayWebOfflineWorker;
import com.larus.api.CoordinateType;
import com.larus.api.LocationService;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import com.larus.settings.value.e10;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.z2;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f359880a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f359881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f359882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Job f359883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f359884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f359885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f359886g = null;

    public interface a {
        void a(com.larus.navigation.api.a r100);

        void onFailed(String r100);
    }

    public static final class b implements z2 {
        public b() {
        }

        @Override // hq9.z2
        public final void a(LocationResult r110, GeoLocationInfo r111) {
            Intrinsics.checkNotNullParameter(r110, "code");
            Intrinsics.checkNotNullParameter(r111, "location");
            e r112 = e.f359880a;
            monitor-enter(r112);
        L18:
            th = move-exception;
            throw th;
        L5:
            if (e.f359881b == true) goto L8;
            monitor-exit(r112);
            return;
        L8:
            int r100 = e.f359885f;     // Catch: Throwable -> L18
            int r101 = e.f359884e + 1;     // Catch: Throwable -> L18
            e.f359884e = r101;     // Catch: Throwable -> L18
            if (r101 > 3) goto L15;
            long r102 = System.currentTimeMillis() - r111.getGpsTime();     // Catch: Throwable -> L18
            if (r102 < 30000) goto L15;
            int r113 = com.larus.navigation.api.c.f359656a;     // Catch: Throwable -> L18
            com.larus.navigation.api.c.d("location_resolver", "rejecting stale location #" + e.f359884e + ", age=" + r102 + "ms");     // Catch: Throwable -> L18
            monitor-exit(r112);
            return;
        L15:
            int r103 = com.larus.navigation.api.c.f359656a;     // Catch: Throwable -> L18
            com.larus.navigation.api.c.d("location_resolver", "resolved at update #" + e.f359884e);     // Catch: Throwable -> L18
            e.a(new com.larus.navigation.api.a(r111.getLatitude(), r111.getLongitude(), AudioStats.AUDIO_AMPLITUDE_NONE, 12), null, r100);     // Catch: Throwable -> L18
            Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L18
            monitor-exit(r112);
        }

        @Override // hq9.z2
        public final void onError(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "code");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = com.larus.navigation.api.c.f359656a;
            com.larus.navigation.api.c.b("location_resolver", "location error: code=" + r100 + ", msg=" + r101);
        }
    }

    public e() {
    }

    static {
        f359880a = new e();
        f359886g = new b();
    }

    public final synchronized void c(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "reason");     // Catch: Throwable -> L18
        if (f359881b == true) goto L9;
        monitor-exit(this);
        return;
    L9:
        f359881b = false;     // Catch: Throwable -> L18
        Job r101 = f359883d;     // Catch: Throwable -> L18
        if (r101 == null) goto L12;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);     // Catch: Throwable -> L18
    L12:
        f359883d = null;     // Catch: Throwable -> L18
        f359882c = null;     // Catch: Throwable -> L18
        LocationService r102 = (LocationService) ServiceManager.get().getService(LocationService.class);     // Catch: Throwable -> L18
        if (r102 == null) goto L15;
        r102.f("resolver_".concat(r100));     // Catch: Throwable -> L18
    L15:
        int r103 = com.larus.navigation.api.c.f359656a;     // Catch: Throwable -> L18
        com.larus.navigation.api.c.d("location_resolver", "stopped: ".concat(r100));     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public static final void a(com.larus.navigation.api.a r100, String r101, int r102) {
        e r103 = f359880a;
        monitor-enter(r103);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (f359881b == true) goto L7;
    L19:
        monitor-exit(r103);
        return;
    L7:
        if (r102 != f359885f) goto L19;
        a r104 = f359882c;     // Catch: Throwable -> L21
        r103.c(CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED);     // Catch: Throwable -> L21
        if (r100 == null) goto L13;
        if (r104 == null) goto L17;
        r104.a(r100);     // Catch: Throwable -> L21
    L17:
        monitor-exit(r103);
        return;
    L13:
        if (r104 == null) goto L17;
        if (r101 != null) goto L16;
        r101 = "unknown";
    L16:
        r104.onFailed(r101);     // Catch: Throwable -> L21
        goto L17
    }

    public static void b(JSONObject r110, a r111, int r112) {
        e r100 = f359880a;
        if ((r112 & 1) == 0) goto L5;
        JSONObject r101 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        long r102 = 10000;
    L10:
        long r103 = r102;
        monitor-enter(r100);
        Intrinsics.checkNotNullParameter(r111, "callback");     // Catch: Throwable -> L23
        if (f359881b == false) goto L15;
        r100.c("new_resolve");     // Catch: Throwable -> L23
    L15:
        LocationService r104 = (LocationService) ServiceManager.get().getService(LocationService.class);     // Catch: Throwable -> L23
        if (r104 != null) goto L20;
        com.larus.navigation.api.c.b("location_resolver", "LocationService not available");     // Catch: Throwable -> L23
        r111.onFailed("no_location_service");     // Catch: Throwable -> L23
        monitor-exit(r100);
        return;
    L20:
        int r113 = f359885f + 1;     // Catch: Throwable -> L23
        f359885f = r113;     // Catch: Throwable -> L23
        f359882c = r111;     // Catch: Throwable -> L23
        f359881b = true;     // Catch: Throwable -> L23
        f359884e = 0;     // Catch: Throwable -> L23
        e10 r114 = e10.f368561a;     // Catch: Throwable -> L23
        long r105 = e10.B().b();     // Catch: Throwable -> L23
        int r115 = com.larus.navigation.api.c.f359656a;     // Catch: Throwable -> L23
        com.larus.navigation.api.c.d("location_resolver", "starting resolve, interval=" + r105 + "ms, timeout=" + r103 + "ms");     // Catch: Throwable -> L23
        r104.r(r105, CoordinateType.GCJ_O2, r101, f359886g);     // Catch: Throwable -> L23
        f359883d = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new NavigationLocationResolver$resolve$1(r103, r113, null), 3, null);     // Catch: Throwable -> L23
        monitor-exit(r100);
        return;
    L23:
        th = move-exception;
        throw th;
    L9:
        r102 = 0;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
