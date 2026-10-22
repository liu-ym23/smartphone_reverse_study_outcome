package sna;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import com.obric.sva.sdk.utils.InteractConst;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f542678a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f542679b = null;

    /* JADX INFO: loaded from: classes34.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f542680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f542681b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f542680a, r101.f542680a) == true) goto L12;
            return false;
        L12:
            if (this.f542681b == r101.f542681b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f542680a.hashCode() * 31;
            long r101 = this.f542681b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "SidThresholdSnapshot(config=" + this.f542680a + ", cachedAt=" + this.f542681b + ')';
        }

        public a(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "config");
            this.f542680a = r100;
            this.f542681b = r101;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f542682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f542683b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f542682a == r101.f542682a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f542683b, r101.f542683b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f542682a;
            return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f542683b.hashCode();
        }

        public final String toString() {
            return "VoiceprintFailRecord(failTime=" + this.f542682a + ", wakeupId=" + this.f542683b + ')';
        }

        public b(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, InteractConst.WAKEUP_WAKEUP_ID);
            this.f542682a = r100;
            this.f542683b = r101;
        }
    }

    public h() {
    }

    static {
        f542678a = new h();
        f542679b = LazyKt.lazy(new g());
    }

    public static Keva a() {
        return (Keva) f542679b.getValue();
    }

    public static void b(String r100) {
        FLogger.f375446a.i("WakeupCacheManager", r100);
    }
}
