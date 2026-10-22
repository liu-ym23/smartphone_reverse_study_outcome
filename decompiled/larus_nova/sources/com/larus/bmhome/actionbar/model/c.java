package com.larus.bmhome.actionbar.model;

import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: classes25.dex */
@Serializable
public final class c {
    public static final b Companion = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f295017l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f295018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f295019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, String> f295020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f295021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g1 f295022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g1 f295023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g1 f295024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g1 f295025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f295026i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f295027j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f295028k;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295029a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295030b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295030b;
        }

        static {
            a r100 = new a();
            f295029a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ActionBarCommandOption", r100, 10);
            r101.j("id", true);
            r101.j("display_text", true);
            r101.j("params", true);
            r101.j("command", true);
            r101.j("icon", true);
            r101.j("dark_mode_icon", true);
            r101.j("right_icon", true);
            r101.j("dark_mode_right_icon", true);
            r101.j("android_status", true);
            r101.j("keep_skill_state", true);
            f295030b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = c.f295017l;
            nuc.w0 r101 = nuc.w0.f520792a;
            v2 r102 = v2.f520790a;
            g1.a r103 = g1.a.f295160a;
            return new juc.d[]{kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r100[2].getValue()), kuc.a.d(r102), kuc.a.d(r103), kuc.a.d(r103), kuc.a.d(r103), kuc.a.d(r103), kuc.a.d(r101), kuc.a.d(nuc.i.f520705a)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f295030b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = c.f295017l;
            int r103 = 9;
            int r110 = 8;
            String r111 = null;
            if (r101.decodeSequentially() == false) goto L5;
            nuc.w0 r104 = nuc.w0.f520792a;
            Integer r112 = (Integer) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            v2 r113 = v2.f520790a;
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 1, r113, null);
            HashMap r105 = (HashMap) r101.decodeNullableSerializableElement(r100, 2, r102[2].getValue(), null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 3, r113, null);
            g1.a r107 = g1.a.f295160a;
            g1 r115 = (g1) r101.decodeNullableSerializableElement(r100, 4, r107, null);
            g1 r108 = (g1) r101.decodeNullableSerializableElement(r100, 5, r107, null);
            g1 r109 = (g1) r101.decodeNullableSerializableElement(r100, 6, r107, null);
            g1 r116 = (g1) r101.decodeNullableSerializableElement(r100, 7, r107, null);
            Integer r117 = (Integer) r101.decodeNullableSerializableElement(r100, 8, r104, null);
            int r118 = 1023;
            Integer r119 = r117;
            g1 r120 = r108;
            g1 r121 = r109;
            g1 r122 = r116;
            Boolean r123 = (Boolean) r101.decodeNullableSerializableElement(r100, 9, nuc.i.f520705a, null);
            g1 r124 = r115;
            Integer r125 = r112;
            String r126 = r114;
            HashMap r127 = r105;
            String r128 = r106;
        L28:
            r101.endStructure(r100);
            return new c(r118, r125, r126, r127, r128, r124, r120, r121, r122, r119, r123);
        L5:
            g1 r129 = null;
            Boolean r130 = null;
            Integer r131 = null;
            g1 r132 = null;
            g1 r133 = null;
            r127 = null;
            g1 r134 = null;
            String r135 = null;
            Integer r136 = null;
            int r137 = 0;
            boolean r211 = true;
        L6:
            if (r211 == false) goto L27;
            int r138 = r101.decodeElementIndex(r100);
            switch(r138) {
                case -1: goto L26;
                case 0: goto L24;
                case 1: goto L22;
                case 2: goto L20;
                case 3: goto L18;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r138);
        L26:
            r110 = 8;
            r211 = false;
            goto L6
        L11:
            r130 = (Boolean) r101.decodeNullableSerializableElement(r100, r103, nuc.i.f520705a, r130);
            r137 = r137 | 512;
        L23:
            Integer r139 = r136;
        L25:
            r136 = r139;
            r103 = 9;
            r110 = 8;
            goto L6
        L12:
            r131 = (Integer) r101.decodeNullableSerializableElement(r100, r110, nuc.w0.f520792a, r131);
            r137 = r137 | 256;
            goto L23
        L13:
            r129 = (g1) r101.decodeNullableSerializableElement(r100, 7, g1.a.f295160a, r129);
            r137 = r137 | 128;
            goto L23
        L14:
            r132 = (g1) r101.decodeNullableSerializableElement(r100, 6, g1.a.f295160a, r132);
            r137 = r137 | 64;
            goto L23
        L15:
            r133 = (g1) r101.decodeNullableSerializableElement(r100, 5, g1.a.f295160a, r133);
            r137 = r137 | 32;
            goto L23
        L16:
            r134 = (g1) r101.decodeNullableSerializableElement(r100, 4, g1.a.f295160a, r134);
            r137 = r137 | 16;
            goto L23
        L18:
            r135 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r135);
            r137 = r137 | 8;
            goto L23
        L20:
            r137 = r137 | 4;
            r127 = (HashMap) r101.decodeNullableSerializableElement(r100, 2, r102[2].getValue(), r127);
            goto L23
        L22:
            r111 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r111);
            r137 = r137 | 2;
            goto L23
        L24:
            r139 = (Integer) r101.decodeNullableSerializableElement(r100, 0, nuc.w0.f520792a, r136);
            r137 = r137 | 1;
            goto L25
        L27:
            Integer r140 = r136;
            r122 = r129;
            r123 = r130;
            r119 = r131;
            r121 = r132;
            r126 = r111;
            r118 = r137;
            r124 = r134;
            r128 = r135;
            r120 = r133;
            r125 = r140;
            goto L28
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            c r112 = (c) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r112, "value");
            g2 r100 = f295030b;
            muc.d r113 = r110.beginStructure(r100);
            Lazy<juc.d<Object>>[] r101 = c.f295017l;
            boolean r102 = false;
            if (r113.shouldEncodeElementDefault(r100, 0) == true) goto L10;
            Integer r103 = r112.f295018a;
            if (r103 == null) goto L10;
            if (r103.intValue() != 0) goto L10;
            boolean r104 = false;
        L12:
            if (r104 == false) goto L15;
            r113.encodeNullableSerializableElement(r100, 0, nuc.w0.f520792a, r112.f295018a);
        L15:
            if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L18;
        L19:
            boolean r105 = true;
        L21:
            if (r105 == false) goto L24;
            r113.encodeNullableSerializableElement(r100, 1, v2.f520790a, r112.f295019b);
        L24:
            if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L27;
        L28:
            boolean r106 = true;
        L30:
            if (r106 == false) goto L33;
            r113.encodeNullableSerializableElement(r100, 2, r101[2].getValue(), r112.f295020c);
        L33:
            if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L36;
        L37:
            boolean r107 = true;
        L39:
            if (r107 == false) goto L42;
            r113.encodeNullableSerializableElement(r100, 3, v2.f520790a, r112.f295021d);
        L42:
            if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L45;
        L46:
            boolean r108 = true;
        L48:
            if (r108 == false) goto L51;
            r113.encodeNullableSerializableElement(r100, 4, g1.a.f295160a, r112.f295022e);
        L51:
            if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L54;
        L55:
            boolean r109 = true;
        L57:
            if (r109 == false) goto L60;
            r113.encodeNullableSerializableElement(r100, 5, g1.a.f295160a, r112.f295023f);
        L60:
            if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L63;
        L64:
            boolean r114 = true;
        L66:
            if (r114 == false) goto L69;
            r113.encodeNullableSerializableElement(r100, 6, g1.a.f295160a, r112.f295024g);
        L69:
            if (r113.shouldEncodeElementDefault(r100, 7) == false) goto L72;
        L73:
            boolean r115 = true;
        L75:
            if (r115 == false) goto L78;
            r113.encodeNullableSerializableElement(r100, 7, g1.a.f295160a, r112.f295025h);
        L78:
            if (r113.shouldEncodeElementDefault(r100, 8) == true) goto L85;
            Integer r116 = r112.f295026i;
            if (r116 == null) goto L85;
            if (r116.intValue() != 0) goto L85;
            boolean r117 = false;
        L87:
            if (r117 == false) goto L90;
            r113.encodeNullableSerializableElement(r100, 8, nuc.w0.f520792a, r112.f295026i);
        L90:
            if (r113.shouldEncodeElementDefault(r100, 9) == false) goto L93;
        L94:
            r102 = true;
        L95:
            if (r102 == false) goto L97;
            r113.encodeNullableSerializableElement(r100, 9, nuc.i.f520705a, r112.f295027j);
        L97:
            r113.endStructure(r100);
            return;
        L93:
            if (Intrinsics.areEqual(r112.f295027j, Boolean.FALSE) == true) goto L95;
        L85:
            r117 = true;
            goto L87
        L72:
            if (Intrinsics.areEqual(r112.f295025h, new g1("", "", null, null, 28)) == false) goto L73;
            r115 = false;
            goto L75
        L63:
            if (Intrinsics.areEqual(r112.f295024g, new g1("", "", null, null, 28)) == false) goto L64;
            r114 = false;
            goto L66
        L54:
            if (Intrinsics.areEqual(r112.f295023f, new g1("", "", null, null, 28)) == false) goto L55;
            r109 = false;
            goto L57
        L45:
            if (Intrinsics.areEqual(r112.f295022e, new g1("", "", null, null, 28)) == false) goto L46;
            r108 = false;
            goto L48
        L36:
            if (r112.f295021d != null) goto L37;
            r107 = false;
            goto L39
        L27:
            if (r112.f295020c != null) goto L28;
            r106 = false;
            goto L30
        L18:
            if (Intrinsics.areEqual(r112.f295019b, "") == false) goto L19;
            r105 = false;
        L10:
            r104 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.f295029a;
        }
    }

    public c() {
        this(null, null, null, null, null, null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f295018a, r101.f295018a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295019b, r101.f295019b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295020c, r101.f295020c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295021d, r101.f295021d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295022e, r101.f295022e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f295023f, r101.f295023f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f295024g, r101.f295024g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f295025h, r101.f295025h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f295026i, r101.f295026i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f295027j, r101.f295027j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f295018a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f295019b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        HashMap<String, String> r107 = this.f295020c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f295021d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        g1 r113 = this.f295022e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        g1 r116 = this.f295023f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        g1 r119 = this.f295024g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        g1 r122 = this.f295025h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.f295026i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.f295027j;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
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
        return "ActionBarCommandOption(id=" + this.f295018a + ", displayText=" + this.f295019b + ", params=" + this.f295020c + ", command=" + this.f295021d + ", icon=" + this.f295022e + ", darkModeIcon=" + this.f295023f + ", rightIcon=" + this.f295024g + ", darkModeRightIcon=" + this.f295025h + ", status=" + this.f295026i + ", keepSkillState=" + this.f295027j + ')';
    }

    static {
        Companion = new b();
        f295017l = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.f()), null, null, null, null, null, null, null};
    }

    public c(Integer r110, String r111, HashMap r210, String r211, g1 r212, g1 r213, int r214) {
        Integer r100 = 0;
        if ((r214 & 1) == 0) goto L5;
        Integer r101 = r100;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r102 = "";
    L10:
        Boolean r103 = null;
        if ((r214 & 4) == 0) goto L13;
        HashMap r104 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        g1 r106 = new g1("", "", null, null, 28);
    L23:
        if ((r214 & 32) == 0) goto L25;
        g1 r107 = new g1("", "", null, null, 28);
    L27:
        if ((r214 & 64) == 0) goto L29;
        g1 r112 = new g1("", "", null, null, 28);
    L31:
        if ((r214 & 128) == 0) goto L33;
        g1 r113 = new g1("", "", null, null, 28);
    L35:
        if ((r214 & 256) != 0) goto L39;
        r100 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        r103 = Boolean.FALSE;
    L41:
        this.f295018a = r101;
        this.f295019b = r102;
        this.f295020c = r104;
        this.f295021d = r105;
        this.f295022e = r106;
        this.f295023f = r107;
        this.f295024g = r112;
        this.f295025h = r113;
        this.f295026i = r100;
        this.f295027j = r103;
        this.f295028k = true;
        return;
    L33:
        r113 = null;
        goto L35
    L29:
        r112 = null;
        goto L31
    L25:
        r107 = r213;
        goto L27
    L21:
        r106 = r212;
        goto L23
    L17:
        r105 = r211;
        goto L19
    L13:
        r104 = r210;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }

    public c(int r110, Integer r111, String r112, HashMap r113, String r114, g1 r115, g1 r116, g1 r117, g1 r210, Integer r211, Boolean r212) {
        if ((r110 & 0) == 0) goto L5;
        nuc.b2.b(r110, 0, a.f295030b);
        throw null;
    L5:
        if ((r110 & 1) != 0) goto L7;
        this.f295018a = 0;
    L9:
        if ((r110 & 2) != 0) goto L11;
        String r100 = "";
    L12:
        this.f295019b = r100;
        if ((r110 & 4) != 0) goto L15;
        this.f295020c = null;
    L17:
        if ((r110 & 8) != 0) goto L19;
        this.f295021d = null;
    L21:
        if ((r110 & 16) != 0) goto L23;
        g1 r101 = new g1("", "", null, null, 28);
    L24:
        this.f295022e = r101;
        if ((r110 & 32) != 0) goto L27;
        g1 r102 = new g1("", "", null, null, 28);
    L28:
        this.f295023f = r102;
        if ((r110 & 64) != 0) goto L31;
        g1 r103 = new g1("", "", null, null, 28);
    L32:
        this.f295024g = r103;
        if ((r110 & 128) != 0) goto L35;
        g1 r104 = new g1("", "", null, null, 28);
    L36:
        this.f295025h = r104;
        if ((r110 & 256) != 0) goto L39;
        this.f295026i = 0;
    L41:
        if ((r110 & 512) != 0) goto L43;
        Boolean r105 = Boolean.FALSE;
    L44:
        this.f295027j = r105;
        this.f295028k = true;
        return;
    L43:
        r105 = r212;
        goto L44
    L39:
        this.f295026i = r211;
        goto L41
    L35:
        r104 = r210;
        goto L36
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
        this.f295021d = r114;
        goto L21
    L15:
        this.f295020c = r113;
        goto L17
    L11:
        r100 = r112;
        goto L12
    L7:
        this.f295018a = r111;
        goto L9
    }
}
