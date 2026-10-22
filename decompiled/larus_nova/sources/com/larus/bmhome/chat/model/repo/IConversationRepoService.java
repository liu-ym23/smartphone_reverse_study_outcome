package com.larus.bmhome.chat.model.repo;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.BotConversationType;
import com.larus.im.bean.conversation.ConversationDeleteMode;
import com.larus.im.bean.conversation.ConversationType;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\n\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tH¦@¢\u0006\u0002\u0010\u0010J\u0080\u0001\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001bH¦@¢\u0006\u0002\u0010\u001cJ&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\t2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001bH&J\u0018\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0005H&J\u001e\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010#\u001a\u00020$H¦@¢\u0006\u0002\u0010%J*\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020$2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\tH¦@¢\u0006\u0002\u0010+J.\u0010,\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010.J2\u0010/\u001a\b\u0012\u0004\u0012\u00020\t002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010.J<\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u00052\f\u00103\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001bH¦@¢\u0006\u0002\u00105J0\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u0002082\u0016\b\u0002\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001bH¦@¢\u0006\u0002\u0010:J<\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u00020;2\u0016\b\u0002\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010=J.\u0010>\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010?\u001a\u00020\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010@J\"\u0010A\u001a\b\u0012\u0004\u0012\u00020\t0\r2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050\rH¦@¢\u0006\u0002\u0010CJ.\u0010D\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010E\u001a\u00020\u00032\b\b\u0002\u0010F\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020HH&J4\u0010I\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010E\u001a\u00020\u00032\b\b\u0002\u0010F\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020HH¦@¢\u0006\u0002\u0010JJ4\u0010K\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010E\u001a\u00020\u00032\b\b\u0002\u0010F\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020HH¦@¢\u0006\u0002\u0010JJ\u001a\u0010L\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u000208H\u0016J\u001a\u0010L\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010M\u001a\u00020;H\u0016J \u0010N\u001a\u00020O2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010P\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010QJ(\u0010R\u001a\u00020O2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010P\u001a\u00020\u00132\u0006\u0010S\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010TJ#\u0010U\u001a\u00020\u001e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010V\u001a\u0004\u0018\u00010WH&¢\u0006\u0002\u0010XJ\u0016\u0010Y\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r0ZH&J>\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u00032\b\b\u0002\u0010]\u001a\u00020\u00132\b\b\u0002\u0010^\u001a\u00020\u00132\b\b\u0002\u0010_\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010`J\u0010\u0010a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000bJ\u0010\u0010c\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006d"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/IConversationRepoService;", "", "modifyConversationTts", "", "conversationId", "", "enable", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findLocalConversationByBot", "Lcom/larus/im/bean/conversation/Conversation;", "botId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findConversationListByBot", "", "findConversationByBot", "getMainConversation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBotConversation", "botConversationType", "", "sourceConversationId", "sourceMessageId", "pinned", "collectionId", "caseId", "caseName", "ext", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConversationBizExt", "", "conversation", "bizExtra", "updateConversationExt", "removeConversation", "mode", "Lcom/larus/im/bean/conversation/ConversationDeleteMode;", "(Lcom/larus/im/bean/conversation/Conversation;Lcom/larus/im/bean/conversation/ConversationDeleteMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMode", "(Ljava/lang/String;Lcom/larus/im/bean/conversation/ConversationDeleteMode;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncConversationInfo", "userId", "conversationResp", "(Ljava/lang/String;Lcom/larus/im/bean/conversation/Conversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireConversationInfo", "localConversationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireConversationInfo2", "Lcom/larus/network/http/Async;", "syncConversationBio", "owner", "conversationList", "botBioMap", "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocalConversation", "bot", "Lcom/larus/bmhome/chat/bean/RecommendBot;", ControlRule.KEY_EXTRA_DATA, "(Lcom/larus/bmhome/chat/bean/RecommendBot;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/larus/im/bean/bot/BotModel;", "projectId", "(Lcom/larus/im/bean/bot/BotModel;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findConversation", "fromLocal", "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findConversationListLocalFirst", "cvsIdList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryInterrupt", "serverInterrupt", "forceInterrupt", "breakReason", "Lcom/larus/im/internal/jni/bean/OmniBreakReason;", "tryInterruptByDb", "(Ljava/lang/String;ZZLcom/larus/im/internal/jni/bean/OmniBreakReason;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryInterruptSuspend", "updateFirstMet", "botModel", "clearHistory", "Lcom/larus/bmhome/bot/bean/BotInfoUpdateResult;", "conversationType", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearContext", "from", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markConversationRead", "readIndex", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "conversationSyncFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getParticipants", "Lcom/larus/im/bean/conversation/ConversationParticipantListResponse;", "offset", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "acquireTotal", "(Ljava/lang/String;ZIIZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRequiringBotFirstMet", "updateConversationCreateScene", "getConversationType", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IConversationRepoService {

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ Object d(IConversationRepoService r100, String r101, Continuation r102) {
            return r100.b(r101, 0, 50, true, r102);
        }

        public static /* synthetic */ Object g(ConversationRepo r100, String r101, OmniBreakReason r102, Continuation r103) {
            return r100.B(r101, true, false, r102, r103);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object b(IConversationRepoService r100, BotModel r101, Map r102, Continuation r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = null;
        L6:
            return r100.k(r101, r102, null, r103);
        }

        public static /* synthetic */ Object e(IConversationRepoService r100, String r101, String r102, Continuation r103, int r104) {
            String r105 = "";
            if ((r104 & 1) == 0) goto L6;
            r101 = "";
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = "";
        L9:
            if ((r104 & 4) != 0) goto L13;
            r105 = null;
        L13:
            return r100.j(r101, r102, r105, r103);
        }

        public static /* synthetic */ Object c(IConversationRepoService r100, String r101, boolean r102, String r103, Continuation r104, int r105) {
            if ((r105 & 2) == 0) goto L6;
            r102 = true;
        L6:
            if ((r105 & 4) == 0) goto L9;
            r103 = null;
        L9:
            return r100.v(r101, r102, r103, r104);
        }

        public static /* synthetic */ void f(IConversationRepoService r100, String r101, boolean r102, boolean r103, OmniBreakReason r104, int r105) {
            if ((r105 & 2) == 0) goto L6;
            r102 = true;
        L6:
            if ((r105 & 4) == 0) goto L9;
            r103 = false;
        L9:
            if ((r105 & 8) == 0) goto L11;
            r104 = OmniBreakReason.OmniBreakReason_OTHER;
        L11:
            r100.w(r101, r102, r103, r104);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object a(IConversationRepoService r110, String r111, int r112, String r113, String r114, boolean r115, String r210, String r211, String r212, Map r213, Continuation r214, int r215) {
            if ((r215 & 4) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r215 & 8) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r215 & 16) == 0) goto L13;
            boolean r102 = false;
        L15:
            if ((r215 & 32) == 0) goto L17;
            String r103 = null;
        L19:
            if ((r215 & 64) == 0) goto L21;
            String r116 = null;
        L23:
            if ((r215 & 128) == 0) goto L25;
            String r117 = null;
        L27:
            if ((r215 & 256) == 0) goto L29;
            Map r118 = null;
        L31:
            return r110.t(r111, r112, r100, r101, r102, r103, r116, r117, r118, r214);
        L29:
            r118 = r213;
            goto L31
        L25:
            r117 = r212;
            goto L27
        L21:
            r116 = r211;
            goto L23
        L17:
            r103 = r210;
            goto L19
        L13:
            r102 = r115;
            goto L15
        L9:
            r101 = r114;
            goto L11
        L5:
            r100 = r113;
            goto L7
        }
    }

    Object a(String r100, Continuation<? super wc9.e> r101);

    Object b(String r100, int r101, int r102, boolean r103, Continuation r104);

    void c(wc9.e r100, Map<String, String> r101);

    Object d(String r100, ContinuationImpl r101);

    void e(wc9.e r100, String r101);

    Object f(Continuation<? super wc9.e> r100);

    Object g(List<String> r100, Continuation<? super List<wc9.e>> r101);

    void h(String r100, Long r101);

    void i(String r100, RecommendBot r101);

    Object j(String r100, String r101, String r102, Continuation<? super com.larus.network.http.a<wc9.e>> r103);

    Object k(BotModel r100, Map<String, String> r101, String r102, Continuation<? super String> r103);

    Object l(String r100, ConversationDeleteMode r101, String r102, Continuation<? super Boolean> r103);

    Object m(String r100, Continuation<? super wc9.e> r101);

    Object n(String r100, @ConversationType int r101, String r102, Continuation<? super ub8.b> r103);

    void o(String r100, BotModel r101);

    Object p(String r100, boolean r101, Continuation<? super Boolean> r102);

    Object q(String r100, Continuation r101);

    Object r(String r100, String r101, String r102, Continuation<? super wc9.e> r103);

    Object s(String r100, Continuation<? super Boolean> r101);

    Object t(String r100, @BotConversationType int r101, String r102, String r103, boolean r104, String r105, String r106, String r107, Map<String, String> r108, Continuation<? super wc9.e> r110);

    Object u(RecommendBot r100, Map<String, String> r101, Continuation<? super String> r102);

    Object v(String r100, boolean r101, String r102, Continuation<? super wc9.e> r103);

    void w(String r100, boolean r101, boolean r102, OmniBreakReason r103);

    int x(String r100);

    kotlinx.coroutines.flow.i1<List<String>> y();
}
