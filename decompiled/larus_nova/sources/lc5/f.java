package lc5;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
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

/* JADX INFO: loaded from: classes18.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f508440a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f508441b = null;

    public static final class a {
        @JvmStatic
        public static String k(boolean r100) {
            if (r100 == false) goto L4;
            return GXViewKey.VIEW_TYPE_CONTAINER_GRID;
        L4:
            return "list";
        }

        @JvmStatic
        public static com.bytedance.ee.bear.contract.d d() {
            return (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        }

        public static long j() {
            Calendar r100 = Calendar.getInstance();
            r100.set(11, 0);
            r100.set(13, 0);
            r100.set(12, 0);
            r100.set(14, 0);
            return r100.getTime().getTime();
        }

        public a() {
        }

        @JvmStatic
        public static void H(o r100) {
            Intrinsics.checkNotNullParameter(r100, "param");
            HashMap r101 = new HashMap();
            r101.put("source", r100.f508496b);
            r101.put(EventConstant.Key.MODULE, r100.f508497c);
            r101.put("status_name", r100.f508498d);
            r101.put("action", "make_a_copy");
            r101.put("file_type", sbb.e.c(r100.f508499e));
            r101.put("file_id", du5.b.g(r100.f508500f));
            if (qc5.a.h() == false) goto L5;
            String r102 = "new_format";
        L6:
            r101.put("space_version", r102);
            r100.f508495a.v("client_content_management", r101);
            return;
        L5:
            r102 = "original";
            goto L6
        }

        public static int g(String r100) {
            if (r100 != null) goto L4;
        L7:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L12;
            tt5.a.k("ListAnalysis", "contentUrl is empty");
            return sbb.e.f541298i.f541317b;
        L12:
            sbb.c.f541290a.getClass();
            obb.b r102 = sbb.c.e(r100);
            if (r102 != null) goto L17;
            tt5.a.k("ListAnalysis", "metaInfo is empty");
            return sbb.e.f541298i.f541317b;
        L17:
            return r102.getType();
        L4:
            if (r100.length() == 0) goto L7;
            r101 = false;
            goto L9
        }

        @JvmStatic
        public static HashMap h(g r100) {
            Intrinsics.checkNotNullParameter(r100, "publicParams");
            HashMap r101 = new HashMap();
            String r102 = r100.f508443b;
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            r101.put(EventConstant.Key.MODULE, r102);
            if (TextUtils.isEmpty(r100.f508444c) == false) goto L8;
            String r104 = "null";
        L11:
            r101.put("sub_module", r104);
            if (TextUtils.isEmpty(r100.f508445d) == true) goto L14;
            r101.put("file_id", du5.b.g(r100.f508445d));
        L15:
            int r105 = r100.f508446e;
            if (r105 == sbb.e.f541294e.f541317b) goto L18;
            r101.put("file_type", sbb.e.c(r105));
        L20:
            if (TextUtils.isEmpty(r100.f508447f) == false) goto L22;
            String r106 = "null";
        L25:
            r101.put("sub_file_type", r106);
            if (TextUtils.isEmpty(r100.f508448g) == true) goto L28;
            r101.put("container_id", du5.b.g(r100.f508448g));
        L30:
            if (TextUtils.isEmpty(r100.f508449h) == true) goto L36;
            String r107 = r100.f508449h;
            if (r107 == null) goto L35;
            r103 = r107;
        L35:
            r101.put(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, r103);
        L38:
            if (TextUtils.isEmpty(r100.f508450i) == true) goto L40;
            r101.put("shortcut_id", du5.b.g(r100.f508450i));
            r101.put("is_shortcut", "true");
        L42:
            if (qc5.a.h() == false) goto L44;
            String r108 = "new_format";
        L45:
            r101.put("space_version", r108);
            r101.put("app_form", "null");
            return r101;
        L44:
            r108 = "original";
            goto L45
        L40:
            r101.put("shortcut_id", "null");
            r101.put("is_shortcut", "false");
            goto L42
        L36:
            r101.put(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, "null");
            goto L38
        L28:
            r101.put("container_id", "null");
            goto L30
        L22:
            r106 = r100.f508447f;
            if (r106 != null) goto L25;
            r106 = "";
            goto L25
        L18:
            r101.put("file_type", "null");
            goto L20
        L14:
            r101.put("file_id", "null");
            goto L15
        L8:
            r104 = r100.f508444c;
            if (r104 != null) goto L11;
            r104 = "";
            goto L11
        }

        @JvmStatic
        public static String i(String r100) {
            if (r100 != null) goto L4;
        L44:
            return "";
        L4:
            switch(r100.hashCode()) {
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
            if (r100.equals("personal_subfolder") == false) goto L44;
        L43:
            return "ccm_space_folder_view";
        L10:
            if (r100.equals(WikiSpaceType.PERSONAL) == false) goto L44;
            return "ccm_space_personal_page_view";
        L14:
            if (r100.equals("home") == false) goto L44;
            return "ccm_space_home_page_view";
        L17:
            if (r100.equals("personal_folder") == true) goto L43;
        L20:
            if (r100.equals("shared_folder") == true) goto L43;
        L23:
            if (r100.equals("shared") == false) goto L44;
            return "ccm_space_shared_page_view";
        L27:
            if (r100.equals("personal_folder_root") == true) goto L43;
        L30:
            if (r100.equals("shared_folder_root") == true) goto L43;
        L33:
            if (r100.equals(OperationName.OPERATION_OFFLINE_AVAILABLE) == false) goto L44;
            return "ccm_space_offline_page_view";
        L37:
            if (r100.equals("favorites") == false) goto L44;
            return "ccm_space_favorites_page_view";
        L41:
            if (r100.equals("shared_subfolder") == true) goto L43;
            goto L43
        }

        @JvmStatic
        public static void o(Long r100) {
            JSONObject r101 = new JSONObject();
            r101.put("container_env", "larktab_bitable");
            r101.put("base_hp_from", "larktab");
            r101.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, "recommend");
            r101.put("stay_duration", r100);
            r101.put(EventConstant.Key.MODULE, "base_home");
            com.bytedance.ee.bear.contract.d r102 = d();
            if (r102 == null) goto L6;
            r102.i("ccm_base_homepage_feed_stay_duration_status", r101);
            return;
        }

        @JvmStatic
        public static void y(String r100) {
            JSONObject r101 = new JSONObject();
            r101.put("container_env", "larktab_bitable");
            r101.put("base_hp_from", "larktab");
            r101.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r100);
            r101.put(EventConstant.Key.MODULE, "base_home");
            com.bytedance.ee.bear.contract.d r102 = d();
            if (r102 == null) goto L6;
            r102.i("ccm_base_homepage_landing_view", r101);
            return;
        }

        @JvmStatic
        public final void C(tc5.a r110) {
            Intrinsics.checkNotNullParameter(r110, "clickParam");
            JSONObject r100 = new JSONObject();
            b(this, new g(r100, r110.f545401a, r110.f545402b, r110.f545407g, r110.getType(), "", r110.f545406f, DocumentType.FOLDER_NAME, null));
            r100.put("click", r110.f545403c);
            if (TextUtils.isEmpty(r110.f545404d) == true) goto L6;
            r100.put(PickerReporterConstants.KEY.TARGET, r110.f545404d);
        L6:
            if (TextUtils.isEmpty(r110.f545405e) == true) goto L8;
            r100.put("templates_id", r110.f545405e);
        L8:
            com.bytedance.ee.bear.contract.d r111 = d();
            if (r111 == null) goto L12;
            r111.i("ccm_space_create_new_click", r100);
            return;
        }

        @JvmStatic
        public final void I(p r110) {
            Intrinsics.checkNotNullParameter(r110, "param");
            JSONObject r100 = new JSONObject();     // Catch: Exception -> L33
            b(this, new g(r100, r110.f508502b, r110.f508503c, r110.f508507g, r110.getType(), r110.f508509i, r110.f508510j, DocumentType.FOLDER_NAME, r110.f508517q));     // Catch: Exception -> L33
            if (TextUtils.isEmpty(r110.f508504d) == true) goto L7;
            r100.put("click", r110.f508504d);     // Catch: Exception -> L33
        L7:
            if (TextUtils.isEmpty(r110.f508505e) == true) goto L9;
            r100.put(PickerReporterConstants.KEY.TARGET, r110.f508505e);     // Catch: Exception -> L33
        L9:
            r100.put(BytedCertConstant.IntentKey.VIEW_TYPE, k(t3.f229771a));     // Catch: Exception -> L33
            if (TextUtils.isEmpty(r110.f508506f) == true) goto L12;
            r100.put("current_sub_view", r110.f508506f);     // Catch: Exception -> L33
        L12:
            r100.put("is_folder", r110.f508511k);     // Catch: Exception -> L33
            r100.put("is_shared_folder", r110.f508512l);     // Catch: Exception -> L33
            r100.put("is_subfolder", r110.f508513m);     // Catch: Exception -> L33
            r100.put("folder_lever", r110.f508514n);     // Catch: Exception -> L33
            Boolean r101 = r110.f508515o;     // Catch: Exception -> L33
            if (r101 == null) goto L16;
            r100.put("is_blank", String.valueOf(r101));     // Catch: Exception -> L33
        L16:
            if (TextUtils.isEmpty(r110.f508516p) == true) goto L19;
            r100.put("location", r110.f508516p);     // Catch: Exception -> L33
        L19:
            if (TextUtils.isEmpty(r110.f508518r) == true) goto L22;
            r100.put("container_env", r110.f508518r);     // Catch: Exception -> L33
        L22:
            if (TextUtils.isEmpty(r110.f508519s) == true) goto L25;
            r100.put("base_hp_from", r110.f508519s);     // Catch: Exception -> L33
        L25:
            if (TextUtils.isEmpty(r110.f508520t) == true) goto L28;
            r100.put("view_from", r110.f508520t);     // Catch: Exception -> L33
        L28:
            if (r110.f508501a == null) goto L37;
            a r102 = f.f508440a;     // Catch: Exception -> L33
            com.bytedance.ee.bear.contract.d r103 = d();     // Catch: Exception -> L33
            if (r103 == null) goto L38;
            r103.i(r110.f508501a, r100);     // Catch: Exception -> L33
            return;
        L38:
            return;
        L37:
            return;
        L33:
            tt5.a.d("ListAnalysis", "reportPageClick error");
        }

        @JvmStatic
        public final void J(p r110) {
            Intrinsics.checkNotNullParameter(r110, "param");
            JSONObject r100 = new JSONObject();     // Catch: Exception -> L33
            b(this, new g(r100, r110.f508502b, r110.f508503c, r110.f508507g, r110.getType(), r110.f508509i, r110.f508510j, DocumentType.FOLDER_NAME, r110.f508517q));     // Catch: Exception -> L33
            if (TextUtils.isEmpty(r110.f508504d) == true) goto L7;
            r100.put("click", r110.f508504d);     // Catch: Exception -> L33
        L7:
            if (TextUtils.isEmpty(r110.f508505e) == true) goto L9;
            r100.put(PickerReporterConstants.KEY.TARGET, r110.f508505e);     // Catch: Exception -> L33
        L9:
            r100.put(BytedCertConstant.IntentKey.VIEW_TYPE, k(t3.f229771a));     // Catch: Exception -> L33
            if (TextUtils.isEmpty(r110.f508506f) == true) goto L12;
            r100.put("current_sub_view", r110.f508506f);     // Catch: Exception -> L33
        L12:
            r100.put("is_folder", r110.f508511k);     // Catch: Exception -> L33
            r100.put("is_shared_folder", r110.f508512l);     // Catch: Exception -> L33
            r100.put("is_subfolder", r110.f508513m);     // Catch: Exception -> L33
            r100.put("folder_lever", r110.f508514n);     // Catch: Exception -> L33
            Boolean r101 = r110.f508515o;     // Catch: Exception -> L33
            if (r101 == null) goto L16;
            r100.put("is_blank", String.valueOf(r101));     // Catch: Exception -> L33
        L16:
            if (TextUtils.isEmpty(r110.f508516p) == true) goto L19;
            r100.put("location", r110.f508516p);     // Catch: Exception -> L33
        L19:
            if (TextUtils.isEmpty(r110.f508518r) == true) goto L22;
            r100.put("container_env", r110.f508518r);     // Catch: Exception -> L33
        L22:
            if (TextUtils.isEmpty(r110.f508519s) == true) goto L25;
            r100.put("base_hp_from", r110.f508519s);     // Catch: Exception -> L33
        L25:
            if (TextUtils.isEmpty(r110.f508519s) == true) goto L28;
            r100.put("hp_version", "hp_v2");     // Catch: Exception -> L33
        L28:
            if (r110.f508501a == null) goto L37;
            a r102 = f.f508440a;     // Catch: Exception -> L33
            com.bytedance.ee.bear.contract.d r103 = d();     // Catch: Exception -> L33
            if (r103 == null) goto L38;
            r103.i(r110.f508501a, r100);     // Catch: Exception -> L33
            return;
        L38:
            return;
        L37:
            return;
        L33:
            tt5.a.d("ListAnalysis", "reportPageClick error");
        }

        @JvmStatic
        public final void L(q r110) {
            Intrinsics.checkNotNullParameter(r110, "clickParam");
            JSONObject r100 = new JSONObject();
            b(this, new g(r100, r110.f508522b, r110.f508523c, r110.f508526f, r110.getType(), r110.f508528h, r110.f508525e, DocumentType.FOLDER_NAME, r110.f508532l));
            r100.put("click", "list_item");
            if (TextUtils.isEmpty(r110.f508524d) == true) goto L5;
            r100.put("current_sub_view", r110.f508524d);
        L5:
            r100.put(BytedCertConstant.IntentKey.VIEW_TYPE, k(t3.f229771a));
            if (TextUtils.equals(r110.f508521a, "ccm_base_homepage_filelist_click") == false) goto L9;
            r100.put(PickerReporterConstants.KEY.TARGET, "ccm_bitable_content_page_view");
        L14:
            if (r110.getType() != sbb.e.f541295f.f541317b) goto L16;
            boolean r101 = true;
        L17:
            r100.put("is_folder", String.valueOf(r101));
            r100.put("is_shared_folder", String.valueOf(r110.f508529i));
            r100.put("is_subfolder", String.valueOf(r110.f508530j));
            r100.put("folder_lever", r110.f508531k);
            if (TextUtils.isEmpty(r110.f508533m) == true) goto L21;
            r100.put("container_env", r110.f508533m);
        L21:
            if (TextUtils.isEmpty(r110.f508534n) == true) goto L24;
            r100.put("base_hp_from", r110.f508534n);
        L24:
            if (TextUtils.isEmpty("hp_v2") == true) goto L26;
            r100.put("hp_version", "hp_v2");
        L26:
            com.bytedance.ee.bear.contract.d r102 = d();
            if (r102 == null) goto L30;
            r102.i(r110.f508521a, r100);
            return;
        L30:
            return;
        L16:
            r101 = false;
            goto L17
        L9:
            if (r110.getType() != sbb.e.f541295f.f541317b) goto L11;
            String r103 = "ccm_space_folder_view";
        L12:
            r100.put(PickerReporterConstants.KEY.TARGET, r103);
            goto L14
        L11:
            r103 = "ccm_docs_page_view";
            goto L12
        }

        @JvmStatic
        public final void O(r r110) {
            Intrinsics.checkNotNullParameter(r110, "clickParam");
            JSONObject r100 = new JSONObject();
            b(this, new g(r100, r110.f508536b, r110.f508537c, r110.f508539e, r110.getType(), r110.f508541g, r110.f508546l, DocumentType.FOLDER_NAME, null));
            if (t3.f229771a == false) goto L5;
            String r101 = "switch_to_grid_view";
        L6:
            r100.put("click", r101);
            r100.put(PickerReporterConstants.KEY.TARGET, "none");
            r100.put("switch_to", k(t3.f229771a));
            r100.put(BytedCertConstant.IntentKey.VIEW_TYPE, k(!t3.f229771a));
            if (TextUtils.isEmpty(r110.f508538d) == true) goto L9;
            r100.put("current_sub_view", r110.f508538d);
        L9:
            r100.put("is_folder", String.valueOf(r110.f508542h));
            r100.put("is_shared_folder", String.valueOf(r110.f508543i));
            r100.put("is_subfolder", String.valueOf(r110.f508544j));
            r100.put("folder_lever", r110.f508545k);
            if (TextUtils.isEmpty(r110.f508547m) == true) goto L13;
            r100.put("container_env", r110.f508547m);
        L13:
            if (TextUtils.isEmpty(r110.f508548n) == true) goto L15;
            r100.put("base_hp_from", r110.f508548n);
        L15:
            com.bytedance.ee.bear.contract.d r102 = d();
            if (r102 == null) goto L19;
            r102.i(r110.f508535a, r100);
            return;
        L19:
            return;
        L5:
            r101 = "switch_to_list_view";
            goto L6
        }

        @JvmStatic
        public final void S(v r110) {
            Intrinsics.checkNotNullParameter(r110, "param");
            JSONObject r100 = new JSONObject();
            b(this, new g(r100, r110.f508572a, r110.f508573b, r110.f508574c, r110.getType(), r110.f508576e, r110.f508577f, r110.f508578g, r110.f508579h));
            r100.put("is_shared_folder", r110.f508580i);
            r100.put(EventConstant.Key.MODULE, r110.f508572a);
            r100.put("click", r110.f508581j);
            r100.put(PickerReporterConstants.KEY.TARGET, r110.f508582k);
            r100.put("is_folder", r110.f508583l);
            r100.put("view_title", r110.f508584m);
            com.bytedance.ee.bear.contract.d r111 = d();
            if (r111 == null) goto L6;
            r111.i("ccm_space_delete_or_remove_click", r100);
            return;
        }

        @JvmStatic
        public static void B(com.bytedance.ee.bear.contract.d r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "analyticService");
            Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
            HashMap r102 = new HashMap();
            r102.put(EventConstant.Key.MODULE, r101);
            if (qc5.a.h() == false) goto L5;
            String r103 = "new_format";
        L6:
            r102.put("space_version", r103);
            r100.v("click_search", r102);
            return;
        L5:
            r103 = "original";
            goto L6
        }

        @JvmStatic
        public static void K(q r110, ce5.a r111) {
            Intrinsics.checkNotNullParameter(r110, "clickParam");
            Intrinsics.checkNotNullParameter(r111, "userComponentAbility");
            JSONObject r100 = new JSONObject();
            a(new g(r100, r110.f508522b, r110.f508523c, r110.f508526f, r110.getType(), r110.f508528h, r110.f508525e, DocumentType.FOLDER_NAME, r110.f508532l), r111);
            r100.put("click", "list_item");
            if (TextUtils.isEmpty(r110.f508524d) == true) goto L5;
            r100.put("current_sub_view", r110.f508524d);
        L5:
            r100.put(BytedCertConstant.IntentKey.VIEW_TYPE, k(t3.f229771a));
            if (TextUtils.equals(r110.f508521a, "ccm_base_homepage_filelist_click") == false) goto L9;
            r100.put(PickerReporterConstants.KEY.TARGET, "ccm_bitable_content_page_view");
        L14:
            if (r110.getType() != sbb.e.f541295f.f541317b) goto L16;
            boolean r112 = true;
        L17:
            r100.put("is_folder", String.valueOf(r112));
            r100.put("is_shared_folder", String.valueOf(r110.f508529i));
            r100.put("is_subfolder", String.valueOf(r110.f508530j));
            r100.put("folder_lever", r110.f508531k);
            if (TextUtils.isEmpty(r110.f508533m) == true) goto L21;
            r100.put("container_env", r110.f508533m);
        L21:
            if (TextUtils.isEmpty(r110.f508534n) == true) goto L23;
            r100.put("base_hp_from", r110.f508534n);
        L23:
            com.bytedance.ee.bear.contract.d r113 = d();
            if (r113 == null) goto L27;
            r113.i(r110.f508521a, r100);
            return;
        L27:
            return;
        L16:
            r112 = false;
            goto L17
        L9:
            if (r110.getType() != sbb.e.f541295f.f541317b) goto L11;
            String r114 = "ccm_space_folder_view";
        L12:
            r100.put(PickerReporterConstants.KEY.TARGET, r114);
            goto L14
        L11:
            r114 = "ccm_docs_page_view";
            goto L12
        }

        public static void a(g r100, ce5.a r101) {
            JSONObject r102 = r100.f508442a;
            String r103 = r100.f508444c;
            r102.put(EventConstant.Key.MODULE, r100.f508443b);
            if (TextUtils.isEmpty(r103) == false) goto L5;
            r103 = "null";
        L5:
            r102.put("sub_module", r103);
            if (TextUtils.isEmpty(r100.f508445d) == true) goto L8;
            r102.put("file_id", du5.b.g(r100.f508445d));
        L9:
            int r104 = r100.f508446e;
            if (r104 == sbb.e.f541294e.f541317b) goto L12;
            r102.put("file_type", sbb.e.c(r104));
        L14:
            if (TextUtils.isEmpty(r100.f508447f) == false) goto L16;
            String r105 = "null";
        L17:
            r102.put("sub_file_type", r105);
            if (TextUtils.isEmpty(r100.f508448g) == true) goto L20;
            r102.put("container_id", du5.b.g(r100.f508448g));
        L22:
            if (TextUtils.isEmpty(r100.f508449h) == true) goto L24;
            r102.put(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, r100.f508449h);
        L26:
            if (TextUtils.isEmpty(r100.f508450i) == true) goto L28;
            r102.put("shortcut_id", du5.b.g(r100.f508450i));
            r102.put("is_shortcut", "true");
        L30:
            if (qc5.a.g(r101) == false) goto L32;
            String r106 = "new_format";
        L33:
            r102.put("space_version", r106);
            r102.put("app_form", "null");
            return;
        L32:
            r106 = "original";
            goto L33
        L28:
            r102.put("shortcut_id", "null");
            r102.put("is_shortcut", "false");
            goto L30
        L24:
            r102.put(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, "null");
            goto L26
        L20:
            r102.put("container_id", "null");
            goto L22
        L16:
            r105 = r100.f508447f;
            goto L17
        L12:
            r102.put("file_type", "null");
            goto L14
        L8:
            r102.put("file_id", "null");
            goto L9
        }

        public static /* synthetic */ void b(a r100, g r101) {
            ce5.a r102 = new ce5.a();
            r100.getClass();
            a(r101, r102);
        }

        @JvmStatic
        public static void D(com.bytedance.ee.bear.contract.d r100, String r101, HashMap r102) {
            Intrinsics.checkNotNullParameter(r100, "analyticService");
            Intrinsics.checkNotNullParameter(r101, com.heytap.mcssdk.constant.b.f276361k);
            r100.v(r101, r102);
        }

        @JvmStatic
        public static void E(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter("ccm_base_homepage_filelist_view", "eventName");
            Intrinsics.checkNotNullParameter(r100, "currentSubView");
            JSONObject r103 = new JSONObject();
            r103.put("current_sub_view", r100);
            if (TextUtils.isEmpty(r101) == true) goto L6;
            r103.put("container_env", r101);
        L6:
            if (TextUtils.isEmpty(r102) == true) goto L8;
            r103.put("base_hp_from", r102);
        L8:
            com.bytedance.ee.bear.contract.d r104 = d();
            if (r104 == null) goto L12;
            r104.i("ccm_base_homepage_filelist_view", r103);
            return;
        }

        public static void p(String r100, String r101, Long r102) {
            JSONObject r103 = new JSONObject();
            r103.put("container_env", "larktab_bitable");
            r103.put("base_hp_from", r101);
            r103.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, "recommend");
            r103.put("stay_duration", r102);
            r103.put(EventConstant.Key.MODULE, "base_home");
            if (TextUtils.isEmpty("hp_v2") == true) goto L6;
            r103.put("hp_version", "hp_v2");
        L6:
            if (TextUtils.isEmpty(r100) == true) goto L8;
            r103.put("container_env", r100);
        L8:
            com.bytedance.ee.bear.contract.d r104 = d();
            if (r104 == null) goto L12;
            r104.i("ccm_base_homepage_feed_stay_duration_status", r103);
            return;
        }

        @JvmStatic
        public static void F(String r100, String r101, String r102, Boolean r103) {
            Intrinsics.checkNotNullParameter("ccm_base_homepage_filelist_view", "eventName");
            Intrinsics.checkNotNullParameter(r100, "currentSubView");
            JSONObject r104 = new JSONObject();
            r104.put("current_sub_view", r100);
            if (TextUtils.isEmpty(r101) == true) goto L6;
            r104.put("container_env", r101);
        L6:
            if (TextUtils.isEmpty(r102) == true) goto L9;
            r104.put("base_hp_from", r102);
        L9:
            if (TextUtils.isEmpty("hp_v2") == true) goto L12;
            r104.put("hp_version", "hp_v2");
        L12:
            if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L14;
            r104.put("is_full_screen", true);
        L15:
            com.bytedance.ee.bear.contract.d r105 = d();
            if (r105 == null) goto L19;
            r105.i("ccm_base_homepage_filelist_view", r104);
            return;
        L19:
            return;
        L14:
            r104.put("is_full_screen", false);
            goto L15
        }

        public static /* synthetic */ void Q(String r100, String r101, String r110, boolean r111) {
            f.f508440a.P(r100, r101, "hp_v2", r110, r111, null, null);
        }

        @JvmStatic
        public static void R(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "duplicateReason");
            Intrinsics.checkNotNullParameter(r101, "click");
            JSONObject r104 = new JSONObject();     // Catch: Exception -> L18
            r104.put("duplicate_reason", r100);     // Catch: Exception -> L18
            r104.put("click", r101);     // Catch: Exception -> L18
            r104.put(PickerReporterConstants.KEY.TARGET, "none");     // Catch: Exception -> L18
            String r105 = du5.b.g(r102);     // Catch: Exception -> L18
            if (r105 != null) goto L7;
            r105 = "";
        L7:
            r104.put("children_file_id", r105);     // Catch: Exception -> L18
            r104.put("children_page_token", "");     // Catch: Exception -> L18
            if (r103 != null) goto L10;
            r103 = "";
        L10:
            r104.put("children_file_type", r103);     // Catch: Exception -> L18
            if (qc5.a.h() == false) goto L13;
            String r106 = "new_format";
        L14:
            r104.put("space_version", r106);     // Catch: Exception -> L18
            tt5.a.b("ListAnalysis", "reportSpaceAddToFolderDuplicateClick, params = " + r104);     // Catch: Exception -> L18
            com.bytedance.ee.bear.contract.d r107 = d();     // Catch: Exception -> L18
            if (r107 == null) goto L23;
            r107.u("ccm_space_add_to_folder_duplicate_click", r104);     // Catch: Exception -> L18
            return;
        L23:
            return;
        L13:
            r106 = "original";
        L18:
            e = move-exception;
            tt5.a.d("ListAnalysis", "reportSpaceAddToFolderDuplicateClick error " + e.getMessage());
        }

        @JvmStatic
        public static void c(com.bytedance.ee.bear.contract.d r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "analyticService");
            Intrinsics.checkNotNullParameter(r101, "tag");
            Intrinsics.checkNotNullParameter(r102, "key");
            r100.j(r101, r102, r103);
        }

        @JvmStatic
        public static void z(String r100, String r101, String r102, String r103) {
            JSONObject r104 = new JSONObject();
            r104.put("container_env", "larktab_bitable");
            r104.put("base_hp_from", r100);
            r104.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r101);
            r104.put(EventConstant.Key.MODULE, "base_home");
            if (TextUtils.isEmpty(r102) == true) goto L6;
            r104.put("hp_version", r102);
        L6:
            if (TextUtils.isEmpty(r103) == true) goto L8;
            r104.put("container_env", r103);
        L8:
            com.bytedance.ee.bear.contract.d r105 = d();
            if (r105 == null) goto L12;
            r105.i("ccm_base_homepage_landing_view", r104);
            return;
        }

        @JvmStatic
        public final void A(String r110, String r111, String r112, String r113) {
            Intrinsics.checkNotNullParameter(r110, "event");
            JSONObject r100 = new JSONObject();
            b(this, new g(r100, "", "", "", sbb.e.f541294e.f541317b, "", "", "", null));
            if (r111 == null) goto L6;
            r100.put("current_sub_view", r111);
        L6:
            if (TextUtils.isEmpty(r112) == true) goto L9;
            r100.put("container_env", r112);
        L9:
            if (TextUtils.isEmpty(r113) == true) goto L11;
            r100.put("base_hp_from", r113);
        L11:
            r100.put(BytedCertConstant.IntentKey.VIEW_TYPE, k(t3.f229771a));
            com.bytedance.ee.bear.contract.d r101 = d();
            if (r101 == null) goto L15;
            r101.i(r110, r100);
            return;
        }

        @JvmStatic
        public final void M(String r100, String r110, String r111, String r112) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r110, EventConstant.Key.MODULE);
            Intrinsics.checkNotNullParameter(r111, "subModule");
            N(r100, r110, r111, r112, null, null);
        }

        @JvmStatic
        public final void l(p r210, String r211, String r212, String r213) {
            Intrinsics.checkNotNullParameter(r210, "param");
            tt5.a.h("ListAnalysis", "reportAINotePageClick()...");     // Catch: Exception -> L45
            JSONObject r100 = new JSONObject();     // Catch: Exception -> L45
            b(this, new g(r100, r210.f508502b, r210.f508503c, r210.f508507g, r210.getType(), r210.f508509i, r210.f508510j, DocumentType.FOLDER_NAME, r210.f508517q));     // Catch: Exception -> L49
            if (TextUtils.isEmpty(r210.f508504d) == true) goto L11;
            r100.put("click", r210.f508504d);     // Catch: Exception -> L49
        L11:
            if (TextUtils.isEmpty(r210.f508505e) == true) goto L13;
            r100.put(PickerReporterConstants.KEY.TARGET, r210.f508505e);     // Catch: Exception -> L49
        L13:
            r100.put(BytedCertConstant.IntentKey.VIEW_TYPE, k(t3.f229771a));     // Catch: Exception -> L49
            if (TextUtils.isEmpty(r210.f508506f) == true) goto L16;
            r100.put("current_sub_view", r210.f508506f);     // Catch: Exception -> L49
        L16:
            r100.put("is_folder", r210.f508511k);     // Catch: Exception -> L49
            r100.put("is_shared_folder", r210.f508512l);     // Catch: Exception -> L49
            r100.put("is_subfolder", r210.f508513m);     // Catch: Exception -> L49
            r100.put("folder_lever", r210.f508514n);     // Catch: Exception -> L49
            Boolean r101 = r210.f508515o;     // Catch: Exception -> L49
            if (r101 == null) goto L20;
            r100.put("is_blank", String.valueOf(r101));     // Catch: Exception -> L49
        L20:
            if (TextUtils.isEmpty(r210.f508516p) == true) goto L23;
            r100.put("location", r210.f508516p);     // Catch: Exception -> L49
        L23:
            if (TextUtils.isEmpty(r210.f508518r) == true) goto L26;
            r100.put("container_env", r210.f508518r);     // Catch: Exception -> L49
        L26:
            if (TextUtils.isEmpty(r210.f508519s) == true) goto L29;
            r100.put("base_hp_from", r210.f508519s);     // Catch: Exception -> L49
        L29:
            if (TextUtils.isEmpty(r210.f508520t) == true) goto L31;
            r100.put("view_from", r210.f508520t);     // Catch: Exception -> L49
        L31:
            if (r213 == null) goto L33;
            r100.put("source", r213);     // Catch: Exception -> L49
        L33:
            if (r211 == null) goto L36;
            r100.put(r211, r212);     // Catch: Exception -> L49
        L36:
            if (r210.f508501a == null) goto L58;
            String r102 = "ListAnalysis";
            tt5.a.h(r102, "reportAINotePageClick()...event = " + r210.f508501a + ", click = " + r210.f508504d + ", source = " + r213 + ", secondKey = " + r211 + ", secondValue = " + r212);     // Catch: Exception -> L48
            a r103 = f.f508440a;     // Catch: Exception -> L48
            com.bytedance.ee.bear.contract.d r104 = d();     // Catch: Exception -> L48
            if (r104 == null) goto L59;
            r104.i(r210.f508501a, r100);     // Catch: Exception -> L48
            return;
        L59:
            return;
        L46:
            tt5.a.d(r102, "reportAINotePageClick error");
            return;
        L58:
            return;
        L44:
            r102 = "ListAnalysis";
        L45:
            r102 = "ListAnalysis";
            goto L46
        }

        @JvmStatic
        public final void m(String r110, String r111, String r112, String r113) {
            JSONObject r114 = new JSONObject();
            b(this, new g(r114, "", "", "", sbb.e.f541294e.f541317b, "", "", "", null));
            r114.put("click", "notice_card_click");
            if (r110 == null) goto L5;
            r114.put("notice_id", r110);
        L5:
            if (r111 == null) goto L7;
            r114.put("file_id", du5.b.g(r111));
        L7:
            r114.put("current_sub_view", r112);
            r114.put("notice_card_type", r113);
            r114.put("container_env", "larktab_bitable");
            r114.put(BytedCertConstant.IntentKey.VIEW_TYPE, k(t3.f229771a));
            com.bytedance.ee.bear.contract.d r100 = d();
            if (r100 == null) goto L11;
            r100.i("ccm_base_homepage_activity_click", r114);
            return;
        }

        @JvmStatic
        public static void T(com.bytedance.ee.bear.contract.d r100, String r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "analyticService");
            Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
            JSONObject r105 = new JSONObject();
            r105.put(EventConstant.Key.MODULE, r101);
            if (TextUtils.isEmpty(r102) == true) goto L6;
            r105.put("sub_module", r102);
        L6:
            if (TextUtils.isEmpty(r103) == true) goto L9;
            r105.put("src_module", r103);
        L9:
            if (TextUtils.isEmpty(r104) == true) goto L12;
            r105.put("src_folder_id", du5.b.g(r104));
        L12:
            if (qc5.a.h() == false) goto L14;
            String r106 = "new_format";
        L15:
            r105.put("space_version", r106);
            r100.a("enter_explorer_module", r105);
            return;
        L14:
            r106 = "original";
            goto L15
        }

        @JvmStatic
        public final void G(String r110, String r111, String r112, String r113, String r210, String r211) {
            Intrinsics.checkNotNullParameter(r110, EventConstant.Key.MODULE);
            Intrinsics.checkNotNullParameter(r111, "subModule");
            Intrinsics.checkNotNullParameter(r112, "currentSubView");
            Intrinsics.checkNotNullParameter(r113, "event");
            O(new r(r113, r110, r111, r112, "", sbb.e.f541294e.f541317b, false, false, false, 0, "", r210, r211));
        }

        @JvmStatic
        public final void N(String r110, String r111, String r112, String r113, String r114, String r115) {
            Intrinsics.checkNotNullParameter(r110, "event");
            Intrinsics.checkNotNullParameter(r111, EventConstant.Key.MODULE);
            Intrinsics.checkNotNullParameter(r112, "subModule");
            JSONObject r100 = new JSONObject();
            b(this, new g(r100, r111, r112, "", sbb.e.f541294e.f541317b, "", "", "", null));
            if (TextUtils.isEmpty(r113) == true) goto L6;
            r100.put("current_sub_view", r113);
        L6:
            if (TextUtils.isEmpty(r114) == true) goto L9;
            r100.put("container_env", r114);
        L9:
            if (TextUtils.isEmpty(r115) == true) goto L12;
            r100.put("base_hp_from", r115);
        L12:
            if (TextUtils.equals(r110, "ccm_space_home_page_view") == false) goto L14;
        L15:
            r100.put("is_ai_notes", String.valueOf(qc5.a.a()));
        L16:
            r100.put(BytedCertConstant.IntentKey.VIEW_TYPE, k(t3.f229771a));
            com.bytedance.ee.bear.contract.d r101 = d();
            if (r101 == null) goto L20;
            r101.i(r110, r100);
            return;
        L20:
            return;
        L14:
            if (TextUtils.equals(r110, "ccm_space_sidebar_view") == false) goto L16;
            goto L15
        }

        @JvmStatic
        public final void n(String r110, String r111, String r112, Integer r210, String r211, String r212) {
            Intrinsics.checkNotNullParameter("ccm_base_homepage_banner_click", "event");
            Intrinsics.checkNotNullParameter(r110, "click");
            JSONObject r113 = new JSONObject();     // Catch: Exception -> L24
            b(this, new g(r113, "", "", "", sbb.e.f541294e.f541317b, "", "", "", null));     // Catch: Exception -> L22
            r113.put("click", r110);     // Catch: Exception -> L22
            if (TextUtils.isEmpty(r111) == true) goto L8;
            r113.put("template_token", UriProtector.parse(r111).getLastPathSegment());     // Catch: Exception -> L22
        L8:
            if (r112 == null) goto L10;
            r113.put("template_name", r112);     // Catch: Exception -> L22
        L10:
            if (r210 == null) goto L13;
            r113.put("position_index", r210.intValue() + 1);     // Catch: Exception -> L22
        L13:
            if (TextUtils.isEmpty(r211) == true) goto L16;
            r113.put("container_env", r211);     // Catch: Exception -> L22
        L16:
            if (TextUtils.isEmpty(r212) == true) goto L18;
            r113.put("base_hp_from", r212);     // Catch: Exception -> L22
        L18:
            r113.put(BytedCertConstant.IntentKey.VIEW_TYPE, k(t3.f229771a));     // Catch: Exception -> L22
            com.bytedance.ee.bear.contract.d r100 = d();     // Catch: Exception -> L22
            if (r100 == null) goto L32;
            r100.i("ccm_base_homepage_banner_click", r113);     // Catch: Exception -> L22
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
        public final void P(String r110, String r111, String r112, String r113, boolean r114, String r115, Boolean r210) {
            Intrinsics.checkNotNullParameter("ccm_base_homepage_landing_view", "event");
            Intrinsics.checkNotNullParameter("base_home", EventConstant.Key.MODULE);
            Intrinsics.checkNotNullParameter("", "subModule");
            JSONObject r116 = new JSONObject();
            b(this, new g(r116, "base_home", "", "", sbb.e.f541294e.f541317b, "", "", "", null));
            if (TextUtils.isEmpty("") == true) goto L6;
            r116.put("current_sub_view", "");
        L6:
            if (TextUtils.isEmpty(r110) == true) goto L9;
            r116.put("container_env", r110);
        L9:
            if (TextUtils.isEmpty(r111) == true) goto L12;
            r116.put("base_hp_from", r111);
        L12:
            if (TextUtils.isEmpty(r112) == true) goto L15;
            r116.put("hp_version", r112);
        L15:
            if (TextUtils.isEmpty(r113) == true) goto L17;
            r116.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r113);
        L17:
            r116.put("has_feed", r114);
            if (TextUtils.isEmpty(r115) == true) goto L20;
            r116.put("page_type", r115);
        L20:
            if (r210 == null) goto L22;
            r116.put("has_notice_dot", r210.booleanValue());
        L22:
            r116.put(BytedCertConstant.IntentKey.VIEW_TYPE, k(t3.f229771a));
            com.bytedance.ee.bear.contract.d r100 = d();
            if (r100 == null) goto L26;
            r100.i("ccm_base_homepage_landing_view", r116);
            return;
        }

        @JvmStatic
        public final void q(String r110, String r111, String r210, String r211, String r212, String r213, String r214, String r215) {
            Intrinsics.checkNotNullParameter(r110, EventConstant.Key.MODULE);
            Intrinsics.checkNotNullParameter(r111, "subModule");
            Intrinsics.checkNotNullParameter(r210, "click");
            Intrinsics.checkNotNullParameter(r211, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r213, "currentSubView");
            JSONObject r112 = new JSONObject();
            b(this, new g(r112, r110, r111, r212, sbb.e.f541298i.f541317b, "", "", DocumentType.FOLDER_NAME, null));
            if (TextUtils.isEmpty(r212) == true) goto L5;
            r112.put("target_file_id", du5.b.g(r212));
        L7:
            if (TextUtils.isEmpty(r214) == true) goto L10;
            r112.put("container_env", r214);
        L10:
            if (TextUtils.isEmpty(r215) == true) goto L12;
            r112.put("base_hp_from", r215);
        L12:
            r112.put("click", r210);
            r112.put(PickerReporterConstants.KEY.TARGET, r211);
            r112.put(BytedCertConstant.IntentKey.VIEW_TYPE, k(t3.f229771a));
            if (TextUtils.isEmpty(r213) == true) goto L15;
            r112.put("current_sub_view", r213);
        L15:
            r112.put("is_folder", false);
            r112.put("is_shared_folder", false);
            r112.put("is_subfolder", false);
            r112.put("folder_lever", 0);
            com.bytedance.ee.bear.contract.d r100 = d();
            if (r100 == null) goto L19;
            r100.i("ccm_base_homepage_landing_click", r112);
            return;
        L19:
            return;
        L5:
            r112.put("target_file_id", "null");
            goto L7
        }

        @JvmStatic
        public final void r(String r110, String r210, String r211, String r212, String r213, String r214, String r215, boolean r216) {
            Intrinsics.checkNotNullParameter(r110, EventConstant.Key.MODULE);
            Intrinsics.checkNotNullParameter("", "subModule");
            Intrinsics.checkNotNullParameter(r210, "click");
            Intrinsics.checkNotNullParameter(r211, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter("", "currentSubView");
            JSONObject r111 = new JSONObject();
            b(this, new g(r111, r110, "", r212, sbb.e.f541298i.f541317b, "", "", DocumentType.FOLDER_NAME, null));
            if (TextUtils.isEmpty(r212) == true) goto L5;
            r111.put("target_file_id", du5.b.g(r212));
        L7:
            if (TextUtils.isEmpty(r213) == true) goto L10;
            r111.put("container_env", r213);
        L10:
            if (TextUtils.isEmpty(r214) == true) goto L13;
            r111.put("base_hp_from", r214);
        L13:
            if (TextUtils.isEmpty(r215) == true) goto L15;
            r111.put("hp_version", r215);
        L15:
            r111.put("has_feed", r216);
            r111.put("click", r210);
            r111.put(PickerReporterConstants.KEY.TARGET, r211);
            r111.put(BytedCertConstant.IntentKey.VIEW_TYPE, k(t3.f229771a));
            if (TextUtils.isEmpty("") == true) goto L18;
            r111.put("current_sub_view", "");
        L18:
            r111.put("is_folder", false);
            r111.put("is_shared_folder", false);
            r111.put("is_subfolder", false);
            r111.put("folder_lever", 0);
            com.bytedance.ee.bear.contract.d r100 = d();
            if (r100 == null) goto L22;
            r100.i("ccm_base_homepage_landing_click", r111);
            return;
        L22:
            return;
        L5:
            r111.put("target_file_id", "null");
            goto L7
        }

        public final JSONObject e(String r110, String r111, String r112, String r113, Integer r114, Integer r115, Integer r116, String r210, Boolean r211) {
            boolean r100 = false;
            if (r110 != null) goto L5;
        L10:
            if (r100 == false) goto L12;
            String r101 = UriProtector.parse(r110).getLastPathSegment();
        L13:
            String r102 = r101;
            JSONObject r103 = new JSONObject();
            b(this, new g(r103, "base_home", "homepage_feed", r102, g(r110), null, null, null, null));
            r103.put("container_env", "larktab_bitable");
            r103.put("base_hp_from", "larktab");
            r103.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, "recommend");
            r103.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, r111);
            r103.put("content_name", r112);
            r103.put("request_id", r113);
            r103.put("request_rank_first", r114);
            r103.put("all_position_index", r115);
            r103.put("position_index", r116);
            r103.put("is_cover_load_success", r210);
            r103.put("is_refresh", r211);
            Date r104 = new Date();
            r103.put("happen_date", f.f508441b.format(r104));
            return r103;
        L12:
            r101 = "";
            goto L13
        L5:
            if (r110.length() <= 0) goto L7;
            boolean r105 = true;
        L8:
            if (r105 != true) goto L10;
            r100 = true;
            goto L10
        L7:
            r105 = false;
            goto L8
        }

        @JvmStatic
        public final void w(String r100, String r101, String r102, String r103, Integer r104, Integer r105, Integer r106, String r107, Boolean r110, Map r111) {
            com.bytedance.ee.bear.contract.d r108 = d();
            if (r108 == null) goto L13;
            JSONObject r109 = e(r100, r101, r102, r103, r104, r105, r106, r107, r110);
            if (r111 == null) goto L10;
            Iterator r112 = r111.entrySet().iterator();
        L8:
            if (r112.hasNext() == false) goto L10;
            Map.Entry r113 = (Map.Entry) r112.next();
            r109.put((String) r113.getKey(), r113.getValue());
        L10:
            Unit r114 = Unit.INSTANCE;
            r108.i("ccm_base_homepage_feed_content_view", r109);
            return;
        }

        public final JSONObject f(String r110, String r111, String r112, String r113, String r114, String r115, Integer r116, Integer r210, Integer r211, String r212, Boolean r213) {
            boolean r100 = false;
            if (r112 != null) goto L5;
        L10:
            if (r100 == false) goto L12;
            String r101 = UriProtector.parse(r112).getLastPathSegment();
        L13:
            String r102 = r101;
            JSONObject r103 = new JSONObject();
            b(this, new g(r103, "base_home", "homepage_feed", r102, g(r112), null, null, null, null));
            r103.put("container_env", r110);
            r103.put("base_hp_from", r111);
            r103.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, "recommend");
            r103.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, r113);
            r103.put("content_name", r114);
            r103.put("request_id", r115);
            r103.put("request_rank_first", r116);
            r103.put("all_position_index", r210);
            r103.put("position_index", r211);
            r103.put("is_cover_load_success", r212);
            r103.put("is_refresh", r213);
            if (TextUtils.isEmpty("hp_v2") == true) goto L16;
            r103.put("hp_version", "hp_v2");
        L16:
            Date r104 = new Date();
            r103.put("happen_date", f.f508441b.format(r104));
            return r103;
        L12:
            r101 = "";
            goto L13
        L5:
            if (r112.length() <= 0) goto L7;
            boolean r105 = true;
        L8:
            if (r105 != true) goto L10;
            r100 = true;
            goto L10
        L7:
            r105 = false;
            goto L8
        }

        @JvmStatic
        public final void s(String r100, String r101, String r102, String r103, Integer r104, Integer r105, Integer r106, String r107, Boolean r108, Long r110, Map r111) {
            JSONObject r109 = e(r100, r101, r102, r103, r104, r105, r106, r107, r108);
            if (r111 == null) goto L8;
            Iterator r112 = r111.entrySet().iterator();
        L6:
            if (r112.hasNext() == false) goto L8;
            Map.Entry r113 = (Map.Entry) r112.next();
            r109.put((String) r113.getKey(), r113.getValue());
        L8:
            r109.put(PickerReporterConstants.KEY.TARGET, "ccm_docs_page_view");
            r109.put("show_duration", r110);
            com.bytedance.ee.bear.contract.d r114 = d();
            if (r114 == null) goto L13;
            r114.i("ccm_base_homepage_feed_content_click", r109);
            return;
        }

        @JvmStatic
        public final void u(String r100, String r101, String r102, String r103, Integer r104, Integer r105, Integer r106, String r107, Boolean r108, Long r110, Map r111) {
            JSONObject r109 = e(r100, r101, r102, r103, r104, r105, r106, r107, r108);
            if (r111 == null) goto L8;
            Iterator r112 = r111.entrySet().iterator();
        L6:
            if (r112.hasNext() == false) goto L8;
            Map.Entry r113 = (Map.Entry) r112.next();
            r109.put((String) r113.getKey(), r113.getValue());
        L8:
            r109.put("show_duration", r110);
            com.bytedance.ee.bear.contract.d r114 = d();
            if (r114 == null) goto L13;
            r114.i("ccm_base_homepage_feed_content_effect_view", r109);
            return;
        }

        @JvmStatic
        public final void x(String r100, String r101, String r102, String r103, String r104, String r105, Integer r106, Integer r107, Integer r110, String r111, Boolean r112, Map r113) {
            com.bytedance.ee.bear.contract.d r108 = d();
            if (r108 == null) goto L13;
            JSONObject r109 = f(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112);
            if (r113 == null) goto L10;
            Iterator r114 = r113.entrySet().iterator();
        L8:
            if (r114.hasNext() == false) goto L10;
            Map.Entry r115 = (Map.Entry) r114.next();
            r109.put((String) r115.getKey(), r115.getValue());
        L10:
            Unit r116 = Unit.INSTANCE;
            r108.i("ccm_base_homepage_feed_content_view", r109);
            return;
        }

        @JvmStatic
        public final void t(String r100, String r101, String r102, String r103, String r104, String r105, Integer r106, Integer r107, Integer r108, String r110, Boolean r111, Long r112, Map r113) {
            JSONObject r109 = f(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111);
            if (r113 == null) goto L8;
            Iterator r114 = r113.entrySet().iterator();
        L6:
            if (r114.hasNext() == false) goto L8;
            Map.Entry r115 = (Map.Entry) r114.next();
            r109.put((String) r115.getKey(), r115.getValue());
        L8:
            r109.put(PickerReporterConstants.KEY.TARGET, "ccm_docs_page_view");
            r109.put("show_duration", r112);
            com.bytedance.ee.bear.contract.d r116 = d();
            if (r116 == null) goto L13;
            r116.i("ccm_base_homepage_feed_content_click", r109);
            return;
        }

        @JvmStatic
        public final void v(String r100, String r101, String r102, String r103, String r104, String r105, Integer r106, Integer r107, Integer r108, String r110, Boolean r111, Long r112, Map r113) {
            JSONObject r109 = f(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111);
            if (r113 == null) goto L8;
            Iterator r114 = r113.entrySet().iterator();
        L6:
            if (r114.hasNext() == false) goto L8;
            Map.Entry r115 = (Map.Entry) r114.next();
            r109.put((String) r115.getKey(), r115.getValue());
        L8:
            r109.put("show_duration", r112);
            com.bytedance.ee.bear.contract.d r116 = d();
            if (r116 == null) goto L13;
            r116.i("ccm_base_homepage_feed_content_effect_view", r109);
            return;
        }
    }

    @JvmStatic
    public static final void r(com.bytedance.ee.bear.contract.d r100, String r101, String r102, String r103, String r104) {
        a.T(r100, r101, r102, r103, r104);
    }

    static {
        f508440a = new a();
        f508441b = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    }

    @JvmStatic
    public static final void a(lc5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        r100.f508430a.h(r100.f508433d);
        a.c(r100.f508430a, r100.f508433d, "source", r100.f508431b);
        a.c(r100.f508430a, r100.f508433d, EventConstant.Key.MODULE, r100.f508432c);
        a.c(r100.f508430a, r100.f508433d, "file_type", sbb.e.c(r100.f508434e.getType()));
        if (r100.f508434e.getType() != sbb.e.f541301l.f541317b) goto L13;
        String r101 = r100.f508434e.F;
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L13;
        a.c(r100.f508430a, r100.f508433d, "sub_type", r100.f508434e.F);
        goto L13
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
    L13:
        a.c(r100.f508430a, r100.f508433d, "file_id", du5.b.g(r100.f508434e.f227873d));
        com.bytedance.ee.bear.contract.d r103 = r100.f508430a;
        String r104 = r100.f508433d;
        String r105 = r100.f508434e.f227905x1;
        if (r105 != null) goto L16;
        r105 = "";
    L16:
        a.c(r103, r104, "appid", r105);
    }

    @JvmStatic
    public static final void b(h r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        HashMap r101 = new HashMap();
        if (TextUtils.isEmpty(r100.f508453c) == false) goto L5;
    L9:
        r101.put("file_type", sbb.e.c(r100.f508454d.getType()));
        if (r100.f508454d.getType() != sbb.e.f541301l.f541317b) goto L20;
        String r102 = r100.f508454d.F;
        if (r102 != null) goto L14;
    L17:
        boolean r103 = true;
    L18:
        if (r103 == true) goto L20;
        r101.put("sub_type", r100.f508454d.F);
        goto L20
    L14:
        if (r102.length() == 0) goto L17;
        r103 = false;
    L20:
        r101.put("file_id", du5.b.g(r100.f508454d.f227873d));
        r101.put("action", "add_offline");
        r101.put("status_name", r100.f508455e);
        if (qc5.a.h() == false) goto L23;
        String r104 = "new_format";
    L24:
        r101.put("space_version", r104);
        r100.f508451a.v("client_content_management", r101);
        return;
    L23:
        r104 = "original";
        goto L24
    L5:
        if (r100.f508452b == false) goto L7;
        String r105 = "grid_more";
    L8:
        r101.put("source", r105);
        r101.put(EventConstant.Key.MODULE, r100.f508453c);
        goto L9
    L7:
        r105 = "left_slide";
        goto L8
    }

    @JvmStatic
    public static final void e(i r110) {
        a r100 = f508440a;
        Intrinsics.checkNotNullParameter(r110, "clickParam");
        JSONObject r101 = new JSONObject();
        a.b(r100, new g(r101, r110.f508456a, r110.f508457b, "", sbb.e.f541295f.f541317b, "", r110.f508460e, DocumentType.FOLDER_NAME, null));
        r101.put("is_shared_folder", "false");
        r101.put("click", r110.f508458c);
        if (TextUtils.isEmpty(r110.f508459d) == true) goto L5;
        r101.put(PickerReporterConstants.KEY.TARGET, r110.f508459d);
    L5:
        com.bytedance.ee.bear.contract.d r111 = a.d();
        if (r111 == null) goto L9;
        r111.i("ccm_space_create_new_folder_click", r101);
        return;
    }

    @JvmStatic
    public static final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "objToken");
        Flowable r101 = null;
        NetService r102 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        Intrinsics.checkNotNullParameter(r100, "objToken");
        NetService.f r103 = new NetService.f("/space/api/explorer/recent/report/");
        r103.f216906c = 1;
        ((HashMap) r103.f216907d).put("obj_token", r100);
        Map<String, String> r104 = r103.f216907d;
        HashMap r105 = (HashMap) r104;
        r105.put("obj_type", String.valueOf(0));
        if (r102 == null) goto L7;
        NetService.d r106 = r102.Vc(new ax4.f());
        if (r106 == null) goto L7;
        r101 = r106.a(r103);
    L7:
        if (r101 == null) goto L10;
        r101.subscribe(b.f508435a, c.f508436a);
        return;
    }

    @JvmStatic
    public static final void j(p r100) {
        a r101 = f508440a;
        Intrinsics.checkNotNullParameter(r100, "param");
        r101.I(r100);
    }

    @JvmStatic
    public static final void l(n r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        HashMap r101 = new HashMap();     // Catch: Exception -> L43
        r101.put("source", r100.f508494f);     // Catch: Exception -> L43
        r101.put(EventConstant.Key.MODULE, r100.f508493e);     // Catch: Exception -> L43
        r101.put("action", r100.f508491c);     // Catch: Exception -> L43
        r101.put("file_type", sbb.e.c(r100.f508492d.getType()));     // Catch: Exception -> L43
        boolean r102 = true;
        if (r100.f508492d.getType() != sbb.e.f541301l.f541317b) goto L14;
        String r103 = r100.f508492d.F;     // Catch: Exception -> L43
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L14;
        r101.put("sub_file_type", r100.f508492d.F);     // Catch: Exception -> L43
        goto L14
    L8:
        if (r103.length() == 0) goto L11;
        r104 = false;
    L14:
        r101.put("file_id", du5.b.g(r100.f508492d.f227873d));     // Catch: Exception -> L43
        String r105 = r100.f508492d.f227905x1;     // Catch: Exception -> L43
        String r106 = "";
        if (r105 != null) goto L18;
        r105 = "";
    L18:
        r101.put("appid", r105);     // Catch: Exception -> L43
        if (ArraysKt.contains(new String[]{"share", "delete", "more", "remove_complete"}, r100.f508491c) == false) goto L38;
        String r107 = r100.f508492d.f227875f;     // Catch: Exception -> L43
        if (r107 != null) goto L23;
    L26:
        boolean r108 = true;
    L27:
        if (r108 == true) goto L30;
        r106 = du5.b.g(r100.f508492d.f227875f);     // Catch: Exception -> L43
    L30:
        r101.put("file_tenant_id", r106);     // Catch: Exception -> L43
        AccountService$Account r109 = r100.f508490b;     // Catch: Exception -> L43
        if (r109 == null) goto L38;
        if (Intrinsics.areEqual(r100.f508492d.f227875f, r109.tenantId) == false) goto L36;
        r102 = false;
    L36:
        r101.put("file_is_cross_tenant", String.valueOf(r102));     // Catch: Exception -> L43
        goto L38
    L23:
        if (r107.length() == 0) goto L26;
        r108 = false;
    L38:
        if (qc5.a.h() == false) goto L40;
        String r110 = "new_format";
    L41:
        r101.put("space_version", r110);     // Catch: Exception -> L43
        r100.f508489a.v("client_content_management", r101);     // Catch: Exception -> L43
        return;
    L40:
        r110 = "original";
    L43:
        e = move-exception;
        tt5.a.e("ListAnalysis", "reportLeftSlideClickEvent: error", e, false);
    }

    @JvmStatic
    public static final void n(s r100) {
        Intrinsics.checkNotNullParameter(r100, "removeParam");
        HashMap r101 = new HashMap();
        if (TextUtils.isEmpty(r100.f508551c) == false) goto L5;
    L9:
        r101.put("file_type", sbb.e.c(r100.getType()));
        r101.put("file_id", du5.b.g(r100.f508552d));
        r101.put("action", "remove_offline");
        r101.put("status_name", r100.f508554f);
        if (qc5.a.h() == false) goto L12;
        String r102 = "new_format";
    L13:
        r101.put("space_version", r102);
        r100.f508549a.v("client_content_management", r101);
        return;
    L12:
        r102 = "original";
        goto L13
    L5:
        if (r100.f508550b == false) goto L7;
        String r103 = "grid_more";
    L8:
        r101.put("source", r103);
        r101.put(EventConstant.Key.MODULE, r100.f508551c);
        goto L9
    L7:
        r103 = "left_slide";
        goto L8
    }

    @JvmStatic
    public static final void o(u r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        HashMap r101 = new HashMap();
        r101.put("source", r100.f508567b);
        r101.put(EventConstant.Key.MODULE, r100.f508568c);
        if (r100.f508569d == false) goto L5;
        String r102 = "succeed";
    L6:
        r101.put("status_name", r102);
        if (r100.f508570e == false) goto L9;
        String r103 = "set_folder_display";
    L10:
        r101.put("action", r103);
        r101.put("file_type", sbb.e.f541295f.getType());
        r101.put("file_id", du5.b.g(r100.f508571f));
        if (qc5.a.h() == false) goto L13;
        String r104 = "new_format";
    L14:
        r101.put("space_version", r104);
        a.D(r100.f508566a, "client_content_management", r101);
        return;
    L13:
        r104 = "original";
        goto L14
    L9:
        r103 = "set_folder_hidden";
        goto L10
    L5:
        r102 = "failed";
        goto L6
    }

    @JvmStatic
    public static final void c(com.bytedance.ee.bear.contract.d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "analyticService");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        HashMap r102 = new HashMap();
        r102.put(EventConstant.Key.MODULE, r101);
        if (qc5.a.h() == false) goto L5;
        String r103 = "new_format";
    L6:
        r102.put("space_version", r103);
        a.D(r100, "click_filter_board", r102);
        return;
    L5:
        r103 = "original";
        goto L6
    }

    @JvmStatic
    public static final void f(com.bytedance.ee.bear.contract.d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "analyticService");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        JSONObject r102 = new JSONObject();
        r102.put(EventConstant.Key.MODULE, r101);
        if (qc5.a.h() == false) goto L5;
        String r103 = "new_format";
    L6:
        r102.put("space_version", r103);
        r100.a("launch_web", r102);
        return;
    L5:
        r103 = "original";
        goto L6
    }

    @JvmStatic
    public static final void k(com.bytedance.ee.bear.contract.d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "analyticService");
        Intrinsics.checkNotNullParameter(r101, "tag");
        String r102 = r100.e(r101, ILoadStallMonitor.START_TIME);
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L16;
        float r104 = SystemClock.uptimeMillis() - yu5.c.g(r102, 0);
        zw4.a r105 = com.bytedance.ee.bear.docshost.m.f218489a;
        if (r105 == null) goto L13;
        r105.a(r101, r104);
    L14:
        r100.c(r101);
        return;
    L13:
        tt5.a.k("AbsMonitorServiceImp", "monitorSLA: monitor agent is null");
        goto L14
    L16:
        return;
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r103 = false;
        goto L9
    }

    @JvmStatic
    public static final void q(com.bytedance.ee.bear.contract.d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "analyticService");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        a.T(r100, r101, null, null, null);
    }

    @JvmStatic
    public static final void d(com.bytedance.ee.bear.contract.d r100, String r101, Document r102) {
        Intrinsics.checkNotNullParameter(r100, "analyticService");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        HashMap r103 = new HashMap();
        r103.put(EventConstant.Key.MODULE, r101);
        r103.put("file_type", sbb.e.c(r102.getType()));
        String r104 = r102.f227905x1;
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        r103.put("appid", r104);
        if (qc5.a.h() == false) goto L8;
        String r105 = "new_format";
    L9:
        r103.put("space_version", r105);
        a.D(r100, "click_grid_more", r103);
        return;
    L8:
        r105 = "original";
        goto L9
    }

    @JvmStatic
    public static final void g(String r110, String r111, String r112) {
        a r100 = f508440a;
        Intrinsics.checkNotNullParameter(r110, EventConstant.Key.MODULE);
        JSONObject r101 = new JSONObject();
        a.b(r100, new g(r101, r110, r111, "", sbb.e.f541301l.f541317b, "", r112, DocumentType.FOLDER_NAME, null));
        com.bytedance.ee.bear.contract.d r113 = a.d();
        if (r113 == null) goto L6;
        r113.i("ccm_space_file_choose_view", r101);
        return;
    }

    @JvmStatic
    public static final void i(String r110, String r111, String r112) {
        a r100 = f508440a;
        Intrinsics.checkNotNullParameter(r110, EventConstant.Key.MODULE);
        JSONObject r101 = new JSONObject();
        a.b(r100, new g(r101, r110, r111, r112, sbb.e.f541295f.f541317b, "", "", "", null));
        com.bytedance.ee.bear.contract.d r113 = a.d();
        if (r113 == null) goto L6;
        r113.i("ccm_space_header_filter_view", r101);
        return;
    }

    @JvmStatic
    public static final void m(boolean r100, Document r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "document");
        Intrinsics.checkNotNullParameter(r102, "from");
        if (r100 == true) goto L6;
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.a()).subscribe(new d(r101, r102), e.f508439a);
        return;
    }

    @JvmStatic
    public static final void p(String r110, String r111, String r112, boolean r113, String r114, String r115) {
        a r100 = f508440a;
        Intrinsics.checkNotNullParameter(r110, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r111, "subModule");
        JSONObject r116 = new JSONObject();     // Catch: Throwable -> L11
        a.b(r100, new g(r116, r110, r111, r112, sbb.e.f541295f.f541317b, "", r112, DocumentType.FOLDER_NAME, null));     // Catch: Throwable -> L11
        r116.put(BytedCertConstant.IntentKey.VIEW_TYPE, a.k(t3.f229771a));     // Catch: Throwable -> L11
        r116.put("is_shared_folder", String.valueOf(r113));     // Catch: Throwable -> L11
        if (((gpb.a) ApiUtils.getApi(gpb.a.class)).isFeishuBrand() == false) goto L6;
        String r101 = "feishu";
    L7:
        r116.put("owner_id", du5.b.g(r114));     // Catch: Throwable -> L11
        r116.put("owner_tenant_id", du5.b.g(r115));     // Catch: Throwable -> L11
        r116.put("user_brand", r101);     // Catch: Throwable -> L11
        r116.put("is_block", false);     // Catch: Throwable -> L11
        com.bytedance.ee.bear.contract.d r102 = a.d();     // Catch: Throwable -> L11
        if (r102 == null) goto L16;
        r102.i("ccm_space_folder_view", r116);     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L6:
        r101 = "lark";
    L11:
        th = move-exception;
        tt5.a.f("ListAnalysis", th, false);
    }
}
