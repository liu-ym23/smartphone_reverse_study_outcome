package com.bytedance.ee.bear.drive.report;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ee.bear.bizwidget.sharepermissiondialog.BottomPopupData;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.utils.ApiUtils;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import t85.e;
import t85.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public long a;
    public int b;
    public Disposable c;
    public final d d;
    public final b0 e;
    public final h0 f;
    public final t85.c g;
    public h h;

    public class a implements Consumer<Long> {
        public final /* synthetic */ b a;
        public final /* synthetic */ c b;

        public final void accept(Object r6) throws Exception {
            Long r7 = (Long) r6;
            c r8 = this.b;
            b r0 = this.a;
            String r1 = r0.a;
            String r2 = r0.b;
            r8.b += 60;
            HashMap<String, Object> r3 = new HashMap();
            r3.put("session_duration", Integer.valueOf(r8.b));
            r3.put("in_page", String.valueOf(true));
            r3.put("session_id", null);
            r8.z(r3, r1, r2);
            r8.d.v("launch_duration", r3);
        }

        public a(c r1, b r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static class b {
        public String a;
        public String b;
        public long c;

        public b() {
            this.a = "";
            this.b = "";
        }
    }

    public final boolean j() {
        h r0 = this.h;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a == false) goto L7;
        return true;
    }

    public c(t85.c r2) {
        this.b = -60;
        this.d = (d) org.koin.java.a.a(d.class);
        this.e = (b0) org.koin.java.a.a(b0.class);
        this.f = (h0) org.koin.java.a.a(h0.class);
        this.g = r2;
    }

    public static void d(HashMap r2) {
        r2.put("container_id", "none");
        r2.put("container_type", "none");
        r2.put("shortcut_id", "none");
        r2.put("is_shortcut", "false");
    }

    public static b e(w75.a r3) {
        b r0 = new b();
        if (r3 != null) goto L5;
    L7:
        return r0;
    L5:
        if (r3.c() == null) goto L7;
        r0.a = r3.c().a;
        r0.b = r3.c().k;
        r0.c = r3.c().c;
        goto L7
    }

    public static String k(e r2) {
        if (r2 != null) goto L5;
        return "false";
    L5:
        Bundle r3 = r2.c;
        if (r3 != null) goto L9;
        return "false";
    L9:
        if (TextUtils.equals(r3.getString("is_degraded"), "true") == true) goto L11;
        return "false";
    L11:
        return "true";
    }

    public final void B(ImportFileEntity r7) {
        HashMap<String, Object> r0 = new HashMap();
        String r1 = r7.a;
        String r2 = r7.b;
        if (r2 == null) goto L5;
        String r3 = com.bytedance.ee.util.io.a.c(r2);
    L6:
        r0.put(JSEventListener.ACTION, "import");
        HashMap<String, String> r8 = r7.c;
        if (r8.containsKey("is_grid") == false) goto L15;
        if (r8.get("is_grid") == null) goto L15;
        if (Boolean.parseBoolean(r8.get("is_grid")) == false) goto L13;
        r0.put("source", "grid_more");
        goto L15
    L13:
        r0.put("source", "left_slide");
    L15:
        if (r8.containsKey("is_file_detail") == true) goto L17;
    L22:
        z(r0, r1, r3);
        this.d.v("client_content_management", r0);
        return;
    L17:
        if (r8.get("is_file_detail") == null) goto L22;
        if (Boolean.parseBoolean(r8.get("is_file_detail")) == false) goto L21;
        r0.put("source", "innerpage_more");
        goto L22
    L21:
        r0.put("source", "attachment_more");
        goto L22
    L5:
        r3 = "";
        goto L6
    }

    public final void G(boolean r3) {
        HashMap<String, Object> r0 = new HashMap();
        a(r0);
        d(r0);
        if (r3 == false) goto L5;
        String r4 = "full_screen";
    L6:
        r0.put("click", r4);
        r0.put("target", "none");
        r0.put("convert_type", "none");
        this.d.n("ccm_space_docs_topbar_click", r0);
        return;
    L5:
        r4 = "normal_screen";
        goto L6
    }

    public final void a(HashMap<String, Object> r4) {
        r4.put("module", "drive");
        r4.put("sub_module", "none");
        h r0 = this.h;
        if (r0 != null) goto L5;
    L7:
        r4.put("app_form", "none");
    L8:
        r4.put("target", "none");
        return;
    L5:
        if (r0.a == false) goto L7;
        r4.put("app_form", "vc");
        goto L8
    }

    public final HashMap<String, Object> g(BaseOpenEntity r3) {
        if (r3 == null) goto L4;
        String r0 = r3.getFileId();
        String r4 = FileUtils.s(r3.getFileName());
    L5:
        Pair r1 = new Pair(r0, r4);
        return h((String) r1.first, (String) r1.second);
    L4:
        r0 = "none";
        r4 = "none";
        goto L5
    }

    public final HashMap<String, Object> i(w75.a r3) {
        if (r3 != null) goto L4;
    L6:
        String r0 = "none";
        String r4 = "none";
    L7:
        Pair r1 = new Pair(r0, r4);
        return h((String) r1.first, (String) r1.second);
    L4:
        if (r3.c() == null) goto L6;
        r0 = r3.c().a;
        r4 = r3.c().k;
        goto L7
    }

    public final void l(b r6) {
        this.b = -60;
        Disposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.c = Flowable.interval(0, 60, TimeUnit.SECONDS).observeOn(fo5.d.a()).subscribe(new a(this, r6));
    }

    public final void A(String r3, HashMap<String, Object> r4) {
        tt5.a.b("DriveReport", "reportDriveEventV2 event = " + r3 + ", map = " + r4);
        this.d.n(r3, r4);
    }

    public final void E(b r3, String r4) {
        F(r3.a, r3.b, "click_rename", r4);
    }

    public final void c(String r3, HashMap<String, Object> r4) {
        e r5 = this.g.a(r3);
        if (r5 == null) goto L11;
        int r6 = r5.d;
        if (r6 != 3) goto L8;
        r4.put("scene", "im");
        return;
    L8:
        if (r6 != 2) goto L13;
        r4.put("scene", "space");
        return;
    L13:
        return;
    }

    public final HashMap<String, Object> h(String r2, String r3) {
        HashMap<String, Object> r0 = new HashMap();
        a(r0);
        d(r0);
        b(r0, r2, r3);
        return r0;
    }

    public final void r(w75.a r3, HashMap<String, Object> r4) {
        s(r3, r4, -1);
    }

    public final void u(String r4, int r5) {
        HashMap r0 = new HashMap();
        r0.put("file_id", du5.b.g(r4));
        r0.put("file_type", sbb.e.l.getType());
        r0.put("is_landscape", Integer.valueOf(r5));
        e r6 = this.g.a(r4);
        if (r6 != null) goto L5;
    L20:
        this.d.v("client_file_landscape", r0);
        tt5.a.b("DriveReport", "report client_file_landscape, params: " + r0);
        return;
    L5:
        if (r6.c() == null) goto L20;
        r0.put("sub_file_type", r6.a());
        r0.put("preview_from", r6.c());
        Bundle r7 = r6.c;
        String r1 = r6.c();
        if (r7 == null) goto L9;
        String r2 = r7.getString("drive_fragment_type");
    L10:
        String r8 = f(r1, r2, r6.d());
        if (TextUtils.isEmpty(r8) == false) goto L17;
        if (r7 == null) goto L17;
        if (TextUtils.isEmpty(r7.getString("module")) == true) goto L17;
        r8 = r7.getString("module");
    L17:
        if (TextUtils.isEmpty(r8) == false) goto L19;
        r8 = "other_link";
    L19:
        r0.put("module", r8);
        goto L20
    L9:
        r2 = null;
        goto L10
    }

    public final void v(w75.a r3, boolean r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.c() == null) goto L13;
        HashMap<String, Object> r0 = new HashMap();
        z(r0, r3.c().a, r3.c().k);
        if (r4 == false) goto L9;
        String r5 = "full";
    L10:
        r0.put("display_type", r5);
        tt5.a.b("DriveReport", "reportClickDisplayEvent map = " + r0);
        this.d.v("client_click_display", r0);
        return;
    L9:
        r5 = BottomPopupData.Default;
        goto L10
    }

    public final void y(String r3, String r4) {
        HashMap<String, Object> r0 = new HashMap();
        r0.put(JSEventListener.ACTION, r4);
        e r5 = this.g.a(r3);
        if (r5 == null) goto L5;
        String r6 = r5.a();
    L6:
        z(r0, r3, r6);
        this.d.v("client_praise", r0);
        return;
    L5:
        r6 = "";
        goto L6
    }

    public static String f(String r5, String r6, String r7) {
        String r1 = "";
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return "";
    L5:
        r5.getClass();
        String r2 = "calendar";
        byte r3 = -1;
        switch(r5.hashCode()) {
            case -1961668694: goto L85;
            case -1902200833: goto L81;
            case -1389265756: goto L77;
            case -1366839291: goto L73;
            case -1354042618: goto L69;
            case -907320503: goto L65;
            case -519244153: goto L61;
            case -178324674: goto L57;
            case -113928104: goto L53;
            case -102166727: goto L49;
            case 3343799: goto L45;
            case 248701330: goto L41;
            case 306539794: goto L37;
            case 498059870: goto L33;
            case 819565027: goto L29;
            case 934983331: goto L25;
            case 954925063: goto L21;
            case 1028708505: goto L17;
            case 1178514824: goto L13;
            case 2016408475: goto L9;
            default: goto L89;
        };
    L9:
        if (r5.equals("from_parent_docs") == false) goto L89;
        r3 = 19;
        goto L89
    L13:
        if (r5.equals("tab_sharetome") == false) goto L89;
        r3 = 18;
        goto L89
    L17:
        if (r5.equals("lark_search") == false) goto L89;
        r3 = 17;
        goto L89
    L21:
        if (r5.equals("message") == false) goto L89;
        r3 = 16;
        goto L89
    L25:
        if (r5.equals("tab_personal_folder") == false) goto L89;
        r3 = 15;
        goto L89
    L29:
        if (r5.equals("doc_mention") == false) goto L89;
        r3 = 14;
        goto L89
    L33:
        if (r5.equals("tab_shared_folder") == false) goto L89;
        r3 = 13;
        goto L89
    L37:
        if (r5.equals("doc_embed") == false) goto L89;
        r3 = 12;
        goto L89
    L41:
        if (r5.equals("tab_search") == false) goto L89;
        r3 = 11;
        goto L89
    L45:
        if (r5.equals("mail") == false) goto L89;
        r3 = 10;
        goto L89
    L49:
        if (r5.equals("tab_offline") == false) goto L89;
        r3 = 9;
        goto L89
    L53:
        if (r5.equals("tab_folder") == false) goto L89;
        r3 = 8;
        goto L89
    L57:
        if (r5.equals("calendar") == false) goto L89;
        r3 = 7;
        goto L89
    L61:
        if (r5.equals("from_parent_bitable") == false) goto L89;
        r3 = 6;
        goto L89
    L65:
        if (r5.equals("tab_home") == false) goto L89;
        r3 = 5;
        goto L89
    L69:
        if (r5.equals("tab_favorite") == false) goto L89;
        r3 = 4;
        goto L89
    L73:
        if (r5.equals("drive_sdk") == false) goto L89;
        r3 = 3;
        goto L89
    L77:
        if (r5.equals("from_parent_mindnote") == false) goto L89;
        r3 = 2;
        goto L89
    L81:
        if (r5.equals("from_parent_sheet") == false) goto L89;
        r3 = 1;
        goto L89
    L85:
        if (r5.equals("tab_personal") == false) goto L89;
        r3 = 0;
    L89:
        switch(r3) {
            case 0: goto L122;
            case 1: goto L121;
            case 2: goto L120;
            case 3: goto L114;
            case 4: goto L112;
            case 5: goto L111;
            case 6: goto L110;
            case 7: goto L106;
            case 8: goto L124;
            case 9: goto L104;
            case 10: goto L100;
            case 11: goto L98;
            case 12: goto L129;
            case 13: goto L96;
            case 14: goto L129;
            case 15: goto L124;
            case 16: goto L95;
            case 17: goto L98;
            case 18: goto L94;
            case 19: goto L129;
            default: goto L91;
        };
    L94:
        return "sharetome";
    L95:
        return "im_link";
    L96:
        return "shared_folder";
    L98:
        return "search";
    L104:
        return "offline";
    L110:
        return "bitable";
    L111:
        return "home";
    L112:
        return "favorites";
    L120:
        return "mindnote";
    L121:
        return "sheet";
    L122:
        return "personal";
    L124:
        return "folder";
    L91:
        if ("main".equals(r6) == false) goto L125;
        r1 = "other_link";
    L125:
        return r1;
    L129:
        return "doc";
    L100:
        if ("attachment".equals(r6) == false) goto L102;
        String r8 = "email";
    L131:
        return r8;
    L102:
        r8 = "email_link";
        goto L131
    L106:
        if ("attachment".equals(r6) == true) goto L133;
        r2 = "calendar_link";
    L133:
        return r2;
    L114:
        if ("1001".equals(r7) == false) goto L117;
        return "im";
    L117:
        if ("1002".equals(r7) == false) goto L119;
        return "mini_program";
    L119:
        return "unknown";
    }

    public final void H(String r3, String r4, HashMap<String, Object> r5) {
        String r6 = com.bytedance.ee.util.io.a.c(r3);
        if (r5.containsKey("file_id") == false) goto L5;
        String r0 = (String) r5.get("file_id");
    L6:
        HashMap<String, Object> r1 = new HashMap(r5);
        r1.put(JSEventListener.ACTION, r4);
        r1.put("sub_module", "recent");
        z(r1, r0, r6);
        this.d.v("client_content_management", r1);
        return;
    L5:
        r0 = "";
        goto L6
    }

    public final void I(String r4, String r5, String r6) {
        HashMap<String, Object> r0 = new HashMap();
        r0.put("event_type", "mouseClick");
        r0.put("sub_module", "upload_layer");
        r0.put(JSEventListener.ACTION, r6);
        z(r0, r4, r5);
        this.d.v("client_file_upload", r0);
    }

    public final void b(HashMap<String, Object> r3, String r4, String r5) {
        String r0 = "none";
        if ("none".equals(r4) == true) goto L6;
        r0 = du5.b.g(r4);
    L6:
        r3.put("file_id", r0);
        e r6 = this.g.a(r4);
        String r1 = sbb.e.l.getType();
        if (r6 != null) goto L9;
    L11:
        r3.put("file_type", r1);
        r3.put("sub_file_type", r5);
        return;
    L9:
        if (r6.d != 2) goto L11;
        r1 = "drive";
        goto L11
    }

    public final void m(w75.a r2, String r3, String r4) {
        HashMap<String, Object> r5 = i(r2);
        r5.put("click", r3);
        r5.put("target", r4);
        A("ccm_docs_page_click", r5);
    }

    public final void n(w75.a r3, String r4, String r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        HashMap<String, Object> r0 = i(r3);
        r0.put("click", r4);
        r0.put("target", r5);
        c(r3.c().a, r0);
        A("ccm_drive_file_menu_click", r0);
    }

    public final void o(String r3, String r4, String r5) {
        HashMap<String, Object> r0 = i(null);
        r0.put("click", r3);
        r0.put("target", r4);
        if (TextUtils.isEmpty(r5) == true) goto L5;
        r0.put("container_id", du5.b.g(r5));
        r0.put("container_type", FileInfoPuller.CALLER_WIKI);
    L5:
        A("ccm_drive_file_upload_process_click", r0);
    }

    public final void p(w75.a r3, String r4, String r5) {
        HashMap<String, Object> r0 = new HashMap();
        r0.put("click", r4);
        r0.put("diaplay", r5);
        r0.put("target", "none");
        r(r3, r0);
    }

    public final void q(w75.a r4, String r5, String r6) {
        HashMap<String, Object> r0 = new HashMap();
        r0.put("click", "media_volume");
        r0.put("diaplay", r5);
        r0.put("is_mute", r6);
        r0.put("target", "none");
        r(r4, r0);
    }

    public final void s(w75.a r3, HashMap<String, Object> r4, long r5) {
        HashMap<String, Object> r6 = i(r3);
        if (r4.size() <= 0) goto L6;
        r6.putAll(r4);
    L6:
        if (r5 < 0) goto L8;
        r6.put("play_time", Long.valueOf(r5));
    L8:
        A("ccm_drive_page_click", r6);
    }

    public final void z(HashMap<String, Object> r8, String r9, String r10) {
        r8.put("file_id", du5.b.g(r9));
        r8.put("file_type", sbb.e.l.getType());
        r8.put("module", "drive");
        r8.put("src_module", "");
        r8.put("sub_module", "");
        r8.put("src_obj_id", "");
        r8.put("product", "suite");
        if (r10 == null) goto L5;
        r8.put("sub_file_type", r10.toLowerCase());
    L6:
        e r11 = this.g.a(r9);
        if (r11 != null) goto L9;
    L11:
        h r2 = this.h;
        if (r2 != null) goto L14;
    L16:
        if (r11 != null) goto L18;
    L20:
        if (r11 == null) goto L24;
        Bundle r12 = r11.c;
        if (r12 == null) goto L24;
        r8.put("src_module", r12.getString("src_module"));
        r8.put("sub_module", r12.getString("sub_module"));
        r8.put("src_obj_id", du5.b.g(r12.getString(DocViewModel.EXTRA_PARENT_TOKEN)));
    L24:
        h r13 = this.h;
        if (r13 != null) goto L27;
    L29:
        r8.put("product_type", "drive");
        return;
    L27:
        if (r13.a == false) goto L29;
        r8.put("app_from", "vc");
        r8.put("meeting_id", this.h.b);
        goto L29
    L18:
        if (TextUtils.isEmpty(r11.d()) == true) goto L20;
        r8.put("sdkAppId", r11.d());
        goto L20
    L14:
        if (r2.a == false) goto L16;
        r8.put("preview_from", "vc");
        goto L16
    L9:
        if (r11.c() == null) goto L11;
        r8.put("preview_from", r11.c());
        goto L11
    L5:
        r8.put("sub_file_type", "");
        goto L6
    }

    public final void D(String r4, String r5, String r6, String r7) {
        HashMap<String, Object> r0 = new HashMap();
        r0.put("event_type", "mouseClick");
        r0.put("mode", "drive_view");
        r0.put(JSEventListener.ACTION, r6);
        r0.put("source", r7);
        r0.put("media_type", r7);
        z(r0, r4, r5);
        tt5.a.b("DriveReport", "reportPreviewRelatedEvent map = " + r0);
        this.d.v("toggle_attribute", r0);
    }

    public final void F(String r3, String r4, String r5, String r6) {
        HashMap<String, Object> r0 = new HashMap();
        r0.put(JSEventListener.ACTION, r5);
        r0.put("sub_module", "recent");
        r0.put("status_name", "success");
        r0.put("sub_confirm_type", r6);
        z(r0, r3, r4);
        this.d.v("client_content_management", r0);
    }

    public final void J(String r6, String r7, boolean r8, String r9) {
        HashMap<String, Object> r0 = new HashMap();
        r0.put("file_size", Long.valueOf(FileUtils.y(r6) / 1048576));
        r0.put("dummy_token", r7);
        if (r8 == false) goto L5;
        String r10 = "success";
    L6:
        r0.put("status", r10);
        r0.put("file_id", r9);
        H(r6, "drive_upload_result", r0);
        return;
    L5:
        r10 = "fail";
        goto L6
    }

    public final void t(w75.a r2, String r3, String r4, Map<String, Object> r5) {
        HashMap<String, Object> r6 = i(r2);
        r6.put("click", r3);
        r6.put("target", r4);
        if (r5 == null) goto L8;
        Iterator r7 = ((HashMap) r5).entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        Map.Entry r8 = (Map.Entry) r7.next();
        r6.put((String) r8.getKey(), r8.getValue());
    L8:
        A("ccm_space_docs_topbar_click", r6);
    }

    public final void w(String r6, String r7, String r8, String r9) {
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L5
        r3.put("module", r6);     // Catch: Exception -> L5
        r3.put("src_module", r6);     // Catch: Exception -> L5
        r3.put("sub_module", "");     // Catch: Exception -> L5
        r3.put("file_id", yu5.c.j(r8));     // Catch: Exception -> L5
        r3.put("sub_file_type", r9);     // Catch: Exception -> L5
        r3.put(JSEventListener.ACTION, r7);     // Catch: Exception -> L5
        r3.put("product_type", "drive");     // Catch: Exception -> L5
        r3.put("file_type", "file");     // Catch: Exception -> L5
        r3.put("is_dir", 0);     // Catch: Exception -> L5
        r3.put("is_export", 0);     // Catch: Exception -> L5
        tt5.a.h("DriveReport", "reportClientFileDownload. params = " + r3);     // Catch: Exception -> L5
        this.d.a("client_file_download", r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e("DriveReport", "reportClientFileDownload fail ", e, false);
    }

    public final void x(String r8, String r9, String r10, Bundle r11) {
        if (r11 != null) goto L13;
        return;
    L13:
        String r5 = r11.getString("module", "");     // Catch: Exception -> L10
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L10
        r6.put("module", r11.getString("module", ""));     // Catch: Exception -> L10
        r6.put("src_module", r5);     // Catch: Exception -> L10
        r6.put("sub_module", "");     // Catch: Exception -> L10
        r6.put("file_id", yu5.c.j(r9));     // Catch: Exception -> L10
        r6.put("sub_file_type", r10);     // Catch: Exception -> L10
        r6.put(JSEventListener.ACTION, r8);     // Catch: Exception -> L10
        r6.put("product_type", "drive");     // Catch: Exception -> L10
        r6.put("file_type", "file");     // Catch: Exception -> L10
        r6.put("is_dir", 0);     // Catch: Exception -> L10
        r6.put("is_import", 0);     // Catch: Exception -> L10
        tt5.a.b("DriveReport", "reportClientFileUpload. params = " + r6);     // Catch: Exception -> L10
        d r12 = this.d;     // Catch: Exception -> L10
        if (r12 == null) goto L15;
        r12.a("client_file_upload", r6);     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        tt5.a.e("DriveReport", "reportClientFileUpload fail ", e, false);
    }

    public final void C(String r4, String r5, String r6, String r7, String r8) {
        HashMap<String, Object> r0 = new HashMap();
        r0.put("network_status", "online");
        r0.put("session_id", null);
        r0.put("file_tenant_id", du5.b.g(r7));
        r0.put("file_is_cross_tenant", r8);
        r0.put("owner_tenant_id", du5.b.g(r7));
        if (((gpb.a) ApiUtils.getApi(gpb.a.class)).isFeishuBrand() == false) goto L5;
        Object r9 = "feishu";
    L6:
        r0.put("user_brand", r9);
        z(r0, r5, r6);
        h r10 = this.h;
        if (r10 != null) goto L9;
    L11:
        r0.put("mode", "preview");
    L12:
        e r11 = this.g.a(r5);
        if (r11 == null) goto L38;
        Bundle r12 = r11.c;
        if (r12 == null) goto L38;
        String r13 = r12.getString("drive_fragment_type");
        String r14 = f(r11.c(), r13, r11.d());
        if ("client_file_open".equals(r4) == false) goto L22;
        if ("attachment".equals(r13) == false) goto L22;
        r4 = "drive_sdk_file_open";
    L22:
        if (TextUtils.isEmpty(r14) == false) goto L24;
        r14 = r12.getString("module");
    L24:
        r0.put("module", r14);
        if ("home".equals(r14) == false) goto L35;
        String r16 = (String) r0.get("sub_module");
        if (TextUtils.isEmpty(r16) == true) goto L35;
        if (r16.equals("recent") == false) goto L32;
        r0.put("module", "recent");
        goto L35
    L32:
        if (r16.equals("quickaccess") == false) goto L35;
        r0.put("module", "quickaccess");
    L35:
        if (TextUtils.isEmpty((String) r0.get("src_module")) == false) goto L38;
        r0.put("src_module", r14);
    L38:
        if ("client_file_open".equals(r4) == false) goto L46;
        h r17 = this.h;
        if (r17 != null) goto L42;
    L44:
        Object r18 = BottomPopupData.Default;
    L45:
        r0.put("display_type", r18);
        goto L46
    L42:
        if (r17.a == false) goto L44;
        r18 = "full";
    L46:
        tt5.a.b("DriveReport", "reportPreviewEventInternal event = " + r4 + ", map = " + r0);
        this.d.v(r4, r0);
        return;
    L9:
        if (r10.a == false) goto L11;
        r0.put("mode", "presentation");
        goto L12
    L5:
        r9 = "lark";
        goto L6
    }
}
