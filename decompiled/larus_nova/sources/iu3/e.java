package iu3;

import android.os.Build;
import android.os.Debug;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f495784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f495785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f495786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f495787d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f495788a = null;

        static {
            f495788a = new e();
        }
    }

    public e() {
    }

    public final long a() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r100 = CastLongProtector.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-count"));
        long r101 = r100 - this.f495786c;
        this.f495786c = r100;
        if (xu3.a.a() == false) goto L9;
        av3.b.a("APM-Memory", "blockingGcCount:" + this.f495786c);
    L9:
        return r101;
    }

    public final long b() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r100 = CastLongProtector.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-time"));
        long r101 = r100 - this.f495787d;
        this.f495787d = r100;
        if (xu3.a.a() == false) goto L9;
        av3.b.a("APM-Memory", "blockingGcTime:" + this.f495787d);
    L9:
        return r101;
    }

    public final long c() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r100 = CastLongProtector.parseLong(Debug.getRuntimeStat("art.gc.gc-count"));
        long r101 = r100 - this.f495784a;
        this.f495784a = r100;
        if (xu3.a.a() == false) goto L9;
        av3.b.a("APM-Memory", "gcCount:" + r100);
    L9:
        return r101;
    }

    public final long d() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r100 = CastLongProtector.parseLong(Debug.getRuntimeStat("art.gc.gc-time"));
        long r101 = r100 - this.f495785b;
        this.f495785b = r100;
        if (xu3.a.a() == false) goto L9;
        av3.b.a("APM-Memory", "gcTime:" + this.f495785b);
    L9:
        return r101;
    }
}
