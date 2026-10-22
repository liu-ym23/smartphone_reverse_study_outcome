package com.larus.avlink.gallery.silent;

import b49.e;
import b49.f;
import b98.d;
import com.larus.avlink.gallery.coordinator.MediaSyncCoordinator;
import com.larus.avlink.gallery.view.mob.GalleryMobHelper;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.annotation.DoraScene;
import com.larus.dora.api.model.FlowDoraGlassOpenState;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.dora.impl.serviceimpl.h;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import h49.i;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.TimersKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes25.dex */
public final class SilentSyncManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Job f292705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Timer f292706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final IDoraService f292707c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineScope f292708d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile int f292709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile int f292710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile Pair<Integer, Integer> f292711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f292712h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicBoolean f292713i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static SilentSyncManager$init$linkListener$1 f292714j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static com.larus.avlink.gallery.silent.a f292715k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c f292716l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f292717m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final SilentSyncManager$appBackgroundListener$1 f292718n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final b f292719o = null;

    public static final class a implements u39.a {
        public a() {
        }

        @Override // u39.a
        public final void a(Set<? extends DoraScene> r110) {
            Intrinsics.checkNotNullParameter(r110, "scene");
            FLogger r100 = FLogger.f375446a;
            r100.i("SilentSyncManager", "Dora scene changed: " + CollectionsKt.joinToString$default(r110, ",", null, null, 0, null, null, 62, null));
            if ((!r110.isEmpty()) == false) goto L5;
            Job r111 = SilentSyncManager.f292705a;
            SilentSyncManager.d("OTA Or Feedback");
            return;
        L5:
            r100.i("SilentSyncManager", "OTA Or Feedback exit, try start silent sync");
            IDoraService r112 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r112 == null) goto L10;
            VisionService r113 = r112.V();
            if (r113 == null) goto L10;
            Pair<Integer, Integer> r114 = r113.l();
        L11:
            int r101 = 0;
            if (r114 == null) goto L14;
            int r102 = r114.getFirst().intValue();
        L15:
            if (r114 == null) goto L17;
            r101 = r114.getSecond().intValue();
        L17:
            if (r102 > 0) goto L19;
            if (r101 > 0) goto L19;
            return;
        L19:
            r100.i("SilentSyncManager", "Has media when OTA Or Feedback exit, triggering silent sync");
            Job r115 = SilentSyncManager.f292705a;
            SilentSyncManager.c();
            return;
        L14:
            r102 = 0;
        L10:
            r114 = null;
            goto L11
        }
    }

    public static final class b implements d {
        public b() {
        }

        @Override // b98.d
        public final void a(int r100, int r101) {
            FLogger r102 = FLogger.f375446a;
            r102.i("SilentSyncManager", "Scene state changed: scene:" + r100 + ", state:" + r101);
            if (r100 != 1) goto L25;
            if (r101 != 1) goto L6;
            Job r103 = SilentSyncManager.f292705a;
            SilentSyncManager.d("Live AI");
            return;
        L6:
            if (r101 != 2) goto L28;
            r102.i("SilentSyncManager", "Live AI exit, try start silent sync");
            IDoraService r104 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r104 == null) goto L13;
            VisionService r105 = r104.V();
            if (r105 == null) goto L13;
            Pair<Integer, Integer> r106 = r105.l();
        L14:
            int r107 = 0;
            if (r106 == null) goto L17;
            int r108 = r106.getFirst().intValue();
        L18:
            if (r106 == null) goto L20;
            r107 = r106.getSecond().intValue();
        L20:
            if (r108 > 0) goto L22;
            if (r107 > 0) goto L22;
            return;
        L22:
            r102.i("SilentSyncManager", "Has media when Live AI exit, triggering silent sync");
            Job r109 = SilentSyncManager.f292705a;
            SilentSyncManager.c();
            return;
        L17:
            r108 = 0;
        L13:
            r106 = null;
            goto L14
        L28:
            return;
        }
    }

    public static final class c implements i {
        public c() {
        }

        @Override // h49.i
        public final void c() {
            if (SilentSyncManager.f292709e != 1) goto L6;
            FLogger.f375446a.i("SilentSyncManager", "Silent transfer status already on in the mode, skipping");
            return;
        L6:
            Job r100 = SilentSyncManager.f292705a;
            SilentSyncManager.f292709e = 1;
            FLogger.f375446a.i("SilentSyncManager", "Silent transfer status always on in the mode");
            Job r101 = SilentSyncManager.f292705a;
            boolean r102 = SilentSyncManager.b();
            GalleryMobHelper.f293006a.getClass();
            LinkedHashMap r103 = new LinkedHashMap();
            r103.put("silent_sync_switch", Integer.valueOf(r102 ? 1 : 0));
            GalleryMobHelper.i("flow_album_silent_sync_switch", r103);
            BuildersKt.launch$default(SilentSyncManager.f292708d, null, null, new SilentSyncManager$wifiStateListener$1$onAlbumSilentTrans$1(r102, null), 3, null);
        }

        @Override // h49.i
        public final void a(FlowDoraGlassOpenState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            Intrinsics.checkNotNullParameter(r100, "state");
            FLogger r101 = FLogger.f375446a;
            r101.i("SilentSyncManager", "Glass open state changed: " + r100);
            if (SilentSyncManager.f292710f != r100.getValue()) goto L6;
            r101.d("SilentSyncManager", "Glass open state unchanged " + r100.getValue() + ", skipping");
            return;
        L6:
            Job r102 = SilentSyncManager.f292705a;
            SilentSyncManager.f292710f = r100.getValue();
            if (r100 != FlowDoraGlassOpenState.CLOSE) goto L14;
            Job r103 = SilentSyncManager.f292705a;
            if (SilentSyncManager.b() == true) goto L12;
            r101.i("SilentSyncManager", "Auto sync feature is disabled, skipping");
            return;
        L12:
            r101.i("SilentSyncManager", "Glass folded detected - triggering silent sync");
            SilentSyncManager.c();
            return;
        }

        @Override // h49.i
        @Deprecated(message = "使用ThumbnailManager")
        public final void b(e r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
        }

        @Override // h49.i
        public final void d(f r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
        }

        @Override // h49.i
        public final void e(FlowDoraGlassOpenState r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // h49.i
        public final void f(int r100, int r101, String r102) {
            FLogger.f375446a.i("SilentSyncManager", "WiFi state changed: " + r100 + " -> " + r101);
            if (r101 != 0) goto L6;
            Job r103 = SilentSyncManager.f292705a;
            SilentSyncManager.d("Wifi Disconnected");
            return;
        }
    }

    public SilentSyncManager() {
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.larus.avlink.gallery.silent.SilentSyncManager$appBackgroundListener$1] */
    static {
        f292707c = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        f292708d = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        f292709e = -1;
        f292710f = -1;
        f292711g = new Pair(0, 0);
        f292712h = true;
        f292713i = new AtomicBoolean(false);
        f292716l = new c();
        f292717m = new a();
        f292718n = new SilentSyncManager$appBackgroundListener$1();
        f292719o = new b();
    }

    public static boolean b() {
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r100 == null) goto L7;
        h r101 = r100.debug();
        if (r101 == null) goto L7;
        boolean r102 = r101.i();
    L8:
        FLogger.f375446a.i("SilentSyncManager", "isOSilentTransferEnabled: " + r102 + ' ');
        if (r102 == true) goto L11;
    L13:
        return false;
    L11:
        if (f292709e != 1) goto L13;
        return true;
    L7:
        r102 = true;
        goto L8
    }

    public static void c() {
        String r100 = UUID.randomUUID().toString();
        Ref.BooleanRef r101 = new Ref.BooleanRef();
        boolean r102 = false;
        if (b() == true) goto L5;
        FLogger.f375446a.i("SilentSyncManager", "preCheck: Silent sync switch is off, skipping silent media sync");
        GalleryMobHelper r103 = GalleryMobHelper.f293006a;
        GalleryMobHelper.AlbumSyncInterceptionReason r104 = GalleryMobHelper.AlbumSyncInterceptionReason.SILENT_SYNC_OFF;
        r103.getClass();
        GalleryMobHelper.h(false, r100, r104);
        boolean r105 = false;
    L7:
        if (com.larus.avlink.gallery.f.a() == false) goto L9;
        FLogger.f375446a.i("SilentSyncManager", "preCheck: Battery level is too low, skipping silent media sync");
        GalleryMobHelper r106 = GalleryMobHelper.f293006a;
        GalleryMobHelper.AlbumSyncInterceptionReason r107 = GalleryMobHelper.AlbumSyncInterceptionReason.LOW_BATTERY;
        r106.getClass();
        GalleryMobHelper.h(false, r100, r107);
        r105 = false;
    L9:
        MediaSyncCoordinator r108 = MediaSyncCoordinator.f292370a;
        if (MediaSyncCoordinator.i() == false) goto L12;
        FLogger.f375446a.i("SilentSyncManager", "preCheck: Silent sync is disabled during another media sync in progress");
        GalleryMobHelper r109 = GalleryMobHelper.f293006a;
        GalleryMobHelper.AlbumSyncInterceptionReason r110 = GalleryMobHelper.AlbumSyncInterceptionReason.IS_GETTING_MEDIAS;
        r109.getClass();
        GalleryMobHelper.h(false, r100, r110);
        r105 = false;
    L12:
        IDoraService r111 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r111 == null) goto L19;
        DeviceService r112 = r111.device();
        if (r112 == null) goto L19;
        if (r112.e0() != true) goto L19;
        boolean r113 = true;
    L20:
        if (r113 == false) goto L22;
        FLogger.f375446a.i("SilentSyncManager", "preCheck: Silent sync is disabled during OTA");
        GalleryMobHelper r114 = GalleryMobHelper.f293006a;
        GalleryMobHelper.AlbumSyncInterceptionReason r115 = GalleryMobHelper.AlbumSyncInterceptionReason.OTA_ACTIVE;
        r114.getClass();
        GalleryMobHelper.h(false, r100, r115);
        r105 = false;
    L22:
        IDoraService r116 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r116 == null) goto L29;
        DeviceService r117 = r116.device();
        if (r117 == null) goto L29;
        if (r117.U() != true) goto L29;
        boolean r118 = true;
    L30:
        if (r118 == false) goto L33;
        FLogger.f375446a.i("SilentSyncManager", "preCheck: Silent sync is disabled during Feedback");
        GalleryMobHelper r119 = GalleryMobHelper.f293006a;
        GalleryMobHelper.AlbumSyncInterceptionReason r120 = GalleryMobHelper.AlbumSyncInterceptionReason.FEEDBACK_ACTIVE;
        r119.getClass();
        GalleryMobHelper.h(false, r100, r120);
        r105 = false;
    L33:
        if (b98.b.b(1) == false) goto L36;
        FLogger.f375446a.i("SilentSyncManager", "preCheck: Silent sync is disabled during Live AI mode");
        GalleryMobHelper r121 = GalleryMobHelper.f293006a;
        GalleryMobHelper.AlbumSyncInterceptionReason r122 = GalleryMobHelper.AlbumSyncInterceptionReason.LIVE_AI;
        r121.getClass();
        GalleryMobHelper.h(false, r100, r122);
        r105 = false;
    L36:
        if (b98.b.b(3) == false) goto L38;
        FLogger.f375446a.i("SilentSyncManager", "preCheck: Silent sync is disabled during recording");
        GalleryMobHelper r123 = GalleryMobHelper.f293006a;
        GalleryMobHelper.AlbumSyncInterceptionReason r124 = GalleryMobHelper.AlbumSyncInterceptionReason.RECORDING;
        r123.getClass();
        GalleryMobHelper.h(false, r100, r124);
    L39:
        r101.element = r102;
        if (r102 == true) goto L42;
        FLogger.f375446a.i("SilentSyncManager", "Silent sync pre check failed, skip this job.");
    L42:
        FLogger.f375446a.i("SilentSyncManager", "startSyncWithDiff called - checking for new media");
        f292705a = BuildersKt.launch$default(f292708d, null, null, new SilentSyncManager$startSyncWithDiff$1(r100, r101, null), 3, null);
        return;
    L38:
        r102 = r105;
    L29:
        r118 = false;
    L19:
        r113 = false;
        goto L20
    L5:
        r105 = true;
        goto L7
    }

    public static final void a(String r100) {
        if (f292706b == null) goto L7;
        FLogger.f375446a.d("SilentSyncManager", "Cancelling previous auto sync schedule");
        Timer r101 = f292706b;
        if (r101 == null) goto L7;
        r101.cancel();
    L7:
        FLogger.f375446a.i("SilentSyncManager", "Scheduling auto sync in 600000ms for reason: ".concat(r100));
        Timer r102 = TimersKt.timer("DoraGSilentSync", false);
        r102.scheduleAtFixedRate(new com.larus.avlink.gallery.silent.b(r100), 0, 600000);
        f292706b = r102;
    }

    public static void d(String r100) {
        FLogger r101 = FLogger.f375446a;
        r101.i("SilentSyncManager", "Stopping silent sync operation");
        Job r102 = f292705a;
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L13;
        r101.d("SilentSyncManager", "Cancelling current sync job");
        Job r104 = f292705a;
        if (r104 == null) goto L13;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L13:
        r101.d("SilentSyncManager", "Cancelling auto sync timer");
        Timer r105 = f292706b;
        if (r105 == null) goto L16;
        r105.cancel();
    L16:
        r101.d("SilentSyncManager", "Delegating sync stop to HardwareMediaLoadService");
        MediaSyncCoordinator r106 = MediaSyncCoordinator.f292370a;
        if (MediaSyncCoordinator.i() == true) goto L19;
    L21:
        r101.i("SilentSyncManager", "Silent sync operation stopped successfully");
        return;
    L19:
        if (MediaSyncCoordinator.f292375f != MediaSyncCoordinator.SyncMode.SILENT) goto L21;
        MediaSyncCoordinator.w(r100, null, 6);
        goto L21
    L5:
        if (r102.isActive() != true) goto L7;
        r103 = true;
        goto L9
    }
}
