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

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class v {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f200106a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<v> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f200107a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f200108b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{v2.f520790a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f200108b;
        }

        static {
            a r100 = new a();
            f200107a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.navigation.NotificationInstruction", r100, 1);
            r101.j("instruction", true);
            f200108b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            g2 r101 = f200108b;
            muc.c r102 = r100.beginStructure(r101);
            int r103 = 1;
            if (r102.decodeSequentially() == false) goto L5;
            String r104 = r102.decodeStringElement(r101, 0);
        L15:
            r102.endStructure(r101);
            return new v(r103, r104);
        L5:
            r104 = null;
            int r105 = 0;
        L6:
            if (r103 == 0) goto L14;
            int r106 = r102.decodeElementIndex(r101);
            if (r106 != (-1)) goto L9;
            r103 = 0;
            goto L6
        L9:
            if (r106 != 0) goto L12;
            r104 = r102.decodeStringElement(r101, 0);
            r105 = r105 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r106);
        L14:
            r103 = r105;
            goto L15
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            v r102 = (v) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f200108b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = v.Companion;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r106 = true;
        L9:
            if (r106 == false) goto L11;
            r104.encodeStringElement(r103, 0, r102.f200106a);
        L11:
            r104.endStructure(r103);
            return;
        L6:
            if (Intrinsics.areEqual(r102.f200106a, "") == false) goto L7;
            r106 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<v> serializer() {
            return a.f200107a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f200106a, ((v) r100).f200106a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f200106a.hashCode();
    }

    static {
        Companion = new b();
    }

    public v() {
        this("");
    }

    public final String toString() {
        return "NotificationInstruction{instruction='" + this.f200106a + "'}";
    }

    public v(String r100) {
        Intrinsics.checkNotNullParameter(r100, "instruction");
        this.f200106a = r100;
    }

    public v(int r100, String r101) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f200108b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f200106a = "";
        return;
    L7:
        this.f200106a = r101;
    }
}
