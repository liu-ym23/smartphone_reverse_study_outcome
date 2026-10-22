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
public final class w1 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f295537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f295538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g1 f295539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g1 f295540d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<w1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295541a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295542b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            g1.a r100 = g1.a.f295160a;
            return new juc.d[]{kuc.a.d(nuc.i.f520705a), kuc.a.d(v2.f520790a), kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295542b;
        }

        static {
            a r100 = new a();
            f295541a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ReasoningEffortSectionConf", r100, 4);
            r101.j("show", true);
            r101.j("name", true);
            r101.j("icon", true);
            r101.j("dark_mode_icon", true);
            f295542b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f295542b;
            muc.c r101 = r110.beginStructure(r100);
            Boolean r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            Boolean r103 = (Boolean) r101.decodeNullableSerializableElement(r100, 0, nuc.i.f520705a, null);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, null);
            g1.a r105 = g1.a.f295160a;
            Boolean r111 = r103;
            g1 r112 = (g1) r101.decodeNullableSerializableElement(r100, 2, r105, null);
            String r113 = r104;
            g1 r114 = (g1) r101.decodeNullableSerializableElement(r100, 3, r105, null);
            int r115 = 15;
        L21:
            r101.endStructure(r100);
            return new w1(r115, r111, r113, r112, r114);
        L5:
            String r106 = null;
            g1 r107 = null;
            g1 r116 = null;
            int r108 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L20;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 != 0) goto L10;
            r102 = (Boolean) r101.decodeNullableSerializableElement(r100, 0, nuc.i.f520705a, r102);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r118 != 1) goto L11;
            r106 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r106);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r107 = (g1) r101.decodeNullableSerializableElement(r100, 2, g1.a.f295160a, r107);
            r108 = r108 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r116 = (g1) r101.decodeNullableSerializableElement(r100, 3, g1.a.f295160a, r116);
            r108 = r108 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r115 = r108;
            r111 = r102;
            r113 = r106;
            r112 = r107;
            r114 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            w1 r102 = (w1) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295542b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = w1.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, nuc.i.f520705a, r102.f295537a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f295538b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeNullableSerializableElement(r103, 2, g1.a.f295160a, r102.f295539c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            r106 = true;
        L35:
            if (r106 == false) goto L37;
            r104.encodeNullableSerializableElement(r103, 3, g1.a.f295160a, r102.f295540d);
        L37:
            r104.endStructure(r103);
            return;
        L33:
            if (r102.f295540d == null) goto L35;
        L24:
            if (r102.f295539c != null) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f295538b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f295537a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<w1> serializer() {
            return a.f295541a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w1) == true) goto L8;
        return false;
    L8:
        w1 r101 = (w1) r100;
        if (Intrinsics.areEqual(this.f295537a, r101.f295537a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295538b, r101.f295538b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295539c, r101.f295539c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295540d, r101.f295540d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f295537a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f295538b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        g1 r107 = this.f295539c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        g1 r110 = this.f295540d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReasoningEffortSectionConf(show=" + this.f295537a + ", name=" + this.f295538b + ", icon=" + this.f295539c + ", darkModeIcon=" + this.f295540d + ')';
    }

    static {
        Companion = new b();
    }

    public w1() {
        this.f295537a = null;
        this.f295538b = null;
        this.f295539c = null;
        this.f295540d = null;
    }

    public w1(int r100, Boolean r101, String r102, g1 r103, g1 r104) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295542b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f295537a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f295538b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f295539c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f295540d = null;
        return;
    L19:
        this.f295540d = r104;
        return;
    L15:
        this.f295539c = r103;
        goto L17
    L11:
        this.f295538b = r102;
        goto L13
    L7:
        this.f295537a = r101;
        goto L9
    }
}
