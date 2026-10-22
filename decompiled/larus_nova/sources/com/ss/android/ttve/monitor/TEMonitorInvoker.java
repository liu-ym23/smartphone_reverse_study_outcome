package com.ss.android.ttve.monitor;

import com.ss.android.ttve.nativePort.TENativeLibsLoader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class TEMonitorInvoker {
    public TEMonitorInvoker() {
    }

    public static native Map<String, String> nativeGetMap();

    public static native Map<String, String> nativeGetMapByType(int r100);

    public static native void nativeInit();

    public static native void nativeMonitorPerf(int r100);

    public static native void nativeMonitorPerfWithType(int r100);

    public static native void nativePerfDouble(int r100, String r101, double r102);

    public static native void nativePerfDouble(String r100, double r101);

    public static native void nativePerfLong(int r100, String r101, long r102);

    public static native void nativePerfLong(String r100, long r101);

    public static native void nativePerfRational(String r100, float r101, float r102);

    public static native void nativePerfString(int r100, String r101, String r102);

    public static native void nativePerfString(String r100, String r101);

    public static native void nativeReset();

    public static native void nativeReset(int r100);

    static {
        TENativeLibsLoader.loadBase();
    }

    public static void onNativeCallback_onMonitorLogFloat(String r100, String r101, float r102) {
        if (i.f449943c == true) goto L7;
        HashMap r103 = new HashMap();
        r103.put(r101, Float.valueOf(r102));
        i.d(r100, r101, r103);
        return;
    }

    public static void onNativeCallback_onMonitorLogInt(String r100, String r101, long r102) {
        if (i.f449943c == true) goto L7;
        HashMap r103 = new HashMap();
        r103.put(r101, Long.valueOf(r102));
        i.d(r100, r101, r103);
        return;
    }

    public static void onNativeCallback_onMonitorLogJson(String r100, String r101, String r102) {
        if (i.f449943c == true) goto L19;
        JSONObject r103 = new JSONObject(r102);     // Catch: JSONException -> L10
        r103.put("service", r101);     // Catch: JSONException -> L8
    L13:
        i.i(i.f449941a, r100, r103);
        return;
    L8:
        e = e;
    L12:
        e.printStackTrace();
    L10:
        e = e;
        r103 = null;
        goto L12
    }

    public static void onNativeCallback_onMonitorLogMap(String r100, String r101, HashMap r102) {
        i.d(r100, r101, r102);
    }
}
