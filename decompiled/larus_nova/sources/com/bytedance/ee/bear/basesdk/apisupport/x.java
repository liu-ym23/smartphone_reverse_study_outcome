package com.bytedance.ee.bear.basesdk.apisupport;

import com.ss.android.lark.watermark.dto.WatermarkInfo;

/* JADX INFO: loaded from: classes15.dex */
public final class x implements pn4.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f206585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pn4.m f206586b;

    @Override // pn4.m
    public final void b(WatermarkInfo r100) {
        tt5.a.h("Apisupport", "api call: updateWatermarkInfo");
        ((w) this.f206585a).d();
        this.f206586b.b(r100);
    }

    public x(n r100, pn4.m r101) {
        this.f206585a = r100;
        this.f206586b = r101;
    }
}
