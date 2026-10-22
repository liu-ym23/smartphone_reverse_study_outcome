package com.larus.bmhome.actionbar.model;

import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.ArrayList;
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
public final class r {
    public static final b Companion = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f295407m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f295408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<u> f295409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h1 f295410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f295411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j1 f295412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f295413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f295414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f295415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final y f295416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f295417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f295418k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i1 f295419l;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<r> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295420a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295421b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295421b;
        }

        static {
            a r100 = new a();
            f295420a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ActionBarInstructionConf", r100, 12);
            r101.j("instruction_type", true);
            r101.j("instruction_item_list", true);
            r101.j("input_box_content", true);
            r101.j("persistent", true);
            r101.j("ext", true);
            r101.j("use_template_id", true);
            r101.j("starling_name", true);
            r101.j("enter_independent_page", true);
            r101.j("menu_conf", true);
            r101.j("template_enhance", true);
            r101.j("input_type", true);
            r101.j("input_box_settings", true);
            f295421b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = r.f295407m;
            nuc.w0 r101 = nuc.w0.f520792a;
            nuc.i r102 = nuc.i.f520705a;
            v2 r103 = v2.f520790a;
            return new juc.d[]{kuc.a.d(r101), kuc.a.d(r100[1].getValue()), kuc.a.d(h1.a.f295190a), kuc.a.d(r102), kuc.a.d(j1.a.f295253a), kuc.a.d(r103), kuc.a.d(r103), kuc.a.d(r102), kuc.a.d(y.a.f295567a), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d(i1.a.f295202a)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f295421b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = r.f295407m;
            int r110 = 9;
            int r111 = 8;
            Boolean r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            nuc.w0 r104 = nuc.w0.f520792a;
            Integer r112 = (Integer) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            List r105 = (List) r101.decodeNullableSerializableElement(r100, 1, r102[1].getValue(), null);
            h1 r113 = (h1) r101.decodeNullableSerializableElement(r100, 2, h1.a.f295190a, null);
            nuc.i r114 = nuc.i.f520705a;
            Boolean r106 = (Boolean) r101.decodeNullableSerializableElement(r100, 3, r114, null);
            j1 r107 = (j1) r101.decodeNullableSerializableElement(r100, 4, j1.a.f295253a, null);
            v2 r115 = v2.f520790a;
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 5, r115, null);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 6, r115, null);
            Boolean r116 = (Boolean) r101.decodeNullableSerializableElement(r100, 7, r114, null);
            y r117 = (y) r101.decodeNullableSerializableElement(r100, 8, y.a.f295567a, null);
            Boolean r118 = (Boolean) r101.decodeNullableSerializableElement(r100, 9, r114, null);
            Integer r119 = (Integer) r101.decodeNullableSerializableElement(r100, 10, r104, null);
            List r120 = r105;
            Integer r211 = r119;
            i1 r212 = (i1) r101.decodeNullableSerializableElement(r100, 11, i1.a.f295202a, null);
            j1 r121 = r107;
            Boolean r122 = r106;
            String r123 = r108;
            String r124 = r109;
            Boolean r125 = r116;
            Boolean r213 = r118;
            y r214 = r117;
            Integer r126 = r112;
            h1 r127 = r113;
            int r128 = UnixStat.PERM_MASK;
        L34:
            r101.endStructure(r100);
            return new r(r128, r126, r120, r127, r122, r121, r123, r124, r125, r214, r213, r211, r212);
        L5:
            int r129 = 11;
            h1 r130 = null;
            Boolean r131 = null;
            Integer r132 = null;
            Boolean r133 = null;
            y r134 = null;
            String r135 = null;
            i1 r136 = null;
            j1 r215 = null;
            String r216 = null;
            Integer r217 = null;
            List r218 = null;
            int r137 = 0;
            boolean r219 = true;
        L6:
            if (r219 == false) goto L33;
            int r138 = r101.decodeElementIndex(r100);
            switch(r138) {
                case -1: goto L30;
                case 0: goto L29;
                case 1: goto L28;
                case 2: goto L26;
                case 3: goto L25;
                case 4: goto L23;
                case 5: goto L21;
                case 6: goto L20;
                case 7: goto L17;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L11;
                default: goto L10;
            };
        L11:
            r137 = r137 | 2048;
            r136 = (i1) r101.decodeNullableSerializableElement(r100, r129, i1.a.f295202a, r136);
            r215 = r215;
            r216 = r216;
        L12:
            List r139 = r218;
        L32:
            r216 = r216;
            r218 = r139;
            r215 = r215;
            r102 = r102;
            r129 = 11;
            r110 = 9;
            r111 = 8;
            goto L6
        L13:
            r132 = (Integer) r101.decodeNullableSerializableElement(r100, 10, nuc.w0.f520792a, r132);
            r137 = r137 | 1024;
        L18:
            j1 r140 = r215;
            r216 = r216;
        L27:
            r215 = r140;
            goto L12
        L14:
            r131 = (Boolean) r101.decodeNullableSerializableElement(r100, r110, nuc.i.f520705a, r131);
            r137 = r137 | 512;
            goto L18
        L15:
            r134 = (y) r101.decodeNullableSerializableElement(r100, r111, y.a.f295567a, r134);
            r137 = r137 | 256;
            goto L18
        L17:
            r133 = (Boolean) r101.decodeNullableSerializableElement(r100, 7, nuc.i.f520705a, r133);
            r137 = r137 | 128;
            goto L18
        L20:
            r135 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r135);
            r137 = r137 | 64;
        L22:
            r140 = r215;
            r216 = r216;
            goto L27
        L21:
            r216 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r216);
            r137 = r137 | 32;
            goto L22
        L23:
            r216 = r216;
            r140 = (j1) r101.decodeNullableSerializableElement(r100, 4, j1.a.f295253a, r215);
            r137 = r137 | 16;
            goto L27
        L25:
            r216 = r216;
            r103 = (Boolean) r101.decodeNullableSerializableElement(r100, 3, nuc.i.f520705a, r103);
            r137 = r137 | 8;
            r140 = r215;
            goto L27
        L26:
            r216 = r216;
            r130 = (h1) r101.decodeNullableSerializableElement(r100, 2, h1.a.f295190a, r130);
            r137 = r137 | 4;
            r140 = r215;
            goto L27
        L28:
            r215 = r215;
            r216 = r216;
            r218 = (List) r101.decodeNullableSerializableElement(r100, 1, r102[1].getValue(), r218);
            r137 = r137 | 2;
            goto L12
        L29:
            Integer r141 = r217;
            List r220 = r218;
            Integer r142 = (Integer) r101.decodeNullableSerializableElement(r100, 0, nuc.w0.f520792a, r141);
            r137 = r137 | 1;
        L31:
            List r221 = r220;
            r217 = r142;
            r139 = r221;
            goto L32
        L30:
            r142 = r217;
            r220 = r218;
            r219 = false;
            goto L31
        L10:
            throw new UnknownFieldException(r138);
        L33:
            r123 = r216;
            r213 = r131;
            r211 = r132;
            r121 = r215;
            r125 = r133;
            r214 = r134;
            r124 = r135;
            r212 = r136;
            r120 = r218;
            r122 = r103;
            r127 = r130;
            r128 = r137;
            r126 = r217;
            goto L34
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            r r102 = (r) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295421b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = r.f295407m;
            int r106 = 0;
            if (r104.shouldEncodeElementDefault(r103, 0) == true) goto L10;
            Integer r107 = r102.f295408a;
            if (r107 == null) goto L10;
            if (r107.intValue() != 0) goto L10;
            boolean r108 = false;
        L12:
            if (r108 == false) goto L15;
            r104.encodeNullableSerializableElement(r103, 0, nuc.w0.f520792a, r102.f295408a);
        L15:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L18;
        L19:
            boolean r109 = true;
        L21:
            if (r109 == false) goto L24;
            r104.encodeNullableSerializableElement(r103, 1, r105[1].getValue(), r102.f295409b);
        L24:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L27;
        L28:
            boolean r110 = true;
        L30:
            if (r110 == false) goto L33;
            r104.encodeNullableSerializableElement(r103, 2, h1.a.f295190a, r102.f295410c);
        L33:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L36;
        L37:
            boolean r111 = true;
        L39:
            if (r111 == false) goto L42;
            r104.encodeNullableSerializableElement(r103, 3, nuc.i.f520705a, r102.f295411d);
        L42:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L45;
        L46:
            boolean r112 = true;
        L48:
            if (r112 == false) goto L51;
            r104.encodeNullableSerializableElement(r103, 4, j1.a.f295253a, r102.f295412e);
        L51:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L54;
        L55:
            boolean r113 = true;
        L57:
            if (r113 == false) goto L60;
            r104.encodeNullableSerializableElement(r103, 5, v2.f520790a, r102.f295413f);
        L60:
            if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L63;
        L64:
            boolean r114 = true;
        L66:
            if (r114 == false) goto L69;
            r104.encodeNullableSerializableElement(r103, 6, v2.f520790a, r102.f295414g);
        L69:
            if (r104.shouldEncodeElementDefault(r103, 7) == false) goto L72;
        L73:
            boolean r115 = true;
        L75:
            if (r115 == false) goto L78;
            r104.encodeNullableSerializableElement(r103, 7, nuc.i.f520705a, r102.f295415h);
        L78:
            if (r104.shouldEncodeElementDefault(r103, 8) == false) goto L81;
        L82:
            boolean r116 = true;
        L84:
            if (r116 == false) goto L87;
            r104.encodeNullableSerializableElement(r103, 8, y.a.f295567a, r102.f295416i);
        L87:
            if (r104.shouldEncodeElementDefault(r103, 9) == false) goto L90;
        L91:
            boolean r117 = true;
        L93:
            if (r117 == false) goto L96;
            r104.encodeNullableSerializableElement(r103, 9, nuc.i.f520705a, r102.f295417j);
        L96:
            if (r104.shouldEncodeElementDefault(r103, 10) == false) goto L99;
        L100:
            boolean r118 = true;
        L102:
            if (r118 == false) goto L105;
            r104.encodeNullableSerializableElement(r103, 10, nuc.w0.f520792a, r102.f295418k);
        L105:
            if (r104.shouldEncodeElementDefault(r103, 11) == false) goto L108;
        L109:
            r106 = 1;
        L110:
            if (r106 == 0) goto L112;
            r104.encodeNullableSerializableElement(r103, 11, i1.a.f295202a, r102.f295419l);
        L112:
            r104.endStructure(r103);
            return;
        L108:
            if (r102.f295419l == null) goto L110;
        L99:
            if (r102.f295418k != null) goto L100;
            r118 = false;
            goto L102
        L90:
            if (r102.f295417j != null) goto L91;
            r117 = false;
            goto L93
        L81:
            if (Intrinsics.areEqual(r102.f295416i, new y(r106)) == false) goto L82;
            r116 = false;
            goto L84
        L72:
            if (r102.f295415h != null) goto L73;
            r115 = false;
            goto L75
        L63:
            if (Intrinsics.areEqual(r102.f295414g, "") == false) goto L64;
            r114 = false;
            goto L66
        L54:
            if (r102.f295413f != null) goto L55;
            r113 = false;
            goto L57
        L45:
            if (r102.f295412e != null) goto L46;
            r112 = false;
            goto L48
        L36:
            if (Intrinsics.areEqual(r102.f295411d, Boolean.FALSE) == false) goto L37;
            r111 = false;
            goto L39
        L27:
            if (r102.f295410c != null) goto L28;
            r110 = false;
            goto L30
        L18:
            if (Intrinsics.areEqual(r102.f295409b, new ArrayList()) == false) goto L19;
            r109 = false;
        L10:
            r108 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<r> serializer() {
            return a.f295420a;
        }
    }

    public r() {
        this(null, null, null, null, null, null, null, null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f295408a, r101.f295408a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295409b, r101.f295409b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295410c, r101.f295410c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295411d, r101.f295411d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295412e, r101.f295412e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f295413f, r101.f295413f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f295414g, r101.f295414g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f295415h, r101.f295415h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f295416i, r101.f295416i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f295417j, r101.f295417j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f295418k, r101.f295418k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f295419l, r101.f295419l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f295408a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<u> r104 = this.f295409b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        h1 r107 = this.f295410c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f295411d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        j1 r113 = this.f295412e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f295413f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f295414g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.f295415h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        y r125 = this.f295416i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.f295417j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.f295418k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        i1 r134 = this.f295419l;
        if (r134 == null) goto L51;
        r101 = r134.hashCode();
    L51:
        return r133 + r101;
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
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
        return "ActionBarInstructionConf(instructionType=" + this.f295408a + ", instructionItems=" + this.f295409b + ", inputBoxContent=" + this.f295410c + ", persistent=" + this.f295411d + ", ext=" + this.f295412e + ", useTemplateId=" + this.f295413f + ", starlingName=" + this.f295414g + ", enterIndependentPage=" + this.f295415h + ", menuConf=" + this.f295416i + ", templateEnhance=" + this.f295417j + ", inputType=" + this.f295418k + ", inputBoxSettings=" + this.f295419l + ')';
    }

    static {
        Companion = new b();
        f295407m = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.v()), null, null, null, null, null, null, null, null, null, null};
    }

    public final String b() {
        Integer r100 = this.f295408a;
        if (r100 != null) goto L6;
    L7:
        if (r100 != null) goto L10;
    L12:
        if (r100 != null) goto L15;
    L17:
        if (r100 == null) goto L24;
        r100.intValue();
        return "ai_generate_feed_image";
    L24:
        return "ai_generate_feed_image";
    L15:
        if (r100.intValue() != 18) goto L17;
        return "ai_generate_feed_video";
    L10:
        if (r100.intValue() != 16) goto L12;
        return "ai_generate_feed_image";
    L6:
        if (r100.intValue() != 4) goto L7;
        return "ai_generate_feed_image";
    }

    public final boolean f() {
        Boolean r100 = this.f295415h;
        Boolean r101 = Boolean.TRUE;
        if (Intrinsics.areEqual(r100, r101) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(this.f295417j, r101) == true) goto L8;
        return false;
    }

    public final List<u> c() {
        return this.f295409b;
    }

    public final Integer d() {
        return this.f295408a;
    }

    public final String e() {
        return this.f295414g;
    }

    public static r a(r r110, List r111, h1 r112, j1 r210, y r211, int r212) {
        i1 r100 = null;
        if ((r212 & 1) == 0) goto L5;
        Integer r101 = r110.f295408a;
    L7:
        if ((r212 & 2) == 0) goto L9;
        List r102 = r110.f295409b;
    L11:
        if ((r212 & 4) == 0) goto L13;
        h1 r103 = r110.f295410c;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Boolean r104 = r110.f295411d;
    L19:
        if ((r212 & 16) == 0) goto L21;
        j1 r105 = r110.f295412e;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r113 = r110.f295413f;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r114 = r110.f295414g;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Boolean r115 = r110.f295415h;
    L35:
        if ((r212 & 256) == 0) goto L37;
        y r116 = r110.f295416i;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Boolean r117 = r110.f295417j;
    L43:
        if ((r212 & 1024) == 0) goto L45;
        Integer r118 = r110.f295418k;
    L47:
        if ((r212 & 2048) == 0) goto L50;
        r100 = r110.f295419l;
    L50:
        return new r(r101, r102, r103, r104, r105, r113, r114, r115, r116, r117, r118, r100);
    L45:
        r118 = null;
        goto L47
    L41:
        r117 = null;
        goto L43
    L37:
        r116 = r211;
        goto L39
    L33:
        r115 = null;
        goto L35
    L29:
        r114 = null;
        goto L31
    L25:
        r113 = null;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ r(Integer r110, List r111, h1 r112, j1 r210, String r211, String r212, Boolean r213, y r214, int r215) {
        int r100 = 0;
        if ((r215 & 1) == 0) goto L5;
        Integer r101 = 0;
    L7:
        if ((r215 & 2) == 0) goto L9;
        List r102 = new ArrayList();
    L11:
        if ((r215 & 4) == 0) goto L13;
        h1 r103 = null;
    L15:
        if ((r215 & 8) == 0) goto L17;
        Boolean r104 = Boolean.FALSE;
    L19:
        if ((r215 & 16) == 0) goto L21;
        j1 r105 = null;
    L23:
        if ((r215 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r215 & 64) == 0) goto L29;
        String r113 = "";
    L31:
        if ((r215 & 128) == 0) goto L33;
        Boolean r114 = null;
    L35:
        if ((r215 & 256) == 0) goto L37;
        y r115 = new y(r100);
    L38:
        this(r101, r102, r103, r104, r105, r106, r113, r114, r115, null, null, null);
        return;
    L37:
        r115 = r214;
        goto L38
    L33:
        r114 = r213;
        goto L35
    L29:
        r113 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public r(Integer r100, List<u> r101, h1 r102, Boolean r103, j1 r104, String r105, String r106, Boolean r107, y r108, Boolean r110, Integer r111, i1 r112) {
        this.f295408a = r100;
        this.f295409b = r101;
        this.f295410c = r102;
        this.f295411d = r103;
        this.f295412e = r104;
        this.f295413f = r105;
        this.f295414g = r106;
        this.f295415h = r107;
        this.f295416i = r108;
        this.f295417j = r110;
        this.f295418k = r111;
        this.f295419l = r112;
    }

    public r(int r100, Integer r101, List r102, h1 r103, Boolean r110, j1 r111, String r112, String r113, Boolean r114, y r115, Boolean r116, Integer r117, i1 r118) {
        int r104 = 0;
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295421b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        Integer r105 = 0;
    L8:
        this.f295408a = r105;
        if ((r100 & 2) != 0) goto L11;
        List r106 = new ArrayList();
    L12:
        this.f295409b = r106;
        if ((r100 & 4) != 0) goto L15;
        this.f295410c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        Boolean r107 = Boolean.FALSE;
    L20:
        this.f295411d = r107;
        if ((r100 & 16) != 0) goto L23;
        this.f295412e = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f295413f = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        String r108 = "";
    L32:
        this.f295414g = r108;
        if ((r100 & 128) != 0) goto L35;
        this.f295415h = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        y r109 = new y(r104);
    L40:
        this.f295416i = r109;
        if ((r100 & 512) != 0) goto L43;
        this.f295417j = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.f295418k = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.f295419l = null;
        return;
    L51:
        this.f295419l = r118;
        return;
    L47:
        this.f295418k = r117;
        goto L49
    L43:
        this.f295417j = r116;
        goto L45
    L39:
        r109 = r115;
        goto L40
    L35:
        this.f295415h = r114;
        goto L37
    L31:
        r108 = r113;
        goto L32
    L27:
        this.f295413f = r112;
        goto L29
    L23:
        this.f295412e = r111;
        goto L25
    L19:
        r107 = r110;
        goto L20
    L15:
        this.f295410c = r103;
        goto L17
    L11:
        r106 = r102;
        goto L12
    L7:
        r105 = r101;
        goto L8
    }
}
