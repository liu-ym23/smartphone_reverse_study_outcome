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
public final class k0 implements k1 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f295261f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f295262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y1 f295263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<y1> f295264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f295265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f295266e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<k0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295267a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295268b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295268b;
        }

        static {
            a r100 = new a();
            f295267a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ActionBarTextSelectorTemplate", r100, 5);
            r101.j("col_nums", true);
            r101.j("default_option", true);
            r101.j("option_list", true);
            r101.j("default_selection_index", true);
            r101.j("choose_required", true);
            f295268b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = k0.f295261f;
            nuc.w0 r101 = nuc.w0.f520792a;
            return new juc.d[]{kuc.a.d(r101), kuc.a.d(y1.a.f295584a), kuc.a.d(r100[2].getValue()), kuc.a.d(r101), kuc.a.d(nuc.i.f520705a)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f295268b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = k0.f295261f;
            Integer r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            nuc.w0 r104 = nuc.w0.f520792a;
            Integer r105 = (Integer) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            y1 r106 = (y1) r101.decodeNullableSerializableElement(r100, 1, y1.a.f295584a, null);
            List r107 = (List) r101.decodeNullableSerializableElement(r100, 2, r102[2].getValue(), null);
            List r211 = r107;
            Integer r212 = (Integer) r101.decodeNullableSerializableElement(r100, 3, r104, null);
            Boolean r213 = (Boolean) r101.decodeNullableSerializableElement(r100, 4, nuc.i.f520705a, null);
            y1 r110 = r106;
            Integer r111 = r105;
            int r112 = 31;
        L25:
            r101.endStructure(r100);
            return new k0(r112, r111, r110, r211, r212, r213);
        L5:
            y1 r113 = null;
            List r114 = null;
            Integer r115 = null;
            Boolean r116 = null;
            int r108 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L24;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 == 0) goto L21;
            if (r118 == 1) goto L19;
            if (r118 == 2) goto L18;
            if (r118 == 3) goto L17;
            if (r118 != 4) goto L16;
            r116 = (Boolean) r101.decodeNullableSerializableElement(r100, 4, nuc.i.f520705a, r116);
            r108 = r108 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r118);
        L17:
            r115 = (Integer) r101.decodeNullableSerializableElement(r100, 3, nuc.w0.f520792a, r115);
            r108 = r108 | 8;
            goto L6
        L18:
            r114 = (List) r101.decodeNullableSerializableElement(r100, 2, r102[2].getValue(), r114);
            r108 = r108 | 4;
            goto L6
        L19:
            r113 = (y1) r101.decodeNullableSerializableElement(r100, 1, y1.a.f295584a, r113);
            r108 = r108 | 2;
            goto L6
        L21:
            r108 = r108 | 1;
            r103 = (Integer) r101.decodeNullableSerializableElement(r100, 0, nuc.w0.f520792a, r103);
            goto L6
        L24:
            r112 = r108;
            r111 = r103;
            r110 = r113;
            r211 = r114;
            r212 = r115;
            r213 = r116;
            goto L25
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            k0 r102 = (k0) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295268b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = k0.f295261f;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == true) goto L10;
            Integer r107 = r102.f295262a;
            if (r107 == null) goto L10;
            if (r107.intValue() != 1) goto L10;
            boolean r108 = false;
        L12:
            if (r108 == false) goto L15;
            r104.encodeNullableSerializableElement(r103, 0, nuc.w0.f520792a, r102.f295262a);
        L15:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L18;
        L19:
            boolean r109 = true;
        L21:
            if (r109 == false) goto L24;
            r104.encodeNullableSerializableElement(r103, 1, y1.a.f295584a, r102.f295263b);
        L24:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L27;
        L28:
            boolean r110 = true;
        L30:
            if (r110 == false) goto L33;
            r104.encodeNullableSerializableElement(r103, 2, r105[2].getValue(), r102.f295264c);
        L33:
            if (r104.shouldEncodeElementDefault(r103, 3) == true) goto L40;
            Integer r111 = r102.f295265d;
            if (r111 == null) goto L40;
            if (r111.intValue() != (-1)) goto L40;
            boolean r112 = false;
        L42:
            if (r112 == false) goto L45;
            r104.encodeNullableSerializableElement(r103, 3, nuc.w0.f520792a, r102.f295265d);
        L45:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L48;
        L49:
            r106 = true;
        L50:
            if (r106 == false) goto L52;
            r104.encodeNullableSerializableElement(r103, 4, nuc.i.f520705a, r102.f295266e);
        L52:
            r104.endStructure(r103);
            return;
        L48:
            if (Intrinsics.areEqual(r102.f295266e, Boolean.FALSE) == true) goto L50;
        L40:
            r112 = true;
            goto L42
        L27:
            if (Intrinsics.areEqual(r102.f295264c, new ArrayList()) == false) goto L28;
            r110 = false;
            goto L30
        L18:
            if (r102.f295263b != null) goto L19;
            r109 = false;
        L10:
            r108 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<k0> serializer() {
            return a.f295267a;
        }
    }

    public k0() {
        this(1, null, new ArrayList(), -1, Boolean.FALSE);
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final List<String> b(List<String> r100) {
        return null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r101 = (k0) r100;
        if (Intrinsics.areEqual(this.f295262a, r101.f295262a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295263b, r101.f295263b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295264c, r101.f295264c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295265d, r101.f295265d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295266e, r101.f295266e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f295262a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        y1 r104 = this.f295263b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<y1> r107 = this.f295264c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f295265d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.f295266e;
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
        return "ActionBarTextSelectorTemplate(colNums=" + this.f295262a + ", defaultOption=" + this.f295263b + ", options=" + this.f295264c + ", defaultSelectionIndex=" + this.f295265d + ", chooseRequired=" + this.f295266e + ')';
    }

    static {
        Companion = new b();
        f295261f = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.p0()), null, null};
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        List<y1> r100 = this.f295264c;
        if (r100 == null) goto L9;
        List<y1> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L12;
        r102.add(((y1) r103.next()).f295578b);
        goto L6
    L12:
        return CollectionsKt.joinToString$default(r102, com.alipay.sdk.m.u.i.f25853b, null, null, 0, null, null, 62, null);
    L9:
        return null;
    }

    public static k0 d(k0 r100, List r101) {
        return new k0(r100.f295262a, r100.f295263b, r101, r100.f295265d, r100.f295266e);
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r110, List<String> r111) {
        List<y1> r112 = this.f295264c;
        if (r112 == null) goto L9;
        List<y1> r113 = r112;
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator<T> r114 = r113.iterator();
    L6:
        if (r114.hasNext() == false) goto L12;
        r100.add(((y1) r114.next()).f295579c);
        goto L6
    L12:
        return CollectionsKt.joinToString$default(r100, wa8.h.a(), null, null, 0, null, null, 62, null);
    L9:
        return null;
    }

    public k0(Integer r100, y1 r101, List<y1> r102, Integer r103, Boolean r104) {
        this.f295262a = r100;
        this.f295263b = r101;
        this.f295264c = r102;
        this.f295265d = r103;
        this.f295266e = r104;
    }

    public k0(int r100, Integer r101, y1 r102, List r103, Integer r104, Boolean r105) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295268b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = 1;
    L7:
        this.f295262a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f295263b = null;
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f295264c = new ArrayList();
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.f295265d = -1;
    L20:
        if ((r100 & 16) != 0) goto L22;
        this.f295266e = Boolean.FALSE;
        return;
    L22:
        this.f295266e = r105;
        return;
    L18:
        this.f295265d = r104;
        goto L20
    L14:
        this.f295264c = r103;
        goto L16
    L10:
        this.f295263b = r102;
        goto L12
    }
}
