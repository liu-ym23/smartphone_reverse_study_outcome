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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00060\u0001j\u0002`\u0002:\u000278Be\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000fBg\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jg\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0011HÖ\u0001J\t\u0010.\u001a\u00020\u0004HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0016R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0016R\u0016\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0016¨\u00069"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVAudioUpdateContent;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "ttsTaskId", "", "firstAudioGenDuration", "", "firstAudioServSendTs", "serverLinkStartTs", "serverLinkEndTs", "firstChatRespDuration", "firstTtsRespDuration", "flowServerProcessDuration", "intention", "<init>", "(Ljava/lang/String;JJJJJJJLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JJJJJJJLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTtsTaskId$annotations", "()V", "getFirstAudioGenDuration$annotations", "getFirstAudioServSendTs$annotations", "getServerLinkStartTs$annotations", "getServerLinkEndTs$annotations", "getFirstChatRespDuration$annotations", "getFirstTtsRespDuration$annotations", "getFlowServerProcessDuration$annotations", "getIntention$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVAudioUpdateContent implements java.io.Serializable {
    public static final Companion Companion = null;
    public final long firstAudioGenDuration;
    public final long firstAudioServSendTs;
    public final long firstChatRespDuration;
    public final long firstTtsRespDuration;
    public final long flowServerProcessDuration;
    public final String intention;
    public final long serverLinkEndTs;
    public final long serverLinkStartTs;
    public final String ttsTaskId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVAudioUpdateContent$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVAudioUpdateContent;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVAudioUpdateContent> serializer() {
            return OMNIAVAudioUpdateContent$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVAudioUpdateContent() {
        this(null, 0, 0, 0, 0, 0, 0, 0, null, 511, null);
    }

    public static /* synthetic */ OMNIAVAudioUpdateContent copy$default(OMNIAVAudioUpdateContent r110, String r111, long r112, long r210, long r211, long r212, long r213, long r214, long r310, String r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        String r100 = r110.ttsTaskId;
    L7:
        if ((r312 & 2) == 0) goto L9;
        long r101 = r110.firstAudioGenDuration;
    L11:
        if ((r312 & 4) == 0) goto L13;
        long r102 = r110.firstAudioServSendTs;
    L15:
        if ((r312 & 8) == 0) goto L17;
        long r103 = r110.serverLinkStartTs;
    L19:
        if ((r312 & 16) == 0) goto L21;
        long r104 = r110.serverLinkEndTs;
    L23:
        if ((r312 & 32) == 0) goto L25;
        long r113 = r110.firstChatRespDuration;
    L27:
        if ((r312 & 64) == 0) goto L29;
        long r114 = r110.firstTtsRespDuration;
    L30:
        long r215 = r114;
        if ((r312 & 128) == 0) goto L33;
        long r115 = r110.flowServerProcessDuration;
    L35:
        if ((r312 & 256) == 0) goto L37;
        String r105 = r110.intention;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r113, r215, r115, r105);
    L37:
        r105 = r311;
        goto L39
    L33:
        r115 = r310;
        goto L35
    L29:
        r114 = r214;
        goto L30
    L25:
        r113 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @SerialName("first_audio_gen_duration")
    public static /* synthetic */ void getFirstAudioGenDuration$annotations() {
    }

    @SerialName("first_audio_serv_send_ts")
    public static /* synthetic */ void getFirstAudioServSendTs$annotations() {
    }

    @SerialName("first_chat_resp_duration")
    public static /* synthetic */ void getFirstChatRespDuration$annotations() {
    }

    @SerialName("first_tts_resp_duration")
    public static /* synthetic */ void getFirstTtsRespDuration$annotations() {
    }

    @SerialName("flow_server_process_duration")
    public static /* synthetic */ void getFlowServerProcessDuration$annotations() {
    }

    @SerialName("intention")
    public static /* synthetic */ void getIntention$annotations() {
    }

    @SerialName("server_link_end_ts")
    public static /* synthetic */ void getServerLinkEndTs$annotations() {
    }

    @SerialName("server_link_start_ts")
    public static /* synthetic */ void getServerLinkStartTs$annotations() {
    }

    @SerialName("tts_task_id")
    public static /* synthetic */ void getTtsTaskId$annotations() {
    }

    public final String component1() {
        return this.ttsTaskId;
    }

    public final long component2() {
        return this.firstAudioGenDuration;
    }

    public final long component3() {
        return this.firstAudioServSendTs;
    }

    public final long component4() {
        return this.serverLinkStartTs;
    }

    public final long component5() {
        return this.serverLinkEndTs;
    }

    public final long component6() {
        return this.firstChatRespDuration;
    }

    public final long component7() {
        return this.firstTtsRespDuration;
    }

    public final long component8() {
        return this.flowServerProcessDuration;
    }

    public final String component9() {
        return this.intention;
    }

    public final OMNIAVAudioUpdateContent copy(String r110, long r210, long r211, long r212, long r213, long r214, long r310, long r311, String r312) {
        return new OMNIAVAudioUpdateContent(r110, r210, r211, r212, r213, r214, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVAudioUpdateContent) == true) goto L8;
        return false;
    L8:
        OMNIAVAudioUpdateContent r101 = (OMNIAVAudioUpdateContent) r100;
        if (Intrinsics.areEqual(this.ttsTaskId, r101.ttsTaskId) == true) goto L12;
        return false;
    L12:
        if (this.firstAudioGenDuration == r101.firstAudioGenDuration) goto L15;
        return false;
    L15:
        if (this.firstAudioServSendTs == r101.firstAudioServSendTs) goto L18;
        return false;
    L18:
        if (this.serverLinkStartTs == r101.serverLinkStartTs) goto L21;
        return false;
    L21:
        if (this.serverLinkEndTs == r101.serverLinkEndTs) goto L24;
        return false;
    L24:
        if (this.firstChatRespDuration == r101.firstChatRespDuration) goto L27;
        return false;
    L27:
        if (this.firstTtsRespDuration == r101.firstTtsRespDuration) goto L30;
        return false;
    L30:
        if (this.flowServerProcessDuration == r101.flowServerProcessDuration) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.intention, r101.intention) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r100 = this.ttsTaskId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        long r103 = this.firstAudioGenDuration;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.firstAudioServSendTs;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.serverLinkStartTs;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.serverLinkEndTs;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.firstChatRespDuration;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = this.firstTtsRespDuration;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        long r115 = this.flowServerProcessDuration;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        String r117 = this.intention;
        if (r117 == null) goto L11;
        r101 = r117.hashCode();
    L11:
        return r116 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OMNIAVAudioUpdateContent(ttsTaskId=" + this.ttsTaskId + ", firstAudioGenDuration=" + this.firstAudioGenDuration + ", firstAudioServSendTs=" + this.firstAudioServSendTs + ", serverLinkStartTs=" + this.serverLinkStartTs + ", serverLinkEndTs=" + this.serverLinkEndTs + ", firstChatRespDuration=" + this.firstChatRespDuration + ", firstTtsRespDuration=" + this.firstTtsRespDuration + ", flowServerProcessDuration=" + this.flowServerProcessDuration + ", intention=" + this.intention + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVAudioUpdateContent r100, muc.d r101, f r110) {
        boolean r102 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.encodeNullableSerializableElement(r110, 0, v2.f520790a, r100.ttsTaskId);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r101.encodeLongElement(r110, 1, r100.firstAudioGenDuration);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r101.encodeLongElement(r110, 2, r100.firstAudioServSendTs);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r101.encodeLongElement(r110, 3, r100.serverLinkStartTs);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r101.encodeLongElement(r110, 4, r100.serverLinkEndTs);
    L48:
        if (r101.shouldEncodeElementDefault(r110, 5) == false) goto L51;
    L49:
        boolean r108 = true;
    L54:
        if (r108 == false) goto L57;
        r101.encodeLongElement(r110, 5, r100.firstChatRespDuration);
    L57:
        if (r101.shouldEncodeElementDefault(r110, 6) == false) goto L60;
    L58:
        boolean r109 = true;
    L63:
        if (r109 == false) goto L66;
        r101.encodeLongElement(r110, 6, r100.firstTtsRespDuration);
    L66:
        if (r101.shouldEncodeElementDefault(r110, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeLongElement(r110, 7, r100.flowServerProcessDuration);
    L75:
        if (r101.shouldEncodeElementDefault(r110, 8) == false) goto L78;
    L76:
        r102 = true;
    L80:
        if (r102 == false) goto L83;
        r101.encodeNullableSerializableElement(r110, 8, v2.f520790a, r100.intention);
        return;
    L83:
        return;
    L78:
        if (r100.intention == null) goto L80;
    L69:
        if (r100.flowServerProcessDuration != 0) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.firstTtsRespDuration != 0) goto L58;
        r109 = false;
        goto L63
    L51:
        if (r100.firstChatRespDuration != 0) goto L49;
        r108 = false;
        goto L54
    L42:
        if (r100.serverLinkEndTs != 0) goto L40;
        r107 = false;
        goto L45
    L33:
        if (r100.serverLinkStartTs != 0) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.firstAudioServSendTs != 0) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.firstAudioGenDuration != 0) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.ttsTaskId != null) goto L4;
        r103 = false;
        goto L9
    }

    public OMNIAVAudioUpdateContent(String r100, long r101, long r102, long r103, long r110, long r111, long r112, long r113, String r114) {
        this.ttsTaskId = r100;
        this.firstAudioGenDuration = r101;
        this.firstAudioServSendTs = r102;
        this.serverLinkStartTs = r103;
        this.serverLinkEndTs = r110;
        this.firstChatRespDuration = r111;
        this.firstTtsRespDuration = r112;
        this.flowServerProcessDuration = r113;
        this.intention = r114;
    }

    public /* synthetic */ OMNIAVAudioUpdateContent(int r100, String r110, long r111, long r112, long r113, long r114, long r115, long r210, long r211, String r212, q2 r213) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVAudioUpdateContent$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.ttsTaskId = null;
    L8:
        long r101 = 0;
        if ((r100 & 2) != 0) goto L11;
        this.firstAudioGenDuration = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.firstAudioServSendTs = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.serverLinkStartTs = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.serverLinkEndTs = 0;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.firstChatRespDuration = 0;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.firstTtsRespDuration = 0;
    L33:
        if ((r100 & 128) == 0) goto L36;
        r101 = r211;
    L36:
        this.flowServerProcessDuration = r101;
        if ((r100 & 256) != 0) goto L39;
        this.intention = null;
        return;
    L39:
        this.intention = r212;
        return;
    L31:
        this.firstTtsRespDuration = r210;
        goto L33
    L27:
        this.firstChatRespDuration = r115;
        goto L29
    L23:
        this.serverLinkEndTs = r114;
        goto L25
    L19:
        this.serverLinkStartTs = r113;
        goto L21
    L15:
        this.firstAudioServSendTs = r112;
        goto L17
    L11:
        this.firstAudioGenDuration = r111;
        goto L13
    L7:
        this.ttsTaskId = r110;
        goto L8
    }

    public /* synthetic */ OMNIAVAudioUpdateContent(String r110, long r210, long r211, long r212, long r213, long r214, long r310, long r311, String r312, int r313, DefaultConstructorMarker r314) {
        String r100 = null;
        if ((r313 & 1) == 0) goto L5;
        String r101 = null;
    L6:
        long r102 = 0;
        if ((r313 & 2) == 0) goto L9;
        long r103 = 0;
    L11:
        if ((r313 & 4) == 0) goto L13;
        long r104 = 0;
    L15:
        if ((r313 & 8) == 0) goto L17;
        long r111 = 0;
    L19:
        if ((r313 & 16) == 0) goto L21;
        long r112 = 0;
    L23:
        if ((r313 & 32) == 0) goto L25;
        long r113 = 0;
    L27:
        if ((r313 & 64) == 0) goto L29;
        long r114 = 0;
    L31:
        if ((r313 & 128) != 0) goto L35;
        r102 = r311;
    L35:
        if ((r313 & 256) != 0) goto L38;
        r100 = r312;
    L38:
        this(r101, r103, r104, r111, r112, r113, r114, r102, r100);
        return;
    L29:
        r114 = r310;
        goto L31
    L25:
        r113 = r214;
        goto L27
    L21:
        r112 = r213;
        goto L23
    L17:
        r111 = r212;
        goto L19
    L13:
        r104 = r211;
        goto L15
    L9:
        r103 = r210;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
