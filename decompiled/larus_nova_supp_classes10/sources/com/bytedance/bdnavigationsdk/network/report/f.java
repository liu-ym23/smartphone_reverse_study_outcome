package com.bytedance.bdnavigationsdk.network.report;

import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class f {
    public static final b Companion = null;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final long h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<f> {
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
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.network.report.ReportParam", r0, 8);
            r1.j("appid", false);
            r1.j("device_platform", false);
            r1.j("did", false);
            r1.j("business", false);
            r1.j("profile", false);
            r1.j("session_id", false);
            r1.j("logger_content", false);
            r1.j("logger_timestamp", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new juc.d[]{r1, r1, r1, r1, r1, r1, r1, g1.a};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r22) {
            Intrinsics.checkNotNullParameter(r22, "decoder");
            g2 r1 = b;
            muc.c r0 = r22.beginStructure(r1);
            if (r0.decodeSequentially() == false) goto L5;
            String r2 = r0.decodeStringElement(r1, 0);
            String r5 = r0.decodeStringElement(r1, 1);
            String r3 = r0.decodeStringElement(r1, 2);
            String r6 = r0.decodeStringElement(r1, 3);
            String r4 = r0.decodeStringElement(r1, 4);
            String r9 = r0.decodeStringElement(r1, 5);
            String r13 = r4;
            String r12 = r6;
            String r15 = r0.decodeStringElement(r1, 6);
            String r14 = r9;
            long r16 = r0.decodeLongElement(r1, 7);
            int r8 = 255;
            String r10 = r2;
            String r11 = r3;
            String r17 = r5;
        L22:
            r0.endStructure(r1);
            return new f(r8, r10, r17, r11, r12, r13, r14, r15, r16);
        L5:
            String r7 = null;
            String r18 = null;
            String r19 = null;
            String r110 = null;
            String r111 = null;
            long r112 = 0;
            int r113 = 0;
            boolean r20 = true;
            r11 = null;
            String r114 = null;
        L6:
            if (r20 == false) goto L21;
            int r21 = r0.decodeElementIndex(r1);
            switch(r21) {
                case -1: goto L20;
                case 0: goto L19;
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r21);
        L19:
            r7 = r0.decodeStringElement(r1, 0);
            r113 = r113 | 1;
            goto L6
        L20:
            r20 = false;
            goto L6
        L11:
            r112 = r0.decodeLongElement(r1, 7);
            int r23 = r113 | DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE;
        L18:
            r113 = r23;
            goto L6
        L12:
            r110 = r0.decodeStringElement(r1, 6);
            r23 = r113 | 64;
            goto L18
        L13:
            r111 = r0.decodeStringElement(r1, 5);
            r23 = r113 | 32;
            goto L18
        L14:
            r114 = r0.decodeStringElement(r1, 4);
            r23 = r113 | 16;
            goto L18
        L15:
            r19 = r0.decodeStringElement(r1, 3);
            r23 = r113 | 8;
            goto L18
        L16:
            r11 = r0.decodeStringElement(r1, 2);
            r23 = r113 | 4;
            goto L18
        L17:
            r18 = r0.decodeStringElement(r1, 1);
            r23 = r113 | 2;
            goto L18
        L21:
            r10 = r7;
            r17 = r18;
            r8 = r113;
            r15 = r110;
            r13 = r114;
            r12 = r19;
            r14 = r111;
            r16 = r112;
            goto L22
        }

        public final void serialize(muc.f r10, Object r11) {
            f r12 = (f) r11;
            Intrinsics.checkNotNullParameter(r10, "encoder");
            Intrinsics.checkNotNullParameter(r12, "value");
            g2 r0 = b;
            muc.d r13 = r10.beginStructure(r0);
            boolean r2 = false;
            r13.encodeStringElement(r0, 0, r12.a);
            r13.encodeStringElement(r0, 1, r12.b);
            r13.encodeStringElement(r0, 2, r12.c);
            r13.encodeStringElement(r0, 3, r12.d);
            r13.encodeStringElement(r0, 4, r12.e);
            r13.encodeStringElement(r0, 5, r12.f);
            r13.encodeStringElement(r0, 6, r12.g);
            if (r13.shouldEncodeElementDefault(r0, 7) == true) goto L7;
            long r4 = r12.h;
            int r6 = com.bytedance.bdnavigationsdk.utils.e.a;
            if (r4 != System.currentTimeMillis()) goto L7;
        L8:
            if (r2 == false) goto L10;
            r13.encodeLongElement(r0, 7, r12.h);
        L10:
            r13.endStructure(r0);
            return;
        L7:
            r2 = true;
            goto L8
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<f> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof f) == true) goto L8;
        return false;
    L8:
        f r9 = (f) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        long r1 = this.h;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    static {
        Companion = new b();
    }

    public final String toString() {
        return "ReportParam{appid='" + this.a + "', devicePlatform='" + this.b + "', deviceId='" + this.c + "', business='" + this.d + "', profile='" + this.e + "', sessionId='" + this.f + "', reportContent='" + this.g + "', reportTimestamp='" + this.h + "'}";
    }

    public f(String r2, String r3, String r4, String r5, String r6, String r7, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "devicePlatform");
        Intrinsics.checkNotNullParameter(r4, "deviceId");
        Intrinsics.checkNotNullParameter(r5, "business");
        Intrinsics.checkNotNullParameter(r6, "profile");
        Intrinsics.checkNotNullParameter(r7, "sessionId");
        Intrinsics.checkNotNullParameter(r8, "reportContent");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public f(int r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, long r11) {
        if (127 != (r3 & 127)) goto L9;
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        if ((r3 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) != 0) goto L7;
        int r12 = com.bytedance.bdnavigationsdk.utils.e.a;
        this.h = System.currentTimeMillis();
        return;
    L7:
        this.h = r11;
        return;
    L9:
        b2.b(r3, 127, a.b);
        throw null;
    }
}
