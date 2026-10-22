package cx5;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes19.dex */
@Serializable
public final class f {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f465728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f465729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f465730d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f465731a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f465732b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            i r100 = i.f520705a;
            return new juc.d[]{kuc.a.d(v2.f520790a), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f465732b;
        }

        static {
            a r100 = new a();
            f465731a = r100;
            g2 r101 = new g2("com.bytedance.flow_audio.impl.core.response.FlowAudioASRResultItem", r100, 4);
            r101.j("text", true);
            r101.j("is_interim", true);
            r101.j("stream_asr_finish", true);
            r101.j("definite", true);
            f465732b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f465732b;
            muc.c r101 = r110.beginStructure(r100);
            String r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            String r103 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, null);
            i r104 = i.f520705a;
            Boolean r105 = (Boolean) r101.decodeNullableSerializableElement(r100, 1, r104, null);
            String r111 = r103;
            Boolean r112 = (Boolean) r101.decodeNullableSerializableElement(r100, 2, r104, null);
            Boolean r113 = (Boolean) r101.decodeNullableSerializableElement(r100, 3, r104, null);
            Boolean r114 = r105;
            int r115 = 15;
        L21:
            r101.endStructure(r100);
            return new f(r115, r111, r114, r112, r113);
        L5:
            Boolean r106 = null;
            Boolean r107 = null;
            Boolean r116 = null;
            int r108 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L20;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 != 0) goto L10;
            r102 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r102);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r118 != 1) goto L11;
            r106 = (Boolean) r101.decodeNullableSerializableElement(r100, 1, i.f520705a, r106);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r107 = (Boolean) r101.decodeNullableSerializableElement(r100, 2, i.f520705a, r107);
            r108 = r108 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r116 = (Boolean) r101.decodeNullableSerializableElement(r100, 3, i.f520705a, r116);
            r108 = r108 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r115 = r108;
            r111 = r102;
            r114 = r106;
            r112 = r107;
            r113 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            f r102 = (f) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f465732b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = f.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f465727a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, i.f520705a, r102.f465728b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeNullableSerializableElement(r103, 2, i.f520705a, r102.f465729c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            r106 = true;
        L35:
            if (r106 == false) goto L37;
            r104.encodeNullableSerializableElement(r103, 3, i.f520705a, r102.f465730d);
        L37:
            r104.endStructure(r103);
            return;
        L33:
            if (Intrinsics.areEqual(r102.f465730d, Boolean.FALSE) == true) goto L35;
        L24:
            if (Intrinsics.areEqual(r102.f465729c, Boolean.FALSE) == false) goto L25;
            r109 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r102.f465728b, Boolean.FALSE) == false) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f465727a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<f> serializer() {
            return a.f465731a;
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
        if (Intrinsics.areEqual(this.f465727a, r101.f465727a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465728b, r101.f465728b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465729c, r101.f465729c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f465730d, r101.f465730d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f465727a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f465728b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f465729c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f465730d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowAudioASRResultItem(text=" + this.f465727a + ", isInterim=" + this.f465728b + ", streamAsrFinish=" + this.f465729c + ", definite=" + this.f465730d + ')';
    }

    static {
        Companion = new b();
    }

    public f() {
        Boolean r100 = Boolean.FALSE;
        this.f465727a = null;
        this.f465728b = r100;
        this.f465729c = r100;
        this.f465730d = r100;
    }

    public f(int r100, String r101, Boolean r102, Boolean r103, Boolean r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f465732b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f465727a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f465728b = Boolean.FALSE;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f465729c = Boolean.FALSE;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f465730d = Boolean.FALSE;
        return;
    L19:
        this.f465730d = r104;
        return;
    L15:
        this.f465729c = r103;
        goto L17
    L11:
        this.f465728b = r102;
        goto L13
    L7:
        this.f465727a = r101;
        goto L9
    }
}
