package jq9;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes31.dex */
@Serializable
public final class j {
    public static final b Companion = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f500084j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f500085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f500086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f500087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f500088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f500089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f500090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f500091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f500092h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f500093i;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f500094a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f500095b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f500095b;
        }

        static {
            a r100 = new a();
            f500094a = r100;
            g2 r101 = new g2("com.larus.platform.model.actionbar.ActionBarGradientStyle", r100, 9);
            r101.j("instruction_type", true);
            r101.j("text_light_color_list", true);
            r101.j("text_dark_color_list", true);
            r101.j("background_light_color_list", true);
            r101.j("background_dark_color_list", true);
            r101.j("border_dark_color_list", true);
            r101.j("border_light_color_list", true);
            r101.j("foreground_light_color", true);
            r101.j("foreground_dark_color", true);
            f500095b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = j.f500084j;
            v2 r101 = v2.f520790a;
            return new juc.d[]{kuc.a.d(w0.f520792a), kuc.a.d(r100[1].getValue()), kuc.a.d(r100[2].getValue()), kuc.a.d(r100[3].getValue()), kuc.a.d(r100[4].getValue()), kuc.a.d(r100[5].getValue()), kuc.a.d(r100[6].getValue()), kuc.a.d(r101), kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f500095b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = j.f500084j;
            int r103 = 5;
            int r104 = 6;
            int r105 = 7;
            List r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            Integer r106 = (Integer) r101.decodeNullableSerializableElement(r100, 0, w0.f520792a, null);
            List r111 = (List) r101.decodeNullableSerializableElement(r100, 1, r102[1].getValue(), null);
            List r107 = (List) r101.decodeNullableSerializableElement(r100, 2, r102[2].getValue(), null);
            List r108 = (List) r101.decodeNullableSerializableElement(r100, 3, r102[3].getValue(), null);
            List r109 = (List) r101.decodeNullableSerializableElement(r100, 4, r102[4].getValue(), null);
            List r112 = (List) r101.decodeNullableSerializableElement(r100, 5, r102[5].getValue(), null);
            List r113 = (List) r101.decodeNullableSerializableElement(r100, 6, r102[6].getValue(), null);
            v2 r114 = v2.f520790a;
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 7, r114, null);
            List r116 = r113;
            Integer r117 = r106;
            List r118 = r108;
            List r119 = r112;
            String r211 = (String) r101.decodeNullableSerializableElement(r100, 8, r114, null);
            String r120 = r115;
            List r121 = r107;
            List r122 = r109;
            r110 = r111;
            int r123 = 511;
        L26:
            r101.endStructure(r100);
            return new j(r123, r117, r110, r121, r118, r122, r119, r116, r120, r211);
        L5:
            String r124 = null;
            String r125 = null;
            List r126 = null;
            List r127 = null;
            List r128 = null;
            List r129 = null;
            List r130 = null;
            Integer r212 = null;
            int r131 = 0;
            boolean r213 = true;
        L6:
            if (r213 == false) goto L25;
            int r132 = r101.decodeElementIndex(r100);
            switch(r132) {
                case -1: goto L24;
                case 0: goto L22;
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r132);
        L24:
            r103 = 5;
            r105 = 7;
            r213 = false;
            goto L6
        L11:
            r125 = (String) r101.decodeNullableSerializableElement(r100, 8, v2.f520790a, r125);
            r131 = r131 | 256;
        L14:
            List r133 = r130;
        L23:
            r130 = r133;
            r103 = 5;
            r104 = 6;
            r105 = 7;
            goto L6
        L12:
            r124 = (String) r101.decodeNullableSerializableElement(r100, r105, v2.f520790a, r124);
            r131 = r131 | 128;
            goto L14
        L13:
            r131 = r131 | 64;
            r126 = (List) r101.decodeNullableSerializableElement(r100, r104, r102[r104].getValue(), r126);
            goto L14
        L16:
            r129 = (List) r101.decodeNullableSerializableElement(r100, r103, r102[r103].getValue(), r129);
            r131 = r131 | 32;
        L20:
            r133 = r130;
            goto L23
        L17:
            r127 = (List) r101.decodeNullableSerializableElement(r100, 4, r102[4].getValue(), r127);
            r131 = r131 | 16;
            goto L20
        L18:
            r128 = (List) r101.decodeNullableSerializableElement(r100, 3, r102[3].getValue(), r128);
            r131 = r131 | 8;
            goto L20
        L19:
            r130 = (List) r101.decodeNullableSerializableElement(r100, 2, r102[2].getValue(), r130);
            r131 = r131 | 4;
            goto L20
        L21:
            r133 = r130;
            r131 = r131 | 2;
            r110 = (List) r101.decodeNullableSerializableElement(r100, 1, r102[1].getValue(), r110);
            goto L23
        L22:
            r133 = r130;
            r212 = (Integer) r101.decodeNullableSerializableElement(r100, 0, w0.f520792a, r212);
            r131 = r131 | 1;
            goto L23
        L25:
            List r134 = r130;
            Integer r135 = r212;
            r120 = r124;
            r211 = r125;
            r116 = r126;
            r122 = r127;
            r119 = r129;
            r123 = r131;
            r117 = r135;
            r118 = r128;
            r121 = r134;
            goto L26
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            j r102 = (j) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f500095b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = j.f500084j;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == true) goto L10;
            Integer r107 = r102.f500085a;
            if (r107 == null) goto L10;
            if (r107.intValue() != (-1)) goto L10;
            boolean r108 = false;
        L12:
            if (r108 == false) goto L15;
            r104.encodeNullableSerializableElement(r103, 0, w0.f520792a, r102.f500085a);
        L15:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L18;
        L19:
            boolean r109 = true;
        L21:
            if (r109 == false) goto L24;
            r104.encodeNullableSerializableElement(r103, 1, r105[1].getValue(), r102.f500086b);
        L24:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L27;
        L28:
            boolean r110 = true;
        L30:
            if (r110 == false) goto L33;
            r104.encodeNullableSerializableElement(r103, 2, r105[2].getValue(), r102.f500087c);
        L33:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L36;
        L37:
            boolean r111 = true;
        L39:
            if (r111 == false) goto L42;
            r104.encodeNullableSerializableElement(r103, 3, r105[3].getValue(), r102.f500088d);
        L42:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L45;
        L46:
            boolean r112 = true;
        L48:
            if (r112 == false) goto L51;
            r104.encodeNullableSerializableElement(r103, 4, r105[4].getValue(), r102.f500089e);
        L51:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L54;
        L55:
            boolean r113 = true;
        L57:
            if (r113 == false) goto L60;
            r104.encodeNullableSerializableElement(r103, 5, r105[5].getValue(), r102.f500090f);
        L60:
            if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L63;
        L64:
            boolean r114 = true;
        L66:
            if (r114 == false) goto L69;
            r104.encodeNullableSerializableElement(r103, 6, r105[6].getValue(), r102.f500091g);
        L69:
            if (r104.shouldEncodeElementDefault(r103, 7) == false) goto L72;
        L73:
            boolean r115 = true;
        L75:
            if (r115 == false) goto L78;
            r104.encodeNullableSerializableElement(r103, 7, v2.f520790a, r102.f500092h);
        L78:
            if (r104.shouldEncodeElementDefault(r103, 8) == false) goto L81;
        L82:
            r106 = true;
        L83:
            if (r106 == false) goto L85;
            r104.encodeNullableSerializableElement(r103, 8, v2.f520790a, r102.f500093i);
        L85:
            r104.endStructure(r103);
            return;
        L81:
            if (Intrinsics.areEqual(r102.f500093i, "") == true) goto L83;
        L72:
            if (Intrinsics.areEqual(r102.f500092h, "") == false) goto L73;
            r115 = false;
            goto L75
        L63:
            if (Intrinsics.areEqual(r102.f500091g, CollectionsKt.emptyList()) == false) goto L64;
            r114 = false;
            goto L66
        L54:
            if (Intrinsics.areEqual(r102.f500090f, CollectionsKt.emptyList()) == false) goto L55;
            r113 = false;
            goto L57
        L45:
            if (Intrinsics.areEqual(r102.f500089e, CollectionsKt.emptyList()) == false) goto L46;
            r112 = false;
            goto L48
        L36:
            if (Intrinsics.areEqual(r102.f500088d, CollectionsKt.emptyList()) == false) goto L37;
            r111 = false;
            goto L39
        L27:
            if (Intrinsics.areEqual(r102.f500087c, CollectionsKt.emptyList()) == false) goto L28;
            r110 = false;
            goto L30
        L18:
            if (Intrinsics.areEqual(r102.f500086b, CollectionsKt.emptyList()) == false) goto L19;
            r109 = false;
        L10:
            r108 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<j> serializer() {
            return a.f500094a;
        }
    }

    public j() {
        this(-1, CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), "", "");
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f500085a, r101.f500085a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f500086b, r101.f500086b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f500087c, r101.f500087c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f500088d, r101.f500088d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f500089e, r101.f500089e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f500090f, r101.f500090f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f500091g, r101.f500091g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f500092h, r101.f500092h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f500093i, r101.f500093i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f500085a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f500086b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.f500087c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.f500088d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.f500089e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.f500090f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.f500091g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f500092h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f500093i;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
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
        return "ActionBarGradientStyle(instructionType=" + this.f500085a + ", textLightColorList=" + this.f500086b + ", textDarkColorList=" + this.f500087c + ", backgroundLightColorList=" + this.f500088d + ", backgroundDarkColorList=" + this.f500089e + ", borderDarkColorList=" + this.f500090f + ", borderLightColorList=" + this.f500091g + ", foregroundLightColor=" + this.f500092h + ", foregroundDarkColor=" + this.f500093i + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f500084j = new Lazy[]{null, LazyKt.lazy(r100, new d()), LazyKt.lazy(r100, new e()), LazyKt.lazy(r100, new f()), LazyKt.lazy(r100, new g()), LazyKt.lazy(r100, new h()), LazyKt.lazy(r100, new i()), null, null};
    }

    public j(Integer r100, List<String> r101, List<String> r102, List<String> r103, List<String> r104, List<String> r105, List<String> r106, String r107, String r108) {
        this.f500085a = r100;
        this.f500086b = r101;
        this.f500087c = r102;
        this.f500088d = r103;
        this.f500089e = r104;
        this.f500090f = r105;
        this.f500091g = r106;
        this.f500092h = r107;
        this.f500093i = r108;
    }

    public j(int r100, Integer r101, List r102, List r103, List r104, List r105, List r106, List r107, String r110, String r111) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f500095b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = -1;
    L7:
        this.f500085a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f500086b = CollectionsKt.emptyList();
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f500087c = CollectionsKt.emptyList();
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.f500088d = CollectionsKt.emptyList();
    L20:
        if ((r100 & 16) != 0) goto L22;
        this.f500089e = CollectionsKt.emptyList();
    L24:
        if ((r100 & 32) != 0) goto L26;
        this.f500090f = CollectionsKt.emptyList();
    L28:
        if ((r100 & 64) != 0) goto L30;
        this.f500091g = CollectionsKt.emptyList();
    L32:
        if ((r100 & 128) != 0) goto L34;
        this.f500092h = "";
    L36:
        if ((r100 & 256) != 0) goto L38;
        this.f500093i = "";
        return;
    L38:
        this.f500093i = r111;
        return;
    L34:
        this.f500092h = r110;
        goto L36
    L30:
        this.f500091g = r107;
        goto L32
    L26:
        this.f500090f = r106;
        goto L28
    L22:
        this.f500089e = r105;
        goto L24
    L18:
        this.f500088d = r104;
        goto L20
    L14:
        this.f500087c = r103;
        goto L16
    L10:
        this.f500086b = r102;
        goto L12
    }
}
