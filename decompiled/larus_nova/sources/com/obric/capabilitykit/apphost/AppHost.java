package com.obric.capabilitykit.apphost;

import android.app.Application;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wia.s;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\bg\u0018\u0000 &2\u00020\u0001:\u0001&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R\u0012\u0010\u001a\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0012\u0010\u001b\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u0012\u0010\u001c\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\tR\u0012\u0010\u001e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\rR\u0012\u0010 \u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\tR\u0012\u0010\"\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\tR\u0012\u0010$\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\r¨\u0006'"}, d2 = {"Lcom/obric/capabilitykit/apphost/AppHost;", "", "appClock", "Lcom/obric/capabilitykit/apphost/AppClock;", "getAppClock", "()Lcom/obric/capabilitykit/apphost/AppClock;", "appId", "", "getAppId", "()I", "appName", "", "getAppName", "()Ljava/lang/String;", "appStringName", "getAppStringName", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "buildChannel", "getBuildChannel", "isDebug", "", "()Z", "isDebugChannel", "isOversea", "isTestChannel", "manifestVersionCode", "getManifestVersionCode", "manifestVersionName", "getManifestVersionName", "updateVersionCode", "getUpdateVersionCode", RuleConditionBean.VERSION_CODE_KEY, "getVersionCode", "versionName", "getVersionName", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface AppHost {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0001R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001dR\u0014\u0010!\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u000bR\u0014\u0010#\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u000fR\u0014\u0010%\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u000bR\u0014\u0010'\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u000bR\u0014\u0010)\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u000f¨\u0006."}, d2 = {"Lcom/obric/capabilitykit/apphost/AppHost$Companion;", "Lcom/obric/capabilitykit/apphost/AppHost;", "()V", "_inst", "appClock", "Lcom/obric/capabilitykit/apphost/AppClock;", "getAppClock", "()Lcom/obric/capabilitykit/apphost/AppClock;", "appId", "", "getAppId", "()I", "appName", "", "getAppName", "()Ljava/lang/String;", "appStringName", "getAppStringName", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "buildChannel", "getBuildChannel", "inst", "getInst", "()Lcom/obric/capabilitykit/apphost/AppHost;", "isDebug", "", "()Z", "isDebugChannel", "isOversea", "isTestChannel", "manifestVersionCode", "getManifestVersionCode", "manifestVersionName", "getManifestVersionName", "updateVersionCode", "getUpdateVersionCode", RuleConditionBean.VERSION_CODE_KEY, "getVersionCode", "versionName", "getVersionName", "setAppHost", "", "impl", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion implements AppHost {
        public static final /* synthetic */ Companion $$INSTANCE = null;
        private static AppHost _inst;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        private final AppHost getInst() {
            AppHost r100 = _inst;
            if (r100 == null) goto L6;
            return r100;
        L6:
            throw new IllegalStateException("app module must call Apphost.setApphost()");
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public s getAppClock() {
            return getInst().getAppClock();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public int getAppId() {
            return getInst().getAppId();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public String getAppName() {
            return getInst().getAppName();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public String getAppStringName() {
            return getInst().getAppStringName();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public Application getApplication() {
            return getInst().getApplication();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public String getBuildChannel() {
            return getInst().getBuildChannel();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public int getManifestVersionCode() {
            return getInst().getManifestVersionCode();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public String getManifestVersionName() {
            return getInst().getManifestVersionName();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public int getUpdateVersionCode() {
            return getInst().getUpdateVersionCode();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public int getVersionCode() {
            return getInst().getVersionCode();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public String getVersionName() {
            return getInst().getVersionName();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public boolean isDebug() {
            return getInst().isDebug();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public boolean isDebugChannel() {
            return getInst().isDebugChannel();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public boolean isOversea() {
            return getInst().isOversea();
        }

        @Override // com.obric.capabilitykit.apphost.AppHost
        public boolean isTestChannel() {
            return getInst().isTestChannel();
        }

        public final void setAppHost(AppHost r100) {
            Intrinsics.checkNotNullParameter(r100, "impl");
            _inst = r100;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    s getAppClock();

    int getAppId();

    String getAppName();

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

    boolean isTestChannel();
}
