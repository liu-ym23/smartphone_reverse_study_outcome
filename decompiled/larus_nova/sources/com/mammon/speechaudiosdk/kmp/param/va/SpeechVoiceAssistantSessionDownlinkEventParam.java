package com.mammon.speechaudiosdk.kmp.param.va;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010)\u001a\u00020\u000fHÆ\u0003J}\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0005HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00060"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionDownlinkEventParam;", "", "event", "", "statusCode", "", "statusText", DBDefinition.TASK_ID, "sessionId", "messageId", "textMsg", "extra", "binaryData", "", "seqId", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BJ)V", "getEvent", "()Ljava/lang/String;", "getStatusCode", "()I", "getStatusText", "getTaskId", "getSessionId", "getMessageId", "getTextMsg", "getExtra", "getBinaryData", "()[B", "getSeqId", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechVoiceAssistantSessionDownlinkEventParam {
    private final byte[] binaryData;
    private final String event;
    private final String extra;
    private final String messageId;
    private final long seqId;
    private final String sessionId;
    private final int statusCode;
    private final String statusText;
    private final String taskId;
    private final String textMsg;

    public SpeechVoiceAssistantSessionDownlinkEventParam() {
        this(null, 0, null, null, null, null, null, null, null, 0, 1023, null);
    }

    public static /* synthetic */ SpeechVoiceAssistantSessionDownlinkEventParam copy$default(SpeechVoiceAssistantSessionDownlinkEventParam r110, String r111, int r112, String r113, String r114, String r115, String r116, String r210, String r211, byte[] r212, long r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.event;
    L7:
        if ((r214 & 2) == 0) goto L9;
        int r101 = r110.statusCode;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.statusText;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = r110.taskId;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = r110.sessionId;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.messageId;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.textMsg;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r107 = r110.extra;
    L35:
        if ((r214 & 256) == 0) goto L37;
        byte[] r117 = r110.binaryData;
    L39:
        if ((r214 & 512) == 0) goto L41;
        long r118 = r110.seqId;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118);
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.event;
    }

    public final long component10() {
        return this.seqId;
    }

    public final int component2() {
        return this.statusCode;
    }

    public final String component3() {
        return this.statusText;
    }

    public final String component4() {
        return this.taskId;
    }

    public final String component5() {
        return this.sessionId;
    }

    public final String component6() {
        return this.messageId;
    }

    public final String component7() {
        return this.textMsg;
    }

    public final String component8() {
        return this.extra;
    }

    public final byte[] component9() {
        return this.binaryData;
    }

    public final SpeechVoiceAssistantSessionDownlinkEventParam copy(String r110, int r111, String r112, String r113, String r114, String r115, String r210, String r211, byte[] r212, long r213) {
        return new SpeechVoiceAssistantSessionDownlinkEventParam(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpeechVoiceAssistantSessionDownlinkEventParam) == true) goto L8;
        return false;
    L8:
        SpeechVoiceAssistantSessionDownlinkEventParam r101 = (SpeechVoiceAssistantSessionDownlinkEventParam) r100;
        if (Intrinsics.areEqual(this.event, r101.event) == true) goto L12;
        return false;
    L12:
        if (this.statusCode == r101.statusCode) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.statusText, r101.statusText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.textMsg, r101.textMsg) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.binaryData, r101.binaryData) == true) goto L36;
        return false;
    L36:
        if (this.seqId == r101.seqId) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.event;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.statusCode) * 31;
        String r104 = this.statusText;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.taskId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.sessionId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.messageId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.textMsg;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.extra;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        byte[] r122 = this.binaryData;
        if (r122 == null) goto L34;
        r101 = Arrays.hashCode(r122);
    L34:
        int r123 = (r121 + r101) * 31;
        long r124 = this.seqId;
        return r123 + ((int) (r124 ^ (r124 >>> 32)));
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
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
        return "SpeechVoiceAssistantSessionDownlinkEventParam(event=" + this.event + ", statusCode=" + this.statusCode + ", statusText=" + this.statusText + ", taskId=" + this.taskId + ", sessionId=" + this.sessionId + ", messageId=" + this.messageId + ", textMsg=" + this.textMsg + ", extra=" + this.extra + ", binaryData=" + Arrays.toString(this.binaryData) + ", seqId=" + this.seqId + ')';
    }

    public final byte[] getBinaryData() {
        return this.binaryData;
    }

    public final String getEvent() {
        return this.event;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final long getSeqId() {
        return this.seqId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusText() {
        return this.statusText;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTextMsg() {
        return this.textMsg;
    }

    public SpeechVoiceAssistantSessionDownlinkEventParam(String r100, int r101, String r102, String r103, String r104, String r105, String r106, String r107, byte[] r108, long r110) {
        this.event = r100;
        this.statusCode = r101;
        this.statusText = r102;
        this.taskId = r103;
        this.sessionId = r104;
        this.messageId = r105;
        this.textMsg = r106;
        this.extra = r107;
        this.binaryData = r108;
        this.seqId = r110;
    }

    public /* synthetic */ SpeechVoiceAssistantSessionDownlinkEventParam(String r110, int r111, String r112, String r113, String r114, String r115, String r116, String r210, byte[] r211, long r212, int r213, DefaultConstructorMarker r214) {
        byte[] r100 = null;
        if ((r213 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r213 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r213 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r213 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r213 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r213 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r213 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r213 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r213 & 256) != 0) goto L39;
        r100 = r211;
    L39:
        if ((r213 & 512) == 0) goto L41;
        long r117 = 0;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100, r117);
        return;
    L41:
        r117 = r212;
        goto L42
    L33:
        r108 = r210;
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
}
