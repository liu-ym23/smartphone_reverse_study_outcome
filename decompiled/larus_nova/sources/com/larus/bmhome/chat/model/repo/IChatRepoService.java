package com.larus.bmhome.chat.model.repo;

import androidx.lifecycle.MutableLiveData;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.tencent.open.SocialConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u0000 f2\u00020\u0001:\u0001fJ\b\u0010\u0002\u001a\u00020\u0003H&J&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJ\b\u0010\u000f\u001a\u00020\u0010H&J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H&J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u001aJF\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H¦@¢\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u001aJ\u0018\u0010(\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u001aJ \u0010/\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00100\u001a\u000201H¦@¢\u0006\u0002\u00102JH\u00103\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0*2\u0006\u0010\u0007\u001a\u00020\b2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000206H¦@¢\u0006\u0002\u00108J\u0018\u00109\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u001aJ\u0018\u0010:\u001a\u0004\u0018\u00010\u00062\u0006\u0010;\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010<J\u0010\u0010=\u001a\u0004\u0018\u00010>H¦@¢\u0006\u0002\u0010?J<\u0010@\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\b2*\u0010A\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0C\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0C0BH&J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010;\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010<J*\u0010E\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0010\b\u0002\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010IH&J$\u0010J\u001a\b\u0012\u0004\u0012\u00020\b0K2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010L\u001a\u00020\bH¦@¢\u0006\u0002\u0010MJ\u0018\u0010N\u001a\u0004\u0018\u00010\u00062\u0006\u0010F\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u001aJ\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010;\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010<J\u0018\u0010P\u001a\u00020\u00152\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\nH&J\u0018\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010F\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u001aJ\\\u0010U\u001a\u0002062\u0006\u0010V\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010W\u001a\u00020\b2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0\u00052\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010[\u001a\u0002062\u0010\b\u0002\u0010\\\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010]J,\u0010^\u001a\b\u0012\u0004\u0012\u00020\b0K2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b2\u0006\u0010_\u001a\u00020\bH¦@¢\u0006\u0002\u0010`J8\u0010a\u001a\b\u0012\u0004\u0012\u00020\b0K2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010b\u001a\u00020\n2\b\u0010c\u001a\u0004\u0018\u00010\n2\b\u0010d\u001a\u0004\u0018\u000101H¦@¢\u0006\u0002\u0010eR\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u0011\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00150%X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R(\u0010)\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b0*0%X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u001a\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0%X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010'¨\u0006g"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/IChatRepoService;", "", "getISender", "Lcom/larus/bmhome/chat/model/repo/IChatSender;", "getMessageListLocal", "", "Lcom/larus/im/bean/message/Message;", "conversationId", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sender", "getSender", "()Lcom/larus/bmhome/chat/model/repo/IChatSender;", "getIReceiver", "Lcom/larus/bmhome/chat/model/repo/IChatReceiver;", SocialConstants.PARAM_RECEIVER, "getReceiver", "()Lcom/larus/bmhome/chat/model/repo/IChatReceiver;", "breakAnswer", "", "breakReason", "Lcom/larus/im/internal/jni/bean/OmniBreakReason;", "findMessageById", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messageFeedback", "messageId", "feedbackType", "Lcom/larus/im/bean/message/MsgFeedbackType;", "feedbackDislikeDetailType", "feedbackDetailContent", "feedbackDislikeDetailTypes", "(Ljava/lang/String;Lcom/larus/im/bean/message/MsgFeedbackType;ILjava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessageExt", "touristReachMessageLimit", "Landroidx/lifecycle/MutableLiveData;", "getTouristReachMessageLimit", "()Landroidx/lifecycle/MutableLiveData;", "getLatestSubtitleMessage", "tabChangeEvent", "Lkotlin/Pair;", "getTabChangeEvent", "conversationIdChangeEvent", "Lcom/larus/bmhome/chat/event/ConversationIdChangeEvent;", "getConversationIdChangeEvent", "requireOneMessageRecord", "msgServerIndex", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportDeleteMessage", "messages", "local", "", "delByUser", "(Ljava/lang/String;Ljava/util/List;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findLastIndexMessage", "findQuestion", "message", "(Lcom/larus/im/bean/message/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireCheckLimit", "Lcom/larus/bmhome/chat/resp/ChatLimit;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMessageBizExtOnly", "action", "Lkotlin/Function1;", "", "findMessagesByCollectionId", "updateMessageContentOnly", RemoteMessageConst.MSGID, "newContent", "callback", "Lcom/larus/im/callback/IIMCallback;", "updateMessage", "Lcom/larus/network/http/Async;", "content", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastMessage", "findQuestionByCollectionId", "updateMessageStatusLocalOnly", "localMessageId", "newStatus", "findBotByMessageId", "Lcom/larus/im/bean/bot/BotModel;", "requestSaveBotReply", "botId", "questionId", "messageContentList", "Lcom/larus/bmhome/chat/model/repo/MessageContent;", "suggests", "forHistoricalQuestion", "suggestsV2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZLjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMessageResponseForModel", "responseForModel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecordMessage", "status", "duration", "meetingId", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IChatRepoService {
    Object A1(String r100, String r101, Continuation<? super com.larus.network.http.a<String>> r102);

    MutableLiveData<Pair<String, String>> B1();

    Object C1(String r100, List<Message> r101, boolean r102, boolean r103, Continuation<? super Pair<? extends List<Message>, String>> r104);

    Object D1(String r100, Continuation<? super Message> r101);

    Object E1(String r100, Continuation<? super Message> r101);

    Object F1(String r100, Continuation<? super BotModel> r101);

    MutableLiveData<Unit> G1();

    MutableLiveData<te8.a> H1();

    Object I1(String r100, String r101, String r102, Continuation<? super com.larus.network.http.a<String>> r103);

    void J1(String r100, String r101, IIMCallback<Message> r102);

    Object K1(String r100, Continuation<? super Message> r101);

    t1 getReceiver();

    u1 getSender();

    void n1(String r100, OmniBreakReason r101);

    Object o1(String r100, int r101, Continuation<? super List<Message>> r102);

    Object p1(String r100, String r101, String r102, List<a2> r103, List<String> r104, boolean r105, List<String> r106, Continuation<? super Boolean> r107);

    Object q1(String r100, int r101, Integer r102, Long r103, Continuation<? super com.larus.network.http.a<String>> r104);

    void r1(String r100, Function1<? super Map<String, String>, ? extends Map<String, String>> r101);

    Object s1(Message r100, Continuation<? super List<Message>> r101);

    void t1(String r100, int r101);

    u1 u1();

    Object v1(String r100, long r101, Continuation<? super Message> r102);

    Object w1(String r100, Continuation<? super String> r101);

    t1 x1();

    Object y1(Message r100, Continuation<? super Message> r101);

    Object z1(Message r100, Continuation<? super List<Message>> r101);
}
