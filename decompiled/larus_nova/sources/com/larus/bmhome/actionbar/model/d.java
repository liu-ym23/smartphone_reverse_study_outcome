package com.larus.bmhome.actionbar.model;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: classes25.dex */
@Serializable
public final class d {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f295054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f295055b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295056a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295057b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(nuc.w0.f520792a), kuc.a.d(v2.f520790a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295057b;
        }

        static {
            a r100 = new a();
            f295056a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ActionBarDegradeConfig", r100, 2);
            r101.j("degrade_type", true);
            r101.j("toast_message", true);
            f295057b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f295057b;
            muc.c r111 = r110.beginStructure(r100);
            String r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            Integer r102 = (Integer) r111.decodeNullableSerializableElement(r100, 0, nuc.w0.f520792a, null);
            String r103 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, null);
            int r104 = 3;
        L17:
            r111.endStructure(r100);
            return new d(r104, r102, r103);
        L5:
            Integer r105 = null;
            int r106 = 0;
            boolean r107 = true;
        L6:
            if (r107 == false) goto L16;
            int r108 = r111.decodeElementIndex(r100);
            if (r108 != (-1)) goto L9;
            r107 = false;
            goto L6
        L9:
            if (r108 != 0) goto L10;
            r105 = (Integer) r111.decodeNullableSerializableElement(r100, 0, nuc.w0.f520792a, r105);
            r106 = r106 | 1;
            goto L6
        L10:
            if (r108 != 1) goto L13;
            r101 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, r101);
            r106 = r106 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r108);
        L16:
            r104 = r106;
            r103 = r101;
            r102 = r105;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            d r102 = (d) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295057b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = d.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, nuc.w0.f520792a, r102.f295054a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f295055b);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (r102.f295055b == null) goto L17;
        L6:
            if (r102.f295054a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<d> serializer() {
            return a.f295056a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f295054a, r101.f295054a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295055b, r101.f295055b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f295054a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f295055b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarDegradeConfig(degradeType=" + this.f295054a + ", toastMessage=" + this.f295055b + ')';
    }

    static {
        Companion = new b();
    }

    public d() {
        this.f295054a = null;
        this.f295055b = null;
    }

    public d(int r100, Integer r101, String r102) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295057b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f295054a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f295055b = null;
        return;
    L11:
        this.f295055b = r102;
        return;
    L7:
        this.f295054a = r101;
        goto L9
    }
}
