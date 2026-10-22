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
import nuc.w0;

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class a {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f503463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f503464b;

    /* JADX INFO: renamed from: kh9.a$a, reason: collision with other inner class name */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class C6556a implements m0<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C6556a f503465a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f503466b = null;

        public C6556a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{v2.f520790a, w0.f520792a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f503466b;
        }

        static {
            C6556a r100 = new C6556a();
            f503465a = r100;
            g2 r101 = new g2("com.larus.kmp.voice_setting.voice.request.ImageUploadFileHead", r100, 2);
            r101.j("file_type", false);
            r101.j("biz_type", false);
            f503466b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f503466b;
            muc.c r111 = r110.beginStructure(r100);
            if (r111.decodeSequentially() == false) goto L5;
            String r101 = r111.decodeStringElement(r100, 0);
            int r102 = r111.decodeIntElement(r100, 1);
            int r103 = 3;
        L17:
            r111.endStructure(r100);
            return new a(r103, r101, r102);
        L5:
            r101 = null;
            int r104 = 0;
            int r105 = 0;
            boolean r106 = true;
        L6:
            if (r106 == false) goto L16;
            int r107 = r111.decodeElementIndex(r100);
            if (r107 != (-1)) goto L9;
            r106 = false;
            goto L6
        L9:
            if (r107 != 0) goto L10;
            r101 = r111.decodeStringElement(r100, 0);
            r105 = r105 | 1;
            goto L6
        L10:
            if (r107 != 1) goto L13;
            r104 = r111.decodeIntElement(r100, 1);
            r105 = r105 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r107);
        L16:
            r102 = r104;
            r103 = r105;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            a r102 = (a) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f503466b;
            muc.d r104 = r100.beginStructure(r103);
            r104.encodeStringElement(r103, 0, r102.f503463a);
            r104.encodeIntElement(r103, 1, r102.f503464b);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<a> serializer() {
            return C6556a.f503465a;
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
        if (Intrinsics.areEqual(this.f503463a, r101.f503463a) == true) goto L12;
        return false;
    L12:
        if (this.f503464b == r101.f503464b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f503463a.hashCode() * 31) + this.f503464b;
    }

    public final String toString() {
        return "ImageUploadFileHead(fileType=" + this.f503463a + ", bizType=" + this.f503464b + ')';
    }

    static {
        Companion = new b();
    }

    public a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "fileType");
        this.f503463a = r100;
        this.f503464b = r101;
    }

    public a(int r100, String r101, int r102) {
        if (3 != (r100 & 3)) goto L6;
        this.f503463a = r101;
        this.f503464b = r102;
        return;
    L6:
        b2.b(r100, 3, C6556a.f503466b);
        throw null;
    }
}
