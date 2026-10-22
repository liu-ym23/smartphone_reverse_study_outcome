package com.bytedance.ee.bear.document.loading;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.doc.follow.event.LoadStateChangedEvent;
import com.bytedance.ee.bear.document.follow.FollowPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class VCLoadingFailedPlugin extends LoadingFailedPlugin {
    private static final String TAG = "VCLoadingFailedPlugin";

    @Override // com.bytedance.ee.bear.document.loading.LoadingFailedPlugin, com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.loading.LoadingFailedPlugin
    public void replaceDocumentFragment() {
        FollowPlugin r0 = (FollowPlugin) findPlugin(FollowPlugin.class);
        if (r0 == null) goto L6;
        tt5.a.h(TAG, "load fail and then inform VC of recreating new fragment");
        r0.processEvent(new LoadStateChangedEvent(LoadStateChangedEvent.LoadState.LoadFailAndReplaceDocFragment));
        return;
    }

    public VCLoadingFailedPlugin() {
    }
}
