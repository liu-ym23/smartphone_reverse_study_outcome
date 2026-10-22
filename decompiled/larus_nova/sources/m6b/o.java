package m6b;

import com.bytedance.lark.pb.im.v1.DoubaoTyping;
import com.bytedance.lark.pb.im.v1.PushDoubaoSmartReply;
import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.g1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public interface o {
    void a(g1 r100);

    void b(PushMessageReadStates r100);

    void c(MessageInfo r100);

    void d(PushDoubaoSmartReply r100);

    void e(DoubaoTyping r100);

    void f(PushMessageReactions r100);

    void g(Chat r100, Map<String, ? extends Chatter> r101);

    void h(Chat r100, Map<String, ? extends Chatter> r101);

    void i(Chat r100, Map<String, ? extends Chatter> r101);

    void onPushChat(Chat r100);

    void onPushChatRemoveMe(Chat r100);

    void onPushThreadTopic(ThreadTopic r100);
}
