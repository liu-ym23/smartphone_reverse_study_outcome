package com.larus.canvas.feature.component.logic.helper;

import com.bytedance.router.SmartRouter;
import com.larus.canvas.feature.CreationCanvasActivity;
import com.larus.utils.logger.FLogger;
import hq9.q3;

/* JADX INFO: loaded from: classes26.dex */
public final class b implements q3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f323367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CreationCanvasActivity f323368b;

    @Override // hq9.q3
    public final void a() {
    }

    @Override // hq9.q3
    public final void b(boolean r100) {
    }

    @Override // hq9.q3
    public final void c() {
        String r100 = this.f323367a;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        FLogger.f375446a.i("CanvasMemberQuotaPush", "click push but actionUrl is empty");
        return;
    L12:
        SmartRouter.buildRoute(this.f323368b, this.f323367a).d();
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public b(String r100, CreationCanvasActivity r101) {
        this.f323367a = r100;
        this.f323368b = r101;
    }
}
