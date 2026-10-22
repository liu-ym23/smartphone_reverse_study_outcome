package com.larus.avlink.notification;

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
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes25.dex */
@Serializable
public final class b {
    public static final C4002b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f293471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f293472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f293473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f293474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f293475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f293476f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f293477g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f293478h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f293479a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f293480b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f293480b;
        }

        static {
            a r100 = new a();
            f293479a = r100;
            g2 r101 = new g2("com.larus.avlink.notification.UploadDoraStatusRequest", r100, 8);
            r101.j("user_id", true);
            r101.j("device_id", true);
            r101.j("connect_status", true);
            r101.j("a2dp", true);
            r101.j("hfp", true);
            r101.j("mic_occupy", true);
            r101.j("current_device_a2dp", true);
            r101.j("support_distinguish_a2dp", true);
            f293480b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            i r101 = i.f520705a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f293480b;
            c r101 = r210.beginStructure(r100);
            int r102 = 4;
            String r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            i r106 = i.f520705a;
            Boolean r107 = (Boolean) r101.decodeNullableSerializableElement(r100, 2, r106, null);
            Boolean r108 = (Boolean) r101.decodeNullableSerializableElement(r100, 3, r106, null);
            Boolean r109 = (Boolean) r101.decodeNullableSerializableElement(r100, 4, r106, null);
            Boolean r111 = (Boolean) r101.decodeNullableSerializableElement(r100, 5, r106, null);
            Boolean r112 = (Boolean) r101.decodeNullableSerializableElement(r100, 6, r106, null);
            Boolean r113 = (Boolean) r101.decodeNullableSerializableElement(r100, 7, r106, null);
            String r114 = r105;
            Boolean r115 = r109;
            Boolean r116 = r113;
            Boolean r117 = r112;
            Boolean r118 = r111;
            Boolean r119 = r108;
            Boolean r120 = r107;
            int r121 = 255;
        L24:
            r101.endStructure(r100);
            return new b(r121, r104, r114, r120, r119, r115, r118, r117, r116);
        L5:
            Boolean r122 = null;
            Boolean r123 = null;
            Boolean r124 = null;
            Boolean r125 = null;
            String r126 = null;
            Boolean r127 = null;
            Boolean r128 = null;
            int r129 = 0;
            boolean r130 = true;
        L6:
            if (r130 == false) goto L23;
            int r131 = r101.decodeElementIndex(r100);
            switch(r131) {
                case -1: goto L22;
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r131);
        L22:
            r102 = 4;
            r130 = false;
            goto L6
        L11:
            r125 = (Boolean) r101.decodeNullableSerializableElement(r100, 7, i.f520705a, r125);
            r129 = r129 | 128;
        L21:
            r102 = 4;
            goto L6
        L12:
            r123 = (Boolean) r101.decodeNullableSerializableElement(r100, 6, i.f520705a, r123);
            r129 = r129 | 64;
            goto L21
        L13:
            r128 = (Boolean) r101.decodeNullableSerializableElement(r100, 5, i.f520705a, r128);
            r129 = r129 | 32;
            goto L21
        L14:
            r124 = (Boolean) r101.decodeNullableSerializableElement(r100, r102, i.f520705a, r124);
            r129 = r129 | 16;
            goto L21
        L15:
            r122 = (Boolean) r101.decodeNullableSerializableElement(r100, 3, i.f520705a, r122);
            r129 = r129 | 8;
            goto L21
        L16:
            r127 = (Boolean) r101.decodeNullableSerializableElement(r100, 2, i.f520705a, r127);
            r129 = r129 | 4;
            goto L21
        L18:
            r110 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r110);
            r129 = r129 | 2;
            goto L21
        L20:
            r129 = r129 | 1;
            r126 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r126);
            goto L21
        L23:
            r119 = r122;
            r120 = r127;
            r121 = r129;
            r116 = r125;
            r118 = r128;
            String r132 = r126;
            r117 = r123;
            r104 = r132;
            String r133 = r110;
            r115 = r124;
            r114 = r133;
            goto L24
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            b r102 = (b) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f293480b;
            muc.d r104 = r100.beginStructure(r103);
            C4002b r105 = b.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f293471a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f293472b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeNullableSerializableElement(r103, 2, i.f520705a, r102.f293473c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            boolean r110 = true;
        L36:
            if (r110 == false) goto L39;
            r104.encodeNullableSerializableElement(r103, 3, i.f520705a, r102.f293474d);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
        L43:
            boolean r111 = true;
        L45:
            if (r111 == false) goto L48;
            r104.encodeNullableSerializableElement(r103, 4, i.f520705a, r102.f293475e);
        L48:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
        L52:
            boolean r112 = true;
        L54:
            if (r112 == false) goto L57;
            r104.encodeNullableSerializableElement(r103, 5, i.f520705a, r102.f293476f);
        L57:
            if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L60;
        L61:
            boolean r113 = true;
        L63:
            if (r113 == false) goto L66;
            r104.encodeNullableSerializableElement(r103, 6, i.f520705a, r102.f293477g);
        L66:
            if (r104.shouldEncodeElementDefault(r103, 7) == false) goto L69;
        L70:
            r106 = true;
        L71:
            if (r106 == false) goto L73;
            r104.encodeNullableSerializableElement(r103, 7, i.f520705a, r102.f293478h);
        L73:
            r104.endStructure(r103);
            return;
        L69:
            if (r102.f293478h == null) goto L71;
        L60:
            if (r102.f293477g != null) goto L61;
            r113 = false;
            goto L63
        L51:
            if (r102.f293476f != null) goto L52;
            r112 = false;
            goto L54
        L42:
            if (r102.f293475e != null) goto L43;
            r111 = false;
            goto L45
        L33:
            if (r102.f293474d != null) goto L34;
            r110 = false;
            goto L36
        L24:
            if (r102.f293473c != null) goto L25;
            r109 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r102.f293472b, "") == false) goto L16;
            r108 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r102.f293471a, "") == false) goto L7;
            r107 = false;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.notification.b$b, reason: collision with other inner class name */
    public static final class C4002b {
        public C4002b() {
        }

        public final d<b> serializer() {
            return a.f293479a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        Object[] r100 = 0 == true ? 1 : 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(null, r100, r101, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f293471a, r101.f293471a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f293472b, r101.f293472b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f293473c, r101.f293473c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f293474d, r101.f293474d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f293475e, r101.f293475e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f293476f, r101.f293476f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f293477g, r101.f293477g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f293478h, r101.f293478h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f293471a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f293472b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f293473c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f293474d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.f293475e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.f293476f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f293477g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.f293478h;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "UploadDoraStatusRequest(userId=" + this.f293471a + ", deviceId=" + this.f293472b + ", connectStatus=" + this.f293473c + ", a2dp=" + this.f293474d + ", hfp=" + this.f293475e + ", micOccupy=" + this.f293476f + ", currentDeviceA2dp=" + this.f293477g + ", supportDistinguishA2dp=" + this.f293478h + ')';
    }

    static {
        Companion = new C4002b();
    }

    public /* synthetic */ b(String r110, String r111, Boolean r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r113 & 32) == 0) goto L13;
        r112 = null;
    L13:
        this(r100, r101, null, null, null, r112, null, null);
        return;
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public b(String r100, String r101, Boolean r102, Boolean r103, Boolean r104, Boolean r105, Boolean r106, Boolean r107) {
        this.f293471a = r100;
        this.f293472b = r101;
        this.f293473c = r102;
        this.f293474d = r103;
        this.f293475e = r104;
        this.f293476f = r105;
        this.f293477g = r106;
        this.f293478h = r107;
    }

    public b(int r100, String r101, String r102, Boolean r103, Boolean r104, Boolean r105, Boolean r110, Boolean r111, Boolean r112) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f293480b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f293471a = "";
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f293472b = "";
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f293473c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f293474d = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f293475e = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f293476f = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.f293477g = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.f293478h = null;
        return;
    L35:
        this.f293478h = r112;
        return;
    L31:
        this.f293477g = r111;
        goto L33
    L27:
        this.f293476f = r110;
        goto L29
    L23:
        this.f293475e = r105;
        goto L25
    L19:
        this.f293474d = r104;
        goto L21
    L15:
        this.f293473c = r103;
        goto L17
    L11:
        this.f293472b = r102;
        goto L13
    L7:
        this.f293471a = r101;
        goto L9
    }
}
