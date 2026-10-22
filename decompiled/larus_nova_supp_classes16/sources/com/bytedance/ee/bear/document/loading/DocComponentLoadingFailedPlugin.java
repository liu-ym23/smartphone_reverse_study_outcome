package com.bytedance.ee.bear.document.loading;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.doccomponent.api.entity.contentevent.DCLoadStateChangedEvent;
import com.bytedance.ee.bear.document.doccomponent.DocComponentPlugin;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/document/loading/DocComponentLoadingFailedPlugin;", "Lcom/bytedance/ee/bear/document/loading/LoadingFailedPlugin;", "<init>", "()V", "replaceDocumentFragment", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocComponentLoadingFailedPlugin extends LoadingFailedPlugin {
    @Override // com.bytedance.ee.bear.document.loading.LoadingFailedPlugin, com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.loading.LoadingFailedPlugin
    public void replaceDocumentFragment() {
        DocComponentPlugin r0 = (DocComponentPlugin) findPlugin(DocComponentPlugin.class);
        if (r0 == null) goto L6;
        r0.processContentEvent(new DCLoadStateChangedEvent(DCLoadStateChangedEvent.LoadState.LoadFailAndReplaceDocFragment));
        return;
    }

    public DocComponentLoadingFailedPlugin() {
    }
}
