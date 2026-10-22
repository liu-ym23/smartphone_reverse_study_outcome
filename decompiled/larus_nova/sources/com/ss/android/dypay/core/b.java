package com.ss.android.dypay.core;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.view.Display;
import android.view.WindowManager;
import com.android.ttcjpaysdk.integrated.counter.outerpay.CJOuterPayManager;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.ss.android.dypay.activity.DyPayEntranceActivity;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.dypay.api.IDyPayResultCallback;
import com.ss.android.dypay.base.d;
import com.ss.android.dypay.base.f;
import com.ss.android.dypay.utils.e;
import com.ss.android.dypay.utils.h;
import com.ss.android.dypay.utils.j;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.dypay.bean.c f408465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f408466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public vta.b f408467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f408468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Activity f408469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f408470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IDyPayResultCallback f408471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f408472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f408473i;

    public static final class a implements IDyPayResultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f408474a;

        public a(b r100) {
            this.f408474a = r100;
        }

        @Override // com.ss.android.dypay.api.IDyPayResultCallback
        public final void onResult(Map<String, String> r100) {
            IDyPayResultCallback r101 = this.f408474a.f408471g;
            if (r101 == null) goto L5;
            r101.onResult(r100);
        L5:
            JSONObject r102 = sta.a.f543575a;
            d r103 = this.f408474a.f408466b;
            JSONObject r104 = new JSONObject();
            r104.put("code", r100.get("resultCode"));     // Catch: Exception -> L22
        L25:
            r104.put("msg", r100.get("errorMsg"));     // Catch: Exception -> L10
        L11:
            sta.a.b(r103, "out_wallet_rd_dy_pay_result_callback", r104, -1);
            b r105 = this.f408474a;
            vta.b r106 = r105.f408467c;
            if (r106 != null) goto L15;
            SharedPreferences r107 = vta.d.f557260a;
            com.ss.android.dypay.bean.c r108 = r105.f408465a;
            r106 = vta.d.b(r108.f408458b, r108.f408457a);
            r105.f408467c = r106;
        L15:
            if (r106 != null) goto L17;
            return;
        L17:
            if (r106.f557248a.f557284l != true) goto L28;
            f r109 = com.ss.android.dypay.base.a.f408435a;
            if (r109 == null) goto L29;
            r109.b();
            return;
        L29:
            return;
        }
    }

    public final String a() {
        Map<String, String> r100 = this.f408470f;
        if (r100 == null) goto L13;
        Map r101 = MapsKt.toMutableMap(r100);
        if (r101 == null) goto L13;
        r101.put("sign", URLEncoder.encode((String) r101.get("sign"), "UTF-8"));
        r101.put(DyPayConstant.KEY_OUTER_DID, com.ss.android.dypay.base.b.a());
        JSONObject r102 = new JSONObject(r101);     // Catch: Exception -> L9
    L10:
        String r103 = r102.toString();
        if (r103 == null) goto L13;
        return r103;
    L9:
        r102 = new JSONObject();
    L13:
        return "";
    }

    public final void b() {
        String r100 = "";
        String r101 = "";
        LinkedHashMap r110 = new LinkedHashMap();
        Map<String, String> r102 = this.f408470f;
        if (r102 == null) goto L49;
        r100 = r102.get(DyPayConstant.K_PAY_INFO_PARAM_PARTNERID);
        if (r100 != null) goto L8;
        r100 = "";
    L8:
        r101 = r102.get("appid");
        if (r101 != null) goto L12;
        r101 = "";
    L12:
        Activity r103 = this.f408469e;
        if (r103 == null) goto L17;
        String r104 = r103.getPackageName();
        if (r104 == null) goto L17;
    L18:
        r110.put("outer_pkg_name", r104);
        Activity r105 = this.f408469e;
        if (r105 != null) goto L281;
    L29:
        String r106 = "";
    L30:
        r110.put("outer_app_name", r106);
        String r107 = r102.get(DyPayConstant.K_PAY_INFO_PARAM_PREPAYID);
        if (r107 != null) goto L34;
        r107 = "";
    L34:
        r110.put("prepay_id", r107);
        String r108 = r102.get("is_auto_mate_x");
        if (r108 != null) goto L38;
        r108 = "";
    L38:
        r110.put("is_auto_mate_x", r108);
        r110.put("outer_sdk_version", "1.0.0.lite");
        r110.put(DyPayConstant.KEY_OUTER_DID, com.ss.android.dypay.base.b.a());
        Activity r109 = this.f408469e;     // Catch: Exception -> L243
        if (r109 == null) goto L47;
        WindowManager r111 = r109.getWindowManager();     // Catch: Exception -> L243
        if (r111 == null) goto L47;
        Display r112 = r111.getDefaultDisplay();     // Catch: Exception -> L243
        if (r112 == null) goto L47;
        int r113 = r112.getRotation();     // Catch: Exception -> L243
    L48:
        r110.put("window_rotation", Integer.valueOf(r113));
    L47:
        r113 = 0;
        goto L48
    L281:
        PackageManager r114 = r105.getPackageManager();     // Catch: Exception -> L244
        if (r114 == null) goto L29;
        String r115 = r105.getPackageName();     // Catch: Exception -> L244
        if (r115 != null) goto L26;
        r115 = "";
    L26:
        r106 = r114.getApplicationLabel(r114.getApplicationInfo(r115, 128)).toString();     // Catch: Exception -> L244
        if (r106 == null) goto L29;
    L17:
        r104 = "";
    L49:
        String r116 = r100;
        String r117 = r101;
        LinkedHashMap r118 = new LinkedHashMap();
        Map<String, String> r119 = this.f408470f;
        if (r119 == null) goto L55;
        Iterator<Map.Entry<String, String>> r120 = r119.entrySet().iterator();
    L53:
        if (r120.hasNext() == false) goto L55;
        Map.Entry<String, String> r121 = r120.next();
        r118.put(r121.getKey(), r121.getValue());
    L55:
        com.ss.android.dypay.bean.c r122 = this.f408465a;
        if (r122.f408459c.length() <= 0) goto L58;
        boolean r123 = true;
    L59:
        if (r123 == false) goto L62;
        String r124 = r122.f408459c;
    L74:
        if (r124 != null) goto L76;
    L79:
        boolean r125 = true;
    L80:
        Long r126 = null;
        if (r125 == false) goto L84;
        r124 = null;
    L84:
        if (r124 != null) goto L87;
        StringBuilder r127 = new StringBuilder();
        r127.append(System.currentTimeMillis());
        r127.append(new SecureRandom().nextInt(10000));
        r124 = r127.toString();
    L87:
        d r128 = new d(r124, r116, r117, System.currentTimeMillis(), r118, r110);
        this.f408466b = r128;
        JSONObject r129 = sta.a.f543575a;
        sta.a.a(this.f408469e);
        JSONObject r130 = new JSONObject();
        r130.put("rom_version", j.b());     // Catch: Exception -> L245
    L89:
        sta.a.b(r128, "out_wallet_cashier_client_entrance_in", r130, -1);
        h r131 = h.f408499b;
        com.ss.android.dypay.bean.c r132 = this.f408465a;
        monitor-enter(r131);
        SharedPreferences r133 = vta.d.f557260a;     // Catch: Throwable -> L134
        vta.b r134 = vta.d.b(r132.f408458b, r132.f408457a);     // Catch: Throwable -> L134
        if (r134 == null) goto L96;
        vta.f r135 = r134.f557253f;     // Catch: Throwable -> L134
        if (r135 == null) goto L96;
        int r136 = r135.f557267a;     // Catch: Throwable -> L134
    L97:
        long r137 = 1000;
        Long r138 = Long.valueOf(((long) r136) * 1000);     // Catch: Throwable -> L134
        if (r138.longValue() <= 0) goto L100;
        boolean r139 = true;
    L101:
        if (r139 == true) goto L104;
        r138 = null;
    L104:
        if (r138 == null) goto L106;
        r137 = r138.longValue();     // Catch: Throwable -> L134
    L106:
        String r140 = r132.f408458b + r132.f408457a;     // Catch: Throwable -> L134
        long r141 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L134
        Long r142 = h.f408498a.get(r140);     // Catch: Throwable -> L134
        if (r142 != null) goto L110;
        r142 = 0L;     // Catch: Throwable -> L134
    L110:
        long r143 = r141 - r142.longValue();     // Catch: Throwable -> L134
        if (r143 >= r137) goto L113;
        boolean r144 = true;
    L114:
        Lazy r145 = com.ss.android.dypay.base.c.f408438a;     // Catch: Throwable -> L134
        Iterator r146 = ((Stack) com.ss.android.dypay.base.c.f408438a.getValue()).iterator();     // Catch: Throwable -> L134
    L116:
        if (r146.hasNext() == false) goto L120;
        if (Intrinsics.areEqual(((Activity) r146.next()).getClass(), DyPayEntranceActivity.class) == false) goto L116;
        boolean r147 = true;
    L122:
        if (r143 >= KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL) goto L124;
        boolean r148 = true;
    L125:
        if (r144 == true) goto L129;
        if (r147 == false) goto L130;
        if (r148 == true) goto L129;
    L130:
        h.f408498a.put(r140, Long.valueOf(r141));     // Catch: Throwable -> L134
        boolean r149 = false;
    L132:
        monitor-exit(r131);
    L143:
        if (r149 == false) goto L156;
        JSONObject r150 = sta.a.f543575a;
        d r151 = this.f408466b;
        JSONObject r152 = new JSONObject();
        d r153 = d.f408440g;
        if (r153 == null) goto L273;
        long r154 = r153.f408444d;
        d r155 = this.f408466b;
        if (r155 == null) goto L273;
        r126 = Long.valueOf(r155.f408444d - r154);
    L273:
        r152.put("invoke_duration", r126);     // Catch: Exception -> L151
    L152:
        sta.a.b(r151, "out_wallet_cashier_client_duplicated_block", r152, -1);
        Activity r156 = this.f408469e;
        if (r156 == null) goto L155;
        r156.runOnUiThread(new c(r156));
    L155:
        this.f408468d.onResult(MapsKt.mapOf(new Pair[]{TuplesKt.to("resultCode", String.valueOf(103)), TuplesKt.to("errorMsg", "重复订单，取消唤起"), TuplesKt.to("extraParams", "")}));
        return;
    L156:
        com.ss.android.dypay.core.a.f408464c = this.f408468d;
        d.f408440g = this.f408466b;
        sta.a.f543576b.d("a24331.b28747.c0.d0");
        int r157 = DyPayEntranceActivity.f408348e;
        JSONObject r158 = new JSONObject();
        Activity r159 = this.f408469e;
        String r160 = com.ss.android.dypay.base.b.a();
        String r161 = com.ss.android.dypay.base.b.a();
        String r162 = "";
        if (r161.length() < 13) goto L159;
        String r163 = r161.substring(0, 13);
    L160:
        String r164 = String.valueOf(System.currentTimeMillis());
        if (r159 == null) goto L165;
        String r165 = r159.getPackageName();
        if (r165 == null) goto L165;
    L166:
        if (r159 != null) goto L285;
    L176:
        String r166 = "";
    L177:
        String r167 = com.ss.android.dypay.utils.c.a(r160 + r163 + r164 + r165 + r166 + "salt_dypay_risk_info_bytedance");
        JSONObject r168 = new JSONObject();
        r168.put(DyPayConstant.KEY_OUTER_DID, r160);     // Catch: Exception -> L246
    L259:
        r168.put("outer_did_init_time", r163);     // Catch: Exception -> L247
    L271:
        r168.put("timestamp", r164);     // Catch: Exception -> L248
    L283:
        r168.put("package_name", r165);     // Catch: Exception -> L249
    L279:
        r168.put("app_name", r166);     // Catch: Exception -> L250
    L253:
        r168.put("sign", r167);     // Catch: Exception -> L251
    L263:
        r158.put("caller_info", r168);     // Catch: Exception -> L191
    L192:
        String r169 = r158.toString();
        Map<String, String> r170 = this.f408470f;
        if (r170 == null) goto L231;
        Map r171 = MapsKt.toMutableMap(r170);
        if (r171 == null) goto L231;
        if (this.f408473i == true) goto L261;
    L208:
        Activity r172 = this.f408469e;
        if (r172 == null) goto L213;
        String r173 = r172.getPackageName();
        if (r173 == null) goto L213;
    L214:
        r171.put("pkgName", r173);
        Activity r174 = this.f408469e;
        if (r174 != null) goto L257;
    L226:
        String r175 = "";
    L227:
        r171.put("appName", r175);
        String r176 = com.ss.android.dypay.core.a.f408462a;
        if (r176 == null) goto L230;
        r162 = r176;
    L230:
        r171.put("appId", r162);
        r171.put("sdk_ext", r169);
    L255:
        JSONObject r177 = new JSONObject(r171);     // Catch: Exception -> L234
    L235:
        String r178 = r177.toString();
        e.f408484a = (String) r171.get("pay_source");
        Activity r179 = this.f408469e;
        boolean r180 = this.f408472h;
        if (r179 == null) goto L238;
        long r181 = System.currentTimeMillis();
        Intent r182 = new Intent(r179, DyPayEntranceActivity.class);
        r182.putExtra("payInfo", r178);
        r182.putExtra(DyPayConstant.KEY_SHOW_LOADING, r180);
        r182.putExtra(DyPayConstant.KEY_START_TIME, r181);
        r179.startActivity(r182);
        qta.a.d(r179);
        return;
    L238:
        sta.a.g("传入的activity为null");
        return;
    L234:
        r177 = new JSONObject();
        goto L235
    L257:
        PackageManager r183 = r174.getPackageManager();     // Catch: Exception -> L225
        if (r183 == null) goto L226;
        String r184 = r174.getPackageName();     // Catch: Exception -> L225
        if (r184 != null) goto L222;
        r184 = "";
    L222:
        r175 = r183.getApplicationLabel(r183.getApplicationInfo(r184, 128)).toString();     // Catch: Exception -> L225
        if (r175 == null) goto L226;
    L213:
        r173 = "";
        goto L214
    L261:
        String r185 = (String) r171.get(DyPayConstant.K_PAY_INFO_PARAM_PARTNERID);     // Catch: Exception -> L207
        if (r185 != null) goto L203;
        r185 = "";
    L203:
        r171.put("mchid", r185);     // Catch: Exception -> L207
        r171.put("token", a());     // Catch: Exception -> L207
        r171.put("pay_source", DyPayConstant.V_PAY_SOURCE_OUTER_BDPAY);     // Catch: Exception -> L207
        r171.put(CJOuterPayManager.KEY_DY_PAY_VERSION, "5");     // Catch: Exception -> L207
        r171.put("version", "5");     // Catch: Exception -> L207
    L231:
        r171 = new LinkedHashMap();
        goto L255
    L285:
        PackageManager r186 = r159.getPackageManager();     // Catch: Exception -> L252
        if (r186 == null) goto L176;
        String r187 = r159.getPackageName();     // Catch: Exception -> L252
        if (r187 != null) goto L173;
        r187 = "";
    L173:
        r166 = r186.getApplicationLabel(r186.getApplicationInfo(r187, 128)).toString();     // Catch: Exception -> L252
        if (r166 == null) goto L176;
    L165:
        r165 = "";
        goto L166
    L159:
        r163 = "";
    L129:
        r149 = true;
        goto L132
    L124:
        r148 = false;
        goto L125
    L120:
        r147 = false;
        goto L122
    L113:
        r144 = false;
        goto L114
    L100:
        r139 = false;
    L96:
        r136 = 0;
    L134:
        th = move-exception;
        Object r188 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L240
        Throwable r189 = Result.m9452exceptionOrNullimpl(r188);     // Catch: Throwable -> L240
        if (r189 == null) goto L138;
        r189.getStackTrace();     // Catch: Throwable -> L240
    L138:
        Boolean r190 = Boolean.FALSE;     // Catch: Throwable -> L240
        if (Result.m9455isFailureimpl(r188) == false) goto L141;
        r188 = r190;
    L141:
        r149 = ((Boolean) r188).booleanValue();     // Catch: Throwable -> L240
    L240:
        th = move-exception;
        throw th;
    L76:
        if (r124.length() == 0) goto L79;
        r125 = false;
        goto L80
    L62:
        if (r122.f408460d.length() <= 0) goto L64;
        boolean r191 = true;
    L65:
        if (r191 == false) goto L68;
        r124 = r122.f408460d;
        goto L74
    L68:
        if (r122.f408461e.length() <= 0) goto L70;
        boolean r192 = true;
    L71:
        if (r192 == false) goto L73;
        r124 = r122.f408461e;
        goto L74
    L73:
        r124 = "";
        goto L74
    L70:
        r192 = false;
        goto L71
    L64:
        r191 = false;
        goto L65
    L58:
        r123 = false;
        goto L59
    }

    public b(Activity r100, Map<String, String> r101, IDyPayResultCallback r102, boolean r103, boolean r104) {
        this.f408469e = r100;
        this.f408470f = r101;
        this.f408471g = r102;
        this.f408472h = r103;
        this.f408473i = r104;
        if (r101 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        com.ss.android.dypay.bean.c r106 = new com.ss.android.dypay.bean.c();
    L12:
        this.f408465a = r106;
        if (r100 == null) goto L26;
        vta.d.c(r100, new vta.e(r106.f408458b, r106.f408457a, r106.f408459c), true, null);
        d r107 = this.f408466b;
        if (r107 == null) goto L26;
        Map<String, Object> r108 = r107.f408446f;
        if (r108 == null) goto L26;
        vta.b r109 = this.f408467c;
        if (r109 != null) goto L22;
        r109 = vta.d.b(r106.f408458b, r106.f408457a);
        this.f408467c = r109;
    L22:
        if (r109 == null) goto L24;
        int r110 = Integer.valueOf(r109.f557252e);
    L25:
        r108.put("login_opt", r110);
        goto L26
    L24:
        r110 = 1;
    L26:
        this.f408468d = new a(this);
        return;
    L11:
        com.ss.android.dypay.bean.c r111 = new com.ss.android.dypay.bean.c();
        com.ss.android.dypay.bean.c.a.a(r111, new com.ss.android.dypay.bean.b(r101));
        r106 = r111;
        goto L12
    L5:
        if (r101.isEmpty() == true) goto L8;
        r105 = false;
        goto L9
    }
}
