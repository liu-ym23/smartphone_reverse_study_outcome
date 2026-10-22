package gq5;

import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$DataSource;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static Long a;

    public static final class a {
        public final String a;
        public final String b;
        public final Integer c;
        public final String d;
        public final String e;
        public final String f;

        public a() {
            this(null, null, null, null, null, 63);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.f;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReportRedirectEventBean(fileId=" + this.a + ", objToken=" + this.b + ", objType=" + this.c + ", redirectTo=" + this.d + ", redirectReason=" + this.e + ", logId=" + this.f + ')';
        }

        public /* synthetic */ a(String r10, String r11, Integer r12, String r13, String r14, int r15) {
            if ((r15 & 1) == 0) goto L5;
            String r3 = null;
        L7:
            if ((r15 & 2) == 0) goto L9;
            String r4 = null;
        L11:
            if ((r15 & 4) == 0) goto L13;
            Integer r5 = null;
        L15:
            if ((r15 & 8) == 0) goto L17;
            String r6 = null;
        L19:
            if ((r15 & 16) == 0) goto L21;
            String r7 = null;
        L22:
            this(r3, r4, r5, r6, r7, null);
            return;
        L21:
            r7 = r14;
            goto L22
        L17:
            r6 = r13;
            goto L19
        L13:
            r5 = r12;
            goto L15
        L9:
            r4 = r11;
            goto L11
        L5:
            r3 = r10;
            goto L7
        }

        public a(String r1, String r2, Integer r3, String r4, String r5, String r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    static {
    }

    @JvmStatic
    public static final void c(a r3) {
        Intrinsics.checkNotNullParameter(r3, "bean");
        JSONObject r0 = new JSONObject();
        e.b(r0, "wiki_token", e.a(r3.a));
        e.b(r0, ResourceData.KEY_OBJ_TOKEN, e.a(r3.b));
        e.b(r0, "obj_type", r3.c);
        e.b(r0, "redirect_to", r3.d);
        e.b(r0, "redirect_reason", r3.e);
        e.b(r0, "log_id", r3.f);
        e.c("ccm_workspace_redirect_event_dev", r0);
    }

    @JvmStatic
    public static final void b(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "collectedTag");
        Intrinsics.checkNotNullParameter(r9, "stage");
        HashMap r1 = ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).m(r8);
        if (r1.get(r9) == null) goto L6;
        return;
    L6:
        switch(r9.hashCode()) {
            case -854791472: goto L20;
            case 3237136: goto L16;
            case 89790802: goto L12;
            case 734912626: goto L9;
            default: goto L26;
        };
    L26:
        Object r2 = null;
    L28:
        if ((r2 instanceof Long) == false) goto L30;
        Long r3 = (Long) r2;
    L31:
        if (r3 == null) goto L38;
        long r4 = r3.longValue();
        long r6 = System.currentTimeMillis();
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).j(r8, r9, Long.valueOf(r6));
        JSONObject r10 = new JSONObject();
        r10.put("stage", r9);
        r10.put("list_type", "wiki_home");
        r10.put("cost_time", r6 - r4);
        r10.put("result_code", 0);
        r10.put("view_mode", 0);
        r10.put("data_size", 0);
        r10.put("user_operation_source", 0);
        e.c("docs_dev_performance_space_open_stages", r10);
        return;
    L38:
        return;
    L30:
        r3 = null;
        goto L31
    L9:
        if (r9.equals("load_db_data") == false) goto L34;
    L14:
        r2 = r1.get("init");
        goto L28
    L34:
        r2 = null;
        goto L28
    L12:
        if (r9.equals("load_from_network") == true) goto L14;
        r2 = null;
        goto L28
    L16:
        if (r9.equals("init") == false) goto L36;
        r2 = r1.get("start");
        goto L28
    L36:
        r2 = null;
        goto L28
    L20:
        if (r9.equals("fill_ui") == false) goto L37;
        Object r5 = r1.get("load_db_data");
        if (r5 != null) goto L25;
        r2 = r1.get("load_from_network");
        goto L28
    L25:
        r2 = r5;
        goto L28
    L37:
        r2 = null;
        goto L28
    }

    @JvmStatic
    public static final void d(String r4, String r5, String r6, Integer r7) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (a == null) goto L12;
        long r0 = System.currentTimeMillis();
        Long r2 = a;
        Intrinsics.checkNotNull(r2);
        long r1 = r0 - r2.longValue();
        JSONObject r3 = new JSONObject();
        e.b(r3, "file_id", e.a(r4));
        e.b(r3, "source", r5);
        e.b(r3, "result_key", r6);
        if (r7 == null) goto L8;
        String r8 = r7.toString();
    L9:
        e.b(r3, "result_code", r8);
        e.b(r3, "cost_time", Long.valueOf(r1));
        e.b(r3, "open_type", DocFeed$Value$DataSource.NETWORK);
        e.c("docs_wiki_performance_open_tree_finish", r3);
        return;
    L8:
        r8 = null;
        goto L9
    }

    public static void a(String r4, int r5, Integer r6, Boolean r7, int r8) {
        Long r1 = null;
        if ((r8 & 4) == 0) goto L6;
        r6 = null;
    L6:
        if ((r8 & 8) == 0) goto L8;
        r7 = null;
    L8:
        Intrinsics.checkNotNullParameter(r4, "collectedTag");
        Object r9 = ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).f(r4, "start");
        if ((r9 instanceof Long) == false) goto L11;
        r1 = (Long) r9;
    L11:
        if (r1 == null) goto L22;
        long r2 = System.currentTimeMillis() - r1.longValue();
        JSONObject r10 = new JSONObject();
        r10.put("result_code", String.valueOf(r5));
        if (r6 == null) goto L16;
        String r11 = r6.toString();
        if (r11 == null) goto L16;
    L17:
        r10.put("fail_code", r11);
        r10.put("cost_time", r2);
        r10.put("list_type", "wiki_home");
        r10.put("filter_type1", "");
        r10.put("sort_type", "");
        boolean r12 = false;
        r10.put("view_mode", 0);
        r10.put("user_operation_source", 0);
        if (r7 == null) goto L20;
        r12 = r7.booleanValue();
    L20:
        r10.put("has_cache", r12);
        e.c("docs_dev_performance_space_open_finish", r10);
        return;
    L16:
        r11 = "";
        goto L17
    }
}
