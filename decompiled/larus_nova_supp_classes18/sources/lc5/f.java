package lc5;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.ApiUtils;
import io.reactivex.Flowable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public static final a a = null;
    public static final SimpleDateFormat b = null;

    public static final class a {
        @JvmStatic
        public static String k(boolean r0) {
            if (r0 == false) goto L4;
            return "grid";
        L4:
            return "list";
        }

        @JvmStatic
        public static com.bytedance.ee.bear.contract.d d() {
            return (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        }

        public static long j() {
            Calendar r0 = Calendar.getInstance();
            r0.set(11, 0);
            r0.set(13, 0);
            r0.set(12, 0);
            r0.set(14, 0);
            return r0.getTime().getTime();
        }

        public a() {
        }

        @JvmStatic
        public static void H(o r3) {
            Intrinsics.checkNotNullParameter(r3, "param");
            HashMap r0 = new HashMap();
            r0.put("source", r3.b);
            r0.put("module", r3.c);
            r0.put("status_name", r3.d);
            r0.put("action", "make_a_copy");
            r0.put("file_type", sbb.e.c(r3.e));
            r0.put("file_id", du5.b.g(r3.f));
            if (qc5.a.h() == false) goto L5;
            String r1 = "new_format";
        L6:
            r0.put("space_version", r1);
            r3.a.v("client_content_management", r0);
            return;
        L5:
            r1 = "original";
            goto L6
        }

        public static int g(String r2) {
            if (r2 != null) goto L4;
        L7:
            boolean r0 = true;
        L9:
            if (r0 == false) goto L12;
            tt5.a.k("ListAnalysis", "contentUrl is empty");
            return sbb.e.i.b;
        L12:
            sbb.c.a.getClass();
            obb.b r3 = sbb.c.e(r2);
            if (r3 != null) goto L17;
            tt5.a.k("ListAnalysis", "metaInfo is empty");
            return sbb.e.i.b;
        L17:
            return r3.getType();
        L4:
            if (r2.length() == 0) goto L7;
            r0 = false;
            goto L9
        }

        @JvmStatic
        public static HashMap h(g r6) {
            Intrinsics.checkNotNullParameter(r6, "publicParams");
            HashMap r0 = new HashMap();
            String r1 = r6.b;
            String r2 = "";
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            r0.put("module", r1);
            if (TextUtils.isEmpty(r6.c) == false) goto L8;
            String r3 = "null";
        L11:
            r0.put("sub_module", r3);
            if (TextUtils.isEmpty(r6.d) == true) goto L14;
            r0.put("file_id", du5.b.g(r6.d));
        L15:
            int r4 = r6.e;
            if (r4 == sbb.e.e.b) goto L18;
            r0.put("file_type", sbb.e.c(r4));
        L20:
            if (TextUtils.isEmpty(r6.f) == false) goto L22;
            String r5 = "null";
        L25:
            r0.put("sub_file_type", r5);
            if (TextUtils.isEmpty(r6.g) == true) goto L28;
            r0.put("container_id", du5.b.g(r6.g));
        L30:
            if (TextUtils.isEmpty(r6.h) == true) goto L36;
            String r7 = r6.h;
            if (r7 == null) goto L35;
            r2 = r7;
        L35:
            r0.put("container_type", r2);
        L38:
            if (TextUtils.isEmpty(r6.i) == true) goto L40;
            r0.put("shortcut_id", du5.b.g(r6.i));
            r0.put("is_shortcut", "true");
        L42:
            if (qc5.a.h() == false) goto L44;
            String r8 = "new_format";
        L45:
            r0.put("space_version", r8);
            r0.put("app_form", "null");
            return r0;
        L44:
            r8 = "original";
            goto L45
        L40:
            r0.put("shortcut_id", "null");
            r0.put("is_shortcut", "false");
            goto L42
        L36:
            r0.put("container_type", "null");
            goto L38
        L28:
            r0.put("container_id", "null");
            goto L30
        L22:
            r5 = r6.f;
            if (r5 != null) goto L25;
            r5 = "";
            goto L25
        L18:
            r0.put("file_type", "null");
            goto L20
        L14:
            r0.put("file_id", "null");
            goto L15
        L8:
            r3 = r6.c;
            if (r3 != null) goto L11;
            r3 = "";
            goto L11
        }

        @JvmStatic
        public static String i(String r1) {
            if (r1 != null) goto L4;
        L44:
            return "";
        L4:
            switch(r1.hashCode()) {
                case -2082449580: goto L41;
                case -1785238953: goto L37;
                case -1548612125: goto L33;
                case -1212527303: goto L30;
                case -1062676844: goto L27;
                case -903566235: goto L23;
                case -517627512: goto L20;
                case -183014579: goto L17;
                case 3208415: goto L14;
                case 443164224: goto L10;
                case 2047310703: goto L7;
                default: goto L44;
            };
        L7:
            if (r1.equals("personal_subfolder") == false) goto L44;
        L43:
            return "ccm_space_folder_view";
        L10:
            if (r1.equals(WikiSpaceType.PERSONAL) == false) goto L44;
            return "ccm_space_personal_page_view";
        L14:
            if (r1.equals("home") == false) goto L44;
            return "ccm_space_home_page_view";
        L17:
            if (r1.equals("personal_folder") == true) goto L43;
        L20:
            if (r1.equals("shared_folder") == true) goto L43;
        L23:
            if (r1.equals("shared") == false) goto L44;
            return "ccm_space_shared_page_view";
        L27:
            if (r1.equals("personal_folder_root") == true) goto L43;
        L30:
            if (r1.equals("shared_folder_root") == true) goto L43;
        L33:
            if (r1.equals(OperationName.OPERATION_OFFLINE_AVAILABLE) == false) goto L44;
            return "ccm_space_offline_page_view";
        L37:
            if (r1.equals("favorites") == false) goto L44;
            return "ccm_space_favorites_page_view";
        L41:
            if (r1.equals("shared_subfolder") == true) goto L43;
            goto L43
        }

        @JvmStatic
        public static void o(Long r3) {
            JSONObject r0 = new JSONObject();
            r0.put("container_env", "larktab_bitable");
            r0.put("base_hp_from", "larktab");
            r0.put("tab_name", "recommend");
            r0.put("stay_duration", r3);
            r0.put("module", "base_home");
            com.bytedance.ee.bear.contract.d r4 = d();
            if (r4 == null) goto L6;
            r4.i("ccm_base_homepage_feed_stay_duration_status", r0);
            return;
        }

        @JvmStatic
        public static void y(String r3) {
            JSONObject r0 = new JSONObject();
            r0.put("container_env", "larktab_bitable");
            r0.put("base_hp_from", "larktab");
            r0.put("tab_name", r3);
            r0.put("module", "base_home");
            com.bytedance.ee.bear.contract.d r4 = d();
            if (r4 == null) goto L6;
            r4.i("ccm_base_homepage_landing_view", r0);
            return;
        }

        @JvmStatic
        public final void C(tc5.a r13) {
            Intrinsics.checkNotNullParameter(r13, "clickParam");
            JSONObject r0 = new JSONObject();
            b(this, new g(r0, r13.a, r13.b, r13.g, r13.getType(), "", r13.f, DocumentType.FOLDER_NAME, null));
            r0.put("click", r13.c);
            if (TextUtils.isEmpty(r13.d) == true) goto L6;
            r0.put("target", r13.d);
        L6:
            if (TextUtils.isEmpty(r13.e) == true) goto L8;
            r0.put("templates_id", r13.e);
        L8:
            com.bytedance.ee.bear.contract.d r14 = d();
            if (r14 == null) goto L12;
            r14.i("ccm_space_create_new_click", r0);
            return;
        }

        @JvmStatic
        public final void I(p r13) {
            Intrinsics.checkNotNullParameter(r13, "param");
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L33
            b(this, new g(r0, r13.b, r13.c, r13.g, r13.getType(), r13.i, r13.j, DocumentType.FOLDER_NAME, r13.q));     // Catch: Exception -> L33
            if (TextUtils.isEmpty(r13.d) == true) goto L7;
            r0.put("click", r13.d);     // Catch: Exception -> L33
        L7:
            if (TextUtils.isEmpty(r13.e) == true) goto L9;
            r0.put("target", r13.e);     // Catch: Exception -> L33
        L9:
            r0.put("view_type", k(t3.a));     // Catch: Exception -> L33
            if (TextUtils.isEmpty(r13.f) == true) goto L12;
            r0.put("current_sub_view", r13.f);     // Catch: Exception -> L33
        L12:
            r0.put("is_folder", r13.k);     // Catch: Exception -> L33
            r0.put("is_shared_folder", r13.l);     // Catch: Exception -> L33
            r0.put("is_subfolder", r13.m);     // Catch: Exception -> L33
            r0.put("folder_lever", r13.n);     // Catch: Exception -> L33
            Boolean r1 = r13.o;     // Catch: Exception -> L33
            if (r1 == null) goto L16;
            r0.put("is_blank", String.valueOf(r1));     // Catch: Exception -> L33
        L16:
            if (TextUtils.isEmpty(r13.p) == true) goto L19;
            r0.put("location", r13.p);     // Catch: Exception -> L33
        L19:
            if (TextUtils.isEmpty(r13.r) == true) goto L22;
            r0.put("container_env", r13.r);     // Catch: Exception -> L33
        L22:
            if (TextUtils.isEmpty(r13.s) == true) goto L25;
            r0.put("base_hp_from", r13.s);     // Catch: Exception -> L33
        L25:
            if (TextUtils.isEmpty(r13.t) == true) goto L28;
            r0.put("view_from", r13.t);     // Catch: Exception -> L33
        L28:
            if (r13.a == null) goto L37;
            a r2 = f.a;     // Catch: Exception -> L33
            com.bytedance.ee.bear.contract.d r3 = d();     // Catch: Exception -> L33
            if (r3 == null) goto L38;
            r3.i(r13.a, r0);     // Catch: Exception -> L33
            return;
        L38:
            return;
        L37:
            return;
        L33:
            tt5.a.d("ListAnalysis", "reportPageClick error");
        }

        @JvmStatic
        public final void J(p r14) {
            Intrinsics.checkNotNullParameter(r14, "param");
            JSONObject r1 = new JSONObject();     // Catch: Exception -> L33
            b(this, new g(r1, r14.b, r14.c, r14.g, r14.getType(), r14.i, r14.j, DocumentType.FOLDER_NAME, r14.q));     // Catch: Exception -> L33
            if (TextUtils.isEmpty(r14.d) == true) goto L7;
            r1.put("click", r14.d);     // Catch: Exception -> L33
        L7:
            if (TextUtils.isEmpty(r14.e) == true) goto L9;
            r1.put("target", r14.e);     // Catch: Exception -> L33
        L9:
            r1.put("view_type", k(t3.a));     // Catch: Exception -> L33
            if (TextUtils.isEmpty(r14.f) == true) goto L12;
            r1.put("current_sub_view", r14.f);     // Catch: Exception -> L33
        L12:
            r1.put("is_folder", r14.k);     // Catch: Exception -> L33
            r1.put("is_shared_folder", r14.l);     // Catch: Exception -> L33
            r1.put("is_subfolder", r14.m);     // Catch: Exception -> L33
            r1.put("folder_lever", r14.n);     // Catch: Exception -> L33
            Boolean r2 = r14.o;     // Catch: Exception -> L33
            if (r2 == null) goto L16;
            r1.put("is_blank", String.valueOf(r2));     // Catch: Exception -> L33
        L16:
            if (TextUtils.isEmpty(r14.p) == true) goto L19;
            r1.put("location", r14.p);     // Catch: Exception -> L33
        L19:
            if (TextUtils.isEmpty(r14.r) == true) goto L22;
            r1.put("container_env", r14.r);     // Catch: Exception -> L33
        L22:
            if (TextUtils.isEmpty(r14.s) == true) goto L25;
            r1.put("base_hp_from", r14.s);     // Catch: Exception -> L33
        L25:
            if (TextUtils.isEmpty(r14.s) == true) goto L28;
            r1.put("hp_version", "hp_v2");     // Catch: Exception -> L33
        L28:
            if (r14.a == null) goto L37;
            a r0 = f.a;     // Catch: Exception -> L33
            com.bytedance.ee.bear.contract.d r3 = d();     // Catch: Exception -> L33
            if (r3 == null) goto L38;
            r3.i(r14.a, r1);     // Catch: Exception -> L33
            return;
        L38:
            return;
        L37:
            return;
        L33:
            tt5.a.d("ListAnalysis", "reportPageClick error");
        }

        @JvmStatic
        public final void L(q r13) {
            Intrinsics.checkNotNullParameter(r13, "clickParam");
            JSONObject r0 = new JSONObject();
            b(this, new g(r0, r13.b, r13.c, r13.f, r13.getType(), r13.h, r13.e, DocumentType.FOLDER_NAME, r13.l));
            r0.put("click", "list_item");
            if (TextUtils.isEmpty(r13.d) == true) goto L5;
            r0.put("current_sub_view", r13.d);
        L5:
            r0.put("view_type", k(t3.a));
            if (TextUtils.equals(r13.a, "ccm_base_homepage_filelist_click") == false) goto L9;
            r0.put("target", "ccm_bitable_content_page_view");
        L14:
            if (r13.getType() != sbb.e.f.b) goto L16;
            boolean r1 = true;
        L17:
            r0.put("is_folder", String.valueOf(r1));
            r0.put("is_shared_folder", String.valueOf(r13.i));
            r0.put("is_subfolder", String.valueOf(r13.j));
            r0.put("folder_lever", r13.k);
            if (TextUtils.isEmpty(r13.m) == true) goto L21;
            r0.put("container_env", r13.m);
        L21:
            if (TextUtils.isEmpty(r13.n) == true) goto L24;
            r0.put("base_hp_from", r13.n);
        L24:
            if (TextUtils.isEmpty("hp_v2") == true) goto L26;
            r0.put("hp_version", "hp_v2");
        L26:
            com.bytedance.ee.bear.contract.d r2 = d();
            if (r2 == null) goto L30;
            r2.i(r13.a, r0);
            return;
        L30:
            return;
        L16:
            r1 = false;
            goto L17
        L9:
            if (r13.getType() != sbb.e.f.b) goto L11;
            String r3 = "ccm_space_folder_view";
        L12:
            r0.put("target", r3);
            goto L14
        L11:
            r3 = "ccm_docs_page_view";
            goto L12
        }

        @JvmStatic
        public final void O(r r13) {
            Intrinsics.checkNotNullParameter(r13, "clickParam");
            JSONObject r0 = new JSONObject();
            b(this, new g(r0, r13.b, r13.c, r13.e, r13.getType(), r13.g, r13.l, DocumentType.FOLDER_NAME, null));
            if (t3.a == false) goto L5;
            String r1 = "switch_to_grid_view";
        L6:
            r0.put("click", r1);
            r0.put("target", "none");
            r0.put("switch_to", k(t3.a));
            r0.put("view_type", k(!t3.a));
            if (TextUtils.isEmpty(r13.d) == true) goto L9;
            r0.put("current_sub_view", r13.d);
        L9:
            r0.put("is_folder", String.valueOf(r13.h));
            r0.put("is_shared_folder", String.valueOf(r13.i));
            r0.put("is_subfolder", String.valueOf(r13.j));
            r0.put("folder_lever", r13.k);
            if (TextUtils.isEmpty(r13.m) == true) goto L13;
            r0.put("container_env", r13.m);
        L13:
            if (TextUtils.isEmpty(r13.n) == true) goto L15;
            r0.put("base_hp_from", r13.n);
        L15:
            com.bytedance.ee.bear.contract.d r2 = d();
            if (r2 == null) goto L19;
            r2.i(r13.a, r0);
            return;
        L19:
            return;
        L5:
            r1 = "switch_to_list_view";
            goto L6
        }

        @JvmStatic
        public final void S(v r13) {
            Intrinsics.checkNotNullParameter(r13, "param");
            JSONObject r0 = new JSONObject();
            b(this, new g(r0, r13.a, r13.b, r13.c, r13.getType(), r13.e, r13.f, r13.g, r13.h));
            r0.put("is_shared_folder", r13.i);
            r0.put("module", r13.a);
            r0.put("click", r13.j);
            r0.put("target", r13.k);
            r0.put("is_folder", r13.l);
            r0.put("view_title", r13.m);
            com.bytedance.ee.bear.contract.d r14 = d();
            if (r14 == null) goto L6;
            r14.i("ccm_space_delete_or_remove_click", r0);
            return;
        }

        @JvmStatic
        public static void B(com.bytedance.ee.bear.contract.d r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "analyticService");
            Intrinsics.checkNotNullParameter(r3, "module");
            HashMap r1 = new HashMap();
            r1.put("module", r3);
            if (qc5.a.h() == false) goto L5;
            String r4 = "new_format";
        L6:
            r1.put("space_version", r4);
            r2.v("click_search", r1);
            return;
        L5:
            r4 = "original";
            goto L6
        }

        @JvmStatic
        public static void K(q r12, ce5.a r13) {
            Intrinsics.checkNotNullParameter(r12, "clickParam");
            Intrinsics.checkNotNullParameter(r13, "userComponentAbility");
            JSONObject r0 = new JSONObject();
            a(new g(r0, r12.b, r12.c, r12.f, r12.getType(), r12.h, r12.e, DocumentType.FOLDER_NAME, r12.l), r13);
            r0.put("click", "list_item");
            if (TextUtils.isEmpty(r12.d) == true) goto L5;
            r0.put("current_sub_view", r12.d);
        L5:
            r0.put("view_type", k(t3.a));
            if (TextUtils.equals(r12.a, "ccm_base_homepage_filelist_click") == false) goto L9;
            r0.put("target", "ccm_bitable_content_page_view");
        L14:
            if (r12.getType() != sbb.e.f.b) goto L16;
            boolean r14 = true;
        L17:
            r0.put("is_folder", String.valueOf(r14));
            r0.put("is_shared_folder", String.valueOf(r12.i));
            r0.put("is_subfolder", String.valueOf(r12.j));
            r0.put("folder_lever", r12.k);
            if (TextUtils.isEmpty(r12.m) == true) goto L21;
            r0.put("container_env", r12.m);
        L21:
            if (TextUtils.isEmpty(r12.n) == true) goto L23;
            r0.put("base_hp_from", r12.n);
        L23:
            com.bytedance.ee.bear.contract.d r15 = d();
            if (r15 == null) goto L27;
            r15.i(r12.a, r0);
            return;
        L27:
            return;
        L16:
            r14 = false;
            goto L17
        L9:
            if (r12.getType() != sbb.e.f.b) goto L11;
            String r16 = "ccm_space_folder_view";
        L12:
            r0.put("target", r16);
            goto L14
        L11:
            r16 = "ccm_docs_page_view";
            goto L12
        }

        public static void a(g r5, ce5.a r6) {
            JSONObject r0 = r5.a;
            String r1 = r5.c;
            r0.put("module", r5.b);
            if (TextUtils.isEmpty(r1) == false) goto L5;
            r1 = "null";
        L5:
            r0.put("sub_module", r1);
            if (TextUtils.isEmpty(r5.d) == true) goto L8;
            r0.put("file_id", du5.b.g(r5.d));
        L9:
            int r2 = r5.e;
            if (r2 == sbb.e.e.b) goto L12;
            r0.put("file_type", sbb.e.c(r2));
        L14:
            if (TextUtils.isEmpty(r5.f) == false) goto L16;
            String r3 = "null";
        L17:
            r0.put("sub_file_type", r3);
            if (TextUtils.isEmpty(r5.g) == true) goto L20;
            r0.put("container_id", du5.b.g(r5.g));
        L22:
            if (TextUtils.isEmpty(r5.h) == true) goto L24;
            r0.put("container_type", r5.h);
        L26:
            if (TextUtils.isEmpty(r5.i) == true) goto L28;
            r0.put("shortcut_id", du5.b.g(r5.i));
            r0.put("is_shortcut", "true");
        L30:
            if (qc5.a.g(r6) == false) goto L32;
            String r7 = "new_format";
        L33:
            r0.put("space_version", r7);
            r0.put("app_form", "null");
            return;
        L32:
            r7 = "original";
            goto L33
        L28:
            r0.put("shortcut_id", "null");
            r0.put("is_shortcut", "false");
            goto L30
        L24:
            r0.put("container_type", "null");
            goto L26
        L20:
            r0.put("container_id", "null");
            goto L22
        L16:
            r3 = r5.f;
            goto L17
        L12:
            r0.put("file_type", "null");
            goto L14
        L8:
            r0.put("file_id", "null");
            goto L9
        }

        public static /* synthetic */ void b(a r1, g r2) {
            ce5.a r0 = new ce5.a();
            r1.getClass();
            a(r2, r0);
        }

        @JvmStatic
        public static void D(com.bytedance.ee.bear.contract.d r1, String r2, HashMap r3) {
            Intrinsics.checkNotNullParameter(r1, "analyticService");
            Intrinsics.checkNotNullParameter(r2, "eventId");
            r1.v(r2, r3);
        }

        @JvmStatic
        public static void E(String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter("ccm_base_homepage_filelist_view", "eventName");
            Intrinsics.checkNotNullParameter(r3, "currentSubView");
            JSONObject r0 = new JSONObject();
            r0.put("current_sub_view", r3);
            if (TextUtils.isEmpty(r4) == true) goto L6;
            r0.put("container_env", r4);
        L6:
            if (TextUtils.isEmpty(r5) == true) goto L8;
            r0.put("base_hp_from", r5);
        L8:
            com.bytedance.ee.bear.contract.d r6 = d();
            if (r6 == null) goto L12;
            r6.i("ccm_base_homepage_filelist_view", r0);
            return;
        }

        public static void p(String r3, String r4, Long r5) {
            JSONObject r0 = new JSONObject();
            r0.put("container_env", "larktab_bitable");
            r0.put("base_hp_from", r4);
            r0.put("tab_name", "recommend");
            r0.put("stay_duration", r5);
            r0.put("module", "base_home");
            if (TextUtils.isEmpty("hp_v2") == true) goto L6;
            r0.put("hp_version", "hp_v2");
        L6:
            if (TextUtils.isEmpty(r3) == true) goto L8;
            r0.put("container_env", r3);
        L8:
            com.bytedance.ee.bear.contract.d r6 = d();
            if (r6 == null) goto L12;
            r6.i("ccm_base_homepage_feed_stay_duration_status", r0);
            return;
        }

        @JvmStatic
        public static void F(String r3, String r4, String r5, Boolean r6) {
            Intrinsics.checkNotNullParameter("ccm_base_homepage_filelist_view", "eventName");
            Intrinsics.checkNotNullParameter(r3, "currentSubView");
            JSONObject r0 = new JSONObject();
            r0.put("current_sub_view", r3);
            if (TextUtils.isEmpty(r4) == true) goto L6;
            r0.put("container_env", r4);
        L6:
            if (TextUtils.isEmpty(r5) == true) goto L9;
            r0.put("base_hp_from", r5);
        L9:
            if (TextUtils.isEmpty("hp_v2") == true) goto L12;
            r0.put("hp_version", "hp_v2");
        L12:
            if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L14;
            r0.put("is_full_screen", true);
        L15:
            com.bytedance.ee.bear.contract.d r7 = d();
            if (r7 == null) goto L19;
            r7.i("ccm_base_homepage_filelist_view", r0);
            return;
        L19:
            return;
        L14:
            r0.put("is_full_screen", false);
            goto L15
        }

        public static /* synthetic */ void Q(String r8, String r9, String r10, boolean r11) {
            f.a.P(r8, r9, "hp_v2", r10, r11, null, null);
        }

        @JvmStatic
        public static void R(String r5, String r6, String r7, String r8) {
            Intrinsics.checkNotNullParameter(r5, "duplicateReason");
            Intrinsics.checkNotNullParameter(r6, "click");
            JSONObject r3 = new JSONObject();     // Catch: Exception -> L18
            r3.put("duplicate_reason", r5);     // Catch: Exception -> L18
            r3.put("click", r6);     // Catch: Exception -> L18
            r3.put("target", "none");     // Catch: Exception -> L18
            String r9 = du5.b.g(r7);     // Catch: Exception -> L18
            if (r9 != null) goto L7;
            r9 = "";
        L7:
            r3.put("children_file_id", r9);     // Catch: Exception -> L18
            r3.put("children_page_token", "");     // Catch: Exception -> L18
            if (r8 != null) goto L10;
            r8 = "";
        L10:
            r3.put("children_file_type", r8);     // Catch: Exception -> L18
            if (qc5.a.h() == false) goto L13;
            String r10 = "new_format";
        L14:
            r3.put("space_version", r10);     // Catch: Exception -> L18
            tt5.a.b("ListAnalysis", "reportSpaceAddToFolderDuplicateClick, params = " + r3);     // Catch: Exception -> L18
            com.bytedance.ee.bear.contract.d r11 = d();     // Catch: Exception -> L18
            if (r11 == null) goto L23;
            r11.u("ccm_space_add_to_folder_duplicate_click", r3);     // Catch: Exception -> L18
            return;
        L23:
            return;
        L13:
            r10 = "original";
        L18:
            e = move-exception;
            tt5.a.d("ListAnalysis", "reportSpaceAddToFolderDuplicateClick error " + e.getMessage());
        }

        @JvmStatic
        public static void c(com.bytedance.ee.bear.contract.d r1, String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r1, "analyticService");
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "key");
            r1.j(r2, r3, r4);
        }

        @JvmStatic
        public static void z(String r3, String r4, String r5, String r6) {
            JSONObject r0 = new JSONObject();
            r0.put("container_env", "larktab_bitable");
            r0.put("base_hp_from", r3);
            r0.put("tab_name", r4);
            r0.put("module", "base_home");
            if (TextUtils.isEmpty(r5) == true) goto L6;
            r0.put("hp_version", r5);
        L6:
            if (TextUtils.isEmpty(r6) == true) goto L8;
            r0.put("container_env", r6);
        L8:
            com.bytedance.ee.bear.contract.d r7 = d();
            if (r7 == null) goto L12;
            r7.i("ccm_base_homepage_landing_view", r0);
            return;
        }

        @JvmStatic
        public final void A(String r15, String r16, String r17, String r18) {
            Intrinsics.checkNotNullParameter(r15, "event");
            JSONObject r2 = new JSONObject();
            b(this, new g(r2, "", "", "", sbb.e.e.b, "", "", "", null));
            if (r16 == null) goto L6;
            r2.put("current_sub_view", r16);
        L6:
            if (TextUtils.isEmpty(r17) == true) goto L9;
            r2.put("container_env", r17);
        L9:
            if (TextUtils.isEmpty(r18) == true) goto L11;
            r2.put("base_hp_from", r18);
        L11:
            r2.put("view_type", k(t3.a));
            com.bytedance.ee.bear.contract.d r1 = d();
            if (r1 == null) goto L15;
            r1.i(r15, r2);
            return;
        }

        @JvmStatic
        public final void M(String r9, String r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r9, "event");
            Intrinsics.checkNotNullParameter(r10, "module");
            Intrinsics.checkNotNullParameter(r11, "subModule");
            N(r9, r10, r11, r12, null, null);
        }

        @JvmStatic
        public final void l(p r20, String r21, String r22, String r23) {
            Intrinsics.checkNotNullParameter(r20, "param");
            tt5.a.h("ListAnalysis", "reportAINotePageClick()...");     // Catch: Exception -> L45
            JSONObject r6 = new JSONObject();     // Catch: Exception -> L45
            b(this, new g(r6, r20.b, r20.c, r20.g, r20.getType(), r20.i, r20.j, DocumentType.FOLDER_NAME, r20.q));     // Catch: Exception -> L49
            if (TextUtils.isEmpty(r20.d) == true) goto L11;
            r6.put("click", r20.d);     // Catch: Exception -> L49
        L11:
            if (TextUtils.isEmpty(r20.e) == true) goto L13;
            r6.put("target", r20.e);     // Catch: Exception -> L49
        L13:
            r6.put("view_type", k(t3.a));     // Catch: Exception -> L49
            if (TextUtils.isEmpty(r20.f) == true) goto L16;
            r6.put("current_sub_view", r20.f);     // Catch: Exception -> L49
        L16:
            r6.put("is_folder", r20.k);     // Catch: Exception -> L49
            r6.put("is_shared_folder", r20.l);     // Catch: Exception -> L49
            r6.put("is_subfolder", r20.m);     // Catch: Exception -> L49
            r6.put("folder_lever", r20.n);     // Catch: Exception -> L49
            Boolean r4 = r20.o;     // Catch: Exception -> L49
            if (r4 == null) goto L20;
            r6.put("is_blank", String.valueOf(r4));     // Catch: Exception -> L49
        L20:
            if (TextUtils.isEmpty(r20.p) == true) goto L23;
            r6.put("location", r20.p);     // Catch: Exception -> L49
        L23:
            if (TextUtils.isEmpty(r20.r) == true) goto L26;
            r6.put("container_env", r20.r);     // Catch: Exception -> L49
        L26:
            if (TextUtils.isEmpty(r20.s) == true) goto L29;
            r6.put("base_hp_from", r20.s);     // Catch: Exception -> L49
        L29:
            if (TextUtils.isEmpty(r20.t) == true) goto L31;
            r6.put("view_from", r20.t);     // Catch: Exception -> L49
        L31:
            if (r23 == null) goto L33;
            r6.put("source", r23);     // Catch: Exception -> L49
        L33:
            if (r21 == null) goto L36;
            r6.put(r21, r22);     // Catch: Exception -> L49
        L36:
            if (r20.a == null) goto L58;
            String r2 = "ListAnalysis";
            tt5.a.h(r2, "reportAINotePageClick()...event = " + r20.a + ", click = " + r20.d + ", source = " + r23 + ", secondKey = " + r21 + ", secondValue = " + r22);     // Catch: Exception -> L48
            a r1 = f.a;     // Catch: Exception -> L48
            com.bytedance.ee.bear.contract.d r3 = d();     // Catch: Exception -> L48
            if (r3 == null) goto L59;
            r3.i(r20.a, r6);     // Catch: Exception -> L48
            return;
        L59:
            return;
        L46:
            tt5.a.d(r2, "reportAINotePageClick error");
            return;
        L58:
            return;
        L44:
            r2 = "ListAnalysis";
        L45:
            r2 = "ListAnalysis";
            goto L46
        }

        @JvmStatic
        public final void m(String r14, String r15, String r16, String r17) {
            JSONObject r11 = new JSONObject();
            b(this, new g(r11, "", "", "", sbb.e.e.b, "", "", "", null));
            r11.put("click", "notice_card_click");
            if (r14 == null) goto L5;
            r11.put("notice_id", r14);
        L5:
            if (r15 == null) goto L7;
            r11.put("file_id", du5.b.g(r15));
        L7:
            r11.put("current_sub_view", r16);
            r11.put("notice_card_type", r17);
            r11.put("container_env", "larktab_bitable");
            r11.put("view_type", k(t3.a));
            com.bytedance.ee.bear.contract.d r0 = d();
            if (r0 == null) goto L11;
            r0.i("ccm_base_homepage_activity_click", r11);
            return;
        }

        @JvmStatic
        public static void T(com.bytedance.ee.bear.contract.d r2, String r3, String r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "analyticService");
            Intrinsics.checkNotNullParameter(r3, "module");
            JSONObject r1 = new JSONObject();
            r1.put("module", r3);
            if (TextUtils.isEmpty(r4) == true) goto L6;
            r1.put("sub_module", r4);
        L6:
            if (TextUtils.isEmpty(r5) == true) goto L9;
            r1.put("src_module", r5);
        L9:
            if (TextUtils.isEmpty(r6) == true) goto L12;
            r1.put("src_folder_id", du5.b.g(r6));
        L12:
            if (qc5.a.h() == false) goto L14;
            String r7 = "new_format";
        L15:
            r1.put("space_version", r7);
            r2.a("enter_explorer_module", r1);
            return;
        L14:
            r7 = "original";
            goto L15
        }

        @JvmStatic
        public final void G(String r16, String r17, String r18, String r19, String r20, String r21) {
            Intrinsics.checkNotNullParameter(r16, "module");
            Intrinsics.checkNotNullParameter(r17, "subModule");
            Intrinsics.checkNotNullParameter(r18, "currentSubView");
            Intrinsics.checkNotNullParameter(r19, "event");
            O(new r(r19, r16, r17, r18, "", sbb.e.e.b, false, false, false, 0, "", r20, r21));
        }

        @JvmStatic
        public final void N(String r14, String r15, String r16, String r17, String r18, String r19) {
            Intrinsics.checkNotNullParameter(r14, "event");
            Intrinsics.checkNotNullParameter(r15, "module");
            Intrinsics.checkNotNullParameter(r16, "subModule");
            JSONObject r1 = new JSONObject();
            b(this, new g(r1, r15, r16, "", sbb.e.e.b, "", "", "", null));
            if (TextUtils.isEmpty(r17) == true) goto L6;
            r1.put("current_sub_view", r17);
        L6:
            if (TextUtils.isEmpty(r18) == true) goto L9;
            r1.put("container_env", r18);
        L9:
            if (TextUtils.isEmpty(r19) == true) goto L12;
            r1.put("base_hp_from", r19);
        L12:
            if (TextUtils.equals(r14, "ccm_space_home_page_view") == false) goto L14;
        L15:
            r1.put("is_ai_notes", String.valueOf(qc5.a.a()));
        L16:
            r1.put("view_type", k(t3.a));
            com.bytedance.ee.bear.contract.d r3 = d();
            if (r3 == null) goto L20;
            r3.i(r14, r1);
            return;
        L20:
            return;
        L14:
            if (TextUtils.equals(r14, "ccm_space_sidebar_view") == false) goto L16;
            goto L15
        }

        @JvmStatic
        public final void n(String r17, String r18, String r19, Integer r20, String r21, String r22) {
            Intrinsics.checkNotNullParameter("ccm_base_homepage_banner_click", "event");
            Intrinsics.checkNotNullParameter(r17, "click");
            JSONObject r14 = new JSONObject();     // Catch: Exception -> L24
            b(this, new g(r14, "", "", "", sbb.e.e.b, "", "", "", null));     // Catch: Exception -> L22
            r14.put("click", r17);     // Catch: Exception -> L22
            if (TextUtils.isEmpty(r18) == true) goto L8;
            r14.put("template_token", UriProtector.parse(r18).getLastPathSegment());     // Catch: Exception -> L22
        L8:
            if (r19 == null) goto L10;
            r14.put("template_name", r19);     // Catch: Exception -> L22
        L10:
            if (r20 == null) goto L13;
            r14.put("position_index", r20.intValue() + 1);     // Catch: Exception -> L22
        L13:
            if (TextUtils.isEmpty(r21) == true) goto L16;
            r14.put("container_env", r21);     // Catch: Exception -> L22
        L16:
            if (TextUtils.isEmpty(r22) == true) goto L18;
            r14.put("base_hp_from", r22);     // Catch: Exception -> L22
        L18:
            r14.put("view_type", k(t3.a));     // Catch: Exception -> L22
            com.bytedance.ee.bear.contract.d r0 = d();     // Catch: Exception -> L22
            if (r0 == null) goto L32;
            r0.i("ccm_base_homepage_banner_click", r14);     // Catch: Exception -> L22
            return;
        L32:
            return;
        L22:
            e = e;
        L26:
            tt5.a.d("ListAnalysis", "reportBannerClick error " + e.getMessage());
            return;
        L24:
            e = e;
            goto L26
        }

        @JvmStatic
        public final void P(String r14, String r15, String r16, String r17, boolean r18, String r19, Boolean r20) {
            Intrinsics.checkNotNullParameter("ccm_base_homepage_landing_view", "event");
            Intrinsics.checkNotNullParameter("base_home", "module");
            Intrinsics.checkNotNullParameter("", "subModule");
            JSONObject r11 = new JSONObject();
            b(this, new g(r11, "base_home", "", "", sbb.e.e.b, "", "", "", null));
            if (TextUtils.isEmpty("") == true) goto L6;
            r11.put("current_sub_view", "");
        L6:
            if (TextUtils.isEmpty(r14) == true) goto L9;
            r11.put("container_env", r14);
        L9:
            if (TextUtils.isEmpty(r15) == true) goto L12;
            r11.put("base_hp_from", r15);
        L12:
            if (TextUtils.isEmpty(r16) == true) goto L15;
            r11.put("hp_version", r16);
        L15:
            if (TextUtils.isEmpty(r17) == true) goto L17;
            r11.put("tab_name", r17);
        L17:
            r11.put("has_feed", r18);
            if (TextUtils.isEmpty(r19) == true) goto L20;
            r11.put("page_type", r19);
        L20:
            if (r20 == null) goto L22;
            r11.put("has_notice_dot", r20.booleanValue());
        L22:
            r11.put("view_type", k(t3.a));
            com.bytedance.ee.bear.contract.d r1 = d();
            if (r1 == null) goto L26;
            r1.i("ccm_base_homepage_landing_view", r11);
            return;
        }

        @JvmStatic
        public final void q(String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25) {
            Intrinsics.checkNotNullParameter(r18, "module");
            Intrinsics.checkNotNullParameter(r19, "subModule");
            Intrinsics.checkNotNullParameter(r20, "click");
            Intrinsics.checkNotNullParameter(r21, "target");
            Intrinsics.checkNotNullParameter(r23, "currentSubView");
            JSONObject r15 = new JSONObject();
            b(this, new g(r15, r18, r19, r22, sbb.e.i.b, "", "", DocumentType.FOLDER_NAME, null));
            if (TextUtils.isEmpty(r22) == true) goto L5;
            r15.put("target_file_id", du5.b.g(r22));
        L7:
            if (TextUtils.isEmpty(r24) == true) goto L10;
            r15.put("container_env", r24);
        L10:
            if (TextUtils.isEmpty(r25) == true) goto L12;
            r15.put("base_hp_from", r25);
        L12:
            r15.put("click", r20);
            r15.put("target", r21);
            r15.put("view_type", k(t3.a));
            if (TextUtils.isEmpty(r23) == true) goto L15;
            r15.put("current_sub_view", r23);
        L15:
            r15.put("is_folder", false);
            r15.put("is_shared_folder", false);
            r15.put("is_subfolder", false);
            r15.put("folder_lever", 0);
            com.bytedance.ee.bear.contract.d r0 = d();
            if (r0 == null) goto L19;
            r0.i("ccm_base_homepage_landing_click", r15);
            return;
        L19:
            return;
        L5:
            r15.put("target_file_id", "null");
            goto L7
        }

        @JvmStatic
        public final void r(String r19, String r20, String r21, String r22, String r23, String r24, String r25, boolean r26) {
            Intrinsics.checkNotNullParameter(r19, "module");
            Intrinsics.checkNotNullParameter("", "subModule");
            Intrinsics.checkNotNullParameter(r20, "click");
            Intrinsics.checkNotNullParameter(r21, "target");
            Intrinsics.checkNotNullParameter("", "currentSubView");
            JSONObject r15 = new JSONObject();
            b(this, new g(r15, r19, "", r22, sbb.e.i.b, "", "", DocumentType.FOLDER_NAME, null));
            if (TextUtils.isEmpty(r22) == true) goto L5;
            r15.put("target_file_id", du5.b.g(r22));
        L7:
            if (TextUtils.isEmpty(r23) == true) goto L10;
            r15.put("container_env", r23);
        L10:
            if (TextUtils.isEmpty(r24) == true) goto L13;
            r15.put("base_hp_from", r24);
        L13:
            if (TextUtils.isEmpty(r25) == true) goto L15;
            r15.put("hp_version", r25);
        L15:
            r15.put("has_feed", r26);
            r15.put("click", r20);
            r15.put("target", r21);
            r15.put("view_type", k(t3.a));
            if (TextUtils.isEmpty("") == true) goto L18;
            r15.put("current_sub_view", "");
        L18:
            r15.put("is_folder", false);
            r15.put("is_shared_folder", false);
            r15.put("is_subfolder", false);
            r15.put("folder_lever", 0);
            com.bytedance.ee.bear.contract.d r0 = d();
            if (r0 == null) goto L22;
            r0.i("ccm_base_homepage_landing_click", r15);
            return;
        L22:
            return;
        L5:
            r15.put("target_file_id", "null");
            goto L7
        }

        public final JSONObject e(String r13, String r14, String r15, String r16, Integer r17, Integer r18, Integer r19, String r20, Boolean r21) {
            boolean r0 = false;
            if (r13 != null) goto L5;
        L10:
            if (r0 == false) goto L12;
            String r1 = UriProtector.parse(r13).getLastPathSegment();
        L13:
            String r5 = r1;
            JSONObject r2 = new JSONObject();
            b(this, new g(r2, "base_home", "homepage_feed", r5, g(r13), null, null, null, null));
            r2.put("container_env", "larktab_bitable");
            r2.put("base_hp_from", "larktab");
            r2.put("tab_name", "recommend");
            r2.put("content_id", r14);
            r2.put("content_name", r15);
            r2.put("request_id", r16);
            r2.put("request_rank_first", r17);
            r2.put("all_position_index", r18);
            r2.put("position_index", r19);
            r2.put("is_cover_load_success", r20);
            r2.put("is_refresh", r21);
            Date r3 = new Date();
            r2.put("happen_date", f.b.format(r3));
            return r2;
        L12:
            r1 = "";
            goto L13
        L5:
            if (r13.length() <= 0) goto L7;
            boolean r4 = true;
        L8:
            if (r4 != true) goto L10;
            r0 = true;
            goto L10
        L7:
            r4 = false;
            goto L8
        }

        @JvmStatic
        public final void w(String r2, String r3, String r4, String r5, Integer r6, Integer r7, Integer r8, String r9, Boolean r10, Map r11) {
            com.bytedance.ee.bear.contract.d r0 = d();
            if (r0 == null) goto L13;
            JSONObject r12 = e(r2, r3, r4, r5, r6, r7, r8, r9, r10);
            if (r11 == null) goto L10;
            Iterator r13 = r11.entrySet().iterator();
        L8:
            if (r13.hasNext() == false) goto L10;
            Map.Entry r14 = (Map.Entry) r13.next();
            r12.put((String) r14.getKey(), r14.getValue());
        L10:
            Unit r15 = Unit.INSTANCE;
            r0.i("ccm_base_homepage_feed_content_view", r12);
            return;
        }

        public final JSONObject f(String r13, String r14, String r15, String r16, String r17, String r18, Integer r19, Integer r20, Integer r21, String r22, Boolean r23) {
            boolean r0 = false;
            if (r15 != null) goto L5;
        L10:
            if (r0 == false) goto L12;
            String r1 = UriProtector.parse(r15).getLastPathSegment();
        L13:
            String r5 = r1;
            JSONObject r2 = new JSONObject();
            b(this, new g(r2, "base_home", "homepage_feed", r5, g(r15), null, null, null, null));
            r2.put("container_env", r13);
            r2.put("base_hp_from", r14);
            r2.put("tab_name", "recommend");
            r2.put("content_id", r16);
            r2.put("content_name", r17);
            r2.put("request_id", r18);
            r2.put("request_rank_first", r19);
            r2.put("all_position_index", r20);
            r2.put("position_index", r21);
            r2.put("is_cover_load_success", r22);
            r2.put("is_refresh", r23);
            if (TextUtils.isEmpty("hp_v2") == true) goto L16;
            r2.put("hp_version", "hp_v2");
        L16:
            Date r3 = new Date();
            r2.put("happen_date", f.b.format(r3));
            return r2;
        L12:
            r1 = "";
            goto L13
        L5:
            if (r15.length() <= 0) goto L7;
            boolean r4 = true;
        L8:
            if (r4 != true) goto L10;
            r0 = true;
            goto L10
        L7:
            r4 = false;
            goto L8
        }

        @JvmStatic
        public final void s(String r1, String r2, String r3, String r4, Integer r5, Integer r6, Integer r7, String r8, Boolean r9, Long r10, Map r11) {
            JSONObject r12 = e(r1, r2, r3, r4, r5, r6, r7, r8, r9);
            if (r11 == null) goto L8;
            Iterator r13 = r11.entrySet().iterator();
        L6:
            if (r13.hasNext() == false) goto L8;
            Map.Entry r14 = (Map.Entry) r13.next();
            r12.put((String) r14.getKey(), r14.getValue());
        L8:
            r12.put("target", "ccm_docs_page_view");
            r12.put("show_duration", r10);
            com.bytedance.ee.bear.contract.d r15 = d();
            if (r15 == null) goto L13;
            r15.i("ccm_base_homepage_feed_content_click", r12);
            return;
        }

        @JvmStatic
        public final void u(String r1, String r2, String r3, String r4, Integer r5, Integer r6, Integer r7, String r8, Boolean r9, Long r10, Map r11) {
            JSONObject r12 = e(r1, r2, r3, r4, r5, r6, r7, r8, r9);
            if (r11 == null) goto L8;
            Iterator r13 = r11.entrySet().iterator();
        L6:
            if (r13.hasNext() == false) goto L8;
            Map.Entry r14 = (Map.Entry) r13.next();
            r12.put((String) r14.getKey(), r14.getValue());
        L8:
            r12.put("show_duration", r10);
            com.bytedance.ee.bear.contract.d r15 = d();
            if (r15 == null) goto L13;
            r15.i("ccm_base_homepage_feed_content_effect_view", r12);
            return;
        }

        @JvmStatic
        public final void x(String r2, String r3, String r4, String r5, String r6, String r7, Integer r8, Integer r9, Integer r10, String r11, Boolean r12, Map r13) {
            com.bytedance.ee.bear.contract.d r0 = d();
            if (r0 == null) goto L13;
            JSONObject r14 = f(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
            if (r13 == null) goto L10;
            Iterator r15 = r13.entrySet().iterator();
        L8:
            if (r15.hasNext() == false) goto L10;
            Map.Entry r16 = (Map.Entry) r15.next();
            r14.put((String) r16.getKey(), r16.getValue());
        L10:
            Unit r17 = Unit.INSTANCE;
            r0.i("ccm_base_homepage_feed_content_view", r14);
            return;
        }

        @JvmStatic
        public final void t(String r1, String r2, String r3, String r4, String r5, String r6, Integer r7, Integer r8, Integer r9, String r10, Boolean r11, Long r12, Map r13) {
            JSONObject r14 = f(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
            if (r13 == null) goto L8;
            Iterator r15 = r13.entrySet().iterator();
        L6:
            if (r15.hasNext() == false) goto L8;
            Map.Entry r16 = (Map.Entry) r15.next();
            r14.put((String) r16.getKey(), r16.getValue());
        L8:
            r14.put("target", "ccm_docs_page_view");
            r14.put("show_duration", r12);
            com.bytedance.ee.bear.contract.d r17 = d();
            if (r17 == null) goto L13;
            r17.i("ccm_base_homepage_feed_content_click", r14);
            return;
        }

        @JvmStatic
        public final void v(String r1, String r2, String r3, String r4, String r5, String r6, Integer r7, Integer r8, Integer r9, String r10, Boolean r11, Long r12, Map r13) {
            JSONObject r14 = f(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
            if (r13 == null) goto L8;
            Iterator r15 = r13.entrySet().iterator();
        L6:
            if (r15.hasNext() == false) goto L8;
            Map.Entry r16 = (Map.Entry) r15.next();
            r14.put((String) r16.getKey(), r16.getValue());
        L8:
            r14.put("show_duration", r12);
            com.bytedance.ee.bear.contract.d r17 = d();
            if (r17 == null) goto L13;
            r17.i("ccm_base_homepage_feed_content_effect_view", r14);
            return;
        }
    }

    @JvmStatic
    public static final void r(com.bytedance.ee.bear.contract.d r0, String r1, String r2, String r3, String r4) {
        a.T(r0, r1, r2, r3, r4);
    }

    static {
        a = new a();
        b = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    }

    @JvmStatic
    public static final void a(lc5.a r4) {
        Intrinsics.checkNotNullParameter(r4, "param");
        r4.a.h(r4.d);
        a.c(r4.a, r4.d, "source", r4.b);
        a.c(r4.a, r4.d, "module", r4.c);
        a.c(r4.a, r4.d, "file_type", sbb.e.c(r4.e.getType()));
        if (r4.e.getType() != sbb.e.l.b) goto L13;
        String r0 = r4.e.F;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        a.c(r4.a, r4.d, "sub_type", r4.e.F);
        goto L13
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
    L13:
        a.c(r4.a, r4.d, "file_id", du5.b.g(r4.e.d));
        com.bytedance.ee.bear.contract.d r2 = r4.a;
        String r3 = r4.d;
        String r5 = r4.e.x1;
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        a.c(r2, r3, "appid", r5);
    }

    @JvmStatic
    public static final void b(h r3) {
        Intrinsics.checkNotNullParameter(r3, "param");
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(r3.c) == false) goto L5;
    L9:
        r0.put("file_type", sbb.e.c(r3.d.getType()));
        if (r3.d.getType() != sbb.e.l.b) goto L20;
        String r1 = r3.d.F;
        if (r1 != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == true) goto L20;
        r0.put("sub_type", r3.d.F);
        goto L20
    L14:
        if (r1.length() == 0) goto L17;
        r2 = false;
    L20:
        r0.put("file_id", du5.b.g(r3.d.d));
        r0.put("action", "add_offline");
        r0.put("status_name", r3.e);
        if (qc5.a.h() == false) goto L23;
        String r4 = "new_format";
    L24:
        r0.put("space_version", r4);
        r3.a.v("client_content_management", r0);
        return;
    L23:
        r4 = "original";
        goto L24
    L5:
        if (r3.b == false) goto L7;
        String r5 = "grid_more";
    L8:
        r0.put("source", r5);
        r0.put("module", r3.c);
        goto L9
    L7:
        r5 = "left_slide";
        goto L8
    }

    @JvmStatic
    public static final void e(i r13) {
        a r0 = a;
        Intrinsics.checkNotNullParameter(r13, "clickParam");
        JSONObject r1 = new JSONObject();
        a.b(r0, new g(r1, r13.a, r13.b, "", sbb.e.f.b, "", r13.e, DocumentType.FOLDER_NAME, null));
        r1.put("is_shared_folder", "false");
        r1.put("click", r13.c);
        if (TextUtils.isEmpty(r13.d) == true) goto L5;
        r1.put("target", r13.d);
    L5:
        com.bytedance.ee.bear.contract.d r14 = a.d();
        if (r14 == null) goto L9;
        r14.i("ccm_space_create_new_folder_click", r1);
        return;
    }

    @JvmStatic
    public static final void h(String r5) {
        Intrinsics.checkNotNullParameter(r5, "objToken");
        Flowable r3 = null;
        NetService r1 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        Intrinsics.checkNotNullParameter(r5, "objToken");
        NetService.f r0 = new NetService.f("/space/api/explorer/recent/report/");
        ((NetService.e) r0).c = 1;
        ((HashMap) ((NetService.e) r0).d).put(ResourceData.KEY_OBJ_TOKEN, r5);
        Map r6 = ((NetService.e) r0).d;
        HashMap r7 = (HashMap) r6;
        r7.put("obj_type", String.valueOf(0));
        if (r1 == null) goto L7;
        NetService.d r8 = r1.Vc(new ax4.f());
        if (r8 == null) goto L7;
        r3 = r8.a(r0);
    L7:
        if (r3 == null) goto L10;
        r3.subscribe(b.a, c.a);
        return;
    }

    @JvmStatic
    public static final void j(p r2) {
        a r0 = a;
        Intrinsics.checkNotNullParameter(r2, "param");
        r0.I(r2);
    }

    @JvmStatic
    public static final void l(n r8) {
        Intrinsics.checkNotNullParameter(r8, "param");
        HashMap r1 = new HashMap();     // Catch: Exception -> L43
        r1.put("source", r8.f);     // Catch: Exception -> L43
        r1.put("module", r8.e);     // Catch: Exception -> L43
        r1.put("action", r8.c);     // Catch: Exception -> L43
        r1.put("file_type", sbb.e.c(r8.d.getType()));     // Catch: Exception -> L43
        boolean r4 = true;
        if (r8.d.getType() != sbb.e.l.b) goto L14;
        String r2 = r8.d.F;     // Catch: Exception -> L43
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L14;
        r1.put("sub_file_type", r8.d.F);     // Catch: Exception -> L43
        goto L14
    L8:
        if (r2.length() == 0) goto L11;
        r3 = false;
    L14:
        r1.put("file_id", du5.b.g(r8.d.d));     // Catch: Exception -> L43
        String r5 = r8.d.x1;     // Catch: Exception -> L43
        String r6 = "";
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        r1.put("appid", r5);     // Catch: Exception -> L43
        if (ArraysKt.contains(new String[]{"share", "delete", "more", "remove_complete"}, r8.c) == false) goto L38;
        String r7 = r8.d.f;     // Catch: Exception -> L43
        if (r7 != null) goto L23;
    L26:
        boolean r9 = true;
    L27:
        if (r9 == true) goto L30;
        r6 = du5.b.g(r8.d.f);     // Catch: Exception -> L43
    L30:
        r1.put("file_tenant_id", r6);     // Catch: Exception -> L43
        AccountService.Account r10 = r8.b;     // Catch: Exception -> L43
        if (r10 == null) goto L38;
        if (Intrinsics.areEqual(r8.d.f, r10.tenantId) == false) goto L36;
        r4 = false;
    L36:
        r1.put("file_is_cross_tenant", String.valueOf(r4));     // Catch: Exception -> L43
        goto L38
    L23:
        if (r7.length() == 0) goto L26;
        r9 = false;
    L38:
        if (qc5.a.h() == false) goto L40;
        String r11 = "new_format";
    L41:
        r1.put("space_version", r11);     // Catch: Exception -> L43
        r8.a.v("client_content_management", r1);     // Catch: Exception -> L43
        return;
    L40:
        r11 = "original";
    L43:
        e = move-exception;
        tt5.a.e("ListAnalysis", "reportLeftSlideClickEvent: error", e, false);
    }

    @JvmStatic
    public static final void n(s r3) {
        Intrinsics.checkNotNullParameter(r3, "removeParam");
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(r3.c) == false) goto L5;
    L9:
        r0.put("file_type", sbb.e.c(r3.getType()));
        r0.put("file_id", du5.b.g(r3.d));
        r0.put("action", "remove_offline");
        r0.put("status_name", r3.f);
        if (qc5.a.h() == false) goto L12;
        String r1 = "new_format";
    L13:
        r0.put("space_version", r1);
        r3.a.v("client_content_management", r0);
        return;
    L12:
        r1 = "original";
        goto L13
    L5:
        if (r3.b == false) goto L7;
        String r2 = "grid_more";
    L8:
        r0.put("source", r2);
        r0.put("module", r3.c);
        goto L9
    L7:
        r2 = "left_slide";
        goto L8
    }

    @JvmStatic
    public static final void o(u r3) {
        Intrinsics.checkNotNullParameter(r3, "param");
        HashMap r0 = new HashMap();
        r0.put("source", r3.b);
        r0.put("module", r3.c);
        if (r3.d == false) goto L5;
        String r1 = "succeed";
    L6:
        r0.put("status_name", r1);
        if (r3.e == false) goto L9;
        String r2 = "set_folder_display";
    L10:
        r0.put("action", r2);
        r0.put("file_type", sbb.e.f.getType());
        r0.put("file_id", du5.b.g(r3.f));
        if (qc5.a.h() == false) goto L13;
        String r4 = "new_format";
    L14:
        r0.put("space_version", r4);
        a.D(r3.a, "client_content_management", r0);
        return;
    L13:
        r4 = "original";
        goto L14
    L9:
        r2 = "set_folder_hidden";
        goto L10
    L5:
        r1 = "failed";
        goto L6
    }

    @JvmStatic
    public static final void c(com.bytedance.ee.bear.contract.d r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "analyticService");
        Intrinsics.checkNotNullParameter(r3, "module");
        HashMap r1 = new HashMap();
        r1.put("module", r3);
        if (qc5.a.h() == false) goto L5;
        String r4 = "new_format";
    L6:
        r1.put("space_version", r4);
        a.D(r2, "click_filter_board", r1);
        return;
    L5:
        r4 = "original";
        goto L6
    }

    @JvmStatic
    public static final void f(com.bytedance.ee.bear.contract.d r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "analyticService");
        Intrinsics.checkNotNullParameter(r3, "module");
        JSONObject r1 = new JSONObject();
        r1.put("module", r3);
        if (qc5.a.h() == false) goto L5;
        String r4 = "new_format";
    L6:
        r1.put("space_version", r4);
        r2.a("launch_web", r1);
        return;
    L5:
        r4 = "original";
        goto L6
    }

    @JvmStatic
    public static final void k(com.bytedance.ee.bear.contract.d r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "analyticService");
        Intrinsics.checkNotNullParameter(r6, "tag");
        String r0 = r5.e(r6, "start_time");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L16;
        float r2 = SystemClock.uptimeMillis() - yu5.c.g(r0, 0);
        zw4.a r3 = com.bytedance.ee.bear.docshost.m.a;
        if (r3 == null) goto L13;
        r3.a(r6, r2);
    L14:
        r5.c(r6);
        return;
    L13:
        tt5.a.k("AbsMonitorServiceImp", "monitorSLA: monitor agent is null");
        goto L14
    L16:
        return;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    @JvmStatic
    public static final void q(com.bytedance.ee.bear.contract.d r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "analyticService");
        Intrinsics.checkNotNullParameter(r2, "module");
        a.T(r1, r2, null, null, null);
    }

    @JvmStatic
    public static final void d(com.bytedance.ee.bear.contract.d r2, String r3, Document r4) {
        Intrinsics.checkNotNullParameter(r2, "analyticService");
        Intrinsics.checkNotNullParameter(r3, "module");
        Intrinsics.checkNotNullParameter(r4, "item");
        HashMap r1 = new HashMap();
        r1.put("module", r3);
        r1.put("file_type", sbb.e.c(r4.getType()));
        String r5 = r4.x1;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r1.put("appid", r5);
        if (qc5.a.h() == false) goto L8;
        String r6 = "new_format";
    L9:
        r1.put("space_version", r6);
        a.D(r2, "click_grid_more", r1);
        return;
    L8:
        r6 = "original";
        goto L9
    }

    @JvmStatic
    public static final void g(String r13, String r14, String r15) {
        a r0 = a;
        Intrinsics.checkNotNullParameter(r13, "module");
        JSONObject r1 = new JSONObject();
        a.b(r0, new g(r1, r13, r14, "", sbb.e.l.b, "", r15, DocumentType.FOLDER_NAME, null));
        com.bytedance.ee.bear.contract.d r16 = a.d();
        if (r16 == null) goto L6;
        r16.i("ccm_space_file_choose_view", r1);
        return;
    }

    @JvmStatic
    public static final void i(String r13, String r14, String r15) {
        a r0 = a;
        Intrinsics.checkNotNullParameter(r13, "module");
        JSONObject r1 = new JSONObject();
        a.b(r0, new g(r1, r13, r14, r15, sbb.e.f.b, "", "", "", null));
        com.bytedance.ee.bear.contract.d r16 = a.d();
        if (r16 == null) goto L6;
        r16.i("ccm_space_header_filter_view", r1);
        return;
    }

    @JvmStatic
    public static final void m(boolean r1, Document r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "document");
        Intrinsics.checkNotNullParameter(r3, "from");
        if (r1 == true) goto L6;
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.a()).subscribe(new d(r2, r3), e.a);
        return;
    }

    @JvmStatic
    public static final void p(String r14, String r15, String r16, boolean r17, String r18, String r19) {
        a r0 = a;
        Intrinsics.checkNotNullParameter(r14, "module");
        Intrinsics.checkNotNullParameter(r15, "subModule");
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L11
        a.b(r0, new g(r12, r14, r15, r16, sbb.e.f.b, "", r16, DocumentType.FOLDER_NAME, null));     // Catch: Throwable -> L11
        r12.put("view_type", a.k(t3.a));     // Catch: Throwable -> L11
        r12.put("is_shared_folder", String.valueOf(r17));     // Catch: Throwable -> L11
        if (((gpb.a) ApiUtils.getApi(gpb.a.class)).isFeishuBrand() == false) goto L6;
        String r1 = "feishu";
    L7:
        r12.put("owner_id", du5.b.g(r18));     // Catch: Throwable -> L11
        r12.put("owner_tenant_id", du5.b.g(r19));     // Catch: Throwable -> L11
        r12.put("user_brand", r1);     // Catch: Throwable -> L11
        r12.put("is_block", false);     // Catch: Throwable -> L11
        com.bytedance.ee.bear.contract.d r2 = a.d();     // Catch: Throwable -> L11
        if (r2 == null) goto L16;
        r2.i("ccm_space_folder_view", r12);     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L6:
        r1 = "lark";
    L11:
        th = move-exception;
        tt5.a.f("ListAnalysis", th, false);
    }
}
