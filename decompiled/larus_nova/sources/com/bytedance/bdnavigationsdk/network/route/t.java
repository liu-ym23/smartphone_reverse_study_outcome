package com.bytedance.bdnavigationsdk.network.route;

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

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class t {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f200282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f200283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f200284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f200285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f200286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f200287f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<t> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f200288a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f200289b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            w0 r100 = w0.f520792a;
            v2 r101 = v2.f520790a;
            return new juc.d[]{u.f200290a, r100, r100, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f200289b;
        }

        static {
            a r100 = new a();
            f200288a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.network.route.RouteVisualInstruction", r100, 6);
            r101.j("remain_distance", true);
            r101.j("mode", true);
            r101.j("action", true);
            r101.j("main_action", true);
            r101.j("assist_action", true);
            r101.j("road_name", true);
            f200289b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f200289b;
            muc.c r101 = r110.beginStructure(r100);
            int r102 = 2;
            if (r101.decodeSequentially() == false) goto L5;
            int r103 = ((Number) r101.decodeSerializableElement(r100, 0, u.f200290a, 0)).intValue();
            int r104 = r101.decodeIntElement(r100, 1);
            int r105 = r101.decodeIntElement(r100, 2);
            v2 r106 = v2.f520790a;
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 3, r106, null);
            int r111 = r103;
            int r112 = r105;
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 4, r106, null);
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 5, r106, null);
            int r115 = r104;
            String r116 = r107;
            int r108 = 63;
        L21:
            r101.endStructure(r100);
            return new t(r108, r111, r115, r112, r116, r113, r114);
        L5:
            String r117 = null;
            r116 = null;
            r113 = null;
            int r109 = 0;
            int r118 = 0;
            int r119 = 0;
            int r120 = 0;
            boolean r121 = true;
        L6:
            if (r121 == false) goto L20;
            int r122 = r101.decodeElementIndex(r100);
            switch(r122) {
                case -1: goto L19;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r122);
        L19:
            r102 = 2;
            r121 = false;
            goto L6
        L11:
            r117 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r117);
            int r123 = r120 | 32;
        L16:
            r120 = r123;
        L18:
            r102 = 2;
            goto L6
        L12:
            r113 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r113);
            r123 = r120 | 16;
            goto L16
        L13:
            r116 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r116);
            r123 = r120 | 8;
            goto L16
        L14:
            r118 = r101.decodeIntElement(r100, r102);
            r123 = r120 | 4;
            goto L16
        L15:
            r119 = r101.decodeIntElement(r100, 1);
            r123 = r120 | 2;
            goto L16
        L17:
            r109 = ((Number) r101.decodeSerializableElement(r100, 0, u.f200290a, Integer.valueOf(r109))).intValue();
            r120 = r120 | 1;
            goto L18
        L20:
            r114 = r117;
            r112 = r118;
            r108 = r120;
            r115 = r119;
            r111 = r109;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            t r102 = (t) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f200289b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = t.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeSerializableElement(r103, 0, u.f200290a, Integer.valueOf(r102.f200282a));
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeIntElement(r103, 1, r102.f200283b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeIntElement(r103, 2, r102.f200284c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            boolean r110 = true;
        L36:
            if (r110 == false) goto L39;
            r104.encodeNullableSerializableElement(r103, 3, v2.f520790a, r102.f200285d);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
        L43:
            boolean r111 = true;
        L45:
            if (r111 == false) goto L48;
            r104.encodeNullableSerializableElement(r103, 4, v2.f520790a, r102.f200286e);
        L48:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
        L52:
            r106 = true;
        L53:
            if (r106 == false) goto L55;
            r104.encodeNullableSerializableElement(r103, 5, v2.f520790a, r102.f200287f);
        L55:
            r104.endStructure(r103);
            return;
        L51:
            if (r102.f200287f == null) goto L53;
        L42:
            if (r102.f200286e != null) goto L43;
            r111 = false;
            goto L45
        L33:
            if (r102.f200285d != null) goto L34;
            r110 = false;
            goto L36
        L24:
            if (r102.f200284c != 0) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f200283b != 1) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f200282a != 0) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<t> serializer() {
            return a.f200288a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (this.f200282a == r101.f200282a) goto L12;
        return false;
    L12:
        if (this.f200283b == r101.f200283b) goto L15;
        return false;
    L15:
        if (this.f200284c == r101.f200284c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f200285d, r101.f200285d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f200286e, r101.f200286e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f200287f, r101.f200287f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f200282a * 31) + this.f200283b) * 31) + this.f200284c) * 31;
        String r101 = this.f200285d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f200286e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f200287f;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RouteVisualInstruction(remainDistance=" + this.f200282a + ", mode=" + this.f200283b + ", action=" + this.f200284c + ", mainAction=" + this.f200285d + ", assistAction=" + this.f200286e + ", roadName=" + this.f200287f + ")";
    }

    static {
        Companion = new b();
    }

    public t() {
        this.f200282a = 0;
        this.f200283b = 1;
        this.f200284c = 0;
        this.f200285d = null;
        this.f200286e = null;
        this.f200287f = null;
    }

    public t(int r100, int r101, int r102, int r103, String r104, String r105, String r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f200289b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f200282a = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f200283b = 1;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f200284c = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f200285d = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f200286e = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f200287f = null;
        return;
    L27:
        this.f200287f = r110;
        return;
    L23:
        this.f200286e = r105;
        goto L25
    L19:
        this.f200285d = r104;
        goto L21
    L15:
        this.f200284c = r103;
        goto L17
    L11:
        this.f200283b = r102;
        goto L13
    L7:
        this.f200282a = r101;
        goto L9
    }
}
