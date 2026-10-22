package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes41.dex */
public abstract class fn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final String f463568a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final DateFormat f580a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f463569b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static String f581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f463570c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f582a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private fr f583a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<fk> f584a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Map<String, Object> f585a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f463571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f463572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f463573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f463574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f463575h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f463576i;

    /* JADX INFO: renamed from: a */
    public abstract String mo9099a();

    public synchronized Collection<String> b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f585a != null) goto L8;
        Set r100 = Collections.emptySet();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r100;
    L8:
        Set r101 = Collections.unmodifiableSet(new HashSet(this.f585a.keySet()));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    }

    public synchronized String o() {
        monitor-enter(this);
        StringBuilder r100 = new StringBuilder();     // Catch: Throwable -> L73
        Iterator<fk> r101 = m9102a().iterator();     // Catch: Throwable -> L73
    L5:
        if (r101.hasNext() == false) goto L7;
        r100.append(r101.next().d());     // Catch: Throwable -> L73
        goto L5
    L7:
        Map<String, Object> r102 = this.f585a;     // Catch: Throwable -> L73
        if (r102 != null) goto L10;
    L70:
        String r103 = r100.toString();     // Catch: Throwable -> L73
        monitor-exit(this);
        return r103;
    L10:
        if (r102.isEmpty() == true) goto L70;
        r100.append(ax.b("PHByb3BlcnRpZXMgeG1sbnM9Imh0dHA6Ly93d3cuaml2ZXNvZnR3YXJlLmNvbS94bWxucy94bXBwL3Byb3BlcnRpZXMiPg=="));     // Catch: Throwable -> L73
        Iterator<String> r104 = b().iterator();     // Catch: Throwable -> L73
    L13:
        if (r104.hasNext() == false) goto L69;
        String r105 = r104.next();     // Catch: Throwable -> L73
        Object r106 = m9101a(r105);     // Catch: Throwable -> L73
        r100.append("<property>");     // Catch: Throwable -> L73
        r100.append("<name>");     // Catch: Throwable -> L73
        r100.append(fw.a(r105));     // Catch: Throwable -> L73
        r100.append("</name>");     // Catch: Throwable -> L73
        r100.append("<value type=\"");     // Catch: Throwable -> L73
        if ((r106 instanceof Integer) == false) goto L18;
        r100.append("integer\">");     // Catch: Throwable -> L73
        r100.append(r106);     // Catch: Throwable -> L73
        r100.append("</value>");     // Catch: Throwable -> L73
    L58:
        r100.append("</property>");     // Catch: Throwable -> L73
        goto L13
    L18:
        if ((r106 instanceof Long) == false) goto L21;
        r100.append("long\">");     // Catch: Throwable -> L73
        r100.append(r106);     // Catch: Throwable -> L73
        r100.append("</value>");     // Catch: Throwable -> L73
        goto L58
    L21:
        if ((r106 instanceof Float) == false) goto L24;
        r100.append("float\">");     // Catch: Throwable -> L73
        r100.append(r106);     // Catch: Throwable -> L73
        r100.append("</value>");     // Catch: Throwable -> L73
        goto L58
    L24:
        if ((r106 instanceof Double) == false) goto L27;
        r100.append("double\">");     // Catch: Throwable -> L73
        r100.append(r106);     // Catch: Throwable -> L73
        r100.append("</value>");     // Catch: Throwable -> L73
        goto L58
    L27:
        if ((r106 instanceof Boolean) == false) goto L30;
        r100.append("boolean\">");     // Catch: Throwable -> L73
        r100.append(r106);     // Catch: Throwable -> L73
        r100.append("</value>");     // Catch: Throwable -> L73
        goto L58
    L30:
        if ((r106 instanceof String) == false) goto L33;
        r100.append("string\">");     // Catch: Throwable -> L73
        r100.append(fw.a((String) r106));     // Catch: Throwable -> L73
        r100.append("</value>");     // Catch: Throwable -> L73
        goto L58
    L33:
        ObjectOutputStream r107 = null;
        ByteArrayOutputStream r108 = new ByteArrayOutputStream();     // Catch: Throwable -> L46 Exception -> L48
        ObjectOutputStream r109 = new ObjectOutputStream(r108);     // Catch: Throwable -> L42 Exception -> L44
        r109.writeObject(r106);     // Catch: Exception -> L40 Throwable -> L60
        r100.append("java-object\">");     // Catch: Exception -> L40 Throwable -> L60
        r100.append(fw.a(r108.toByteArray()));     // Catch: Exception -> L40 Throwable -> L60
        r100.append("</value>");     // Catch: Exception -> L40 Throwable -> L60
    L86:
        r109.close();     // Catch: Exception -> L77 Throwable -> L73
    L88:
        r108.close();     // Catch: Exception -> L76 Throwable -> L73
    L40:
        Exception e100 = e;
    L51:
        e100.printStackTrace();     // Catch: Throwable -> L60
        if (r109 != null) goto L79;
    L56:
        if (r108 == null) goto L58;
    L79:
        r109.close();     // Catch: Exception -> L55 Throwable -> L73
    L60:
        th = th;
        r107 = r109;
    L62:
        if (r107 != null) goto L90;
    L66:
        if (r108 == null) goto L106;
        r108.close();     // Catch: Exception -> L78 Throwable -> L73
        throw th;     // Catch: Throwable -> L73
    L107:
        throw th;     // Catch: Throwable -> L73
    L106:
        throw th;     // Catch: Throwable -> L73
    L90:
        r107.close();     // Catch: Exception -> L65 Throwable -> L73
        goto L66
    L44:
        e = e;
        r109 = null;
    L50:
        e100 = e;
    L42:
        th = th;
        goto L62
    L48:
        e = e;
        r108 = null;
        r109 = null;
    L46:
        th = th;
        r108 = null;
        goto L62
    L69:
        r100.append("</properties>");     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        throw th;
    }

    public static synchronized String i() {
        monitor-enter(fn.class);
        StringBuilder r100 = new StringBuilder();     // Catch: Throwable -> L7
        r100.append(f463570c);     // Catch: Throwable -> L7
        long r101 = f463569b;     // Catch: Throwable -> L7
        f463569b = 1 + r101;     // Catch: Throwable -> L7
        r100.append(Long.toString(r101));     // Catch: Throwable -> L7
        String r102 = r100.toString();     // Catch: Throwable -> L7
        monitor-exit(fn.class);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public Bundle a() {
        Bundle r100 = new Bundle();
        if (TextUtils.isEmpty(this.f463571d) == true) goto L6;
        r100.putString("ext_ns", this.f463571d);
    L6:
        if (TextUtils.isEmpty(this.f463574g) == true) goto L9;
        r100.putString("ext_from", this.f463574g);
    L9:
        if (TextUtils.isEmpty(this.f463573f) == true) goto L12;
        r100.putString("ext_to", this.f463573f);
    L12:
        if (TextUtils.isEmpty(this.f463572e) == true) goto L15;
        r100.putString("ext_pkt_id", this.f463572e);
    L15:
        if (TextUtils.isEmpty(this.f463575h) == true) goto L17;
        r100.putString("ext_chid", this.f463575h);
    L17:
        fr r101 = this.f583a;
        if (r101 == null) goto L20;
        r100.putBundle("ext_ERROR", r101.a());
    L20:
        List<fk> r102 = this.f584a;
        if (r102 == null) goto L29;
        Bundle[] r103 = new Bundle[r102.size()];
        Iterator<fk> r104 = this.f584a.iterator();
        int r105 = 0;
    L24:
        if (r104.hasNext() == false) goto L28;
        Bundle r106 = r104.next().a();
        if (r106 == null) goto L24;
        r103[r105] = r106;
        r105 = r105 + 1;
        goto L24
    L28:
        r100.putParcelableArray("ext_exts", r103);
    L29:
        return r100;
    }

    public int hashCode() {
        String r100 = this.f463571d;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f463572e;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f463573f;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f463574g;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f463575h;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (((((r112 + r114) * 31) + this.f584a.hashCode()) * 31) + this.f585a.hashCode()) * 31;
        fr r116 = this.f583a;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.f463572e) == false) goto L7;
        return null;
    L7:
        if (this.f463572e != null) goto L10;
        this.f463572e = i();
    L10:
        return this.f463572e;
    }

    static {
        f463568a = Locale.getDefault().getLanguage().toLowerCase();
        f581b = null;
        SimpleDateFormat r100 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f580a = r100;
        r100.setTimeZone(TimeZone.getTimeZone("UTC"));
        f463570c = fw.a(5) + "-";
        f463569b = 0;
    }

    public fn() {
        this.f463571d = f581b;
        this.f463572e = null;
        this.f463573f = null;
        this.f463574g = null;
        this.f463575h = null;
        this.f463576i = null;
        this.f584a = new CopyOnWriteArrayList();
        this.f585a = new HashMap();
        this.f583a = null;
    }

    public static String q() {
        return f463568a;
    }

    public String k() {
        return this.f463575h;
    }

    public String l() {
        return this.f463573f;
    }

    public String m() {
        return this.f463574g;
    }

    public String n() {
        return this.f463576i;
    }

    public String p() {
        return this.f463571d;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized Collection<fk> m9102a() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f584a != null) goto L8;
        List r100 = Collections.emptyList();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r100;
    L8:
        List r101 = Collections.unmodifiableList(new ArrayList(this.f584a));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public fr m9100a() {
        return this.f583a;
    }

    public fn(Bundle r100) {
        this.f463571d = f581b;
        this.f463572e = null;
        this.f463573f = null;
        this.f463574g = null;
        this.f463575h = null;
        this.f463576i = null;
        this.f584a = new CopyOnWriteArrayList();
        this.f585a = new HashMap();
        this.f583a = null;
        this.f463573f = r100.getString("ext_to");
        this.f463574g = r100.getString("ext_from");
        this.f463575h = r100.getString("ext_chid");
        this.f463572e = r100.getString("ext_pkt_id");
        Parcelable[] r101 = r100.getParcelableArray("ext_exts");
        if (r101 == null) goto L10;
        this.f584a = new ArrayList(r101.length);
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        fk r104 = fk.a((Bundle) r101[r103]);
        if (r104 == null) goto L9;
        this.f584a.add(r104);
    L9:
        r103 = r103 + 1;
    L10:
        Bundle r105 = r100.getBundle("ext_ERROR");
        if (r105 == null) goto L17;
        this.f583a = new fr(r105);
        return;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized Object m9101a(String r100) {
        monitor-enter(this);
        Map<String, Object> r101 = this.f585a;     // Catch: Throwable -> L11
        if (r101 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Object r102 = r101.get(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L70:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L70;
        fn r101 = (fn) r100;
        fr r102 = this.f583a;
        if (r102 == null) goto L16;
        if (r102.equals(r101.f583a) == false) goto L17;
    L18:
        String r103 = this.f463574g;
        if (r103 == null) goto L24;
        if (r103.equals(r101.f463574g) == true) goto L27;
    L25:
        return false;
    L27:
        if (this.f584a.equals(r101.f584a) == true) goto L29;
        return false;
    L29:
        String r104 = this.f463572e;
        if (r104 == null) goto L35;
        if (r104.equals(r101.f463572e) == false) goto L36;
    L37:
        String r105 = this.f463575h;
        if (r105 == null) goto L43;
        if (r105.equals(r101.f463575h) == false) goto L44;
    L45:
        Map<String, Object> r106 = this.f585a;
        if (r106 == null) goto L51;
        if (r106.equals(r101.f585a) == false) goto L52;
    L53:
        String r107 = this.f463573f;
        if (r107 == null) goto L59;
        if (r107.equals(r101.f463573f) == false) goto L60;
    L61:
        String r108 = this.f463571d;
        String r109 = r101.f463571d;
        if (r108 != null) goto L64;
        if (r109 == null) goto L72;
    L68:
        return false;
    L72:
        return true;
    L64:
        if (r108.equals(r109) == false) goto L68;
        return true;
    L60:
        return false;
    L59:
        if (r101.f463573f == null) goto L61;
    L52:
        return false;
    L51:
        if (r101.f585a == null) goto L53;
    L44:
        return false;
    L43:
        if (r101.f463575h == null) goto L45;
    L36:
        return false;
    L35:
        if (r101.f463572e == null) goto L37;
    L24:
        if (r101.f463574g == null) goto L27;
    L17:
        return false;
    L16:
        if (r101.f583a == null) goto L18;
        goto L17
    }

    public void k(String r100) {
        this.f463572e = r100;
    }

    public void l(String r100) {
        this.f463575h = r100;
    }

    public void m(String r100) {
        this.f463573f = r100;
    }

    public void n(String r100) {
        this.f463574g = r100;
    }

    public void o(String r100) {
        this.f463576i = r100;
    }

    public fk a(String r100) {
        return a(r100, null);
    }

    public void a(fk r100) {
        this.f584a.add(r100);
    }

    public void a(fr r100) {
        this.f583a = r100;
    }

    public fk a(String r100, String r101) {
        Iterator<fk> r102 = this.f584a.iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        fk r103 = r102.next();
        if (r101 == null) goto L10;
        if (r101.equals(r103.b()) == false) goto L4;
    L10:
        if (r100.equals(r103.m9096a()) == false) goto L4;
        return r103;
    L12:
        return null;
    }
}
