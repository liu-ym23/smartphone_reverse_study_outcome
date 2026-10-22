package com.bytedance.bdnavigationsdk.network.route;

import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.l0;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class RoutePath$$serializer implements m0<RoutePath> {
    public static final RoutePath$$serializer a = null;
    public static final g2 b = null;

    public RoutePath$$serializer() {
    }

    public final luc.f getDescriptor() {
        return b;
    }

    static {
        RoutePath$$serializer r0 = new RoutePath$$serializer();
        a = r0;
        g2 r1 = new g2("com.bytedance.bdnavigationsdk.network.route.RoutePath", r0, 7);
        r1.j("route_id", false);
        r1.j("distance", true);
        r1.j("cost", true);
        final String[] r3 = {"duration"};
        r1.k(new RoutePath$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0(r3));
        r1.j("steps", true);
        r1.j("guide_points", true);
        r1.j("guide_info", true);
        r1.j("legs", true);
        b = r1;
    }

    public final juc.d<?>[] childSerializers() {
        juc.d<?>[] r0 = RoutePath.h;
        return new juc.d[]{v2.a, l0.a, kuc.a.d(f.a), kuc.a.d(r0[3]), r0[4], r0[5], r0[6]};
    }

    public final juc.d<?>[] typeParametersSerializers() {
        return i2.a;
    }

    public final Object deserialize(muc.e r19) {
        Intrinsics.checkNotNullParameter(r19, "decoder");
        g2 r1 = b;
        muc.c r0 = r19.beginStructure(r1);
        juc.c[] r2 = RoutePath.h;
        int r4 = 4;
        if (r0.decodeSequentially() == false) goto L5;
        String r3 = r0.decodeStringElement(r1, 0);
        float r7 = r0.decodeFloatElement(r1, 1);
        e r6 = (e) r0.decodeNullableSerializableElement(r1, 2, f.a, null);
        List r8 = (List) r0.decodeNullableSerializableElement(r1, 3, r2[3], null);
        List r5 = (List) r0.decodeSerializableElement(r1, 4, r2[4], null);
        List r9 = (List) r0.decodeSerializableElement(r1, 5, r2[5], null);
        List r15 = (List) r0.decodeSerializableElement(r1, 6, r2[6], null);
        List r13 = r5;
        e r11 = r6;
        float r10 = r7;
        List r12 = r8;
        List r14 = r9;
        int r16 = 127;
        String r17 = r3;
    L24:
        r0.endStructure(r1);
        return new RoutePath(r16, r17, r10, r11, r12, r13, r14, r15);
    L5:
        List r18 = null;
        List r20 = null;
        String r110 = null;
        List r111 = null;
        e r112 = null;
        r15 = null;
        int r21 = 0;
        float r113 = 0.0f;
        boolean r114 = true;
    L6:
        if (r114 == false) goto L23;
        int r22 = r0.decodeElementIndex(r1);
        switch(r22) {
            case -1: goto L22;
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            default: goto L10;
        };
    L10:
        throw new UnknownFieldException(r22);
    L22:
        r114 = false;
        goto L6
    L11:
        r21 = r21 | 64;
        r15 = (List) r0.decodeSerializableElement(r1, 6, r2[6], r15);
    L21:
        r110 = r110;
        r4 = 4;
        goto L6
    L12:
        r21 = r21 | 32;
        r20 = (List) r0.decodeSerializableElement(r1, 5, r2[5], r20);
        goto L21
    L13:
        r21 = r21 | 16;
        r18 = (List) r0.decodeSerializableElement(r1, r4, r2[r4], r18);
        goto L21
    L14:
        r21 = r21 | 8;
        r111 = (List) r0.decodeNullableSerializableElement(r1, 3, r2[3], r111);
        goto L21
    L17:
        r112 = (e) r0.decodeNullableSerializableElement(r1, 2, f.a, r112);
        r21 = r21 | 4;
        goto L21
    L18:
        r113 = r0.decodeFloatElement(r1, 1);
        r21 = r21 | 2;
        goto L21
    L20:
        r110 = r0.decodeStringElement(r1, 0);
        r21 = r21 | 1;
        goto L21
    L23:
        r10 = r113;
        r17 = r110;
        r12 = r111;
        r11 = r112;
        r13 = r18;
        r14 = r20;
        r16 = r21;
        goto L24
    }

    public final void serialize(muc.f r8, Object r9) {
        RoutePath r10 = (RoutePath) r9;
        Intrinsics.checkNotNullParameter(r8, "encoder");
        Intrinsics.checkNotNullParameter(r10, "value");
        g2 r0 = b;
        muc.d r11 = r8.beginStructure(r0);
        juc.n[] r1 = RoutePath.h;
        boolean r3 = false;
        r11.encodeStringElement(r0, 0, r10.a);
        if (r11.shouldEncodeElementDefault(r0, 1) == false) goto L6;
    L7:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L12;
        r11.encodeFloatElement(r0, 1, r10.b);
    L12:
        if (r11.shouldEncodeElementDefault(r0, 2) == false) goto L15;
    L16:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L21;
        r11.encodeNullableSerializableElement(r0, 2, f.a, r10.c);
    L21:
        if (r11.shouldEncodeElementDefault(r0, 3) == false) goto L24;
    L25:
        boolean r6 = true;
    L27:
        if (r6 == false) goto L30;
        r11.encodeNullableSerializableElement(r0, 3, r1[3], r10.d);
    L30:
        if (r11.shouldEncodeElementDefault(r0, 4) == false) goto L33;
    L34:
        boolean r7 = true;
    L36:
        if (r7 == false) goto L39;
        r11.encodeSerializableElement(r0, 4, r1[4], r10.e);
    L39:
        if (r11.shouldEncodeElementDefault(r0, 5) == false) goto L42;
    L43:
        boolean r12 = true;
    L45:
        if (r12 == false) goto L48;
        r11.encodeSerializableElement(r0, 5, r1[5], r10.f);
    L48:
        if (r11.shouldEncodeElementDefault(r0, 6) == false) goto L51;
    L52:
        r3 = true;
    L53:
        if (r3 == false) goto L55;
        r11.encodeSerializableElement(r0, 6, r1[6], r10.g);
    L55:
        r11.endStructure(r0);
        return;
    L51:
        if (Intrinsics.areEqual(r10.g, new ArrayList()) == true) goto L53;
    L42:
        if (Intrinsics.areEqual(r10.f, new ArrayList()) == false) goto L43;
        r12 = false;
        goto L45
    L33:
        if (Intrinsics.areEqual(r10.e, new ArrayList()) == false) goto L34;
        r7 = false;
        goto L36
    L24:
        if (r10.d != null) goto L25;
        r6 = false;
        goto L27
    L15:
        if (r10.c != null) goto L16;
        r5 = false;
        goto L18
    L6:
        if (Float.compare(r10.b, 0.0f) != 0) goto L7;
        r4 = false;
        goto L9
    }
}
