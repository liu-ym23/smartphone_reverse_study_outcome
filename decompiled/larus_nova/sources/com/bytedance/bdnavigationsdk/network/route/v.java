package com.bytedance.bdnavigationsdk.network.route;

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

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final juc.d<Object>[] f200292e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.bdnavigationsdk.pojo.a f200293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PoiType f200294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f200295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f200296d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<v> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f200297a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f200298b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f200298b;
        }

        static {
            a r100 = new a();
            f200297a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.network.route.RouteWayPoint", r100, 4);
            r101.j("location", false);
            r101.j("id_type", true);
            r101.j("poi_id", true);
            r101.j("name", true);
            f200298b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            juc.d<Object>[] r100 = v.f200292e;
            v2 r101 = v2.f520790a;
            return new juc.d[]{com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, kuc.a.d(r100[1]), kuc.a.d(r101), kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f200298b;
            muc.c r101 = r210.beginStructure(r100);
            juc.d<Object>[] r102 = v.f200292e;
            com.bytedance.bdnavigationsdk.pojo.a r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            com.bytedance.bdnavigationsdk.pojo.a r104 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeSerializableElement(r100, 0, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, null);
            PoiType r105 = (PoiType) r101.decodeNullableSerializableElement(r100, 1, r102[1], null);
            v2 r106 = v2.f520790a;
            PoiType r110 = r105;
            com.bytedance.bdnavigationsdk.pojo.a r111 = r104;
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 2, r106, null);
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 3, r106, null);
            int r114 = 15;
        L21:
            r101.endStructure(r100);
            return new v(r114, r111, r110, r112, r113);
        L5:
            PoiType r107 = null;
            String r115 = null;
            String r116 = null;
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
            r103 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeSerializableElement(r100, 0, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, r103);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r118 != 1) goto L11;
            r107 = (PoiType) r101.decodeNullableSerializableElement(r100, 1, r102[1], r107);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r115 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r115);
            r108 = r108 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r116 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r116);
            r108 = r108 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r114 = r108;
            r111 = r103;
            r110 = r107;
            r112 = r115;
            r113 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            v r102 = (v) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f200298b;
            muc.d r104 = r100.beginStructure(r103);
            juc.d<Object>[] r105 = v.f200292e;
            boolean r106 = false;
            r104.encodeSerializableElement(r103, 0, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, r102.f200293a);
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 1, r105[1], r102.f200294b);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 2, v2.f520790a, r102.f200295c);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L24;
        L25:
            r106 = true;
        L26:
            if (r106 == false) goto L28;
            r104.encodeNullableSerializableElement(r103, 3, v2.f520790a, r102.f200296d);
        L28:
            r104.endStructure(r103);
            return;
        L24:
            if (r102.f200296d == null) goto L26;
        L15:
            if (r102.f200295c != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f200294b != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<v> serializer() {
            return a.f200297a;
        }
    }

    static {
        Companion = new b();
        f200292e = new juc.d[]{null, PoiType.Companion.serializer(), null, null};
    }

    public v(com.bytedance.bdnavigationsdk.pojo.a r100, PoiType r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "location");
        this.f200293a = r100;
        this.f200294b = r101;
        this.f200295c = r102;
        this.f200296d = r103;
    }

    public v(int r100, com.bytedance.bdnavigationsdk.pojo.a r101, PoiType r102, String r103, String r104) {
        if (1 != (r100 & 1)) goto L17;
        this.f200293a = r101;
        if ((r100 & 2) != 0) goto L7;
        this.f200294b = null;
    L9:
        if ((r100 & 4) != 0) goto L11;
        this.f200295c = null;
    L13:
        if ((r100 & 8) != 0) goto L15;
        this.f200296d = null;
        return;
    L15:
        this.f200296d = r104;
        return;
    L11:
        this.f200295c = r103;
        goto L13
    L7:
        this.f200294b = r102;
        goto L9
    L17:
        b2.b(r100, 1, a.f200298b);
        throw null;
    }
}
