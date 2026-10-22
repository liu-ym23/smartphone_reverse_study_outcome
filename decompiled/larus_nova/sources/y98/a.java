package y98;

import com.larus.api.CoordinateType;
import com.larus.api.LocationService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.IDoraService;
import com.larus.platform.model.LocateScene;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import h49.k;
import h49.m;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import t39.n;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f566988a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f566989b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C8317a f566990c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f566991d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f566992e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f566993f = null;

    /* JADX INFO: renamed from: y98.a$a, reason: collision with other inner class name */
    public static final class C8317a implements f09.a.b {
        public C8317a() {
        }

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            AtomicBoolean r100 = a.f566988a;
            if (a.c() == true) goto L7;
            FLogger.f375446a.i("DoraGLocationClient", "onAppBackground, DoraG is disabled");
            return;
        L7:
            if (a.a() == true) goto L10;
            FLogger.f375446a.i("DoraGLocationClient", "onAppBackground, canEnableLocationPoll is false stop poll");
            LocationService.f286873a.t("enter_bg");
            return;
        L10:
            FLogger.f375446a.i("DoraGLocationClient", "onAppBackground, canEnableLocationPoll is true");
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            AtomicBoolean r100 = a.f566988a;
            if (a.c() == true) goto L7;
            FLogger.f375446a.i("DoraGLocationClient", "onAppForeground, DoraG is disabled");
            return;
        L7:
            if (a.a() == false) goto L9;
            FLogger.f375446a.i("DoraGLocationClient", "onAppForeground, canEnableLocationPoll is true");
            LocationService.f286873a.k(LocateScene.DORA_G_CONNECT, CoordinateType.WGS_84);
            return;
        L9:
            FLogger.f375446a.i("DoraGLocationClient", "onAppForeground, canEnableLocationPoll is false start hot launch");
            LocationService.a.a(LocationService.f286873a, LocateScene.HOT_LAUNCH, null, null, 30);
        }
    }

    public static final class b implements l48.c {
        @Override // l48.c
        public final boolean c() {
            AtomicBoolean r100 = a.f566988a;
            return a.c();
        }

        public b() {
        }

        @Override // l48.c
        public final Boolean a(LocateScene r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            if (r100.isDoraGStrategy() == true) goto L7;
            return null;
        L7:
            if (r100.canTriggerPoll(r101) == false) goto L12;
            if (r101 == true) goto L10;
        L11:
            boolean r102 = true;
        L13:
            FLogger.f375446a.i("DoraGLocationClient", "canContinueAutoPoll scene:" + r100.name() + " isBackground:" + r101 + " canContinue:" + r102);
            return Boolean.valueOf(r102);
        L10:
            if (a.a() == true) goto L11;
        L12:
            r102 = false;
            goto L13
        }

        @Override // l48.c
        public final Boolean b(LocateScene r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            if (r100.isDoraGStrategy() == true) goto L7;
            return null;
        L7:
            if (r100.canTriggerPoll(r101) == true) goto L9;
        L13:
            boolean r102 = false;
        L14:
            FLogger.f375446a.i("DoraGLocationClient", "canStartAutoPoll scene:" + r100.name() + " isBackground:" + r101 + " canStart:" + r102);
            return Boolean.valueOf(r102);
        L9:
            if (r100.isDoraGRadicalStrategy() == true) goto L11;
        L12:
            r102 = true;
            goto L14
        L11:
            if (a.a() == false) goto L13;
            goto L12
        }
    }

    public static final class c implements n {
        public c() {
        }

        @Override // t39.n
        public final void e(int r100, int r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r102, "productName");
            if (a.f566988a.get() == true) goto L5;
            return;
        L5:
            FLogger.f375446a.i("DoraGLocationClient", "onDoraLinkChanged state:" + r100 + " productId:" + r101 + " productName:" + r102 + " fwVersion:" + r103);
            if (r100 != 0) goto L8;
            a.b("dora_link_disconnected");
            return;
        L8:
            if (r100 != 2) goto L14;
            LocationService.a.a(LocationService.f286873a, LocateScene.DORA_G_CONNECT, null, null, 30);
            return;
        }
    }

    public static final class d implements k {
        public d() {
        }

        @Override // h49.k
        public final void a(int r100) {
        }

        @Override // h49.k
        public final void onStateChange(int r100) {
            if (a.f566988a.get() == true) goto L6;
            return;
        L6:
            if (r100 == 2) goto L8;
            return;
        L8:
            AtomicBoolean r101 = a.f566988a;
            if (a.c() == false) goto L11;
        L13:
            LocationService.a.a(LocationService.f286873a, LocateScene.VUI_AWAKE, null, null, 30);
            return;
        L11:
            if (AppHost.f326268a.a().isAppBackground() == true) goto L13;
        }
    }

    public static final class e implements m {
        public e() {
        }

        @Override // h49.m
        public final void a(boolean r100, boolean r101) {
            if (a.f566988a.get() == true) goto L5;
            return;
        L5:
            FLogger.f375446a.i("DoraGLocationClient", "onWearStateChanged leftOn:" + r100 + " rightOn:" + r101);
            if (r100 == true) goto L10;
            if (r101 == true) goto L10;
            a.b("dora_unwear");
            return;
        L10:
            LocationService.a.a(LocationService.f286873a, LocateScene.DORA_G_WEAR, null, null, 30);
        }
    }

    public a() {
    }

    static {
        f566988a = new AtomicBoolean(false);
        f566989b = new b();
        f566990c = new C8317a();
        f566991d = new d();
        f566992e = new c();
        f566993f = new e();
    }

    public static final boolean a() {
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.B0() != true) goto L7;
        return true;
    }

    public static boolean c() {
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.T0(DoraEnableScope.G_SERIES) != true) goto L7;
        return true;
    }

    public static final void b(String r100) {
        FLogger.f375446a.i("DoraGLocationClient", "stopDoraGAutoPoll reason:".concat(r100));
        LocationService.f286873a.t(r100);
    }
}
