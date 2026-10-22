package com.bytedance.ee.bear.doc.structure.pad.container;

import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ PadCatalogController a;

    public e(PadCatalogController r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        tt5.a.h("PadCatalogController", "isCatalogOpenLiveData isOpen=" + r4);
        if (r4.booleanValue() == false) goto L5;
        PadCatalogController.c(this.a);
    L6:
        PluginHost r0 = this.a.f();
        View r1 = null;
        if (r0 == null) goto L11;
        t r2 = r0.getUIContainer();
        if (r2 == null) goto L11;
        TitleBar r5 = r2.getTitleBar();
    L12:
        if (r5 == null) goto L14;
        r1 = r5.findMenuView("pad_catalog_menu");
    L14:
        if (r1 == null) goto L16;
        Intrinsics.checkNotNull(r4);
        r1.setSelected(r4.booleanValue());
    L16:
        PadCatalogController.b(this.a);
        return;
    L11:
        r5 = null;
        goto L12
    L5:
        PadCatalogController.a(this.a);
        goto L6
    }
}
