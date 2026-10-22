package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: classes18.dex */
public class WikiInfoPlugin extends BasePluginV2 implements com.bytedance.ee.bear.contract.route.parcelable.d {
    private static final String TAG = "WikiInfoPlugin";
    private final boolean isWikiRootCustomHomePageEnable;

    @Override // com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public WikiInfoPlugin() {
        this.isWikiRootCustomHomePageEnable = yp5.c.i();
    }

    public TreeNode getWikiMeta() {
        return g1.a(getHost()).getWikiMeta();
    }

    public WikNodePerm getWikiPerm() {
        return g1.a(getHost()).getWikiPerm();
    }

    public boolean isMyLib() {
        return g1.a(getHost()).isMyLib();
    }

    @Override // com.bytedance.ee.bear.contract.route.parcelable.d
    public boolean isWikiHomePage() {
        TreeNode r100 = getWikiMeta();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isWikiHomePage == false) goto L7;
        return true;
    }

    public Flowable<Boolean> updatePerm() {
        return g1.a(getHost()).updatePerm();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r100) {
        super.onAttachToHost(r100);
        if (this.isWikiRootCustomHomePageEnable == false) goto L6;
        r100.registerHostAbility(this);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r100) {
        super.onDetachFromHost(r100);
        if (this.isWikiRootCustomHomePageEnable == false) goto L6;
        r100.unregisterHostAbility(this);
        return;
    }
}
