package com.larus.avlink.autoGreet;

import android.media.AudioManager;
import android.os.SystemClock;
import com.larus.applog.api.IApplog;
import com.larus.avlink.activeSummary.ProactiveSummaryModel;
import com.larus.avlink.activeSummary.ProactiveSummarySource;
import com.larus.avlink.n1;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import h49.l;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.collections.SetsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class AutoGreetModel {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f291651n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile AutoGreetModel f291652o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f291653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f291654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f291655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f291656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f291657e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f291658f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference<Set<String>> f291659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile AutoGreetModel$registerBluetoothConnectionReceiverIfNeeded$1$receiver$1 f291660h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile String f291661i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile Job f291662j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f291663k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f291664l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f291665m;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AutoGreetModel f291666a;

        public b(CoroutineExceptionHandler.Key r100, AutoGreetModel r101) {
            this.f291666a = r101;
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            this.f291666a.f291654b = false;
            Lazy r102 = e.f291674a;
            e.b("CoroutineExceptionHandler throwable: " + r101, r101);
        }
    }

    public static final class c implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AutoGreetModel f291667a;

        @Override // h49.l
        public final void g(boolean r100, boolean r101, t39.d r102) {
            Intrinsics.checkNotNullParameter(r102, "deviceInfo");
        }

        public c(AutoGreetModel r100) {
            this.f291667a = r100;
        }

        @Override // h49.l
        public final void f(boolean r110, boolean r111, t39.d r112) {
            Intrinsics.checkNotNullParameter(r112, "deviceInfo");
            AutoGreetModel r100 = this.f291667a;
            r100.getClass();
            IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r101 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L10;
            e.c("Is onboarding, ignore wear state change");
            return;
        L10:
            IDoraService r103 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r103 == null) goto L17;
            DeviceService r104 = r103.device();
            if (r104 == null) goto L17;
            if (r104.F() != true) goto L17;
            boolean r105 = true;
        L18:
            if (r105 == true) goto L20;
            e.c("Auto greet is not enabled, ignore wear state change");
            return;
        L20:
            Lazy r106 = e.f291674a;
            e.c("onWearStateChanged: leftOn=" + r110 + ", rightOn=" + r111 + ", deviceInfo=" + r112);
            if (r100.f291656d == false) goto L23;
        L25:
            boolean r107 = false;
        L26:
            if (r110 == true) goto L30;
            if (r111 == true) goto L30;
            boolean r108 = false;
        L31:
            r100.f291656d = r110;
            r100.f291657e = r111;
            if (r107 == false) goto L65;
            if (r108 == false) goto L65;
            e.c("Earphones worn detected, triggering auto greet logic");
            if (r100.f291658f == false) goto L37;
            e.c("Wear event already reported, skipping");
            return;
        L37:
            String r113 = AutoGreetModel.f(r112.f544461b);
            if (r113.length() != 0) goto L40;
            boolean r114 = true;
        L41:
            if (r114 == false) goto L43;
            e.c("consumeWearUploadEligibility skipped because device mac is empty");
            boolean r109 = false;
        L60:
            if (r109 == false) goto L85;
            r100.f291658f = true;
            e.c("Wear event eligibility consumed, mark hasReportedWearEvent=true");
            BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new AutoGreetModel$uploadWearEvent$1(r112, null), 2, null);
            StringBuilder r115 = new StringBuilder("Starting SSE connection for auto greet, isHonorDevice: ");
            Lazy r116 = e.f291674a;
            r115.append(((Boolean) r116.getValue()).booleanValue());
            e.c(r115.toString());
            if (((Boolean) r116.getValue()).booleanValue() == true) goto L81;
            r100.f291655c = SystemClock.elapsedRealtime() + ((long) (r100.f291663k * 1000));
            r100.g("wear_earphone_trigger", false);
            return;
        L81:
            return;
        L85:
            return;
        L43:
            Set<String> r117 = r100.f291659g.get();
            Intrinsics.checkNotNull(r117);
            Set<String> r118 = r117;
            Intrinsics.checkNotNullParameter(r118, "current");
            if (r118.contains(r113) == false) goto L46;
            r118 = SetsKt.minus(r118, r113);
        L46:
            Set<String> r119 = r118;
            if (Intrinsics.areEqual(r117, r119) == true) goto L56;
            AtomicReference<Set<String>> r120 = r100.f291659g;
        L50:
            if (r120.compareAndSet(r117, r119) == true) goto L51;
            if (r120.get() == r117) goto L50;
            boolean r121 = false;
        L55:
            if (r121 == false) goto L43;
        L51:
            r121 = true;
        L56:
            r109 = r117.contains(r113);
            if (r109 == false) goto L59;
            Lazy r122 = e.f291674a;
            e.c("consumeWearUploadEligibility success: mac=".concat(r113));
            goto L60
        L59:
            Lazy r123 = e.f291674a;
            e.c("consumeWearUploadEligibility failed: mac=" + r113 + ", eligibleMacs=" + r117);
            goto L60
        L40:
            r114 = false;
        L65:
            if (r108 == false) goto L67;
            return;
        L67:
            if (r100.f291658f == false) goto L84;
            e.c("Earphones completely removed, resetting wear event flag");
            r100.f291658f = false;
            return;
        L84:
            return;
        L30:
            r108 = true;
            goto L31
        L23:
            if (r100.f291657e == true) goto L25;
            r107 = true;
        L17:
            r105 = false;
            goto L18
        L5:
            if (r101.J0() != true) goto L7;
            r102 = true;
            goto L8
        }
    }

    static {
        f291651n = new a();
    }

    public static String e() {
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r100 == null) goto L7;
        DeviceService r101 = r100.device();
        if (r101 == null) goto L7;
        return r101.n();
    L7:
        return null;
    }

    public final void h() {
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L9 LinkageError -> L11
        if (r100 == null) goto L7;
        DeviceService r101 = r100.device();     // Catch: Exception -> L9 LinkageError -> L11
        if (r101 == null) goto L7;
        r101.v0(this.f291665m);     // Catch: Exception -> L9 LinkageError -> L11
    L7:
        t0.a(new com.larus.avlink.autoGreet.a(this));     // Catch: Exception -> L9 LinkageError -> L11
        e.c("registerWearListener success");     // Catch: Exception -> L9 LinkageError -> L11
    L17:
        return;
    L9:
        e = move-exception;
        e.b("registerWearListener failed", e);
        return;
    L11:
        e = move-exception;
        e.b("registerWearListener failed because native library is unavailable", e);
    }

    public AutoGreetModel() {
        this.f291659g = new AtomicReference(SetsKt.emptySet());
        this.f291663k = 70;
        this.f291664l = new b(CoroutineExceptionHandler.Key, this);
        this.f291665m = new c(this);
    }

    public static void d(String r100) {
        new ProactiveSummaryModel().d(r100, ProactiveSummarySource.SSE_FRONTIER);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.b("dispatchAutoGreet error", e);
    }

    public static String f(String r100) {
        if (r100 == null) goto L6;
        String r101 = StringsKt.trim(r100).toString();
        if (r101 == null) goto L6;
        String r102 = r101.toUpperCase(Locale.US);
    L7:
        if (r102 != null) goto L10;
        return "";
    L10:
        return r102;
    L6:
        r102 = null;
        goto L7
    }

    public final void a(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        e.c("cacheWearUploadEligibleMac skipped because device mac is empty");
        return;
    L9:
        Set<String> r102 = this.f291659g.get();
        Intrinsics.checkNotNull(r102);
        Set<String> r103 = r102;
        Intrinsics.checkNotNullParameter(r103, "current");
        Set<String> r104 = SetsKt.plus(r103, r100);
        if (Intrinsics.areEqual(r102, r104) == true) goto L19;
        AtomicReference<Set<String>> r105 = this.f291659g;
    L13:
        if (r105.compareAndSet(r102, r104) == true) goto L14;
        if (r105.get() == r102) goto L13;
        boolean r106 = false;
    L18:
        if (r106 == false) goto L9;
    L14:
        r106 = true;
    L19:
        Lazy r107 = e.f291674a;
        e.c("cacheWearUploadEligibleMac success: mac=" + r100 + ", scope=until_first_wear_upload");
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void b(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        Set<String> r102 = this.f291659g.get();
        Intrinsics.checkNotNull(r102);
        Set<String> r103 = r102;
        Intrinsics.checkNotNullParameter(r103, "current");
        if (r103.contains(r100) == false) goto L11;
        r103 = SetsKt.minus(r103, r100);
    L11:
        Set<String> r104 = r103;
        if (Intrinsics.areEqual(r102, r104) == true) goto L22;
        AtomicReference<Set<String>> r105 = this.f291659g;
    L15:
        if (r105.compareAndSet(r102, r104) == true) goto L16;
        if (r105.get() == r102) goto L15;
        boolean r106 = false;
    L20:
        if (r106 == false) goto L8;
    L16:
        r106 = true;
    L22:
        if (r102.contains(r100) == false) goto L33;
        Lazy r107 = e.f291674a;
        e.c("clearWearUploadEligibility success: mac=".concat(r100));
        return;
    L33:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void c(String r100) {
        String r101 = this.f291661i;
        if (r101 != null) goto L5;
        return;
    L5:
        String r102 = f(e());
        if (r102.length() != 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
    L18:
        Lazy r104 = e.f291674a;
        e.c("consumePendingGreet ignored, connectedMac=" + r100 + " not match doraMac=" + r102);
        return;
    L11:
        if (Intrinsics.areEqual(r100, r102) == false) goto L18;
        Job r105 = this.f291662j;
        if (r105 == null) goto L16;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
    L16:
        this.f291662j = null;
        this.f291661i = null;
        Lazy r106 = e.f291674a;
        e.c("Consuming pending greet after A2DP ready, summaryId=".concat(r101));
        d(r101);
        return;
    L8:
        r103 = false;
        goto L9
    }

    public final void i(String r110) {
        Lazy r100 = e.f291674a;
        e.c("triggerAutoGreet with summaryId: " + r110);
        boolean r101 = false;
        if (r110.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        Intrinsics.checkNotNullParameter("triggerAutoGreet skipped because summaryId is empty", "message");
        n1.e("AutoGreetUtils", "triggerAutoGreet skipped because summaryId is empty");
        return;
    L9:
        IDoraService r103 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r103 == null) goto L31;
        DeviceService r104 = r103.device();
        if (r104 == null) goto L31;
        boolean r105 = r104.J();
        String r106 = f(e());
        AppHost.Companion r107 = AppHost.f326268a;
        Object r108 = r107.getApplication().getSystemService("audio");
        if ((r108 instanceof AudioManager) == false) goto L17;
        AudioManager r109 = (AudioManager) r108;
    L18:
        if (r109 != null) goto L20;
        Set<String> r111 = SetsKt.emptySet();
    L21:
        if (r105 == true) goto L23;
    L30:
        e.c("shouldPendGreetUntilA2dpReady=" + r101 + ", isDoraConnected=" + r105 + ", connectedDoraMac=" + r106 + ", activeA2dpAddressSet=" + r111);
        goto L31
    L23:
        if (r106.length() <= 0) goto L25;
        boolean r112 = true;
    L26:
        if (r112 == false) goto L30;
        if (r111.isEmpty() == false) goto L30;
        r101 = true;
        goto L30
    L25:
        r112 = false;
        goto L26
    L20:
        r111 = ja8.e.a(r109, r107.getApplication(), "AutoGreetModel");
        goto L21
    L17:
        r109 = null;
    L31:
        if (r101 == false) goto L37;
        this.f291661i = r110;
        Job r113 = this.f291662j;
        if (r113 == null) goto L35;
        Job.DefaultImpls.cancel$default(r113, null, 1, null);
    L35:
        this.f291662j = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new AutoGreetModel$startPendingGreetTimeout$1(this, r110, null), 2, null);
        e.c("Auto greet pending, waiting for A2DP ready, summaryId=".concat(r110));
        return;
    L37:
        d(r110);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void g(String r100, boolean r110) {
        if (SystemClock.elapsedRealtime() < this.f291655c) goto L7;
        Lazy r111 = e.f291674a;
        e.c("receiveSseForAutoGreet trigger:" + r100 + ": exceed sseCloseTimestamp, return");
        return;
    L7:
        if (this.f291654b == false) goto L10;
        Lazy r112 = e.f291674a;
        e.c("receiveSseForAutoGreet trigger:" + r100 + ": isSSEConnecting, return");
        return;
    L10:
        this.f291654b = true;
        if (r110 == true) goto L13;
        this.f291653a = 0;
    L13:
        JSONObject r113 = new JSONObject();
        IApplog.Companion r101 = IApplog.f287053a;
        r113.put("device_id", r101.getDeviceId());
        r113.put("user_id", r101.getUserID());
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO().plus(this.f291664l), null, new AutoGreetModel$receiveSseForAutoGreet$1(r100, r113, this, null), 2, null);
    }
}
