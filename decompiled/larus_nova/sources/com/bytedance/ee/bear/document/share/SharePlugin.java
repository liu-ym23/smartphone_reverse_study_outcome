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

/* JADX INFO: loaded from: classes16.dex */
public class SharePlugin extends DocumentPlugin implements sa5.a, m.a {
    private static final String TAG = "SharePlugin";
    private final IEventPlugin.a mOnDeleteListener;
    private com.bytedance.ee.bear.document.share.a mShareHandler;

    public class a implements IEventPlugin.a {
        public a() {
        }

        @Override // com.bytedance.ee.bear.document.event.IEventPlugin.a
        public final void a(String r100) {
            j.c(new e());
        }
    }

    public class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SharePlugin f221762a;

        public b(SharePlugin r100) {
            this.f221762a = r100;
        }
    }

    public interface c {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
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
        com.bytedance.ee.bear.document.share.a r100 = this.mShareHandler;
        if (r100.f540466a == null) goto L14;
        JSONObject r101 = new JSONObject();
        r101.put2("id", ShareItem.SHARE_IMAGE);
        r100.f540466a.b(r101);
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

    public com.bytedance.ee.bear.document.share.a createHandler(DocumentPluginHost r100) {
        return new com.bytedance.ee.bear.document.share.a(r100, getShareCallBack());
    }

    public static /* synthetic */ f access$000(SharePlugin r100, Class r101) {
        return r100.findPlugin(r101);
    }

    public void onAttachToUIContainer(DocumentPluginHost r100, t r101) {
        super.onAttachToUIContainer(r100, r101);
        com.bytedance.ee.bear.document.share.a r102 = createHandler(r100);
        this.mShareHandler = r102;
        bindBridgeHandler("biz.util.share", r102);
        ((m) org.koin.java.a.a(m.class)).l(this);
        IEventPlugin r103 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r103 == null) goto L6;
        r103.addDeleteListener(this.mOnDeleteListener);
        return;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r100, t r101) {
        super.onDetachFromUIContainer(r100, r101);
        ((m) org.koin.java.a.a(m.class)).g(this);
        IEventPlugin r102 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r102 == null) goto L6;
        r102.removeDeleteListener(this.mOnDeleteListener);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101) {
        onAttachToUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // sa5.a
    public void onActivityResult(int r100, int r101, Intent r102) {
        com.bytedance.ee.bear.document.share.a r103 = this.mShareHandler;
        if (r100 != 0) goto L24;
        s35.b r104 = r103.f221764c;
        if (r104 != null) goto L7;
        return;
    L7:
        if (r101 != 201) goto L10;
        String r105 = "share_to_lark";
    L16:
        s35.a r106 = r104.f540478l;
        if (r106 == null) goto L23;
        if (r105 == null) goto L23;
        if (r106.f540466a == null) goto L23;
        JSONObject r107 = new JSONObject();
        r107.put2("id", r105);
        r106.f540466a.b(r107);
    L23:
        tt5.a.h("ShareHandler", "share content " + r103.f221764c.toString());
        return;
    L10:
        if (r101 != 202) goto L13;
        r105 = "share_to_toutiao";
        goto L16
    L13:
        if (r101 != 203) goto L15;
        r105 = "copy_link";
        goto L16
    L15:
        r105 = null;
        goto L16
    L24:
        r103.getClass();
    }
}
