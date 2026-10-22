package mu4;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.share.EShareType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f515752a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f515753a = null;

        static {
            int[] r100 = new int[EShareType.values().length];
            r100[EShareType.DASHBOARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[EShareType.DASHBOARD_REDIRECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[EShareType.Record.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[EShareType.FORM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f515753a = r100;
        }
    }

    static {
    }

    public static void i() {
        f("ccm_bitable_form_permission_view", new JSONObject());
    }

    public static String a(EShareType r100) {
        int r101 = a.f515753a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "dashboard";
    L5:
        if (r101 != 2) goto L7;
        return "dashboard_previous";
    L7:
        if (r101 == 3) goto L9;
        return "";
    L9:
        return "record";
    }

    public static void d(EShareType r100) {
        Intrinsics.checkNotNullParameter(r100, "shareType");
        int r101 = a.f515753a[r100.ordinal()];
        if (r101 != 1) goto L5;
    L12:
        String r102 = "ccm_bitable_external_share_limit_set_view";
    L13:
        c("limit_set", r102, r100);
        return;
    L5:
        if (r101 == 2) goto L12;
        if (r101 == 3) goto L12;
        if (r101 == 4) goto L11;
        r102 = "";
        goto L13
    L11:
        r102 = "ccm_bitable_form_limit_set_view";
        goto L13
    }

    public static void b(String r100, EShareType r101) {
        Intrinsics.checkNotNullParameter(r100, "click");
        Intrinsics.checkNotNullParameter(r101, "shareType");
        JSONObject r102 = new JSONObject();
        r102.put("click", r100);
        r102.put(PickerReporterConstants.KEY.TARGET, "none");
        if (r101 != EShareType.BASE_ADD) goto L5;
        r102.put("type", "individual_page");
    L6:
        f("ccm_bitable_add_record_qrcode_click", r102);
        return;
    L5:
        r102.put("type", "inside_base");
        goto L6
    }

    public static void e(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "click");
        JSONObject r102 = new JSONObject();
        r102.put("click", r100);
        r102.put(PickerReporterConstants.KEY.TARGET, "none");
        if (r101 == false) goto L5;
        r102.put("share_type", "record");
        r102.put("record_type", BitableAnalytic.LinkSceneClickType.ADD_RECORD);
        f("ccm_bitable_share_click", r102);
        return;
    L5:
        f("ccm_bitable_record_create_click", r102);
    }

    public static void f(String r100, JSONObject r101) {
        com.bytedance.ee.bear.contract.d r102 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        HashMap<String, Object> r103 = r102.m("docCommonParams");
        HashMap<String, Object> r104 = r102.m("nativePermissionCommonParams");
        HashMap<String, Object> r105 = r102.m("bitableFormPermCommonParams");
        Iterator<T> r106 = r103.entrySet().iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        Map.Entry r107 = (Map.Entry) r106.next();
        r101.put((String) r107.getKey(), r107.getValue());
        goto L4
    L6:
        Iterator<T> r108 = r104.entrySet().iterator();
    L8:
        if (r108.hasNext() == false) goto L10;
        Map.Entry r109 = (Map.Entry) r108.next();
        r101.put((String) r109.getKey(), r109.getValue());
        goto L8
    L10:
        Iterator<T> r110 = r105.entrySet().iterator();
    L12:
        if (r110.hasNext() == false) goto L14;
        Map.Entry r111 = (Map.Entry) r110.next();
        r101.put((String) r111.getKey(), r111.getValue());
        goto L12
    L14:
        r102.u(r100, r101);
        tt5.a.b("ShareBitableShareAnalytic", "eventName = " + r100 + ", params = " + r101);
    }

    public static void g(EShareType r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "shareType");
        JSONObject r102 = new JSONObject();
        r102.put("share_type", a(r100));
        r102.put("from_onboarding", "false");
        r102.put("is_opened", String.valueOf(r101));
        if (r100 != EShareType.Record) goto L7;
        r102.put("type", r100.getExtra("type"));
        Object r103 = r100.getExtra("comment_id");
        if (r103 == null) goto L7;
        r102.put("comment_id", r103);
    L7:
        f("ccm_bitable_external_permission_view", r102);
    }

    public static void h(String r100, EShareType r101) {
        Intrinsics.checkNotNullParameter(r100, "click");
        Intrinsics.checkNotNullParameter(r101, "shareType");
        EShareType r102 = EShareType.BASE_ADD;
        if (r101 != r102) goto L5;
    L8:
        if (r101 != r102) goto L10;
        boolean r103 = true;
    L11:
        e("qrcode", r103);
        return;
    L10:
        r103 = false;
        goto L11
    L5:
        if (r101 == EShareType.BASE_ADD_SUBMIT) goto L8;
        c(r100, "none", r101);
    }

    public static void c(String r100, String r101, EShareType r102) {
        JSONObject r103 = new JSONObject();
        r103.put("click", r100);
        r103.put(PickerReporterConstants.KEY.TARGET, r101);
        if (r102 != EShareType.Record) goto L8;
        r103.put("type", r102.getExtra("type"));
        Object r104 = r102.getExtra("comment_id");
        if (r104 == null) goto L8;
        r103.put("comment_id", r104);
    L8:
        if (r102 != EShareType.FORM) goto L10;
        f("ccm_bitable_form_permission_click", r103);
        return;
    L10:
        r103.put("share_type", a(r102));
        f("ccm_bitable_external_permission_click", r103);
    }
}
