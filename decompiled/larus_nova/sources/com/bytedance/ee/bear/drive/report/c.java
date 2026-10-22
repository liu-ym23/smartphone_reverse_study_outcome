package com.bytedance.ee.bear.drive.report;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.util.io.FileUtils;
import com.larus.platform.model.SlashMentionConfig;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.videoarch.strategy.dataCenter.strategyData.HistoryTableOperate;
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

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f224582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f224583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f224584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f224585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b0 f224586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h0 f224587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t85.c f224588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h f224589h;

    public class a implements Consumer<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f224590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f224591b;

        @Override // io.reactivex.functions.Consumer
        public final void accept(Long r100) throws Exception {
            c r101 = this.f224591b;
            b r102 = this.f224590a;
            String r103 = r102.f224592a;
            String r104 = r102.f224593b;
            r101.f224583b += 60;
            HashMap<String, Object> r105 = new HashMap();
            r105.put("session_duration", Integer.valueOf(r101.f224583b));
            r105.put("in_page", String.valueOf(true));
            r105.put("session_id", null);
            r101.z(r105, r103, r104);
            r101.f224585d.v("launch_duration", r105);
        }

        public a(c r100, b r101) {
            this.f224591b = r100;
            this.f224590a = r101;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f224592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f224593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f224594c;

        public b() {
            this.f224592a = "";
            this.f224593b = "";
        }
    }

    public final boolean j() {
        h r100 = this.f224589h;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.f545050a == false) goto L7;
        return true;
    }

    public c(t85.c r100) {
        this.f224583b = -60;
        this.f224585d = (d) org.koin.java.a.a(d.class);
        this.f224586e = (b0) org.koin.java.a.a(b0.class);
        this.f224587f = (h0) org.koin.java.a.a(h0.class);
        this.f224588g = r100;
    }

    public static void d(HashMap r100) {
        r100.put("container_id", "none");
        r100.put(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, "none");
        r100.put("shortcut_id", "none");
        r100.put("is_shortcut", "false");
    }

    public static b e(w75.a r100) {
        b r101 = new b();
        if (r100 != null) goto L5;
    L7:
        return r101;
    L5:
        if (r100.c() == null) goto L7;
        r101.f224592a = r100.c().f558557a;
        r101.f224593b = r100.c().f558567k;
        r101.f224594c = r100.c().f558559c;
        goto L7
    }

    public static String k(e r100) {
        if (r100 != null) goto L5;
        return "false";
    L5:
        Bundle r101 = r100.f545043c;
        if (r101 != null) goto L9;
        return "false";
    L9:
        if (TextUtils.equals(r101.getString("is_degraded"), "true") == true) goto L11;
        return "false";
    L11:
        return "true";
    }

    public final void B(ImportFileEntity r100) {
        HashMap<String, Object> r101 = new HashMap();
        String r102 = r100.f224401a;
        String r103 = r100.f224402b;
        if (r103 == null) goto L5;
        String r104 = com.bytedance.ee.util.io.a.c(r103);
    L6:
        r101.put("action", "import");
        HashMap<String, String> r105 = r100.f224403c;
        if (r105.containsKey("is_grid") == false) goto L15;
        if (r105.get("is_grid") == null) goto L15;
        if (Boolean.parseBoolean(r105.get("is_grid")) == false) goto L13;
        r101.put("source", "grid_more");
        goto L15
    L13:
        r101.put("source", "left_slide");
    L15:
        if (r105.containsKey("is_file_detail") == true) goto L17;
    L22:
        z(r101, r102, r104);
        this.f224585d.v("client_content_management", r101);
        return;
    L17:
        if (r105.get("is_file_detail") == null) goto L22;
        if (Boolean.parseBoolean(r105.get("is_file_detail")) == false) goto L21;
        r101.put("source", "innerpage_more");
        goto L22
    L21:
        r101.put("source", "attachment_more");
        goto L22
    L5:
        r104 = "";
        goto L6
    }

    public final void G(boolean r100) {
        HashMap<String, Object> r101 = new HashMap();
        a(r101);
        d(r101);
        if (r100 == false) goto L5;
        String r102 = "full_screen";
    L6:
        r101.put("click", r102);
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        r101.put("convert_type", "none");
        this.f224585d.n("ccm_space_docs_topbar_click", r101);
        return;
    L5:
        r102 = "normal_screen";
        goto L6
    }

    public final void a(HashMap<String, Object> r100) {
        r100.put(EventConstant.Key.MODULE, "drive");
        r100.put("sub_module", "none");
        h r101 = this.f224589h;
        if (r101 != null) goto L5;
    L7:
        r100.put("app_form", "none");
    L8:
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        return;
    L5:
        if (r101.f545050a == false) goto L7;
        r100.put("app_form", ThumbGlideUrl.SOURCE_VC);
        goto L8
    }

    public final HashMap<String, Object> g(BaseOpenEntity r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getFileId();
        String r102 = FileUtils.s(r100.getFileName());
    L5:
        Pair r103 = new Pair(r101, r102);
        return h((String) r103.first, (String) r103.second);
    L4:
        r101 = "none";
        r102 = "none";
        goto L5
    }

    public final HashMap<String, Object> i(w75.a r100) {
        if (r100 != null) goto L4;
    L6:
        String r101 = "none";
        String r102 = "none";
    L7:
        Pair r103 = new Pair(r101, r102);
        return h((String) r103.first, (String) r103.second);
    L4:
        if (r100.c() == null) goto L6;
        r101 = r100.c().f558557a;
        r102 = r100.c().f558567k;
        goto L7
    }

    public final void l(b r100) {
        this.f224583b = -60;
        Disposable r101 = this.f224584c;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        this.f224584c = Flowable.interval(0, 60, TimeUnit.SECONDS).observeOn(fo5.d.a()).subscribe(new a(this, r100));
    }

    public final void A(String r100, HashMap<String, Object> r101) {
        tt5.a.b("DriveReport", "reportDriveEventV2 event = " + r100 + ", map = " + r101);
        this.f224585d.n(r100, r101);
    }

    public final void E(b r100, String r101) {
        F(r100.f224592a, r100.f224593b, "click_rename", r101);
    }

    public final void c(String r100, HashMap<String, Object> r101) {
        e r102 = this.f224588g.a(r100);
        if (r102 == null) goto L11;
        int r103 = r102.f545044d;
        if (r103 != 3) goto L8;
        r101.put("scene", "im");
        return;
    L8:
        if (r103 != 2) goto L13;
        r101.put("scene", "space");
        return;
    L13:
        return;
    }

    public final HashMap<String, Object> h(String r100, String r101) {
        HashMap<String, Object> r102 = new HashMap();
        a(r102);
        d(r102);
        b(r102, r100, r101);
        return r102;
    }

    public final void r(w75.a r100, HashMap<String, Object> r101) {
        s(r100, r101, -1);
    }

    public final void u(String r100, int r101) {
        HashMap r102 = new HashMap();
        r102.put("file_id", du5.b.g(r100));
        r102.put("file_type", sbb.e.f541301l.getType());
        r102.put("is_landscape", Integer.valueOf(r101));
        e r103 = this.f224588g.a(r100);
        if (r103 != null) goto L5;
    L20:
        this.f224585d.v("client_file_landscape", r102);
        tt5.a.b("DriveReport", "report client_file_landscape, params: " + r102);
        return;
    L5:
        if (r103.c() == null) goto L20;
        r102.put("sub_file_type", r103.a());
        r102.put("preview_from", r103.c());
        Bundle r104 = r103.f545043c;
        String r105 = r103.c();
        if (r104 == null) goto L9;
        String r106 = r104.getString("drive_fragment_type");
    L10:
        String r107 = f(r105, r106, r103.d());
        if (TextUtils.isEmpty(r107) == false) goto L17;
        if (r104 == null) goto L17;
        if (TextUtils.isEmpty(r104.getString(EventConstant.Key.MODULE)) == true) goto L17;
        r107 = r104.getString(EventConstant.Key.MODULE);
    L17:
        if (TextUtils.isEmpty(r107) == false) goto L19;
        r107 = "other_link";
    L19:
        r102.put(EventConstant.Key.MODULE, r107);
        goto L20
    L9:
        r106 = null;
        goto L10
    }

    public final void v(w75.a r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.c() == null) goto L13;
        HashMap<String, Object> r102 = new HashMap();
        z(r102, r100.c().f558557a, r100.c().f558567k);
        if (r101 == false) goto L9;
        String r103 = "full";
    L10:
        r102.put("display_type", r103);
        tt5.a.b("DriveReport", "reportClickDisplayEvent map = " + r102);
        this.f224585d.v("client_click_display", r102);
        return;
    L9:
        r103 = "default";
        goto L10
    }

    public final void y(String r100, String r101) {
        HashMap<String, Object> r102 = new HashMap();
        r102.put("action", r101);
        e r103 = this.f224588g.a(r100);
        if (r103 == null) goto L5;
        String r104 = r103.a();
    L6:
        z(r102, r100, r104);
        this.f224585d.v("client_praise", r102);
        return;
    L5:
        r104 = "";
        goto L6
    }

    public static String f(String r100, String r101, String r102) {
        String r103 = "";
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        r100.getClass();
        String r104 = "calendar";
        byte r105 = -1;
        switch(r100.hashCode()) {
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
        if (r100.equals("from_parent_docs") == false) goto L89;
        r105 = 19;
        goto L89
    L13:
        if (r100.equals("tab_sharetome") == false) goto L89;
        r105 = 18;
        goto L89
    L17:
        if (r100.equals("lark_search") == false) goto L89;
        r105 = 17;
        goto L89
    L21:
        if (r100.equals("message") == false) goto L89;
        r105 = 16;
        goto L89
    L25:
        if (r100.equals("tab_personal_folder") == false) goto L89;
        r105 = 15;
        goto L89
    L29:
        if (r100.equals("doc_mention") == false) goto L89;
        r105 = 14;
        goto L89
    L33:
        if (r100.equals("tab_shared_folder") == false) goto L89;
        r105 = HTTP.CR;
        goto L89
    L37:
        if (r100.equals("doc_embed") == false) goto L89;
        r105 = 12;
        goto L89
    L41:
        if (r100.equals("tab_search") == false) goto L89;
        r105 = 11;
        goto L89
    L45:
        if (r100.equals(IOfflineExtraParser.ParserType.MAIL) == false) goto L89;
        r105 = 10;
        goto L89
    L49:
        if (r100.equals("tab_offline") == false) goto L89;
        r105 = 9;
        goto L89
    L53:
        if (r100.equals("tab_folder") == false) goto L89;
        r105 = 8;
        goto L89
    L57:
        if (r100.equals("calendar") == false) goto L89;
        r105 = 7;
        goto L89
    L61:
        if (r100.equals("from_parent_bitable") == false) goto L89;
        r105 = 6;
        goto L89
    L65:
        if (r100.equals("tab_home") == false) goto L89;
        r105 = 5;
        goto L89
    L69:
        if (r100.equals("tab_favorite") == false) goto L89;
        r105 = 4;
        goto L89
    L73:
        if (r100.equals("drive_sdk") == false) goto L89;
        r105 = 3;
        goto L89
    L77:
        if (r100.equals("from_parent_mindnote") == false) goto L89;
        r105 = 2;
        goto L89
    L81:
        if (r100.equals("from_parent_sheet") == false) goto L89;
        r105 = 1;
        goto L89
    L85:
        if (r100.equals("tab_personal") == false) goto L89;
        r105 = 0;
    L89:
        switch(r105) {
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
        return OperationName.OPERATION_OFFLINE_AVAILABLE;
    L110:
        return DocumentType.BITABLE_NAME;
    L111:
        return "home";
    L112:
        return "favorites";
    L120:
        return DocumentType.MINDNOTE_NAME;
    L121:
        return DocumentType.SHEET_NAME;
    L122:
        return WikiSpaceType.PERSONAL;
    L124:
        return DocumentType.FOLDER_NAME;
    L91:
        if (PullConfiguration.PROCESS_NAME_MAIN.equals(r101) == false) goto L125;
        r103 = "other_link";
    L125:
        return r103;
    L129:
        return "doc";
    L100:
        if (SlashMentionConfig.MENTION_CONTENT_ATTACHMENT.equals(r101) == false) goto L102;
        String r106 = "email";
    L131:
        return r106;
    L102:
        r106 = "email_link";
        goto L131
    L106:
        if (SlashMentionConfig.MENTION_CONTENT_ATTACHMENT.equals(r101) == true) goto L133;
        r104 = "calendar_link";
    L133:
        return r104;
    L114:
        if (AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF.equals(r102) == false) goto L117;
        return "im";
    L117:
        if (AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF_3M.equals(r102) == false) goto L119;
        return "mini_program";
    L119:
        return "unknown";
    }

    public final void H(String r100, String r101, HashMap<String, Object> r102) {
        String r103 = com.bytedance.ee.util.io.a.c(r100);
        if (r102.containsKey("file_id") == false) goto L5;
        String r104 = (String) r102.get("file_id");
    L6:
        HashMap<String, Object> r105 = new HashMap(r102);
        r105.put("action", r101);
        r105.put("sub_module", "recent");
        z(r105, r104, r103);
        this.f224585d.v("client_content_management", r105);
        return;
    L5:
        r104 = "";
        goto L6
    }

    public final void I(String r100, String r101, String r102) {
        HashMap<String, Object> r103 = new HashMap();
        r103.put("event_type", "mouseClick");
        r103.put("sub_module", "upload_layer");
        r103.put("action", r102);
        z(r103, r100, r101);
        this.f224585d.v("client_file_upload", r103);
    }

    public final void b(HashMap<String, Object> r100, String r101, String r102) {
        String r103 = "none";
        if ("none".equals(r101) == true) goto L6;
        r103 = du5.b.g(r101);
    L6:
        r100.put("file_id", r103);
        e r104 = this.f224588g.a(r101);
        String r105 = sbb.e.f541301l.getType();
        if (r104 != null) goto L9;
    L11:
        r100.put("file_type", r105);
        r100.put("sub_file_type", r102);
        return;
    L9:
        if (r104.f545044d != 2) goto L11;
        r105 = "drive";
        goto L11
    }

    public final void m(w75.a r100, String r101, String r102) {
        HashMap<String, Object> r103 = i(r100);
        r103.put("click", r101);
        r103.put(PickerReporterConstants.KEY.TARGET, r102);
        A("ccm_docs_page_click", r103);
    }

    public final void n(w75.a r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        HashMap<String, Object> r103 = i(r100);
        r103.put("click", r101);
        r103.put(PickerReporterConstants.KEY.TARGET, r102);
        c(r100.c().f558557a, r103);
        A("ccm_drive_file_menu_click", r103);
    }

    public final void o(String r100, String r101, String r102) {
        HashMap<String, Object> r103 = i(null);
        r103.put("click", r100);
        r103.put(PickerReporterConstants.KEY.TARGET, r101);
        if (TextUtils.isEmpty(r102) == true) goto L5;
        r103.put("container_id", du5.b.g(r102));
        r103.put(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, "wiki");
    L5:
        A("ccm_drive_file_upload_process_click", r103);
    }

    public final void p(w75.a r100, String r101, String r102) {
        HashMap<String, Object> r103 = new HashMap();
        r103.put("click", r101);
        r103.put("diaplay", r102);
        r103.put(PickerReporterConstants.KEY.TARGET, "none");
        r(r100, r103);
    }

    public final void q(w75.a r100, String r101, String r102) {
        HashMap<String, Object> r103 = new HashMap();
        r103.put("click", "media_volume");
        r103.put("diaplay", r101);
        r103.put("is_mute", r102);
        r103.put(PickerReporterConstants.KEY.TARGET, "none");
        r(r100, r103);
    }

    public final void s(w75.a r100, HashMap<String, Object> r101, long r102) {
        HashMap<String, Object> r103 = i(r100);
        if (r101.size() <= 0) goto L6;
        r103.putAll(r101);
    L6:
        if (r102 < 0) goto L8;
        r103.put(HistoryTableOperate.HISTORY_PLAY_TIME, Long.valueOf(r102));
    L8:
        A("ccm_drive_page_click", r103);
    }

    public final void z(HashMap<String, Object> r100, String r101, String r110) {
        r100.put("file_id", du5.b.g(r101));
        r100.put("file_type", sbb.e.f541301l.getType());
        r100.put(EventConstant.Key.MODULE, "drive");
        r100.put("src_module", "");
        r100.put("sub_module", "");
        r100.put("src_obj_id", "");
        r100.put("product", "suite");
        if (r110 == null) goto L5;
        r100.put("sub_file_type", r110.toLowerCase());
    L6:
        e r102 = this.f224588g.a(r101);
        if (r102 != null) goto L9;
    L11:
        h r103 = this.f224589h;
        if (r103 != null) goto L14;
    L16:
        if (r102 != null) goto L18;
    L20:
        if (r102 == null) goto L24;
        Bundle r104 = r102.f545043c;
        if (r104 == null) goto L24;
        r100.put("src_module", r104.getString("src_module"));
        r100.put("sub_module", r104.getString("sub_module"));
        r100.put("src_obj_id", du5.b.g(r104.getString(DocViewModel.EXTRA_PARENT_TOKEN)));
    L24:
        h r105 = this.f224589h;
        if (r105 != null) goto L27;
    L29:
        r100.put("product_type", "drive");
        return;
    L27:
        if (r105.f545050a == false) goto L29;
        r100.put("app_from", ThumbGlideUrl.SOURCE_VC);
        r100.put("meeting_id", this.f224589h.f545051b);
        goto L29
    L18:
        if (TextUtils.isEmpty(r102.d()) == true) goto L20;
        r100.put("sdkAppId", r102.d());
        goto L20
    L14:
        if (r103.f545050a == false) goto L16;
        r100.put("preview_from", ThumbGlideUrl.SOURCE_VC);
        goto L16
    L9:
        if (r102.c() == null) goto L11;
        r100.put("preview_from", r102.c());
        goto L11
    L5:
        r100.put("sub_file_type", "");
        goto L6
    }

    public final void D(String r100, String r101, String r102, String r103) {
        HashMap<String, Object> r104 = new HashMap();
        r104.put("event_type", "mouseClick");
        r104.put("mode", "drive_view");
        r104.put("action", r102);
        r104.put("source", r103);
        r104.put(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, r103);
        z(r104, r100, r101);
        tt5.a.b("DriveReport", "reportPreviewRelatedEvent map = " + r104);
        this.f224585d.v("toggle_attribute", r104);
    }

    public final void F(String r100, String r101, String r102, String r103) {
        HashMap<String, Object> r104 = new HashMap();
        r104.put("action", r102);
        r104.put("sub_module", "recent");
        r104.put("status_name", "success");
        r104.put("sub_confirm_type", r103);
        z(r104, r100, r101);
        this.f224585d.v("client_content_management", r104);
    }

    public final void J(String r100, String r101, boolean r102, String r103) {
        HashMap<String, Object> r104 = new HashMap();
        r104.put("file_size", Long.valueOf(FileUtils.y(r100) / 1048576));
        r104.put("dummy_token", r101);
        if (r102 == false) goto L5;
        String r105 = "success";
    L6:
        r104.put("status", r105);
        r104.put("file_id", r103);
        H(r100, "drive_upload_result", r104);
        return;
    L5:
        r105 = "fail";
        goto L6
    }

    public final void t(w75.a r100, String r101, String r102, Map<String, Object> r103) {
        HashMap<String, Object> r104 = i(r100);
        r104.put("click", r101);
        r104.put(PickerReporterConstants.KEY.TARGET, r102);
        if (r103 == null) goto L8;
        Iterator r105 = ((HashMap) r103).entrySet().iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        Map.Entry r106 = (Map.Entry) r105.next();
        r104.put((String) r106.getKey(), r106.getValue());
    L8:
        A("ccm_space_docs_topbar_click", r104);
    }

    public final void w(String r100, String r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L5
        r104.put(EventConstant.Key.MODULE, r100);     // Catch: Exception -> L5
        r104.put("src_module", r100);     // Catch: Exception -> L5
        r104.put("sub_module", "");     // Catch: Exception -> L5
        r104.put("file_id", yu5.c.j(r102));     // Catch: Exception -> L5
        r104.put("sub_file_type", r103);     // Catch: Exception -> L5
        r104.put("action", r101);     // Catch: Exception -> L5
        r104.put("product_type", "drive");     // Catch: Exception -> L5
        r104.put("file_type", "file");     // Catch: Exception -> L5
        r104.put("is_dir", 0);     // Catch: Exception -> L5
        r104.put("is_export", 0);     // Catch: Exception -> L5
        tt5.a.h("DriveReport", "reportClientFileDownload. params = " + r104);     // Catch: Exception -> L5
        this.f224585d.a("client_file_download", r104);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e("DriveReport", "reportClientFileDownload fail ", e, false);
    }

    public final void x(String r100, String r101, String r110, Bundle r111) {
        if (r111 != null) goto L13;
        return;
    L13:
        String r102 = r111.getString(EventConstant.Key.MODULE, "");     // Catch: Exception -> L10
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L10
        r103.put(EventConstant.Key.MODULE, r111.getString(EventConstant.Key.MODULE, ""));     // Catch: Exception -> L10
        r103.put("src_module", r102);     // Catch: Exception -> L10
        r103.put("sub_module", "");     // Catch: Exception -> L10
        r103.put("file_id", yu5.c.j(r101));     // Catch: Exception -> L10
        r103.put("sub_file_type", r110);     // Catch: Exception -> L10
        r103.put("action", r100);     // Catch: Exception -> L10
        r103.put("product_type", "drive");     // Catch: Exception -> L10
        r103.put("file_type", "file");     // Catch: Exception -> L10
        r103.put("is_dir", 0);     // Catch: Exception -> L10
        r103.put("is_import", 0);     // Catch: Exception -> L10
        tt5.a.b("DriveReport", "reportClientFileUpload. params = " + r103);     // Catch: Exception -> L10
        d r104 = this.f224585d;     // Catch: Exception -> L10
        if (r104 == null) goto L15;
        r104.a("client_file_upload", r103);     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        tt5.a.e("DriveReport", "reportClientFileUpload fail ", e, false);
    }

    public final void C(String r100, String r101, String r102, String r103, String r104) {
        HashMap<String, Object> r105 = new HashMap();
        r105.put("network_status", "online");
        r105.put("session_id", null);
        r105.put("file_tenant_id", du5.b.g(r103));
        r105.put("file_is_cross_tenant", r104);
        r105.put("owner_tenant_id", du5.b.g(r103));
        if (((gpb.a) ApiUtils.getApi(gpb.a.class)).isFeishuBrand() == false) goto L5;
        Object r106 = "feishu";
    L6:
        r105.put("user_brand", r106);
        z(r105, r101, r102);
        h r107 = this.f224589h;
        if (r107 != null) goto L9;
    L11:
        r105.put("mode", "preview");
    L12:
        e r108 = this.f224588g.a(r101);
        if (r108 == null) goto L38;
        Bundle r109 = r108.f545043c;
        if (r109 == null) goto L38;
        String r110 = r109.getString("drive_fragment_type");
        String r111 = f(r108.c(), r110, r108.d());
        if ("client_file_open".equals(r100) == false) goto L22;
        if (SlashMentionConfig.MENTION_CONTENT_ATTACHMENT.equals(r110) == false) goto L22;
        r100 = "drive_sdk_file_open";
    L22:
        if (TextUtils.isEmpty(r111) == false) goto L24;
        r111 = r109.getString(EventConstant.Key.MODULE);
    L24:
        r105.put(EventConstant.Key.MODULE, r111);
        if ("home".equals(r111) == false) goto L35;
        String r112 = (String) r105.get("sub_module");
        if (TextUtils.isEmpty(r112) == true) goto L35;
        if (r112.equals("recent") == false) goto L32;
        r105.put(EventConstant.Key.MODULE, "recent");
        goto L35
    L32:
        if (r112.equals("quickaccess") == false) goto L35;
        r105.put(EventConstant.Key.MODULE, "quickaccess");
    L35:
        if (TextUtils.isEmpty((String) r105.get("src_module")) == false) goto L38;
        r105.put("src_module", r111);
    L38:
        if ("client_file_open".equals(r100) == false) goto L46;
        h r113 = this.f224589h;
        if (r113 != null) goto L42;
    L44:
        Object r114 = "default";
    L45:
        r105.put("display_type", r114);
        goto L46
    L42:
        if (r113.f545050a == false) goto L44;
        r114 = "full";
    L46:
        tt5.a.b("DriveReport", "reportPreviewEventInternal event = " + r100 + ", map = " + r105);
        this.f224585d.v(r100, r105);
        return;
    L9:
        if (r107.f545050a == false) goto L11;
        r105.put("mode", "presentation");
        goto L12
    L5:
        r106 = "lark";
        goto L6
    }
}
