package com.mammon.speechaudiosdk.kmp.param.va;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006&"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionAudioParam;", "", DBDefinition.TASK_ID, "", "sessionId", "data", "", "dataSize", "", "refData", "refDataSize", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;[BJ[BJLjava/lang/String;)V", "getTaskId", "()Ljava/lang/String;", "getSessionId", "getData", "()[B", "getDataSize", "()J", "getRefData", "getRefDataSize", "getExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechVoiceAssistantSessionAudioParam {
    private final byte[] data;
    private final long dataSize;
    private final String extra;
    private final byte[] refData;
    private final long refDataSize;
    private final String sessionId;
    private final String taskId;

    public static /* synthetic */ SpeechVoiceAssistantSessionAudioParam copy$default(SpeechVoiceAssistantSessionAudioParam r110, String r111, String r112, byte[] r113, long r114, byte[] r115, long r116, String r117, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.taskId;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.sessionId;
    L11:
        if ((r210 & 4) == 0) goto L13;
        byte[] r102 = r110.data;
    L15:
        if ((r210 & 8) == 0) goto L17;
        long r103 = r110.dataSize;
    L19:
        if ((r210 & 16) == 0) goto L21;
        byte[] r104 = r110.refData;
    L23:
        if ((r210 & 32) == 0) goto L25;
        long r105 = r110.refDataSize;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.extra;
    L31:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106);
    L29:
        r106 = r117;
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
        return this.taskId;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final byte[] component3() {
        return this.data;
    }

    public final long component4() {
        return this.dataSize;
    }

    public final byte[] component5() {
        return this.refData;
    }

    public final long component6() {
        return this.refDataSize;
    }

    public final String component7() {
        return this.extra;
    }

    public final SpeechVoiceAssistantSessionAudioParam copy(String r110, String r111, byte[] r112, long r113, byte[] r114, long r115, String r210) {
        return new SpeechVoiceAssistantSessionAudioParam(r110, r111, r112, r113, r114, r115, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpeechVoiceAssistantSessionAudioParam) == true) goto L8;
        return false;
    L8:
        SpeechVoiceAssistantSessionAudioParam r101 = (SpeechVoiceAssistantSessionAudioParam) r100;
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L18;
        return false;
    L18:
        if (this.dataSize == r101.dataSize) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.refData, r101.refData) == true) goto L24;
        return false;
    L24:
        if (this.refDataSize == r101.refDataSize) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.taskId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.sessionId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        byte[] r107 = this.data;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.dataSize;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        byte[] r112 = this.refData;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        long r115 = this.refDataSize;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        String r117 = this.extra;
        if (r117 == null) goto L23;
        r101 = r117.hashCode();
    L23:
        return r116 + r101;
    L17:
        r113 = Arrays.hashCode(r112);
        goto L18
    L13:
        r108 = Arrays.hashCode(r107);
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SpeechVoiceAssistantSessionAudioParam(taskId=" + this.taskId + ", sessionId=" + this.sessionId + ", data=" + Arrays.toString(this.data) + ", dataSize=" + this.dataSize + ", refData=" + Arrays.toString(this.refData) + ", refDataSize=" + this.refDataSize + ", extra=" + this.extra + ')';
    }

    public final byte[] getData() {
        return this.data;
    }

    public final long getDataSize() {
        return this.dataSize;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final byte[] getRefData() {
        return this.refData;
    }

    public final long getRefDataSize() {
        return this.refDataSize;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public SpeechVoiceAssistantSessionAudioParam(String r100, String r101, byte[] r102, long r103, byte[] r104, long r105, String r106) {
        this.taskId = r100;
        this.sessionId = r101;
        this.data = r102;
        this.dataSize = r103;
        this.refData = r104;
        this.refDataSize = r105;
        this.extra = r106;
    }
}
