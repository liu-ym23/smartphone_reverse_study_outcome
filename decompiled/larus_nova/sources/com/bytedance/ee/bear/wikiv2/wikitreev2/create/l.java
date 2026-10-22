package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiItemNewDecoration;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemRootView;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements WikiItemNewDecoration.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f241418a = null;

    static {
        f241418a = new l();
    }

    public l() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.WikiItemNewDecoration.a
    public final boolean a(WikItemLeafView r100, int r101) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if ((r100 instanceof WikItemRootView) == true) goto L8;
        if (r100.f242239r == false) goto L8;
        return true;
    }
}
