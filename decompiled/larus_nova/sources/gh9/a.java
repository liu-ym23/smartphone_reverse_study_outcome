package gh9;

import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class a {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f481312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f481313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f481314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f481315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f481316e;

    /* JADX INFO: renamed from: gh9.a$a, reason: collision with other inner class name */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class C6022a implements m0<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C6022a f481317a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f481318b = null;

        public C6022a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f481318b;
        }

        static {
            C6022a r100 = new C6022a();
            f481317a = r100;
            g2 r101 = new g2("com.larus.kmp.voice_setting.voice.mix.res.PreviewInfo", r100, 4);
            r101.j("style_id", true);
            r101.j("text", true);
            r101.j("audio_url", true);
            r101.j("md5", true);
            f481318b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f481318b;
            c r101 = r110.beginStructure(r100);
            String r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 3, r103, null);
            String r112 = r106;
            String r113 = r104;
            String r114 = r105;
            int r115 = 15;
        L21:
            r101.endStructure(r100);
            return new a(r115, r113, r114, r112, r111);
        L5:
            String r107 = null;
            String r108 = null;
            String r116 = null;
            int r109 = 0;
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
            r109 = r109 | 1;
            goto L6
        L10:
            if (r118 != 1) goto L11;
            r107 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r107);
            r109 = r109 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r108 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r108);
            r109 = r109 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r116 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r116);
            r109 = r109 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r115 = r109;
            r113 = r102;
            r114 = r107;
            r112 = r108;
            r111 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            a r102 = (a) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f481318b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = a.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f481312a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f481313b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeNullableSerializableElement(r103, 2, v2.f520790a, r102.f481314c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            r106 = true;
        L35:
            if (r106 == false) goto L37;
            r104.encodeNullableSerializableElement(r103, 3, v2.f520790a, r102.f481315d);
        L37:
            r104.endStructure(r103);
            return;
        L33:
            if (Intrinsics.areEqual(r102.f481315d, "") == true) goto L35;
        L24:
            if (Intrinsics.areEqual(r102.f481314c, "") == false) goto L25;
            r109 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r102.f481313b, "") == false) goto L16;
            r108 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r102.f481312a, "") == false) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<a> serializer() {
            return C6022a.f481317a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f481312a, r101.f481312a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f481313b, r101.f481313b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f481314c, r101.f481314c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f481315d, r101.f481315d) == true) goto L21;
        return false;
    L21:
        if (this.f481316e == r101.f481316e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f481312a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f481313b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f481314c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f481315d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        int r111 = (r109 + r101) * 31;
        if (this.f481316e == false) goto L21;
        int r112 = 1231;
    L23:
        return r111 + r112;
    L21:
        r112 = 1237;
        goto L23
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
        return "PreviewInfo(styleId=" + this.f481312a + ", text=" + this.f481313b + ", url=" + this.f481314c + ", md5=" + this.f481315d + ", isMixedVoice=" + this.f481316e + ')';
    }

    static {
        Companion = new b();
    }

    public a() {
        this("", "", "", "", true);
    }

    public a(int r100, String r101, String r102, String r103, String r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, C6022a.f481318b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f481312a = "";
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f481313b = "";
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f481314c = "";
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f481315d = "";
    L20:
        this.f481316e = true;
        return;
    L19:
        this.f481315d = r104;
        goto L20
    L15:
        this.f481314c = r103;
        goto L17
    L11:
        this.f481313b = r102;
        goto L13
    L7:
        this.f481312a = r101;
        goto L9
    }

    public a(String r100, String r101, String r102, String r103, boolean r104) {
        this.f481312a = r100;
        this.f481313b = r101;
        this.f481314c = r102;
        this.f481315d = r103;
        this.f481316e = r104;
    }
}
