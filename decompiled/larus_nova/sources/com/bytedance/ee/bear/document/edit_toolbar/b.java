package com.bytedance.ee.bear.document.edit_toolbar;

import com.bytedance.ee.bear.browser.plugin.PluginHost;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements com.bytedance.ee.bear.document.toolbar2.b {
    public b() {
    }

    @Override // com.bytedance.ee.bear.document.toolbar2.b
    public final void a(PluginHost r100) {
        BaseDocToolbarV2Plugin r101 = (BaseDocToolbarV2Plugin) r100.findPlugin(BaseDocToolbarV2Plugin.class);
        if (r101 == null) goto L6;
        r101.resetToolbar();
        return;
    }

    @Override // com.bytedance.ee.bear.document.toolbar2.b
    public final void b(PluginHost r100) {
        BaseDocToolbarV2Plugin r101 = (BaseDocToolbarV2Plugin) r100.findPlugin(BaseDocToolbarV2Plugin.class);
        if (r101 == null) goto L6;
        r101.close();
        return;
    }
}
