package okhttp3;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: loaded from: classes42.dex */
public final class g {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f523851j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f523852k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f523853l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f523854m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f523855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f523856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f523857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f523858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f523859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f523860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f523861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f523862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f523863i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public String f523864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public String f523865b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f523866c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public String f523867d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f523868e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f523869f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f523870g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f523871h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f523872i;

        public a() {
            this.f523866c = 253402300799999L;
            this.f523868e = HTTP.URL_DEFAULT;
        }

        public final void b(long r100) {
            if (r100 > 0) goto L6;
            r100 = Long.MIN_VALUE;
        L6:
            if (r100 <= 253402300799999L) goto L8;
            r100 = 253402300799999L;
        L8:
            this.f523866c = r100;
            this.f523871h = true;
        }

        public final void c(String r100) {
            if (r100 == null) goto L10;
            if (r100.trim().equals(r100) == false) goto L8;
            this.f523864a = r100;
            return;
        L8:
            throw new IllegalArgumentException("name is not trimmed");
        L10:
            throw new NullPointerException("name == null");
        }

        public final void d(String r100) {
            if (r100.startsWith(HTTP.URL_DEFAULT) == false) goto L7;
            this.f523868e = r100;
            return;
        L7:
            throw new IllegalArgumentException("path must start with '/'");
        }

        public final void e(String r100) {
            if (r100 == null) goto L10;
            if (r100.trim().equals(r100) == false) goto L8;
            this.f523865b = r100;
            return;
        L8:
            throw new IllegalArgumentException("value is not trimmed");
        L10:
            throw new NullPointerException("value == null");
        }

