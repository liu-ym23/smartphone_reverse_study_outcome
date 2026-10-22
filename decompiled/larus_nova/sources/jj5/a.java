package jj5;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements com.bytedance.ee.bear.mindnote.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f499328a;

    public a(com.bytedance.ee.bear.contract.d r100) {
        this.f499328a = r100;
    }

    public final void a(String r100, BearUrl r101, String r102) {
        if (this.f499328a != null) goto L5;
        return;
    L5:
        tt5.a.b("MindNoteToolbarAnalytic", "report:event = ".concat(r100));
        HashMap r103 = new HashMap();
        r103.put("mindnote_mode", "outline");
        r103.put("is_block", "FALSE");
        r103.put(BitableResourceData.KEY_BLOCK_ID, "null");
        r103.put("file_type", DocumentType.MINDNOTE_NAME);
        r103.put(EventConstant.Key.MODULE, DocumentType.MINDNOTE_NAME);
        r103.put("sub_module", "null");
        if (r102 == null) goto L8;
        r103.put("page_token", du5.b.g(r102));
    L10:
        if (ThumbGlideUrl.SOURCE_VC.equals(r101.f222567h) == false) goto L12;
        r103.put("app_from", r101.f222567h);
    L13:
        r103.put("file_id", du5.b.g(r101.f222561b));
        this.f499328a.n(r100, r103);
        return;
    L12:
        r103.put("app_from", "null");
        goto L13
    L8:
        r103.put("page_token", du5.b.g(r101.f222561b));
        goto L10
    }
}
