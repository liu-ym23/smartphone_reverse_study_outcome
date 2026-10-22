package ij5;

import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.share.SharePlugin;
import com.bytedance.ee.bear.mindnote.toolbar.MindNoteTitleMenuConfigPlugin;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import ml5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends com.bytedance.ee.bear.document.share.a {
    public final b h;

    public final String a() {
        return (String) this.h.a("mindnote_view_type", MindNoteTitleMenuConfigPlugin.MENU_ID_OUTLINE);
    }

    public a(DocumentPluginHost r1, SharePlugin.c r2) {
        super(r1, r2);
        this.h = new b(DocumentType.MINDNOTE_NAME);
    }
}
