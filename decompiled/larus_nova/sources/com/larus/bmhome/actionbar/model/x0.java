package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
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
public final class x0 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f295543h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<z0> f295544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f295545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f295546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f295547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f295548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f295549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f295550g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<x0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295551a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295552b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295552b;
        }

        static {
            a r100 = new a();
            f295551a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.CustomActionBarConfResult", r100, 7);
            r101.j("entry_list", true);
            r101.j("recommend_request_id", true);
            r101.j("disable_client_reorder", true);
            r101.j("action_bar_always_on_top", true);
            r101.j("red_dot_text", true);
            r101.j("through_token", true);
            r101.j("need_offline_actionbar", true);
            f295552b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            nuc.i r101 = nuc.i.f520705a;
            return new juc.d[]{kuc.a.d(x0.f295543h[0].getValue()), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f295552b;
            muc.c r101 = r110.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = x0.f295543h;
            int r103 = 4;
            ArrayList r111 = null;
            if (r101.decodeSequentially() == false) goto L5;
            ArrayList r104 = (ArrayList) r101.decodeNullableSerializableElement(r100, 0, r102[0].getValue(), null);
            v2 r105 = v2.f520790a;
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 1, r105, null);
            nuc.i r107 = nuc.i.f520705a;
            Boolean r108 = (Boolean) r101.decodeNullableSerializableElement(r100, 2, r107, null);
            Boolean r112 = (Boolean) r101.decodeNullableSerializableElement(r100, 3, r107, null);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 4, r105, null);
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 5, r105, null);
            Boolean r114 = (Boolean) r101.decodeNullableSerializableElement(r100, 6, r107, null);
            int r115 = 127;
            ArrayList r116 = r104;
            String r117 = r113;
            String r118 = r109;
            Boolean r119 = r114;
            Boolean r120 = r108;
            Boolean r121 = r112;
            String r122 = r106;
        L23:
            r101.endStructure(r100);
            return new x0(r115, r116, r122, r120, r121, r118, r117, r119);
        L5:
            Boolean r123 = null;
            Boolean r124 = null;
            String r125 = null;
            r118 = null;
            r117 = null;
            Boolean r126 = null;
            int r127 = 0;
            boolean r128 = true;
        L6:
            if (r128 == false) goto L22;
            int r129 = r101.decodeElementIndex(r100);
            switch(r129) {
                case -1: goto L21;
                case 0: goto L19;
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r129);
        L21:
            r128 = false;
            goto L6
        L11:
            r124 = (Boolean) r101.decodeNullableSerializableElement(r100, 6, nuc.i.f520705a, r124);
            r127 = r127 | 64;
        L20:
            r103 = 4;
            goto L6
        L12:
            r117 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r117);
            r127 = r127 | 32;
            goto L20
        L13:
            r118 = (String) r101.decodeNullableSerializableElement(r100, r103, v2.f520790a, r118);
            r127 = r127 | 16;
            goto L20
        L14:
            r126 = (Boolean) r101.decodeNullableSerializableElement(r100, 3, nuc.i.f520705a, r126);
            r127 = r127 | 8;
            goto L20
        L15:
            r123 = (Boolean) r101.decodeNullableSerializableElement(r100, 2, nuc.i.f520705a, r123);
            r127 = r127 | 4;
            goto L20
        L17:
            r125 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r125);
            r127 = r127 | 2;
            goto L20
        L19:
            r127 = r127 | 1;
            r111 = (ArrayList) r101.decodeNullableSerializableElement(r100, 0, r102[0].getValue(), r111);
            goto L20
        L22:
            r116 = r111;
            r122 = r125;
            r121 = r126;
            r120 = r123;
            r119 = r124;
            r115 = r127;
            goto L23
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            x0 r102 = (x0) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295552b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = x0.f295543h;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, r105[0].getValue(), r102.f295544a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f295545b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeNullableSerializableElement(r103, 2, nuc.i.f520705a, r102.f295546c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            boolean r110 = true;
        L36:
            if (r110 == false) goto L39;
            r104.encodeNullableSerializableElement(r103, 3, nuc.i.f520705a, r102.f295547d);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
        L43:
            boolean r111 = true;
        L45:
            if (r111 == false) goto L48;
            r104.encodeNullableSerializableElement(r103, 4, v2.f520790a, r102.f295548e);
        L48:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
        L52:
            boolean r112 = true;
        L54:
            if (r112 == false) goto L57;
            r104.encodeNullableSerializableElement(r103, 5, v2.f520790a, r102.f295549f);
        L57:
            if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L60;
        L61:
            r106 = true;
        L62:
            if (r106 == false) goto L64;
            r104.encodeNullableSerializableElement(r103, 6, nuc.i.f520705a, r102.f295550g);
        L64:
            r104.endStructure(r103);
            return;
        L60:
            if (r102.f295550g == null) goto L62;
        L51:
            if (r102.f295549f != null) goto L52;
            r112 = false;
            goto L54
        L42:
            if (r102.f295548e != null) goto L43;
            r111 = false;
            goto L45
        L33:
            if (r102.f295547d != null) goto L34;
            r110 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r102.f295546c, Boolean.TRUE) == false) goto L25;
            r109 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r102.f295545b, "") == false) goto L16;
            r108 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r102.f295544a, new ArrayList()) == false) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<x0> serializer() {
            return a.f295551a;
        }
    }

    public x0() {
        this(null, null, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x0) == true) goto L8;
        return false;
    L8:
        x0 r101 = (x0) r100;
        if (Intrinsics.areEqual(this.f295544a, r101.f295544a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295545b, r101.f295545b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295546c, r101.f295546c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295547d, r101.f295547d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295548e, r101.f295548e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f295549f, r101.f295549f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f295550g, r101.f295550g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        ArrayList<z0> r100 = this.f295544a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f295545b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f295546c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f295547d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f295548e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f295549f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f295550g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "CustomActionBarConfResult(actionBarItemList=" + this.f295544a + ", recommendRequestId=" + this.f295545b + ", disableClientReorder=" + this.f295546c + ", actionBarAlwaysOnTop=" + this.f295547d + ", redDotText=" + this.f295548e + ", throughToken=" + this.f295549f + ", needOfflineActionbar=" + this.f295550g + ')';
    }

    static {
        Companion = new b();
        f295543h = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.i1()), null, null, null, null, null, null};
    }

    public x0(ArrayList r100, String r101, Boolean r102, Boolean r103, String r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = Boolean.TRUE;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 16) == 0) goto L17;
        r104 = null;
    L17:
        this.f295544a = r100;
        this.f295545b = r101;
        this.f295546c = r102;
        this.f295547d = r103;
        this.f295548e = r104;
        this.f295549f = null;
        this.f295550g = null;
    }

    public x0(int r100, ArrayList r101, String r102, Boolean r103, Boolean r104, String r105, String r106, Boolean r110) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295552b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = new ArrayList();
    L7:
        this.f295544a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f295545b = "";
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f295546c = Boolean.TRUE;
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.f295547d = null;
    L20:
        if ((r100 & 16) != 0) goto L22;
        this.f295548e = null;
    L24:
        if ((r100 & 32) != 0) goto L26;
        this.f295549f = null;
    L28:
        if ((r100 & 64) != 0) goto L30;
        this.f295550g = null;
        return;
    L30:
        this.f295550g = r110;
        return;
    L26:
        this.f295549f = r106;
        goto L28
    L22:
        this.f295548e = r105;
        goto L24
    L18:
        this.f295547d = r104;
        goto L20
    L14:
        this.f295546c = r103;
        goto L16
    L10:
        this.f295545b = r102;
        goto L12
    }
}
