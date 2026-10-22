package com.bytedance.ee.bear.drive.report;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.comment.bean.ShowCardsJsData;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.drive.sdk.service.f;
import com.bytedance.ee.bear.lark.dependency.k;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.vfs.VFSFile;
import i75.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import t85.e;
import t85.h;
import w55.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final d a;
    public final h0 b;
    public final t85.c c;
    public h d;
    public final HashMap<String, Boolean> e;
    public boolean f;

    public a(t85.c r2) {
        this.e = new HashMap();
        this.a = (d) org.koin.java.a.a(d.class);
        this.b = (h0) org.koin.java.a.a(h0.class);
        this.c = r2;
    }

    public static String d(Throwable r2) {
        if ((r2 instanceof NetService.ServerErrorException) == false) goto L7;
        return ((NetService.ServerErrorException) r2).getCode() + "";
    L7:
        if ((r2 instanceof NetService.HttpErrorException) == true) goto L9;
        return "";
    L9:
        return ((NetService.HttpErrorException) r2).getCode() + "";
    }

    public final void f(String r4) {
        String r0 = e.e(r4, 3);
        e r1 = this.c.a(r0);
        if (r1 != null) goto L5;
        r1 = new e();
        this.c.b(r0, r1);
        this.c.b(r4, r1);
    L5:
        r1.f = true;
    }

    public final void a(String r3, String r4) {
        if (r3 == null) goto L5;
        String r5 = r3.concat(r4);
        this.a.h(r5);
        this.a.j(r5, "start_time", String.valueOf(SystemClock.uptimeMillis()));
        return;
    }

    public final void g(w75.a r3, int r4) {
        if (r3 == null) goto L8;
        String r5 = e.e(r3.c().a, r4);
        e r0 = this.c.a(r5);
        if (r0 != null) goto L6;
        r0 = new e();
        this.c.b(r5, r0);
        this.c.b(r3.c().a, r0);
    L6:
        r0.e = r3;
        return;
    }

    public final void j(String r16, String r17) {
        e r1 = this.c.a(r16);
        HashMap r12 = new HashMap();
        if (r1 == null) goto L5;
        String r6 = r1.a();
    L6:
        if (r1 == null) goto L8;
        long r3 = r1.b();
    L9:
        long r7 = r3;
        String r2 = r16.concat(r17);
        e r4 = this.c.a(r16);
        String r5 = this.a.e(r2, "start_time");
        if (r5 == null) goto L22;
        long r8 = SystemClock.uptimeMillis() - CastLongProtector.parseLong(r5);     // Catch: Exception -> L17
        r12.put("stage", r17);     // Catch: Exception -> L17
        if (r4 != null) goto L14;
        String r9 = "";
    L15:
        e(r12, r8, r16, r6, r7, r9);     // Catch: Exception -> L17
        tt5.a.b("DriveDevPerformanceReport", "reportImportTimeCostEvent map = " + r12);     // Catch: Exception -> L17
        this.a.v("dev_performance_drive_import_stages", r12);     // Catch: Exception -> L17
        return;
    L14:
        r9 = r4.c();     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L22:
        return;
    L8:
        r3 = 0;
        goto L9
    L5:
        r6 = "";
        goto L6
    }

    public final void q(String r3, String r4) {
        r(r3, r4, SystemClock.uptimeMillis());
    }

    public static String c(String r0, String r1, int r2) {
        return r0.concat(r1).concat(String.valueOf(r2));
    }

    public final void b(String r3, String r4, com.bytedance.ee.bear.drive.config.strategy.d r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.startsWith("local_") == true) goto L14;
        if (r5 != null) goto L8;
    L10:
        int r6 = 0;
    L11:
        String r7 = c(r3, r4, r6);
        this.a.h(r7);
        this.a.j(r7, "start_time", String.valueOf(SystemClock.uptimeMillis()));
        return;
    L8:
        if ((r5 instanceof com.bytedance.ee.bear.drive.config.strategy.h) == false) goto L10;
        r6 = 1;
        goto L11
    }

    public final void i(String r16, String r17, String r18) {
        String r1 = "";
        if (r18 != null) goto L5;
        String r5 = "";
    L6:
        e r2 = this.c.a(r5);
        HashMap r11 = new HashMap();
        if (r2 == null) goto L9;
        String r6 = r2.a();
    L10:
        if (r2 == null) goto L12;
        long r3 = r2.b();
    L13:
        long r7 = r3;
        String r4 = this.a.e(r5.concat("dev_performance_drive_import_finish"), "start_time");
        if (r4 == null) goto L26;
        long r8 = SystemClock.uptimeMillis() - CastLongProtector.parseLong(r4);     // Catch: Exception -> L21
        r11.put("result_key", r16);     // Catch: Exception -> L21
        r11.put("result_code", r17);     // Catch: Exception -> L21
        if (r2 == null) goto L19;
        r1 = r2.c();     // Catch: Exception -> L21
    L19:
        e(r11, r8, r5, r6, r7, r1);     // Catch: Exception -> L21
        tt5.a.b("DriveDevPerformanceReport", "reportImportFinishEvent map = " + r11);     // Catch: Exception -> L21
        this.a.v("dev_performance_drive_import_finish", r11);     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        return;
    L26:
        return;
    L12:
        r3 = 0;
        goto L13
    L9:
        r6 = "";
        goto L10
    L5:
        r5 = r18;
        goto L6
    }

    public final void o(c.b r11, int r12, int r13) {
        if (r12 != 403) goto L5;
        k("nativeFail", "DEC4", r11.a, r13);
        return;
    L5:
        if (r12 != 404) goto L7;
    L48:
        k("nativeFail", "DEC27", r11.a, r13);
        return;
    L7:
        if (r12 != 1000) goto L9;
        tt5.a.h("DriveDevPerformanceReport", "reportRustDownloadFailedFinishEvent user cancel");
        return;
    L9:
        if (r12 != 1007) goto L11;
    L46:
        k("nativeFail", "DEC3", r11.a, r13);
        return;
    L11:
        if (r12 == 1010) goto L46;
        if (r12 != 1024) goto L15;
        tt5.a.h("DriveDevPerformanceReport", "reportRustDownloadFailedFinishEvent user not login");
        return;
    L15:
        if (r12 == 2003) goto L48;
        if (r12 != 3002) goto L19;
        k("nativeFail", "DEC16", r11.a, r13);
        return;
    L19:
        if (r12 == 900023001) goto L43;
        switch(r12) {
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
        k("nativeFail", "DEC3", r11.a, r13);
        return;
    L26:
        if (r12 != 401) goto L42;
        AccountService$Account r0 = ((h0) org.koin.java.a.a(h0.class)).G2();
        com.bytedance.ee.bear.lark.dependency.b r1 = (com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.b.class);
        boolean r3 = ((f) org.koin.java.a.a(f.class)).d0().y();
        String r4 = r1.getUserId();
        String r2 = r1.getSession();
        boolean r5 = true;
        if (r0 != null) goto L30;
    L34:
        boolean r7 = false;
    L35:
        tt5.a.h("DriveDevPerformanceReport", "isAccountStateError()  Drive initDone=" + r3 + " accountNotEquals=" + r7 + " account=" + r0 + " depUserId=" + r4 + " depToken=" + du5.b.i(r2));
        if (r3 == false) goto L40;
        if (r7 == true) goto L40;
        r5 = false;
    L40:
        if (r5 == false) goto L42;
        return;
    L30:
        if (TextUtils.equals(r0.uid, r4) == true) goto L34;
        if (TextUtils.equals(r0.token, r2) == true) goto L34;
        r7 = true;
    L42:
        l("rustFail", "DEC8", r11.a, r13, "rust error, code: " + r12);
        return;
    L43:
        tt5.a.h("DriveDevPerformanceReport", "reportRustDownloadFailedFinishEvent DRIVE_RUST_ERROR_CODE_ENCRYPTION_KEY_DELETED");
    }

    public final void r(String r12, String r13, long r14) {
        HashMap r10 = new HashMap();
        e r1 = this.c.a(r13);
        String r3 = this.a.e(c(r13, r12, 0), "start_time");
        if (r3 == null) goto L15;
        long r4 = r14 - CastLongProtector.parseLong(r3);     // Catch: Exception -> L10
        r10.put("stage", r12);     // Catch: Exception -> L10
        r10.put("loading_type", 0);     // Catch: Exception -> L10
        if (r1 == null) goto L7;
        e(r10, r4, r13, r1.a(), r1.b(), r1.c());     // Catch: Exception -> L10
    L8:
        tt5.a.b("DriveDevPerformanceReport", "reportTimeCostEvent 222 ==>" + r10);     // Catch: Exception -> L10
        this.a.v("dev_performance_drive_open_stages", r10);     // Catch: Exception -> L10
        return;
    L7:
        e(r10, r4, r13, "", 0, "");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void s(String r18, w75.a r19, com.bytedance.ee.bear.drive.config.strategy.d r20) {
        if (r19 != null) goto L5;
    L8:
        String r5 = "";
    L9:
        if (r19 != null) goto L11;
        String r6 = "";
    L12:
        if (r19 != null) goto L14;
    L17:
        long r3 = 0;
    L18:
        long r7 = r3;
        if (r5 != null) goto L21;
        return;
    L21:
        if (r5.startsWith("local_") == true) goto L45;
        HashMap r12 = new HashMap();
        if (r20 != null) goto L27;
    L29:
        int r1 = 0;
    L30:
        String r4 = c(r5, r18, r1);
        e r8 = this.c.a(r5);
        String r9 = this.a.e(r4, "start_time");
        if (r9 == null) goto L44;
        long r13 = SystemClock.uptimeMillis() - CastLongProtector.parseLong(r9);     // Catch: Exception -> L38
        r12.put("stage", r18);     // Catch: Exception -> L38
        r12.put("loading_type", Integer.valueOf(r1));     // Catch: Exception -> L38
        if (r8 != null) goto L35;
        String r10 = "";
    L36:
        e(r12, r13, r5, r6, r7, r10);     // Catch: Exception -> L38
        tt5.a.b("DriveDevPerformanceReport", "reportTimeCostEvent 111 ==>" + r12);     // Catch: Exception -> L38
        this.a.v("dev_performance_drive_open_stages", r12);     // Catch: Exception -> L38
        return;
    L35:
        r10 = r8.c();     // Catch: Exception -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
        return;
    L44:
        return;
    L27:
        if ((r20 instanceof com.bytedance.ee.bear.drive.config.strategy.h) == false) goto L29;
        r1 = 1;
        goto L30
    L45:
        return;
    L14:
        if (r19.c() == null) goto L17;
        r3 = r19.c().c;
        goto L18
    L11:
        r6 = r19.c().k;
        goto L12
    L5:
        if (r19.c() == null) goto L8;
        r5 = r19.c().a;
        goto L9
    }

    public final void t(String r4, String r5, String r6) {
        String r0 = e.e(r4, 3);
        e r1 = this.c.a(r0);
        if (r1 != null) goto L5;
        r1 = new e();
        this.c.b(r0, r1);
        this.c.b(r4, r1);
    L5:
        Bundle r7 = r1.c;
        if (r7 != null) goto L8;
        r7 = new Bundle();
    L8:
        r7.putString(r5, r6);
        r1.c = r7;
    }

    public final void k(String r8, String r9, String r10, int r11) {
        m(r8, r9, r10, r11, "", "");
    }

    public final void h(int r16, long r17, String r18, String r19, long r20) {
        if (r18 != null) goto L5;
        String r5 = "";
    L6:
        if (r19 != null) goto L8;
        String r6 = "";
    L9:
        HashMap r13 = new HashMap();
        e r2 = this.c.a(r5);
        r13.put("key", "server_transform");     // Catch: Exception -> L16
        r13.put("code", Integer.valueOf(r16));     // Catch: Exception -> L16
        if (r2 != null) goto L13;
        String r9 = "";
    L14:
        e(r13, r17, r5, r6, r20, r9);     // Catch: Exception -> L16
        tt5.a.b("DriveDevPerformanceReport", "reportDataCollection " + r13);     // Catch: Exception -> L16
        this.a.v("dev_performance_data_collection", r13);     // Catch: Exception -> L16
        return;
    L13:
        r9 = r2.c();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        tt5.a.f("DriveDevPerformanceReport", e, false);
        return;
    L8:
        r6 = r19;
        goto L9
    L5:
        r5 = r18;
        goto L6
    }

    public final void l(String r8, String r9, String r10, int r11, String r12) {
        m(r8, r9, r10, r11, "", r12);
    }

    public final void e(Map<String, Object> r1, long r2, String r4, String r5, long r6, String r8) {
        HashMap r3 = (HashMap) r1;
        r3.put("cost_time", Long.valueOf(r2));
        r3.put("file_token", du5.b.g(r4));
        if (TextUtils.isEmpty(r5) == false) goto L5;
        r3.put("file_type", r5);
    L6:
        r3.put("file_size", Long.valueOf(r6));
        if (this.b.G2() == null) goto L10;
        r3.put("user_id", du5.b.g(this.b.G2().uid));
        r3.put("tenant_id", du5.b.g(this.b.G2().tenantId));
    L10:
        if (TextUtils.isEmpty(r8) == true) goto L12;
        r3.put("preview_from", r8);
    L13:
        e r7 = this.c.a(r4);
        if (r7 != null) goto L16;
        return;
    L16:
        if (TextUtils.isEmpty(r7.d()) == true) goto L20;
        r3.put("sdkAppId", r7.d());
        return;
    L20:
        return;
    L12:
        tt5.a.k("DriveDevPerformanceReport", "PREVIEW_FROM is empty...");
        goto L13
    L5:
        r3.put("file_type", r5.toLowerCase());
        goto L6
    }

    public final void m(String r9, String r10, String r11, int r12, String r13, String r14) {
        n("dev_performance_drive_open_finish", r9, r10, r11, r12, r13, r14);
    }

    public final void p(String r2, String r3, String r4, String r5, String r6, Map<String, Object> r7) {
        HashMap r0 = new HashMap();
        if (r7 == null) goto L5;
        r0.putAll(r7);
    L5:
        r0.put("stage_code", r2);
        r0.put("view_id", r3);
        r0.put("view_type", r4);
        r0.put("result_code", r5);
        r0.put("error_message", r6);
        h r8 = this.d;
        if (r8 != null) goto L8;
    L10:
        AccountService$Account r9 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (r9 == null) goto L13;
        r0.put("user_id", du5.b.g(r9.uid));
        r0.put("tenant_id", du5.b.g(r9.tenantId));
    L13:
        r0.put("doc_network_status", String.valueOf(j.a.a.getNetworkState().getType()));
        r0.put("app_visible", String.valueOf(((com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class)).a()));
        r0.put("app_doze", String.valueOf(((com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class)).f()));
        r0.put("doc_network_level", String.valueOf(((f) org.koin.java.a.a(f.class)).d0().p().getValue()));
        this.a.n("dev_same_render_open_finish_dev", r0);
        return;
    L8:
        if (r8.a == false) goto L10;
        r0.put("preview_from", "vc");
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    public final void n(String r8, String r9, String r10, String r11, int r12, String r13, String r14) {
        HashMap r0 = new HashMap();
        r0.put("result_key", r9);
        r0.put("result_code", r10);
        r0.put("file_token", du5.b.g(r11));
        String r16 = "";
        if (TextUtils.isEmpty(r13) == false) goto L6;
        r13 = "";
    L6:
        r0.put("open_type", r13);
        if (TextUtils.isEmpty(r14) == false) goto L10;
        r14 = "";
    L10:
        r0.put("error_message", r14);
        r0.put("source_type", String.valueOf(r12));
        boolean r17 = false;
        String r1 = DiagramData$RESULT.FAIL;
        if (r12 != 3) goto L13;
    L14:
        String r18 = this.a.e(r11.concat("dev_performance_drive_open_finish").concat(DiagramData$RESULT.FAIL), "start_time");
        if (r18 != null) goto L92;
    L20:
        long r3 = -1;
    L21:
        r0.put("cost_time", Long.valueOf(r3));
        e r19 = this.c.a(e.e(r11, r12));
        if (r19 == null) goto L79;
        r0.put("preview_from", r19.c());
        if (TextUtils.isEmpty(r19.d()) == true) goto L26;
        r0.put("sdkAppId", r19.d());
    L26:
        r0.put("file_type", r19.a().toLowerCase());
        r0.put("file_size", Long.valueOf(r19.b()));
        w75.a r4 = r19.e;
        ?? r5 = -1;
        if (r4 == null) goto L29;
        int r6 = r4.e;
    L30:
        r0.put("preview_type", Integer.valueOf(r6));
        w75.a r7 = r19.e;
        if (r7 == null) goto L33;
        String r20 = r7.f;
    L35:
        if (TextUtils.isEmpty(r20) == true) goto L37;
        String r21 = r20.toLowerCase();
    L38:
        r0.put("preview_ext", r21);
        a95.a r22 = new a95.a();
        DriveFilePath.Companion.getClass();
        DriveFilePath r23 = DriveFilePath.a.a();
        w75.a r24 = r19.e;
        if (r24 == null) goto L42;
        r23 = r24.a();
    L42:
        if (r23.isEmpty() == true) goto L46;
        VFSFile r26 = z75.b.e(r23, r22.b);
        if (z75.b.d(r23, r22.b) == false) goto L46;
        long r27 = r26.length();
    L47:
        r0.put("preview_size", Long.valueOf(r27));
        w75.a r28 = r19.e;
        if (r28 == null) goto L50;
        r5 = r28.c.get();
    L50:
        r0.put("doc_has_cache", Integer.valueOf(r5));
        w75.a r29 = r19.e;
        if (r29 != null) goto L53;
        String r30 = "";
    L54:
        r0.put("mime_type", r30);
        w75.a r31 = r19.e;
        if (r31 == null) goto L58;
        r16 = r31.a.j;
    L58:
        r0.put("real_mime_type", r16);
        w75.a r110 = r19.e;
        if (r110 == null) goto L62;
        r17 = r110.d();
    L62:
        String r111 = DiagramData$RESULT.SUCCESS;
        if (r17 == false) goto L65;
        r1 = DiagramData$RESULT.SUCCESS;
    L65:
        r0.put("isRealType", r1);
        w75.a r112 = r19.e;
        if (r112 != null) goto L68;
        String r113 = ShowCardsJsData.ID_GLOBAL;
    L69:
        r0.put("cache_source_from", r113);
        Bundle r114 = r19.c;
        if (r114 == null) goto L76;
        Iterator<String> r2 = r114.keySet().iterator();
    L73:
        if (r2.hasNext() == false) goto L76;
        String r32 = r2.next();
        r0.put(r32, du5.b.f(r114.get(r32)));
    L76:
        if (r19.f == false) goto L78;
        r111 = "2";
    L78:
        r0.put("load_from", r111);
        goto L79
    L68:
        r113 = r112.w;
        goto L69
    L53:
        r30 = r29.a.f;
    L46:
        r27 = 0;
        goto L47
    L37:
        r21 = "";
        goto L38
    L33:
        r20 = "";
        goto L35
    L29:
        r6 = -1;
    L79:
        r0.put("tt_init", Boolean.valueOf(n.g().a.hasInit()));
        r0.put("tt_pluginstateenable", Boolean.valueOf(n.g().f()));
        r0.put("tt_pkgcanuseplugin", Boolean.valueOf(n.g().e()));
        r0.put("tt_netinitfalseuninstalled", Boolean.valueOf(n.g().b.get()));
        h r33 = this.d;
        if (r33 != null) goto L82;
    L84:
        AccountService$Account r34 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (r34 == null) goto L87;
        r0.put("user_id", du5.b.g(r34.uid));
        r0.put("tenant_id", du5.b.g(r34.tenantId));
    L87:
        r0.put("feishu_brand", String.valueOf(((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.b.class)).isFeishuBrand()));
        b0 r36 = (b0) org.koin.java.a.a(b0.class);
        r0.put("user_geo", String.valueOf(r36.isChinaMainlandGeo()));
        r0.put("is_private_ka_pkg", Boolean.valueOf(r36.f()));
        r0.put("is_lark_package", Boolean.valueOf(((k) org.koin.java.a.a(k.class)).isUsPackage()));
        r0.put("doc_network_status", String.valueOf(j.a.a.getNetworkState().getType()));
        r0.put("app_visible", String.valueOf(((com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class)).a()));
        r0.put("app_doze", String.valueOf(((com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class)).f()));
        r0.put("doc_network_level", String.valueOf(((f) org.koin.java.a.a(f.class)).d0().p().getValue()));
        if (TextUtils.equals(r8, "dev_performance_drive_open_finish") == false) goto L90;
        r0.put("is_forseti_fg_on", Boolean.valueOf(ForsetiHelper.p()));
        r0.put("is_in_forseti", Boolean.valueOf(this.f));
    L90:
        tt5.a.h("DriveDevPerformanceReport", "event = " + r8 + ", reportOpenFinishEvent, data: " + du5.b.f(r0));
        this.e.put(r11, Boolean.TRUE);
        this.a.v(r8, r0);
        return;
    L82:
        if (r33.a == false) goto L84;
        r0.put("preview_from", "vc");
        goto L84
    L92:
        r3 = SystemClock.uptimeMillis() - CastLongProtector.parseLong(r18);
    L18:
        e = move-exception;
        tt5.a.f("DriveDevPerformanceReport", e, false);
        goto L20
    L13:
        if (r12 != 5) goto L20;
        goto L14
    }
}
