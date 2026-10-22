package com.unionpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.suite.lark.platform.component.dyres.DyResUtils;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.unionpay.utils.UPUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f462126a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f462127b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f462128c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f462129d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f462130e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f462131f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f462132g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f462133h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f462134i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static WeakReference f462135j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f462136k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f462137l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f462138m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f462139n = "";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f462140o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f462141p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f462142q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static wpc.c f462143r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static Handler f462144s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static String f462145t = "[{\"package_info\":[{\"schema\":\"com.unionpay\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":101,\"version\":\".*\"}],\"sort\":100,\"type\":\"app\"},{\"text\":\"5pyq5a6J6KOF5LqR6Zeq5LuYQVBQ\",\"sort\":900,\"type\":\"toast\"}]";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static String f462146u = "[{\"package_info\": [{\"schema\": \"com.unionpay.tsmservice\",\"sign\": \"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\": 102,\"version\": \"^[1-9].*|^0[2-9].*|^01\\\\.[1-9].*|^01\\\\.0[1-9].*|^01\\\\.00\\\\.[2-9].*|^01\\\\.00\\\\.1[012789].*|^01\\\\.00\\\\.0[8-9].*\"},{\"schema\": \"com.unionpay.tsmservice.mi\",\"sign\": \"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\": 103,\"version\": \"^[1-9].*|^0[2-9].*|^01\\\\.[1-9].*|^01\\\\.0[1-9].*|^01\\\\.00\\\\.[1-9].*|^01\\\\.00\\\\.0[8-9].*\"}],\"sort\": 100,\"type\": \"app\"}]";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static String f462147v = "[{\"package_info\": [{\"schema\": \"com.huawei.wallet\",\"sign\": \"9095F915D6C143A41CE029209AFECB87AB481DDD\",\"sort\": 101,\"version\": \"([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\"},{\"schema\": \"com.huawei.wallet\",\"sign\": \"059e2480adf8c1c5b3d9ec007645ccfc442a23c5\",\"sort\": 102,\"version\": \"([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\"},{\"schema\": \"com.unionpay.tsmservice\",\"sign\": \"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\": 103,\"version\": \"^[1-9].*|^0[2-9].*|^01\\\\.[1-9].*|^01\\\\.0[1-9].*|^01\\\\.00\\\\.[2-9].*|^01\\\\.00\\\\.1[012789].*|^01\\\\.00\\\\.0[8-9].*\"},{\"schema\": \"com.unionpay.tsmservice.mi\",\"sign\": \"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\": 104,\"version\": \"^[1-9].*|^0[2-9].*|^01\\\\.[1-9].*|^01\\\\.0[1-9].*|^01\\\\.00\\\\.[1-9].*|^01\\\\.00\\\\.0[8-9].*\"}],\"sort\": 100,\"type\": \"app\"}]";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static JSONArray f462148w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final b f462149x = null;

    static {
        f462149x = new b();
    }

    public static void c(String r100, Bundle r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.trim().length() > 0) goto L7;
        return;
    L7:
        if (r100.trim().charAt(0) == '<') goto L9;
        r101.putString("ex_mode", r102);
        return;
    L9:
        if (r102 != null) goto L11;
    L14:
        r101.putBoolean("UseTestMode", true);
        return;
    L11:
        if (r102.trim().equalsIgnoreCase(CustomAlbumViewModel.DEFAULT_TAB_ID) == false) goto L14;
        r101.putBoolean("UseTestMode", false);
    }

    public static void d(String r100, String r101) {
        Bundle r102 = new Bundle();
        if ("link".equals(r101) == true) goto L16;
        c(f462136k, r102, f462139n);
        r102.putString("SpId", f462137l);
        r102.putString("SysProvide", f462138m);
        int r103 = CastIntegerProtector.parseInt(f462139n);     // Catch: Exception -> L7
    L9:
        if ("wcd".equals(r101) == true) goto L30;
        r102.putString("paydata", UPUtils.e(r103, com.unionpay.utils.b.d(f462136k)));
    L15:
        r102.putString("pay_tn", f462136k);
        goto L16
    L30:
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L12
        r104.put("os", "android");     // Catch: Exception -> L12
        r104.put("tn", f462136k);     // Catch: Exception -> L12
        r102.putString("paydata", UPUtils.e(r103, com.unionpay.utils.b.d(r104.toString())));     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L7:
        r103 = 0;
    L16:
        r102.putString("magic_data", "949A1CC");
        r102.putString("wapurl", r100);
        r102.putString(ReportConstant.COMMON_ACTION_TYPE, r101);
        Context r105 = k();     // Catch: Exception -> L25
        if (r105 == null) goto L32;
        Intent r106 = new Intent();     // Catch: Exception -> L25
        r106.putExtras(r102);     // Catch: Exception -> L25
        r106.setClass(r105, UPPayWapActivity.class);     // Catch: Exception -> L25
        if ((r105 instanceof Activity) == false) goto L23;
        ((Activity) r105).startActivityForResult(r106, 10);     // Catch: Exception -> L25
        return;
    L23:
        r106.addFlags(268435456);     // Catch: Exception -> L25
        r105.startActivity(r106);     // Catch: Exception -> L25
        return;
    L32:
        return;
    L25:
        Context r107 = k();
        JSONArray r108 = f462148w;
        int r109 = f462140o + 1;
        f462140o = r109;
        f(r107, r108, r109);
    }

    public static JSONArray e(JSONArray r100) {
        ArrayList r101 = new ArrayList();
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r100 == null) goto L7;
        if (r103 >= r100.length()) goto L7;
        r101.add(r100.optJSONObject(r103));
        r103 = r103 + 1;
    L7:
        Collections.sort(r101, new k());
        JSONArray r104 = new JSONArray();
    L9:
        if (r102 >= r101.size()) goto L11;
        r104.put((JSONObject) ListProtector.get(r101, r102));
        r102 = r102 + 1;
        goto L9
    L11:
        return r104;
    }

    public static void g(String r100, String r101) {
        Bundle r102 = new Bundle();
        c(f462136k, r102, f462139n);
        r102.putString("SpId", f462137l);
        r102.putString("SysProvide", f462138m);
        r102.putString("paydata", f462136k);
        r102.putString("source", f462131f);
        r102.putString("se_type", f462132g);
        if (TextUtils.isEmpty(f462132g) == true) goto L5;
        r102.putString("se_title_logo", f462126a);
        r102.putString("se_loading_logo", f462127b);
        r102.putString("se_title_bg_color", f462128c);
        r102.putString("se_cancel_bg_color", f462129d);
    L5:
        r102.putBoolean("dlgstyle", f462134i);
        r102.putString(BenefitStore.FROM_SERVER, r101);
        r102.putString("SecurityChipType", null);
        r102.putInt("reqOriginalId", 0);
        Intent r103 = new Intent();
        r103.putExtras(r102);
        if ("com.huawei.wallet".equals(r100) == false) goto L8;
        r103.setAction("com.huawei.wallet.action.onlinepay.startpay");
        r103.setPackage(r100);
    L9:
        Context r104 = k();
        if (r104 != null) goto L12;
        return;
    L12:
        if ((r104 instanceof Activity) == false) goto L15;
        ((Activity) r104).startActivityForResult(r103, 10);
        return;
    L15:
        r103.addFlags(268435456);
        r104.startActivity(r103);
        return;
    L8:
        r103.setClassName(r100, "com.unionpay.uppay.PayActivity");
        goto L9
    }

    public static void i(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L4
        f462126a = JSONObjectProtectorUtils.getString(r101, "titleLogo");     // Catch: Exception -> L4
        f462127b = JSONObjectProtectorUtils.getString(r101, "loadingLogo");     // Catch: Exception -> L4
        f462128c = JSONObjectProtectorUtils.getString(r101, "backGroundColor");     // Catch: Exception -> L4
        f462129d = JSONObjectProtectorUtils.getString(r101, "textColor");     // Catch: Exception -> L4
        return;
    }

    public static Context k() {
        WeakReference r100 = f462135j;
        if (r100 != null) goto L5;
        return null;
    L5:
        return (Context) r100.get();
    }

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("entryexpro", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> entryexpro");
        com.bytedance.librarian.a.c("entryexpro");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> entryexpro");
    }

    public static void h(String r100) {
        int r101 = CastIntegerProtector.parseInt(f462139n);     // Catch: Exception -> L5
    L24:
    L12:
        th = move-exception;
        th.printStackTrace();
        String r102 = null;
    L14:
        "url: ".concat(String.valueOf(r102));
        f462143r = new wpc.c(r102);
        String r103 = b(k(), false, r100);
        wpc.c r104 = f462143r;
        r104.getClass();
        if (r103 == null) goto L18;
        r103.getBytes();
        r104.f560679b = r103;
    L18:
        if (f462144s != null) goto L20;
        f462144s = new Handler(f462149x);
    L20:
        h r105 = new h();
        PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("UPPayAssistEx")).execute(r105);
        return;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        boolean r106 = true;
    L10:
        r102 = UPUtils.c(UPUtils.forUrl(r101, r106));     // Catch: Throwable -> L12
        goto L14
    L9:
        r106 = false;
    L5:
        r101 = 0;
        goto L24
    }

    public static void j(String r100) {
        String r101 = f462139n;
        HashMap r102 = com.unionpay.utils.b.f462195a;
        if (TextUtils.isEmpty(r101) == false) goto L55;
    L6:
        int r103 = 0;
    L57:
    L13:
        th = move-exception;
        th.printStackTrace();
        String r104 = null;
    L15:
        "calling app url: ".concat(String.valueOf(r104));
        f462143r = new wpc.c(r104);
        Context r105 = k();
        String r106 = f462136k;
        JSONObject r107 = new JSONObject();
        r107.put(BaseSwitches.V, "1.5");     // Catch: Exception -> L46
        r107.put("os_name", "android");     // Catch: Exception -> L46
        if (TextUtils.isEmpty(r106) == true) goto L59;
        r107.put("tn", UPUtils.e(r103, com.unionpay.utils.b.d(r106)));     // Catch: Exception -> L46
    L59:
        r107.put("terminal_version", "3.5.18");     // Catch: Exception -> L23
        String r108 = Build.VERSION.RELEASE;     // Catch: Exception -> L23
        String r109 = "";
        if (TextUtils.isEmpty(r108) == true) goto L25;
        String r110 = r108.trim();     // Catch: Exception -> L23
    L26:
        r107.put("os_version", r110);     // Catch: Exception -> L23
        String r111 = Build.MODEL;     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r111) == true) goto L31;
        String r112 = r111.trim();     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r112) == true) goto L31;
        String r113 = r112.replace(" ", "");     // Catch: Exception -> L23
    L32:
        r107.put("device_model", r113);     // Catch: Exception -> L23
        if (r105 != null) goto L35;
    L39:
        r107.put("app_version", r109);     // Catch: Exception -> L23
    L43:
        if (TextUtils.isEmpty(r100) == true) goto L48;
        r107.put("package_name", r100);     // Catch: Exception -> L46
    L48:
        String r114 = r107.toString();
        wpc.c r115 = f462143r;
        r115.getClass();
        if (r114 == null) goto L51;
        r114.getBytes();
        r115.f560679b = r114;
    L51:
        j r116 = new j();
        PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("UPPayAssistEx")).execute(r116);
        return;
    L35:
        if (TextUtils.isEmpty(r100) == true) goto L39;
        PackageInfo r117 = r105.getPackageManager().getPackageInfo(r100, 0);     // Catch: Exception -> L53
        if (r117 == null) goto L39;
        r109 = r117.versionName;     // Catch: Exception -> L53
    L31:
        r113 = "";
        goto L32
    L25:
        r110 = "";
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L46
    L46:
        e = move-exception;
        e.printStackTrace();
        goto L48
    L8:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        boolean r118 = true;
    L11:
        r104 = UPUtils.c(UPUtils.forCallingAppUrl(r103, r118));     // Catch: Throwable -> L13
        goto L15
    L10:
        r118 = false;
        goto L11
    L55:
        r103 = CastIntegerProtector.parseInt(r101);     // Catch: Exception -> L54
        goto L57
    }

    public static String b(Context r110, boolean r111, String r112) {
        String r100 = f462139n;
        if (r111 == false) goto L5;
        String r101 = null;
    L6:
        String r102 = "0";
        if (r111 == false) goto L9;
        CharSequence r113 = "0";
    L10:
        String r103 = f462133h;
        String r104 = f462130e;
        JSONObject r105 = new JSONObject();
        r105.put(BaseSwitches.V, "1.5");     // Catch: Exception -> L104
        r105.put("sdkVerMode", "02");     // Catch: Exception -> L104
        r105.put("os_name", "android");     // Catch: Exception -> L104
        int r106 = 0;
        if (TextUtils.isEmpty(r101) == true) goto L20;
        HashMap r114 = com.unionpay.utils.b.f462195a;     // Catch: Exception -> L104
        if (TextUtils.isEmpty(r100) == false) goto L126;
    L17:
        int r115 = 0;
    L18:
        r105.put("tn", UPUtils.e(r115, com.unionpay.utils.b.d(r101)));     // Catch: Exception -> L104
        goto L20
    L126:
        r115 = CastIntegerProtector.parseInt(r100);     // Catch: Exception -> L108
    L20:
        String r116 = "";
        if (r110 != null) goto L118;
    L28:
        String r117 = "";
    L29:
        r105.put("appUuId", r117);     // Catch: Exception -> L104
    L43:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L104
    L82:
        r105.put("vendorCapacity", r112);     // Catch: Exception -> L104
        if (TextUtils.isEmpty(null) == true) goto L89;
        HashMap r118 = com.unionpay.utils.b.f462195a;     // Catch: Exception -> L104
        if (TextUtils.isEmpty(r100) == false) goto L116;
    L87:
        r105.put("randKey", UPUtils.e(r106, com.unionpay.utils.b.d(null)));     // Catch: Exception -> L104
        goto L89
    L116:
        r106 = CastIntegerProtector.parseInt(r100);     // Catch: Exception -> L110
    L89:
        if (TextUtils.isEmpty(r113) == true) goto L92;
        r105.put("has_sdk", r113);     // Catch: Exception -> L104
    L92:
        if (TextUtils.isEmpty(null) == true) goto L95;
        r105.put("merId", null);     // Catch: Exception -> L104
    L95:
        if (TextUtils.isEmpty(r103) == true) goto L98;
        r105.put("isLimitSe", r103);     // Catch: Exception -> L104
    L98:
        if (TextUtils.isEmpty(r104) == true) goto L107;
        HashMap r119 = com.unionpay.utils.b.f462195a;     // Catch: Exception -> L104
        if (TextUtils.isEmpty((CharSequence) r119.get(r104)) == true) goto L102;
        r104 = (String) r119.get(r104);     // Catch: Exception -> L104
    L102:
        r105.put("seType", r104);     // Catch: Exception -> L104
    L107:
        return r105.toString();
    L31:
        if (Locale.getDefault().toString().startsWith("zh") == false) goto L33;
        String r107 = "zh_CN";
    L34:
        r105.put("locale", r107);     // Catch: Exception -> L43
        r105.put("terminal_version", "3.5.18");     // Catch: Exception -> L43
        if (r110 == null) goto L39;
        Resources r108 = r110.getResources();     // Catch: Exception -> L43
        if (r108 == null) goto L39;
        DisplayMetrics r109 = WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics());     // Catch: Exception -> L43
        int r120 = r109.widthPixels;     // Catch: Exception -> L43
        int r121 = r109.heightPixels;     // Catch: Exception -> L43
    L40:
        r105.put("terminal_resolution", (r120 + "*" + r121).trim());     // Catch: Exception -> L43
        String r122 = Build.VERSION.RELEASE;     // Catch: Exception -> L43
        if (TextUtils.isEmpty(r122) == true) goto L45;
        String r123 = r122.trim();     // Catch: Exception -> L43
    L46:
        r105.put("os_version", r123);     // Catch: Exception -> L43
        String r124 = Build.MODEL;     // Catch: Exception -> L43
        if (TextUtils.isEmpty(r124) == true) goto L51;
        String r125 = r124.trim();     // Catch: Exception -> L43
        if (TextUtils.isEmpty(r125) == true) goto L51;
        String r126 = r125.replace(" ", "");     // Catch: Exception -> L43
    L52:
        r105.put("device_model", r126);     // Catch: Exception -> L43
        if (new PolarisFileWrapper("/system/bin/su").exists() == false) goto L55;
        r102 = "1";
    L55:
        r105.put(RootDescription.ROOT_ELEMENT, r102);     // Catch: Exception -> L43
        if ((r110 instanceof Activity) == false) goto L60;
        String r127 = ((Activity) r110).getPackageName();     // Catch: Exception -> L112
    L61:
        if (r127 == null) goto L62;
    L63:
        HashMap r128 = com.unionpay.utils.b.f462195a;     // Catch: Exception -> L43
        String r129 = PatternProtector.compile("[\":,\\[\\]{}]").matcher(r127).replaceAll("").trim();     // Catch: Exception -> L66
    L67:
        r105.put("package", r129);     // Catch: Exception -> L43
        if ((r110 instanceof Activity) == false) goto L72;
        String r130 = ((Activity) r110).getPackageName();     // Catch: Exception -> L111
    L73:
        if (r130 == null) goto L74;
    L122:
        r116 = PatternProtector.compile("[\":,\\[\\]{}]").matcher(r130).replaceAll("").trim();     // Catch: Exception -> L109
    L76:
        r105.put("sign", com.unionpay.utils.e.a(r110, r116));     // Catch: Exception -> L43
        String r131 = Build.MANUFACTURER;     // Catch: Exception -> L43
        if (TextUtils.isEmpty(r131) == true) goto L79;
        r131 = r131.toUpperCase();     // Catch: Exception -> L43
    L79:
        r105.put("phone_model", r131);     // Catch: Exception -> L43
    L72:
        r130 = "";
    L74:
        r130 = "";
    L66:
        r129 = "";
        goto L67
    L60:
        r127 = "";
    L62:
        r127 = "";
    L51:
        r126 = "";
        goto L52
    L45:
        r123 = "";
    L39:
        r121 = 0;
        r120 = 0;
        goto L40
    L33:
        r107 = DyResUtils.ResI18n.en_US;
        goto L34
    L118:
        r117 = UPUtils.a(r110, "merchant_id");     // Catch: Exception -> L113
        if (TextUtils.isEmpty(r117) == false) goto L29;
        r117 = UUID.randomUUID().toString();     // Catch: Exception -> L113
        if (TextUtils.isEmpty(r117) == true) goto L29;
        r117 = r117.replaceAll("-", "");     // Catch: Exception -> L113
        UPUtils.d(r110, r117, "merchant_id");     // Catch: Exception -> L113
    L104:
        e = move-exception;
        e.printStackTrace();
        goto L107
    L9:
        r113 = null;
        goto L10
    L5:
        r101 = f462136k;
        goto L6
    }

    public static void f(Context r110, JSONArray r111, int r112) {
        if (r111 != null) goto L4;
        return;
    L4:
        if (r112 >= r111.length()) goto L116;
        Object r113 = com.unionpay.utils.g.a(r111, r112);
        if (r113 == null) goto L117;
        JSONObject r114 = (JSONObject) r113;
        String r115 = com.unionpay.utils.g.b(r114, "type");
        String r100 = "";
        if ("app".equals(r115) == false) goto L60;
        if (r114.has("package_info") == true) goto L92;
    L14:
        JSONArray r116 = null;
    L15:
        String r117 = com.unionpay.utils.g.b(r114, "app_server");
        JSONArray r118 = e(r116);
        boolean r101 = false;
        if (r118.length() <= 0) goto L57;
        int r102 = r118.length();
        int r103 = 0;
        boolean r104 = false;
    L18:
        if (r103 >= r102) goto L56;
        Object r105 = com.unionpay.utils.g.a(r118, r103);
        if (r105 == null) goto L55;
        JSONObject r106 = (JSONObject) r105;
        String r107 = com.unionpay.utils.g.b(r106, "schema");
        String r108 = com.unionpay.utils.g.b(r106, "sign");
        String r109 = com.unionpay.utils.g.b(r106, "version");
        HashMap r119 = com.unionpay.utils.b.f462195a;
        if (r110 != null) goto L90;
    L30:
        PackageInfo r120 = null;
    L31:
        if (r120 == null) goto L33;
        boolean r121 = true;
    L34:
        if (r121 == false) goto L55;
        if (r108.equalsIgnoreCase(com.unionpay.utils.b.c(r110, r107, "SHA1")) == false) goto L55;
        if (r110 != null) goto L39;
    L44:
        String r122 = "";
    L46:
        if (r122.matches(r109) == false) goto L55;
        g(r107, r117);     // Catch: Exception -> L52
        j(r107);     // Catch: Exception -> L50
        r101 = true;
    L50:
        Exception e100 = e;
        boolean r123 = true;
    L54:
        e100.printStackTrace();
        r104 = r123;
    L52:
        e = move-exception;
        r123 = r104;
        e100 = e;
        goto L54
    L39:
        if (TextUtils.isEmpty(r107) == true) goto L44;
        PackageInfo r124 = r110.getPackageManager().getPackageInfo(r107, 0);     // Catch: Exception -> L85
        if (r124 == null) goto L44;
        r122 = r124.versionName;     // Catch: Exception -> L85
    L33:
        r121 = false;
        goto L34
    L90:
        PackageManager r125 = r110.getPackageManager();     // Catch: Exception -> L29
        if (r125 == null) goto L30;
        if (TextUtils.isEmpty(r107) == true) goto L30;
        r120 = r125.getPackageInfo(r107, 0);     // Catch: Exception -> L29
    L55:
        r103 = r103 + 1;
        goto L18
    L56:
        r101 = r104;
    L57:
        if (r101 == true) goto L118;
        JSONArray r126 = f462148w;
        int r127 = f462140o + 1;
        f462140o = r127;
        f(r110, r126, r127);
        return;
    L118:
        return;
    L92:
        r116 = JSONObjectProtectorUtils.getJSONArray(r114, "package_info");     // Catch: Exception -> L13
    L13:
        com.unionpay.utils.g.class.toString();
        goto L14
    L60:
        if ("wap".equals(r115) == false) goto L68;
        if ("samsung_out".equals(f462131f) == false) goto L98;
        JSONArray r128 = f462148w;
        int r129 = f462140o + 1;
        f462140o = r129;
        f(r110, r128, r129);
        return;
    L98:
        r100 = (String) r114.get("url");     // Catch: Exception -> L86
    L66:
        d(r100, "wap");
        return;
    L68:
        if ("link".equals(r115) == false) goto L72;
        r100 = JSONObjectProtectorUtils.getString(r114, "url");     // Catch: Exception -> L89
    L70:
        d(r100, "link");
        return;
    L72:
        if ("wcd".equals(r115) == false) goto L76;
        r100 = JSONObjectProtectorUtils.getString(r114, "url");     // Catch: Exception -> L88
    L74:
        d(r100, "wcd");
        return;
    L76:
        if ("toast".equals(r115) == false) goto L83;
        String r130 = com.unionpay.utils.g.b(r114, "text");
        if (TextUtils.isEmpty(r130) == false) goto L102;
    L82:
        JSONArray r131 = f462148w;
        int r132 = f462140o + 1;
        f462140o = r132;
        f(r110, r131, r132);
        return;
    L102:
        Toast.makeText(r110, new String(Base64.decode(r130, 2), "UTF-8"), 1).show();     // Catch: Exception -> L87
        return;
    L83:
        Context r133 = k();
        JSONArray r134 = f462148w;
        int r135 = f462140o + 1;
        f462140o = r135;
        f(r133, r134, r135);
        return;
    L117:
        return;
    }
}
