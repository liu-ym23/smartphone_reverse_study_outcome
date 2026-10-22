package com.bytedance.ee.bear.bitable.share.sharepanel;

import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m implements w85.a.b {
    public final /* synthetic */ FormsQRCodePanelFragmentV2 a;

    public static final class a implements Runnable {
        public final /* synthetic */ FormsQRCodePanelFragmentV2 a;
        public final /* synthetic */ String b;

        public a(FormsQRCodePanelFragmentV2 r1, String r2) {
            this.a = r1;
            this.b = r2;
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
            if (FormsQRCodePanelFragmentV2.S90(this.a) == false) goto L5;
            FormsQRCodePanelFragmentV2.b r0 = new FormsQRCodePanelFragmentV2.b();     // Catch: Throwable -> L7
            FormsQRCodePanelFragmentV2.BannerSourceType r1 = FormsQRCodePanelFragmentV2.BannerSourceType.LOCAL_PATH;     // Catch: Throwable -> L7
            Intrinsics.checkNotNullParameter(r1, "sourceType");     // Catch: Throwable -> L7
            Intrinsics.checkNotNullParameter(r1, "<set-?>");     // Catch: Throwable -> L7
            r0.d = r1;     // Catch: Throwable -> L7
            r0.c = this.b;     // Catch: Throwable -> L7
            FormsQRCodePanelFragmentV2.a r2 = r0.a();     // Catch: Throwable -> L7
            this.a.W90(r2);     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            tt5.a.h("FormsQRCodePanelFragment", "fragment detached on loadBanner within glide");     // Catch: Throwable -> L7
            goto L12
        }
    }

    @Override // w85.a.b
    public final void e(String r1) {
    }

    public m(FormsQRCodePanelFragmentV2 r1) {
        this.a = r1;
    }

    @Override // w85.a.b
    public final void c(String r3, w85.b r4) {
        if (r4 == null) goto L9;
        File r5 = r4.b;
        if (r5 == null) goto L10;
        String r6 = r5.getAbsolutePath();
        if (r6 == null) goto L11;
        FormsQRCodePanelFragmentV2 r7 = this.a;
        tt5.a.h("FormsQRCodePanelFragment", "onDownloadSuccess path=".concat(r6));
        com.bytedance.ee.util.ui.j.f(new a(r7, r6));
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // w85.a.b
    public final void a(String r2, String r3, int r4) {
        tt5.a.d("FormsQRCodePanelFragment", "onDownloadFail key = " + r3 + " errorCode = " + r4);
    }
}
