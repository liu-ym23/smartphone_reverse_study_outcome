package com.obric.assistant.state.api.v2.core;

import com.larus.im.bean.message.Message;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\r"}, d2 = {"Lcom/obric/assistant/state/api/v2/core/IObricMsgInfoSaveService;", "", "saveInformationOnSendOrRegenMessage", "", "saveInformationOnReceiveMessage", "saveMsgInfoOnRegen", "msg", "Lcom/larus/im/bean/message/Message;", "saveMsgInfoOnSend", "saveMsgRespondedTimeForOtherContentType", "saveMsgRespondedTime", "isCurrentReplyMessage", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricMsgInfoSaveService {
    void a(Message r100);

    void b(Message r100);

    void c(Message r100);

    void d(boolean r100, Message r101);
}
