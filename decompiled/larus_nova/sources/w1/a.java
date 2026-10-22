package w1;

import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import kotlin.jvm.internal.ByteCompanionObject;
import y1.d;

/* JADX INFO: loaded from: classes39.dex */
public final class a {
    public String A;
    public boolean B;
    public final byte[] C;
    public boolean D;
    public byte E;
    public int F;
    public int G;
    public int H;
    public byte[] I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f557834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f557835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f557836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f557837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f557838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f557839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f557840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f557841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f557842i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f557843j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final byte[] f557844k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f557845l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f557846m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f557847n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f557848o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f557849p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f557850q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public byte[] f557851r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f557852s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f557853t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f557854u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f557855v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f557856w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f557857x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f557858y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f557859z;

    public final String a() {
        byte[] r100 = this.f557851r;
        if (r100 != null) goto L5;
        return "";
    L5:
        int r101 = r100.length;
        if (r101 != 0) goto L9;
        return "0.00";
    L9:
        double r102 = this.f557854u * 100;
        double r103 = r101;
        if ((r102 / 100.0d) <= r103) goto L12;
        r102 = r103;
    L12:
        StringBuilder r104 = new StringBuilder();
        r104.append(new BigDecimal(Double.toString(r102)).divide(new BigDecimal(Double.toString(r103)), 2, 4).doubleValue() + "");
        r104.append("");
        return r104.toString();
    }

    public a() {
        this.f557835b = 0;
        this.f557836c = false;
        this.f557837d = false;
        this.f557838e = false;
        this.f557840g = 0;
        this.f557841h = new byte[]{66, 69, 83, 84};
        this.f557842i = new byte[0];
        this.f557843j = 0;
        this.f557844k = new byte[1];
        this.f557845l = new byte[32];
        this.f557846m = "";
        this.f557847n = "";
        this.f557848o = "";
        this.f557849p = 512;
        this.f557850q = "";
        this.f557852s = 0;
        this.f557853t = 16384;
        this.f557854u = 0;
        this.f557855v = 0;
        this.f557856w = 0;
        this.f557857x = 0;
        this.f557858y = 0;
        this.f557859z = false;
        this.A = "";
        this.B = false;
        this.C = new byte[]{0, -112};
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = new byte[4];
    }

    public final byte[] b(byte[] r100) {
        byte[] r101 = y1.a.f(r100.length);
        byte[] r102 = y1.a.c(this.C, new byte[]{r101[0]}, new byte[]{r101[1]}, r100);
        y1.a.k(r102);
        return r102;
    }

    public final byte[] c(Context r110) {
        this.f557834a = r110;
        byte[] r100 = {-116};
        byte[] r101 = this.f557842i;
        byte[] r102 = new byte[32];
        byte[] r103 = {1, 2, 3, 4};
        byte[] r104 = new byte[4];
        if (this.f557835b != 1) goto L5;
        r101 = y1.a.f(this.f557841h.length + 40);
    L5:
        byte[] r105 = new byte[40];
        String r106 = (String) d.a(this.f557834a, "BES_OTA_RANDOM_CODE_LEFT" + this.f557839f, "");
        if (r106 == null) goto L9;
        if (r106 == "") goto L9;
        r102 = y1.a.j(r106);
    L9:
        byte[] r107 = new byte[36];
        System.arraycopy(r102, 0, r107, 0, r102.length);
        System.arraycopy(r103, 0, r107, r102.length, 4);
        long r108 = y1.a.e(r107, 36);
        r104[0] = (byte) r108;
        r104[1] = (byte) (r108 >> 8);
        r104[2] = (byte) (r108 >> 16);
        r104[3] = (byte) (r108 >> 24);
        System.arraycopy(r102, 0, r105, 0, r102.length);
        System.arraycopy(r103, 0, r105, r102.length, 4);
        System.arraycopy(r104, 0, r105, r102.length + 4, 4);
        byte[] r111 = y1.a.c(r100, r101, this.f557841h, r105);
        if (this.f557837d == true) goto L12;
        return r111;
    L12:
        return b(r111);
    }

