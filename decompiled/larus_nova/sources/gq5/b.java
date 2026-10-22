package gq5;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Long f482179a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f482180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f482181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f482182c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f482183d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f482184e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f482185f;

        public a() {
            this(null, null, null, null, null, 63);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f482180a, r101.f482180a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f482181b, r101.f482181b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f482182c, r101.f482182c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f482183d, r101.f482183d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f482184e, r101.f482184e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f482185f, r101.f482185f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f482180a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f482181b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.f482182c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f482183d;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f482184e;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.f482185f;
            if (r116 == null) goto L27;
            r101 = r116.hashCode();
        L27:
            return r115 + r101;
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReportRedirectEventBean(fileId=" + this.f482180a + ", objToken=" + this.f482181b + ", objType=" + this.f482182c + ", redirectTo=" + this.f482183d + ", redirectReason=" + this.f482184e + ", logId=" + this.f482185f + ')';
        }

        public /* synthetic */ a(String r110, String r111, Integer r112, String r113, String r114, int r115) {
            if ((r115 & 1) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r115 & 2) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r115 & 4) == 0) goto L13;
            Integer r102 = null;
        L15:
            if ((r115 & 8) == 0) goto L17;
            String r103 = null;
        L19:
            if ((r115 & 16) == 0) goto L21;
            String r104 = null;
        L22:
            this(r100, r101, r102, r103, r104, null);
            return;
        L21:
            r104 = r114;
            goto L22
        L17:
            r103 = r113;
            goto L19
        L13:
            r102 = r112;
            goto L15
        L9:
            r101 = r111;
            goto L11
        L5:
            r100 = r110;
            goto L7
        }

        public a(String r100, String r101, Integer r102, String r103, String r104, String r105) {
            this.f482180a = r100;
            this.f482181b = r101;
            this.f482182c = r102;
            this.f482183d = r103;
            this.f482184e = r104;
            this.f482185f = r105;
        }
    }

    static {
    }

    @JvmStatic
    public static final void c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "bean");
        JSONObject r101 = new JSONObject();
        e.b(r101, "wiki_token", e.a(r100.f482180a));
        e.b(r101, "obj_token", e.a(r100.f482181b));
        e.b(r101, "obj_type", r100.f482182c);
        e.b(r101, "redirect_to", r100.f482183d);
        e.b(r101, "redirect_reason", r100.f482184e);
        e.b(r101, "log_id", r100.f482185f);
        e.c("ccm_workspace_redirect_event_dev", r101);
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "collectedTag");
        Intrinsics.checkNotNullParameter(r101, "stage");
        HashMap<String, Object> r102 = ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).m(r100);
        if (r102.get(r101) == null) goto L6;
        return;
    L6:
        switch(r101.hashCode()) {
            case -854791472: goto L20;
            case 3237136: goto L16;
            case 89790802: goto L12;
            case 734912626: goto L9;
            default: goto L26;
        };
    L26:
        Object r103 = null;
    L28:
        if ((r103 instanceof Long) == false) goto L30;
        Long r104 = (Long) r103;
    L31:
        if (r104 == null) goto L38;
        long r105 = r104.longValue();
        long r106 = System.currentTimeMillis();
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).j(r100, r101, Long.valueOf(r106));
        JSONObject r107 = new JSONObject();
        r107.put("stage", r101);
        r107.put("list_type", "wiki_home");
        r107.put(HiAnalyticsConstant.BI_KEY_COST_TIME, r106 - r105);
        r107.put("result_code", 0);
        r107.put("view_mode", 0);
        r107.put("data_size", 0);
        r107.put("user_operation_source", 0);
        e.c("docs_dev_performance_space_open_stages", r107);
        return;
    L38:
        return;
    L30:
        r104 = null;
        goto L31
    L9:
        if (r101.equals("load_db_data") == false) goto L34;
    L14:
        r103 = r102.get("init");
        goto L28
    L34:
        r103 = null;
        goto L28
    L12:
        if (r101.equals("load_from_network") == true) goto L14;
        r103 = null;
        goto L28
    L16:
        if (r101.equals("init") == false) goto L36;
        r103 = r102.get("start");
        goto L28
    L36:
        r103 = null;
        goto L28
    L20:
        if (r101.equals("fill_ui") == false) goto L37;
        Object r108 = r102.get("load_db_data");
        if (r108 != null) goto L25;
        r103 = r102.get("load_from_network");
        goto L28
    L25:
        r103 = r108;
        goto L28
    L37:
        r103 = null;
        goto L28
    }

    @JvmStatic
    public static final void d(String r100, String r101, String r102, Integer r103) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (f482179a == null) goto L12;
        long r104 = System.currentTimeMillis();
        Long r105 = f482179a;
        Intrinsics.checkNotNull(r105);
        long r106 = r104 - r105.longValue();
        JSONObject r107 = new JSONObject();
        e.b(r107, "file_id", e.a(r100));
        e.b(r107, "source", r101);
        e.b(r107, "result_key", r102);
        if (r103 == null) goto L8;
        String r108 = r103.toString();
    L9:
        e.b(r107, "result_code", r108);
        e.b(r107, HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(r106));
        e.b(r107, "open_type", "network");
        e.c("docs_wiki_performance_open_tree_finish", r107);
        return;
    L8:
        r108 = null;
        goto L9
    }

    public static void a(String r100, int r101, Integer r102, Boolean r103, int r104) {
        Long r105 = null;
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "collectedTag");
        Object r106 = ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).f(r100, "start");
        if ((r106 instanceof Long) == false) goto L11;
        r105 = (Long) r106;
    L11:
        if (r105 == null) goto L22;
        long r107 = System.currentTimeMillis() - r105.longValue();
        JSONObject r108 = new JSONObject();
        r108.put("result_code", String.valueOf(r101));
        if (r102 == null) goto L16;
        String r109 = r102.toString();
        if (r109 == null) goto L16;
    L17:
        r108.put("fail_code", r109);
        r108.put(HiAnalyticsConstant.BI_KEY_COST_TIME, r107);
        r108.put("list_type", "wiki_home");
        r108.put("filter_type1", "");
        r108.put(com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE, "");
        boolean r110 = false;
        r108.put("view_mode", 0);
        r108.put("user_operation_source", 0);
        if (r103 == null) goto L20;
        r110 = r103.booleanValue();
    L20:
        r108.put("has_cache", r110);
        e.c("docs_dev_performance_space_open_finish", r108);
        return;
    L16:
        r109 = "";
        goto L17
    }
}
