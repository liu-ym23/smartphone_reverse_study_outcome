package com.bytedance.ee.bear.bitable.share.sharepanel;

import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements w85.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FormsQRCodePanelFragment f215442a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormsQRCodePanelFragment f215443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f215444b;

        public a(FormsQRCodePanelFragment r100, String r101) {
            this.f215443a = r100;
            this.f215444b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        L15:
            return;
        L3:
            if (FormsQRCodePanelFragment.S90(this.f215443a) == false) goto L5;
            this.f215443a.T90(this.f215444b);     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            tt5.a.h("FormsQRCodePanelFragment", "fragment detached on loadBanner within glide");     // Catch: Throwable -> L7
            goto L12
        }
    }

    @Override // w85.a.b
    public final void e(String r100) {
    }

    public g(FormsQRCodePanelFragment r100) {
        this.f215442a = r100;
    }

    @Override // w85.a.b
    public final void c(String r100, w85.b r101) {
        if (r101 == null) goto L9;
        File r102 = r101.f558653b;
        if (r102 == null) goto L10;
        String r103 = r102.getAbsolutePath();
        if (r103 == null) goto L11;
        FormsQRCodePanelFragment r104 = this.f215442a;
        tt5.a.h("FormsQRCodePanelFragment", "onDownloadSuccess path=".concat(r103));
        com.bytedance.ee.util.ui.j.f(new a(r104, r103));
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // w85.a.b
    public final void a(String r100, String r101, int r102) {
        tt5.a.d("FormsQRCodePanelFragment", "onDownloadFail key = " + r101 + " errorCode = " + r102);
    }
}
