package com.bytedance.ee.bear.doc.structure.pad.container;

import android.view.View;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.doc.structure.pad.viewmodel.CatalogViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import nz4.m;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements MenuItem.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PadCatalogController f218248a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PadCatalogController f218249a;

        public a(PadCatalogController r100) {
            this.f218249a = r100;
        }

        public final void a() {
            com.bytedance.ee.bear.contract.d r100 = m.f521407a;
            Pair[] r101 = new Pair[2];
            if (this.f218249a.f218232d.isCatalogOpen() == false) goto L5;
            String r102 = "1";
        L6:
            r101[0] = TuplesKt.to("catalog_switch", r102);
            r101[1] = TuplesKt.to("action", "docs_iPad_click_catalog_button");
            Map r103 = MapsKt.mapOf(r101);
            m.f521407a.n("docs_iPad_click_catalog_button", r103);
            return;
        L5:
            r102 = "0";
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

    public g(PadCatalogController r100) {
        this.f218248a = r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.MenuItem.b
    public final void a(MenuItem r100, View r101) {
        CatalogViewModel.openOrCloseCatalogView$default(this.f218248a.f218232d, false, 1, null);
        com.bytedance.ee.util.ui.j.c(new a(this.f218248a));
    }
}
