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
public final class p1 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f295383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f295384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f295385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g1 f295386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g1 f295387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f295388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f295389g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<p1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295390a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295391b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            g1.a r101 = g1.a.f295160a;
            return new juc.d[]{kuc.a.d(nuc.w0.f520792a), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(nuc.i.f520705a), kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295391b;
        }

        static {
            a r100 = new a();
            f295390a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.MsgInstructionItem", r100, 7);
            r101.j("id", true);
            r101.j("display_text", true);
            r101.j(TTDelegateActivity.MESSAGE_TEXT, true);
            r101.j("icon", true);
            r101.j("dark_mode_icon", true);
            r101.j("require_media", true);
            r101.j("redirect_schema", true);
            f295391b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f295391b;
            muc.c r101 = r110.beginStructure(r100);
            int r102 = 2;
            Integer r111 = null;
            if (r101.decodeSequentially() == false) goto L5;
            Integer r103 = (Integer) r101.decodeNullableSerializableElement(r100, 0, nuc.w0.f520792a, null);
            v2 r104 = v2.f520790a;
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r104, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 2, r104, null);
            g1.a r112 = g1.a.f295160a;
            g1 r107 = (g1) r101.decodeNullableSerializableElement(r100, 3, r112, null);
            g1 r108 = (g1) r101.decodeNullableSerializableElement(r100, 4, r112, null);
            Boolean r109 = (Boolean) r101.decodeNullableSerializableElement(r100, 5, nuc.i.f520705a, null);
            r111 = r103;
            String r113 = r106;
            g1 r114 = r108;
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 6, r104, null);
            String r116 = r105;
            Boolean r117 = r109;
            g1 r118 = r107;
            int r119 = 127;
        L23:
            r101.endStructure(r100);
            return new p1(r119, r111, r116, r113, r118, r114, r117, r115);
        L5:
            g1 r120 = null;
            r116 = null;
            String r121 = null;
            String r122 = null;
            Boolean r123 = null;
            g1 r124 = null;
            int r125 = 0;
            boolean r126 = true;
        L6:
            if (r126 == false) goto L22;
            int r127 = r101.decodeElementIndex(r100);
            switch(r127) {
                case -1: goto L21;
                case 0: goto L19;
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r127);
        L21:
            r102 = 2;
            r126 = false;
            goto L6
        L11:
            r121 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r121);
            r125 = r125 | 64;
        L20:
            r102 = 2;
            goto L6
        L12:
            r123 = (Boolean) r101.decodeNullableSerializableElement(r100, 5, nuc.i.f520705a, r123);
            r125 = r125 | 32;
            goto L20
        L13:
            r120 = (g1) r101.decodeNullableSerializableElement(r100, 4, g1.a.f295160a, r120);
            r125 = r125 | 16;
            goto L20
        L14:
            r124 = (g1) r101.decodeNullableSerializableElement(r100, 3, g1.a.f295160a, r124);
            r125 = r125 | 8;
            goto L20
        L15:
            r122 = (String) r101.decodeNullableSerializableElement(r100, r102, v2.f520790a, r122);
            r125 = r125 | 4;
            goto L20
        L17:
            r116 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r116);
            r125 = r125 | 2;
            goto L20
        L19:
            r125 = r125 | 1;
            r111 = (Integer) r101.decodeNullableSerializableElement(r100, 0, nuc.w0.f520792a, r111);
            goto L20
        L22:
            r119 = r125;
            r115 = r121;
            r113 = r122;
            r118 = r124;
            r117 = r123;
            r114 = r120;
            goto L23
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            p1 r102 = (p1) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295391b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = p1.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == true) goto L10;
            Integer r107 = r102.f295383a;
            if (r107 == null) goto L10;
            if (r107.intValue() != (-1)) goto L10;
            boolean r108 = false;
        L12:
            if (r108 == false) goto L15;
            r104.encodeNullableSerializableElement(r103, 0, nuc.w0.f520792a, r102.f295383a);
        L15:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L18;
        L19:
            boolean r109 = true;
        L21:
            if (r109 == false) goto L24;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f295384b);
        L24:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L27;
        L28:
            boolean r110 = true;
        L30:
            if (r110 == false) goto L33;
            r104.encodeNullableSerializableElement(r103, 2, v2.f520790a, r102.f295385c);
        L33:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L36;
        L37:
            boolean r111 = true;
        L39:
            if (r111 == false) goto L42;
            r104.encodeNullableSerializableElement(r103, 3, g1.a.f295160a, r102.f295386d);
        L42:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L45;
        L46:
            boolean r112 = true;
        L48:
            if (r112 == false) goto L51;
            r104.encodeNullableSerializableElement(r103, 4, g1.a.f295160a, r102.f295387e);
        L51:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L54;
        L55:
            boolean r113 = true;
        L57:
            if (r113 == false) goto L60;
            r104.encodeNullableSerializableElement(r103, 5, nuc.i.f520705a, r102.f295388f);
        L60:
            if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L63;
        L64:
            r106 = true;
        L65:
            if (r106 == false) goto L67;
            r104.encodeNullableSerializableElement(r103, 6, v2.f520790a, r102.f295389g);
        L67:
            r104.endStructure(r103);
            return;
        L63:
            if (r102.f295389g == null) goto L65;
        L54:
            if (Intrinsics.areEqual(r102.f295388f, Boolean.FALSE) == false) goto L55;
            r113 = false;
            goto L57
        L45:
            if (r102.f295387e != null) goto L46;
            r112 = false;
            goto L48
        L36:
            if (r102.f295386d != null) goto L37;
            r111 = false;
            goto L39
        L27:
            if (Intrinsics.areEqual(r102.f295385c, "") == false) goto L28;
            r110 = false;
            goto L30
        L18:
            if (Intrinsics.areEqual(r102.f295384b, "") == false) goto L19;
            r109 = false;
        L10:
            r108 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<p1> serializer() {
            return a.f295390a;
        }
    }

    public p1() {
        Boolean r100 = Boolean.FALSE;
        this.f295383a = -1;
        this.f295384b = "";
        this.f295385c = "";
        this.f295386d = null;
        this.f295387e = null;
        this.f295388f = r100;
        this.f295389g = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p1) == true) goto L8;
        return false;
    L8:
        p1 r101 = (p1) r100;
        if (Intrinsics.areEqual(this.f295383a, r101.f295383a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295384b, r101.f295384b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295385c, r101.f295385c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295386d, r101.f295386d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295387e, r101.f295387e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f295388f, r101.f295388f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f295389g, r101.f295389g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f295383a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f295384b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f295385c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        g1 r110 = this.f295386d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        g1 r113 = this.f295387e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.f295388f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f295389g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "MsgInstructionItem(id=" + this.f295383a + ", displayText=" + this.f295384b + ", messageText=" + this.f295385c + ", icon=" + this.f295386d + ", darkModeIcon=" + this.f295387e + ", requireMedia=" + this.f295388f + ", redirectSchema=" + this.f295389g + ')';
    }

    static {
        Companion = new b();
    }

    public final Integer a() {
        return this.f295383a;
    }

    public p1(int r100, Integer r101, String r102, String r103, g1 r104, g1 r105, Boolean r106, String r110) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295391b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = -1;
    L7:
        this.f295383a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f295384b = "";
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f295385c = "";
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.f295386d = null;
    L20:
        if ((r100 & 16) != 0) goto L22;
        this.f295387e = null;
    L24:
        if ((r100 & 32) != 0) goto L26;
        this.f295388f = Boolean.FALSE;
    L28:
        if ((r100 & 64) != 0) goto L30;
        this.f295389g = null;
        return;
    L30:
        this.f295389g = r110;
        return;
    L26:
        this.f295388f = r106;
        goto L28
    L22:
        this.f295387e = r105;
        goto L24
    L18:
        this.f295386d = r104;
        goto L20
    L14:
        this.f295385c = r103;
        goto L16
    L10:
        this.f295384b = r102;
        goto L12
    }
}
