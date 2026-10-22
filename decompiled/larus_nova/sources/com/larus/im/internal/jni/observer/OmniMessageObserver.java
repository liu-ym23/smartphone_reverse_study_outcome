package com.larus.im.internal.jni.observer;

import com.larus.im.internal.jni.bean.OmniMessage;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0010\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J.\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH&J.\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J&\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012H&J,\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0007H&J*\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\u0010H'J \u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H'J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H'¨\u0006\""}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniMessageObserver;", "Lcom/larus/im/internal/jni/observer/Observer;", "onSendMessage", "", "cid", "", "message", "Lcom/larus/im/internal/jni/bean/OmniMessage;", "onReceiveMessage", "ext", "", "onUpdateMessage", "onMessageInvisible", "onMessageListChanged", "conversationId", "state", "", "messages", "", "onMessageListReplaced", "oldMessages", "newMessages", "onRegenMessage", "msg", "onStreamingMessage", "local", "type", "onReportEvent", "queryLocalMsgId", "eventName", "param", "onReceiveEnd", "replyMsgId", "endMsg", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OmniMessageObserver extends Observer {
    void onMessageInvisible(String r100, OmniMessage r101);

    void onMessageListChanged(String r100, int r101, List<OmniMessage> r102);

    void onMessageListReplaced(String r100, List<OmniMessage> r101, List<OmniMessage> r102);

    @Deprecated(message = "for imsdk")
    void onReceiveEnd(String r100, String r101);

    void onReceiveMessage(String r100, OmniMessage r101, Map<String, String> r102);

    void onRegenMessage(String r100, OmniMessage r101);

    @Deprecated(message = "for imsdk")
    void onReportEvent(String r100, String r101, String r102);

    void onSendMessage(String r100, OmniMessage r101);

    @Deprecated(message = "for imsdk")
    void onStreamingMessage(String r100, OmniMessage r101, OmniMessage r102, int r103);

    void onUpdateMessage(String r100, OmniMessage r101, Map<String, String> r102);
}
