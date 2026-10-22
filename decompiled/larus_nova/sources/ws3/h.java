package ws3;

import android.os.Process;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PolarisFileWrapper f560992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f560993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f560994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f560995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f560996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f560997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f560998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f560999h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile long f561000i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f561001j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f561002k;

    @Override // ws3.e
    public final void d(boolean r100) {
    }

    @Override // ws3.e
    public final void init() {
        this.f560992a = new PolarisFileWrapper("/proc/net/xt_qtaguid/stats");
    }

    public final void m() {
        h this = this;
        if ((System.currentTimeMillis() - this.f560994c) >= 1000) goto L5;
        return;
    L5:
        this.f560994c = System.currentTimeMillis();
        int r100 = Process.myUid();
        if (this.f560992a == null) goto L24;
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L19
        BufferedReader r102 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper(this.f560992a), XML.CHARSET_UTF8));     // Catch: Throwable -> L19
        int r103 = 1;
    L89:
        String r104 = r102.readLine();     // Catch: Throwable -> L17
        if (r104 == null) goto L15;
        if (r103 < 0) goto L14;
        r101.add(r104);     // Catch: Throwable -> L17
    L14:
        r103 = r103 + 1;     // Catch: Throwable -> L17
        goto L89
    L15:
        ((CopyOnWriteArrayList) this.f560993b).clear();     // Catch: Throwable -> L17
        ((CopyOnWriteArrayList) this.f560993b).addAll(r101);     // Catch: Throwable -> L17
    L22:
        d27.d.a(r102);
    L17:
        th = th;
    L97:
        th.printStackTrace();     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        d27.d.a(r102);
        throw th;
    L19:
        th = th;
        r102 = null;
    L24:
        if (com.bytedance.apm.util.k.b(this.f560993b) == false) goto L26;
        return;
    L26:
        Iterator r105 = ((CopyOnWriteArrayList) this.f560993b).iterator();
        long r106 = 0;
        long r107 = 0;
        long r108 = 0;
        long r110 = 0;
        long r111 = 0;
        long r112 = 0;
        long r113 = 0;
        long r210 = 0;
    L28:
        if (r105.hasNext() == false) goto L77;
        String r109 = (String) r105.next();
        r105 = r105;
        String[] r114 = r109.split(" ");
    L74:
        int r310 = r100;
        long r311 = r108;
        r110 = r110;
        r113 = r113;
        r210 = r210;
    L75:
        r113 = r113;
        r210 = r210;
        r108 = r311;
        r110 = r110;
    L76:
        r100 = r310;
        goto L28
    L31:
        if (TextUtils.equals(r114[3], "uid_tag_int") == true) goto L28;
        if (r100 != CastIntegerProtector.parseInt(r114[3])) goto L73;
        long r211 = CastLongProtector.parseLong(r114[5]);     // Catch: Exception -> L74
        long r212 = CastLongProtector.parseLong(r114[6]);     // Catch: Exception -> L74
        long r213 = CastLongProtector.parseLong(r114[7]);     // Catch: Exception -> L74
        long r312 = CastLongProtector.parseLong(r114[8]);     // Catch: Exception -> L74
        if (CastLongProtector.valueOf(r114[4]).longValue() != 1) goto L50;
        r310 = r100;
        if (r114[1].startsWith("rmnet_data") == false) goto L42;
        r110 = r110 + (r213 + r211);
        r108 = r108 + (r312 + r212);
    L95:
        if (CastLongProtector.valueOf(r114[4]).longValue() != 0) goto L69;
        long r313 = r106;
        if (r114[1].startsWith("rmnet_data") == false) goto L91;
        r112 = r112 + (r213 + r211);
        r107 = r107 + (r312 + r212);
        r106 = r313;
        goto L76
    L91:
        if (r114[1].startsWith("wlan") == false) goto L71;
        r111 = r111 + (r213 + r211);
        long r115 = r113;
        r113 = r115 + (r312 + r212);
    L72:
        r106 = r313;
    L71:
        r113 = r113;
        goto L72
    L69:
        r313 = r106;
    L70:
        r313 = r106;
        goto L71
    L42:
        r311 = r108;
        if (r114[1].startsWith("wlan") == false) goto L51;
        r106 = r106 + (r213 + r211);
        long r116 = r210;
        r210 = r116 + (r312 + r212);
    L52:
        r108 = r311;
        r110 = r110;
    L51:
        r210 = r210;
    L47:
        r311 = r108;
        goto L75
    L50:
        r310 = r100;
        r311 = r108;
        goto L51
    L73:
        r310 = r100;
        r311 = r108;
        goto L75
    L77:
        long r314 = r108;
        long r315 = r110;
        h r117 = this;
        r117.f560995d = r111;
        r117.f560996e = r112;
        r117.f560997f = r106;
        r117.f560998g = r315;
        r117.f560999h = r113;
        r117.f561000i = r107;
        r117.f561001j = r210;
        r117.f561002k = r314;
    }

    public h() {
        this.f560993b = new CopyOnWriteArrayList();
        this.f560994c = -1;
        this.f560995d = 0;
        this.f560996e = 0;
        this.f560997f = 0;
        this.f560998g = 0;
        this.f560999h = 0;
        this.f561000i = 0;
        this.f561001j = 0;
        this.f561002k = 0;
    }

    @Override // ws3.e
    public final long a() {
        m();
        return this.f560995d;
    }

    @Override // ws3.e
    public final long b() {
        m();
        return this.f560996e;
    }

    @Override // ws3.e
    public final long c() {
        m();
        long r100 = this.f560996e;
        m();
        return r100 + this.f560995d;
    }

    @Override // ws3.e
    public final long e() {
        m();
        long r100 = this.f560995d;
        m();
        return r100 + this.f560997f;
    }

    @Override // ws3.e
    public final long f() {
        m();
        long r100 = this.f560998g;
        m();
        return r100 + this.f560997f;
    }

    @Override // ws3.e
    public final long g() {
        m();
        long r100 = this.f560996e;
        m();
        return r100 + this.f560998g;
    }

    @Override // ws3.e
    public final long h() {
        m();
        return this.f561002k + this.f561001j;
    }

    @Override // ws3.e
    public final long i() {
        return g() + e();
    }

    @Override // ws3.e
    public final long j() {
        m();
        return this.f560997f;
    }

    @Override // ws3.e
    public final long k() {
        m();
        return this.f561000i + this.f560999h;
    }

    @Override // ws3.e
    public final long l() {
        m();
        return this.f560998g;
    }
}
