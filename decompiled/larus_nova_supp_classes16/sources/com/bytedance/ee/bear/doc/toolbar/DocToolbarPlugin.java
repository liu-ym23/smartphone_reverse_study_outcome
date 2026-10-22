package com.bytedance.ee.bear.doc.toolbar;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.toolbar.NavBarBottomInsetCompatEntity;
import com.bytedance.ee.bear.document.toolbar.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocToolbarPlugin extends DocumentToolbarPlugin {
    private static final String TAG = "DocToolbarPlugin";

    @Override // com.bytedance.ee.bear.doc.toolbar.DocumentToolbarPlugin, com.bytedance.ee.bear.document.toolbar.BaseToolbarPlugin, com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DocToolbarPlugin() {
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPlugin
    public void onAttachToHost(DocumentPluginHost r4) {
        super.onAttachToHost(r4);
        NavBarBottomInsetCompatEntity r5 = (NavBarBottomInsetCompatEntity) c.a.a.c("doc_toolbar_android_compat", NavBarBottomInsetCompatEntity.class, new NavBarBottomInsetCompatEntity());
        n.b.a.c(getActivity(), r5);
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }
}
