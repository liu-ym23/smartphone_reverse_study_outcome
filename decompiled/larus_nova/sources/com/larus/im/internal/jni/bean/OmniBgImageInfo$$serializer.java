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
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/larus/im/internal/jni/bean/OmniBgImageInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/larus/im/internal/jni/bean/OmniBgImageInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class OmniBgImageInfo$$serializer implements m0<OmniBgImageInfo> {
    public static final OmniBgImageInfo$$serializer INSTANCE = null;
    private static final f descriptor = null;

    private OmniBgImageInfo$$serializer() {
    }

    @Override // juc.d, juc.n, juc.c
    public final f getDescriptor() {
        return descriptor;
    }

    static {
        OmniBgImageInfo$$serializer r100 = new OmniBgImageInfo$$serializer();
        INSTANCE = r100;
        g2 r101 = new g2("com.larus.im.internal.jni.bean.OmniBgImageInfo", r100, 11);
        r101.j("bg_img_prompt", true);
        r101.j("bg_img_prompt_en", true);
        r101.j("ai_gen_bg_img", true);
        r101.j("bg_img_draw_style_starling_key", true);
        r101.j("bg_img_open", true);
        r101.j("reference_bg_img_uri", true);
        r101.j("reference_bg_img_url", true);
        r101.j("reference_bg_img_style", true);
        r101.j("reference_bg_img_prompt", true);
        r101.j("bot_category_type", true);
        r101.j("bg_image_prompt_for_enrich", true);
        descriptor = r101;
    }

    @Override // nuc.m0
    public final d<?>[] childSerializers() {
        Lazy[] r100 = OmniBgImageInfo.access$get$childSerializers$cp();
        v2 r101 = v2.f520790a;
        i r102 = i.f520705a;
        return new d[]{a.d(r101), a.d(r101), r102, a.d((d) r100[3].getValue()), r102, a.d(r101), a.d(r101), a.d(r101), a.d(r101), w0.f520792a, a.d(r101)};
    }

    @Override // nuc.m0
    public d<?>[] typeParametersSerializers() {
        return i2.f520710a;
    }

    @Override // juc.c
    public final OmniBgImageInfo deserialize(e r210) {
        Intrinsics.checkNotNullParameter(r210, "decoder");
        f r100 = descriptor;
        c r101 = r210.beginStructure(r100);
        Lazy[] r102 = OmniBgImageInfo.access$get$childSerializers$cp();
        int r103 = 10;
        int r104 = 9;
        if (r101.decodeSequentially() == false) goto L5;
        v2 r105 = v2.f520790a;
        String r110 = (String) r101.decodeNullableSerializableElement(r100, 0, r105, null);
        String r111 = (String) r101.decodeNullableSerializableElement(r100, 1, r105, null);
        boolean r112 = r101.decodeBooleanElement(r100, 2);
        List r106 = (List) r101.decodeNullableSerializableElement(r100, 3, (juc.c) r102[3].getValue(), null);
        boolean r113 = r101.decodeBooleanElement(r100, 4);
        String r107 = (String) r101.decodeNullableSerializableElement(r100, 5, r105, null);
        String r108 = (String) r101.decodeNullableSerializableElement(r100, 6, r105, null);
        String r109 = (String) r101.decodeNullableSerializableElement(r100, 7, r105, null);
        String r114 = (String) r101.decodeNullableSerializableElement(r100, 8, r105, null);
        int r115 = r101.decodeIntElement(r100, 9);
        List r116 = r106;
        String r117 = (String) r101.decodeNullableSerializableElement(r100, 10, r105, null);
        int r118 = r115;
        String r119 = r109;
        String r120 = r108;
        String r121 = r114;
        String r122 = r110;
        String r123 = r107;
        int r124 = 2047;
        boolean r125 = r113;
        String r126 = r111;
    L27:
        r101.endStructure(r100);
        return new OmniBgImageInfo(r124, r122, r126, r112, r116, r125, r123, r120, r119, r121, r118, r117, null);
    L5:
        String r127 = null;
        String r128 = null;
        String r129 = null;
        String r130 = null;
        String r131 = null;
        List r132 = null;
        String r133 = null;
        String r134 = null;
        int r135 = 0;
        int r136 = 0;
        boolean r137 = false;
        boolean r138 = false;
        boolean r211 = true;
    L6:
        if (r211 == false) goto L26;
        int r139 = r101.decodeElementIndex(r100);
        switch(r139) {
            case -1: goto L25;
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            default: goto L10;
        };
    L10:
        throw new UnknownFieldException(r139);
    L25:
        r104 = 9;
        r211 = false;
        goto L6
    L11:
        r127 = (String) r101.decodeNullableSerializableElement(r100, r103, v2.f520790a, r127);
        r135 = r135 | 1024;
        goto L6
    L12:
        r136 = r101.decodeIntElement(r100, r104);
        r135 = r135 | 512;
        goto L6
    L13:
        r128 = (String) r101.decodeNullableSerializableElement(r100, 8, v2.f520790a, r128);
        r135 = r135 | 256;
        goto L6
    L14:
        r129 = (String) r101.decodeNullableSerializableElement(r100, 7, v2.f520790a, r129);
        r135 = r135 | 128;
    L18:
        r103 = 10;
        goto L6
    L15:
        r131 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r131);
        r135 = r135 | 64;
        goto L18
    L16:
        r130 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r130);
        r135 = r135 | 32;
        goto L18
    L17:
        r137 = r101.decodeBooleanElement(r100, 4);
        r135 = r135 | 16;
        goto L18
    L19:
        r132 = (List) r101.decodeNullableSerializableElement(r100, 3, (juc.c) r102[3].getValue(), r132);
        r135 = r135 | 8;
    L23:
        r103 = 10;
        r104 = 9;
        goto L6
    L20:
        r138 = r101.decodeBooleanElement(r100, 2);
        r135 = r135 | 4;
        goto L23
    L21:
        r133 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r133);
        r135 = r135 | 2;
        goto L23
    L22:
        r135 = r135 | 1;
        r134 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r134);
        goto L23
    L26:
        r122 = r134;
        r117 = r127;
        r118 = r136;
        r120 = r131;
        r116 = r132;
        r125 = r137;
        r119 = r129;
        r126 = r133;
        r123 = r130;
        r112 = r138;
        r121 = r128;
        r124 = r135;
        goto L27
    }

    @Override // juc.c
    public /* bridge */ /* synthetic */ Object deserialize(e r100) {
        return deserialize(r100);
    }

    public final void serialize(muc.f r100, OmniBgImageInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        f r102 = descriptor;
        muc.d r103 = r100.beginStructure(r102);
        OmniBgImageInfo.write$Self$omnisdk_release(r101, r103, r102);
        r103.endStructure(r102);
    }

    @Override // juc.n
    public /* bridge */ /* synthetic */ void serialize(muc.f r100, Object r101) {
        serialize(r100, (OmniBgImageInfo) r101);
    }
}
