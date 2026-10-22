package cx2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f465689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f465690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f465691d;

    public final float c() {
        d r100 = this.f465691d;
        String r101 = this.f465688a;
        int r102 = this.f465689b;
        int r103 = this.f465690c;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "input");
        r100.f465687a = r102;
        if (r102 < r103) goto L5;
    L4:
        float r104 = Float.NaN;
    L158:
        if (Float.isNaN(r104) == true) goto L160;
        this.f465689b = this.f465691d.f465687a;
    L160:
        return r104;
    L5:
        char r105 = r101.charAt(r102);
        if (r105 != '-') goto L8;
        r100.f465687a++;
        boolean r106 = true;
    L11:
        int r110 = r100.f465687a;
        long r111 = 0;
        long r112 = 0;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
        boolean r116 = false;
        int r117 = 0;
    L12:
        int r107 = r100.f465687a;
        int r108 = 57;
        int r109 = 48;
        if (r107 >= r103) goto L40;
        char r118 = r101.charAt(r107);
        if (r118 != '0') goto L20;
        if (r113 != 0) goto L18;
        r115 = r115 + 1;
    L39:
        r100.f465687a++;
        r111 = 0;
        goto L12
    L18:
        r114 = r114 + 1;
        goto L39
    L20:
        if (Intrinsics.compare(r118, 49) < 0) goto L35;
        if (Intrinsics.compare(r118, 57) > 0) goto L35;
        int r119 = r113 + r114;
    L25:
        if (r114 <= 0) goto L29;
        if (r112 > 922337203685477580L) goto L4;
        r112 = r112 * ((long) 10);
        r114 = r114 - 1;
        goto L25
    L29:
        if (r112 > 922337203685477580L) goto L4;
        r112 = (r112 * ((long) 10)) + ((long) (r118 - '0'));
        r113 = r119 + 1;
        if (r112 >= r111) goto L39;
    L35:
        if (r118 != '.') goto L40;
        if (r116 == true) goto L40;
        r117 = r100.f465687a - r110;
        r116 = true;
    L40:
        if (r116 == true) goto L42;
    L44:
        if (r113 != 0) goto L48;
        if (r115 == 0) goto L4;
        r113 = 1;
    L48:
        if (r116 == false) goto L50;
        r114 = (r117 - r115) - r113;
    L50:
        int r120 = r100.f465687a;
        if (r120 >= r103) goto L139;
        char r121 = r101.charAt(r120);
        if (r121 != 'E') goto L55;
    L56:
        int r122 = r100.f465687a + 1;
        r100.f465687a = r122;
        if (r122 == r103) goto L4;
        char r123 = r101.charAt(r122);
        if (r123 != '-') goto L63;
        r100.f465687a++;
        boolean r124 = false;
        boolean r125 = true;
    L121:
        if (r124 == true) goto L139;
        int r126 = r100.f465687a;
        int r127 = 0;
    L123:
        int r128 = r100.f465687a;
        if (r128 >= r103) goto L134;
        char r129 = r101.charAt(r128);
        if (Intrinsics.compare(r129, r109) < 0) goto L134;
        if (Intrinsics.compare(r129, r108) > 0) goto L134;
        if (r127 > 922337203685477580L) goto L4;
        r127 = (r127 * 10) + (r129 - '0');
        r100.f465687a++;
        r109 = 48;
        r108 = 57;
    L134:
        if (r100.f465687a == r126) goto L4;
        if (r125 == false) goto L138;
        r114 = r114 - r127;
        goto L139
    L138:
        r114 = r114 + r127;
        goto L139
    L63:
        if (r123 != '+') goto L65;
        r100.f465687a++;
    L119:
        r124 = false;
    L120:
        r125 = false;
        goto L121
    L65:
        if (r123 == '0') goto L68;
        if (r123 == '1') goto L68;
        boolean r130 = false;
    L70:
        if (r130 == false) goto L73;
    L74:
        boolean r131 = true;
    L76:
        if (r131 == false) goto L79;
    L80:
        boolean r132 = true;
    L82:
        if (r132 == false) goto L85;
    L86:
        boolean r133 = true;
    L88:
        if (r133 == false) goto L91;
    L92:
        boolean r134 = true;
    L94:
        if (r134 == false) goto L97;
    L98:
        boolean r135 = true;
    L100:
        if (r135 == false) goto L103;
    L104:
        boolean r136 = true;
    L106:
        if (r136 == false) goto L109;
    L110:
        boolean r137 = true;
    L112:
        if (r137 == true) goto L115;
        if (r123 == '9') goto L115;
        boolean r138 = false;
    L117:
        if (r138 == true) goto L119;
        r100.f465687a--;
        r124 = true;
    L115:
        r138 = true;
        goto L117
    L109:
        if (r123 == '8') goto L110;
        r137 = false;
        goto L112
    L103:
        if (r123 == '7') goto L104;
        r136 = false;
        goto L106
    L97:
        if (r123 == '6') goto L98;
        r135 = false;
        goto L100
    L91:
        if (r123 == '5') goto L92;
        r134 = false;
        goto L94
    L85:
        if (r123 == '4') goto L86;
        r133 = false;
        goto L88
    L79:
        if (r123 == '3') goto L80;
        r132 = false;
        goto L82
    L73:
        if (r123 == '2') goto L74;
        r131 = false;
    L68:
        r130 = true;
        goto L70
    L55:
        if (r121 == 'e') goto L56;
    L139:
        int r139 = r113 + r114;
        if (r139 > 39) goto L4;
        if (r139 < (-44)) goto L4;
        long r140 = r112;
        float r141 = r140;
        if (r140 == 0) goto L154;
        if (r114 <= 0) goto L148;
        float r142 = d.f465685b[r114];
    L153:
        r141 = r141 * r142;
        goto L154
    L148:
        if (r114 >= 0) goto L154;
        if (r114 >= (-38)) goto L152;
        r141 = r141 * 1.0E-20f;
        r114 = r114 + 20;
    L152:
        r142 = d.f465686c[-r114];
    L154:
        if (r106 == false) goto L156;
        r141 = -r141;
    L156:
        r104 = r141;
        goto L158
    L42:
        if (r100.f465687a != (r117 + 1)) goto L44;
    L8:
        if (r105 != '+') goto L10;
        r100.f465687a++;
    L10:
        r106 = false;
        goto L11
    }

    public final void d() {
    L2:
        int r100 = this.f465689b;
        if (r100 >= this.f465690c) goto L17;
        char r101 = this.f465688a.charAt(r100);
        if (r101 != ' ') goto L7;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == false) goto L20;
        this.f465689b++;
        goto L2
    L20:
        return;
    L7:
        if (r101 == '\n') goto L14;
        if (r101 == '\r') goto L14;
        if (r101 == '\t') goto L14;
        r102 = false;
        goto L15
    }

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        this.f465691d = new d();
        int r101 = r100.length() - 1;
        int r102 = 0;
        boolean r103 = false;
    L3:
        if (r102 > r101) goto L18;
        if (r103 == true) goto L6;
        int r104 = r102;
    L8:
        if (Intrinsics.compare(r100.charAt(r104), 32) > 0) goto L10;
        boolean r105 = true;
    L11:
        if (r103 == false) goto L12;
        if (r105 == false) goto L18;
        r101 = r101 - 1;
        goto L3
    L12:
        if (r105 == false) goto L13;
        r102 = r102 + 1;
        goto L3
    L13:
        r103 = true;
        goto L3
    L10:
        r105 = false;
        goto L11
    L6:
        r104 = r101;
    L18:
        String r106 = r100.subSequence(r102, r101 + 1).toString();
        this.f465688a = r106;
        this.f465690c = r106.length();
    }

    public final float a(float r100) {
        if (Float.isNaN(r100) == false) goto L6;
        return Float.NaN;
    L6:
        d();
        int r101 = this.f465689b;
        if (r101 == this.f465690c) goto L14;
        if (this.f465688a.charAt(r101) != ',') goto L14;
        this.f465689b++;
        d();
    L14:
        return c();
    }

    public final boolean b(char r100) {
        int r101 = this.f465689b;
        if (r101 < this.f465690c) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        this.f465689b++;
    L10:
        return r102;
    L5:
        if (this.f465688a.charAt(r101) != r100) goto L7;
        r102 = true;
        goto L8
    }
}
