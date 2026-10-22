package ws3;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f560974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long[] f560975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long[] f560976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f560977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f560978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f560979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f560980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f560981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile long f560982i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f560983j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f560984k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile long f560985l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f560986m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public NetworkStatsManager f560987n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f560988o;

    /* JADX INFO: loaded from: classes14.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f560989a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f560989a.n();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(g r100) {
            this.f560989a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f560990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f560991b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f560991b.o();     // Catch: Throwable -> L4
            this.f560991b.f560986m = !this.f560990a;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(g r100, boolean r101) {
            this.f560991b = r100;
            this.f560990a = r101;
        }
    }

    @Override // ws3.e
    public final void init() {
        bt3.b r100 = bt3.b.d.f20539a;
        if (r100.c() == false) goto L5;
        n();
        return;
    L5:
        r100.e(new a(this));
    }

    public final void n() {
        if (this.f560974a == false) goto L5;
        return;
    L5:
        this.f560974a = true;
        this.f560975b = m(1);
        this.f560976c = m(0);
        this.f560985l = SystemClock.elapsedRealtime();
        if (com.bytedance.apm.d.j() == false) goto L9;
        av3.b.a("NewTrafficStatisticsImp", "initTrafficData: mTotalWifiBytes:" + this.f560975b[0] + " mTotalWifiPackets:" + this.f560975b[1] + " mTotalMobileBytes:" + this.f560976c[0] + " mTotalMobilePackets:" + this.f560976c[1]);
        return;
    }

    public final void o() {
        long r100 = SystemClock.elapsedRealtime();
        if ((r100 - this.f560985l) >= 1000) goto L5;
        return;
    L5:
        if (this.f560985l == (-1)) goto L21;
        long[] r101 = m(1);
        long[] r102 = m(0);
        long r103 = r102[0] - this.f560976c[0];
        long r104 = r102[1] - this.f560976c[1];
        this.f560976c = r102;
        long r110 = r101[0] - this.f560975b[0];
        long r111 = r101[1] - this.f560975b[1];
        this.f560975b = r101;
        if (com.bytedance.apm.d.j() == false) goto L10;
        String r105 = "NewTrafficStatisticsImp";
        av3.b.a(r105, "mTotalWifiBytes:" + this.f560975b[0] + " mTotalWifiPackets:" + this.f560975b[1] + " mTotalMobileBytes:" + this.f560976c[0] + " mTotalMobilePackets:" + this.f560976c[1]);
    L12:
        if (this.f560986m == false) goto L14;
        this.f560980g += r103;
        this.f560984k += r104;
        this.f560979f += r110;
        this.f560983j += r111;
    L16:
        if (com.bytedance.apm.d.j() == false) goto L18;
        av3.b.a(r105, "periodWifiBytes" + r110 + " periodMobileBytes:" + r103 + " mMobileBackBytes:" + this.f560978e + " mWifiBackBytes:" + this.f560977d);
    L18:
        this.f560985l = r100;
        return;
    L14:
        this.f560978e += r103;
        this.f560982i += r104;
        this.f560977d += r110;
        this.f560981h += r111;
        goto L16
    L10:
        r105 = "NewTrafficStatisticsImp";
        goto L12
    }

    public g() {
        this.f560974a = false;
        this.f560977d = 0;
        this.f560978e = 0;
        this.f560979f = 0;
        this.f560980g = 0;
        this.f560981h = 0;
        this.f560982i = 0;
        this.f560983j = 0;
        this.f560984k = 0;
        this.f560985l = -1;
        this.f560986m = true;
        this.f560988o = -1;
    }

    @Override // ws3.e
    public final long a() {
        o();
        return this.f560977d;
    }

    @Override // ws3.e
    public final long b() {
        o();
        return this.f560978e;
    }

    @Override // ws3.e
    public final long c() {
        o();
        return this.f560978e + this.f560977d;
    }

    @Override // ws3.e
    public final long e() {
        o();
        return this.f560977d + this.f560979f;
    }

    @Override // ws3.e
    public final long f() {
        o();
        return this.f560980g + this.f560979f;
    }

    @Override // ws3.e
    public final long g() {
        o();
        return this.f560978e + this.f560980g;
    }

    @Override // ws3.e
    public final long h() {
        o();
        return this.f560984k + this.f560983j;
    }

    @Override // ws3.e
    public final long i() {
        return g() + e();
    }

    @Override // ws3.e
    public final long j() {
        o();
        return this.f560979f;
    }

    @Override // ws3.e
    public final long k() {
        o();
        return this.f560982i + this.f560981h;
    }

    @Override // ws3.e
    public final long l() {
        o();
        return this.f560980g;
    }

    @Override // ws3.e
    public final void d(boolean r100) {
        bt3.b.d.f20539a.b(new b(this, r100));
    }

    public final long[] m(int r110) {
        Context r100 = com.bytedance.apm.d.getContext();
        if (this.f560987n != null) goto L6;
        this.f560987n = (NetworkStatsManager) r100.getApplicationContext().getSystemService("netstats");
    L6:
        if (this.f560987n == null) goto L8;
        NetworkStats.Bucket r111 = new NetworkStats.Bucket();
        NetworkStats r101 = this.f560987n.querySummary(r110, null, 0, 4611686018427387903L);     // Catch: Exception -> L12
    L14:
        NetworkStats r102 = r101;
        long r103 = 0;
        long r104 = 0;
        long r105 = 0;
        long r112 = 0;
    L15:
        if (r102 == null) goto L31;
        if (r102.hasNextBucket() == false) goto L31;
        r102.getNextBucket(r111);
        int r113 = r111.getUid();
        if (this.f560988o != (-1)) goto L28;
        PackageInfo r106 = r100.getApplicationContext().getPackageManager().getPackageInfo(r100.getApplicationContext().getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L25
        if (r106 == null) goto L28;
        this.f560988o = r106.applicationInfo.uid;     // Catch: PackageManager.NameNotFoundException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L28:
        if (this.f560988o != r113) goto L15;
        r103 = r103 + r111.getRxBytes();
        r104 = r104 + r111.getTxBytes();
        r105 = r105 + r111.getRxPackets();
        r112 = r112 + r111.getTxPackets();
    L31:
        if (r102 == null) goto L34;
        r102.close();
    L34:
        return new long[]{r103 + r104, r105 + r112};
    L12:
        e = move-exception;
        e.printStackTrace();
        r101 = null;
        goto L14
    L8:
        return new long[]{0, 0};
    }
}
