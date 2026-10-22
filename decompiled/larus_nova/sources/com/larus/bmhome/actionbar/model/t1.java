package com.larus.bmhome.actionbar.model;

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

/* JADX INFO: loaded from: classes25.dex */
@Serializable
public final class t1 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f295470b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f1> f295471a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<t1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295472a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295473b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295473b;
        }

        static {
            a r100 = new a();
            f295472a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ParamFilterConf", r100, 1);
            r101.j("conf_list", true);
            f295473b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(t1.f295470b[0].getValue())};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            g2 r101 = f295473b;
            muc.c r102 = r100.beginStructure(r101);
            Lazy<juc.d<Object>>[] r103 = t1.f295470b;
            int r104 = 1;
            List r105 = null;
            if (r102.decodeSequentially() == false) goto L5;
            List r106 = (List) r102.decodeNullableSerializableElement(r101, 0, r103[0].getValue(), null);
        L15:
            r102.endStructure(r101);
            return new t1(r104, r106);
        L5:
            int r107 = 0;
        L6:
            if (r104 == 0) goto L14;
            int r108 = r102.decodeElementIndex(r101);
            if (r108 != (-1)) goto L9;
            r104 = 0;
            goto L6
        L9:
            if (r108 != 0) goto L12;
            r105 = (List) r102.decodeNullableSerializableElement(r101, 0, r103[0].getValue(), r105);
            r107 = r107 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r108);
        L14:
            r104 = r107;
            r106 = r105;
            goto L15
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            t1 r102 = (t1) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295473b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = t1.f295470b;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r106 = true;
        L9:
            if (r106 == false) goto L11;
            r104.encodeNullableSerializableElement(r103, 0, r105[0].getValue(), r102.f295471a);
        L11:
            r104.endStructure(r103);
            return;
        L6:
            if (Intrinsics.areEqual(r102.f295471a, new ArrayList()) == false) goto L7;
            r106 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<t1> serializer() {
            return a.f295472a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t1) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f295471a, ((t1) r100).f295471a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<f1> r100 = this.f295471a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "ParamFilterConf(confList=" + this.f295471a + ')';
    }

    static {
        Companion = new b();
        f295470b = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.s1())};
    }

    public t1() {
        this.f295471a = new ArrayList();
    }

    public t1(int r100, List r101) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295473b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f295471a = new ArrayList();
        return;
    L7:
        this.f295471a = r101;
    }
}
