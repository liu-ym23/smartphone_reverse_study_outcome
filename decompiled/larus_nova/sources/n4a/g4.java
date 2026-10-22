package n4a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class g4 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static g4 f517297h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f517298i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, Long> f517299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PolarisFileWrapper f517300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f517301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f517302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f517303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f517304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f517305g;

    public static synchronized g4 a(Context r100) {
        monitor-enter(g4.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f517297h != null) goto L7;
        f517297h = new g4(r100);     // Catch: Throwable -> L10
    L7:
        g4 r101 = f517297h;     // Catch: Throwable -> L10
        monitor-exit(g4.class);
        return r101;
    }

    public final synchronized void b() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f517303e == false) goto L6;
        f();     // Catch: Throwable -> L8
        this.f517303e = false;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final synchronized void c(AMapLocation r100) {
        monitor-enter(this);
    L48:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L52
        return;
    L52:
        th = move-exception;
        throw th;
    L4:
        if (this.f517299a.containsKey(this.f517304f) == true) goto L8;
        if (this.f517299a.size() < 8) goto L8;
    L11:
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L48
        Iterator<Map.Entry<String, Long>> r102 = this.f517299a.entrySet().iterator();     // Catch: Throwable -> L48
    L13:
        if (r102.hasNext() == false) goto L21;
        r101.add(r102.next().getKey());     // Catch: Throwable -> L19
    L17:
        if (r101.size() != (this.f517299a.size() - 7)) goto L13;
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L48
    L21:
        Iterator r103 = r101.iterator();     // Catch: Throwable -> L48
    L23:
        if (r103.hasNext() == false) goto L26;
        this.f517299a.remove((String) r103.next());     // Catch: Throwable -> L48
    L26:
        if (r100.getErrorCode() == 0) goto L30;
        monitor-exit(this);
        return;
    L30:
        if (r100.getLocationType() != 6) goto L32;
    L46:
        monitor-exit(this);
        return;
    L32:
        if (r100.getLocationType() == 5) goto L46;
        if (this.f517299a.containsKey(this.f517304f) == false) goto L37;
        long r104 = this.f517299a.get(this.f517304f).longValue() + 1;     // Catch: Throwable -> L48
        f517298i = r104;     // Catch: Throwable -> L48
        this.f517299a.put(this.f517304f, Long.valueOf(r104));     // Catch: Throwable -> L48
    L38:
        long r105 = f517298i;     // Catch: Throwable -> L48
        if (r105 != 0) goto L41;
    L43:
        this.f517303e = true;     // Catch: Throwable -> L48
        monitor-exit(this);
        return;
    L41:
        if ((r105 % 100) != 0) goto L43;
        b();     // Catch: Throwable -> L48
        goto L43
    L37:
        this.f517299a.put(this.f517304f, 1L);     // Catch: Throwable -> L48
        f517298i = 1;     // Catch: Throwable -> L48
    L8:
        if (this.f517299a.containsKey(this.f517304f) == false) goto L26;
        if (this.f517299a.size() < 9) goto L26;
        goto L11
    }

    public final synchronized void d() {
        monitor-enter(this);
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    L4:
        if (e(this.f517302d) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator<Map.Entry<String, Long>> r100 = this.f517299a.entrySet().iterator();     // Catch: Throwable -> L21
    L8:
        if (r100.hasNext() == false) goto L19;
        Map.Entry<String, Long> r101 = r100.next();     // Catch: Throwable -> L21
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L8
    L12:
        if (this.f517304f.equals(r101.getKey()) == true) goto L8;
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L16
        r102.put("param_long_first", r101.getKey());     // Catch: Throwable -> L16
        r102.put("param_long_second", r101.getValue());     // Catch: Throwable -> L16
        h4.i(this.f517302d, "O023", r102);     // Catch: Throwable -> L16
    L19:
        monitor-exit(this);
    }

    public final void f() {
        StringBuilder r100 = new StringBuilder();     // Catch: Throwable -> L14
        Iterator<Map.Entry<String, Long>> r101 = this.f517299a.entrySet().iterator();     // Catch: Throwable -> L14
    L4:
        if (r101.hasNext() == false) goto L10;
        Map.Entry<String, Long> r102 = r101.next();     // Catch: Throwable -> L14
        r100.append(y4.d(t3.c((r102.getKey() + "," + r102.getValue()).getBytes("UTF-8"), this.f517301c)) + "\n");     // Catch: UnsupportedEncodingException -> L8 Throwable -> L14
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L4
    L10:
        String r103 = r100.toString();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r103) == true) goto L25;
        j4.h(this.f517300b, r103);     // Catch: Throwable -> L14
        return;
    L25:
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
    }

    public g4(Context r100) {
        this.f517299a = new LinkedHashMap();
        this.f517301c = null;
        this.f517304f = "";
        this.f517305g = null;
        Context r101 = r100.getApplicationContext();
        this.f517302d = r101;
        String r102 = r101.getFilesDir().getPath();
        this.f517301c = j4.I(r101);
        this.f517300b = new PolarisFileWrapper(r102, "reportRecorder");     // Catch: Throwable -> L32
    L4:
        monitor-enter(this);
        LinkedHashMap<String, Long> r103 = this.f517299a;     // Catch: Throwable -> L29
        if (r103 != null) goto L8;
    L35:
        this.f517304f = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));     // Catch: Throwable -> L25
        Iterator r104 = ((ArrayList) j4.g(this.f517300b)).iterator();     // Catch: Throwable -> L25
    L11:
        if (r104.hasNext() == false) goto L27;
        String[] r105 = new String(t3.e(y4.e((String) r104.next()), this.f517301c), "UTF-8").split(",");     // Catch: Throwable -> L20 UnsupportedEncodingException -> L22
        if (r105 == null) goto L11;
        if (r105.length <= 1) goto L11;
        this.f517299a.put(r105[0], Long.valueOf(CastLongProtector.parseLong(r105[1])));     // Catch: Throwable -> L20 UnsupportedEncodingException -> L22
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L25
    L27:
        monitor-exit(this);
        return;
    L25:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L29
        goto L27
    L8:
        if (r103.size() <= 0) goto L35;
    L29:
        th = move-exception;
        throw th;
    }

    public final boolean e(Context r100) {
        if (this.f517305g != null) goto L6;
        this.f517305g = i4.d(r100, "pref", "lastavedate", "0");
    L6:
        if (this.f517305g.equals(this.f517304f) == false) goto L8;
        return false;
    L8:
        SharedPreferences.Editor r101 = r100.getSharedPreferences("pref", 0).edit();
        i4.h(r101, "lastavedate", this.f517304f);
        i4.e(r101);
        this.f517305g = this.f517304f;
        return true;
    }
}
