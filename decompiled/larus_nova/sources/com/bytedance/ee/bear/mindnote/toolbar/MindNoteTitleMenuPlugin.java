package com.bytedance.ee.bear.mindnote.toolbar;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.menu.TitleMenuPlugin;
import com.larus.nova.R;
import y15.d;

/* JADX INFO: loaded from: classes18.dex */
public class MindNoteTitleMenuPlugin extends TitleMenuPlugin {
    private static final String MENU_ID_MINDMAP = "MINDMAP";
    private static final String MENU_ID_OUTLINE = "OUTLINE";

    @Override // com.bytedance.ee.bear.document.menu.TitleMenuPlugin, com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public MindNoteTitleMenuPlugin() {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r100) {
        super.onAttachToHost(r100);
        d.e("MINDMAP", R.drawable.ud_icon_mindmap_outlined, R.color.facade_selector_icon_n1);
        d.e("OUTLINE", R.drawable.ud_icon_outline_outlined, R.color.facade_selector_icon_n1);
    }
}
