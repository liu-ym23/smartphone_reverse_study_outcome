package com.bytedance.ee.bear.mindnote.toolbar;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y15.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/mindnote/toolbar/MindNoteTitleMenuConfigPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "Companion", "docs-mindnote_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MindNoteTitleMenuConfigPlugin extends DocumentPluginV3 {
    private static final a Companion = null;
    public static final String MENU_ID_MINDMAP = "MINDMAP";
    public static final String MENU_ID_OUTLINE = "OUTLINE";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public MindNoteTitleMenuConfigPlugin() {
    }

    public void onAttachToHost(ChameleonPluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        d.e(MENU_ID_MINDMAP, 2131255125, 2131101926);
        d.e(MENU_ID_OUTLINE, 2131255271, 2131101926);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }
}
