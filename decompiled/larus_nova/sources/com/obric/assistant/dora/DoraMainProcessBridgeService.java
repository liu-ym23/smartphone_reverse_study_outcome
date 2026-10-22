package com.obric.assistant.dora;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.dora.api.IDoraObricService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0004\r\u0010\u0013\u0016\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\"\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0012\u0010 \u001a\u00020!2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\"\u001a\u00020\u0019H\u0016J\b\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\b\u0010*\u001a\u00020\u0019H\u0002J\b\u0010+\u001a\u00020\u0019H\u0002J\u0018\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020'H\u0002J\u0010\u0010/\u001a\u00020\u00192\u0006\u0010.\u001a\u00020'H\u0002J\u0010\u00100\u001a\u00020\u00192\u0006\u0010.\u001a\u00020'H\u0002J \u00101\u001a\u0002022\u0006\u0010.\u001a\u00020'2\b\u00103\u001a\u0004\u0018\u000104H\u0082@¢\u0006\u0002\u00105J\f\u00106\u001a\u000207*\u00020'H\u0002J\f\u00108\u001a\u00020'*\u000209H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006;"}, d2 = {"Lcom/obric/assistant/dora/DoraMainProcessBridgeService;", "Landroid/app/Service;", "<init>", "()V", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "privateProtocolService", "Lcom/obric/assistant/dora/IDoraPrivateProtocolService;", "isPrivateProtocolBound", "", "latestSnapshot", "Lcom/obric/assistant/dora/DoraMainProcessStateSnapshot;", "privateProtocolServiceConnection", "com/obric/assistant/dora/DoraMainProcessBridgeService$privateProtocolServiceConnection$1", "Lcom/obric/assistant/dora/DoraMainProcessBridgeService$privateProtocolServiceConnection$1;", "binder", "com/obric/assistant/dora/DoraMainProcessBridgeService$binder$1", "Lcom/obric/assistant/dora/DoraMainProcessBridgeService$binder$1;", "doraLinkCallback", "com/obric/assistant/dora/DoraMainProcessBridgeService$doraLinkCallback$1", "Lcom/obric/assistant/dora/DoraMainProcessBridgeService$doraLinkCallback$1;", "doraBudsCallback", "com/obric/assistant/dora/DoraMainProcessBridgeService$doraBudsCallback$1", "Lcom/obric/assistant/dora/DoraMainProcessBridgeService$doraBudsCallback$1;", WidgetCostModule.TYPE_ON_CREATE, "", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "onBind", "Landroid/os/IBinder;", LiveCommonConstants.REASON_ON_DEDTROY, "registerAdapterCallbacks", "unregisterAdapterCallbacks", "refreshLatestSnapshot", "getCurrentDeviceInfoFromAdapter", "Lcom/obric/assistant/dora/DoraDeviceInfo;", "bindPrivateProtocolService", "unbindPrivateProtocolService", "clearPrivateProtocolServiceReference", "syncLatestSnapshotToPrivateProtocolService", "syncConnectionStateToPrivateProtocolService", "state", "deviceInfo", "syncBatteryChangedToPrivateProtocolService", "syncChargeStateChangedToPrivateProtocolService", "executeCheckBindAndConnectIfNecessary", "Lcom/obric/assistant/dora/DoraMainProcessConnectResult;", "requestId", "", "(Lcom/obric/assistant/dora/DoraDeviceInfo;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toApiDeviceInfo", "Lcom/larus/dora/api/DoraDeviceInfo;", "toBridgeDeviceInfo", "Lcom/bytedance/dora/device/DoraDevice;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraMainProcessBridgeService extends Service {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f389070i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f389071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile IDoraPrivateProtocolService f389072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f389073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile DoraMainProcessStateSnapshot f389074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f389075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DoraMainProcessBridgeService$binder$1 f389076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f389077g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f389078h;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class b implements mj4.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraMainProcessBridgeService f389079a;

        @Override // mj4.h
        public final void J(byte[] r100) {
        }

        @Override // mj4.h
        public final /* synthetic */ void N(int r100, int r101) {
        }

        @Override // mj4.h
        public final void N0(DoraDevice r100, int[] r101) {
        }

        @Override // mj4.h
        public final /* synthetic */ void P0(DoraDevice r100, int[] r101) {
        }

        @Override // mj4.h
        public final /* synthetic */ void Y(int r100, int r101, int r102) {
        }

        @Override // mj4.h
        public final void a0(DoraDevice r100, int[] r101) {
        }

        @Override // mj4.h
        public final void a1(DoraDevice r100, mj4.b r101) {
        }

        @Override // mj4.h
        public final /* synthetic */ void d1(DoraDevice r100, int r101) {
        }

        @Override // mj4.h
        public final void e1(DoraDevice r100, int[] r101) {
        }

        @Override // mj4.h
        public final void f1(int r100, byte r101) {
        }

        @Override // mj4.h
        public final /* synthetic */ void l1(DoraDevice r100) {
        }

        @Override // mj4.h
        public final /* synthetic */ void p(int r100) {
        }

        @Override // mj4.h
        public final void u(DoraDevice r100, int r101) {
        }

        @Override // mj4.h
        public final /* synthetic */ void y(DoraDevice r100, int r101, byte[] r102) {
        }

        @Override // mj4.h
        public final /* synthetic */ void y0(DoraDevice r100, int[] r101) {
        }

        public b(DoraMainProcessBridgeService r100) {
            this.f389079a = r100;
        }

        @Override // mj4.h
        public final void D(DoraDevice r100, int[] r101) {
            DoraMainProcessBridgeService r102 = this.f389079a;
            int r103 = DoraMainProcessBridgeService.f389070i;
            r102.getClass();
            DoraDeviceInfo r104 = DoraDeviceInfo.a(DoraMainProcessBridgeService.h(r100), r101, null, 16375);
            DoraMainProcessBridgeService r105 = this.f389079a;
            int r106 = r105.f389074d.f389090a;
            Intrinsics.checkNotNullParameter(r104, "deviceInfo");
            r105.f389074d = new DoraMainProcessStateSnapshot(r106, r104);
            this.f389079a.f(r104);
        }

        @Override // mj4.h
        public final void b0(DoraDevice r100, int[] r101) {
            FLogger r102 = FLogger.f375446a;
            StringBuilder r103 = new StringBuilder("onBatteryChanged: device=");
            r103.append(r100.name);
            r103.append(", mac=");
            r103.append(r100.f204389mac);
            r103.append(", sn=");
            r103.append(r100.getSerialNumber());
            r103.append(", battery=");
            if (r101 == null) goto L5;
            String r104 = Arrays.toString(r101);
        L6:
            r103.append(r104);
            r102.i("DoraMainProcessBridge", r103.toString());
            DoraMainProcessBridgeService r105 = this.f389079a;
            int r106 = DoraMainProcessBridgeService.f389070i;
            r105.getClass();
            DoraDeviceInfo r107 = DoraDeviceInfo.a(DoraMainProcessBridgeService.h(r100), null, r101, 16367);
            DoraMainProcessBridgeService r108 = this.f389079a;
            int r109 = r108.f389074d.f389090a;
            Intrinsics.checkNotNullParameter(r107, "deviceInfo");
            r108.f389074d = new DoraMainProcessStateSnapshot(r109, r107);
            this.f389079a.e(r107);
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class c implements IDoraLinkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraMainProcessBridgeService f389080a;

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final void onBtConnectStateChanged(DoraDevice r100, int r101, int r102) {
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final void onBtStateChanged(int r100, int r101) {
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final void onDeviceFound(DoraDevice r100) {
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final void onScanFailed(int r100) {
        }

        public c(DoraMainProcessBridgeService r100) {
            this.f389080a = r100;
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final void onDoraLinkStateChanged(DoraDevice r110, int r111, int r112) {
            FLogger r100 = FLogger.f375446a;
            StringBuilder r101 = new StringBuilder("onDoraLinkStateChanged: prevState=");
            r101.append(r111);
            r101.append(", state=");
            r101.append(r112);
            r101.append(", device=");
            String r102 = null;
            if (r110 == null) goto L5;
            String r103 = r110.name;
        L6:
            r101.append(r103);
            r101.append(", mac=");
            if (r110 == null) goto L9;
            String r104 = r110.f204389mac;
        L10:
            r101.append(r104);
            r101.append(", sn=");
            if (r110 == null) goto L13;
            r102 = r110.getSerialNumber();
        L13:
            r101.append(r102);
            r100.i("DoraMainProcessBridge", r101.toString());
            if (r110 == null) goto L16;
            DoraMainProcessBridgeService r105 = this.f389080a;
            int r106 = DoraMainProcessBridgeService.f389070i;
            r105.getClass();
            DoraDeviceInfo r107 = DoraMainProcessBridgeService.h(r110);
        L17:
            DoraMainProcessBridgeService r108 = this.f389080a;
            r108.f389074d.getClass();
            Intrinsics.checkNotNullParameter(r107, "deviceInfo");
            r108.f389074d = new DoraMainProcessStateSnapshot(r112, r107);
            this.f389080a.g(r112, r107);
            return;
        L16:
            r107 = new DoraDeviceInfo(null, null, null, null, 0, 0, null, 0, 0, 0, 0, 16383);
            goto L17
        L9:
            r104 = null;
            goto L10
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class d implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraMainProcessBridgeService f389081a;

        public d(DoraMainProcessBridgeService r100) {
            this.f389081a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onBindingDied(ComponentName r100) {
            FLogger.f375446a.w("DoraMainProcessBridge", "privateProtocol onBindingDied: name=" + r100);
            DoraMainProcessBridgeService r101 = this.f389081a;
            int r102 = DoraMainProcessBridgeService.f389070i;
            r101.c();
            this.f389081a.b();
        }

        @Override // android.content.ServiceConnection
        public final void onNullBinding(ComponentName r100) {
            FLogger.f375446a.w("DoraMainProcessBridge", "privateProtocol onNullBinding: name=" + r100);
            DoraMainProcessBridgeService r101 = this.f389081a;
            int r102 = DoraMainProcessBridgeService.f389070i;
            r101.c();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            FLogger.f375446a.w("DoraMainProcessBridge", "privateProtocol onServiceDisconnected: name=" + r100);
            DoraMainProcessBridgeService r101 = this.f389081a;
            int r102 = DoraMainProcessBridgeService.f389070i;
            r101.c();
            this.f389081a.b();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            FLogger.f375446a.i("DoraMainProcessBridge", "privateProtocol onServiceConnected: name=" + r100);
            this.f389081a.f389072b = IDoraPrivateProtocolService.Stub.asInterface(r101);
            this.f389081a.f389073c = true;
            DoraMainProcessBridgeService r102 = this.f389081a;
            DoraMainProcessStateSnapshot r103 = r102.f389074d;
            r102.g(r103.f389090a, r103.f389091b);
            r102.e(r103.f389091b);
            r102.f(r103.f389091b);
        }
    }

    static {
    }

    public final void c() {
        this.f389072b = null;
        this.f389073c = false;
    }

    public final void b() {
        if (this.f389073c == false) goto L5;
        return;
    L5:
        Intent r100 = new Intent(getApplicationContext(), DoraPrivateProtocolService.class);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(getApplicationContext().bindService(r100, this.f389075e, 1)));     // Catch: Throwable -> L8
    L10:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L14;
        FLogger.f375446a.e("DoraMainProcessBridge", "bindPrivateProtocolService failed: " + r103.getMessage());
        r102 = Boolean.FALSE;
    L14:
        this.f389073c = ((Boolean) r102).booleanValue();
        FLogger.f375446a.i("DoraMainProcessBridge", "bindPrivateProtocolService: isPrivateProtocolBound=" + this.f389073c);
        return;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void d() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Integer.valueOf(kj4.a.g().getDoraState()));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = 0;
    L9:
        int r102 = ((Number) r101).intValue();
        DoraDevice r103 = kj4.a.g().c();
        if (r103 == null) goto L12;
        DoraDeviceInfo r104 = h(r103);
    L13:
        this.f389074d = new DoraMainProcessStateSnapshot(r102, r104);
        return;
    L12:
        r104 = new DoraDeviceInfo(null, null, null, null, 0, 0, null, 0, 0, 0, 0, 16383);
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // android.app.Service
    public final void onDestroy() {
        FLogger.f375446a.i("DoraMainProcessBridge", "onDestroy called");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        kj4.a r101 = kj4.a.g();     // Catch: Throwable -> L5
        r101.unregisterDoraLinkCallback(this.f389077g);     // Catch: Throwable -> L5
        r101.E(this.f389078h);     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        FLogger.f375446a.e("DoraMainProcessBridge", "unregisterAdapterCallbacks failed: " + r103.getMessage());
    L11:
        if (this.f389073c == true) goto L23;
        c();
    L21:
        CoroutineScopeKt.cancel$default(this.f389071a, null, 1, null);
        super.onDestroy();
        return;
    L23:
        getApplicationContext().unbindService(this.f389075e);     // Catch: Throwable -> L15
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L20;
        FLogger.f375446a.e("DoraMainProcessBridge", "unbindPrivateProtocolService failed: " + r105.getMessage());
    L20:
        c();
    L15:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.assistant.dora.DoraMainProcessBridgeService$binder$1] */
    public DoraMainProcessBridgeService() {
        this.f389071a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f389074d = new DoraMainProcessStateSnapshot(0, new DoraDeviceInfo(null, null, null, null, 0, 0, null, 0, 0, 0, 0, 16383));
        this.f389075e = new d(this);
        this.f389076f = new DoraMainProcessBridgeService$binder$1(this);
        this.f389077g = new c(this);
        this.f389078h = new b(this);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        FLogger r100 = FLogger.f375446a;
        r100.i("DoraMainProcessBridge", "onCreate called");
        d();
        b();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L38
        StringBuilder r102 = new StringBuilder("registerAdapterCallbacks start: doraState=");     // Catch: Throwable -> L38
        Object r103 = Result.m9449constructorimpl(Integer.valueOf(kj4.a.g().getDoraState()));     // Catch: Throwable -> L6
    L8:
        Object r104 = null;
        if (Result.m9455isFailureimpl(r103) == false) goto L11;
        r103 = null;
    L11:
        r102.append(r103);     // Catch: Throwable -> L38
        r102.append(", currentDevice=");     // Catch: Throwable -> L38
        DoraDevice r105 = kj4.a.g().c();     // Catch: Throwable -> L18
        if (r105 == null) goto L15;
        String r106 = r105.name;     // Catch: Throwable -> L18
    L16:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L18
    L21:
        if (Result.m9455isFailureimpl(r107) == false) goto L23;
        r107 = null;
    L23:
        r102.append((String) r107);     // Catch: Throwable -> L38
        r102.append(", currentMac=");     // Catch: Throwable -> L38
        DoraDevice r108 = kj4.a.g().c();     // Catch: Throwable -> L30
        if (r108 == null) goto L27;
        String r109 = r108.f204389mac;     // Catch: Throwable -> L30
    L28:
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L30
    L33:
        if (Result.m9455isFailureimpl(r110) == true) goto L36;
        r104 = r110;
    L36:
        r102.append((String) r104);     // Catch: Throwable -> L38
        r100.i("DoraMainProcessBridge", r102.toString());     // Catch: Throwable -> L38
        kj4.a r111 = kj4.a.g();     // Catch: Throwable -> L38
        r111.registerDoraLinkCallback(this.f389077g);     // Catch: Throwable -> L38
        r111.k(this.f389078h);     // Catch: Throwable -> L38
        FLogger.f375446a.i("DoraMainProcessBridge", "registerAdapterCallbacks success");     // Catch: Throwable -> L38
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L38
    L40:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L52;
        FLogger.f375446a.e("DoraMainProcessBridge", "registerAdapterCallbacks failed: " + r113.getMessage());
        return;
    L52:
        return;
    L27:
        r109 = null;
    L30:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L38
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L38
        goto L33
    L15:
        r106 = null;
    L18:
        th = move-exception;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L38
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L38
        goto L21
    L6:
        th = move-exception;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L38
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L40
    }

    public static DoraDeviceInfo h(DoraDevice r110) {
        return new DoraDeviceInfo(r110.f204389mac, r110.name, r110.state, r110.charge, r110.battery, r110.wearState, r110.idleState, r110.version, r110.type, r110.f204390sn, r110.sku, r110.mode, r110.vendorId, r110.productId);
    }

    public final void e(DoraDeviceInfo r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        IDoraPrivateProtocolService r102 = this.f389072b;     // Catch: Throwable -> L12
        if (r102 == null) goto L6;
        r102.syncBatteryChanged(r100);     // Catch: Throwable -> L12
    L6:
        FLogger r103 = FLogger.f375446a;     // Catch: Throwable -> L12
        StringBuilder r104 = new StringBuilder("syncBatteryChangedToPrivateProtocolService: mac=");     // Catch: Throwable -> L12
        r104.append(r100.f389056a);     // Catch: Throwable -> L12
        r104.append(", battery=");     // Catch: Throwable -> L12
        int[] r105 = r100.f389060e;     // Catch: Throwable -> L12
        if (r105 == null) goto L9;
        String r106 = Arrays.toString(r105);     // Catch: Throwable -> L12
    L10:
        r104.append(r106);     // Catch: Throwable -> L12
        r103.i("DoraMainProcessBridge", r104.toString());     // Catch: Throwable -> L12
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L20;
        FLogger.f375446a.e("DoraMainProcessBridge", "syncBatteryChangedToPrivateProtocolService failed: " + r108.getMessage());
        return;
    L20:
        return;
    L9:
        r106 = null;
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final void f(DoraDeviceInfo r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        IDoraPrivateProtocolService r102 = this.f389072b;     // Catch: Throwable -> L12
        if (r102 == null) goto L6;
        r102.syncChargeStateChanged(r100);     // Catch: Throwable -> L12
    L6:
        FLogger r103 = FLogger.f375446a;     // Catch: Throwable -> L12
        StringBuilder r104 = new StringBuilder("syncChargeStateChangedToPrivateProtocolService: mac=");     // Catch: Throwable -> L12
        r104.append(r100.f389056a);     // Catch: Throwable -> L12
        r104.append(", charge=");     // Catch: Throwable -> L12
        int[] r105 = r100.f389059d;     // Catch: Throwable -> L12
        if (r105 == null) goto L9;
        String r106 = Arrays.toString(r105);     // Catch: Throwable -> L12
    L10:
        r104.append(r106);     // Catch: Throwable -> L12
        r103.i("DoraMainProcessBridge", r104.toString());     // Catch: Throwable -> L12
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L20;
        FLogger.f375446a.e("DoraMainProcessBridge", "syncChargeStateChangedToPrivateProtocolService failed: " + r108.getMessage());
        return;
    L20:
        return;
    L9:
        r106 = null;
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        FLogger.f375446a.i("DoraMainProcessBridge", "onBind called with intent=" + r100);
        return this.f389076f;
    }

    public final void g(int r100, DoraDeviceInfo r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        IDoraPrivateProtocolService r103 = this.f389072b;     // Catch: Throwable -> L8
        if (r103 == null) goto L6;
        r103.syncConnectionState(r100, r101);     // Catch: Throwable -> L8
    L6:
        FLogger.f375446a.i("DoraMainProcessBridge", "syncConnectionStateToPrivateProtocolService: state=" + r100 + ", mac=" + r101.f389056a);     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L16;
        FLogger.f375446a.e("DoraMainProcessBridge", "syncConnectionStateToPrivateProtocolService failed: " + r105.getMessage());
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        int r103 = super.onStartCommand(r100, r101, r102);
        if (Intrinsics.areEqual(ObricFeatureServiceDelegate.f387839b.f(), "LowLevel") == false) goto L6;
        return 2;
    L6:
        return r103;
    }

    public static final Object a(DoraMainProcessBridgeService r110, DoraDeviceInfo r111, String r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof DoraMainProcessBridgeService$executeCheckBindAndConnectIfNecessary$1) == false) goto L7;
        DoraMainProcessBridgeService$executeCheckBindAndConnectIfNecessary$1 r100 = (DoraMainProcessBridgeService$executeCheckBindAndConnectIfNecessary$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r115 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        if (r102 == 0) goto L18;
        if (r102 != 1) goto L17;
        r112 = (String) r100.L$1;
        r111 = (DoraDeviceInfo) r100.L$0;
        ResultKt.throwOnFailure(r114);     // Catch: Throwable -> L14
    L25:
        boolean r103 = ((Boolean) r114).booleanValue();     // Catch: Throwable -> L14
        if (r103 == true) goto L28;
        boolean r104 = true;
    L29:
        Object r116 = Result.m9449constructorimpl(new DoraMainProcessConnectResult(r112, r111, r103, r103, r104, 0, null, 192));     // Catch: Throwable -> L14
    L32:
        DoraDeviceInfo r105 = r111;
        String r106 = r112;
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L36;
        r116 = new DoraMainProcessConnectResult(r106, r105, false, false, true, 2, r117.getMessage(), 28);
    L36:
        return r116;
    L28:
        r104 = false;
        goto L29
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r114);
        IDoraObricService r118 = (IDoraObricService) ServiceManager.get().getService(IDoraObricService.class);
        if (r118 != null) goto L22;
        r116 = new DoraMainProcessConnectResult(r112, r111, false, false, true, 1, "IDoraObricService unavailable", 28);
        goto L36
    L22:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L14
        t39.d r108 = new t39.d(r111.f389057b, r111.f389056a, Integer.valueOf(r111.f389069n), Integer.valueOf(r111.f389068m), null, null, r111.f389065j, 48);     // Catch: Throwable -> L14
        r100.L$0 = r111;     // Catch: Throwable -> L14
        r100.L$1 = r112;     // Catch: Throwable -> L14
        r100.label = 1;     // Catch: Throwable -> L14
        r114 = r118.a(r108, r100);     // Catch: Throwable -> L14
        if (r114 != r115) goto L25;
        return r115;
    L14:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new DoraMainProcessBridgeService$executeCheckBindAndConnectIfNecessary$1(r110, r113);
        goto L8
    }
}
