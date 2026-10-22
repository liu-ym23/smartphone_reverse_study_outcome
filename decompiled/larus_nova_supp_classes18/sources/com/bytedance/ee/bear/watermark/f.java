package com.bytedance.ee.bear.watermark;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements Consumer<WatermarkConfigPuller$WatermarkResult> {
    public final /* synthetic */ h a;

    public f(l.a r1) {
        this.a = r1;
    }

    public final void accept(Object r2) throws Exception {
        h r0 = this.a;
        r0.a((WatermarkConfigPuller$WatermarkResult) r2);
    }
}
