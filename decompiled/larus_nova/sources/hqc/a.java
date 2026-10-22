package hqc;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f486835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f486836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f486837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f486838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f486839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f486840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f486841g;

    public final void a() {
        if (this.f486839e == false) goto L13;
        this.f486839e = false;
        b r100 = this.f486837c;
        InputStream r101 = r100.f486842a;
        if (r101 != null) goto L11;
    L8:
        this.f486840f = null;
        this.f486837c = null;
        c r102 = this.f486841g;
        r102.f486844b = 0;
        r102.f486845c = 0;
        this.f486838d = null;
        this.f486835a = -1;
        return;
    L11:
        r101.close();     // Catch: IOException -> L10
    L7:
        r100.f486842a = null;
        goto L8
    }

    public final void b() throws IOException {
        if (this.f486840f != null) goto L22;
        this.f486837c.c(524291);
        this.f486837c.d();
        b r100 = this.f486837c;
        r100.c(1835009);
        int r101 = r100.a();
        int r102 = r100.a();
        int r103 = r100.a();
        r100.a();
        int r104 = r100.a();
        int r105 = r100.a();
        f r106 = new f();
        r106.f486848a = r100.b(r102);
        if (r103 == 0) goto L7;
        r100.b(r103);
    L7:
        if (r105 != 0) goto L9;
        int r107 = r101;
    L10:
        int r108 = r107 - r104;
        if ((r108 % 4) != 0) goto L21;
        r106.f486849b = r100.b(r108 / 4);
        if (r105 == 0) goto L19;
        int r109 = r101 - r105;
        if ((r109 % 4) != 0) goto L18;
        r100.b(r109 / 4);
        goto L19
    L18:
        throw new IOException();
    L19:
        this.f486840f = r106;
        this.f486841g.a();
        this.f486839e = true;
        goto L22
    L21:
        throw new IOException();
    L9:
        r107 = r105;
    L22:
        int r110 = this.f486835a;
        if (r110 != 1) goto L25;
        return;
    L25:
        this.f486838d = null;
        this.f486835a = -1;
    L27:
        if (this.f486836b == false) goto L33;
        this.f486836b = false;
        c r111 = this.f486841g;
        int r112 = r111.f486844b;
        if (r112 == 0) goto L33;
        int r113 = r112 - 1;
        int r114 = r111.f486843a[r113] * 2;
        if (((r113 - 1) - r114) == 0) goto L33;
        r111.f486844b = r112 - (r114 + 2);
        r111.f486845c--;
    L33:
        int r115 = 3;
        if (r110 != 3) goto L44;
        c r116 = this.f486841g;
        if (r116.f486845c != 1) goto L44;
        int r117 = r116.f486844b;
        if (r117 != 0) goto L40;
        int r118 = 0;
    L41:
        if (r118 != 0) goto L44;
        this.f486835a = 1;
        return;
    L40:
        r118 = r116.f486843a[r117 - 1];
    L44:
        if (r110 != 0) goto L46;
        int r119 = 1048834;
    L48:
        if (r119 == 524672) goto L49;
        if (r119 < 1048832) goto L97;
        if (r119 > 1048836) goto L97;
        if (r119 != 1048834) goto L63;
        if (r110 != (-1)) goto L63;
        this.f486835a = 0;
        return;
    L63:
        this.f486837c.d();
        this.f486837c.a();
        this.f486837c.d();
        if (r119 == 1048832) goto L81;
        if (r119 == 1048833) goto L81;
        if (r119 == 1048834) goto L69;
        if (r119 == 1048835) goto L76;
        if (r119 != 1048836) goto L27;
        this.f486837c.a();
        this.f486837c.d();
        this.f486837c.d();
        this.f486835a = 4;
        return;
    L76:
        this.f486837c.a();
        this.f486837c.a();
        this.f486835a = 3;
        this.f486836b = true;
        return;
    L69:
        this.f486837c.a();
        this.f486837c.a();
        this.f486837c.d();
        int r120 = this.f486837c.a() & 65535;
        this.f486837c.a();
        this.f486838d = this.f486837c.b(r120 * 5);
    L70:
        int[] r121 = this.f486838d;
        if (r115 >= r121.length) goto L73;
        r121[r115] = r121[r115] >>> 24;
        r115 = r115 + 5;
        goto L70
    L73:
        this.f486841g.a();
        this.f486835a = 2;
        return;
    L81:
        if (r119 == 1048832) goto L82;
        this.f486837c.d();
        this.f486837c.d();
        c r122 = this.f486841g;
        int r123 = r122.f486844b;
        if (r123 == 0) goto L27;
        int r124 = r123 - 1;
        int[] r125 = r122.f486843a;
        int r126 = r125[r124];
        if (r126 == 0) goto L27;
        int r127 = r126 - 1;
        int r128 = r124 - 2;
        r125[r128] = r127;
        r125[r128 - ((r127 * 2) + 1)] = r127;
        r122.f486844b = r123 - 2;
        goto L27
    L82:
        int r129 = this.f486837c.a();
        int r130 = this.f486837c.a();
        c r131 = this.f486841g;
        if (r131.f486845c != 0) goto L85;
        r131.a();
    L85:
        int[] r132 = r131.f486843a;
        int r133 = r132.length;
        int r134 = r131.f486844b;
        int r135 = r133 - r134;
        if (r135 > 2) goto L88;
        int[] r136 = new int[(r132.length + r135) * 2];
        System.arraycopy(r132, 0, r136, 0, r134);
        r131.f486843a = r136;
    L88:
        int r137 = r131.f486844b;
        int r138 = r137 - 1;
        int[] r139 = r131.f486843a;
        int r140 = r139[r138];
        int r141 = (r138 - 1) - (r140 * 2);
        int r142 = r140 + 1;
        r139[r141] = r142;
        r139[r138] = r129;
        r139[r138 + 1] = r130;
        r139[r138 + 2] = r142;
        r131.f486844b = r137 + 2;
    L97:
        throw new IOException("Invalid chunk type (" + r119 + ").");
    L49:
        int r143 = this.f486837c.a();
        if (r143 < 8) goto L55;
        if ((r143 % 4) != 0) goto L55;
        this.f486837c.b((r143 / 4) - 2);
    L55:
        throw new IOException("Invalid resource ids size (" + r143 + ").");
    L46:
        r119 = this.f486837c.a();
        goto L48
    }

    public a() {
        this.f486839e = false;
        this.f486841g = new c();
        this.f486838d = null;
        this.f486835a = -1;
    }

    public final int c(int r100) {
        if (this.f486835a != 2) goto L10;
        int r101 = r100 * 5;
        if (r101 >= this.f486838d.length) goto L8;
        return r101;
    L8:
        throw new IndexOutOfBoundsException("Invalid attribute index (" + r100 + ").");
    L10:
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }
}
