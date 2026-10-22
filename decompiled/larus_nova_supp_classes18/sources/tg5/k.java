package tg5;

import android.content.DialogInterface;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements DialogInterface.OnClickListener {
    public final /* synthetic */ b a;

    public k(b r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r13, int r14) {
        p.a r15 = this.a.d;
        if (r15 == null) goto L5;
        r15.W2();
    L5:
        ArrayList<UserInfo> r16 = this.a.e();
        if (this.a.getNotes().length() <= 0) goto L8;
        boolean r17 = true;
    L9:
        String r0 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r16, "userInfoList");
        JSONObject r1 = new JSONObject();
        String r2 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r3 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L12;
        String r4 = ThumbGlideUrl.SOURCE_VC;
    L13:
        com.bytedance.ee.bear.middleground.permission.c.a(r1, r2, r3, r4, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        r1.put("click", "send");
        r1.put("is_add_notes", String.valueOf(r17));
        JSONArray r18 = new JSONArray();
        Iterator<UserInfo> r19 = r16.iterator();
    L15:
        if (r19.hasNext() == false) goto L17;
        UserInfo r5 = r19.next();
        JSONObject r6 = new JSONObject();
        r6.put("collaborate_type", r5.getOwnerType());
        r6.put("object_uid", du5.b.g(r5.getId()));
        r6.put("list_type", com.bytedance.ee.bear.middleground.permission.c.d(com.bytedance.ee.bear.middleground.permission.c.g, r5.getPermission()));
        r18.put(r6);
        goto L15
    L17:
        r1.put("user_list", r18.toString());
        r1.put("target", "none");
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_organization_authorize_send_notice_click", r1);
        return;
    L12:
        r4 = "none";
        goto L13
    L8:
        r17 = false;
        goto L9
    }
}
