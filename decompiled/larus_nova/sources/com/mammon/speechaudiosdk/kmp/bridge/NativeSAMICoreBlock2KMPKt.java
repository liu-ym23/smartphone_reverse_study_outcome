package com.mammon.speechaudiosdk.kmp.bridge;

import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreServerEvent;
import com.mammon.audiosdk.structures.SAMICoreWebSocketConnectionEvent;
import com.mammon.speechaudiosdk.kmp.param.SpeechAudioNetConnectionEventParam;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionDownlinkEventParam;
import com.mammon.speechaudiosdk.kmp.type.SpeechAudioNetConnectionStateType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0002H\u0000¨\u0006\u0005"}, d2 = {"toDownlinkEventKmp", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionDownlinkEventParam;", "Lcom/mammon/audiosdk/structures/SAMICoreBlock;", "toNetConnectionEventKmp", "Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioNetConnectionEventParam;", "speech_audiosdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class NativeSAMICoreBlock2KMPKt {
    public static final SpeechVoiceAssistantSessionDownlinkEventParam toDownlinkEventKmp(SAMICoreBlock r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Object[] r100 = r110.audioData;
        boolean r101 = true;
        if (r100 == null) goto L12;
        if (r100.length != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L12;
        r101 = false;
        goto L12
    L7:
        r102 = false;
    L12:
        if (r101 == false) goto L15;
        return null;
    L15:
        if (r110.dataType != SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event) goto L24;
        Object r103 = r100[0];
        if ((r103 instanceof SAMICoreServerEvent) == false) goto L19;
        SAMICoreServerEvent r104 = (SAMICoreServerEvent) r103;
    L20:
        if (r104 != null) goto L23;
        return null;
    L23:
        return new SpeechVoiceAssistantSessionDownlinkEventParam(r104.event, r104.statusCode, r104.statusText, r104.taskId, r104.sessionId, r104.messageId, r104.textMsg, r104.extra, r104.binaryData, 0, 512, null);
    L19:
        r104 = null;
        goto L20
    L24:
        return null;
    }

    public static final SpeechAudioNetConnectionEventParam toNetConnectionEventKmp(SAMICoreBlock r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object[] r101 = r100.audioData;
        boolean r102 = true;
        if (r101 == null) goto L12;
        if (r101.length != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L12;
        r102 = false;
        goto L12
    L7:
        r103 = false;
    L12:
        if (r102 == false) goto L15;
        return null;
    L15:
        if (r100.dataType != SAMICoreDataType.SAMICoreDataType_WebSocket_Connection_Event) goto L24;
        Object r104 = r101[0];
        if ((r104 instanceof SAMICoreWebSocketConnectionEvent) == false) goto L19;
        SAMICoreWebSocketConnectionEvent r105 = (SAMICoreWebSocketConnectionEvent) r104;
    L20:
        if (r105 != null) goto L23;
        return null;
    L23:
        return new SpeechAudioNetConnectionEventParam(SpeechAudioNetConnectionStateType.Companion.fromInt(r105.state), r105.url, r105.textMsg);
    L19:
        r105 = null;
        goto L20
    L24:
        return null;
    }
}
