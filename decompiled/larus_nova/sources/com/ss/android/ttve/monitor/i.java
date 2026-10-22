package com.ss.android.ttve.monitor;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.vesdk.VEConfigCenter;
import com.ss.android.vesdk.VELogUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<IMonitor> f449941a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f449942b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f449943c;

    public static void a(int r100) {
        if (f449943c == false) goto L5;
        return;
    L5:
        TEMonitorInvoker.nativeReset(r100);
    }

    public static void c(int r100) {
        if (r100 != 0) goto L6;
        f(0, "te_record_err_code", 0);
        return;
    L6:
        if (r100 != 1) goto L10;
        f(1, "te_edit_err_code", 0);
        f(1, "te_composition_err_code", 0);
        return;
    }

    public static void j(int r100) {
        if (f449943c == false) goto L5;
        return;
    L5:
        TEMonitorInvoker.nativeMonitorPerfWithType(r100);
    }

    public static void b(Context r100, String r101) {
        boolean r102 = VEConfigCenter.getInstance().getValue("ve_applog_opt", false).booleanValue();
        f449943c = r102;
        if (r102 == false) goto L6;
        g.f449935a = false;
        return;
    L6:
        TEMonitorInvoker.nativeInit();
        Context r103 = r100.getApplicationContext();
        if (g.f449935a == true) goto L10;
        return;
    L10:
        if (g.f449939e == true) goto L12;
        g.f449937c = true;
        return;
    L12:
        if (g.f449937c == false) goto L14;
        return;
    L14:
        if (g.f449936b != null) goto L19;
        PthreadThreadV2 r104 = new PthreadThreadV2(new f(r103, r101), "/MonitorUtils");
        g.f449936b = r104;
        ThreadMethodProxy.start(r104);
        return;
    }

    public static void e(String r100, double r101) {
        if (f449943c == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        VELogUtil.w("TEMonitor", "perfDouble: key is null");
        return;
    L9:
        TEMonitorInvoker.nativePerfDouble(0, r100, r101);
    }

    public static boolean d(String r100, String r101, Map r110) {
        boolean r102 = f449943c;
        if (r102 == false) goto L5;
        return false;
    L5:
        WeakReference<IMonitor> r103 = f449941a;
        if (r102 == true) goto L63;
        JSONObject r104 = new JSONObject();
    L46:
        VELogUtil.d("TEMonitor", "No monitor callback, skip");
        return false;
    L10:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        r104.put("service", r101);     // Catch: JSONException -> L46
    L13:
        if (r101.equals("iesve_veeditor_record_finish") == false) goto L15;
    L44:
        h(r101, r110, r104);     // Catch: JSONException -> L46
    L45:
        i(r103, r100, r104);
        return true;
    L15:
        if (r101.equals("iesve_veeditor_composition_finish") == true) goto L44;
        if (r101.equals("iesve_veeditor_edit") == true) goto L44;
        if (r101.equals("iesve_veeditor_cut") == true) goto L44;
        if (r101.equals("iesve_veeditor_frame_report") == true) goto L44;
        if (f449943c == true) goto L45;
        Iterator r105 = r110.keySet().iterator();     // Catch: JSONException -> L46
    L28:
        if (r105.hasNext() == false) goto L45;
        String r106 = (String) r105.next();     // Catch: JSONException -> L46
        if (r106.startsWith("iesve_") == false) goto L32;
        int r107 = k.getType(r106);     // Catch: JSONException -> L46
    L33:
        if (r107 != 1) goto L39;
        r104.put(r106, CastIntegerProtector.parseInt(String.valueOf(r110.get(r106))));     // Catch: Exception -> L36
    L36:
        VELogUtil.e("TEMonitor", "Parse int error:" + r110.get(r106));     // Catch: JSONException -> L46
        goto L28
    L39:
        if (r107 != 2) goto L43;
        r104.put(r106, CastFloatProtector.parseFloat(String.valueOf(r110.get(r106))));     // Catch: Exception -> L42
    L42:
        VELogUtil.e("TEMonitor", "Parse float error");     // Catch: JSONException -> L46
        goto L28
    L43:
        r104.put(r106, r110.get(r106));     // Catch: JSONException -> L46
        goto L28
    L32:
        r107 = k.getType(r106);     // Catch: JSONException -> L46
        goto L33
    L63:
        return false;
    }

    public static void f(int r100, String r101, long r102) {
        if (f449943c == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return;
    L8:
        TEMonitorInvoker.nativePerfLong(r100, r101, r102);
    }

    public static void g(int r100, String r101, String r102) {
        if (f449943c == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        VELogUtil.w("TEMonitor", "perfString: key is null");
        return;
    L9:
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        TEMonitorInvoker.nativePerfString(r100, r101, r102);
    }

    public static void h(String r100, Map r101, JSONObject r102) throws JSONException {
        if (f449943c == false) goto L5;
        return;
    L5:
        Iterator r103 = r101.keySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L30;
        String r104 = (String) r103.next();
        if (r100.equals("iesve_veeditor_record_finish") == false) goto L11;
    L18:
        int r105 = k.getType(r104);
    L20:
        if (r105 != 1) goto L25;
        r102.put(r104, CastIntegerProtector.parseInt(String.valueOf(r101.get(r104))));     // Catch: Exception -> L23
    L23:
        VELogUtil.e("TEMonitor", "Parse int error:" + r101.get(r104));
        goto L7
    L25:
        if (r105 != 2) goto L29;
        r102.put(r104, CastFloatProtector.parseFloat(String.valueOf(r101.get(r104))));     // Catch: Exception -> L28
    L28:
        VELogUtil.e("TEMonitor", "Parse float error");
        goto L7
    L29:
        r102.put(r104, r101.get(r104));
        goto L7
    L11:
        if (r100.equals("iesve_veeditor_composition_finish") == true) goto L18;
        if (r100.equals("iesve_veeditor_edit") == true) goto L18;
        if (r100.equals("iesve_veeditor_cut") == true) goto L18;
        r105 = k.getType(r104);
        goto L20
    }

    public static void i(WeakReference<IMonitor> r100, String r101, JSONObject r102) {
        if (f449943c == false) goto L5;
        return;
    L5:
        if (r102 == null) goto L40;
    L11:
        e = move-exception;
        VELogUtil.e("TEMonitor", "get complete filed error!");
        e.printStackTrace();
    L89:
    L37:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L14:
        if (r102.has("service") == false) goto L17;
        String r103 = JSONObjectProtectorUtils.getString(r102, "service");     // Catch: JSONException -> L37
    L20:
        if (r103.equals("iesve_veeditor_record_finish") == true) goto L24;
        if (r103.equals("iesve_veeditor_composition_finish") == true) goto L24;
    L34:
        if (r103.equals("iesve_veeditor_composition_finish") == false) goto L40;
        f449942b = "";     // Catch: JSONException -> L37
    L24:
        if ("".equals(f449942b) == false) goto L32;
        StringBuilder r104 = new StringBuilder("null_");     // Catch: JSONException -> L37
        boolean r105 = g.f449935a;     // Catch: JSONException -> L37
        if (r105 == false) goto L31;
        if (r105 == false) goto L31;
        g.a();     // Catch: JSONException -> L37
    L31:
        r104.append(System.currentTimeMillis());     // Catch: JSONException -> L37
        f449942b = r104.toString();     // Catch: JSONException -> L37
    L32:
        r102.put("te_record_compose_vid", f449942b);     // Catch: JSONException -> L37
        goto L34
    L17:
        r103 = "sdk_video_edit_compose";
        goto L20
    L8:
        if (r102.has("completed") == false) goto L89;
        JSONObjectProtectorUtils.getInt(r102, "completed");     // Catch: JSONException -> L11
    L40:
        if (g.f449935a == false) goto L79;
        if (r102 == null) goto L79;
        g.a();
        if (g.f449935a == false) goto L49;
        g.a();
    L49:
        if (TextUtils.isEmpty(null) == false) goto L52;
        g.d();
    L52:
        if (g.f449935a == false) goto L56;
        g.a();
    L56:
        if (TextUtils.isEmpty(null) == false) goto L59;
        g.d();
    L59:
        if (g.f449935a == false) goto L63;
        g.a();
    L63:
        if (TextUtils.isEmpty(null) == false) goto L85;
        g.d();
    L85:
        Iterator r106 = ((HashMap) RuntimeInfoUtils.b()).entrySet().iterator();     // Catch: JSONException -> L78
    L66:
        if (r106.hasNext() == false) goto L79;
        Map.Entry r107 = (Map.Entry) r106.next();     // Catch: JSONException -> L78
        String r108 = (String) r107.getValue();     // Catch: JSONException -> L78
        if (((ArrayList) RuntimeInfoUtils.f449917c).contains(r107.getKey()) == true) goto L72;
        r102.put("te_device_info_" + ((String) r107.getKey()), r108);     // Catch: JSONException -> L78
        goto L66
    L72:
        if (TextUtils.isEmpty(r108) == true) goto L66;
        r102.put("te_device_info_" + ((String) r107.getKey()), CastFloatProtector.parseFloat(r108));     // Catch: Exception -> L75
    L75:
        String r109 = (String) r107.getKey();     // Catch: JSONException -> L78
    L79:
        if (r100 != null) goto L81;
        return;
    L81:
        if (r100.get() == null) goto L104;
        r100.get().monitorLog(r101, r102);     // Catch: Exception -> L84
        return;
    L105:
        return;
    }
}
