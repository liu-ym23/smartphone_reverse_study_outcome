package cx5;

import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.k;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes19.dex */
@Serializable
public final class g {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nw5.e f465733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f465734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f465735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f465736d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f465737a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f465738b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(nw5.e.a.f521000a), kuc.a.d(v2.f520790a), kuc.a.d(k.f520722c), kuc.a.d(h.a.f465741a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f465738b;
        }

        static {
            a r100 = new a();
            f465737a = r100;
            g2 r101 = new g2("com.bytedance.flow_audio.impl.core.response.FlowAudioTTSResponse", r100, 4);
            r101.j("sentence", true);
            r101.j("tts_content_scene", true);
            r101.j("audio", true);
            r101.j("extra", true);
            f465738b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f465738b;
            muc.c r101 = r110.beginStructure(r100);
            nw5.e r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            nw5.e r103 = (nw5.e) r101.decodeNullableSerializableElement(r100, 0, nw5.e.a.f521000a, null);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, null);
            nw5.e r111 = r103;
            byte[] r112 = (byte[]) r101.decodeNullableSerializableElement(r100, 2, k.f520722c, null);
            String r113 = r104;
            h r114 = (h) r101.decodeNullableSerializableElement(r100, 3, h.a.f465741a, null);
            int r115 = 15;
        L21:
            r101.endStructure(r100);
            return new g(r115, r111, r113, r112, r114);
        L5:
            String r105 = null;
            byte[] r106 = null;
            h r116 = null;
            int r107 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L20;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 != 0) goto L10;
            r102 = (nw5.e) r101.decodeNullableSerializableElement(r100, 0, nw5.e.a.f521000a, r102);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r118 != 1) goto L11;
            r105 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r105);
            r107 = r107 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r106 = (byte[]) r101.decodeNullableSerializableElement(r100, 2, k.f520722c, r106);
            r107 = r107 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r116 = (h) r101.decodeNullableSerializableElement(r100, 3, h.a.f465741a, r116);
            r107 = r107 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r115 = r107;
            r111 = r102;
            r113 = r105;
            r112 = r106;
            r114 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            g r102 = (g) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f465738b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = g.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, nw5.e.a.f521000a, r102.f465733a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f465734b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeNullableSerializableElement(r103, 2, k.f520722c, r102.f465735c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            r106 = true;
        L35:
            if (r106 == false) goto L37;
            r104.encodeNullableSerializableElement(r103, 3, h.a.f465741a, r102.f465736d);
        L37:
            r104.endStructure(r103);
            return;
        L33:
            if (r102.f465736d == null) goto L35;
        L24:
            if (r102.f465735c != null) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f465734b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f465733a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<g> serializer() {
            return a.f465737a;
        }
    }

    public g() {
        this(null, 15);
    }

    public final String toString() {
        return "FlowAudioTTSResponse(sentence=" + this.f465733a + ", ttsContentScene=" + this.f465734b + ", audioData=" + Arrays.toString(this.f465735c) + ", extra=" + this.f465736d + ')';
    }

    static {
        Companion = new b();
    }

    public final int hashCode() {
        nw5.e r100 = this.f465733a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f465734b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        byte[] r107 = this.f465735c;
        if (r107 == null) goto L13;
        int r108 = Arrays.hashCode(r107);
    L14:
        int r109 = (r106 + r108) * 31;
        h r110 = this.f465736d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L23:
        return false;
    L8:
        if (g.class != r100.getClass()) goto L23;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f465733a, r101.f465733a) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f465734b, r101.f465734b) == true) goto L17;
        return false;
    L17:
        if (Arrays.equals(this.f465735c, r101.f465735c) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f465736d, r101.f465736d) == true) goto L22;
        return false;
    L22:
        return true;
    }

    public /* synthetic */ g(nw5.e r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null, null, null);
    }

    public g(nw5.e r100, String r101, byte[] r102, h r103) {
        this.f465733a = r100;
        this.f465734b = r101;
        this.f465735c = r102;
        this.f465736d = r103;
    }

    public g(int r100, nw5.e r101, String r102, byte[] r103, h r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f465738b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f465733a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f465734b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f465735c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f465736d = null;
        return;
    L19:
        this.f465736d = r104;
        return;
    L15:
        this.f465735c = r103;
        goto L17
    L11:
        this.f465734b = r102;
        goto L13
    L7:
        this.f465733a = r101;
        goto L9
    }
}
