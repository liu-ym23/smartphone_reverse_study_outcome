package ht5;

import com.ss.android.lark.officesdk.di.core.deps.webview.PlatformPluginVersion;
import java.util.HashMap;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ht5.a f487132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f487133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public otb.e f487134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public jt5.d f487135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<PlatformPluginVersion, Boolean> f487136e;

    public static final class a {
    }

    static {
    }

    public final void a() {
        otb.e r100 = this.f487134c;
        if (r100 == null) goto L5;
        HashMap<PlatformPluginVersion, Boolean> r101 = this.f487136e;
        PlatformPluginVersion r102 = PlatformPluginVersion.SANDWICH;
        r100.isFeatureSupport("mixrender_sandwich_mode");
        Boolean r103 = Boolean.FALSE;
        r101.put(r102, r103);
        HashMap<PlatformPluginVersion, Boolean> r104 = this.f487136e;
        PlatformPluginVersion r105 = PlatformPluginVersion.EMBED;
        r100.isFeatureSupport("mixrender_embed_mode");
        r104.put(r105, r103);
    L5:
        this.f487132a.getClass();
        ht5.a.b("PlatformPluginManager", "updateMixRenderState");
    }

    public b() {
        ht5.a r100 = new ht5.a();
        this.f487132a = r100;
        this.f487133b = new d(r100);
        this.f487136e = new HashMap();
    }
}
