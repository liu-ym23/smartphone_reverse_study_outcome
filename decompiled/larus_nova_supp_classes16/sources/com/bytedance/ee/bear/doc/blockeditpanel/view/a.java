package com.bytedance.ee.bear.doc.blockeditpanel.view;

import android.text.TextUtils;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.highlight.HighlightPanel;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements Runnable {
    public final /* synthetic */ BlockEditPanelFragment a;
    public final /* synthetic */ Highlight b;

    public a(BlockEditPanelFragment r1, Highlight r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BlockEditPanelFragment r0 = this.a;     // Catch: Throwable -> L13
        int r1 = BlockEditPanelFragment.n;     // Catch: Throwable -> L13
        List<BaseBlockEditPanel> r2 = r0.V90();     // Catch: Throwable -> L13
        BlockEditPanelFragment r3 = this.a;     // Catch: Throwable -> L13
        Iterator r4 = ((ArrayList) r2).iterator();     // Catch: Throwable -> L13
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r5 = r4.next();     // Catch: Throwable -> L13
        String r6 = ((BaseBlockEditPanel) r5).getPanelId();     // Catch: Throwable -> L13
        r3.getClass();     // Catch: Throwable -> L13
        if (TextUtils.equals(r6, "highlightPanel") == false) goto L4;
    L9:
        BaseBlockEditPanel r7 = (BaseBlockEditPanel) r5;     // Catch: Throwable -> L13
        if (r7 == null) goto L16;
        ((HighlightPanel) r7).d(this.b);     // Catch: Throwable -> L13
        return;
    L16:
        return;
    L8:
        r5 = null;
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    }
}
