package com.larus.im.internal.jni.bean;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import muc.e;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.w0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/larus/im/internal/jni/bean/OMNIAudio.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAudio;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class OMNIAudio$$serializer implements m0<OMNIAudio> {
    public static final OMNIAudio$$serializer INSTANCE = null;
    private static final f descriptor = null;

    private OMNIAudio$$serializer() {
    }

    @Override // nuc.m0
    public final d<?>[] childSerializers() {
        w0 r100 = w0.f520792a;
        return new d[]{r100, r100};
    }

    @Override // juc.d, juc.n, juc.c
    public final f getDescriptor() {
        return descriptor;
    }

    static {
        OMNIAudio$$serializer r100 = new OMNIAudio$$serializer();
        INSTANCE = r100;
        g2 r101 = new g2("com.larus.im.internal.jni.bean.OMNIAudio", r100, 2);
        r101.j(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, true);
        r101.j("channel", true);
        descriptor = r101;
    }

    @Override // nuc.m0
    public d<?>[] typeParametersSerializers() {
        return i2.f520710a;
    }

    @Override // juc.c
    public final OMNIAudio deserialize(e r110) {
        Intrinsics.checkNotNullParameter(r110, "decoder");
        f r100 = descriptor;
        c r111 = r110.beginStructure(r100);
        if (r111.decodeSequentially() == false) goto L5;
        int r101 = r111.decodeIntElement(r100, 0);
        int r102 = r111.decodeIntElement(r100, 1);
        int r103 = 3;
    L17:
        r111.endStructure(r100);
        return new OMNIAudio(r103, r101, r102, null);
    L5:
        r101 = 0;
        int r104 = 0;
        int r105 = 0;
        boolean r106 = true;
    L6:
        if (r106 == false) goto L16;
        int r107 = r111.decodeElementIndex(r100);
        if (r107 != (-1)) goto L9;
        r106 = false;
        goto L6
    L9:
        if (r107 != 0) goto L10;
        r101 = r111.decodeIntElement(r100, 0);
        r105 = r105 | 1;
        goto L6
    L10:
        if (r107 != 1) goto L13;
        r104 = r111.decodeIntElement(r100, 1);
        r105 = r105 | 2;
        goto L6
    L13:
        throw new UnknownFieldException(r107);
    L16:
        r102 = r104;
        r103 = r105;
        goto L17
    }

    @Override // juc.c
    public /* bridge */ /* synthetic */ Object deserialize(e r100) {
        return deserialize(r100);
    }

    public final void serialize(muc.f r100, OMNIAudio r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        f r102 = descriptor;
        muc.d r103 = r100.beginStructure(r102);
        OMNIAudio.write$Self$omnisdk_av_release(r101, r103, r102);
        r103.endStructure(r102);
    }

    @Override // juc.n
    public /* bridge */ /* synthetic */ void serialize(muc.f r100, Object r101) {
        serialize(r100, (OMNIAudio) r101);
    }
}
