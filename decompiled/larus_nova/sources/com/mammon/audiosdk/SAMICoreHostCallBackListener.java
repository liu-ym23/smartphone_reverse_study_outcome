package com.mammon.audiosdk;

import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.structures.SAMICoreBlock;

/* JADX INFO: loaded from: classes32.dex */
public interface SAMICoreHostCallBackListener {
    void onSendToHost(SAMICoreCallBackEventType r100, SAMICoreBlock r101);
}
