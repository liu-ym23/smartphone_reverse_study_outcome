package com.bytedance.ee.bear.browser.plugin;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p {
    public static volatile p b;
    public final LinkedHashMap<PluginHost.a, PluginHost> a;

    public static p d() {
        if (b != null) goto L15;
        monitor-enter(p.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new p();     // Catch: Throwable -> L11
    L9:
        monitor-exit(p.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public p() {
        this.a = new LinkedHashMap();
    }

    static {
    }

    public final void b(PluginHost.a r3) {
        com.ss.android.lark.officesdk.utils.di.j.e("PluginRuntime", "destroyHost " + r3);
        this.a.remove(r3).onDestroy();
    }

    public final PluginHost a(PluginHost.b r4, PluginHost.a r5) {
        com.ss.android.lark.officesdk.utils.di.j.e("PluginRuntime", "createHost");
        PluginHost r6 = r4.createPluginHost();
        com.ss.android.lark.officesdk.utils.di.j.e("PluginRuntime", "newPluginHost() called with: pluginHost = [" + r6 + "], delegate = [" + r5 + "]");
        this.a.put(r5, r6);
        r6.onCreate(r5);
        o r7 = r5.getPluginListProvider();
        if (r7 == null) goto L5;
        n r8 = r7.a(r6);
    L6:
        if (r8 != null) goto L8;
        r8 = new n(new n.a[0]);
    L8:
        vv4.g.b = System.currentTimeMillis();
        r6.addPlugins(r8);
        vv4.g.c = System.currentTimeMillis();
        return r6;
    L5:
        r8 = null;
        goto L6
    }

    public final void c(PluginHost.a r2, t r3) {
        PluginHost r4 = this.a.get(r2);
        if (r3.getLayoutStrategy() != null) goto L5;
        r3.k(new c(r3));
    L5:
        r4.onDispatchUIAttach(r3);
    }
}
