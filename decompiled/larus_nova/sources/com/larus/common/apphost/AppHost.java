package com.larus.common.apphost;

import android.app.Application;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import e09.a;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "不要在这里面新增代码 ，用 FlowAndroidRuntime.appHost() or FlowRuntime.appHost() 来代替！！")
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\n\bg\u0018\u0000 :2\u00020\u0001:\u0001:R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0012\u0010\u0012\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0012\u0010\u0018\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0012\u0010\u001a\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0012\u0010\u001b\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u0012\u0010\u001c\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0012\u0010\u001d\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\rR\u0012\u0010\u001f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\tR\u0012\u0010!\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\rR\u0012\u0010#\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\tR\u0012\u0010%\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\tR\u0012\u0010'\u001a\u00020(X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0012\u0010+\u001a\u00020,X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001e\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020100X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0012\u00104\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\tR\u0012\u00106\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0016R\u0012\u00108\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\r¨\u0006;"}, d2 = {"Lcom/larus/common/apphost/AppHost;", "", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "appId", "", "getAppId", "()I", "appName", "", "getAppName", "()Ljava/lang/String;", "appStringName", "getAppStringName", "defaultOfficialWebsiteName", "getDefaultOfficialWebsiteName", "defaultOfficialWebsiteUrl", "getDefaultOfficialWebsiteUrl", "isOversea", "", "()Z", "isDebug", "buildChannel", "getBuildChannel", "isTestChannel", "isDebugChannel", "isPlugin", "versionName", "getVersionName", RuleConditionBean.VERSION_CODE_KEY, "getVersionCode", "manifestVersionName", "getManifestVersionName", "manifestVersionCode", "getManifestVersionCode", "updateVersionCode", "getUpdateVersionCode", "activityStackManager", "Lcom/larus/common/apphost/lifecycle/ActivityStackManager;", "getActivityStackManager", "()Lcom/larus/common/apphost/lifecycle/ActivityStackManager;", "appClock", "Lcom/larus/common/apphost/time/AppClock;", "getAppClock", "()Lcom/larus/common/apphost/time/AppClock;", "appStartTime", "Lkotlin/Pair;", "", "getAppStartTime", "()Lkotlin/Pair;", "appIconId", "getAppIconId", "supportCloudTest", "getSupportCloudTest", "mainBotTag", "getMainBotTag", "Companion", "apphost_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AppHost {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f326268a = null;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014R\u0014\u0010\u001e\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0010R\u0014\u0010 \u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u0014\u0010\"\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0019R\u0014\u0010#\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0014R\u0014\u0010%\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0019R\u0014\u0010&\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0019R\u0014\u0010'\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0014R\u0014\u0010)\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0010R\u0014\u0010+\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0019R\u0014\u0010,\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0014R\u0014\u0010.\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0010R\u0014\u00100\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0010R\u0014\u00102\u001a\u0002038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u0002078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R \u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020<0;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u0014¨\u0006A"}, d2 = {"Lcom/larus/common/apphost/AppHost$Companion;", "Lcom/larus/common/apphost/AppHost;", "<init>", "()V", "inst", "getInst", "()Lcom/larus/common/apphost/AppHost;", "inst$delegate", "Lkotlin/Lazy;", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "appId", "", "getAppId", "()I", "appName", "", "getAppName", "()Ljava/lang/String;", "appStringName", "getAppStringName", "isOversea", "", "()Z", "defaultOfficialWebsiteName", "getDefaultOfficialWebsiteName", "defaultOfficialWebsiteUrl", "getDefaultOfficialWebsiteUrl", "appIconId", "getAppIconId", "supportCloudTest", "getSupportCloudTest", "isDebug", "buildChannel", "getBuildChannel", "isDebugChannel", "isPlugin", "versionName", "getVersionName", RuleConditionBean.VERSION_CODE_KEY, "getVersionCode", "isTestChannel", "manifestVersionName", "getManifestVersionName", "manifestVersionCode", "getManifestVersionCode", "updateVersionCode", "getUpdateVersionCode", "activityStackManager", "Lcom/larus/common/apphost/lifecycle/ActivityStackManager;", "getActivityStackManager", "()Lcom/larus/common/apphost/lifecycle/ActivityStackManager;", "appClock", "Lcom/larus/common/apphost/time/AppClock;", "getAppClock", "()Lcom/larus/common/apphost/time/AppClock;", "appStartTime", "Lkotlin/Pair;", "", "getAppStartTime", "()Lkotlin/Pair;", "mainBotTag", "getMainBotTag", "apphost_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements AppHost {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f326269b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<AppHost> f326270c = null;

        private Companion() {
        }

        static {
            f326269b = new Companion();
            f326270c = LazyKt.lazy(new a());
        }

        public static AppHost g() {
            return f326270c.getValue();
        }

        @Override // com.larus.common.apphost.AppHost
        public final f09.a a() {
            return g().a();
        }

        @Override // com.larus.common.apphost.AppHost
        public final int b() {
            return g().b();
        }

        @Override // com.larus.common.apphost.AppHost
        public final boolean c() {
            return g().c();
        }

        @Override // com.larus.common.apphost.AppHost
        public final String d() {
            return g().d();
        }

        @Override // com.larus.common.apphost.AppHost
        public final String e() {
            return g().e();
        }

        @Override // com.larus.common.apphost.AppHost
        public final String f() {
            return g().f();
        }

        @Override // com.larus.common.apphost.AppHost
        public final g09.a getAppClock() {
            return g().getAppClock();
        }

        @Override // com.larus.common.apphost.AppHost
        public final int getAppId() {
            return g().getAppId();
        }

        @Override // com.larus.common.apphost.AppHost
        public final String getAppName() {
            return g().getAppName();
        }

        @Override // com.larus.common.apphost.AppHost
        public final Pair<Long, Long> getAppStartTime() {
            return g().getAppStartTime();
        }

        @Override // com.larus.common.apphost.AppHost
        public final String getAppStringName() {
            return g().getAppStringName();
        }

        @Override // com.larus.common.apphost.AppHost
        public final Application getApplication() {
            return g().getApplication();
        }

        @Override // com.larus.common.apphost.AppHost
        public final String getBuildChannel() {
            return g().getBuildChannel();
        }

        @Override // com.larus.common.apphost.AppHost
        public final int getManifestVersionCode() {
            return g().getManifestVersionCode();
        }

        @Override // com.larus.common.apphost.AppHost
        public final String getManifestVersionName() {
            return g().getManifestVersionName();
        }

        @Override // com.larus.common.apphost.AppHost
        public final int getUpdateVersionCode() {
            return g().getUpdateVersionCode();
        }

        @Override // com.larus.common.apphost.AppHost
        public final int getVersionCode() {
            return g().getVersionCode();
        }

        @Override // com.larus.common.apphost.AppHost
        public final String getVersionName() {
            return g().getVersionName();
        }

        @Override // com.larus.common.apphost.AppHost
        public final boolean isDebug() {
            return g().isDebug();
        }

        @Override // com.larus.common.apphost.AppHost
        public final boolean isDebugChannel() {
            return g().isDebugChannel();
        }

        @Override // com.larus.common.apphost.AppHost
        public final boolean isOversea() {
            return g().isOversea();
        }

        @Override // com.larus.common.apphost.AppHost
        public final boolean isPlugin() {
            return g().isPlugin();
        }

        @Override // com.larus.common.apphost.AppHost
        public final boolean isTestChannel() {
            return g().isTestChannel();
        }
    }

    static {
        f326268a = Companion.f326269b;
    }

    f09.a a();

    int b();

    boolean c();

    String d();

    String e();

    String f();

    g09.a getAppClock();

    int getAppId();

    String getAppName();

    Pair<Long, Long> getAppStartTime();

    String getAppStringName();

    Application getApplication();

    String getBuildChannel();

    int getManifestVersionCode();

    String getManifestVersionName();

    int getUpdateVersionCode();

    int getVersionCode();

    String getVersionName();

    boolean isDebug();

    boolean isDebugChannel();

    boolean isOversea();

    boolean isPlugin();

    boolean isTestChannel();
}
