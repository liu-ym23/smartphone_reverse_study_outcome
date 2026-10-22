package com.bytedance.bdturing;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cc4.g;
import com.alipay.sdk.m.u.i;
import com.bytedance.android.service.manager.push.client.intelligence.IClientFeatureService;
import com.bytedance.bdturing.livedetect.LiveDetectService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import jc4.m;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.k;
import qb4.n;
import qb4.s;
import vb4.e;

/* JADX INFO: loaded from: classes3.dex */
public final class EventReport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f201688a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f201689b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f201690c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f201691d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f201692e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f201693f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f201694g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f201695h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Long f201696i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f201697j;

    /* JADX INFO: loaded from: classes12.dex */
    public static final enum CloseType extends Enum<CloseType> {
        public static final CloseType CLOSE_FB_CLOSE = null;
        public static final CloseType CLOSE_FB_FEEDBACK = null;
        public static final CloseType CLOSE_FB_MASK = null;
        public static final CloseType CLOSE_FB_SYSTEM = null;
        public static final CloseType CLOSE_REASON_APP = null;
        public static final CloseType CLOSE_REASON_BACK = null;
        public static final CloseType CLOSE_REASON_MASK = null;
        public static final CloseType CLOSE_REASON_PAGE_LOAD_FAILED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CloseType[] f201698a = null;
        private String name;

        static {
            CloseType r100 = new CloseType("CLOSE_REASON_MASK", 0, "mask_click_close");
            CLOSE_REASON_MASK = r100;
            CloseType r101 = new CloseType("CLOSE_REASON_BACK", 1, "back_close");
            CLOSE_REASON_BACK = r101;
            CloseType r102 = new CloseType("CLOSE_REASON_APP", 2, "app_close");
            CLOSE_REASON_APP = r102;
            CloseType r103 = new CloseType("CLOSE_REASON_PAGE_LOAD_FAILED", 3, "page_load_failed_close");
            CLOSE_REASON_PAGE_LOAD_FAILED = r103;
            CloseType r104 = new CloseType("CLOSE_FB_MASK", 4, "close_fb_mask");
            CLOSE_FB_MASK = r104;
            CloseType r105 = new CloseType("CLOSE_FB_CLOSE", 5, "close_fb_close");
            CLOSE_FB_CLOSE = r105;
            CloseType r110 = new CloseType("CLOSE_FB_FEEDBACK", 6, "close_fb_feedback");
            CLOSE_FB_FEEDBACK = r110;
            CloseType r111 = new CloseType("CLOSE_FB_SYSTEM", 7, "close_fb_system");
            CLOSE_FB_SYSTEM = r111;
            f201698a = new CloseType[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static CloseType[] values() {
            return (CloseType[]) f201698a.clone();
        }

        public String getName() {
            return this.name;
        }

        public static CloseType valueOf(String r100) {
            return (CloseType) r27.a.a(CloseType.class, r100);
        }

        public CloseType(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public static void H(jc4.a r100) {
        JSONObject r101 = new JSONObject();
        r101.put("key", "background");     // Catch: JSONException -> L5
    L7:
        w("turing_verify_sdk", r101, r100);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void I(jc4.a r100) {
        JSONObject r101 = new JSONObject();
        r101.put("key", "pop");     // Catch: JSONException -> L6
        w("turing_verify_sdk", r101, r100);
        return;
    L6:
        e = move-exception;
        int r102 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void V(jc4.a r100) {
        f201688a = System.currentTimeMillis();
        JSONObject r101 = new JSONObject();
        r101.put("key", "verify_start");     // Catch: JSONException -> L6
        w("turing_verify_sdk", r101, r100);
        return;
    L6:
        e = move-exception;
        int r102 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void Y(jc4.a r100) {
        JSONObject r101 = new JSONObject();
        r101.put("key", "onAttachedToWindow");     // Catch: JSONException -> L6
        w("turing_verify_sdk", r101, r100);
        return;
    L6:
        e = move-exception;
        int r102 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void j(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("key", "touch_intercept_fail");     // Catch: JSONException -> L6
        r101.put("custom", r100);     // Catch: JSONException -> L6
        w("turing_verify_sdk", r101, null);
        return;
    L6:
        e = move-exception;
        int r102 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static boolean o(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L19;
        return false;
    L19:
        BdTuringConfig r101 = qb4.b.c.f532315a.f532302a;     // Catch: Throwable -> L16
        if (r101 == null) goto L8;
        Context r102 = r101.getApplicationContext();     // Catch: Throwable -> L16
    L9:
        if (r102 == null) goto L21;
        SharedPreferences r103 = r102.getSharedPreferences("turing_log_config", 0);     // Catch: Throwable -> L16
        String r104 = r103.getString(r100, "");     // Catch: Throwable -> L16
        Date r105 = new Date();     // Catch: Throwable -> L16
        String r106 = new SimpleDateFormat("yyyy-MM-dd").format(r105);     // Catch: Throwable -> L16
        int r107 = n.f532367a;     // Catch: Throwable -> L16
        if (r104 != null) goto L13;
        return false;
    L13:
        if (r104.equals(r106) == true) goto L23;
        SharedPreferences.Editor r108 = r103.edit();     // Catch: Throwable -> L16
        r108.putString(r100, r106);     // Catch: Throwable -> L16
        r108.commit();     // Catch: Throwable -> L16
        return true;
    L23:
        return false;
    L21:
        return false;
    L8:
        r102 = null;
    L16:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static void z(jc4.a r100) {
        JSONObject r101 = new JSONObject();
        r101.put("key", "report_no_captcha_data");     // Catch: JSONException -> L6
        r101.put("custom", "tracer_init:" + g.d().f23283f + i.f25853b + s.f532383e);     // Catch: JSONException -> L6
        w("turing_verify_sdk", r101, r100);
        return;
    L6:
        e = move-exception;
        int r102 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void A(jc4.a r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("key", "sdk_sate_error");     // Catch: JSONException -> L6
        r102.put("custom", r101);     // Catch: JSONException -> L6
        w("turing_verify_sdk", r102, r100);
        return;
    L6:
        e = move-exception;
        int r103 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void D(int r100, jc4.a r101) {
        JSONObject r102 = new JSONObject();
        r102.put("key", "senseless_dialog_close");     // Catch: JSONException -> L8
        r102.put("result", r100);     // Catch: JSONException -> L8
        if (TextUtils.isEmpty("") == true) goto L6;
        r102.put("custom", "");     // Catch: JSONException -> L8
    L6:
        w("turing_verify_sdk", r102, r101);
        return;
    L8:
        e = move-exception;
        int r103 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void F(int r100, boolean r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L8
        r102.put("key", "sensor_state");     // Catch: Exception -> L8
        r102.put("type", r100);     // Catch: Exception -> L8
        if (r101 == false) goto L5;
        int r103 = 0;
    L6:
        r102.put("result", r103);     // Catch: Exception -> L8
        w("turing_verify_sdk", r102, null);     // Catch: Exception -> L8
        return;
    L5:
        r103 = 1;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static void G(CloseType r100, jc4.a r101) {
        JSONObject r102 = new JSONObject();
        r102.put("duration", System.currentTimeMillis() - f201688a);     // Catch: JSONException -> L6
        r102.put("result", r100.getName());     // Catch: JSONException -> L6
        r102.put("key", "close");     // Catch: JSONException -> L6
        w("turing_verify_sdk", r102, r101);
        return;
    L6:
        e = move-exception;
        int r103 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void K(int r100, jc4.a r101) {
        JSONObject r102 = new JSONObject();
        r102.put("result", r100);     // Catch: JSONException -> L6
        r102.put("key", "orientation");     // Catch: JSONException -> L6
        w("turing_verify_sdk", r102, r101);
        return;
    L6:
        e = move-exception;
        int r103 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void L(int r100, jc4.a r101) {
        JSONObject r102 = new JSONObject();
        r102.put("result", r100);     // Catch: JSONException -> L6
        r102.put("key", "orientation_change");     // Catch: JSONException -> L6
        w("turing_verify_sdk", r102, r101);
        return;
    L6:
        e = move-exception;
        int r103 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void M(long r100, BdTuringConfig r101) {
        if (o("turing_init_date") == false) goto L12;
        JSONObject r102 = new JSONObject();
        r102.put("duration", r100);     // Catch: JSONException -> L7
        r102.put("key", "init");     // Catch: JSONException -> L7
        r102.put("custom", r101.toString());     // Catch: JSONException -> L7
        w("turing_verify_sdk", r102, null);
        return;
    L7:
        e = move-exception;
        int r103 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
        return;
    }

    public static void N(int r100, jc4.a r101) {
        JSONObject r102 = new JSONObject();
        r102.put("duration", System.currentTimeMillis() - f201688a);     // Catch: JSONException -> L6
        r102.put("result", r100);     // Catch: JSONException -> L6
        r102.put("key", "result");     // Catch: JSONException -> L6
        w("turing_verify_sdk", r102, r101);
        return;
    L6:
        e = move-exception;
        int r103 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void R(String r100, jc4.a r101) {
        JSONObject r102 = new JSONObject();
        r102.put("duration", System.currentTimeMillis() - f201688a);     // Catch: JSONException -> L6
        r102.put("key", r100.concat("_onCreate"));     // Catch: JSONException -> L6
        w("turing_verify_sdk", r102, r101);
        return;
    L6:
        e = move-exception;
        int r103 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void S(jc4.a r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("key", "verify_conflict");     // Catch: JSONException -> L6
        r102.put("custom", r101);     // Catch: JSONException -> L6
        w("turing_verify_sdk", r102, r100);
        return;
    L6:
        e = move-exception;
        int r103 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void W(boolean r100, String r101) {
        JSONObject r102 = new JSONObject();
        if (r100 == false) goto L6;
        int r103 = 0;
    L19:
        r102.put("result", r103);     // Catch: JSONException -> L16
        r102.put("key", "client_status_report_result");     // Catch: JSONException -> L16
        if (TextUtils.isEmpty(r101) == false) goto L10;
    L14:
        w("turing_verify_sdk", r102, null);
        return;
    L10:
        if (r101 != null) goto L13;
        r101 = "";
    L13:
        r102.put("custom", r101);     // Catch: JSONException -> L16
    L16:
        e = move-exception;
        int r104 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
        return;
    L6:
        r103 = 1;
        goto L19
    }

    public static void a(int r100, jc4.a r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L4
        r102.put("key", "turing_live_detect_camera_permission");     // Catch: Exception -> L4
        r102.put("result", r100);     // Catch: Exception -> L4
        w("turing_verify_sdk", r102, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void f(JSONObject r100, jc4.a r110) {
        BdTuringConfig r101 = qb4.b.c.f532315a.f532302a;     // Catch: Exception -> L53
        if (r101 == null) goto L6;
        r100.put("sdk_version", "4.1.1.cn");     // Catch: Exception -> L53
        r100.put("host_app_id", r101.getAppId());     // Catch: Exception -> L53
    L6:
        r100.put("is_back_ground", g.d().f23279b);     // Catch: Exception -> L53
        r100.put("app_first_launch", e.d());     // Catch: Exception -> L53
        if (f201689b <= 0) goto L10;
        r100.put("app_alive_time", System.currentTimeMillis() - f201689b);     // Catch: Exception -> L53
    L10:
        boolean r102 = false;
        String r103 = "1";
        if (r100.has("verify_use_dialog_v2") == true) goto L21;
        com.bytedance.bdturing.setting.e r104 = com.bytedance.bdturing.setting.e.f202077a;     // Catch: Exception -> L53
        if (com.bytedance.bdturing.setting.e.e("common").optInt("verify_use_dialog_v2", 0) != 1) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L18;
        Object r106 = "1";
    L19:
        r100.put("verify_use_dialog_v2", r106);     // Catch: Exception -> L53
        goto L21
    L18:
        r106 = "0";
        goto L19
    L15:
        r105 = false;
    L21:
        if (r100.has("h5_load_retry_enable") == true) goto L30;
        com.bytedance.bdturing.setting.e r107 = com.bytedance.bdturing.setting.e.f202077a;     // Catch: Exception -> L53
        if (com.bytedance.bdturing.setting.e.e("common").optInt("h5_load_retry_enable", 0) != 1) goto L25;
        r102 = true;
    L25:
        if (r102 == false) goto L27;
        Object r108 = "1";
    L28:
        r100.put("h5_load_retry_enable", r108);     // Catch: Exception -> L53
        goto L30
    L27:
        r108 = "0";
    L30:
        if (r100.has("verify_cancellable") == true) goto L37;
        com.bytedance.bdturing.setting.e r109 = com.bytedance.bdturing.setting.e.f202077a;     // Catch: Exception -> L53
        if (com.bytedance.bdturing.setting.e.i() == true) goto L35;
        r103 = "0";
    L35:
        r100.put("verify_cancellable", r103);     // Catch: Exception -> L53
    L37:
        if (r110 == null) goto L49;
        if (r100.has("shark_log_id") == true) goto L41;
        r100.put("shark_log_id", r110.f498093d);     // Catch: Exception -> L53
    L41:
        r100.put("mode", r110.g());     // Catch: Exception -> L53
        r100.put("request_type", r110.getType());     // Catch: Exception -> L53
        r100.put("call_type", r110.f498097h);     // Catch: Exception -> L53
        r100.put("h5_popup", r110.f498094e);     // Catch: Exception -> L53
        r100.put("verify_scene", r110.f498095f);     // Catch: Exception -> L53
        r100.put("verify_type_code", r110.f498100k);     // Catch: Exception -> L53
        r100.put("verify_sub_type", r110.f498101l);     // Catch: Exception -> L53
        if (r110.getType() == 16) goto L44;
        return;
    L44:
        if (LiveDetectService.getInstance().useByteNN() == false) goto L46;
        String r111 = "byteNN";
    L47:
        r100.put("engine_type", r111);     // Catch: Exception -> L53
        return;
    L46:
        r111 = IClientFeatureService.INVOKE_SCENE_PITAYA;
        goto L47
    L49:
        if (r100.has("shark_log_id") == true) goto L51;
        r100.put("shark_log_id", f201690c);     // Catch: Exception -> L53
    L51:
        r100.put("mode", f201691d);     // Catch: Exception -> L53
        r100.put("request_type", f201693f);     // Catch: Exception -> L53
        r100.put("call_type", f201694g);     // Catch: Exception -> L53
        r100.put("h5_popup", f201695h);     // Catch: Exception -> L53
        r100.put("verify_scene", f201692e);     // Catch: Exception -> L53
        r100.put("verify_type_code", f201696i);     // Catch: Exception -> L53
        r100.put("verify_sub_type", f201697j);     // Catch: Exception -> L53
        return;
    L53:
        e = move-exception;
        e.printStackTrace();
    }

    public static void g(boolean r100, m r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L8
        r102.put("key", "confirm_dialog_display");     // Catch: Exception -> L8
        if (r100 == false) goto L5;
        int r103 = 0;
    L6:
        r102.put("result", r103);     // Catch: Exception -> L8
        w("turing_verify_sdk", r102, r101);     // Catch: Exception -> L8
        return;
    L5:
        r103 = 1;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static void k(int r100, jc4.a r101) {
        JSONObject r102 = new JSONObject();
        r102.put("result", r100);     // Catch: JSONException -> L12
        r102.put("key", "agree");     // Catch: JSONException -> L12
        com.bytedance.bdturing.setting.e r103 = com.bytedance.bdturing.setting.e.f202077a;     // Catch: JSONException -> L12
        boolean r104 = false;
        if (com.bytedance.bdturing.setting.e.e("common").optInt("identity_use_dialog_v2", 0) != 1) goto L6;
        r104 = true;
    L6:
        if (r104 == false) goto L8;
        String r105 = "1";
    L9:
        r102.put("verify_use_dialog_v2", r105);     // Catch: JSONException -> L12
        w("turing_verify_sdk", r102, r101);
        return;
    L8:
        r105 = "0";
    L12:
        e = move-exception;
        int r106 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void l(int r100, jc4.a r101) {
        JSONObject r102 = new JSONObject();
        r102.put("is_success", r100);     // Catch: JSONException -> L6
        r102.put("key", "front_pop");     // Catch: JSONException -> L6
        w("turing_verify_sdk", r102, r101);
        return;
    L6:
        e = move-exception;
        int r103 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void m(int r100, jc4.a r101) {
        JSONObject r102 = new JSONObject();
        r102.put("is_success", r100);     // Catch: JSONException -> L6
        r102.put("key", "load_real_name");     // Catch: JSONException -> L6
        w("turing_verify_sdk", r102, r101);
        return;
    L6:
        e = move-exception;
        int r103 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void n(boolean r100, String r101) {
        JSONObject r102 = new JSONObject();
    L14:
        e = move-exception;
        int r103 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
        return;
    L4:
        if (qb4.b.class.getName().equals(r101) == true) goto L6;
    L8:
        r102.put("key", "pty_init");     // Catch: JSONException -> L14
        if (r100 == false) goto L11;
        int r104 = 0;
    L12:
        r102.put("result", r104);     // Catch: JSONException -> L14
        r102.put("custom", r101);     // Catch: JSONException -> L14
        w("turing_verify_sdk", r102, null);     // Catch: JSONException -> L14
        return;
    L11:
        r104 = 1;
        goto L12
    L6:
        if (o("turing_pty_init_date") == true) goto L8;
    }

    public static void q(boolean r100, jc4.a r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L8
        r102.put("key", "live_start_btn_click");     // Catch: Exception -> L8
        if (r100 == false) goto L5;
        int r103 = 1;
    L6:
        r102.put("result", r103);     // Catch: Exception -> L8
        w("turing_verify_sdk", r102, r101);     // Catch: Exception -> L8
        return;
    L5:
        r103 = 0;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static void u(int r100, String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L4
        r102.put("key", "local_cache_state");     // Catch: Exception -> L4
        r102.put("result", r100);     // Catch: Exception -> L4
        r102.put("custom", r101);     // Catch: Exception -> L4
        w("turing_verify_sdk", r102, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void v(boolean r100, jc4.a r101) {
        JSONObject r102 = new JSONObject();
        BdTuringConfig r103 = qb4.b.c.f532315a.f532302a;     // Catch: JSONException -> L14
        if (r103 == null) goto L6;
        String r104 = r103.getDeviceId();     // Catch: JSONException -> L14
    L7:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_DID, r104);     // Catch: JSONException -> L14
        if (r100 == false) goto L10;
        int r105 = 0;
    L11:
        r102.put("result", r105);     // Catch: JSONException -> L14
        r102.put("key", "login_result");     // Catch: JSONException -> L14
        w("turing_verify_sdk", r102, r101);
        return;
    L10:
        r105 = 1;
        goto L11
    L6:
        r104 = "";
    L14:
        e = move-exception;
        int r106 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void O(int r100, long r101, jc4.a r102) {
        JSONObject r103 = new JSONObject();
        r103.put("duration", r101);     // Catch: JSONException -> L6
        r103.put("result", r100);     // Catch: JSONException -> L6
        r103.put("key", "turingH5LoadResult");     // Catch: JSONException -> L6
        w("turing_verify_sdk", r103, r102);
        return;
    L6:
        e = move-exception;
        int r104 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void P(long r100, String r101, jc4.a r102) {
        JSONObject r103 = new JSONObject();
        r103.put("duration", r100);     // Catch: JSONException -> L6
        r103.put("key", r101.concat("_onDestroy"));     // Catch: JSONException -> L6
        w("turing_verify_sdk", r103, r102);
        return;
    L6:
        e = move-exception;
        int r104 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void Q(boolean r100, JSONObject r101, jc4.a r102) {
        JSONObject r103 = new JSONObject();
        r103.put("duration", System.currentTimeMillis() - f201688a);     // Catch: JSONException -> L14
        if (r100 == false) goto L6;
        int r104 = 0;
    L7:
        r103.put("result", r104);     // Catch: JSONException -> L14
        r103.put("key", "twice_verify_result");     // Catch: JSONException -> L14
        if (r101 == null) goto L10;
        String r105 = r101.toString();     // Catch: JSONException -> L14
    L11:
        r103.put("custom", r105);     // Catch: JSONException -> L14
        w("turing_verify_sdk", r103, r102);
        return;
    L10:
        r105 = "";
        goto L11
    L6:
        r104 = 1;
    L14:
        e = move-exception;
        int r106 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void T(int r100, String r101, m r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L4
        r103.put("key", "verify_protect_notify_result");     // Catch: Exception -> L4
        r103.put("result", r100);     // Catch: Exception -> L4
        r103.put("custom", r101);     // Catch: Exception -> L4
        w("turing_verify_sdk", r103, r102);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void U(int r100, JSONObject r101, m r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L4
        r103.put("key", "verify_protect_result");     // Catch: Exception -> L4
        r103.put("result", r100);     // Catch: Exception -> L4
        r103.put("custom", r101);     // Catch: Exception -> L4
        w("turing_verify_sdk", r103, r102);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void c(boolean r100, String r101, jc4.a r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L8
        r103.put("key", "turing_live_remote_result");     // Catch: Exception -> L8
        if (r100 == false) goto L5;
        int r104 = 0;
    L6:
        r103.put("result", r104);     // Catch: Exception -> L8
        r103.put("custom", r101);     // Catch: Exception -> L8
        w("turing_verify_sdk", r103, r102);     // Catch: Exception -> L8
        return;
    L5:
        r104 = 1;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static void e(boolean r100, String r101, jc4.a r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L8
        r103.put("key", "turing_verify_state");     // Catch: Exception -> L8
        r103.put("custom", r101);     // Catch: Exception -> L8
        if (r100 == false) goto L5;
        int r104 = 0;
    L6:
        r103.put("result", r104);     // Catch: Exception -> L8
        w("turing_verify_sdk", r103, r102);     // Catch: Exception -> L8
        return;
    L5:
        r104 = 1;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static void h(boolean r100, String r101, jc4.a r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L8
        r103.put("key", "turing_live_create_session_result");     // Catch: Exception -> L8
        if (r100 == false) goto L5;
        int r104 = 0;
    L6:
        r103.put("result", r104);     // Catch: Exception -> L8
        r103.put("custom", r101);     // Catch: Exception -> L8
        w("turing_verify_sdk", r103, r102);     // Catch: Exception -> L8
        return;
    L5:
        r104 = 1;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static void i(int r100, JSONObject r101, jc4.a r102) {
        JSONObject r103 = new JSONObject();
        r103.put("duration", System.currentTimeMillis() - f201688a);     // Catch: JSONException -> L10
        r103.put("result", r100);     // Catch: JSONException -> L10
        r103.put("key", "final_verify_result");     // Catch: JSONException -> L10
        if (r101 == null) goto L6;
        String r104 = r101.toString();     // Catch: JSONException -> L10
    L7:
        r103.put("custom", r104);     // Catch: JSONException -> L10
        w("turing_verify_sdk", r103, r102);
        return;
    L6:
        r104 = "";
    L10:
        e = move-exception;
        int r105 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void p(int r100, String r101, jc4.a r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L4
        r103.put("key", "live_detect_error");     // Catch: Exception -> L4
        r103.put("result", r100);     // Catch: Exception -> L4
        r103.put("custom", r101);     // Catch: Exception -> L4
        w("turing_verify_sdk", r103, r102);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void startActivity(boolean r100, String r101, jc4.a r102) {
        JSONObject r103 = new JSONObject();
        r103.put("key", "start_activity");     // Catch: JSONException -> L10
        if (r100 == false) goto L6;
        int r104 = 0;
    L7:
        r103.put("result", r104);     // Catch: JSONException -> L10
        r103.put("custom", r101);     // Catch: JSONException -> L10
        w("turing_verify_sdk", r103, r102);
        return;
    L6:
        r104 = 1;
    L10:
        e = move-exception;
        int r105 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void w(String r100, JSONObject r101, jc4.a r102) {
        if (TextUtils.isEmpty(r100) == false) goto L16;
        return;
    L16:
        r101.put("params_for_special", "turing");     // Catch: Exception -> L13
        f(r101, r102);     // Catch: Exception -> L13
        BdTuringConfig r103 = qb4.b.c.f532315a.f532302a;     // Catch: Exception -> L13
        if (r103 == null) goto L8;
        k r104 = r103.getEventClient();     // Catch: Exception -> L13
    L9:
        if (r104 == null) goto L11;
        r104.onEvent(r100, r101);     // Catch: Exception -> L13
    L11:
        int r105 = n.f532367a;     // Catch: Exception -> L13
        return;
    L8:
        r104 = null;
    L13:
        e = move-exception;
        int r106 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void x(String r100, int r101, jc4.a r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L4
        r103.put("key", "turing_live_detect_page_close");     // Catch: Exception -> L4
        r103.put("custom", r100);     // Catch: Exception -> L4
        r103.put("result", r101);     // Catch: Exception -> L4
        w("turing_verify_sdk", r103, r102);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void y(String r100, boolean r101, jc4.a r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L8
        r103.put("key", "turing_live_detect_page_display");     // Catch: Exception -> L8
        r103.put("custom", r100);     // Catch: Exception -> L8
        if (r101 == false) goto L5;
        int r104 = 0;
    L6:
        r103.put("result", r104);     // Catch: Exception -> L8
        w("turing_verify_sdk", r103, r102);     // Catch: Exception -> L8
        return;
    L5:
        r104 = 1;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static void B(List<com.bytedance.bdturing.livedetect.pty.a> r100, boolean r110, JSONObject r111, jc4.a r112) {
        if (r100 == null) goto L26;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (r100.size() <= 0) goto L27;
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L18
        r101.put("key", "turing_live_detect_frame_results");     // Catch: Exception -> L18
        JSONArray r102 = new JSONArray();     // Catch: Exception -> L18
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r104 >= r100.size()) goto L12;
        com.bytedance.bdturing.livedetect.pty.a r105 = (com.bytedance.bdturing.livedetect.pty.a) ListProtector.get(r100, r104);     // Catch: Exception -> L18
        if (r105 == null) goto L11;
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L18
        r106.put("status", r105.f201918a);     // Catch: Exception -> L18
        r106.put("ts", r105.f201919b);     // Catch: Exception -> L18
        r106.put("engineTime", r105.f201920c);     // Catch: Exception -> L18
        r106.put("dataConvertTime", r105.f201921d);     // Catch: Exception -> L18
        r106.put("log", r105.f201922e);     // Catch: Exception -> L18
        r102.put(r106);     // Catch: Exception -> L18
    L11:
        r104 = r104 + 1;     // Catch: Exception -> L18
        goto L7
    L12:
        r101.put("last_frame_result", r111);     // Catch: Exception -> L18
        r101.put("result", r102);     // Catch: Exception -> L18
        if (r110 == true) goto L16;
        r103 = 1;
    L16:
        r101.put("custom", r103);     // Catch: Exception -> L18
        w("turing_verify_sdk", r101, r112);     // Catch: Exception -> L18
        return;
    L27:
        return;
    }

    public static void C(jc4.a r100, int r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        r104.put("key", "send_request_retry");     // Catch: JSONException -> L9
        StringBuilder r105 = new StringBuilder("retry_num=");     // Catch: JSONException -> L9
        r105.append(r101);     // Catch: JSONException -> L9
        if (TextUtils.isEmpty(r103) == true) goto L6;
        r105.append(";errorMessage=");     // Catch: JSONException -> L9
        r105.append(r103);     // Catch: JSONException -> L9
    L6:
        r104.put("request_path", "nocaptcha/report");     // Catch: JSONException -> L9
        r104.put("type", r102);     // Catch: JSONException -> L9
        r104.put("custom", r105.toString());     // Catch: JSONException -> L9
        w("turing_verify_sdk", r104, r100);
        return;
    L9:
        e = move-exception;
        int r106 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void E(jc4.a r100, int r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        r104.put("result", r101);     // Catch: JSONException -> L6
        r104.put("key", "senseless_report_result");     // Catch: JSONException -> L6
        r104.put("type", r102);     // Catch: JSONException -> L6
        r104.put("custom", "lifeCycleRegister result:" + s.b().f532384a + i.f25853b + r103);     // Catch: JSONException -> L6
        w("turing_verify_sdk", r104, r100);
        return;
    L6:
        e = move-exception;
        int r105 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void J(int r100, String r101, int r102, jc4.a r103) {
        JSONObject r104 = new JSONObject();
        r104.put("duration", System.currentTimeMillis() - f201688a);     // Catch: JSONException -> L6
        r104.put("result", r100);     // Catch: JSONException -> L6
        r104.put("custom", r101);     // Catch: JSONException -> L6
        r104.put("key", "load_webview");     // Catch: JSONException -> L6
        r104.put(com.bytedance.android.ec.core.event.a.KEY_HIT_CACHE, r102);     // Catch: JSONException -> L6
        r104.put("cache_sate", rb4.c.e().f536925g);     // Catch: JSONException -> L6
        w("turing_verify_sdk", r104, r103);
        return;
    L6:
        e = move-exception;
        int r105 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static void X(boolean r100, boolean r101, long r102, jc4.a r103) {
        JSONObject r104 = new JSONObject();
        int r105 = 1;
        if (r100 == false) goto L6;
        int r106 = 1;
    L17:
        r104.put("pageFinished", r106);     // Catch: JSONException -> L14
        if (r101 == true) goto L11;
        r105 = 0;
    L11:
        r104.put("loadFail", r105);     // Catch: JSONException -> L14
        r104.put("duration", r102);     // Catch: JSONException -> L14
        r104.put("key", "onDetachedFromWindow");     // Catch: JSONException -> L14
        w("turing_verify_sdk", r104, r103);
        return;
    L14:
        e = move-exception;
        int r107 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
        return;
    L6:
        r106 = 0;
        goto L17
    }

    public static void b(boolean r100, long r101, String r102, jc4.a r103) {
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L8
        r104.put("key", "turing_live_local_result");     // Catch: Exception -> L8
        r104.put("duration", r101);     // Catch: Exception -> L8
        if (r100 == false) goto L5;
        int r105 = 0;
    L6:
        r104.put("result", r105);     // Catch: Exception -> L8
        r104.put("custom", r102);     // Catch: Exception -> L8
        w("turing_verify_sdk", r104, r103);     // Catch: Exception -> L8
        return;
    L5:
        r105 = 1;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static void d(String r100, boolean r101, String r102, long r103) {
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L8
        r104.put("key", "load_bytenn_plugin");     // Catch: Exception -> L8
        if (r101 == false) goto L5;
        int r105 = 0;
    L6:
        r104.put("result", r105);     // Catch: Exception -> L8
        r104.put("custom", r100);     // Catch: Exception -> L8
        r104.put("duration", r103);     // Catch: Exception -> L8
        r104.put("msg", r102);     // Catch: Exception -> L8
        w("turing_verify_sdk", r104, null);     // Catch: Exception -> L8
        return;
    L5:
        r105 = 1;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static void r(int r100, int r101, String r102, jc4.a r103) {
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L5
        r104.put("key", "turing_live_dialog_state");     // Catch: Exception -> L5
        r104.put("custom", "type=" + r100 + ":state=" + r101 + ":scene=liveDetectPage:msg=" + r102);     // Catch: Exception -> L5
        w("turing_verify_sdk", r104, r103);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static void t(boolean r100, String r101, String r102, jc4.a r103) {
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L8
        r104.put("key", "live_dispatch_result");     // Catch: Exception -> L8
        r104.put("custom", r102);     // Catch: Exception -> L8
        if (r100 == false) goto L5;
        int r105 = 0;
    L6:
        r104.put("result", r105);     // Catch: Exception -> L8
        r104.put("live_dispatch_type", r101);     // Catch: Exception -> L8
        w("turing_verify_sdk", r104, r103);     // Catch: Exception -> L8
        return;
    L5:
        r105 = 1;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static void s(boolean r100, String r101, String r102, String r103, jc4.a r104) {
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L8
        r105.put("key", "live_dispatch");     // Catch: Exception -> L8
        r105.put("custom", r101 + ":errorMessage=" + r103);     // Catch: Exception -> L8
        r105.put("live_dispatch_type", r102);     // Catch: Exception -> L8
        if (r100 == false) goto L5;
        int r106 = 0;
    L6:
        r105.put("result", r106);     // Catch: Exception -> L8
        w("turing_verify_sdk", r105, r104);     // Catch: Exception -> L8
        return;
    L5:
        r106 = 1;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
