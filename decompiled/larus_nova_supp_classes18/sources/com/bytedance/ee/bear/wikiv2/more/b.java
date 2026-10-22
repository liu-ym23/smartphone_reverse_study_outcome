package com.bytedance.ee.bear.wikiv2.more;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiInfoPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final boolean a(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        if (yp5.c.i() == true) goto L5;
        return false;
    L5:
        WikiInfoPlugin r3 = r2.findPlugin(WikiInfoPlugin.class);
        if (r3 == null) goto L8;
        TreeNode r4 = r3.getWikiMeta();
    L9:
        if (r4 != null) goto L11;
        return false;
    L11:
        if (r4.isWikiHomePage == false) goto L15;
        return true;
    L15:
        return false;
    L8:
        r4 = null;
        goto L9
    }
}
