package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.ee.bear.drive.biz.preview.vc.pdf.DrivePdfState;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i0 implements Runnable {
    public final /* synthetic */ PDFCtrlView a;

    public static final class a implements MessageQueue.IdleHandler {
        public final /* synthetic */ PDFCtrlView a;

        public a(PDFCtrlView r1) {
            this.a = r1;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            PDFCtrlViewModel r0 = this.a.k;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r0 = null;
        L5:
            r0.turnToPage(this.a.getPresentationViewFromXml().getPageIndex() - 1);
            PDFCtrlView r1 = this.a;
            DrivePdfState r2 = r1.x;
            if (r2 != null) goto L8;
            return false;
        L8:
            com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.InterfaceC0155a r3 = r1.y;
            if (r3 == null) goto L18;
            if (r3 == null) goto L18;
            com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.a r4 = (com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.a) r3;
            com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a r5 = r4.a.p();
            if (r5 != null) goto L15;
            tt5.a.k("CCMFollow_PDFVCFollowConnector", "configurationChanged: 228");
            goto L18
        L15:
            if (r2.getV2() != null) goto L17;
            r4.a.r(r2.getPageNumber() - 1, r2.getPageOffsetTop());
            r5.setCurrentPosition(r2.getPageNumber());
            goto L18
        L17:
            r4.a.s(r2.getV2());
        L18:
            return false;
        }
    }

    public i0(PDFCtrlView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myQueue().addIdleHandler(new a(this.a));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
