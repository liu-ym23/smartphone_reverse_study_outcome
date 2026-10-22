package com.bytedance.bdnavigationsdk.network.route;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
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
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class g {
    public static final b Companion = null;
    public final int a;
    public final String b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<g> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{w0.a, kuc.a.d(v2.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.network.route.RouteGuideInfo", r0, 2);
            r1.j(LocationMonitorConst.TYPE, true);
            r1.j("instruction", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r10) {
            Intrinsics.checkNotNullParameter(r10, "decoder");
            g2 r0 = b;
            muc.c r11 = r10.beginStructure(r0);
            if (r11.decodeSequentially() == false) goto L5;
            int r1 = r11.decodeIntElement(r0, 0);
            String r2 = (String) r11.decodeNullableSerializableElement(r0, 1, v2.a, null);
            int r3 = 3;
        L17:
            r11.endStructure(r0);
            return new g(r3, r1, r2);
        L5:
            String r5 = null;
            r1 = 0;
            int r4 = 0;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L16;
            int r7 = r11.decodeElementIndex(r0);
            if (r7 != (-1)) goto L9;
            r6 = false;
            goto L6
        L9:
            if (r7 != 0) goto L10;
            r1 = r11.decodeIntElement(r0, 0);
            r4 = r4 | 1;
            goto L6
        L10:
            if (r7 != 1) goto L13;
            r5 = (String) r11.decodeNullableSerializableElement(r0, 1, v2.a, r5);
            r4 = r4 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r7);
        L16:
            r3 = r4;
            r2 = r5;
            goto L17
        }

        public final void serialize(muc.f r5, Object r6) {
            g r7 = (g) r6;
            Intrinsics.checkNotNullParameter(r5, "encoder");
            Intrinsics.checkNotNullParameter(r7, "value");
            g2 r0 = b;
            muc.d r8 = r5.beginStructure(r0);
            b r1 = g.Companion;
            boolean r2 = false;
            if (r8.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r8.encodeIntElement(r0, 0, r7.a);
        L12:
            if (r8.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r8.encodeNullableSerializableElement(r0, 1, v2.a, r7.b);
        L19:
            r8.endStructure(r0);
            return;
        L15:
            if (r7.b == null) goto L17;
        L6:
            if (r7.a != 0) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<g> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "RouteGuideInfo(type=" + this.a + ", instruction=" + this.b + ")";
    }

    static {
        Companion = new b();
    }

    public g() {
        this.a = 0;
        this.b = null;
    }

    public final int getType() {
        return this.a;
    }

    public g(int r4, int r5, String r6) {
        if ((r4 & 0) == 0) goto L5;
        b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        this.a = 0;
    L9:
        if ((r4 & 2) != 0) goto L11;
        this.b = null;
        return;
    L11:
        this.b = r6;
        return;
    L7:
        this.a = r5;
        goto L9
    }
}
