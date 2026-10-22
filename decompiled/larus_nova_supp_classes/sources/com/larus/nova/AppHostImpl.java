package com.larus.nova;

import android.app.Application;
import android.text.TextUtils;
import android.util.EventsUtils;
import com.bytedance.common.utility.android.ManifestData;
import com.larus.business.debug.api.DebugResourceService;
import com.larus.common.apphost.AppHost;
import com.larus.network.HttpConst;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import mm9.a;
import mm9.c;
import mm9.d;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Deprecated(message = "不要在这里面新增代码 ，用 FlowAndroidRuntime.appHost() or FlowRuntime.appHost() 来代替！！")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0018R\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\"X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0014\u0010&\u001a\u00020\"X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0014\u0010'\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0014\u0010)\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u001b\u0010+\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b,\u0010\u001cR\u0014\u0010/\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0014\u00100\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0014\u00101\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u001cR\u0014\u00103\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0018R\u0014\u00105\u001a\u00020\u001aX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001cR\u0014\u00107\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0018R\u0014\u00109\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0018R\u0014\u0010;\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010$R\u0014\u0010<\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u001c¨\u0006>"}, d2 = {"Lcom/larus/nova/AppHostImpl;", "Lcom/larus/common/apphost/AppHost;", "<init>", "()V", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "activityStackManager", "Lcom/larus/common/apphost/lifecycle/ActivityStackManager;", "getActivityStackManager", "()Lcom/larus/common/apphost/lifecycle/ActivityStackManager;", "appClock", "Lcom/larus/common/apphost/time/AppClock;", "getAppClock", "()Lcom/larus/common/apphost/time/AppClock;", "appStartTime", "Lkotlin/Pair;", XmlPullParser.NO_NAMESPACE, "getAppStartTime", "()Lkotlin/Pair;", "appId", XmlPullParser.NO_NAMESPACE, "getAppId", "()I", "appName", XmlPullParser.NO_NAMESPACE, "getAppName", "()Ljava/lang/String;", "appStringName", "getAppStringName", "appIconId", "getAppIconId", "supportCloudTest", XmlPullParser.NO_NAMESPACE, "getSupportCloudTest", "()Z", "isDebug", "isOversea", "defaultOfficialWebsiteName", "getDefaultOfficialWebsiteName", "defaultOfficialWebsiteUrl", "getDefaultOfficialWebsiteUrl", "buildChannel", "getBuildChannel", "buildChannel$delegate", "Lkotlin/Lazy;", "isTestChannel", "isDebugChannel", "versionName", "getVersionName", "versionCode", "getVersionCode", "manifestVersionName", "getManifestVersionName", "manifestVersionCode", "getManifestVersionCode", "updateVersionCode", "getUpdateVersionCode", "isPlugin", "mainBotTag", "getMainBotTag", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class AppHostImpl implements AppHost {
    public final NovaApplication b;
    public final a c;
    public final c d;
    public final Pair<Long, Long> e;
    public final int f;
    public final String g;
    public final String h;
    public final String i;
    public final Lazy j;
    public final boolean k;
    public final String l;
    public final int m;
    public final int n;

    @Override // com.larus.common.apphost.AppHost
    public final boolean c() {
        return false;
    }

    @Override // com.larus.common.apphost.AppHost
    public final String e() {
        return "doubao.com";
    }

    @Override // com.larus.common.apphost.AppHost
    public final boolean isDebug() {
        return false;
    }

    @Override // com.larus.common.apphost.AppHost
    public final boolean isDebugChannel() {
        return false;
    }

    @Override // com.larus.common.apphost.AppHost
    public final boolean isOversea() {
        return false;
    }

    @Override // com.larus.common.apphost.AppHost
    public final boolean isPlugin() {
        return false;
    }

    @Override // com.larus.common.apphost.AppHost
    public final int b() {
        Integer r0 = DebugResourceService.a.b();
        if (r0 != null) goto L7;
        return 2131689522;
    L7:
        return r0.intValue();
    }

    @Override // com.larus.common.apphost.AppHost
    public final String getAppStringName() {
        String r0 = this.b.getString(2131894310);
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.larus.common.apphost.AppHost
    public final String getBuildChannel() {
        return (String) this.j.getValue();
    }

    @Override // com.larus.common.apphost.AppHost
    public final int getVersionCode() {
        int r0 = ManifestData.getInt(this.b, "SS_VERSION_CODE");     // Catch: Exception -> L4
    L6:
        if (r0 == (-1)) goto L10;
        if (r0 == 0) goto L10;
        return r0;
    L10:
        return this.m;
    L4:
        r0 = 0;
        goto L6
    }

    @Override // com.larus.common.apphost.AppHost
    public final String getVersionName() {
        String r0 = ManifestData.getString(this.b, "SS_VERSION_NAME");     // Catch: Exception -> L4
    L6:
        if (TextUtils.isEmpty(r0) == false) goto L9;
        return this.l;
    L9:
        return String.valueOf(r0);
    L4:
        r0 = XmlPullParser.NO_NAMESPACE;
        goto L6
    }

    public AppHostImpl() {
        NovaApplication r0 = NovaApplication.e;
        NovaApplication r1 = NovaApplication.a.a();
        this.b = r1;
        this.c = new a(r1);
        this.d = new c();
        this.e = NovaApplication.a.a().b;
        this.f = 482431;
        this.g = "nova_ai";
        HttpConst.a.getClass();
        this.h = HttpConst.c;
        this.i = HttpConst.g;
        this.j = LazyKt.lazy(new d(this));
        this.k = SetsKt.setOf(new String[]{"debug", "local_test"}).contains("obric_pacific");
        this.l = "15.2.0.1";
        this.m = 15020010;
        this.n = 15020070;
    }

    @Override // com.larus.common.apphost.AppHost
    public final f09.a a() {
        return this.c;
    }

    @Override // com.larus.common.apphost.AppHost
    public final String d() {
        return this.i;
    }

    @Override // com.larus.common.apphost.AppHost
    public final String f() {
        return this.h;
    }

    @Override // com.larus.common.apphost.AppHost
    public final g09.a getAppClock() {
        return this.d;
    }

    @Override // com.larus.common.apphost.AppHost
    public final int getAppId() {
        return this.f;
    }

    @Override // com.larus.common.apphost.AppHost
    public final String getAppName() {
        return this.g;
    }

    @Override // com.larus.common.apphost.AppHost
    public final Pair<Long, Long> getAppStartTime() {
        return this.e;
    }

    @Override // com.larus.common.apphost.AppHost
    public final Application getApplication() {
        return this.b;
    }

    @Override // com.larus.common.apphost.AppHost
    public final int getManifestVersionCode() {
        return this.m;
    }

    @Override // com.larus.common.apphost.AppHost
    public final String getManifestVersionName() {
        return this.l;
    }

    @Override // com.larus.common.apphost.AppHost
    public final int getUpdateVersionCode() {
        return this.n;
    }

    @Override // com.larus.common.apphost.AppHost
    public final boolean isTestChannel() {
        return this.k;
    }
}
