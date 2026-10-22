package com.bytedance.bdnavigationsdk.network.route;

import com.monitor.cloudmessage.consts.CloudControlInf;
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

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class p {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f200257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f200258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f200259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f200260d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f200261a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f200262b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(d.a.f200217a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f200262b;
        }

        static {
            a r100 = new a();
            f200261a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.network.route.RouteResponse", r100, 4);
            r101.j("code", true);
            r101.j("message", true);
            r101.j("count", true);
            r101.j(CloudControlInf.ROUTE, true);
            f200262b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f200262b;
            muc.c r101 = r110.beginStructure(r100);
            String r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            d r112 = (d) r101.decodeNullableSerializableElement(r100, 3, d.a.f200217a, null);
            String r113 = r104;
            String r114 = r105;
            int r115 = 15;
        L21:
            r101.endStructure(r100);
            return new p(r115, r113, r114, r111, r112);
        L5:
            String r106 = null;
            String r107 = null;
            d r116 = null;
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
            r106 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r106);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r107 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r107);
            r108 = r108 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r116 = (d) r101.decodeNullableSerializableElement(r100, 3, d.a.f200217a, r116);
            r108 = r108 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r115 = r108;
            r113 = r102;
            r114 = r106;
            r111 = r107;
            r112 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            p r102 = (p) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f200262b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = p.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f200257a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f200258b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeNullableSerializableElement(r103, 2, v2.f520790a, r102.f200259c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            r106 = true;
        L35:
            if (r106 == false) goto L37;
            r104.encodeNullableSerializableElement(r103, 3, d.a.f200217a, r102.f200260d);
        L37:
            r104.endStructure(r103);
            return;
        L33:
            if (r102.f200260d == null) goto L35;
        L24:
            if (r102.f200259c != null) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f200258b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f200257a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<p> serializer() {
            return a.f200261a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f200257a, r101.f200257a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f200258b, r101.f200258b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f200259c, r101.f200259c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f200260d, r101.f200260d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f200257a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f200258b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f200259c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        d r110 = this.f200260d;
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

    static {
        Companion = new b();
    }

    public final String toString() {
        return "RouteResponse{code='" + this.f200257a + "', message='" + this.f200258b + "', count='" + this.f200259c + "', route=" + this.f200260d + com.alipay.sdk.m.u.i.f25855d;
    }

    public p() {
        this.f200257a = null;
        this.f200258b = null;
        this.f200259c = null;
        this.f200260d = null;
    }

    public p(int r100, String r101, String r102, String r103, d r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f200262b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f200257a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f200258b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f200259c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f200260d = null;
        return;
    L19:
        this.f200260d = r104;
        return;
    L15:
        this.f200259c = r103;
        goto L17
    L11:
        this.f200258b = r102;
        goto L13
    L7:
        this.f200257a = r101;
        goto L9
    }
}
