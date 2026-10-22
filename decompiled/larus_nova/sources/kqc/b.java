package kqc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f505674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f505675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Integer, Integer> f505676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f505677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f505678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f505679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f505680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f505681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f505682i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f505683j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int[] f505684k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f505685l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f505686m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f505687n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f505688o;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f505689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f505690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f505691c;

        public final void a() {
            int[] r100 = this.f505689a;
            int r101 = r100.length;
            int r102 = this.f505690b;
            int r103 = r101 - r102;
            if (r103 > 2) goto L6;
            int[] r104 = new int[(r100.length + r103) * 2];
            System.arraycopy(r100, 0, r104, 0, r102);
            this.f505689a = r104;
        L6:
            int r105 = this.f505690b;
            int[] r106 = this.f505689a;
            r106[r105] = 0;
            r106[r105 + 1] = 0;
            this.f505690b = r105 + 2;
            this.f505691c++;
        }

        public a() {
            this.f505689a = new int[32];
        }
    }

    public final void a() throws IOException {
        int r100 = 3;
        if (this.f505679f == true) goto L12;
        int r101 = this.f505678e.readInt();
        if (r101 != 524291) goto L7;
    L11:
        this.f505678e.skipBytes(4);
        n.a(this.f505678e);
        this.f505681h.a();
        this.f505679f = true;
        goto L12
    L7:
        if (r101 == 524289) goto L11;
        throw new IOException(String.format("Expected: 0x%08x or 0x%08x, got: 0x%08x", new Object[]{524291, 524289, Integer.valueOf(r101)}));
    L12:
        int r102 = this.f505683j;
        if (r102 != this.f505685l) goto L15;
        return;
    L15:
        int r103 = -1;
        this.f505683j = -1;
        this.f505684k = null;
    L17:
        if (this.f505682i == false) goto L26;
        this.f505682i = false;
        a r104 = this.f505681h;
        int r105 = r104.f505690b;
        if (r105 == 0) goto L26;
        int r110 = r105 - 1;
        int r111 = r104.f505689a[r110] * 2;
        if (((r110 + r103) - r111) == 0) goto L26;
        r104.f505690b = r105 - (r111 + 2);
        r104.f505691c += r103;
    L26:
        if (r102 != this.f505687n) goto L36;
        a r106 = this.f505681h;
        if (r106.f505691c != 1) goto L36;
        int r107 = r106.f505690b;
        if (r107 != 0) goto L32;
        int r108 = 0;
    L33:
        if (r108 != 0) goto L36;
        this.f505683j = this.f505685l;
        return;
    L32:
        r108 = r106.f505689a[r107 - 1];
    L36:
        if (r102 != 0) goto L38;
        int r109 = 1048834;
    L40:
        if (r109 == 524672) goto L41;
        if (r109 < 1048832) goto L133;
        if (r109 > 1048836) goto L133;
        if (r109 != 1048834) goto L67;
        if (r102 != r103) goto L67;
        this.f505683j = 0;
        return;
    L67:
        this.f505678e.skipBytes(4);
        this.f505678e.readInt();
        this.f505678e.skipBytes(4);
        if (r109 != 1048832) goto L70;
    L116:
        if (r109 != 1048832) goto L125;
        int r112 = this.f505678e.readInt();
        int r113 = this.f505678e.readInt();
        a r114 = this.f505681h;
        if (r114.f505691c != 0) goto L120;
        r114.a();
    L120:
        int[] r115 = r114.f505689a;
        int r116 = r115.length;
        int r117 = r114.f505690b;
        int r118 = r116 - r117;
        if (r118 > 2) goto L124;
        int[] r119 = new int[(r115.length + r118) * 2];
        System.arraycopy(r115, 0, r119, 0, r117);
        r114.f505689a = r119;
    L124:
        int r120 = r114.f505690b;
        int r121 = r120 - 1;
        int[] r122 = r114.f505689a;
        int r123 = r122[r121];
        int r124 = (r121 - 1) - (r123 * 2);
        int r125 = r123 + 1;
        r122[r124] = r125;
        r122[r121] = r112;
        r122[r121 + 1] = r113;
        r122[r121 + 2] = r125;
        r114.f505690b = r120 + 2;
    L127:
        r103 = -1;
        goto L17
    L125:
        this.f505678e.skipBytes(4);
        this.f505678e.skipBytes(4);
        a r126 = this.f505681h;
        int r127 = r126.f505690b;
        if (r127 == 0) goto L127;
        int r128 = r127 - 1;
        int[] r129 = r126.f505689a;
        int r130 = r129[r128];
        if (r130 == 0) goto L127;
        int r131 = r130 - 1;
        int r132 = r128 - 2;
        r129[r132] = r131;
        r129[r132 - ((r131 * 2) + 1)] = r131;
        r126.f505690b = r127 - 2;
        goto L127
    L70:
        if (r109 == 1048833) goto L116;
        if (r109 == 1048834) goto L73;
        if (r109 == 1048835) goto L112;
        if (r109 != 1048836) goto L127;
        this.f505678e.readInt();
        this.f505678e.skipBytes(4);
        this.f505678e.skipBytes(4);
        this.f505683j = this.f505688o;
        return;
    L112:
        this.f505678e.readInt();
        this.f505678e.readInt();
        this.f505683j = this.f505687n;
        this.f505682i = true;
        return;
    L73:
        this.f505678e.readInt();
        this.f505678e.readInt();
        this.f505678e.skipBytes(4);
        int r133 = this.f505678e.readInt() & 65535;
        this.f505678e.readInt();
        int r134 = m.a(this.f505678e);
        i r135 = this.f505678e;
        int r136 = r133 * 5;
        r135.getClass();
        int[] r137 = new int[r136];
        int r138 = 0;
    L74:
        if (r138 >= r136) goto L76;
        r137[r138] = r135.readInt();
        r138 = r138 + 1;
        goto L74
    L76:
        this.f505684k = r137;
    L77:
        int[] r139 = this.f505684k;
        if (r100 >= r139.length) goto L81;
        r139[r100] = r139[r100] >>> 24;
        r100 = r100 + 5;
        goto L77
    L81:
        if (r139.length != r136) goto L109;
        int r140 = 0;
        boolean r141 = false;
    L83:
        if (r140 >= r133) goto L92;
        int r142 = r140 * 5;
        if (this.f505676c.containsKey(Integer.valueOf(this.f505684k[r142 + 1])) == false) goto L87;
        r141 = true;
    L87:
        int[] r143 = this.f505684k;
        int r144 = r143[r142 + 3];
        if (r144 == 1) goto L90;
        if (r144 == 2) goto L90;
    L91:
        r140 = r140 + 1;
    L90:
        int r145 = r142 + 4;
        m.c(this.f505675b, r143[r145], (r145 * 4) + r134, this.f505674a);
        goto L91
    L92:
        if (r141 == true) goto L94;
    L107:
        this.f505681h.a();
        this.f505683j = this.f505686m;
        return;
    L94:
        if (this.f505677d == false) goto L107;
        byte[] r146 = this.f505675b;
        int[] r147 = this.f505684k;
        HashMap<Integer, Integer> r148 = this.f505676c;
        HashMap r149 = new HashMap();
        HashMap r150 = new HashMap();
        int r151 = 0;
        int r152 = -1;
    L96:
        if (r151 >= r133) goto L103;
        int r153 = r151 * 5;
        int r154 = r147[r153 + 1];
        if (r148.containsKey(Integer.valueOf(r154)) == false) goto L102;
        if (r152 != r103) goto L101;
        r152 = r151;
    L101:
        int r155 = (r153 * 4) + r134;
        r149.put(Integer.valueOf(r151), Arrays.copyOfRange(r146, r155, r155 + 20));
        r150.put(Integer.valueOf(r148.get(Integer.valueOf(r154)).intValue()), Integer.valueOf(r151));
    L102:
        r151 = r151 + 1;
        r103 = -1;
        goto L96
    L103:
        ArrayList r156 = new ArrayList(r150.keySet());
        Collections.sort(r156);
        Iterator r157 = r156.iterator();
        int r158 = 0;
    L105:
        if (r157.hasNext() == false) goto L107;
        byte[] r159 = (byte[]) r149.get(Integer.valueOf(((Integer) r150.get((Integer) r157.next())).intValue()));
        System.arraycopy(r159, 0, r146, (((r158 + r152) * 5) * 4) + r134, r159.length);
        r158 = r158 + 1;
        goto L105
    L109:
        throw new RuntimeException();
    L133:
        throw new IOException("Invalid chunk type (" + r109 + ").");
    L41:
        this.f505676c.clear();
        int r160 = this.f505678e.readInt();
        if (r160 < 8) goto L59;
        if ((r160 % 4) != 0) goto L59;
        int r161 = m.a(this.f505678e);
        i r162 = this.f505678e;
        int r163 = (r160 / 4) - 2;
        r162.getClass();
        int[] r164 = new int[r163];
        int r165 = 0;
    L46:
        if (r165 >= r163) goto L48;
        r164[r165] = r162.readInt();
        r165 = r165 + 1;
        goto L46
    L48:
        this.f505680g = r164;
        ArrayList r166 = new ArrayList();
        int r167 = 0;
    L49:
        int[] r168 = this.f505680g;
        if (r167 >= r168.length) goto L55;
        int r169 = m.c(this.f505675b, r168[r167], (r167 * 4) + r161, this.f505674a);
        if (r169 < 2130706432) goto L54;
        this.f505676c.put(Integer.valueOf(r167), Integer.valueOf(r169));
        r166.add(Integer.valueOf(r169));
    L54:
        r167 = r167 + 1;
        goto L49
    L55:
        ArrayList r170 = new ArrayList(r166);
        Collections.sort(r170);
        if (r166.equals(r170) == true) goto L17;
        this.f505677d = true;
    L59:
        throw new IOException("Invalid resource ids size (" + r160 + ").");
    L38:
        r109 = this.f505678e.readInt();
        goto L40
    }

    public b(byte[] r100, d r101) {
        this.f505676c = new HashMap();
        this.f505677d = false;
        this.f505679f = false;
        this.f505681h = new a();
        this.f505685l = 1;
        this.f505686m = 2;
        this.f505687n = 3;
        this.f505688o = 4;
        this.f505674a = r101;
        this.f505675b = r100;
        this.f505683j = -1;
        this.f505684k = null;
    }
}
