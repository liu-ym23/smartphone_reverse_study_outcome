package com.larus.bmhome.actionbar.model;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: classes25.dex */
@Serializable
public final class z1 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f295633e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f295634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f295635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f295636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f295637d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<z1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295638a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295639b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295639b;
        }

        static {
            a r100 = new a();
            f295638a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.SubscribeConfig", r100, 4);
            r101.j("jump_url", true);
            r101.j("need_upgrade", true);
            r101.j("button_text", true);
            r101.j("extra", true);
            f295639b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = z1.f295633e;
            v2 r101 = v2.f520790a;
            return new juc.d[]{kuc.a.d(r101), kuc.a.d(nuc.i.f520705a), kuc.a.d(r101), kuc.a.d(r100[3].getValue())};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f295639b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = z1.f295633e;
            String r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r104 = v2.f520790a;
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            Boolean r106 = (Boolean) r101.decodeNullableSerializableElement(r100, 1, nuc.i.f520705a, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 2, r104, null);
            Map r110 = (Map) r101.decodeNullableSerializableElement(r100, 3, r102[3].getValue(), null);
            String r111 = r107;
            String r112 = r105;
            Boolean r113 = r106;
            int r114 = 15;
        L21:
            r101.endStructure(r100);
            return new z1(r114, r112, r113, r111, r110);
        L5:
            Boolean r108 = null;
            String r115 = null;
            Map r116 = null;
            int r109 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L20;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 != 0) goto L10;
            r103 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r103);
            r109 = r109 | 1;
            goto L6
        L10:
            if (r118 != 1) goto L11;
            r108 = (Boolean) r101.decodeNullableSerializableElement(r100, 1, nuc.i.f520705a, r108);
            r109 = r109 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r115 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r115);
            r109 = r109 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r116 = (Map) r101.decodeNullableSerializableElement(r100, 3, r102[3].getValue(), r116);
            r109 = r109 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r114 = r109;
            r112 = r103;
            r113 = r108;
            r111 = r115;
            r110 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            z1 r102 = (z1) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295639b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = z1.f295633e;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f295634a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, nuc.i.f520705a, r102.f295635b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeNullableSerializableElement(r103, 2, v2.f520790a, r102.f295636c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            r106 = true;
        L35:
            if (r106 == false) goto L37;
            r104.encodeNullableSerializableElement(r103, 3, r105[3].getValue(), r102.f295637d);
        L37:
            r104.endStructure(r103);
            return;
        L33:
            if (r102.f295637d == null) goto L35;
        L24:
            if (r102.f295636c != null) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f295635b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f295634a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<z1> serializer() {
            return a.f295638a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z1) == true) goto L8;
        return false;
    L8:
        z1 r101 = (z1) r100;
        if (Intrinsics.areEqual(this.f295634a, r101.f295634a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295635b, r101.f295635b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295636c, r101.f295636c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295637d, r101.f295637d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f295634a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f295635b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f295636c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.f295637d;
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
        return "SubscribeConfig(jumpUrl=" + this.f295634a + ", needUpgrade=" + this.f295635b + ", buttonText=" + this.f295636c + ", extra=" + this.f295637d + ')';
    }

    static {
        Companion = new b();
        f295633e = new Lazy[]{null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.v1())};
    }

    public z1() {
        this.f295634a = null;
        this.f295635b = null;
        this.f295636c = null;
        this.f295637d = null;
    }

    public z1(int r100, String r101, Boolean r102, String r103, Map r104) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295639b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f295634a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f295635b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f295636c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f295637d = null;
        return;
    L19:
        this.f295637d = r104;
        return;
    L15:
        this.f295636c = r103;
        goto L17
    L11:
        this.f295635b = r102;
        goto L13
    L7:
        this.f295634a = r101;
        goto L9
    }
}
