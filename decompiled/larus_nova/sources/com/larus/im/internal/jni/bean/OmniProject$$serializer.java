package com.larus.im.internal.jni.bean;

import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import com.tencent.open.SocialConstants;
import java.util.List;
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
import nuc.g1;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/larus/im/internal/jni/bean/OmniProject.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/larus/im/internal/jni/bean/OmniProject;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class OmniProject$$serializer implements m0<OmniProject> {
    public static final OmniProject$$serializer INSTANCE = null;
    private static final f descriptor = null;

    private OmniProject$$serializer() {
    }

    @Override // juc.d, juc.n, juc.c
    public final f getDescriptor() {
        return descriptor;
    }

    static {
        OmniProject$$serializer r100 = new OmniProject$$serializer();
        INSTANCE = r100;
        g2 r101 = new g2("com.larus.im.internal.jni.bean.OmniProject", r100, 16);
        r101.j(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, true);
        r101.j("name", true);
        r101.j(SocialConstants.PARAM_APP_DESC, true);
        r101.j("status", true);
        r101.j("is_pinned", true);
        r101.j("display_order", true);
        r101.j("folders", true);
        r101.j("create_time", true);
        r101.j("update_time", true);
        r101.j("version", true);
        r101.j("creator_id", true);
        r101.j("tenant_id", true);
        r101.j(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, true);
        r101.j("device_id", true);
        r101.j(ICEffectKeys.KEY_IS_IC_EFFECT_DEVICE_NAME, true);
        r101.j("ext", true);
        descriptor = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nuc.m0
    public final d<?>[] childSerializers() {
        Lazy[] r100 = OmniProject.access$get$childSerializers$cp();
        v2 r101 = v2.f520790a;
        g1 r102 = g1.f520681a;
        return new d[]{a.d(r101), a.d(r101), a.d(r101), r100[3].getValue(), i.f520705a, w0.f520792a, a.d((d) r100[6].getValue()), r102, r102, r102, a.d(r101), a.d(r101), a.d(r101), a.d(r101), a.d(r101), a.d((d) r100[15].getValue())};
    }

    @Override // nuc.m0
    public d<?>[] typeParametersSerializers() {
        return i2.f520710a;
    }

    @Override // juc.c
    public final OmniProject deserialize(e r410) {
        Intrinsics.checkNotNullParameter(r410, "decoder");
        f r100 = descriptor;
        c r101 = r410.beginStructure(r100);
        Lazy[] r102 = OmniProject.access$get$childSerializers$cp();
        if (r101.decodeSequentially() == false) goto L5;
        v2 r103 = v2.f520790a;
        String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
        String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
        String r110 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
        OmniProjectStatus r106 = (OmniProjectStatus) r101.decodeSerializableElement(r100, 3, (juc.c) r102[3].getValue(), null);
        boolean r107 = r101.decodeBooleanElement(r100, 4);
        int r111 = r101.decodeIntElement(r100, 5);
        List r112 = (List) r101.decodeNullableSerializableElement(r100, 6, (juc.c) r102[6].getValue(), null);
        long r210 = r101.decodeLongElement(r100, 7);
        long r211 = r101.decodeLongElement(r100, 8);
        long r108 = r101.decodeLongElement(r100, 9);
        String r113 = (String) r101.decodeNullableSerializableElement(r100, 10, r103, null);
        String r114 = (String) r101.decodeNullableSerializableElement(r100, 11, r103, null);
        String r109 = (String) r101.decodeNullableSerializableElement(r100, 12, r103, null);
        String r115 = (String) r101.decodeNullableSerializableElement(r100, 13, r103, null);
        String r116 = (String) r101.decodeNullableSerializableElement(r100, 14, r103, null);
        Map r212 = (Map) r101.decodeNullableSerializableElement(r100, 15, (juc.c) r102[15].getValue(), null);
        String r213 = r116;
        int r117 = r111;
        String r214 = r115;
        String r215 = r109;
        long r216 = r211;
        String r118 = r104;
        String r217 = r113;
        List r119 = r112;
        String r120 = r110;
        String r218 = r114;
        OmniProjectStatus r121 = r106;
        long r122 = r210;
        String r123 = r105;
        boolean r124 = r107;
        long r219 = r108;
        int r125 = 65535;
    L31:
        r101.endStructure(r100);
        return new OmniProject(r125, r118, r123, r120, r121, r124, r117, r119, r122, r216, r219, r217, r218, r215, r214, r213, r212, null);
    L5:
        int r126 = 15;
        List r127 = null;
        String r128 = null;
        String r129 = null;
        String r130 = null;
        Map r131 = null;
        String r132 = null;
        String r133 = null;
        String r134 = null;
        String r135 = null;
        r121 = null;
        String r136 = null;
        long r310 = 0;
        long r311 = 0;
        long r312 = 0;
        int r137 = 0;
        boolean r313 = false;
        int r314 = 0;
        boolean r315 = true;
    L6:
        if (r315 == false) goto L30;
        String r316 = r130;
        int r138 = r101.decodeElementIndex(r100);
        switch(r138) {
            case -1: goto L29;
            case 0: goto L27;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L15;
            case 12: goto L14;
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L11;
            default: goto L10;
        };
    L10:
        throw new UnknownFieldException(r138);
    L12:
        r134 = (String) r101.decodeNullableSerializableElement(r100, 14, v2.f520790a, r134);
        r137 = r137 | 16384;
    L26:
        r130 = r316;
    L28:
        r126 = 15;
        goto L6
    L13:
        r132 = (String) r101.decodeNullableSerializableElement(r100, 13, v2.f520790a, r132);
        r137 = r137 | 8192;
        goto L26
    L14:
        r136 = (String) r101.decodeNullableSerializableElement(r100, 12, v2.f520790a, r136);
        r137 = r137 | 4096;
        goto L26
    L15:
        r133 = (String) r101.decodeNullableSerializableElement(r100, 11, v2.f520790a, r133);
        r137 = r137 | 2048;
        goto L26
    L16:
        r135 = (String) r101.decodeNullableSerializableElement(r100, 10, v2.f520790a, r135);
        r137 = r137 | 1024;
        goto L26
    L17:
        r310 = r101.decodeLongElement(r100, 9);
        r137 = r137 | 512;
        goto L26
    L18:
        r312 = r101.decodeLongElement(r100, 8);
        r137 = r137 | 256;
        goto L26
    L19:
        r311 = r101.decodeLongElement(r100, 7);
        r137 = r137 | 128;
        goto L26
    L20:
        r127 = (List) r101.decodeNullableSerializableElement(r100, 6, (juc.c) r102[6].getValue(), r127);
        r137 = r137 | 64;
        goto L26
    L21:
        r314 = r101.decodeIntElement(r100, 5);
        r137 = r137 | 32;
        goto L26
    L22:
        r313 = r101.decodeBooleanElement(r100, 4);
        r137 = r137 | 16;
        goto L26
    L23:
        r121 = (OmniProjectStatus) r101.decodeSerializableElement(r100, 3, (juc.c) r102[3].getValue(), r121);
        r137 = r137 | 8;
        goto L26
    L24:
        r128 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r128);
        r137 = r137 | 4;
        goto L26
    L25:
        r129 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r129);
        r137 = r137 | 2;
        goto L26
    L27:
        r130 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r316);
        r137 = r137 | 1;
        r102 = r102;
        goto L28
    L29:
        r102 = r102;
        r130 = r316;
        r126 = 15;
        r315 = false;
        goto L6
    L11:
        r131 = (Map) r101.decodeNullableSerializableElement(r100, r126, (juc.c) r102[r126].getValue(), r131);
        r137 = r137 | 32768;
        r130 = r316;
        goto L6
    L30:
        r119 = r127;
        r212 = r131;
        r214 = r132;
        r218 = r133;
        r213 = r134;
        r217 = r135;
        r215 = r136;
        r124 = r313;
        r219 = r310;
        r117 = r314;
        r122 = r311;
        r216 = r312;
        r118 = r130;
        r120 = r128;
        r123 = r129;
        r125 = r137;
        goto L31
    }

    @Override // juc.c
    public /* bridge */ /* synthetic */ Object deserialize(e r100) {
        return deserialize(r100);
    }

    public final void serialize(muc.f r100, OmniProject r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        f r102 = descriptor;
        muc.d r103 = r100.beginStructure(r102);
        OmniProject.write$Self$omnisdk_release(r101, r103, r102);
        r103.endStructure(r102);
    }

    @Override // juc.n
    public /* bridge */ /* synthetic */ void serialize(muc.f r100, Object r101) {
        serialize(r100, (OmniProject) r101);
    }
}
