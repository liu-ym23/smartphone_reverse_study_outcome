package com.larus.im.internal.jni.bean;

import java.util.Map;
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
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/larus/im/internal/jni/bean/OmniImageObj.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/larus/im/internal/jni/bean/OmniImageObj;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class OmniImageObj$$serializer implements m0<OmniImageObj> {
    public static final OmniImageObj$$serializer INSTANCE = null;
    private static final f descriptor = null;

    private OmniImageObj$$serializer() {
    }

    @Override // juc.d, juc.n, juc.c
    public final f getDescriptor() {
        return descriptor;
    }

    static {
        OmniImageObj$$serializer r100 = new OmniImageObj$$serializer();
        INSTANCE = r100;
        g2 r101 = new g2("com.larus.im.internal.jni.bean.OmniImageObj", r100, 5);
        r101.j("url", true);
        r101.j("width", true);
        r101.j("height", true);
        r101.j("url_v2", true);
        r101.j("url_formats", true);
        descriptor = r101;
    }

    @Override // nuc.m0
    public final d<?>[] childSerializers() {
        Lazy[] r100 = OmniImageObj.access$get$childSerializers$cp();
        v2 r101 = v2.f520790a;
        w0 r102 = w0.f520792a;
        return new d[]{a.d(r101), r102, r102, a.d(r101), a.d((d) r100[4].getValue())};
    }

    @Override // nuc.m0
    public d<?>[] typeParametersSerializers() {
        return i2.f520710a;
    }

    @Override // juc.c
    public final OmniImageObj deserialize(e r210) {
        Intrinsics.checkNotNullParameter(r210, "decoder");
        f r100 = descriptor;
        c r101 = r210.beginStructure(r100);
        Lazy[] r102 = OmniImageObj.access$get$childSerializers$cp();
        if (r101.decodeSequentially() == false) goto L5;
        v2 r103 = v2.f520790a;
        String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
        int r105 = r101.decodeIntElement(r100, 1);
        int r106 = r101.decodeIntElement(r100, 2);
        String r107 = (String) r101.decodeNullableSerializableElement(r100, 3, r103, null);
        Map r211 = (Map) r101.decodeNullableSerializableElement(r100, 4, (juc.c) r102[4].getValue(), null);
        String r212 = r107;
        int r213 = r106;
        int r110 = r105;
        String r111 = r104;
        int r112 = 31;
    L24:
        r101.endStructure(r100);
        return new OmniImageObj(r112, r111, r110, r213, r212, r211, null);
    L5:
        String r113 = null;
        String r114 = null;
        Map r115 = null;
        int r108 = 0;
        int r109 = 0;
        int r116 = 0;
        boolean r117 = true;
    L6:
        if (r117 == false) goto L23;
        int r118 = r101.decodeElementIndex(r100);
        if (r118 != (-1)) goto L9;
        r117 = false;
        goto L6
    L9:
        if (r118 == 0) goto L20;
        if (r118 == 1) goto L19;
        if (r118 == 2) goto L18;
        if (r118 == 3) goto L17;
        if (r118 != 4) goto L16;
        r115 = (Map) r101.decodeNullableSerializableElement(r100, 4, (juc.c) r102[4].getValue(), r115);
        r108 = r108 | 16;
        goto L6
    L16:
        throw new UnknownFieldException(r118);
    L17:
        r114 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r114);
        r108 = r108 | 8;
        goto L6
    L18:
        r109 = r101.decodeIntElement(r100, 2);
        r108 = r108 | 4;
        goto L6
    L19:
        r116 = r101.decodeIntElement(r100, 1);
        r108 = r108 | 2;
        goto L6
    L20:
        r113 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r113);
        r108 = r108 | 1;
        goto L6
    L23:
        r112 = r108;
        r213 = r109;
        r110 = r116;
        r111 = r113;
        r212 = r114;
        r211 = r115;
        goto L24
    }

    @Override // juc.c
    public /* bridge */ /* synthetic */ Object deserialize(e r100) {
        return deserialize(r100);
    }

    public final void serialize(muc.f r100, OmniImageObj r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        f r102 = descriptor;
        muc.d r103 = r100.beginStructure(r102);
        OmniImageObj.write$Self$omnisdk_release(r101, r103, r102);
        r103.endStructure(r102);
    }

    @Override // juc.n
    public /* bridge */ /* synthetic */ void serialize(muc.f r100, Object r101) {
        serialize(r100, (OmniImageObj) r101);
    }
}
