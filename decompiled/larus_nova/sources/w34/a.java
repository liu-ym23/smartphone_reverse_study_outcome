package w34;

import android.os.SystemClock;
import com.ss.android.download.api.constant.BaseConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f558144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f558145b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f558144a, r101.f558144a) == true) goto L12;
        return false;
    L12:
        if (this.f558145b == r101.f558145b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        T r100 = this.f558144a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.f558145b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AosCacheModel(data=" + this.f558144a + ", fetchTime=" + this.f558145b + ')';
    }

    public final boolean a() {
        long r100 = this.f558145b - SystemClock.elapsedRealtime();
        int r101 = b44.a.f17520a;
        if (r100 > BaseConstants.Time.HOUR) goto L5;
        return true;
    L5:
        return false;
    }

    public a(T r100, long r101) {
        this.f558144a = r100;
        this.f558145b = r101;
    }
}