        public final void a(String r100, boolean r101) {
            if (r100 == null) goto L10;
            String r102 = cvc.c.c(r100);
            if (r102 == null) goto L8;
            this.f523867d = r102;
            this.f523872i = r101;
            return;
        L8:
            throw new IllegalArgumentException("unexpected domain: ".concat(r100));
        L10:
            throw new NullPointerException("domain == null");
        }
    }

    static {
        f523851j = PatternProtector.compile("(\\d{2,4})[^\\d]*");
        f523852k = PatternProtector.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        f523853l = PatternProtector.compile("(\\d{1,2})[^\\d]*");
        f523854m = PatternProtector.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    public final int hashCode() {
        int r100 = (((((((TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER + this.f523855a.hashCode()) * 31) + this.f523856b.hashCode()) * 31) + this.f523858d.hashCode()) * 31) + this.f523859e.hashCode()) * 31;
        long r101 = this.f523857c;
        return ((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + (!this.f523860f ? 1 : 0)) * 31) + (!this.f523861g ? 1 : 0)) * 31) + (!this.f523862h ? 1 : 0)) * 31) + (!this.f523863i ? 1 : 0);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f523855a);
        r100.append(com.alipay.sdk.m.n.a.f25612h);
        r100.append(this.f523856b);
        if (this.f523862h == false) goto L9;
        if (this.f523857c != Long.MIN_VALUE) goto L7;
        r100.append("; max-age=0");
        goto L9
    L7:
        r100.append("; expires=");
        Date r101 = new Date(this.f523857c);
        r100.append(evc.d.f474506a.get().format(r101));
    L9:
        if (this.f523863i == true) goto L11;
        r100.append("; domain=");
        r100.append(this.f523858d);
    L11:
        r100.append("; path=");
        r100.append(this.f523859e);
        if (this.f523860f == false) goto L15;
        r100.append("; secure");
    L15:
        if (this.f523861g == false) goto L18;
        r100.append("; httponly");
    L18:
        return r100.toString();
    }

    public g(a r100) {
        String r101 = r100.f523864a;
        if (r101 == null) goto L15;
        String r102 = r100.f523865b;
        if (r102 == null) goto L13;
        String r103 = r100.f523867d;
        if (r103 == null) goto L11;
        this.f523855a = r101;
        this.f523856b = r102;
        this.f523857c = r100.f523866c;
        this.f523858d = r103;
        this.f523859e = r100.f523868e;
        this.f523860f = r100.f523869f;
        this.f523861g = r100.f523870g;
        this.f523862h = r100.f523871h;
        this.f523863i = r100.f523872i;
        return;
    L11:
        throw new NullPointerException("builder.domain == null");
    L13:
        throw new NullPointerException("builder.value == null");
    L15:
        throw new NullPointerException("builder.name == null");
    }

    public final boolean equals(@Nullable Object r100) {
        if ((r100 instanceof g) == true) goto L5;
        return false;
    L5:
        g r101 = (g) r100;
        if (r101.f523855a.equals(this.f523855a) == true) goto L8;
        return false;
    L8:
        if (r101.f523856b.equals(this.f523856b) == true) goto L10;
        return false;
    L10:
        if (r101.f523858d.equals(this.f523858d) == true) goto L12;
        return false;
    L12:
        if (r101.f523859e.equals(this.f523859e) == true) goto L14;
        return false;
    L14:
        if (r101.f523857c == this.f523857c) goto L16;
        return false;
    L16:
        if (r101.f523860f == this.f523860f) goto L18;
        return false;
    L18:
        if (r101.f523861g == this.f523861g) goto L20;
        return false;
    L20:
        if (r101.f523862h == this.f523862h) goto L22;
        return false;
    L22:
        if (r101.f523863i != this.f523863i) goto L33;
        return true;
    L33:
        return false;
    }

    public static boolean b(String r100, String r101) {
        if (r100.equals(r101) == false) goto L6;
        return true;
    L6:
        if (r100.endsWith(r101) == true) goto L8;
        return false;
    L8:
        if (r100.charAt((r100.length() - r101.length()) - 1) == '.') goto L10;
        return false;
    L10:
        if (cvc.c.x(r100) == true) goto L15;
        return true;
    L15:
        return false;
    }

    @Nullable
    public static g c(HttpUrl r310, String r311) {
        long r100 = System.currentTimeMillis();
        int r101 = r311.length();
        char r102 = ';';
        int r103 = cvc.c.i(r311, 0, r101, ';');
        int r104 = cvc.c.i(r311, 0, r103, com.alipay.sdk.m.n.a.f25612h);
        if (r104 == r103) goto L117;
        String r110 = cvc.c.w(r311, 0, r104);
        if (r110.isEmpty() == true) goto L117;
        int r111 = r110.length();
        int r112 = 0;
    L9:
        if (r112 >= r111) goto L15;
        char r105 = r110.charAt(r112);
        if (r105 <= 31) goto L16;
        if (r105 >= 127) goto L16;
        r112 = r112 + 1;
    L16:
        if (r112 != (-1)) goto L117;
        String r113 = cvc.c.w(r311, r104 + 1, r103);
        int r106 = r113.length();
        int r114 = 0;
    L19:
        if (r114 >= r106) goto L25;
        char r107 = r113.charAt(r114);
        if (r107 <= 31) goto L26;
        if (r107 >= 127) goto L26;
        r114 = r114 + 1;
    L26:
        if (r114 != (-1)) goto L117;
        int r108 = r103 + 1;
        long r210 = -1;
        boolean r109 = false;
        boolean r115 = false;
        String r116 = null;
        String r117 = null;
        boolean r211 = true;
        boolean r212 = false;
        long r213 = 253402300799999L;
    L29:
        long r214 = Long.MAX_VALUE;
        if (r108 >= r101) goto L79;
        int r118 = cvc.c.i(r311, r108, r101, r102);
        int r119 = cvc.c.i(r311, r108, r118, com.alipay.sdk.m.n.a.f25612h);
        String r120 = cvc.c.w(r311, r108, r119);
        if (r119 >= r118) goto L34;
        String r121 = cvc.c.w(r311, r119 + 1, r118);
    L36:
        if (r120.equalsIgnoreCase("expires") == false) goto L40;
        r213 = d(r121, r121.length());     // Catch: Throwable -> L119
    L52:
        r212 = true;
    L77:
        r108 = r118 + 1;
        r102 = ';';
        goto L29
    L40:
        if (r120.equalsIgnoreCase(HTTP.MAX_AGE) == false) goto L55;
        r210 = CastLongProtector.parseLong(r121);     // Catch: NumberFormatException -> L45
        if (r210 > 0) goto L52;
    L50:
        r210 = Long.MIN_VALUE;
    L45:
        e = move-exception;
        if (r121.matches("-?\\d+") == false) goto L53;
        if (r121.startsWith("-") == true) goto L50;
        r210 = Long.MAX_VALUE;
        goto L52
    L53:
        throw e;
    L55:
        if (r120.equalsIgnoreCase("domain") == false) goto L69;
        if (r121.endsWith(".") == true) goto L67;
        if (r121.startsWith(".") == false) goto L61;
        r121 = r121.substring(1);     // Catch: Throwable -> L119
    L61:
        String r122 = cvc.c.c(r121);     // Catch: Throwable -> L119
        if (r122 == null) goto L65;
        r116 = r122;
        r211 = false;
        goto L77
    L65:
        throw new IllegalArgumentException();     // Catch: Throwable -> L119
    L67:
        throw new IllegalArgumentException();     // Catch: Throwable -> L119
    L69:
        if (r120.equalsIgnoreCase("path") == false) goto L72;
        r117 = r121;
        goto L77
    L72:
        if (r120.equalsIgnoreCase("secure") == false) goto L75;
        r109 = true;
        goto L77
    L75:
        if (r120.equalsIgnoreCase("httponly") == false) goto L77;
        r115 = true;
        goto L77
    L34:
        r121 = "";
        goto L36
    L79:
        if (r210 != Long.MIN_VALUE) goto L82;
        long r123 = Long.MIN_VALUE;
    L94:
        String r124 = r310.host();
        if (r116 != null) goto L98;
        String r125 = r124;
    L102:
        if (r124.length() != r125.length()) goto L104;
    L106:
        String r126 = HTTP.URL_DEFAULT;
        if (r117 != null) goto L109;
    L112:
        String r127 = r310.encodedPath();
        int r128 = r127.lastIndexOf(47);
        if (r128 == 0) goto L115;
        r126 = r127.substring(0, r128);
    L115:
        String r129 = r126;
    L139:
        return new g(r110, r113, r123, r125, r129, r109, r115, r211, r212);
    L109:
        if (r117.startsWith(HTTP.URL_DEFAULT) == false) goto L112;
        r129 = r117;
        goto L139
    L104:
        if (PublicSuffixDatabase.f523914h.b(r125) != null) goto L106;
    L98:
        if (b(r124, r116) == false) goto L117;
        r125 = r116;
        goto L102
    L82:
        if (r210 != (-1)) goto L84;
        r123 = r213;
        goto L94
    L84:
        if (r210 > 9223372036854775L) goto L86;
        r214 = r210 * 1000;
    L86:
        long r215 = r100 + r214;
        if (r215 >= r100) goto L89;
    L92:
        r123 = 253402300799999L;
        goto L94
    L89:
        if (r215 > 253402300799999L) goto L92;
        r123 = r215;
        goto L94
    L25:
        r114 = -1;
        goto L26
    L15:
        r112 = -1;
    L117:
        return null;
    }

    public static long d(String r110, int r111) {
        int r100 = a(r110, 0, r111, false);
        Matcher r101 = f523854m.matcher(r110);
        int r102 = -1;
        int r103 = -1;
        int r104 = -1;
        int r105 = -1;
        int r106 = -1;
        int r107 = -1;
    L4:
        if (r100 >= r111) goto L24;
        int r112 = a(r110, r100 + 1, r111, true);
        r101.region(r100, r112);
        if (r103 == (-1)) goto L8;
    L10:
        if (r104 == (-1)) goto L12;
    L14:
        if (r105 != (-1)) goto L18;
        Pattern r108 = f523852k;
        if (r101.usePattern(r108).matches() == false) goto L18;
        String r109 = r101.group(1).toLowerCase(Locale.US);
        r105 = r108.pattern().indexOf(r109) / 4;
    L22:
        r100 = a(r110, r112 + 1, r111, false);
    L18:
        if (r102 != (-1)) goto L22;
        if (r101.usePattern(f523851j).matches() == false) goto L22;
        r102 = CastIntegerProtector.parseInt(r101.group(1));
        goto L22
    L12:
        if (r101.usePattern(f523853l).matches() == false) goto L14;
        r104 = CastIntegerProtector.parseInt(r101.group(1));
        goto L22
    L8:
        if (r101.usePattern(f523854m).matches() == false) goto L10;
        r103 = CastIntegerProtector.parseInt(r101.group(1));
        r106 = CastIntegerProtector.parseInt(r101.group(2));
        r107 = CastIntegerProtector.parseInt(r101.group(3));
        goto L22
    L24:
        if (r102 >= 70) goto L26;
    L28:
        if (r102 < 0) goto L33;
        if (r102 > 69) goto L33;
        r102 = r102 + 2000;
    L33:
        if (r102 < 1601) goto L59;
        if (r105 == (-1)) goto L57;
        if (r104 < 1) goto L55;
        if (r104 > 31) goto L55;
        if (r103 < 0) goto L53;
        if (r103 > 23) goto L53;
        if (r106 < 0) goto L51;
        if (r106 > 59) goto L51;
        if (r107 < 0) goto L49;
        if (r107 > 59) goto L49;
        GregorianCalendar r113 = new GregorianCalendar(cvc.c.f465528p);
        r113.setLenient(false);
        r113.set(1, r102);
        r113.set(2, r105 - 1);
        r113.set(5, r104);
        r113.set(11, r103);
        r113.set(12, r106);
        r113.set(13, r107);
        r113.set(14, 0);
        return r113.getTimeInMillis();
    L49:
        throw new IllegalArgumentException();
    L51:
        throw new IllegalArgumentException();
    L53:
        throw new IllegalArgumentException();
    L55:
        throw new IllegalArgumentException();
    L57:
        throw new IllegalArgumentException();
    L59:
        throw new IllegalArgumentException();
    L26:
        if (r102 > 99) goto L28;
        r102 = r102 + 1900;
        goto L28
    }

    public static int a(String r100, int r101, int r102, boolean r103) {
    L2:
        if (r101 >= r102) goto L30;
        char r104 = r100.charAt(r101);
        if (r104 >= ' ') goto L8;
        if (r104 == '\t') goto L8;
    L25:
        boolean r105 = true;
    L27:
        if (r105 == (!r103)) goto L28;
        r101 = r101 + 1;
        goto L2
    L28:
        return r101;
    L8:
        if (r104 >= 127) goto L25;
        if (r104 < '0') goto L14;
        if (r104 <= '9') goto L25;
    L14:
        if (r104 < 'a') goto L18;
        if (r104 <= 'z') goto L25;
    L18:
        if (r104 < 'A') goto L22;
        if (r104 <= 'Z') goto L25;
    L22:
        if (r104 == ':') goto L25;
        r105 = false;
        goto L27
    L30:
        return r102;
    }

    public g(String r100, String r101, long r102, String r103, String r104, boolean r105, boolean r106, boolean r107, boolean r110) {
        this.f523855a = r100;
        this.f523856b = r101;
        this.f523857c = r102;
        this.f523858d = r103;
        this.f523859e = r104;
        this.f523860f = r105;
        this.f523861g = r106;
        this.f523863i = r107;
        this.f523862h = r110;
    }
}
