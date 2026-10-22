package com.bytedance.ee.bear.doc.blockeditpanel.view;

import android.text.TextUtils;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.highlight.HighlightPanel;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BlockEditPanelFragment f217659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Highlight f217660b;

    public a(BlockEditPanelFragment r100, Highlight r101) {
        this.f217659a = r100;
        this.f217660b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BlockEditPanelFragment r100 = this.f217659a;     // Catch: Throwable -> L13
        int r101 = BlockEditPanelFragment.f217632n;     // Catch: Throwable -> L13
        List<BaseBlockEditPanel> r102 = r100.V90();     // Catch: Throwable -> L13
        BlockEditPanelFragment r103 = this.f217659a;     // Catch: Throwable -> L13
        Iterator r104 = ((ArrayList) r102).iterator();     // Catch: Throwable -> L13
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();     // Catch: Throwable -> L13
        String r106 = ((BaseBlockEditPanel) r105).getPanelId();     // Catch: Throwable -> L13
        r103.getClass();     // Catch: Throwable -> L13
        if (TextUtils.equals(r106, "highlightPanel") == false) goto L4;
    L9:
        BaseBlockEditPanel r107 = (BaseBlockEditPanel) r105;     // Catch: Throwable -> L13
        if (r107 == null) goto L16;
        ((HighlightPanel) r107).d(this.f217660b);     // Catch: Throwable -> L13
        return;
    L16:
        return;
    L8:
        r105 = null;
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    }
}
