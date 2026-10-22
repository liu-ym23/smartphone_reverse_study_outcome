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
import nuc.g1;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/larus/im/internal/jni/bean/RoomMeta.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/larus/im/internal/jni/bean/RoomMeta;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class RoomMeta$$serializer implements m0<RoomMeta> {
    public static final RoomMeta$$serializer INSTANCE = null;
    private static final f descriptor = null;

    private RoomMeta$$serializer() {
    }

    @Override // juc.d, juc.n, juc.c
    public final f getDescriptor() {
        return descriptor;
    }

    static {
        RoomMeta$$serializer r100 = new RoomMeta$$serializer();
        INSTANCE = r100;
        g2 r101 = new g2("com.larus.im.internal.jni.bean.RoomMeta", r100, 8);
        r101.j("rtc_app_id", true);
        r101.j("room_id", true);
        r101.j("rtc_user_id", true);
        r101.j("token", true);
        r101.j("expire_time_ms", true);
        r101.j("session_id", true);
        r101.j("use_rtc_test_domain", true);
        r101.j("test_access_hosts", true);
        descriptor = r101;
    }

    @Override // nuc.m0
    public final d<?>[] childSerializers() {
        Lazy[] r100 = RoomMeta.access$get$childSerializers$cp();
        v2 r101 = v2.f520790a;
        return new d[]{a.d(r101), a.d(r101), a.d(r101), a.d(r101), g1.f520681a, a.d(r101), i.f520705a, a.d((d) r100[7].getValue())};
    }

    @Override // nuc.m0
    public d<?>[] typeParametersSerializers() {
        return i2.f520710a;
    }

    @Override // juc.c
    public final RoomMeta deserialize(e r210) {
        Intrinsics.checkNotNullParameter(r210, "decoder");
        f r100 = descriptor;
        c r101 = r210.beginStructure(r100);
        Lazy[] r102 = RoomMeta.access$get$childSerializers$cp();
        int r103 = 6;
        if (r101.decodeSequentially() == false) goto L5;
        v2 r104 = v2.f520790a;
        String r110 = (String) r101.decodeNullableSerializableElement(r100, 0, r104, null);
        String r111 = (String) r101.decodeNullableSerializableElement(r100, 1, r104, null);
        String r105 = (String) r101.decodeNullableSerializableElement(r100, 2, r104, null);
        String r106 = (String) r101.decodeNullableSerializableElement(r100, 3, r104, null);
        long r112 = r101.decodeLongElement(r100, 4);
        String r107 = (String) r101.decodeNullableSerializableElement(r100, 5, r104, null);
        boolean r108 = r101.decodeBooleanElement(r100, 6);
        List r113 = (List) r101.decodeNullableSerializableElement(r100, 7, (juc.c) r102[7].getValue(), null);
        String r114 = r107;
        boolean r115 = r108;
        String r116 = r106;
        String r109 = r110;
        String r117 = r105;
        int r118 = 255;
    L23:
        r101.endStructure(r100);
        return new RoomMeta(r118, r109, r111, r117, r116, r112, r114, r115, r113, null);
    L5:
        List r119 = null;
        String r120 = null;
        String r121 = null;
        String r122 = null;
        long r123 = 0;
        boolean r124 = false;
        boolean r211 = true;
        String r125 = null;
        String r126 = null;
        int r127 = 0;
    L6:
        if (r211 == false) goto L22;
        int r128 = r101.decodeElementIndex(r100);
        switch(r128) {
            case -1: goto L21;
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L10;
        };
    L10:
        throw new UnknownFieldException(r128);
    L21:
        r103 = 6;
        r211 = false;
        goto L6
    L11:
        r119 = (List) r101.decodeNullableSerializableElement(r100, 7, (juc.c) r102[7].getValue(), r119);
        r127 = r127 | 128;
        goto L6
    L12:
        r124 = r101.decodeBooleanElement(r100, r103);
        r127 = r127 | 64;
        goto L6
    L13:
        r120 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r120);
        r127 = r127 | 32;
        goto L6
    L14:
        r123 = r101.decodeLongElement(r100, 4);
        r127 = r127 | 16;
        goto L6
    L15:
        r121 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r121);
        r127 = r127 | 8;
    L19:
        r103 = 6;
        goto L6
    L16:
        r122 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r122);
        r127 = r127 | 4;
        goto L19
    L17:
        r126 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r126);
        r127 = r127 | 2;
        goto L19
    L18:
        r125 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r125);
        r127 = r127 | 1;
        goto L19
    L22:
        r115 = r124;
        r113 = r119;
        r118 = r127;
        r109 = r125;
        r116 = r121;
        r117 = r122;
        r114 = r120;
        r111 = r126;
        r112 = r123;
        goto L23
    }

    @Override // juc.c
    public /* bridge */ /* synthetic */ Object deserialize(e r100) {
        return deserialize(r100);
    }

    public final void serialize(muc.f r100, RoomMeta r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        f r102 = descriptor;
        muc.d r103 = r100.beginStructure(r102);
        RoomMeta.write$Self$omnisdk_release(r101, r103, r102);
        r103.endStructure(r102);
    }

    @Override // juc.n
    public /* bridge */ /* synthetic */ void serialize(muc.f r100, Object r101) {
        serialize(r100, (RoomMeta) r101);
    }
}
