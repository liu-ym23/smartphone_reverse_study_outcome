package com.obric.aiagent.messenger;

import android.os.Bundle;
import android.provider.Settings;
import com.bytedance.bdturing.loginverify.LoginVerifyService;
import com.bytedance.privacy.bridge.IAccountBridge;
import com.bytedance.privacy.bridge.IEnvBridge;
import com.bytedance.privacy.pcc.AppInfo;
import com.bytedance.privacy.pcc.PccManager;
import com.bytedance.privacy.pseudoid.PseudoManager;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.larus.applog.api.IApplog;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.assistant.spi.common.IObricUtilService;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004*\u0004/258\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010!\u001a\u00020 H\u0096@¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u0004\u0018\u00010\u0019H\u0082@¢\u0006\u0002\u0010\"J\b\u0010$\u001a\u00020\u0017H\u0016J \u0010%\u001a\u0004\u0018\u00010\u00192\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u0004\u0018\u00010\u0019H\u0082@¢\u0006\u0002\u0010\"J\u0010\u0010+\u001a\u0004\u0018\u00010\u0019H\u0082@¢\u0006\u0002\u0010\"J\u000e\u0010,\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\"J\b\u0010-\u001a\u00020\u0017H\u0002R#\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103R\u0010\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0004\n\u0002\u00106R\u0010\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0004\n\u0002\u00109¨\u0006;"}, d2 = {"Lcom/obric/aiagent/messenger/ObricPccServiceImpl;", "Lcom/obric/aiagent/messenger/IObricPccService;", "<init>", "()V", "config", "Lcom/obric/assistant/debug/api/IObricDebugService;", "kotlin.jvm.PlatformType", "getConfig", "()Lcom/obric/assistant/debug/api/IObricDebugService;", "config$delegate", "Lkotlin/Lazy;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isRegisterListener", "", "isInit", "appInfo", "Lcom/bytedance/privacy/pcc/AppInfo;", "pseudoManager", "Lcom/bytedance/privacy/pseudoid/PseudoManager;", "pccManager", "Lcom/bytedance/privacy/pcc/PccManager;", "laneType", "", "currSessionId", "", "taskCount", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "encryptJobs", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlinx/coroutines/Deferred;", "", "init", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initInternal", "getLaneType", "tryEncryptData", "messageId", "data", "", "(Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRpDid", "getRpUid", "openSecuritySessionInternal", "fetchActiveTaskCount", "complexTaskStateListener", "com/obric/aiagent/messenger/ObricPccServiceImpl$complexTaskStateListener$1", "Lcom/obric/aiagent/messenger/ObricPccServiceImpl$complexTaskStateListener$1;", "accountBridge", "com/obric/aiagent/messenger/ObricPccServiceImpl$accountBridge$1", "Lcom/obric/aiagent/messenger/ObricPccServiceImpl$accountBridge$1;", "envBridge", "com/obric/aiagent/messenger/ObricPccServiceImpl$envBridge$1", "Lcom/obric/aiagent/messenger/ObricPccServiceImpl$envBridge$1;", "loggerBridge", "com/obric/aiagent/messenger/ObricPccServiceImpl$loggerBridge$1", "Lcom/obric/aiagent/messenger/ObricPccServiceImpl$loggerBridge$1;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPccServiceImpl implements IObricPccService {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f384772q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f384773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f384774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f384775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f384776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AppInfo f384777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PseudoManager f384778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PccManager f384779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f384780h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile String f384781i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f384782j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutexImpl f384783k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CopyOnWriteArrayList<Deferred<Unit>> f384784l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ObricPccServiceImpl$complexTaskStateListener$1 f384785m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f384786n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f384787o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d f384788p;

    public static final class a {
    }

    public static final class b implements IAccountBridge {
        public b() {
        }

        @Override // com.bytedance.privacy.bridge.IAccountBridge
        public final String onGetUDID() {
            return "";
        }

        @Override // com.bytedance.privacy.bridge.IAccountBridge
        public final void onTeaEvent(String r100, JSONObject r101) {
        }

        @Override // com.bytedance.privacy.bridge.IAccountBridge
        public final String onGetDeviceId() {
            return IApplog.f287053a.getDeviceId();
        }

        @Override // com.bytedance.privacy.bridge.IAccountBridge
        public final String onGetUserId() {
            return IApplog.f287053a.getUserID();
        }

        @Override // com.bytedance.privacy.bridge.IAccountBridge
        public final Map<String, String> onGetXttTokenMap() {
            LinkedHashMap r100 = new LinkedHashMap();
            String r101 = AccountService.f365697a.getXTTToken();
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            r100.put(LoginVerifyService.X_TT_TOKEN, r101);
            r100.put("sdk-version", "2");
            IObricUtilService r102 = (IObricUtilService) ServiceManager.get().getService(IObricUtilService.class);
            if (r102 == null) goto L8;
            Integer r103 = Integer.valueOf(r102.f());
        L9:
            r100.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, String.valueOf(r103));
            return r100;
        L8:
            r103 = null;
            goto L9
        }

        @Override // com.bytedance.privacy.bridge.IAccountBridge
        public final boolean onIsAccountLogin() {
            return AccountService.f365697a.isLogin().booleanValue();
        }
    }

    public static final class c implements IEnvBridge {
        public c() {
        }

        @Override // com.bytedance.privacy.bridge.IEnvBridge
        public final boolean onIsBoeEnv() {
            if (Settings.Global.getInt(IAppContext.f384977a.getApplication().getContentResolver(), "matrix_env_status_is_boe", 0) != 1) goto L6;
            return true;
        L6:
            return false;
        }
    }

    public static final class d implements c67.b {
        public d() {
        }

        @Override // c67.b
        public final void e(String r100, String r101) {
            FLogger.f375446a.e("ObricPccServiceImpl", "tag: " + r100 + ", msg: " + r101);
        }

        @Override // c67.b
        public final void i(String r100, String r101) {
            FLogger.f375446a.i("ObricPccServiceImpl", "tag: " + r100 + ", msg: " + r101);
        }

        @Override // c67.b
        public final void w(String r100, String r101) {
            FLogger.f375446a.w("ObricPccServiceImpl", "tag: " + r100 + ", msg: " + r101);
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.obric.aiagent.messenger.ObricPccServiceImpl$complexTaskStateListener$1] */
    public ObricPccServiceImpl() {
        this.f384773a = LazyKt.lazy(new com.obric.aiagent.messenger.d());
        this.f384774b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f384780h = 1;
        this.f384783k = kotlinx.coroutines.sync.b.a();
        this.f384784l = new CopyOnWriteArrayList();
        this.f384785m = new ObricPccServiceImpl$complexTaskStateListener$1(this);
        this.f384786n = new b();
        this.f384787o = new c();
        this.f384788p = new d();
    }

    @Override // com.obric.aiagent.messenger.IObricPccService
    public final int c() {
        return this.f384780h;
    }

    public static final int d(ObricPccServiceImpl r100) {
        r100.getClass();
        IAgentDMStateManagerIDL r101 = com.obric.aiagent.assistant.idl.f.a(Reflection.getOrCreateKotlinClass(IAgentDMStateManagerIDL.class));     // Catch: Exception -> L12
        if (r101 == null) goto L11;
        DMStateInfo r102 = r101.getCurrentDMSteate();     // Catch: Exception -> L12
        if (r102 == null) goto L11;
        List<DMTaskState> r103 = r102.getActiveTasks();     // Catch: Exception -> L12
        if (r103 == null) goto L11;
        return r103.size();
    L11:
        return 0;
    L12:
        e = move-exception;
        FLogger.f375446a.e("ObricPccServiceImpl", "fetchActiveTaskCount failed", e);
        return r100.f384782j;
    }

    @Override // com.obric.aiagent.messenger.IObricPccService
    public final Object b(Continuation<? super Unit> r100) {
        if ((r100 instanceof ObricPccServiceImpl$init$1) == false) goto L7;
        ObricPccServiceImpl$init$1 r101 = (ObricPccServiceImpl$init$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L15
    L27:
        String r107 = (String) r103;     // Catch: Throwable -> L15
        r106.unlock(null);
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        kotlinx.coroutines.sync.a r108 = r106;
        th = th;
        kotlinx.coroutines.sync.a r109 = r108;
    L32:
        r109.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r110 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r109 = r110;
    L36:
        r101.L$0 = r109;     // Catch: Throwable -> L31
        r101.label = 2;     // Catch: Throwable -> L31
        Object r111 = f(r101);     // Catch: Throwable -> L31
        if (r111 != r104) goto L26;
        return r104;
    L26:
        r106 = r109;
        r103 = r111;
    L31:
        th = th;
        goto L32
    L20:
        ResultKt.throwOnFailure(r103);
        r109 = this.f384783k;
        r101.L$0 = r109;
        r101.label = 1;
        if (r109.a(null, r101) != r104) goto L36;
        return r104;
    L7:
        r101 = new ObricPccServiceImpl$init$1(this, r100);
        goto L8
    }

    public final Object f(Continuation<? super String> r100) {
        if ((r100 instanceof ObricPccServiceImpl$initInternal$1) == false) goto L7;
        ObricPccServiceImpl$initInternal$1 r101 = (ObricPccServiceImpl$initInternal$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        Ref.ObjectRef r106 = (Ref.ObjectRef) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L19:
        return r106.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        Ref.ObjectRef r107 = new Ref.ObjectRef();
        CoroutineDispatcher r108 = Dispatchers.getIO();
        ObricPccServiceImpl$initInternal$2 r109 = new ObricPccServiceImpl$initInternal$2(this, r107, null);
        r101.L$0 = r107;
        r101.label = 1;
        if (BuildersKt.withContext(r108, r109, r101) != r104) goto L17;
        return r104;
    L17:
        r106 = r107;
    L7:
        r101 = new ObricPccServiceImpl$initInternal$1(this, r100);
        goto L8
    }

    public static final Object e(ObricPccServiceImpl r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof ObricPccServiceImpl$openSecuritySessionInternal$1) == false) goto L7;
        ObricPccServiceImpl$openSecuritySessionInternal$1 r102 = (ObricPccServiceImpl$openSecuritySessionInternal$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = false;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L22:
        if (r100.f384776d == true) goto L24;
    L45:
        FLogger.f375446a.e("ObricPccServiceImpl", "openSecuritySession failed, isInit=" + r100.f384776d + ", appInfo=" + r100.f384777e);
        return Boxing.boxBoolean(false);
    L24:
        if (r100.f384777e == null) goto L45;
    L26:
        AppInfo r108 = r100.f384777e;
        if (r108 != null) goto L29;
        FLogger.f375446a.e("ObricPccServiceImpl", "openSecuritySession failed, appInfo is null");
        return Boxing.boxBoolean(false);
    L29:
        String r109 = "omni_" + System.currentTimeMillis();
        Bundle r110 = new Bundle();
        r110.putInt(PccManager.KEY_LANE_TYPE, t1.f393353a.getObricPrivacyLaneType());
        PccManager r111 = r100.f384779g;
        if (r111 == null) goto L32;
        Bundle r112 = r111.openSecuritySession(r109, r108, r110);
    L33:
        FLogger.f375446a.i("ObricPccServiceImpl", "openSecuritySession sessionId=" + r109 + ", res=" + r112);
        if (r112 != null) goto L36;
    L38:
        boolean r113 = false;
    L39:
        if (r113 == false) goto L48;
        if (r112 == null) goto L42;
        int r114 = r112.getInt(PccManager.KEY_LANE_TYPE);
    L43:
        r100.f384780h = r114;
        r100.f384781i = r109;
        r107 = true;
        goto L48
    L42:
        r114 = 1;
    L48:
        return Boxing.boxBoolean(r107);
    L36:
        if (r112.getInt("error_code") != 0) goto L38;
        r113 = true;
        goto L39
    L32:
        r112 = null;
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r100.f384776d == true) goto L17;
    L18:
        r102.label = 1;
        if (r100.f(r102) != r105) goto L22;
        return r105;
    L17:
        if (r100.f384777e != null) goto L26;
    L7:
        r102 = new ObricPccServiceImpl$openSecuritySessionInternal$1(r100, r101);
        goto L8
    }

    @Override // com.obric.aiagent.messenger.IObricPccService
    public final Object a(String r100, byte[] r101, Continuation<? super String> r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ObricPccServiceImpl$tryEncryptData$2(this, r100, r101, null), r102);
    }
}
