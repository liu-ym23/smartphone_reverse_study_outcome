package q1;

import com.apm.lite.k.j;
import com.apm.lite.k.n;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes39.dex */
public final class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f531255f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f531256g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f531257h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f531258i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f531259j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f531260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f531261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f531262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f531263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f531264e;

    static {
        f531255f = PatternProtector.compile("^pid:\\s(.*),\\stid:\\s(.*),\\sname:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");
        f531256g = PatternProtector.compile("^signal\\s(.*),\\scode\\s(.*),\\sfault\\saddr\\s(.*)$");
        f531257h = PatternProtector.compile("^Abort message: (.*)$");
        f531258i = PatternProtector.compile("^Crash message: (.*)$");
        f531259j = PatternProtector.compile("^    \\/(\\w*)\\/.*\\/(.*\\.so)\\s\\(BuildId: ([a-f0-9]*)\\)$");
    }

    public e(File r100) {
        this.f531264e = new HashMap();
        c(n.e(r100));
    }

    public final void a(PolarisFileWrapper r100) {
        c(n.e(r100));
    }

    public final String b() {
        StringBuilder r100 = new StringBuilder();
        String r101 = this.f531261b;
        if (r101 == null) goto L5;
        r100.append(r101);
    L5:
        String r102 = this.f531262c;
        if (r102 == null) goto L8;
        r100.append(r102);
    L8:
        String r103 = this.f531263d;
        if (r103 == null) goto L12;
        r100.append(r103);
    L12:
        return r100.toString();
    }

    public final void c(PolarisFileWrapper r110) {
        if (r110.exists() == true) goto L5;
        return;
    L5:
        if (r110.length() == 0) goto L126;
        BufferedReader r100 = new BufferedReader(new PolarisFileReaderWrapper(r110));     // Catch: Throwable -> L83
        int r101 = 0;
    L96:
        String r102 = r100.readLine();     // Catch: Throwable -> L91
        if (r102 == null) goto L85;
        if (r101 >= 64) goto L85;
        if (this.f531260a != null) goto L24;
        if (r102.startsWith("pid: ") == false) goto L24;
        Matcher r103 = f531255f.matcher(r102);     // Catch: Throwable -> L91
        if (r103.find() == false) goto L82;
        if (r103.groupCount() != 4) goto L82;
        this.f531260a = r103.group(1);     // Catch: Throwable -> L91
        r103.group(2);     // Catch: Throwable -> L91
        r103.group(3);     // Catch: Throwable -> L91
        r103.group(4);     // Catch: Throwable -> L91
    L82:
        r101 = r101 + 1;
    L24:
        if (this.f531261b != null) goto L36;
        if (r102.startsWith("signal ") == false) goto L36;
        Matcher r104 = f531256g.matcher(r102);     // Catch: Throwable -> L91
        if (r104.find() == false) goto L82;
        if (r104.groupCount() != 3) goto L82;
        String r105 = r104.group(1).replace(" ", "");     // Catch: Throwable -> L91
        String r106 = r104.group(2).replace(" ", "");     // Catch: Throwable -> L91
        int r107 = r106.indexOf("frompid");     // Catch: Throwable -> L91
        if (r107 <= 0) goto L34;
        r106 = r106.substring(0, r107) + ")";     // Catch: Throwable -> L91
    L34:
        this.f531261b = "Signal " + r105 + ", Code " + r106 + "\n";     // Catch: Throwable -> L91
    L36:
        if (this.f531262c != null) goto L46;
        if (r102.startsWith("Abort ") == false) goto L46;
        Matcher r108 = f531257h.matcher(r102);     // Catch: Throwable -> L91
        if (r108.find() == false) goto L82;
        if (r108.groupCount() != 1) goto L82;
        StringBuilder r109 = new StringBuilder();     // Catch: Throwable -> L91
        r109.append("abort message: ");     // Catch: Throwable -> L91
        r109.append(r108.group(1));     // Catch: Throwable -> L91
    L44:
        r109.append("\n");     // Catch: Throwable -> L91
        this.f531262c = r109.toString();     // Catch: Throwable -> L91
    L46:
        if (this.f531262c != null) goto L56;
        if (r102.startsWith("Crash ") == false) goto L56;
        Matcher r111 = f531258i.matcher(r102);     // Catch: Throwable -> L91
        if (r111.find() == false) goto L82;
        if (r111.groupCount() != 1) goto L82;
        r109 = new StringBuilder();     // Catch: Throwable -> L91
        r109.append("crash message: ");     // Catch: Throwable -> L91
        r109.append(r111.group(1));     // Catch: Throwable -> L91
    L56:
        if (this.f531263d != null) goto L67;
        if (r102.startsWith("backtrace:") == false) goto L67;
        StringBuilder r112 = new StringBuilder();     // Catch: Throwable -> L91
    L60:
        String r113 = r100.readLine();     // Catch: Throwable -> L91
        if (r113 == null) goto L65;
        if (r113.startsWith("    #") == false) goto L65;
        r112.append(r113.substring(4));     // Catch: Throwable -> L91
        r112.append('\n');     // Catch: Throwable -> L91
    L65:
        r101 = r101 + 1;     // Catch: Throwable -> L91
        this.f531263d = r112.toString();     // Catch: Throwable -> L91
    L67:
        if (((HashMap) this.f531264e).isEmpty() == false) goto L82;
        if (r102.startsWith("build id:") == false) goto L82;
    L70:
        String r114 = r100.readLine();     // Catch: Throwable -> L91
        if (r114 == null) goto L85;
        if (r114.contains("BuildId:") == false) goto L85;
        Matcher r115 = f531259j.matcher(r114);     // Catch: Throwable -> L91
        if (r115.find() == false) goto L70;
        String r116 = r115.group(1);     // Catch: Throwable -> L91
        String r117 = r115.group(2);     // Catch: Throwable -> L91
        String r118 = r115.group(3);     // Catch: Throwable -> L91
        if (r116.equals("data") == false) goto L70;
        ((HashMap) this.f531264e).put(r117, r118);     // Catch: Throwable -> L91
    L85:
        j.a(r100);
        return;
    L92:
        com.apm.lite.c.a();     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        j.a(r100);
        throw th;
    L83:
        r100 = null;
        goto L92
    }
}
