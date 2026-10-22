package com.larus.im.internal.jni.bean;

import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
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

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/larus/im/internal/jni/bean/AskResultV2.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/larus/im/internal/jni/bean/AskResultV2;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class AskResultV2$$serializer implements m0<AskResultV2> {
    public static final AskResultV2$$serializer INSTANCE = null;
    private static final f descriptor = null;

    private AskResultV2$$serializer() {
    }

    @Override // nuc.m0
    public final d<?>[] childSerializers() {
        return new d[]{a.d(v2.f520790a)};
    }

    @Override // juc.d, juc.n, juc.c
    public final f getDescriptor() {
        return descriptor;
    }

    static {
        AskResultV2$$serializer r100 = new AskResultV2$$serializer();
        INSTANCE = r100;
        g2 r101 = new g2("com.larus.im.internal.jni.bean.AskResultV2", r100, 1);
        r101.j("interaction_ask_block_json", true);
        descriptor = r101;
    }

    @Override // nuc.m0
    public d<?>[] typeParametersSerializers() {
        return i2.f520710a;
    }

    @Override // juc.c
    public final AskResultV2 deserialize(e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        f r101 = descriptor;
        c r102 = r100.beginStructure(r101);
        int r103 = 1;
        if (r102.decodeSequentially() == false) goto L5;
        String r104 = (String) r102.decodeNullableSerializableElement(r101, 0, v2.f520790a, null);
    L15:
        r102.endStructure(r101);
        return new AskResultV2(r103, r104, null);
    L5:
        r104 = null;
        int r105 = 0;
    L6:
        if (r103 == 0) goto L14;
        int r106 = r102.decodeElementIndex(r101);
        if (r106 != (-1)) goto L9;
        r103 = 0;
        goto L6
    L9:
        if (r106 != 0) goto L12;
        r104 = (String) r102.decodeNullableSerializableElement(r101, 0, v2.f520790a, r104);
        r105 = r105 | 1;
        goto L6
    L12:
        throw new UnknownFieldException(r106);
    L14:
        r103 = r105;
        goto L15
    }

    @Override // juc.c
    public /* bridge */ /* synthetic */ Object deserialize(e r100) {
        return deserialize(r100);
    }

    public final void serialize(muc.f r100, AskResultV2 r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        f r102 = descriptor;
        muc.d r103 = r100.beginStructure(r102);
        AskResultV2.write$Self$omnisdk_release(r101, r103, r102);
        r103.endStructure(r102);
    }

    @Override // juc.n
    public /* bridge */ /* synthetic */ void serialize(muc.f r100, Object r101) {
        serialize(r100, (AskResultV2) r101);
    }
}
