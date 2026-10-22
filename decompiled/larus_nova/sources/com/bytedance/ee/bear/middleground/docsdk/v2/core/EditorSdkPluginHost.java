package com.bytedance.ee.bear.middleground.docsdk.v2.core;

import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;

/* JADX INFO: loaded from: classes18.dex */
public class EditorSdkPluginHost extends WebPluginHost {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EditPanelsManager f232401a;

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final void onCreate(PluginHost.a r100) {
        this.f232401a = (EditPanelsManager) q.c(this, EditPanelsManager.class, null);
        super.onCreate(r100);
    }
}
