package n84;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import ouc.v;
import ouc.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class f {
    private static final b Companion = null;
    public static final v c = null;
    public final boolean a;
    public final d b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<f> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{i.a, kuc.a.d(d.a.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.agent.NavigationAgentSnapshotResponse", r0, 2);
            r1.j("is_running", false);
            r1.j("navigation_agent_snapshot", false);
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
            boolean r1 = r11.decodeBooleanElement(r0, 0);
            d r2 = (d) r11.decodeNullableSerializableElement(r0, 1, d.a.a, null);
            int r3 = 3;
        L17:
            r11.endStructure(r0);
            return new f(r3, r1, r2);
        L5:
            d r5 = null;
            r1 = false;
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
            r1 = r11.decodeBooleanElement(r0, 0);
            r4 = r4 | 1;
            goto L6
        L10:
            if (r7 != 1) goto L13;
            r5 = (d) r11.decodeNullableSerializableElement(r0, 1, d.a.a, r5);
            r4 = r4 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r7);
        L16:
            r3 = r4;
            r2 = r5;
            goto L17
        }

        public final void serialize(muc.f r4, Object r5) {
            f r6 = (f) r5;
            Intrinsics.checkNotNullParameter(r4, "encoder");
            Intrinsics.checkNotNullParameter(r6, "value");
            g2 r0 = b;
            muc.d r7 = r4.beginStructure(r0);
            r7.encodeBooleanElement(r0, 0, r6.a);
            r7.encodeNullableSerializableElement(r0, 1, d.a.a, r6.b);
            r7.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<f> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        d r2 = this.b;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "NavigationAgentSnapshotResponse(isRunning=" + this.a + ", navigationAgentSnapshot=" + this.b + ")";
    }

    static {
        Companion = new b();
        c = w.a(new e());
    }

    public final String a() {
        v r0 = c;
        r0.getClass();
        return r0.a(Companion.serializer(), this);
    }

    public f(boolean r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    public f(int r3, boolean r4, d r5) {
        if (3 != (r3 & 3)) goto L6;
        this.a = r4;
        this.b = r5;
        return;
    L6:
        b2.b(r3, 3, a.b);
        throw null;
    }
}
