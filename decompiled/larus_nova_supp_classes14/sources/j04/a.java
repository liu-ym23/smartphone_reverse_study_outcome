package j04;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final long a;
    public final long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public final String g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public final long n;
    public int o;

    public a(String r2, Long r3) {
        Intrinsics.checkNotNullParameter(r2, "entranceType");
        this.g = "";
        this.g = r2;
        if (Intrinsics.areEqual(r2, "enter_play") == false) goto L8;
        if (r3 == null) goto L6;
        long r4 = r3.longValue();
    L7:
        this.a = r4;
        this.b = System.currentTimeMillis();
        return;
    L6:
        r4 = 0;
        goto L7
    L8:
        this.n = System.currentTimeMillis();
    }
}
