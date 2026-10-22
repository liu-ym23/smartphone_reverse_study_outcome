package com.bytedance.bdnavigationsdk.navigation;

import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.l0;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class h {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f200076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f200077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f200078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f200079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Float f200080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f200081f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f200082a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f200083b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            w0 r100 = w0.f520792a;
            v2 r101 = v2.f520790a;
            return new juc.d[]{r100, r100, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(l0.f520731a), kuc.a.d(r101)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f200083b;
        }

        static {
            a r100 = new a();
            f200082a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.navigation.NavigationInstruction", r100, 6);
            r101.j(ForwardDependency$ForwardLocation.FLAG, true);
            r101.j("action", true);
            r101.j("main_action", true);
            r101.j("assist_action", true);
            r101.j("distance", true);
            r101.j("road_name", true);
            f200083b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f200083b;
            muc.c r101 = r110.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            int r102 = r101.decodeIntElement(r100, 0);
            int r103 = r101.decodeIntElement(r100, 1);
            v2 r104 = v2.f520790a;
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 2, r104, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 3, r104, null);
            int r107 = r102;
            String r111 = r105;
            Float r112 = (Float) r101.decodeNullableSerializableElement(r100, 4, l0.f520731a, null);
            int r113 = r103;
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 5, r104, null);
            String r115 = r106;
            int r108 = 63;
        L20:
            r101.endStructure(r100);
            return new h(r108, r107, r113, r111, r115, r112, r114);
        L5:
            r111 = null;
            Float r116 = null;
            String r117 = null;
            r114 = null;
            int r109 = 0;
            int r118 = 0;
            int r119 = 0;
            boolean r120 = true;
        L6:
            if (r120 == false) goto L19;
            int r121 = r101.decodeElementIndex(r100);
            switch(r121) {
                case -1: goto L18;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r121);
        L17:
            r109 = r101.decodeIntElement(r100, 0);
            r119 = r119 | 1;
            goto L6
        L18:
            r120 = false;
            goto L6
        L11:
            r119 = r119 | 32;
            r114 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r114);
            goto L6
        L12:
            r119 = r119 | 16;
            r116 = (Float) r101.decodeNullableSerializableElement(r100, 4, l0.f520731a, r116);
            goto L6
        L13:
            r119 = r119 | 8;
            r117 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r117);
            goto L6
        L14:
            r119 = r119 | 4;
            r111 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r111);
            goto L6
        L15:
            r118 = r101.decodeIntElement(r100, 1);
            r119 = r119 | 2;
            goto L6
        L19:
            r108 = r119;
            r113 = r118;
            r107 = r109;
            String r122 = r117;
            r112 = r116;
            r115 = r122;
            goto L20
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            h r102 = (h) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f200083b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = h.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeIntElement(r103, 0, r102.f200076a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeIntElement(r103, 1, r102.f200077b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeNullableSerializableElement(r103, 2, v2.f520790a, r102.f200078c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            boolean r110 = true;
        L36:
            if (r110 == false) goto L39;
            r104.encodeNullableSerializableElement(r103, 3, v2.f520790a, r102.f200079d);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
        L43:
            boolean r111 = true;
        L45:
            if (r111 == false) goto L48;
            r104.encodeNullableSerializableElement(r103, 4, l0.f520731a, r102.f200080e);
        L48:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
        L52:
            r106 = true;
        L53:
            if (r106 == false) goto L55;
            r104.encodeNullableSerializableElement(r103, 5, v2.f520790a, r102.f200081f);
        L55:
            r104.endStructure(r103);
            return;
        L51:
            if (r102.f200081f == null) goto L53;
        L42:
            if (r102.f200080e != null) goto L43;
            r111 = false;
            goto L45
        L33:
            if (r102.f200079d != null) goto L34;
            r110 = false;
            goto L36
        L24:
            if (r102.f200078c != null) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f200077b != 0) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f200076a != 0) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<h> serializer() {
            return a.f200082a;
        }
    }

    public h() {
        int r100 = 0;
        this(r100, r100, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f200076a == r101.f200076a) goto L12;
        return false;
    L12:
        if (this.f200077b == r101.f200077b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f200078c, r101.f200078c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f200079d, r101.f200079d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f200080e, r101.f200080e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f200081f, r101.f200081f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f200076a * 31) + this.f200077b) * 31;
        String r101 = this.f200078c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f200079d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Float r108 = this.f200080e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f200081f;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    static {
        Companion = new b();
    }

    public final String a() {
        int r100 = this.f200076a;
        String r101 = "Error";
        if (r100 == 0) goto L52;
        String r102 = "";
        if (r100 != 1) goto L7;
        Float r103 = this.f200080e;
        if (r103 == null) goto L42;
        String r104 = com.bytedance.bdnavigationsdk.utils.f.a(r103.floatValue());
        if (r104 == null) goto L42;
        r102 = r104;
    L42:
        String r105 = this.f200078c;
        if (r105 == null) goto L46;
        r101 = r105;
    L46:
        String r106 = r101 + r102;
        String r107 = this.f200081f;
        if (r107 == null) goto L77;
        String r108 = "沿" + r107 + "," + r106;
        if (r108 == null) goto L77;
    L78:
        return r108;
    L77:
        return r106;
    L7:
        if (r100 != 2) goto L79;
        r106 = this.f200079d;
        if (r106 != null) goto L13;
        r106 = "Error";
    L13:
        if (this.f200078c == null) goto L15;
    L19:
        Float r109 = this.f200080e;
        if (r109 == null) goto L25;
        String r110 = com.bytedance.bdnavigationsdk.utils.f.a(r109.floatValue()) + "后" + r106;
        if (r110 == null) goto L25;
        r106 = r110;
    L25:
        String r111 = this.f200078c;
        if (r111 == null) goto L29;
        r108 = r111 + r106;
        if (r108 == null) goto L29;
    L30:
        String r112 = this.f200081f;
        if (r112 == null) goto L78;
        r106 = "沿" + r112 + "," + r108;
        if (r106 != null) goto L77;
    L29:
        r108 = "Error" + r106;
        goto L30
    L15:
        if (this.f200080e != null) goto L19;
        if (this.f200081f != null) goto L19;
    L79:
        return "";
    L52:
        String r113 = this.f200079d;
        if (r113 == null) goto L57;
        String r114 = this.f200081f;
        if (r114 == null) goto L57;
        String r115 = r113.concat(r114);
    L58:
        String r116 = this.f200078c;
        if (r116 == null) goto L62;
        if (r115 == null) goto L62;
        r101 = r116 + "," + r115;
    L68:
        Float r117 = this.f200080e;
        if (r117 == null) goto L74;
        String r118 = com.bytedance.bdnavigationsdk.utils.f.a(r117.floatValue()) + "后" + r101;
        if (r118 == null) goto L74;
        String r119 = r118;
    L75:
        Intrinsics.checkNotNull(r119);
        return r119;
    L74:
        r119 = r101;
    L62:
        if (r116 == null) goto L65;
        if (r115 != null) goto L65;
        r101 = r116;
    L65:
        if (r116 != null) goto L68;
        if (r115 == null) goto L68;
        r101 = "Error," + r115;
    L57:
        r115 = null;
        goto L58
    }

    public final String toString() {
        return "NavigationInstruction{flag=" + this.f200076a + ", action=" + this.f200077b + ", mainAction='" + this.f200078c + "', assistAction='" + this.f200079d + "', distance=" + this.f200080e + ", roadName='" + this.f200081f + "'}";
    }

    public /* synthetic */ h(int r110, int r111, String r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r113 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r113 & 8) == 0) goto L13;
        r112 = null;
    L13:
        this(r100, r101, null, r112, null, null);
        return;
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public h(int r100, int r101, String r102, String r103, Float r104, String r105) {
        this.f200076a = r100;
        this.f200077b = r101;
        this.f200078c = r102;
        this.f200079d = r103;
        this.f200080e = r104;
        this.f200081f = r105;
    }

    public h(int r100, int r101, int r102, String r103, String r104, Float r105, String r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f200083b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f200076a = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f200077b = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f200078c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f200079d = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f200080e = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f200081f = null;
        return;
    L27:
        this.f200081f = r110;
        return;
    L23:
        this.f200080e = r105;
        goto L25
    L19:
        this.f200079d = r104;
        goto L21
    L15:
        this.f200078c = r103;
        goto L17
    L11:
        this.f200077b = r102;
        goto L13
    L7:
        this.f200076a = r101;
        goto L9
    }
}
