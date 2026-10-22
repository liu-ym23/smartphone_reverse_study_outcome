package q1;

import android.text.TextUtils;
import com.apm.lite.k.h;
import com.apm.lite.k.j;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes39.dex */
public final class d {

    public static class a extends c {
        public a(PolarisFileWrapper r100) {
            super(r100);
            this.f531252b = "Total FD Count:";
            this.f531253c = ":";
            this.f531254d = -2;
        }
    }

    public static class b extends c {
        public b(PolarisFileWrapper r100) {
            super(r100);
            this.f531252b = "VmSize:";
            this.f531253c = "\\s+";
            this.f531254d = -1;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f531251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f531252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f531253c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f531254d;

        public c(PolarisFileWrapper r100) {
            this.f531251a = r100;
        }

        public final int a() {
            int r100 = -1;
            if (this.f531251a.exists() == true) goto L5;
        L35:
            return -1;
        L5:
            if (this.f531251a.isFile() == false) goto L35;
            BufferedReader r101 = new BufferedReader(new PolarisFileReaderWrapper(this.f531251a));     // Catch: Throwable -> L25
            int r102 = -1;
        L36:
            String r103 = r101.readLine();     // Catch: Throwable -> L24
            if (r103 == null) goto L23;
            int r104 = this.f531254d;     // Catch: Throwable -> L24
            if (r103.startsWith(this.f531252b) == true) goto L40;
        L20:
            r102 = r104;
        L21:
            if (r102 != (-1)) goto L23;
        L40:
            r104 = CastIntegerProtector.parseInt(r103.split(this.f531253c)[1].trim());     // Catch: NumberFormatException -> L17 Throwable -> L24
        L18:
            if (r104 >= 0) goto L20;
            r102 = -2;
            goto L21
        L17:
            com.apm.lite.c.a();     // Catch: Throwable -> L24
        L23:
            j.a(r101);
            return r102;
        L24:
            r100 = r102;
        L42:
            com.apm.lite.c.a();     // Catch: Throwable -> L31
            if (r101 == null) goto L30;
            j.a(r101);
        L30:
            return r100;
        L31:
            th = move-exception;
            if (r101 == null) goto L34;
            j.a(r101);
        L34:
            throw th;
        L25:
            r101 = null;
            goto L42
        }
    }

    /* JADX INFO: renamed from: q1.d$d, reason: collision with other inner class name */
    public static class C7263d extends c {
        public C7263d(PolarisFileWrapper r100) {
            super(r100);
            this.f531252b = "Total Threads Count:";
            this.f531253c = ":";
            this.f531254d = -2;
        }
    }

    public static JSONArray a(PolarisFileWrapper r100, PolarisFileWrapper r101) {
        HashMap r102 = new HashMap();
        int r103 = 0;
        JSONArray r104 = h.l(r100.getAbsolutePath());     // Catch: Throwable -> L25 IOException -> L26
        if (r104 == null) goto L27;
        int r105 = 0;
    L7:
        if (r105 >= r104.length()) goto L27;
        String r106 = r104.optString(r105);     // Catch: Throwable -> L25 IOException -> L26
        if (TextUtils.isEmpty(r106) == false) goto L13;
    L24:
        r105 = r105 + 1;
        goto L7
    L13:
        if (r106.startsWith("[tid:0") == false) goto L24;
        if (r106.endsWith("sigstack:0x0]") == false) goto L24;
        int r107 = r106.indexOf("[routine:0x");     // Catch: Throwable -> L25 IOException -> L26
        int r108 = r107 + 11;     // Catch: Throwable -> L25 IOException -> L26
        int r109 = r106.indexOf(93, r108);     // Catch: Throwable -> L25 IOException -> L26
        if (r107 <= 0) goto L19;
        String r110 = r106.substring(r108, r109);     // Catch: Throwable -> L25 IOException -> L26
    L20:
        List r111 = (List) r102.get(r110);     // Catch: Throwable -> L25 IOException -> L26
        if (r111 != null) goto L23;
        r111 = new ArrayList();     // Catch: Throwable -> L25 IOException -> L26
        r102.put(r110, r111);     // Catch: Throwable -> L25 IOException -> L26
    L23:
        r111.add(r106);     // Catch: Throwable -> L25 IOException -> L26
        goto L24
    L19:
        r110 = "unknown addr";
        goto L20
    L25:
        com.apm.lite.c.a();
    L27:
        JSONArray r112 = new JSONArray();
        if (r102.isEmpty() == false) goto L62;
    L60:
        return r112;
    L62:
        JSONArray r113 = h.l(r101.getAbsolutePath());     // Catch: Throwable -> L59 IOException -> L61
        if (r113 == null) goto L60;
    L34:
        if (r103 >= r113.length()) goto L51;
        String r114 = r113.optString(r103);     // Catch: Throwable -> L59 IOException -> L61
        if (TextUtils.isEmpty(r114) == true) goto L50;
        int r115 = r114.indexOf(":");     // Catch: Throwable -> L59 IOException -> L61
        if (r115 <= 2) goto L50;
        String r116 = r114.substring(2, r115);     // Catch: Throwable -> L59 IOException -> L61
        if (r102.containsKey(r116) == false) goto L50;
        List r117 = (List) r102.get(r116);     // Catch: Throwable -> L59 IOException -> L61
        if (r117 == null) goto L50;
        Iterator r118 = r117.iterator();     // Catch: Throwable -> L59 IOException -> L61
    L47:
        if (r118.hasNext() == false) goto L49;
        r112.put(((String) r118.next()) + " " + r114);     // Catch: Throwable -> L59 IOException -> L61
        goto L47
    L49:
        r102.remove(r116);     // Catch: Throwable -> L59 IOException -> L61
    L50:
        r103 = r103 + 1;     // Catch: Throwable -> L59 IOException -> L61
        goto L34
    L51:
        Iterator r119 = r102.values().iterator();     // Catch: Throwable -> L59 IOException -> L61
    L52:
        if (r119.hasNext() == false) goto L60;
        Iterator r120 = ((List) r119.next()).iterator();     // Catch: Throwable -> L59 IOException -> L61
    L56:
        if (r120.hasNext() == false) goto L52;
        r112.put(((String) r120.next()) + "  0x000000:unknown");     // Catch: Throwable -> L59 IOException -> L61
        goto L56
    L59:
        com.apm.lite.c.a();
        goto L60
    }
}
