package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlatformNetworkRequestHandle f199856a;

    public /* synthetic */ j(PlatformNetworkRequestHandle r100) {
        this.f199856a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f199856a.cancel();
    }
}
