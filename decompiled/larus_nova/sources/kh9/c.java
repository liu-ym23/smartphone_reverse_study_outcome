package kh9;

import com.hihonor.honorid.core.data.UserInfo;
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
import nuc.w0;

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class c {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f503471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f503472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f503473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f503474d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f503475a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f503476b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            w0 r100 = w0.f520792a;
            v2 r101 = v2.f520790a;
            return new juc.d[]{r100, r100, r101, r101};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f503476b;
        }

        static {
            a r100 = new a();
            f503475a = r100;
            g2 r101 = new g2("com.larus.kmp.voice_setting.voice.request.TtsOtherVoiceListRequest", r100, 4);
            r101.j("page_index", false);
            r101.j("page_size", false);
            r101.j("visit_id", false);
            r101.j("language_code", false);
            f503476b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f503476b;
            muc.c r101 = r110.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            int r102 = r101.decodeIntElement(r100, 0);
            int r103 = r101.decodeIntElement(r100, 1);
            int r111 = r102;
            String r112 = r101.decodeStringElement(r100, 2);
            int r113 = r103;
            String r114 = r101.decodeStringElement(r100, 3);
            int r115 = 15;
        L21:
            r101.endStructure(r100);
            return new c(r115, r111, r113, r112, r114);
        L5:
            String r104 = null;
            String r105 = null;
            int r106 = 0;
            int r107 = 0;
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
            r106 = r101.decodeIntElement(r100, 0);
            r116 = r116 | 1;
            goto L6
        L10:
            if (r118 != 1) goto L11;
            r107 = r101.decodeIntElement(r100, 1);
            r116 = r116 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r104 = r101.decodeStringElement(r100, 2);
            r116 = r116 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r105 = r101.decodeStringElement(r100, 3);
            r116 = r116 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r111 = r106;
            r112 = r104;
            r113 = r107;
            r114 = r105;
            r115 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            c r102 = (c) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f503476b;
            muc.d r104 = r100.beginStructure(r103);
            r104.encodeIntElement(r103, 0, r102.f503471a);
            r104.encodeIntElement(r103, 1, r102.f503472b);
            r104.encodeStringElement(r103, 2, r102.f503473c);
            r104.encodeStringElement(r103, 3, r102.f503474d);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.f503475a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f503471a == r101.f503471a) goto L12;
        return false;
    L12:
        if (this.f503472b == r101.f503472b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f503473c, r101.f503473c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f503474d, r101.f503474d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f503471a * 31) + this.f503472b) * 31) + this.f503473c.hashCode()) * 31) + this.f503474d.hashCode();
    }

    public final String toString() {
        return "TtsOtherVoiceListRequest(pageIndex=" + this.f503471a + ", pageSize=" + this.f503472b + ", visitId=" + this.f503473c + ", languageCode=" + this.f503474d + ')';
    }

    static {
        Companion = new b();
    }

    public c(int r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "visitId");
        Intrinsics.checkNotNullParameter(r103, UserInfo.LANGUAGECODE);
        this.f503471a = r100;
        this.f503472b = r101;
        this.f503473c = r102;
        this.f503474d = r103;
    }

    public c(int r100, int r101, int r102, String r103, String r104) {
        if (15 != (r100 & 15)) goto L6;
        this.f503471a = r101;
        this.f503472b = r102;
        this.f503473c = r103;
        this.f503474d = r104;
        return;
    L6:
        b2.b(r100, 15, a.f503476b);
        throw null;
    }
}
