package com.bytedance.bdnavigationsdk.network.config;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class d {
    public static final b Companion = null;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<d> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new juc.d[]{r1, r1, r1, r1};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.network.config.ConfigureParam", r0, 4);
            r1.j("appid", false);
            r1.j("device_platform", false);
            r1.j(LocationMonitorConst.DEVICE_BRAND, false);
            r1.j("device_model", false);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r19) {
            Intrinsics.checkNotNullParameter(r19, "decoder");
            g2 r1 = b;
            muc.c r0 = r19.beginStructure(r1);
            if (r0.decodeSequentially() == false) goto L5;
            String r2 = r0.decodeStringElement(r1, 0);
            String r4 = r0.decodeStringElement(r1, 1);
            String r14 = r2;
            String r16 = r0.decodeStringElement(r1, 2);
            String r15 = r4;
            String r17 = r0.decodeStringElement(r1, 3);
            int r13 = 15;
        L21:
            r0.endStructure(r1);
            return new d(r13, r14, r15, r16, r17);
        L5:
            String r3 = null;
            String r7 = null;
            String r8 = null;
            String r9 = null;
            int r10 = 0;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L20;
            int r12 = r0.decodeElementIndex(r1);
            if (r12 != (-1)) goto L9;
            r11 = false;
            goto L6
        L9:
            if (r12 != 0) goto L10;
            r3 = r0.decodeStringElement(r1, 0);
            r10 = r10 | 1;
            goto L6
        L10:
            if (r12 != 1) goto L11;
            r8 = r0.decodeStringElement(r1, 1);
            r10 = r10 | 2;
            goto L6
        L11:
            if (r12 != 2) goto L12;
            r7 = r0.decodeStringElement(r1, 2);
            r10 = r10 | 4;
            goto L6
        L12:
            if (r12 != 3) goto L15;
            r9 = r0.decodeStringElement(r1, 3);
            r10 = r10 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r12);
        L20:
            r14 = r3;
            r16 = r7;
            r15 = r8;
            r17 = r9;
            r13 = r10;
            goto L21
        }

        public final void serialize(muc.f r4, Object r5) {
            d r6 = (d) r5;
            Intrinsics.checkNotNullParameter(r4, "encoder");
            Intrinsics.checkNotNullParameter(r6, "value");
            g2 r0 = b;
            muc.d r7 = r4.beginStructure(r0);
            r7.encodeStringElement(r0, 0, r6.a);
            r7.encodeStringElement(r0, 1, r6.b);
            r7.encodeStringElement(r0, 2, r6.c);
            r7.encodeStringElement(r0, 3, r6.d);
            r7.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<d> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    static {
        Companion = new b();
    }

    public final String toString() {
        return "ConfigureParam{appId='" + this.a + "', devicePlatform='" + this.b + "', deviceBrand='" + this.c + "', deviceModel='" + this.d + "'}";
    }

    public d(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "devicePlatform");
        Intrinsics.checkNotNullParameter(r4, "deviceBrand");
        Intrinsics.checkNotNullParameter(r5, "deviceModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public d(int r3, String r4, String r5, String r6, String r7) {
        if (15 != (r3 & 15)) goto L6;
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        return;
    L6:
        b2.b(r3, 15, a.b);
        throw null;
    }
}
