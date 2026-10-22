package ns9;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f520360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f520361b;

    public b() {
        this(0, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f520360a == r101.f520360a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520361b, r101.f520361b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f520360a * 31;
        Map<String, String> r101 = this.f520361b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ReachAction(type=" + this.f520360a + ", data=" + this.f520361b + ')';
    }

    public final int getType() {
        return this.f520360a;
    }

    public b(int r100, Map<String, String> r101) {
        this.f520360a = r100;
        this.f520361b = r101;
    }
}
