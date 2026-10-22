package nw5;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes19.dex */
@Serializable
public final class b {
    public static final C6985b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f520989b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f520990a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f520991b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{v2.f520790a, d.a.f520994a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f520991b;
        }

        static {
            a r100 = new a();
            f520990a = r100;
            g2 r101 = new g2("com.bytedance.flow_audio.api.business.tts.sentence.FlowAudioSentenceInfo", r100, 2);
            r101.j("text", false);
            r101.j("speech_alignment_result", false);
            f520991b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f520991b;
            muc.c r111 = r110.beginStructure(r100);
            d r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            String r102 = r111.decodeStringElement(r100, 0);
            d r103 = (d) r111.decodeSerializableElement(r100, 1, d.a.f520994a, null);
            int r104 = 3;
        L17:
            r111.endStructure(r100);
            return new b(r104, r102, r103);
        L5:
            String r105 = null;
            int r106 = 0;
            boolean r107 = true;
        L6:
            if (r107 == false) goto L16;
            int r108 = r111.decodeElementIndex(r100);
            if (r108 != (-1)) goto L9;
            r107 = false;
            goto L6
        L9:
            if (r108 != 0) goto L10;
            r105 = r111.decodeStringElement(r100, 0);
            r106 = r106 | 1;
            goto L6
        L10:
            if (r108 != 1) goto L13;
            r101 = (d) r111.decodeSerializableElement(r100, 1, d.a.f520994a, r101);
            r106 = r106 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r108);
        L16:
            r104 = r106;
            r103 = r101;
            r102 = r105;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            b r102 = (b) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f520991b;
            muc.d r104 = r100.beginStructure(r103);
            r104.encodeStringElement(r103, 0, r102.f520988a);
            r104.encodeSerializableElement(r103, 1, d.a.f520994a, r102.f520989b);
            r104.endStructure(r103);
        }
    }

    /* JADX INFO: renamed from: nw5.b$b, reason: collision with other inner class name */
    public static final class C6985b {
        public C6985b() {
        }

        public final juc.d<b> serializer() {
            return a.f520990a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f520988a, r101.f520988a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520989b, r101.f520989b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f520988a.hashCode() * 31) + this.f520989b.hashCode();
    }

    public final String toString() {
        return "FlowAudioSentenceInfo(text=" + this.f520988a + ", phonemes=" + this.f520989b + ')';
    }

    static {
        Companion = new C6985b();
    }

    public b(String r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "phonemes");
        this.f520988a = r100;
        this.f520989b = r101;
    }

    public b(int r100, String r101, d r102) {
        if (3 != (r100 & 3)) goto L6;
        this.f520988a = r101;
        this.f520989b = r102;
        return;
    L6:
        b2.b(r100, 3, a.f520991b);
        throw null;
    }
}
