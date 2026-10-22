package com.caverock.androidsvg;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f272982b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float[] f272983c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f272984a;

    public b() {
    }

    static {
        f272982b = new float[]{1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f, 1.0E11f, 1.0E12f, 1.0E13f, 1.0E14f, 1.0E15f, 1.0E16f, 1.0E17f, 1.0E18f, 1.0E19f, 1.0E20f, 1.0E21f, 1.0E22f, 1.0E23f, 1.0E24f, 1.0E25f, 1.0E26f, 1.0E27f, 1.0E28f, 1.0E29f, 1.0E30f, 1.0E31f, 1.0E32f, 1.0E33f, 1.0E34f, 1.0E35f, 1.0E36f, 1.0E37f, 1.0E38f};
        f272983c = new float[]{1.0f, 0.1f, 0.01f, 0.001f, 1.0E-4f, 1.0E-5f, 1.0E-6f, 1.0E-7f, 1.0E-8f, 1.0E-9f, 1.0E-10f, 1.0E-11f, 1.0E-12f, 1.0E-13f, 1.0E-14f, 1.0E-15f, 1.0E-16f, 1.0E-17f, 1.0E-18f, 1.0E-19f, 1.0E-20f, 1.0E-21f, 1.0E-22f, 1.0E-23f, 1.0E-24f, 1.0E-25f, 1.0E-26f, 1.0E-27f, 1.0E-28f, 1.0E-29f, 1.0E-30f, 1.0E-31f, 1.0E-32f, 1.0E-33f, 1.0E-34f, 1.0E-35f, 1.0E-36f, 1.0E-37f, 1.0E-38f};
    }

    public final float a(String r210, int r211, int r212) {
        this.f272984a = r211;
        if (r211 < r212) goto L5;
        return Float.NaN;
    L5:
        char r100 = r210.charAt(r211);
        if (r100 == '+') goto L10;
        if (r100 == '-') goto L9;
        boolean r101 = false;
    L12:
        int r102 = this.f272984a;
        long r110 = 0;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
        boolean r114 = false;
        int r115 = 0;
    L13:
        int r103 = this.f272984a;
        if (r103 >= r212) goto L42;
        char r104 = r210.charAt(r103);
        if (r104 != '0') goto L21;
        if (r111 != 0) goto L19;
        r113 = r113 + 1;
    L41:
        this.f272984a++;
        goto L13
    L19:
        r112 = r112 + 1;
        goto L41
    L21:
        if (r104 < '1') goto L37;
        if (r104 > '9') goto L37;
        int r116 = r111 + r112;
    L25:
        if (r112 <= 0) goto L31;
        if (r110 > 922337203685477580L) goto L28;
        r110 = r110 * 10;
        r112 = r112 - 1;
        goto L25
    L28:
        return Float.NaN;
    L31:
        if (r110 > 922337203685477580L) goto L32;
        r110 = (r110 * 10) + ((long) (r104 - '0'));
        r111 = r116 + 1;
        if (r110 >= 0) goto L41;
        return Float.NaN;
    L32:
        return Float.NaN;
    L37:
        if (r104 != '.') goto L42;
        if (r114 == true) goto L42;
        r115 = this.f272984a - r102;
        r114 = true;
    L42:
        if (r114 == true) goto L44;
    L46:
        if (r111 != 0) goto L50;
        if (r113 != 0) goto L49;
        return Float.NaN;
    L49:
        r111 = 1;
    L50:
        if (r114 == false) goto L52;
        r112 = (r115 - r113) - r111;
    L52:
        int r105 = this.f272984a;
        if (r105 >= r212) goto L89;
        char r106 = r210.charAt(r105);
        if (r106 != 'E') goto L57;
    L58:
        int r107 = this.f272984a + 1;
        this.f272984a = r107;
        if (r107 != r212) goto L61;
        return Float.NaN;
    L61:
        char r108 = r210.charAt(r107);
        if (r108 != '+') goto L64;
        boolean r109 = false;
    L70:
        this.f272984a++;
    L71:
        boolean r117 = false;
    L72:
        if (r117 == true) goto L89;
        int r118 = this.f272984a;
        int r119 = 0;
    L74:
        int r120 = this.f272984a;
        if (r120 >= r212) goto L84;
        char r121 = r210.charAt(r120);
        if (r121 < '0') goto L84;
        if (r121 > '9') goto L84;
        if (r119 > 922337203685477580L) goto L81;
        r119 = (r119 * 10) + (r121 - '0');
        this.f272984a++;
        goto L74
    L81:
        return Float.NaN;
    L84:
        if (this.f272984a != r118) goto L86;
        return Float.NaN;
    L86:
        if (r109 == false) goto L88;
        r112 = r112 - r119;
        goto L89
    L88:
        r112 = r112 + r119;
        goto L89
    L64:
        if (r108 == '-') goto L68;
        switch(r108) {
            case 48: goto L67;
            case 49: goto L67;
            case 50: goto L67;
            case 51: goto L67;
            case 52: goto L67;
            case 53: goto L67;
            case 54: goto L67;
            case 55: goto L67;
            case 56: goto L67;
            case 57: goto L67;
            default: goto L66;
        };
    L66:
        this.f272984a--;
        r109 = false;
        r117 = true;
        goto L72
    L67:
        r109 = false;
        goto L71
    L68:
        r109 = true;
        goto L70
    L57:
        if (r106 == 'e') goto L58;
    L89:
        int r122 = r111 + r112;
        if (r122 <= 39) goto L92;
    L107:
        return Float.NaN;
    L92:
        if (r122 < (-44)) goto L107;
        long r123 = r110;
        float r124 = r123;
        if (r123 == 0) goto L104;
        if (r112 <= 0) goto L99;
        float r125 = f272982b[r112];
    L98:
        r124 = r124 * r125;
        goto L104
    L99:
        if (r112 >= 0) goto L104;
        if (r112 >= (-38)) goto L103;
        r124 = (float) (((double) r124) * 1.0E-20d);
        r112 = r112 + 20;
    L103:
        r125 = f272983c[-r112];
    L104:
        if (r101 == true) goto L106;
        return r124;
    L106:
        return -r124;
    L44:
        if (this.f272984a != (r115 + 1)) goto L46;
        return Float.NaN;
    L9:
        r101 = true;
    L11:
        this.f272984a++;
        goto L12
    L10:
        r101 = false;
        goto L11
    }
}
