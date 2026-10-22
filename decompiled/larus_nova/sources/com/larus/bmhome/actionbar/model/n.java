package com.larus.bmhome.actionbar.model;

import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import java.util.ArrayList;
import java.util.Iterator;
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
import nuc.g2;
import nuc.i2;

/* JADX INFO: loaded from: classes25.dex */
@Serializable
public final class n implements k1 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f295322f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<w> f295323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f295324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f295325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<w> f295326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TemplateInfo$TemplateInfo f295327e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295328a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295329b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295329b;
        }

        static {
            a r100 = new a();
            f295328a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ActionBarImageTemplateInstructionTemplateV2", r100, 5);
            r101.j("option_list", true);
            r101.j("default_selection_index", true);
            r101.j("choose_required", true);
            r101.j("other_option_list", true);
            r101.j("selected_template", true);
            f295329b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = n.f295322f;
            return new juc.d[]{kuc.a.d(r100[0].getValue()), kuc.a.d(nuc.w0.f520792a), kuc.a.d(nuc.i.f520705a), kuc.a.d(r100[3].getValue()), kuc.a.d(TemplateInfo$TemplateInfo.a.f365426a)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f295329b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = n.f295322f;
            List r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            List r104 = (List) r101.decodeNullableSerializableElement(r100, 0, r102[0].getValue(), null);
            Integer r105 = (Integer) r101.decodeNullableSerializableElement(r100, 1, nuc.w0.f520792a, null);
            Boolean r106 = (Boolean) r101.decodeNullableSerializableElement(r100, 2, nuc.i.f520705a, null);
            List r211 = (List) r101.decodeNullableSerializableElement(r100, 3, r102[3].getValue(), null);
            List r110 = r104;
            Boolean r111 = r106;
            TemplateInfo$TemplateInfo r212 = (TemplateInfo$TemplateInfo) r101.decodeNullableSerializableElement(r100, 4, TemplateInfo$TemplateInfo.a.f365426a, null);
            Integer r112 = r105;
            int r113 = 31;
        L24:
            r101.endStructure(r100);
            return new n(r113, r110, r112, r111, r211, r212);
        L5:
            Integer r114 = null;
            Boolean r115 = null;
            List r116 = null;
            TemplateInfo$TemplateInfo r117 = null;
            int r107 = 0;
            boolean r118 = true;
        L6:
            if (r118 == false) goto L23;
            int r119 = r101.decodeElementIndex(r100);
            if (r119 != (-1)) goto L9;
            r118 = false;
            goto L6
        L9:
            if (r119 != 0) goto L10;
            r103 = (List) r101.decodeNullableSerializableElement(r100, 0, r102[0].getValue(), r103);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r119 == 1) goto L19;
            if (r119 == 2) goto L18;
            if (r119 == 3) goto L17;
            if (r119 != 4) goto L16;
            r107 = r107 | 16;
            r117 = (TemplateInfo$TemplateInfo) r101.decodeNullableSerializableElement(r100, 4, TemplateInfo$TemplateInfo.a.f365426a, r117);
            goto L6
        L16:
            throw new UnknownFieldException(r119);
        L17:
            r107 = r107 | 8;
            r116 = (List) r101.decodeNullableSerializableElement(r100, 3, r102[3].getValue(), r116);
            goto L6
        L18:
            r107 = r107 | 4;
            r115 = (Boolean) r101.decodeNullableSerializableElement(r100, 2, nuc.i.f520705a, r115);
            goto L6
        L19:
            r107 = r107 | 2;
            r114 = (Integer) r101.decodeNullableSerializableElement(r100, 1, nuc.w0.f520792a, r114);
            goto L6
        L23:
            r113 = r107;
            r110 = r103;
            r112 = r114;
            r111 = r115;
            r211 = r116;
            r212 = r117;
            goto L24
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            n r102 = (n) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295329b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = n.f295322f;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, r105[0].getValue(), r102.f295323a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == true) goto L19;
            Integer r108 = r102.f295324b;
            if (r108 == null) goto L19;
            if (r108.intValue() != (-1)) goto L19;
            boolean r109 = false;
        L21:
            if (r109 == false) goto L24;
            r104.encodeNullableSerializableElement(r103, 1, nuc.w0.f520792a, r102.f295324b);
        L24:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L27;
        L28:
            boolean r110 = true;
        L30:
            if (r110 == false) goto L33;
            r104.encodeNullableSerializableElement(r103, 2, nuc.i.f520705a, r102.f295325c);
        L33:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L36;
        L37:
            boolean r111 = true;
        L39:
            if (r111 == false) goto L42;
            r104.encodeNullableSerializableElement(r103, 3, r105[3].getValue(), r102.f295326d);
        L42:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L45;
        L46:
            r106 = true;
        L47:
            if (r106 == false) goto L49;
            r104.encodeNullableSerializableElement(r103, 4, TemplateInfo$TemplateInfo.a.f365426a, r102.f295327e);
        L49:
            r104.endStructure(r103);
            return;
        L45:
            if (r102.f295327e == null) goto L47;
        L36:
            if (Intrinsics.areEqual(r102.f295326d, new ArrayList()) == false) goto L37;
            r111 = false;
            goto L39
        L27:
            if (Intrinsics.areEqual(r102.f295325c, Boolean.FALSE) == false) goto L28;
            r110 = false;
        L19:
            r109 = true;
            goto L21
        L6:
            if (Intrinsics.areEqual(r102.f295323a, new ArrayList()) == false) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<n> serializer() {
            return a.f295328a;
        }
    }

    public n() {
        this(null, 31);
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final List<String> b(List<String> r100) {
        return null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f295323a, r101.f295323a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295324b, r101.f295324b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295325c, r101.f295325c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295326d, r101.f295326d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295327e, r101.f295327e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        List<w> r100 = this.f295323a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f295324b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f295325c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<w> r110 = this.f295326d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        TemplateInfo$TemplateInfo r113 = this.f295327e;
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
        return "ActionBarImageTemplateInstructionTemplateV2(imageList=" + this.f295323a + ", defaultSelectionIndex=" + this.f295324b + ", chooseRequired=" + this.f295325c + ", otherOptionList=" + this.f295326d + ", selectorImageTemplateItem=" + this.f295327e + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f295322f = new Lazy[]{LazyKt.lazy(r100, new wa8.s()), null, null, LazyKt.lazy(r100, new wa8.t()), null};
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        List<w> r100 = this.f295323a;
        if (r100 == null) goto L9;
        List<w> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L12;
        r102.add(((w) r103.next()).f295511b);
        goto L6
    L12:
        return CollectionsKt.joinToString$default(r102, com.alipay.sdk.m.u.i.f25853b, null, null, 0, null, null, 62, null);
    L9:
        return null;
    }

    public /* synthetic */ n(List r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new ArrayList();
    L5:
        List r102 = r100;
        if ((r101 & 2) == 0) goto L8;
        Integer r103 = -1;
    L10:
        if ((r101 & 4) == 0) goto L12;
        Boolean r104 = Boolean.FALSE;
    L14:
        if ((r101 & 8) == 0) goto L16;
        ArrayList r105 = new ArrayList();
    L17:
        this(r102, r103, r104, r105, null);
        return;
    L16:
        r105 = null;
        goto L17
    L12:
        r104 = null;
        goto L14
    L8:
        r103 = null;
        goto L10
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r110, List<String> r111) {
        List<w> r112 = this.f295323a;
        if (r112 == null) goto L9;
        List<w> r113 = r112;
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator<T> r114 = r113.iterator();
    L6:
        if (r114.hasNext() == false) goto L12;
        r100.add(((w) r114.next()).f295513d);
        goto L6
    L12:
        return CollectionsKt.joinToString$default(r100, wa8.h.a(), null, null, 0, null, null, 62, null);
    L9:
        return null;
    }

    public static n d(n r100, List r101, TemplateInfo$TemplateInfo r102) {
        return new n(r101, r100.f295324b, r100.f295325c, r100.f295326d, r102);
    }

    public n(List<w> r100, Integer r101, Boolean r102, List<w> r103, TemplateInfo$TemplateInfo r104) {
        this.f295323a = r100;
        this.f295324b = r101;
        this.f295325c = r102;
        this.f295326d = r103;
        this.f295327e = r104;
    }

    public n(int r100, List r101, Integer r102, Boolean r103, List r104, TemplateInfo$TemplateInfo r105) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295329b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = new ArrayList();
    L7:
        this.f295323a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f295324b = -1;
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f295325c = Boolean.FALSE;
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.f295326d = new ArrayList();
    L20:
        if ((r100 & 16) != 0) goto L22;
        this.f295327e = null;
        return;
    L22:
        this.f295327e = r105;
        return;
    L18:
        this.f295326d = r104;
        goto L20
    L14:
        this.f295325c = r103;
        goto L16
    L10:
        this.f295324b = r102;
        goto L12
    }
}
