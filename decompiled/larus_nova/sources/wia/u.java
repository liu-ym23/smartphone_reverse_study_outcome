package wia;

import android.app.Application;
import com.obric.capabilitykit.apphost.AppHost;
import com.squareup.wire.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class u implements AppHost {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f559891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f559892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f559893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f559894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f559895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f559896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f559897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f559898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f559899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f559900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f559901k;

    public u(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "app");
        this.f559891a = r100;
        this.f559892b = "160";
        this.f559893c = 160;
        this.f559894d = new t();
        this.f559895e = 498349;
        this.f559896f = "obric_assistant";
        this.f559897g = "OGrace";
        this.f559898h = "sdk";
        this.f559899i = BuildConfig.VERSION_NAME;
        this.f559900j = 1;
        this.f559901k = 1;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final s getAppClock() {
        return this.f559894d;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final int getAppId() {
        return this.f559895e;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final String getAppName() {
        return this.f559896f;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final String getAppStringName() {
        return this.f559897g;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final Application getApplication() {
        return this.f559891a;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final String getBuildChannel() {
        return this.f559898h;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final int getManifestVersionCode() {
        return this.f559893c;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final String getManifestVersionName() {
        return this.f559892b;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final int getUpdateVersionCode() {
        return this.f559901k;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final int getVersionCode() {
        return this.f559900j;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final String getVersionName() {
        return this.f559899i;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final boolean isDebug() {
        return false;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final boolean isDebugChannel() {
        return false;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final boolean isOversea() {
        return false;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final boolean isTestChannel() {
        return false;
    }
}
