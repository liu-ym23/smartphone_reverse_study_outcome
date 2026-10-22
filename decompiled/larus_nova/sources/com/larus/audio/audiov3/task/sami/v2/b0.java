package com.larus.audio.audiov3.task.sami.v2;

import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreServerEvent;
import com.mammon.audiosdk.structures.SAMICoreWebSocketConnectionEvent;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 {
    public static final String a(SAMICore r100) {
        if (r100 != null) goto L6;
        return ", SAMICore: null";
    L6:
        return ", SAMICore: " + r100.getHandle();
    }

    public static final String b(SAMICoreBlock r100) {
        if (r100 != null) goto L5;
        return ", event: null";
    L5:
        SAMICoreDataType r101 = r100.dataType;
        SAMICoreServerEvent r102 = null;
        SAMICoreWebSocketConnectionEvent r103 = null;
        if (r101 != SAMICoreDataType.SAMICoreDataType_WebSocket_Connection_Event) goto L14;
        Object r104 = ArraysKt.getOrNull(r100.audioData, 0);
        if ((r104 instanceof SAMICoreWebSocketConnectionEvent) == false) goto L10;
        r103 = (SAMICoreWebSocketConnectionEvent) r104;
    L10:
        if (r103 == null) goto L22;
        return ", webSocketStateChanged: " + r103.state + ", msg: " + r103.textMsg;
    L22:
        return ", event: " + r100;
    L14:
        if (r101 != SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event) goto L22;
        Object r105 = ArraysKt.getOrNull(r100.audioData, 0);
        if ((r105 instanceof SAMICoreServerEvent) == false) goto L18;
        r102 = (SAMICoreServerEvent) r105;
    L18:
        if (r102 == null) goto L22;
        return ", event: " + r102.event + ", status_code: " + r102.statusCode + ", status_text: " + r102.statusText + ", message_id: " + r102.messageId;
    }
}
