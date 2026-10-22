package com.mammon.audiosdk.session.callback;

import com.mammon.audiosdk.session.data.SpeechReceiverCallbackParam;
import com.mammon.audiosdk.session.data.SpeechSenderCallbackParam;

/* JADX INFO: loaded from: classes32.dex */
public interface ISpeechCallback {
    void onReceiverCallback(SpeechReceiverCallbackParam r100, Object r101);

    void onSenderCallback(SpeechSenderCallbackParam r100, Object r101);
}
