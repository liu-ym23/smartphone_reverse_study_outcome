package kh9;

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

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class g {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f503490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f503491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f503492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f503493d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f503494a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f503495b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new juc.d[]{r100, r100, r100, r100};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f503495b;
        }

        static {
            a r100 = new a();
            f503494a = r100;
            g2 r101 = new g2("com.larus.kmp.voice_setting.voice.request.UgcVoiceCheckRequest", r100, 4);
            r101.j("tos_key", false);
            r101.j("preview_text", false);
            r101.j("voice_lang", false);
            r101.j("enter_method", false);
            f503495b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f503495b;
            muc.c r101 = r110.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            String r102 = r101.decodeStringElement(r100, 0);
            String r103 = r101.decodeStringElement(r100, 1);
            String r111 = r102;
            String r112 = r101.decodeStringElement(r100, 2);
            String r113 = r103;
            String r114 = r101.decodeStringElement(r100, 3);
            int r115 = 15;
        L21:
            r101.endStructure(r100);
            return new g(r115, r111, r113, r112, r114);
        L5:
            String r104 = null;
            String r105 = null;
            String r106 = null;
            String r107 = null;
            int r116 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L20;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 != 0) goto L10;
            r104 = r101.decodeStringElement(r100, 0);
            r116 = r116 | 1;
            goto L6
        L10:
            if (r118 != 1) goto L11;
            r106 = r101.decodeStringElement(r100, 1);
            r116 = r116 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r105 = r101.decodeStringElement(r100, 2);
            r116 = r116 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r107 = r101.decodeStringElement(r100, 3);
            r116 = r116 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r111 = r104;
            r112 = r105;
            r113 = r106;
            r114 = r107;
            r115 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            g r102 = (g) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f503495b;
            muc.d r104 = r100.beginStructure(r103);
            r104.encodeStringElement(r103, 0, r102.f503490a);
            r104.encodeStringElement(r103, 1, r102.f503491b);
            r104.encodeStringElement(r103, 2, r102.f503492c);
            r104.encodeStringElement(r103, 3, r102.f503493d);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<g> serializer() {
            return a.f503494a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f503490a, r101.f503490a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f503491b, r101.f503491b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f503492c, r101.f503492c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f503493d, r101.f503493d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f503490a.hashCode() * 31) + this.f503491b.hashCode()) * 31) + this.f503492c.hashCode()) * 31) + this.f503493d.hashCode();
    }

    public final String toString() {
        return "UgcVoiceCheckRequest(tosKey=" + this.f503490a + ", previewText=" + this.f503491b + ", voiceLang=" + this.f503492c + ", enterMethod=" + this.f503493d + ')';
    }

    static {
        Companion = new b();
    }

    public g(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "tosKey");
        Intrinsics.checkNotNullParameter(r101, "previewText");
        Intrinsics.checkNotNullParameter(r102, "voiceLang");
        Intrinsics.checkNotNullParameter(r103, "enterMethod");
        this.f503490a = r100;
        this.f503491b = r101;
        this.f503492c = r102;
        this.f503493d = r103;
    }

    public g(int r100, String r101, String r102, String r103, String r104) {
        if (15 != (r100 & 15)) goto L6;
        this.f503490a = r101;
        this.f503491b = r102;
        this.f503492c = r103;
        this.f503493d = r104;
        return;
    L6:
        b2.b(r100, 15, a.f503495b);
        throw null;
    }
}
