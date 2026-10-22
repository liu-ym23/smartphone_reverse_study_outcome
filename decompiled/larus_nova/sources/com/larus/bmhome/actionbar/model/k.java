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
public final class k implements k1 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f295255d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f295256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<t> f295257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<h> f295258c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<k> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295259a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295260b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295260b;
        }

        static {
            a r100 = new a();
            f295259a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ActionBarFeatureSelectorTemplate", r100, 3);
            r101.j("feature_selection_button", true);
            r101.j("feature_option_panel_list", true);
            r101.j("drop_down_box_list", true);
            f295260b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = k.f295255d;
            return new juc.d[]{kuc.a.d(q.a.f295394a), kuc.a.d(r100[1].getValue()), kuc.a.d(r100[2].getValue())};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f295260b;
            muc.c r111 = r110.beginStructure(r100);
            Lazy<juc.d<Object>>[] r101 = k.f295255d;
            q r102 = null;
            if (r111.decodeSequentially() == false) goto L5;
            q r103 = (q) r111.decodeNullableSerializableElement(r100, 0, q.a.f295394a, null);
            List r104 = (List) r111.decodeNullableSerializableElement(r100, 1, r101[1].getValue(), null);
            List r105 = (List) r111.decodeNullableSerializableElement(r100, 2, r101[2].getValue(), null);
            int r106 = 7;
        L19:
            r111.endStructure(r100);
            return new k(r106, r103, r104, r105);
        L5:
            List r107 = null;
            List r108 = null;
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
            r102 = (q) r111.decodeNullableSerializableElement(r100, 0, q.a.f295394a, r102);
            r109 = r109 | 1;
            goto L6
        L10:
            if (r113 != 1) goto L11;
            r107 = (List) r111.decodeNullableSerializableElement(r100, 1, r101[1].getValue(), r107);
            r109 = r109 | 2;
            goto L6
        L11:
            if (r113 != 2) goto L14;
            r108 = (List) r111.decodeNullableSerializableElement(r100, 2, r101[2].getValue(), r108);
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
            k r102 = (k) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295260b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = k.f295255d;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, q.a.f295394a, r102.f295256a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, r105[1].getValue(), r102.f295257b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            r106 = true;
        L26:
            if (r106 == false) goto L28;
            r104.encodeNullableSerializableElement(r103, 2, r105[2].getValue(), r102.f295258c);
        L28:
            r104.endStructure(r103);
            return;
        L24:
            if (Intrinsics.areEqual(r102.f295258c, new ArrayList()) == true) goto L26;
        L15:
            if (Intrinsics.areEqual(r102.f295257b, new ArrayList()) == false) goto L16;
            r108 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r102.f295256a, new q(0)) == false) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<k> serializer() {
            return a.f295259a;
        }
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        return null;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final List<String> b(List<String> r100) {
        return null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f295256a, r101.f295256a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295257b, r101.f295257b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295258c, r101.f295258c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        q r100 = this.f295256a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<t> r104 = this.f295257b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<h> r107 = this.f295258c;
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
        return "ActionBarFeatureSelectorTemplate(featureSelectionButton=" + this.f295256a + ", featureOptionPanelList=" + this.f295257b + ", dropdownBoxList=" + this.f295258c + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f295255d = new Lazy[]{null, LazyKt.lazy(r100, new wa8.n()), LazyKt.lazy(r100, new wa8.o())};
    }

    public k() {
        this(new q(0), new ArrayList(), new ArrayList());
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r110, List<String> r111) {
        ArrayList r112 = new ArrayList();
        List<h> r100 = this.f295258c;
        if (r100 == null) goto L10;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        List<w> r102 = ((h) r101.next()).f295167e;
        if (r102 == null) goto L6;
        r112.addAll(r102);
    L10:
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator r113 = r112.iterator();
    L12:
        if (r113.hasNext() == false) goto L14;
        r103.add(((w) r113.next()).f295513d);
        goto L12
    L14:
        if (r110 != null) goto L17;
        r110 = wa8.h.a();
    L17:
        return CollectionsKt.joinToString$default(r103, r110, null, null, 0, null, null, 62, null);
    }

    public k(q r100, List<t> r101, List<h> r102) {
        this.f295256a = r100;
        this.f295257b = r101;
        this.f295258c = r102;
    }

    public k(int r100, q r101, List r102, List r103) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295260b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = new q(0);
    L7:
        this.f295256a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f295257b = new ArrayList();
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f295258c = new ArrayList();
        return;
    L14:
        this.f295258c = r103;
        return;
    L10:
        this.f295257b = r102;
        goto L12
    }

    public static k d(k r100, List r101, List r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        q r104 = r100.f295256a;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r101 = r100.f295257b;
    L10:
        if ((r103 & 4) == 0) goto L13;
        r102 = r100.f295258c;
    L13:
        return new k(r104, r101, r102);
    L5:
        r104 = null;
        goto L7
    }
}
