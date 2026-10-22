package com.bytedance.bdnavigationsdk.network.route;

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
public final class i {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f200233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f200234b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f200235a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f200236b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            w0 r100 = w0.f520792a;
            return new juc.d[]{r100, r100};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f200236b;
        }

        static {
            a r100 = new a();
            f200235a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.network.route.RouteLeg", r100, 2);
            r101.j("step_start_index", true);
            r101.j("step_end_index", true);
            f200236b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f200236b;
            muc.c r111 = r110.beginStructure(r100);
            if (r111.decodeSequentially() == false) goto L5;
            int r101 = r111.decodeIntElement(r100, 0);
            int r102 = r111.decodeIntElement(r100, 1);
            int r103 = 3;
        L17:
            r111.endStructure(r100);
            return new i(r103, r101, r102);
        L5:
            r101 = 0;
            int r104 = 0;
            int r105 = 0;
            boolean r106 = true;
        L6:
            if (r106 == false) goto L16;
            int r107 = r111.decodeElementIndex(r100);
            if (r107 != (-1)) goto L9;
            r106 = false;
            goto L6
        L9:
            if (r107 != 0) goto L10;
            r101 = r111.decodeIntElement(r100, 0);
            r105 = r105 | 1;
            goto L6
        L10:
            if (r107 != 1) goto L13;
            r104 = r111.decodeIntElement(r100, 1);
            r105 = r105 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r107);
        L16:
            r102 = r104;
            r103 = r105;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            i r102 = (i) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f200236b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = i.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeIntElement(r103, 0, r102.f200233a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeIntElement(r103, 1, r102.f200234b);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (r102.f200234b == 0) goto L17;
        L6:
            if (r102.f200233a != 0) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<i> serializer() {
            return a.f200235a;
        }
    }

    static {
        Companion = new b();
    }

    public i() {
        this.f200233a = 0;
        this.f200234b = 0;
    }

    public i(int r100, int r101, int r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f200236b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f200233a = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f200234b = 0;
        return;
    L11:
        this.f200234b = r102;
        return;
    L7:
        this.f200233a = r101;
        goto L9
    }
}
