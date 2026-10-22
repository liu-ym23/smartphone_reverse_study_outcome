package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.lazy.PluginMountStrategy;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.leanmode.CCMConfig;
import com.bytedance.ee.bear.document.s4;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n0 {
    public static com.bytedance.ee.bear.browser.plugin.n a(PluginHost r5) {
        Bundle r6 = r5.getHostAbility(s4.class).getFragment().getArguments();
        CCMConfig r0 = ((ww4.a) org.koin.java.a.a(ww4.a.class)).a();
        if (r0.g != null) goto L6;
        r0.g = new CCMConfig.SubConfig();
    L6:
        if (r0.g.a == true) goto L8;
    L17:
        boolean r7 = false;
    L18:
        tt5.a.h("WikiPluginsV2", "enableWikiTreeMenu:" + r7);
        yp5.c.e();
        BasePluginV2 r1 = ((com.bytedance.ee.bear.contract.route.parcelable.j) org.koin.java.a.a(com.bytedance.ee.bear.contract.route.parcelable.j.class)).newLoadingCallbackPlugin();
        PluginMountStrategy r4 = PluginMountStrategy.Immediate;
        return new com.bytedance.ee.bear.browser.plugin.n(new com.bytedance.ee.bear.browser.plugin.n.a[]{com.bytedance.ee.bear.browser.plugin.n.k(r1, r4), com.bytedance.ee.bear.browser.plugin.n.k(new WikiInfoPlugin(), r4), com.bytedance.ee.bear.browser.plugin.n.i(new WikiTreeMenuPlugin(), r7, r4), com.bytedance.ee.bear.browser.plugin.n.k(new SetWikiTreeEnablePlugin(), r4), com.bytedance.ee.bear.browser.plugin.n.i(new WikiTreePlugin(), r7, r4), com.bytedance.ee.bear.browser.plugin.n.k(new WikiFavoritePlugin(), r4), com.bytedance.ee.bear.browser.plugin.n.k(new WikiPinPlugin(), r4), com.bytedance.ee.bear.browser.plugin.n.k(new WikiExploreFavoritePlugin(), r4), com.bytedance.ee.bear.browser.plugin.n.k(new WikiDeletePlugin(), r4), com.bytedance.ee.bear.browser.plugin.n.k(new WikiMakeCopyPlugin(), r4), com.bytedance.ee.bear.browser.plugin.n.k(new WikiMultiTaskPlugin(), r4), com.bytedance.ee.bear.browser.plugin.n.k(new WikiShortcutPlugin(), r4), com.bytedance.ee.bear.browser.plugin.n.k(new WikiMovePlugin(), r4)});
    L8:
        if ((!TextUtils.isEmpty(com.bytedance.ee.bear.doc.follow.impl.t.a(r6))) == true) goto L17;
        String r8 = r6.getString(ResourceData.KEY_URL);
        if (TextUtils.isEmpty(r8) == true) goto L14;
        Uri r9 = UriProtector.parse(r8);
        if (r9 == null) goto L14;
        boolean r10 = TextUtils.equals(UriProtector.getQueryParameter(r9, "from"), DocsOpenSource.chat_tab.name());
    L15:
        if (r10 == true) goto L17;
        r7 = true;
    L14:
        r10 = false;
        goto L15
    }
}
