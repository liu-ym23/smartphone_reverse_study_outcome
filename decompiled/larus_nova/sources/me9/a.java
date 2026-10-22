package me9;

import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.network.stragery.f;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f513571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f513572b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f513571a == r101.f513571a) goto L12;
        return false;
    L12:
        if (this.f513572b == r101.f513572b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f513571a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f513572b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "ReceiveRetryConfig(timeout=" + this.f513571a + ", retryInterval=" + this.f513572b + ')';
    }

    public a() {
        Lazy r100 = f.f349540a;
        this(y0.j(), (long) (y0.e().f348572d * ((double) 1000)));
    }

    public a(long r100, long r101) {
        this.f513571a = r100;
        this.f513572b = r101;
    }
}
