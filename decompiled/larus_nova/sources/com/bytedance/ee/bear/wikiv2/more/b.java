package com.bytedance.ee.bear.wikiv2.more;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiInfoPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {
    public static final boolean a(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        if (yp5.c.i() == true) goto L5;
        return false;
    L5:
        WikiInfoPlugin r101 = (WikiInfoPlugin) r100.findPlugin(WikiInfoPlugin.class);
        if (r101 == null) goto L8;
        TreeNode r102 = r101.getWikiMeta();
    L9:
        if (r102 != null) goto L11;
        return false;
    L11:
        if (r102.isWikiHomePage == false) goto L15;
        return true;
    L15:
        return false;
    L8:
        r102 = null;
        goto L9
    }
}
