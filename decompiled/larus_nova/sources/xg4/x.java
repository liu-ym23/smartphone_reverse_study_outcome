package xg4;

import android.text.TextUtils;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<c> f563740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f563741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f563742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f563743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f563744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f563745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PolarisFileWrapper f563746g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f563747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f563748b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f563749c;

        public a() {
            this.f563747a = false;
            this.f563748b = false;
            this.f563749c = null;
        }

        public final boolean a(String r100) {
            if (r100.startsWith("Dump cost time:") == false) goto L61;
            this.f563747a = true;
            int r101 = r100.indexOf(58);
            if (r101 != (-1)) goto L66;
        L59:
            return true;
        L66:
            long r102 = CastLongProtector.parseLong(r100.substring(r101 + 1).trim());     // Catch: Throwable -> L57
            if (r102 > 50) goto L11;
            String r103 = "0~50ms";
        L58:
            this.f563749c = r103;
            goto L59
        L11:
            if (r102 > 100) goto L14;
            r103 = "50~100ms";
            goto L58
        L14:
            if (r102 > 150) goto L17;
            r103 = "100~150ms";
            goto L58
        L17:
            if (r102 > 200) goto L20;
            r103 = "150~200ms";
            goto L58
        L20:
            if (r102 > 300) goto L23;
            r103 = "200~300ms";
            goto L58
        L23:
            if (r102 > 400) goto L26;
            r103 = "300~400ms";
            goto L58
        L26:
            if (r102 > 500) goto L29;
            r103 = "400~500ms";
            goto L58
        L29:
            if (r102 > 700) goto L32;
            r103 = "500~700ms";
            goto L58
        L32:
            if (r102 > 1000) goto L35;
            r103 = "700~1000ms";
            goto L58
        L35:
            if (r102 > 1500) goto L38;
            r103 = "1000~1500ms";
            goto L58
        L38:
            if (r102 > 2000) goto L41;
            r103 = "1500~2000ms";
            goto L58
        L41:
            if (r102 > 3000) goto L44;
            r103 = "2000~3000ms";
            goto L58
        L44:
            if (r102 > 4000) goto L47;
            r103 = "3000~4000ms";
            goto L58
        L47:
            if (r102 > 5000) goto L50;
            r103 = "4000~5000ms";
            goto L58
        L50:
            if (r102 > 7000) goto L53;
            r103 = "5000~7000ms";
            goto L58
        L53:
            if (r102 > 10000) goto L55;
            r103 = "7000~10000ms";
            goto L58
        L55:
            r103 = "> 10000ms";
        L57:
            r103 = "none";
            goto L58
        L61:
            if (r100.startsWith("Dump crash") == false) goto L64;
            this.f563748b = true;
            return true;
        L64:
            return false;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f563750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f563751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f563752c;

        public b() {
        }

        public static long a(int r100, String r101) {
            int r102 = 0;
        L4:
            if (r100 >= r101.length()) goto L11;
            char r103 = r101.charAt(r100);
            if (r103 < '0') goto L11;
            if (r103 > '9') goto L11;
            r102 = (r102 * 10) + (r103 - '0');
            r100 = r100 + 1;
        L11:
            return (r102 * 1024) * 1024;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f563753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f563754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f563755c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f563756d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f563757e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f563758f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f563759g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f563760h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f563761i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final ArrayList<String> f563762j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public JSONArray f563763k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final HashMap<String, JSONArray> f563764l;

        public final boolean b() {
            if (this.f563754b.equals("TimedWaiting") == false) goto L5;
        L10:
            return true;
        L5:
            if (this.f563754b.equals("Waiting") == true) goto L10;
            if (this.f563754b.equals("Blocked") == true) goto L10;
            return false;
        }

        public final boolean c() {
            if (this.f563754b.equals("Native") == false) goto L20;
            int r100 = this.f563759g;
        L6:
            if (r100 >= this.f563762j.size()) goto L29;
            String r101 = (String) ListProtector.get(this.f563762j, r100);
            if (r101.startsWith("  at") == true) goto L10;
            if (r101.startsWith("  native: #") == false) goto L19;
            if (r101.contains("__futex_wait_ex") == true) goto L28;
            if (r101.startsWith("talkWithDriver") == false) goto L19;
            return true;
        L28:
            return true;
        L19:
            r100 = r100 + 1;
            goto L6
        L10:
            return r101.contains("BinderProxy.transactNative");
        L29:
            return false;
        L20:
            return false;
        }

        public static boolean a(c r110) {
            int r100 = 0;
            if (r110.f563762j.size() <= 5) goto L88;
            String r101 = (String) ListProtector.get(r110.f563762j, 0);
            Pattern r102 = PatternProtector.compile("^\"(.*)\"(?: daemon)? prio=-?\\d+ (.*)$");
            Pattern r103 = PatternProtector.compile("tid=(\\d+) ([a-zA-Z]+)$");
            Matcher r104 = r102.matcher(r101);
            if (r104.find() == true) goto L8;
        L19:
            boolean r105 = false;
        L20:
            if (r105 == true) goto L23;
            return false;
        L23:
            if (r110.f563760h == true) goto L25;
            int r106 = 1;
        L29:
            int r107 = r106 + 1;
            Matcher r108 = PatternProtector.compile("^  \\| sysTid=(\\d+) nice=(-?)(\\d+) .*$").matcher((String) ListProtector.get(r110.f563762j, r106));
            if (r108.find() == true) goto L32;
        L41:
            boolean r109 = false;
        L42:
            if (r109 == false) goto L91;
            int r111 = r107 + 1;
            Matcher r112 = PatternProtector.compile("^  \\| state=([A-Z?]) schedstat=\\((.*)\\) utm=(\\d+) stm=(\\d+) core=(\\d+) HZ=\\d+$").matcher((String) ListProtector.get(r110.f563762j, r107));
            if (r112.find() == true) goto L47;
        L55:
            boolean r113 = false;
        L56:
            if (r113 == true) goto L59;
            return false;
        L59:
            if (r110.f563760h == false) goto L65;
            int r114 = r111 + 1;
            if (((String) ListProtector.get(r110.f563762j, r111)).startsWith("  | stack=") == false) goto L93;
            r111 = r114;
            goto L65
        L93:
            return false;
        L65:
            if (r110.f563760h == true) goto L67;
        L69:
            ArrayList<String> r115 = r110.f563762j;
            if (r111 >= r115.size()) goto L82;
            String r116 = (String) ListProtector.get(r115, r111);
            if (r110.f563763k == null) goto L82;
            if (r116.contains("Unwind failed for thread") == false) goto L82;
            r110.f563761i = true;
            ListProtector.remove(r110.f563762j, r111);     // Catch: Throwable -> L84
            int r117 = r111;
            int r118 = 0;
        L79:
            if (r118 >= r110.f563763k.length()) goto L81;
            ListProtector.add(r110.f563762j, r117, JSONArrayProtectorUtils.getString(r110.f563763k, r118));     // Catch: Throwable -> L84
            r118 = r118 + 1;     // Catch: Throwable -> L84
            r117 = r117 + 1;     // Catch: Throwable -> L84
            goto L79
        L81:
            r100 = r110.f563763k.length();     // Catch: Throwable -> L84
        L82:
            r110.f563759g = r111 + r100;
            return true;
        L67:
            if (((String) ListProtector.get(r110.f563762j, r111)).startsWith("  | held mutexes=") == false) goto L69;
            r111 = r111 + 1;
            goto L69
        L47:
            if (r112.groupCount() != 5) goto L55;
            r112.group(1);
            r110.f563755c = CastLongProtector.parseLong(r112.group(3));
            r110.f563756d = CastLongProtector.parseLong(r112.group(4));
            CastIntegerProtector.parseInt(r112.group(5));
            String r119 = r112.group(2);
            if (r119 == null) goto L54;
            String[] r120 = r119.trim().split(" ");
            if (r120.length != 3) goto L54;
            CastLongProtector.parseLong(r120[0]);
            CastLongProtector.parseLong(r120[1]);
            CastLongProtector.parseLong(r120[2]);
        L54:
            r113 = true;
            goto L56
        L91:
            return false;
        L32:
            if (r108.groupCount() != 3) goto L41;
            r110.f563757e = CastIntegerProtector.parseInt(r108.group(1));
            r110.f563758f = CastIntegerProtector.parseInt(r108.group(3));
            if ("-".equals(r108.group(2)) == false) goto L37;
            r110.f563758f *= -1;
        L37:
            HashMap<String, JSONArray> r121 = r110.f563764l;
            if (r121 == null) goto L40;
            r110.f563763k = r121.get(r108.group(1));
        L40:
            r109 = true;
            goto L42
        L25:
            if (((String) ListProtector.get(r110.f563762j, 1)).startsWith("  | group=") == false) goto L90;
            r106 = 2;
            goto L29
        L90:
            return false;
        L8:
            if (r104.groupCount() != 2) goto L19;
            r110.f563753a = r104.group(1);
            String r122 = r104.group(2);
            Matcher r123 = r103.matcher(r122);
            if (r123.find() == false) goto L16;
            if (r123.groupCount() != 2) goto L16;
            CastIntegerProtector.parseInt(r123.group(1));
            r110.f563754b = r123.group(2);
            r110.f563760h = true;
        L18:
            r105 = true;
        L16:
            if ("(not attached)".equals(r122) == false) goto L19;
            r110.f563760h = false;
            goto L18
        L88:
            return false;
        }

        public c(ArrayList<String> r100, HashMap<String, JSONArray> r101) {
            this.f563754b = "";
            this.f563763k = null;
            this.f563764l = null;
            this.f563762j = r100;
            this.f563764l = r101;
        }
    }

    public final boolean a() {
        c r100 = this.f563742c;
        if (r100 != null) goto L5;
    L7:
        Iterator<c> r101 = this.f563740a.iterator();
        int r102 = 0;
        int r103 = 0;
    L9:
        if (r101.hasNext() == false) goto L17;
        c r104 = r101.next();
        if (r104.f563760h == false) goto L9;
        if ("WaitingForGcToComplete".equals(r104.f563754b) == false) goto L15;
        r102 = r102 + 1;
    L15:
        r103 = r103 + 1;
        goto L9
    L17:
        if (r102 < 5) goto L19;
        return true;
    L19:
        if ((r102 * 4) > r103) goto L29;
        return false;
    L29:
        return true;
    L5:
        if ("WaitingForGcToComplete".equals(r100.f563754b) == false) goto L7;
        return true;
    }

    public final void b(JSONObject r100) {
        JSONArray r101 = new JSONArray();
        Iterator<c> r102 = this.f563740a.iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        c r103 = r102.next();
        JSONArray r104 = new JSONArray();
        JSONObject r105 = new JSONObject();
        int r106 = 1;
    L43:
        if (r106 >= r103.f563762j.size()) goto L9;
        r104.put(ListProtector.get(r103.f563762j, r106));     // Catch: JSONException -> L11
        r106 = r106 + 1;     // Catch: JSONException -> L11
        goto L43
    L9:
        r105.put("thread_name", ListProtector.get(r103.f563762j, 0));     // Catch: JSONException -> L11
        r105.put("thread_stack", r104);     // Catch: JSONException -> L11
        r101.put(r105);     // Catch: JSONException -> L11
        goto L4
    L12:
        JSONObject r107 = new JSONObject();
        r107.put("thread_stacks", r101);     // Catch: JSONException -> L37
        r107.put("thread_all_count", this.f563741b);     // Catch: JSONException -> L37
    L14:
        com.bytedance.crash.util.j.h(r100, "all_thread_stacks", r107);
        c r108 = this.f563742c;
        long r109 = -1;
        if (r108 == null) goto L17;
        long r110 = r108.f563756d;
    L18:
        if (r108 == null) goto L20;
        r109 = r108.f563755c;
    L20:
        com.bytedance.crash.util.j.h(r100, "main_thread_cpu_tick", Long.valueOf(r110 + r109));
        PolarisFileWrapper r111 = new PolarisFileWrapper(this.f563743d, "trace.txt");
        HashMap r112 = new HashMap();
        ArrayList r113 = new ArrayList();
        new com.bytedance.crash.dumper.b.a(r111).c(r113);
        Iterator r114 = r113.iterator();
    L22:
        if (r114.hasNext() == false) goto L30;
        String r115 = (String) r114.next();
        if (com.bytedance.crash.dumper.b.b(r115) == true) goto L22;
        if (r112.containsKey(r115) == true) goto L22;
        String r116 = NativeBridge.a(r115);
        if (r116 == null) goto L22;
        r112.put(r115, r116);
        goto L22
    L30:
        com.bytedance.crash.dumper.b.d(r100, r112);
        if (r100.optJSONObject("app_memory_info") == null) goto L34;
        return;
    L34:
        if (this.f563744e.f563750a <= 0) goto L60;
        JSONObject r117 = new JSONObject();     // Catch: Throwable -> L38
        r100.put("app_memory_info", r117);     // Catch: Throwable -> L38
        r117.put("max_memory", this.f563744e.f563750a);     // Catch: Throwable -> L38
        r117.put("free_memory", this.f563744e.f563751b);     // Catch: Throwable -> L38
        r117.put("total_memory", this.f563744e.f563752c);     // Catch: Throwable -> L38
        return;
    L60:
        return;
    L61:
        return;
    L17:
        r110 = -1;
        goto L18
    }

    public x(File r110, int r111) {
        ArrayList<c> r100 = new ArrayList();
        this.f563746g = new PolarisFileWrapper(r110, "trace_by_child.txt");
        a r101 = new a();
        b r102 = new b();
        PolarisFileWrapper r103 = new PolarisFileWrapper(r110, "trace.txt");
        int r104 = 0;
        c r112 = null;
        if (r103.exists() == true) goto L5;
    L73:
        int r105 = r100.size();
        if (r112 == null) goto L76;
        r104 = 1;
    L76:
        this.f563741b = r105 + r104;
        this.f563742c = r112;
        this.f563740a = r100;
        this.f563744e = r102;
        this.f563745f = r101;
        this.f563743d = r110;
        return;
    L5:
        if (r103.isDirectory() == true) goto L73;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r110, "trace_by_child.txt");
        if (r106.exists() == true) goto L10;
        HashMap r107 = null;
    L86:
        BufferedReader r108 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper(r103)));
    L80:
        String r109 = r108.readLine();     // Catch: Throwable -> L78
        if (r109 == null) goto L71;
        if (r109.isEmpty() == true) goto L80;
        if (r101.a(r109) == true) goto L80;
        if (r109.startsWith("Free memory ") == false) goto L44;
        long r113 = b.a(12, r109);     // Catch: Throwable -> L78
        if (r113 <= 0) goto L49;
        r102.f563751b = r113;     // Catch: Throwable -> L78
    L49:
        boolean r114 = true;
    L51:
        if (r114 == true) goto L80;
        if (r109.charAt(0) != '\"') goto L80;
        if (r109.contains(" prio=") == false) goto L80;
        ArrayList r115 = new ArrayList();     // Catch: Throwable -> L78
        r115.add(r109);     // Catch: Throwable -> L78
    L59:
        String r116 = r108.readLine();     // Catch: Throwable -> L78
        if (r116 == null) goto L64;
        if (r116.startsWith(tb2.c.DEFAULT_TEXT) == false) goto L64;
        r115.add(r116);     // Catch: Throwable -> L78
    L64:
        c r117 = new c(r115, r107);     // Catch: Throwable -> L78
        if (c.a(r117) == false) goto L80;
        if (r117.f563757e == r111) goto L68;
        r100.add(r117);     // Catch: Throwable -> L78
        goto L80
    L68:
        r112 = r117;
        goto L80
    L44:
        if (r109.startsWith("Total memory ") == false) goto L47;
        r102.f563752c = b.a(13, r109);     // Catch: Throwable -> L78
        goto L49
    L47:
        if (r109.startsWith("Max memory ") == false) goto L50;
        r102.f563750a = b.a(11, r109);     // Catch: Throwable -> L78
        goto L49
    L50:
        r114 = false;
    L71:
        com.bytedance.crash.util.g.a(r108);
        goto L73
    L10:
        r107 = new HashMap();
        BufferedReader r118 = new BufferedReader(new PolarisFileReaderWrapper(r106));     // Catch: Throwable -> L26
        JSONArray r119 = null;
    L84:
        String r120 = r118.readLine();     // Catch: Throwable -> L79
        if (r120 == null) goto L27;
        if (TextUtils.isEmpty(r120) == true) goto L84;
        if (r120.contains("sysTid") == true) goto L20;
        if (r119 == null) goto L84;
        String r121 = r120.trim();     // Catch: Throwable -> L79
        if (r121.startsWith("#") == false) goto L84;
        r119.put(r121);     // Catch: Throwable -> L79
        goto L84
    L20:
        String r122 = r120.substring(r120.indexOf(61) + 1);     // Catch: Throwable -> L79
        JSONArray r123 = new JSONArray();     // Catch: Throwable -> L79
        r123.put("backtrace: \n");     // Catch: Throwable -> L79
        r107.put(r122, r123);     // Catch: Throwable -> L79
        r119 = r123;
    L27:
        com.bytedance.crash.util.g.a(r118);
    L26:
        r118 = null;
        goto L27
    }
}
