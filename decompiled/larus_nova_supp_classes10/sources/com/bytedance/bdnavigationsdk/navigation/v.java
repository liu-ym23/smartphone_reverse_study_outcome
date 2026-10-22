package com.bytedance.bdnavigationsdk.navigation;

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
public final class v {
    public static final b Companion = null;
    public String a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<v> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{v2.a};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.navigation.NotificationInstruction", r0, 1);
            r1.j("instruction", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r8) {
            Intrinsics.checkNotNullParameter(r8, "decoder");
            g2 r0 = b;
            muc.c r9 = r8.beginStructure(r0);
            int r2 = 1;
            if (r9.decodeSequentially() == false) goto L5;
            String r1 = r9.decodeStringElement(r0, 0);
        L15:
            r9.endStructure(r0);
            return new v(r2, r1);
        L5:
            r1 = null;
            int r4 = 0;
        L6:
            if (r2 == 0) goto L14;
            int r5 = r9.decodeElementIndex(r0);
            if (r5 != (-1)) goto L9;
            r2 = 0;
            goto L6
        L9:
            if (r5 != 0) goto L12;
            r1 = r9.decodeStringElement(r0, 0);
            r4 = r4 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r5);
        L14:
            r2 = r4;
            goto L15
        }

        public final void serialize(muc.f r5, Object r6) {
            v r7 = (v) r6;
            Intrinsics.checkNotNullParameter(r5, "encoder");
            Intrinsics.checkNotNullParameter(r7, "value");
            g2 r0 = b;
            muc.d r8 = r5.beginStructure(r0);
            b r1 = v.Companion;
            if (r8.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L11;
            r8.encodeStringElement(r0, 0, r7.a);
        L11:
            r8.endStructure(r0);
            return;
        L6:
            if (Intrinsics.areEqual(r7.a, "") == false) goto L7;
            r2 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<v> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof v) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((v) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    static {
        Companion = new b();
    }

    public v() {
        this("");
    }

    public final String toString() {
        return "NotificationInstruction{instruction='" + this.a + "'}";
    }

    public v(String r2) {
        Intrinsics.checkNotNullParameter(r2, "instruction");
        this.a = r2;
    }

    public v(int r2, String r3) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.a = "";
        return;
    L7:
        this.a = r3;
    }
}
