package com.bytedance.bdnavigationsdk.network.report;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
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
public final class k {
    public static final b Companion = null;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<k> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.network.report.ReportSystemContent", r0, 10);
            r1.j("appid", false);
            r1.j("bussiness", false);
            r1.j("did", false);
            r1.j("device_platform", false);
            r1.j(LocationMonitorConst.DEVICE_BRAND, false);
            r1.j("device_model", false);
            r1.j("app_version", false);
            r1.j("os_version", false);
            r1.j("os_api", true);
            r1.j("sdk_version", false);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new juc.d[]{r1, r1, r1, r1, r1, r1, r1, r1, kuc.a.d(r1), r1};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r24) {
            Intrinsics.checkNotNullParameter(r24, "decoder");
            g2 r1 = b;
            muc.c r0 = r24.beginStructure(r1);
            int r3 = 2;
            String r13 = null;
            if (r0.decodeSequentially() == false) goto L5;
            String r2 = r0.decodeStringElement(r1, 0);
            String r6 = r0.decodeStringElement(r1, 1);
            String r4 = r0.decodeStringElement(r1, 2);
            String r7 = r0.decodeStringElement(r1, 3);
            String r5 = r0.decodeStringElement(r1, 4);
            String r11 = r0.decodeStringElement(r1, 5);
            String r10 = r0.decodeStringElement(r1, 6);
            String r9 = r0.decodeStringElement(r1, 7);
            String r12 = r4;
            String r14 = r5;
            String r18 = (String) r0.decodeNullableSerializableElement(r1, 8, v2.a, null);
            r13 = r7;
            String r19 = r0.decodeStringElement(r1, 9);
            String r17 = r9;
            String r16 = r10;
            String r15 = r11;
            int r20 = 1023;
            String r110 = r2;
            String r111 = r6;
        L24:
            r0.endStructure(r1);
            return new k(r20, r110, r111, r12, r13, r14, r15, r16, r17, r18, r19);
        L5:
            String r8 = null;
            String r112 = null;
            String r113 = null;
            String r114 = null;
            String r115 = null;
            String r116 = null;
            r19 = null;
            String r21 = null;
            String r22 = null;
            int r23 = 0;
            boolean r25 = true;
        L6:
            if (r25 == false) goto L23;
            int r26 = r0.decodeElementIndex(r1);
            switch(r26) {
                case -1: goto L22;
                case 0: goto L21;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r26);
        L20:
            r113 = r0.decodeStringElement(r1, 1);
            r23 = r23 | 2;
            goto L6
        L21:
            r114 = r0.decodeStringElement(r1, 0);
            r23 = r23 | 1;
            r3 = 2;
            goto L6
        L22:
            r3 = 2;
            r25 = false;
            goto L6
        L11:
            String r27 = r0.decodeStringElement(r1, 9);
            r23 = r23 | DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE;
            r19 = r27;
            goto L6
        L12:
            r8 = (String) r0.decodeNullableSerializableElement(r1, 8, v2.a, r8);
            r23 = r23 | DeviceStatus$DiffDimension.DIFF_LOCATION_MODE;
            goto L6
        L13:
            String r28 = r0.decodeStringElement(r1, 7);
            r23 = r23 | DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE;
            r22 = r28;
            goto L6
        L14:
            r23 = r23 | 64;
            r21 = r0.decodeStringElement(r1, 6);
            goto L6
        L15:
            r23 = r23 | 32;
            r115 = r0.decodeStringElement(r1, 5);
            goto L6
        L16:
            r23 = r23 | 16;
            r116 = r0.decodeStringElement(r1, 4);
            goto L6
        L17:
            r23 = r23 | 8;
            r13 = r0.decodeStringElement(r1, 3);
            goto L6
        L18:
            r23 = r23 | 4;
            r112 = r0.decodeStringElement(r1, r3);
            goto L6
        L23:
            r20 = r23;
            r12 = r112;
            r111 = r113;
            r110 = r114;
            r15 = r115;
            r14 = r116;
            r16 = r21;
            r17 = r22;
            r18 = r8;
            goto L24
        }

        public final void serialize(muc.f r6, Object r7) {
            k r8 = (k) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            boolean r2 = false;
            r9.encodeStringElement(r0, 0, r8.a);
            r9.encodeStringElement(r0, 1, r8.b);
            r9.encodeStringElement(r0, 2, r8.c);
            r9.encodeStringElement(r0, 3, r8.d);
            r9.encodeStringElement(r0, 4, r8.e);
            r9.encodeStringElement(r0, 5, r8.f);
            r9.encodeStringElement(r0, 6, r8.g);
            r9.encodeStringElement(r0, 7, r8.h);
            if (r9.shouldEncodeElementDefault(r0, 8) == false) goto L6;
        L7:
            r2 = true;
        L8:
            if (r2 == false) goto L10;
            r9.encodeNullableSerializableElement(r0, 8, v2.a, r8.i);
        L10:
            r9.encodeStringElement(r0, 9, r8.j);
            r9.endStructure(r0);
            return;
        L6:
            if (r8.i == null) goto L8;
            goto L7
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<k> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        String r1 = this.i;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.j.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    static {
        Companion = new b();
    }

    public final String toString() {
        return "ReportSystem{appId='" + this.a + "', business='" + this.b + "', deviceId='" + this.c + "', devicePlatform='" + this.d + "', deviceBrand='" + this.e + "', deviceModel='" + this.f + "', appVersion='" + this.g + "', osVersion='" + this.h + "', osApi='" + this.i + "', sdkVersion='" + this.j + "'}";
    }

    public k(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r3, "appId");
        Intrinsics.checkNotNullParameter(r4, "business");
        Intrinsics.checkNotNullParameter(r5, "deviceId");
        Intrinsics.checkNotNullParameter(r6, "devicePlatform");
        Intrinsics.checkNotNullParameter(r7, "deviceBrand");
        Intrinsics.checkNotNullParameter(r8, "deviceModel");
        Intrinsics.checkNotNullParameter(r9, "appVersion");
        Intrinsics.checkNotNullParameter(r10, "osVersion");
        Intrinsics.checkNotNullParameter("0.0.1-rc.44", "sdkVersion");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = "0.0.1-rc.44";
    }

    public k(int r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14) {
        if (767 != (r4 & 767)) goto L10;
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        if ((r4 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) != 0) goto L7;
        this.i = null;
    L8:
        this.j = r14;
        return;
    L7:
        this.i = r13;
        goto L8
    L10:
        b2.b(r4, 767, a.b);
        throw null;
    }
}
