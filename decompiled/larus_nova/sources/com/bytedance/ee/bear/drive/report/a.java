package com.bytedance.ee.bear.drive.report;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.drive.sdk.service.f;
import com.bytedance.ee.bear.lark.dependency.k;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.vfs.VFSFile;
import i75.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import t85.e;
import t85.h;
import w55.n;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f224576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f224577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t85.c f224578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f224579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, Boolean> f224580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f224581f;

    public a(t85.c r100) {
        this.f224580e = new HashMap();
        this.f224576a = (d) org.koin.java.a.a(d.class);
        this.f224577b = (h0) org.koin.java.a.a(h0.class);
        this.f224578c = r100;
    }

    public static String d(Throwable r100) {
        if ((r100 instanceof NetService.ServerErrorException) == false) goto L7;
        return ((NetService.ServerErrorException) r100).getCode() + "";
    L7:
        if ((r100 instanceof NetService.HttpErrorException) == true) goto L9;
        return "";
    L9:
        return ((NetService.HttpErrorException) r100).getCode() + "";
    }

    public final void f(String r100) {
        String r101 = e.e(r100, 3);
        e r102 = this.f224578c.a(r101);
        if (r102 != null) goto L5;
        r102 = new e();
        this.f224578c.b(r101, r102);
        this.f224578c.b(r100, r102);
    L5:
        r102.f545046f = true;
    }

    public final void a(String r100, String r101) {
        if (r100 == null) goto L5;
        String r102 = r100.concat(r101);
        this.f224576a.h(r102);
        this.f224576a.j(r102, ILoadStallMonitor.START_TIME, String.valueOf(SystemClock.uptimeMillis()));
        return;
    }

    public final void g(w75.a r100, int r101) {
        if (r100 == null) goto L8;
        String r102 = e.e(r100.c().f558557a, r101);
        e r103 = this.f224578c.a(r102);
        if (r103 != null) goto L6;
        r103 = new e();
        this.f224578c.b(r102, r103);
        this.f224578c.b(r100.c().f558557a, r103);
    L6:
        r103.f545045e = r100;
        return;
    }

    public final void j(String r110, String r111) {
        e r100 = this.f224578c.a(r110);
        HashMap r112 = new HashMap();
        if (r100 == null) goto L5;
        String r101 = r100.a();
    L6:
        if (r100 == null) goto L8;
        long r102 = r100.b();
    L9:
        long r103 = r102;
        String r104 = r110.concat(r111);
        e r105 = this.f224578c.a(r110);
        String r106 = this.f224576a.e(r104, ILoadStallMonitor.START_TIME);
        if (r106 == null) goto L22;
        long r107 = SystemClock.uptimeMillis() - CastLongProtector.parseLong(r106);     // Catch: Exception -> L17
        r112.put("stage", r111);     // Catch: Exception -> L17
        if (r105 != null) goto L14;
        String r108 = "";
    L15:
        e(r112, r107, r110, r101, r103, r108);     // Catch: Exception -> L17
        tt5.a.b("DriveDevPerformanceReport", "reportImportTimeCostEvent map = " + r112);     // Catch: Exception -> L17
        this.f224576a.v("dev_performance_drive_import_stages", r112);     // Catch: Exception -> L17
        return;
    L14:
        r108 = r105.c();     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L22:
        return;
    L8:
        r102 = 0;
        goto L9
    L5:
        r101 = "";
        goto L6
    }

    public final void q(String r100, String r101) {
        r(r100, r101, SystemClock.uptimeMillis());
    }

    public static String c(String r100, String r101, int r102) {
        return r100.concat(r101).concat(String.valueOf(r102));
    }

    public final void b(String r100, String r101, com.bytedance.ee.bear.drive.config.strategy.d r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.startsWith("local_") == true) goto L14;
        if (r102 != null) goto L8;
    L10:
        int r103 = 0;
    L11:
        String r104 = c(r100, r101, r103);
        this.f224576a.h(r104);
        this.f224576a.j(r104, ILoadStallMonitor.START_TIME, String.valueOf(SystemClock.uptimeMillis()));
        return;
    L8:
        if ((r102 instanceof com.bytedance.ee.bear.drive.config.strategy.h) == false) goto L10;
        r103 = 1;
        goto L11
    }

    public final void i(String r110, String r111, String r112) {
        String r100 = "";
        if (r112 != null) goto L5;
        String r101 = "";
    L6:
        e r102 = this.f224578c.a(r101);
        HashMap r113 = new HashMap();
        if (r102 == null) goto L9;
        String r103 = r102.a();
    L10:
        if (r102 == null) goto L12;
        long r104 = r102.b();
    L13:
        long r105 = r104;
        String r106 = this.f224576a.e(r101.concat("dev_performance_drive_import_finish"), ILoadStallMonitor.START_TIME);
        if (r106 == null) goto L26;
        long r107 = SystemClock.uptimeMillis() - CastLongProtector.parseLong(r106);     // Catch: Exception -> L21
        r113.put("result_key", r110);     // Catch: Exception -> L21
        r113.put("result_code", r111);     // Catch: Exception -> L21
        if (r102 == null) goto L19;
        r100 = r102.c();     // Catch: Exception -> L21
    L19:
        e(r113, r107, r101, r103, r105, r100);     // Catch: Exception -> L21
        tt5.a.b("DriveDevPerformanceReport", "reportImportFinishEvent map = " + r113);     // Catch: Exception -> L21
        this.f224576a.v("dev_performance_drive_import_finish", r113);     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        return;
    L26:
        return;
    L12:
        r104 = 0;
        goto L13
    L9:
        r103 = "";
        goto L10
    L5:
        r101 = r112;
        goto L6
    }

    public final void o(c.b r110, int r111, int r112) {
        if (r111 != 403) goto L5;
        k("nativeFail", "DEC4", r110.f224592a, r112);
        return;
    L5:
        if (r111 != 404) goto L7;
    L48:
        k("nativeFail", "DEC27", r110.f224592a, r112);
        return;
    L7:
        if (r111 != 1000) goto L9;
        tt5.a.h("DriveDevPerformanceReport", "reportRustDownloadFailedFinishEvent user cancel");
        return;
    L9:
        if (r111 != 1007) goto L11;
    L46:
        k("nativeFail", "DEC3", r110.f224592a, r112);
        return;
    L11:
        if (r111 == 1010) goto L46;
        if (r111 != 1024) goto L15;
        tt5.a.h("DriveDevPerformanceReport", "reportRustDownloadFailedFinishEvent user not login");
        return;
    L15:
        if (r111 == 2003) goto L48;
        if (r111 != 3002) goto L19;
        k("nativeFail", "DEC16", r110.f224592a, r112);
        return;
    L19:
        if (r111 == 900023001) goto L43;
        switch(r111) {
            case 1019: goto L24;
            case 1020: goto L24;
            case 1021: goto L24;
            default: goto L22;
        };
    L24:
        tt5.a.h("DriveDevPerformanceReport", "reportRustDownloadFailedFinishEvent background error");
        return;
    L22:
        if (g.a() == false) goto L26;
        k("nativeFail", "DEC3", r110.f224592a, r112);
        return;
    L26:
        if (r111 != 401) goto L42;
        AccountService$Account r100 = ((h0) org.koin.java.a.a(h0.class)).G2();
        com.bytedance.ee.bear.lark.dependency.b r101 = (com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.b.class);
        boolean r102 = ((f) org.koin.java.a.a(f.class)).d0().y();
        String r103 = r101.getUserId();
        String r104 = r101.getSession();
        boolean r105 = true;
        if (r100 != null) goto L30;
    L34:
        boolean r106 = false;
    L35:
        tt5.a.h("DriveDevPerformanceReport", "isAccountStateError()  Drive initDone=" + r102 + " accountNotEquals=" + r106 + " account=" + r100 + " depUserId=" + r103 + " depToken=" + du5.b.i(r104));
        if (r102 == false) goto L40;
        if (r106 == true) goto L40;
        r105 = false;
    L40:
        if (r105 == false) goto L42;
        return;
    L30:
        if (TextUtils.equals(r100.uid, r103) == true) goto L34;
        if (TextUtils.equals(r100.token, r104) == true) goto L34;
        r106 = true;
    L42:
        l("rustFail", "DEC8", r110.f224592a, r112, "rust error, code: " + r111);
        return;
    L43:
        tt5.a.h("DriveDevPerformanceReport", "reportRustDownloadFailedFinishEvent DRIVE_RUST_ERROR_CODE_ENCRYPTION_KEY_DELETED");
    }

    public final void r(String r110, String r111, long r112) {
        HashMap r113 = new HashMap();
        e r100 = this.f224578c.a(r111);
        String r101 = this.f224576a.e(c(r111, r110, 0), ILoadStallMonitor.START_TIME);
        if (r101 == null) goto L15;
        long r102 = r112 - CastLongProtector.parseLong(r101);     // Catch: Exception -> L10
        r113.put("stage", r110);     // Catch: Exception -> L10
        r113.put("loading_type", 0);     // Catch: Exception -> L10
        if (r100 == null) goto L7;
        e(r113, r102, r111, r100.a(), r100.b(), r100.c());     // Catch: Exception -> L10
    L8:
        tt5.a.b("DriveDevPerformanceReport", "reportTimeCostEvent 222 ==>" + r113);     // Catch: Exception -> L10
        this.f224576a.v("dev_performance_drive_open_stages", r113);     // Catch: Exception -> L10
        return;
    L7:
        e(r113, r102, r111, "", 0, "");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void s(String r110, w75.a r111, com.bytedance.ee.bear.drive.config.strategy.d r210) {
        if (r111 != null) goto L5;
    L8:
        String r100 = "";
    L9:
        if (r111 != null) goto L11;
        String r101 = "";
    L12:
        if (r111 != null) goto L14;
    L17:
        long r102 = 0;
    L18:
        long r103 = r102;
        if (r100 != null) goto L21;
        return;
    L21:
        if (r100.startsWith("local_") == true) goto L45;
        HashMap r112 = new HashMap();
        if (r210 != null) goto L27;
    L29:
        int r104 = 0;
    L30:
        String r105 = c(r100, r110, r104);
        e r106 = this.f224578c.a(r100);
        String r107 = this.f224576a.e(r105, ILoadStallMonitor.START_TIME);
        if (r107 == null) goto L44;
        long r113 = SystemClock.uptimeMillis() - CastLongProtector.parseLong(r107);     // Catch: Exception -> L38
        r112.put("stage", r110);     // Catch: Exception -> L38
        r112.put("loading_type", Integer.valueOf(r104));     // Catch: Exception -> L38
        if (r106 != null) goto L35;
        String r108 = "";
    L36:
        e(r112, r113, r100, r101, r103, r108);     // Catch: Exception -> L38
        tt5.a.b("DriveDevPerformanceReport", "reportTimeCostEvent 111 ==>" + r112);     // Catch: Exception -> L38
        this.f224576a.v("dev_performance_drive_open_stages", r112);     // Catch: Exception -> L38
        return;
    L35:
        r108 = r106.c();     // Catch: Exception -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
        return;
    L44:
        return;
    L27:
        if ((r210 instanceof com.bytedance.ee.bear.drive.config.strategy.h) == false) goto L29;
        r104 = 1;
        goto L30
    L45:
        return;
    L14:
        if (r111.c() == null) goto L17;
        r102 = r111.c().f558559c;
        goto L18
    L11:
        r101 = r111.c().f558567k;
        goto L12
    L5:
        if (r111.c() == null) goto L8;
        r100 = r111.c().f558557a;
        goto L9
    }

    public final void t(String r100, String r101, String r102) {
        String r103 = e.e(r100, 3);
        e r104 = this.f224578c.a(r103);
        if (r104 != null) goto L5;
        r104 = new e();
        this.f224578c.b(r103, r104);
        this.f224578c.b(r100, r104);
    L5:
        Bundle r105 = r104.f545043c;
        if (r105 != null) goto L8;
        r105 = new Bundle();
    L8:
        r105.putString(r101, r102);
        r104.f545043c = r105;
    }

    public final void k(String r100, String r101, String r110, int r111) {
        m(r100, r101, r110, r111, "", "");
    }

    public final void h(int r110, long r111, String r112, String r113, long r210) {
        if (r112 != null) goto L5;
        String r100 = "";
    L6:
        if (r113 != null) goto L8;
        String r101 = "";
    L9:
        HashMap r114 = new HashMap();
        e r102 = this.f224578c.a(r100);
        r114.put("key", "server_transform");     // Catch: Exception -> L16
        r114.put("code", Integer.valueOf(r110));     // Catch: Exception -> L16
        if (r102 != null) goto L13;
        String r103 = "";
    L14:
        e(r114, r111, r100, r101, r210, r103);     // Catch: Exception -> L16
        tt5.a.b("DriveDevPerformanceReport", "reportDataCollection " + r114);     // Catch: Exception -> L16
        this.f224576a.v("dev_performance_data_collection", r114);     // Catch: Exception -> L16
        return;
    L13:
        r103 = r102.c();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        tt5.a.f("DriveDevPerformanceReport", e, false);
        return;
    L8:
        r101 = r113;
        goto L9
    L5:
        r100 = r112;
        goto L6
    }

    public final void l(String r100, String r101, String r110, int r111, String r112) {
        m(r100, r101, r110, r111, "", r112);
    }

    public final void e(Map<String, Object> r100, long r101, String r102, String r103, long r104, String r105) {
        HashMap r106 = (HashMap) r100;
        r106.put(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(r101));
        r106.put("file_token", du5.b.g(r102));
        if (TextUtils.isEmpty(r103) == false) goto L5;
        r106.put("file_type", r103);
    L6:
        r106.put("file_size", Long.valueOf(r104));
        if (this.f224577b.G2() == null) goto L10;
        r106.put("user_id", du5.b.g(this.f224577b.G2().uid));
        r106.put("tenant_id", du5.b.g(this.f224577b.G2().tenantId));
    L10:
        if (TextUtils.isEmpty(r105) == true) goto L12;
        r106.put("preview_from", r105);
    L13:
        e r107 = this.f224578c.a(r102);
        if (r107 != null) goto L16;
        return;
    L16:
        if (TextUtils.isEmpty(r107.d()) == true) goto L20;
        r106.put("sdkAppId", r107.d());
        return;
    L20:
        return;
    L12:
        tt5.a.k("DriveDevPerformanceReport", "PREVIEW_FROM is empty...");
        goto L13
    L5:
        r106.put("file_type", r103.toLowerCase());
        goto L6
    }

    public final void m(String r100, String r110, String r111, int r112, String r113, String r114) {
        n("dev_performance_drive_open_finish", r100, r110, r111, r112, r113, r114);
    }

    public final void p(String r100, String r101, String r102, String r103, String r104, Map<String, Object> r105) {
        HashMap r106 = new HashMap();
        if (r105 == null) goto L5;
        r106.putAll(r105);
    L5:
        r106.put("stage_code", r100);
        r106.put(BitableResourceData.KEY_VIEW_ID, r101);
        r106.put(BytedCertConstant.IntentKey.VIEW_TYPE, r102);
        r106.put("result_code", r103);
        r106.put("error_message", r104);
        h r107 = this.f224579d;
        if (r107 != null) goto L8;
    L10:
        AccountService$Account r108 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (r108 == null) goto L13;
        r106.put("user_id", du5.b.g(r108.uid));
        r106.put("tenant_id", du5.b.g(r108.tenantId));
    L13:
        r106.put("doc_network_status", String.valueOf(j.a.f217090a.getNetworkState().getType()));
        r106.put("app_visible", String.valueOf(((com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class)).a()));
        r106.put("app_doze", String.valueOf(((com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class)).f()));
        r106.put("doc_network_level", String.valueOf(((f) org.koin.java.a.a(f.class)).d0().p().getValue()));
        this.f224576a.n("dev_same_render_open_finish_dev", r106);
        return;
    L8:
        if (r107.f545050a == false) goto L10;
        r106.put("preview_from", ThumbGlideUrl.SOURCE_VC);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    public final void n(String r100, String r101, String r110, String r111, int r112, String r113, String r114) {
        HashMap r102 = new HashMap();
        r102.put("result_key", r101);
        r102.put("result_code", r110);
        r102.put("file_token", du5.b.g(r111));
        String r115 = "";
        if (TextUtils.isEmpty(r113) == false) goto L6;
        r113 = "";
    L6:
        r102.put("open_type", r113);
        if (TextUtils.isEmpty(r114) == false) goto L10;
        r114 = "";
    L10:
        r102.put("error_message", r114);
        r102.put("source_type", String.valueOf(r112));
        boolean r116 = false;
        String r103 = "0";
        if (r112 != 3) goto L13;
    L14:
        String r104 = this.f224576a.e(r111.concat("dev_performance_drive_open_finish").concat("0"), ILoadStallMonitor.START_TIME);
        if (r104 != null) goto L92;
    L20:
        long r105 = -1;
    L21:
        r102.put(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(r105));
        e r106 = this.f224578c.a(e.e(r111, r112));
        if (r106 == null) goto L79;
        r102.put("preview_from", r106.c());
        if (TextUtils.isEmpty(r106.d()) == true) goto L26;
        r102.put("sdkAppId", r106.d());
    L26:
        r102.put("file_type", r106.a().toLowerCase());
        r102.put("file_size", Long.valueOf(r106.b()));
        w75.a r107 = r106.f545045e;
        ?? r108 = -1;
        if (r107 == null) goto L29;
        int r109 = r107.f558536e;
    L30:
        r102.put("preview_type", Integer.valueOf(r109));
        w75.a r117 = r106.f545045e;
        if (r117 == null) goto L33;
        String r118 = r117.f558537f;
    L35:
        if (TextUtils.isEmpty(r118) == true) goto L37;
        String r119 = r118.toLowerCase();
    L38:
        r102.put("preview_ext", r119);
        a95.a r120 = new a95.a();
        DriveFilePath.Companion.getClass();
        DriveFilePath r121 = DriveFilePath.a.a();
        w75.a r122 = r106.f545045e;
        if (r122 == null) goto L42;
        r121 = r122.a();
    L42:
        if (r121.isEmpty() == true) goto L46;
        VFSFile r123 = z75.b.e(r121, r120.f2278b);
        if (z75.b.d(r121, r120.f2278b) == false) goto L46;
        long r124 = r123.length();
    L47:
        r102.put("preview_size", Long.valueOf(r124));
        w75.a r125 = r106.f545045e;
        if (r125 == null) goto L50;
        r108 = r125.f558534c.get();
    L50:
        r102.put("doc_has_cache", Integer.valueOf(r108));
        w75.a r126 = r106.f545045e;
        if (r126 != null) goto L53;
        String r127 = "";
    L54:
        r102.put("mime_type", r127);
        w75.a r128 = r106.f545045e;
        if (r128 == null) goto L58;
        r115 = r128.f558532a.f558566j;
    L58:
        r102.put("real_mime_type", r115);
        w75.a r129 = r106.f545045e;
        if (r129 == null) goto L62;
        r116 = r129.d();
    L62:
        String r130 = "1";
        if (r116 == false) goto L65;
        r103 = "1";
    L65:
        r102.put("isRealType", r103);
        w75.a r131 = r106.f545045e;
        if (r131 != null) goto L68;
        String r132 = "-1";
    L69:
        r102.put("cache_source_from", r132);
        Bundle r133 = r106.f545043c;
        if (r133 == null) goto L76;
        Iterator<String> r134 = r133.keySet().iterator();
    L73:
        if (r134.hasNext() == false) goto L76;
        String r135 = r134.next();
        r102.put(r135, du5.b.f(r133.get(r135)));
    L76:
        if (r106.f545046f == false) goto L78;
        r130 = "2";
    L78:
        r102.put(ResourceData.KEY_LOAD_FROM, r130);
        goto L79
    L68:
        r132 = r131.f558554w;
        goto L69
    L53:
        r127 = r126.f558532a.f558562f;
    L46:
        r124 = 0;
        goto L47
    L37:
        r119 = "";
        goto L38
    L33:
        r118 = "";
        goto L35
    L29:
        r109 = -1;
    L79:
        r102.put("tt_init", Boolean.valueOf(n.g().f558325a.hasInit()));
        r102.put("tt_pluginstateenable", Boolean.valueOf(n.g().f()));
        r102.put("tt_pkgcanuseplugin", Boolean.valueOf(n.g().e()));
        r102.put("tt_netinitfalseuninstalled", Boolean.valueOf(n.g().f558326b.get()));
        h r136 = this.f224579d;
        if (r136 != null) goto L82;
    L84:
        AccountService$Account r137 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (r137 == null) goto L87;
        r102.put("user_id", du5.b.g(r137.uid));
        r102.put("tenant_id", du5.b.g(r137.tenantId));
    L87:
        r102.put("feishu_brand", String.valueOf(((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.b.class)).isFeishuBrand()));
        b0 r138 = (b0) org.koin.java.a.a(b0.class);
        r102.put("user_geo", String.valueOf(r138.isChinaMainlandGeo()));
        r102.put("is_private_ka_pkg", Boolean.valueOf(r138.f()));
        r102.put("is_lark_package", Boolean.valueOf(((k) org.koin.java.a.a(k.class)).isUsPackage()));
        r102.put("doc_network_status", String.valueOf(j.a.f217090a.getNetworkState().getType()));
        r102.put("app_visible", String.valueOf(((com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class)).a()));
        r102.put("app_doze", String.valueOf(((com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class)).f()));
        r102.put("doc_network_level", String.valueOf(((f) org.koin.java.a.a(f.class)).d0().p().getValue()));
        if (TextUtils.equals(r100, "dev_performance_drive_open_finish") == false) goto L90;
        r102.put("is_forseti_fg_on", Boolean.valueOf(ForsetiHelper.p()));
        r102.put("is_in_forseti", Boolean.valueOf(this.f224581f));
    L90:
        tt5.a.h("DriveDevPerformanceReport", "event = " + r100 + ", reportOpenFinishEvent, data: " + du5.b.f(r102));
        this.f224580e.put(r111, Boolean.TRUE);
        this.f224576a.v(r100, r102);
        return;
    L82:
        if (r136.f545050a == false) goto L84;
        r102.put("preview_from", ThumbGlideUrl.SOURCE_VC);
        goto L84
    L92:
        r105 = SystemClock.uptimeMillis() - CastLongProtector.parseLong(r104);
    L18:
        e = move-exception;
        tt5.a.f("DriveDevPerformanceReport", e, false);
        goto L20
    L13:
        if (r112 != 5) goto L20;
        goto L14
    }
}
