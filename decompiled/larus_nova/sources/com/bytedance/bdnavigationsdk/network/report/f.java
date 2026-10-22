package com.bytedance.bdnavigationsdk.network.report;

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

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class f {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f200164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f200165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f200166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f200167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f200168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f200169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f200170g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f200171h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f200172a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f200173b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f200173b;
        }

        static {
            a r100 = new a();
            f200172a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.network.report.ReportParam", r100, 8);
            r101.j("appid", false);
            r101.j("device_platform", false);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_DID, false);
            r101.j("business", false);
            r101.j("profile", false);
            r101.j("session_id", false);
            r101.j("logger_content", false);
            r101.j("logger_timestamp", true);
            f200173b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new juc.d[]{r100, r100, r100, r100, r100, r100, r100, g1.f520681a};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f200173b;
            muc.c r101 = r210.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            String r102 = r101.decodeStringElement(r100, 0);
            String r103 = r101.decodeStringElement(r100, 1);
            String r104 = r101.decodeStringElement(r100, 2);
            String r105 = r101.decodeStringElement(r100, 3);
            String r106 = r101.decodeStringElement(r100, 4);
            String r107 = r101.decodeStringElement(r100, 5);
            String r110 = r106;
            String r111 = r105;
            String r112 = r101.decodeStringElement(r100, 6);
            String r113 = r107;
            long r114 = r101.decodeLongElement(r100, 7);
            int r108 = 255;
            String r109 = r102;
            String r115 = r104;
            String r116 = r103;
        L22:
            r101.endStructure(r100);
            return new f(r108, r109, r116, r115, r111, r110, r113, r112, r114);
        L5:
            String r117 = null;
            String r118 = null;
            String r119 = null;
            String r120 = null;
            String r121 = null;
            long r122 = 0;
            int r123 = 0;
            boolean r211 = true;
            r115 = null;
            String r124 = null;
        L6:
            if (r211 == false) goto L21;
            int r125 = r101.decodeElementIndex(r100);
            switch(r125) {
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
            throw new UnknownFieldException(r125);
        L19:
            r117 = r101.decodeStringElement(r100, 0);
            r123 = r123 | 1;
            goto L6
        L20:
            r211 = false;
            goto L6
        L11:
            r122 = r101.decodeLongElement(r100, 7);
            int r126 = r123 | 128;
        L18:
            r123 = r126;
            goto L6
        L12:
            r120 = r101.decodeStringElement(r100, 6);
            r126 = r123 | 64;
            goto L18
        L13:
            r121 = r101.decodeStringElement(r100, 5);
            r126 = r123 | 32;
            goto L18
        L14:
            r124 = r101.decodeStringElement(r100, 4);
            r126 = r123 | 16;
            goto L18
        L15:
            r119 = r101.decodeStringElement(r100, 3);
            r126 = r123 | 8;
            goto L18
        L16:
            r115 = r101.decodeStringElement(r100, 2);
            r126 = r123 | 4;
            goto L18
        L17:
            r118 = r101.decodeStringElement(r100, 1);
            r126 = r123 | 2;
            goto L18
        L21:
            r109 = r117;
            r116 = r118;
            r108 = r123;
            r112 = r120;
            r110 = r124;
            r111 = r119;
            r113 = r121;
            r114 = r122;
            goto L22
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            f r112 = (f) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r112, "value");
            g2 r100 = f200173b;
            muc.d r113 = r110.beginStructure(r100);
            boolean r101 = false;
            r113.encodeStringElement(r100, 0, r112.f200164a);
            r113.encodeStringElement(r100, 1, r112.f200165b);
            r113.encodeStringElement(r100, 2, r112.f200166c);
            r113.encodeStringElement(r100, 3, r112.f200167d);
            r113.encodeStringElement(r100, 4, r112.f200168e);
            r113.encodeStringElement(r100, 5, r112.f200169f);
            r113.encodeStringElement(r100, 6, r112.f200170g);
            if (r113.shouldEncodeElementDefault(r100, 7) == true) goto L7;
            long r102 = r112.f200171h;
            int r103 = com.bytedance.bdnavigationsdk.utils.e.f200378a;
            if (r102 != System.currentTimeMillis()) goto L7;
        L8:
            if (r101 == false) goto L10;
            r113.encodeLongElement(r100, 7, r112.f200171h);
        L10:
            r113.endStructure(r100);
            return;
        L7:
            r101 = true;
            goto L8
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<f> serializer() {
            return a.f200172a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f200164a, r101.f200164a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f200165b, r101.f200165b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f200166c, r101.f200166c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f200167d, r101.f200167d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f200168e, r101.f200168e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f200169f, r101.f200169f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f200170g, r101.f200170g) == true) goto L30;
        return false;
    L30:
        if (this.f200171h == r101.f200171h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f200164a.hashCode() * 31) + this.f200165b.hashCode()) * 31) + this.f200166c.hashCode()) * 31) + this.f200167d.hashCode()) * 31) + this.f200168e.hashCode()) * 31) + this.f200169f.hashCode()) * 31) + this.f200170g.hashCode()) * 31;
        long r101 = this.f200171h;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    static {
        Companion = new b();
    }

    public final String toString() {
        return "ReportParam{appid='" + this.f200164a + "', devicePlatform='" + this.f200165b + "', deviceId='" + this.f200166c + "', business='" + this.f200167d + "', profile='" + this.f200168e + "', sessionId='" + this.f200169f + "', reportContent='" + this.f200170g + "', reportTimestamp='" + this.f200171h + "'}";
    }

    public f(String r100, String r101, String r102, String r103, String r104, String r105, String r106, long r107) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "devicePlatform");
        Intrinsics.checkNotNullParameter(r102, "deviceId");
        Intrinsics.checkNotNullParameter(r103, "business");
        Intrinsics.checkNotNullParameter(r104, "profile");
        Intrinsics.checkNotNullParameter(r105, "sessionId");
        Intrinsics.checkNotNullParameter(r106, "reportContent");
        this.f200164a = r100;
        this.f200165b = r101;
        this.f200166c = r102;
        this.f200167d = r103;
        this.f200168e = r104;
        this.f200169f = r105;
        this.f200170g = r106;
        this.f200171h = r107;
    }

    public f(int r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, long r111) {
        if (127 != (r100 & 127)) goto L9;
        this.f200164a = r101;
        this.f200165b = r102;
        this.f200166c = r103;
        this.f200167d = r104;
        this.f200168e = r105;
        this.f200169f = r106;
        this.f200170g = r110;
        if ((r100 & 128) != 0) goto L7;
        int r107 = com.bytedance.bdnavigationsdk.utils.e.f200378a;
        this.f200171h = System.currentTimeMillis();
        return;
    L7:
        this.f200171h = r111;
        return;
    L9:
        b2.b(r100, 127, a.f200173b);
        throw null;
    }
}
