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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00060\u0001j\u0002`\u0002:\u000234Be\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eBi\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jg\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0010HÖ\u0001J\t\u0010*\u001a\u00020\u0004HÖ\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0015R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0015R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0015R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0015¨\u00065"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVAudioBeginContent;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "silenceContext", "", "text", "ttsTaskId", "withDrawContent", "v3LoudnessParams", "enableV3LoudnessBalance", "", "sentenceId", "speechHelloType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSilenceContext$annotations", "()V", "getText$annotations", "getTtsTaskId$annotations", "getWithDrawContent$annotations", "getV3LoudnessParams$annotations", "getEnableV3LoudnessBalance$annotations", "getSentenceId$annotations", "getSpeechHelloType$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVAudioBeginContent implements java.io.Serializable {
    public static final Companion Companion = null;
    public final boolean enableV3LoudnessBalance;
    public final String sentenceId;
    public final String silenceContext;
    public final String speechHelloType;
    public final String text;
    public final String ttsTaskId;
    public final String v3LoudnessParams;
    public final String withDrawContent;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVAudioBeginContent$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVAudioBeginContent;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVAudioBeginContent> serializer() {
            return OMNIAVAudioBeginContent$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVAudioBeginContent() {
        this(null, null, null, null, null, false, null, null, 255, null);
    }

    public static /* synthetic */ OMNIAVAudioBeginContent copy$default(OMNIAVAudioBeginContent r100, String r110, String r111, String r112, String r113, String r114, boolean r115, String r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.silenceContext;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.text;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.ttsTaskId;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.withDrawContent;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.v3LoudnessParams;
    L23:
        if ((r118 & 32) == 0) goto L25;
        boolean r106 = r100.enableV3LoudnessBalance;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.sentenceId;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.speechHelloType;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    @SerialName("enable_v3_loudness_balance")
    public static /* synthetic */ void getEnableV3LoudnessBalance$annotations() {
    }

    @SerialName("sentence_id")
    public static /* synthetic */ void getSentenceId$annotations() {
    }

    @SerialName("silence_context")
    public static /* synthetic */ void getSilenceContext$annotations() {
    }

    @SerialName("speech_hello_type")
    public static /* synthetic */ void getSpeechHelloType$annotations() {
    }

    @SerialName("text")
    public static /* synthetic */ void getText$annotations() {
    }

    @SerialName("tts_task_id")
    public static /* synthetic */ void getTtsTaskId$annotations() {
    }

    @SerialName("v3_loudness_params")
    public static /* synthetic */ void getV3LoudnessParams$annotations() {
    }

    @SerialName("with_draw_content")
    public static /* synthetic */ void getWithDrawContent$annotations() {
    }

    public final String component1() {
        return this.silenceContext;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.ttsTaskId;
    }

    public final String component4() {
        return this.withDrawContent;
    }

    public final String component5() {
        return this.v3LoudnessParams;
    }

    public final boolean component6() {
        return this.enableV3LoudnessBalance;
    }

    public final String component7() {
        return this.sentenceId;
    }

    public final String component8() {
        return this.speechHelloType;
    }

    public final OMNIAVAudioBeginContent copy(String r110, String r111, String r112, String r113, String r114, boolean r115, String r116, String r117) {
        return new OMNIAVAudioBeginContent(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVAudioBeginContent) == true) goto L8;
        return false;
    L8:
        OMNIAVAudioBeginContent r101 = (OMNIAVAudioBeginContent) r100;
        if (Intrinsics.areEqual(this.silenceContext, r101.silenceContext) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ttsTaskId, r101.ttsTaskId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.withDrawContent, r101.withDrawContent) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.v3LoudnessParams, r101.v3LoudnessParams) == true) goto L24;
        return false;
    L24:
        if (this.enableV3LoudnessBalance == r101.enableV3LoudnessBalance) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.sentenceId, r101.sentenceId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.speechHelloType, r101.speechHelloType) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.silenceContext;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.text;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.ttsTaskId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.withDrawContent;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.v3LoudnessParams;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.enableV3LoudnessBalance == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        String r118 = this.sentenceId;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.speechHelloType;
        if (r121 == null) goto L35;
        r101 = r121.hashCode();
    L35:
        return r120 + r101;
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OMNIAVAudioBeginContent(silenceContext=" + this.silenceContext + ", text=" + this.text + ", ttsTaskId=" + this.ttsTaskId + ", withDrawContent=" + this.withDrawContent + ", v3LoudnessParams=" + this.v3LoudnessParams + ", enableV3LoudnessBalance=" + this.enableV3LoudnessBalance + ", sentenceId=" + this.sentenceId + ", speechHelloType=" + this.speechHelloType + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVAudioBeginContent r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.silenceContext);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.text);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.ttsTaskId);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.withDrawContent);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.v3LoudnessParams);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeBooleanElement(r102, 5, r100.enableV3LoudnessBalance);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, v2.f520790a, r100.sentenceId);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        r103 = true;
    L71:
        if (r103 == false) goto L74;
        r101.encodeNullableSerializableElement(r102, 7, v2.f520790a, r100.speechHelloType);
        return;
    L74:
        return;
    L69:
        if (r100.speechHelloType == null) goto L71;
    L60:
        if (r100.sentenceId != null) goto L58;
        r110 = false;
        goto L63
    L51:
        if (r100.enableV3LoudnessBalance == true) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.v3LoudnessParams != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.withDrawContent != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.ttsTaskId != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.text != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.silenceContext != null) goto L4;
        r104 = false;
        goto L9
    }

    public OMNIAVAudioBeginContent(String r100, String r101, String r102, String r103, String r104, boolean r105, String r106, String r107) {
        this.silenceContext = r100;
        this.text = r101;
        this.ttsTaskId = r102;
        this.withDrawContent = r103;
        this.v3LoudnessParams = r104;
        this.enableV3LoudnessBalance = r105;
        this.sentenceId = r106;
        this.speechHelloType = r107;
    }

    public /* synthetic */ OMNIAVAudioBeginContent(int r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r110, String r111, q2 r112) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVAudioBeginContent$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.silenceContext = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.text = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.ttsTaskId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.withDrawContent = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.v3LoudnessParams = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.enableV3LoudnessBalance = false;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.sentenceId = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.speechHelloType = null;
        return;
    L35:
        this.speechHelloType = r111;
        return;
    L31:
        this.sentenceId = r110;
        goto L33
    L27:
        this.enableV3LoudnessBalance = r106;
        goto L29
    L23:
        this.v3LoudnessParams = r105;
        goto L25
    L19:
        this.withDrawContent = r104;
        goto L21
    L15:
        this.ttsTaskId = r103;
        goto L17
    L11:
        this.text = r102;
        goto L13
    L7:
        this.silenceContext = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVAudioBeginContent(String r110, String r111, String r112, String r113, String r114, boolean r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
