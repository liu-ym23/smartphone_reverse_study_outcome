package exb;

import com.ss.android.lark.officesdk.di.core.deps.webview.PlatformPluginVersion;
import java.util.HashMap;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final exb.a f474734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f474735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public otb.e f474736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gxb.d f474737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<PlatformPluginVersion, Boolean> f474738e;

    public static final class a {
    }

    static {
    }

    public final void a() {
        otb.e r100 = this.f474736c;
        if (r100 == null) goto L5;
        HashMap<PlatformPluginVersion, Boolean> r101 = this.f474738e;
        PlatformPluginVersion r102 = PlatformPluginVersion.SANDWICH;
        r100.isFeatureSupport("mixrender_sandwich_mode");
        Boolean r103 = Boolean.FALSE;
        r101.put(r102, r103);
        HashMap<PlatformPluginVersion, Boolean> r104 = this.f474738e;
        PlatformPluginVersion r105 = PlatformPluginVersion.EMBED;
        r100.isFeatureSupport("mixrender_embed_mode");
        r104.put(r105, r103);
    L5:
        this.f474734a.getClass();
        exb.a.c("PlatformPluginManager", "updateMixRenderState");
    }

    public b() {
        exb.a r100 = new exb.a();
        this.f474734a = r100;
        this.f474735b = new d(r100);
        this.f474738e = new HashMap();
    }
}
