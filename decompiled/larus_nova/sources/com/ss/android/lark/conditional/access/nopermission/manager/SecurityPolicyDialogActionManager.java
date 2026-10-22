package com.ss.android.lark.conditional.access.nopermission.manager;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.lark.pb.security.v1.CustomDisplayConfig;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.bytedance.lark.pb.security.v1.CustomDisplayTemplate;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.auth.v2.SecurityPolicyAuthManager;
import com.ss.android.lark.conditional.access.display.DisplayUtilsKt;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.params.SecurityActionHandleContext;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes35.dex */
public final class SecurityPolicyDialogActionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SecurityPolicyDialogActionManager f418129a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CompositeDisposable f418130b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final StateFlowImpl f418131c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b1 f418132d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<Application.ActivityLifecycleCallbacks> f418133e = null;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/manager/SecurityPolicyDialogActionManager$FilePolicyDialogType;", "", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public @interface FilePolicyDialogType {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f418134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InternalSecurityAction f418135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f418136c;

        public final int getType() {
            return this.f418134a;
        }

        public a(int r100, InternalSecurityAction r101) {
            Intrinsics.checkNotNullParameter(r101, "action");
            this.f418134a = r100;
            this.f418135b = r101;
        }
    }

    public static final class b<T1, T2> implements ttc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T1, T2> f418137a = null;

        static {
            f418137a = new b();
        }

        public b() {
        }

        @Override // ttc.a
        public final void accept(Object r100, Object r101) {
            Boolean r102 = (Boolean) r100;
            Throwable r103 = (Throwable) r101;
            SecurityPolicyDialogActionManager.f418129a.getClass();
            SecurityPolicyDialogActionManager.b();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f418138a;

        public c(Object r100) {
            this.f418138a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Disposable r101 = (Disposable) r100;
            ((Handler) SecurityDialogUtil.f418126d.getValue()).postAtTime(k.f418182a, this.f418138a, ((long) 100) + SystemClock.uptimeMillis());
            Intrinsics.checkNotNullParameter(new AtomicBoolean(true), "<set-?>");
        }
    }

    public static final class d<T1, T2> implements ttc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f418139a;

        public d(Object r100) {
            this.f418139a = r100;
        }

        @Override // ttc.a
        public final void accept(Object r100, Object r101) {
            CustomDisplayConfig r102 = (CustomDisplayConfig) r100;
            Throwable r103 = (Throwable) r101;
            ((Handler) SecurityDialogUtil.f418126d.getValue()).removeCallbacksAndMessages(this.f418139a);
            Intrinsics.checkNotNullParameter(new AtomicBoolean(false), "<set-?>");
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f418140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InternalSecurityAction f418141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f418142c;

        public e(String r100, InternalSecurityAction r101, int r102) {
            this.f418140a = r100;
            this.f418141b = r101;
            this.f418142c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            CustomDisplayConfig r101 = (CustomDisplayConfig) r100;
            String r102 = this.f418140a;
            InternalSecurityAction r103 = this.f418141b;
            int r104 = this.f418142c;
            String r105 = qqb.a.d();     // Catch: Throwable -> L13
            qqb.a.f(r102);     // Catch: Throwable -> L11
            if (r101 == null) goto L9;
            CustomDisplayTemplate r106 = r101.template;     // Catch: Throwable -> L11
            if (r106 == null) goto L9;
            CustomDisplayTemplate r107 = DisplayUtilsKt.e(r106, r103);     // Catch: Throwable -> L11
            r103.getInternalParams().put("displayModel", r107);     // Catch: Throwable -> L11
            SecurityPolicyDialogActionManager.e(SecurityPolicyDialogActionManager.f418129a, r104, r103);     // Catch: Throwable -> L11
        L9:
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r105, "traceId");
            qqb.a.g(r105);
            return;
        L11:
            th = th;
        L15:
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r105, "traceId");
            qqb.a.g(r105);
            throw th;
        L13:
            th = th;
            r105 = "";
            goto L15
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f418143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f418144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f418145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ InternalSecurityAction f418146d;

        public f(String r100, String r101, int r102, InternalSecurityAction r103) {
            this.f418143a = r100;
            this.f418144b = r101;
            this.f418145c = r102;
            this.f418146d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            String r100 = "";
            Throwable r111 = (Throwable) r110;
            String r101 = this.f418143a;
            String r102 = this.f418144b;
            int r103 = this.f418145c;
            InternalSecurityAction r104 = this.f418146d;
            String r105 = qqb.a.d();     // Catch: Throwable -> L18
            qqb.a.f(r101);     // Catch: Throwable -> L16
            if ((r111 instanceof TimeoutException) == true) goto L8;
            int r106 = ScsLogger.f440428a;     // Catch: Throwable -> L16
            ScsLogger.c("SecurityPolicy_SecurityPolicyDialogActionManager", String.valueOf(r111.getMessage()));     // Catch: Throwable -> L16
        L10:
            ScsLogger.c("SecurityPolicy_SecurityPolicyDialogActionManager", "getDisplayModelById error!");     // Catch: Throwable -> L16
            if (r103 != 92) goto L13;
            Map<String, Object> r112 = r104.getInternalParams();     // Catch: Throwable -> L16
            CustomDisplayTemplate.Builder r107 = new CustomDisplayTemplate.Builder();     // Catch: Throwable -> L16
            LarkAppContext.Companion.getClass();     // Catch: Throwable -> L16
            r112.put("displayModel", r107.title(UIUtils.getString(LarkAppContext.access$getInstance$cp().getContext(), R.string.Lark_PolicyCenter_OperationNotPossible_PopupTitle)).text(UIUtils.getString(LarkAppContext.access$getInstance$cp().getContext(), R.string.Lark_PolicyCenter_ContactOrganizationAdministrator_PopupBody)).handler_list(CollectionsKt.listOf(new CustomDisplayHandler(UIUtils.getString(LarkAppContext.access$getInstance$cp().getContext(), R.string.Lark_PolicyCenter_IUnderstand_Button), "Cancel", "", MapsKt.emptyMap(), MapsKt.emptyMap()))).build());     // Catch: Throwable -> L16
            SecurityPolicyDialogActionManager.e(SecurityPolicyDialogActionManager.f418129a, r103, r104);     // Catch: Throwable -> L16
        L14:
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r105, "traceId");
            qqb.a.g(r105);
            return;
        L13:
            SecurityDialogUtil.b(r104);     // Catch: Throwable -> L16
            goto L14
        L8:
            FileAuthMonitor.e(302, "");     // Catch: Throwable -> L16
            LarkAppContext.Companion.getClass();     // Catch: Throwable -> L16
            ((com.ss.android.lark.conditional.access.display.g) e0c.k.a(LarkAppContext.access$getInstance$cp().getContext(), com.ss.android.lark.conditional.access.display.g.class)).S5(CollectionsKt.listOf(r102), true);     // Catch: Throwable -> L16
        L16:
            th = th;
            r100 = r105;
        L19:
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r100, "traceId");
            qqb.a.g(r100);
            throw th;
        L18:
            th = th;
            goto L19
        }
    }

    public SecurityPolicyDialogActionManager() {
    }

    static {
        f418129a = new SecurityPolicyDialogActionManager();
        f418130b = new CompositeDisposable();
        StateFlowImpl r100 = j1.a(null);
        f418131c = r100;
        f418132d = kotlinx.coroutines.flow.e.b(r100);
        f418133e = LazyKt.lazy(SecurityPolicyDialogActionManager$activityLifecycleCallback$1.INSTANCE);
    }

    public static void b() {
        String r100 = "SecurityPolicy_SecurityPolicyDialogActionManager";
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "exitDialog.");
        StateFlowImpl r101 = f418131c;
        a r102 = (a) r101.getValue();
        SecurityPolicyAuthManager r103 = null;
        if (r102 == null) goto L5;
        InternalSecurityAction r104 = r102.f418135b;
    L6:
        r101.setValue(null);
        WeakReference<Dialog> r105 = SecurityDialogUtil.f418123a;
        if (r104 == null) goto L76;
        Object r106 = r104.getInternalParams().get("filePolicyModelsSnapshot");
        if ((r106 instanceof List) == false) goto L12;
        List r107 = (List) r106;
    L13:
        if (r107 == null) goto L73;
        ArrayList r108 = new ArrayList();
        Iterator r109 = r107.iterator();
    L16:
        if (r109.hasNext() == false) goto L20;
        Object r110 = r109.next();
        if ((r110 instanceof PolicyModel) == false) goto L16;
        r108.add(r110);
        goto L16
    L20:
        SecurityActionHandleContext r111 = r104.getHandleContext();
        if (r111 == null) goto L77;
        String r112 = r111.getPointKey();
        if (r112 == null) goto L78;
        String r113 = r104.getTraceId();
        boolean r114 = true;
        if (r113.length() <= 0) goto L29;
        boolean r115 = true;
    L30:
        if (r115 == true) goto L33;
        r113 = null;
    L33:
        if (r113 == null) goto L36;
        r100 = r113;
    L36:
        int r116 = h8b.a.f484297a;
        com.ss.android.lark.conditional.access.auth.v2.z.f417940a.getClass();
        com.ss.android.lark.conditional.access.auth.v2.a0 r117 = com.ss.android.lark.conditional.access.auth.v2.z.f417942c;
        if (r117 == null) goto L42;
        com.ss.android.lark.conditional.access.auth.v2.f r118 = r117.f417776b;
        if (r118 == null) goto L42;
        r103 = r118.f417795b;
    L42:
        if (r103 == null) goto L48;
        Intrinsics.checkNotNullParameter(r108, "policyModels");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator r120 = r108.iterator();
    L45:
        if (r120.hasNext() == false) goto L47;
        PolicyModel r121 = (PolicyModel) r120.next();
        r121.setConfig(new PolicyModel.a(r103.b(r121)));
        r119.add(r121);
        goto L45
    L47:
        ((i8b.m) r103.f417762o.getValue()).h(r119);
        int r122 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_SecurityPolicyAuthManager", "removeCaches success, clearCount: " + r119.size() + ", traceId: " + r100);
    L48:
        String r123 = r111.getCacheHitTaskId();
        String r124 = r111.getCacheType();
        if (r123 != null) goto L51;
    L54:
        boolean r125 = true;
    L56:
        if (r125 == true) goto L65;
        if (r124 != null) goto L59;
    L62:
        if (r114 == true) goto L65;
        if (r103 == null) goto L74;
        Intrinsics.checkNotNullParameter(r123, com.heytap.mcssdk.constant.b.f276354d);
        Intrinsics.checkNotNullParameter(r124, "cacheType");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        ((i8b.m) r103.f417762o.getValue()).g(r123, r124, r112);
        int r126 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_SecurityPolicyAuthManager", "removeCache success, pointKey: " + r112 + ", taskID: " + r123 + ", cacheType: " + r124 + ", traceId: " + r100);
        return;
    L74:
        return;
    L59:
        if (r124.length() == 0) goto L62;
        r114 = false;
    L65:
        int r127 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_CustomDisplayModel", "dialog clear current cache skipped, pointKey: " + r112 + ", cacheHitTaskId: " + r123 + ", cacheType: " + r124);
        return;
    L51:
        if (r123.length() == 0) goto L54;
        r125 = false;
        goto L56
    L29:
        r115 = false;
        goto L30
    L78:
        return;
    L77:
        return;
    L73:
        return;
    L12:
        r107 = null;
        goto L13
    L76:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static void a(Activity r100) {
        int r101 = ScsLogger.f440428a;
        StringBuilder r102 = new StringBuilder("dialog apply:");
        Boolean r103 = null;
        if (r100 == null) goto L5;
        String r104 = r100.getClass().getSimpleName();
    L6:
        r102.append(r104);
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", r102.toString());
        Lazy<Application.ActivityLifecycleCallbacks> r105 = f418133e;
        if (r105.isInitialized() == true) goto L9;
        LarkContext.getApplication().registerActivityLifecycleCallbacks(r105.getValue());
    L9:
        if (r100 != null) goto L11;
    L13:
        boolean r106 = false;
        if ((r100 instanceof AppCompatActivity) == true) goto L16;
    L29:
        StateFlowImpl r107 = f418131c;
        if (r107.getValue() == null) goto L45;
        if (r100 == null) goto L40;
        a r108 = (a) r107.getValue();
        if (r108 == null) goto L39;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r108.f418136c != null) goto L38;
        long r109 = System.currentTimeMillis();
        Intent r110 = new Intent(r100, SecurityPolicyPopupWindowActivity.class);
        r110.putExtra("mark", r109);
        r100.startActivity(r110);
        r106 = true;
    L38:
        r103 = Boolean.valueOf(r106);
    L39:
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "start new activity to show dialog, " + r103);
        return;
    L40:
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "start new activity to show dialog null");
        return;
    L45:
        return;
    L16:
        if ((r100 instanceof SecurityPolicyPopupWindowActivity) == true) goto L18;
        int r111 = g8b.b.f480460a;
        g8b.b.a.a().getDependency().l(r100);
        goto L29
    L18:
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "add dialog to ".concat(r100.getClass().getSimpleName()));
        a r112 = (a) f418132d.getValue();
        AppCompatActivity r113 = (AppCompatActivity) r100;
        Fragment r114 = r113.getSupportFragmentManager().findFragmentByTag("sec_dlg");
        if (r112 == null) goto L42;
        if (r114 == null) goto L22;
        return;
    L22:
        if (r113.isDestroyed() == true) goto L44;
        FragmentTransaction r115 = r113.getSupportFragmentManager().beginTransaction();
        SecurityPolicyDialogFragment r116 = new SecurityPolicyDialogFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r115, r116, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "sec_dlg", 0) == true) goto L27;
        r115 = r115.add(r116, "sec_dlg");
    L27:
        r115.commitAllowingStateLoss();
        return;
    L44:
        return;
    L42:
        return;
    L11:
        if (w4c.c.a().X() == false) goto L13;
        int r117 = g8b.b.f480460a;
        g8b.b.a.a().getDependency().i(r100);
        goto L13
    L5:
        r104 = null;
        goto L6
    }

    public static void c(final InternalSecurityAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        int r101 = g8b.b.f480460a;
        t4c.a.b(t4c.a.a(g8b.b.a.a().getDependency().c()).doOnEvent(b.f418137a), f418130b, new SecurityPolicyDialogActionManager$getDeviceDeclareSwitch$2(r100), new SecurityPolicyDialogActionManager$getDeviceDeclareSwitch$3(r100));
    }

    public final void d(@FilePolicyDialogType int r100, InternalSecurityAction r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        String r102 = r101.getCurrentAction().getParams().get("entity_operation");
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        int r103 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "[start show dialog], handleFilePolicyAction(), operation:" + r102 + ", dialogType is " + r100);
        f(r100, r101);
    }

    public final void f(int r100, InternalSecurityAction r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        String r102 = qqb.a.d();
        Object r103 = r101.getInternalParams().get("comeFrom");
        if (r103 != null) goto L5;
        r103 = "SDK_INTERNAL";
    L5:
        String r104 = (String) r103;
        int r105 = g8b.b.f480460a;
        if (g8b.b.a.a().j() == false) goto L10;
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "startPopupDialog(), NoPermissionModuleManager.getCurrentUnauthorizedType() != null");
        FileAuthMonitor.UpdateTrigger[] r106 = FileAuthMonitor.f418450a;
        FileAuthMonitor.o(r104, r101.toString(), "inNoAccessStatus");
        return;
    L10:
        if (f418131c.getValue() == null) goto L13;
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "dialog already exist");
        FileAuthMonitor.UpdateTrigger[] r107 = FileAuthMonitor.f418450a;
        FileAuthMonitor.o(r104, r101.toString(), "dialogAlreadyExist");
        return;
    L13:
        String r108 = r101.getCurrentAction().getParams().get("policyType");
        if (Intrinsics.areEqual(r108, "POLICY_CENTER") == true) goto L16;
        int r109 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "snapshot skipped, not policy center, policyType: " + r108);
    L26:
        boolean r110 = false;
        if (ArraysKt.contains(new Integer[]{9, 92}, Integer.valueOf(r100)) == true) goto L29;
        e(this, r100, r101);
        return;
    L29:
        String r111 = r101.getCurrentAction().getParams().get("displayID");
        if (r111 != null) goto L32;
    L33:
        r110 = true;
    L34:
        if (r110 == false) goto L37;
        ScsLogger.c("SecurityPolicy_SecurityPolicyDialogActionManager", "displayID is empty!");
        FileAuthMonitor.UpdateTrigger[] r112 = FileAuthMonitor.f418450a;
        FileAuthMonitor.e(101, r101.toString());
        SecurityDialogUtil.b(r101);
        return;
    L37:
        Object r113 = new Object();
        if (w4c.c.a().Q() == false) goto L40;
        LarkAppContext.Companion.getClass();
        Single<? extends CustomDisplayConfig> r114 = ((com.ss.android.lark.conditional.access.display.g) e0c.k.a(LarkAppContext.access$getInstance$cp().getContext(), com.ss.android.lark.conditional.access.display.g.class)).Ld(r111, r102);
    L41:
        r114.doOnSubscribe(new c(r113)).doOnEvent(new d(r113)).subscribe(new e(r102, r101, r100), new f(r102, r111, r100, r101));
        return;
    L40:
        LarkAppContext.Companion.getClass();
        r114 = ((com.ss.android.lark.conditional.access.display.g) e0c.k.a(LarkAppContext.access$getInstance$cp().getContext(), com.ss.android.lark.conditional.access.display.g.class)).ye(r111, r102).map(j.f418181a).timeout(w4c.c.a().g(), TimeUnit.MILLISECONDS);
        Intrinsics.checkNotNull(r114);
        goto L41
    L32:
        if (r111.length() != 0) goto L34;
    L16:
        SecurityActionHandleContext r115 = r101.getHandleContext();
        if (r115 == null) goto L19;
        String r116 = r115.getPointKey();
    L20:
        if (r116 != null) goto L22;
    L25:
        int r117 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "snapshot skipped, pointKey not in clear cache list, pointKey: " + r116);
        goto L26
    L22:
        if (w4c.c.a().p0().contains(r116) == false) goto L25;
        List<PolicyModel> r118 = g8b.b.a.a().getDependency().f();
        r101.getInternalParams().put("filePolicyModelsSnapshot", r118);
        int r119 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "snapshot file policy models before dialog show, size: " + r118.size());
        goto L26
    L19:
        r116 = null;
        goto L20
    }

    public static void e(SecurityPolicyDialogActionManager r100, final int r101, final InternalSecurityAction r102) {
        final String r103 = qqb.a.d();
        r100.getClass();
        String r104 = qqb.a.d();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r103, "traceId");     // Catch: Throwable -> L7
        qqb.a.g(r103);     // Catch: Throwable -> L7
        ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "showDialogInternal");     // Catch: Throwable -> L7
        ((Handler) SecurityDialogUtil.f418126d.getValue()).post(new SecurityPolicyDialogActionManager$showDialogInternal$1$1(r101, r102, r103));     // Catch: Throwable -> L7
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r104, "traceId");
        qqb.a.g(r104);
        return;
    L7:
        th = th;
    L11:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r104, "traceId");
        qqb.a.g(r104);
        throw th;
    L9:
        th = th;
        r104 = "";
        goto L11
    }
}
