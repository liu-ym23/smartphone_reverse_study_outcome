package mc5;

import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public String A;
    public int B;
    public int C;
    public int D;
    public String E;
    public String F;
    public String G;
    public int H;
    public String I;
    public String J;
    public int K;
    public int L;
    public String M;
    public int N;
    public String O;
    public int P;
    public boolean Q;
    public int R;
    public String S;
    public String T;
    public String U;
    public String V;
    public String W;
    public String X;
    public boolean Y;
    public String Z;
    public String a;
    public String a0;
    public String b;
    public String b0;
    public String c;
    public boolean c0;
    public String d;
    public boolean d0;
    public String e;
    public int e0;
    public String f;
    public String f0;
    public String g;
    public String g0;
    public String h;
    public String h0;
    public String i;
    public int i0;
    public String j;
    public String j0;
    public boolean k;
    public boolean k0;
    public boolean l;
    public String l0;
    public boolean m;
    public String m0;
    public String n;
    public String n0;
    public String o;
    public String o0;
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
    public int u0;
    public long v;
    public String v0;
    public boolean w;
    public String w0;
    public String x;
    public boolean x0;
    public String y;
    public String z;

    public d() {
        this.S = "";
        this.T = "";
    }

    public String getType() {
        return this.c;
    }

    public static ArrayList<Document> a(List<d> r5) {
        ArrayList<Document> r0 = new ArrayList();
        if (hu5.a.d(r5) == false) goto L5;
        return r0;
    L5:
        Iterator<d> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L13;
        d r1 = r6.next();
        Document r2 = new Document();
        r2.d = r1.a;
        r2.a = r1.b;
        r2.b = CastIntegerProtector.parseInt(r1.getType());
        r2.e = r1.d;
        r2.f = r1.e;
        String r3 = r1.f;
        r2.r = r3;
        r2.s = r3;
        r2.g = r1.g;
        r2.i = r1.h;
        r2.p = r1.i;
        r2.u = r1.j;
        r2.z = r1.k;
        r2.L = r1.l;
        r2.A = r1.m;
        r2.l = r1.Z;
        r2.H = r1.n;
        r2.I = r1.o;
        r2.J = r1.p;
        r2.K = r1.q;
        r2.S = r1.r;
        r2.n = r1.s;
        r2.x = r1.t;
        r2.y = r1.x0;
        r2.F = r1.u;
        r2.G = r1.v;
        r2.L0 = r1.w;
        r2.j = r1.x;
        r2.M = r1.a0;
        r2.N = r1.b0;
        r2.V0 = r1.y;
        r2.b1 = r1.z;
        r2.g1 = r1.A;
        r2.h1 = r1.B;
        r2.U = r1.C;
        r2.T = r1.D;
        r2.Z = r1.E;
        Document.DocumentIcon r4 = r2.k1;
        r4.a = r1.G;
        r4.b = r1.H;
        r4.c = r1.I;
        r2.w = x1.a(r1.K);
        r2.F2 = r1.w0;
        r2.c = r1.T;
        String r7 = r1.U;
        r2.O = r7;
        r2.M2 = com.bytedance.ee.bear.list.u.b(r7);
        r2.P = r1.V;
        r2.m = r1.W;
        r2.t = r1.S;
        r2.V = r1.X;
        r2.k0 = r1.Y;
        r2.p1 = r1.c0;
        r2.v1 = r1.d0;
        r2.q = r1.F;
        r2.x1 = r1.J;
        r2.y1 = r1.L;
        r2.G1 = r1.M;
        r2.L1 = r1.N;
        int r8 = r1.e0;
        r2.M1 = r8;
        r2.P1 = r1.k0;
        r2.T1 = r1.O;
        r2.V1 = r1.P;
        r2.P0 = r1.p0;
        r2.o = r1.l0;
        r2.W = r1.o0;
        r2.X = r1.n0;
        r2.Y = r1.m0;
        r2.g2 = r1.R;
        if (NodeType.isShortcut(r8) == false) goto L11;
        r2.a = r1.f0;
        r2.r = r1.g0;
        r2.s = r1.h0;
        r2.h2 = r1.i0;
        r2.p2 = r1.j0;
        r2.V0 = r1.r0;
        r2.q = r1.v0;
        r2.h1 = r1.u0;
        r2.b1 = r1.s0;
        r2.g1 = r1.t0;
    L12:
        r2.H1 = r1.q0;
        r0.add(r2);
        goto L7
    L11:
        r2.b2 = r1.Q;
        goto L12
    L13:
        return r0;
    }
}
