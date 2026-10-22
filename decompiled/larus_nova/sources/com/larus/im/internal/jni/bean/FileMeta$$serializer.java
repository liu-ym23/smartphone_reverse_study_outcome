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
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/larus/im/internal/jni/bean/FileMeta.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/larus/im/internal/jni/bean/FileMeta;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class FileMeta$$serializer implements m0<FileMeta> {
    public static final FileMeta$$serializer INSTANCE = null;
    private static final f descriptor = null;

    private FileMeta$$serializer() {
    }

    @Override // nuc.m0
    public final d<?>[] childSerializers() {
        v2 r100 = v2.f520790a;
        return new d[]{a.d(r100), a.d(r100)};
    }

    @Override // juc.d, juc.n, juc.c
    public final f getDescriptor() {
        return descriptor;
    }

    static {
        FileMeta$$serializer r100 = new FileMeta$$serializer();
        INSTANCE = r100;
        g2 r101 = new g2("com.larus.im.internal.jni.bean.FileMeta", r100, 2);
        r101.j("file_path", true);
        r101.j("file_type", true);
        descriptor = r101;
    }

    @Override // nuc.m0
    public d<?>[] typeParametersSerializers() {
        return i2.f520710a;
    }

    @Override // juc.c
    public final FileMeta deserialize(e r110) {
        Intrinsics.checkNotNullParameter(r110, "decoder");
        f r100 = descriptor;
        c r111 = r110.beginStructure(r100);
        if (r111.decodeSequentially() == false) goto L5;
        v2 r101 = v2.f520790a;
        String r102 = (String) r111.decodeNullableSerializableElement(r100, 0, r101, null);
        String r103 = (String) r111.decodeNullableSerializableElement(r100, 1, r101, null);
        int r104 = 3;
    L17:
        r111.endStructure(r100);
        return new FileMeta(r104, r102, r103, null);
    L5:
        r103 = null;
        String r105 = null;
        int r106 = 0;
        boolean r107 = true;
    L6:
        if (r107 == false) goto L16;
        int r108 = r111.decodeElementIndex(r100);
        if (r108 != (-1)) goto L9;
        r107 = false;
        goto L6
    L9:
        if (r108 != 0) goto L10;
        r105 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, r105);
        r106 = r106 | 1;
        goto L6
    L10:
        if (r108 != 1) goto L13;
        r103 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, r103);
        r106 = r106 | 2;
        goto L6
    L13:
        throw new UnknownFieldException(r108);
    L16:
        r104 = r106;
        r102 = r105;
        goto L17
    }

    @Override // juc.c
    public /* bridge */ /* synthetic */ Object deserialize(e r100) {
        return deserialize(r100);
    }

    public final void serialize(muc.f r100, FileMeta r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        f r102 = descriptor;
        muc.d r103 = r100.beginStructure(r102);
        FileMeta.write$Self$omnisdk_release(r101, r103, r102);
        r103.endStructure(r102);
    }

    @Override // juc.n
    public /* bridge */ /* synthetic */ void serialize(muc.f r100, Object r101) {
        serialize(r100, (FileMeta) r101);
    }
}
