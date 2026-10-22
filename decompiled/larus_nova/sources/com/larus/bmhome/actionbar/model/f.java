package com.larus.bmhome.actionbar.model;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: classes25.dex */
@Serializable
public final class f {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f295101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f295102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f295103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f295104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g1 f295105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g1 f295106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g1 f295107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f295108h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295109a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295110b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            nuc.g1 r100 = nuc.g1.f520681a;
            v2 r101 = v2.f520790a;
            g1.a r102 = g1.a.f295160a;
            return new juc.d[]{r100, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r102)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295110b;
        }

        static {
            a r100 = new a();
            f295109a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ActionBarDigitalAvatarTemplateItem", r100, 7);
            r101.j("id", true);
            r101.j("display_text", true);
            r101.j(TTDelegateActivity.MESSAGE_TEXT, true);
            r101.j("avatar_id", true);
            r101.j("icon", true);
            r101.j("icon_ori", true);
            r101.j("preview_icon", true);
            f295110b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f295110b;
            muc.c r101 = r210.beginStructure(r100);
            g1 r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            long r111 = r101.decodeLongElement(r100, 0);
            v2 r102 = v2.f520790a;
            String r103 = (String) r101.decodeNullableSerializableElement(r100, 1, r102, null);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 2, r102, null);
            Long r105 = (Long) r101.decodeNullableSerializableElement(r100, 3, nuc.g1.f520681a, null);
            g1.a r106 = g1.a.f295160a;
            g1 r107 = (g1) r101.decodeNullableSerializableElement(r100, 4, r106, null);
            g1 r108 = (g1) r101.decodeNullableSerializableElement(r100, 5, r106, null);
            Long r112 = r105;
            g1 r113 = r107;
            g1 r114 = (g1) r101.decodeNullableSerializableElement(r100, 6, r106, null);
            g1 r115 = r108;
            long r109 = r111;
            int r116 = 127;
            String r117 = r104;
            String r118 = r103;
        L21:
            r101.endStructure(r100);
            return new f(r116, r109, r118, r117, r112, r113, r115, r114);
        L5:
            String r119 = null;
            String r120 = null;
            Long r121 = null;
            long r122 = 0;
            int r123 = 0;
            boolean r124 = true;
            g1 r125 = null;
            g1 r126 = null;
        L6:
            if (r124 == false) goto L20;
            int r127 = r101.decodeElementIndex(r100);
            switch(r127) {
                case -1: goto L19;
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r127);
        L18:
            r122 = r101.decodeLongElement(r100, 0);
            r123 = r123 | 1;
            goto L6
        L19:
            r124 = false;
            goto L6
        L11:
            r123 = r123 | 64;
            r126 = (g1) r101.decodeNullableSerializableElement(r100, 6, g1.a.f295160a, r126);
            goto L6
        L12:
            r123 = r123 | 32;
            r125 = (g1) r101.decodeNullableSerializableElement(r100, 5, g1.a.f295160a, r125);
            goto L6
        L13:
            r123 = r123 | 16;
            r110 = (g1) r101.decodeNullableSerializableElement(r100, 4, g1.a.f295160a, r110);
            goto L6
        L14:
            r123 = r123 | 8;
            r121 = (Long) r101.decodeNullableSerializableElement(r100, 3, nuc.g1.f520681a, r121);
            goto L6
        L15:
            r123 = r123 | 4;
            r120 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r120);
            goto L6
        L16:
            r123 = r123 | 2;
            r119 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r119);
            goto L6
        L20:
            r116 = r123;
            String r128 = r120;
            r113 = r110;
            r109 = r122;
            r114 = r126;
            r117 = r128;
            Long r211 = r121;
            r115 = r125;
            r118 = r119;
            r112 = r211;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            f r112 = (f) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r112, "value");
            g2 r100 = f295110b;
            muc.d r113 = r110.beginStructure(r100);
            b r101 = f.Companion;
            boolean r102 = false;
            if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
        L7:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            r113.encodeLongElement(r100, 0, r112.f295101a);
        L12:
            if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
        L16:
            boolean r104 = true;
        L18:
            if (r104 == false) goto L21;
            r113.encodeNullableSerializableElement(r100, 1, v2.f520790a, r112.f295102b);
        L21:
            if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
        L25:
            boolean r105 = true;
        L27:
            if (r105 == false) goto L30;
            r113.encodeNullableSerializableElement(r100, 2, v2.f520790a, r112.f295103c);
        L30:
            if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
        L34:
            boolean r106 = true;
        L36:
            if (r106 == false) goto L39;
            r113.encodeNullableSerializableElement(r100, 3, nuc.g1.f520681a, r112.f295104d);
        L39:
            if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
        L43:
            boolean r107 = true;
        L45:
            if (r107 == false) goto L48;
            r113.encodeNullableSerializableElement(r100, 4, g1.a.f295160a, r112.f295105e);
        L48:
            if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L51;
        L52:
            boolean r108 = true;
        L54:
            if (r108 == false) goto L57;
            r113.encodeNullableSerializableElement(r100, 5, g1.a.f295160a, r112.f295106f);
        L57:
            if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L60;
        L61:
            r102 = true;
        L62:
            if (r102 == false) goto L64;
            r113.encodeNullableSerializableElement(r100, 6, g1.a.f295160a, r112.f295107g);
        L64:
            r113.endStructure(r100);
            return;
        L60:
            if (Intrinsics.areEqual(r112.f295107g, new g1("", "", null, null, 28)) == true) goto L62;
        L51:
            if (Intrinsics.areEqual(r112.f295106f, new g1("", "", null, null, 28)) == false) goto L52;
            r108 = false;
            goto L54
        L42:
            if (Intrinsics.areEqual(r112.f295105e, new g1("", "", null, null, 28)) == false) goto L43;
            r107 = false;
            goto L45
        L33:
            if (r112.f295104d != null) goto L34;
            r106 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r112.f295103c, "") == false) goto L25;
            r105 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r112.f295102b, "") == false) goto L16;
            r104 = false;
            goto L18
        L6:
            if (r112.f295101a != 0) goto L7;
            r103 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<f> serializer() {
            return a.f295109a;
        }
    }

    public f() {
        this(0, null, null, null, null, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f295101a == r101.f295101a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295102b, r101.f295102b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295103c, r101.f295103c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295104d, r101.f295104d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295105e, r101.f295105e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f295106f, r101.f295106f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f295107g, r101.f295107g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f295108h, r101.f295108h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f295101a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f295102b;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f295103c;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        Long r109 = this.f295104d;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        g1 r112 = this.f295105e;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        g1 r115 = this.f295106f;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        g1 r118 = this.f295107g;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        Integer r121 = this.f295108h;
        if (r121 == null) goto L31;
        r103 = r121.hashCode();
    L31:
        return r120 + r103;
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarDigitalAvatarTemplateItem(id=" + this.f295101a + ", displayText=" + this.f295102b + ", messageText=" + this.f295103c + ", avatarId=" + this.f295104d + ", thumbIcon=" + this.f295105e + ", originIcon=" + this.f295106f + ", previewIcon=" + this.f295107g + ", status=" + this.f295108h + ')';
    }

    static {
        Companion = new b();
    }

    public f(long r110, String r111, g1 r112, g1 r210, g1 r211, Integer r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        long r100 = 0;
    L6:
        String r101 = "";
        if ((r213 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r213 & 4) != 0) goto L15;
        r101 = r111;
    L15:
        if ((r213 & 16) == 0) goto L17;
        g1 r103 = new g1("", "", null, null, 28);
    L19:
        if ((r213 & 32) == 0) goto L21;
        g1 r104 = new g1("", "", null, null, 28);
    L23:
        if ((r213 & 64) == 0) goto L25;
        g1 r105 = new g1("", "", null, null, 28);
    L27:
        if ((r213 & 128) == 0) goto L29;
        Integer r106 = 0;
    L30:
        this.f295101a = r100;
        this.f295102b = r102;
        this.f295103c = r101;
        this.f295104d = null;
        this.f295105e = r103;
        this.f295106f = r104;
        this.f295107g = r105;
        this.f295108h = r106;
        return;
    L29:
        r106 = r212;
        goto L30
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r112;
        goto L19
    L9:
        r102 = null;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }

    public f(int r110, long r111, String r112, String r113, Long r114, g1 r115, g1 r116, g1 r117) {
        if ((r110 & 0) == 0) goto L5;
        nuc.b2.b(r110, 0, a.f295110b);
        throw null;
    L5:
        if ((r110 & 1) != 0) goto L7;
        long r100 = 0;
    L8:
        this.f295101a = r100;
        if ((r110 & 2) != 0) goto L11;
        this.f295102b = "";
    L13:
        if ((r110 & 4) != 0) goto L15;
        this.f295103c = "";
    L17:
        if ((r110 & 8) != 0) goto L19;
        this.f295104d = null;
    L21:
        if ((r110 & 16) != 0) goto L23;
        g1 r101 = new g1("", "", null, null, 28);
    L24:
        this.f295105e = r101;
        if ((r110 & 32) != 0) goto L27;
        g1 r102 = new g1("", "", null, null, 28);
    L28:
        this.f295106f = r102;
        if ((r110 & 64) != 0) goto L31;
        g1 r103 = new g1("", "", null, null, 28);
    L32:
        this.f295107g = r103;
        this.f295108h = 0;
        return;
    L31:
        r103 = r117;
        goto L32
    L27:
        r102 = r116;
        goto L28
    L23:
        r101 = r115;
        goto L24
    L19:
        this.f295104d = r114;
        goto L21
    L15:
        this.f295103c = r113;
        goto L17
    L11:
        this.f295102b = r112;
        goto L13
    L7:
        r100 = r111;
        goto L8
    }
}
