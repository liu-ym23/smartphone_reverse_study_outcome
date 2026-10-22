package com.volcengine.zeus.download;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes41.dex */
public final class i implements Callable<PluginDownloadBean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f462688a;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public PluginDownloadBean call() {
        return new c(this.f462688a).c();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ PluginDownloadBean call() throws Exception {
        return call();
    }

    public i(String r100) {
        this.f462688a = r100;
    }
}
