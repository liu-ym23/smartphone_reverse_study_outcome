package ij5;

import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.share.SharePlugin;
import com.bytedance.ee.bear.mindnote.toolbar.MindNoteTitleMenuConfigPlugin;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import ml5.b;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends com.bytedance.ee.bear.document.share.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f490069h;

    @Override // com.bytedance.ee.bear.document.share.a
    public final String a() {
        return (String) this.f490069h.a("mindnote_view_type", MindNoteTitleMenuConfigPlugin.MENU_ID_OUTLINE);
    }

    public a(DocumentPluginHost r100, SharePlugin.c r101) {
        super(r100, r101);
        this.f490069h = new b(DocumentType.MINDNOTE_NAME);
    }
}
