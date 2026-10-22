package com.larus.im.internal.jni.bean;

import java.util.List;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.UnknownFieldException;
import kuc.a;
import luc.f;
import muc.c;
import muc.e;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/larus/im/internal/jni/bean/OmniBotOnBoarding.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/larus/im/internal/jni/bean/OmniBotOnBoarding;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class OmniBotOnBoarding$$serializer implements m0<OmniBotOnBoarding> {
    public static final OmniBotOnBoarding$$serializer INSTANCE = null;
    private static final f descriptor = null;

    private OmniBotOnBoarding$$serializer() {
    }

    @Override // juc.d, juc.n, juc.c
    public final f getDescriptor() {
        return descriptor;
    }

    static {
        OmniBotOnBoarding$$serializer r100 = new OmniBotOnBoarding$$serializer();
        INSTANCE = r100;
        g2 r101 = new g2("com.larus.im.internal.jni.bean.OmniBotOnBoarding", r100, 6);
        r101.j("prologue", true);
        r101.j("suggests", true);
        r101.j("content", true);
        r101.j("call_mode", true);
        r101.j("message_list", true);
        r101.j("version", true);
        descriptor = r101;
    }

    @Override // nuc.m0
    public final d<?>[] childSerializers() {
        Lazy[] r100 = OmniBotOnBoarding.access$get$childSerializers$cp();
        v2 r101 = v2.f520790a;
        w0 r102 = w0.f520792a;
        return new d[]{a.d(r101), a.d((d) r100[1].getValue()), a.d(r101), r102, a.d((d) r100[4].getValue()), r102};
    }

    @Override // nuc.m0
    public d<?>[] typeParametersSerializers() {
        return i2.f520710a;
    }

    @Override // juc.c
    public final OmniBotOnBoarding deserialize(e r210) {
        Intrinsics.checkNotNullParameter(r210, "decoder");
        f r100 = descriptor;
        c r101 = r210.beginStructure(r100);
        Lazy[] r102 = OmniBotOnBoarding.access$get$childSerializers$cp();
        int r103 = 5;
        if (r101.decodeSequentially() == false) goto L5;
        v2 r104 = v2.f520790a;
        String r105 = (String) r101.decodeNullableSerializableElement(r100, 0, r104, null);
        List r106 = (List) r101.decodeNullableSerializableElement(r100, 1, (juc.c) r102[1].getValue(), null);
        String r107 = (String) r101.decodeNullableSerializableElement(r100, 2, r104, null);
        int r108 = r101.decodeIntElement(r100, 3);
        List r110 = (List) r101.decodeNullableSerializableElement(r100, 4, (juc.c) r102[4].getValue(), null);
        String r111 = r107;
        int r112 = r101.decodeIntElement(r100, 5);
        int r113 = r108;
        List r114 = r106;
        String r115 = r105;
        int r116 = 63;
    L20:
        r101.endStructure(r100);
        return new OmniBotOnBoarding(r116, r115, r114, r111, r113, r110, r112, null);
    L5:
        r115 = null;
        r114 = null;
        r111 = null;
        List r117 = null;
        int r109 = 0;
        int r118 = 0;
        r116 = 0;
        boolean r119 = true;
    L6:
        if (r119 == false) goto L19;
        int r120 = r101.decodeElementIndex(r100);
        switch(r120) {
            case -1: goto L18;
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            default: goto L10;
        };
    L10:
        throw new UnknownFieldException(r120);
    L18:
        r103 = 5;
        r119 = false;
        goto L6
    L11:
        r109 = r101.decodeIntElement(r100, r103);
        r116 = r116 | 32;
        goto L6
    L12:
        r117 = (List) r101.decodeNullableSerializableElement(r100, 4, (juc.c) r102[4].getValue(), r117);
        r116 = r116 | 16;
        goto L6
    L13:
        r118 = r101.decodeIntElement(r100, 3);
        r116 = r116 | 8;
        goto L6
    L14:
        r111 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r111);
        r116 = r116 | 4;
        goto L6
    L15:
        r114 = (List) r101.decodeNullableSerializableElement(r100, 1, (juc.c) r102[1].getValue(), r114);
        r116 = r116 | 2;
        goto L6
    L16:
        r115 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r115);
        r116 = r116 | 1;
        r103 = 5;
        goto L6
    L19:
        r112 = r109;
        r110 = r117;
        r113 = r118;
        goto L20
    }

    @Override // juc.c
    public /* bridge */ /* synthetic */ Object deserialize(e r100) {
        return deserialize(r100);
    }

    public final void serialize(muc.f r100, OmniBotOnBoarding r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        f r102 = descriptor;
        muc.d r103 = r100.beginStructure(r102);
        OmniBotOnBoarding.write$Self$omnisdk_release(r101, r103, r102);
        r103.endStructure(r102);
    }

    @Override // juc.n
    public /* bridge */ /* synthetic */ void serialize(muc.f r100, Object r101) {
        serialize(r100, (OmniBotOnBoarding) r101);
    }
}
