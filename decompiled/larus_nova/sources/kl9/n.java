package kl9;

import com.ttnet.org.chromium.base.TimeUtils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.w0;

/* JADX INFO: loaded from: classes4.dex */
@Serializable
public final class n {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f503945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f503946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f503947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f503948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f503949e;

    /* JADX INFO: loaded from: classes30.dex */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f503950a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f503951b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            g1 r100 = g1.f520681a;
            return new juc.d[]{w0.f520792a, r100, r100, r100, r100};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f503951b;
        }

        static {
            a r100 = new a();
            f503950a = r100;
            g2 r101 = new g2("com.larus.multitask_management.api.data.MultiTaskManagementConfig", r100, 5);
            r101.j("max_ongoing_task_count", true);
            r101.j("remote_task_polling_interval", true);
            r101.j("remote_task_idle_polling_interval", true);
            r101.j("remote_task_polling_scatter", true);
            r101.j("remote_task_refresh_interval", true);
            f503951b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f503951b;
            muc.c r101 = r310.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            int r102 = r101.decodeIntElement(r100, 0);
            long r103 = r101.decodeLongElement(r100, 1);
            long r104 = r101.decodeLongElement(r100, 2);
            int r210 = r102;
            long r211 = r104;
            long r212 = r101.decodeLongElement(r100, 3);
            long r213 = r103;
            long r214 = r101.decodeLongElement(r100, 4);
            int r110 = 31;
        L25:
            r101.endStructure(r100);
            return new n(r110, r210, r213, r211, r212, r214);
        L5:
            long r105 = 0;
            long r111 = 0;
            long r112 = 0;
            long r113 = 0;
            int r106 = 0;
            int r114 = 0;
            boolean r115 = true;
        L6:
            if (r115 == false) goto L24;
            int r107 = r101.decodeElementIndex(r100);
            if (r107 != (-1)) goto L9;
            r115 = false;
            goto L6
        L9:
            if (r107 != 0) goto L10;
            r106 = r101.decodeIntElement(r100, 0);
            r114 = r114 | 1;
            goto L6
        L10:
            if (r107 != 1) goto L12;
            r112 = r101.decodeLongElement(r100, 1);
            int r108 = r114 | 2;
        L21:
            r114 = r108;
            goto L6
        L12:
            if (r107 == 2) goto L19;
            if (r107 == 3) goto L18;
            if (r107 != 4) goto L17;
            r113 = r101.decodeLongElement(r100, 4);
            r108 = r114 | 16;
            goto L21
        L17:
            throw new UnknownFieldException(r107);
        L18:
            r111 = r101.decodeLongElement(r100, 3);
            r108 = r114 | 8;
            goto L21
        L19:
            r105 = r101.decodeLongElement(r100, 2);
            r108 = r114 | 4;
            goto L21
        L24:
            r210 = r106;
            r211 = r105;
            r110 = r114;
            r212 = r111;
            r213 = r112;
            r214 = r113;
            goto L25
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            n r112 = (n) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r112, "value");
            g2 r100 = f503951b;
            muc.d r113 = r110.beginStructure(r100);
            b r101 = n.Companion;
            boolean r102 = false;
            if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
        L7:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            r113.encodeIntElement(r100, 0, r112.f503945a);
        L12:
            if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
        L16:
            boolean r104 = true;
        L18:
            if (r104 == false) goto L21;
            r113.encodeLongElement(r100, 1, r112.f503946b);
        L21:
            if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
        L25:
            boolean r105 = true;
        L27:
            if (r105 == false) goto L30;
            r113.encodeLongElement(r100, 2, r112.f503947c);
        L30:
            if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
        L34:
            boolean r106 = true;
        L36:
            if (r106 == false) goto L39;
            r113.encodeLongElement(r100, 3, r112.f503948d);
        L39:
            if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
        L43:
            r102 = true;
        L44:
            if (r102 == false) goto L46;
            r113.encodeLongElement(r100, 4, r112.f503949e);
        L46:
            r113.endStructure(r100);
            return;
        L42:
            if (r112.f503949e == TimeUtils.SECONDS_PER_HOUR) goto L44;
        L33:
            if (r112.f503948d != 10) goto L34;
            r106 = false;
            goto L36
        L24:
            if (r112.f503947c != 300) goto L25;
            r105 = false;
            goto L27
        L15:
            if (r112.f503946b != 60) goto L16;
            r104 = false;
            goto L18
        L6:
            if (r112.f503945a != 50) goto L7;
            r103 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<n> serializer() {
            return a.f503950a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f503945a == r101.f503945a) goto L12;
        return false;
    L12:
        if (this.f503946b == r101.f503946b) goto L15;
        return false;
    L15:
        if (this.f503947c == r101.f503947c) goto L18;
        return false;
    L18:
        if (this.f503948d == r101.f503948d) goto L21;
        return false;
    L21:
        if (this.f503949e == r101.f503949e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f503945a * 31;
        long r101 = this.f503946b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f503947c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f503948d;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f503949e;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    }

    public final String toString() {
        return "MultiTaskManagementConfig(maxOngoingTaskCount=" + this.f503945a + ", remoteTaskPollingInterval=" + this.f503946b + ", remoteTaskIdlePollingInterval=" + this.f503947c + ", remoteTaskPollingScatter=" + this.f503948d + ", remoteTaskRefreshInterval=" + this.f503949e + ')';
    }

    static {
        Companion = new b();
    }

    public n() {
        this(50, 60, 300, 10, TimeUtils.SECONDS_PER_HOUR);
    }

    public n(int r100, long r101, long r102, long r103, long r104) {
        this.f503945a = r100;
        this.f503946b = r101;
        this.f503947c = r102;
        this.f503948d = r103;
        this.f503949e = r104;
    }

    public n(int r100, int r101, long r102, long r103, long r104, long r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f503951b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = 50;
    L7:
        this.f503945a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f503946b = 60;
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f503947c = 300;
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.f503948d = 10;
    L20:
        if ((r100 & 16) != 0) goto L22;
        this.f503949e = TimeUtils.SECONDS_PER_HOUR;
        return;
    L22:
        this.f503949e = r110;
        return;
    L18:
        this.f503948d = r104;
        goto L20
    L14:
        this.f503947c = r103;
        goto L16
    L10:
        this.f503946b = r102;
        goto L12
    }
}
