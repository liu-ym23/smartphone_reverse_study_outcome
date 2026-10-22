package com.bytedance.ee.bear.middleground.docsdk.v2.core;

import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class EditorSdkPluginHost extends WebPluginHost {
    public EditPanelsManager a;

    public final void onCreate(PluginHost.a r3) {
        this.a = q.c(this, EditPanelsManager.class, null);
        super/*com.bytedance.ee.bear.browser.plugin.PluginHost*/.onCreate(r3);
    }
}
