package com.bytedance.bdnavigationsdk.network.route;

import com.bytedance.ee.bear.sheet.filter.FilterData;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class r {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f200273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f200274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f200275c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<r> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f200276a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f200277b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new juc.d[]{kuc.a.d(s.a.f200280a), kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f200277b;
        }

        static {
            a r100 = new a();
            f200276a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.network.route.RouteVerbalInstruction", r100, 3);
            r101.j(FilterData.FilterOptionItem.Type.RANGE, true);
            r101.j("instruction", true);
            r101.j("version", true);
            f200277b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f200277b;
            muc.c r111 = r110.beginStructure(r100);
            s r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            s r102 = (s) r111.decodeNullableSerializableElement(r100, 0, s.a.f200280a, null);
            v2 r103 = v2.f520790a;
            String r104 = (String) r111.decodeNullableSerializableElement(r100, 1, r103, null);
            String r105 = (String) r111.decodeNullableSerializableElement(r100, 2, r103, null);
            int r106 = 7;
        L19:
            r111.endStructure(r100);
            return new r(r106, r102, r104, r105);
        L5:
            String r107 = null;
            String r108 = null;
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
            r101 = (s) r111.decodeNullableSerializableElement(r100, 0, s.a.f200280a, r101);
            r109 = r109 | 1;
            goto L6
        L10:
            if (r113 != 1) goto L11;
            r107 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, r107);
            r109 = r109 | 2;
            goto L6
        L11:
            if (r113 != 2) goto L14;
            r108 = (String) r111.decodeNullableSerializableElement(r100, 2, v2.f520790a, r108);
            r109 = r109 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r113);
        L18:
            r106 = r109;
            r102 = r101;
            r104 = r107;
            r105 = r108;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            r r102 = (r) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f200277b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = r.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, s.a.f200280a, r102.f200273a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f200274b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            r106 = true;
        L26:
            if (r106 == false) goto L28;
            r104.encodeNullableSerializableElement(r103, 2, v2.f520790a, r102.f200275c);
        L28:
            r104.endStructure(r103);
            return;
        L24:
            if (r102.f200275c == null) goto L26;
        L15:
            if (r102.f200274b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f200273a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<r> serializer() {
            return a.f200276a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f200273a, r101.f200273a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f200274b, r101.f200274b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f200275c, r101.f200275c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        s r100 = this.f200273a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f200274b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f200275c;
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
        return "RouteVerbalInstruction(range=" + this.f200273a + ", instruction=" + this.f200274b + ", version=" + this.f200275c + ")";
    }

    static {
        Companion = new b();
    }

    public r() {
        this.f200273a = null;
        this.f200274b = null;
        this.f200275c = null;
    }

    public r(int r100, s r101, String r102, String r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f200277b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f200273a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f200274b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f200275c = null;
        return;
    L15:
        this.f200275c = r103;
        return;
    L11:
        this.f200274b = r102;
        goto L13
    L7:
        this.f200273a = r101;
        goto L9
    }
}
