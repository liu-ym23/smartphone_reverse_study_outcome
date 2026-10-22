package w17;

import com.bytedance.memory.shrink.BaseType;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f557930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f557931b;

    public f(InputStream r100) {
        this.f557931b = 0;
        this.f557930a = r100;
    }

    public final void a(g r110) throws IOException {
        InputStream r100 = this.f557930a;
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.read();
        int r103 = 0;
    L3:
        int r111 = 1;
        if (r102 == 0) goto L10;
        r101.append((char) r102);
        r103 = r103 + 1;
        if (r103 > 2048) goto L9;
        r102 = r100.read();
        goto L3
    L9:
        throw new IOException("Bad string data which causes result to be too long.");
    L10:
        String r104 = r101.toString();
        int r105 = i.a(this.f557930a);
        if (r105 <= 0) goto L40;
        if (r105 >= 1073741823) goto L40;
        long r106 = i.b(this.f557930a);
        this.f557931b = r105;
        r110.b(r104, r105, r106);
    L41:
        int r107 = this.f557930a.read();     // Catch: EOFException -> L37
        int r108 = i.a(this.f557930a);     // Catch: EOFException -> L37
        long r109 = ((long) i.a(this.f557930a)) & BodyPartID.bodyIdMax;     // Catch: EOFException -> L37
        if (r107 == r111) goto L35;
        if (r107 != 2) goto L20;
        r110.d(i.a(this.f557930a), i.e(this.f557930a, this.f557931b), i.a(this.f557930a), i.e(this.f557930a, this.f557931b), r108, r109);     // Catch: EOFException -> L37
    L36:
        r111 = 1;
        goto L41
    L20:
        if (r107 != 4) goto L22;
        d(r108, r109, r110);     // Catch: EOFException -> L37
        goto L41
    L22:
        if (r107 != 5) goto L24;
        int r112 = i.a(this.f557930a);     // Catch: EOFException -> L37
        int r113 = i.a(this.f557930a);     // Catch: EOFException -> L37
        int r114 = i.a(this.f557930a);     // Catch: EOFException -> L37
        e[] r115 = new e[r114];     // Catch: EOFException -> L37
        int r116 = 0;
    L30:
        if (r116 >= r114) goto L32;
        r115[r116] = i.e(this.f557930a, this.f557931b);     // Catch: EOFException -> L37
        r116 = r116 + 1;     // Catch: EOFException -> L37
        goto L30
    L32:
        r110.f(r112, r113, r115, r108, r109);     // Catch: EOFException -> L37
        goto L41
    L24:
        if (r107 == 12) goto L28;
        if (r107 == 28) goto L28;
        byte[] r117 = new byte[(int) r109];     // Catch: EOFException -> L37
        i.d(this.f557930a, r117, r109);     // Catch: EOFException -> L37
        r110.h(r107, r108, r109, r117);     // Catch: EOFException -> L37
    L28:
        b(r107, r108, r109, r110);     // Catch: EOFException -> L37
        goto L41
    L35:
        e r118 = i.e(this.f557930a, this.f557931b);     // Catch: EOFException -> L37
        InputStream r119 = this.f557930a;     // Catch: EOFException -> L37
        long r120 = r109 - ((long) this.f557931b);     // Catch: EOFException -> L37
        byte[] r121 = new byte[(int) r120];     // Catch: EOFException -> L37
        i.d(r119, r121, r120);     // Catch: EOFException -> L37
        r110.g(r118, new String(r121, Charset.forName("UTF-8")), r108, r109);     // Catch: EOFException -> L37
    L37:
        r110.a();
        return;
    L40:
        throw new IOException("bad idSize: " + r105);
    }

    public final int c(int r100, d r110) throws IOException {
        e r101 = i.e(this.f557930a, this.f557931b);
        i.a(this.f557930a);
        int r102 = i.a(this.f557930a);
        int r103 = this.f557930a.read();
        BaseType r104 = BaseType.getType(r103);
        if (r104 == null) goto L7;
        int r105 = r104.getSize(this.f557931b) * r102;
        i.d(this.f557930a, new byte[r105], r105);
        r110.k(r100, r101, r102, r103);
        return (((this.f557931b + 4) + 4) + 1) + r105;
    L7:
        throw new IllegalStateException("accept primitive array failed, lost type def of typeId: " + r103);
    }

    public final void d(int r110, long r111, g r112) throws IOException {
        r112.e(i.e(this.f557930a, this.f557931b), i.e(this.f557930a, this.f557931b), i.e(this.f557930a, this.f557931b), i.e(this.f557930a, this.f557931b), i.a(this.f557930a), i.a(this.f557930a), r110, r111);
    }

    public final void b(int r110, int r111, long r112, g r210) throws IOException {
        long r100 = r112;
        d r101 = r210.c(r110, r111, r100);
        if (r101 != null) goto L7;
        i.g(this.f557930a, r100);
        return;
    L7:
        if (r100 <= 0) goto L69;
        int r102 = this.f557930a.read();
        long r113 = r100 - 1;
        if (r102 != 144) goto L11;
        d r103 = r101;
        r103.b(r102, i.e(this.f557930a, this.f557931b));
        int r104 = this.f557931b;
    L67:
        long r105 = r104;
    L68:
        r101 = r103;
        r100 = r113 - r105;
        goto L7
    L11:
        if (r102 != 195) goto L13;
        r103 = r101;
        r104 = c(r102, r103);
        goto L67
    L13:
        if (r102 != 254) goto L15;
        r103 = r101;
        r103.d(i.a(this.f557930a), i.e(this.f557930a, this.f557931b));
        int r106 = this.f557931b;
    L64:
        r104 = r106 + 4;
        goto L67
    L15:
        if (r102 == 255) goto L62;
        switch(r102) {
            case 1: goto L31;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            default: goto L17;
        };
    L17:
        switch(r102) {
            case 32: goto L37;
            case 33: goto L35;
            case 34: goto L34;
            case 35: goto L33;
            default: goto L18;
        };
    L18:
        d r114 = r101;
        switch(r102) {
            case 137: goto L61;
            case 138: goto L60;
            case 139: goto L59;
            case 140: goto L58;
            case 141: goto L57;
            case 142: goto L55;
            default: goto L21;
        };
    L55:
        e r107 = i.e(this.f557930a, this.f557931b);
        i.a(this.f557930a);
        i.a(this.f557930a);
        r103 = r114;
        r103.h(r107);
        int r108 = this.f557931b;
    L56:
        r106 = r108 + 4;
        goto L64
    L57:
        r103 = r114;
        r103.b(r102, i.e(this.f557930a, this.f557931b));
        r104 = this.f557931b;
        goto L67
    L58:
        r103 = r114;
        r103.b(r102, i.e(this.f557930a, this.f557931b));
        r104 = this.f557931b;
        goto L67
    L59:
        r103 = r114;
        r103.b(r102, i.e(this.f557930a, this.f557931b));
        r104 = this.f557931b;
        goto L67
    L60:
        r103 = r114;
        r103.b(r102, i.e(this.f557930a, this.f557931b));
        r104 = this.f557931b;
        goto L67
    L61:
        r103 = r114;
        r103.b(r102, i.e(this.f557930a, this.f557931b));
        r104 = this.f557931b;
        goto L67
    L21:
        throw new IllegalArgumentException("acceptHeapDumpRecord loop with unknown tag " + r102 + " with " + this.f557930a.available() + " bytes possibly remaining");
    L33:
        r104 = c(r102, r101);
    L32:
        r103 = r101;
        goto L67
    L34:
        e r109 = i.e(this.f557930a, this.f557931b);
        i.a(this.f557930a);
        int r115 = i.a(this.f557930a);
        e r116 = i.e(this.f557930a, this.f557931b);
        int r117 = this.f557931b * r115;
        byte[] r118 = new byte[r117];
        i.d(this.f557930a, r118, r117);
        r101.j(r109, r115, r116, r118);
        int r119 = this.f557931b;
        int r120 = (((r119 + 4) + 4) + r119) + r117;
    L36:
        r105 = r120;
        r103 = r101;
        goto L68
    L35:
        e r121 = i.e(this.f557930a, this.f557931b);
        i.a(this.f557930a);
        e r122 = i.e(this.f557930a, this.f557931b);
        int r123 = i.a(this.f557930a);
        byte[] r124 = new byte[r123];
        i.d(this.f557930a, r124, r123);
        r101.e(r121, r122, r124);
        int r125 = this.f557931b;
        r120 = (((r125 + 4) + r125) + 4) + r123;
        goto L36
    L37:
        e r126 = i.e(this.f557930a, this.f557931b);
        int r127 = i.a(this.f557930a);
        e r128 = i.e(this.f557930a, this.f557931b);
        e r129 = i.e(this.f557930a, this.f557931b);
        i.g(this.f557930a, this.f557931b << 2);
        int r130 = i.a(this.f557930a);
        int r131 = ((this.f557931b * 7) + 4) + 4;
        short r132 = i.c(this.f557930a);
        int r133 = r131 + 2;
        int r134 = 0;
    L38:
        if (r134 >= r132) goto L44;
        i.g(this.f557930a, 2);
        int r135 = this.f557930a.read();
        BaseType r136 = BaseType.getType(r135);
        if (r136 == null) goto L43;
        int r137 = r136.getSize(this.f557931b);
        i.g(this.f557930a, r137);
        r133 = r133 + ((r137 + 1) + 2);
        r134 = r134 + 1;
        r101 = r101;
        goto L38
    L43:
        throw new IllegalStateException("failure to skip type, cannot find type def of typeid: " + r135);
    L44:
        d r138 = r101;
        int r139 = i.c(this.f557930a);
        c[] r140 = new c[r139];
        int r141 = r133 + 2;
        int r142 = 0;
    L45:
        if (r142 >= r139) goto L51;
        e r143 = i.e(this.f557930a, this.f557931b);
        int r144 = this.f557930a.read();
        BaseType r145 = BaseType.getType(r144);
        if (r145 == null) goto L50;
        int r146 = r139;
        r140[r142] = new c(r144, r143, i.f(this.f557930a, r145, this.f557931b));
        int r147 = this.f557931b;
        r141 = r141 + ((r147 + 1) + r145.getSize(r147));
        r142 = r142 + 1;
        r139 = r146;
        goto L45
    L50:
        throw new IllegalStateException("accept class failed, lost type def of typeId: " + r144);
    L51:
        int r148 = i.c(this.f557930a);
        c[] r149 = new c[r148];
        int r150 = r141 + 2;
        int r151 = 0;
    L52:
        if (r151 >= r148) goto L54;
        r149[r151] = new c(this.f557930a.read(), i.e(this.f557930a, this.f557931b), null);
        r150 = r150 + (this.f557931b + 1);
        r151 = r151 + 1;
        r148 = r148;
        goto L52
    L54:
        r138.c(r126, r127, r128, r129, r130, r140, r149);
        r105 = r150;
        r103 = r138;
        goto L68
    L22:
        e r152 = i.e(this.f557930a, this.f557931b);
        i.a(this.f557930a);
        i.a(this.f557930a);
        r101.m(r152);
        r108 = this.f557931b;
    L30:
        r103 = r101;
        goto L56
    L23:
        r101.b(r102, i.e(this.f557930a, this.f557931b));
        r104 = this.f557931b;
        goto L32
    L24:
        e r153 = i.e(this.f557930a, this.f557931b);
        i.a(this.f557930a);
        r101.l(r153);
        r106 = this.f557931b;
    L27:
        r103 = r101;
        goto L64
    L25:
        r101.b(r102, i.e(this.f557930a, this.f557931b));
        r104 = this.f557931b;
        goto L32
    L26:
        e r154 = i.e(this.f557930a, this.f557931b);
        i.a(this.f557930a);
        r101.i(r154);
        r106 = this.f557931b;
        goto L27
    L28:
        e r155 = i.e(this.f557930a, this.f557931b);
        i.a(this.f557930a);
        i.a(this.f557930a);
        r101.f(r155);
        r108 = this.f557931b;
        goto L30
    L29:
        e r156 = i.e(this.f557930a, this.f557931b);
        i.a(this.f557930a);
        i.a(this.f557930a);
        r101.g(r156);
        r108 = this.f557931b;
        goto L30
    L31:
        r101.b(r102, i.e(this.f557930a, this.f557931b));
        i.g(this.f557930a, this.f557931b);
        r104 = this.f557931b << 1;
        goto L32
    L62:
        r103 = r101;
        r103.b(r102, i.e(this.f557930a, this.f557931b));
        r104 = this.f557931b;
        goto L67
    L69:
        r101.a();
    }
}
