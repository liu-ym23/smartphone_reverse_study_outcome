package com.larus.avlink.autoGreet;

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

/* JADX INFO: loaded from: classes23.dex */
@Serializable
public final class g {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f291681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f291682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f291683c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f291684a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f291685b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(f.a.f291679a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f291685b;
        }

        static {
            a r100 = new a();
            f291684a = r100;
            g2 r101 = new g2("com.larus.avlink.autoGreet.UploadDoraEventRequest", r100, 3);
            r101.j("user_id", true);
            r101.j("device_id", true);
            r101.j("event", true);
            f291685b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f291685b;
            muc.c r111 = r110.beginStructure(r100);
            String r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            v2 r102 = v2.f520790a;
            String r103 = (String) r111.decodeNullableSerializableElement(r100, 0, r102, null);
            String r104 = (String) r111.decodeNullableSerializableElement(r100, 1, r102, null);
            f r105 = (f) r111.decodeNullableSerializableElement(r100, 2, f.a.f291679a, null);
            int r106 = 7;
        L19:
            r111.endStructure(r100);
            return new g(r106, r103, r104, r105);
        L5:
            String r107 = null;
            f r108 = null;
            int r109 = 0;
            boolean r112 = true;
        L6:
            if (r112 == false) goto L18;
            int r113 = r111.decodeElementIndex(r100);
            if (r113 != (-1)) goto L9;
            r112 = false;
            goto L6
        L9:
            if (r113 != 0) goto L10;
            r101 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, r101);
            r109 = r109 | 1;
            goto L6
        L10:
            if (r113 != 1) goto L11;
            r107 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, r107);
            r109 = r109 | 2;
            goto L6
        L11:
            if (r113 != 2) goto L14;
            r108 = (f) r111.decodeNullableSerializableElement(r100, 2, f.a.f291679a, r108);
            r109 = r109 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r113);
        L18:
            r106 = r109;
            r103 = r101;
            r104 = r107;
            r105 = r108;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            g r102 = (g) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f291685b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = g.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f291681a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f291682b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            r106 = true;
        L26:
            if (r106 == false) goto L28;
            r104.encodeNullableSerializableElement(r103, 2, f.a.f291679a, r102.f291683c);
        L28:
            r104.endStructure(r103);
            return;
        L24:
            if (r102.f291683c == null) goto L26;
        L15:
            if (r102.f291682b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f291681a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<g> serializer() {
            return a.f291684a;
        }
    }

    public g() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f291681a, r101.f291681a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f291682b, r101.f291682b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f291683c, r101.f291683c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f291681a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f291682b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        f r107 = this.f291683c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UploadDoraEventRequest(userId=" + this.f291681a + ", deviceId=" + this.f291682b + ", event=" + this.f291683c + ')';
    }

    static {
        Companion = new b();
    }

    public g(String r100, String r101, f r102) {
        this.f291681a = r100;
        this.f291682b = r101;
        this.f291683c = r102;
    }

    public g(int r100, String r101, String r102, f r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f291685b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f291681a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f291682b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f291683c = null;
        return;
    L15:
        this.f291683c = r103;
        return;
    L11:
        this.f291682b = r102;
        goto L13
    L7:
        this.f291681a = r101;
        goto L9
    }
}
