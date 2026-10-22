package com.larus.bmhome.actionbar.model;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;

/* JADX INFO: loaded from: classes25.dex */
@Serializable
public final class p implements k1 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h1 f295361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f295362b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295363a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295364b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(h1.a.f295190a), kuc.a.d(nuc.i.f520705a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295364b;
        }

        static {
            a r100 = new a();
            f295363a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ActionBarInputBoxTemplate", r100, 2);
            r101.j("input_box_content", true);
            r101.j("choose_required", true);
            f295364b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f295364b;
            muc.c r111 = r110.beginStructure(r100);
            Boolean r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            h1 r102 = (h1) r111.decodeNullableSerializableElement(r100, 0, h1.a.f295190a, null);
            Boolean r103 = (Boolean) r111.decodeNullableSerializableElement(r100, 1, nuc.i.f520705a, null);
            int r104 = 3;
        L17:
            r111.endStructure(r100);
            return new p(r104, r102, r103);
        L5:
            h1 r105 = null;
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
            r105 = (h1) r111.decodeNullableSerializableElement(r100, 0, h1.a.f295190a, r105);
            r106 = r106 | 1;
            goto L6
        L10:
            if (r108 != 1) goto L13;
            r101 = (Boolean) r111.decodeNullableSerializableElement(r100, 1, nuc.i.f520705a, r101);
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
            p r102 = (p) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295364b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = p.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, h1.a.f295190a, r102.f295361a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeNullableSerializableElement(r103, 1, nuc.i.f520705a, r102.f295362b);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (Intrinsics.areEqual(r102.f295362b, Boolean.FALSE) == true) goto L17;
        L6:
            if (r102.f295361a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<p> serializer() {
            return a.f295363a;
        }
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        return null;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final List<String> b(List<String> r100) {
        return null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f295361a, r101.f295361a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295362b, r101.f295362b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        h1 r100 = this.f295361a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f295362b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarInputBoxTemplate(inputBoxContent=" + this.f295361a + ", chooseRequired=" + this.f295362b + ')';
    }

    static {
        Companion = new b();
    }

    public p() {
        Boolean r100 = Boolean.FALSE;
        this.f295361a = null;
        this.f295362b = r100;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r100, List<String> r101) {
        h1 r102 = this.f295361a;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.f295181b;
    }

    public p(int r100, h1 r101, Boolean r102) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295364b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f295361a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f295362b = Boolean.FALSE;
        return;
    L11:
        this.f295362b = r102;
        return;
    L7:
        this.f295361a = r101;
        goto L9
    }
}
