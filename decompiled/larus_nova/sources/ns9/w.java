package ns9;

import com.larus.reach.api.ReachPageScope;
import com.larus.reach.api.ReachPosition;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class w extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReachPosition f520416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f520417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f520418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f520419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f520420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ReachPageScope f520421f;

    /* JADX WARN: Multi-variable type inference failed */
    public w() {
        Object[] r100 = 0 == true ? 1 : 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(null, r100, r101, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (this.f520416a == r101.f520416a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520417b, r101.f520417b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f520418c, r101.f520418c) == true) goto L18;
        return false;
    L18:
        if (this.f520419d == r101.f520419d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f520420e, r101.f520420e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f520416a.hashCode() * 31) + this.f520417b.hashCode()) * 31;
        String r101 = this.f520418c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        long r104 = this.f520419d;
        return ((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f520420e.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "TargetPageReachTarget(position=" + this.f520416a + ", reachPageInfo=" + this.f520417b + ", reachPolicy=" + this.f520418c + ", expireTimeMs=" + this.f520419d + ", displayPolicy=" + this.f520420e + ')';
    }

    @Override // ns9.v
    public final ReachPageScope a() {
        return this.f520421f;
    }

    @Override // ns9.v
    public final ReachPosition b() {
        return this.f520416a;
    }

    public /* synthetic */ w(ReachPosition r100, Map r101, Map r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r100 = ReachPosition.BOTTOM;
    L5:
        ReachPosition r102 = r100;
        if ((r111 & 2) == 0) goto L8;
        r101 = MapsKt.emptyMap();
    L8:
        Map r103 = r101;
        if ((r111 & 16) == 0) goto L11;
        r110 = MapsKt.emptyMap();
    L11:
        this(r102, r103, null, 0, r110);
    }

    public w(ReachPosition r100, Map<String, String> r101, String r102, long r103, Map<String, String> r104) {
        Intrinsics.checkNotNullParameter(r100, "position");
        Intrinsics.checkNotNullParameter(r101, "reachPageInfo");
        Intrinsics.checkNotNullParameter(r104, "displayPolicy");
        this.f520416a = r100;
        this.f520417b = r101;
        this.f520418c = r102;
        this.f520419d = r103;
        this.f520420e = r104;
        this.f520421f = ReachPageScope.TargetPage;
    }
}
