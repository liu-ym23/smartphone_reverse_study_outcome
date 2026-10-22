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
public final class y1 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f295577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f295578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f295579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q1 f295580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t1 f295581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f295582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f295583g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<y1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295584a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295585b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new juc.d[]{kuc.a.d(nuc.w0.f520792a), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(q1.a.f295405a), kuc.a.d(t1.a.f295472a), kuc.a.d(nuc.i.f520705a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295585b;
        }

        static {
            a r100 = new a();
            f295584a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.SingleSelectorInstructionOption", r100, 6);
            r101.j("id", true);
            r101.j("display_text", true);
            r101.j(TTDelegateActivity.MESSAGE_TEXT, true);
            r101.j("msg_prompt_conf", true);
            r101.j("param_filter_conf", true);
            r101.j("choose_required", true);
            f295585b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f295585b;
            muc.c r101 = r110.beginStructure(r100);
            int r102 = 2;
            Boolean r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            Integer r104 = (Integer) r101.decodeNullableSerializableElement(r100, 0, nuc.w0.f520792a, null);
            v2 r105 = v2.f520790a;
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 1, r105, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 2, r105, null);
            q1 r108 = (q1) r101.decodeNullableSerializableElement(r100, 3, q1.a.f295405a, null);
            Integer r111 = r104;
            String r112 = r107;
            t1 r113 = (t1) r101.decodeNullableSerializableElement(r100, 4, t1.a.f295472a, null);
            Boolean r114 = (Boolean) r101.decodeNullableSerializableElement(r100, 5, nuc.i.f520705a, null);
            String r115 = r106;
            q1 r116 = r108;
            int r109 = 63;
        L21:
            r101.endStructure(r100);
            return new y1(r109, r111, r115, r112, r116, r113, r114);
        L5:
            r111 = null;
            q1 r117 = null;
            r112 = null;
            String r118 = null;
            r113 = null;
            int r119 = 0;
            boolean r120 = true;
        L6:
            if (r120 == false) goto L20;
            int r121 = r101.decodeElementIndex(r100);
            switch(r121) {
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
            throw new UnknownFieldException(r121);
        L19:
            r102 = 2;
            r120 = false;
            goto L6
        L11:
            r103 = (Boolean) r101.decodeNullableSerializableElement(r100, 5, nuc.i.f520705a, r103);
            r119 = r119 | 32;
        L18:
            r102 = 2;
            goto L6
        L12:
            r113 = (t1) r101.decodeNullableSerializableElement(r100, 4, t1.a.f295472a, r113);
            r119 = r119 | 16;
            goto L18
        L13:
            r117 = (q1) r101.decodeNullableSerializableElement(r100, 3, q1.a.f295405a, r117);
            r119 = r119 | 8;
            goto L18
        L14:
            r112 = (String) r101.decodeNullableSerializableElement(r100, r102, v2.f520790a, r112);
            r119 = r119 | 4;
            goto L18
        L15:
            r118 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r118);
            r119 = r119 | 2;
            goto L18
        L17:
            r119 = r119 | 1;
            r111 = (Integer) r101.decodeNullableSerializableElement(r100, 0, nuc.w0.f520792a, r111);
            goto L18
        L20:
            r114 = r103;
            r109 = r119;
            String r122 = r118;
            r116 = r117;
            r115 = r122;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            y1 r102 = (y1) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295585b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = y1.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == true) goto L10;
            Integer r107 = r102.f295577a;
            if (r107 == null) goto L10;
            if (r107.intValue() != 0) goto L10;
            boolean r108 = false;
        L12:
            if (r108 == false) goto L15;
            r104.encodeNullableSerializableElement(r103, 0, nuc.w0.f520792a, r102.f295577a);
        L15:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L18;
        L19:
            boolean r109 = true;
        L21:
            if (r109 == false) goto L24;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f295578b);
        L24:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L27;
        L28:
            boolean r110 = true;
        L30:
            if (r110 == false) goto L33;
            r104.encodeNullableSerializableElement(r103, 2, v2.f520790a, r102.f295579c);
        L33:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L36;
        L37:
            boolean r111 = true;
        L39:
            if (r111 == false) goto L42;
            r104.encodeNullableSerializableElement(r103, 3, q1.a.f295405a, r102.f295580d);
        L42:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L45;
        L46:
            boolean r112 = true;
        L48:
            if (r112 == false) goto L51;
            r104.encodeNullableSerializableElement(r103, 4, t1.a.f295472a, r102.f295581e);
        L51:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L54;
        L55:
            r106 = true;
        L56:
            if (r106 == false) goto L58;
            r104.encodeNullableSerializableElement(r103, 5, nuc.i.f520705a, r102.f295582f);
        L58:
            r104.endStructure(r103);
            return;
        L54:
            if (Intrinsics.areEqual(r102.f295582f, Boolean.FALSE) == true) goto L56;
        L45:
            if (r102.f295581e != null) goto L46;
            r112 = false;
            goto L48
        L36:
            if (r102.f295580d != null) goto L37;
            r111 = false;
            goto L39
        L27:
            if (Intrinsics.areEqual(r102.f295579c, "") == false) goto L28;
            r110 = false;
            goto L30
        L18:
            if (Intrinsics.areEqual(r102.f295578b, "") == false) goto L19;
            r109 = false;
        L10:
            r108 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<y1> serializer() {
            return a.f295584a;
        }
    }

    public y1() {
        this(0, "", "", null, null, Boolean.FALSE, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y1) == true) goto L8;
        return false;
    L8:
        y1 r101 = (y1) r100;
        if (Intrinsics.areEqual(this.f295577a, r101.f295577a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295578b, r101.f295578b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295579c, r101.f295579c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295580d, r101.f295580d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295581e, r101.f295581e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f295582f, r101.f295582f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f295583g, r101.f295583g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f295577a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f295578b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f295579c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        q1 r110 = this.f295580d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        t1 r113 = this.f295581e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.f295582f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f295583g;
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
        return "SingleSelectorInstructionOption(id=" + this.f295577a + ", displayText=" + this.f295578b + ", messageText=" + this.f295579c + ", msgPromptConf=" + this.f295580d + ", paramFilterConf=" + this.f295581e + ", chooseRequired=" + this.f295582f + ", status=" + this.f295583g + ')';
    }

    static {
        Companion = new b();
    }

    public static y1 a(y1 r110, Integer r111, int r112) {
        Boolean r100 = null;
        if ((r112 & 1) == 0) goto L5;
        Integer r101 = r110.f295577a;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r102 = r110.f295578b;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r103 = r110.f295579c;
    L15:
        if ((r112 & 8) == 0) goto L17;
        q1 r104 = r110.f295580d;
    L19:
        if ((r112 & 16) == 0) goto L21;
        t1 r105 = r110.f295581e;
    L23:
        if ((r112 & 32) == 0) goto L25;
        r100 = r110.f295582f;
    L25:
        Boolean r106 = r100;
        if ((r112 & 64) == 0) goto L28;
        r111 = r110.f295583g;
    L28:
        r110.getClass();
        return new y1(r101, r102, r103, r104, r105, r106, r111);
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
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

    public y1(int r100, Integer r101, String r102, String r103, q1 r104, t1 r110, Boolean r111) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295585b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f295577a = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f295578b = "";
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f295579c = "";
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f295580d = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f295581e = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f295582f = Boolean.FALSE;
    L28:
        this.f295583g = 0;
        return;
    L27:
        this.f295582f = r111;
        goto L28
    L23:
        this.f295581e = r110;
        goto L25
    L19:
        this.f295580d = r104;
        goto L21
    L15:
        this.f295579c = r103;
        goto L17
    L11:
        this.f295578b = r102;
        goto L13
    L7:
        this.f295577a = r101;
        goto L9
    }

    public y1(Integer r100, String r101, String r102, q1 r103, t1 r104, Boolean r105, Integer r106) {
        this.f295577a = r100;
        this.f295578b = r101;
        this.f295579c = r102;
        this.f295580d = r103;
        this.f295581e = r104;
        this.f295582f = r105;
        this.f295583g = r106;
    }
}
