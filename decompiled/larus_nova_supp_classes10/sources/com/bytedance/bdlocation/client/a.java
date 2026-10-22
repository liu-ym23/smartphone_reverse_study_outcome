package com.bytedance.bdlocation.client;

import com.bytedance.bdlocation.BDLocation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ BDLocation b;

    public /* synthetic */ a(int r1, BDLocation r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BDLocationConfig.a(this.a, this.b);
    }
}
