package mc5;

import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u1 {
    public String A;
    public String A0;
    public int B;
    public boolean B0;
    public int C;
    public boolean C0;
    public int D;
    public String E;
    public String F;
    public String G;
    public int H;
    public String I;
    public String J;
    public int K;
    public boolean L;
    public int M;
    public String N;
    public String O;
    public String P;
    public int Q;
    public boolean R;
    public String S;
    public int T;
    public boolean U;
    public int V;
    public boolean W;
    public String X;
    public String Y;
    public String Z;
    public String a;
    public String a0;
    public String b;
    public String b0;
    public String c;
    public boolean c0;
    public String d;
    public String d0;
    public String e;
    public String e0;
    public String f;
    public String f0;
    public String g;
    public boolean g0;
    public String h;
    public boolean h0;
    public String i;
    public int i0;
    public String j;
    public String j0;
    public boolean k;
    public String k0;
    public boolean l;
    public String l0;
    public boolean m;
    public int m0;
    public String n;
    public String n0;
    public String o;
    public int o0;
    public String p;
    public boolean p0;
    public int q;
    public String q0;
    public boolean r;
    public String r0;
    public boolean s;
    public String s0;
    public boolean t;
    public String t0;
    public String u;
    public String u0;
    public long v;
    public String v0;
    public boolean w;
    public String w0;
    public String x;
    public String x0;
    public String y;
    public int y0;
    public String z;
    public String z0;

    public u1() {
        this.X = "";
        this.a0 = "";
    }

    public String getType() {
        return this.c;
    }

    public static Document a(u1 r3) {
        Document r0 = new Document();
        r0.d = r3.a;
        r0.a = r3.b;
        r0.b = yu5.c.f(r3.getType(), -1);
        r0.e = r3.d;
        r0.f = r3.e;
        String r1 = r3.f;
        r0.r = r1;
        r0.s = r1;
        r0.g = r3.g;
        r0.i = r3.h;
        r0.p = r3.i;
        r0.u = r3.j;
        r0.z = r3.k;
        r0.L = r3.l;
        r0.A = r3.m;
        r0.l = r3.d0;
        r0.H = r3.n;
        r0.I = r3.o;
        r0.J = r3.p;
        r0.K = r3.q;
        r0.S = r3.r;
        r0.n = r3.s;
        r0.x = r3.t;
        r0.y = r3.B0;
        r0.F = r3.u;
        r0.G = r3.v;
        r0.L0 = r3.w;
        r0.j = r3.x;
        r0.M = r3.e0;
        r0.N = r3.f0;
        r0.V0 = r3.y;
        r0.b1 = r3.z;
        r0.g1 = r3.A;
        r0.h1 = r3.B;
        r0.U = r3.C;
        r0.T = r3.D;
        r0.P1 = r3.R;
        r0.Z = r3.E;
        Document.DocumentIcon r2 = r0.k1;
        r2.a = r3.G;
        r2.b = r3.H;
        r2.c = r3.I;
        r0.w = x1.a(r3.K);
        r0.y2 = r3.W;
        r0.E2 = r3.u0;
        r0.F2 = r3.A0;
        r0.P = r3.P;
        r0.H2 = r3.C0;
        r0.c = r3.X;
        String r4 = r3.Y;
        r0.O = r4;
        r0.M2 = com.bytedance.ee.bear.list.u.b(r4);
        r0.m = r3.Z;
        r0.t = r3.a0;
        r0.V = r3.b0;
        r0.k0 = r3.c0;
        r0.p1 = r3.g0;
        r0.v1 = r3.h0;
        r0.q = r3.F;
        r0.x1 = r3.J;
        r0.y1 = r3.M;
        r0.G1 = r3.N;
        r0.H1 = r3.O;
        r0.L1 = r3.Q;
        int r5 = r3.i0;
        r0.M1 = r5;
        r0.T1 = r3.S;
        r0.V1 = r3.T;
        r0.o = r3.q0;
        r0.Y = r3.r0;
        r0.X = r3.s0;
        r0.W = r3.t0;
        r0.P0 = r3.p0;
        r0.g2 = r3.V;
        if (NodeType.isShortcut(r5) == false) goto L5;
        r0.a = r3.j0;
        r0.r = r3.k0;
        r0.s = r3.l0;
        r0.h2 = r3.m0;
        r0.p2 = r3.n0;
        r0.v2 = r3.o0;
        r0.q = r3.z0;
        r0.g1 = r3.x0;
        r0.b1 = r3.w0;
        r0.h1 = r3.y0;
        r0.V0 = r3.v0;
    L6:
        return r0;
    L5:
        r0.b2 = r3.U;
        goto L6
    }

    public static ArrayList<Document> b(List<u1> r3) {
        ArrayList<Document> r0 = new ArrayList();
        if (hu5.a.d(r3) == false) goto L5;
        return r0;
    L5:
        Iterator<u1> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        Document r1 = a(r4.next());
        if (h(r1) == false) goto L7;
        r0.add(r1);
        goto L7
    L11:
        return r0;
    }

    public static b c(Document r3) {
        b r0 = new b();
        r0.a = r3.d;
        r0.c = String.valueOf(r3.getType());
        r0.e = r3.f;
        r0.j = r3.p;
        r0.k = r3.u;
        r0.l = r3.z;
        r0.m = r3.L;
        r0.n = r3.B;
        r0.o = r3.H;
        r0.p = r3.I;
        r0.q = r3.J;
        r0.r = r3.K;
        r0.s = r3.S;
        r0.t = r3.n;
        r0.u = r3.x;
        r0.d0 = r3.y;
        r0.v = r3.F;
        r0.w = r3.G;
        r0.x = r3.L0;
        r0.z = r3.V0;
        r0.A = r3.b1;
        r0.B = r3.g1;
        r0.C = r3.h1;
        r0.D = r3.U;
        r0.F = r3.T;
        r0.I = r3.Z;
        r0.c0 = r3.F2;
        Document.DocumentIcon r1 = r3.k1;
        r0.K = r1.a;
        r0.L = r1.b;
        r0.M = r1.c;
        r0.J = r3.q;
        r0.N = r3.x1;
        r0.Q = r3.y1;
        r0.R = r3.G1;
        r0.S = r3.a();
        r0.T = r3.L1;
        r0.U = r3.P1;
        r0.V = r3.T1;
        r0.W = r3.V1;
        r0.Y = r3.g2;
        r0.Z = r3.y2;
        r0.a0 = r3.E2;
        r0.b0 = r3.P;
        r0.e0 = r3.H2;
        if (NodeType.isShortcut(r3.M1) == false) goto L5;
        r0.f0 = true;
    L6:
        return r0;
    L5:
        r0.b = r3.a;
        String r2 = r3.r;
        r0.f = r2;
        r0.g = r2;
        r0.d = r3.e;
        r0.h = r3.g;
        r0.y = r3.j;
        r0.i = r3.i;
        r0.X = r3.b2;
        goto L6
    }

    public static ArrayList<b> g(List<Document> r2) {
        ArrayList<b> r0 = new ArrayList();
        if (hu5.a.d(r2) == false) goto L5;
        return r0;
    L5:
        Iterator<Document> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r0.add(c(r3.next()));
        goto L7
    L9:
        return r0;
    }

    public static boolean h(Document r2) {
        if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == false) goto L5;
        return true;
    L5:
        int r0 = r2.getType();
        int r3 = r2.y1;
        if (r3 <= 0) goto L9;
        r0 = r3;
    L9:
        if (r0 != 113) goto L11;
    L13:
        return false;
    L11:
        if (r0 == 114) goto L13;
        return true;
    }

    public static ArrayList<v1> e(List<Document> r2, int r3) {
        ArrayList<v1> r0 = new ArrayList();
        if (hu5.a.d(r2) == false) goto L5;
        return r0;
    L5:
        Iterator<Document> r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r0.add(f(r4.next(), r3));
        goto L7
    L9:
        return r0;
    }

    public static v1 f(Document r2, int r3) {
        v1 r0 = new v1();
        r0.a = r2.d;
        r0.b = r3;
        String r4 = r2.c;
        r0.c = r4;
        if (r4 != null) goto L5;
        r0.c = "";
    L5:
        String r5 = r2.t;
        r0.f = r5;
        if (r5 != null) goto L8;
        r0.f = "";
    L8:
        r0.d = r2.O;
        r0.e = r2.m;
        r0.g = r2.V;
        r0.i = r2.l;
        r0.j = r2.M;
        r0.k = r2.N;
        r0.h = r2.k0;
        r0.l = r2.p1;
        r0.m = r2.v1;
        int r6 = r2.M1;
        r0.n = r6;
        r0.u = r2.P0;
        r0.v = r2.o;
        r0.y = r2.W;
        r0.x = r2.X;
        r0.w = r2.Y;
        r0.E = r2.G2;
        if (NodeType.isShortcut(r6) == false) goto L11;
        r0.o = r2.a;
        r0.p = r2.r;
        r0.q = r2.s;
        r0.r = r2.h2;
        r0.s = r2.p2;
        r0.t = r2.v2;
        r0.C = r2.h1;
        r0.D = r2.q;
        r0.A = r2.b1;
        r0.B = r2.g1;
        r0.z = r2.V0;
    L11:
        return r0;
    }

    public static ArrayList<c> d(List<Document> r7, int r8, FolderSortStrategy r9) {
        ArrayList<c> r0 = new ArrayList();
        if (r9 != null) goto L5;
    L14:
        return r0;
    L5:
        if (hu5.a.d(r7) == true) goto L14;
        Iterator<Document> r10 = r7.iterator();
        int r2 = 1;
    L9:
        if (r10.hasNext() == false) goto L14;
        Document r3 = r10.next();
        v1 r4 = f(r3, r8);
        c r5 = new c();
        r5.a = r8;
        r5.b = r9.getType();
        r5.c = r9.c;
        r5.d = r9.e;
        r5.e = r9.f;
        r5.g = r9.a;
        r5.f = r3.d;
        r5.h = r4.c;
        r5.i = r4.d;
        r5.j = r4.e;
        r5.k = r4.g;
        r5.l = r4.h;
        r5.m = r4.i;
        r5.n = r4.j;
        r5.o = r4.k;
        r5.p = r4.l;
        r5.q = r4.m;
        int r6 = r3.M1;
        r5.r = r6;
        r5.x = r3.P0;
        r5.y = r3.o;
        r5.B = r3.W;
        r5.z = r3.Y;
        r5.A = r3.X;
        r5.I = r3.F2;
        if (NodeType.isShortcut(r6) == false) goto L13;
        r5.s = r3.a;
        r5.t = r3.r;
        r5.u = r3.s;
        r5.v = r3.h2;
        r5.w = r3.p2;
        r5.F = r3.h1;
        r5.G = r3.q;
        r5.C = r3.V0;
        r5.D = r3.b1;
        r5.E = r3.g1;
    L13:
        r5.H = r2;
        r0.add(r5);
        r2 = r2 + 1;
        goto L9
    }
}
