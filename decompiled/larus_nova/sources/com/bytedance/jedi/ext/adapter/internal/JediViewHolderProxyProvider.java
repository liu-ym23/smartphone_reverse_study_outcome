package com.bytedance.jedi.ext.adapter.internal;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes19.dex */
public final class JediViewHolderProxyProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<JediViewHolderProxy> f251020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f251021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f251022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JediViewHolderProxyManager f251023d;

    public JediViewHolderProxyProvider(JediViewHolderProxyManager r100) {
        this.f251023d = r100;
        this.f251020a = JediViewHolderProxyProvider$proxyFactory$1.INSTANCE;
        b r101 = new b();
        r100.f251016a = r101;
        this.f251021b = r101;
        d r102 = new d(r100);
        r100.f251017b = r102;
        this.f251022c = r102;
    }
}
