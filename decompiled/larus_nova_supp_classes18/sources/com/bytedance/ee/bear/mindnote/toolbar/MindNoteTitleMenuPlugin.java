package com.bytedance.ee.bear.mindnote.toolbar;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.menu.TitleMenuPlugin;
import y15.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MindNoteTitleMenuPlugin extends TitleMenuPlugin {
    private static final String MENU_ID_MINDMAP = "MINDMAP";
    private static final String MENU_ID_OUTLINE = "OUTLINE";

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public MindNoteTitleMenuPlugin() {
    }

    public void onAttachToHost(PluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        d.e("MINDMAP", 2131255125, 2131101926);
        d.e("OUTLINE", 2131255271, 2131101926);
    }
}
