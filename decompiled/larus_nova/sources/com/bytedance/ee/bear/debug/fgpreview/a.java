package com.bytedance.ee.bear.debug.fgpreview;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FGPreviewActivity f217396a;

    public a(FGPreviewActivity r100) {
        this.f217396a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.showText(this.f217396a, "请求失败了.....", 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
