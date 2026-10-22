package com.larksuite.framework.utils;

import com.ss.android.download.api.constant.BaseConstants;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes24.dex */
public final class j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentMap<d, j> f286000f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConcurrentMap<C3933j, String> f286001g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f286002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeZone f286003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Locale f286004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient g[] f286005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient int f286006e;

    public static class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f286007a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return 1;
        }

        public a(char r100) {
            this.f286007a = r100;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r100, Calendar r101) throws IOException {
            StringBuilder r102 = (StringBuilder) r100;
            r102.append(this.f286007a);
        }
    }

    public static class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f286008a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return this.f286008a.estimateLength();
        }

        public b(e r100) {
            this.f286008a = r100;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r100, Calendar r101) throws IOException {
            int r102 = 7;
            int r103 = r101.get(7);
            e r104 = this.f286008a;
            if (r103 == 1) goto L6;
            r102 = r103 - 1;
        L6:
            r104.appendTo(r100, r102);
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r100, int r101) throws IOException {
            this.f286008a.appendTo(r100, r101);
        }
    }

    public static class c implements g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f286009b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f286010c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f286011d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f286012a;

        static {
            f286009b = new c(3);
            f286010c = new c(5);
            f286011d = new c(6);
        }

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return this.f286012a;
        }

        public c(int r100) {
            this.f286012a = r100;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r100, Calendar r101) throws IOException {
            int r102 = r101.get(15) + r101.get(16);
            if (r102 != 0) goto L6;
            ((StringBuilder) r100).append("Z");
            return;
        L6:
            if (r102 >= 0) goto L8;
            ((StringBuilder) r100).append('-');
            r102 = -r102;
        L9:
            int r103 = r102 / BaseConstants.Time.HOUR;
            j.a(r100, r103);
            int r104 = this.f286012a;
            if (r104 >= 5) goto L13;
            return;
        L13:
            if (r104 != 6) goto L15;
            ((StringBuilder) r100).append(':');
        L15:
            j.a(r100, (r102 / 60000) - (r103 * 60));
            return;
        L8:
            ((StringBuilder) r100).append('+');
            goto L9
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object[] f286013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f286014b;

        public final int hashCode() {
            if (this.f286014b != 0) goto L12;
            Object[] r100 = this.f286013a;
            int r101 = r100.length;
            int r102 = 0;
            int r103 = 0;
        L5:
            if (r102 >= r101) goto L10;
            Object r104 = r100[r102];
            if (r104 == null) goto L9;
            r103 = (r103 * 7) + r104.hashCode();
        L9:
            r102 = r102 + 1;
            goto L5
        L10:
            this.f286014b = r103;
        L12:
            return this.f286014b;
        }

        public d(Object... r100) {
            this.f286013a = r100;
        }

        public final boolean equals(Object r100) {
            return Arrays.equals(this.f286013a, ((d) r100).f286013a);
        }
    }

    public interface e extends g {
        void appendTo(Appendable r100, int r101) throws IOException;
    }

    public static class f implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f286015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f286016b;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return this.f286016b;
        }

        public f(int r100, int r101) {
            if (r101 < 3) goto L7;
            this.f286015a = r100;
            this.f286016b = r101;
            return;
        L7:
            throw new IllegalArgumentException();
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r100, Calendar r101) throws IOException {
            appendTo(r100, r101.get(this.f286015a));
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r100, int r101) throws IOException {
            j.b(r100, r101, this.f286016b);
        }
    }

    public interface g {
        void appendTo(Appendable r100, Calendar r101) throws IOException;

        int estimateLength();
    }

    public static class h implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f286017a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return this.f286017a.length();
        }

        public h(String r100) {
            this.f286017a = r100;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r100, Calendar r101) throws IOException {
            StringBuilder r102 = (StringBuilder) r100;
            r102.append(this.f286017a);
        }
    }

    public static class i implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f286018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f286019b;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            int r100 = this.f286019b.length;
            int r101 = 0;
        L3:
            r100 = r100 - 1;
            if (r100 < 0) goto L8;
            int r102 = this.f286019b[r100].length();
            if (r102 <= r101) goto L3;
            r101 = r102;
            goto L3
        L8:
            return r101;
        }

        public i(int r100, String[] r101) {
            this.f286018a = r100;
            this.f286019b = r101;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r100, Calendar r101) throws IOException {
            StringBuilder r102 = (StringBuilder) r100;
            r102.append(this.f286019b[r101.get(this.f286018a)]);
        }
    }

    /* JADX INFO: renamed from: com.larksuite.framework.utils.j$j, reason: collision with other inner class name */
    public static class C3933j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TimeZone f286020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f286021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Locale f286022c;

        public final int hashCode() {
            return (((this.f286021b * 31) + this.f286022c.hashCode()) * 31) + this.f286020a.hashCode();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3933j) == false) goto L16;
            C3933j r101 = (C3933j) r100;
            if (this.f286020a.equals(r101.f286020a) == true) goto L10;
        L14:
            return false;
        L10:
            if (this.f286021b != r101.f286021b) goto L14;
            if (this.f286022c.equals(r101.f286022c) == false) goto L14;
            return true;
        L16:
            return false;
        }

        public C3933j(TimeZone r100, boolean r101, int r102, Locale r103) {
            this.f286020a = r100;
            if (r101 == false) goto L5;
            this.f286021b = Integer.MIN_VALUE | r102;
        L6:
            this.f286022c = r103;
            return;
        L5:
            this.f286021b = r102;
            goto L6
        }
    }

    public static class k implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Locale f286023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f286024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f286025c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f286026d;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return Math.max(this.f286025c.length(), this.f286026d.length());
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r100, Calendar r101) throws IOException {
            TimeZone r102 = r101.getTimeZone();
            if (r101.get(16) != 0) goto L5;
            StringBuilder r103 = (StringBuilder) r100;
            r103.append(j.c(r102, false, this.f286024b, this.f286023a));
            return;
        L5:
            StringBuilder r104 = (StringBuilder) r100;
            r104.append(j.c(r102, true, this.f286024b, this.f286023a));
        }

        public k(TimeZone r100, Locale r101, int r102) {
            this.f286023a = r101;
            this.f286024b = r102;
            this.f286025c = j.c(r100, false, r102, r101);
            this.f286026d = j.c(r100, true, r102, r101);
        }
    }

    public static class l implements g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final l f286027b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final l f286028c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f286029a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return 5;
        }

        static {
            f286027b = new l(true);
            f286028c = new l(false);
        }

        public l(boolean r100) {
            this.f286029a = r100;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r100, Calendar r101) throws IOException {
            int r102 = r101.get(15) + r101.get(16);
            if (r102 >= 0) goto L5;
            ((StringBuilder) r100).append('-');
            r102 = -r102;
        L6:
            int r103 = r102 / BaseConstants.Time.HOUR;
            j.a(r100, r103);
            if (this.f286029a == false) goto L9;
            ((StringBuilder) r100).append(':');
        L9:
            j.a(r100, (r102 / 60000) - (r103 * 60));
            return;
        L5:
            ((StringBuilder) r100).append('+');
            goto L6
        }
    }

    public static class m implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f286030a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return this.f286030a.estimateLength();
        }

        public m(e r100) {
            this.f286030a = r100;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r100, Calendar r101) throws IOException {
            int r102 = r101.get(10);
            if (r102 != 0) goto L5;
            r102 = r101.getLeastMaximum(10) + 1;
        L5:
            this.f286030a.appendTo(r100, r102);
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r100, int r101) throws IOException {
            this.f286030a.appendTo(r100, r101);
        }
    }

    public static class n implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f286031a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return this.f286031a.estimateLength();
        }

        public n(e r100) {
            this.f286031a = r100;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r100, Calendar r101) throws IOException {
            int r102 = r101.get(11);
            if (r102 != 0) goto L5;
            r102 = r101.getMaximum(11) + 1;
        L5:
            this.f286031a.appendTo(r100, r102);
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r100, int r101) throws IOException {
            this.f286031a.appendTo(r100, r101);
        }
    }

    public static class o implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f286032a = null;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return 2;
        }

        static {
            f286032a = new o();
        }

        public o() {
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r100, Calendar r101) throws IOException {
            j.a(r100, r101.get(2) + 1);
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r100, int r101) throws IOException {
            j.a(r100, r101);
        }
    }

    public static class p implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f286033a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return 2;
        }

        public p(int r100) {
            this.f286033a = r100;
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r100, int r101) throws IOException {
            if (r101 >= 100) goto L5;
            j.a(r100, r101);
            return;
        L5:
            j.b(r100, r101, 2);
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r100, Calendar r101) throws IOException {
            appendTo(r100, r101.get(this.f286033a));
        }
    }

    public static class q implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f286034a = null;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return 2;
        }

        static {
            f286034a = new q();
        }

        public q() {
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r100, Calendar r101) throws IOException {
            j.a(r100, r101.get(1) % 100);
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r100, int r101) throws IOException {
            j.a(r100, r101);
        }
    }

    public static class r implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f286035a = null;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return 2;
        }

        static {
            f286035a = new r();
        }

        public r() {
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r100, int r101) throws IOException {
            if (r101 >= 10) goto L5;
            StringBuilder r102 = (StringBuilder) r100;
            r102.append((char) (r101 + 48));
            return;
        L5:
            j.a(r100, r101);
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r100, Calendar r101) throws IOException {
            appendTo(r100, r101.get(2) + 1);
        }
    }

    public static class s implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f286036a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return 4;
        }

        public s(int r100) {
            this.f286036a = r100;
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r100, int r101) throws IOException {
            if (r101 >= 10) goto L6;
            StringBuilder r102 = (StringBuilder) r100;
            r102.append((char) (r101 + 48));
            return;
        L6:
            if (r101 >= 100) goto L8;
            j.a(r100, r101);
            return;
        L8:
            j.b(r100, r101, 1);
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r100, Calendar r101) throws IOException {
            appendTo(r100, r101.get(this.f286036a));
        }
    }

    public static class t implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f286037a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return this.f286037a.estimateLength();
        }

        public t(e r100) {
            this.f286037a = r100;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r100, Calendar r101) throws IOException {
            throw new UnsupportedOperationException("getWeekYear not support");
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r100, int r101) throws IOException {
            this.f286037a.appendTo(r100, r101);
        }
    }

    static {
        f286000f = new ConcurrentHashMap(7);
        f286001g = new ConcurrentHashMap(7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v9, types: [com.larksuite.framework.utils.j$e] */
    public final void d() {
        DateFormatSymbols r100 = new DateFormatSymbols(this.f286004c);
        ArrayList r101 = new ArrayList();
        String[] r102 = r100.getEras();
        String[] r103 = r100.getMonths();
        String[] r104 = r100.getShortMonths();
        String[] r105 = r100.getWeekdays();
        String[] r106 = r100.getShortWeekdays();
        String[] r107 = r100.getAmPmStrings();
        int r108 = this.f286002a.length();
        int[] r110 = new int[1];
        char r111 = 0;
        int r112 = 0;
    L3:
        if (r112 >= r108) goto L123;
        r110[r111] = r112;
        String r113 = this.f286002a;
        StringBuilder r114 = new StringBuilder();
        int r115 = r110[r111];
        int r116 = r113.length();
        char r117 = r113.charAt(r115);
        String[] r118 = r105;
        if (r117 < 'A') goto L9;
        if (r117 > 'Z') goto L9;
    L11:
        r114.append(r117);
    L12:
        int r109 = r115 + 1;
        if (r109 >= r116) goto L41;
        if (r113.charAt(r109) != r117) goto L41;
        r114.append(r117);
        r115 = r109;
    L41:
        String[] r119 = r106;
    L42:
        r110[0] = r115;
        String r120 = r114.toString();
        int r121 = r110[0];
        int r122 = r120.length();
        if (r122 == 0) goto L123;
        char r123 = r120.charAt(0);
        if (r123 == 'y') goto L112;
        if (r123 == 'z') goto L107;
        switch(r123) {
            case 39: goto L76;
            case 75: goto L75;
            case 77: goto L67;
            case 83: goto L65;
            case 97: goto L64;
            case 100: goto L63;
            case 104: goto L61;
            case 107: goto L60;
            case 109: goto L59;
            case 115: goto L58;
            case 117: goto L57;
            case 119: goto L56;
            default: goto L52;
        };
    L56:
        g r124 = e(3, r122);
    L110:
        ?? r125 = r124;
    L122:
        r101.add(r125);
        r112 = r121 + 1;
        r105 = r118;
        r106 = r119;
        r111 = 0;
        goto L3
    L57:
        r124 = new b(e(7, r122));
        goto L110
    L58:
        r124 = e(13, r122);
        goto L110
    L59:
        r124 = e(12, r122);
        goto L110
    L60:
        r124 = new n(e(11, r122));
        goto L110
    L61:
        g r126 = new m(e(10, r122));
    L62:
        r124 = r126;
        goto L110
    L63:
        r124 = e(5, r122);
        goto L110
    L64:
        r124 = new i(9, r107);
        goto L110
    L65:
        r124 = e(14, r122);
        goto L110
    L75:
        r124 = e(10, r122);
        goto L110
    L76:
        String r127 = r120.substring(1);
        if (r127.length() != 1) goto L79;
        r124 = new a(r127.charAt(0));
        goto L110
    L79:
        r124 = new h(r127);
        goto L110
    L52:
        switch(r123) {
            case 68: goto L88;
            case 69: goto L84;
            case 70: goto L82;
            case 71: goto L81;
            case 72: goto L80;
            default: goto L53;
        };
    L53:
        switch(r123) {
            case 87: goto L105;
            case 88: goto L97;
            case 89: goto L112;
            case 90: goto L90;
            default: goto L55;
        };
    L105:
        r124 = e(4, r122);
        goto L110
    L90:
        if (r122 != 1) goto L93;
        r126 = l.f286028c;
        goto L62
    L93:
        if (r122 != 2) goto L95;
        r126 = c.f286011d;
        goto L62
    L95:
        r126 = l.f286027b;
        goto L62
    L97:
        if (r122 == 1) goto L104;
        if (r122 == 2) goto L103;
        if (r122 != 3) goto L101;
        r124 = c.f286011d;
        goto L110
    L101:
        c r128 = c.f286009b;
        throw new IllegalArgumentException("invalid number of X");
    L103:
        r124 = c.f286010c;
        goto L110
    L104:
        r124 = c.f286009b;
        goto L110
    L55:
        throw new IllegalArgumentException("Illegal pattern component: ".concat(r120));
    L80:
        r126 = e(11, r122);
        goto L62
    L81:
        r126 = new i(0, r102);
        goto L62
    L82:
        r124 = e(8, r122);
        goto L110
    L88:
        r124 = e(6, r122);
        goto L110
    L84:
        if (r122 >= 4) goto L86;
        String[] r129 = r119;
    L87:
        r124 = new i(7, r129);
        goto L110
    L86:
        r129 = r118;
        goto L87
    L67:
        if (r122 < 4) goto L70;
        r124 = new i(2, r103);
        goto L110
    L70:
        if (r122 != 3) goto L72;
        r124 = new i(2, r104);
        goto L110
    L72:
        if (r122 != 2) goto L74;
        r124 = o.f286032a;
        goto L110
    L74:
        r124 = r.f286035a;
        goto L110
    L107:
        if (r122 < 4) goto L109;
        r124 = new k(this.f286003b, this.f286004c, 1);
        goto L110
    L109:
        r124 = new k(this.f286003b, this.f286004c, 0);
    L112:
        if (r122 != 2) goto L115;
        r125 = q.f286034a;
    L120:
        if (r123 != 'Y') goto L122;
        r125 = new t(r125);
        goto L122
    L115:
        if (r122 >= 4) goto L117;
        int r130 = 1;
        r122 = 4;
    L118:
        r125 = e(r130, r122);
        goto L120
    L117:
        r130 = 1;
    L9:
        if (r117 < 'a') goto L17;
        if (r117 <= 'z') goto L11;
    L17:
        char r131 = '\'';
        r114.append('\'');
        boolean r132 = false;
    L18:
        if (r115 >= r116) goto L41;
        char r133 = r113.charAt(r115);
        if (r133 != r131) goto L29;
        int r134 = r115 + 1;
        r119 = r106;
        if (r134 >= r116) goto L27;
        if (r113.charAt(r134) != '\'') goto L27;
        r114.append(r133);
        r115 = r134;
    L28:
        int r135 = 1;
    L40:
        r115 = r115 + r135;
        r106 = r119;
        r131 = '\'';
    L27:
        r132 = !r132;
        goto L28
    L29:
        r119 = r106;
        if (r132 == true) goto L39;
        if (r133 < 'A') goto L35;
        if (r133 > 'Z') goto L35;
    L38:
        r115 = r115 - 1;
    L35:
        if (r133 < 'a') goto L39;
        if (r133 <= 'z') goto L38;
    L39:
        r114.append(r133);
        r135 = 1;
    L123:
        g[] r136 = (g[]) r101.toArray(new g[0]);
        this.f286005d = r136;
        int r137 = r136.length;
        int r138 = 0;
    L124:
        r137 = r137 - 1;
        if (r137 < 0) goto L127;
        r138 = r138 + this.f286005d[r137].estimateLength();
        goto L124
    L127:
        this.f286006e = r138;
    }

    public final int hashCode() {
        return this.f286002a.hashCode() + ((this.f286003b.hashCode() + (this.f286004c.hashCode() * 13)) * 13);
    }

    public final String toString() {
        return "FastDatePrinter[" + this.f286002a + "," + this.f286004c + "," + this.f286003b.getID() + "]";
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof j) == true) goto L5;
        return false;
    L5:
        j r101 = (j) r100;
        if (this.f286002a.equals(r101.f286002a) == true) goto L8;
        return false;
    L8:
        if (this.f286003b.equals(r101.f286003b) == true) goto L10;
        return false;
    L10:
        if (this.f286004c.equals(r101.f286004c) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static void a(Appendable r100, int r101) throws IOException {
        StringBuilder r102 = (StringBuilder) r100;
        r102.append((char) ((r101 / 10) + 48));
        r102.append((char) ((r101 % 10) + 48));
    }

    public static e e(int r100, int r101) {
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L9;
        return new f(r100, r101);
    L9:
        return new p(r100);
    L11:
        return new s(r100);
    }

    public j(String r100, TimeZone r101, Locale r102) {
        this.f286002a = r100;
        this.f286003b = r101;
        this.f286004c = r102;
    }

    public static void b(Appendable r100, int r110, int r111) throws IOException {
        if (r110 < 10000) goto L5;
        char[] r101 = new char[10];
        int r102 = 0;
    L29:
        if (r110 == 0) goto L31;
        r101[r102] = (char) ((r110 % 10) + 48);
        r110 = r110 / 10;
        r102 = r102 + 1;
    L31:
        if (r102 >= r111) goto L33;
        ((StringBuilder) r100).append('0');
        r111 = r111 - 1;
    L33:
        r102 = r102 - 1;
        if (r102 < 0) goto L42;
        ((StringBuilder) r100).append(r101[r102]);
        goto L33
    L42:
        return;
    L5:
        if (r110 >= 1000) goto L11;
        if (r110 >= 100) goto L10;
        if (r110 >= 10) goto L9;
        int r103 = 1;
    L12:
        int r112 = r111 - r103;
    L13:
        if (r112 <= 0) goto L15;
        ((StringBuilder) r100).append('0');
        r112 = r112 - 1;
        goto L13
    L15:
        if (r103 == 1) goto L27;
        if (r103 == 2) goto L24;
        if (r103 == 3) goto L21;
        if (r103 != 4) goto L41;
        ((StringBuilder) r100).append((char) ((r110 / 1000) + 48));
        r110 = r110 % 1000;
        goto L21
    L41:
        return;
    L21:
        if (r110 < 100) goto L23;
        ((StringBuilder) r100).append((char) ((r110 / 100) + 48));
        r110 = r110 % 100;
        goto L24
    L23:
        ((StringBuilder) r100).append('0');
    L24:
        if (r110 < 10) goto L26;
        ((StringBuilder) r100).append((char) ((r110 / 10) + 48));
        r110 = r110 % 10;
        goto L27
    L26:
        ((StringBuilder) r100).append('0');
    L27:
        ((StringBuilder) r100).append((char) (r110 + 48));
        return;
    L9:
        r103 = 2;
        goto L12
    L10:
        r103 = 3;
        goto L12
    L11:
        r103 = 4;
        goto L12
    }

    public static String c(TimeZone r100, boolean r101, int r102, Locale r103) {
        C3933j r104 = new C3933j(r100, r101, r102, r103);
        ConcurrentHashMap r105 = (ConcurrentHashMap) f286001g;
        String r106 = (String) r105.get(r104);
        if (r106 != null) goto L8;
        String r107 = r100.getDisplayName(r101, r102, r103);
        String r108 = (String) r105.putIfAbsent(r104, r107);
        if (r108 != null) goto L7;
        return r107;
    L7:
        return r108;
    L8:
        return r106;
    }
}
