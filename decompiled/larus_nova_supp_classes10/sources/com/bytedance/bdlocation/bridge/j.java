package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ PlatformNetworkRequestHandle a;

    public /* synthetic */ j(PlatformNetworkRequestHandle r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.cancel();
    }
}
