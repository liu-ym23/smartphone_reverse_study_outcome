package com.bytedance.ee.bear.middleground.docsdk.v2;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStoreOwner;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.doc.toolbar.DocItemId;
import com.bytedance.ee.bear.doc.toolbar.DocToolbar;
import com.bytedance.ee.bear.doc.toolbar.DocToolbarPanelViewModel;
import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel;
import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.document.toolbar.Toolbar;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.DocSDKBaseToolbarPlugin;
import com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.DocSDKBaseToolbarPlugin$ToolbarJSHandler$CC;
import com.bytedance.ee.bear.middleground.docsdk.v2.core.EditorSdkPluginHost;
import com.bytedance.ee.bear.middleground.docsdk.v2.toolbar.DocSDKAppletsToolbarPanelFragment;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Map;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
class SDKV2ToolbarPlugin extends DocSDKBaseToolbarPlugin<DocToolbar> {
    private static final String TAG = "SDKV2ToolbarPlugin";

    public class a implements DocSDKBaseToolbarPlugin.a<DocToolbar> {
        public m a;
        public final /* synthetic */ SDKV2ToolbarPlugin b;

        @Override // com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.DocSDKBaseToolbarPlugin.a
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return DocSDKBaseToolbarPlugin$ToolbarJSHandler$CC.$default$authType(this);
        }

        public a(SDKV2ToolbarPlugin r1) {
            this.b = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.DocSDKBaseToolbarPlugin.a
        public final void b(ItemId r3, String r4) {
            if (this.a != null) goto L5;
            return;
        L5:
            JSONObject r0 = new JSONObject();
            r0.put(ResourceData.KEY_ID, r3.name());
            r0.put("value", r4);
            tt5.a.b(SDKV2ToolbarPlugin.TAG, r0.toString());
            this.a.b(r0);
        }

        @Override // com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.DocSDKBaseToolbarPlugin.a
        public final void handle(DocToolbar r3, m r4) {
            DocToolbar r5 = r3;
            tt5.a.b(SDKV2ToolbarPlugin.TAG, "Js update toolbar:" + r5);
            if (r5 == null) goto L5;
            r5.initFromJsBridge(DocItemId.values());
        L5:
            this.a = r4;
            SDKV2ToolbarPlugin r6 = this.b;
            if (r5 != null) goto L8;
        L9:
            r5 = null;
        L10:
            SDKV2ToolbarPlugin.access$100(r6, r5);
            return;
        L8:
            if (r5.getChildren().length != 0) goto L10;
            goto L9
        }
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.DocSDKBaseToolbarPlugin, com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin
    public void getBridgeHandlers(Map<String, i<?>> r1) {
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.DocSDKBaseToolbarPlugin
    public String getToolbarJSBinderName() {
        return "biz.navigation.setToolBar";
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.DocSDKBaseToolbarPlugin, com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.DocSDKBaseToolbarPlugin
    public DocSDKBaseToolbarPlugin.a<DocToolbar> onCreateToolbarJSHandler() {
        return new a(this);
    }

    public SDKV2ToolbarPlugin() {
        setToolbarAnimation(2130772208, 2130772209);
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.DocSDKBaseToolbarPlugin
    public void ensureToolbarFragment(boolean r2) {
        if (getUIContainer().f(this) == false) goto L5;
        super.ensureToolbarFragment(true);
        return;
    L5:
        super.ensureToolbarFragment(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.DocSDKBaseToolbarPlugin
    public BaseToolbarPanelViewModel<DocToolbar> getToolbarViewModel(ViewModelStoreOwner r3) {
        BaseToolbarPanelViewModel<DocToolbar> r4 = q.c(getHost(), DocToolbarPanelViewModel.class, null);
        tt5.a.h(TAG, "view model = " + r4.hashCode());
        return r4;
    }

    public static /* synthetic */ void access$100(SDKV2ToolbarPlugin r0, Toolbar r1) {
        r0.updateToolbar(r1);
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.DocSDKBaseToolbarPlugin
    public Fragment onCreateToolbarFragment(Context r2, String r3) {
        Bundle r4 = new Bundle();
        r4.putString(ResourceData.KEY_URL, r3);
        return instantiateFragment(DocSDKAppletsToolbarPanelFragment.class, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.DocSDKBaseToolbarPlugin
    public void onDetachFromUIContainer(EditorSdkPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        this.toolbarViewModel.setActive(false);
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.DocSDKBaseToolbarPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((EditorSdkPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.DocSDKBaseToolbarPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((EditorSdkPluginHost) r1, r2);
    }
}
