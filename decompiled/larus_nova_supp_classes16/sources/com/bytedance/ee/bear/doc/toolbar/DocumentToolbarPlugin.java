package com.bytedance.ee.bear.doc.toolbar;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel;
import com.bytedance.ee.bear.document.toolbar.BaseToolbarPlugin;
import com.bytedance.ee.bear.document.toolbar.BaseToolbarPlugin$ToolbarJSHandler$CC;
import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.document.toolbar.Toolbar;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocumentToolbarPlugin extends BaseToolbarPlugin<DocToolbar> {
    private static final String TAG = "DocToolbarPlugin";

    public class a implements BaseToolbarPlugin.b<DocToolbar> {
        public m a;
        public final /* synthetic */ DocumentToolbarPlugin b;

        @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPlugin.b, tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BaseToolbarPlugin$ToolbarJSHandler$CC.$default$authType(this);
        }

        public a(DocumentToolbarPlugin r1) {
            this.b = r1;
        }

        @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPlugin.b
        public final void b(ItemId r3, String r4) {
            if (this.a != null) goto L5;
            return;
        L5:
            JSONObject r0 = new JSONObject();
            r0.put("id", r3.name());
            r0.put("value", r4);
            tt5.a.b(DocumentToolbarPlugin.TAG, r0.toString());
            this.a.b(r0);
        }

        @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPlugin.b, tb5.i, tb5.o
        public final void handle(Object r3, m r4) {
            DocToolbar r5 = (DocToolbar) r3;
            tt5.a.b(DocumentToolbarPlugin.TAG, "Js update toolbar:" + r5);
            if (r5 == null) goto L5;
            r5.initFromJsBridge(DocItemId.values());
        L5:
            this.a = r4;
            DocumentToolbarPlugin r6 = this.b;
            if (r5 != null) goto L8;
        L9:
            r5 = null;
        L10:
            DocumentToolbarPlugin.access$100(r6, r5);
            return;
        L8:
            if (r5.getChildren().length != 0) goto L10;
            goto L9
        }
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPlugin
    public String getToolbarJSBinderName() {
        return "biz.navigation.setDocToolbar";
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPlugin, com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPlugin
    public BaseToolbarPlugin.b<DocToolbar> onCreateToolbarJSHandler() {
        return new a(this);
    }

    public DocumentToolbarPlugin() {
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPlugin
    public BaseToolbarPanelViewModel<DocToolbar> getToolbarViewModel(FragmentActivity r2) {
        return (BaseToolbarPanelViewModel) ViewModelProviders.of(r2).get(DocToolbarPanelViewModel.class);
    }

    public static /* synthetic */ void access$100(DocumentToolbarPlugin r0, Toolbar r1) {
        r0.updateToolbar(r1);
    }

    @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPlugin
    public Fragment onCreateToolbarFragment(Context r2, String r3) {
        Bundle r4 = new Bundle();
        r4.putString("url", r3);
        return instantiateFragment(DocToolbarPanelFragment.class, r4);
    }
}
