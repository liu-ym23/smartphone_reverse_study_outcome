package jj5;

import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements com.bytedance.ee.bear.mindnote.a {
    public final com.bytedance.ee.bear.contract.d a;

    public a(com.bytedance.ee.bear.contract.d r1) {
        this.a = r1;
    }

    public final void a(String r5, BearUrl r6, String r7) {
        if (this.a != null) goto L5;
        return;
    L5:
        tt5.a.b("MindNoteToolbarAnalytic", "report:event = ".concat(r5));
        HashMap r0 = new HashMap();
        r0.put("mindnote_mode", "outline");
        r0.put("is_block", "FALSE");
        r0.put("block_id", "null");
        r0.put("file_type", DocumentType.MINDNOTE_NAME);
        r0.put("module", DocumentType.MINDNOTE_NAME);
        r0.put("sub_module", "null");
        if (r7 == null) goto L8;
        r0.put("page_token", du5.b.g(r7));
    L10:
        if (ThumbGlideUrl.SOURCE_VC.equals(r6.h) == false) goto L12;
        r0.put("app_from", r6.h);
    L13:
        r0.put("file_id", du5.b.g(r6.b));
        this.a.n(r5, r0);
        return;
    L12:
        r0.put("app_from", "null");
        goto L13
    L8:
        r0.put("page_token", du5.b.g(r6.b));
        goto L10
    }
}
