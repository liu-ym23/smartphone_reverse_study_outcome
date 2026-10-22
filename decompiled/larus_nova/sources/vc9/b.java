package vc9;

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

/* JADX INFO: loaded from: classes29.dex */
@Serializable
public final class b {
    public static final C7980b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f554137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f554138b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f554139a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f554140b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f554140b;
        }

        static {
            a r100 = new a();
            f554139a = r100;
            g2 r101 = new g2("com.larus.im.bean.cmd.SendCmdEntity", r100, 2);
            r101.j("key", true);
            r101.j("value", true);
            f554140b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f554140b;
            c r111 = r110.beginStructure(r100);
            String r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            v2 r102 = v2.f520790a;
            String r103 = (String) r111.decodeNullableSerializableElement(r100, 0, r102, null);
            String r104 = (String) r111.decodeNullableSerializableElement(r100, 1, r102, null);
            int r105 = 3;
        L17:
            r111.endStructure(r100);
            return new b(r105, r103, r104);
        L5:
            String r106 = null;
            int r107 = 0;
            boolean r108 = true;
        L6:
            if (r108 == false) goto L16;
            int r109 = r111.decodeElementIndex(r100);
            if (r109 != (-1)) goto L9;
            r108 = false;
            goto L6
        L9:
            if (r109 != 0) goto L10;
            r101 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, r101);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r109 != 1) goto L13;
            r106 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, r106);
            r107 = r107 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r109);
        L16:
            r105 = r107;
            r103 = r101;
            r104 = r106;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            b r102 = (b) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f554140b;
            muc.d r104 = r100.beginStructure(r103);
            C7980b r105 = b.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f554137a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f554138b);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (Intrinsics.areEqual(r102.f554138b, "") == true) goto L17;
        L6:
            if (Intrinsics.areEqual(r102.f554137a, "") == false) goto L7;
            r107 = false;
            goto L9
        }
    }

    /* JADX INFO: renamed from: vc9.b$b, reason: collision with other inner class name */
    public static final class C7980b {
        public C7980b() {
        }

        public final d<b> serializer() {
            return a.f554139a;
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
        if (Intrinsics.areEqual(this.f554137a, r101.f554137a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f554138b, r101.f554138b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f554137a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f554138b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SendCmdEntity(key=" + this.f554137a + ", value=" + this.f554138b + ')';
    }

    static {
        Companion = new C7980b();
    }

    public b() {
        this("", "");
    }

    public b(String r100, String r101) {
        this.f554137a = r100;
        this.f554138b = r101;
    }

    public b(int r100, String r101, String r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f554140b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f554137a = "";
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f554138b = "";
        return;
    L11:
        this.f554138b = r102;
        return;
    L7:
        this.f554137a = r101;
        goto L9
    }
}
