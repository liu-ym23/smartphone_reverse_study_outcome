package com.obric.oui.common.style;

import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f399531f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f399532g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f399533h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f399534i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f399535j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f399536k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final HashMap<Integer, Pair<Integer, Integer>> f399537l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f399538m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static TypedValue f399539n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f399540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f399541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f399542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f399543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f399544e;

    static {
        String r100 = (String) a().getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(null, new Object[]{"ro.pvr.product.name", "Phoenix"});     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r100) == true) goto L5;
    L6:
        f399532g = r100;
        f399533h = "Phoenix".equals(r100);
        f399534i = "Phoenix".equals(r100);
        f399535j = true;
        f399536k = -1;
        f399537l = new HashMap();
        f399538m = false;
        return;
    L5:
        r100 = "Phoenix";
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public j(View r100) {
        boolean r101 = true;
        this.f399541b = true;
        this.f399542c = true;
        this.f399543d = true;
        this.f399540a = new WeakReference(r100);
        Context r102 = r100.getContext();
        if (f399539n != null) goto L5;
        f399539n = new TypedValue();
    L5:
        r102.getTheme().resolveAttribute(R.attr.oui_effect_enabled, f399539n, true);
        if (f399539n.data != 0) goto L9;
        r101 = false;
    L9:
        this.f399544e = r101;
    }

    public static boolean d(String r100) {
        String[] r101 = r100.split(",");
        if (r101.length <= 0) goto L11;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L11;
        String r104 = r101[r103];
        if (f399532g.equals(r104) == true) goto L8;
        r103 = r103 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    public final void b(boolean r100) {
        if (this.f399540a.get() == null) goto L34;
        boolean r101 = !r100;
        if (f399535j == false) goto L16;
        if (this.f399542c == false) goto L16;
        this.f399540a.get().getContext();
        int r102 = f399536k;
        if (f399533h == false) goto L16;
        if (r102 < 100000) goto L16;
        if (f399538m == true) goto L16;
    L16:
        if (this.f399543d == false) goto L35;
        Context r103 = this.f399540a.get().getContext();
        int r104 = f399536k;
        if (f399534i == false) goto L36;
        if (r104 < 100000) goto L37;
        Pair<Integer, Integer> r105 = f399537l.get(Integer.valueOf(r104));
        AudioManager r106 = (AudioManager) r103.getSystemService("audio");
        if (r105 != null) goto L25;
        return;
    L25:
        if (f399538m == true) goto L27;
    L27:
        if (r101 == true) goto L29;
        int r107 = ((Integer) r105.first).intValue();
    L32:
        r106.playSoundEffect(r107, 1.0f);
        return;
    L29:
        if (r101 != true) goto L31;
        r107 = ((Integer) r105.second).intValue();
        goto L32
    L31:
        r107 = 10;
        goto L32
    L37:
        return;
    L36:
        return;
    L35:
        return;
    }

    public final void e(boolean r100) {
        if (this.f399544e == true) goto L5;
        return;
    L5:
        if (r100 == true) goto L7;
        return;
    L7:
        if (this.f399541b == false) goto L11;
        b(true);
        return;
    }

    public final void f(int r110) {
        String r100 = "";
        if (r110 != 0) goto L77;
        if (this.f399544e == false) goto L106;
        View r111 = this.f399540a.get();
        if (r111 != null) goto L10;
        return;
    L10:
        if (r111.getContext() != null) goto L12;
        return;
    L12:
        if (f399531f == true) goto L107;
        f399531f = true;
        Context r112 = r111.getContext();
        f399537l.clear();
        Settings.Global.getInt(r112.getContentResolver(), "controller_vibration_level", 0);
        if (Settings.Global.getInt(r112.getContentResolver(), "system_vibration_enabled", 1) != 1) goto L17;
        boolean r101 = true;
    L18:
        f399535j = r101;
        String r113 = Settings.Global.getString(r112.getContentResolver(), "pvr_ui_config");
        if (TextUtils.isEmpty(r113) == false) goto L86;
    L71:
        boolean r114 = f399538m;
        if (r114 == true) goto L74;
    L74:
        if (r114 == true) goto L105;
        return;
    L105:
        return;
    L86:
        JSONObject r102 = new JSONObject(r113);     // Catch: JSONException -> L67
        JSONObject r115 = JSONObjectProtectorUtils.getJSONObject(r102, "vibration");     // Catch: JSONException -> L33
        c(r115, "def_hover_fre");     // Catch: JSONException -> L33
        c(r115, "def_hover_level");     // Catch: JSONException -> L33
        c(r115, "def_hover_dur");     // Catch: JSONException -> L33
        c(r115, "def_press_fre");     // Catch: JSONException -> L33
        c(r115, "def_press_level");     // Catch: JSONException -> L33
        c(r115, "def_press_dur");     // Catch: JSONException -> L33
        c(r115, "weak_hover_fre");     // Catch: JSONException -> L33
        c(r115, "weak_hover_level");     // Catch: JSONException -> L33
        c(r115, "weak_hover_dur");     // Catch: JSONException -> L33
        c(r115, "weak_press_fre");     // Catch: JSONException -> L33
        c(r115, "weak_press_level");     // Catch: JSONException -> L33
        c(r115, "weak_press_dur");     // Catch: JSONException -> L33
        c(r115, "strong_hover_fre");     // Catch: JSONException -> L33
        c(r115, "strong_hover_level");     // Catch: JSONException -> L33
        c(r115, "strong_hover_dur");     // Catch: JSONException -> L33
        c(r115, "strong_press_fre");     // Catch: JSONException -> L33
        c(r115, "strong_press_level");     // Catch: JSONException -> L33
        c(r115, "strong_press_dur");     // Catch: JSONException -> L33
        String r103 = JSONObjectProtectorUtils.getString(r115, "device_allowed");     // Catch: JSONException -> L24
    L91:
        boolean r116 = JSONObjectProtectorUtils.getBoolean(r115, "debug");     // Catch: JSONException -> L28
    L29:
        f399538m = r116;     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r103) == true) goto L89;
        f399533h = d(r103);     // Catch: JSONException -> L33
    L89:
        JSONObject r117 = JSONObjectProtectorUtils.getJSONObject(r102, RemoteMessageConst.Notification.SOUND);     // Catch: JSONException -> L62
        String r104 = JSONObjectProtectorUtils.getString(r117, "device_allowed");     // Catch: JSONException -> L40
    L42:
        if (TextUtils.isEmpty(r104) == true) goto L84;
        f399534i = d(r104);     // Catch: JSONException -> L62
    L84:
        r100 = JSONObjectProtectorUtils.getString(r117, "device_id_effect_type");     // Catch: JSONException -> L81
    L47:
        if (TextUtils.isEmpty(r100) == true) goto L71;
        String[] r118 = r100.split(com.alipay.sdk.m.u.i.f25853b);     // Catch: JSONException -> L62
        if (r118.length <= 0) goto L71;
        int r105 = r118.length;     // Catch: JSONException -> L62
        int r106 = 0;
    L51:
        if (r106 >= r105) goto L71;
        String[] r107 = r118[r106].split(",");     // Catch: JSONException -> L62
    L54:
        if (r107.length != 3) goto L61;
        f399537l.put(Integer.valueOf(CastIntegerProtector.parseInt(r107[0])), new Pair(Integer.valueOf(CastIntegerProtector.parseInt(r107[1])), Integer.valueOf(CastIntegerProtector.parseInt(r107[2]))));     // Catch: Exception -> L57
    L57:
        e = move-exception;
        if (f399538m == false) goto L61;
        e.toString();     // Catch: JSONException -> L62
    L61:
        r106 = r106 + 1;
    L40:
        r104 = "";
    L62:
        e = move-exception;
        if (f399538m == false) goto L71;
        e.toString();     // Catch: JSONException -> L67
    L28:
        r116 = false;
    L24:
        r103 = "";
    L33:
        e = move-exception;
        if (f399538m == false) goto L89;
        e.toString();     // Catch: JSONException -> L67
    L67:
        e = move-exception;
        if (f399538m == false) goto L71;
        e.toString();
        goto L71
    L17:
        r101 = false;
        goto L18
    L107:
        return;
    L106:
        return;
    L77:
        if (this.f399544e == false) goto L108;
        f399531f = false;
        return;
    }

    public final void g(boolean r100) {
        if (this.f399544e == true) goto L5;
        return;
    L5:
        View r101 = this.f399540a.get();
        if (r101 != null) goto L9;
        return;
    L9:
        if ((r101.isPressed() ^ r100) == false) goto L14;
        if (r100 == false) goto L12;
        b(false);
        this.f399541b = false;
        return;
    L12:
        r101.postDelayed(new i(this), 20);
        return;
    }

    public final void h(MotionEvent r100) {
        if (this.f399544e == true) goto L5;
        return;
    L5:
        f399536k = r100.getDeviceId();
    }

    public static int c(JSONObject r100, String r101) {
        return JSONObjectProtectorUtils.getInt(r100, r101);
    L4:
        return -1;
    }
}
