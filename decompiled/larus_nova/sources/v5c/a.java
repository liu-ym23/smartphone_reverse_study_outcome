package v5c;

import android.os.Build;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static final Boolean A = null;
    public static final Boolean B = null;
    public static final String C = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f553339a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f553340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f553341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f553342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f553343e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f553344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f553345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f553346h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f553347i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f553348j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Boolean f553349k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f553350l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Boolean f553351m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Boolean f553352n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f553353o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Boolean f553354p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f553355q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static String f553356r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Boolean f553357s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f553358t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f553359u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f553360v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f553361w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f553362x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Boolean f553363y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f553364z = null;

    static {
        ArrayList r100 = new ArrayList();
        f553339a = r100;
        r100.add(DyPayConstant.KEY_USER_UNIQUE_ID);
        r100.add("device_id");
        r100.add("tenant_id");
        r100.add("app_full_version");
        r100.add("LKP");
        f553340b = "";
        f553341c = "";
        f553342d = "";
        f553343e = "";
        f553344f = "";
        f553345g = "";
        f553346h = "0";
        f553347i = "lark";
        f553348j = "others";
        Boolean r101 = Boolean.FALSE;
        f553349k = r101;
        f553350l = "";
        f553351m = r101;
        f553352n = r101;
        f553353o = "none";
        f553354p = r101;
        f553355q = "";
        f553356r = "";
        f553357s = r101;
        f553358t = "";
        f553359u = "";
        f553360v = "";
        f553361w = "";
        f553362x = "";
        f553363y = r101;
        f553364z = "";
        A = r101;
        B = r101;
        C = "";
    }

    public static HashMap a() {
        HashMap r100 = new HashMap();
        String r101 = f553340b;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        String r104 = "none";
        if (r103 == false) goto L12;
        String r105 = "none";
    L13:
        r100.put(DyPayConstant.KEY_USER_UNIQUE_ID, r105);
        String r106 = f553341c;
        if (r106 != null) goto L16;
    L19:
        boolean r107 = true;
    L20:
        if (r107 == false) goto L22;
        String r108 = "none";
    L23:
        r100.put("device_id", r108);
        String r109 = f553342d;
        if (r109 != null) goto L26;
    L29:
        boolean r110 = true;
    L30:
        if (r110 == false) goto L32;
        String r111 = "none";
    L33:
        r100.put("tenant_id", r111);
        String r112 = f553343e;
        if (r112 != null) goto L36;
    L39:
        boolean r113 = true;
    L40:
        if (r113 == false) goto L42;
        r112 = "none";
    L42:
        r100.put("app_full_version", r112);
        String r114 = f553344f;
        if (r114 != null) goto L45;
    L48:
        boolean r115 = true;
    L49:
        if (r115 == false) goto L51;
        String r116 = "none";
    L52:
        r100.put("sys_rom_base_version", r116);
        String r117 = f553345g;
        if (r117 != null) goto L55;
    L58:
        boolean r118 = true;
    L59:
        if (r118 == false) goto L61;
        String r119 = "none";
    L62:
        r100.put("sys_rom_incremental_version", r119);
        String r120 = f553346h;
        if (r120 != null) goto L65;
    L68:
        boolean r121 = true;
    L69:
        if (r121 == false) goto L71;
        r120 = "none";
    L71:
        r100.put("LKP", r120);
        r100.put("platform", f553347i);
        r100.put("sub_platform", f553348j);
        r100.put("is_login", f553349k);
        String r122 = f553350l;
        if (r122 != null) goto L74;
    L77:
        boolean r123 = true;
    L78:
        if (r123 == false) goto L80;
        String r124 = "none";
    L81:
        r100.put("lark_user_id", r124);
        r100.put("is_device_64", f553351m);
        r100.put("is_app_64", f553352n);
        String r125 = f553353o;
        if (r125 != null) goto L84;
    L87:
        if (r102 == true) goto L90;
        r104 = r125;
    L90:
        r100.put("dark_mode", r104);
        r100.put("is_oversea_raw", f553354p);
        r100.put("user_geo", f553355q);
        r100.put("tenant_brand", f553356r);
        r100.put("ttwebview_version", C);
        r100.put("custom_device_model", Build.MODEL.toLowerCase(Locale.getDefault()));
        r100.put("is_harmony_os", f553357s);
        r100.put("harmony_version", f553358t);
        r100.put("package_deploy_mode", f553359u);
        r100.put("release_action", f553360v);
        r100.put("package_brand", f553361w);
        r100.put("package_job_id", f553362x);
        r100.put("cpu_count", Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        r100.put("is_pad", f553363y);
        r100.put("car_brand", f553364z);
        r100.put("is_supported_fold_display", A);
        r100.put("is_forseti_running", B);
        Log.i("Statistics-CustomHitHeaderHolder", "createCustomHitPointHeader: " + r100);
        return r100;
    L84:
        if (r125.length() == 0) goto L87;
        r102 = false;
        goto L87
    L80:
        r124 = f553350l;
        goto L81
    L74:
        if (r122.length() == 0) goto L77;
        r123 = false;
        goto L78
    L65:
        if (r120.length() == 0) goto L68;
        r121 = false;
        goto L69
    L61:
        r119 = f553345g;
        goto L62
    L55:
        if (r117.length() == 0) goto L58;
        r118 = false;
        goto L59
    L51:
        r116 = f553344f;
        goto L52
    L45:
        if (r114.length() == 0) goto L48;
        r115 = false;
        goto L49
    L36:
        if (r112.length() == 0) goto L39;
        r113 = false;
        goto L40
    L32:
        r111 = f553342d;
        goto L33
    L26:
        if (r109.length() == 0) goto L29;
        r110 = false;
        goto L30
    L22:
        r108 = f553341c;
        goto L23
    L16:
        if (r106.length() == 0) goto L19;
        r107 = false;
        goto L20
    L12:
        r105 = f553340b;
        goto L13
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
