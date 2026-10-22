package lg5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.BatchAuthorizeActivity;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.EmbededDocumentInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements Observer<EmbededDocumentInfo.EmbededData> {
    public final /* synthetic */ BatchAuthorizeActivity a;

    public e(BatchAuthorizeActivity r1) {
        this.a = r1;
    }

    public final void onChanged(Object r12) {
        EmbededDocumentInfo.EmbededData r13 = (EmbededDocumentInfo.EmbededData) r12;
        BatchAuthorizeActivity r14 = this.a;
        if (r14.o == false) goto L17;
        boolean r0 = false;
        r14.o = false;
        if (r14.i.getInfo().getChatType() != 0) goto L7;
        r0 = true;
    L7:
        boolean r15 = Boolean.valueOf(r0).booleanValue();
        String r1 = com.bytedance.ee.bear.middleground.permission.c.a;
        JSONObject r2 = new JSONObject();
        if (r15 == false) goto L10;
        String r16 = "false";
    L11:
        r2.put("is_group_chat", r16);
        String r3 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r4 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L14;
        String r17 = ThumbGlideUrl.SOURCE_VC;
    L15:
        com.bytedance.ee.bear.middleground.permission.c.a(r2, r3, r4, r17, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_cited_doc_authorize_view", r2);
        return;
    L14:
        r17 = "none";
        goto L15
    L10:
        r16 = "true";
        goto L11
    }
}
