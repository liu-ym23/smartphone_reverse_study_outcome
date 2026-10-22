package com.bytedance.ee.bear.browser.plugin;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile p f216633b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<PluginHost.a, PluginHost> f216634a;

    public static p d() {
        if (f216633b != null) goto L15;
        monitor-enter(p.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f216633b != null) goto L9;
        f216633b = new p();     // Catch: Throwable -> L11
    L9:
        monitor-exit(p.class);     // Catch: Throwable -> L11
    L15:
        return f216633b;
    }

    public p() {
        this.f216634a = new LinkedHashMap();
    }

    static {
    }

    public final void b(PluginHost.a r100) {
        com.ss.android.lark.officesdk.utils.di.j.e("PluginRuntime", "destroyHost " + r100);
        this.f216634a.remove(r100).onDestroy();
    }

    public final PluginHost a(PluginHost.b r100, PluginHost.a r101) {
        com.ss.android.lark.officesdk.utils.di.j.e("PluginRuntime", "createHost");
        PluginHost r102 = r100.createPluginHost();
        com.ss.android.lark.officesdk.utils.di.j.e("PluginRuntime", "newPluginHost() called with: pluginHost = [" + r102 + "], delegate = [" + r101 + "]");
        this.f216634a.put(r101, r102);
        r102.onCreate(r101);
        o r103 = r101.getPluginListProvider();
        if (r103 == null) goto L5;
        n r104 = r103.a(r102);
    L6:
        if (r104 != null) goto L8;
        r104 = new n(new n.a[0]);
    L8:
        vv4.g.f557389b = System.currentTimeMillis();
        r102.addPlugins(r104);
        vv4.g.f557390c = System.currentTimeMillis();
        return r102;
    L5:
        r104 = null;
        goto L6
    }

    public final void c(PluginHost.a r100, t r101) {
        PluginHost r102 = this.f216634a.get(r100);
        if (r101.getLayoutStrategy() != null) goto L5;
        r101.k(new c(r101));
    L5:
        r102.onDispatchUIAttach(r101);
    }
}
