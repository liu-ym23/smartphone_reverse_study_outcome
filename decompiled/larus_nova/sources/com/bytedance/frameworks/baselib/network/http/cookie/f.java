package com.bytedance.frameworks.baselib.network.http.cookie;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Cloneable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Set<String> f244699i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f244700j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f244701k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f244702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f244703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f244704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f244705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f244706e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f244707f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f244708g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f244709h;

    public class a extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        public final DateFormat initialValue() {
            SimpleDateFormat r100 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            r100.setTimeZone(TimeZone.getTimeZone("UTC"));
            return r100;
        }

        public a() {
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f244710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f244711b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f244712c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f244713d;

        public final void d() {
        L3:
            if (this.f244712c >= this.f244710a.length()) goto L8;
            if (" \t".indexOf(this.f244710a.charAt(this.f244712c)) == (-1)) goto L11;
            this.f244712c++;
            goto L3
        L11:
            return;
        }

        public final boolean c() {
            d();
            if (this.f244712c < this.f244710a.length()) goto L5;
            return false;
        L5:
            if (this.f244710a.charAt(this.f244712c) != '=') goto L10;
            this.f244712c++;
            return true;
        L10:
            return false;
        }

        public b(String r100) {
            this.f244712c = 0;
            this.f244713d = false;
            this.f244710a = r100;
            this.f244711b = r100.toLowerCase(Locale.US);
        }

        public final int a(String r100) {
            int r101 = this.f244712c;
        L4:
            if (r101 >= this.f244710a.length()) goto L10;
            if (r100.indexOf(this.f244710a.charAt(r101)) != (-1)) goto L7;
            r101 = r101 + 1;
            goto L4
        L7:
            return r101;
        L10:
            return this.f244710a.length();
        }

        public final String b(boolean r100) {
            d();
            int r101 = a(";= \t");
            if (r100 == false) goto L5;
            String r102 = this.f244711b;
        L6:
            int r103 = this.f244712c;
            if (r103 >= r101) goto L9;
            String r104 = r102.substring(r103, r101);
        L10:
            this.f244712c = r101;
            return r104;
        L9:
            r104 = null;
            goto L10
        L5:
            r102 = this.f244710a;
            goto L6
        }
    }

    static {
        HashSet r100 = new HashSet();
        f244699i = r100;
        r100.add("comment");
        r100.add("commenturl");
        r100.add("discard");
        r100.add("domain");
        r100.add("expires");
        r100.add("httponly");
        r100.add(HTTP.MAX_AGE);
        r100.add("path");
        r100.add("port");
        r100.add("secure");
        r100.add("version");
        f244700j = new a();
        f244701k = new String[]{"EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    }

    public final String a() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f244706e);
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(this.f244709h);
        r100.append("|dom=");
        r100.append(this.f244702a);
        r100.append("|path=");
        r100.append(this.f244707f);
        r100.append("|sec=");
        r100.append(this.f244708g);
        r100.append("|ho=");
        r100.append(this.f244703b);
        r100.append("|exp_t=");
        r100.append(this.f244704c);
        r100.append("|age=");
        long r101 = this.f244704c;
        if (r101 <= 0) goto L6;
        r101 = r101 - System.currentTimeMillis();
    L6:
        r100.append(r101);
        r100.append("|ct=");
        r100.append(this.f244705d);
        return r100.toString();
    }

    public final long b() {
        if (TextUtils.isEmpty(this.f244705d) == false) goto L7;
        return -1;
    L7:
        if (this.f244705d.startsWith("s_") == false) goto L11;
        return CastLongProtector.parseLong(this.f244705d.substring(2));
    L11:
        return CastLongProtector.parseLong(this.f244705d);
    }

    public final boolean c() {
        long r100 = this.f244704c;
        if (r100 != (-1)) goto L6;
        return false;
    L6:
        if (r100 != 0) goto L9;
        return true;
    L9:
        if (System.currentTimeMillis() <= this.f244704c) goto L12;
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = (this.f244706e.hashCode() * 31) + 17;
        String r101 = this.f244702a;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = r100 + (r103 * 31);
        String r105 = this.f244707f;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return (r104 + (r102 * 31)) + ((!this.f244703b ? 1 : 0) * 31);
    L5:
        r103 = r101.toLowerCase(Locale.US).hashCode();
        goto L6
    }

    public final String toString() {
        return this.f244706e + ContainerUtils.KEY_VALUE_DELIMITER + this.f244709h;
    }

    public f() {
        this.f244703b = true;
        this.f244704c = -1;
    }

    public final Object clone() {
        return super.clone();
    L5:
        throw new AssertionError();
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == false) goto L23;
        f r101 = (f) r100;
        if (this.f244706e.equals(r101.f244706e) == false) goto L21;
        String r102 = this.f244702a;
        if (r102 == null) goto L15;
        if (r102.equalsIgnoreCase(r101.f244702a) == false) goto L21;
    L17:
        if (Objects.equals(this.f244707f, r101.f244707f) == false) goto L21;
        if (this.f244703b != r101.f244703b) goto L21;
        return true;
    L15:
        if (r101.f244702a == null) goto L17;
    L21:
        return false;
    L23:
        return false;
    }

    public f(String r100, String r101) {
        boolean r102 = true;
        this.f244703b = true;
        this.f244704c = -1;
        String r103 = r100.trim();
        boolean r104 = false;
        if (r103.isEmpty() == false) goto L5;
    L9:
        r102 = false;
    L10:
        if (r102 == false) goto L24;
        int r105 = 0;
    L13:
        if (r105 >= r103.length()) goto L24;
        char r106 = r103.charAt(r105);
        if (r106 >= 127) goto L25;
        if (r106 == ';') goto L25;
        if (r106 == ',') goto L25;
        if (Character.isWhitespace(r106) == true) goto L25;
        r105 = r105 + 1;
    L25:
        if (r104 == false) goto L29;
        this.f244706e = r103;
        this.f244709h = r101;
        return;
    L29:
        throw new IllegalArgumentException("Invalid name: ".concat(r100));
    L24:
        r104 = r102;
        goto L25
    L5:
        if (r103.startsWith("$") == true) goto L9;
        Set<String> r107 = f244699i;
        HashSet r108 = (HashSet) r107;
        if (r108.contains(r103.toLowerCase(Locale.US)) == true) goto L9;
        goto L9
    }

    public static f d(URI r110, String r111) {
        b r100 = new b(r111);
        if (r100.f244711b.startsWith("set-cookie:") == false) goto L5;
        r100.f244712c += 11;
    L5:
        String r101 = r100.b(false);
        if (TextUtils.isEmpty(r101) == true) goto L89;
        if (r100.c() == false) goto L87;
        r100.d();
        int r102 = r100.a(com.alipay.sdk.m.u.i.f25853b);
        String r103 = r111.substring(r100.f244712c, r102);
        r100.f244712c = r102;
        f r104 = new f(r101, r103);
        r104.e(String.valueOf(System.currentTimeMillis()), false);
        int r105 = 0;
    L10:
        r100.d();
        if (r100.f244712c >= r100.f244710a.length()) goto L67;
        r105 = r105 + 1;
        if (r100.f244710a.charAt(r100.f244712c) != ';') goto L16;
        r100.f244712c++;
    L16:
        String r106 = r100.b(true);
        if (TextUtils.isEmpty(r106) == true) goto L65;
        if (r100.c() == false) goto L22;
        r100.d();
        int r107 = r100.a(com.alipay.sdk.m.u.i.f25853b);
        String r112 = r100.f244710a.substring(r100.f244712c, r107);
        r100.f244712c = r107;
    L24:
        if (TextUtils.isEmpty(r112) == true) goto L62;
        if (r106.equals("domain") == false) goto L32;
        if (r112.charAt(0) == '.') goto L30;
        r112 = ".".concat(r112);
    L30:
        r104.f(r112.toLowerCase(Locale.US), false);
        goto L65
    L32:
        if (r106.equals(HTTP.MAX_AGE) == false) goto L41;
        long r113 = CastLongProtector.parseLong(r112);     // Catch: NumberFormatException -> L38
        r100.f244713d = true;     // Catch: NumberFormatException -> L38
        if (r113 <= 0) goto L36;
        r104.f244704c = System.currentTimeMillis() + (r113 * 1000);     // Catch: NumberFormatException -> L38
        goto L65
    L36:
        r104.f244704c = 0;     // Catch: NumberFormatException -> L38
    L39:
        throw new IllegalArgumentException("Invalid max-age: " + r112);
    L41:
        if (r106.equals("expires") == false) goto L59;
        if (r100.f244713d == true) goto L59;
        Date r108 = f244700j.get().parse(r112);     // Catch: ParseException -> L46
    L53:
        if (r108 == null) goto L65;
        long r109 = r108.getTime();
        if ((r109 - System.currentTimeMillis()) <= 0) goto L57;
        r104.f244704c = r109;
        goto L65
    L57:
        r104.f244704c = 0;
    L46:
        String[] r114 = f244701k;
        int r115 = r114.length;
        int r116 = 0;
    L47:
        if (r116 >= r115) goto L52;
        r108 = new SimpleDateFormat(r114[r116], Locale.US).parse(r112);     // Catch: ParseException -> L51
    L51:
        r116 = r116 + 1;
        goto L47
    L52:
        r108 = null;
    L59:
        if (r106.equals("path") == false) goto L65;
        r104.f244707f = r112;
        goto L65
    L62:
        if (r106.equals("secure") == false) goto L65;
        r104.f244708g = true;
        goto L65
    L22:
        r112 = null;
    L65:
        if (r105 < 100) goto L10;
    L67:
        if (TextUtils.isEmpty(r104.f244702a) == false) goto L74;
        String r117 = e.c(r110);
        if (TextUtils.isEmpty(r117) == true) goto L72;
        r104.f(r117, !r117.startsWith("."));
        goto L74
    L72:
        throw new IllegalArgumentException("No domain in " + r100.f244710a);
    L74:
        if (TextUtils.isEmpty(r104.f244707f) == false) goto L85;
        String r118 = r110.getPath();
        boolean r119 = TextUtils.isEmpty(r118);
        String r120 = HTTP.URL_DEFAULT;
        if (r119 == false) goto L78;
    L84:
        r104.f244707f = r120;
        goto L85
    L78:
        if (r118.startsWith(HTTP.URL_DEFAULT) == false) goto L84;
        int r121 = r118.lastIndexOf(47);
        if (r121 <= 0) goto L84;
        r120 = r118.substring(0, r121);
    L85:
        return r104;
    L87:
        throw new IllegalArgumentException("Expected '=' after " + r101 + " in " + r111);
    L89:
        throw new IllegalArgumentException("No cookies in ".concat(r111));
    }

    public final void e(String r100, boolean r101) {
        if (r101 == false) goto L4;
        String r102 = "s_";
    L5:
        this.f244705d = r102 + r100;
        return;
    L4:
        r102 = "";
        goto L5
    }

    public final void f(String r100, boolean r101) {
        if (TextUtils.isEmpty(this.f244702a) == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        String r102 = null;
    L8:
        this.f244702a = r102;
        this.f244703b = r101;
        return;
    L7:
        r102 = r100.toLowerCase(Locale.US);
        goto L8
    }
}
