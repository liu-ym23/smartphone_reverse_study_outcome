package com.ss.android.lark.audit.userscope.auth;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.passport.v1.PushPermissionResponse;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larksuite.framework.thread.n;
import com.larksuite.framework.utils.z;
import com.larus.apm.impl.protector.RunnableProtector;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.audit.AuditManager;
import com.ss.android.lark.audit.LarkAuditSettingConfig;
import com.ss.android.lark.audit.auth.ForceClearModel;
import com.ss.android.lark.audit.auth.PermissionDataWrapper;
import com.ss.android.lark.audit.utils.Trigger;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.pb.authorization.AllPermissionData;
import com.ss.android.lark.pb.authorization.CustomizedOperatePermission;
import com.ss.android.lark.pb.authorization.ExtendedOperatePermission;
import com.ss.android.lark.pb.authorization.OperatePermission;
import com.ss.android.lark.pb.authorization.PermissionType;
import com.ss.android.lark.pb.authorization.PullPermissionRequest;
import com.ss.android.lark.pb.authorization.PullPermissionResponse;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@Singleton
public final class AuthDataServiceGlobalScope implements com.ss.android.lark.passportc.api.g {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f409498t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.j f409499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PermissionDataService f409500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.h f409501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jdb.e f409502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicInteger f409503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f409504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference<String> f409505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, PermissionDataWrapper> f409506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<Integer, Boolean> f409507i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.ss.android.lark.audit.userscope.auth.e f409508j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Handler f409509k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ExecutorService f409510l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f409511m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public l f409512n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public gwa.g f409513o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Disposable f409514p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f409515q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f409516r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f409517s;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AuthDataServiceGlobalScope f409518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Trigger f409519b;

