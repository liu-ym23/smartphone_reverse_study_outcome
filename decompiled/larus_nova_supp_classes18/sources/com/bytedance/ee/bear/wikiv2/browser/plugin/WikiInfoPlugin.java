package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiInfoPlugin extends BasePluginV2 implements com.bytedance.ee.bear.contract.route.parcelable.d {
    private static final String TAG = "WikiInfoPlugin";
    private final boolean isWikiRootCustomHomePageEnable;

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
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

    public boolean isWikiHomePage() {
        TreeNode r0 = getWikiMeta();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isWikiHomePage == false) goto L7;
        return true;
    }

    public Flowable<Boolean> updatePerm() {
        return g1.a(getHost()).updatePerm();
    }

    public void onAttachToHost(PluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        if (this.isWikiRootCustomHomePageEnable == false) goto L6;
        r2.registerHostAbility(this);
        return;
    }

    public void onDetachFromHost(PluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
        if (this.isWikiRootCustomHomePageEnable == false) goto L6;
        r2.unregisterHostAbility(this);
        return;
    }
}
