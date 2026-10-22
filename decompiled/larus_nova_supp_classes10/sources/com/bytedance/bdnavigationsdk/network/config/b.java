package com.bytedance.bdnavigationsdk.network.config;

import java.util.List;
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
import y84.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class b {
    public static final C0131b Companion = null;
    public static final juc.d<Object>[] c = null;
    public com.bytedance.bdnavigationsdk.network.report.a a;
    public List<j> b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<b> {
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
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.network.config.ConfigureInfo", r0, 2);
            r1.j("report_config", true);
            r1.j("yaw_config", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(com.bytedance.bdnavigationsdk.network.report.a.C0132a.a), kuc.a.d(b.c[1])};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r11) {
            Intrinsics.checkNotNullParameter(r11, "decoder");
            g2 r0 = b;
            muc.c r12 = r11.beginStructure(r0);
            juc.c[] r1 = b.c;
            List r5 = null;
            if (r12.decodeSequentially() == false) goto L5;
            com.bytedance.bdnavigationsdk.network.report.a r2 = (com.bytedance.bdnavigationsdk.network.report.a) r12.decodeNullableSerializableElement(r0, 0, com.bytedance.bdnavigationsdk.network.report.a.C0132a.a, null);
            List r3 = (List) r12.decodeNullableSerializableElement(r0, 1, r1[1], null);
            int r4 = 3;
        L17:
            r12.endStructure(r0);
            return new b(r4, r2, r3);
        L5:
            com.bytedance.bdnavigationsdk.network.report.a r6 = null;
            int r7 = 0;
            boolean r8 = true;
        L6:
            if (r8 == false) goto L16;
            int r9 = r12.decodeElementIndex(r0);
            if (r9 != (-1)) goto L9;
            r8 = false;
            goto L6
        L9:
            if (r9 != 0) goto L10;
            r6 = (com.bytedance.bdnavigationsdk.network.report.a) r12.decodeNullableSerializableElement(r0, 0, com.bytedance.bdnavigationsdk.network.report.a.C0132a.a, r6);
            r7 = r7 | 1;
            goto L6
        L10:
            if (r9 != 1) goto L13;
            r5 = (List) r12.decodeNullableSerializableElement(r0, 1, r1[1], r5);
            r7 = r7 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r9);
        L16:
            r4 = r7;
            r3 = r5;
            r2 = r6;
            goto L17
        }

        public final void serialize(muc.f r7, Object r8) {
            b r9 = (b) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            n[] r1 = b.c;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, com.bytedance.bdnavigationsdk.network.report.a.C0132a.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r10.encodeNullableSerializableElement(r0, 1, r1[1], r9.b);
        L19:
            r10.endStructure(r0);
            return;
        L15:
            if (r9.b == null) goto L17;
        L6:
            if (r9.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdnavigationsdk.network.config.b$b, reason: collision with other inner class name */
    public static final class C0131b {
        public C0131b() {
        }

        public final juc.d<b> serializer() {
            return a.a;
        }
    }

    public b() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        com.bytedance.bdnavigationsdk.network.report.a r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<j> r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    static {
        Companion = new C0131b();
        c = new juc.d[]{null, new nuc.f(j.a.a)};
    }

    public final String toString() {
        return "ConfigureInfo{reportConfig=" + this.a + ", yawConfigs=" + this.b + "}";
    }

    public b(Object r1) {
        this.a = null;
        this.b = null;
    }

    public b(int r3, com.bytedance.bdnavigationsdk.network.report.a r4, List r5) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = null;
        return;
    L11:
        this.b = r5;
        return;
    L7:
        this.a = r4;
        goto L9
    }
}
