package com.ss.android.lark.audit;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.audit.network.EasyNetworkState;
import com.ss.android.lark.audit.network.NetworkTypeDetector;
import com.ss.android.lark.audit.userscope.audit.l;
import com.ss.android.lark.audit.userscope.auth.k;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.security_event.Event;
import com.ss.android.lark.utils.LarkContext;
import gwa.e;
import gwa.f;
import gwa.g;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class AuditManager {
    private static final String TAG = "AuditManager";
    public static boolean auditUserScopeFgStatus;
    private static boolean isInit;
    private l audit;
    private final ArrayList<hwa.a> authZListeners;
    private Context context;
    private g dependency;
    private boolean isRegisterNetworkListener;
    private k mAuthorizationManager;
    private lwa.a mNetworkTypeListener;
    private com.ss.android.lark.audit.userscope.audit.k process;

    public class a implements lwa.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AuditManager f409447a;

        public a(AuditManager r100) {
            this.f409447a = r100;
        }

        @Override // lwa.a
        public final void a(EasyNetworkState r100) {
            Log.i(AuditManager.TAG, "[onNetworkStateChange] currState = " + r100.toString() + ",isInit=" + AuditManager.access$000());
            if ((AuditManager.access$000() & true) == false) goto L6;
            AuditManager.access$100(this.f409447a).a(r100);
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AuditManager f409448a = null;

        static {
            f409448a = new AuditManager();
        }
    }

    public static class c implements g {
        public c() {
        }

        @Override // gwa.g
        public final /* synthetic */ g.a a() {
            return null;
        }

        @Override // gwa.g
        public final String getHost() {
            return "";
        }

        @Override // gwa.g
        public final /* synthetic */ boolean isDoubaoEnterpriseUser() {
            return false;
        }

        @Override // gwa.g
        public final /* synthetic */ void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        }

        @Override // gwa.g
        public final g.b getSecurityComplianceDependency() {
            return new f();
        }
    }

    public static /* synthetic */ void a(AuditManager r100, String r101) {
        r100.lambda$initSdk$0(r101);
    }

    private void registerNetworkListener() {
        if (this.mNetworkTypeListener != null) goto L6;
        this.mNetworkTypeListener = new a(this);
    L6:
        if (this.isRegisterNetworkListener == true) goto L45;
        this.isRegisterNetworkListener = true;
        lwa.a r100 = this.mNetworkTypeListener;
        NetworkTypeDetector.f409455b.add(r100);
        Context r101 = this.context;
        if (NetworkTypeDetector.f409454a != null) goto L10;
        NetworkTypeDetector.f409454a = new NetworkTypeDetector();
    L10:
        NetworkTypeDetector.f409458e = NetworkTypeDetector.a(r101);
        IntentFilter r102 = new IntentFilter();
        r102.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        NetworkTypeDetector r110 = NetworkTypeDetector.f409454a;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L43;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L43:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r102);
        return;
    L40:
        throw e;
    L14:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L27;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r102) == false) goto L27;
        int r103 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r102, 0, null, null, 2, r101).result;     // Catch: Exception -> L36
        if (r103 != 1) goto L20;
        r101.registerReceiver(r110, r102);     // Catch: Exception -> L36
    L42:
        return;
    L20:
        if (r103 != 2) goto L22;
        new Intent();     // Catch: Exception -> L36
        goto L42
    L22:
        if (r103 == 3) goto L42;
        r101.registerReceiver(r110, r102);     // Catch: Exception -> L36
    L27:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L30;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        r101.registerReceiver(r110, r102, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L36
        goto L42
    L30:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L32;
    L34:
        r101.registerReceiver(r110, r102);     // Catch: Exception -> L36
        goto L42
    L32:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r102) == false) goto L34;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        ContextCompat.registerReceiver(r101, r110, r102, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L36
        goto L42
    }

    public void clearData() {
        Context r100 = this.context;
        if (r100 != null) goto L6;
        return;
    L6:
        if (jwa.b.b(r100).c() == false) goto L9;
        this.mAuthorizationManager.clearData();
        return;
    }

    public g getDependency() {
        g r100 = this.dependency;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new c();
    }

    public void pullData() {
        Context r100 = this.context;
        if (r100 != null) goto L6;
        return;
    L6:
        if (jwa.b.b(r100).c() == false) goto L9;
        this.mAuthorizationManager.e();
        return;
    }

    public void pullDataFail() {
        Context r100 = this.context;
        if (r100 != null) goto L6;
        return;
    L6:
        if (jwa.b.b(r100).c() == false) goto L9;
        this.mAuthorizationManager.f();
        return;
    }

    public AuditManager() {
        this.authZListeners = new ArrayList();
    }

    public static /* synthetic */ boolean access$000() {
        return isInit;
    }

    public static AuditManager getInstance() {
        return b.f409448a;
    }

    public static boolean isInit() {
        return isInit;
    }

    public Context getContext() {
        return this.context;
    }

    public static /* synthetic */ k access$100(AuditManager r100) {
        return r100.mAuthorizationManager;
    }

    private /* synthetic */ void lambda$initSdk$0(String r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.authZListeners.size()) goto L9;
        hwa.a r102 = (hwa.a) ListProtector.get(this.authZListeners, r101);
        if (r102 == null) goto L8;
        Log.i(TAG, "onAuthorizationUpdate(), moduleName:" + r102.moduleName());
        r102.a(r100);
    L8:
        r101 = r101 + 1;
        goto L4
    }

    public void addAuthorizationUpdateListener(hwa.a r100) {
        Log.i(TAG, "addAuthorizationUpdateListener,module： " + r100.moduleName());
        this.authZListeners.add(r100);
    }

    public void auditSecurityEvent(Event r100) {
        if (isInit() == true) goto L6;
        return;
    L6:
        if (auditUserScopeFgStatus == false) goto L11;
        l r101 = this.audit;
        if (r101 == null) goto L16;
        if (r100 == null) goto L17;
        r101.Qe(r100);
        return;
    L17:
        return;
    L16:
        return;
    L11:
        com.ss.android.lark.audit.userscope.audit.k r102 = this.process;
        if (r102 == null) goto L19;
        if (r100 == null) goto L20;
        r102.Qe(r100);
        return;
    L20:
        return;
    }

    public int checkAuthority(int r100) {
        k r101 = this.mAuthorizationManager;
        if (r101 != null) goto L7;
        Log.e(TAG, "[checkAuthority 1] mAuthorizationManager is null");
        return 3;
    L7:
        return r101.c(r100);
    }

    public Pair<Integer, Integer> checkAuthorityWithErrorType(int r100) {
        k r101 = this.mAuthorizationManager;
        if (r101 != null) goto L7;
        Log.e(TAG, "[checkAuthority 1] mAuthorizationManager is null");
        return new Pair(3, 0);
    L7:
        return r101.l(r100);
    }

    public void onAppStateChangedV2(boolean r100) {
        k r101 = this.mAuthorizationManager;
        if (r101 != null) goto L6;
        Log.e(TAG, "[onAppStateChanged] mAuthorizationManager is null");
        return;
    L6:
        r101.b(r100);
    }

    public boolean removeAuthorizationUpdateListener(hwa.a r100) {
        boolean r101 = this.authZListeners.remove(r100);
        Log.e(TAG, "removeAuthorizationUpdateListener,module: " + r100.moduleName() + ",result: " + r101);
        return r101;
    }

    public void initSdk(Context r100, g r101) {
    L13:
        th = move-exception;
        Log.e(TAG, "init failed", th);
        return;
    L3:
        if (isInit == false) goto L5;
        return;
    L5:
        auditUserScopeFgStatus = idb.f.a().isEnable("lark.security.enable_audit_user_container");     // Catch: Throwable -> L13
        Context r102 = r100.getApplicationContext();     // Catch: Throwable -> L13
        this.context = r102;     // Catch: Throwable -> L13
        this.dependency = r101;     // Catch: Throwable -> L13
        if (z.e(r102) == false) goto L8;
        iwa.b.a.f496246a.a(this.context);     // Catch: Throwable -> L13
    L8:
        com.ss.android.lark.audit.userscope.audit.k r103 = (com.ss.android.lark.audit.userscope.audit.k) e0c.k.a(LarkContext.getApplication(), com.ss.android.lark.audit.userscope.audit.k.class);     // Catch: Throwable -> L13
        this.process = r103;     // Catch: Throwable -> L13
        r103.af(r101);     // Catch: Throwable -> L13
        if (auditUserScopeFgStatus == false) goto L11;
        this.audit = (l) e0c.k.a(LarkContext.getApplication(), l.class);     // Catch: Throwable -> L13
        this.process.D6();     // Catch: Throwable -> L13
    L11:
        nwa.b r104 = nwa.b.a.f521016a;     // Catch: Throwable -> L13
        r104.f521015a = this.dependency;     // Catch: Throwable -> L13
        k r105 = (k) e0c.k.a(LarkContext.getApplication(), k.class);     // Catch: Throwable -> L13
        this.mAuthorizationManager = r105;     // Catch: Throwable -> L13
        r105.d(r100, r101, new gwa.a(this));     // Catch: Throwable -> L13
        registerNetworkListener();     // Catch: Throwable -> L13
        isInit = true;     // Catch: Throwable -> L13
    }

    public int checkAuthority(int r100, int r101, String r102) {
        k r103 = this.mAuthorizationManager;
        if (r103 != null) goto L7;
        Log.e(TAG, "[checkAuthority 3] mAuthorizationManager is null");
        return 3;
    L7:
        return r103.m(r100, r101, r102);
    }

    public Pair<Integer, Integer> checkAuthorityWithErrorType(int r100, int r101, String r102) {
        k r103 = this.mAuthorizationManager;
        if (r103 != null) goto L7;
        Log.e(TAG, "[checkAuthority 3] mAuthorizationManager is null");
        return new Pair(3, 0);
    L7:
        return r103.n(r100, r101, r102);
    }

    public Pair<Integer, Integer> checkAuthorityWithErrorType(int r100, String r101, String r102) {
        k r103 = this.mAuthorizationManager;
        if (r103 != null) goto L7;
        Log.e(TAG, "[checkAuthority 3] mAuthorizationManager is null");
        return new Pair(3, 0);
    L7:
        return r103.k(r100, r101, r102);
    }

    public void checkAuthority(int r100, int r101, String r102, e r103) {
        k r104 = this.mAuthorizationManager;
        if (r104 != null) goto L8;
        Log.e(TAG, "[checkAuthority 4] mAuthorizationManager is null");
        if (r103 == null) goto L10;
        r103.a();
        return;
    L10:
        return;
    L8:
        r104.j();
    }
}
