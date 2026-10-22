package com.bytedance.ug.sdk.luckycat.impl.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.ug.sdk.luckycat.api.depend.Dependency;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f271333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f271334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ug.sdk.luckycat.api.depend.c f271335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.ug.sdk.luckycat.api.depend.j f271336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.ug.sdk.luckycat.api.depend.d f271337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.ug.sdk.luckycat.api.depend.f f271338f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ug.sdk.luckycat.api.depend.l f271339g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.ug.sdk.luckycat.api.depend.g f271340h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.ug.sdk.luckycat.api.depend.k f271341i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ti7.a f271342j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.ug.sdk.luckycat.api.depend.h f271343k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f271344l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f271345m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f271346n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Map<Dependency, com.bytedance.ug.sdk.luckycat.api.depend.a> f271347o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f271348p;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f271349a = null;

        static {
            f271349a = new m();
        }
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.ug.sdk.luckydog.api.network.LuckyDogActCommonInterceptor");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.ug.sdk.luckydog.api.network.LuckyDogActCommonInterceptor");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.ug.sdk.luckydog.api.network.LuckyDogActCommonInterceptor");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.ug.sdk.luckydog.api.network.LuckyDogActCommonInterceptor");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.ug.sdk.luckydog.api.network.LuckyDogActCommonInterceptor");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.ug.sdk.luckydog.api.network.LuckyDogActCommonInterceptor");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.ug.sdk.luckydog.api.network.LuckyDogActCommonInterceptor");
    }

    public final Context f() {
        Context r100 = this.f271334b;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.f271333a;
    }

    public final int g() {
        com.bytedance.ug.sdk.luckycat.api.depend.d r100 = this.f271337e;
        if (r100 == null) goto L14;
        bn7.a r101 = ((cn7.a) r100).f24554b;
        if (r101 == null) goto L7;
        int r102 = r101.getAppId();
    L8:
        if (r102 <= 0) goto L14;
        bn7.a r103 = ((cn7.a) this.f271337e).f24554b;
        if (r103 != null) goto L12;
        return 0;
    L12:
        return r103.getAppId();
    L7:
        r102 = 0;
    L14:
        return this.f271346n;
    }

    public final ti7.b h() {
        ti7.a r100 = this.f271342j;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.f546206a;
    }

    public final String i() {
        com.bytedance.ug.sdk.luckycat.api.depend.d r100 = this.f271337e;
        if (r100 == null) goto L8;
        bn7.a r101 = ((cn7.a) r100).f24554b;
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101.getDeviceId();
    L8:
        return "";
    }

    public final String j() {
        if (this.f271336d == null) goto L12;
        StringBuilder r100 = new StringBuilder();
        bn7.e r101 = ((cn7.e) this.f271336d).f24556a;
        String r102 = null;
        if (r101 == null) goto L7;
        r101.getHost();
        String r103 = CJPayConstant.TT_CJ_PAY_FOLLOW_HOST;
    L8:
        r100.append(r103);
        r100.append(HTTP.URL_DEFAULT);
        bn7.e r104 = ((cn7.e) this.f271336d).f24556a;
        if (r104 == null) goto L11;
        r104.b();
        r102 = "luckycat/aweme";
    L11:
        r100.append(r102);
        r100.append("/v1/");
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatConfigManager", "getUrlRequestVersion:".concat("v1"));
        String r105 = r100.toString();
    L14:
        return com.bytedance.ug.sdk.luckycat.impl.utils.z.c(r105);
    L7:
        r103 = null;
        goto L8
    L12:
        r105 = "";
        goto L14
    }

    public final void m() {
        com.bytedance.ug.sdk.luckycat.api.depend.d r100 = this.f271337e;
        if (r100 == null) goto L6;
        ((cn7.a) r100).a();
        return;
    }

    public final void n() {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatConfigManager", "isEnableFission:false");
    }

    public final void o() {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatConfigManager", "isEnablePedometer:false");
    }

    public final void p() {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatConfigManager", "isEnableRedDot:false");
    }

    public final void q() {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatConfigManager", "isEnableWebViewTimeOut:true");
    }

    public final boolean r() {
        com.bytedance.ug.sdk.luckycat.api.depend.c r100 = this.f271335c;
        if (r100 != null) goto L5;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatConfigManager", "cannot get login status");
        return false;
    L5:
        return r100.isLogin();
    }

    public final boolean s() {
        com.bytedance.ug.sdk.luckycat.api.depend.h r100 = this.f271343k;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.e();
    }

    public final void t() {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatConfigManager", "isWebViewPreCreate:false");
    }

    public m() {
        this.f271346n = 0;
        this.f271348p = 0;
    }

    public final String b(String r100) {
        com.bytedance.ug.sdk.luckycat.api.depend.j r101 = this.f271336d;
        if (r101 == null) goto L47;
        cn7.e r102 = (cn7.e) r101;
        if (r102.f24556a == null) goto L47;
        r100 = r102.f24556a.addCommonParams(ek7.b.a(r100));
    L47:
        String r103 = UriProtector.getQueryParameter(UriProtector.parse(r100), "aid");     // Catch: Throwable -> L13
        String r104 = String.valueOf(g());     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r103) == false) goto L10;
    L15:
        StringBuilder r105 = new StringBuilder(r100);
        if (r105.toString().indexOf(63) >= 0) goto L18;
        r105.append("?");
    L19:
        Uri r106 = UriProtector.parse(r100);
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("luckycat_version_name", "8.75.0-rc.12-db");
        r107.put("luckycat_version_code", String.valueOf(890100));
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r106, "lucky_is_32")) == false) goto L27;
        boolean r108 = zl7.b.f572790a;
        if (zl7.b.a(a.f271349a.f()) == false) goto L24;
        String r109 = "1";
    L25:
        r107.put("lucky_is_32", r109);
        goto L27
    L24:
        r109 = "0";
    L27:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r106, "lucky_device_score")) == false) goto L35;
        r107.put("lucky_device_score", String.valueOf(com.bytedance.ug.sdk.luckycat.impl.utils.f.a()));
        JSONObject r110 = new JSONObject();
        r110.put("lucky_device_score", com.bytedance.ug.sdk.luckycat.impl.utils.f.a());     // Catch: JSONException -> L31
        r110.put("lucky_path", r100);     // Catch: JSONException -> L31
    L33:
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("lucky_request_device_score", r110, true);
    L31:
        e = move-exception;
        e.printStackTrace();
    L35:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r106, "lucky_device_type")) == false) goto L37;
        r107.put("lucky_device_type", Build.MODEL);
    L37:
        m r111 = a.f271349a;
        int r112 = r111.f271348p;
        if (r112 > 0) goto L41;
        r112 = com.bytedance.ug.sdk.luckycat.utils.d.b(r111.f271334b, false);
        r111.f271348p = r112;
    L41:
        r107.put("status_bar_height", String.valueOf(r112));
        ArrayList r113 = new ArrayList();
        Iterator r114 = r107.entrySet().iterator();
    L43:
        if (r114.hasNext() == false) goto L45;
        Map.Entry r115 = (Map.Entry) r114.next();
        r113.add(new Pair(r115.getKey(), r115.getValue()));
        goto L43
    L45:
        r105.append(com.bytedance.ug.sdk.luckycat.impl.utils.z.a(r113));
        return r105.toString();
    L18:
        r105.append("&");
        goto L19
    L10:
        if (r103.equals(r104) == true) goto L15;
        r100 = com.bytedance.ug.sdk.luckycat.impl.utils.z.b(r100, r104);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.getMessage();
        goto L15
    }

    public final boolean c(String r100) {
        boolean r101 = false;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        m r102 = a.f271349a;
        ti7.a r103 = r102.f271342j;
        if (r103 == null) goto L9;
        r103.getClass();
    L9:
        if (r102.f271344l == false) goto L14;
        ti7.a r104 = this.f271342j;
        if (r104 == null) goto L14;
        r104.getClass();
    L14:
        if (TextUtils.isEmpty(r100) == false) goto L59;
    L20:
        boolean r105 = false;
    L21:
        if (r105 == false) goto L23;
        return true;
    L23:
        String r106 = com.bytedance.ug.sdk.luckycat.utils.i.d(r100);
        if (TextUtils.isEmpty(r106) == false) goto L26;
        return false;
    L26:
        Uri r107 = UriProtector.parse(r106);
        if (r107 != null) goto L29;
        return false;
    L29:
        String r108 = r107.getPath();
        if (TextUtils.isEmpty(r108) == false) goto L33;
        return false;
    L33:
        if (TextUtils.isEmpty(r108) == true) goto L56;
        Object r109 = LuckyCatSettingsManger.b.f271283a.c(new String[]{"container_config", "bullet_container_path"});
        if ((r109 instanceof JSONArray) == false) goto L49;
        JSONArray r110 = (JSONArray) r109;
        if (r110 == null) goto L56;
        if (r110.length() == 0) goto L56;
        int r111 = 0;
    L44:
        if (r111 >= r110.length()) goto L56;
        if (r108.equals(r110.optString(r111)) == true) goto L47;
        r111 = r111 + 1;
        goto L44
    L47:
        r101 = true;
        goto L56
    L49:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatConfigManager", "isUseBulletContainerBySettings path : " + r108);
        if (TextUtils.isEmpty(r108) == false) goto L53;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatConfigManager", "path is null, disable bullet container");
        goto L56
    L53:
        if (this.f271342j != null) goto L55;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatConfigManager", "extra config is null, disable bullet container");
        goto L56
    L55:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatConfigManager", "useBulletContainerPathList is null or size 0, disable bullet");
    L56:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatConfigManager", "path : " + r108 + " enable bullet container : " + r101);
        return r101;
    L59:
        if (CastIntegerProtector.parseInt(UriProtector.getQueryParameter(UriProtector.parse(r100), "use_bullet_container")) != 1) goto L20;
        r105 = true;
        goto L21
    }

    public final String d(String r100) throws Exception {
        com.bytedance.ug.sdk.luckycat.api.depend.j r101 = this.f271336d;
        String r102 = null;
        if (r101 == null) goto L8;
        String r103 = com.bytedance.ug.sdk.luckycat.impl.utils.z.c(r100);
        bn7.e r104 = ((cn7.e) r101).f24556a;
        if (r104 == null) goto L7;
        r102 = r104.executeGet(r103);
    L7:
        com.bytedance.ug.sdk.luckycat.utils.a.a(r100, r102);
    L8:
        return r102;
    }

    public final void w(Map r100) {
        com.bytedance.ug.sdk.luckycat.api.depend.j r101 = this.f271336d;
        if (r101 == null) goto L7;
        cn7.e r102 = (cn7.e) r101;
        if (r102.f24556a == null) goto L7;
        ek7.b.e(r100);
        r102.f24556a.putCommonParams(r100);
    L7:
        m r103 = a.f271349a;
        int r104 = r103.f271348p;
        if (r104 > 0) goto L11;
        r104 = com.bytedance.ug.sdk.luckycat.utils.d.b(r103.f271334b, false);
        r103.f271348p = r104;
    L11:
        HashMap r105 = (HashMap) r100;
        r105.put("status_bar_height", String.valueOf(r104));
        r105.put("luckycat_version_name", "8.75.0-rc.12-db");
        r105.put("luckycat_version_code", String.valueOf(890100));
    }

    public final String e(String r100, JSONObject r101) throws Exception {
        com.bytedance.ug.sdk.luckycat.api.depend.j r102 = this.f271336d;
        if (r102 == null) goto L10;
        String r103 = com.bytedance.ug.sdk.luckycat.impl.utils.z.c(r100);
        bn7.e r104 = ((cn7.e) r102).f24556a;
        if (r104 == null) goto L7;
        String r105 = r104.a(r103, r101);
    L8:
        com.bytedance.ug.sdk.luckycat.utils.a.a(r100, r105);
        return r105;
    L7:
        r105 = null;
        goto L8
    L10:
        return "";
    }

    public final boolean k(Context r100, String r101) {
        if ("android.permission.ACTIVITY_RECOGNITION".equals(r101) == true) goto L5;
    L8:
        com.bytedance.ug.sdk.luckycat.api.depend.k r102 = this.f271341i;
        if (r102 != null) goto L11;
        return false;
    L11:
        return r102.b();
    L5:
        if (Build.VERSION.SDK_INT >= 29) goto L8;
        return true;
    }

    public final boolean l(Context r100, String[] r101) {
        if (this.f271341i == null) goto L15;
        if (r101 == null) goto L15;
        if (r101.length <= 0) goto L15;
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L13;
        if (k(r100, r101[r103]) == false) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    L15:
        return false;
    }

    public final void x(Context r100, String r101) {
        r100.getApplicationContext();
        com.bytedance.ug.sdk.luckycat.api.depend.l r102 = this.f271339g;
        if (r102 == null) goto L6;
        r102.b();
        return;
    L6:
        com.bytedance.ug.sdk.luckycat.api.depend.l r103 = c.b();
        if (r103 == null) goto L10;
        r103.b();
        return;
    }

    public void requestPermissions(Activity r100, String[] r101, pi7.d r102) {
        com.bytedance.ug.sdk.luckycat.api.depend.k r103 = this.f271341i;
        if (r103 == null) goto L6;
        r103.requestPermissions(r100, r101, r102);
        return;
    }

    public final void u(Activity r100, String r101, String r102) {
        if (TextUtils.isEmpty(r102) == false) goto L5;
    L7:
        com.bytedance.ug.sdk.luckycat.api.depend.c r103 = this.f271335c;
        if (r103 == null) goto L11;
        r103.a();
        return;
    L11:
        return;
    L5:
        if (r102.equals("big_red_packet") == false) goto L7;
        jj7.a.C6446a.f499342a.getClass();
        goto L7
    }

    public final boolean v(Context r110, String r111, String r112) {
        if (com.bytedance.ug.sdk.luckycat.utils.i.j(r111) == false) goto L6;
        com.bytedance.ug.sdk.luckycat.impl.route.e.e(r110, r111, true, null, null, null, r112);
        return true;
    L6:
        com.bytedance.ug.sdk.luckycat.api.depend.d r113 = this.f271337e;
        if (r113 == null) goto L30;
        bn7.a r114 = ((cn7.a) r113).f24554b;
        if (r114 == null) goto L11;
        boolean r115 = r114.openSchema(r111);
    L12:
        if (r115 == true) goto L31;
        if (r110 != null) goto L15;
    L28:
        return false;
    L15:
        if (TextUtils.isEmpty(r111) == true) goto L28;
        if (TextUtils.isEmpty(r111) == true) goto L25;
        Intent r116 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r116.setData(UriProtector.parse(r111));
        r116.addFlags(268435456);
        List<ResolveInfo> r117 = r110.getPackageManager().queryIntentActivities(r116, 65536);
        if (r117 == null) goto L25;
        if (r117.size() <= 0) goto L25;
        boolean r118 = true;
    L26:
        if (r118 == false) goto L28;
        Intent r119 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r119.setData(UriProtector.parse(r111));
        r119.addFlags(268435456);
        r110.startActivity(r119);
        return true;
    L25:
        r118 = false;
        goto L26
    L31:
        return true;
    L11:
        r115 = false;
        goto L12
    L30:
        return false;
    }
}
