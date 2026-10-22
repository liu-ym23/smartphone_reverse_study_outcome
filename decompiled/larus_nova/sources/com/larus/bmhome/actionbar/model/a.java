package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public final class a {
    public static final b Companion = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f294945k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f294946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f294947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f294948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, String> f294949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g1 f294950e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g1 f294951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g1 f294952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g1 f294953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f294954i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<w> f294955j;

    /* JADX INFO: renamed from: com.larus.bmhome.actionbar.model.a$a, reason: collision with other inner class name */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class C4015a implements nuc.m0<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4015a f294956a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f294957b = null;

        public C4015a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f294957b;
        }

        static {
            C4015a r100 = new C4015a();
            f294956a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ActionBarButtonRouterTemplate", r100, 10);
            r101.j("id", true);
            r101.j("display_text", true);
            r101.j("schema", true);
            r101.j("params", true);
            r101.j("icon", true);
            r101.j("dark_mode_icon", true);
            r101.j("right_icon", true);
            r101.j("dark_mode_right_icon", true);
            r101.j("keep_skill_state", true);
            r101.j("option_list", true);
            f294957b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = a.f294945k;
            v2 r101 = v2.f520790a;
            g1.a r102 = g1.a.f295160a;
            return new juc.d[]{kuc.a.d(nuc.w0.f520792a), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r100[3].getValue()), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(nuc.i.f520705a), kuc.a.d(r100[9].getValue())};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f294957b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = a.f294945k;
            int r103 = 9;
            Integer r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            Integer r104 = (Integer) r101.decodeNullableSerializableElement(r100, 0, nuc.w0.f520792a, null);
            v2 r111 = v2.f520790a;
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 1, r111, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 2, r111, null);
            HashMap r106 = (HashMap) r101.decodeNullableSerializableElement(r100, 3, r102[3].getValue(), null);
            g1.a r113 = g1.a.f295160a;
            g1 r114 = (g1) r101.decodeNullableSerializableElement(r100, 4, r113, null);
            g1 r107 = (g1) r101.decodeNullableSerializableElement(r100, 5, r113, null);
            g1 r108 = (g1) r101.decodeNullableSerializableElement(r100, 6, r113, null);
            g1 r109 = (g1) r101.decodeNullableSerializableElement(r100, 7, r113, null);
            Boolean r115 = (Boolean) r101.decodeNullableSerializableElement(r100, 8, nuc.i.f520705a, null);
            List r211 = (List) r101.decodeNullableSerializableElement(r100, 9, r102[9].getValue(), null);
            r110 = r104;
            HashMap r116 = r106;
            g1 r117 = r107;
            g1 r212 = r108;
            g1 r213 = r109;
            String r118 = r105;
            g1 r119 = r114;
            Boolean r214 = r115;
            String r120 = r112;
            int r121 = 1023;
        L29:
            r101.endStructure(r100);
            return new a(r121, r110, r120, r118, r116, r119, r117, r212, r213, r214, r211);
        L5:
            g1 r122 = null;
            g1 r123 = null;
            List r124 = null;
            Boolean r125 = null;
            g1 r126 = null;
            g1 r127 = null;
            String r128 = null;
            HashMap r129 = null;
            r120 = null;
            int r130 = 0;
            boolean r215 = true;
        L6:
            if (r215 == false) goto L28;
            int r131 = r101.decodeElementIndex(r100);
            switch(r131) {
                case -1: goto L27;
                case 0: goto L25;
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L18;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r131);
        L27:
            r102 = r102;
            r215 = false;
            goto L6
        L11:
            r124 = (List) r101.decodeNullableSerializableElement(r100, r103, r102[r103].getValue(), r124);
            r130 = r130 | 512;
            goto L6
        L13:
            r125 = (Boolean) r101.decodeNullableSerializableElement(r100, 8, nuc.i.f520705a, r125);
            r130 = r130 | 256;
        L19:
            r102 = r102;
        L26:
            r102 = r102;
            r103 = 9;
            goto L6
        L14:
            r127 = (g1) r101.decodeNullableSerializableElement(r100, 7, g1.a.f295160a, r127);
            r130 = r130 | 128;
            goto L19
        L15:
            r123 = (g1) r101.decodeNullableSerializableElement(r100, 6, g1.a.f295160a, r123);
            r130 = r130 | 64;
            goto L19
        L16:
            r126 = (g1) r101.decodeNullableSerializableElement(r100, 5, g1.a.f295160a, r126);
            r130 = r130 | 32;
            goto L19
        L18:
            r122 = (g1) r101.decodeNullableSerializableElement(r100, 4, g1.a.f295160a, r122);
            r130 = r130 | 16;
            goto L19
        L20:
            r129 = (HashMap) r101.decodeNullableSerializableElement(r100, 3, r102[3].getValue(), r129);
            r130 = r130 | 8;
            goto L26
        L21:
            r128 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r128);
            r130 = r130 | 4;
            goto L26
        L23:
            r102 = r102;
            r120 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r120);
            r130 = r130 | 2;
            goto L26
        L25:
            r102 = r102;
            r130 = r130 | 1;
            r110 = (Integer) r101.decodeNullableSerializableElement(r100, 0, nuc.w0.f520792a, r110);
            goto L26
        L28:
            r119 = r122;
            r212 = r123;
            r211 = r124;
            r214 = r125;
            r117 = r126;
            r213 = r127;
            r118 = r128;
            r116 = r129;
            r121 = r130;
            goto L29
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            a r112 = (a) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r112, "value");
            g2 r100 = f294957b;
            muc.d r113 = r110.beginStructure(r100);
            Lazy<juc.d<Object>>[] r101 = a.f294945k;
            boolean r102 = false;
            if (r113.shouldEncodeElementDefault(r100, 0) == true) goto L10;
            Integer r103 = r112.f294946a;
            if (r103 == null) goto L10;
            if (r103.intValue() != 0) goto L10;
            boolean r104 = false;
        L12:
            if (r104 == false) goto L15;
            r113.encodeNullableSerializableElement(r100, 0, nuc.w0.f520792a, r112.f294946a);
        L15:
            if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L18;
        L19:
            boolean r105 = true;
        L21:
            if (r105 == false) goto L24;
            r113.encodeNullableSerializableElement(r100, 1, v2.f520790a, r112.f294947b);
        L24:
            if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L27;
        L28:
            boolean r106 = true;
        L30:
            if (r106 == false) goto L33;
            r113.encodeNullableSerializableElement(r100, 2, v2.f520790a, r112.f294948c);
        L33:
            if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L36;
        L37:
            boolean r107 = true;
        L39:
            if (r107 == false) goto L42;
            r113.encodeNullableSerializableElement(r100, 3, r101[3].getValue(), r112.f294949d);
        L42:
            if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L45;
        L46:
            boolean r108 = true;
        L48:
            if (r108 == false) goto L51;
            r113.encodeNullableSerializableElement(r100, 4, g1.a.f295160a, r112.f294950e);
        L51:
            if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L54;
        L55:
            boolean r109 = true;
        L57:
            if (r109 == false) goto L60;
            r113.encodeNullableSerializableElement(r100, 5, g1.a.f295160a, r112.f294951f);
        L60:
            if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L63;
        L64:
            boolean r114 = true;
        L66:
            if (r114 == false) goto L69;
            r113.encodeNullableSerializableElement(r100, 6, g1.a.f295160a, r112.f294952g);
        L69:
            if (r113.shouldEncodeElementDefault(r100, 7) == false) goto L72;
        L73:
            boolean r115 = true;
        L75:
            if (r115 == false) goto L78;
            r113.encodeNullableSerializableElement(r100, 7, g1.a.f295160a, r112.f294953h);
        L78:
            if (r113.shouldEncodeElementDefault(r100, 8) == false) goto L81;
        L82:
            boolean r116 = true;
        L84:
            if (r116 == false) goto L87;
            r113.encodeNullableSerializableElement(r100, 8, nuc.i.f520705a, r112.f294954i);
        L87:
            if (r113.shouldEncodeElementDefault(r100, 9) == false) goto L90;
        L91:
            r102 = true;
        L92:
            if (r102 == false) goto L94;
            r113.encodeNullableSerializableElement(r100, 9, r101[9].getValue(), r112.f294955j);
        L94:
            r113.endStructure(r100);
            return;
        L90:
            if (Intrinsics.areEqual(r112.f294955j, new ArrayList()) == true) goto L92;
        L81:
            if (Intrinsics.areEqual(r112.f294954i, Boolean.FALSE) == false) goto L82;
            r116 = false;
            goto L84
        L72:
            if (Intrinsics.areEqual(r112.f294953h, new g1("", "", null, null, 28)) == false) goto L73;
            r115 = false;
            goto L75
        L63:
            if (Intrinsics.areEqual(r112.f294952g, new g1("", "", null, null, 28)) == false) goto L64;
            r114 = false;
            goto L66
        L54:
            if (Intrinsics.areEqual(r112.f294951f, new g1("", "", null, null, 28)) == false) goto L55;
            r109 = false;
            goto L57
        L45:
            if (Intrinsics.areEqual(r112.f294950e, new g1("", "", null, null, 28)) == false) goto L46;
            r108 = false;
            goto L48
        L36:
            if (r112.f294949d != null) goto L37;
            r107 = false;
            goto L39
        L27:
            if (Intrinsics.areEqual(r112.f294948c, "") == false) goto L28;
            r106 = false;
            goto L30
        L18:
            if (Intrinsics.areEqual(r112.f294947b, "") == false) goto L19;
            r105 = false;
        L10:
            r104 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<a> serializer() {
            return C4015a.f294956a;
        }
    }

    public a() {
        this(null, null, null, null, null, null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f294946a, r101.f294946a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f294947b, r101.f294947b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f294948c, r101.f294948c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f294949d, r101.f294949d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f294950e, r101.f294950e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f294951f, r101.f294951f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f294952g, r101.f294952g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f294953h, r101.f294953h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f294954i, r101.f294954i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f294955j, r101.f294955j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f294946a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f294947b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f294948c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        HashMap<String, String> r110 = this.f294949d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        g1 r113 = this.f294950e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        g1 r116 = this.f294951f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        g1 r119 = this.f294952g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        g1 r122 = this.f294953h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.f294954i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        List<w> r128 = this.f294955j;
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
        return "ActionBarButtonRouterTemplate(id=" + this.f294946a + ", displayText=" + this.f294947b + ", schema=" + this.f294948c + ", params=" + this.f294949d + ", icon=" + this.f294950e + ", darkModeIcon=" + this.f294951f + ", rightIcon=" + this.f294952g + ", darkModeRightIcon=" + this.f294953h + ", keepSkillState=" + this.f294954i + ", optionList=" + this.f294955j + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f294945k = new Lazy[]{null, null, null, LazyKt.lazy(r100, new wa8.c()), null, null, null, null, null, LazyKt.lazy(r100, new wa8.d())};
    }

    public a(Integer r110, String r111, String r112, HashMap r210, g1 r211, g1 r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        Integer r100 = 0;
    L6:
        String r101 = "";
        if ((r213 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r213 & 4) != 0) goto L14;
        r101 = r112;
    L14:
        ArrayList r103 = null;
        if ((r213 & 8) == 0) goto L17;
        HashMap r104 = null;
    L19:
        if ((r213 & 16) == 0) goto L21;
        g1 r105 = new g1("", "", null, null, 28);
    L23:
        if ((r213 & 32) == 0) goto L25;
        g1 r106 = new g1("", "", null, null, 28);
    L27:
        if ((r213 & 64) == 0) goto L29;
        g1 r107 = new g1("", "", null, null, 28);
    L31:
        if ((r213 & 128) == 0) goto L33;
        g1 r113 = new g1("", "", null, null, 28);
    L35:
        if ((r213 & 256) == 0) goto L37;
        Boolean r114 = Boolean.FALSE;
    L39:
        if ((r213 & 512) == 0) goto L41;
        r103 = new ArrayList();
    L41:
        this.f294946a = r100;
        this.f294947b = r102;
        this.f294948c = r101;
        this.f294949d = r104;
        this.f294950e = r105;
        this.f294951f = r106;
        this.f294952g = r107;
        this.f294953h = r113;
        this.f294954i = r114;
        this.f294955j = r103;
        return;
    L37:
        r114 = null;
        goto L39
    L33:
        r113 = null;
        goto L35
    L29:
        r107 = null;
        goto L31
    L25:
        r106 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
        goto L19
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }

    public a(int r110, Integer r111, String r112, String r113, HashMap r114, g1 r115, g1 r116, g1 r117, g1 r118, Boolean r119, List r210) {
        if ((r110 & 0) == 0) goto L5;
        nuc.b2.b(r110, 0, C4015a.f294957b);
        throw null;
    L5:
        if ((r110 & 1) != 0) goto L7;
        Integer r100 = 0;
    L8:
        this.f294946a = r100;
        if ((r110 & 2) != 0) goto L11;
        this.f294947b = "";
    L13:
        if ((r110 & 4) != 0) goto L15;
        this.f294948c = "";
    L17:
        if ((r110 & 8) != 0) goto L19;
        this.f294949d = null;
    L21:
        if ((r110 & 16) != 0) goto L23;
        g1 r101 = new g1("", "", null, null, 28);
    L24:
        this.f294950e = r101;
        if ((r110 & 32) != 0) goto L27;
        g1 r102 = new g1("", "", null, null, 28);
    L28:
        this.f294951f = r102;
        if ((r110 & 64) != 0) goto L31;
        g1 r103 = new g1("", "", null, null, 28);
    L32:
        this.f294952g = r103;
        if ((r110 & 128) != 0) goto L35;
        g1 r104 = new g1("", "", null, null, 28);
    L36:
        this.f294953h = r104;
        if ((r110 & 256) != 0) goto L39;
        Boolean r105 = Boolean.FALSE;
    L40:
        this.f294954i = r105;
        if ((r110 & 512) != 0) goto L43;
        List r106 = new ArrayList();
    L44:
        this.f294955j = r106;
        return;
    L43:
        r106 = r210;
        goto L44
    L39:
        r105 = r119;
        goto L40
    L35:
        r104 = r118;
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
        this.f294949d = r114;
        goto L21
    L15:
        this.f294948c = r113;
        goto L17
    L11:
        this.f294947b = r112;
        goto L13
    L7:
        r100 = r111;
        goto L8
    }
}
