package tk4;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: loaded from: classes15.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PthreadHandlerThreadV2 f546494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f546495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Deque<byte[]> f546496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f546497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f546498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f546499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f546500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f546501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f546502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f546503j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f546504k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f546505l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f546506m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f546507n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f546508o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f546509p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f546510q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f546511r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f546512s;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f546513a = null;

        static {
            f546513a = new k();
        }
    }

    public final void c() {
        pk4.j.a("DoraRtosPlayer", "txSendDataEnd");
        this.f546498e = false;
        ak4.a.d().g(2, 5, new byte[]{1, 1, 7});
    }

    public k() {
        this.f546496c = new ArrayDeque();
        this.f546497d = 0;
        this.f546498e = false;
        this.f546499f = 90;
        this.f546500g = 4;
        this.f546501h = 20;
        this.f546502i = 1;
        this.f546503j = 0;
        this.f546504k = 0;
        this.f546505l = false;
        this.f546506m = true;
        this.f546507n = false;
        this.f546508o = 0;
        this.f546509p = 0;
        this.f546510q = 0;
        this.f546511r = 0;
        this.f546512s = 1;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("DoraRtosPlayerThread", 0);
        this.f546494a = r100;
        ThreadMethodProxy.start(r100);
        this.f546495b = new j(this, this.f546494a.getLooper());
    }

    public static void a(l r110) {
        pk4.j.a("DoraRtosPlayer", "setAudioPlayerConfig");
        r110.getClass();
        byte r100 = (byte) 1;
        byte[] r101 = pk4.n.v(new byte[][]{new byte[]{1, 1, r100}, new byte[]{2, 1, (byte) 5}, new byte[]{3, 2}, pk4.n.k(24000), new byte[]{4, 1, r100}, new byte[]{5, 1, r100}, new byte[]{6, 1, (byte) 3}});
        byte[] r102 = r110.f546514a;
        byte[] r103 = null;
        if (r102 == null) goto L5;
        byte[] r104 = (byte[]) r102.clone();
    L6:
        if (r104 == null) goto L15;
        byte[][] r105 = new byte[3][];
        r105[0] = r101;
        byte[] r106 = new byte[2];
        r106[0] = 7;
        byte[] r107 = r110.f546514a;
        if (r107 == null) goto L10;
        byte[] r108 = (byte[]) r107.clone();
    L11:
        r106[1] = (byte) r108.length;
        r105[1] = r106;
        byte[] r111 = r110.f546514a;
        if (r111 == null) goto L14;
        r103 = (byte[]) r111.clone();
    L14:
        r105[2] = r103;
        r101 = pk4.n.v(r105);
        goto L15
    L10:
        r108 = null;
    L15:
        ak4.a.d().g(2, 5, pk4.n.u(new byte[]{-82, (byte) r101.length}, r101));
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static void d(boolean r100) {
        pk4.j.a("DoraRtosPlayer", "txSendPlayerPauseResume isResume: " + r100);
        if (r100 == false) goto L5;
        byte r101 = 10;
    L6:
        ak4.a.d().g(2, 5, new byte[]{1, 1, r101});
        return;
    L5:
        r101 = 9;
        goto L6
    }

    public final void b(boolean r100) {
        if (this.f546506m == true) goto L5;
    L16:
        pk4.j.a("DoraRtosPlayer", "Start sending PCM frames failed, isSendingAvailable=" + this.f546506m + ", isSending=" + this.f546505l);
        return;
    L5:
        if (this.f546505l == true) goto L16;
        if (this.f546495b == null) goto L16;
        this.f546505l = true;
        if (this.f546504k < 5) goto L15;
        if (r100 == false) goto L15;
        int r101 = this.f546501h;
        if (this.f546499f > 0) goto L14;
        pk4.j.a("DoraRtosPlayer", "Start sending PCM frames with delay fixed 100 ");
        r101 = 100;
    L14:
        pk4.j.a("DoraRtosPlayer", "Start sending PCM frames with delay = " + r101);
        this.f546495b.sendEmptyMessageDelayed(0, (long) r101);
        return;
    L15:
        pk4.j.a("DoraRtosPlayer", "Start sending PCM frames immediately");
        this.f546495b.sendEmptyMessage(0);
    }
}
