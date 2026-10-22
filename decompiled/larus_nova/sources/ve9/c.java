package ve9;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.w0;

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class c {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f554428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f554429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f554430c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f554431a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f554432b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            w0 r100 = w0.f520792a;
            return new juc.d[]{r100, r100, r100};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f554432b;
        }

        static {
            a r100 = new a();
            f554431a = r100;
            g2 r101 = new g2("com.larus.im.internal.network.link.service.config.AvQuicConnectConfig", r100, 3);
            r101.j("connect_timeout_ms", true);
            r101.j("connect_retry_count", true);
            r101.j("connect_retry_duration_ms", true);
            f554432b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f554432b;
            muc.c r111 = r110.beginStructure(r100);
            if (r111.decodeSequentially() == false) goto L5;
            int r101 = r111.decodeIntElement(r100, 0);
            int r102 = r111.decodeIntElement(r100, 1);
            int r103 = r111.decodeIntElement(r100, 2);
            int r104 = 7;
        L19:
            r111.endStructure(r100);
            return new c(r104, r101, r102, r103);
        L5:
            r101 = 0;
            int r105 = 0;
            int r106 = 0;
            int r107 = 0;
            boolean r108 = true;
        L6:
            if (r108 == false) goto L18;
            int r109 = r111.decodeElementIndex(r100);
            if (r109 != (-1)) goto L9;
            r108 = false;
            goto L6
        L9:
            if (r109 != 0) goto L10;
            r101 = r111.decodeIntElement(r100, 0);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r109 != 1) goto L11;
            r106 = r111.decodeIntElement(r100, 1);
            r107 = r107 | 2;
            goto L6
        L11:
            if (r109 != 2) goto L14;
            r105 = r111.decodeIntElement(r100, 2);
            r107 = r107 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r109);
        L18:
            r103 = r105;
            r102 = r106;
            r104 = r107;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            c r102 = (c) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f554432b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = c.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeIntElement(r103, 0, r102.f554428a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeIntElement(r103, 1, r102.f554429b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            r106 = true;
        L26:
            if (r106 == false) goto L28;
            r104.encodeIntElement(r103, 2, r102.f554430c);
        L28:
            r104.endStructure(r103);
            return;
        L24:
            if (r102.f554430c == 0) goto L26;
        L15:
            if (r102.f554429b != 0) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f554428a != 0) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.f554431a;
        }
    }

    public c() {
        this(0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f554428a == r101.f554428a) goto L12;
        return false;
    L12:
        if (this.f554429b == r101.f554429b) goto L15;
        return false;
    L15:
        if (this.f554430c == r101.f554430c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f554428a * 31) + this.f554429b) * 31) + this.f554430c;
    }

    public final String toString() {
        return "AvQuicConnectConfig(connectTimeoutMs=" + this.f554428a + ", connectRetryCount=" + this.f554429b + ", connectRetryDurationMs=" + this.f554430c + ')';
    }

    static {
        Companion = new b();
    }

    public c(int r100, int r101, int r102) {
        this.f554428a = r100;
        this.f554429b = r101;
        this.f554430c = r102;
    }

    public c(int r100, int r101, int r102, int r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f554432b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f554428a = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f554429b = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f554430c = 0;
        return;
    L15:
        this.f554430c = r103;
        return;
    L11:
        this.f554429b = r102;
        goto L13
    L7:
        this.f554428a = r101;
        goto L9
    }
}
