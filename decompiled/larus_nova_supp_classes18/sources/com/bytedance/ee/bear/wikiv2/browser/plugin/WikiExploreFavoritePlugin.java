package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeObserver;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiExploreFavoritePlugin extends BasePluginV2 implements Observer<com.bytedance.ee.bear.wikiv2.wikitreev2.b> {
    private static final String TAG = "WikiExploreFavoritePlugin";

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public WikiExploreFavoritePlugin() {
    }

    public void exploreFavorite(boolean r4) {
        tt5.a.h(TAG, "exploreFavorite, switchOn: " + r4);
        TreeNode r0 = g1.a(getHost()).getWikiMeta();
        if (r0 == null) goto L6;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.l.a(getContext(), r0, !r4, false);
        return;
    }

    public void onAttachToHost(PluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        tt5.a.h(TAG, "onAttachToHost. ");
        WikiTreeObserver.b().a(this);
    }

    public void onChanged(com.bytedance.ee.bear.wikiv2.wikitreev2.b r4) {
        TreeNode r0 = g1.a(getHost()).getWikiMeta();
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r4.b, r0.getOriginToken()) == false) goto L9;
        r0.is_explorer_star = r4.c;
        return;
    }

    public void onDetachFromHost(PluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r1);
        WikiTreeObserver.b().d(this);
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((com.bytedance.ee.bear.wikiv2.wikitreev2.b) r1);
    }
}
