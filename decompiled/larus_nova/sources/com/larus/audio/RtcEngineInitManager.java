package com.larus.audio;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.keva.Keva;
import com.google.gson.reflect.TypeToken;
import com.larus.audio.repo.AudioConfigRepo;
import com.larus.network.http.AsyncThrowable;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.IVoiceCallService;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
public final class RtcEngineInitManager {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f288304h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f288305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f288306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Job f288307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CompletableDeferred<f0> f288308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f288309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d78.d f288310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f288311g;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class b implements com.larus.platform.api.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RtcEngineInitManager f288312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f288313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ cf9.a f288314c;

        @Override // com.larus.platform.api.y
        public final boolean a() {
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(RtcEngineInitManager r100, Function1<? super Boolean, Unit> r101, cf9.a r102) {
            this.f288312a = r100;
            this.f288313b = r101;
            this.f288314c = r102;
        }

        @Override // com.larus.platform.api.y
        public final void onGetId(String r100, String r101, String r110) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DID);
            Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_INSTALL_ID);
            Intrinsics.checkNotNullParameter(r110, "ssid");
            this.f288312a.getClass();
            boolean r102 = false;
            if (r100 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
        L15:
            if (r102 == true) goto L17;
            this.f288313b.invoke(Boolean.FALSE);
            return;
        L17:
            RtcEngineInitManager r104 = this.f288312a;
            cf9.a r105 = cf9.a.a(this.f288314c, null, null, r100, false, 0, 27);
            Function1<Boolean, Unit> r111 = this.f288313b;
            r104.getClass();
            RtcEngineInitManager.g(r105, r111);
            return;
        L12:
            if (Intrinsics.areEqual(r100, "0") == true) goto L15;
            r102 = true;
            goto L15
        L5:
            if (StringsKt.isBlank(r100) == true) goto L8;
            r103 = false;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends TypeToken<d78.d> {
        public c() {
        }
    }

    static {
    }

    public final d78.d i() {
        String r100 = ((Keva) this.f288309e.getValue()).getString("audio_launch_data", null);     // Catch: Exception -> L24
        zd9.h r101 = zd9.h.f571481a;     // Catch: Exception -> L24
        if (r100 != null) goto L6;
    L9:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L27;
    L21:
        Object r103 = null;
    L22:
        return (d78.d) r103;
    L27:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L14
        r101.getClass();     // Catch: Throwable -> L14
        r103 = Result.m9449constructorimpl(zd9.h.f571482b.fromJson(r100, new c().getType()));     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r103);     // Catch: Exception -> L24
        if (r105 == null) goto L20;
        com.larus.im.internal.delegate.c0 r106 = com.larus.im.internal.delegate.c0.f348199b;     // Catch: Exception -> L24
        StringBuilder r107 = new StringBuilder("fromJson failed, stack: ");     // Catch: Exception -> L24
        Intrinsics.checkNotNullParameter(r105, "<this>");     // Catch: Exception -> L24
        r107.append(ExceptionsKt.stackTraceToString(r105));     // Catch: Exception -> L24
        r106.e("GsonHolder", r107.toString());     // Catch: Exception -> L24
    L20:
        if (Result.m9455isFailureimpl(r103) == false) goto L22;
    L14:
        th = move-exception;
        Result.Companion r108 = Result.Companion;     // Catch: Exception -> L24
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L24
        goto L16
    L6:
        if (StringsKt.isBlank(r100) == true) goto L9;
        r102 = false;
    L24:
        e = move-exception;
        FLogger.f375446a.e("RtcEngineInitManager", "[loadAppLaunchDataFromJson] error: " + e.getMessage());
        return null;
    }

    public RtcEngineInitManager() {
        this.f288308d = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.f288309e = LazyKt.lazy(new j1());
        this.f288311g = LazyKt.lazy(new k1(this));
    }

    public static List c(d78.d r100) {
        List r101 = null;
        if (r100 == null) goto L22;
        List<d78.e> r102 = r100.b();
        if (r102 == null) goto L22;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L21;
        d78.e r105 = (d78.e) r104.next();
        if (r105 == null) goto L18;
        String r106 = r105.b();
        if (r106 == null) goto L18;
        String r107 = StringsKt.trim(r106).toString();
        if (r107 == null) goto L18;
        if ((!StringsKt.isBlank(r107)) == false) goto L18;
    L19:
        if (r107 == null) goto L8;
        r103.add(r107);
    L18:
        r107 = null;
        goto L19
    L21:
        r101 = CollectionsKt.distinct(r103);
    L22:
        if (r101 == null) goto L24;
        return r101;
    L24:
        return CollectionsKt.emptyList();
    }

    public final void b(d78.d r100) {
        zd9.h.f571481a.getClass();     // Catch: Exception -> L4
        ((Keva) this.f288309e.getValue()).storeString("audio_launch_data", zd9.h.c(r100));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        FLogger.f375446a.e("RtcEngineInitManager", "[cacheStreamAppDetailsJson] error: " + e.getMessage());
    }

    public final void f(d78.d r100) {
        this.f288305a = false;
        this.f288306b = true;
        this.f288310f = r100;
        FLogger.f375446a.i("RtcEngineInitManager", "[handleInitializationSuccess] rtcConnectionInfo=" + r100);
        if (this.f288308d.isActive() == false) goto L6;
        this.f288308d.complete(new f0(true, false));
        return;
    }

    public final void l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "trigger");
        if (sf9.a.a((ouc.d0) com.larus.im.internal.delegate.w.f348282r.getValue(), "enable_token_preload_optimize", false) == true) goto L6;
        FLogger.f375446a.i("RtcEngineInitManager", "[ConnectOpt][tokenPreload] skip trigger: " + r100 + ", enableTokenPreloadOptimize=false");
        return;
    L6:
        d78.d r101 = this.f288310f;
        if (r101 != null) goto L9;
        r101 = i();
    L9:
        if (r101 != null) goto L13;
        FLogger.f375446a.i("RtcEngineInitManager", "[ConnectOpt][tokenPreload] skip trigger: " + r100 + ", launchData is null");
        return;
    L13:
        if (this.f288310f == null) goto L15;
    L17:
        k(r101, r100);
        return;
    L15:
        if (Intrinsics.areEqual(r100, "network_recovered") == false) goto L17;
        r100 = "network_recovered_fallback";
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(final RtcEngineInitManager r100, com.larus.network.http.a r101) {
        r100.getClass();
        boolean r102 = false;
        if ((r101 instanceof com.larus.network.http.y) == false) goto L13;
        d78.d r103 = (d78.d) ((com.larus.network.http.y) r101).f360135b;
        if (r103 == null) goto L7;
        final d78.d r104 = d78.d.a(r103);
    L8:
        FLogger.f375446a.i("RtcEngineInitManager", "[fetchRTCConnectionInfo] rtcConnectionInfo=" + r104);
        if (r104 == null) goto L11;
        r100.k(r104, "call_launch_success");
        r100.h(r104, new i1(r100, r104));
        return;
    L11:
        r100.e(new Exception("RTC engine initialization failed"), false);
        return;
    L7:
        r104 = null;
        goto L8
    L13:
        if ((r101 instanceof com.larus.network.http.f) == false) goto L18;
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("[fetchRTCConnectionInfo] failed, ");
        com.larus.network.http.f r107 = (com.larus.network.http.f) r101;
        r106.append(r107.f360157d);
        r105.e("RtcEngineInitManager", r106.toString());
        AsyncThrowable r108 = r107.f360157d;
        if (r108.getCode() != (-555)) goto L17;
        r102 = true;
    L17:
        r100.e(r108, r102);
        return;
    L18:
        r100.e(new Exception("RTC engine initialization unknown failed"), false);
    }

    public static void g(cf9.a r100, Function1 r101) {
        int r102 = com.larus.im.a.f346406a;
        gd9.o r103 = com.larus.im.internal.d.f347913a;
        com.larus.im.internal.audio.u.f347501c.getClass();
        Intrinsics.checkNotNullParameter(r100, "config");
        com.larus.im.internal.audio.u.a().f532754g.c(r100);
        r101.invoke(Boolean.TRUE);
    }

    public static void j(List r100, String r101) {
        int r102 = com.larus.im.a.f346406a;
        if (com.larus.im.internal.d.f347915c == true) goto L6;
        FLogger.f375446a.i("RtcEngineInitManager", "[ConnectOpt][tokenPreload] skip because FlowAVSDK is not initialized, trigger: " + r101);
        return;
    L6:
        com.larus.im.internal.audio.u.f347501c.getClass();
        Intrinsics.checkNotNullParameter(r100, "rtcAppIds");
        com.larus.im.internal.audio.u.a().f532754g.b(r100);
    }

    public final Object d(String r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof RtcEngineInitManager$ensureInitialized$1) == false) goto L7;
        RtcEngineInitManager$ensureInitialized$1 r100 = (RtcEngineInitManager$ensureInitialized$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        ResultKt.throwOnFailure(r112);
    L44:
        return Boxing.boxBoolean(((f0) r112).f289666a);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r112);
    L36:
        return Boxing.boxBoolean(((f0) r112).f289666a);
    L17:
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L28:
        f0 r113 = (f0) r112;
        boolean r104 = r113.f289666a;
        if (r104 == false) goto L31;
    L37:
        if (r104 == true) goto L46;
        if (ObricFeatureServiceDelegate.f387839b.a() == false) goto L46;
        FLogger.f375446a.i("RtcEngineInitManager", "[ensureInitialized] server downgrade, retry initialization");
        this.f288308d = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        m(r110, false);
        CompletableDeferred<f0> r114 = this.f288308d;
        r100.L$0 = null;
        r100.label = 3;
        r112 = r114.await(r100);
        if (r112 != r102) goto L44;
        return r102;
    L46:
        return Boxing.boxBoolean(true);
    L31:
        if (r113.f289667b == false) goto L37;
        FLogger.f375446a.i("RtcEngineInitManager", "[ensureInitialized] server downgrade, retry initialization");
        this.f288308d = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        m(r110, false);
        CompletableDeferred<f0> r115 = this.f288308d;
        r100.L$0 = null;
        r100.label = 2;
        r112 = r115.await(r100);
        if (r112 != r102) goto L36;
        return r102;
    L18:
        ResultKt.throwOnFailure(r112);
        if (this.f288306b == true) goto L46;
        if (this.f288305a == false) goto L23;
    L25:
        CoroutineDispatcher r116 = Dispatchers.getIO();
        RtcEngineInitManager$ensureInitialized$ret$1 r105 = new RtcEngineInitManager$ensureInitialized$ret$1(this, null);
        r100.L$0 = r110;
        r100.label = 1;
        r112 = BuildersKt.withContext(r116, r105, r100);
        if (r112 != r102) goto L28;
        return r102;
    L23:
        if (this.f288308d.isCompleted() == true) goto L25;
        m(r110, false);
    L7:
        r100 = new RtcEngineInitManager$ensureInitialized$1(this, r111);
        goto L8
    }

    public final void e(Throwable r100, boolean r101) {
        this.f288305a = false;
        this.f288306b = false;
        FLogger r102 = FLogger.f375446a;
        r102.e("RtcEngineInitManager", "[initializeRTC] failed, " + r100.getMessage() + ", isServerDowngrade: " + r101);
        if (r101 == false) goto L5;
        r102.i("RtcEngineInitManager", "[ConnectOpt][tokenPreload] skip launch failure fallback because server downgrade");
    L7:
        if (this.f288308d.isActive() == false) goto L10;
        this.f288308d.complete(new f0(false, r101));
        return;
    L10:
        return;
    L5:
        l("voice_config_call_launch_failure_fallback");
        goto L7
    }

    public final void h(d78.d r110, Function1<? super Boolean, Unit> r111) {
        if (d78.c.a(r110) == false) goto L45;
        String r100 = com.larus.platform.service.o.f365780a.getDeviceId();
        if (AccountService.f365697a.isEnterpriseAccount() == false) goto L7;
        String r101 = "doubao_ent";
    L8:
        List<d78.e> r112 = r110.b();
        String r102 = null;
        if (r112 == null) goto L24;
        Iterator<T> r113 = r112.iterator();
    L12:
        if (r113.hasNext() == false) goto L20;
        Object r103 = r113.next();
        d78.e r104 = (d78.e) r103;
        if (r104 == null) goto L16;
        String r105 = r104.a();
    L18:
        if (Intrinsics.areEqual(r105, r101) == false) goto L12;
    L21:
        d78.e r106 = (d78.e) r103;
        if (r106 == null) goto L24;
        r102 = r106.b();
        goto L24
    L16:
        r105 = null;
        goto L18
    L20:
        r103 = null;
    L24:
        if (r102 != null) goto L26;
        r102 = "";
    L26:
        String r107 = r102;
        cf9.a r108 = new cf9.a("", "", "", false, 0);
        String r109 = AudioConfigRepo.f289781a.C();
        boolean r114 = VoiceCallServiceDelegate.f377087a.p();
        IVoiceCallService r115 = (IVoiceCallService) ServiceManager.get().getService(IVoiceCallService.class);
        boolean r116 = false;
        if (r115 == null) goto L31;
        b3a.a r117 = r115.v();
        if (r117 == null) goto L31;
        int r118 = r117.f17394c;
    L32:
        cf9.a r119 = cf9.a.a(r108, r107, r109, null, r114, r118, 4);
        if (StringsKt.isBlank(r100) == false) goto L35;
        boolean r120 = true;
    L36:
        if (r120 == false) goto L39;
    L42:
        if (r116 == true) goto L44;
        com.larus.platform.service.o.f365780a.e(new b(this, r111, r119));
        return;
    L44:
        g(cf9.a.a(r119, null, null, r100, false, 0, 27), r111);
        return;
    L39:
        if (Intrinsics.areEqual(r100, "0") == true) goto L42;
        r116 = true;
        goto L42
    L35:
        r120 = false;
    L31:
        r118 = 0;
        goto L32
    L7:
        r101 = "doubao";
        goto L8
    L45:
        r111.invoke(Boolean.FALSE);
    }

    public final void k(d78.d r100, String r110) {
        boolean r101 = false;
        boolean r102 = sf9.a.a((ouc.d0) com.larus.im.internal.delegate.w.f348282r.getValue(), "enable_token_preload_optimize", false);
        if (r102 == true) goto L46;
        List<d78.e> r103 = r100.b();
        ArrayList r104 = null;
        if (r103 == null) goto L15;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r103.iterator();
    L8:
        if (r106.hasNext() == false) goto L16;
        d78.e r107 = (d78.e) r106.next();
        if (r107 == null) goto L12;
        String r108 = r107.b();
    L13:
        if (r108 == null) goto L8;
        r105.add(r108);
        goto L8
    L12:
        r108 = null;
    L16:
        if (r105 != null) goto L18;
    L21:
        boolean r109 = true;
    L22:
        if (r109 == true) goto L24;
        j(r105, r110);
        b(r100);
        return;
    L24:
        d78.d r111 = (d78.d) this.f288311g.getValue();
        if (r111 == null) goto L38;
        List<d78.e> r112 = r111.b();
        if (r112 == null) goto L38;
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r112.iterator();
    L30:
        if (r114.hasNext() == false) goto L37;
        d78.e r115 = (d78.e) r114.next();
        if (r115 == null) goto L34;
        String r116 = r115.b();
    L35:
        if (r116 == null) goto L30;
        r113.add(r116);
        goto L30
    L34:
        r116 = null;
        goto L35
    L37:
        r104 = r113;
    L38:
        if (r104 != null) goto L40;
    L41:
        r101 = true;
    L42:
        if (r101 == true) goto L44;
        j(r104, r110);
        return;
    L44:
        FLogger.f375446a.e("RtcEngineInitManager", "[prefetchRtcAppIds] no rtcAppIds available (empty and no cache)");
        return;
    L40:
        if (r104.isEmpty() == false) goto L42;
    L18:
        if (r105.isEmpty() == true) goto L21;
        r109 = false;
        goto L22
    L15:
        r105 = null;
        goto L16
    L46:
        LinkedHashSet r117 = new LinkedHashSet();
        r117.addAll(c(r100));
        if (r117.isEmpty() == false) goto L49;
        r117.addAll(c(i()));
    L49:
        List r118 = CollectionsKt.sorted(CollectionsKt.toList(r117));
        if ((!r118.isEmpty()) == false) goto L54;
        FLogger.f375446a.i("RtcEngineInitManager", "[ConnectOpt][tokenPreload] trigger: " + r110 + ", rtcAppIds: " + r118 + ", enableTokenPreloadOptimize: " + r102);
        j(r118, r110);
        if ((!c(r100).isEmpty()) == false) goto L68;
        b(r100);
        return;
    L68:
        return;
    L54:
        FLogger.f375446a.e("RtcEngineInitManager", "[ConnectOpt][tokenPreload] skip empty rtcAppIds, trigger: " + r110 + ", enableTokenPreloadOptimize: " + r102);
    }

    public final void m(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        if (this.f288305a == false) goto L6;
        FLogger.f375446a.i("RtcEngineInitManager", "[fetchRTCConnectionInfo] isInitializing=" + this.f288305a + ", caller: " + r100);
        return;
    L6:
        this.f288305a = true;
        FLogger.f375446a.i("RtcEngineInitManager", "[fetchRTCConnectionInfo] startInitialization, caller: " + r100 + ", isAutoReq: " + r101);
        this.f288307c = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new RtcEngineInitManager$startInitialization$1(this, r101, r100, null), 3, null);
    }

    public final void n(Boolean r100, Map<String, String> r101) {
        if (r101 == null) goto L8;
        ArrayList r102 = new ArrayList(r101.size());
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        Map.Entry<String, String> r104 = r103.next();
        r102.add(new d78.e(r104.getKey(), r104.getValue()));
    L9:
        d78.d r105 = new d78.d(r100, r102);
        if (d78.c.a(r105) == true) goto L13;
        FLogger.f375446a.i("RtcEngineInitManager", "[updateAudioLaunchDataFromLaunch] invalid launch data");
        return;
    L13:
        this.f288310f = r105;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new RtcEngineInitManager$updateAudioLaunchDataFromLaunch$1(this, r105, null), 3, null);
        return;
    L8:
        r102 = null;
        goto L9
    }
}
