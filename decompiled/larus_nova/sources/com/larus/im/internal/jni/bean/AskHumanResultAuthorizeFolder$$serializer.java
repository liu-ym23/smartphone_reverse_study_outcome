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
import nuc.i;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/larus/im/internal/jni/bean/AskHumanResultAuthorizeFolder.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/larus/im/internal/jni/bean/AskHumanResultAuthorizeFolder;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class AskHumanResultAuthorizeFolder$$serializer implements m0<AskHumanResultAuthorizeFolder> {
    public static final AskHumanResultAuthorizeFolder$$serializer INSTANCE = null;
    private static final f descriptor = null;

    private AskHumanResultAuthorizeFolder$$serializer() {
    }

    @Override // juc.d, juc.n, juc.c
    public final f getDescriptor() {
        return descriptor;
    }

    static {
        AskHumanResultAuthorizeFolder$$serializer r100 = new AskHumanResultAuthorizeFolder$$serializer();
        INSTANCE = r100;
        g2 r101 = new g2("com.larus.im.internal.jni.bean.AskHumanResultAuthorizeFolder", r100, 2);
        r101.j("folders", true);
        r101.j("refuse", true);
        descriptor = r101;
    }

    @Override // nuc.m0
    public final d<?>[] childSerializers() {
        return new d[]{a.d((d) AskHumanResultAuthorizeFolder.access$get$childSerializers$cp()[0].getValue()), i.f520705a};
    }

    @Override // nuc.m0
    public d<?>[] typeParametersSerializers() {
        return i2.f520710a;
    }

    @Override // juc.c
    public final AskHumanResultAuthorizeFolder deserialize(e r110) {
        Intrinsics.checkNotNullParameter(r110, "decoder");
        f r100 = descriptor;
        c r111 = r110.beginStructure(r100);
        Lazy[] r101 = AskHumanResultAuthorizeFolder.access$get$childSerializers$cp();
        if (r111.decodeSequentially() == false) goto L5;
        List r102 = (List) r111.decodeNullableSerializableElement(r100, 0, (juc.c) r101[0].getValue(), null);
        boolean r103 = r111.decodeBooleanElement(r100, 1);
        int r104 = 3;
    L17:
        r111.endStructure(r100);
        return new AskHumanResultAuthorizeFolder(r104, r102, r103, null);
    L5:
        List r105 = null;
        boolean r106 = false;
        int r107 = 0;
        boolean r108 = true;
    L6:
        if (r108 == false) goto L16;
        int r109 = r111.decodeElementIndex(r100);
        if (r109 != (-1)) goto L9;
        r108 = false;
        goto L6
    L9:
        if (r109 != 0) goto L10;
        r105 = (List) r111.decodeNullableSerializableElement(r100, 0, (juc.c) r101[0].getValue(), r105);
        r107 = r107 | 1;
        goto L6
    L10:
        if (r109 != 1) goto L13;
        r106 = r111.decodeBooleanElement(r100, 1);
        r107 = r107 | 2;
        goto L6
    L13:
        throw new UnknownFieldException(r109);
    L16:
        r102 = r105;
        r103 = r106;
        r104 = r107;
        goto L17
    }

    @Override // juc.c
    public /* bridge */ /* synthetic */ Object deserialize(e r100) {
        return deserialize(r100);
    }

    public final void serialize(muc.f r100, AskHumanResultAuthorizeFolder r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        f r102 = descriptor;
        muc.d r103 = r100.beginStructure(r102);
        AskHumanResultAuthorizeFolder.write$Self$omnisdk_release(r101, r103, r102);
        r103.endStructure(r102);
    }

    @Override // juc.n
    public /* bridge */ /* synthetic */ void serialize(muc.f r100, Object r101) {
        serialize(r100, (AskHumanResultAuthorizeFolder) r101);
    }
}
