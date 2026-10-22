package com.bytedance.ee.bear.doc.blockeditpanel.view;

import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements Runnable {
    public final /* synthetic */ BaseBlockEditPanel a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ BlockEditPanelFragment e;

    public e(BaseBlockEditPanel r1, int r2, int r3, int r4, BlockEditPanelFragment r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        int r0 = this.a.getMeasuredHeight();
        tt5.a.h("BlockEditPanelFragment", "panel id: " + this.a.getPanelId());
        int r1 = this.b;
        if (r0 >= r1) goto L5;
        tt5.a.h("BlockEditPanelFragment", "this panel height: (" + r0 + ") Low to topPanelHeight: " + this.b + "; not need scale");
    L6:
        this.a.a(false);
        return;
    L5:
        int r2 = r1 - (((this.c - this.d) - 1) * this.e.g);
        tt5.a.h("BlockEditPanelFragment", "this targetHeight: (" + r2 + ") ; " + this.a.getPanelId());
        BlockEditPanelFragment r3 = this.e;
        BaseBlockEditPanel r4 = this.a;
        r3.getClass();
        BlockEditPanelFragment.U90(r4, r2).start();
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
