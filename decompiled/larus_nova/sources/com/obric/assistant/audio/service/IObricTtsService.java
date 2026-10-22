package com.obric.assistant.audio.service;

import com.larus.im.bean.message.Message;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H&J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\b\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/audio/service/IObricTtsService;", "", "init", "", "replayMessageTts", "messageId", "", "policy", "", "readContent", "content", "readAuthenticationContent", "playScene", "readContentByMessage", "msg", "Lcom/larus/im/bean/message/Message;", "shouldContinuePlayWhenPause", "", "isOautoAndComplexMsgMustPlayTtsScene", "isReplyMessageFromLockScreenAndVoiceWakeup", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricTtsService {
    boolean a();

    void b(String r100, int r101);

    void c(String r100, int r101);

    boolean d(Message r100);

    void e(Message r100, int r101);

    void f(String r100, String r101);

    void init();
}
