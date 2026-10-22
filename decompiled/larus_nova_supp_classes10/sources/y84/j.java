package y84;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.a1;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class j {
    public static final b Companion = null;
    public static final juc.d<Object>[] d = null;
    public final String a;
    public final Map<String, t84.b> b;
    public final t84.c c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<j> {
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
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.yaw.YawConfig", r0, 3);
            r1.j("profile", true);
            r1.j("strategy_threshold", true);
            r1.j("universal_threshold", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(v2.a), j.d[1], t84.c.a.a};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r13) {
            Intrinsics.checkNotNullParameter(r13, "decoder");
            g2 r0 = b;
            muc.c r14 = r13.beginStructure(r0);
            juc.c[] r1 = j.d;
            String r6 = null;
            if (r14.decodeSequentially() == false) goto L5;
            String r2 = (String) r14.decodeNullableSerializableElement(r0, 0, v2.a, null);
            Map r3 = (Map) r14.decodeSerializableElement(r0, 1, r1[1], null);
            t84.c r4 = (t84.c) r14.decodeSerializableElement(r0, 2, t84.c.a.a, null);
            int r5 = 7;
        L19:
            r14.endStructure(r0);
            return new j(r5, r2, r3, r4);
        L5:
            Map r7 = null;
            t84.c r8 = null;
            int r9 = 0;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L18;
            int r11 = r14.decodeElementIndex(r0);
            if (r11 != (-1)) goto L9;
            r10 = false;
            goto L6
        L9:
            if (r11 != 0) goto L10;
            r6 = (String) r14.decodeNullableSerializableElement(r0, 0, v2.a, r6);
            r9 = r9 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r7 = (Map) r14.decodeSerializableElement(r0, 1, r1[1], r7);
            r9 = r9 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r8 = (t84.c) r14.decodeSerializableElement(r0, 2, t84.c.a.a, r8);
            r9 = r9 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r11);
        L18:
            r5 = r9;
            r2 = r6;
            r3 = r7;
            r4 = r8;
            goto L19
        }

        public final void serialize(muc.f r7, Object r8) {
            j r9 = (j) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            juc.n[] r1 = j.d;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, v2.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeSerializableElement(r0, 1, r1[1], r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r10.encodeSerializableElement(r0, 2, t84.c.a.a, r9.c);
        L28:
            r10.endStructure(r0);
            return;
        L24:
            if (Intrinsics.areEqual(r9.c, new t84.c(0)) == true) goto L26;
        L15:
            if (Intrinsics.areEqual(r9.b, MapsKt.emptyMap()) == false) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r9.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<j> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    static {
        Companion = new b();
        d = new juc.d[]{null, new a1(v2.a, t84.b.a.a), null};
    }

    public final String toString() {
        return "YawConfig{profile='" + this.a + "', universalThreshold='" + this.c + "', dynamicThreshold='" + this.b + "'}";
    }

    public j() {
        this(null, MapsKt.emptyMap(), new t84.c(0));
    }

    public j(String r2, Map<String, t84.b> r3, t84.c r4) {
        Intrinsics.checkNotNullParameter(r3, "dynamicThreshold");
        Intrinsics.checkNotNullParameter(r4, "universalThreshold");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public j(int r4, String r5, Map r6, t84.c r7) {
        if ((r4 & 0) == 0) goto L5;
        b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r4 & 2) != 0) goto L11;
        r6 = MapsKt.emptyMap();
    L11:
        this.b = r6;
        if ((r4 & 4) != 0) goto L14;
        r7 = new t84.c(0);
    L14:
        this.c = r7;
        return;
    L7:
        this.a = r5;
        goto L9
    }
}
