package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.huawei.hms.support.api.entity.common.CommonConstant;
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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00060\u0001j\u0002`\u0002:\u0002)*B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bBA\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\rHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0012¨\u0006+"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVASRConfig;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "audioSrc", "", CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, "", "audioInfo", "Lcom/larus/im/internal/jni/bean/OMNIAVAudioInfo;", "extra", "<init>", "(JLjava/lang/String;Lcom/larus/im/internal/jni/bean/OMNIAVAudioInfo;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Lcom/larus/im/internal/jni/bean/OMNIAVAudioInfo;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAudioSrc$annotations", "()V", "getLang$annotations", "getAudioInfo$annotations", "getExtra$annotations", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVASRConfig implements java.io.Serializable {
    public static final Companion Companion = null;
    public final OMNIAVAudioInfo audioInfo;
    public final long audioSrc;
    public final String extra;
    public final String lang;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVASRConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVASRConfig;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVASRConfig> serializer() {
            return OMNIAVASRConfig$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVASRConfig() {
        this(0, null, null, null, 15, null);
    }

    public static /* synthetic */ OMNIAVASRConfig copy$default(OMNIAVASRConfig r100, long r101, String r102, OMNIAVAudioInfo r110, String r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.audioSrc;
    L5:
        long r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.lang;
    L8:
        String r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = r100.audioInfo;
    L11:
        OMNIAVAudioInfo r105 = r110;
        if ((r112 & 8) == 0) goto L15;
        r111 = r100.extra;
    L15:
        return r100.copy(r103, r104, r105, r111);
    }

    @SerialName("audio_info")
    public static /* synthetic */ void getAudioInfo$annotations() {
    }

    @SerialName("audio_src")
    public static /* synthetic */ void getAudioSrc$annotations() {
    }

    @SerialName("extra")
    public static /* synthetic */ void getExtra$annotations() {
    }

    @SerialName(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL)
    public static /* synthetic */ void getLang$annotations() {
    }

    public final long component1() {
        return this.audioSrc;
    }

    public final String component2() {
        return this.lang;
    }

    public final OMNIAVAudioInfo component3() {
        return this.audioInfo;
    }

    public final String component4() {
        return this.extra;
    }

    public final OMNIAVASRConfig copy(long r100, String r110, OMNIAVAudioInfo r111, String r112) {
        return new OMNIAVASRConfig(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVASRConfig) == true) goto L8;
        return false;
    L8:
        OMNIAVASRConfig r101 = (OMNIAVASRConfig) r100;
        if (this.audioSrc == r101.audioSrc) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lang, r101.lang) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.audioInfo, r101.audioInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r100 = this.audioSrc;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.lang;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        OMNIAVAudioInfo r106 = this.audioInfo;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.extra;
        if (r109 == null) goto L15;
        r103 = r109.hashCode();
    L15:
        return r108 + r103;
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "OMNIAVASRConfig(audioSrc=" + this.audioSrc + ", lang=" + this.lang + ", audioInfo=" + this.audioInfo + ", extra=" + this.extra + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVASRConfig r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeLongElement(r102, 0, r100.audioSrc);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.lang);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, OMNIAVAudioInfo$$serializer.INSTANCE, r100.audioInfo);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        r103 = true;
    L35:
        if (r103 == false) goto L38;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.extra);
        return;
    L38:
        return;
    L33:
        if (r100.extra == null) goto L35;
    L24:
        if (r100.audioInfo != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.lang != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.audioSrc != 0) goto L4;
        r104 = false;
        goto L9
    }

    public OMNIAVASRConfig(long r100, String r101, OMNIAVAudioInfo r102, String r103) {
        this.audioSrc = r100;
        this.lang = r101;
        this.audioInfo = r102;
        this.extra = r103;
    }

    public /* synthetic */ OMNIAVASRConfig(int r100, long r101, String r102, OMNIAVAudioInfo r103, String r104, q2 r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVASRConfig$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = 0;
    L7:
        this.audioSrc = r101;
        if ((r100 & 2) != 0) goto L10;
        this.lang = null;
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.audioInfo = null;
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.extra = null;
        return;
    L18:
        this.extra = r104;
        return;
    L14:
        this.audioInfo = r103;
        goto L16
    L10:
        this.lang = r102;
        goto L12
    }

    public /* synthetic */ OMNIAVASRConfig(long r100, String r101, OMNIAVAudioInfo r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        long r102 = r100;
        if ((r112 & 2) == 0) goto L8;
        String r103 = null;
    L10:
        if ((r112 & 4) == 0) goto L12;
        OMNIAVAudioInfo r104 = null;
    L14:
        if ((r112 & 8) == 0) goto L16;
        String r105 = null;
    L17:
        this(r102, r103, r104, r105);
        return;
    L16:
        r105 = r111;
        goto L17
    L12:
        r104 = r110;
        goto L14
    L8:
        r103 = r101;
        goto L10
    }
}
