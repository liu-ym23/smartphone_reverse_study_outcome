package com.ss.android.lark.watermark.userscope;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.watermark.core.IAttachResultCallback;
import com.ss.android.lark.watermark.core.IAttachToBitmapCallback;
import com.ss.android.lark.watermark.core.WatermarkPointContext;
import com.ss.android.lark.watermark.core.WatermarkType;
import com.ss.android.lark.watermark.dto.WatermarkData;
import com.ss.android.lark.watermark.dto.WatermarkInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class k extends c0c.b implements com.ss.android.lark.watermark.v2.p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.watermark.v2.p f445451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f445452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<com.ss.android.lark.watermark.v2.p> f445453d;

    @Override // com.ss.android.lark.watermark.v2.p
    public final void addWatermarkToBitmap(Bitmap r100, IAttachToBitmapCallback r101) {
        this.f445451b.addWatermarkToBitmap(r100, r101);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final void attachWatermark(Activity r100, IAttachResultCallback r101) {
        this.f445451b.attachWatermark(r100, r101);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final void attachWatermark(Activity r100, boolean r101, IAttachResultCallback r102) {
        this.f445451b.attachWatermark(r100, r101, r102);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final void attachWatermark(FrameLayout r100, IAttachResultCallback r101) {
        this.f445451b.attachWatermark(r100, r101);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final void attachWatermark(FrameLayout r100, boolean r101, IAttachResultCallback r102) {
        this.f445451b.attachWatermark(r100, r101, r102);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final void detachWatermark(Activity r100) {
        this.f445451b.detachWatermark(r100);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final void detachWatermark(FrameLayout r100) {
        this.f445451b.detachWatermark(r100);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final WatermarkInfo get() {
        return this.f445451b.get();
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final WatermarkData getWatermarkData(WatermarkType r100) {
        return this.f445451b.getWatermarkData(r100);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final void init(Context r100) {
        this.f445451b.init(r100);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public final void tryAddFileWatermarkToBitmap(Bitmap r100, IAttachToBitmapCallback r101, WatermarkType r102, WatermarkPointContext r103) {
        this.f445451b.tryAddFileWatermarkToBitmap(r100, r101, r102, r103);
    }

    @Override // com.ss.android.lark.watermark.v2.p
    public void update(WatermarkInfo r100) {
        this.f445451b.update(r100);
    }

    public k(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<com.ss.android.lark.watermark.v2.p> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), com.ss.android.lark.watermark.v2.p.class), com.ss.android.lark.watermark.v2.p.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f445451b = r103.b();
        this.f445452c = r101;
        this.f445453d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        com.ss.android.lark.passportc.internal.v r102 = this.f445452c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        com.ss.android.lark.watermark.v2.p r104 = (com.ss.android.lark.watermark.v2.p) e0c.k.b(r102.c(r103), com.ss.android.lark.watermark.v2.p.class);
        this.f445453d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
