package com.ss.android.lark.im.sdk.service;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.p0;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.chat.service.impl.RecallInterceptCallback;
import com.ss.android.lark.flow.chat.page.flow.plugin.select.FlowMessageSelectPlugin$pullFollowingMessages$1;
import com.ss.android.lark.mergeforward.ParseMergeForwardDataUtils$wrapCallback$1;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes36.dex */
public interface p {
    void B8(String r100, boolean r101, RecallInterceptCallback r102);

    void Fe(List<String> r100, IGetDataCallback<Map<String, Message>> r101);

    void Jc(String r100, List<String> r101, IGetDataCallback<Message> r102);

    Executor P0();

    void Q5(String r100);

    void W2(String r100, int r101, FlowMessageSelectPlugin$pullFollowingMessages$1 r102);

    Map<String, MessageInfo> W5(List<String> r100);

    void X3(Message r100, IGetDataCallback<String> r101);

    void Z8(List r100, ParseMergeForwardDataUtils$wrapCallback$1 r101);

    void a7(p0 r100, MonitorMessageSendCallback r101);

    void ac(String r100);

    void e8(b r100, IGetDataCallback<List<MessageInfo>> r101);

    void f1(String r100, SendStatus r101);

    ChatMessageResponse fd(String r100, List<Integer> r101);

    void ib(MessageParams r100, MonitorMessageSendCallback r101);

    Map<String, Message> ie(List<String> r100);

    void j6(a0 r100);

    void k7(List<String> r100, IGetDataCallback<Map<String, Message>> r101);

    void l9(Message.b r100, IGetDataCallback<String> r101);

    void m5(Message r100, boolean r101, MessageFoldDetail r102);

    void mb(String r100);

    MessageInfo p(String r100);

    void p2(Message.b r100, IGetDataCallback<String> r101);

    void sendImages(String r100, List<String> r101, boolean r102, IGetDataCallback<String> r103);

    void sendMessage(MessageParams<?, ?> r100, IGetDataCallback<String> r101);

    Map<String, Message> ta(List<String> r100);

    ChatMessageResponse x2(a r100);

    void yb(z r100);

    Message za(String r100);
}
