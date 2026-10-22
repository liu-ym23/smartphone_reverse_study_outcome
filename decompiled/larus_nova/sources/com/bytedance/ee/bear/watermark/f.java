package com.bytedance.ee.bear.watermark;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements Consumer<WatermarkConfigPuller$WatermarkResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f239831a;

    public f(l.a r100) {
        this.f239831a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(WatermarkConfigPuller$WatermarkResult r100) throws Exception {
        h r101 = this.f239831a;
        r101.a(r100);
    }
}
