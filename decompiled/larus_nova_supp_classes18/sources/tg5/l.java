package tg5;

import android.content.DialogInterface;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements DialogInterface.OnClickListener {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r12, int r13) {
        String r14 = com.bytedance.ee.bear.middleground.permission.c.a;
        JSONObject r15 = new JSONObject();
        String r1 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r2 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L5;
        String r3 = ThumbGlideUrl.SOURCE_VC;
    L6:
        com.bytedance.ee.bear.middleground.permission.c.a(r15, r1, r2, r3, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        r15.put("click", DocFeed$Value$Result.CANCEL);
        r15.put("target", "none");
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_organization_authorize_send_notice_click", r15);
        return;
    L5:
        r3 = "none";
        goto L6
    }
}
