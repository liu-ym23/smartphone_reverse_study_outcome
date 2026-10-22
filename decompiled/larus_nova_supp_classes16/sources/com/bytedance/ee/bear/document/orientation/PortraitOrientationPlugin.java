package com.bytedance.ee.bear.document.orientation;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PortraitOrientationPlugin extends CommonOrientationPlugin {
    private static final String TAG = "PortraitOrientationPlug";

    @Override // com.bytedance.ee.bear.document.orientation.CommonOrientationPlugin, com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public PortraitOrientationPlugin() {
    }

    public void onAttachToHost(DocumentPluginHost r4) {
        super.onAttachToHost(r4);
        if (yo5.a.a(getActivity()) == false) goto L5;
    L8:
        boolean r5 = true;
    L9:
        tt5.a.h(TAG, "supportLandscape:" + r5);
        if (r5 == true) goto L13;
        getActivity().setRequestedOrientation(1);
        return;
    L13:
        return;
    L5:
        if (com.ss.android.lark.base.embedded.b.g() == true) goto L8;
        r5 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }
}
