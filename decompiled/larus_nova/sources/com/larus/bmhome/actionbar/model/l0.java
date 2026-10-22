package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;

/* JADX INFO: loaded from: classes25.dex */
@Serializable
public final class l0 implements k1 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f295275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f295276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f295277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f295278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f295279e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<l0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295280a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295281b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            h.a r100 = h.a.f295175a;
            return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(nuc.w0.f520792a), kuc.a.d(nuc.i.f520705a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295281b;
        }

        static {
            a r100 = new a();
            f295280a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ActionBarTranslatorBoxTemplate", r100, 5);
            r101.j("source_selector", true);
            r101.j("target_selector", true);
            r101.j("voice_selector", true);
            r101.j("default_selection_index", true);
            r101.j("can_be_empty", true);
            f295281b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f295281b;
            muc.c r101 = r210.beginStructure(r100);
            h r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            h.a r103 = h.a.f295175a;
            h r104 = (h) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            h r105 = (h) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            h r106 = (h) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            h r110 = r106;
            Integer r111 = (Integer) r101.decodeNullableSerializableElement(r100, 3, nuc.w0.f520792a, null);
            Boolean r211 = (Boolean) r101.decodeNullableSerializableElement(r100, 4, nuc.i.f520705a, null);
            h r112 = r104;
            h r113 = r105;
            int r114 = 31;
        L23:
            r101.endStructure(r100);
            return new l0(r114, r112, r113, r110, r111, r211);
        L5:
            h r107 = null;
            h r115 = null;
            Integer r116 = null;
            Boolean r117 = null;
            int r108 = 0;
            boolean r118 = true;
        L6:
            if (r118 == false) goto L22;
            int r119 = r101.decodeElementIndex(r100);
            if (r119 != (-1)) goto L9;
            r118 = false;
            goto L6
        L9:
            if (r119 != 0) goto L10;
            r102 = (h) r101.decodeNullableSerializableElement(r100, 0, h.a.f295175a, r102);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r119 != 1) goto L11;
            r107 = (h) r101.decodeNullableSerializableElement(r100, 1, h.a.f295175a, r107);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r119 != 2) goto L12;
            r115 = (h) r101.decodeNullableSerializableElement(r100, 2, h.a.f295175a, r115);
            r108 = r108 | 4;
            goto L6
        L12:
            if (r119 != 3) goto L13;
            r116 = (Integer) r101.decodeNullableSerializableElement(r100, 3, nuc.w0.f520792a, r116);
            r108 = r108 | 8;
            goto L6
        L13:
            if (r119 != 4) goto L16;
            r117 = (Boolean) r101.decodeNullableSerializableElement(r100, 4, nuc.i.f520705a, r117);
            r108 = r108 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r119);
        L22:
            r114 = r108;
            r112 = r102;
            r113 = r107;
            r110 = r115;
            r111 = r116;
            r211 = r117;
            goto L23
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            l0 r102 = (l0) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295281b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = l0.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, h.a.f295175a, r102.f295275a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, h.a.f295175a, r102.f295276b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeNullableSerializableElement(r103, 2, h.a.f295175a, r102.f295277c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == true) goto L37;
            Integer r110 = r102.f295278d;
            if (r110 == null) goto L37;
            if (r110.intValue() != (-1)) goto L37;
            boolean r111 = false;
        L39:
            if (r111 == false) goto L42;
            r104.encodeNullableSerializableElement(r103, 3, nuc.w0.f520792a, r102.f295278d);
        L42:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L45;
        L46:
            r106 = true;
        L47:
            if (r106 == false) goto L49;
            r104.encodeNullableSerializableElement(r103, 4, nuc.i.f520705a, r102.f295279e);
        L49:
            r104.endStructure(r103);
            return;
        L45:
            if (Intrinsics.areEqual(r102.f295279e, Boolean.FALSE) == true) goto L47;
        L37:
            r111 = true;
            goto L39
        L24:
            if (r102.f295277c != null) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f295276b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f295275a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<l0> serializer() {
            return a.f295280a;
        }
    }

    public l0() {
        this(null, null, null, -1, Boolean.FALSE);
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final List<String> b(List<String> r100) {
        return null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.f295275a, r101.f295275a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295276b, r101.f295276b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295277c, r101.f295277c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295278d, r101.f295278d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295279e, r101.f295279e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        h r100 = this.f295275a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        h r104 = this.f295276b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        h r107 = this.f295277c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f295278d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.f295279e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "ActionBarTranslatorBoxTemplate(sourceSelector=" + this.f295275a + ", targetSelector=" + this.f295276b + ", voiceSelector=" + this.f295277c + ", defaultSelectionIndex=" + this.f295278d + ", canBeEmpty=" + this.f295279e + ')';
    }

    static {
        Companion = new b();
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        ArrayList r100 = new ArrayList();
        h r101 = this.f295275a;
        boolean r102 = true;
        if (r101 == null) goto L16;
        List<w> r103 = r101.f295167e;
        if (r103 == null) goto L16;
        w r104 = (w) CollectionsKt.firstOrNull(r103);
        if (r104 == null) goto L16;
        String r105 = r104.f295511b;
        if (r105 == null) goto L16;
        if (r105.length() <= 0) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == false) goto L16;
        r100.add(r105);
        goto L16
    L13:
        r106 = false;
    L16:
        h r107 = this.f295276b;
        if (r107 == null) goto L30;
        List<w> r108 = r107.f295167e;
        if (r108 == null) goto L30;
        w r109 = (w) CollectionsKt.firstOrNull(r108);
        if (r109 == null) goto L30;
        String r110 = r109.f295511b;
        if (r110 == null) goto L30;
        if (r110.length() <= 0) goto L27;
        boolean r111 = true;
    L28:
        if (r111 == false) goto L30;
        r100.add(r110);
        goto L30
    L27:
        r111 = false;
    L30:
        h r112 = this.f295277c;
        if (r112 == null) goto L45;
        List<w> r113 = r112.f295167e;
        if (r113 == null) goto L45;
        w r114 = (w) CollectionsKt.firstOrNull(r113);
        if (r114 == null) goto L45;
        String r115 = r114.f295511b;
        if (r115 == null) goto L45;
        if (r115.length() > 0) goto L42;
        r102 = false;
    L42:
        if (r102 == false) goto L45;
        r100.add(r115);
    L45:
        return CollectionsKt.joinToString$default(r100, com.alipay.sdk.m.u.i.f25853b, null, null, 0, null, null, 62, null);
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r100, List<String> r101) {
        h r102 = this.f295275a;
        String r103 = null;
        if (r102 == null) goto L9;
        List<w> r104 = r102.f295167e;
        if (r104 == null) goto L9;
        w r105 = (w) CollectionsKt.firstOrNull(r104);
        if (r105 == null) goto L9;
        String r106 = r105.f295513d;
    L10:
        h r107 = this.f295276b;
        if (r107 == null) goto L18;
        List<w> r108 = r107.f295167e;
        if (r108 == null) goto L18;
        w r109 = (w) CollectionsKt.firstOrNull(r108);
        if (r109 == null) goto L18;
        r103 = r109.f295513d;
    L18:
        return r106 + r103;
    L9:
        r106 = null;
        goto L10
    }

    public l0(h r100, h r101, h r102, Integer r103, Boolean r104) {
        this.f295275a = r100;
        this.f295276b = r101;
        this.f295277c = r102;
        this.f295278d = r103;
        this.f295279e = r104;
    }

    public static l0 d(l0 r100, h r101, h r102, h r103, int r110) {
        if ((r110 & 1) == 0) goto L5;
        r101 = r100.f295275a;
    L5:
        h r104 = r101;
        if ((r110 & 2) == 0) goto L8;
        r102 = r100.f295276b;
    L8:
        h r105 = r102;
        if ((r110 & 4) == 0) goto L11;
        r103 = r100.f295277c;
    L11:
        h r106 = r103;
        if ((r110 & 8) == 0) goto L14;
        Integer r107 = r100.f295278d;
    L16:
        if ((r110 & 16) == 0) goto L18;
        Boolean r108 = r100.f295279e;
    L19:
        r100.getClass();
        return new l0(r104, r105, r106, r107, r108);
    L18:
        r108 = null;
        goto L19
    L14:
        r107 = null;
        goto L16
    }

    public l0(int r100, h r101, h r102, h r103, Integer r104, Boolean r105) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295281b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f295275a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f295276b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f295277c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f295278d = -1;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f295279e = Boolean.FALSE;
        return;
    L23:
        this.f295279e = r105;
        return;
    L19:
        this.f295278d = r104;
        goto L21
    L15:
        this.f295277c = r103;
        goto L17
    L11:
        this.f295276b = r102;
        goto L13
    L7:
        this.f295275a = r101;
        goto L9
    }
}
