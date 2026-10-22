package m6b;

import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;

/* JADX INFO: loaded from: classes35.dex */
public interface d {
    void K6(String r100, SubscribeChatEventRequest.SubscriptionKey r101);

    void V(Object r100, String r101);

    void W1(Object r100, String r101, aqb.a r102);

    void registerPushChatRelation(Object r100, String r101, SubscribeChatEventRequest.SubscriptionKey r102, o r103);

    void unregisterPushChatRelation(Object r100, String r101, SubscribeChatEventRequest.SubscriptionKey r102);

    void z9(String r100, SubscribeChatEventRequest.SubscriptionKey r101);
}
