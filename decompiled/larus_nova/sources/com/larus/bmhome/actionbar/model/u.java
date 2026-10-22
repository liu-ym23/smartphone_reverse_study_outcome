package com.larus.bmhome.actionbar.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
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
public final class u {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f295474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f295475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f295476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f295477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k1 f295478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f295479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f295480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f295481h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<u> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295482a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295483b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            nuc.w0 r100 = nuc.w0.f520792a;
            v2 r101 = v2.f520790a;
            nuc.i r102 = nuc.i.f520705a;
            return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295483b;
        }

        static {
            a r100 = new a();
            f295482a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ActionBarInstructionItem", r100, 7);
            r101.j("id", true);
            r101.j("instruction_item_type", true);
            r101.j(BdpAppEventConstant.PARAMS_SUB_TITLE, true);
            r101.j(ThumbGlideUrl.SOURCE_TEMPLATE, true);
            r101.j("enable_bottom_line", true);
            r101.j("cancel_top_margin", true);
            r101.j("margin_top", true);
            f295483b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f295483b;
            muc.c r101 = r110.beginStructure(r100);
            int r102 = 2;
            Integer r111 = null;
            if (r101.decodeSequentially() == false) goto L5;
            nuc.w0 r103 = nuc.w0.f520792a;
            Integer r104 = (Integer) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            Integer r105 = (Integer) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            v2 r112 = v2.f520790a;
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 2, r112, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 3, r112, null);
            nuc.i r113 = nuc.i.f520705a;
            Boolean r108 = (Boolean) r101.decodeNullableSerializableElement(r100, 4, r113, null);
            Boolean r109 = (Boolean) r101.decodeNullableSerializableElement(r100, 5, r113, null);
            Integer r114 = (Integer) r101.decodeNullableSerializableElement(r100, 6, r103, null);
            String r115 = r106;
            Boolean r116 = r108;
            r111 = r104;
            Integer r117 = r105;
            Boolean r118 = r109;
            String r119 = r107;
            int r120 = 127;
        L23:
            r101.endStructure(r100);
            return new u(r120, r111, r117, r115, r119, r116, r118, r114);
        L5:
            Boolean r121 = null;
            r117 = null;
            Integer r122 = null;
            String r123 = null;
            Boolean r124 = null;
            String r125 = null;
            int r126 = 0;
            boolean r127 = true;
        L6:
            if (r127 == false) goto L22;
            int r128 = r101.decodeElementIndex(r100);
            switch(r128) {
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
            throw new UnknownFieldException(r128);
        L21:
            r102 = 2;
            r127 = false;
            goto L6
        L11:
            r122 = (Integer) r101.decodeNullableSerializableElement(r100, 6, nuc.w0.f520792a, r122);
            r126 = r126 | 64;
        L20:
            r102 = 2;
            goto L6
        L12:
            r124 = (Boolean) r101.decodeNullableSerializableElement(r100, 5, nuc.i.f520705a, r124);
            r126 = r126 | 32;
            goto L20
        L13:
            r121 = (Boolean) r101.decodeNullableSerializableElement(r100, 4, nuc.i.f520705a, r121);
            r126 = r126 | 16;
            goto L20
        L14:
            r125 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r125);
            r126 = r126 | 8;
            goto L20
        L15:
            r123 = (String) r101.decodeNullableSerializableElement(r100, r102, v2.f520790a, r123);
            r126 = r126 | 4;
            goto L20
        L17:
            r117 = (Integer) r101.decodeNullableSerializableElement(r100, 1, nuc.w0.f520792a, r117);
            r126 = r126 | 2;
            goto L20
        L19:
            r126 = r126 | 1;
            r111 = (Integer) r101.decodeNullableSerializableElement(r100, 0, nuc.w0.f520792a, r111);
            goto L20
        L22:
            r120 = r126;
            r114 = r122;
            r115 = r123;
            r119 = r125;
            r118 = r124;
            r116 = r121;
            goto L23
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            u r102 = (u) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295483b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = u.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == true) goto L10;
            Integer r107 = r102.f295474a;
            if (r107 == null) goto L10;
            if (r107.intValue() != 0) goto L10;
            boolean r108 = false;
        L12:
            if (r108 == false) goto L15;
            r104.encodeNullableSerializableElement(r103, 0, nuc.w0.f520792a, r102.f295474a);
        L15:
            if (r104.shouldEncodeElementDefault(r103, 1) == true) goto L22;
            Integer r109 = r102.f295475b;
            if (r109 == null) goto L22;
            if (r109.intValue() != 0) goto L22;
            boolean r110 = false;
        L24:
            if (r110 == false) goto L27;
            r104.encodeNullableSerializableElement(r103, 1, nuc.w0.f520792a, r102.f295475b);
        L27:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L30;
        L31:
            boolean r111 = true;
        L33:
            if (r111 == false) goto L36;
            r104.encodeNullableSerializableElement(r103, 2, v2.f520790a, r102.f295476c);
        L36:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L39;
        L40:
            boolean r112 = true;
        L42:
            if (r112 == false) goto L45;
            r104.encodeNullableSerializableElement(r103, 3, v2.f520790a, r102.f295477d);
        L45:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L48;
        L49:
            boolean r113 = true;
        L51:
            if (r113 == false) goto L54;
            r104.encodeNullableSerializableElement(r103, 4, nuc.i.f520705a, r102.f295479f);
        L54:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L57;
        L58:
            boolean r114 = true;
        L60:
            if (r114 == false) goto L63;
            r104.encodeNullableSerializableElement(r103, 5, nuc.i.f520705a, r102.f295480g);
        L63:
            if (r104.shouldEncodeElementDefault(r103, 6) == true) goto L70;
            Integer r115 = r102.f295481h;
            if (r115 == null) goto L70;
            if (r115.intValue() != 0) goto L70;
        L71:
            if (r106 == false) goto L73;
            r104.encodeNullableSerializableElement(r103, 6, nuc.w0.f520792a, r102.f295481h);
        L73:
            r104.endStructure(r103);
            return;
        L70:
            r106 = true;
            goto L71
        L57:
            if (Intrinsics.areEqual(r102.f295480g, Boolean.FALSE) == false) goto L58;
            r114 = false;
            goto L60
        L48:
            if (Intrinsics.areEqual(r102.f295479f, Boolean.FALSE) == false) goto L49;
            r113 = false;
            goto L51
        L39:
            if (Intrinsics.areEqual(r102.f295477d, "") == false) goto L40;
            r112 = false;
            goto L42
        L30:
            if (Intrinsics.areEqual(r102.f295476c, "") == false) goto L31;
            r111 = false;
        L22:
            r110 = true;
        L10:
            r108 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<u> serializer() {
            return a.f295482a;
        }
    }

    public u() {
        this(null, null, null, null, null, null, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f295474a, r101.f295474a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295475b, r101.f295475b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295476c, r101.f295476c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295477d, r101.f295477d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295478e, r101.f295478e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f295479f, r101.f295479f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f295480g, r101.f295480g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f295481h, r101.f295481h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f295474a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f295475b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f295476c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f295477d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        k1 r113 = this.f295478e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.f295479f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f295480g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.f295481h;
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
        return "ActionBarInstructionItem(id=" + this.f295474a + ", instructionItemType=" + this.f295475b + ", subTitle=" + this.f295476c + ", template=" + this.f295477d + ", templateObject=" + this.f295478e + ", enableBottomLine=" + this.f295479f + ", cancelTopMargin=" + this.f295480g + ", marginTop=" + this.f295481h + ')';
    }

    static {
        Companion = new b();
    }

    public final Integer b() {
        return this.f295475b;
    }

    public final String c() {
        return this.f295477d;
    }

    public static u a(u r110, String r111, int r112) {
        Integer r100 = null;
        if ((r112 & 1) == 0) goto L5;
        Integer r101 = r110.f295474a;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Integer r102 = r110.f295475b;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r103 = r110.f295476c;
    L15:
        if ((r112 & 8) == 0) goto L17;
        r111 = r110.f295477d;
    L17:
        String r104 = r111;
        if ((r112 & 16) == 0) goto L20;
        k1 r105 = r110.f295478e;
    L22:
        if ((r112 & 32) == 0) goto L24;
        Boolean r106 = r110.f295479f;
    L26:
        if ((r112 & 64) == 0) goto L28;
        Boolean r107 = r110.f295480g;
    L30:
        if ((r112 & 128) == 0) goto L32;
        r100 = r110.f295481h;
    L32:
        r110.getClass();
        return new u(r101, r102, r103, r104, r105, r106, r107, r100);
    L28:
        r107 = null;
        goto L30
    L24:
        r106 = null;
        goto L26
    L20:
        r105 = null;
        goto L22
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

    public u(int r100, Integer r101, Integer r102, String r103, String r104, Boolean r110, Boolean r111, Integer r112) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295483b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f295474a = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f295475b = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f295476c = "";
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f295477d = "";
    L20:
        this.f295478e = null;
        if ((r100 & 16) != 0) goto L23;
        this.f295479f = Boolean.FALSE;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f295480g = Boolean.FALSE;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.f295481h = 0;
        return;
    L31:
        this.f295481h = r112;
        return;
    L27:
        this.f295480g = r111;
        goto L29
    L23:
        this.f295479f = r110;
        goto L25
    L19:
        this.f295477d = r104;
        goto L20
    L15:
        this.f295476c = r103;
        goto L17
    L11:
        this.f295475b = r102;
        goto L13
    L7:
        this.f295474a = r101;
        goto L9
    }

    public /* synthetic */ u(Integer r110, Integer r111, String r112, String r113, Boolean r114, Boolean r115, Integer r116, int r210) {
        if ((r210 & 1) == 0) goto L5;
        Integer r100 = 0;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Integer r101 = 0;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r210 & 32) == 0) goto L21;
        Boolean r104 = Boolean.FALSE;
    L23:
        if ((r210 & 64) == 0) goto L25;
        Boolean r117 = Boolean.FALSE;
    L27:
        if ((r210 & 128) == 0) goto L29;
        Integer r118 = 0;
    L30:
        this(r100, r101, r102, r103, null, r104, r117, r118);
        return;
    L29:
        r118 = r116;
        goto L30
    L25:
        r117 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public u(Integer r100, Integer r101, String r102, String r103, k1 r104, Boolean r105, Boolean r106, Integer r107) {
        this.f295474a = r100;
        this.f295475b = r101;
        this.f295476c = r102;
        this.f295477d = r103;
        this.f295478e = r104;
        this.f295479f = r105;
        this.f295480g = r106;
        this.f295481h = r107;
    }
}
