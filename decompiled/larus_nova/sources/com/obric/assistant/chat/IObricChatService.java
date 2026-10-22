package com.obric.assistant.chat;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.obric.aiagent.messenger.stub.AppStateIDLStub;
import com.obric.assistant.chat.internal.ChatSender;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\r\bg\u0018\u0000 12\u00020\u0001:\u00011J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001aH&J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH&J(\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#\u0018\u00010%H&J\b\u0010&\u001a\u00020\u0003H&J\b\u0010'\u001a\u00020\u001aH&J\b\u0010(\u001a\u00020\u0003H&J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH&J\b\u0010*\u001a\u00020\u001aH&J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020#H&J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020#H&J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010/\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u00100\u001a\u00020\u00032\u0006\u0010,\u001a\u00020#H&¨\u00062"}, d2 = {"Lcom/obric/assistant/chat/IObricChatService;", "", "init", "", "getConversation", "Lcom/larus/im/bean/conversation/Conversation;", "getMainConversation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBot", "Lcom/larus/im/bean/bot/BotModel;", "getSender", "Lcom/obric/assistant/chat/api/ISenderApi;", "messageApi", "Lcom/obric/assistant/chat/api/IMessageApi;", "messageObserver", "Lcom/obric/assistant/chat/api/IMessageObserver;", "registerMainBotChatPageListener", "listener", "Lcom/obric/assistant/chat/IMainBotChatPageListener;", "unregisterMainBotChatPageListener", LynxViewpagerItem.BIND_ON_ATTACH, "componentFeature", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "detach", "onNewInteractionSession", "isTtsPlayChecked", "", "setTtsEnable", "enable", "shouldNotPlayTts", "msg", "Lcom/larus/im/bean/message/Message;", "isComplexTaskMessage", "onVoiceAuthenAsrResult", DBDefinition.TASK_ID, "", "extraMap", "", "onStop", "isLastMessageFromVoiceWakeup", "updateTitle", "isWakeupAndKeyLock", "needRestoreTtsState", "turnOnTtsSwitchIfNecessary", RemoteMessageConst.MSGID, "isMessageFromVoiceWakeup", "shouldIgnoreTtsConfig", "isContLockScreenQueryReply", "markPlayingLockReply", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricChatService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f386556a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f386557a = null;

        static {
            f386557a = new a();
        }

        public a() {
        }

        public static IObricChatService a() {
            return (IObricChatService) ServiceManager.get().getService(IObricChatService.class, false, false);
        }
    }

    static {
        f386556a = a.f386557a;
    }

    void a(ComponentFeature r100);

    void b(ComponentFeature r100);

    boolean c(Message r100);

    Object d(ContinuationImpl r100);

    void e();

    void f(String r100);

    void g();

    ChatSender getSender();

    wc9.e h();

    void i(AppStateIDLStub.b r100);

    void init();

    void isContLockScreenQueryReply(Message r100);

    boolean j();

    BotModel j0();

    boolean k();

    void l();

    boolean m(String r100);

    void n(boolean r100);

    boolean o(String r100);

    void onStop();

    void p(String r100, Map<String, String> r101);

    boolean q();

    boolean r(Message r100);

    void updateTitle();
}
