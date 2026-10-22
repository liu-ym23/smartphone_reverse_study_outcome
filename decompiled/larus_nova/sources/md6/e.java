package md6;

import androidx.camera.video.AudioStats;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;

/* JADX INFO: loaded from: classes19.dex */
@Serializable
public final class e {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f513322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f513323b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f513324a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f513325b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            nuc.b0 r100 = nuc.b0.f520644a;
            return new juc.d[]{r100, r100};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f513325b;
        }

        static {
            a r100 = new a();
            f513324a = r100;
            g2 r101 = new g2("com.bytedance.kmp.performance.model.KPerfCpuData", r100, 2);
            r101.j("systemCpuUsage", false);
            r101.j("appCpuUsage", false);
            f513325b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f513325b;
            muc.c r101 = r110.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            double r111 = r101.decodeDoubleElement(r100, 0);
            double r112 = r101.decodeDoubleElement(r100, 1);
            int r113 = 3;
        L17:
            r101.endStructure(r100);
            return new e(r113, r111, r112);
        L5:
            double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
            double r103 = 0.0d;
            int r104 = 0;
            boolean r105 = true;
        L6:
            if (r105 == false) goto L16;
            int r114 = r101.decodeElementIndex(r100);
            if (r114 != (-1)) goto L9;
            r105 = false;
            goto L6
        L9:
            if (r114 != 0) goto L10;
            r102 = r101.decodeDoubleElement(r100, 0);
            r104 = r104 | 1;
            goto L6
        L10:
            if (r114 != 1) goto L13;
            r103 = r101.decodeDoubleElement(r100, 1);
            r104 = r104 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r114);
        L16:
            r113 = r104;
            r111 = r102;
            r112 = r103;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            e r102 = (e) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f513325b;
            muc.d r104 = r100.beginStructure(r103);
            r104.encodeDoubleElement(r103, 0, r102.f513322a);
            r104.encodeDoubleElement(r103, 1, r102.f513323b);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<e> serializer() {
            return a.f513324a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Double.compare(this.f513322a, r101.f513322a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f513323b, r101.f513323b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f513322a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f513323b);
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "KPerfCpuData(systemCpuUsage=" + this.f513322a + ", appCpuUsage=" + this.f513323b + ')';
    }

    static {
        Companion = new b();
    }

    public e(double r100, double r101) {
        this.f513322a = r100;
        this.f513323b = r101;
    }

    public e(int r100, double r101, double r102) {
        if (3 != (r100 & 3)) goto L6;
        this.f513322a = r101;
        this.f513323b = r102;
        return;
    L6:
        b2.b(r100, 3, a.f513325b);
        throw null;
    }
}
