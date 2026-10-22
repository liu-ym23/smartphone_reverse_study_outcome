package com.obric.assistant.actionbar.service;

import bda.a;
import com.larus.im.bean.message.Message;
import com.obric.assistant.spi.actionbar.IObricActionBarSendService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/actionbar/service/IObricActionBarSendServiceExt;", "Lcom/obric/assistant/spi/actionbar/IObricActionBarSendService;", "registerActionBarHintChangedCallback", "", "obricCustomActionBarCallback", "Lcom/obric/assistant/chat/callback/IOrionCustomActionBarCallback;", "unregisterActionBarHintChangedCallback", "resetSuggestSelector", "setConfirmTextMessage", "message", "Lcom/larus/im/bean/message/Message;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricActionBarSendServiceExt extends IObricActionBarSendService {
    void h();

    void j(a r100);

    void q();

    void t(Message r100);
}
