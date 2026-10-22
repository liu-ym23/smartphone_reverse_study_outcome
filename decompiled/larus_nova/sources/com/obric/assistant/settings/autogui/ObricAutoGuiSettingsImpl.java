package com.obric.assistant.settings.autogui;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.keva.Keva;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.AutoGuiAppScopeConfig;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.permission.IObricPermissionService;
import com.obric.assistant.reporter.IObricReporter;
import com.obric.assistant.settings.IObricAutoBlacklistSettingsNotifier;
import com.obric.assistant.settings.IObricAutoGuiSettingsApi;
import com.obric.assistant.settings.ObricAppListMode;
import com.obric.assistant.settings.h1;
import com.obric.assistant.t1;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 e2\u00020\u0001:\u0007efghijkB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0018H\u0016J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0018H\u0016J\b\u0010#\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u001dH\u0002J\u000e\u0010'\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010(J\u0016\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0016H\u0096@¢\u0006\u0002\u0010(J\u000e\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010(J\u0018\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u000200H\u0082@¢\u0006\u0002\u00101J0\u00102\u001a\u00020,*\u00020.2\u0006\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u0018062\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001806H\u0002J(\u00108\u001a\b\u0012\u0004\u0012\u00020\u001806*\b\u0012\u0004\u0012\u00020\u0018062\u0006\u00103\u001a\u0002042\u0006\u00109\u001a\u00020\u0018H\u0002J\u0016\u0010:\u001a\u0004\u0018\u00010\u0018*\u00020\u00182\u0006\u0010;\u001a\u00020<H\u0002J\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001806*\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0016H\u0002J\b\u0010>\u001a\u000200H\u0002J\u0018\u0010?\u001a\u00020@2\u0006\u0010/\u001a\u0002002\u0006\u0010A\u001a\u00020\u0018H\u0002J\u0016\u0010B\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0016H\u0082@¢\u0006\u0002\u0010(J\u000e\u0010C\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010(J\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00180\u0016H\u0082@¢\u0006\u0002\u0010(J\u0010\u0010E\u001a\u00020F2\u0006\u00103\u001a\u000204H\u0002J$\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u00162\u0006\u0010I\u001a\u00020@2\u0006\u0010J\u001a\u00020@H\u0096@¢\u0006\u0002\u0010KJ\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020H0\u0016H\u0096@¢\u0006\u0002\u0010(J\u000e\u0010M\u001a\u00020NH\u0096@¢\u0006\u0002\u0010(J\u000e\u0010O\u001a\u00020NH\u0096@¢\u0006\u0002\u0010(J\u0018\u0010P\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020@H\u0016J\u0018\u0010R\u001a\u00020@2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010S\u001a\u00020@H\u0016J\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u00103\u001a\u000204H\u0002J\u0016\u0010U\u001a\b\u0012\u0004\u0012\u00020\n0\u00162\u0006\u00103\u001a\u000204H\u0002J\u0016\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u00162\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010X\u001a\u00020@2\u0006\u0010Y\u001a\u00020\u0018H\u0002J\u0010\u0010Z\u001a\u00020@2\u0006\u0010;\u001a\u00020<H\u0002J*\u0010[\u001a\u0002H\\\"\u0004\b\u0000\u0010\\2\u0006\u0010]\u001a\u00020\u00182\f\u0010^\u001a\b\u0012\u0004\u0012\u0002H\\0_H\u0082\b¢\u0006\u0002\u0010`J \u0010a\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020\u00182\u0006\u0010b\u001a\u00020\u00112\u0006\u0010c\u001a\u00020@H\u0002J\b\u0010d\u001a\u00020@H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006l"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoGuiSettingsImpl;", "Lcom/obric/assistant/settings/IObricAutoGuiSettingsApi;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "cleanupScope", "Lkotlinx/coroutines/CoroutineScope;", "appInfoComparator", "Ljava/util/Comparator;", "Lcom/obric/assistant/settings/AppInfo;", "Lkotlin/Comparator;", "currentAutoActionAppDataSource", "Lcom/obric/assistant/settings/AutoActionAppDataSource;", "cloudPolicyCacheLock", "", "accountGeneration", "", "lastSuccessfulCloudPolicy", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiSettingsImpl$CloudAppPolicySnapshot;", "currentAutoActionAppDataSourceFromOs", "launcherAppsCache", "", "launcherAppPackageNamesCache", "", "userID", "getUserID", "()Ljava/lang/String;", "initKeva", "", "invalidateAccountScopedCaches", "invalidateLauncherAppsCache", "onAppUninstalled", "packageName", "onAppInstalled", "cleanupKevaAgainstInstalledAppsIfNeeded", "removeKevaValueForPackage", "migrateSettingsIfNeeded", "doMigrateSettingsIfNeeded", "getAutoActionAppBlacklistFromCloudAndOs", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppSoftBlacklistFromCloud", "Lcom/obric/assistant/settings/ObricAppBlacklistItem;", "getAutoActionAppFilterPolicyForRecommendation", "Lcom/obric/assistant/settings/AutoActionAppFilterPolicy;", "fetchCloudAppPolicy", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiSettingsImpl$CloudAppPolicy;", "accountScope", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiSettingsImpl$AccountScope;", "(Lcom/obric/assistant/settings/autogui/ObricAutoGuiSettingsImpl$AccountScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toAppFilterPolicy", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "saepRestrictedPackages", "", "saepDeclaredPackages", "toAppLabelSet", "source", "toAppLabel", "packageManager", "Landroid/content/pm/PackageManager;", "toAppNameSet", "captureAccountScope", "isCurrentAccountLocked", "", "currentUserId", "fetchAppSoftBlacklistFromCloud", "getAutoActionAppBlacklistFromOs", "getAvailableAppPackageNamesFromCloudAndOs", "getLauncherPackageSnapshot", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiSettingsImpl$LauncherPackageSnapshot;", "getAutoActionAvailableAppPermissionFromUser", "Lcom/obric/assistant/settings/AutoActionBlacklistByUserItem;", "onlyReturnWhiteList", "isClientOnly", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAutoActionAppBlacklistFromUser", "getAutoActionMergedBlacklistForSystemSettings", "Lcom/obric/assistant/settings/SystemSettingsAppListResult;", "getAutoActionA16UserAvailableApps", "setAppState", "isEnable", "getAppState", "defVal", "getLauncherAppPackageNamesInternal", "getLauncherAppsInternal", "queryLauncherResolveInfoList", "Landroid/content/pm/ResolveInfo;", "isMiniProgramActivity", "activityName", "isDoubaoMiniAppInstalled", "trackDuration", ExifInterface.GPS_DIRECTION_TRUE, "methodName", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "reportMethodDuration", "duration", "success", "checkPackagePermission", "Companion", "CloudAppPolicy", "AppScopeInputs", "LauncherPackageSnapshot", "SystemSettingsAppScopeInputs", "AccountScope", "CloudAppPolicySnapshot", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAutoGuiSettingsImpl implements IObricAutoGuiSettingsApi {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Set<String> f391829i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final List<String> f391830j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Keva f391831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f391832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i0 f391833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f391834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f391835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f391836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile List<com.obric.assistant.settings.b> f391837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile List<String> f391838h;

    public static final class a implements n38.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObricAutoGuiSettingsImpl f391839a;

        public a(ObricAutoGuiSettingsImpl r100) {
            this.f391839a = r100;
        }

        @Override // n38.j
        public final void a(n38.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            ObricAutoGuiSettingsImpl r101 = this.f391839a;
            Set<String> r102 = ObricAutoGuiSettingsImpl.f391829i;
            Object r103 = r101.f391834d;
            monitor-enter(r103);
            r101.f391835e++;     // Catch: Throwable -> L7
            r101.f391836f = null;     // Catch: Throwable -> L7
            Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r103);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // n38.j
        public final void b(n38.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "onUserDidOnline, user login, init keva");
            ObricAutoGuiSettingsImpl r101 = this.f391839a;
            Set<String> r102 = ObricAutoGuiSettingsImpl.f391829i;
            r101.q();
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f391840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f391841b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f391840a, r101.f391840a) == true) goto L12;
            return false;
        L12:
            if (this.f391841b == r101.f391841b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f391840a.hashCode() * 31;
            long r101 = this.f391841b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "AccountScope(userId=" + this.f391840a + ", generation=" + this.f391841b + ')';
        }

        public b(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            this.f391840a = r100;
            this.f391841b = r101;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<com.obric.assistant.settings.b> f391842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f391843b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<String> f391844c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ObricSaepRestrictedPackageReader.a f391845d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f391842a, r101.f391842a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f391843b, r101.f391843b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f391844c, r101.f391844c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f391845d, r101.f391845d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f391842a.hashCode() * 31) + this.f391843b.hashCode()) * 31) + this.f391844c.hashCode()) * 31) + this.f391845d.hashCode();
        }

        public final String toString() {
            return "AppScopeInputs(launcherApps=" + this.f391842a + ", cloudPolicy=" + this.f391843b + ", systemBlacklistPackages=" + this.f391844c + ", saepResult=" + this.f391845d + ')';
        }

        public c(List<com.obric.assistant.settings.b> r100, d r101, Set<String> r102, ObricSaepRestrictedPackageReader.a r103) {
            Intrinsics.checkNotNullParameter(r100, "launcherApps");
            Intrinsics.checkNotNullParameter(r101, "cloudPolicy");
            Intrinsics.checkNotNullParameter(r102, "systemBlacklistPackages");
            Intrinsics.checkNotNullParameter(r103, "saepResult");
            this.f391842a = r100;
            this.f391843b = r101;
            this.f391844c = r102;
            this.f391845d = r103;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ObricAppListMode f391846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.obric.assistant.settings.r> f391847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<String> f391848c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set<String> f391849d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f391850e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f391846a == r101.f391846a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f391847b, r101.f391847b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f391848c, r101.f391848c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f391849d, r101.f391849d) == true) goto L21;
            return false;
        L21:
            if (this.f391850e == r101.f391850e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f391846a.hashCode() * 31;
            List<com.obric.assistant.settings.r> r101 = this.f391847b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Set<String> r105 = this.f391848c;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            int r106 = (((r104 + r102) * 31) + this.f391849d.hashCode()) * 31;
            if (this.f391850e == false) goto L13;
            int r107 = 1231;
        L15:
            return r106 + r107;
        L13:
            r107 = 1237;
            goto L15
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "CloudAppPolicy(mode=" + this.f391846a + ", softBlacklist=" + this.f391847b + ", whitelistPackages=" + this.f391848c + ", whitelistNames=" + this.f391849d + ", isComplete=" + this.f391850e + ')';
        }

        public d(ObricAppListMode r100, List<com.obric.assistant.settings.r> r101, Set<String> r102, Set<String> r103, boolean r104) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            Intrinsics.checkNotNullParameter(r103, "whitelistNames");
            this.f391846a = r100;
            this.f391847b = r101;
            this.f391848c = r102;
            this.f391849d = r103;
            this.f391850e = r104;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f391851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ObricAppListMode f391852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<com.obric.assistant.settings.r> f391853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set<String> f391854d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Set<String> f391855e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f391851a, r101.f391851a) == true) goto L12;
            return false;
        L12:
            if (this.f391852b == r101.f391852b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f391853c, r101.f391853c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f391854d, r101.f391854d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f391855e, r101.f391855e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f391851a.hashCode() * 31) + this.f391852b.hashCode()) * 31;
            List<com.obric.assistant.settings.r> r101 = this.f391853c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Set<String> r105 = this.f391854d;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return ((r104 + r102) * 31) + this.f391855e.hashCode();
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "CloudAppPolicySnapshot(accountScope=" + this.f391851a + ", mode=" + this.f391852b + ", softBlacklist=" + this.f391853c + ", whitelistPackages=" + this.f391854d + ", whitelistNames=" + this.f391855e + ')';
        }

        public e(b r100, ObricAppListMode r101, List<com.obric.assistant.settings.r> r102, Set<String> r103, Set<String> r104) {
            Intrinsics.checkNotNullParameter(r100, "accountScope");
            Intrinsics.checkNotNullParameter(r101, "mode");
            Intrinsics.checkNotNullParameter(r104, "whitelistNames");
            this.f391851a = r100;
            this.f391852b = r101;
            this.f391853c = r102;
            this.f391854d = r103;
            this.f391855e = r104;
        }
    }

    public static final class f {
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<String> f391856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f391857b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f391856a, r101.f391856a) == true) goto L12;
            return false;
        L12:
            if (this.f391857b == r101.f391857b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f391856a.hashCode() * 31;
            if (this.f391857b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "LauncherPackageSnapshot(packages=" + this.f391856a + ", isComplete=" + this.f391857b + ')';
        }

        public g(Set<String> r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "packages");
            this.f391856a = r100;
            this.f391857b = r101;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f391858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f391859b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o0.a f391860c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ObricSaepRestrictedPackageReader.a f391861d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (Intrinsics.areEqual(this.f391858a, r101.f391858a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f391859b, r101.f391859b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f391860c, r101.f391860c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f391861d, r101.f391861d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f391858a.hashCode() * 31) + this.f391859b.hashCode()) * 31) + this.f391860c.hashCode()) * 31) + this.f391861d.hashCode();
        }

        public final String toString() {
            return "SystemSettingsAppScopeInputs(launcherPackages=" + this.f391858a + ", cloudPolicy=" + this.f391859b + ", deviceConfigResult=" + this.f391860c + ", saepResult=" + this.f391861d + ')';
        }

        public h(g r100, d r101, o0.a r102, ObricSaepRestrictedPackageReader.a r103) {
            Intrinsics.checkNotNullParameter(r100, "launcherPackages");
            Intrinsics.checkNotNullParameter(r101, "cloudPolicy");
            Intrinsics.checkNotNullParameter(r102, "deviceConfigResult");
            Intrinsics.checkNotNullParameter(r103, "saepResult");
            this.f391858a = r100;
            this.f391859b = r101;
            this.f391860c = r102;
            this.f391861d = r103;
        }
    }

    static {
        f391829i = SetsKt.setOf("auto_gui_app_migrated_action");
        f391830j = CollectionsKt.listOf(new String[]{"miniapp", "miniprogram", "mini.app"});
    }

    public static boolean m() {
        if (Build.VERSION.SDK_INT < 23) goto L31;
        IObricPermissionService r100 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r100 == null) goto L7;
        boolean r101 = r100.o();
    L8:
        Application r102 = AppHost.f326268a.getApplication();
        ArrayList r110 = new ArrayList();
        Object[] r111 = {"com.android.permission.GET_INSTALLED_APPS"};
        f06.b r112 = new f06.b("auto_cert_com_obric_assistant_settings_autogui_ObricAutoGuiSettingsImpl_android_app_Application_checkSelfPermission");
        g06.a r103 = ApiHookConfig.f245611b.get(102608);
        if (r103 == null) goto L11;
        f06.a[] r104 = r103.f479473i;
    L12:
        f06.a[] r113 = r104;
        int r114 = r113.length;
        int r105 = 0;
    L14:
        if (r105 >= r114) goto L21;
        f06.a r106 = r113[r105];
        int r115 = r105;
        int r210 = r114;
        f06.a[] r211 = r113;
        f06.d r107 = r106.preInvoke(102608, "android/app/Application", "checkSelfPermission", r102, r111, "int", r112);     // Catch: Exception -> L33
        if (r107.f474982a == true) goto L23;
        r110.add(r106);     // Catch: Exception -> L33
    L23:
        if (r107.f474982a == false) goto L25;
        int r108 = ((Integer) r107.f474983b).intValue();
    L26:
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "checkPackagePermission, isSupportAppListPermission: " + r101 + ", ret: " + r108);
        if (r101 == false) goto L31;
        if (r108 == 0) goto L31;
        return false;
    L25:
        r108 = r102.checkSelfPermission("com.android.permission.GET_INSTALLED_APPS");
    L20:
        r105 = r115 + 1;
        r114 = r210;
        r113 = r211;
        goto L14
    L21:
        r107 = new f06.d(false, null);
        goto L23
    L11:
        r104 = ApiHookConfig.f245613d;
        goto L12
    L7:
        r101 = false;
    L31:
        return true;
    }

    public final b l() {
        String r100 = ILoginService.f286097a.getAccountInfo().f531530c;
        Object r101 = this.f391834d;
        monitor-enter(r101);
        b r102 = new b(r100, this.f391835e);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public final void q() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("initKeva with user id ");
        ILoginService.Companion r102 = ILoginService.f286097a;
        r101.append(com.obric.assistant.utils.j.d(r102.getAccountInfo().f531530c));
        r100.i("ObricAutoGuiSettingsImpl", r101.toString());
        this.f391831a = Keva.getRepo("obric_auto_gui_settings_" + r102.getAccountInfo().f531530c, 0);
        this.f391837g = null;
        this.f391838h = null;
        Object r103 = this.f391834d;
        monitor-enter(r103);
        this.f391835e++;     // Catch: Throwable -> L21
        this.f391836f = null;     // Catch: Throwable -> L21
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r103);
        if (com.obric.assistant.common.utils.l.a(null) == false) goto L14;
        if (r102.getAccountInfo().f531528a == true) goto L12;
        r100.i("ObricAutoGuiSettingsImpl", "migrateSettingsIfNeeded, not login, skip");
        goto L14
    L12:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ObricAutoGuiSettingsImpl$migrateSettingsIfNeeded$1(this, null), 3, null);
    L14:
        if (com.obric.assistant.common.utils.l.a(null) == true) goto L17;
        return;
    L17:
        if (m() == true) goto L19;
        r100.i("ObricAutoGuiSettingsImpl", "cleanupKevaAgainstInstalledAppsIfNeeded: no package permission, skip");
        return;
    L19:
        BuildersKt.launch$default(this.f391832b, null, null, new ObricAutoGuiSettingsImpl$cleanupKevaAgainstInstalledAppsIfNeeded$1(this, null), 3, null);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.assistant.settings.autogui.i0] */
    public ObricAutoGuiSettingsImpl() {
        this.f391832b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f391833c = new i0();
        this.f391834d = new Object();
        FLogger r100 = FLogger.f375446a;
        r100.i("ObricAutoGuiSettingsImpl", "init");
        ILoginService.Companion r101 = ILoginService.f286097a;
        ILoginService.a.c(r101, new a(this));
        if (r101.getAccountInfo().f531528a == false) goto L6;
        r100.i("ObricAutoGuiSettingsImpl", "init, already login, init keva");
        q();
        return;
    }

    public static boolean s(String r100) {
        List<String> r101 = f391830j;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        if (StringsKt.contains(r100, (String) r102.next(), true) == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r101.isEmpty() == false) goto L7;
        goto L7
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final Object b(Continuation<? super com.obric.assistant.settings.d> r110) {
        if ((r110 instanceof ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$1) == false) goto L7;
        ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$1 r100 = (ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        int r105 = r100.I$0;
        long r106 = r100.J$0;
        String r107 = (String) r100.L$1;
        ObricAutoGuiSettingsImpl r108 = (ObricAutoGuiSettingsImpl) r100.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L14
    L23:
        com.obric.assistant.settings.d r112 = (com.obric.assistant.settings.d) r111;     // Catch: Throwable -> L14
        long r109 = SystemClock.elapsedRealtime() - r106;
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", r107 + ", cost = " + r109 + "ms, success = true");
        r108.getClass();
        t(r107, r109, true);
        return r112;
    L14:
        th = move-exception;
        ObricAutoGuiSettingsImpl r113 = r108;
        th = th;
        String r114 = r107;
        int r115 = r105;
        ObricAutoGuiSettingsImpl r116 = r113;
    L29:
        long r117 = SystemClock.elapsedRealtime() - r106;
        FLogger r118 = FLogger.f375446a;
        StringBuilder r119 = new StringBuilder();
        r119.append(r114);
        r119.append(", cost = ");
        r119.append(r117);
        r119.append("ms, success = ");
        if (r115 == 0) goto L32;
        boolean r120 = true;
    L33:
        r119.append(r120);
        r118.i("ObricAutoGuiSettingsImpl", r119.toString());
        if (r115 != 0) goto L37;
        r104 = false;
    L37:
        r116.getClass();
        t(r114, r117, r104);
        throw th;
    L32:
        r120 = false;
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r111);
        r114 = "getAutoActionAppFilterPolicyForRecommendation";
        r106 = SystemClock.elapsedRealtime();
        ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$2$1 r121 = new ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$2$1(this, t1.f393353a.s0(), AppHost.f326268a.getApplication().getApplicationContext(), null);     // Catch: Throwable -> L27
        r100.L$0 = this;     // Catch: Throwable -> L27
        r100.L$1 = "getAutoActionAppFilterPolicyForRecommendation";     // Catch: Throwable -> L27
        r100.J$0 = r106;     // Catch: Throwable -> L27
        r100.I$0 = 0;     // Catch: Throwable -> L27
        r100.label = 1;     // Catch: Throwable -> L27
        Object r122 = CoroutineScopeKt.coroutineScope(r121, r100);     // Catch: Throwable -> L27
        if (r122 != r102) goto L22;
        return r102;
    L22:
        r107 = "getAutoActionAppFilterPolicyForRecommendation";
        r111 = r122;
        r105 = 0;
        r108 = this;
    L27:
        th = th;
        r116 = this;
        r115 = 0;
    L7:
        r100 = new ObricAutoGuiSettingsImpl$getAutoActionAppFilterPolicyForRecommendation$1(this, r110);
        goto L8
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final Object c(Continuation<? super h1> r100) {
        if ((r100 instanceof ObricAutoGuiSettingsImpl$getAutoActionA16UserAvailableApps$1) == false) goto L7;
        ObricAutoGuiSettingsImpl$getAutoActionA16UserAvailableApps$1 r101 = (ObricAutoGuiSettingsImpl$getAutoActionA16UserAvailableApps$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L26:
        return new h1((List) r103, true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        if (ILoginService.f286097a.getAccountInfo().f531528a == true) goto L19;
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "getAutoActionA16UserAvailableApps, not login, incomplete");
        return new h1(CollectionsKt.emptyList(), false);
    L19:
        if (m() == true) goto L22;
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "getAutoActionA16UserAvailableApps, no package permission, incomplete");
        return new h1(CollectionsKt.emptyList(), false);
    L22:
        r101.label = 1;
        r103 = IObricAutoGuiSettingsApi.a.a(this, true, r101, 2);
        if (r103 != r104) goto L26;
        return r104;
    L7:
        r101 = new ObricAutoGuiSettingsImpl$getAutoActionA16UserAvailableApps$1(this, r100);
        goto L8
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        if (StringsKt.isBlank(r100) == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r100, AppHost.f326268a.getApplication().getPackageName()) == false) goto L8;
        return;
    L8:
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "onAppInstalled: packageName=".concat(r100));
        this.f391837g = null;
        this.f391838h = null;
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final Object f(Continuation<? super h1> r110) {
        if ((r110 instanceof ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$1) == false) goto L7;
        ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$1 r100 = (ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        AutoGuiAppScopeConfig r106 = (AutoGuiAppScopeConfig) r102.L$1;
        b r107 = (b) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L18:
        h r108 = (h) r103;
        g r109 = r108.f391858a;
        d r111 = r108.f391859b;
        o0.a r112 = r108.f391860c;
        ObricSaepRestrictedPackageReader.a r113 = r108.f391861d;
        List<com.obric.assistant.settings.r> r114 = r111.f391847b;
        List r115 = null;
        if (r114 == null) goto L39;
        ArrayList r116 = new ArrayList();
        Iterator<T> r117 = r114.iterator();
    L22:
        if (r117.hasNext() == false) goto L38;
        com.obric.assistant.settings.r r118 = (com.obric.assistant.settings.r) r117.next();
        if (r118 == null) goto L35;
        String r119 = r118.e();
        if (r119 == null) goto L35;
        String r120 = StringsKt.trim(r119).toString();
        if (r120 == null) goto L35;
        if (r120.length() <= 0) goto L32;
        boolean r121 = true;
    L33:
        if (r121 == false) goto L35;
    L36:
        if (r120 == null) goto L22;
        r116.add(r120);
        goto L22
    L32:
        r121 = false;
    L35:
        r120 = null;
        goto L36
    L38:
        r115 = r116;
    L39:
        if (r115 != null) goto L41;
        r115 = CollectionsKt.emptyList();
    L41:
        Set<String> r122 = r111.f391848c;
        if (r111.f391846a != ObricAppListMode.WHITE_LIST) goto L52;
        if (r122 != null) goto L45;
        Collection r123 = r109.f391856a;
    L54:
        if (r106.getEnableSaepRestrictedPackages() == true) goto L56;
        Set<String> r124 = SetsKt.emptySet();
    L59:
        Set<String> r125 = r113.f391876b;
        if (r125 != null) goto L62;
        r125 = SetsKt.emptySet();
    L62:
        List r126 = CollectionsKt.plus(r115, r123);
        ArrayList r127 = new ArrayList();
        Iterator r128 = r126.iterator();
    L64:
        if (r128.hasNext() == false) goto L69;
        Object r129 = r128.next();
        if (r125.contains((String) r129) == true) goto L64;
        r127.add(r129);
        goto L64
    L69:
        List<String> r130 = r112.f391942a;
        ArrayList r131 = new ArrayList();
        Iterator<T> r132 = r130.iterator();
    L71:
        if (r132.hasNext() == false) goto L75;
        Object r133 = r132.next();
        if (r125.contains((String) r133) == true) goto L71;
        r131.add(r133);
        goto L71
    L75:
        List r134 = CollectionsKt.distinct(CollectionsKt.plus(CollectionsKt.plus(r127, r131), r124));
        if (r(r107, ILoginService.f286097a.getAccountInfo().f531530c) == true) goto L78;
    L89:
        boolean r135 = false;
    L90:
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "getAutoActionMergedBlacklistForSystemSettings, cloudMode: " + r111.f391846a.getValue() + ", cloudBlacklist: " + r115.size() + ", cloudWhitelistBlocked: " + r123.size() + ", deviceConfig: " + r112.f391942a.size() + "(success=" + r112.f391943b + "), saepRestricted: " + r124.size() + ", saepDeclared: " + r125.size() + ", saepComplete: " + r113.f391877c + ", saepSource: " + r113.f391878d + ", launcher: " + r109.f391856a.size() + "(complete=" + r109.f391857b + "), merged: " + r134.size() + ", isComplete: " + r135);
        List r136 = r134;
        ArrayList r137 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r136, 10));
        Iterator r138 = r136.iterator();
    L92:
        if (r138.hasNext() == false) goto L95;
        r137.add(new com.obric.assistant.settings.e((String) r138.next(), false));
        goto L92
    L95:
        return new h1(r137, r135);
    L78:
        if (r112.f391943b == false) goto L89;
        if (r113.f391877c == false) goto L89;
        if (r111.f391850e == false) goto L89;
        if (r111.f391846a == ObricAppListMode.WHITE_LIST) goto L86;
    L88:
        r135 = true;
        goto L90
    L86:
        if (r109.f391857b == false) goto L89;
        if (r122 == null) goto L89;
    L56:
        r124 = r113.f391875a;
        if (r124 != null) goto L59;
        r124 = SetsKt.emptySet();
        goto L59
    L45:
        Set<String> r139 = r109.f391856a;
        ArrayList r140 = new ArrayList();
        Iterator<T> r141 = r139.iterator();
    L47:
        if (r141.hasNext() == false) goto L51;
        Object r142 = r141.next();
        if ((!r122.contains((String) r142)) == false) goto L47;
        r140.add(r142);
        goto L47
    L51:
        r123 = r140;
        goto L54
    L52:
        r123 = CollectionsKt.emptyList();
        goto L54
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        b r143 = l();
        Context r144 = AppHost.f326268a.getApplication().getApplicationContext();
        AutoGuiAppScopeConfig r145 = t1.f393353a.s0();
        ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2 r146 = new ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2(this, r144, r143, r145, null);
        r102.L$0 = r143;
        r102.L$1 = r145;
        r102.label = 1;
        r103 = CoroutineScopeKt.coroutineScope(r146, r102);
        if (r103 != r104) goto L17;
        return r104;
    L17:
        r107 = r143;
        r106 = r145;
    L7:
        r100 = new ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$1(this, r110);
        goto L8
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        if (StringsKt.isBlank(r100) == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r100, AppHost.f326268a.getApplication().getPackageName()) == false) goto L8;
        return;
    L8:
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "onAppUninstalled: packageName=".concat(r100));
        this.f391837g = null;
        this.f391838h = null;
        BuildersKt.launch$default(this.f391832b, null, null, new ObricAutoGuiSettingsImpl$onAppUninstalled$1(this, r100, null), 3, null);
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final Object i(Continuation<? super com.obric.assistant.settings.c> r310) {
        if ((r310 instanceof ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$1) == false) goto L7;
        ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$1 r100 = (ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$1) r310;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        int r106 = r102.I$0;
        long r107 = r102.J$0;
        AutoGuiAppScopeConfig r108 = (AutoGuiAppScopeConfig) r102.L$3;
        b r109 = (b) r102.L$2;
        String r110 = (String) r102.L$1;
        ObricAutoGuiSettingsImpl r111 = (ObricAutoGuiSettingsImpl) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L14
        AutoGuiAppScopeConfig r311 = r108;
        String r210 = "setupAvailableAppList, appList, list.size: ";
        b r112 = r109;
        String r113 = r110;
        long r114 = r107;
        int r115 = r106;
        ObricAutoGuiSettingsImpl r116 = r111;
    L99:
        c r117 = (c) r103;     // Catch: Throwable -> L76
        List<com.obric.assistant.settings.b> r118 = r117.f391842a;     // Catch: Throwable -> L76
        d r119 = r117.f391843b;     // Catch: Throwable -> L76
        Set<String> r120 = r117.f391844c;     // Catch: Throwable -> L76
        ObricSaepRestrictedPackageReader.a r121 = r117.f391845d;     // Catch: Throwable -> L76
        FLogger r122 = FLogger.f375446a;     // Catch: Throwable -> L76
        int r123 = r115;
        ObricAutoGuiSettingsImpl r124 = r116;
        r122.i("ObricAutoGuiSettingsImpl", r210 + r118.size() + ", " + r118);     // Catch: Throwable -> L72
        List<com.obric.assistant.settings.r> r125 = r119.f391847b;     // Catch: Throwable -> L72
        StringBuilder r126 = new StringBuilder("setupAvailableAppList, appBlacklist, list: ");     // Catch: Throwable -> L72
        r126.append(r125);     // Catch: Throwable -> L72
        r122.i("ObricAutoGuiSettingsImpl", r126.toString());     // Catch: Throwable -> L72
        r122.i("ObricAutoGuiSettingsImpl", "setupAvailableAppList, systemBlacklistPackages: " + r120);     // Catch: Throwable -> L72
        r122.i("ObricAutoGuiSettingsImpl", "setupAvailableAppList, saepEnable: " + r311.getEnableSaepRestrictedPackages() + ", saepResult: " + r121);     // Catch: Throwable -> L72
        int r127 = j.f391931a;     // Catch: Throwable -> L72
        j.a r128 = j.a(r118, r125, r120, r121.f391875a, r121.f391876b, r119.f391848c, r119.f391846a, r311);     // Catch: Throwable -> L72
        r122.i("ObricAutoGuiSettingsImpl", "setupAvailableAppList, cloud mode: " + r119.f391846a.getValue());     // Catch: Throwable -> L72
        StringBuilder r129 = new StringBuilder("setupAvailableAppList, cloud blacklist size:  ");     // Catch: Throwable -> L72
        if (r125 != null) goto L103;
        int r130 = 0;
    L40:
        r129.append(r130);     // Catch: Throwable -> L72
        r122.i("ObricAutoGuiSettingsImpl", r129.toString());     // Catch: Throwable -> L72
        StringBuilder r131 = new StringBuilder("setupAvailableAppList, cloud whitelist size: ");     // Catch: Throwable -> L72
        Set<String> r132 = r119.f391848c;     // Catch: Throwable -> L72
        int r133 = -1;
        if (r132 == null) goto L45;
        int r134 = r132.size();     // Catch: Throwable -> L37
    L46:
        r131.append(r134);     // Catch: Throwable -> L72
        r131.append(", saep restricted size: ");     // Catch: Throwable -> L72
        Set<String> r135 = r121.f391875a;     // Catch: Throwable -> L72
        if (r135 == null) goto L50;
        int r136 = r135.size();     // Catch: Throwable -> L37
    L51:
        r131.append(r136);     // Catch: Throwable -> L72
        r131.append(", saep declared size: ");     // Catch: Throwable -> L72
        Set<String> r137 = r121.f391876b;     // Catch: Throwable -> L72
        if (r137 == null) goto L57;
        r133 = r137.size();     // Catch: Throwable -> L37
    L37:
        th = th;
        r110 = r113;
        int r138 = r123;
        r111 = r124;
    L56:
        String r139 = r110;
        r123 = r138;
        boolean r140 = true;
    L87:
        long r141 = SystemClock.elapsedRealtime() - r114;
        FLogger r142 = FLogger.f375446a;
        StringBuilder r143 = new StringBuilder();
        r143.append(r139);
        r143.append(", cost = ");
        r143.append(r141);
        r143.append("ms, success = ");
        if (r123 == 0) goto L90;
        boolean r144 = true;
    L91:
        r143.append(r144);
        r142.i("ObricAutoGuiSettingsImpl", r143.toString());
        if (r123 != 0) goto L95;
        r140 = false;
    L95:
        r111.getClass();
        t(r139, r141, r140);
        throw th;
    L90:
        r144 = false;
    L57:
        r131.append(r133);     // Catch: Throwable -> L72
        r131.append(", saep complete: ");     // Catch: Throwable -> L72
        r131.append(r121.f391877c);     // Catch: Throwable -> L72
        r131.append(", saep source: ");     // Catch: Throwable -> L72
        r131.append(r121.f391878d);     // Catch: Throwable -> L72
        r122.i("ObricAutoGuiSettingsImpl", r131.toString());     // Catch: Throwable -> L72
        r122.i("ObricAutoGuiSettingsImpl", "setupAvailableAppList, blacklistExist, size: " + r128.f391933b.size());     // Catch: Throwable -> L72
        r122.i("ObricAutoGuiSettingsImpl", "setupAvailableAppList, availableList.size: " + r128.f391932a.size());     // Catch: Throwable -> L72
        com.obric.assistant.settings.c r145 = new com.obric.assistant.settings.c(CollectionsKt.sortedWith(r128.f391932a, this.f391833c), r125, CollectionsKt.sortedWith(r128.f391933b, this.f391833c));     // Catch: Throwable -> L72
        String r146 = ILoginService.f286097a.getAccountInfo().f531530c;     // Catch: Throwable -> L72
        Object r147 = this.f391834d;     // Catch: Throwable -> L72
        monitor-enter(r147);     // Catch: Throwable -> L72
    L66:
        th = move-exception;
        r140 = true;
    L70:
        th = th;
    L79:
        r139 = r113;
        r111 = r124;
        goto L87
    L69:
        throw th;     // Catch: Throwable -> L70
    L60:
        if (r(r112, r146) == true) goto L63;
        r122.w("ObricAutoGuiSettingsImpl", "setupAvailableAppList, account changed while resolving, discard result");     // Catch: Throwable -> L66
        r145 = new com.obric.assistant.settings.c(CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());     // Catch: Throwable -> L66
    L63:
        monitor-exit(r147);     // Catch: Throwable -> L72
        long r148 = SystemClock.elapsedRealtime() - r114;
        r122.i("ObricAutoGuiSettingsImpl", r113 + ", cost = " + r148 + "ms, success = true");
        r124.getClass();
        t(r113, r148, true);
        return r145;
    L50:
        r136 = -1;
        goto L51
    L45:
        r134 = -1;
        goto L46
    L103:
        r130 = r125.size();     // Catch: Throwable -> L37
    L72:
        th = th;
    L73:
        r140 = true;
    L74:
        th = th;
    L78:
        r124 = r116;
    L76:
        th = th;
        r123 = r115;
    L14:
        th = th;
        r114 = r107;
        r138 = r106;
        goto L56
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        long r149 = SystemClock.elapsedRealtime();
        b r150 = l();     // Catch: Throwable -> L84
        AutoGuiAppScopeConfig r151 = t1.f393353a.s0();     // Catch: Throwable -> L84
        r114 = r149;
        r113 = "getAutoActionAppBlacklistFromCloudAndOs";
        r210 = "setupAvailableAppList, appList, list.size: ";
        ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$2$1 r152 = new ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$2$1(this, AppHost.f326268a.getApplication().getApplicationContext(), r150, r151, null);     // Catch: Throwable -> L82
        r102.L$0 = this;     // Catch: Throwable -> L82
        r102.L$1 = r113;     // Catch: Throwable -> L82
        r102.L$2 = r150;     // Catch: Throwable -> L82
        r102.L$3 = r151;     // Catch: Throwable -> L82
        r102.J$0 = r114;     // Catch: Throwable -> L82
        r102.I$0 = 0;     // Catch: Throwable -> L82
        r140 = true;
        r102.label = 1;     // Catch: Throwable -> L80
        Object r153 = CoroutineScopeKt.coroutineScope(r152, r102);     // Catch: Throwable -> L82
        if (r153 != r104) goto L28;
        return r104;
    L28:
        r116 = this;
        r311 = r151;
        r115 = 0;
        r103 = r153;
        r112 = r150;
    L80:
        th = th;
    L86:
        r111 = this;
        r139 = r113;
        r123 = 0;
    L82:
        th = th;
    L83:
        r140 = true;
    L84:
        th = th;
        r114 = r149;
        r113 = "getAutoActionAppBlacklistFromCloudAndOs";
    L7:
        r100 = new ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$1(this, r310);
        goto L8
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final Object j(Continuation<? super List<com.obric.assistant.settings.e>> r110) {
        if ((r110 instanceof ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromUser$1) == false) goto L7;
        ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromUser$1 r100 = (ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromUser$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = false;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        int r106 = r100.I$0;
        long r107 = r100.J$0;
        List r108 = (List) r100.L$2;
        String r111 = (String) r100.L$1;
        ObricAutoGuiSettingsImpl r109 = (ObricAutoGuiSettingsImpl) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14
    L37:
        Iterator r112 = ((List) r102).iterator();     // Catch: Throwable -> L14
    L38:
        if (r112.hasNext() == false) goto L48;
        String r113 = (String) r112.next();     // Catch: Throwable -> L14
        boolean r114 = e(r113, false);     // Catch: Throwable -> L14
        FLogger r115 = FLogger.f375446a;     // Catch: Throwable -> L14
        StringBuilder r116 = new StringBuilder();     // Catch: Throwable -> L14
        r116.append("getAutoActionAppBlacklistFromUser, packageName: ");     // Catch: Throwable -> L14
        r116.append(r113);     // Catch: Throwable -> L14
        r116.append(", isAppAvailable: ");     // Catch: Throwable -> L14
        if (r114 == false) goto L43;
        boolean r117 = true;
    L44:
        r116.append(r117);     // Catch: Throwable -> L14
        r115.i("ObricAutoGuiSettingsImpl", r116.toString());     // Catch: Throwable -> L14
        if (r114 == true) goto L38;
        r108.add(new com.obric.assistant.settings.e(r113, false));     // Catch: Throwable -> L14
        goto L38
    L43:
        r117 = false;
    L48:
        long r118 = SystemClock.elapsedRealtime() - r107;
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", r111 + ", cost = " + r118 + "ms, success = true");
        r109.getClass();
        t(r111, r118, true);
        return r108;
    L14:
        th = th;
    L52:
        long r119 = SystemClock.elapsedRealtime() - r107;
        FLogger r120 = FLogger.f375446a;
        StringBuilder r121 = new StringBuilder();
        r121.append(r111);
        r121.append(", cost = ");
        r121.append(r119);
        r121.append("ms, success = ");
        if (r106 == 0) goto L55;
        boolean r122 = true;
    L56:
        r121.append(r122);
        r120.i("ObricAutoGuiSettingsImpl", r121.toString());
        if (r106 == 0) goto L59;
        r105 = true;
    L59:
        r109.getClass();
        t(r111, r119, r105);
        throw th;
    L55:
        r122 = false;
        goto L56
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        r111 = "getAutoActionAppBlacklistFromUser";
        r107 = SystemClock.elapsedRealtime();
        r108 = new ArrayList();     // Catch: Throwable -> L50
        if (ILoginService.f286097a.getAccountInfo().f531528a == true) goto L23;
    L31:
        r109 = this;
        goto L48
    L23:
        if (this.f391831a != null) goto L29;
        q();     // Catch: Throwable -> L26
    L26:
        th = th;
        r109 = this;
        r106 = 0;
    L29:
        if (m() == true) goto L33;
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "getAutoActionAppBlacklistFromUser, return emptylist by permission denied");     // Catch: Throwable -> L26
        r108 = CollectionsKt.emptyList();     // Catch: Throwable -> L26
        goto L31
    L33:
        CoroutineDispatcher r123 = Dispatchers.getIO();     // Catch: Throwable -> L50
        ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromUser$2$availablePackageNames$1 r124 = new ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromUser$2$availablePackageNames$1(this, null);     // Catch: Throwable -> L50
        r100.L$0 = this;     // Catch: Throwable -> L50
        r100.L$1 = "getAutoActionAppBlacklistFromUser";     // Catch: Throwable -> L50
        r100.L$2 = r108;     // Catch: Throwable -> L50
        r100.J$0 = r107;     // Catch: Throwable -> L50
        r100.I$0 = 0;     // Catch: Throwable -> L50
        r100.label = 1;     // Catch: Throwable -> L50
        r102 = BuildersKt.withContext(r123, r124, r100);     // Catch: Throwable -> L50
        if (r102 != r103) goto L36;
        return r103;
    L36:
        r109 = this;
        r106 = 0;
    L50:
        th = th;
        r109 = this;
        r106 = 0;
    L7:
        r100 = new ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromUser$1(this, r110);
        goto L8
    }

    public final Object n(Continuation<? super List<com.obric.assistant.settings.r>> r100) {
        if ((r100 instanceof ObricAutoGuiSettingsImpl$fetchAppSoftBlacklistFromCloud$1) == false) goto L7;
        ObricAutoGuiSettingsImpl$fetchAppSoftBlacklistFromCloud$1 r101 = (ObricAutoGuiSettingsImpl$fetchAppSoftBlacklistFromCloud$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L18:
        return ((d) r103).f391847b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r101.label = 1;
        r103 = o(l(), r101);
        if (r103 != r104) goto L18;
        return r104;
    L7:
        r101 = new ObricAutoGuiSettingsImpl$fetchAppSoftBlacklistFromCloud$1(this, r100);
        goto L8
    }

    public final List<String> p(Context r110) {
        long r100 = SystemClock.elapsedRealtime();
    L37:
        th = move-exception;
        long r101 = SystemClock.elapsedRealtime() - r100;
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "getLauncherAppPackageNamesInternal, cost = " + r101 + "ms, success = false");
        t("getLauncherAppPackageNamesInternal", r101, false);
        throw th;
    L4:
        if (m() == true) goto L6;
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "getLauncherAppPackageNamesInternal, return emptylist by permission denied");     // Catch: Throwable -> L37
        List<String> r111 = CollectionsKt.emptyList();     // Catch: Throwable -> L37
    L35:
        long r102 = SystemClock.elapsedRealtime() - r100;
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "getLauncherAppPackageNamesInternal, cost = " + r102 + "ms, success = true");
        t("getLauncherAppPackageNamesInternal", r102, true);
        return r111;
    L6:
        List<String> r103 = this.f391838h;     // Catch: Throwable -> L37
        if (r103 == null) goto L9;
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "getLauncherAppPackageNamesInternal, hit cache, size: " + r103.size());     // Catch: Throwable -> L37
        r111 = r103;
        goto L35
    L9:
        List<com.obric.assistant.settings.b> r104 = this.f391837g;     // Catch: Throwable -> L37
        if (r104 == null) goto L16;
        List<com.obric.assistant.settings.b> r105 = r104;     // Catch: Throwable -> L37
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));     // Catch: Throwable -> L37
        Iterator<T> r106 = r105.iterator();     // Catch: Throwable -> L37
    L13:
        if (r106.hasNext() == false) goto L15;
        r112.add(((com.obric.assistant.settings.b) r106.next()).f391987a);     // Catch: Throwable -> L37
        goto L13
    L15:
        this.f391838h = r112;     // Catch: Throwable -> L37
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "getLauncherAppPackageNamesInternal, reuse appsCache, size: " + r112.size());     // Catch: Throwable -> L37
        r111 = r112;
        goto L35
    L16:
        PackageManager r113 = r110.getPackageManager();     // Catch: Throwable -> L37
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L37
        Intent r107 = new Intent("android.intent.action.MAIN");     // Catch: Throwable -> L37
        r107.addCategory("android.intent.category.LAUNCHER");     // Catch: Throwable -> L37
        List<ResolveInfo> r108 = r113.queryIntentActivities(r107, 0);     // Catch: Throwable -> L37
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "getLauncherAppPackageNamesInternal, resolveList: " + r108.size());     // Catch: Throwable -> L37
        ArrayList r109 = new ArrayList(r108.size());     // Catch: Throwable -> L37
        Iterator<T> r114 = r108.iterator();     // Catch: Throwable -> L37
    L18:
        if (r114.hasNext() == false) goto L42;
        ResolveInfo r115 = (ResolveInfo) r114.next();     // Catch: Throwable -> L37
    L25:
        e = move-exception;
        FLogger.f375446a.e("ObricAutoGuiSettingsImpl", "getLauncherAppPackageNamesInternal, error: " + e);     // Catch: Throwable -> L37
        goto L18
    L21:
        if (s(r115.activityInfo.name) == true) goto L18;
        r109.add(r115.activityInfo.packageName);     // Catch: Exception -> L25 Throwable -> L37
    L42:
        r113.getPackageInfo("com.obric.appletapp", 0);     // Catch: Exception -> L30 Throwable -> L37
        boolean r116 = true;
    L32:
        if (r116 == false) goto L34;
        r109.add("com.obric.appletapp");     // Catch: Throwable -> L37
    L34:
        List<String> r117 = CollectionsKt.toList(r109);     // Catch: Throwable -> L37
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "getLauncherAppPackageNamesInternal, build done, size: " + r117.size());     // Catch: Throwable -> L37
        this.f391838h = r117;     // Catch: Throwable -> L37
        r111 = r117;
        goto L35
    L30:
        e = move-exception;
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "isDoubaoMiniAppInstalled, not installed: " + e);     // Catch: Throwable -> L37
        r116 = false;
        goto L32
    }

    public static final Object k(ObricAutoGuiSettingsImpl r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof ObricAutoGuiSettingsImpl$getAvailableAppPackageNamesFromCloudAndOs$1) == false) goto L7;
        ObricAutoGuiSettingsImpl$getAvailableAppPackageNamesFromCloudAndOs$1 r102 = (ObricAutoGuiSettingsImpl$getAvailableAppPackageNamesFromCloudAndOs$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        List<String> r107 = (List) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L18:
        List r108 = (List) r104;
        Set r109 = null;
        if (r108 == null) goto L37;
        ArrayList r110 = new ArrayList();
        Iterator r111 = r108.iterator();
    L22:
        if (r111.hasNext() == false) goto L36;
        String r112 = ((com.obric.assistant.settings.r) r111.next()).e();
        if (r112 == null) goto L33;
        String r113 = StringsKt.trim(r112).toString();
        if (r113 == null) goto L33;
        if (r113.length() <= 0) goto L30;
        boolean r114 = true;
    L31:
        if (r114 == false) goto L33;
    L34:
        if (r113 == null) goto L22;
        r110.add(r113);
        goto L22
    L30:
        r114 = false;
    L33:
        r113 = null;
        goto L34
    L36:
        r109 = CollectionsKt.toHashSet(r110);
    L37:
        if (r109 != null) goto L39;
        r109 = SetsKt.emptySet();
    L39:
        ArrayList r115 = new ArrayList();
        Iterator<T> r116 = r107.iterator();
    L41:
        if (r116.hasNext() == false) goto L45;
        Object r117 = r116.next();
        if ((!r109.contains((String) r117)) == false) goto L41;
        r115.add(r117);
        goto L41
    L45:
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "getAvailableAppPackageNamesFromCloudAndOs, launcher: " + r107.size() + ", blacklist: " + r109.size() + ", available: " + r115.size());
        Object r118 = r115;
    L46:
        return r118;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        List<String> r119 = r100.p(AppHost.f326268a.getApplication().getApplicationContext());
        r102.L$0 = r119;
        r102.label = 1;
        Object r120 = r100.n(r102);
        r118 = r105;
        if (r120 == r105) goto L46;
        r104 = r120;
        r107 = r119;
    L7:
        r102 = new ObricAutoGuiSettingsImpl$getAvailableAppPackageNamesFromCloudAndOs$1(r100, r101);
        goto L8
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final boolean e(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        if (ILoginService.f286097a.getAccountInfo().f531528a == true) goto L6;
        return r101;
    L6:
        if (this.f391831a != null) goto L8;
        q();
    L8:
        Keva r102 = this.f391831a;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r102 = null;
    L11:
        boolean r103 = r102.getBoolean(r100, r101);
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "getAppState, ret: " + r103 + ", packageName: " + r100 + ", defVal: " + r101);
        return r103;
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final void h(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        if (ILoginService.f286097a.getAccountInfo().f531528a == true) goto L6;
        return;
    L6:
        if (this.f391831a != null) goto L8;
        q();
    L8:
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "setAppState, isEnable: " + r101 + ", packageName: " + r100);
        Keva r102 = this.f391831a;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r102 = null;
    L11:
        r102.storeBoolean(r100, r101);
        IObricAutoBlacklistSettingsNotifier r103 = (IObricAutoBlacklistSettingsNotifier) ServiceManager.get().getService(IObricAutoBlacklistSettingsNotifier.class);
        if (r103 == null) goto L15;
        r103.a();
        return;
    }

    public final Object o(b r110, Continuation<? super d> r111) {
        if ((r111 instanceof ObricAutoGuiSettingsImpl$fetchCloudAppPolicy$1) == false) goto L7;
        ObricAutoGuiSettingsImpl$fetchCloudAppPolicy$1 r100 = (ObricAutoGuiSettingsImpl$fetchCloudAppPolicy$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        b r105 = (b) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L20:
        com.obric.assistant.settings.v r106 = (com.obric.assistant.settings.v) r102;
        b r107 = r105;
    L22:
        String r108 = ILoginService.f286097a.getAccountInfo().f531530c;
        Object r109 = this.f391834d;
        monitor-enter(r109);
    L116:
        th = move-exception;
        throw th;
    L25:
        if (r(r107, r108) == true) goto L27;
        FLogger.f375446a.w("ObricAutoGuiSettingsImpl", "fetchCloudAppPolicy, account changed while requesting, discard response");     // Catch: Throwable -> L116
        d r112 = new d(ObricAppListMode.BLACK_LIST, null, null, SetsKt.emptySet(), false);     // Catch: Throwable -> L116
    L114:
        monitor-exit(r109);
        return r112;
    L27:
        e r113 = this.f391836f;     // Catch: Throwable -> L116
        if (r113 != null) goto L30;
    L32:
        r113 = null;
    L33:
        if (r106 == null) goto L36;
        ObricAppListMode r114 = r106.c();     // Catch: Throwable -> L116
        if (r114 == null) goto L36;
    L39:
        if (r106 == null) goto L45;
        List<com.obric.assistant.settings.r> r115 = r106.a();     // Catch: Throwable -> L116
        if (r115 == null) goto L45;
        List<com.obric.assistant.settings.r> r116 = CollectionsKt.filterNotNull(r115);     // Catch: Throwable -> L116
        if (r116 == null) goto L45;
    L47:
        List<com.obric.assistant.settings.r> r117 = r116;
    L49:
        boolean r118 = false;
        if (r106 == null) goto L74;
        List<com.obric.assistant.settings.s> r119 = r106.b();     // Catch: Throwable -> L116
        if (r119 == null) goto L74;
        ArrayList r120 = new ArrayList();     // Catch: Throwable -> L116
        Iterator<T> r121 = r119.iterator();     // Catch: Throwable -> L116
    L55:
        if (r121.hasNext() == false) goto L71;
        com.obric.assistant.settings.s r122 = (com.obric.assistant.settings.s) r121.next();     // Catch: Throwable -> L116
        if (r122 == null) goto L68;
        String r123 = r122.b();     // Catch: Throwable -> L116
        if (r123 == null) goto L68;
        String r124 = StringsKt.trim(r123).toString();     // Catch: Throwable -> L116
        if (r124 == null) goto L68;
        if (r124.length() <= 0) goto L65;
        boolean r125 = true;
    L66:
        if (r125 == false) goto L68;
    L69:
        if (r124 == null) goto L55;
        r120.add(r124);     // Catch: Throwable -> L116
        goto L55
    L65:
        r125 = false;
    L68:
        r124 = null;
        goto L69
    L71:
        Set<String> r126 = CollectionsKt.toSet(r120);     // Catch: Throwable -> L116
        if (r126 == null) goto L74;
    L76:
        Set<String> r127 = r126;
    L78:
        if (r106 == null) goto L102;
        List<com.obric.assistant.settings.s> r128 = r106.b();     // Catch: Throwable -> L116
        if (r128 == null) goto L102;
        ArrayList r129 = new ArrayList();     // Catch: Throwable -> L116
        Iterator<T> r130 = r128.iterator();     // Catch: Throwable -> L116
    L83:
        if (r130.hasNext() == false) goto L99;
        com.obric.assistant.settings.s r131 = (com.obric.assistant.settings.s) r130.next();     // Catch: Throwable -> L116
        if (r131 == null) goto L96;
        String r132 = r131.a();     // Catch: Throwable -> L116
        if (r132 == null) goto L96;
        String r133 = StringsKt.trim(r132).toString();     // Catch: Throwable -> L116
        if (r133 == null) goto L96;
        if (r133.length() <= 0) goto L93;
        boolean r134 = true;
    L94:
        if (r134 == false) goto L96;
    L97:
        if (r133 == null) goto L83;
        r129.add(r133);     // Catch: Throwable -> L116
        goto L83
    L93:
        r134 = false;
    L96:
        r133 = null;
        goto L97
    L99:
        Set<String> r135 = CollectionsKt.toSet(r129);     // Catch: Throwable -> L116
        if (r135 == null) goto L102;
    L105:
        if (r106 != null) goto L107;
        if (r113 != null) goto L107;
    L109:
        if (r106 != null) goto L111;
        if (r113 != null) goto L111;
    L113:
        r112 = new d(r114, r117, r127, r135, r118);     // Catch: Throwable -> L116
    L111:
        r118 = true;
    L107:
        this.f391836f = new e(r107, r114, r117, r127, r135);     // Catch: Throwable -> L116
    L102:
        if (r113 == null) goto L104;
        r135 = r113.f391855e;     // Catch: Throwable -> L116
        goto L105
    L104:
        r135 = SetsKt.emptySet();     // Catch: Throwable -> L116
    L74:
        if (r113 == null) goto L77;
        r126 = r113.f391854d;     // Catch: Throwable -> L116
        goto L76
    L77:
        r127 = null;
    L45:
        if (r113 == null) goto L48;
        r116 = r113.f391853c;     // Catch: Throwable -> L116
        goto L47
    L48:
        r117 = null;
    L36:
        if (r113 == null) goto L38;
        r114 = r113.f391852b;     // Catch: Throwable -> L116
        goto L39
    L38:
        r114 = ObricAppListMode.BLACK_LIST;     // Catch: Throwable -> L116
        goto L39
    L30:
        if (Intrinsics.areEqual(r113.f391851a, r107) == false) goto L32;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        IObricNetworkService r136 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r136 == null) goto L21;
        r100.L$0 = r110;
        r100.label = 1;
        r102 = r136.s(r100);
        if (r102 != r103) goto L19;
        return r103;
    L19:
        r105 = r110;
        goto L20
    L21:
        r107 = r110;
        r106 = null;
    L7:
        r100 = new ObricAutoGuiSettingsImpl$fetchCloudAppPolicy$1(this, r111);
        goto L8
    }

    public final boolean r(b r100, String r101) {
        if (r100.f391841b == this.f391835e) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r100.f391840a, r101) == false) goto L7;
        return true;
    }

    public static void t(String r100, long r101, boolean r110) {
        IObricReporter.f391335a.getClass();
        IObricReporter r102 = IObricReporter.a.a();
        if (r102 == null) goto L6;
        IObricReporter.b.a(r102, "OAuto_Settings", r100, r101, r110, 16);
        return;
    }

    public static Set u(Set r110, Context r111, String r112) {
        long r100 = SystemClock.elapsedRealtime();
        if (r110.isEmpty() == false) goto L6;
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "toAppLabelSet, source=" + r112 + ", packageCount=0, appNameCount=0, costMs=0");
        return SetsKt.emptySet();
    L6:
        PackageManager r113 = r111.getPackageManager();
        ArrayList r101 = new ArrayList();
        Iterator r102 = r110.iterator();
    L8:
        if (r102.hasNext() == false) goto L30;
        String r103 = (String) r102.next();
        Intrinsics.checkNotNull(r113);
        Object r104 = null;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L18
        boolean r106 = false;
        String r107 = StringsKt.trim(r113.getApplicationLabel(r113.getApplicationInfo(r103, 0)).toString()).toString();     // Catch: Throwable -> L18
        if (r107.length() <= 0) goto L13;
        r106 = true;
    L13:
        if (r106 == true) goto L16;
        r107 = null;
    L16:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L18
    L20:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L24;
        FLogger.f375446a.w("ObricAutoGuiSettingsImpl", "toAppLabel failed, packageName=" + r103, r109);
    L24:
        if (Result.m9455isFailureimpl(r108) == true) goto L27;
        r104 = r108;
    L27:
        String r114 = (String) r104;
        if (r114 == null) goto L8;
        r101.add(r114);
    L18:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L30:
        Set r116 = CollectionsKt.toSet(r101);
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "toAppLabelSet, source=" + r112 + ", packageCount=" + r110.size() + ", appNameCount=" + r116.size() + ", costMs=" + (SystemClock.elapsedRealtime() - r100));
        return r116;
    }

    @Override // com.obric.assistant.settings.IObricAutoGuiSettingsApi
    public final Object a(boolean r110, boolean r111, Continuation<? super List<com.obric.assistant.settings.e>> r112) {
        if ((r112 instanceof ObricAutoGuiSettingsImpl$getAutoActionAvailableAppPermissionFromUser$1) == false) goto L7;
        ObricAutoGuiSettingsImpl$getAutoActionAvailableAppPermissionFromUser$1 r100 = (ObricAutoGuiSettingsImpl$getAutoActionAvailableAppPermissionFromUser$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = true;
        boolean r106 = false;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        int r107 = r100.I$0;
        long r108 = r100.J$0;
        boolean r109 = r100.Z$0;
        List r113 = (List) r100.L$2;
        String r114 = (String) r100.L$1;
        ObricAutoGuiSettingsImpl r115 = (ObricAutoGuiSettingsImpl) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14
        boolean r116 = r109;
    L37:
        Iterator r117 = ((List) r102).iterator();     // Catch: Throwable -> L14
    L38:
        if (r117.hasNext() == false) goto L62;
        String r118 = (String) r117.next();     // Catch: Throwable -> L14
        boolean r119 = e(r118, r106);     // Catch: Throwable -> L60
        FLogger r120 = FLogger.f375446a;     // Catch: Throwable -> L14
        StringBuilder r121 = new StringBuilder();     // Catch: Throwable -> L14
        r121.append("getAutoActionAvailableAppPermissionFromUser, onlyReturnWhiteList: ");     // Catch: Throwable -> L60
        if (r116 == false) goto L46;
        boolean r122 = true;
    L47:
        r121.append(r122);     // Catch: Throwable -> L60
        r121.append(", packageName: ");     // Catch: Throwable -> L60
        r121.append(r118);     // Catch: Throwable -> L60
        r121.append(", isAppAvailable: ");     // Catch: Throwable -> L60
        if (r119 == false) goto L50;
        boolean r123 = true;
    L51:
        r121.append(r123);     // Catch: Throwable -> L60
        r120.i("ObricAutoGuiSettingsImpl", r121.toString());     // Catch: Throwable -> L60
        if (r116 == false) goto L55;
        if (r119 == true) goto L55;
    L59:
        r105 = true;
        r106 = false;
    L55:
        if (r119 == false) goto L57;
        boolean r124 = true;
    L58:
        r113.add(new com.obric.assistant.settings.e(r118, r124));     // Catch: Throwable -> L60
        goto L59
    L57:
        r124 = false;
        goto L58
    L50:
        r123 = false;
        goto L51
    L46:
        r122 = false;
    L60:
        th = th;
        r105 = true;
    L66:
        long r125 = SystemClock.elapsedRealtime() - r108;
        FLogger r126 = FLogger.f375446a;
        StringBuilder r127 = new StringBuilder();
        r127.append(r114);
        r127.append(", cost = ");
        r127.append(r125);
        r127.append("ms, success = ");
        if (r107 == 0) goto L69;
        boolean r128 = true;
    L70:
        r127.append(r128);
        r126.i("ObricAutoGuiSettingsImpl", r127.toString());
        if (r107 != 0) goto L74;
        r105 = false;
    L74:
        r115.getClass();
        t(r114, r125, r105);
        throw th;
    L69:
        r128 = false;
    L62:
        long r129 = SystemClock.elapsedRealtime() - r108;
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", r114 + ", cost = " + r129 + "ms, success = true");
        r115.getClass();
        t(r114, r129, true);
        return r113;
    L14:
        th = th;
        goto L66
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        r114 = "getAutoActionAvailableAppPermissionFromUser";
        r108 = SystemClock.elapsedRealtime();
        r113 = new ArrayList();     // Catch: Throwable -> L64
        if (ILoginService.f286097a.getAccountInfo().f531528a == true) goto L23;
    L28:
        r115 = this;
        goto L62
    L23:
        if (this.f391831a != null) goto L26;
        q();     // Catch: Throwable -> L64
    L26:
        if (m() == true) goto L29;
        FLogger.f375446a.i("ObricAutoGuiSettingsImpl", "getAutoActionAvailableAppPermissionFromUser, return emptylist by permission denied");     // Catch: Throwable -> L64
        r113 = CollectionsKt.emptyList();     // Catch: Throwable -> L64
        goto L28
    L29:
        CoroutineDispatcher r130 = Dispatchers.getIO();     // Catch: Throwable -> L64
        if (r111 == false) goto L32;
        boolean r131 = true;
    L33:
        ObricAutoGuiSettingsImpl$getAutoActionAvailableAppPermissionFromUser$2$availablePackageNames$1 r132 = new ObricAutoGuiSettingsImpl$getAutoActionAvailableAppPermissionFromUser$2$availablePackageNames$1(r131, this, null);     // Catch: Throwable -> L64
        r100.L$0 = this;     // Catch: Throwable -> L64
        r100.L$1 = "getAutoActionAvailableAppPermissionFromUser";     // Catch: Throwable -> L64
        r100.L$2 = r113;     // Catch: Throwable -> L64
        r116 = r110;
        r100.Z$0 = r116;     // Catch: Throwable -> L64
        r100.J$0 = r108;     // Catch: Throwable -> L64
        r100.I$0 = 0;     // Catch: Throwable -> L64
        r100.label = 1;     // Catch: Throwable -> L64
        r102 = BuildersKt.withContext(r130, r132, r100);     // Catch: Throwable -> L64
        if (r102 != r103) goto L36;
        return r103;
    L36:
        r115 = this;
        r107 = 0;
        goto L37
    L32:
        r131 = false;
    L64:
        th = th;
        r115 = this;
        r107 = 0;
    L7:
        r100 = new ObricAutoGuiSettingsImpl$getAutoActionAvailableAppPermissionFromUser$1(this, r112);
        goto L8
    }
}
