package nw5;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b0;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes19.dex */
@Serializable
public final class f {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f521002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f521003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f521004c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f521005a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f521006b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            b0 r100 = b0.f520644a;
            return new juc.d[]{v2.f520790a, r100, r100};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f521006b;
        }

        static {
            a r100 = new a();
            f521005a = r100;
            g2 r101 = new g2("com.bytedance.flow_audio.api.business.tts.sentence.FlowAudioWordPhoneme", r100, 3);
            r101.j(EffectConfiguration.KEY_SEARCH_WORD, false);
            r101.j(ILoadStallMonitor.START_TIME, false);
            r101.j("end_time", false);
            f521006b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f521006b;
            muc.c r101 = r210.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            String r102 = r101.decodeStringElement(r100, 0);
            String r110 = r102;
            double r111 = r101.decodeDoubleElement(r100, 1);
            double r112 = r101.decodeDoubleElement(r100, 2);
            int r113 = 7;
        L19:
            r101.endStructure(r100);
            return new f(r113, r110, r111, r112);
        L5:
            String r103 = null;
            double r104 = 0.0d;
            boolean r114 = true;
            double r105 = 0.0d;
            int r106 = 0;
        L6:
            if (r114 == false) goto L18;
            int r115 = r101.decodeElementIndex(r100);
            if (r115 != (-1)) goto L9;
            r114 = false;
            goto L6
        L9:
            if (r115 != 0) goto L10;
            r103 = r101.decodeStringElement(r100, 0);
            r106 = r106 | 1;
            goto L6
        L10:
            if (r115 != 1) goto L11;
            r105 = r101.decodeDoubleElement(r100, 1);
            r106 = r106 | 2;
            goto L6
        L11:
            if (r115 != 2) goto L14;
            r104 = r101.decodeDoubleElement(r100, 2);
            r106 = r106 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r115);
        L18:
            r110 = r103;
            r113 = r106;
            r111 = r105;
            r112 = r104;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            f r102 = (f) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f521006b;
            muc.d r104 = r100.beginStructure(r103);
            r104.encodeStringElement(r103, 0, r102.f521002a);
            r104.encodeDoubleElement(r103, 1, r102.f521003b);
            r104.encodeDoubleElement(r103, 2, r102.f521004c);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<f> serializer() {
            return a.f521005a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f521002a, r101.f521002a) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.f521003b, r101.f521003b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.f521004c, r101.f521004c) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f521002a.hashCode() * 31;
        long r101 = Double.doubleToLongBits(this.f521003b);
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = Double.doubleToLongBits(this.f521004c);
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "FlowAudioWordPhoneme(word=" + this.f521002a + ", startTime=" + this.f521003b + ", endTime=" + this.f521004c + ')';
    }

    static {
        Companion = new b();
    }

    public f(int r100, String r101, double r102, double r103) {
        if (7 != (r100 & 7)) goto L6;
        this.f521002a = r101;
        this.f521003b = r102;
        this.f521004c = r103;
        return;
    L6:
        b2.b(r100, 7, a.f521006b);
        throw null;
    }
}
