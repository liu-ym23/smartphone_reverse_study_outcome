package com.larus.tts;

import com.larus.im.bean.message.Message;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\f"}, d2 = {"Lcom/larus/tts/ITtsReaderInterceptor;", "", "priority", "", "canHandle", "", "message", "Lcom/larus/im/bean/message/Message;", "scene", "Lcom/larus/tts/TtsScene;", "intercept", "Lcom/larus/tts/TtsInterceptResult;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ITtsReaderInterceptor {
    boolean a(Message r100, TtsScene r101);

    TtsInterceptResult b(Message r100, TtsScene r101);

    int priority();
}
