package jg5;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k {

    public static class a {
        public static final k a = null;

        static {
            a = new k();
        }
    }

    public final void a() {
        String r0 = com.bytedance.ee.bear.middleground.permission.c.a;
        JSONObject r1 = new JSONObject();
        String r2 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r3 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L5;
        String r4 = ThumbGlideUrl.SOURCE_VC;
    L6:
        com.bytedance.ee.bear.middleground.permission.c.a(r1, r2, r3, r4, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        r1.put("click", "close");
        r1.put("target", "none");
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_share_at_people_click", r1);
        return;
    L5:
        r4 = "none";
        goto L6
    }

    public final void c() {
        String r0 = com.bytedance.ee.bear.middleground.permission.c.a;
        JSONObject r1 = new JSONObject();
        String r2 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r3 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L5;
        String r4 = ThumbGlideUrl.SOURCE_VC;
    L6:
        com.bytedance.ee.bear.middleground.permission.c.a(r1, r2, r3, r4, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_share_at_people_view", r1);
        return;
    L5:
        r4 = "none";
        goto L6
    }

    public k() {
    }

    public final void b(boolean r13) {
        String r0 = com.bytedance.ee.bear.middleground.permission.c.a;
        JSONObject r1 = new JSONObject();
        String r2 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r3 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L5;
        String r4 = ThumbGlideUrl.SOURCE_VC;
    L6:
        com.bytedance.ee.bear.middleground.permission.c.a(r1, r2, r3, r4, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        r1.put("click", "confirm");
        r1.put("is_send_notice", r13);
        r1.put("target", "none");
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_share_at_people_click", r1);
        return;
    L5:
        r4 = "none";
        goto L6
    }

    public final void d(boolean r13, boolean r14) {
        String r0 = com.bytedance.ee.bear.middleground.permission.c.a;
        JSONObject r1 = new JSONObject();
        String r2 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r3 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L5;
        String r4 = ThumbGlideUrl.SOURCE_VC;
    L6:
        com.bytedance.ee.bear.middleground.permission.c.a(r1, r2, r3, r4, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        String r5 = "true";
        if (r13 == false) goto L9;
        Object r15 = "true";
    L10:
        r1.put("is_auth_by_leader", r15);
        r1.put("click", "block_action");
        r1.put("action_type", "copy");
        r1.put("target", "none");
        if (r14 == true) goto L14;
        r5 = "false";
    L14:
        r1.put("is_success", r5);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_docs_global_copy_click", r1);
        return;
    L9:
        r15 = "false";
        goto L10
    L5:
        r4 = "none";
        goto L6
    }

    public final void e(String r2, int r3, String r4, boolean r5, String r6, String r7, boolean r8, String r9, String r10) {
        String r0 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r6, "userPerm");
        String r1 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        com.bytedance.ee.bear.middleground.permission.c.f = r2;
        com.bytedance.ee.bear.middleground.permission.c.g = r3;
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        com.bytedance.ee.bear.middleground.permission.c.h = r4;
        com.bytedance.ee.bear.middleground.permission.c.i = r5;
        com.bytedance.ee.bear.middleground.permission.c.a = r6;
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        com.bytedance.ee.bear.middleground.permission.c.b = r7;
        com.bytedance.ee.bear.middleground.permission.c.c = r8;
        if (r9 != null) goto L14;
        String r11 = "";
    L15:
        com.bytedance.ee.bear.middleground.permission.c.d = r11;
        if (r10 == null) goto L19;
        r1 = r10;
    L19:
        com.bytedance.ee.bear.middleground.permission.c.e = r1;
        tt5.a.h("PermissionAnalyticV2", "setCommonParams()...userPerm:" + r6 + ", isFromVc:" + r8 + ", module:" + r9 + ", subModule: " + r10);
        return;
    L14:
        r11 = r9;
        goto L15
    }
}
