package com.bytedance.ee.bear.doc.structure.pad.container;

import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.doc.structure.pad.viewmodel.CatalogViewModel;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import nz4.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements MenuItem.b {
    public final /* synthetic */ PadCatalogController a;

    public static final class a implements Runnable {
        public final /* synthetic */ PadCatalogController a;

        public a(PadCatalogController r1) {
            this.a = r1;
        }

        public final void a() {
            com.bytedance.ee.bear.contract.d r0 = m.a;
            Pair[] r1 = new Pair[2];
            if (this.a.d.isCatalogOpen() == false) goto L5;
            String r2 = DiagramData$RESULT.SUCCESS;
        L6:
            r1[0] = TuplesKt.to("catalog_switch", r2);
            r1[1] = TuplesKt.to(JSEventListener.ACTION, "docs_iPad_click_catalog_button");
            Map r3 = MapsKt.mapOf(r1);
            m.a.n("docs_iPad_click_catalog_button", r3);
            return;
        L5:
            r2 = DiagramData$RESULT.FAIL;
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

    public g(PadCatalogController r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
    public final void a(MenuItem r3, View r4) {
        CatalogViewModel.openOrCloseCatalogView$default(this.a.d, false, 1, null);
        com.bytedance.ee.util.ui.j.c(new a(this.a));
    }
}
