package com.larus.audio.utils;

import com.mammon.audiosdk.structures.SAMICoreServerEvent;
import com.mammon.audiosdk.structures.SAMICoreWebSocketConnectionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class t0 {
    public static final String a(SAMICoreServerEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return " append_msg status_code=" + r100.statusCode + " status_msg=" + r100.statusText;
    }

    public static final String b(SAMICoreWebSocketConnectionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return " append_msg state=" + r100.state + " textMsg=" + r100.textMsg;
    }
}
