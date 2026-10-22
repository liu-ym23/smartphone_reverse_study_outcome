package d;

import android.app.Application;
import com.obric.eventkit.apphost.AppHost;
import com.squareup.wire.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements AppHost {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f466142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f466143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f466144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f466145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f466146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f466147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f466148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f466149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f466150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f466151j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f466152k;

    public c(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "app");
        this.f466142a = r100;
        this.f466143b = "160";
        this.f466144c = 160;
        this.f466145d = new b();
        this.f466146e = 498349;
        this.f466147f = "obric_assistant";
        this.f466148g = "OGrace";
        this.f466149h = "sdk";
        this.f466150i = BuildConfig.VERSION_NAME;
        this.f466151j = 1;
        this.f466152k = 1;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public final a getAppClock() {
        return this.f466145d;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public final int getAppId() {
        return this.f466146e;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public final String getAppName() {
        return this.f466147f;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public final String getAppStringName() {
        return this.f466148g;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public final Application getApplication() {
        return this.f466142a;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public final String getBuildChannel() {
        return this.f466149h;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public final int getManifestVersionCode() {
        return this.f466144c;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public final String getManifestVersionName() {
        return this.f466143b;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public final int getUpdateVersionCode() {
        return this.f466152k;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public final int getVersionCode() {
        return this.f466151j;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public final String getVersionName() {
        return this.f466150i;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public final boolean isDebug() {
        return false;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public final boolean isDebugChannel() {
        return false;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public final boolean isOversea() {
        return false;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public final boolean isTestChannel() {
        return false;
    }
}
