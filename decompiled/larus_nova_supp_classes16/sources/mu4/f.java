package mu4;

import com.bytedance.ee.bear.share.EShareType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EShareType.values().length];
            r0[EShareType.DASHBOARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[EShareType.DASHBOARD_REDIRECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[EShareType.Record.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[EShareType.FORM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public static void i() {
        f("ccm_bitable_form_permission_view", new JSONObject());
    }

    public static String a(EShareType r1) {
        int r2 = a.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "dashboard";
    L5:
        if (r2 != 2) goto L7;
        return "dashboard_previous";
    L7:
        if (r2 == 3) goto L9;
        return "";
    L9:
        return "record";
    }

    public static void d(EShareType r2) {
        Intrinsics.checkNotNullParameter(r2, "shareType");
        int r0 = a.a[r2.ordinal()];
        if (r0 != 1) goto L5;
    L12:
        String r1 = "ccm_bitable_external_share_limit_set_view";
    L13:
        c("limit_set", r1, r2);
        return;
    L5:
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L12;
        if (r0 == 4) goto L11;
        r1 = "";
        goto L13
    L11:
        r1 = "ccm_bitable_form_limit_set_view";
        goto L13
    }

    public static void b(String r2, EShareType r3) {
        Intrinsics.checkNotNullParameter(r2, "click");
        Intrinsics.checkNotNullParameter(r3, "shareType");
        JSONObject r1 = new JSONObject();
        r1.put("click", r2);
        r1.put("target", "none");
        if (r3 != EShareType.BASE_ADD) goto L5;
        r1.put("type", "individual_page");
    L6:
        f("ccm_bitable_add_record_qrcode_click", r1);
        return;
    L5:
        r1.put("type", "inside_base");
        goto L6
    }

    public static void e(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "click");
        JSONObject r1 = new JSONObject();
        r1.put("click", r2);
        r1.put("target", "none");
        if (r3 == false) goto L5;
        r1.put("share_type", "record");
        r1.put("record_type", "add_record");
        f("ccm_bitable_share_click", r1);
        return;
    L5:
        f("ccm_bitable_record_create_click", r1);
    }

    public static void f(String r6, JSONObject r7) {
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        HashMap<String, Object> r1 = r0.m("docCommonParams");
        HashMap<String, Object> r2 = r0.m("nativePermissionCommonParams");
        HashMap<String, Object> r3 = r0.m("bitableFormPermCommonParams");
        Iterator<T> r4 = r1.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry r5 = (Map.Entry) r4.next();
        r7.put((String) r5.getKey(), r5.getValue());
        goto L4
    L6:
        Iterator<T> r8 = r2.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r9 = (Map.Entry) r8.next();
        r7.put((String) r9.getKey(), r9.getValue());
        goto L8
    L10:
        Iterator<T> r10 = r3.entrySet().iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        Map.Entry r11 = (Map.Entry) r10.next();
        r7.put((String) r11.getKey(), r11.getValue());
        goto L12
    L14:
        r0.u(r6, r7);
        tt5.a.b("ShareBitableShareAnalytic", "eventName = " + r6 + ", params = " + r7);
    }

    public static void g(EShareType r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "shareType");
        JSONObject r0 = new JSONObject();
        r0.put("share_type", a(r3));
        r0.put("from_onboarding", "false");
        r0.put("is_opened", String.valueOf(r4));
        if (r3 != EShareType.Record) goto L7;
        r0.put("type", r3.getExtra("type"));
        Object r5 = r3.getExtra("comment_id");
        if (r5 == null) goto L7;
        r0.put("comment_id", r5);
    L7:
        f("ccm_bitable_external_permission_view", r0);
    }

    public static void h(String r2, EShareType r3) {
        Intrinsics.checkNotNullParameter(r2, "click");
        Intrinsics.checkNotNullParameter(r3, "shareType");
        EShareType r0 = EShareType.BASE_ADD;
        if (r3 != r0) goto L5;
    L8:
        if (r3 != r0) goto L10;
        boolean r4 = true;
    L11:
        e("qrcode", r4);
        return;
    L10:
        r4 = false;
        goto L11
    L5:
        if (r3 == EShareType.BASE_ADD_SUBMIT) goto L8;
        c(r2, "none", r3);
    }

    public static void c(String r2, String r3, EShareType r4) {
        JSONObject r0 = new JSONObject();
        r0.put("click", r2);
        r0.put("target", r3);
        if (r4 != EShareType.Record) goto L8;
        r0.put("type", r4.getExtra("type"));
        Object r5 = r4.getExtra("comment_id");
        if (r5 == null) goto L8;
        r0.put("comment_id", r5);
    L8:
        if (r4 != EShareType.FORM) goto L10;
        f("ccm_bitable_form_permission_click", r0);
        return;
    L10:
        r0.put("share_type", a(r4));
        f("ccm_bitable_external_permission_click", r0);
    }
}
