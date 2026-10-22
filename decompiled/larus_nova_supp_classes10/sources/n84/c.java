package n84;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdnavigationsdk.network.route.PoiType;
import juc.n;
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
public final class c {
    public static final b Companion = null;
    public static final juc.d<Object>[] e = null;
    public final com.bytedance.bdnavigationsdk.pojo.a a;
    public final String b;
    public final PoiType c;
    public final String d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {
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
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.agent.NavigationAgentPointInfo", r0, 4);
            r1.j(LocationMonitorConst.LOCATION, false);
            r1.j("poi_id", true);
            r1.j("poi_type", true);
            r1.j("name", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            juc.d<Object>[] r0 = c.e;
            v2 r2 = v2.a;
            return new juc.d[]{com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, kuc.a.d(r2), kuc.a.d(r0[2]), kuc.a.d(r2)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r20) {
            Intrinsics.checkNotNullParameter(r20, "decoder");
            g2 r1 = b;
            muc.c r0 = r20.beginStructure(r1);
            juc.c[] r2 = c.e;
            com.bytedance.bdnavigationsdk.pojo.a r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            com.bytedance.bdnavigationsdk.pojo.a r3 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeSerializableElement(r1, 0, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, null);
            v2 r5 = v2.a;
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 1, r5, null);
            PoiType r17 = (PoiType) r0.decodeNullableSerializableElement(r1, 2, r2[2], null);
            com.bytedance.bdnavigationsdk.pojo.a r15 = r3;
            String r18 = (String) r0.decodeNullableSerializableElement(r1, 3, r5, null);
            String r16 = r6;
            int r14 = 15;
        L21:
            r0.endStructure(r1);
            return new c(r14, r15, r16, r17, r18);
        L5:
            String r9 = null;
            PoiType r10 = null;
            String r11 = null;
            int r4 = 0;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L20;
            int r13 = r0.decodeElementIndex(r1);
            if (r13 != (-1)) goto L9;
            r12 = false;
            goto L6
        L9:
            if (r13 != 0) goto L10;
            r8 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeSerializableElement(r1, 0, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r8);
            r4 = r4 | 1;
            goto L6
        L10:
            if (r13 != 1) goto L11;
            r9 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r9);
            r4 = r4 | 2;
            goto L6
        L11:
            if (r13 != 2) goto L12;
            r10 = (PoiType) r0.decodeNullableSerializableElement(r1, 2, r2[2], r10);
            r4 = r4 | 4;
            goto L6
        L12:
            if (r13 != 3) goto L15;
            r11 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r11);
            r4 = r4 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r13);
        L20:
            r14 = r4;
            r15 = r8;
            r16 = r9;
            r17 = r10;
            r18 = r11;
            goto L21
        }

        public final void serialize(muc.f r7, Object r8) {
            c r9 = (c) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            n[] r1 = c.e;
            boolean r4 = false;
            r10.encodeSerializableElement(r0, 0, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r9.a);
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 1, v2.a, r9.b);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L15;
        L16:
            boolean r5 = true;
        L18:
            if (r5 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 2, r1[2], r9.c);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L24;
        L25:
            r4 = true;
        L26:
            if (r4 == false) goto L28;
            r10.encodeNullableSerializableElement(r0, 3, v2.a, r9.d);
        L28:
            r10.endStructure(r0);
            return;
        L24:
            if (r9.d == null) goto L26;
        L15:
            if (r9.c != null) goto L16;
            r5 = false;
            goto L18
        L6:
            if (r9.b != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        PoiType r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "NavigationAgentPointInfo(location=" + this.a + ", poiId=" + this.b + ", poiType=" + this.c + ", name=" + this.d + ")";
    }

    static {
        Companion = new b();
        e = new juc.d[]{null, null, PoiType.Companion.serializer(), null};
    }

    public c(com.bytedance.bdnavigationsdk.pojo.a r2, String r3, PoiType r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.LOCATION);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public c(int r4, com.bytedance.bdnavigationsdk.pojo.a r5, String r6, PoiType r7, String r8) {
        if (1 != (r4 & 1)) goto L17;
        this.a = r5;
        if ((r4 & 2) != 0) goto L7;
        this.b = null;
    L9:
        if ((r4 & 4) != 0) goto L11;
        this.c = null;
    L13:
        if ((r4 & 8) != 0) goto L15;
        this.d = null;
        return;
    L15:
        this.d = r8;
        return;
    L11:
        this.c = r7;
        goto L13
    L7:
        this.b = r6;
        goto L9
    L17:
        b2.b(r4, 1, a.b);
        throw null;
    }
}
