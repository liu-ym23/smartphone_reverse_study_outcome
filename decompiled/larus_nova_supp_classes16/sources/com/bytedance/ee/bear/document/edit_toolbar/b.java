package com.bytedance.ee.bear.document.edit_toolbar;

import com.bytedance.ee.bear.browser.plugin.PluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements com.bytedance.ee.bear.document.toolbar2.b {
    public b() {
    }

    @Override // com.bytedance.ee.bear.document.toolbar2.b
    public final void a(PluginHost r2) {
        BaseDocToolbarV2Plugin r3 = (BaseDocToolbarV2Plugin) r2.findPlugin(BaseDocToolbarV2Plugin.class);
        if (r3 == null) goto L6;
        r3.resetToolbar();
        return;
    }

    @Override // com.bytedance.ee.bear.document.toolbar2.b
    public final void b(PluginHost r2) {
        BaseDocToolbarV2Plugin r3 = (BaseDocToolbarV2Plugin) r2.findPlugin(BaseDocToolbarV2Plugin.class);
        if (r3 == null) goto L6;
        r3.close();
        return;
    }
}
