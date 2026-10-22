package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.s4;

/* JADX INFO: loaded from: classes18.dex */
public final class g1 {
    public static WikiViewModel a(PluginHost r100) {
        WikiViewModel r101 = (WikiViewModel) com.bytedance.ee.bear.browser.plugin.q.c(r100, WikiViewModel.class, null);
        if (r101.isInit() == true) goto L5;
        r101.init(((s4) r100.getHostAbility(s4.class)).getFragment().getArguments());
    L5:
        return r101;
    }
}
