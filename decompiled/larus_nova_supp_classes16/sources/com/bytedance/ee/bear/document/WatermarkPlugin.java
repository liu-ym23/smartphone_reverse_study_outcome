package com.bytedance.ee.bear.document;

import com.bytedance.ee.bear.browser.plugin.PluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WatermarkPlugin extends DocumentPlugin {
    private static final String TAG = "WatermarkPlugin";

    public static /* synthetic */ void c(WatermarkPlugin r0, String r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public WatermarkPlugin() {
    }

    private /* synthetic */ void lambda$onAttachToHost$0(String r4) {
        int r0 = getDocViewModel().getDocumentTypeValue();
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        if (bx4.b.b(r4) == false) goto L9;
        tt5.a.h(TAG, "skip update watermark for fake token");
        return;
    L9:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).o(r4, r0, getActivity());
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super.onAttachToHost(r3);
        getDocViewModel().liveDocObjToken().observe(getLifecycleOwner(), new d7(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }
}
