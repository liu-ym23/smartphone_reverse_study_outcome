package com.google.zxing.qrcode.encoder;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class MinimalEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f275973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f275974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nv7.c f275975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ErrorCorrectionLevel f275976d;

    public static final enum VersionSize extends Enum<VersionSize> {
        public static final VersionSize LARGE = null;
        public static final VersionSize MEDIUM = null;
        public static final VersionSize SMALL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VersionSize[] f275977a = null;
        private final String description;

        static {
            VersionSize r100 = new VersionSize("SMALL", 0, "version 1-9");
            SMALL = r100;
            VersionSize r101 = new VersionSize("MEDIUM", 1, "version 10-26");
            MEDIUM = r101;
            VersionSize r102 = new VersionSize("LARGE", 2, "version 27-40");
            LARGE = r102;
            f275977a = new VersionSize[]{r100, r101, r102};
        }

        public static VersionSize[] values() {
            return (VersionSize[]) f275977a.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }

        public static VersionSize valueOf(String r100) {
            return (VersionSize) r27.a.a(VersionSize.class, r100);
        }

        public VersionSize(String r100, int r101, String r102) {
            super(r100, r101);
            this.description = r102;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f275978a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f275979b = null;

        static {
            int[] r100 = new int[Mode.values().length];
            f275979b = r100;
            r100[Mode.KANJI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L23:
            f275979b[Mode.ALPHANUMERIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L29:
            f275979b[Mode.NUMERIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L37:
            f275979b[Mode.BYTE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L25:
            f275979b[Mode.ECI.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L10:
            int[] r101 = new int[VersionSize.values().length];
            f275978a = r101;
            r101[VersionSize.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L31:
            f275978a[VersionSize.MEDIUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L35:
            f275978a[VersionSize.LARGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
            return;
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Mode f275980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f275981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f275982c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f275983d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f275984e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f275985f;

        public b(MinimalEncoder r100, Mode r101, int r102, int r103, int r110, b r111, com.google.zxing.qrcode.decoder.b r112) {
            this.f275980a = r101;
            this.f275981b = r102;
            Mode r104 = Mode.BYTE;
            if (r101 == r104) goto L7;
            if (r111 == null) goto L7;
            int r105 = r111.f275982c;
        L8:
            this.f275982c = r105;
            this.f275983d = r110;
            this.f275984e = r111;
            boolean r106 = false;
            if (r111 == null) goto L11;
            int r107 = r111.f275985f;
        L13:
            if (r101 != r104) goto L16;
            if (r111 != null) goto L16;
            if (r105 == 0) goto L16;
        L19:
            r106 = true;
        L20:
            int r108 = 4;
            if (r111 != null) goto L23;
        L25:
            r107 = r107 + (r101.getCharacterCountBits(r112) + 4);
        L26:
            int r109 = a.f275979b[r101.ordinal()];
            if (r109 != 1) goto L29;
            r107 = r107 + 13;
        L48:
            this.f275985f = r107;
            return;
        L29:
            if (r109 != 2) goto L31;
            if (r110 != 1) goto L45;
            int r113 = 6;
        L46:
            r107 = r107 + r113;
            goto L48
        L45:
            r113 = 11;
            goto L46
        L31:
            if (r109 == 3) goto L37;
            if (r109 != 4) goto L48;
            nv7.c r114 = r100.f275975c;
            r107 = r107 + (r100.f275973a.substring(r102, r110 + r102).getBytes(r114.f520917a[r103].charset()).length * 8);
            if (r106 == false) goto L48;
            r107 = r107 + 12;
            goto L48
        L37:
            if (r110 == 1) goto L42;
            if (r110 != 2) goto L41;
            r108 = 7;
            goto L42
        L41:
            r108 = 10;
        L42:
            r107 = r107 + r108;
            goto L48
        L23:
            if (r101 != r111.f275980a) goto L25;
            if (r106 == false) goto L26;
        L16:
            if (r111 == null) goto L20;
            if (r105 == r111.f275982c) goto L20;
        L11:
            r107 = 0;
        L7:
            r105 = r103;
            goto L8
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<a> f275986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.zxing.qrcode.decoder.b f275987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MinimalEncoder f275988c;

        public final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Mode f275989a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f275990b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f275991c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final int f275992d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ c f275993e;

            public final int a() {
                if (this.f275989a != Mode.BYTE) goto L6;
                MinimalEncoder r100 = this.f275993e.f275988c;
                nv7.c r101 = r100.f275975c;
                String r102 = r100.f275973a;
                int r103 = this.f275990b;
                String r104 = r102.substring(r103, this.f275992d + r103);
                int r105 = this.f275991c;
                return r104.getBytes(r101.f520917a[r105].charset()).length;
            L6:
                return this.f275992d;
            }

            public final String toString() {
                StringBuilder r100 = new StringBuilder();
                r100.append(this.f275989a);
                r100.append('(');
                if (this.f275989a != Mode.ECI) goto L5;
                nv7.c r101 = this.f275993e.f275988c.f275975c;
                int r102 = this.f275991c;
                r100.append(r101.f520917a[r102].charset().displayName());
            L17:
                r100.append(')');
                return r100.toString();
            L5:
                String r103 = this.f275993e.f275988c.f275973a;
                int r104 = this.f275990b;
                String r105 = r103.substring(r104, this.f275992d + r104);
                StringBuilder r106 = new StringBuilder();
                int r107 = 0;
            L7:
                if (r107 >= r105.length()) goto L16;
                if (r105.charAt(r107) >= ' ') goto L11;
            L14:
                r106.append('.');
            L15:
                r107 = r107 + 1;
                goto L7
            L11:
                if (r105.charAt(r107) > '~') goto L14;
                r106.append(r105.charAt(r107));
                goto L15
            L16:
                r100.append(r106.toString());
                goto L17
            }

            public a(c r100, Mode r101, int r102, int r103, int r104) {
                this.f275993e = r100;
                this.f275989a = r101;
                this.f275990b = r102;
                this.f275991c = r103;
                this.f275992d = r104;
            }
        }

        public final String toString() {
            StringBuilder r100 = new StringBuilder();
            Iterator r101 = ((ArrayList) this.f275986a).iterator();
            a r102 = null;
        L4:
            if (r101.hasNext() == false) goto L10;
            a r103 = (a) r101.next();
            if (r102 == null) goto L8;
            r100.append(",");
        L8:
            r100.append(r103.toString());
            r102 = r103;
            goto L4
        L10:
            return r100.toString();
        }

        public final int a(com.google.zxing.qrcode.decoder.b r110) {
            Iterator<a> r100 = this.f275986a.iterator();
            int r101 = 0;
        L4:
            if (r100.hasNext() == false) goto L31;
            a r102 = r100.next();
            int r103 = 4;
            int r104 = r102.f275989a.getCharacterCountBits(r110) + 4;
            int r105 = a.f275979b[r102.f275989a.ordinal()];
            if (r105 != 1) goto L8;
            r103 = r102.f275992d * 13;
        L29:
            r104 = r104 + r103;
        L30:
            r101 = r101 + r104;
            goto L4
        L8:
            if (r105 != 2) goto L10;
            int r106 = r102.f275992d;
            int r107 = r104 + ((r106 / 2) * 11);
            if ((r106 % 2) != 1) goto L26;
            int r108 = 6;
        L27:
            r104 = r107 + r108;
            goto L30
        L26:
            r108 = 0;
            goto L27
        L10:
            if (r105 == 3) goto L17;
            if (r105 != 4) goto L13;
            r103 = r102.a() * 8;
            goto L29
        L13:
            if (r105 != 5) goto L30;
            r104 = r104 + 8;
            goto L30
        L17:
            int r109 = r102.f275992d;
            r104 = r104 + ((r109 / 3) * 10);
            int r111 = r109 % 3;
            if (r111 == 1) goto L29;
            if (r111 != 2) goto L22;
            r103 = 7;
            goto L29
        L22:
            r103 = 0;
            goto L29
        L31:
            return r101;
        }

        public c(MinimalEncoder r110, com.google.zxing.qrcode.decoder.b r111, b r112) {
            this.f275988c = r110;
            this.f275986a = new ArrayList();
            int r100 = 0;
            int r101 = 0;
            boolean r102 = false;
        L3:
            int r103 = 1;
            if (r112 == null) goto L26;
            int r113 = r101 + r112.f275983d;
            b r104 = r112.f275984e;
            Mode r105 = r112.f275980a;
            if (r105 != Mode.BYTE) goto L10;
            if (r104 != null) goto L10;
            if (r112.f275982c == 0) goto L10;
        L13:
            boolean r106 = true;
        L15:
            if (r106 == false) goto L17;
            r102 = true;
        L17:
            if (r104 != null) goto L19;
        L21:
            ListProtector.add(this.f275986a, 0, new a(this, r105, r112.f275981b, r112.f275982c, r113));
            r113 = 0;
        L22:
            if (r106 == false) goto L24;
            ListProtector.add(this.f275986a, 0, new a(this, Mode.ECI, r112.f275981b, r112.f275982c, 0));
        L24:
            r112 = r104;
            r101 = r113;
            goto L3
        L19:
            if (r104.f275980a != r105) goto L21;
            if (r106 == false) goto L22;
        L10:
            if (r104 != null) goto L12;
        L14:
            r106 = false;
            goto L15
        L12:
            if (r112.f275982c == r104.f275982c) goto L14;
        L26:
            if (r110.f275974b == false) goto L38;
            a r114 = (a) ListProtector.get(this.f275986a, 0);
            if (r114 == null) goto L33;
            Mode r115 = r114.f275989a;
            Mode r107 = Mode.ECI;
            if (r115 == r107) goto L33;
            if (r102 == false) goto L33;
            ListProtector.add(this.f275986a, 0, new a(this, r107, 0, 0, 0));
        L33:
            a r116 = (a) ListProtector.get(this.f275986a, 0);
            List<a> r108 = this.f275986a;
            if (r116.f275989a != Mode.ECI) goto L37;
            r100 = 1;
        L37:
            ListProtector.add(r108, r100, new a(this, Mode.FNC1_FIRST_POSITION, 0, 0, 0));
        L38:
            int r117 = r111.f275965a;
            int[] r109 = a.f275978a;
            int r118 = 26;
            if (r117 > 9) goto L41;
            VersionSize r119 = VersionSize.SMALL;
        L44:
            int r120 = r109[r119.ordinal()];
            if (r120 != 1) goto L47;
            r118 = 9;
        L51:
            int r121 = a(r111);
        L52:
            if (r117 >= r118) goto L56;
            if (com.google.zxing.qrcode.encoder.c.d(r121, com.google.zxing.qrcode.decoder.b.b(r117), r110.f275976d) == true) goto L56;
            r117 = r117 + 1;
        L56:
            if (r117 <= r103) goto L60;
            int r122 = r117 - 1;
            if (com.google.zxing.qrcode.encoder.c.d(r121, com.google.zxing.qrcode.decoder.b.b(r122), r110.f275976d) == false) goto L60;
            r117 = r122;
        L60:
            this.f275987b = com.google.zxing.qrcode.decoder.b.b(r117);
            return;
        L47:
            if (r120 == 2) goto L49;
            r103 = 27;
            r118 = 40;
            goto L51
        L49:
            r103 = 10;
            goto L51
        L41:
            if (r117 > 26) goto L43;
            r119 = VersionSize.MEDIUM;
            goto L44
        L43:
            r119 = VersionSize.LARGE;
            goto L44
        }
    }

    public static com.google.zxing.qrcode.decoder.b e(VersionSize r100) {
        int r101 = a.f275978a[r100.ordinal()];
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L9;
        return com.google.zxing.qrcode.decoder.b.b(40);
    L9:
        return com.google.zxing.qrcode.decoder.b.b(26);
    L11:
        return com.google.zxing.qrcode.decoder.b.b(9);
    }

    public final c d(com.google.zxing.qrcode.decoder.b r110) throws WriterException {
        int r100 = this.f275973a.length();
        int r101 = 1;
        b[][][] r102 = (b[][][]) Array.newInstance(b.class, new int[]{r100 + 1, this.f275975c.f520917a.length, 4});
        b(r110, r102, 0, null);
    L3:
        if (r101 > r100) goto L16;
        int r103 = 0;
    L6:
        if (r103 >= this.f275975c.f520917a.length) goto L15;
        int r104 = 0;
    L8:
        if (r104 >= 4) goto L14;
        b r105 = r102[r101][r103][r104];
        if (r105 == null) goto L13;
        if (r101 >= r100) goto L13;
        b(r110, r102, r101, r105);
    L13:
        r104 = r104 + 1;
        goto L8
    L14:
        r103 = r103 + 1;
        goto L6
    L15:
        r101 = r101 + 1;
        goto L3
    L16:
        int r106 = -1;
        int r107 = -1;
        int r108 = Integer.MAX_VALUE;
        int r109 = 0;
    L18:
        if (r109 >= this.f275975c.f520917a.length) goto L28;
        int r111 = 0;
    L20:
        if (r111 >= 4) goto L27;
        b r112 = r102[r100][r109][r111];
        if (r112 == null) goto L26;
        int r113 = r112.f275985f;
        if (r113 >= r108) goto L26;
        r106 = r109;
        r107 = r111;
        r108 = r113;
    L26:
        r111 = r111 + 1;
        goto L20
    L27:
        r109 = r109 + 1;
        goto L18
    L28:
        if (r106 < 0) goto L32;
        return new c(this, r110, r102[r100][r106][r107]);
    L32:
        throw new WriterException("Internal error: failed to encode \"" + this.f275973a + "\"");
    }

    public static boolean c(Mode r100, char r101) {
        int r102 = a.f275979b[r100.ordinal()];
        if (r102 == 1) goto L28;
        if (r102 == 2) goto L20;
        if (r102 == 3) goto L13;
        if (r102 == 4) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (r101 >= '0') goto L15;
    L17:
        return false;
    L15:
        if (r101 > '9') goto L17;
        return true;
    L20:
        if (r101 >= '`') goto L22;
        int r103 = com.google.zxing.qrcode.encoder.c.f275999a[r101];
    L23:
        if (r103 != (-1)) goto L30;
        return false;
    L30:
        return true;
    L22:
        int[] r104 = com.google.zxing.qrcode.encoder.c.f275999a;
        r103 = -1;
        goto L23
    L28:
        return com.google.zxing.qrcode.encoder.c.c(String.valueOf(r101));
    }

    public static void a(b[][][] r100, int r101, b r102) {
        b[] r103 = r100[r101 + r102.f275983d][r102.f275982c];
        Mode r104 = r102.f275980a;
        if (r104 == null) goto L17;
        int r105 = a.f275979b[r104.ordinal()];
        char r106 = 1;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L18;
        r106 = 3;
        if (r105 != 3) goto L12;
        r106 = 2;
        goto L18
    L12:
        if (r105 == 4) goto L18;
        throw new IllegalStateException("Illegal mode " + r104);
    L18:
        b r107 = r103[r106];
        if (r107 != null) goto L21;
    L22:
        r103[r106] = r102;
        return;
    L21:
        if (r107.f275985f > r102.f275985f) goto L22;
        return;
    L17:
        r106 = 0;
        goto L18
    }

    public MinimalEncoder(String r100, Charset r101, boolean r102, ErrorCorrectionLevel r103) {
        this.f275973a = r100;
        this.f275974b = r102;
        this.f275975c = new nv7.c(r100, r101);
        this.f275976d = r103;
    }

    public final void b(com.google.zxing.qrcode.decoder.b r110, b[][][] r111, int r112, b r113) {
        nv7.c r100 = this.f275975c;
        int r101 = r100.f520917a.length;
        int r102 = r100.f520918b;
        if (r102 < 0) goto L7;
        char r103 = this.f275973a.charAt(r112);
        if (r100.f520917a[r102].canEncode("" + r103) == false) goto L7;
        r101 = r102 + 1;
    L8:
        int r114 = r101;
        int r115 = r102;
    L9:
        if (r115 >= r114) goto L14;
        nv7.c r104 = this.f275975c;
        char r105 = this.f275973a.charAt(r112);
        if (r104.f520917a[r115].canEncode("" + r105) == false) goto L13;
        a(r111, r112, new b(this, Mode.BYTE, r112, r115, 1, r113, r110));
    L13:
        r115 = r115 + 1;
        goto L9
    L14:
        Mode r106 = Mode.KANJI;
        if (c(r106, this.f275973a.charAt(r112)) == false) goto L17;
        a(r111, r112, new b(this, r106, r112, 0, 1, r113, r110));
    L17:
        int r116 = this.f275973a.length();
        Mode r107 = Mode.ALPHANUMERIC;
        if (c(r107, this.f275973a.charAt(r112)) == false) goto L27;
        int r108 = r112 + 1;
        if (r108 < r116) goto L22;
    L25:
        int r109 = 1;
    L26:
        a(r111, r112, new b(this, r107, r112, 0, r109, r113, r110));
        goto L27
    L22:
        if (c(r107, this.f275973a.charAt(r108)) == false) goto L25;
        r109 = 2;
    L27:
        Mode r117 = Mode.NUMERIC;
        if (c(r117, this.f275973a.charAt(r112)) == false) goto L47;
        int r118 = r112 + 1;
        if (r118 < r116) goto L32;
    L41:
        int r119 = 1;
    L42:
        a(r111, r112, new b(this, r117, r112, 0, r119, r113, r110));
        return;
    L32:
        if (c(r117, this.f275973a.charAt(r118)) == false) goto L41;
        int r120 = r112 + 2;
        if (r120 < r116) goto L37;
    L40:
        r119 = 2;
        goto L42
    L37:
        if (c(r117, this.f275973a.charAt(r120)) == false) goto L40;
        r119 = 3;
        goto L42
    L47:
        return;
    L7:
        r102 = 0;
        goto L8
    }
}
