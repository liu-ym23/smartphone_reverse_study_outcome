package mw3;

import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f515928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f515929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f515930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f515931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f515932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f515933f;

    public c() {
        this.f515932e = d.f515934a;
    }

    public static int d(String r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r102 = 0;
    L7:
        if (r101 >= r100.length()) goto L19;
        char r103 = r100.charAt(r101);
        if (r103 > 127) goto L12;
        r102 = r102 + 1;
    L18:
        r101 = r101 + 1;
        goto L7
    L12:
        if (r103 > 2047) goto L15;
        r102 = r102 + 2;
        goto L18
    L15:
        if (Character.isHighSurrogate(r103) == false) goto L17;
        r102 = r102 + 4;
        r101 = r101 + 1;
        goto L18
    L17:
        r102 = r102 + 3;
        goto L18
    L19:
        return r102;
    }

    public static int e(JSONObject r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        Iterator<String> r101 = r100.keys();
        boolean r102 = true;
        int r103 = 2;
    L7:
        if (r101.hasNext() == false) goto L11;
        if (r102 == true) goto L10;
        r103 = r103 + 1;
    L10:
        String r104 = r101.next();
        r103 = (r103 + (d(r104) + 3)) + f(r100.opt(r104));
        r102 = false;
        goto L7
    L11:
        return r103;
    }

    public static int f(Object r100) {
        if ((r100 instanceof JSONObject) == true) goto L5;
        int r101 = 2;
        int r102 = 0;
        boolean r103 = true;
        if ((r100 instanceof JSONArray) == false) goto L20;
        JSONArray r104 = (JSONArray) r100;
        if (r104 == null) goto L63;
        int r105 = 0;
    L13:
        if (r105 >= r104.length()) goto L18;
        if (r103 == true) goto L16;
        r101 = r101 + 1;
    L16:
        r101 = r101 + f(r104.opt(r105));
        r105 = r105 + 1;
        r103 = false;
        goto L13
    L18:
        return r101;
    L63:
        return 0;
    L20:
        if ((r100 instanceof String) == false) goto L54;
        String r106 = (String) r100;
        if (r106 == null) goto L52;
        int r107 = 0;
    L26:
        if (r102 >= r106.length()) goto L50;
        char r108 = r106.charAt(r102);
        if (r108 != '\f') goto L30;
    L48:
        r107 = r107 + 2;
    L49:
        r102 = r102 + 1;
        goto L26
    L30:
        if (r108 == '\r') goto L48;
        if (r108 == '\"') goto L48;
        if (r108 == '/') goto L48;
        if (r108 == '\\') goto L48;
        switch(r108) {
            case 8: goto L48;
            case 9: goto L48;
            case 10: goto L48;
            default: goto L39;
        };
    L39:
        if (r108 > 127) goto L42;
        r107 = r107 + 1;
        goto L49
    L42:
        if (r108 <= 2047) goto L48;
        if (Character.isHighSurrogate(r108) == false) goto L47;
        r107 = r107 + 4;
        r102 = r102 + 1;
        goto L49
    L47:
        r107 = r107 + 3;
        goto L49
    L50:
        r102 = r107;
    L52:
        return r102 + 2;
    L54:
        return String.valueOf(r100).length();
    L5:
        return e((JSONObject) r100);
    }

    public final boolean a(int r100) {
        long r101 = this.f515928a + r100;
        boolean r102 = d.f515934a;
        if (r101 >= 1572864) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b(JSONObject r100) {
        if (this.f515932e == true) goto L5;
        return;
    L5:
        this.f515929b = 0;
        this.f515930c = 0;
        this.f515928a = e(r100) + BmLocated.HALF_LEFT_TOP;
        this.f515933f = false;
    }

    public static String c(String r100, String r101) {
        if (r101 != null) goto L4;
    L9:
        int r102 = -1;
    L10:
        if (r102 <= 0) goto L16;
        int r103 = bx3.a.f21350a;
        com.bytedance.applog.b r104 = com.bytedance.applog.a.a(r100);
        if (r104 == null) goto L15;
        r104.W.b(StatsCountKeys.PARAMS_CLEARED_BY_EVENT_SIZE_LIMIT, 1);
    L15:
        return "{\"params_cleared_by_event_size_limit\":\"" + r102 + "\",\"max_event_size\":\"1048576\"}";
    L16:
        return r101;
    L4:
        if ((((long) r101.length()) * 4) <= 1048576) goto L9;
        r102 = d(r101);
        if (r102 <= 1048576) goto L9;
        goto L9
    }
}
