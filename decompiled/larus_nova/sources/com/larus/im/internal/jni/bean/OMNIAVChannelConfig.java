package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00060\u0001j\u0002`\u0002:\u0002()B3\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J5\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\fHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0011¨\u0006*"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVChannelConfig;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "channel", "", "srcLang", "", "destLang", "speakerMode", "<init>", "(JLjava/lang/String;Ljava/lang/String;J)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getChannel$annotations", "()V", "getSrcLang$annotations", "getDestLang$annotations", "getSpeakerMode$annotations", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVChannelConfig implements java.io.Serializable {
    public static final Companion Companion = null;
    public final long channel;
    public final String destLang;
    public final long speakerMode;
    public final String srcLang;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVChannelConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVChannelConfig;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVChannelConfig> serializer() {
            return OMNIAVChannelConfig$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVChannelConfig() {
        this(0, null, null, 0, 15, null);
    }

    public static /* synthetic */ OMNIAVChannelConfig copy$default(OMNIAVChannelConfig r100, long r101, String r110, String r111, long r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L5;
        r101 = r100.channel;
    L5:
        long r102 = r101;
        if ((r113 & 2) == 0) goto L8;
        r110 = r100.srcLang;
    L8:
        String r103 = r110;
        if ((r113 & 4) == 0) goto L11;
        r111 = r100.destLang;
    L11:
        String r104 = r111;
        if ((r113 & 8) == 0) goto L15;
        r112 = r100.speakerMode;
    L15:
        return r100.copy(r102, r103, r104, r112);
    }

    @SerialName("channel")
    public static /* synthetic */ void getChannel$annotations() {
    }

    @SerialName("dest_lang")
    public static /* synthetic */ void getDestLang$annotations() {
    }

    @SerialName("speaker_mode")
    public static /* synthetic */ void getSpeakerMode$annotations() {
    }

    @SerialName("src_lang")
    public static /* synthetic */ void getSrcLang$annotations() {
    }

    public final long component1() {
        return this.channel;
    }

    public final String component2() {
        return this.srcLang;
    }

    public final String component3() {
        return this.destLang;
    }

    public final long component4() {
        return this.speakerMode;
    }

    public final OMNIAVChannelConfig copy(long r100, String r110, String r111, long r112) {
        return new OMNIAVChannelConfig(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVChannelConfig) == true) goto L8;
        return false;
    L8:
        OMNIAVChannelConfig r101 = (OMNIAVChannelConfig) r100;
        if (this.channel == r101.channel) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.srcLang, r101.srcLang) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.destLang, r101.destLang) == true) goto L18;
        return false;
    L18:
        if (this.speakerMode == r101.speakerMode) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r100 = this.channel;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.srcLang;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.destLang;
        if (r106 == null) goto L10;
        r103 = r106.hashCode();
    L10:
        int r107 = (r105 + r103) * 31;
        long r108 = this.speakerMode;
        return r107 + ((int) (r108 ^ (r108 >>> 32)));
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "OMNIAVChannelConfig(channel=" + this.channel + ", srcLang=" + this.srcLang + ", destLang=" + this.destLang + ", speakerMode=" + this.speakerMode + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVChannelConfig r100, muc.d r101, f r110) {
        boolean r102 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.encodeLongElement(r110, 0, r100.channel);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r101.encodeNullableSerializableElement(r110, 1, v2.f520790a, r100.srcLang);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r101.encodeNullableSerializableElement(r110, 2, v2.f520790a, r100.destLang);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        r102 = true;
    L35:
        if (r102 == false) goto L38;
        r101.encodeLongElement(r110, 3, r100.speakerMode);
        return;
    L38:
        return;
    L33:
        if (r100.speakerMode == 0) goto L35;
    L24:
        if (r100.destLang != null) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.srcLang != null) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.channel != 0) goto L4;
        r103 = false;
        goto L9
    }

    public OMNIAVChannelConfig(long r100, String r101, String r102, long r103) {
        this.channel = r100;
        this.srcLang = r101;
        this.destLang = r102;
        this.speakerMode = r103;
    }

    public /* synthetic */ OMNIAVChannelConfig(int r100, long r101, String r102, String r103, long r104, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVChannelConfig$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.channel = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.srcLang = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.destLang = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.speakerMode = 0;
        return;
    L19:
        this.speakerMode = r104;
        return;
    L15:
        this.destLang = r103;
        goto L17
    L11:
        this.srcLang = r102;
        goto L13
    L7:
        this.channel = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVChannelConfig(long r100, String r101, String r102, long r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        long r103 = 0;
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r113 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r111 & 8) == 0) goto L17;
        long r114 = 0;
    L18:
        this(r103, r113, r104, r114);
        return;
    L17:
        r114 = r110;
        goto L18
    L13:
        r104 = r102;
        goto L15
    L9:
        r113 = r101;
        goto L11
    L5:
        r103 = r100;
        goto L7
    }
}
