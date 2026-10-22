package com.bytedance.crash.upload;

import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.general.RomInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static String c(String r100, Map r101) {
        if (TextUtils.isDigitsOnly(r100) == true) goto L30;
        HashMap r102 = (HashMap) r101;
        if (r102.isEmpty() == true) goto L31;
        StringBuilder r103 = new StringBuilder(r100);
        if (r100.contains("?") == true) goto L23;
        r103.append("?");
    L23:
        Iterator r104 = r102.entrySet().iterator();     // Catch: Exception -> L22
    L11:
        if (r104.hasNext() == false) goto L21;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Exception -> L22
        if (r105.getValue() == null) goto L11;
        if (r103.toString().endsWith("?") == true) goto L18;
        r103.append("&");     // Catch: Exception -> L22
    L18:
        r103.append(URLEncoder.encode(r105.getKey().toString(), "UTF-8"));     // Catch: Exception -> L22
        r103.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L22
        r103.append(URLEncoder.encode(r105.getValue().toString(), "UTF-8"));     // Catch: Exception -> L22
        goto L11
    L21:
        return r103.toString();
    L32:
        return r100;
    L31:
        return r100;
    L30:
        return r100;
    }

    public static String d(String r100, JSONObject r101) {
        HashMap r102 = new HashMap();
        if (r101 == null) goto L9;
        Iterator<String> r103 = r101.keys();
    L7:
        if (r103.hasNext() == false) goto L9;
        String r104 = r103.next();
        r102.put(r104, r101.opt(r104));
    L9:
        String[] r105 = new String[14];
        int r106 = 0;
        r105[0] = "aid";
        r105[1] = "4444";
        r105[2] = "os";
        r105[3] = "Android";
        r105[4] = "update_version_code";
        r105[5] = "000000";
        r105[6] = "channel";
        r105[7] = "unknown";
        r105[8] = "app_version";
        r105[9] = "0.0.0";
        r105[10] = "sdk_version";
        r105[11] = zg4.h.f572084a;
        r105[12] = "device_id";
        com.bytedance.crash.general.a r107 = com.bytedance.crash.general.a.a();
        if (r107 != null) goto L12;
        String r108 = UUID.randomUUID().toString();     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r108) == true) goto L26;
    L27:
        r105[13] = r108;
        HashMap r109 = new HashMap();
    L28:
        if (r106 >= 14) goto L35;
        String r110 = r105[r106];
        Object r111 = r102.get(r110);
        if (r111 == null) goto L32;
        String r112 = String.valueOf(r111);
    L33:
        r109.put(r110, r112);
        r106 = r106 + 2;
        goto L28
    L32:
        r112 = r105[r106 + 1];
        goto L33
    L35:
        return c(r100, r109);
    L26:
        r108 = "0000-1111-2222-3333-4444";
        goto L27
    L12:
        if (r107.f203204d != null) goto L22;
        monitor-enter(r107);
    L19:
        th = move-exception;
        throw th;
    L15:
        if (r107.f203204d != null) goto L17;
        r107.f203204d = RomInfo.get(r107.f203201a);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r107);     // Catch: Throwable -> L19
    L22:
        r108 = r107.f203204d.getRandomDeviceId();
        goto L27
    }

    public static String e(String r100, com.bytedance.crash.monitor.f r101) {
        HashMap r102 = new HashMap();
        r102.put("aid", r101.a());
        r102.put("version_code", String.valueOf(r101.i()));
        r102.put("update_version_code", String.valueOf(r101.f()));
        r102.put("app_version", String.valueOf(r101.j()));
        if (TextUtils.isEmpty(r101.b()) == true) goto L5;
        r102.put("channel", r101.b());
    L5:
        r102.put("device_id", r101.d("0"));
        return d(r100, new JSONObject(r102));
    }

    public static String f(CrashType r100, JSONObject r101) {
        if (r100 != CrashType.NATIVE) goto L6;
        String r102 = zg4.g.f572072l.f572080h;
    L27:
        if (com.bytedance.crash.util.j.g(r101) == false) goto L29;
        return r102;
    L29:
        return d(r102, r101);
    L6:
        if (r100 != CrashType.ANR) goto L8;
    L25:
        r102 = zg4.g.f572072l.f572074b;
        goto L27
    L8:
        if (r100 == CrashType.JAVA) goto L25;
        if (r100 == CrashType.DART) goto L25;
        if (r100 != CrashType.LAUNCH) goto L16;
        r102 = zg4.g.f572072l.f572075c;
        goto L27
    L16:
        if (r100 != CrashType.ASAN) goto L19;
        r102 = zg4.g.f572072l.f572080h;
        goto L27
    L19:
        if (r100 != CrashType.COREDUMP) goto L22;
        r102 = zg4.g.f572072l.f572073a;
        goto L27
    L22:
        if (r100 != CrashType.NATIVE_CUSTOMIZE) goto L24;
        r102 = zg4.g.f572072l.f572078f;
        goto L27
    L24:
        r102 = zg4.g.f572072l.f572074b;
        goto L27
    }

    public static String b(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L21;
        if (r102 == null) goto L22;
        StringBuilder r103 = new StringBuilder(r100);
        if (r100.contains("?") == true) goto L18;
        r103.append("?");
    L18:
        if (r103.toString().endsWith("?") == true) goto L14;
        r103.append("&");     // Catch: Exception -> L17
    L14:
        r103.append(URLEncoder.encode(r101, "UTF-8"));     // Catch: Exception -> L17
        r103.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L17
        r103.append(URLEncoder.encode(r102, "UTF-8"));     // Catch: Exception -> L17
        return r103.toString();
    L23:
        return r100;
    L22:
        return r100;
    L21:
        return r100;
    }

    public static String a(String r100, int r101, String r102, String r103, long r104) {
        return b(b(b(b(b(b(b(r100, "aid", String.valueOf(r101)), "device_id", r102), "os", "Android"), "update_version_code", String.valueOf(r104)), "channel", "unknown"), "app_version", r103), "sdk_version", zg4.h.f572084a);
    }
}
