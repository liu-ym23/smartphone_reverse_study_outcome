package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.s4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g1 {
    public static WikiViewModel a(PluginHost r2) {
        WikiViewModel r0 = (WikiViewModel) com.bytedance.ee.bear.browser.plugin.q.c(r2, WikiViewModel.class, null);
        if (r0.isInit() == true) goto L5;
        r0.init(r2.getHostAbility(s4.class).getFragment().getArguments());
    L5:
        return r0;
    }
}
