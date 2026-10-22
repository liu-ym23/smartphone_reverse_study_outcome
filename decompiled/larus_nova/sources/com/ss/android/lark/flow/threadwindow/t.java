package com.ss.android.lark.flow.threadwindow;

import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.g1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public interface t {
    void onPushChat(Chat r100);

    void onPushChatRemoveChatters(Chat r100, Map<String, ? extends Chatter> r101);

    void onPushChatRemoveMe(Chat r100);

    void onPushRootMessage(MessageInfo r100);

    void onPushRootThread(g1 r100);

    void onPushThreadReactions(PushMessageReactions r100);

    void onPushThreadReply(g1 r100);

    void onPushThreadTopic(ThreadTopic r100);

    void onThreadRepliesUpdate(n5b.a r100);
}
