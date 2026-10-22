package io.reactivex.schedulers;

import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f495097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f495098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f495099c;

    public final int hashCode() {
        T r100 = this.f495097a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f495098b;
        return (((r101 * 31) + ((int) (r102 ^ (r102 >>> 31)))) * 31) + this.f495099c.hashCode();
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "Timed[time=" + this.f495098b + ", unit=" + this.f495099c + ", value=" + this.f495097a + "]";
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (ObjectHelper.equals(this.f495097a, r101.f495097a) == true) goto L7;
        return false;
    L7:
        if (this.f495098b == r101.f495098b) goto L9;
        return false;
    L9:
        if (ObjectHelper.equals(this.f495099c, r101.f495099c) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public a(T r100, long r101, TimeUnit r102) {
        this.f495097a = r100;
        this.f495098b = r101;
        this.f495099c = (TimeUnit) ObjectHelper.requireNonNull(r102, "unit is null");
    }
}
