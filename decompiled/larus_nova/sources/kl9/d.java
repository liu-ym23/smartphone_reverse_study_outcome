package kl9;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class d {
    public static final b Companion = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f503881g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f503882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f503883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f503884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f503885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f503886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f503887f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f503888a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f503889b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f503889b;
        }

        static {
            a r100 = new a();
            f503888a = r100;
            g2 r101 = new g2("com.larus.multitask_management.api.data.ConfirmConfig", r100, 6);
            r101.j("need_confirm", true);
            r101.j("title", true);
            r101.j("content", true);
            r101.j("confirm_button_text", true);
            r101.j("cancel_button_text", true);
            r101.j("extra", true);
            f503889b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = d.f503881g;
            v2 r101 = v2.f520790a;
            return new juc.d[]{nuc.i.f520705a, r101, r101, r101, r101, kuc.a.d(r100[5].getValue())};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f503889b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = d.f503881g;
            if (r101.decodeSequentially() == false) goto L5;
            boolean r103 = r101.decodeBooleanElement(r100, 0);
            String r104 = r101.decodeStringElement(r100, 1);
            String r105 = r101.decodeStringElement(r100, 2);
            String r106 = r101.decodeStringElement(r100, 3);
            String r107 = r101.decodeStringElement(r100, 4);
            Map r110 = (Map) r101.decodeNullableSerializableElement(r100, 5, r102[5].getValue(), null);
            boolean r111 = r103;
            String r112 = r105;
            String r113 = r107;
            String r114 = r104;
            String r115 = r106;
            int r108 = 63;
        L20:
            r101.endStructure(r100);
            return new d(r108, r111, r114, r112, r115, r113, r110);
        L5:
            String r116 = null;
            String r117 = null;
            String r118 = null;
            Map r119 = null;
            String r120 = null;
            boolean r109 = false;
            int r121 = 0;
            boolean r122 = true;
        L6:
            if (r122 == false) goto L19;
            int r123 = r101.decodeElementIndex(r100);
            switch(r123) {
                case -1: goto L18;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r123);
        L17:
            r109 = r101.decodeBooleanElement(r100, 0);
            r121 = r121 | 1;
            goto L6
        L18:
            r122 = false;
            goto L6
        L11:
            r121 = r121 | 32;
            r119 = (Map) r101.decodeNullableSerializableElement(r100, 5, r102[5].getValue(), r119);
            goto L6
        L12:
            r121 = r121 | 16;
            r117 = r101.decodeStringElement(r100, 4);
            goto L6
        L13:
            r121 = r121 | 8;
            r116 = r101.decodeStringElement(r100, 3);
            goto L6
        L14:
            r121 = r121 | 4;
            r120 = r101.decodeStringElement(r100, 2);
            goto L6
        L15:
            r121 = r121 | 2;
            r118 = r101.decodeStringElement(r100, 1);
            goto L6
        L19:
            r108 = r121;
            r111 = r109;
            String r124 = r118;
            r115 = r116;
            r114 = r124;
            Map r125 = r119;
            r113 = r117;
            r112 = r120;
            r110 = r125;
            goto L20
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            d r102 = (d) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f503889b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = d.f503881g;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeBooleanElement(r103, 0, r102.f503882a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeStringElement(r103, 1, r102.f503883b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeStringElement(r103, 2, r102.f503884c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            boolean r110 = true;
        L36:
            if (r110 == false) goto L39;
            r104.encodeStringElement(r103, 3, r102.f503885d);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
        L43:
            boolean r111 = true;
        L45:
            if (r111 == false) goto L48;
            r104.encodeStringElement(r103, 4, r102.f503886e);
        L48:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
        L52:
            r106 = true;
        L53:
            if (r106 == false) goto L55;
            r104.encodeNullableSerializableElement(r103, 5, r105[5].getValue(), r102.f503887f);
        L55:
            r104.endStructure(r103);
            return;
        L51:
            if (r102.f503887f == null) goto L53;
        L42:
            if (Intrinsics.areEqual(r102.f503886e, "") == false) goto L43;
            r111 = false;
            goto L45
        L33:
            if (Intrinsics.areEqual(r102.f503885d, "") == false) goto L34;
            r110 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r102.f503884c, "") == false) goto L25;
            r109 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r102.f503883b, "") == false) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f503882a != true) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<d> serializer() {
            return a.f503888a;
        }
    }

    public d() {
        this(false, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f503882a == r101.f503882a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f503883b, r101.f503883b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f503884c, r101.f503884c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f503885d, r101.f503885d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f503886e, r101.f503886e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f503887f, r101.f503887f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.f503882a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((((((r100 * 31) + this.f503883b.hashCode()) * 31) + this.f503884c.hashCode()) * 31) + this.f503885d.hashCode()) * 31) + this.f503886e.hashCode()) * 31;
        Map<String, String> r102 = this.f503887f;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ConfirmConfig(needConfirm=" + this.f503882a + ", title=" + this.f503883b + ", content=" + this.f503884c + ", confirmButtonText=" + this.f503885d + ", cancelButtonText=" + this.f503886e + ", extra=" + this.f503887f + ')';
    }

    static {
        Companion = new b();
        f503881g = new Lazy[]{null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new c())};
    }

    public d(boolean r100, String r101, String r102, String r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L11;
        String r105 = "";
    L13:
        if ((r104 & 8) == 0) goto L16;
        r102 = "";
    L16:
        if ((r104 & 16) == 0) goto L18;
        r103 = "";
    L18:
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r105, "content");
        Intrinsics.checkNotNullParameter(r102, "confirmButtonText");
        Intrinsics.checkNotNullParameter(r103, "cancelButtonText");
        this.f503882a = r100;
        this.f503883b = r101;
        this.f503884c = r105;
        this.f503885d = r102;
        this.f503886e = r103;
        this.f503887f = null;
        return;
    L11:
        r105 = null;
        goto L13
    }

    public d(int r100, boolean r101, String r102, String r103, String r104, String r105, Map r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f503889b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = true;
    L7:
        this.f503882a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f503883b = "";
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f503884c = "";
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.f503885d = "";
    L20:
        if ((r100 & 16) != 0) goto L22;
        this.f503886e = "";
    L24:
        if ((r100 & 32) != 0) goto L26;
        this.f503887f = null;
        return;
    L26:
        this.f503887f = r106;
        return;
    L22:
        this.f503886e = r105;
        goto L24
    L18:
        this.f503885d = r104;
        goto L20
    L14:
        this.f503884c = r103;
        goto L16
    L10:
        this.f503883b = r102;
        goto L12
    }
}
