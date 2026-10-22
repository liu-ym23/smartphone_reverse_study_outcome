package com.bytedance.bdturing.setting;

import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.android.ttcjpaysdk.thirdparty.fingerprint.CJPayFingerprintSharedPrefUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.random.URandomKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;
import org.json.JSONObject;
import qb4.n;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f202077a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f202078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static JSONObject f202079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Handler f202080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static com.bytedance.bdturing.setting.a f202081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<c.a> f202082f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<c.a> f202083g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f202084h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f202085i;

    public static final class a implements Runnable {
        public a() {
        }

        public static void a() {
            e r100 = e.f202077a;
            if (e.f202081e == null) goto L157;
            HashMap r101 = new HashMap();
            com.bytedance.bdturing.setting.a r102 = e.f202081e;
            if (r102 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            r102 = null;
        L8:
            Pair r103 = TuplesKt.to("aid", ((tb4.a.b) r102).f545251a.getAppId());
            r101.put(r103.getFirst(), r103.getSecond());
            com.bytedance.bdturing.setting.a r104 = e.f202081e;
            if (r104 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            r104 = null;
        L11:
            Pair r105 = TuplesKt.to(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, ((tb4.a.b) r104).f545251a.getLanguage());
            r101.put(r105.getFirst(), r105.getSecond());
            com.bytedance.bdturing.setting.a r106 = e.f202081e;
            if (r106 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            r106 = null;
        L14:
            Pair r107 = TuplesKt.to("app_name", ((tb4.a.b) r106).f545251a.getAppName());
            r101.put(r107.getFirst(), r107.getSecond());
            com.bytedance.bdturing.setting.a r108 = e.f202081e;
            if (r108 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            r108 = null;
        L17:
            Pair r109 = TuplesKt.to("channel", ((tb4.a.b) r108).f545251a.getChannel());
            r101.put(r109.getFirst(), r109.getSecond());
            com.bytedance.bdturing.setting.a r110 = e.f202081e;
            if (r110 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            r110 = null;
        L20:
            tb4.a.b r111 = (tb4.a.b) r110;
            if (r111.f545251a.getRegionType() == null) goto L23;
            BdTuringConfig.RegionType r112 = r111.f545251a.getRegionType();
        L24:
            Pair r113 = TuplesKt.to(EffectConfiguration.KEY_REGION, r112.getName());
            r101.put(r113.getFirst(), r113.getSecond());
            Pair r114 = TuplesKt.to("os_type", "0");
            r101.put(r114.getFirst(), r114.getSecond());
            Pair r115 = TuplesKt.to(SheetInputData.InputData.DateType.DATETIME, String.valueOf(System.currentTimeMillis()));
            r101.put(r115.getFirst(), r115.getSecond());
            com.bytedance.bdturing.setting.a r116 = e.f202081e;
            if (r116 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            r116 = null;
        L27:
            r116.getClass();
            Pair r117 = TuplesKt.to("sdk_version", "4.1.1.cn");
            r101.put(r117.getFirst(), r117.getSecond());
            com.bytedance.bdturing.setting.a r118 = e.f202081e;
            if (r118 != null) goto L30;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            r118 = null;
        L30:
            Pair r119 = TuplesKt.to(WsConstants.KEY_INSTALL_ID, ((tb4.a.b) r118).f545251a.getInstallId());
            r101.put(r119.getFirst(), r119.getSecond());
            com.bytedance.bdturing.setting.a r120 = e.f202081e;
            if (r120 != null) goto L33;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            r120 = null;
        L33:
            Pair r121 = TuplesKt.to("app_version", ((tb4.a.b) r120).f545251a.getAppVersion());
            r101.put(r121.getFirst(), r121.getSecond());
            Pair r122 = TuplesKt.to("device_platform", "android");
            r101.put(r122.getFirst(), r122.getSecond());
            com.bytedance.bdturing.setting.a r123 = e.f202081e;
            if (r123 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            r123 = null;
        L36:
            Pair r124 = TuplesKt.to("version_code", String.valueOf(((tb4.a.b) r123).f545251a.getAppVersionCode()));
            r101.put(r124.getFirst(), r124.getSecond());
            com.bytedance.bdturing.setting.a r125 = e.f202081e;
            if (r125 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            r125 = null;
        L39:
            Pair r126 = TuplesKt.to("version_name", ((tb4.a.b) r125).f545251a.getAppVersion());
            r101.put(r126.getFirst(), r126.getSecond());
            Pair r127 = TuplesKt.to("os_name", "android");
            r101.put(r127.getFirst(), r127.getSecond());
            Pair r128 = TuplesKt.to("os_version", String.valueOf(Build.VERSION.SDK_INT));
            r101.put(r128.getFirst(), r128.getSecond());
            com.bytedance.bdturing.setting.a r129 = e.f202081e;
            if (r129 != null) goto L42;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            r129 = null;
        L42:
            Pair r130 = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_DID, ((tb4.a.b) r129).f545251a.getDeviceId());
            r101.put(r130.getFirst(), r130.getSecond());
            String r131 = Build.BRAND;
            String r132 = URLEncoder.encode(r131, XML.CHARSET_UTF8);     // Catch: UnsupportedEncodingException -> L45
        L47:
            Pair r133 = TuplesKt.to("device_brand", r132);
            r101.put(r133.getFirst(), r133.getSecond());
            String r134 = e.d("common");
            if (r134 == null) goto L53;
            HashMap r135 = r101;
            String r136 = "UTF-8";
            Object r137 = "device_platform";
            if (StringsKt.endsWith$default(r134, HTTP.URL_DEFAULT, false, 2, null) == false) goto L52;
            String r138 = r134.concat("vc/setting");
        L54:
            int r139 = n.f532367a;
            String r140 = "";
            if (r138 == null) goto L115;
            StringBuilder r141 = new StringBuilder(r138);
        L112:
            e = move-exception;
            e.printStackTrace();
        L114:
            String r142 = r141.toString();
        L116:
            com.bytedance.bdturing.setting.a r143 = e.f202081e;
            if (r143 != null) goto L119;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");
            r143 = null;
        L119:
            ec4.b r144 = ((tb4.a.b) r143).f545251a.getHttpClient();
            if (r144 == null) goto L143;
            if (r142 != null) goto L123;
            r142 = "";
        L123:
            e r145 = e.f202077a;
            Intrinsics.checkNotNullParameter(r142, "mUrl");
            HashMap r146 = r135;
            Intrinsics.checkNotNullParameter(r146, "params");
            Intrinsics.checkNotNullParameter(r145, "mCallback");
            Intrinsics.checkNotNullParameter(r144, "mHttpClient");
            long r147 = System.currentTimeMillis();
            Random r148 = RandomKt.Random(System.nanoTime());
            Pair r149 = new Pair(UStringsKt.m10781toStringV7xB4Y4(URandomKt.nextUInt(r148), 16), UStringsKt.m10781toStringV7xB4Y4(URandomKt.nextUInt(r148), 16));
            r146.put("key", r149.getFirst());
            r146.put(CJPayFingerprintSharedPrefUtils.KEY_IV, r149.getSecond());
            String r150 = (String) r149.getFirst();
            String r151 = (String) r149.getSecond();
            MessageDigest r152 = MessageDigest.getInstance("SHA-256");
            Charset r153 = Charsets.UTF_8;
            byte[] r154 = r152.digest(r150.getBytes(r153));
            byte[] r155 = MessageDigest.getInstance("MD5").digest(r151.getBytes(r153));
            if (r155 == null) goto L126;
            byte[] r156 = ArraysKt.copyOfRange(r155, 0, 12);
        L127:
            Pair r157 = new Pair(r154, r156);
            Object r158 = r157.getFirst();
            Object r159 = r157.getSecond();
            int r160 = -1;
            String r161 = new JSONObject(r146).toString();     // Catch: Throwable -> L135 Exception -> L137
            LinkedHashMap r162 = new LinkedHashMap();     // Catch: Throwable -> L135 Exception -> L137
            r162.put("Content-type", "application/json;tt-data=g");     // Catch: Throwable -> L135 Exception -> L137
            byte[] r163 = r144.post(r142, r162, r161.getBytes(r153));     // Catch: Throwable -> L135 Exception -> L137
            if (r163 != null) goto L131;
        L134:
            r160 = 204;
        L140:
            r145.a(r160, r140, System.currentTimeMillis() - r147);
            return;
        L131:
            if (r163.length <= 0) goto L134;
            r160 = 200;
            r140 = c.a((byte[]) r158, (byte[]) r159, new ByteArrayInputStream(r163));     // Catch: Throwable -> L135 Exception -> L137
        L137:
            e = move-exception;
            r160 = 500;
            e.printStackTrace();     // Catch: Throwable -> L135
        L135:
            th = move-exception;
            r145.a(r160, "", System.currentTimeMillis() - r147);
            throw th;
        L126:
            r156 = null;
            goto L127
        L143:
            return;
        L59:
            if (StringsKt.indexOf$default(r138, '?', 0, false, 6, null) >= 0) goto L61;
            r141.append("?");     // Catch: Exception -> L112
        L62:
            HashMap r164 = new HashMap();     // Catch: Exception -> L112
            com.bytedance.bdturing.setting.a r165 = e.f202081e;     // Catch: Exception -> L112
            if (r165 != null) goto L65;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");     // Catch: Exception -> L112
            r165 = null;
        L65:
            Pair r166 = TuplesKt.to("aid", ((tb4.a.b) r165).f545251a.getAppId());     // Catch: Exception -> L112
            r164.put(r166.getFirst(), r166.getSecond());     // Catch: Exception -> L112
            com.bytedance.bdturing.setting.a r167 = e.f202081e;     // Catch: Exception -> L112
            if (r167 != null) goto L68;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");     // Catch: Exception -> L112
            r167 = null;
        L68:
            Pair r168 = TuplesKt.to("app_name", ((tb4.a.b) r167).f545251a.getAppName());     // Catch: Exception -> L112
            r164.put(r168.getFirst(), r168.getSecond());     // Catch: Exception -> L112
            com.bytedance.bdturing.setting.a r169 = e.f202081e;     // Catch: Exception -> L112
            if (r169 != null) goto L71;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");     // Catch: Exception -> L112
            r169 = null;
        L71:
            Pair r170 = TuplesKt.to("app_version", ((tb4.a.b) r169).f545251a.getAppVersion());     // Catch: Exception -> L112
            r164.put(r170.getFirst(), r170.getSecond());     // Catch: Exception -> L112
            com.bytedance.bdturing.setting.a r171 = e.f202081e;     // Catch: Exception -> L112
            if (r171 != null) goto L74;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");     // Catch: Exception -> L112
            r171 = null;
        L74:
            Pair r172 = TuplesKt.to("channel", ((tb4.a.b) r171).f545251a.getChannel());     // Catch: Exception -> L112
            r164.put(r172.getFirst(), r172.getSecond());     // Catch: Exception -> L112
            com.bytedance.bdturing.setting.a r173 = e.f202081e;     // Catch: Exception -> L112
            if (r173 != null) goto L77;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");     // Catch: Exception -> L112
            r173 = null;
        L77:
            Pair r174 = TuplesKt.to(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, ((tb4.a.b) r173).f545251a.getLanguage());     // Catch: Exception -> L112
            r164.put(r174.getFirst(), r174.getSecond());     // Catch: Exception -> L112
            com.bytedance.bdturing.setting.a r175 = e.f202081e;     // Catch: Exception -> L112
            if (r175 != null) goto L80;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");     // Catch: Exception -> L112
            r175 = null;
        L80:
            r175.getClass();     // Catch: Exception -> L112
            Pair r176 = TuplesKt.to("sdk_version", "4.1.1.cn");     // Catch: Exception -> L112
            r164.put(r176.getFirst(), r176.getSecond());     // Catch: Exception -> L112
            com.bytedance.bdturing.setting.a r177 = e.f202081e;     // Catch: Exception -> L112
            if (r177 != null) goto L83;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");     // Catch: Exception -> L112
            r177 = null;
        L83:
            Pair r178 = TuplesKt.to("version_code", String.valueOf(((tb4.a.b) r177).f545251a.getAppVersionCode()));     // Catch: Exception -> L112
            r164.put(r178.getFirst(), r178.getSecond());     // Catch: Exception -> L112
            com.bytedance.bdturing.setting.a r179 = e.f202081e;     // Catch: Exception -> L112
            if (r179 != null) goto L86;
            Intrinsics.throwUninitializedPropertyAccessException("configProvider");     // Catch: Exception -> L112
            r179 = null;
        L86:
            Pair r180 = TuplesKt.to("version_name", ((tb4.a.b) r179).f545251a.getAppVersion());     // Catch: Exception -> L112
            r164.put(r180.getFirst(), r180.getSecond());     // Catch: Exception -> L112
            Pair r181 = TuplesKt.to(r137, "android");     // Catch: Exception -> L112
            r164.put(r181.getFirst(), r181.getSecond());     // Catch: Exception -> L112
            Iterator r182 = r164.keySet().iterator();     // Catch: Exception -> L112
        L87:
            if (r182.hasNext() == false) goto L114;
            String r183 = (String) r182.next();     // Catch: Exception -> L112
            if (r141.length() <= 0) goto L92;
            boolean r184 = true;
        L93:
            if (r184 == false) goto L95;
            r141.append("&");     // Catch: Exception -> L112
        L95:
            e r185 = e.f202077a;     // Catch: Exception -> L112
            String r186 = r136;
            String r187 = URLEncoder.encode(r183, r186);     // Catch: Exception -> L99
        L102:
            String r188 = (String) r164.get(r183);     // Catch: Exception -> L112
            if (r188 != null) goto L146;
            String r189 = null;
        L110:
            r141.append(r187);     // Catch: Exception -> L112
            r141.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L112
            r141.append(r189);     // Catch: Exception -> L112
            r136 = r186;
            goto L87
        L146:
            r189 = URLEncoder.encode(r188, r186);     // Catch: Exception -> L106
        L106:
            e = move-exception;
            e.printStackTrace();     // Catch: Exception -> L112
            r189 = "";
            goto L110
        L99:
            e = move-exception;
            e.printStackTrace();     // Catch: Exception -> L112
            r187 = "";
            goto L102
        L92:
            r184 = false;
            goto L93
        L61:
            r141.append("&");     // Catch: Exception -> L112
            goto L62
        L115:
            r142 = null;
            goto L116
        L52:
            r138 = r134.concat("/vc/setting");
            goto L54
        L53:
            r136 = "UTF-8";
            r135 = r101;
            r137 = "device_platform";
            r138 = null;
        L45:
            e = move-exception;
            int r190 = n.f532367a;
            Intrinsics.checkNotNullParameter(e, "e");
            e.printStackTrace();
            r132 = r131;
            goto L47
        L23:
            r112 = BdTuringConfig.RegionType.REGION_CN;
            goto L24
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public e() {
    }

    static {
        f202077a = new e();
        f202079c = DefaultSettings.f202074b;
        f202082f = new LinkedList();
        f202083g = new LinkedList();
        f202084h = new a();
    }

    public static int h() {
        return e("common").optInt("use_dialog_size_v2", 0);
    }

    public static boolean i() {
        if (e("common").optInt("verify_cancellable", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void b(c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "pxy");
        List<c.a> r101 = f202082f;
        monitor-enter(r101);
        ((LinkedList) r101).add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static String d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        return c(r100, "host");
    }

    public static JSONObject e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        JSONObject r101 = f202079c.optJSONObject(r100);
        if (r101 != null) goto L5;
        r101 = DefaultSettings.f202074b.optJSONObject(r100);
    L5:
        if (r101 != null) goto L7;
        r101 = new JSONObject();
    L7:
        com.bytedance.bdturing.setting.a r102 = f202081e;
        if (r102 == null) goto L12;
        b r103 = ((tb4.a.b) r102).f545251a.getServiceInterceptor();
        if (r103 == null) goto L12;
        f202079c.put(r100, r103.a(r100, r101));
    L12:
        return r101;
    }

    public static String f(String r100) {
        Intrinsics.checkNotNullParameter("auth", "service");
        Intrinsics.checkNotNullParameter(r100, "type");
        String r101 = e("auth").optString(r100);
        if (TextUtils.isEmpty(r101) == true) goto L5;
        return r101;
    L5:
        JSONObject r102 = DefaultSettings.f202074b.optJSONObject("auth");
        if (r102 != null) goto L10;
        return null;
    L10:
        return r102.optString(r100);
    }

    public static long g(boolean r100) {
        if (r100 == true) goto L11;
        if (f202078b >= e("common").optInt("retry_count", 0)) goto L11;
        if (e("common").optLong("retry_interval", 30000) == 0) goto L11;
        f202078b++;
        return e("common").optLong("retry_interval", 30000);
    L11:
        return Math.max(Math.min(f202079c.optLong("available_time") - System.currentTimeMillis(), e("common").optLong("period", 300000)), 300000);
    }

    public static void j(long r100) {
        Handler r101 = f202080d;
        if (r101 == null) goto L5;
        r101.removeCallbacks(f202084h);
    L5:
        Handler r102 = f202080d;
        if (r102 == null) goto L9;
        r102.postDelayed(f202084h, r100);
        return;
    }

    public static void k(String r100) {
        f202079c = new JSONObject(r100);     // Catch: Exception -> L4
        long r101 = System.currentTimeMillis() + e("common").optLong("period", 300000);     // Catch: Exception -> L4
        f202079c.put("available_time", r101);     // Catch: Exception -> L4
        yb4.b.f567093a.c(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        int r102 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public static String c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, "type");
        String r102 = Region.CN.getValue();
        com.bytedance.bdturing.setting.a r103 = f202081e;
        if (r103 == null) goto L9;
        tb4.a.b r104 = (tb4.a.b) r103;
        if (r104.f545251a.getRegionType() == null) goto L7;
        BdTuringConfig.RegionType r105 = r104.f545251a.getRegionType();
    L8:
        r102 = r105.getName();
        goto L9
    L7:
        r105 = BdTuringConfig.RegionType.REGION_CN;
    L9:
        JSONObject r106 = e(r100).optJSONObject(r101);
        if (r106 == null) goto L12;
        String r107 = r106.optString(r102);
    L14:
        if (TextUtils.isEmpty(r107) == true) goto L16;
        return r107;
    L16:
        JSONObject r108 = DefaultSettings.f202074b.optJSONObject(r100);
        if (r108 == null) goto L22;
        JSONObject r109 = r108.optJSONObject(r101);
        if (r109 != null) goto L21;
        return null;
    L21:
        return r109.optString(r102);
    L22:
        return null;
    L12:
        r107 = null;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.util.ArrayList] */
    @Override // com.bytedance.bdturing.setting.c.a
    public final void a(int r100, String r101, long r102) {
        boolean r103 = true;
        if (r100 != 200) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L14;
        if (r101 != null) goto L9;
    L12:
        if (r103 == true) goto L14;
        int r105 = n.f532367a;
        k(r101);
        f202078b = 0;
    L15:
        Iterator<T> r106 = f202082f.iterator();
    L17:
        if (r106.hasNext() == false) goto L19;
        ((c.a) r106.next()).a(r100, r101, r102);
        goto L17
    L19:
        Ref.ObjectRef r107 = new Ref.ObjectRef();
        monitor-enter(this);
        ?? r108 = new ArrayList();     // Catch: Throwable -> L29
        List<c.a> r109 = f202083g;     // Catch: Throwable -> L29
        r108.addAll(r109);     // Catch: Throwable -> L29
        r107.element = r108;     // Catch: Throwable -> L29
        ((LinkedList) r109).clear();     // Catch: Throwable -> L29
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L29
        monitor-exit(this);
        Iterator r111 = ((Iterable) r107.element).iterator();
    L25:
        if (r111.hasNext() == false) goto L27;
        ((c.a) r111.next()).a(r100, r101, r102);
        goto L25
    L27:
        j(g(r104));
        return;
    L29:
        th = move-exception;
        throw th;
    L9:
        if (r101.length() == 0) goto L12;
        r103 = false;
    L14:
        int r112 = n.f532367a;
        goto L15
    L5:
        r104 = false;
        goto L6
    }
}
