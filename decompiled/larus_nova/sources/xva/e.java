package xva;

import com.ss.android.lark.appreciablelib.CacheStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f565192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f565193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CacheStatus f565194c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L17:
        return true;
    L5:
        if ((r100 instanceof e) == false) goto L16;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f565192a, r101.f565192a) == false) goto L16;
        if (this.f565193b != r101.f565193b) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L16;
        if (Intrinsics.areEqual(this.f565194c, r101.f565194c) == false) goto L16;
    L11:
        r102 = false;
    L16:
        return false;
    }

    public final int hashCode() {
        f r100 = this.f565192a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f565193b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        CacheStatus r105 = this.f565194c;
        if (r105 == null) goto L10;
        r101 = r105.hashCode();
    L10:
        return r104 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TimeCostCache(params=" + this.f565192a + ", startTimestamp=" + this.f565193b + ", status=" + this.f565194c + ")";
    }

    public e(f r100, long r101, CacheStatus r102) {
        this.f565192a = r100;
        this.f565193b = r101;
        this.f565194c = r102;
        r100.f565202h = r101;
    }
}
