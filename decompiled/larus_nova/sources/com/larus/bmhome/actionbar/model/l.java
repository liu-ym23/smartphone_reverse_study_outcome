package com.larus.bmhome.actionbar.model;

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
public final class l implements k1 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f295269d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<w> f295270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f295271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f295272c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<l> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295273a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295274b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295274b;
        }

        static {
            a r100 = new a();
            f295273a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ActionBarImageSelectorTemplate", r100, 3);
            r101.j("option_list", true);
            r101.j("default_selection_index", true);
            r101.j("choose_required", true);
            f295274b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(l.f295269d[0].getValue()), kuc.a.d(nuc.w0.f520792a), kuc.a.d(nuc.i.f520705a)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f295274b;
            muc.c r111 = r110.beginStructure(r100);
            Lazy<juc.d<Object>>[] r101 = l.f295269d;
            List r102 = null;
            if (r111.decodeSequentially() == false) goto L5;
            List r103 = (List) r111.decodeNullableSerializableElement(r100, 0, r101[0].getValue(), null);
            Integer r104 = (Integer) r111.decodeNullableSerializableElement(r100, 1, nuc.w0.f520792a, null);
            Boolean r105 = (Boolean) r111.decodeNullableSerializableElement(r100, 2, nuc.i.f520705a, null);
            int r106 = 7;
        L19:
            r111.endStructure(r100);
            return new l(r106, r103, r104, r105);
        L5:
            Integer r107 = null;
            Boolean r108 = null;
            int r109 = 0;
            boolean r112 = true;
        L6:
            if (r112 == false) goto L18;
            int r113 = r111.decodeElementIndex(r100);
            if (r113 != (-1)) goto L9;
            r112 = false;
            goto L6
        L9:
            if (r113 != 0) goto L10;
            r102 = (List) r111.decodeNullableSerializableElement(r100, 0, r101[0].getValue(), r102);
            r109 = r109 | 1;
            goto L6
        L10:
            if (r113 != 1) goto L11;
            r107 = (Integer) r111.decodeNullableSerializableElement(r100, 1, nuc.w0.f520792a, r107);
            r109 = r109 | 2;
            goto L6
        L11:
            if (r113 != 2) goto L14;
            r108 = (Boolean) r111.decodeNullableSerializableElement(r100, 2, nuc.i.f520705a, r108);
            r109 = r109 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r113);
        L18:
            r106 = r109;
            r103 = r102;
            r104 = r107;
            r105 = r108;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            l r102 = (l) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295274b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = l.f295269d;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, r105[0].getValue(), r102.f295270a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == true) goto L19;
            Integer r108 = r102.f295271b;
            if (r108 == null) goto L19;
            if (r108.intValue() != (-1)) goto L19;
            boolean r109 = false;
        L21:
            if (r109 == false) goto L24;
            r104.encodeNullableSerializableElement(r103, 1, nuc.w0.f520792a, r102.f295271b);
        L24:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L27;
        L28:
            r106 = true;
        L29:
            if (r106 == false) goto L31;
            r104.encodeNullableSerializableElement(r103, 2, nuc.i.f520705a, r102.f295272c);
        L31:
            r104.endStructure(r103);
            return;
        L27:
            if (Intrinsics.areEqual(r102.f295272c, Boolean.FALSE) == true) goto L29;
        L19:
            r109 = true;
            goto L21
        L6:
            if (Intrinsics.areEqual(r102.f295270a, new ArrayList()) == false) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<l> serializer() {
            return a.f295273a;
        }
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final List<String> b(List<String> r100) {
        return null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f295270a, r101.f295270a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295271b, r101.f295271b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295272c, r101.f295272c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<w> r100 = this.f295270a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f295271b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f295272c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarImageSelectorTemplate(imageList=" + this.f295270a + ", defaultSelectionIndex=" + this.f295271b + ", chooseRequired=" + this.f295272c + ')';
    }

    static {
        Companion = new b();
        f295269d = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.q()), null, null};
    }

    public l() {
        this(new ArrayList(), -1, Boolean.FALSE);
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        List<w> r100 = this.f295270a;
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

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r110, List<String> r111) {
        List<w> r112 = this.f295270a;
        if (r112 == null) goto L11;
        List<w> r113 = r112;
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator<T> r114 = r113.iterator();
    L6:
        if (r114.hasNext() == false) goto L8;
        r100.add(((w) r114.next()).f295513d);
        goto L6
    L8:
        if (r110 != null) goto L14;
        r110 = wa8.h.a();
    L14:
        return CollectionsKt.joinToString$default(r100, r110, null, null, 0, null, null, 62, null);
    L11:
        return null;
    }

    public l(List<w> r100, Integer r101, Boolean r102) {
        this.f295270a = r100;
        this.f295271b = r101;
        this.f295272c = r102;
    }

    public l(int r100, List r101, Integer r102, Boolean r103) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295274b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = new ArrayList();
    L7:
        this.f295270a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f295271b = -1;
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f295272c = Boolean.FALSE;
        return;
    L14:
        this.f295272c = r103;
        return;
    L10:
        this.f295271b = r102;
        goto L12
    }
}
