package com.bytedance.kmp.network;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes19.dex */
@Serializable
public final class b {
    public static final C3601b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f252479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f252480b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class a implements m0<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f252481a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ g2 f252482b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new juc.d[]{r100, r100};
        }

        static {
            a r100 = new a();
            f252481a = r100;
            g2 r101 = new g2("com.bytedance.kmp.network.Header", r100, 2);
            r101.j("name", true);
            r101.j("value", true);
            f252482b = r101;
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f252482b;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f252482b;
            muc.c r111 = r110.beginStructure(r100);
            if (r111.decodeSequentially() == false) goto L5;
            String r101 = r111.decodeStringElement(r100, 0);
            String r102 = r111.decodeStringElement(r100, 1);
            int r103 = 3;
        L17:
            r111.endStructure(r100);
            return new b(r103, r101, r102);
        L5:
            r101 = null;
            String r104 = null;
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
            r101 = r111.decodeStringElement(r100, 0);
            r105 = r105 | 1;
            goto L6
        L10:
            if (r107 != 1) goto L13;
            r104 = r111.decodeStringElement(r100, 1);
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
            b r102 = (b) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f252482b;
            muc.d r104 = r100.beginStructure(r103);
            C3601b r105 = b.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeStringElement(r103, 0, r102.f252479a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeStringElement(r103, 1, r102.f252480b);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (Intrinsics.areEqual(r102.f252480b, "") == true) goto L17;
        L6:
            if (Intrinsics.areEqual(r102.f252479a, "") == false) goto L7;
            r107 = false;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.bytedance.kmp.network.b$b, reason: collision with other inner class name */
    public static final class C3601b {
        public C3601b() {
        }

        public final juc.d<b> serializer() {
            return a.f252481a;
        }
    }

    static {
        Companion = new C3601b();
    }

    public final String toString() {
        return "name='" + this.f252479a + "', value='" + this.f252480b + '\'';
    }

    public b() {
        this.f252479a = "";
        this.f252480b = "";
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public b(int r100, String r101, String r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f252482b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f252479a = "";
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f252480b = "";
        return;
    L11:
        this.f252480b = r102;
        return;
    L7:
        this.f252479a = r101;
        goto L9
    }
}
