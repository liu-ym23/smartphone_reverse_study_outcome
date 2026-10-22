package fp8;

import android.os.SystemClock;
import kotlin.jvm.internal.Intrinsics;
import m1a.d;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f478294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f478295b;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f478294a, r101.f478294a) == true) goto L12;
        return false;
    L12:
        if (this.f478295b == r101.f478295b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f478294a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.f478295b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatArgumentCoreData(immerseBgColor=" + this.f478294a + ", uniqueChatKey=" + this.f478295b + ')';
    }

    public /* synthetic */ a(int r100) {
        this(null, SystemClock.elapsedRealtime());
    }

    public a(Integer r100, long r101) {
        this.f478294a = r100;
        this.f478295b = r101;
    }
}