        @Override // java.lang.Runnable
        public final void run() {
            Log.i("AuditPerm_DataService", "[clearCacheAndDoRequest] runnable really start, runnableId=" + hashCode());     // Catch: Throwable -> L4
            this.f409518a.m();     // Catch: Throwable -> L4
            this.f409518a.l(0, true, this.f409519b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(AuthDataServiceGlobalScope r100, Trigger r101) {
            this.f409518a = r100;
            this.f409519b = r101;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AuthDataServiceGlobalScope f409520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f409521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f409522c;

        public c(AuthDataServiceGlobalScope r100, String r101, String r102) {
            this.f409520a = r100;
            this.f409521b = r101;
            this.f409522c = r102;
        }

        public final void a() {
            PermissionDataWrapper r100 = this.f409520a.g(this.f409521b);
            if (PermissionDataWrapper.isValid(r100) == true) goto L20;
            AuthDataServiceGlobalScope r101 = this.f409520a;
            String r102 = this.f409521b;
            r101.getClass();
            if (TextUtils.isEmpty(r102) == false) goto L7;
            nwa.b.a.f521016a.b("from_db", false);
        L10:
            PermissionDataWrapper r103 = null;
        L13:
            if (PermissionDataWrapper.isValid(r103) == false) goto L18;
            Log.i("AuditPerm_DataService", "doRequestData: pull permission from DB successfully");
            if (r103 == null) goto L17;
            AuthDataServiceGlobalScope.b(this.f409520a, r103.mUserId, r103.mAllPermissionData, r103.mVersion, false, false);
        L17:
            r100 = r103;
            goto L20
        L18:
            Log.e("AuditPerm_DataService", "doRequestData: [From DB] pull permission failed!");
            goto L20
        L7:
            PermissionDataService r104 = r101.f409500b;
            r103 = (PermissionDataWrapper) ((KVRepo) r104.f409531f.getValue()).getJSONObject(r102 + r104.f409528c, PermissionDataWrapper.class);
            if (r103 != null) goto L11;
            nwa.b.a.f521016a.b("from_db", false);
            Log.e("AuditPerm_DataService", "getFromDB: PermissionDataWrapper invalid!");
            goto L10
        L11:
            nwa.b.a.f521016a.b("from_db", PermissionDataWrapper.isValid(r103));
        L20:
            if (PermissionDataWrapper.isValid(r100) == false) goto L30;
            if (r100 == null) goto L23;
            AllPermissionData r105 = r100.mAllPermissionData;
        L25:
            if (nwa.c.b(r105) == false) goto L30;
            AuthDataServiceGlobalScope r106 = this.f409520a;
            String r107 = this.f409521b;
            r106.getClass();
            Log.i("AuditPerm_DataService", "sendDeleteMsg for " + r107);
            Message r108 = Message.obtain();
            r108.what = 2;
            Bundle r109 = new Bundle();
            r109.putString("userId", r107);
            r108.setData(r109);
            com.ss.android.lark.audit.userscope.auth.e r110 = r106.f409508j;
            if (r110 == null) goto L29;
            r110.sendMessage(r108);
        L29:
            r100 = null;
            goto L30
        L23:
            r105 = null;
        L30:
            AuthDataServiceGlobalScope r111 = this.f409520a;
            String r112 = this.f409521b;
            Intrinsics.checkNotNull(r112);
            if (r100 == null) goto L33;
            String r113 = r100.mVersion;
        L34:
            String r114 = this.f409522c;
            r111.getClass();
            LarkAppContext.Companion.getClass();
            int r115 = 1;
            if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L44;
            gwa.g r116 = r111.f409513o;
            if (r116 != null) goto L39;
        L41:
            boolean r117 = false;
        L42:
            if (r117 == true) goto L44;
            boolean r118 = true;
        L45:
            if (r118 == false) goto L48;
            Log.i("AuditPerm_DataService", "pullPermissionFromNetwork: permission pull is disabled");
        L78:
            AuthDataServiceGlobalScope r119 = this.f409520a;
            if (r119.f409502d.B0(r119.f409505g.get(), "lark.security.audit.enable_process_data_sync") == true) goto L81;
            return;
        L81:
            if (z.e(this.f409520a.h()) == false) goto L89;
            Intent r120 = new Intent("com.ss.android.lark.audit.auth.action.data_sync");
            r120.setPackage(this.f409520a.h().getPackageName());
            this.f409520a.h().sendBroadcast(r120);
            Log.i("AuditPerm_DataService", "doRequestData: send process data sync broadcast at ".concat(this.f409520a.f()));
            return;
        L89:
            return;
        L48:
            if (Intrinsics.areEqual(r112, r111.f409505g.get()) == true) goto L50;
            Log.e("AuditPerm_DataService", "pullPermissionFromNetwork: pull permission error: fail before login");
            goto L78
        L50:
            Log.i("AuditPerm_DataService", "pullPermissionFromNetwork: request start, currProcess=".concat(r111.f()));
            boolean r121 = Intrinsics.areEqual(r114, "RETRY");
            if (r121 == true) goto L53;
            r111.f409503e.set(0);
            Log.i("AuditPerm_DataService", "initiative pull，retryCount.set(0)");
        L57:
            JSONObject r122 = new JSONObject();
            xzb.a r123 = (xzb.a) ApiUtils.getApi(xzb.a.class);     // Catch: JSONException -> L63
            if (r123 == null) goto L61;
            r122.put("tenant_id", r123.getTenantId());     // Catch: JSONException -> L63
        L61:
            r122.put("triger", r114);     // Catch: JSONException -> L63
            r122.put("triger_success", 1);     // Catch: JSONException -> L63
        L65:
            Statistics.sendEvent("scs_authz_pull_permission", r122);
            Intrinsics.checkNotNullParameter(r114, "trigger");
            gwa.g r124 = AuditManager.getInstance().getDependency();     // Catch: Exception -> L68
            JSONObject r125 = new JSONObject();     // Catch: Exception -> L68
            r125.put("request_state", GearStrategyConsts.EV_SELECT_BEGIN);     // Catch: Exception -> L68
            r125.put("trigger", r114);     // Catch: Exception -> L68
            r124.getSecurityComplianceDependency().monitorEvent("scs_auth_network_monitor", r125, null, null);     // Catch: Exception -> L68
        L70:
            jwa.b.b(r111.h()).a("pull permission execute");
            PullPermissionRequest.Builder r126 = new PullPermissionRequest.Builder();
            if (com.ss.android.lark.passport.a.b() == false) goto L73;
            r115 = 172;
        L73:
            PullPermissionRequest.Builder r127 = r126.app_id(Long.valueOf(r115)).api_version("1-0");
            if (r113 != null) goto L76;
            String r128 = "";
        L77:
            PullPermissionRequest.Builder r129 = r127.perm_version(r128);
            Intrinsics.checkNotNull(r129);
            ProtoAdapter<PullPermissionResponse> r130 = PullPermissionResponse.ADAPTER;
            Command r131 = Command.POST_GATEWAY;
            com.ss.android.lark.pb.improto.Command r132 = com.ss.android.lark.pb.improto.Command.PULL_PERMISSION;
            r111.f409501c.b(r112, r132, new com.bytedance.lark.rustclient.api.d(r129, r130, r131, null, null, r132, null, 184)).a().subscribe(new f(r111, r113, r112, r114, r121), g.f409546a);
            goto L78
        L76:
            r128 = r113;
        L68:
            e = move-exception;
            Log.e("audit", "monitorAuthRequestBegin：exception is " + e);
        L63:
            e = move-exception;
            e.printStackTrace();
            goto L65
        L53:
            if (r111.f409503e.get() > 0) goto L55;
            Log.i("AuditPerm_DataService", "retryCount.get() <= 0, refuse retry action");
            goto L78
        L55:
            r111.f409503e.decrementAndGet();
            Log.i("AuditPerm_DataService", "retrycount -- , do retry action now");
            goto L57
        L39:
            if (r116.isDoubaoEnterpriseUser() != true) goto L41;
            r117 = true;
        L44:
            r118 = false;
            goto L45
        L33:
            r113 = null;
            goto L34
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AuthDataServiceGlobalScope f409523a;

        public d(AuthDataServiceGlobalScope r100) {
            this.f409523a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f409523a.l(300, true, Trigger.RETRY);     // Catch: Throwable -> L4
            jwa.b.b(this.f409523a.h()).a("retry pullPermission");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AuthDataServiceGlobalScope f409524a;

        public e(AuthDataServiceGlobalScope r100) {
            this.f409524a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            s r101 = (s) r100;
            AuthDataServiceGlobalScope r102 = this.f409524a;
            jwa.b.b(r102.h()).a("receive PUSH_PERMISSION");
            Log.i("AuditPerm_DataService", "received push event");
            r102.l(300, true, Trigger.PUSH);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserChanged(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOnline(f0c.f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOnline(f0c.f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    public final Context h() {
        return (Context) this.f409504f.getValue();
    }

    public final AllPermissionData i() {
        String r100 = this.f409505g.get();
        if (TextUtils.isEmpty(r100) == false) goto L6;
        Log.w("AuditPerm_DataService", "getPermissionData but userId is null");
        return null;
    L6:
        PermissionDataWrapper r101 = g(r100);
        if (PermissionDataWrapper.isValid(r101) == true) goto L10;
        Log.w("AuditPerm_DataService", "getPermissionData but PermissionDataWrapper is invalid");
        return null;
    L10:
        if (r101 != null) goto L12;
        return null;
    L12:
        return r101.mAllPermissionData;
    }

    public final boolean j() {
        boolean r100 = this.f409502d.B0(this.f409505g.get(), "lark.passport.security.auth_by_ip");
        Log.i("AuditPerm_DataService", "isEnableAuthByIP =" + r100);
        return r100;
    }

    public final void m() {
        Log.i("AuditPerm_DataService", "sendDeleteAllMsg begin");
        Message r100 = Message.obtain();
        r100.what = 3;
        r100.setData(new Bundle());
        com.ss.android.lark.audit.userscope.auth.e r101 = this.f409508j;
        if (r101 == null) goto L6;
        r101.sendMessage(r100);
        return;
    }

    public final String f() {
        String r100 = z.b(h());
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.ss.android.lark.passportc.api.g
    public final com.ss.android.lark.passportc.api.j getPassport() {
        return this.f409499a;
    }

    public final void d(String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L10:
        if (r100 == false) goto L13;
        Log.d("AuditPerm_DataService", "userId invalid");
        return;
    L13:
        PermissionDataWrapper r101 = (PermissionDataWrapper) ((ConcurrentHashMap) this.f409506h).get(r110);
        if (r101 != null) goto L17;
        Log.d("AuditPerm_DataService", "permission data is null");
        return;
    L17:
        AllPermissionData r102 = r101.mAllPermissionData;
        if (r102 != null) goto L21;
        Log.d("AuditPerm_DataService", "AllPermissionData data is null");
        return;
    L21:
        ArrayList r103 = new ArrayList();
        List<OperatePermission> r104 = r102.moperate_permission_data;
        if (r104 == null) goto L31;
        Iterator<OperatePermission> r105 = r104.iterator();
    L25:
        if (r105.hasNext() == false) goto L31;
        OperatePermission r106 = r105.next();
        PermissionType r107 = r106.mperm_type;
        if (r107 == null) goto L25;
        Boolean r108 = Boolean.FALSE;
        Map<Integer, Boolean> r109 = this.f409507i;
        ConcurrentHashMap r111 = (ConcurrentHashMap) r109;
        if (Intrinsics.areEqual(r108, r111.get(Integer.valueOf(r107.getValue()))) == false) goto L25;
        Intrinsics.checkNotNull(r106);
        r103.add(r106);
    L31:
        ArrayList r112 = new ArrayList();
        List<ExtendedOperatePermission> r113 = r102.mextended_operate_permission_data;
        if (r113 == null) goto L41;
        Iterator<ExtendedOperatePermission> r114 = r113.iterator();
    L35:
        if (r114.hasNext() == false) goto L41;
        ExtendedOperatePermission r115 = r114.next();
        PermissionType r116 = r115.mperm_type;
        if (r116 == null) goto L35;
        Boolean r117 = Boolean.FALSE;
        Map<Integer, Boolean> r118 = this.f409507i;
        ConcurrentHashMap r119 = (ConcurrentHashMap) r118;
        if (Intrinsics.areEqual(r117, r119.get(Integer.valueOf(r116.getValue()))) == false) goto L35;
        Intrinsics.checkNotNull(r115);
        r112.add(r115);
    L41:
        ArrayList r120 = new ArrayList();
        List<CustomizedOperatePermission> r121 = r102.mcustomized_operate_permission_data;
        if (r121 == null) goto L51;
        Iterator<CustomizedOperatePermission> r122 = r121.iterator();
    L45:
        if (r122.hasNext() == false) goto L51;
        CustomizedOperatePermission r123 = r122.next();
        PermissionType r124 = r123.mperm_type;
        if (r124 == null) goto L45;
        Boolean r125 = Boolean.FALSE;
        Map<Integer, Boolean> r126 = this.f409507i;
        ConcurrentHashMap r127 = (ConcurrentHashMap) r126;
        if (Intrinsics.areEqual(r125, r127.get(Integer.valueOf(r124.getValue()))) == false) goto L45;
        Intrinsics.checkNotNull(r123);
        r120.add(r123);
    L51:
        PermissionDataWrapper r128 = new PermissionDataWrapper(r110, "", new AllPermissionData.Builder().update_time(r102.mupdate_time).expire_time(r102.mexpire_time).operate_permission_data(r103).extended_operate_permission_data(r112).customized_operate_permission_data(r120).build());
        ((ConcurrentHashMap) this.f409506h).put(r110, r128);
        this.f409510l.execute(new com.ss.android.lark.audit.userscope.auth.c(true, this, r128));
        return;
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L10
    }

    public final boolean e(String r100) {
        String r101 = this.f409505g.get();
        if (TextUtils.isEmpty(r101) == false) goto L6;
        Log.e("AuditPerm_DataService", "doRequestData: empty userId");
        return false;
    L6:
        this.f409510l.execute(new c(this, r101, r100));
        return true;
    }

    public final PermissionDataWrapper g(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        nwa.b.a.f521016a.b("from_memory", false);
        return null;
    L6:
        PermissionDataWrapper r101 = (PermissionDataWrapper) ((ConcurrentHashMap) this.f409506h).get(r100);
        nwa.b.a.f521016a.b("from_memory", PermissionDataWrapper.isValid(r101));
        return r101;
    }

    public final void n(String r110) {
        String r100 = this.f409505g.get();
        AtomicReference<String> r101 = this.f409505g;
        if (r110 != null) goto L5;
        String r102 = "";
    L6:
        r101.set(r102);
        if (r110 != null) goto L11;
        Disposable r103 = this.f409514p;
        if (r103 == null) goto L11;
        r103.dispose();
    L11:
        if (r110 == null) goto L45;
        Intrinsics.checkNotNull(r100);
        if (r100.length() != 0) goto L15;
        boolean r104 = true;
    L16:
        boolean r105 = !TextUtils.equals(r110, r100);
        String r106 = r110.concat("_AuthoritySDK_strictMode");
        String r107 = r110.hashCode() + "_AuthoritySDK_strictMode";
        byte[] r108 = r106.getBytes();
        MessageDigest r109 = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L25
        r109.update(r108);     // Catch: NoSuchAlgorithmException -> L25
        byte[] r111 = r109.digest();     // Catch: NoSuchAlgorithmException -> L25
        StringBuilder r112 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L25
        int r113 = r111.length;     // Catch: NoSuchAlgorithmException -> L25
        int r114 = 0;
    L18:
        if (r114 >= r113) goto L23;
        String r115 = Integer.toHexString(r111[r114] & UByte.MAX_VALUE);     // Catch: NoSuchAlgorithmException -> L25
        if (r115.length() != 1) goto L22;
        r112.append("0");     // Catch: NoSuchAlgorithmException -> L25
    L22:
        r112.append(r115);     // Catch: NoSuchAlgorithmException -> L25
        r114 = r114 + 1;     // Catch: NoSuchAlgorithmException -> L25
        goto L18
    L23:
        r107 = r112.toString();     // Catch: NoSuchAlgorithmException -> L25
    L26:
        this.f409515q = r107;
        Log.i("AuditPerm_DataService", "setUserId: changed=" + r105 + ", userId=" + r110);
        if (r105 == false) goto L46;
        PermissionDataService r116 = this.f409500b;
        String r117 = this.f409515q;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r117, "userIdEncrypt");
        ForceClearModel r118 = (ForceClearModel) ((KVRepo) r116.f409532g.getValue()).getJSONObject(r116.f409530e + r117, ForceClearModel.class);
        if (r118 == null) goto L32;
        ((ConcurrentHashMap) this.f409507i).putAll(r118.getForceClearMap());
    L32:
        if (j() == false) goto L34;
        c(r104, Trigger.UID_CHANGE);
    L35:
        Disposable r119 = this.f409514p;
        if (r119 == null) goto L38;
        r119.dispose();
    L38:
        this.f409514p = this.f409501c.g(r110, Command.PUSH_PERMISSION, PushPermissionResponse.RAW_TYPE_ADAPTER).subscribe(new e(this));
        return;
    L34:
        l(300, false, Trigger.UID_CHANGE);
        goto L35
    L46:
        return;
    L25:
        Log.e("AuditPerm_Crypt", "Algorithm not found");
        goto L26
    L15:
        r104 = false;
        goto L16
    L45:
        return;
    L5:
        r102 = r110;
        goto L6
    }

    public final void c(boolean r100, Trigger r101) {
        Log.i("AuditPerm_DataService", "[clearCacheAndDoRequest] start， fromLaunch: " + r100);
        b r102 = new b(this, r101);
        if (r100 == false) goto L5;
        long r103 = 0;
    L6:
        this.f409509k.postDelayed(r102, r103);
        return;
    L5:
        r103 = 1000;
        goto L6
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserChanged(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
        Log.i("AuditPerm_DataService", "onUserChanged");
        f0c.g r102 = r101.a();
        if (r102 == null) goto L7;
        User r103 = r102.f475033a;
        if (r103 == null) goto L7;
        String r104 = r103.userId;
    L8:
        n(r104);
        return;
    L7:
        r104 = null;
        goto L8
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r100, AuthDataServiceGlobalScope$init$receiver$1 r110, IntentFilter r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L40:
    L34:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r111, 4);
        return;
    L39:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L23;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L23;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r111, 4, null, null, 3, r100).result;     // Catch: Exception -> L34
        if (r101 != 1) goto L13;
        r100.registerReceiver(r110, r111, 4);     // Catch: Exception -> L34
        return;
    L13:
        if (r101 != 2) goto L15;
        new Intent();     // Catch: Exception -> L34
        return;
    L15:
        if (r101 == 3) goto L41;
        r100.registerReceiver(r110, r111, 4);     // Catch: Exception -> L34
        return;
    L41:
        return;
    L23:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L27;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L34
        r100.registerReceiver(r110, r111, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L34
        return;
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L29;
    L32:
        r100.registerReceiver(r110, r111, 4);     // Catch: Exception -> L34
        return;
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r111) == false) goto L32;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L34
        ContextCompat.registerReceiver(r100, r110, r111, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L34
    }

    public final void l(long r100, boolean r101, Trigger r102) {
        Intrinsics.checkNotNullParameter(r102, "pullTrigger");
        Log.i("AuditPerm_DataService", "requestRefresh delayMills: " + r100 + ",forceUpdate：" + r101 + ",pullTrigger:" + r102.name());
        Object r103 = h().getSystemService("connectivity");     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L9
        NetworkInfo r104 = ((ConnectivityManager) r103).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r104 != null) goto L6;
    L7:
        Log.i("AuditPerm_DataService", "isNetWorkAvailable() return false");     // Catch: Exception -> L9
        boolean r105 = false;
    L12:
        if (r105 == true) goto L14;
        Log.i("AuditPerm_DataService", "network not available");
    L14:
        Message r106 = Message.obtain();
        r106.what = 0;
        r106.getData().putBoolean("forceUpdate", r101);
        r106.getData().putString("pullTrigger", r102.name());
        if (r100 <= 0) goto L19;
        com.ss.android.lark.audit.userscope.auth.e r107 = this.f409508j;
        if (r107 == null) goto L25;
        r107.sendMessageDelayed(r106, r100);
        return;
    L25:
        return;
    L19:
        com.ss.android.lark.audit.userscope.auth.e r108 = this.f409508j;
        if (r108 == null) goto L27;
        r108.sendMessage(r106);
        return;
    L27:
        return;
    L6:
        if (r104.isAvailable() == false) goto L7;
    L11:
        Log.i("AuditPerm_DataService", "isNetWorkAvailable() return true");
        r105 = true;
    L9:
        e = move-exception;
        Log.e("AuditPerm_DataService", String.valueOf(e.getMessage()));
        goto L11
    }

    @Inject
    public AuthDataServiceGlobalScope(com.ss.android.lark.passportc.api.j r100, PermissionDataService r101, com.bytedance.lark.rustclient.api.h r102, jdb.e r103) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "permissionDataService");
        Intrinsics.checkNotNullParameter(r102, "globalRustService");
        Intrinsics.checkNotNullParameter(r103, "globalFGService");
        this.f409499a = r100;
        this.f409500b = r101;
        this.f409501c = r102;
        this.f409502d = r103;
        this.f409503e = new AtomicInteger(0);
        this.f409504f = LazyKt.lazy(AuthDataServiceGlobalScope$mContext$2.INSTANCE);
        this.f409505g = new AtomicReference("");
        this.f409506h = new ConcurrentHashMap();
        this.f409507i = new ConcurrentHashMap();
        this.f409509k = new Handler(Looper.getMainLooper());
        this.f409510l = PThreadExecutorsUtils.newSingleThreadExecutor(new n("AuditPerm_DataService_Task_Executor"));
        this.f409515q = "";
    }

    public final void k(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        Intrinsics.checkNotNullParameter(r102, "requestUserId");
        Log.e("AuditPerm_DataService", "[From Network]: pull permission errorCode: " + r100 + "，errMsg: " + r101);
        nwa.b.a.f521016a.d("audit_pull_permission", false, r100, r101);
        if (Intrinsics.areEqual(r100, "10008") == false) goto L6;
        int r104 = 1;
    L9:
        this.f409517s = r104;
        LarkAuditSettingConfig r105 = (LarkAuditSettingConfig) SettingManager.getInstance().get(LarkAuditSettingConfig.class);
        if (r105 != null) goto L12;
        r105 = new LarkAuditSettingConfig();
    L12:
        Log.i("AuditPerm_DataService", "LarkAuditSettingConfig.authzRetry is : " + r105.authzRetry);
        if (r105.authzRetry == false) goto L22;
        if (r103 == true) goto L16;
        this.f409503e.set(r105.authzRetryCount);
        Log.i("AuditPerm_DataService", "set retryCount: " + r105.authzRetryCount);
    L16:
        Log.i("AuditPerm_DataService", "retryCount = " + this.f409503e.get());
        if (this.f409503e.get() <= 0) goto L23;
        Log.i("AuditPerm_DataService", "retryCount.get() > 0， do retry action after " + r105.authzRetryDelay);
        com.ss.android.lark.audit.userscope.auth.e r106 = this.f409508j;
        if (r106 == null) goto L24;
        r106.postDelayed(new d(this), r105.authzRetryDelay);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L6:
        if (Intrinsics.areEqual(r100, "10009") == false) goto L8;
        r104 = 2;
        goto L9
    L8:
        r104 = 3;
        goto L9
    }

    public static final void b(AuthDataServiceGlobalScope r100, String r101, AllPermissionData r102, String r103, boolean r104, boolean r105) {
        r100.getClass();
        Log.i("AuditPerm_DataService", "sendUpdateDataMsg for " + r101);
        Message r106 = Message.obtain();
        r106.what = 1;
        r106.obj = new PermissionDataWrapper(r101, r103, r102);
        Bundle r107 = new Bundle();
        r107.putBoolean("fromNetwork", r104);
        r107.putBoolean("clearOld", r105);
        r106.setData(r107);
        com.ss.android.lark.audit.userscope.auth.e r108 = r100.f409508j;
        if (r108 == null) goto L6;
        r108.sendMessage(r106);
        return;
    }
}
