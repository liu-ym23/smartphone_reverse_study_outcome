package lg5;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.BatchAuthorizeActivity;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ BatchAuthorizeActivity a;

    public k(BatchAuthorizeActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        BatchAuthorizeActivity r13 = this.a;
        int r0 = BatchAuthorizeActivity.p;
        r13.i.updateCardState();
        this.a.finish();
        String r14 = com.bytedance.ee.bear.middleground.permission.c.a;
        JSONObject r15 = new JSONObject();
        String r1 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r2 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L5;
        String r3 = ThumbGlideUrl.SOURCE_VC;
    L6:
        com.bytedance.ee.bear.middleground.permission.c.a(r15, r1, r2, r3, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        r15.put("click", "back");
        r15.put("target", "none");
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_cited_doc_authorize_click", r15);
        return;
    L5:
        r3 = "none";
        goto L6
    }
}
