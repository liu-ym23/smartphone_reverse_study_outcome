package jg5;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class k {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f499019a = null;

        static {
            f499019a = new k();
        }
    }

    public final void a() {
        String r100 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
        JSONObject r101 = new JSONObject();
        String r102 = com.bytedance.ee.bear.middleground.permission.c.f233152f;
        int r103 = com.bytedance.ee.bear.middleground.permission.c.f233153g;
        if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L5;
        String r104 = ThumbGlideUrl.SOURCE_VC;
    L6:
        com.bytedance.ee.bear.middleground.permission.c.a(r101, r102, r103, r104, com.bytedance.ee.bear.middleground.permission.c.f233154h, com.bytedance.ee.bear.middleground.permission.c.f233150d, com.bytedance.ee.bear.middleground.permission.c.f233151e, com.bytedance.ee.bear.middleground.permission.c.f233147a, com.bytedance.ee.bear.middleground.permission.c.f233148b, com.bytedance.ee.bear.middleground.permission.c.f233155i);
        r101.put("click", "close");
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_share_at_people_click", r101);
        return;
    L5:
        r104 = "none";
        goto L6
    }

    public final void c() {
        String r100 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
        JSONObject r101 = new JSONObject();
        String r102 = com.bytedance.ee.bear.middleground.permission.c.f233152f;
        int r103 = com.bytedance.ee.bear.middleground.permission.c.f233153g;
        if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L5;
        String r104 = ThumbGlideUrl.SOURCE_VC;
    L6:
        com.bytedance.ee.bear.middleground.permission.c.a(r101, r102, r103, r104, com.bytedance.ee.bear.middleground.permission.c.f233154h, com.bytedance.ee.bear.middleground.permission.c.f233150d, com.bytedance.ee.bear.middleground.permission.c.f233151e, com.bytedance.ee.bear.middleground.permission.c.f233147a, com.bytedance.ee.bear.middleground.permission.c.f233148b, com.bytedance.ee.bear.middleground.permission.c.f233155i);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_share_at_people_view", r101);
        return;
    L5:
        r104 = "none";
        goto L6
    }

    public k() {
    }

    public final void b(boolean r110) {
        String r100 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
        JSONObject r101 = new JSONObject();
        String r102 = com.bytedance.ee.bear.middleground.permission.c.f233152f;
        int r103 = com.bytedance.ee.bear.middleground.permission.c.f233153g;
        if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L5;
        String r104 = ThumbGlideUrl.SOURCE_VC;
    L6:
        com.bytedance.ee.bear.middleground.permission.c.a(r101, r102, r103, r104, com.bytedance.ee.bear.middleground.permission.c.f233154h, com.bytedance.ee.bear.middleground.permission.c.f233150d, com.bytedance.ee.bear.middleground.permission.c.f233151e, com.bytedance.ee.bear.middleground.permission.c.f233147a, com.bytedance.ee.bear.middleground.permission.c.f233148b, com.bytedance.ee.bear.middleground.permission.c.f233155i);
        r101.put("click", "confirm");
        r101.put("is_send_notice", r110);
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_share_at_people_click", r101);
        return;
    L5:
        r104 = "none";
        goto L6
    }

    public final void d(boolean r110, boolean r111) {
        String r100 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
        JSONObject r101 = new JSONObject();
        String r102 = com.bytedance.ee.bear.middleground.permission.c.f233152f;
        int r103 = com.bytedance.ee.bear.middleground.permission.c.f233153g;
        if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L5;
        String r104 = ThumbGlideUrl.SOURCE_VC;
    L6:
        com.bytedance.ee.bear.middleground.permission.c.a(r101, r102, r103, r104, com.bytedance.ee.bear.middleground.permission.c.f233154h, com.bytedance.ee.bear.middleground.permission.c.f233150d, com.bytedance.ee.bear.middleground.permission.c.f233151e, com.bytedance.ee.bear.middleground.permission.c.f233147a, com.bytedance.ee.bear.middleground.permission.c.f233148b, com.bytedance.ee.bear.middleground.permission.c.f233155i);
        String r105 = "true";
        if (r110 == false) goto L9;
        Object r112 = "true";
    L10:
        r101.put("is_auth_by_leader", r112);
        r101.put("click", "block_action");
        r101.put("action_type", "copy");
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        if (r111 == true) goto L14;
        r105 = "false";
    L14:
        r101.put("is_success", r105);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_docs_global_copy_click", r101);
        return;
    L9:
        r112 = "false";
        goto L10
    L5:
        r104 = "none";
        goto L6
    }

    public final void e(String r100, int r101, String r102, boolean r103, String r104, String r105, boolean r106, String r107, String r110) {
        String r108 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
        Intrinsics.checkNotNullParameter(r104, "userPerm");
        String r109 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        com.bytedance.ee.bear.middleground.permission.c.f233152f = r100;
        com.bytedance.ee.bear.middleground.permission.c.f233153g = r101;
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        com.bytedance.ee.bear.middleground.permission.c.f233154h = r102;
        com.bytedance.ee.bear.middleground.permission.c.f233155i = r103;
        com.bytedance.ee.bear.middleground.permission.c.f233147a = r104;
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        com.bytedance.ee.bear.middleground.permission.c.f233148b = r105;
        com.bytedance.ee.bear.middleground.permission.c.f233149c = r106;
        if (r107 != null) goto L14;
        String r111 = "";
    L15:
        com.bytedance.ee.bear.middleground.permission.c.f233150d = r111;
        if (r110 == null) goto L19;
        r109 = r110;
    L19:
        com.bytedance.ee.bear.middleground.permission.c.f233151e = r109;
        tt5.a.h("PermissionAnalyticV2", "setCommonParams()...userPerm:" + r104 + ", isFromVc:" + r106 + ", module:" + r107 + ", subModule: " + r110);
        return;
    L14:
        r111 = r107;
        goto L15
    }
}
