package com.samskivert.mustache;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f405729a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f405730b = null;

    public static class a implements s {
        public a() {
        }
    }

    public static class b implements j {
        public b() {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f405731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f405732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<com.samskivert.mustache.h.d> f405733c;

        public com.samskivert.mustache.h.d[] c() {
            List<com.samskivert.mustache.h.d> r100 = this.f405733c;
            com.samskivert.mustache.h.d[] r101 = new com.samskivert.mustache.h.d[((ArrayList) r100).size()];
            return (com.samskivert.mustache.h.d[]) ((ArrayList) r100).toArray(r101);
        }

        public final void b(StringBuilder r100) {
            if (r100.length() <= 0) goto L12;
            List<com.samskivert.mustache.h.d> r101 = this.f405733c;
            String r102 = r100.toString();
            if (((ArrayList) this.f405733c).isEmpty() == true) goto L7;
        L9:
            boolean r103 = false;
        L10:
            ArrayList r104 = (ArrayList) r101;
            r104.add(new r(r102, r.b(r102, true, r103), r.b(r102, false, r103)));
            r100.setLength(0);
            return;
        L7:
            if (this.f405732b == false) goto L9;
            r103 = true;
            goto L10
        }

        public c(f r100, boolean r101) {
            this.f405733c = new ArrayList();
            this.f405731a = r100;
            this.f405732b = r101;
        }

        public static void d(String r100, int r101) {
            if (r100.indexOf(10) != (-1)) goto L8;
            if (r100.indexOf(13) != (-1)) goto L8;
            return;
        L8:
            throw new MustacheParseException("Invalid tag name: contains newline '" + r100 + "'", r101);
        }

        public c a(String r100, int r101) {
            throw new MustacheParseException("Section close tag with no open tag '" + r100 + "'", r101);
        }

        public static void e(String r100, String r101, int r102) {
            if (r100.equals(r101) == false) goto L6;
            return;
        L6:
            throw new MustacheParseException("Section close tag with mismatched open tag '" + r101 + "' != '" + r100 + "'", r102);
        }
    }

    public static abstract class d extends o {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.samskivert.mustache.h.d[] f405734c;

        public d(String r100, com.samskivert.mustache.h.d[] r101, int r102) {
            super(r100, r102);
            e.b(r101, false);
            this.f405734c = r101;
        }

        public final void b(com.samskivert.mustache.h r100, com.samskivert.mustache.h.b r101, Writer r102) {
            com.samskivert.mustache.h.d[] r103 = this.f405734c;
            int r104 = r103.length;
            int r105 = 0;
        L3:
            if (r105 >= r104) goto L5;
            r103[r105].a(r100, r101, r102);
            r105 = r105 + 1;
            goto L3
        }
    }

    /* JADX INFO: renamed from: com.samskivert.mustache.e$e, reason: collision with other inner class name */
    public interface InterfaceC4697e {
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f405735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f405736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f405737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f405738d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f405739e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f405740f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final j f405741g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final h f405742h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final s f405743i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final InterfaceC4697e f405744j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final g f405745k;

        public final f b() {
            com.samskivert.mustache.c.a r100 = com.samskivert.mustache.c.f405727b;
            return new f(this.f405735a, this.f405736b, this.f405737c, this.f405738d, this.f405739e, this.f405740f, this.f405741g, r100, this.f405743i, this.f405744j, this.f405745k);
        }

        public final com.samskivert.mustache.h a(String r100) {
            StringReader r101 = new StringReader(r100);
            a r102 = e.f405729a;
            p r103 = new p(this);
            r103.f405757c = r101;
        L29:
            int r104 = r103.f405757c.read();     // Catch: IOException -> L26
            if (r104 == (-1)) goto L9;
            char r105 = (char) r104;
            r103.a(r105);
            if (r105 != '\n') goto L29;
            r103.f405760f++;
            goto L29
        L9:
            int r106 = r103.f405759e;
            if (r106 != 1) goto L12;
            r103.f405756b.append(r103.f405755a.f405746a);
        L24:
            r103.f405758d.b(r103.f405756b);
            com.samskivert.mustache.h.d[] r107 = r103.f405758d.c();
            e.b(r107, true);
            return new com.samskivert.mustache.h(r107, this);
        L12:
            if (r106 != 2) goto L14;
            StringBuilder r108 = r103.f405756b;
            g r109 = r103.f405755a;
            r108.insert(0, r109.f405746a);
            char r110 = r109.f405748c;
            if (r110 == 0) goto L22;
            r108.insert(1, r110);
        L22:
            r103.f405756b.append(r103.f405755a.f405747b);
            goto L24
        L14:
            if (r106 != 3) goto L24;
            StringBuilder r111 = r103.f405756b;
            g r112 = r103.f405755a;
            r111.insert(0, r112.f405746a);
            char r113 = r112.f405748c;
            if (r113 == 0) goto L24;
            r111.insert(1, r113);
        L26:
            e = move-exception;
            throw new MustacheException(e);
        }

        public final boolean c(Object r100) {
            if (this.f405739e == false) goto L7;
            if ("".equals(r100) == false) goto L7;
        L12:
            return true;
        L7:
            if (this.f405740f == true) goto L9;
        L13:
            return false;
        L9:
            if ((r100 instanceof Number) == false) goto L13;
            if (((Number) r100).longValue() != 0) goto L13;
            goto L12
        }

        public f(boolean r100, boolean r101, String r102, boolean r103, boolean r104, boolean r105, j r106, h r107, s r108, InterfaceC4697e r110, g r111) {
            this.f405735a = r100;
            this.f405736b = r101;
            this.f405737c = r102;
            this.f405738d = r103;
            this.f405739e = r104;
            this.f405740f = r105;
            this.f405741g = r106;
            this.f405742h = r107;
            this.f405743i = r108;
            this.f405744j = r110;
            this.f405745k = r111;
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public char f405746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public char f405747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public char f405748c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public char f405749d;

        public g() {
            this.f405746a = '{';
            this.f405747b = '}';
            this.f405748c = '{';
            this.f405749d = '}';
        }

        public static String a(String r100) {
            return "Invalid delimiter configuration '" + r100 + "'. Must be of the form {{=1 2=}} or {{=12 34=}} where 1, 2, 3 and 4 are delimiter chars.";
        }
    }

    public interface h {
        String a(String r100);
    }

    public static class i extends com.samskivert.mustache.h.d {
        @Override // com.samskivert.mustache.h.d
        public final void a(com.samskivert.mustache.h r100, com.samskivert.mustache.h.b r101, Writer r102) {
        }

        public final String toString() {
            return "Faux";
        }

        public i() {
        }
    }

    public interface j {
    }

    public static class k extends com.samskivert.mustache.h.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f405750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f405751b;

        public k(f r100, String r101) {
            this.f405750a = r100;
            this.f405751b = r101;
        }

        @Override // com.samskivert.mustache.h.d
        public final void a(com.samskivert.mustache.h r100, com.samskivert.mustache.h.b r101, Writer r102) {
            ((a) this.f405750a.f405743i).getClass();     // Catch: Throwable -> L5 Exception -> L7
            throw new UnsupportedOperationException("Template loading not configured");     // Catch: Throwable -> L5 Exception -> L7
        L5:
            th = move-exception;
            throw th;
        L7:
            e = move-exception;
            if ((e instanceof RuntimeException) == false) goto L13;
            throw ((RuntimeException) e);     // Catch: Throwable -> L5
        L13:
            throw new MustacheException("Unable to load template: " + this.f405751b, e);     // Catch: Throwable -> L5
        }
    }

    public static class l extends d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f f405752d;

        public final String toString() {
            return "Inverted(" + this.f405753a + ":" + this.f405754b + "): " + Arrays.toString(this.f405734c);
        }

        @Override // com.samskivert.mustache.h.d
        public final void a(com.samskivert.mustache.h r100, com.samskivert.mustache.h.b r101, Writer r102) {
            Object r103 = r100.d(r101, this.f405753a, this.f405754b, !r100.f405781b.f405736b);
            if (r103 != null) goto L5;
            r103 = Collections.emptyList();
        L5:
            Iterator<?> r104 = ((com.samskivert.mustache.a) this.f405752d.f405744j).b(r103);
            if (r104 == null) goto L11;
            if (r104.hasNext() == true) goto L28;
            b(r100, r101, r102);
            return;
        L28:
            return;
        L11:
            if ((r103 instanceof Boolean) == false) goto L16;
            if (((Boolean) r103).booleanValue() == true) goto L30;
            b(r100, r101, r102);
            return;
        L30:
            return;
        L16:
            if ((r103 instanceof m) == false) goto L23;
            ((m) r103).a();     // Catch: IOException -> L19
            return;
        L19:
            e = move-exception;
            throw new MustacheException(e);
        L23:
            if (this.f405752d.c(r103) == false) goto L32;
            b(r100, r101, r102);
            return;
        }

        public l(f r100, String r101, com.samskivert.mustache.h.d[] r102, int r103) {
            super(r101, r102, r103);
            this.f405752d = r100;
        }
    }

    public interface m extends n {
        void a() throws IOException;
    }

    public interface n {
        void execute() throws IOException;
    }

    public static abstract class o extends com.samskivert.mustache.h.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f405753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f405754b;

        public o(String r100, int r101) {
            this.f405753a = r100.intern();
            this.f405754b = r101;
        }
    }

    public static class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f405755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StringBuilder f405756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Reader f405757c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f405758d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f405759e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f405760f;

        public p(f r100) {
            this.f405756b = new StringBuilder();
            this.f405759e = 0;
            this.f405760f = 1;
            this.f405758d = new c(r100, true);
            g r101 = r100.f405745k;
            r101.getClass();
            g r102 = new g();
            r102.f405746a = r101.f405746a;
            r102.f405748c = r101.f405748c;
            r102.f405747b = r101.f405747b;
            r102.f405749d = r101.f405749d;
            this.f405755a = r102;
        }

        public final void a(char r100) {
            int r101 = this.f405759e;
            if (r101 != 0) goto L5;
            g r102 = this.f405755a;
            if (r100 != r102.f405746a) goto L109;
            this.f405759e = 1;
            if (r102.f405748c != 0) goto L122;
            a(0);
            return;
        L122:
            return;
        L109:
            this.f405756b.append(r100);
            return;
        L5:
            if (r101 != 1) goto L7;
            g r103 = this.f405755a;
            if (r100 != r103.f405748c) goto L103;
            this.f405758d.b(this.f405756b);
            this.f405759e = 3;
            return;
        L103:
            this.f405756b.append(r103.f405746a);
            this.f405759e = 0;
            a(r100);
            return;
        L7:
            if (r101 == 2) goto L29;
            if (r101 != 3) goto L124;
            g r104 = this.f405755a;
            if (r100 != r104.f405747b) goto L16;
            this.f405759e = 2;
            if (r104.f405749d != 0) goto L113;
            a(0);
            return;
        L113:
            return;
        L16:
            if (r100 == r104.f405746a) goto L18;
        L28:
            this.f405756b.append(r100);
            return;
        L18:
            if (this.f405756b.length() <= 0) goto L28;
            if (this.f405756b.charAt(0) == '!') goto L28;
            StringBuilder r105 = this.f405756b;
            g r106 = this.f405755a;
            r105.insert(0, r106.f405746a);
            char r107 = r106.f405748c;
            if (r107 == 0) goto L24;
            r105.insert(1, r107);
        L24:
            this.f405758d.b(this.f405756b);
            if (this.f405755a.f405748c != 0) goto L27;
            this.f405758d.b(this.f405756b);
            this.f405759e = 3;
            return;
        L27:
            this.f405759e = 1;
            return;
        L124:
            return;
        L29:
            g r108 = this.f405755a;
            if (r100 == r108.f405749d) goto L32;
            this.f405756b.append(r108.f405747b);
            this.f405759e = 3;
            a(r100);
            return;
        L32:
            if (this.f405756b.charAt(0) != '=') goto L52;
            g r109 = this.f405755a;
            StringBuilder r110 = this.f405756b;
            String r111 = r110.substring(1, r110.length() - 1);
            r109.getClass();
            String[] r112 = r111.split(" ");
            if (r112.length != 2) goto L51;
            int r113 = r112[0].length();
            if (r113 == 1) goto L41;
            if (r113 != 2) goto L40;
            r109.f405746a = r112[0].charAt(0);
            r109.f405748c = r112[0].charAt(1);
        L42:
            int r114 = r112[1].length();
            if (r114 == 1) goto L48;
            if (r114 != 2) goto L47;
            r109.f405747b = r112[1].charAt(0);
            r109.f405749d = r112[1].charAt(1);
        L49:
            this.f405756b.setLength(0);
            ((ArrayList) this.f405758d.f405733c).add(new i());
        L98:
            this.f405759e = 0;
            return;
        L47:
            throw new MustacheException(g.a(r111));
        L48:
            r109.f405747b = r112[1].charAt(0);
            r109.f405749d = 0;
            goto L49
        L40:
            throw new MustacheException(g.a(r111));
        L41:
            r109.f405746a = r112[0].charAt(0);
            r109.f405748c = 0;
            goto L42
        L51:
            throw new MustacheException(g.a(r111));
        L52:
            g r115 = this.f405755a;
            if (r115.f405746a == '{') goto L55;
        L61:
            boolean r116 = false;
        L62:
            if (r116 == true) goto L64;
        L77:
            c r117 = this.f405758d;
            StringBuilder r118 = this.f405756b;
            int r119 = this.f405760f;
            r117.getClass();
            String r120 = r118.toString().trim();
            String r121 = r120.substring(1).trim();
            r118.setLength(0);
            char r122 = r120.charAt(0);
            if (r122 != '!') goto L80;
            ((ArrayList) r117.f405733c).add(new i());
        L97:
            this.f405758d = r117;
            goto L98
        L80:
            if (r122 != '#') goto L82;
            c.d(r120, r119);
            c r123 = new com.samskivert.mustache.f(r117.f405731a, r121, r119, r117);
        L95:
            r117 = r123;
            goto L97
        L82:
            if (r122 != '&') goto L84;
            c.d(r120, r119);
            ((ArrayList) r117.f405733c).add(new u(r121, r119, r117.f405731a.f405741g, com.samskivert.mustache.c.f405727b));
            goto L97
        L84:
            if (r122 != '/') goto L86;
            c.d(r120, r119);
            r117 = r117.a(r121, r119);
            goto L97
        L86:
            if (r122 != '>') goto L88;
            ((ArrayList) r117.f405733c).add(new k(r117.f405731a, r121));
            goto L97
        L88:
            if (r122 == '^') goto L90;
            c.d(r120, r119);
            List<com.samskivert.mustache.h.d> r124 = r117.f405733c;
            f r125 = r117.f405731a;
            ((ArrayList) r124).add(new u(r120, r119, r125.f405741g, r125.f405742h));
            goto L97
        L90:
            c.d(r120, r119);
            r123 = new com.samskivert.mustache.g(r117.f405731a, r121, r119, r117);
            goto L95
        L64:
            if (this.f405756b.charAt(0) != this.f405755a.f405746a) goto L77;
            int r126 = this.f405757c.read();     // Catch: IOException -> L74
            if (r126 != 125) goto L68;
            this.f405756b.replace(0, 1, "&");
            goto L77
        L68:
            if (r126 != (-1)) goto L70;
            String r127 = "";
        L72:
            throw new MustacheParseException("Invalid triple-mustache tag: {{" + this.f405756b + "}}" + r127, this.f405760f);
        L70:
            r127 = String.valueOf((char) r126);
        L74:
            e = move-exception;
            throw new MustacheException(e);
        L55:
            if (r115.f405748c != '{') goto L61;
            if (r115.f405747b != '}') goto L61;
            if (r115.f405749d != '}') goto L61;
            r116 = true;
            goto L62
        }
    }

    public static class q extends d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f f405761d;

        public final String toString() {
            return "Section(" + this.f405753a + ":" + this.f405754b + "): " + Arrays.toString(this.f405734c);
        }

        @Override // com.samskivert.mustache.h.d
        public final void a(com.samskivert.mustache.h r110, com.samskivert.mustache.h.b r111, Writer r112) {
            Object r100 = r110.d(r111, this.f405753a, this.f405754b, !r110.f405781b.f405736b);
            if (r100 != null) goto L5;
            r100 = Collections.emptyList();
        L5:
            Object r101 = r100;
            Iterator<?> r102 = ((com.samskivert.mustache.a) this.f405761d.f405744j).b(r101);
            if (r102 == null) goto L16;
            int r103 = 0;
        L9:
            if (r102.hasNext() == false) goto L41;
            Object r104 = r102.next();
            if (r103 != 0) goto L13;
            boolean r105 = true;
        L14:
            r103 = r103 + 1;
            b(r110, new com.samskivert.mustache.h.b(r104, r111, r103, r105, !r102.hasNext()), r112);
            goto L9
        L13:
            r105 = false;
            goto L14
        L41:
            return;
        L16:
            if ((r101 instanceof Boolean) == false) goto L21;
            if (((Boolean) r101).booleanValue() == false) goto L37;
            b(r110, r111, r112);
            return;
        L37:
            return;
        L21:
            if ((r101 instanceof n) == false) goto L28;
            ((n) r101).execute();     // Catch: IOException -> L24
            return;
        L24:
            e = move-exception;
            throw new MustacheException(e);
        L28:
            if (this.f405761d.c(r101) == true) goto L40;
            b(r110, new com.samskivert.mustache.h.b(r101, r111, r111.f405785c, r111.f405786d, r111.f405787e), r112);
            return;
        }

        public q(f r100, String r101, com.samskivert.mustache.h.d[] r102, int r103) {
            super(r101, r102, r103);
            this.f405761d = r100;
        }
    }

    public static class r extends com.samskivert.mustache.h.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f405762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f405763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f405764c;

        public final r c() {
            int r100 = this.f405763b;
            if (r100 != (-1)) goto L5;
            return this;
        L5:
            int r101 = r100 + 1;
            int r102 = this.f405764c;
            if (r102 != (-1)) goto L8;
            int r103 = -1;
        L10:
            return new r(this.f405762a.substring(r101), -1, r103);
        L8:
            r103 = r102 - r101;
            goto L10
        }

        public final r d() {
            int r100 = this.f405764c;
            if (r100 != (-1)) goto L6;
            return this;
        L6:
            return new r(this.f405762a.substring(0, r100), this.f405763b, -1);
        }

        public final String toString() {
            return "Text(" + this.f405762a.replace("\r", "\\r").replace("\n", "\\n") + ")" + this.f405763b + HTTP.URL_DEFAULT + this.f405764c;
        }

        static {
        }

        public r(String r100, int r101, int r102) {
            this.f405762a = r100;
            this.f405763b = r101;
            this.f405764c = r102;
        }

        public static int b(String r100, boolean r101, boolean r102) {
            int r103 = r100.length();
            if (r101 == false) goto L5;
            int r104 = 0;
        L7:
            if (r101 == true) goto L10;
            r103 = -1;
        L10:
            if (r101 == false) goto L12;
            int r105 = 1;
        L13:
            if (r104 == r103) goto L24;
            char r106 = r100.charAt(r104);
            if (r106 == '\n') goto L16;
            if (Character.isWhitespace(r106) == false) goto L22;
            r104 = r104 + r105;
            goto L13
        L22:
            return -1;
        L16:
            if (r101 == false) goto L19;
            return r104;
        L19:
            return r104 + 1;
        L24:
            if (r101 == true) goto L26;
            if (r102 == false) goto L26;
            return 0;
        L26:
            return -1;
        L12:
            r105 = -1;
            goto L13
        L5:
            r104 = r103 - 1;
            goto L7
        }

        @Override // com.samskivert.mustache.h.d
        public final void a(com.samskivert.mustache.h r100, com.samskivert.mustache.h.b r101, Writer r102) {
            r102.write(this.f405762a);     // Catch: IOException -> L5
            return;
        L5:
            e = move-exception;
            throw new MustacheException(e);
        }
    }

    public interface s {
    }

    public interface t {
        Object a(Object r100, String r101) throws Exception;
    }

    public static class u extends o {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final j f405765c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h f405766d;

        public final String toString() {
            return "Var(" + this.f405753a + ":" + this.f405754b + ")";
        }

        @Override // com.samskivert.mustache.h.d
        public final void a(com.samskivert.mustache.h r100, com.samskivert.mustache.h.b r101, Writer r102) {
            String r103 = this.f405753a;
            Object r104 = r100.d(r101, r103, this.f405754b, r100.f405781b.f405738d);
            if (r104 != null) goto L8;
            String r105 = r100.f405781b.f405737c;
            if (r105 != null) goto L7;
            r104 = null;
            goto L8
        L7:
            r104 = r105.replace("{{name}}", r103);
        L8:
            if (r104 == null) goto L16;
            h r106 = this.f405766d;
            ((b) this.f405765c).getClass();
            r102.write(r106.a(String.valueOf(r104)));     // Catch: IOException -> L12
            return;
        L12:
            e = move-exception;
            throw new MustacheException(e);
        L16:
            throw new MustacheException.Context("No key, method or field with name '" + this.f405753a + "' on line " + this.f405754b, this.f405753a, this.f405754b);
        }

        public u(String r100, int r101, j r102, h r103) {
            super(r100, r101);
            this.f405765c = r102;
            this.f405766d = r103;
        }
    }

    public e() {
    }

    static {
        f405729a = new a();
        f405730b = new b();
    }

    public static f a() {
        return new f(false, false, null, false, false, false, f405730b, com.samskivert.mustache.c.f405726a, f405729a, new com.samskivert.mustache.b(), new g());
    }

    public static void b(com.samskivert.mustache.h.d[] r110, boolean r111) {
        int r100 = r110.length;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L80;
        com.samskivert.mustache.h.d r102 = r110[r101];
        r r103 = null;
        if (r101 <= 0) goto L7;
        com.samskivert.mustache.h.d r104 = r110[r101 - 1];
    L9:
        if (r101 >= (r100 - 1)) goto L11;
        com.samskivert.mustache.h.d r105 = r110[r101 + 1];
    L13:
        if ((r104 instanceof r) == false) goto L15;
        r r106 = (r) r104;
    L17:
        if ((r105 instanceof r) == false) goto L19;
        r103 = (r) r105;
    L19:
        boolean r107 = true;
        if (r104 != null) goto L22;
        if (r111 == false) goto L22;
    L28:
        boolean r112 = true;
    L30:
        if (r105 != null) goto L32;
        if (r111 == false) goto L32;
    L38:
        boolean r113 = true;
    L41:
        if ((r102 instanceof d) == false) goto L72;
        d r108 = (d) r102;
        if (r112 == false) goto L57;
        com.samskivert.mustache.h.d[] r114 = r108.f405734c;
        if (r114.length == 0) goto L52;
        com.samskivert.mustache.h.d r115 = r114[0];
        if ((r115 instanceof r) == false) goto L52;
        if (((r) r115).f405763b == (-1)) goto L52;
        boolean r116 = true;
    L53:
        if (r116 == false) goto L57;
        if (r104 == null) goto L56;
        r110[r101 - 1] = r106.d();
    L56:
        com.samskivert.mustache.h.d[] r109 = r108.f405734c;
        r109[0] = ((r) r109[0]).c();
    L52:
        r116 = false;
    L57:
        if (r113 == false) goto L79;
        com.samskivert.mustache.h.d[] r117 = r108.f405734c;
        int r118 = r117.length - 1;
        if (r117.length == 0) goto L66;
        com.samskivert.mustache.h.d r119 = r117[r118];
        if ((r119 instanceof r) == false) goto L66;
        if (((r) r119).f405764c == (-1)) goto L66;
    L67:
        if (r107 == false) goto L79;
        int r120 = r117.length - 1;
        r117[r120] = ((r) r117[r120]).d();
        if (r105 == null) goto L79;
        r110[r101 + 1] = r103.c();
    L66:
        r107 = false;
    L79:
        r101 = r101 + 1;
        goto L3
    L72:
        if ((r102 instanceof i) == false) goto L79;
        if (r112 == false) goto L79;
        if (r113 == false) goto L79;
        if (r104 == null) goto L77;
        r110[r101 - 1] = r106.d();
    L77:
        if (r105 == null) goto L79;
        r110[r101 + 1] = r103.c();
    L32:
        if (r103 != null) goto L34;
    L39:
        r113 = false;
        goto L41
    L34:
        if (r103.f405763b == (-1)) goto L36;
        boolean r121 = true;
    L37:
        if (r121 == false) goto L39;
    L36:
        r121 = false;
    L22:
        if (r106 != null) goto L24;
    L29:
        r112 = false;
        goto L30
    L24:
        if (r106.f405764c == (-1)) goto L26;
        boolean r122 = true;
    L27:
        if (r122 == false) goto L29;
    L26:
        r122 = false;
        goto L27
    L15:
        r106 = null;
        goto L17
    L11:
        r105 = null;
        goto L13
    L7:
        r104 = null;
        goto L9
    }
}
