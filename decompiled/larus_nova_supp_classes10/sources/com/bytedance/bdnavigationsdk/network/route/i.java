package com.bytedance.bdnavigationsdk.network.route;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class i {
    public static final b Companion = null;
    public final int a;
    public final int b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<i> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            w0 r1 = w0.a;
            return new juc.d[]{r1, r1};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.network.route.RouteLeg", r0, 2);
            r1.j("step_start_index", true);
            r1.j("step_end_index", true);
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
            int r1 = r11.decodeIntElement(r0, 0);
            int r2 = r11.decodeIntElement(r0, 1);
            int r3 = 3;
        L17:
            r11.endStructure(r0);
            return new i(r3, r1, r2);
        L5:
            r1 = 0;
            int r4 = 0;
            int r5 = 0;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L16;
            int r7 = r11.decodeElementIndex(r0);
            if (r7 != (-1)) goto L9;
            r6 = false;
            goto L6
        L9:
            if (r7 != 0) goto L10;
            r1 = r11.decodeIntElement(r0, 0);
            r5 = r5 | 1;
            goto L6
        L10:
            if (r7 != 1) goto L13;
            r4 = r11.decodeIntElement(r0, 1);
            r5 = r5 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r7);
        L16:
            r2 = r4;
            r3 = r5;
            goto L17
        }

        public final void serialize(muc.f r5, Object r6) {
            i r7 = (i) r6;
            Intrinsics.checkNotNullParameter(r5, "encoder");
            Intrinsics.checkNotNullParameter(r7, "value");
            g2 r0 = b;
            muc.d r8 = r5.beginStructure(r0);
            b r1 = i.Companion;
            boolean r2 = false;
            if (r8.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r8.encodeIntElement(r0, 0, r7.a);
        L12:
            if (r8.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r8.encodeIntElement(r0, 1, r7.b);
        L19:
            r8.endStructure(r0);
            return;
        L15:
            if (r7.b == 0) goto L17;
        L6:
            if (r7.a != 0) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<i> serializer() {
            return a.a;
        }
    }

    static {
        Companion = new b();
    }

    public i() {
        this.a = 0;
        this.b = 0;
    }

    public i(int r3, int r4, int r5) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = 0;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = 0;
        return;
    L11:
        this.b = r5;
        return;
    L7:
        this.a = r4;
        goto L9
    }
}
