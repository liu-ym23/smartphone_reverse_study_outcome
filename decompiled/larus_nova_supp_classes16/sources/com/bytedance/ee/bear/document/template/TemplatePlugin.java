package com.bytedance.ee.bear.document.template;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.c4;
import com.bytedance.ee.bear.domain.BearUrl;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TemplatePlugin extends DocumentPlugin {
    private static final String RENDER_PARAM_IS_TEMPLATE = "isTemplate";

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void clearTemplateRenderParam() {
        k r0 = getWeb();
        if ((r0 instanceof c4) == false) goto L6;
        ((c4) r0).H();
        return;
    }

    private boolean isNewlyCreatedFromTemplate() {
        BearUrl r0 = getDocViewModel().getBearUrl();
        if (r0 != null) goto L6;
        return false;
    L6:
        if ("space_template".equals(r0.h) == false) goto L8;
    L9:
        return true;
    L8:
        if ("new_template".equals(r0.h) == true) goto L9;
        return false;
    }

    private void setTemplateRenderParam() {
        k r0 = getWeb();
        if ((r0 instanceof c4) == false) goto L6;
        ((c4) r0).b(RENDER_PARAM_IS_TEMPLATE, Boolean.TRUE);
        return;
    }

    public TemplatePlugin() {
    }

    public void onAttachToHost(DocumentPluginHost r1) {
        super.onAttachToHost(r1);
        if (isNewlyCreatedFromTemplate() == false) goto L5;
        setTemplateRenderParam();
        return;
    L5:
        clearTemplateRenderParam();
    }

    public void onDetachFromHost(DocumentPluginHost r1) {
        super.onDetachFromHost(r1);
        clearTemplateRenderParam();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }
}
