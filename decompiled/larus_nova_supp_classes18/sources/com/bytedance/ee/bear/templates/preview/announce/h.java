package com.bytedance.ee.bear.templates.preview.announce;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements PanelTemplateAdapter.b {
    public final /* synthetic */ TemplateCardPanelFragment a;

    public h(TemplateCardPanelFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.templates.preview.announce.PanelTemplateAdapter.b
    public final void a(int r3, AnnounceTemplate r4) {
        Intrinsics.checkNotNullParameter(r4, ThumbGlideUrl.SOURCE_TEMPLATE);
        tt5.a.h("TemplateCardPanelFragment", "onTemplateClicked()...template = " + r4);
        AnnounceTemplateViewModel r5 = this.a.k;
        if (r5 == null) goto L5;
        r5.loadAnnounceUrl(r3, true);
    L5:
        JSONObject r6 = AnnounceTemplateAnalytic.b;
        r6.put("source", "from_im_chat_announcement");
        r6.put("click_source", "from_set");
        ((com.bytedance.ee.bear.contract.d) AnnounceTemplateAnalytic.a.getValue()).n("docs_click_template_preview", r6);
    }
}
