package com.bytedance.ee.bear.bitable.itemview.cell.stage;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StageTabCell f213987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.card.model.stmodel.field.d f213988b;

    public m(StageTabCell r100, com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r101) {
        this.f213987a = r100;
        this.f213988b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StageActionPayload r100 = this.f213987a.b("ItemViewStageRevertAction", this.f213988b.f207141a);     // Catch: Throwable -> L8
        if (r100 == null) goto L11;
        gv4.a r101 = this.f213987a.getMHandler();     // Catch: Throwable -> L8
        if (r101 == null) goto L15;
        r101.a(r100);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
