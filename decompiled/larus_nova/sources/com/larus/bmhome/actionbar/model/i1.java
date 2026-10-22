package com.larus.bmhome.actionbar.model;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;

/* JADX INFO: loaded from: classes25.dex */
@Serializable
public final class i1 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f295200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f295201b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<i1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295202a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295203b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            nuc.i r100 = nuc.i.f520705a;
            return new juc.d[]{r100, r100};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295203b;
        }

        static {
            a r100 = new a();
            f295202a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.InputBoxSettings", r100, 2);
            r101.j("show_camera", true);
            r101.j("show_file_upload", true);
            f295203b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f295203b;
            muc.c r111 = r110.beginStructure(r100);
            if (r111.decodeSequentially() == false) goto L5;
            boolean r101 = r111.decodeBooleanElement(r100, 0);
            boolean r102 = r111.decodeBooleanElement(r100, 1);
            int r103 = 3;
        L17:
            r111.endStructure(r100);
            return new i1(r103, r101, r102);
        L5:
            r101 = false;
            boolean r104 = false;
            int r105 = 0;
            boolean r106 = true;
        L6:
            if (r106 == false) goto L16;
            int r107 = r111.decodeElementIndex(r100);
            if (r107 != (-1)) goto L9;
            r106 = false;
            goto L6
        L9:
            if (r107 != 0) goto L10;
            r101 = r111.decodeBooleanElement(r100, 0);
            r105 = r105 | 1;
            goto L6
        L10:
            if (r107 != 1) goto L13;
            r104 = r111.decodeBooleanElement(r100, 1);
            r105 = r105 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r107);
        L16:
            r102 = r104;
            r103 = r105;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            i1 r102 = (i1) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295203b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = i1.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeBooleanElement(r103, 0, r102.f295200a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeBooleanElement(r103, 1, r102.f295201b);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (r102.f295201b == false) goto L17;
        L6:
            if (r102.f295200a == true) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<i1> serializer() {
            return a.f295202a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i1) == true) goto L8;
        return false;
    L8:
        i1 r101 = (i1) r100;
        if (this.f295200a == r101.f295200a) goto L12;
        return false;
    L12:
        if (this.f295201b == r101.f295201b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f295200a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f295201b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "InputBoxSettings(showCamera=" + this.f295200a + ", showFileUpload=" + this.f295201b + ')';
    }

    static {
        Companion = new b();
    }

    public i1() {
        this.f295200a = false;
        this.f295201b = false;
    }

    public i1(int r100, boolean r101, boolean r102) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295203b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f295200a = false;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f295201b = false;
        return;
    L11:
        this.f295201b = r102;
        return;
    L7:
        this.f295200a = r101;
        goto L9
    }
}
