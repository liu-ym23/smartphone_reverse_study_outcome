package mc5;

import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
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

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f513132J;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f513133a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public String f513134a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f513135b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public String f513136b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f513137c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f513138c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f513139d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public String f513140d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f513141e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public String f513142e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f513143f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public String f513144f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f513145g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f513146g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f513147h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f513148h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f513149i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f513150i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f513151j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public String f513152j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f513153k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f513154k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f513155l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public String f513156l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f513157m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f513158m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f513159n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public String f513160n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f513161o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f513162o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f513163p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f513164p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f513165q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public String f513166q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f513167r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public String f513168r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f513169s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public String f513170s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f513171t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public String f513172t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f513173u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public String f513174u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f513175v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public String f513176v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f513177w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public String f513178w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f513179x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public String f513180x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f513181y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f513182y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f513183z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public String f513184z0;

    public u1() {
        this.X = "";
        this.f513134a0 = "";
    }

    public String getType() {
        return this.f513137c;
    }

    public static Document a(u1 r100) {
        Document r101 = new Document();
        r101.f227873d = r100.f513133a;
        r101.f227868a = r100.f513135b;
        r101.f227869b = yu5.c.f(r100.getType(), -1);
        r101.f227874e = r100.f513139d;
        r101.f227875f = r100.f513141e;
        String r102 = r100.f513143f;
        r101.f227896r = r102;
        r101.f227897s = r102;
        r101.f227876g = r100.f513145g;
        r101.f227882i = r100.f513147h;
        r101.f227891p = r100.f513149i;
        r101.f227899u = r100.f513151j;
        r101.f227910z = r100.f513153k;
        r101.L = r100.f513155l;
        r101.A = r100.f513157m;
        r101.f227887l = r100.f513140d0;
        r101.H = r100.f513159n;
        r101.I = r100.f513161o;
        r101.f227867J = r100.f513163p;
        r101.K = r100.f513165q;
        r101.S = r100.f513167r;
        r101.f227889n = r100.f513169s;
        r101.f227904x = r100.f513171t;
        r101.f227907y = r100.B0;
        r101.F = r100.f513173u;
        r101.G = r100.f513175v;
        r101.L0 = r100.f513177w;
        r101.f227883j = r100.f513179x;
        r101.M = r100.f513142e0;
        r101.N = r100.f513144f0;
        r101.V0 = r100.f513181y;
        r101.f227870b1 = r100.f513183z;
        r101.f227877g1 = r100.A;
        r101.f227880h1 = r100.B;
        r101.U = r100.C;
        r101.T = r100.D;
        r101.P1 = r100.R;
        r101.Z = r100.E;
        Document.DocumentIcon r103 = r101.f227886k1;
        r103.f227911a = r100.G;
        r103.f227912b = r100.H;
        r103.f227913c = r100.I;
        r101.f227903w = x1.a(r100.K);
        r101.f227909y2 = r100.W;
        r101.E2 = r100.f513174u0;
        r101.F2 = r100.A0;
        r101.P = r100.P;
        r101.H2 = r100.C0;
        r101.f227872c = r100.X;
        String r104 = r100.Y;
        r101.O = r104;
        r101.M2 = com.bytedance.ee.bear.list.u.b(r104);
        r101.f227888m = r100.Z;
        r101.f227898t = r100.f513134a0;
        r101.V = r100.f513136b0;
        r101.f227885k0 = r100.f513138c0;
        r101.f227893p1 = r100.f513146g0;
        r101.f227901v1 = r100.f513148h0;
        r101.f227895q = r100.F;
        r101.f227905x1 = r100.f513132J;
        r101.f227908y1 = r100.M;
        r101.G1 = r100.N;
        r101.H1 = r100.O;
        r101.L1 = r100.Q;
        int r105 = r100.f513150i0;
        r101.M1 = r105;
        r101.T1 = r100.S;
        r101.V1 = r100.T;
        r101.f227890o = r100.f513166q0;
        r101.Y = r100.f513168r0;
        r101.X = r100.f513170s0;
        r101.W = r100.f513172t0;
        r101.P0 = r100.f513164p0;
        r101.f227878g2 = r100.V;
        if (NodeType.isShortcut(r105) == false) goto L5;
        r101.f227868a = r100.f513152j0;
        r101.f227896r = r100.f513154k0;
        r101.f227897s = r100.f513156l0;
        r101.f227881h2 = r100.f513158m0;
        r101.f227894p2 = r100.f513160n0;
        r101.f227902v2 = r100.f513162o0;
        r101.f227895q = r100.f513184z0;
        r101.f227877g1 = r100.f513180x0;
        r101.f227870b1 = r100.f513178w0;
        r101.f227880h1 = r100.f513182y0;
        r101.V0 = r100.f513176v0;
    L6:
        return r101;
    L5:
        r101.f227871b2 = r100.U;
        goto L6
    }

    public static ArrayList<Document> b(List<u1> r100) {
        ArrayList<Document> r101 = new ArrayList();
        if (hu5.a.d(r100) == false) goto L5;
        return r101;
    L5:
        Iterator<u1> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        Document r103 = a(r102.next());
        if (h(r103) == false) goto L7;
        r101.add(r103);
        goto L7
    L11:
        return r101;
    }

    public static b c(Document r100) {
        b r101 = new b();
        r101.f512887a = r100.f227873d;
        r101.f512891c = String.valueOf(r100.getType());
        r101.f512895e = r100.f227875f;
        r101.f512902j = r100.f227891p;
        r101.f512903k = r100.f227899u;
        r101.f512904l = r100.f227910z;
        r101.f512905m = r100.L;
        r101.f512906n = r100.B;
        r101.f512907o = r100.H;
        r101.f512908p = r100.I;
        r101.f512909q = r100.f227867J;
        r101.f512910r = r100.K;
        r101.f512911s = r100.S;
        r101.f512912t = r100.f227889n;
        r101.f512913u = r100.f227904x;
        r101.f512894d0 = r100.f227907y;
        r101.f512914v = r100.F;
        r101.f512915w = r100.G;
        r101.f512916x = r100.L0;
        r101.f512918z = r100.V0;
        r101.A = r100.f227870b1;
        r101.B = r100.f227877g1;
        r101.C = r100.f227880h1;
        r101.D = r100.U;
        r101.F = r100.T;
        r101.I = r100.Z;
        r101.f512892c0 = r100.F2;
        Document.DocumentIcon r102 = r100.f227886k1;
        r101.K = r102.f227911a;
        r101.L = r102.f227912b;
        r101.M = r102.f227913c;
        r101.f512886J = r100.f227895q;
        r101.N = r100.f227905x1;
        r101.Q = r100.f227908y1;
        r101.R = r100.G1;
        r101.S = r100.a();
        r101.T = r100.L1;
        r101.U = r100.P1;
        r101.V = r100.T1;
        r101.W = r100.V1;
        r101.Y = r100.f227878g2;
        r101.Z = r100.f227909y2;
        r101.f512888a0 = r100.E2;
        r101.f512890b0 = r100.P;
        r101.f512896e0 = r100.H2;
        if (NodeType.isShortcut(r100.M1) == false) goto L5;
        r101.f512898f0 = true;
    L6:
        return r101;
    L5:
        r101.f512889b = r100.f227868a;
        String r103 = r100.f227896r;
        r101.f512897f = r103;
        r101.f512899g = r103;
        r101.f512893d = r100.f227874e;
        r101.f512900h = r100.f227876g;
        r101.f512917y = r100.f227883j;
        r101.f512901i = r100.f227882i;
        r101.X = r100.f227871b2;
        goto L6
    }

    public static ArrayList<b> g(List<Document> r100) {
        ArrayList<b> r101 = new ArrayList();
        if (hu5.a.d(r100) == false) goto L5;
        return r101;
    L5:
        Iterator<Document> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r101.add(c(r102.next()));
        goto L7
    L9:
        return r101;
    }

    public static boolean h(Document r100) {
        if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == false) goto L5;
        return true;
    L5:
        int r101 = r100.getType();
        int r102 = r100.f227908y1;
        if (r102 <= 0) goto L9;
        r101 = r102;
    L9:
        if (r101 != 113) goto L11;
    L13:
        return false;
    L11:
        if (r101 == 114) goto L13;
        return true;
    }

    public static ArrayList<v1> e(List<Document> r100, int r101) {
        ArrayList<v1> r102 = new ArrayList();
        if (hu5.a.d(r100) == false) goto L5;
        return r102;
    L5:
        Iterator<Document> r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r102.add(f(r103.next(), r101));
        goto L7
    L9:
        return r102;
    }

    public static v1 f(Document r100, int r101) {
        v1 r102 = new v1();
        r102.f513185a = r100.f227873d;
        r102.f513186b = r101;
        String r103 = r100.f227872c;
        r102.f513187c = r103;
        if (r103 != null) goto L5;
        r102.f513187c = "";
    L5:
        String r104 = r100.f227898t;
        r102.f513190f = r104;
        if (r104 != null) goto L8;
        r102.f513190f = "";
    L8:
        r102.f513188d = r100.O;
        r102.f513189e = r100.f227888m;
        r102.f513191g = r100.V;
        r102.f513193i = r100.f227887l;
        r102.f513194j = r100.M;
        r102.f513195k = r100.N;
        r102.f513192h = r100.f227885k0;
        r102.f513196l = r100.f227893p1;
        r102.f513197m = r100.f227901v1;
        int r105 = r100.M1;
        r102.f513198n = r105;
        r102.f513205u = r100.P0;
        r102.f513206v = r100.f227890o;
        r102.f513209y = r100.W;
        r102.f513208x = r100.X;
        r102.f513207w = r100.Y;
        r102.E = r100.G2;
        if (NodeType.isShortcut(r105) == false) goto L11;
        r102.f513199o = r100.f227868a;
        r102.f513200p = r100.f227896r;
        r102.f513201q = r100.f227897s;
        r102.f513202r = r100.f227881h2;
        r102.f513203s = r100.f227894p2;
        r102.f513204t = r100.f227902v2;
        r102.C = r100.f227880h1;
        r102.D = r100.f227895q;
        r102.A = r100.f227870b1;
        r102.B = r100.f227877g1;
        r102.f513210z = r100.V0;
    L11:
        return r102;
    }

    public static ArrayList<c> d(List<Document> r100, int r101, FolderSortStrategy r102) {
        ArrayList<c> r103 = new ArrayList();
        if (r102 != null) goto L5;
    L14:
        return r103;
    L5:
        if (hu5.a.d(r100) == true) goto L14;
        Iterator<Document> r104 = r100.iterator();
        int r105 = 1;
    L9:
        if (r104.hasNext() == false) goto L14;
        Document r106 = r104.next();
        v1 r107 = f(r106, r101);
        c r108 = new c();
        r108.f512944a = r101;
        r108.f512945b = r102.getType();
        r108.f512946c = r102.f227682c;
        r108.f512947d = r102.f227684e;
        r108.f512948e = r102.f227685f;
        r108.f512950g = r102.f227680a;
        r108.f512949f = r106.f227873d;
        r108.f512951h = r107.f513187c;
        r108.f512952i = r107.f513188d;
        r108.f512953j = r107.f513189e;
        r108.f512954k = r107.f513191g;
        r108.f512955l = r107.f513192h;
        r108.f512956m = r107.f513193i;
        r108.f512957n = r107.f513194j;
        r108.f512958o = r107.f513195k;
        r108.f512959p = r107.f513196l;
        r108.f512960q = r107.f513197m;
        int r109 = r106.M1;
        r108.f512961r = r109;
        r108.f512967x = r106.P0;
        r108.f512968y = r106.f227890o;
        r108.B = r106.W;
        r108.f512969z = r106.Y;
        r108.A = r106.X;
        r108.I = r106.F2;
        if (NodeType.isShortcut(r109) == false) goto L13;
        r108.f512962s = r106.f227868a;
        r108.f512963t = r106.f227896r;
        r108.f512964u = r106.f227897s;
        r108.f512965v = r106.f227881h2;
        r108.f512966w = r106.f227894p2;
        r108.F = r106.f227880h1;
        r108.G = r106.f227895q;
        r108.C = r106.V0;
        r108.D = r106.f227870b1;
        r108.E = r106.f227877g1;
    L13:
        r108.H = r105;
        r103.add(r108);
        r105 = r105 + 1;
        goto L9
    }
}
