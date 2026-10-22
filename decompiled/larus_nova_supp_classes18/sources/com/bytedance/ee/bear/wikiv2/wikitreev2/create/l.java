package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiItemNewDecoration;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemRootView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements WikiItemNewDecoration.a {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiItemNewDecoration.a
    public final boolean a(WikItemLeafView r1, int r2) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if ((r1 instanceof WikItemRootView) == true) goto L8;
        if (r1.r == false) goto L8;
        return true;
    }
}
