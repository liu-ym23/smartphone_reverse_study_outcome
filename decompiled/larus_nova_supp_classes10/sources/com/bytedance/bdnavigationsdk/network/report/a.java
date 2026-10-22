package com.bytedance.bdnavigationsdk.network.report;

import com.bytedance.bdnavigationsdk.contants.Constants;
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
public final class a {
    public static final b Companion = null;
    public final Boolean a;
    public final String b;

    /* JADX INFO: renamed from: com.bytedance.bdnavigationsdk.network.report.a$a, reason: collision with other inner class name */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class C0132a implements m0<a> {
        public static final C0132a a = null;
        public static final g2 b = null;

        public C0132a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(nuc.i.a), v2.a};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            C0132a r0 = new C0132a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.network.report.ReportConfig", r0, 2);
            r1.j("enable", true);
            r1.j("public_key_base64", true);
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
            Boolean r1 = (Boolean) r11.decodeNullableSerializableElement(r0, 0, nuc.i.a, null);
            String r2 = r11.decodeStringElement(r0, 1);
            int r3 = 3;
        L17:
            r11.endStructure(r0);
            return new a(r3, r1, r2);
        L5:
            Boolean r5 = null;
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
            r5 = (Boolean) r11.decodeNullableSerializableElement(r0, 0, nuc.i.a, r5);
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
            a r8 = (a) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            b r1 = a.Companion;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeNullableSerializableElement(r0, 0, nuc.i.a, r8.a);
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
            if (Intrinsics.areEqual(r8.b, Constants.PublicKey.getValue()) == true) goto L17;
        L6:
            if (Intrinsics.areEqual(r8.a, Boolean.TRUE) == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<a> serializer() {
            return C0132a.a;
        }
    }

    public a() {
        this(null, 3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.b.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    static {
        Companion = new b();
    }

    public final String toString() {
        return "ReportConfig{enable=" + this.a + ", publicKeyBase64='" + this.b + "'}";
    }

    public a(Boolean r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = Boolean.TRUE;
    L6:
        if ((r3 & 2) == 0) goto L8;
        String r4 = Constants.PublicKey.getValue();
    L9:
        Intrinsics.checkNotNullParameter(r4, "publicKeyBase64");
        this.a = r2;
        this.b = r4;
        return;
    L8:
        r4 = null;
        goto L9
    }

    public a(int r2, Boolean r3, String r4) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, C0132a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        r3 = Boolean.TRUE;
    L7:
        this.a = r3;
        if ((r2 & 2) != 0) goto L10;
        this.b = Constants.PublicKey.getValue();
        return;
    L10:
        this.b = r4;
    }
}
