package com.obric.assistant.settings.autogui;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.SystemClock;
import android.util.EventsUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.keva.Keva;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.AutoGuiAppScopeConfig;
import com.obric.assistant.common.utils.l;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.permission.IObricPermissionService;
import com.obric.assistant.reporter.IObricReporter;
import com.obric.assistant.settings.IObricAutoBlacklistSettingsNotifier;
import com.obric.assistant.settings.IObricAutoGuiSettingsApi;
import com.obric.assistant.settings.ObricAppListMode;
import com.obric.assistant.settings.b;
import com.obric.assistant.settings.c;
import com.obric.assistant.settings.e;
import com.obric.assistant.settings.h1;
import com.obric.assistant.settings.r;
import com.obric.assistant.settings.s;
import com.obric.assistant.settings.v;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import f06.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import n38.j;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 e2\u00020\u0001:\u0007efghijkB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0018H\u0016J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0018H\u0016J\b\u0010#\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u001dH\u0002J\u000e\u0010'\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010(J\u0016\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0016H\u0096@¢\u0006\u0002\u0010(J\u000e\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010(J\u0018\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u000200H\u0082@¢\u0006\u0002\u00101J0\u00102\u001a\u00020,*\u00020.2\u0006\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u0018062\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001806H\u0002J(\u00108\u001a\b\u0012\u0004\u0012\u00020\u001806*\b\u0012\u0004\u0012\u00020\u0018062\u0006\u00103\u001a\u0002042\u0006\u00109\u001a\u00020\u0018H\u0002J\u0016\u0010:\u001a\u0004\u0018\u00010\u0018*\u00020\u00182\u0006\u0010;\u001a\u00020<H\u0002J\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001806*\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0016H\u0002J\b\u0010>\u001a\u000200H\u0002J\u0018\u0010?\u001a\u00020@2\u0006\u0010/\u001a\u0002002\u0006\u0010A\u001a\u00020\u0018H\u0002J\u0016\u0010B\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0016H\u0082@¢\u0006\u0002\u0010(J\u000e\u0010C\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010(J\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00180\u0016H\u0082@¢\u0006\u0002\u0010(J\u0010\u0010E\u001a\u00020F2\u0006\u00103\u001a\u000204H\u0002J$\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u00162\u0006\u0010I\u001a\u00020@2\u0006\u0010J\u001a\u00020@H\u0096@¢\u0006\u0002\u0010KJ\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020H0\u0016H\u0096@¢\u0006\u0002\u0010(J\u000e\u0010M\u001a\u00020NH\u0096@¢\u0006\u0002\u0010(J\u000e\u0010O\u001a\u00020NH\u0096@¢\u0006\u0002\u0010(J\u0018\u0010P\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020@H\u0016J\u0018\u0010R\u001a\u00020@2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010S\u001a\u00020@H\u0016J\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u00103\u001a\u000204H\u0002J\u0016\u0010U\u001a\b\u0012\u0004\u0012\u00020\n0\u00162\u0006\u00103\u001a\u000204H\u0002J\u0016\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u00162\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010X\u001a\u00020@2\u0006\u0010Y\u001a\u00020\u0018H\u0002J\u0010\u0010Z\u001a\u00020@2\u0006\u0010;\u001a\u00020<H\u0002J*\u0010[\u001a\u0002H\\\"\u0004\b\u0000\u0010\\2\u0006\u0010]\u001a\u00020\u00182\f\u0010^\u001a\b\u0012\u0004\u0012\u0002H\\0_H\u0082\b¢\u0006\u0002\u0010`J \u0010a\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020\u00182\u0006\u0010b\u001a\u00020\u00112\u0006\u0010c\u001a\u00020@H\u0002J\b\u0010d\u001a\u00020@H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006l"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoGuiSettingsImpl;", "Lcom/obric/assistant/settings/IObricAutoGuiSettingsApi;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "cleanupScope", "Lkotlinx/coroutines/CoroutineScope;", "appInfoComparator", "Ljava/util/Comparator;", "Lcom/obric/assistant/settings/AppInfo;", "Lkotlin/Comparator;", "currentAutoActionAppDataSource", "Lcom/obric/assistant/settings/AutoActionAppDataSource;", "cloudPolicyCacheLock", XmlPullParser.NO_NAMESPACE, "accountGeneration", XmlPullParser.NO_NAMESPACE, "lastSuccessfulCloudPolicy", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiSettingsImpl$CloudAppPolicySnapshot;", "currentAutoActionAppDataSourceFromOs", "launcherAppsCache", XmlPullParser.NO_NAMESPACE, "launcherAppPackageNamesCache", XmlPullParser.NO_NAMESPACE, "userID", "getUserID", "()Ljava/lang/String;", "initKeva", XmlPullParser.NO_NAMESPACE, "invalidateAccountScopedCaches", "invalidateLauncherAppsCache", "onAppUninstalled", "packageName", "onAppInstalled", "cleanupKevaAgainstInstalledAppsIfNeeded", "removeKevaValueForPackage", "migrateSettingsIfNeeded", "doMigrateSettingsIfNeeded", "getAutoActionAppBlacklistFromCloudAndOs", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppSoftBlacklistFromCloud", "Lcom/obric/assistant/settings/ObricAppBlacklistItem;", "getAutoActionAppFilterPolicyForRecommendation", "Lcom/obric/assistant/settings/AutoActionAppFilterPolicy;", "fetchCloudAppPolicy", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiSettingsImpl$CloudAppPolicy;", "accountScope", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiSettingsImpl$AccountScope;", "(Lcom/obric/assistant/settings/autogui/ObricAutoGuiSettingsImpl$AccountScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toAppFilterPolicy", "context", "Landroid/content/Context;", "saepRestrictedPackages", XmlPullParser.NO_NAMESPACE, "saepDeclaredPackages", "toAppLabelSet", "source", "toAppLabel", "packageManager", "Landroid/content/pm/PackageManager;", "toAppNameSet", "captureAccountScope", "isCurrentAccountLocked", XmlPullParser.NO_NAMESPACE, "currentUserId", "fetchAppSoftBlacklistFromCloud", "getAutoActionAppBlacklistFromOs", "getAvailableAppPackageNamesFromCloudAndOs", "getLauncherPackageSnapshot", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiSettingsImpl$LauncherPackageSnapshot;", "getAutoActionAvailableAppPermissionFromUser", "Lcom/obric/assistant/settings/AutoActionBlacklistByUserItem;", "onlyReturnWhiteList", "isClientOnly", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAutoActionAppBlacklistFromUser", "getAutoActionMergedBlacklistForSystemSettings", "Lcom/obric/assistant/settings/SystemSettingsAppListResult;", "getAutoActionA16UserAvailableApps", "setAppState", "isEnable", "getAppState", "defVal", "getLauncherAppPackageNamesInternal", "getLauncherAppsInternal", "queryLauncherResolveInfoList", "Landroid/content/pm/ResolveInfo;", "isMiniProgramActivity", "activityName", "isDoubaoMiniAppInstalled", "trackDuration", "T", "methodName", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "reportMethodDuration", "duration", "success", "checkPackagePermission", "Companion", "CloudAppPolicy", "AppScopeInputs", "LauncherPackageSnapshot", "SystemSettingsAppScopeInputs", "AccountScope", "CloudAppPolicySnapshot", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricAutoGuiSettingsImpl implements IObricAutoGuiSettingsApi {
    public static final Set<String> i = null;
    public static final List<String> j = null;
    public Keva a;
    public final CoroutineScope b;
    public final i0 c;
    public final Object d;
    public long e;
    public e f;
    public volatile List<b> g;
    public volatile List<String> h;

    public static final class a implements j {
        public final /* synthetic */ ObricAutoGuiSettingsImpl a;

        public a(ObricAutoGuiSettingsImpl r1) {
            this.a = r1;
        }

        @Override // n38.j
        public final void a(n38.a r6) {
            Intrinsics.checkNotNullParameter(r6, "event");
            ObricAutoGuiSettingsImpl r7 = this.a;
            Set<String> r0 = ObricAutoGuiSettingsImpl.i;
            Object r1 = r7.d;
            monitor-enter(r1);
            r7.e++;     // Catch: Throwable -> L7
            r7.f = null;     // Catch: Throwable -> L7
            Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r1);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // n38.j
        public final void b(n38.a r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            FLogger.a.i("ObricAutoGuiSettingsImpl", "onUserDidOnline, user login, init keva");
            ObricAutoGuiSettingsImpl r4 = this.a;
            Set<String> r0 = ObricAutoGuiSettingsImpl.i;
            r4.q();
        }
    }

    public static final class f {
    }

    static {
        i = SetsKt.setOf("auto_gui_app_migrated_action");
        j = CollectionsKt.listOf(new String[]{"miniapp", "miniprogram", "mini.app"});
    }

    public static boolean m() {
        if (Build.VERSION.SDK_INT < 23) goto L31;
        IObricPermissionService r0 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r0 == null) goto L7;
        boolean r1 = r0.o();
    L8:
        Application r3 = AppHost.a.getApplication();
        ArrayList r12 = new ArrayList();
        Object[] r13 = {"com.android.permission.GET_INSTALLED_APPS"};
        f06.b r15 = new f06.b("auto_cert_com_obric_assistant_settings_autogui_ObricAutoGuiSettingsImpl_android_app_Application_checkSelfPermission");
        g06.a r4 = (g06.a) ApiHookConfig.b.get(102608);
        if (r4 == null) goto L11;
        f06.a[] r5 = r4.i;
    L12:
        f06.a[] r11 = r5;
        int r10 = r11.length;
        int r9 = 0;
    L14:
        if (r9 >= r10) goto L21;
        f06.a r8 = r11[r9];
        int r19 = r9;
        int r20 = r10;
        f06.a[] r21 = r11;
        d r6 = r8.preInvoke(102608, "android/app/Application", "checkSelfPermission", r3, r13, "int", r15);     // Catch: Exception -> L33
        if (r6.a == true) goto L23;
        r12.add(r8);     // Catch: Exception -> L33
    L23:
        if (r6.a == false) goto L25;
        int r2 = ((Integer) r6.b).intValue();
    L26:
        FLogger.a.i("ObricAutoGuiSettingsImpl", "checkPackagePermission, isSupportAppListPermission: " + r1 + ", ret: " + r2);
        if (r1 == false) goto L31;
        if (r2 == 0) goto L31;
        return false;
    L25:
        r2 = r3.checkSelfPermission("com.android.permission.GET_INSTALLED_APPS");
    L20:
        r9 = r19 + 1;
        r10 = r20;
        r11 = r21;
        goto L14
    L21:
        r6 = new d(false, null);
        goto L23
    L11:
        r5 = ApiHookConfig.d;
        goto L12
    L7:
        r1 = false;
    L31:
        return true;
    }

    public final b l() {
        String r0 = ILoginService.a.getAccountInfo().c;
        Object r1 = this.d;
        monitor-enter(r1);
        b r2 = new b(r0, this.e);     // Catch: Throwable -> L7
        monitor-exit(r1);
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public final void q() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("initKeva with user id ");
        ILoginService.Companion r2 = ILoginService.a;
        r1.append(com.obric.assistant.utils.j.d(r2.getAccountInfo().c));
        r0.i("ObricAutoGuiSettingsImpl", r1.toString());
        this.a = Keva.getRepo("obric_auto_gui_settings_" + r2.getAccountInfo().c, 0);
        this.g = null;
        this.h = null;
        Object r4 = this.d;
        monitor-enter(r4);
        this.e++;     // Catch: Throwable -> L21
        this.f = null;     // Catch: Throwable -> L21
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r4);
        if (l.a(null) == false) goto L14;
        if (r2.getAccountInfo().a == true) goto L12;
        r0.i("ObricAutoGuiSettingsImpl", "migrateSettingsIfNeeded, not login, skip");
        goto L14
    L12:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new migrateSettingsIfNeeded.1(this, null), 3, null);
    L14:
        if (l.a(null) == true) goto L17;
        return;
    L17:
        if (m() == true) goto L19;
        r0.i("ObricAutoGuiSettingsImpl", "cleanupKevaAgainstInstalledAppsIfNeeded: no package permission, skip");
        return;
    L19:
        BuildersKt.launch$default(this.b, null, null, new cleanupKevaAgainstInstalledAppsIfNeeded.1(this, null), 3, null);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.assistant.settings.autogui.i0] */
    public ObricAutoGuiSettingsImpl() {
        this.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.c = new i0();
        this.d = new Object();
        FLogger r0 = FLogger.a;
        r0.i("ObricAutoGuiSettingsImpl", "init");
        ILoginService.Companion r2 = ILoginService.a;
        ILoginService.a.c(r2, new a(this));
        if (r2.getAccountInfo().a == false) goto L6;
        r0.i("ObricAutoGuiSettingsImpl", "init, already login, init keva");
        q();
        return;
    }

    public static boolean s(String r3) {
        List<String> r0 = j;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (StringsKt.contains(r3, (String) r1.next(), true) == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final Object b(Continuation<? super com.obric.assistant.settings.d> r14) {
        if ((r14 instanceof getAutoActionAppFilterPolicyForRecommendation.1) == false) goto L7;
        getAutoActionAppFilterPolicyForRecommendation.1 r0 = (getAutoActionAppFilterPolicyForRecommendation.1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        int r5 = r0.I$0;
        long r7 = r0.J$0;
        String r6 = (String) r0.L$1;
        ObricAutoGuiSettingsImpl r8 = (ObricAutoGuiSettingsImpl) r0.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
    L23:
        com.obric.assistant.settings.d r16 = (com.obric.assistant.settings.d) r15;     // Catch: Throwable -> L14
        long r9 = SystemClock.elapsedRealtime() - r7;
        FLogger.a.i("ObricAutoGuiSettingsImpl", r6 + ", cost = " + r9 + "ms, success = true");
        r8.getClass();
        t(r6, r9, true);
        return r16;
    L14:
        th = move-exception;
        ObricAutoGuiSettingsImpl r12 = r8;
        th = th;
        String r17 = r6;
        int r10 = r5;
        ObricAutoGuiSettingsImpl r11 = r12;
    L29:
        long r13 = SystemClock.elapsedRealtime() - r7;
        FLogger r18 = FLogger.a;
        StringBuilder r19 = new StringBuilder();
        r19.append(r17);
        r19.append(", cost = ");
        r19.append(r13);
        r19.append("ms, success = ");
        if (r10 == 0) goto L32;
        boolean r20 = true;
    L33:
        r19.append(r20);
        r18.i("ObricAutoGuiSettingsImpl", r19.toString());
        if (r10 != 0) goto L37;
        r4 = false;
    L37:
        r11.getClass();
        t(r17, r13, r4);
        throw th;
    L32:
        r20 = false;
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        r17 = "getAutoActionAppFilterPolicyForRecommendation";
        r7 = SystemClock.elapsedRealtime();
        getAutoActionAppFilterPolicyForRecommendation.2.1 r110 = new getAutoActionAppFilterPolicyForRecommendation.2.1(this, t1.a.s0(), AppHost.a.getApplication().getApplicationContext(), null);     // Catch: Throwable -> L27
        r0.L$0 = this;     // Catch: Throwable -> L27
        r0.L$1 = "getAutoActionAppFilterPolicyForRecommendation";     // Catch: Throwable -> L27
        r0.J$0 = r7;     // Catch: Throwable -> L27
        r0.I$0 = 0;     // Catch: Throwable -> L27
        r0.label = 1;     // Catch: Throwable -> L27
        Object r21 = CoroutineScopeKt.coroutineScope(r110, r0);     // Catch: Throwable -> L27
        if (r21 != r2) goto L22;
        return r2;
    L22:
        r6 = "getAutoActionAppFilterPolicyForRecommendation";
        r15 = r21;
        r5 = 0;
        r8 = this;
    L27:
        th = th;
        r11 = this;
        r10 = 0;
    L7:
        r0 = new getAutoActionAppFilterPolicyForRecommendation.1(this, r14);
        goto L8
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final Object c(Continuation<? super h1> r6) {
        if ((r6 instanceof getAutoActionA16UserAvailableApps.1) == false) goto L7;
        getAutoActionA16UserAvailableApps.1 r0 = (getAutoActionA16UserAvailableApps.1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L26:
        return new h1((List) r7, true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        if (ILoginService.a.getAccountInfo().a == true) goto L19;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getAutoActionA16UserAvailableApps, not login, incomplete");
        return new h1(CollectionsKt.emptyList(), false);
    L19:
        if (m() == true) goto L22;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getAutoActionA16UserAvailableApps, no package permission, incomplete");
        return new h1(CollectionsKt.emptyList(), false);
    L22:
        r0.label = 1;
        r7 = IObricAutoGuiSettingsApi.a.a(this, true, r0, 2);
        if (r7 != r2) goto L26;
        return r2;
    L7:
        r0 = new getAutoActionA16UserAvailableApps.1(this, r6);
        goto L8
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final void d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "packageName");
        if (StringsKt.isBlank(r3) == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r3, AppHost.a.getApplication().getPackageName()) == false) goto L8;
        return;
    L8:
        FLogger.a.i("ObricAutoGuiSettingsImpl", "onAppInstalled: packageName=".concat(r3));
        this.g = null;
        this.h = null;
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final Object f(Continuation<? super h1> r17) {
        if ((r17 instanceof getAutoActionMergedBlacklistForSystemSettings.1) == false) goto L7;
        getAutoActionMergedBlacklistForSystemSettings.1 r1 = (getAutoActionMergedBlacklistForSystemSettings.1) r17;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        getAutoActionMergedBlacklistForSystemSettings.1 r7 = r1;
        Object r0 = r7.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r7.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        AutoGuiAppScopeConfig r4 = (AutoGuiAppScopeConfig) r7.L$1;
        b r5 = (b) r7.L$0;
        ResultKt.throwOnFailure(r0);
    L18:
        h r6 = (h) r0;
        g r9 = r6.a;
        d r10 = r6.b;
        o0.a r11 = r6.c;
        ObricSaepRestrictedPackageReader.a r12 = r6.d;
        List r13 = r10.b;
        List r14 = null;
        if (r13 == null) goto L39;
        ArrayList r15 = new ArrayList();
        Iterator r16 = r13.iterator();
    L22:
        if (r16.hasNext() == false) goto L38;
        r r18 = (r) r16.next();
        if (r18 == null) goto L35;
        String r19 = r18.e();
        if (r19 == null) goto L35;
        String r110 = StringsKt.trim(r19).toString();
        if (r110 == null) goto L35;
        if (r110.length() <= 0) goto L32;
        boolean r111 = true;
    L33:
        if (r111 == false) goto L35;
    L36:
        if (r110 == null) goto L22;
        r15.add(r110);
        goto L22
    L32:
        r111 = false;
    L35:
        r110 = null;
        goto L36
    L38:
        r14 = r15;
    L39:
        if (r14 != null) goto L41;
        r14 = CollectionsKt.emptyList();
    L41:
        Set r20 = r10.c;
        if (r10.a != ObricAppListMode.WHITE_LIST) goto L52;
        if (r20 != null) goto L45;
        Collection r112 = r9.a;
    L54:
        if (r4.getEnableSaepRestrictedPackages() == true) goto L56;
        Set r21 = SetsKt.emptySet();
    L59:
        Set r113 = r12.b;
        if (r113 != null) goto L62;
        r113 = SetsKt.emptySet();
    L62:
        List r114 = CollectionsKt.plus(r14, r112);
        ArrayList r115 = new ArrayList();
        Iterator r116 = r114.iterator();
    L64:
        if (r116.hasNext() == false) goto L69;
        Object r117 = r116.next();
        if (r113.contains((String) r117) == true) goto L64;
        r115.add(r117);
        goto L64
    L69:
        List r22 = r11.a;
        ArrayList r118 = new ArrayList();
        Iterator r23 = r22.iterator();
    L71:
        if (r23.hasNext() == false) goto L75;
        Object r119 = r23.next();
        if (r113.contains((String) r119) == true) goto L71;
        r118.add(r119);
        goto L71
    L75:
        List r24 = CollectionsKt.distinct(CollectionsKt.plus(CollectionsKt.plus(r115, r118), r21));
        if (r(r5, ILoginService.a.getAccountInfo().c) == true) goto L78;
    L89:
        boolean r25 = false;
    L90:
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getAutoActionMergedBlacklistForSystemSettings, cloudMode: " + r10.a.getValue() + ", cloudBlacklist: " + r14.size() + ", cloudWhitelistBlocked: " + r112.size() + ", deviceConfig: " + r11.a.size() + "(success=" + r11.b + "), saepRestricted: " + r21.size() + ", saepDeclared: " + r113.size() + ", saepComplete: " + r12.c + ", saepSource: " + r12.d + ", launcher: " + r9.a.size() + "(complete=" + r9.b + "), merged: " + r24.size() + ", isComplete: " + r25);
        List r26 = r24;
        ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        Iterator r29 = r26.iterator();
    L92:
        if (r29.hasNext() == false) goto L95;
        r28.add(new e((String) r29.next(), false));
        goto L92
    L95:
        return new h1(r28, r25);
    L78:
        if (r11.b == false) goto L89;
        if (r12.c == false) goto L89;
        if (r10.e == false) goto L89;
        if (r10.a == ObricAppListMode.WHITE_LIST) goto L86;
    L88:
        r25 = true;
        goto L90
    L86:
        if (r9.b == false) goto L89;
        if (r20 == null) goto L89;
    L56:
        r21 = r12.a;
        if (r21 != null) goto L59;
        r21 = SetsKt.emptySet();
        goto L59
    L45:
        Set r120 = r9.a;
        ArrayList r121 = new ArrayList();
        Iterator r122 = r120.iterator();
    L47:
        if (r122.hasNext() == false) goto L51;
        Object r123 = r122.next();
        if ((!r20.contains((String) r123)) == false) goto L47;
        r121.add(r123);
        goto L47
    L51:
        r112 = r121;
        goto L54
    L52:
        r112 = CollectionsKt.emptyList();
        goto L54
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        b r124 = l();
        Context r30 = AppHost.a.getApplication().getApplicationContext();
        AutoGuiAppScopeConfig r125 = t1.a.s0();
        getAutoActionMergedBlacklistForSystemSettings.2 r126 = new getAutoActionMergedBlacklistForSystemSettings.2(this, r30, r124, r125, null);
        r7.L$0 = r124;
        r7.L$1 = r125;
        r7.label = 1;
        r0 = CoroutineScopeKt.coroutineScope(r126, r7);
        if (r0 != r8) goto L17;
        return r8;
    L17:
        r5 = r124;
        r4 = r125;
    L7:
        r1 = new getAutoActionMergedBlacklistForSystemSettings.1(this, r17);
        goto L8
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final void g(String r8) {
        Intrinsics.checkNotNullParameter(r8, "packageName");
        if (StringsKt.isBlank(r8) == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r8, AppHost.a.getApplication().getPackageName()) == false) goto L8;
        return;
    L8:
        FLogger.a.i("ObricAutoGuiSettingsImpl", "onAppUninstalled: packageName=".concat(r8));
        this.g = null;
        this.h = null;
        BuildersKt.launch$default(this.b, null, null, new onAppUninstalled.1(this, r8, null), 3, null);
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final Object i(Continuation<? super c> r36) {
        if ((r36 instanceof getAutoActionAppBlacklistFromCloudAndOs.1) == false) goto L7;
        getAutoActionAppBlacklistFromCloudAndOs.1 r1 = (getAutoActionAppBlacklistFromCloudAndOs.1) r36;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        getAutoActionAppBlacklistFromCloudAndOs.1 r0 = r1;
        Object r3 = r0.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        int r6 = r0.I$0;
        long r7 = r0.J$0;
        AutoGuiAppScopeConfig r8 = (AutoGuiAppScopeConfig) r0.L$3;
        b r9 = (b) r0.L$2;
        String r10 = (String) r0.L$1;
        ObricAutoGuiSettingsImpl r18 = (ObricAutoGuiSettingsImpl) r0.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L14
        AutoGuiAppScopeConfig r33 = r8;
        String r25 = "setupAvailableAppList, appList, list.size: ";
        b r11 = r9;
        String r12 = r10;
        long r13 = r7;
        int r14 = r6;
        ObricAutoGuiSettingsImpl r15 = r18;
    L99:
        c r16 = (c) r3;     // Catch: Throwable -> L76
        List r17 = r16.a;     // Catch: Throwable -> L76
        d r19 = r16.b;     // Catch: Throwable -> L76
        Set r20 = r16.c;     // Catch: Throwable -> L76
        ObricSaepRestrictedPackageReader.a r21 = r16.d;     // Catch: Throwable -> L76
        FLogger r110 = FLogger.a;     // Catch: Throwable -> L76
        int r111 = r14;
        ObricAutoGuiSettingsImpl r112 = r15;
        r110.i("ObricAutoGuiSettingsImpl", r25 + r17.size() + ", " + r17);     // Catch: Throwable -> L72
        List r22 = r19.b;     // Catch: Throwable -> L72
        StringBuilder r23 = new StringBuilder("setupAvailableAppList, appBlacklist, list: ");     // Catch: Throwable -> L72
        r23.append(r22);     // Catch: Throwable -> L72
        r110.i("ObricAutoGuiSettingsImpl", r23.toString());     // Catch: Throwable -> L72
        r110.i("ObricAutoGuiSettingsImpl", "setupAvailableAppList, systemBlacklistPackages: " + r20);     // Catch: Throwable -> L72
        r110.i("ObricAutoGuiSettingsImpl", "setupAvailableAppList, saepEnable: " + r33.getEnableSaepRestrictedPackages() + ", saepResult: " + r21);     // Catch: Throwable -> L72
        int r24 = j.a;     // Catch: Throwable -> L72
        j.a r26 = j.a(r17, r22, r20, r21.a, r21.b, r19.c, r19.a, r33);     // Catch: Throwable -> L72
        r110.i("ObricAutoGuiSettingsImpl", "setupAvailableAppList, cloud mode: " + r19.a.getValue());     // Catch: Throwable -> L72
        StringBuilder r28 = new StringBuilder("setupAvailableAppList, cloud blacklist size:  ");     // Catch: Throwable -> L72
        if (r22 != null) goto L103;
        int r29 = 0;
    L40:
        r28.append(r29);     // Catch: Throwable -> L72
        r110.i("ObricAutoGuiSettingsImpl", r28.toString());     // Catch: Throwable -> L72
        StringBuilder r30 = new StringBuilder("setupAvailableAppList, cloud whitelist size: ");     // Catch: Throwable -> L72
        Set r31 = r19.c;     // Catch: Throwable -> L72
        int r32 = -1;
        if (r31 == null) goto L45;
        int r34 = r31.size();     // Catch: Throwable -> L37
    L46:
        r30.append(r34);     // Catch: Throwable -> L72
        r30.append(", saep restricted size: ");     // Catch: Throwable -> L72
        Set r35 = r21.a;     // Catch: Throwable -> L72
        if (r35 == null) goto L50;
        int r37 = r35.size();     // Catch: Throwable -> L37
    L51:
        r30.append(r37);     // Catch: Throwable -> L72
        r30.append(", saep declared size: ");     // Catch: Throwable -> L72
        Set r38 = r21.b;     // Catch: Throwable -> L72
        if (r38 == null) goto L57;
        r32 = r38.size();     // Catch: Throwable -> L37
    L37:
        th = th;
        r10 = r12;
        int r39 = r111;
        r18 = r112;
    L56:
        String r40 = r10;
        r111 = r39;
        boolean r41 = true;
    L87:
        long r42 = SystemClock.elapsedRealtime() - r13;
        FLogger r43 = FLogger.a;
        StringBuilder r44 = new StringBuilder();
        r44.append(r40);
        r44.append(", cost = ");
        r44.append(r42);
        r44.append("ms, success = ");
        if (r111 == 0) goto L90;
        boolean r45 = true;
    L91:
        r44.append(r45);
        r43.i("ObricAutoGuiSettingsImpl", r44.toString());
        if (r111 != 0) goto L95;
        r41 = false;
    L95:
        r18.getClass();
        t(r40, r42, r41);
        throw th;
    L90:
        r45 = false;
    L57:
        r30.append(r32);     // Catch: Throwable -> L72
        r30.append(", saep complete: ");     // Catch: Throwable -> L72
        r30.append(r21.c);     // Catch: Throwable -> L72
        r30.append(", saep source: ");     // Catch: Throwable -> L72
        r30.append(r21.d);     // Catch: Throwable -> L72
        r110.i("ObricAutoGuiSettingsImpl", r30.toString());     // Catch: Throwable -> L72
        r110.i("ObricAutoGuiSettingsImpl", "setupAvailableAppList, blacklistExist, size: " + r26.b.size());     // Catch: Throwable -> L72
        r110.i("ObricAutoGuiSettingsImpl", "setupAvailableAppList, availableList.size: " + r26.a.size());     // Catch: Throwable -> L72
        c r46 = new c(CollectionsKt.sortedWith(r26.a, this.c), r22, CollectionsKt.sortedWith(r26.b, this.c));     // Catch: Throwable -> L72
        String r47 = ILoginService.a.getAccountInfo().c;     // Catch: Throwable -> L72
        Object r48 = this.d;     // Catch: Throwable -> L72
        monitor-enter(r48);     // Catch: Throwable -> L72
    L66:
        th = move-exception;
        r41 = true;
    L70:
        th = th;
    L79:
        r40 = r12;
        r18 = r112;
        goto L87
    L69:
        throw th;     // Catch: Throwable -> L70
    L60:
        if (r(r11, r47) == true) goto L63;
        r110.w("ObricAutoGuiSettingsImpl", "setupAvailableAppList, account changed while resolving, discard result");     // Catch: Throwable -> L66
        r46 = new c(CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());     // Catch: Throwable -> L66
    L63:
        monitor-exit(r48);     // Catch: Throwable -> L72
        long r49 = SystemClock.elapsedRealtime() - r13;
        r110.i("ObricAutoGuiSettingsImpl", r12 + ", cost = " + r49 + "ms, success = true");
        r112.getClass();
        t(r12, r49, true);
        return r46;
    L50:
        r37 = -1;
        goto L51
    L45:
        r34 = -1;
        goto L46
    L103:
        r29 = r22.size();     // Catch: Throwable -> L37
    L72:
        th = th;
    L73:
        r41 = true;
    L74:
        th = th;
    L78:
        r112 = r15;
    L76:
        th = th;
        r111 = r14;
    L14:
        th = th;
        r13 = r7;
        r39 = r6;
        goto L56
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r3);
        long r50 = SystemClock.elapsedRealtime();
        b r51 = l();     // Catch: Throwable -> L84
        AutoGuiAppScopeConfig r52 = t1.a.s0();     // Catch: Throwable -> L84
        r13 = r50;
        r12 = "getAutoActionAppBlacklistFromCloudAndOs";
        r25 = "setupAvailableAppList, appList, list.size: ";
        getAutoActionAppBlacklistFromCloudAndOs.2.1 r53 = new getAutoActionAppBlacklistFromCloudAndOs.2.1(this, AppHost.a.getApplication().getApplicationContext(), r51, r52, null);     // Catch: Throwable -> L82
        r0.L$0 = this;     // Catch: Throwable -> L82
        r0.L$1 = r12;     // Catch: Throwable -> L82
        r0.L$2 = r51;     // Catch: Throwable -> L82
        r0.L$3 = r52;     // Catch: Throwable -> L82
        r0.J$0 = r13;     // Catch: Throwable -> L82
        r0.I$0 = 0;     // Catch: Throwable -> L82
        r41 = true;
        r0.label = 1;     // Catch: Throwable -> L80
        Object r54 = CoroutineScopeKt.coroutineScope(r53, r0);     // Catch: Throwable -> L82
        if (r54 != r5) goto L28;
        return r5;
    L28:
        r15 = this;
        r33 = r52;
        r14 = 0;
        r3 = r54;
        r11 = r51;
    L80:
        th = th;
    L86:
        r18 = this;
        r40 = r12;
        r111 = 0;
    L82:
        th = th;
    L83:
        r41 = true;
    L84:
        th = th;
        r13 = r50;
        r12 = "getAutoActionAppBlacklistFromCloudAndOs";
    L7:
        r1 = new getAutoActionAppBlacklistFromCloudAndOs.1(this, r36);
        goto L8
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final Object j(Continuation<? super List<e>> r17) {
        if ((r17 instanceof getAutoActionAppBlacklistFromUser.1) == false) goto L7;
        getAutoActionAppBlacklistFromUser.1 r2 = (getAutoActionAppBlacklistFromUser.1) r17;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r6 = false;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        int r7 = r2.I$0;
        long r9 = r2.J$0;
        List r8 = (List) r2.L$2;
        String r11 = (String) r2.L$1;
        ObricAutoGuiSettingsImpl r10 = (ObricAutoGuiSettingsImpl) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L14
    L37:
        Iterator r1 = ((List) r0).iterator();     // Catch: Throwable -> L14
    L38:
        if (r1.hasNext() == false) goto L48;
        String r12 = (String) r1.next();     // Catch: Throwable -> L14
        boolean r13 = e(r12, false);     // Catch: Throwable -> L14
        FLogger r14 = FLogger.a;     // Catch: Throwable -> L14
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L14
        r15.append("getAutoActionAppBlacklistFromUser, packageName: ");     // Catch: Throwable -> L14
        r15.append(r12);     // Catch: Throwable -> L14
        r15.append(", isAppAvailable: ");     // Catch: Throwable -> L14
        if (r13 == false) goto L43;
        boolean r16 = true;
    L44:
        r15.append(r16);     // Catch: Throwable -> L14
        r14.i("ObricAutoGuiSettingsImpl", r15.toString());     // Catch: Throwable -> L14
        if (r13 == true) goto L38;
        r8.add(new e(r12, false));     // Catch: Throwable -> L14
        goto L38
    L43:
        r16 = false;
    L48:
        long r18 = SystemClock.elapsedRealtime() - r9;
        FLogger.a.i("ObricAutoGuiSettingsImpl", r11 + ", cost = " + r18 + "ms, success = true");
        r10.getClass();
        t(r11, r18, true);
        return r8;
    L14:
        th = th;
    L52:
        long r19 = SystemClock.elapsedRealtime() - r9;
        FLogger r20 = FLogger.a;
        StringBuilder r110 = new StringBuilder();
        r110.append(r11);
        r110.append(", cost = ");
        r110.append(r19);
        r110.append("ms, success = ");
        if (r7 == 0) goto L55;
        boolean r21 = true;
    L56:
        r110.append(r21);
        r20.i("ObricAutoGuiSettingsImpl", r110.toString());
        if (r7 == 0) goto L59;
        r6 = true;
    L59:
        r10.getClass();
        t(r11, r19, r6);
        throw th;
    L55:
        r21 = false;
        goto L56
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        r11 = "getAutoActionAppBlacklistFromUser";
        r9 = SystemClock.elapsedRealtime();
        r8 = new ArrayList();     // Catch: Throwable -> L50
        if (ILoginService.a.getAccountInfo().a == true) goto L23;
    L31:
        r10 = this;
        goto L48
    L23:
        if (this.a != null) goto L29;
        q();     // Catch: Throwable -> L26
    L26:
        th = th;
        r10 = this;
        r7 = 0;
    L29:
        if (m() == true) goto L33;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getAutoActionAppBlacklistFromUser, return emptylist by permission denied");     // Catch: Throwable -> L26
        r8 = CollectionsKt.emptyList();     // Catch: Throwable -> L26
        goto L31
    L33:
        CoroutineDispatcher r22 = Dispatchers.getIO();     // Catch: Throwable -> L50
        getAutoActionAppBlacklistFromUser.2.availablePackageNames.1 r111 = new getAutoActionAppBlacklistFromUser.2.availablePackageNames.1(this, null);     // Catch: Throwable -> L50
        r2.L$0 = this;     // Catch: Throwable -> L50
        r2.L$1 = "getAutoActionAppBlacklistFromUser";     // Catch: Throwable -> L50
        r2.L$2 = r8;     // Catch: Throwable -> L50
        r2.J$0 = r9;     // Catch: Throwable -> L50
        r2.I$0 = 0;     // Catch: Throwable -> L50
        r2.label = 1;     // Catch: Throwable -> L50
        r0 = BuildersKt.withContext(r22, r111, r2);     // Catch: Throwable -> L50
        if (r0 != r4) goto L36;
        return r4;
    L36:
        r10 = this;
        r7 = 0;
    L50:
        th = th;
        r10 = this;
        r7 = 0;
    L7:
        r2 = new getAutoActionAppBlacklistFromUser.1(this, r17);
        goto L8
    }

    public final Object n(Continuation<? super List<r>> r5) {
        if ((r5 instanceof fetchAppSoftBlacklistFromCloud.1) == false) goto L7;
        fetchAppSoftBlacklistFromCloud.1 r0 = (fetchAppSoftBlacklistFromCloud.1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L18:
        return ((d) r6).b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        r0.label = 1;
        r6 = o(l(), r0);
        if (r6 != r2) goto L18;
        return r2;
    L7:
        r0 = new fetchAppSoftBlacklistFromCloud.1(this, r5);
        goto L8
    }

    public final List<String> p(Context r15) {
        long r6 = SystemClock.elapsedRealtime();
    L37:
        th = move-exception;
        long r3 = SystemClock.elapsedRealtime() - r6;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getLauncherAppPackageNamesInternal, cost = " + r3 + "ms, success = false");
        t("getLauncherAppPackageNamesInternal", r3, false);
        throw th;
    L4:
        if (m() == true) goto L6;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getLauncherAppPackageNamesInternal, return emptylist by permission denied");     // Catch: Throwable -> L37
        List<String> r16 = CollectionsKt.emptyList();     // Catch: Throwable -> L37
    L35:
        long r4 = SystemClock.elapsedRealtime() - r6;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getLauncherAppPackageNamesInternal, cost = " + r4 + "ms, success = true");
        t("getLauncherAppPackageNamesInternal", r4, true);
        return r16;
    L6:
        List<String> r9 = this.h;     // Catch: Throwable -> L37
        if (r9 == null) goto L9;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getLauncherAppPackageNamesInternal, hit cache, size: " + r9.size());     // Catch: Throwable -> L37
        r16 = r9;
        goto L35
    L9:
        List<b> r5 = this.g;     // Catch: Throwable -> L37
        if (r5 == null) goto L16;
        List<b> r7 = r5;     // Catch: Throwable -> L37
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));     // Catch: Throwable -> L37
        Iterator<T> r0 = r7.iterator();     // Catch: Throwable -> L37
    L13:
        if (r0.hasNext() == false) goto L15;
        r17.add(((b) r0.next()).a);     // Catch: Throwable -> L37
        goto L13
    L15:
        this.h = r17;     // Catch: Throwable -> L37
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getLauncherAppPackageNamesInternal, reuse appsCache, size: " + r17.size());     // Catch: Throwable -> L37
        r16 = r17;
        goto L35
    L16:
        PackageManager r18 = r15.getPackageManager();     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L37
        Intent r8 = new Intent("android.intent.action.MAIN");     // Catch: Throwable -> L37
        r8.addCategory("android.intent.category.LAUNCHER");     // Catch: Throwable -> L37
        List<ResolveInfo> r10 = r18.queryIntentActivities(r8, 0);     // Catch: Throwable -> L37
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getLauncherAppPackageNamesInternal, resolveList: " + r10.size());     // Catch: Throwable -> L37
        ArrayList r11 = new ArrayList(r10.size());     // Catch: Throwable -> L37
        Iterator<T> r12 = r10.iterator();     // Catch: Throwable -> L37
    L18:
        if (r12.hasNext() == false) goto L42;
        ResolveInfo r13 = (ResolveInfo) r12.next();     // Catch: Throwable -> L37
    L25:
        e = move-exception;
        FLogger.a.e("ObricAutoGuiSettingsImpl", "getLauncherAppPackageNamesInternal, error: " + e);     // Catch: Throwable -> L37
        goto L18
    L21:
        if (s(r13.activityInfo.name) == true) goto L18;
        r11.add(r13.activityInfo.packageName);     // Catch: Exception -> L25 Throwable -> L37
    L42:
        r18.getPackageInfo("com.obric.appletapp", 0);     // Catch: Exception -> L30 Throwable -> L37
        boolean r19 = true;
    L32:
        if (r19 == false) goto L34;
        r11.add("com.obric.appletapp");     // Catch: Throwable -> L37
    L34:
        List<String> r110 = CollectionsKt.toList(r11);     // Catch: Throwable -> L37
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getLauncherAppPackageNamesInternal, build done, size: " + r110.size());     // Catch: Throwable -> L37
        this.h = r110;     // Catch: Throwable -> L37
        r16 = r110;
        goto L35
    L30:
        e = move-exception;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "isDoubaoMiniAppInstalled, not installed: " + e);     // Catch: Throwable -> L37
        r19 = false;
        goto L32
    }

    public static final Object k(ObricAutoGuiSettingsImpl r6, Continuation r7) {
        r6.getClass();
        if ((r7 instanceof getAvailableAppPackageNamesFromCloudAndOs.1) == false) goto L7;
        getAvailableAppPackageNamesFromCloudAndOs.1 r0 = (getAvailableAppPackageNamesFromCloudAndOs.1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        List<String> r9 = (List) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L18:
        List r10 = (List) r8;
        Set r4 = null;
        if (r10 == null) goto L37;
        ArrayList r5 = new ArrayList();
        Iterator r11 = r10.iterator();
    L22:
        if (r11.hasNext() == false) goto L36;
        String r12 = ((r) r11.next()).e();
        if (r12 == null) goto L33;
        String r13 = StringsKt.trim(r12).toString();
        if (r13 == null) goto L33;
        if (r13.length() <= 0) goto L30;
        boolean r14 = true;
    L31:
        if (r14 == false) goto L33;
    L34:
        if (r13 == null) goto L22;
        r5.add(r13);
        goto L22
    L30:
        r14 = false;
    L33:
        r13 = null;
        goto L34
    L36:
        r4 = CollectionsKt.toHashSet(r5);
    L37:
        if (r4 != null) goto L39;
        r4 = SetsKt.emptySet();
    L39:
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r9.iterator();
    L41:
        if (r16.hasNext() == false) goto L45;
        Object r17 = r16.next();
        if ((!r4.contains((String) r17)) == false) goto L41;
        r15.add(r17);
        goto L41
    L45:
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getAvailableAppPackageNamesFromCloudAndOs, launcher: " + r9.size() + ", blacklist: " + r4.size() + ", available: " + r15.size());
        Object r18 = r15;
    L46:
        return r18;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        List<String> r19 = r6.p(AppHost.a.getApplication().getApplicationContext());
        r0.L$0 = r19;
        r0.label = 1;
        Object r20 = r6.n(r0);
        r18 = r2;
        if (r20 == r2) goto L46;
        r8 = r20;
        r9 = r19;
    L7:
        r0 = new getAvailableAppPackageNamesFromCloudAndOs.1(r6, r7);
        goto L8
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final boolean e(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return r6;
    L6:
        if (this.a != null) goto L8;
        q();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        boolean r1 = r0.getBoolean(r5, r6);
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getAppState, ret: " + r1 + ", packageName: " + r5 + ", defVal: " + r6);
        return r1;
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final void h(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "packageName");
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        q();
    L8:
        FLogger.a.i("ObricAutoGuiSettingsImpl", "setAppState, isEnable: " + r5 + ", packageName: " + r4);
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean(r4, r5);
        IObricAutoBlacklistSettingsNotifier r6 = (IObricAutoBlacklistSettingsNotifier) ServiceManager.get().getService(IObricAutoBlacklistSettingsNotifier.class);
        if (r6 == null) goto L15;
        r6.a();
        return;
    }

    public final Object o(b r17, Continuation<? super d> r18) {
        if ((r18 instanceof fetchCloudAppPolicy.1) == false) goto L7;
        fetchCloudAppPolicy.1 r2 = (fetchCloudAppPolicy.1) r18;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        b r6 = (b) r2.L$0;
        ResultKt.throwOnFailure(r0);
    L20:
        v r1 = (v) r0;
        b r8 = r6;
    L22:
        String r7 = ILoginService.a.getAccountInfo().c;
        Object r9 = this.d;
        monitor-enter(r9);
    L116:
        th = move-exception;
        throw th;
    L25:
        if (r(r8, r7) == true) goto L27;
        FLogger.a.w("ObricAutoGuiSettingsImpl", "fetchCloudAppPolicy, account changed while requesting, discard response");     // Catch: Throwable -> L116
        d r10 = new d(ObricAppListMode.BLACK_LIST, null, null, SetsKt.emptySet(), false);     // Catch: Throwable -> L116
    L114:
        monitor-exit(r9);
        return r10;
    L27:
        e r11 = this.f;     // Catch: Throwable -> L116
        if (r11 != null) goto L30;
    L32:
        r11 = null;
    L33:
        if (r1 == null) goto L36;
        ObricAppListMode r12 = r1.c();     // Catch: Throwable -> L116
        if (r12 == null) goto L36;
    L39:
        if (r1 == null) goto L45;
        List r13 = r1.a();     // Catch: Throwable -> L116
        if (r13 == null) goto L45;
        List r14 = CollectionsKt.filterNotNull(r13);     // Catch: Throwable -> L116
        if (r14 == null) goto L45;
    L47:
        List r15 = r14;
    L49:
        boolean r16 = false;
        if (r1 == null) goto L74;
        List r19 = r1.b();     // Catch: Throwable -> L116
        if (r19 == null) goto L74;
        ArrayList r20 = new ArrayList();     // Catch: Throwable -> L116
        Iterator r21 = r19.iterator();     // Catch: Throwable -> L116
    L55:
        if (r21.hasNext() == false) goto L71;
        s r110 = (s) r21.next();     // Catch: Throwable -> L116
        if (r110 == null) goto L68;
        String r111 = r110.b();     // Catch: Throwable -> L116
        if (r111 == null) goto L68;
        String r112 = StringsKt.trim(r111).toString();     // Catch: Throwable -> L116
        if (r112 == null) goto L68;
        if (r112.length() <= 0) goto L65;
        boolean r113 = true;
    L66:
        if (r113 == false) goto L68;
    L69:
        if (r112 == null) goto L55;
        r20.add(r112);     // Catch: Throwable -> L116
        goto L55
    L65:
        r113 = false;
    L68:
        r112 = null;
        goto L69
    L71:
        Set r22 = CollectionsKt.toSet(r20);     // Catch: Throwable -> L116
        if (r22 == null) goto L74;
    L76:
        Set r114 = r22;
    L78:
        if (r1 == null) goto L102;
        List r23 = r1.b();     // Catch: Throwable -> L116
        if (r23 == null) goto L102;
        ArrayList r24 = new ArrayList();     // Catch: Throwable -> L116
        Iterator r25 = r23.iterator();     // Catch: Throwable -> L116
    L83:
        if (r25.hasNext() == false) goto L99;
        s r115 = (s) r25.next();     // Catch: Throwable -> L116
        if (r115 == null) goto L96;
        String r116 = r115.a();     // Catch: Throwable -> L116
        if (r116 == null) goto L96;
        String r117 = StringsKt.trim(r116).toString();     // Catch: Throwable -> L116
        if (r117 == null) goto L96;
        if (r117.length() <= 0) goto L93;
        boolean r118 = true;
    L94:
        if (r118 == false) goto L96;
    L97:
        if (r117 == null) goto L83;
        r24.add(r117);     // Catch: Throwable -> L116
        goto L83
    L93:
        r118 = false;
    L96:
        r117 = null;
        goto L97
    L99:
        Set r26 = CollectionsKt.toSet(r24);     // Catch: Throwable -> L116
        if (r26 == null) goto L102;
    L105:
        if (r1 != null) goto L107;
        if (r11 != null) goto L107;
    L109:
        if (r1 != null) goto L111;
        if (r11 != null) goto L111;
    L113:
        r10 = new d(r12, r15, r114, r26, r16);     // Catch: Throwable -> L116
    L111:
        r16 = true;
    L107:
        this.f = new e(r8, r12, r15, r114, r26);     // Catch: Throwable -> L116
    L102:
        if (r11 == null) goto L104;
        r26 = r11.e;     // Catch: Throwable -> L116
        goto L105
    L104:
        r26 = SetsKt.emptySet();     // Catch: Throwable -> L116
    L74:
        if (r11 == null) goto L77;
        r22 = r11.d;     // Catch: Throwable -> L116
        goto L76
    L77:
        r114 = null;
    L45:
        if (r11 == null) goto L48;
        r14 = r11.c;     // Catch: Throwable -> L116
        goto L47
    L48:
        r15 = null;
    L36:
        if (r11 == null) goto L38;
        r12 = r11.b;     // Catch: Throwable -> L116
        goto L39
    L38:
        r12 = ObricAppListMode.BLACK_LIST;     // Catch: Throwable -> L116
        goto L39
    L30:
        if (Intrinsics.areEqual(r11.a, r8) == false) goto L32;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        IObricNetworkService r28 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r28 == null) goto L21;
        r2.L$0 = r17;
        r2.label = 1;
        r0 = r28.s(r2);
        if (r0 != r4) goto L19;
        return r4;
    L19:
        r6 = r17;
        goto L20
    L21:
        r8 = r17;
        r1 = null;
    L7:
        r2 = new fetchCloudAppPolicy.1(this, r18);
        goto L8
    }

    public final boolean r(b r6, String r7) {
        if (r6.b == this.e) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r6.a, r7) == false) goto L7;
        return true;
    }

    public static void t(String r8, long r9, boolean r11) {
        IObricReporter.a.getClass();
        IObricReporter r1 = IObricReporter.a.a();
        if (r1 == null) goto L6;
        IObricReporter.b.a(r1, "OAuto_Settings", r8, r9, r11, 16);
        return;
    }

    public static Set u(Set r13, Context r14, String r15) {
        long r0 = SystemClock.elapsedRealtime();
        if (r13.isEmpty() == false) goto L6;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "toAppLabelSet, source=" + r15 + ", packageCount=0, appNameCount=0, costMs=0");
        return SetsKt.emptySet();
    L6:
        PackageManager r16 = r14.getPackageManager();
        ArrayList r5 = new ArrayList();
        Iterator r2 = r13.iterator();
    L8:
        if (r2.hasNext() == false) goto L30;
        String r6 = (String) r2.next();
        Intrinsics.checkNotNull(r16);
        Object r7 = null;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L18
        boolean r9 = false;
        String r10 = StringsKt.trim(r16.getApplicationLabel(r16.getApplicationInfo(r6, 0)).toString()).toString();     // Catch: Throwable -> L18
        if (r10.length() <= 0) goto L13;
        r9 = true;
    L13:
        if (r9 == true) goto L16;
        r10 = null;
    L16:
        Object r11 = Result.m49constructorimpl(r10);     // Catch: Throwable -> L18
    L20:
        Throwable r12 = Result.m52exceptionOrNullimpl(r11);
        if (r12 == null) goto L24;
        FLogger.a.w("ObricAutoGuiSettingsImpl", "toAppLabel failed, packageName=" + r6, r12);
    L24:
        if (Result.m55isFailureimpl(r11) == true) goto L27;
        r7 = r11;
    L27:
        String r17 = (String) r7;
        if (r17 == null) goto L8;
        r5.add(r17);
    L18:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r11 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L20
    L30:
        Set r19 = CollectionsKt.toSet(r5);
        FLogger.a.i("ObricAutoGuiSettingsImpl", "toAppLabelSet, source=" + r15 + ", packageCount=" + r13.size() + ", appNameCount=" + r19.size() + ", costMs=" + (SystemClock.elapsedRealtime() - r0));
        return r19;
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final Object a(boolean r17, boolean r18, Continuation<? super List<e>> r19) {
        if ((r19 instanceof getAutoActionAvailableAppPermissionFromUser.1) == false) goto L7;
        getAutoActionAvailableAppPermissionFromUser.1 r2 = (getAutoActionAvailableAppPermissionFromUser.1) r19;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r6 = true;
        boolean r7 = false;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        int r8 = r2.I$0;
        long r9 = r2.J$0;
        boolean r10 = r2.Z$0;
        List r11 = (List) r2.L$2;
        String r12 = (String) r2.L$1;
        ObricAutoGuiSettingsImpl r13 = (ObricAutoGuiSettingsImpl) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L14
        boolean r14 = r10;
    L37:
        Iterator r1 = ((List) r0).iterator();     // Catch: Throwable -> L14
    L38:
        if (r1.hasNext() == false) goto L62;
        String r15 = (String) r1.next();     // Catch: Throwable -> L14
        boolean r16 = e(r15, r7);     // Catch: Throwable -> L60
        FLogger r110 = FLogger.a;     // Catch: Throwable -> L14
        StringBuilder r20 = new StringBuilder();     // Catch: Throwable -> L14
        r20.append("getAutoActionAvailableAppPermissionFromUser, onlyReturnWhiteList: ");     // Catch: Throwable -> L60
        if (r14 == false) goto L46;
        boolean r21 = true;
    L47:
        r20.append(r21);     // Catch: Throwable -> L60
        r20.append(", packageName: ");     // Catch: Throwable -> L60
        r20.append(r15);     // Catch: Throwable -> L60
        r20.append(", isAppAvailable: ");     // Catch: Throwable -> L60
        if (r16 == false) goto L50;
        boolean r22 = true;
    L51:
        r20.append(r22);     // Catch: Throwable -> L60
        r110.i("ObricAutoGuiSettingsImpl", r20.toString());     // Catch: Throwable -> L60
        if (r14 == false) goto L55;
        if (r16 == true) goto L55;
    L59:
        r6 = true;
        r7 = false;
    L55:
        if (r16 == false) goto L57;
        boolean r23 = true;
    L58:
        r11.add(new e(r15, r23));     // Catch: Throwable -> L60
        goto L59
    L57:
        r23 = false;
        goto L58
    L50:
        r22 = false;
        goto L51
    L46:
        r21 = false;
    L60:
        th = th;
        r6 = true;
    L66:
        long r111 = SystemClock.elapsedRealtime() - r9;
        FLogger r24 = FLogger.a;
        StringBuilder r25 = new StringBuilder();
        r25.append(r12);
        r25.append(", cost = ");
        r25.append(r111);
        r25.append("ms, success = ");
        if (r8 == 0) goto L69;
        boolean r26 = true;
    L70:
        r25.append(r26);
        r24.i("ObricAutoGuiSettingsImpl", r25.toString());
        if (r8 != 0) goto L74;
        r6 = false;
    L74:
        r13.getClass();
        t(r12, r111, r6);
        throw th;
    L69:
        r26 = false;
    L62:
        long r28 = SystemClock.elapsedRealtime() - r9;
        FLogger.a.i("ObricAutoGuiSettingsImpl", r12 + ", cost = " + r28 + "ms, success = true");
        r13.getClass();
        t(r12, r28, true);
        return r11;
    L14:
        th = th;
        goto L66
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        r12 = "getAutoActionAvailableAppPermissionFromUser";
        r9 = SystemClock.elapsedRealtime();
        r11 = new ArrayList();     // Catch: Throwable -> L64
        if (ILoginService.a.getAccountInfo().a == true) goto L23;
    L28:
        r13 = this;
        goto L62
    L23:
        if (this.a != null) goto L26;
        q();     // Catch: Throwable -> L64
    L26:
        if (m() == true) goto L29;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "getAutoActionAvailableAppPermissionFromUser, return emptylist by permission denied");     // Catch: Throwable -> L64
        r11 = CollectionsKt.emptyList();     // Catch: Throwable -> L64
        goto L28
    L29:
        CoroutineDispatcher r29 = Dispatchers.getIO();     // Catch: Throwable -> L64
        if (r18 == false) goto L32;
        boolean r112 = true;
    L33:
        getAutoActionAvailableAppPermissionFromUser.2.availablePackageNames.1 r30 = new getAutoActionAvailableAppPermissionFromUser.2.availablePackageNames.1(r112, this, null);     // Catch: Throwable -> L64
        r2.L$0 = this;     // Catch: Throwable -> L64
        r2.L$1 = "getAutoActionAvailableAppPermissionFromUser";     // Catch: Throwable -> L64
        r2.L$2 = r11;     // Catch: Throwable -> L64
        r14 = r17;
        r2.Z$0 = r14;     // Catch: Throwable -> L64
        r2.J$0 = r9;     // Catch: Throwable -> L64
        r2.I$0 = 0;     // Catch: Throwable -> L64
        r2.label = 1;     // Catch: Throwable -> L64
        r0 = BuildersKt.withContext(r29, r30, r2);     // Catch: Throwable -> L64
        if (r0 != r4) goto L36;
        return r4;
    L36:
        r13 = this;
        r8 = 0;
        goto L37
    L32:
        r112 = false;
    L64:
        th = th;
        r13 = this;
        r8 = 0;
    L7:
        r2 = new getAutoActionAvailableAppPermissionFromUser.1(this, r19);
        goto L8
    }
}
