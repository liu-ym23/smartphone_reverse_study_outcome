package mc5;

import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
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

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f512973J;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f512974a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public String f512975a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f512976b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public String f512977b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f512978c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f512979c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f512980d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f512981d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f512982e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f512983e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f512984f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public String f512985f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f512986g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public String f512987g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f512988h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public String f512989h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f512990i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f512991i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f512992j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public String f512993j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f512994k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f512995k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f512996l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public String f512997l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f512998m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public String f512999m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f513000n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public String f513001n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f513002o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public String f513003o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f513004p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f513005p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f513006q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public String f513007q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f513008r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public String f513009r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f513010s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public String f513011s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f513012t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public String f513013t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f513014u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f513015u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f513016v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public String f513017v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f513018w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public String f513019w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f513020x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f513021x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f513022y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f513023z;

    public d() {
        this.S = "";
        this.T = "";
    }

    public String getType() {
        return this.f512978c;
    }

    public static ArrayList<Document> a(List<d> r100) {
        ArrayList<Document> r101 = new ArrayList();
        if (hu5.a.d(r100) == false) goto L5;
        return r101;
    L5:
        Iterator<d> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L13;
        d r103 = r102.next();
        Document r104 = new Document();
        r104.f227873d = r103.f512974a;
        r104.f227868a = r103.f512976b;
        r104.f227869b = CastIntegerProtector.parseInt(r103.getType());
        r104.f227874e = r103.f512980d;
        r104.f227875f = r103.f512982e;
        String r105 = r103.f512984f;
        r104.f227896r = r105;
        r104.f227897s = r105;
        r104.f227876g = r103.f512986g;
        r104.f227882i = r103.f512988h;
        r104.f227891p = r103.f512990i;
        r104.f227899u = r103.f512992j;
        r104.f227910z = r103.f512994k;
        r104.L = r103.f512996l;
        r104.A = r103.f512998m;
        r104.f227887l = r103.Z;
        r104.H = r103.f513000n;
        r104.I = r103.f513002o;
        r104.f227867J = r103.f513004p;
        r104.K = r103.f513006q;
        r104.S = r103.f513008r;
        r104.f227889n = r103.f513010s;
        r104.f227904x = r103.f513012t;
        r104.f227907y = r103.f513021x0;
        r104.F = r103.f513014u;
        r104.G = r103.f513016v;
        r104.L0 = r103.f513018w;
        r104.f227883j = r103.f513020x;
        r104.M = r103.f512975a0;
        r104.N = r103.f512977b0;
        r104.V0 = r103.f513022y;
        r104.f227870b1 = r103.f513023z;
        r104.f227877g1 = r103.A;
        r104.f227880h1 = r103.B;
        r104.U = r103.C;
        r104.T = r103.D;
        r104.Z = r103.E;
        Document.DocumentIcon r106 = r104.f227886k1;
        r106.f227911a = r103.G;
        r106.f227912b = r103.H;
        r106.f227913c = r103.I;
        r104.f227903w = x1.a(r103.K);
        r104.F2 = r103.f513019w0;
        r104.f227872c = r103.T;
        String r107 = r103.U;
        r104.O = r107;
        r104.M2 = com.bytedance.ee.bear.list.u.b(r107);
        r104.P = r103.V;
        r104.f227888m = r103.W;
        r104.f227898t = r103.S;
        r104.V = r103.X;
        r104.f227885k0 = r103.Y;
        r104.f227893p1 = r103.f512979c0;
        r104.f227901v1 = r103.f512981d0;
        r104.f227895q = r103.F;
        r104.f227905x1 = r103.f512973J;
        r104.f227908y1 = r103.L;
        r104.G1 = r103.M;
        r104.L1 = r103.N;
        int r108 = r103.f512983e0;
        r104.M1 = r108;
        r104.P1 = r103.f512995k0;
        r104.T1 = r103.O;
        r104.V1 = r103.P;
        r104.P0 = r103.f513005p0;
        r104.f227890o = r103.f512997l0;
        r104.W = r103.f513003o0;
        r104.X = r103.f513001n0;
        r104.Y = r103.f512999m0;
        r104.f227878g2 = r103.R;
        if (NodeType.isShortcut(r108) == false) goto L11;
        r104.f227868a = r103.f512985f0;
        r104.f227896r = r103.f512987g0;
        r104.f227897s = r103.f512989h0;
        r104.f227881h2 = r103.f512991i0;
        r104.f227894p2 = r103.f512993j0;
        r104.V0 = r103.f513009r0;
        r104.f227895q = r103.f513017v0;
        r104.f227880h1 = r103.f513015u0;
        r104.f227870b1 = r103.f513011s0;
        r104.f227877g1 = r103.f513013t0;
    L12:
        r104.H1 = r103.f513007q0;
        r101.add(r104);
        goto L7
    L11:
        r104.f227871b2 = r103.Q;
        goto L12
    L13:
        return r101;
    }
}
