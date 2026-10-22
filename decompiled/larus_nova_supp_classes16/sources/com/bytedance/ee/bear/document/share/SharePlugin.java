package com.bytedance.ee.bear.document.share;

import android.content.Intent;
import androidx.lifecycle.Lifecycle;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.m;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.event.IEventPlugin;
import com.bytedance.ee.util.ui.j;
import s35.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SharePlugin extends DocumentPlugin implements sa5.a, m.a {
    private static final String TAG = "SharePlugin";
    private final IEventPlugin.a mOnDeleteListener;
    private com.bytedance.ee.bear.document.share.a mShareHandler;

    public class a implements IEventPlugin.a {
        public a() {
        }

        @Override // com.bytedance.ee.bear.document.event.IEventPlugin.a
        public final void a(String r1) {
            j.c(new e());
        }
    }

    public class b implements c {
        public final /* synthetic */ SharePlugin a;

        public b(SharePlugin r1) {
            this.a = r1;
        }
    }

    public interface c {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public c getShareCallBack() {
        return new b(this);
    }

    public SharePlugin() {
        this.mOnDeleteListener = new a();
    }

    @Override // com.bytedance.ee.bear.contract.m.a
    public void onRequestExport() {
        if (getActivity().getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) goto L7;
        tt5.a.k(TAG, "onRequestExport, activity is not RESUMED");
        return;
    L7:
        if (this.mShareHandler == null) goto L13;
        tt5.a.h(TAG, "onRequestExport.");
        com.bytedance.ee.bear.document.share.a r0 = this.mShareHandler;
        if (r0.a == null) goto L14;
        JSONObject r1 = new JSONObject();
        r1.put("id", ShareItem.SHARE_IMAGE);
        r0.a.b(r1);
        return;
    L14:
        return;
    }

    public void startShare() {
        if (isUIContainerDetached() == false) goto L6;
        tt5.a.k(TAG, "startShare when not active !");
        return;
    L6:
        execJS("javascript:window.lark.biz.sheet.clickShare", new JSONObject());
    }

    public com.bytedance.ee.bear.document.share.a createHandler(DocumentPluginHost r3) {
        return new com.bytedance.ee.bear.document.share.a(r3, getShareCallBack());
    }

    public static /* synthetic */ f access$000(SharePlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        com.bytedance.ee.bear.document.share.a r3 = createHandler(r1);
        this.mShareHandler = r3;
        bindBridgeHandler("biz.util.share", r3);
        ((m) org.koin.java.a.a(m.class)).l(this);
        IEventPlugin r4 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r4 == null) goto L6;
        r4.addDeleteListener(this.mOnDeleteListener);
        return;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        ((m) org.koin.java.a.a(m.class)).g(this);
        IEventPlugin r3 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r3 == null) goto L6;
        r3.removeDeleteListener(this.mOnDeleteListener);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // sa5.a
    public void onActivityResult(int r3, int r4, Intent r5) {
        com.bytedance.ee.bear.document.share.a r6 = this.mShareHandler;
        if (r3 != 0) goto L24;
        s35.b r7 = r6.c;
        if (r7 != null) goto L7;
        return;
    L7:
        if (r4 != 201) goto L10;
        String r8 = "share_to_lark";
    L16:
        s35.a r9 = r7.l;
        if (r9 == null) goto L23;
        if (r8 == null) goto L23;
        if (r9.a == null) goto L23;
        JSONObject r0 = new JSONObject();
        r0.put("id", r8);
        r9.a.b(r0);
    L23:
        tt5.a.h("ShareHandler", "share content " + r6.c.toString());
        return;
    L10:
        if (r4 != 202) goto L13;
        r8 = "share_to_toutiao";
        goto L16
    L13:
        if (r4 != 203) goto L15;
        r8 = "copy_link";
        goto L16
    L15:
        r8 = null;
        goto L16
    L24:
        r6.getClass();
    }
}
