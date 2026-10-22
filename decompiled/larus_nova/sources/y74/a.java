package y74;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.c0;
import com.bytedance.bdinstall.dtrait.model.DTraitLogLevel;
import com.bytedance.bdinstall.p0;
import com.bytedance.common.utility.Logger;
import com.ss.bytertc.engine.utils.LogUtil;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Long> f566586a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Long> f566587b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, List<w74.c>> f566588c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SimpleDateFormat f566589d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Random f566590e = null;

    static {
        f566586a = new ConcurrentHashMap();
        f566587b = new ConcurrentHashMap();
        f566588c = new ConcurrentHashMap();
        f566589d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        f566590e = new SecureRandom();
    }

    public static void a() {
        ((ConcurrentHashMap) f566586a).clear();
        ((ConcurrentHashMap) f566587b).clear();
        ((ConcurrentHashMap) f566588c).clear();
    }

    public static long b(String r100) {
        Map<String, Long> r101 = f566586a;
        if (((ConcurrentHashMap) r101).containsKey(r100) == false) goto L8;
        Map<String, Long> r102 = f566587b;
        if (((ConcurrentHashMap) r102).containsKey(r100) == true) goto L7;
        return 0;
    L7:
        return ((Long) ((ConcurrentHashMap) r102).get(r100)).longValue() - ((Long) ((ConcurrentHashMap) r101).get(r100)).longValue();
    L8:
        return 0;
    }

    public static void d(Context r110) {
        boolean r100 = true;
        SharedPreferences r111 = d.f566592a.b(new Object[]{r110});
        long r101 = r111.getLong("dtrait_report_time", 0);
        long r102 = System.currentTimeMillis();
        if ((r102 - r101) >= 600000) goto L5;
        Logger.d("[dt] dtrait_report_time# it's time not yet, next time: " + f566589d.format(new Date(r101 + 600000)));
        r100 = false;
    L6:
        if (r100 == true) goto L34;
        return;
    L34:
        u74.a r112 = n74.a.f518202d;     // Catch: Throwable -> L28 Exception -> L33
        if (r112 != null) goto L12;
        a();
        return;
    L12:
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L28 Exception -> L33
        Iterator r104 = ((ConcurrentHashMap) f566588c).entrySet().iterator();     // Catch: Throwable -> L28 Exception -> L33
    L14:
        if (r104.hasNext() == false) goto L24;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L28 Exception -> L33
        String r106 = (String) r105.getKey();     // Catch: Throwable -> L28 Exception -> L33
        List r107 = (List) r105.getValue();     // Catch: Throwable -> L28 Exception -> L33
        long r108 = b(r106);     // Catch: Throwable -> L28 Exception -> L33
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L28 Exception -> L33
        JSONArray r113 = new JSONArray();     // Catch: Throwable -> L28 Exception -> L33
        Iterator r114 = r107.iterator();     // Catch: Throwable -> L28 Exception -> L33
    L17:
        if (r114.hasNext() == false) goto L20;
        w74.c r115 = (w74.c) r114.next();     // Catch: Throwable -> L28 Exception -> L33
        JSONObject r116 = new JSONObject();     // Catch: Throwable -> L28 Exception -> L33
        r116.put("businessTag", r115.f558518d);     // Catch: Throwable -> L28 Exception -> L33
        r116.put("level", r115.f558515a.toString());     // Catch: Throwable -> L28 Exception -> L33
        r116.put("msg", r115.f558516b);     // Catch: Throwable -> L28 Exception -> L33
        r116.put("error", r115.f558517c);     // Catch: Throwable -> L28 Exception -> L33
        r113.put(r116);     // Catch: Throwable -> L28 Exception -> L33
        goto L17
    L20:
        if (r108 >= 0) goto L23;
        r108 = -1;
    L23:
        r109.put("duration", r108);     // Catch: Throwable -> L28 Exception -> L33
        r109.put(LogUtil.DIR_TAIL, r113);     // Catch: Throwable -> L28 Exception -> L33
        r109.put("params_for_special", "uc_login");     // Catch: Throwable -> L28 Exception -> L33
        r103.put(r106, r109);     // Catch: Throwable -> L28 Exception -> L33
        goto L14
    L24:
        int r117 = r103.toString().getBytes("UTF-8").length;     // Catch: Throwable -> L28 Exception -> L33
        c0 r118 = ((p0.c) r112).f199764a.E;     // Catch: Throwable -> L28 Exception -> L33
        if (r118 == null) goto L31;
        ((nw3.c) r118).a("dtrait_logs", r103);     // Catch: Throwable -> L28 Exception -> L33
    L28:
        th = move-exception;
        a();
        throw th;
    L31:
        a();
        return;
    L5:
        r111.edit().putLong("dtrait_report_time", r102).apply();
        goto L6
    }

    public static void e(String r100) {
        Map<String, Long> r101 = f566586a;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.put(r100, Long.valueOf(System.currentTimeMillis()));
    }

    public static void f(String r100) {
        Map<String, Long> r101 = f566587b;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.put(r100, Long.valueOf(System.currentTimeMillis()));
    }

    public static void c(DTraitLogLevel r100, String r101, String r102, String r103, Throwable r104) {
        if (r104 == null) goto L4;
        StringWriter r105 = new StringWriter();
        r104.printStackTrace(new PrintWriter(r105));
        String r106 = r105.toString();
    L5:
        w74.c r107 = new w74.c(r100, r101, r103, r106);
        ConcurrentHashMap r108 = (ConcurrentHashMap) f566588c;
        List r109 = (List) r108.get(r102);
        if (r109 != null) goto L8;
        r109 = new ArrayList();
        r108.put(r102, r109);
    L8:
        r109.add(r107);
        return;
    L4:
        r106 = "";
        goto L5
    }
}
