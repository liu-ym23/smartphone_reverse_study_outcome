package com.larus.im.internal.jni.bean;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ss.ttvideoengine.model.SubInfo;
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
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/larus/im/internal/jni/bean/OMNIAVAudioInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVAudioInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class OMNIAVAudioInfo$$serializer implements m0<OMNIAVAudioInfo> {
    public static final OMNIAVAudioInfo$$serializer INSTANCE = null;
    private static final f descriptor = null;

    private OMNIAVAudioInfo$$serializer() {
    }

    @Override // nuc.m0
    public final d<?>[] childSerializers() {
        g1 r100 = g1.f520681a;
        return new d[]{a.d(v2.f520790a), r100, r100};
    }

    @Override // juc.d, juc.n, juc.c
    public final f getDescriptor() {
        return descriptor;
    }

    static {
        OMNIAVAudioInfo$$serializer r100 = new OMNIAVAudioInfo$$serializer();
        INSTANCE = r100;
        g2 r101 = new g2("com.larus.im.internal.jni.bean.OMNIAVAudioInfo", r100, 3);
        r101.j(SubInfo.KEY_FORMAT, true);
        r101.j(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, true);
        r101.j("channel", true);
        descriptor = r101;
    }

    @Override // nuc.m0
    public d<?>[] typeParametersSerializers() {
        return i2.f520710a;
    }

    @Override // juc.c
    public final OMNIAVAudioInfo deserialize(e r210) {
        Intrinsics.checkNotNullParameter(r210, "decoder");
        f r100 = descriptor;
        c r101 = r210.beginStructure(r100);
        String r102 = null;
        if (r101.decodeSequentially() == false) goto L5;
        String r103 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, null);
        String r110 = r103;
        long r111 = r101.decodeLongElement(r100, 1);
        long r112 = r101.decodeLongElement(r100, 2);
        int r113 = 7;
    L19:
        r101.endStructure(r100);
        return new OMNIAVAudioInfo(r113, r110, r111, r112, null);
    L5:
        long r104 = 0;
        long r105 = 0;
        int r106 = 0;
        boolean r114 = true;
    L6:
        if (r114 == false) goto L18;
        int r115 = r101.decodeElementIndex(r100);
        if (r115 != (-1)) goto L9;
        r114 = false;
        goto L6
    L9:
        if (r115 != 0) goto L10;
        r102 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r102);
        r106 = r106 | 1;
        goto L6
    L10:
        if (r115 != 1) goto L11;
        r104 = r101.decodeLongElement(r100, 1);
        r106 = r106 | 2;
        goto L6
    L11:
        if (r115 != 2) goto L14;
        r105 = r101.decodeLongElement(r100, 2);
        r106 = r106 | 4;
        goto L6
    L14:
        throw new UnknownFieldException(r115);
    L18:
        r113 = r106;
        r110 = r102;
        r111 = r104;
        r112 = r105;
        goto L19
    }

    @Override // juc.c
    public /* bridge */ /* synthetic */ Object deserialize(e r100) {
        return deserialize(r100);
    }

    public final void serialize(muc.f r100, OMNIAVAudioInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        f r102 = descriptor;
        muc.d r103 = r100.beginStructure(r102);
        OMNIAVAudioInfo.write$Self$omnisdk_av_release(r101, r103, r102);
        r103.endStructure(r102);
    }

    @Override // juc.n
    public /* bridge */ /* synthetic */ void serialize(muc.f r100, Object r101) {
        serialize(r100, (OMNIAVAudioInfo) r101);
    }
}
