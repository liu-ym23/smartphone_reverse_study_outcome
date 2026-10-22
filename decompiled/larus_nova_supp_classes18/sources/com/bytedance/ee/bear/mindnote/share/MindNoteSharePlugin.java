package com.bytedance.ee.bear.mindnote.share;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.share.SharePlugin;
import ij5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MindNoteSharePlugin extends SharePlugin {
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public MindNoteSharePlugin() {
    }

    /* JADX INFO: renamed from: createHandler, reason: collision with other method in class */
    public a m304createHandler(DocumentPluginHost r3) {
        return new a(r3, getShareCallBack());
    }

    public /* bridge */ /* synthetic */ com.bytedance.ee.bear.document.share.a createHandler(DocumentPluginHost r1) {
        return m304createHandler(r1);
    }
}
