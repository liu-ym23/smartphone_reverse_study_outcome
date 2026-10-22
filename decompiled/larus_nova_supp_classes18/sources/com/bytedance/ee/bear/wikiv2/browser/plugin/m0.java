package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.lazy.PluginMountStrategy;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.loading.DocLoadingPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m0 implements com.bytedance.ee.bear.contract.route.parcelable.n {
    public m0() {
    }

    public final com.bytedance.ee.bear.browser.plugin.n a(PluginHost r7) {
        Intrinsics.checkNotNullParameter(r7, "host");
        if ((r7 instanceof DocumentPluginHost) == false) goto L6;
        boolean r0 = yp5.c.e();
        WikiLoaderPlugin r2 = new WikiLoaderPlugin();
        PluginMountStrategy r3 = PluginMountStrategy.Immediate;
        WikiFolderBlockMorePlugin r4 = new WikiFolderBlockMorePlugin();
        PluginMountStrategy r5 = PluginMountStrategy.FirstJSCall;
        return com.bytedance.ee.bear.browser.plugin.n.c(new com.bytedance.ee.bear.browser.plugin.n(new com.bytedance.ee.bear.browser.plugin.n.a[]{com.bytedance.ee.bear.browser.plugin.n.k(r2, r3), com.bytedance.ee.bear.browser.plugin.n.k(new DocLoadingPlugin(), r3), com.bytedance.ee.bear.browser.plugin.n.k(new WikiLoadFailProcessPlugin(), r3), com.bytedance.ee.bear.browser.plugin.n.i(r4, r0, r5), com.bytedance.ee.bear.browser.plugin.n.i(new WikiFolderPushPlugin(), r0, r3), com.bytedance.ee.bear.browser.plugin.n.i(new WikiFolderThumbnailPlugin(), r0, r5)}), n0.a(r7));
    L6:
        return n0.a(r7);
    }
}
