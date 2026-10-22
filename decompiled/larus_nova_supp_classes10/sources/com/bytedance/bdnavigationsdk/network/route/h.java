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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class h {
    public static final b Companion = null;
    public final com.bytedance.bdnavigationsdk.pojo.a a;
    public final String b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<h> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{com.bytedance.bdnavigationsdk.network.route.b.a, v2.a};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.network.route.RouteGuidePoint", r0, 2);
            r1.j(LocationMonitorConst.LOCATION, true);
            r1.j("name", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r10) {
            Intrinsics.checkNotNullParameter(r10, "decoder");
            g2 r0 = b;
            muc.c r11 = r10.beginStructure(r0);
            String r4 = null;
            if (r11.decodeSequentially() == false) goto L5;
            com.bytedance.bdnavigationsdk.pojo.a r1 = (com.bytedance.bdnavigationsdk.pojo.a) r11.decodeSerializableElement(r0, 0, com.bytedance.bdnavigationsdk.network.route.b.a, null);
            String r2 = r11.decodeStringElement(r0, 1);
            int r3 = 3;
        L17:
            r11.endStructure(r0);
            return new h(r3, r1, r2);
        L5:
            com.bytedance.bdnavigationsdk.pojo.a r5 = null;
            int r6 = 0;
            boolean r7 = true;
        L6:
            if (r7 == false) goto L16;
            int r8 = r11.decodeElementIndex(r0);
            if (r8 != (-1)) goto L9;
            r7 = false;
            goto L6
        L9:
            if (r8 != 0) goto L10;
            r5 = (com.bytedance.bdnavigationsdk.pojo.a) r11.decodeSerializableElement(r0, 0, com.bytedance.bdnavigationsdk.network.route.b.a, r5);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r8 != 1) goto L13;
            r4 = r11.decodeStringElement(r0, 1);
            r6 = r6 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r8);
        L16:
            r3 = r6;
            r2 = r4;
            r1 = r5;
            goto L17
        }

        public final void serialize(muc.f r6, Object r7) {
            h r8 = (h) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            b r1 = h.Companion;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeSerializableElement(r0, 0, com.bytedance.bdnavigationsdk.network.route.b.a, r8.a);
        L12:
            if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r9.encodeStringElement(r0, 1, r8.b);
        L19:
            r9.endStructure(r0);
            return;
        L15:
            if (Intrinsics.areEqual(r8.b, "") == true) goto L17;
        L6:
            if (Intrinsics.areEqual(r8.a, new com.bytedance.bdnavigationsdk.pojo.a()) == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<h> serializer() {
            return a.a;
        }
    }

    static {
        Companion = new b();
    }

    public h() {
        com.bytedance.bdnavigationsdk.pojo.a r0 = new com.bytedance.bdnavigationsdk.pojo.a();
        Intrinsics.checkNotNullParameter(r0, LocationMonitorConst.LOCATION);
        Intrinsics.checkNotNullParameter("", "name");
        this.a = r0;
        this.b = "";
    }

    public h(int r2, com.bytedance.bdnavigationsdk.pojo.a r3, String r4) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        r3 = new com.bytedance.bdnavigationsdk.pojo.a();
    L7:
        this.a = r3;
        if ((r2 & 2) != 0) goto L10;
        this.b = "";
        return;
    L10:
        this.b = r4;
    }
}
