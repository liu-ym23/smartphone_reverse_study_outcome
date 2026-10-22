package com.bytedance.ee.bear.middleground.docsdk.v2;

import com.bytedance.ee.bear.atfinder.e;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.middleground.docsdk.v2.core.EditorSdkPluginHost;
import kn4.f;
import kn4.i;
import kn4.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
class SDKV2MentionPlugin extends BaseSDKMentionPlugin {
    private e mentionDelegate;

    @Override // com.bytedance.ee.bear.middleground.docsdk.v2.BaseSDKMentionPlugin, com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.v2.BaseSDKMentionPlugin
    public e onCreateMentionDelegate() {
        return this.mentionDelegate;
    }

    public SDKV2MentionPlugin(e r1) {
        this.mentionDelegate = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.v2.BaseSDKMentionPlugin
    public void onAttachToHost(EditorSdkPluginHost r2) {
        f.a = new j();
        f.b = new i();
        super.onAttachToHost(r2);
    }

    public void onDetachFromHost(EditorSdkPluginHost r2) {
        f.a = null;
        f.b = null;
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.v2.BaseSDKMentionPlugin
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((EditorSdkPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((EditorSdkPluginHost) r1);
    }
}
