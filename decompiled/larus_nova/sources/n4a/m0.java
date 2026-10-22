package n4a;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class m0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static m0 f517509d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, List<String>>> f517510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<String>> f517511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f517512c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f517513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f517514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f517515c;

        public a(String r100, String r101) {
            this.f517513a = null;
            this.f517514b = r100;
            this.f517515c = r101;
        }

        public a(URL r100) {
            this.f517513a = r100.getProtocol();
            this.f517514b = r100.getHost();
            this.f517515c = r100.getPath();
        }
    }

    static {
    }

    public m0() {
        this.f517510a = new HashMap();
        this.f517511b = new HashMap();
        this.f517512c = new ArrayList();
    }

    public static synchronized m0 a() {
        monitor-enter(m0.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f517509d != null) goto L7;
        f517509d = new m0();     // Catch: Throwable -> L10
    L7:
        m0 r100 = f517509d;     // Catch: Throwable -> L10
        monitor-exit(m0.class);
        return r100;
    }

    public final boolean b(String r110) {
        if (r110 != null) goto L5;
    L88:
        return false;
    L5:
        if (r110.length() == 0) goto L88;
        a r100 = null;
        a r101 = new a(new URL(r110));     // Catch: MalformedURLException -> L10
    L33:
        if (r101 == null) goto L48;
        String r111 = r101.f517515c;
        if (r111 != null) goto L39;
    L47:
        r100 = r101;
        goto L48
    L39:
        if (r111.length() == 0) goto L47;
    L41:
        String r112 = r101.f517515c;
        if (r112.charAt(r112.length() - 1) != '/') goto L45;
        String r113 = r101.f517515c;
        r101.f517515c = r113.substring(0, r113.length() - 1);
    L45:
        if (r101.f517515c.charAt(0) != '/') goto L47;
        r101.f517515c = r101.f517515c.substring(1);
    L48:
        if (r100 != null) goto L50;
        return false;
    L50:
        monitor-enter(this);
    L85:
        th = move-exception;
        throw th;
    L52:
        if (r100.f517515c.length() == 0) goto L83;
        Map<String, List<String>> r114 = this.f517511b;     // Catch: Throwable -> L85
        String r102 = r100.f517513a;     // Catch: Throwable -> L85
        if (r102 != null) goto L57;
    L59:
        List<String> r103 = this.f517512c;     // Catch: Throwable -> L85
        String r104 = r100.f517514b;     // Catch: Throwable -> L85
        if (r104 != null) goto L62;
    L64:
        Iterator<String> r115 = r103.iterator();     // Catch: Throwable -> L85
    L65:
        if (r115.hasNext() == false) goto L83;
        String r105 = r115.next();     // Catch: Throwable -> L85
        String r106 = r100.f517515c;     // Catch: Throwable -> L85
        String[] r107 = r105.split(HTTP.URL_DEFAULT);     // Catch: Throwable -> L85
        String[] r108 = r106.split(HTTP.URL_DEFAULT);     // Catch: Throwable -> L85
        if (r108.length < r107.length) goto L77;
        int r109 = 0;
    L72:
        if (r109 >= r107.length) goto L79;
        if (r107[r109].equals("*") == true) goto L78;
        if (r107[r109].equals(r108[r109]) == false) goto L77;
    L78:
        r109 = r109 + 1;
        goto L72
    L79:
        boolean r116 = true;
    L80:
        if (r116 == false) goto L65;
        monitor-exit(this);
        return true;
    L77:
        r116 = false;
        goto L80
    L62:
        if (r114.containsKey(r104) == false) goto L64;
        r103 = r114.get(r100.f517514b);     // Catch: Throwable -> L85
        goto L64
    L57:
        if (((HashMap) this.f517510a).containsKey(r102) == false) goto L59;
        r114 = (Map) ((HashMap) this.f517510a).get(r100.f517513a);     // Catch: Throwable -> L85
    L83:
        monitor-exit(this);
        return false;
    L11:
        if (r110.contains("://") == false) goto L14;
        r101 = null;
    L14:
        if (r110.startsWith(HTTP.URL_DEFAULT) == false) goto L16;
        r110 = r110.substring(1);
        goto L14
    L16:
        String[] r117 = r110.split(HTTP.URL_DEFAULT);
        if (r117[0].contains(".") == false) goto L19;
        String r118 = r117[0];
        int r119 = 1;
    L20:
        StringBuilder r120 = new StringBuilder();
    L22:
        if (r119 >= r117.length) goto L28;
        if (r120.length() <= 0) goto L26;
        r120.append(HTTP.URL_DEFAULT);
    L26:
        r120.append(r117[r119]);
        r119 = r119 + 1;
        goto L22
    L28:
        if (r120.length() > 0) goto L30;
    L32:
        r101 = new a(r118, r120.toString());
        goto L33
    L30:
        if (r120.charAt(r120.length() - 1) != '/') goto L32;
        r120.deleteCharAt(r120.length() - 1);
        goto L32
    L19:
        r118 = null;
        r119 = 0;
        goto L20
    }
}
