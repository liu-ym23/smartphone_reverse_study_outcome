package com.bytedance.bdnavigationsdk.network.report;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class c {
    public static final b Companion = null;
    public final e a;
    public final k b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{e.a.a, k.a.a};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.network.report.ReportContent", r0, 2);
            r1.j("content", false);
            r1.j("system", false);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r10) {
            Intrinsics.checkNotNullParameter(r10, "decoder");
            g2 r0 = b;
            muc.c r11 = r10.beginStructure(r0);
            k r4 = null;
            if (r11.decodeSequentially() == false) goto L5;
            e r1 = (e) r11.decodeSerializableElement(r0, 0, e.a.a, null);
            k r2 = (k) r11.decodeSerializableElement(r0, 1, k.a.a, null);
            int r3 = 3;
        L17:
            r11.endStructure(r0);
            return new c(r3, r1, r2);
        L5:
            e r5 = null;
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
            r5 = (e) r11.decodeSerializableElement(r0, 0, e.a.a, r5);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r8 != 1) goto L13;
            r4 = (k) r11.decodeSerializableElement(r0, 1, k.a.a, r4);
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

        public final void serialize(muc.f r5, Object r6) {
            c r7 = (c) r6;
            Intrinsics.checkNotNullParameter(r5, "encoder");
            Intrinsics.checkNotNullParameter(r7, "value");
            g2 r0 = b;
            muc.d r8 = r5.beginStructure(r0);
            b r1 = c.Companion;
            r8.encodeSerializableElement(r0, 0, e.a.a, r7.a);
            r8.encodeSerializableElement(r0, 1, k.a.a, r7.b);
            r8.endStructure(r0);
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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    static {
        Companion = new b();
    }

    public final String toString() {
        return "ReportInfo{content=" + this.a + ", system=" + this.b + "}";
    }

    public c(e r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, "system");
        this.a = r2;
        this.b = r3;
    }

    public c(int r3, e r4, k r5) {
        if (3 != (r3 & 3)) goto L6;
        this.a = r4;
        this.b = r5;
        return;
    L6:
        b2.b(r3, 3, a.b);
        throw null;
    }
}
