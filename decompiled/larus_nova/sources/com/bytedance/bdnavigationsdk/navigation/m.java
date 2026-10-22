package com.bytedance.bdnavigationsdk.navigation;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.w0;

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class m {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f200102a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f200103a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f200104b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{w0.f520792a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f200104b;
        }

        static {
            a r100 = new a();
            f200103a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.navigation.NavigationToViaInfo", r100, 1);
            r101.j("via_index", true);
            f200104b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            g2 r101 = f200104b;
            muc.c r102 = r100.beginStructure(r101);
            int r103 = 1;
            if (r102.decodeSequentially() == false) goto L5;
            int r104 = r102.decodeIntElement(r101, 0);
        L15:
            r102.endStructure(r101);
            return new m(r103, r104);
        L5:
            r104 = 0;
            int r105 = 0;
        L6:
            if (r103 == 0) goto L14;
            int r106 = r102.decodeElementIndex(r101);
            if (r106 != (-1)) goto L9;
            r103 = 0;
            goto L6
        L9:
            if (r106 != 0) goto L12;
            r104 = r102.decodeIntElement(r101, 0);
            r105 = r105 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r106);
        L14:
            r103 = r105;
            goto L15
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            m r102 = (m) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f200104b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = m.Companion;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r106 = true;
        L9:
            if (r106 == false) goto L11;
            r104.encodeIntElement(r103, 0, r102.f200102a);
        L11:
            r104.endStructure(r103);
            return;
        L6:
            if (r102.f200102a != 0) goto L7;
            r106 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<m> serializer() {
            return a.f200103a;
        }
    }

    public m() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L9;
        return false;
    L9:
        if (this.f200102a == ((m) r100).f200102a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f200102a;
    }

    public final String toString() {
        return "NavigationToViaInfo(viaIndex=" + this.f200102a + ")";
    }

    static {
        Companion = new b();
    }

    public m(int r100) {
        this.f200102a = r100;
    }

    public m(int r100, int r101) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f200104b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f200102a = 0;
        return;
    L7:
        this.f200102a = r101;
    }
}