    public final byte[] f(String r110) {
        byte[] r100 = {ByteCompanionObject.MIN_VALUE};
        int r101 = 4;
        byte[] r102 = new byte[4];
        byte[] r103 = new byte[4];
        byte[] r104 = this.f557842i;
        if (this.f557835b != 1) goto L5;
        r104 = y1.a.f(this.f557841h.length + 8);
    L5:
        byte[] r105 = r104;
        byte[] r111 = new byte[8];
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(r110);     // Catch: IOException -> L18 FileNotFoundException -> L20
        int r112 = r106.available();     // Catch: IOException -> L18 FileNotFoundException -> L20
        byte[] r113 = new byte[r112];     // Catch: IOException -> L18 FileNotFoundException -> L20
        r106.read(r113, 0, r112);     // Catch: IOException -> L18 FileNotFoundException -> L20
        r106.close();     // Catch: IOException -> L18 FileNotFoundException -> L20
        if (this.D == false) goto L16;
        this.f557858y = 0;     // Catch: IOException -> L18 FileNotFoundException -> L20
        this.f557857x = this.f557852s;     // Catch: IOException -> L18 FileNotFoundException -> L20
        byte[] r107 = new byte[4];     // Catch: IOException -> L18 FileNotFoundException -> L20
        System.arraycopy(r113, 0, r107, 0, 4);     // Catch: IOException -> L18 FileNotFoundException -> L20
        int r108 = y1.a.d(r107);     // Catch: IOException -> L18 FileNotFoundException -> L20
        int r114 = 0;
        int r115 = 0;
    L9:
        if (r114 >= r108) goto L16;
        byte[] r116 = new byte[r101];     // Catch: IOException -> L18 FileNotFoundException -> L20
        int r117 = (r114 * 8) + 4;     // Catch: IOException -> L18 FileNotFoundException -> L20
        System.arraycopy(r113, r117 + 4, r116, 0, r101);     // Catch: IOException -> L18 FileNotFoundException -> L20
        int r109 = y1.a.d(r116);     // Catch: IOException -> L18 FileNotFoundException -> L20
        r115 = r115 + r109;     // Catch: IOException -> L18 FileNotFoundException -> L20
        int r118 = this.f557854u;     // Catch: IOException -> L18 FileNotFoundException -> L20
        int r119 = r108 - 1;     // Catch: IOException -> L18 FileNotFoundException -> L20
        if (r115 > r118) goto L15;
        if (r114 == r119) goto L15;
        r114 = r114 + 1;     // Catch: IOException -> L18 FileNotFoundException -> L20
        r101 = 4;
    L15:
        this.G = r109;     // Catch: IOException -> L18 FileNotFoundException -> L20
        this.f557856w = r118 - (r115 - r109);     // Catch: IOException -> L18 FileNotFoundException -> L20
        byte r120 = r113[r117];     // Catch: IOException -> L18 FileNotFoundException -> L20
        this.E = r120;     // Catch: IOException -> L18 FileNotFoundException -> L20
        y1.a.k(new byte[]{r120});     // Catch: IOException -> L18 FileNotFoundException -> L20
        this.F = r115;     // Catch: IOException -> L18 FileNotFoundException -> L20
        byte[] r121 = new byte[r109];     // Catch: IOException -> L18 FileNotFoundException -> L20
        System.arraycopy(r113, (((r108 * 8) + 4) + r115) - r109, r121, 0, r109);     // Catch: IOException -> L18 FileNotFoundException -> L20
        r113 = r121;
        r112 = r109;
    L16:
        long r122 = y1.a.e(r113, r112);     // Catch: IOException -> L18 FileNotFoundException -> L20
        r102 = y1.a.f(r112);     // Catch: IOException -> L18 FileNotFoundException -> L20
        r103[0] = (byte) r122;     // Catch: IOException -> L18 FileNotFoundException -> L20
        r103[1] = (byte) (r122 >> 8);     // Catch: IOException -> L18 FileNotFoundException -> L20
        r103[2] = (byte) (r122 >> 16);     // Catch: IOException -> L18 FileNotFoundException -> L20
        r103[3] = (byte) (r122 >> 24);     // Catch: IOException -> L18 FileNotFoundException -> L20
    L22:
        System.arraycopy(r102, 0, r111, 0, r102.length);
        System.arraycopy(r103, 0, r111, r102.length, 4);
        byte[] r123 = y1.a.c(r100, r105, this.f557841h, r111);
        if (this.D == false) goto L26;
        r123 = y1.a.b(new byte[]{this.E}, r123);
    L26:
        if (this.f557837d == true) goto L28;
        return r123;
    L28:
        return b(r123);
    L20:
        e = move-exception;
        e.printStackTrace();
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    public final byte[] d(String r110, boolean r111) {
        if (this.f557851r == null) goto L115;
    L53:
        byte[] r112 = this.f557842i;
        if (this.f557859z == false) goto L69;
        this.f557859z = false;
        byte[] r113 = {-126};
        int r100 = this.f557854u;
        int r101 = this.f557853t * this.f557858y;
        if (this.D == false) goto L58;
        int r102 = this.f557855v;
        r100 = r100 - (this.F - this.G);
    L59:
        int r103 = r100 - r101;
        byte[] r104 = new byte[r103];
        System.arraycopy(this.f557851r, r102, r104, 0, r103);
        long r105 = y1.a.e(r104, r103);
        byte[] r106 = {(byte) r105, (byte) (r105 >> 8), (byte) (r105 >> 16), (byte) (r105 >> 24)};
        this.I = r106;
        int r107 = this.f557841h.length + 4;
        if (this.f557835b != 1) goto L62;
        r112 = y1.a.f(r107);
    L62:
        byte[] r114 = y1.a.c(r113, r112, this.f557841h, r106);
        if (this.D == false) goto L66;
        r114 = y1.a.b(new byte[]{this.E}, r114);
    L66:
        if (this.f557837d == true) goto L68;
        return r114;
    L68:
        return b(r114);
    L58:
        r102 = r101;
        goto L59
    L69:
        byte[] r115 = this.f557851r;
        int r108 = r115.length;
        boolean r109 = this.D;
        if (r109 == false) goto L72;
        r108 = this.F;
    L72:
        int r116 = this.f557856w;
        if (r116 == r108) goto L105;
        int r117 = this.f557854u;
        if (r117 == r108) goto L105;
        byte[] r118 = {-123};
        int r119 = this.f557852s;
        int r120 = this.f557853t;
        int r121 = r115.length;
        if (r109 == false) goto L80;
        r121 = this.G;
        int r122 = r117 - (this.F - r121);
    L81:
        if (r116 > 0) goto L83;
    L85:
        int r123 = r122 + r119;
        if (r123 < r121) goto L88;
        this.f557857x = r121 - r122;
        this.f557859z = true;
    L92:
        int r124 = this.f557857x;
        if ((r117 + r124) != ((this.f557858y + 1) * r120)) goto L95;
        this.f557859z = true;
    L95:
        byte[] r125 = new byte[r124];
        System.arraycopy(r115, r117, r125, 0, r124);
        if (this.f557835b != 1) goto L98;
        r112 = y1.a.f(r124);
    L98:
        byte[] r126 = y1.a.c(r118, r112, this.f557842i, r125);
        if (this.D == false) goto L102;
        r126 = y1.a.b(new byte[]{this.E}, r126);
    L102:
        if (this.f557837d == true) goto L104;
        return r126;
    L104:
        return b(r126);
    L88:
        int r127 = (this.f557858y + 1) * r120;
        if (r123 < r127) goto L91;
        this.f557857x = r127 - r122;
        this.f557859z = true;
        goto L92
    L91:
        this.f557857x = r119;
        goto L92
    L83:
        if (this.f557858y != 0) goto L85;
        this.f557858y = r116 / r120;
        goto L85
    L80:
        r122 = r117;
    L105:
        byte[] r128 = {-120};
        if (this.f557835b != 1) goto L108;
        r112 = y1.a.f(0);
    L108:
        byte[] r129 = this.f557842i;
        byte[] r130 = y1.a.c(r128, r112, r129, r129);
        if (this.D == false) goto L112;
        r130 = y1.a.b(new byte[]{this.E}, r130);
    L112:
        if (this.f557837d == true) goto L114;
        return r130;
    L114:
        return b(r130);
    L115:
        PolarisFileInputStreamWrapper r131 = new PolarisFileInputStreamWrapper(r110);     // Catch: IOException -> L49 FileNotFoundException -> L51
        int r132 = r131.available();     // Catch: IOException -> L49 FileNotFoundException -> L51
        byte[] r133 = new byte[r132];     // Catch: IOException -> L49 FileNotFoundException -> L51
        r131.read(r133, 0, r132);     // Catch: IOException -> L49 FileNotFoundException -> L51
        r131.close();     // Catch: IOException -> L49 FileNotFoundException -> L51
        if (this.D == false) goto L7;
        byte[] r134 = new byte[4];     // Catch: IOException -> L49 FileNotFoundException -> L51
        System.arraycopy(r133, 0, r134, 0, 4);     // Catch: IOException -> L49 FileNotFoundException -> L51
        int r135 = (y1.a.d(r134) * 8) + 4;     // Catch: IOException -> L49 FileNotFoundException -> L51
        int r136 = r132 - r135;     // Catch: IOException -> L49 FileNotFoundException -> L51
        byte[] r137 = new byte[r136];     // Catch: IOException -> L49 FileNotFoundException -> L51
        System.arraycopy(r133, r135, r137, 0, r136);     // Catch: IOException -> L49 FileNotFoundException -> L51
        r133 = r137;
    L7:
        this.f557851r = r133;     // Catch: IOException -> L49 FileNotFoundException -> L51
        if (this.f557843j != 2352) goto L10;
        boolean r138 = true;
    L11:
        int r139 = this.f557849p;     // Catch: IOException -> L49 FileNotFoundException -> L51
        if (this.f557835b == (-1)) goto L14;
    L16:
        if (r132 != 0) goto L18;
    L20:
        if (r111 == true) goto L30;
        int r140 = r139 - 1;     // Catch: IOException -> L49 FileNotFoundException -> L51
        if (r138 != true) goto L27;
        if (r140 <= 660) goto L33;
        r140 = 660;
    L33:
        int r141 = (r140 - this.f557840g) - (this.D ? 1 : 0);     // Catch: IOException -> L49 FileNotFoundException -> L51
        this.f557852s = r141;     // Catch: IOException -> L49 FileNotFoundException -> L51
        if (this.f557838e == false) goto L36;
        this.f557852s = (((r141 - 20) / 16) * 15) + 16;     // Catch: IOException -> L49 FileNotFoundException -> L51
    L36:
        int r142 = this.f557852s;     // Catch: IOException -> L49 FileNotFoundException -> L51
        int r143 = ((r132 + r142) - 1) / r142;     // Catch: IOException -> L49 FileNotFoundException -> L51
        int r144 = r132 / 100;     // Catch: IOException -> L49 FileNotFoundException -> L51
        if (r132 >= 256) goto L39;
        r144 = r132;
    L45:
        if (r144 >= 4096) goto L47;
        r144 = 4096;
    L47:
        int r145 = ((r132 + r144) - 1) / r144;     // Catch: IOException -> L49 FileNotFoundException -> L51
        this.f557857x = r142;     // Catch: IOException -> L49 FileNotFoundException -> L51
    L39:
        if (r144 >= 256) goto L41;
        int r146 = 256 - r144;     // Catch: IOException -> L49 FileNotFoundException -> L51
    L42:
        if (r146 == 0) goto L45;
        r144 = r144 + r146;     // Catch: IOException -> L49 FileNotFoundException -> L51
        goto L45
    L41:
        r146 = 256 - (r144 % 256);     // Catch: IOException -> L49 FileNotFoundException -> L51
        goto L42
    L27:
        if (r140 <= 512) goto L33;
        r140 = 512;
        goto L33
    L30:
        if (r139 <= 509) goto L32;
        r140 = 508;
        goto L33
    L32:
        r140 = r139 - 1;     // Catch: IOException -> L49 FileNotFoundException -> L51
        goto L33
    L18:
        if (r132 >= (r139 - 1)) goto L20;
        r140 = r132;
        goto L33
    L14:
        if (this.B == false) goto L16;
        r138 = true;
        goto L16
    L10:
        r138 = false;
    L51:
        e = move-exception;
        e.printStackTrace();
    L49:
        e = move-exception;
        e.printStackTrace();
        goto L53
    }

    public final byte[] e(String r210, Context r211) {
        this.f557859z = false;
        this.f557834a = r211;
        byte[] r100 = {-122};
        byte[] r101 = new byte[4];
        byte[] r102 = new byte[4];
        boolean r103 = this.D;
        int r104 = 32;
        if (r103 == false) goto L5;
        int r110 = 16;
    L6:
        byte[] r111 = new byte[r110];
        if (r103 == false) goto L9;
        r104 = 16;
    L9:
        byte[] r105 = new byte[r104];
        byte[] r112 = new byte[6];
        byte[] r113 = new byte[6];
        byte[] r114 = new byte[4];
        byte[] r106 = this.f557842i;
        int r115 = ((((r110 + 12) + r104) + 6) + 6) + 4;
        if (this.f557835b != 1) goto L12;
        r106 = y1.a.f(r115);
    L12:
        byte[] r107 = new byte[r115];
        int r116 = r115 - 4;
        byte[] r108 = y1.a.f(r116);
        PolarisFileInputStreamWrapper r117 = new PolarisFileInputStreamWrapper(r210);     // Catch: IOException -> L73 FileNotFoundException -> L76
        int r109 = r117.available();     // Catch: IOException -> L73 FileNotFoundException -> L76
        byte[] r118 = r106;
        byte[] r119 = new byte[r109];     // Catch: IOException -> L69 FileNotFoundException -> L71
        byte[] r120 = r100;
        r117.read(r119, 0, r109);     // Catch: IOException -> L65 FileNotFoundException -> L67
        r117.close();     // Catch: IOException -> L65 FileNotFoundException -> L67
        r101[0] = r119[r109 - 4];     // Catch: IOException -> L65 FileNotFoundException -> L67
        r101[1] = r119[r109 - 3];     // Catch: IOException -> L65 FileNotFoundException -> L67
        r101[2] = r119[r109 - 2];     // Catch: IOException -> L65 FileNotFoundException -> L67
        Context r121 = this.f557834a;     // Catch: IOException -> L65 FileNotFoundException -> L67
        Boolean r122 = Boolean.FALSE;     // Catch: IOException -> L65 FileNotFoundException -> L67
        boolean r123 = ((Boolean) d.a(r121, "ota_config_clear_user_data", r122)).booleanValue();     // Catch: IOException -> L65 FileNotFoundException -> L67
        boolean r124 = ((Boolean) d.a(this.f557834a, "ota_config_update_bt_address", r122)).booleanValue();     // Catch: IOException -> L65 FileNotFoundException -> L67
        boolean r125 = ((Boolean) d.a(this.f557834a, "ota_config_update_bt_name", r122)).booleanValue();     // Catch: IOException -> L65 FileNotFoundException -> L67
    L92:
        boolean r126 = ((Boolean) d.a(this.f557834a, "ota_config_update_ble_address", r122)).booleanValue();     // Catch: IOException -> L61 FileNotFoundException -> L63
        boolean r127 = ((Boolean) d.a(this.f557834a, "ota_config_update_ble_name", r122)).booleanValue();     // Catch: IOException -> L61 FileNotFoundException -> L63
        byte r128 = (byte) ((r123 ? 1 : 0) | 0);     // Catch: IOException -> L61 FileNotFoundException -> L63
        if (r125 == false) goto L22;
        byte r129 = 2;
    L23:
        byte r130 = (byte) (r128 | r129);     // Catch: IOException -> L61 FileNotFoundException -> L63
        if (r127 == false) goto L26;
        byte r131 = 4;
    L27:
        byte r132 = (byte) (r130 | r131);     // Catch: IOException -> L61 FileNotFoundException -> L63
        if (r124 == false) goto L30;
        byte r133 = 8;
    L31:
        byte r134 = (byte) (r132 | r133);     // Catch: IOException -> L61 FileNotFoundException -> L63
        if (r126 == false) goto L34;
        byte r135 = 16;
    L35:
        r102[0] = (byte) (r134 | r135);     // Catch: IOException -> L61 FileNotFoundException -> L63
        byte[] r136 = ((String) d.a(this.f557834a, "ota_config_update_bt_name_value", "")).getBytes();     // Catch: IOException -> L61 FileNotFoundException -> L63
        int r137 = r136.length;     // Catch: IOException -> L61 FileNotFoundException -> L63
        boolean r138 = this.D;     // Catch: IOException -> L61 FileNotFoundException -> L63
        int r139 = 0;
    L37:
        if (r139 >= r136.length) goto L39;
        r111[r139] = r136[r139];     // Catch: IOException -> L61 FileNotFoundException -> L63
        r139 = r139 + 1;     // Catch: IOException -> L61 FileNotFoundException -> L63
        goto L37
    L39:
        if (r127 == false) goto L44;
        byte[] r140 = ((String) d.a(this.f557834a, "ota_config_update_ble_name_value", "")).getBytes();     // Catch: IOException -> L61 FileNotFoundException -> L63
        int r141 = r140.length;     // Catch: IOException -> L61 FileNotFoundException -> L63
        boolean r142 = this.D;     // Catch: IOException -> L61 FileNotFoundException -> L63
        int r143 = 0;
    L42:
        if (r143 >= r140.length) goto L44;
        r105[r143] = r140[r143];     // Catch: IOException -> L61 FileNotFoundException -> L63
        r143 = r143 + 1;     // Catch: IOException -> L61 FileNotFoundException -> L63
    L44:
        if (r124 == false) goto L49;
        String r144 = (String) d.a(this.f557834a, "ota_config_update_bt_address_value", "");     // Catch: IOException -> L61 FileNotFoundException -> L63
        r144.getClass();     // Catch: IOException -> L61 FileNotFoundException -> L63
        int r145 = 0;
    L47:
        if (r145 >= 6) goto L49;
        r112[5 - r145] = CastIntegerProtector.valueOf(r144.substring(r145, (r145 * 2) + 2), 16).byteValue();     // Catch: IOException -> L61 FileNotFoundException -> L63
        y1.a.k(r112);     // Catch: IOException -> L61 FileNotFoundException -> L63
        r145 = r145 + 1;     // Catch: IOException -> L61 FileNotFoundException -> L63
    L49:
        if (r126 == false) goto L53;
        String r146 = (String) d.a(this.f557834a, "ota_config_update_ble_address_value", "");     // Catch: IOException -> L61 FileNotFoundException -> L63
        int r147 = 0;
    L51:
        if (r147 >= 6) goto L53;
        r113[5 - r147] = CastIntegerProtector.valueOf(r146.substring(r147, (r147 * 2) + 2), 16).byteValue();     // Catch: IOException -> L61 FileNotFoundException -> L63
        r147 = r147 + 1;     // Catch: IOException -> L61 FileNotFoundException -> L63
    L53:
        byte[] r148 = y1.a.c(r108, r101, r102, r111);     // Catch: IOException -> L61 FileNotFoundException -> L63
        byte[] r149 = y1.a.c(r105, r112, r113, r114);     // Catch: IOException -> L61 FileNotFoundException -> L63
        byte[] r150 = r107;
        System.arraycopy(r148, 0, r150, 0, r148.length);     // Catch: IOException -> L57 FileNotFoundException -> L59
        System.arraycopy(r149, 0, r150, r148.length, r149.length);     // Catch: IOException -> L57 FileNotFoundException -> L59
        long r151 = y1.a.e(r150, r116);     // Catch: IOException -> L57 FileNotFoundException -> L59
        r114[0] = (byte) r151;     // Catch: IOException -> L57 FileNotFoundException -> L59
        r114[1] = (byte) (r151 >> 8);     // Catch: IOException -> L57 FileNotFoundException -> L59
        r114[2] = (byte) (r151 >> 16);     // Catch: IOException -> L57 FileNotFoundException -> L59
        r114[3] = (byte) (r151 >> 24);     // Catch: IOException -> L57 FileNotFoundException -> L59
        System.arraycopy(r114, 0, r150, r116, 4);     // Catch: IOException -> L57 FileNotFoundException -> L59
    L79:
        byte[] r152 = y1.a.c(r120, r118, this.f557842i, r150);
        if (this.D == false) goto L83;
        r152 = y1.a.b(new byte[]{this.E}, r152);
    L83:
        if (this.f557837d == true) goto L85;
        return r152;
    L85:
        return b(r152);
    L59:
        e = e;
    L78:
        e.printStackTrace();
    L57:
        e = e;
    L75:
        e.printStackTrace();
        goto L79
    L34:
        r135 = 0;
        goto L35
    L30:
        r133 = 0;
        goto L31
    L26:
        r131 = 0;
        goto L27
    L22:
        r129 = 0;
    L63:
        e = e;
        r150 = r107;
    L61:
        e = e;
        r150 = r107;
    L67:
        e = e;
    L68:
        r150 = r107;
    L65:
        e = e;
    L66:
        r150 = r107;
        goto L75
    L71:
        e = e;
    L72:
        r120 = r100;
    L69:
        e = e;
    L70:
        r120 = r100;
        goto L66
    L76:
        e = e;
        r118 = r106;
    L73:
        e = e;
        r118 = r106;
        goto L70
    L5:
        r110 = 32;
        goto L6
    }

    public final void g(int r100, boolean r101, boolean r102, boolean r103, boolean r104, String r105) {
        this.f557835b = r100;
        this.B = r101;
        this.f557836c = r102;
        this.f557837d = r103;
        this.f557838e = r104;
        this.f557839f = r105;
        this.f557855v = 0;
        if (r101 == false) goto L6;
        this.f557853t = 32768;
    L6:
        if (r100 != 1) goto L8;
        this.f557840g = 4;
        return;
    L8:
        this.f557840g = 0;
    }
}
