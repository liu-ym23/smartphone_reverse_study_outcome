package dgc;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final double[] f468552e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char f468553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f468554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f468555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f468556d;

    static {
        f468552e = new double[128];
        int r100 = 0;
    L3:
        double[] r101 = f468552e;
        if (r100 >= r101.length) goto L6;
        r101[r100] = Math.pow(10.0d, r100);
        r100 = r100 + 1;
        goto L3
    }

    public final char b() {
        int r100 = this.f468555c;
        int r101 = this.f468556d;
        if (r100 >= r101) goto L5;
        this.f468555c = r100 + 1;
    L5:
        int r102 = this.f468555c;
        if (r102 != r101) goto L10;
        return 0;
    L10:
        return this.f468554b.charAt(r102);
    }

    public final void d() {
    L2:
        int r100 = this.f468555c;
        if (r100 >= this.f468556d) goto L7;
        if (Character.isWhitespace(this.f468554b.charAt(r100)) == false) goto L10;
        this.f468553a = b();
        goto L2
    L10:
        return;
    }

    public final float a() {
        d();
        char r100 = this.f468553a;
        boolean r101 = true;
        int r102 = 0;
        if (r100 == '+') goto L7;
        if (r100 == '-') goto L6;
        boolean r103 = true;
    L10:
        switch(this.f468553a) {
            case 46: goto L27;
            case 47: goto L11;
            case 48: goto L12;
            case 49: goto L18;
            case 50: goto L18;
            case 51: goto L18;
            case 52: goto L18;
            case 53: goto L18;
            case 54: goto L18;
            case 55: goto L18;
            case 56: goto L18;
            case 57: goto L18;
            default: goto L11;
        };
    L11:
        float r104 = Float.NaN;
    L99:
        int r105 = this.f468555c;
        if (r105 >= this.f468556d) goto L111;
        char r106 = this.f468554b.charAt(r105);
        if (r106 == '\t') goto L110;
        if (r106 == '\n') goto L110;
        if (r106 == ' ') goto L110;
        if (r106 != ',') goto L111;
    L110:
        this.f468553a = b();
    L111:
        return r104;
    L12:
        char r107 = b();
        this.f468553a = r107;
        if (r107 == '.') goto L25;
        if (r107 == 'E') goto L25;
        if (r107 == 'e') goto L25;
        switch(r107) {
            case 48: goto L12;
            case 49: goto L18;
            case 50: goto L18;
            case 51: goto L18;
            case 52: goto L18;
            case 53: goto L18;
            case 54: goto L18;
            case 55: goto L18;
            case 56: goto L18;
            case 57: goto L18;
            default: goto L98;
        };
    L98:
        r104 = 0.0f;
    L25:
        int r108 = 0;
        int r110 = 0;
        int r111 = 0;
    L26:
        boolean r112 = true;
    L29:
        if (this.f468553a != '.') goto L46;
        char r109 = b();
        this.f468553a = r109;
        switch(r109) {
            case 48: goto L34;
            case 49: goto L39;
            case 50: goto L39;
            case 51: goto L39;
            case 52: goto L39;
            case 53: goto L39;
            case 54: goto L39;
            case 55: goto L39;
            case 56: goto L39;
            case 57: goto L39;
            default: goto L32;
        };
    L32:
        if (r112 == true) goto L46;
        c(r109);
        throw null;
    L34:
        if (r108 != 0) goto L39;
    L35:
        char r113 = b();
        this.f468553a = r113;
        r110 = r110 - 1;
        switch(r113) {
            case 48: goto L35;
            case 49: goto L39;
            case 50: goto L39;
            case 51: goto L39;
            case 52: goto L39;
            case 53: goto L39;
            case 54: goto L39;
            case 55: goto L39;
            case 56: goto L39;
            case 57: goto L39;
            default: goto L37;
        };
    L37:
        if (r112 == true) goto L46;
    L39:
        if (r108 >= 9) goto L41;
        r108 = r108 + 1;
        r111 = (r111 * 10) + (this.f468553a - '0');
        r110 = r110 - 1;
    L41:
        char r114 = b();
        this.f468553a = r114;
        switch(r114) {
            case 48: goto L39;
            case 49: goto L39;
            case 50: goto L39;
            case 51: goto L39;
            case 52: goto L39;
            case 53: goto L39;
            case 54: goto L39;
            case 55: goto L39;
            case 56: goto L39;
            case 57: goto L39;
            default: goto L46;
        };
    L46:
        char r115 = this.f468553a;
        if (r115 == 'E') goto L50;
        if (r115 == 'e') goto L50;
    L74:
        if (r101 == true) goto L76;
        r102 = -r102;
    L76:
        int r116 = r102 + r110;
        if (r103 == true) goto L80;
        r111 = -r111;
    L80:
        if (r116 < (-125)) goto L98;
        if (r111 == 0) goto L98;
        if (r116 < 128) goto L88;
        if (r111 <= 0) goto L87;
        r104 = Float.POSITIVE_INFINITY;
        goto L99
    L87:
        r104 = Float.NEGATIVE_INFINITY;
        goto L99
    L88:
        if (r116 != 0) goto L91;
        r104 = r111;
        goto L99
    L91:
        if (r111 < 67108864) goto L93;
        r111 = r111 + 1;
    L93:
        double[] r117 = f468552e;
        double r118 = r111;
        if (r116 <= 0) goto L96;
        double r119 = r118 * r117[r116];
    L97:
        r104 = (float) r119;
        goto L99
    L96:
        r119 = r118 / r117[-r116];
    L50:
        char r120 = b();
        this.f468553a = r120;
        if (r120 == '+') goto L57;
        if (r120 == '-') goto L56;
        switch(r120) {
            case 48: goto L62;
            case 49: goto L62;
            case 50: goto L62;
            case 51: goto L62;
            case 52: goto L62;
            case 53: goto L62;
            case 54: goto L62;
            case 55: goto L62;
            case 56: goto L62;
            case 57: goto L62;
            default: goto L54;
        };
    L54:
        c(r120);
        throw null;
    L62:
        switch(this.f468553a) {
            case 48: goto L64;
            case 49: goto L67;
            case 50: goto L67;
            case 51: goto L67;
            case 52: goto L67;
            case 53: goto L67;
            case 54: goto L67;
            case 55: goto L67;
            case 56: goto L67;
            case 57: goto L67;
            default: goto L74;
        };
    L64:
        char r121 = b();
        this.f468553a = r121;
        switch(r121) {
            case 48: goto L64;
            case 49: goto L67;
            case 50: goto L67;
            case 51: goto L67;
            case 52: goto L67;
            case 53: goto L67;
            case 54: goto L67;
            case 55: goto L67;
            case 56: goto L67;
            case 57: goto L67;
            default: goto L74;
        };
    L67:
        int r122 = 0;
    L69:
        if (r102 >= 3) goto L71;
        r102 = r102 + 1;
        r122 = (r122 * 10) + (this.f468553a - '0');
    L71:
        char r123 = b();
        this.f468553a = r123;
        switch(r123) {
            case 48: goto L69;
            case 49: goto L69;
            case 50: goto L69;
            case 51: goto L69;
            case 52: goto L69;
            case 53: goto L69;
            case 54: goto L69;
            case 55: goto L69;
            case 56: goto L69;
            case 57: goto L69;
            default: goto L73;
        };
    L73:
        r102 = r122;
        goto L74
    L56:
        r101 = false;
    L57:
        char r124 = b();
        this.f468553a = r124;
        switch(r124) {
            case 48: goto L62;
            case 49: goto L62;
            case 50: goto L62;
            case 51: goto L62;
            case 52: goto L62;
            case 53: goto L62;
            case 54: goto L62;
            case 55: goto L62;
            case 56: goto L62;
            case 57: goto L62;
            default: goto L59;
        };
    L59:
        c(r124);
        throw null;
    L18:
        r108 = 0;
        r110 = 0;
        r111 = 0;
    L19:
        if (r108 >= 9) goto L21;
        r108 = r108 + 1;
        r111 = (r111 * 10) + (this.f468553a - '0');
    L22:
        char r125 = b();
        this.f468553a = r125;
        switch(r125) {
            case 48: goto L19;
            case 49: goto L19;
            case 50: goto L19;
            case 51: goto L19;
            case 52: goto L19;
            case 53: goto L19;
            case 54: goto L19;
            case 55: goto L19;
            case 56: goto L19;
            case 57: goto L19;
            default: goto L26;
        };
    L21:
        r110 = r110 + 1;
        goto L22
    L27:
        r108 = 0;
        r110 = 0;
        r111 = 0;
        r112 = false;
        goto L29
    L6:
        r103 = false;
    L8:
        this.f468553a = b();
        goto L10
    L7:
        r103 = true;
        goto L8
    }

    public c(CharSequence r100) {
        this.f468554b = r100;
        this.f468555c = 0;
        String r101 = (String) r100;
        this.f468556d = r101.length();
        this.f468553a = r101.charAt(this.f468555c);
    }

    public static void c(char r100) {
        throw new RuntimeException("Unexpected char '" + r100 + "'.");
    }
}
