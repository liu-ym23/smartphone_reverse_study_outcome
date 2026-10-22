package com.vivo.push.b;

import com.ss.ttvideoengine.DataLoaderHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class r extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f462259a = "notify_guide_dialog_result";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f462260b;

    public r() {
        super(DataLoaderHelper.DATALOADER_KEY_INT_OPTIMIZE_RANGE);
    }

    public final int e() {
        return this.f462260b;
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void c(com.vivo.push.d r100) {
        super.c(r100);
        r100.a(f462259a, this.f462260b);
    }

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void d(com.vivo.push.d r100) {
        super.d(r100);
        this.f462260b = r100.b(f462259a, -1);
    }
}
