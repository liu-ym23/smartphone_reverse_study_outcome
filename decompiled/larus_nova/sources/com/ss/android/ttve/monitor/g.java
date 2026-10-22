package com.ss.android.ttve.monitor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import faceverify.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f449935a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static PthreadThreadV2 f449936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f449937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f449938d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f449939e;

    static {
        f449938d = new Object();
        f449939e = false;
    }

    public static void a() {
        if (f449935a == true) goto L6;
        return;
    L6:
        if (f449939e == true) goto L8;
        return;
    L8:
        if (f449937c == true) goto L31;
        Object r100 = f449938d;
        monitor-enter(r100);
    L25:
    L19:
        th = move-exception;
        throw th;
    L12:
        if (f449937c == true) goto L17;
        System.currentTimeMillis();     // Catch: InterruptedException -> L15 Throwable -> L19
        f449938d.wait();     // Catch: InterruptedException -> L15 Throwable -> L19
        System.currentTimeMillis();     // Catch: InterruptedException -> L15 Throwable -> L19
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        goto L25
    L17:
        monitor-exit(r100);     // Catch: Throwable -> L19
        return;
    }

    public static void d() {
        if (f449935a == true) goto L5;
        return;
    L5:
        a();
    }

    public static void b(fic.a r100) {
        if (f449935a == true) goto L5;
        return;
    L5:
        a();
        if (r100 != null) goto L15;
        return;
    L15:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L14
        Iterator r102 = ((HashMap) r100.f477429a).entrySet().iterator();     // Catch: Exception -> L14
    L10:
        if (r102.hasNext() == false) goto L20;
        Map.Entry r103 = (Map.Entry) r102.next();     // Catch: Exception -> L14
        r101.put((String) r103.getKey(), r103.getValue());     // Catch: Exception -> L14
    L20:
        return;
    }

    public static void c(Context r100) {
        if (f449935a == true) goto L5;
        return;
    L5:
        HashMap r101 = new HashMap();
        SensorManager r102 = (SensorManager) r100.getSystemService(w.BLOB_ELEM_TYPE_SENSOR);
        Sensor r103 = r102.getDefaultSensor(4);
        boolean r104 = false;
        if (r103 == null) goto L8;
        boolean r105 = true;
    L9:
        r101.put("te_sensor_type_gyroscope_exist", Boolean.valueOf(r105));
        String r106 = null;
        if (r103 == null) goto L12;
        String r107 = r103.getName();
    L13:
        r101.put("te_sensor_type_gyroscope_name", r107);
        Sensor r108 = r102.getDefaultSensor(15);
        if (r108 == null) goto L16;
        boolean r109 = true;
    L17:
        r101.put("te_sensor_type_game_rotation_vector_exist", Boolean.valueOf(r109));
        if (r108 == null) goto L20;
        String r110 = r108.getName();
    L21:
        r101.put("te_sensor_type_game_rotation_vector_name", r110);
        Sensor r111 = r102.getDefaultSensor(11);
        if (r111 == null) goto L24;
        boolean r112 = true;
    L25:
        r101.put("te_sensor_type_rotation_vector_exist", Boolean.valueOf(r112));
        if (r111 == null) goto L28;
        String r113 = r111.getName();
    L29:
        r101.put("te_sensor_type_rotation_vector_name", r113);
        Sensor r114 = r102.getDefaultSensor(9);
        if (r114 == null) goto L32;
        boolean r115 = true;
    L33:
        r101.put("te_sensor_type_gravity_exist", Boolean.valueOf(r115));
        if (r114 == null) goto L36;
        String r116 = r114.getName();
    L37:
        r101.put("te_sensor_type_gravity_name", r116);
        Sensor r117 = r102.getDefaultSensor(1);
        if (r117 == null) goto L40;
        r104 = true;
    L40:
        r101.put("te_sensor_type_accelerometer_exist", Boolean.valueOf(r104));
        if (r117 == null) goto L43;
        r106 = r117.getName();
    L43:
        r101.put("te_sensor_type_accelerometer_name", r106);
        i.d("iesve_veeditor_sensor_report", "iesve_veeditor_sensor_report", r101);
        return;
    L36:
        r116 = null;
        goto L37
    L32:
        r115 = false;
        goto L33
    L28:
        r113 = null;
        goto L29
    L24:
        r112 = false;
        goto L25
    L20:
        r110 = null;
        goto L21
    L16:
        r109 = false;
        goto L17
    L12:
        r107 = null;
        goto L13
    L8:
        r105 = false;
        goto L9
    }
}
