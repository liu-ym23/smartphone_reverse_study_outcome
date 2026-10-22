package com.larus.bmhome.actionbar.model;

import com.bytedance.android.livesdkapi.broadcastgame.GameSeiConstants;
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
public final class h {
    public static final b Companion = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f295162m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f295163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f295164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f295165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f295166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<w> f295167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f295168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f295169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f295170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f295171i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f295172j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f295173k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f295174l;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295175a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295176b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295176b;
        }

        static {
            a r100 = new a();
            f295175a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ActionBarDropdownBox", r100, 12);
            r101.j("match_ui_id", true);
            r101.j("id", true);
            r101.j("label", true);
            r101.j("key", true);
            r101.j("option_list", true);
            r101.j("default_selection_index", true);
            r101.j("default_selection_id", true);
            r101.j("can_be_empty", true);
            r101.j("need_save", true);
            r101.j(GameSeiConstants.KEY_GAME_RENDER_MODE, true);
            r101.j("display_column", true);
            r101.j("message_starling", true);
            f295176b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = h.f295162m;
            v2 r101 = v2.f520790a;
            nuc.w0 r102 = nuc.w0.f520792a;
            nuc.i r103 = nuc.i.f520705a;
            return new juc.d[]{kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r100[4].getValue()), kuc.a.d(r102), kuc.a.d(nuc.g1.f520681a), kuc.a.d(r103), kuc.a.d(r103), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f295176b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = h.f295162m;
            String r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r104 = v2.f520790a;
            String r110 = (String) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            nuc.w0 r105 = nuc.w0.f520792a;
            Integer r111 = (Integer) r101.decodeNullableSerializableElement(r100, 1, r105, null);
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 2, r104, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 3, r104, null);
            List r107 = (List) r101.decodeNullableSerializableElement(r100, 4, r102[4].getValue(), null);
            Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 5, r105, null);
            Long r109 = (Long) r101.decodeNullableSerializableElement(r100, 6, nuc.g1.f520681a, null);
            nuc.i r113 = nuc.i.f520705a;
            Boolean r114 = (Boolean) r101.decodeNullableSerializableElement(r100, 7, r113, null);
            Boolean r115 = (Boolean) r101.decodeNullableSerializableElement(r100, 8, r113, null);
            Integer r116 = (Integer) r101.decodeNullableSerializableElement(r100, 9, r105, null);
            Integer r117 = (Integer) r101.decodeNullableSerializableElement(r100, 10, r105, null);
            String r118 = (String) r101.decodeNullableSerializableElement(r100, 11, r104, null);
            Integer r119 = r117;
            Boolean r120 = r114;
            int r121 = UnixStat.PERM_MASK;
            String r122 = r106;
            String r123 = r110;
            Boolean r124 = r115;
            Integer r125 = r108;
            Integer r126 = r111;
            Integer r127 = r116;
            List r128 = r107;
            Long r129 = r109;
            String r130 = r112;
        L32:
            r101.endStructure(r100);
            return new h(r121, r123, r126, r130, r122, r128, r125, r129, r120, r124, r127, r119, r118);
        L5:
            String r131 = null;
            String r132 = null;
            Boolean r133 = null;
            Boolean r134 = null;
            Integer r135 = null;
            r125 = null;
            List r136 = null;
            Integer r137 = null;
            String r138 = null;
            Long r139 = null;
            Integer r140 = null;
            int r141 = 0;
            boolean r211 = true;
        L6:
            if (r211 == false) goto L31;
            int r142 = r101.decodeElementIndex(r100);
            switch(r142) {
                case -1: goto L30;
                case 0: goto L27;
                case 1: goto L26;
                case 2: goto L24;
                case 3: goto L22;
                case 4: goto L20;
                case 5: goto L19;
                case 6: goto L18;
                case 7: goto L16;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L12;
                case 11: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r142);
        L30:
            r131 = r131;
            r102 = r102;
            r211 = false;
            goto L6
        L11:
            r132 = (String) r101.decodeNullableSerializableElement(r100, 11, v2.f520790a, r132);
            int r143 = r141 | 2048;
        L17:
            int r144 = r143;
        L25:
            r141 = r144;
            r131 = r131;
            Integer r145 = r140;
            r103 = r103;
        L29:
            r140 = r145;
            r131 = r131;
            r102 = r102;
            goto L6
        L12:
            r137 = (Integer) r101.decodeNullableSerializableElement(r100, 10, nuc.w0.f520792a, r137);
            r143 = r141 | 1024;
            goto L17
        L13:
            r135 = (Integer) r101.decodeNullableSerializableElement(r100, 9, nuc.w0.f520792a, r135);
            r143 = r141 | 512;
            goto L17
        L14:
            r133 = (Boolean) r101.decodeNullableSerializableElement(r100, 8, nuc.i.f520705a, r133);
            r143 = r141 | 256;
            goto L17
        L16:
            r103 = r103;
            r134 = (Boolean) r101.decodeNullableSerializableElement(r100, 7, nuc.i.f520705a, r134);
            r143 = r141 | 128;
            goto L17
        L18:
            r103 = r103;
            r139 = (Long) r101.decodeNullableSerializableElement(r100, 6, nuc.g1.f520681a, r139);
            r143 = r141 | 64;
            goto L17
        L19:
            r103 = r103;
            r125 = (Integer) r101.decodeNullableSerializableElement(r100, 5, nuc.w0.f520792a, r125);
            r143 = r141 | 32;
            goto L17
        L20:
            r103 = r103;
            r136 = (List) r101.decodeNullableSerializableElement(r100, 4, r102[4].getValue(), r136);
            r144 = r141 | 16;
            goto L25
        L22:
            r103 = r103;
            r138 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r138);
            r144 = r141 | 8;
            goto L25
        L24:
            r102 = r102;
            r103 = r103;
            r131 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r131);
            r144 = r141 | 4;
            goto L25
        L26:
            int r146 = r141 | 2;
            r145 = (Integer) r101.decodeNullableSerializableElement(r100, 1, nuc.w0.f520792a, r140);
            r103 = r103;
        L28:
            r141 = r146;
            goto L29
        L27:
            r103 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r103);
            r145 = r140;
            r146 = r141 | 1;
            goto L28
        L31:
            String r147 = r131;
            r121 = r141;
            r128 = r136;
            r119 = r137;
            r129 = r139;
            r120 = r134;
            r127 = r135;
            r122 = r138;
            r130 = r147;
            r118 = r132;
            r124 = r133;
            r126 = r140;
            r123 = r103;
            goto L32
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            h r112 = (h) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r112, "value");
            g2 r100 = f295176b;
            muc.d r113 = r110.beginStructure(r100);
            Lazy<juc.d<Object>>[] r101 = h.f295162m;
            boolean r102 = false;
            if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
        L7:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            r113.encodeNullableSerializableElement(r100, 0, v2.f520790a, r112.f295163a);
        L12:
            if (r113.shouldEncodeElementDefault(r100, 1) == true) goto L19;
            Integer r104 = r112.f295164b;
            if (r104 == null) goto L19;
            if (r104.intValue() != (-1)) goto L19;
            boolean r105 = false;
        L21:
            if (r105 == false) goto L24;
            r113.encodeNullableSerializableElement(r100, 1, nuc.w0.f520792a, r112.f295164b);
        L24:
            if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L27;
        L28:
            boolean r106 = true;
        L30:
            if (r106 == false) goto L33;
            r113.encodeNullableSerializableElement(r100, 2, v2.f520790a, r112.f295165c);
        L33:
            if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L36;
        L37:
            boolean r107 = true;
        L39:
            if (r107 == false) goto L42;
            r113.encodeNullableSerializableElement(r100, 3, v2.f520790a, r112.f295166d);
        L42:
            if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L45;
        L46:
            boolean r108 = true;
        L48:
            if (r108 == false) goto L51;
            r113.encodeNullableSerializableElement(r100, 4, r101[4].getValue(), r112.f295167e);
        L51:
            if (r113.shouldEncodeElementDefault(r100, 5) == true) goto L58;
            Integer r109 = r112.f295168f;
            if (r109 == null) goto L58;
            if (r109.intValue() != (-1)) goto L58;
            boolean r114 = false;
        L60:
            if (r114 == false) goto L63;
            r113.encodeNullableSerializableElement(r100, 5, nuc.w0.f520792a, r112.f295168f);
        L63:
            if (r113.shouldEncodeElementDefault(r100, 6) == true) goto L70;
            Long r115 = r112.f295169g;
            if (r115 == null) goto L70;
            if (r115.longValue() != (-1)) goto L70;
            boolean r116 = false;
        L72:
            if (r116 == false) goto L75;
            r113.encodeNullableSerializableElement(r100, 6, nuc.g1.f520681a, r112.f295169g);
        L75:
            if (r113.shouldEncodeElementDefault(r100, 7) == false) goto L78;
        L79:
            boolean r117 = true;
        L81:
            if (r117 == false) goto L84;
            r113.encodeNullableSerializableElement(r100, 7, nuc.i.f520705a, r112.f295170h);
        L84:
            if (r113.shouldEncodeElementDefault(r100, 8) == false) goto L87;
        L88:
            boolean r118 = true;
        L90:
            if (r118 == false) goto L93;
            r113.encodeNullableSerializableElement(r100, 8, nuc.i.f520705a, r112.f295171i);
        L93:
            if (r113.shouldEncodeElementDefault(r100, 9) == true) goto L100;
            Integer r119 = r112.f295172j;
            if (r119 == null) goto L100;
            if (r119.intValue() != 1) goto L100;
            boolean r120 = false;
        L102:
            if (r120 == false) goto L105;
            r113.encodeNullableSerializableElement(r100, 9, nuc.w0.f520792a, r112.f295172j);
        L105:
            if (r113.shouldEncodeElementDefault(r100, 10) == false) goto L108;
        L109:
            boolean r121 = true;
        L111:
            if (r121 == false) goto L114;
            r113.encodeNullableSerializableElement(r100, 10, nuc.w0.f520792a, r112.f295173k);
        L114:
            if (r113.shouldEncodeElementDefault(r100, 11) == false) goto L117;
        L118:
            r102 = true;
        L119:
            if (r102 == false) goto L121;
            r113.encodeNullableSerializableElement(r100, 11, v2.f520790a, r112.f295174l);
        L121:
            r113.endStructure(r100);
            return;
        L117:
            if (r112.f295174l == null) goto L119;
        L108:
            if (r112.f295173k != null) goto L109;
            r121 = false;
        L100:
            r120 = true;
            goto L102
        L87:
            if (Intrinsics.areEqual(r112.f295171i, Boolean.FALSE) == false) goto L88;
            r118 = false;
            goto L90
        L78:
            if (Intrinsics.areEqual(r112.f295170h, Boolean.FALSE) == false) goto L79;
            r117 = false;
        L70:
            r116 = true;
        L58:
            r114 = true;
            goto L60
        L45:
            if (Intrinsics.areEqual(r112.f295167e, new ArrayList()) == false) goto L46;
            r108 = false;
            goto L48
        L36:
            if (r112.f295166d != null) goto L37;
            r107 = false;
            goto L39
        L27:
            if (Intrinsics.areEqual(r112.f295165c, "") == false) goto L28;
            r106 = false;
        L19:
            r105 = true;
            goto L21
        L6:
            if (Intrinsics.areEqual(r112.f295163a, "") == false) goto L7;
            r103 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<h> serializer() {
            return a.f295175a;
        }
    }

    public h() {
        this(null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f295163a, r101.f295163a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295164b, r101.f295164b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295165c, r101.f295165c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295166d, r101.f295166d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295167e, r101.f295167e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f295168f, r101.f295168f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f295169g, r101.f295169g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f295170h, r101.f295170h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f295171i, r101.f295171i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f295172j, r101.f295172j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f295173k, r101.f295173k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f295174l, r101.f295174l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f295163a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f295164b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f295165c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f295166d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<w> r113 = this.f295167e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f295168f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.f295169g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.f295170h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.f295171i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.f295172j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.f295173k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f295174l;
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
        return "ActionBarDropdownBox(matchUiId=" + this.f295163a + ", id=" + this.f295164b + ", label=" + this.f295165c + ", key=" + this.f295166d + ", optionList=" + this.f295167e + ", defaultSelectionIndex=" + this.f295168f + ", defaultSelectionId=" + this.f295169g + ", canBeEmpty=" + this.f295170h + ", needSave=" + this.f295171i + ", renderMode=" + this.f295172j + ", displayColumn=" + this.f295173k + ", messageStarling=" + this.f295174l + ')';
    }

    static {
        Companion = new b();
        f295162m = new Lazy[]{null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.k()), null, null, null, null, null, null, null};
    }

    public /* synthetic */ h(List r110, int r111) {
        Integer r100 = null;
        if ((r111 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r111 & 2) == 0) goto L9;
        Integer r102 = -1;
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r111 & 16) == 0) goto L17;
        List r104 = new ArrayList();
    L19:
        if ((r111 & 32) == 0) goto L21;
        Integer r112 = -1;
    L23:
        if ((r111 & 64) == 0) goto L25;
        Long r113 = -1L;
    L27:
        if ((r111 & 128) == 0) goto L29;
        Boolean r114 = Boolean.FALSE;
    L31:
        if ((r111 & 256) == 0) goto L33;
        Boolean r115 = Boolean.FALSE;
    L35:
        if ((r111 & 512) == 0) goto L37;
        r100 = 1;
    L37:
        this(r101, r102, r103, null, r104, r112, r113, r114, r115, r100, null, null);
        return;
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
        r112 = null;
        goto L23
    L17:
        r104 = r110;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public static h a(h r110, Integer r111, String r112, String r210, List r211, Integer r212, Long r213, int r214) {
        String r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = r110.f295163a;
    L7:
        if ((r214 & 2) == 0) goto L9;
        Integer r102 = r110.f295164b;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r103 = r110.f295165c;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r104 = r110.f295166d;
    L19:
        if ((r214 & 16) == 0) goto L21;
        List r105 = r110.f295167e;
    L23:
        if ((r214 & 32) == 0) goto L25;
        Integer r113 = r110.f295168f;
    L27:
        if ((r214 & 64) == 0) goto L29;
        Long r114 = r110.f295169g;
    L31:
        if ((r214 & 128) == 0) goto L33;
        Boolean r115 = r110.f295170h;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Boolean r116 = r110.f295171i;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Integer r117 = r110.f295172j;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        Integer r118 = r110.f295173k;
    L47:
        if ((r214 & 2048) == 0) goto L49;
        r100 = r110.f295174l;
    L49:
        r110.getClass();
        return new h(r101, r102, r103, r104, r105, r113, r114, r115, r116, r117, r118, r100);
    L45:
        r118 = null;
        goto L47
    L41:
        r117 = null;
        goto L43
    L37:
        r116 = null;
        goto L39
    L33:
        r115 = null;
        goto L35
    L29:
        r114 = r213;
        goto L31
    L25:
        r113 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
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

    public h(String r100, Integer r101, String r102, String r103, List<w> r104, Integer r105, Long r106, Boolean r107, Boolean r108, Integer r110, Integer r111, String r112) {
        this.f295163a = r100;
        this.f295164b = r101;
        this.f295165c = r102;
        this.f295166d = r103;
        this.f295167e = r104;
        this.f295168f = r105;
        this.f295169g = r106;
        this.f295170h = r107;
        this.f295171i = r108;
        this.f295172j = r110;
        this.f295173k = r111;
        this.f295174l = r112;
    }

    public h(int r100, String r101, Integer r102, String r110, String r111, List r112, Integer r113, Long r114, Boolean r115, Boolean r116, Integer r117, Integer r118, String r119) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295176b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f295163a = "";
    L9:
        if ((r100 & 2) != 0) goto L11;
        Integer r103 = -1;
    L12:
        this.f295164b = r103;
        if ((r100 & 4) != 0) goto L15;
        this.f295165c = "";
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f295166d = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        List r104 = new ArrayList();
    L24:
        this.f295167e = r104;
        if ((r100 & 32) != 0) goto L27;
        Integer r105 = -1;
    L28:
        this.f295168f = r105;
        if ((r100 & 64) != 0) goto L31;
        Long r106 = -1L;
    L32:
        this.f295169g = r106;
        if ((r100 & 128) != 0) goto L35;
        Boolean r107 = Boolean.FALSE;
    L36:
        this.f295170h = r107;
        if ((r100 & 256) != 0) goto L39;
        Boolean r108 = Boolean.FALSE;
    L40:
        this.f295171i = r108;
        if ((r100 & 512) != 0) goto L43;
        Integer r109 = 1;
    L44:
        this.f295172j = r109;
        if ((r100 & 1024) != 0) goto L47;
        this.f295173k = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.f295174l = null;
        return;
    L51:
        this.f295174l = r119;
        return;
    L47:
        this.f295173k = r118;
        goto L49
    L43:
        r109 = r117;
        goto L44
    L39:
        r108 = r116;
        goto L40
    L35:
        r107 = r115;
        goto L36
    L31:
        r106 = r114;
        goto L32
    L27:
        r105 = r113;
        goto L28
    L23:
        r104 = r112;
        goto L24
    L19:
        this.f295166d = r111;
        goto L21
    L15:
        this.f295165c = r110;
        goto L17
    L11:
        r103 = r102;
        goto L12
    L7:
        this.f295163a = r101;
        goto L9
    }
}
