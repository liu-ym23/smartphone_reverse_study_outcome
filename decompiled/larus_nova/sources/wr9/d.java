package wr9;

import com.larus.power.state.api.PowerMetricAvailability;
import com.larus.power.state.api.PowerMetricSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f560885f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f560886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PowerMetricAvailability f560887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PowerMetricSource f560888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f560889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f560890e;

    public static final class a {
        public static d a(PowerMetricAvailability r100, PowerMetricSource r101, long r110, String r111) {
            Intrinsics.checkNotNullParameter(r100, "availability");
            Intrinsics.checkNotNullParameter(r101, "source");
            return new d(null, r100, r101, r110, r111);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f560886a, r101.f560886a) == true) goto L12;
        return false;
    L12:
        if (this.f560887b == r101.f560887b) goto L15;
        return false;
    L15:
        if (this.f560888c == r101.f560888c) goto L18;
        return false;
    L18:
        if (this.f560889d == r101.f560889d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f560890e, r101.f560890e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        T r100 = this.f560886a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f560887b.hashCode()) * 31) + this.f560888c.hashCode()) * 31;
        long r104 = this.f560889d;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.f560890e;
        if (r106 == null) goto L11;
        r101 = r106.hashCode();
    L11:
        return r105 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PowerMetric(value=" + this.f560886a + ", availability=" + this.f560887b + ", source=" + this.f560888c + ", sampledAtElapsedRealtimeMs=" + this.f560889d + ", reason=" + this.f560890e + ')';
    }

    public /* synthetic */ d(Object r100, PowerMetricAvailability r101, PowerMetricSource r110, long r111) {
        this(r100, r101, r110, r111, null);
    }

    public static d a(d r100, PowerMetricAvailability r110, String r111, int r112) {
        PowerMetricSource r101 = null;
        if ((r112 & 1) == 0) goto L5;
        T r102 = r100.f560886a;
    L7:
        if ((r112 & 2) == 0) goto L9;
        r110 = r100.f560887b;
    L9:
        PowerMetricAvailability r103 = r110;
        if ((r112 & 4) == 0) goto L12;
        r101 = r100.f560888c;
    L12:
        PowerMetricSource r104 = r101;
        if ((r112 & 8) == 0) goto L15;
        long r105 = r100.f560889d;
    L16:
        long r106 = r105;
        if ((r112 & 16) == 0) goto L19;
        r111 = r100.f560890e;
    L19:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "availability");
        Intrinsics.checkNotNullParameter(r104, "source");
        return new d(r102, r103, r104, r106, r111);
    L15:
        r105 = 0;
        goto L16
    L5:
        r102 = null;
        goto L7
    }

    public d(T r100, PowerMetricAvailability r101, PowerMetricSource r102, long r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "availability");
        Intrinsics.checkNotNullParameter(r102, "source");
        this.f560886a = r100;
        this.f560887b = r101;
        this.f560888c = r102;
        this.f560889d = r103;
        this.f560890e = r104;
    }
}
