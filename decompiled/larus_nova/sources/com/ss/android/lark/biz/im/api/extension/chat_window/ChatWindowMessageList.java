package com.ss.android.lark.biz.im.api.extension.chat_window;

import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.scaffold.IComponent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000 82\u00020\u00012\u00020\u0002:\u000389:J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000fH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J$\u0010\u0013\u001a\u00020\n2\u001a\u0010\u0014\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016\u0012\u0004\u0012\u00020\u00170\u0015H&J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0016\u0010\u001b\u001a\u00020\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0005H&J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H&J\u0010\u0010#\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H&J\u0010\u0010$\u001a\u00020\n2\u0006\u0010!\u001a\u00020%H&J\u0010\u0010&\u001a\u00020\n2\u0006\u0010!\u001a\u00020%H&J\u0016\u0010'\u001a\u00020\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020)0(H&J\u0016\u0010*\u001a\u00020\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020)0(H&J\b\u0010+\u001a\u00020\nH&J\b\u0010,\u001a\u00020-H&J\u0010\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u000200H&J\u0010\u00101\u001a\u00020\n2\u0006\u0010/\u001a\u000200H&J\u0010\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u0005H&J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0005H\u0016J\b\u00104\u001a\u000205H&J\b\u00106\u001a\u000207H&R$\u0010\u0003\u001a\u0014\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006;"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowMessageList;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/ss/android/lark/scaffold/IComponent;", "messageList", "Landroidx/lifecycle/LiveData;", "", "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "getMessageList", "()Landroidx/lifecycle/LiveData;", "addMessageListKeyEventListener", "", "listener", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowMessageList$MessageListKeyEventListener;", "removeMessageListKeyEventListener", "addNewMessageListener", "Lcom/ss/android/lark/biz/im/api/listener/NewMessageListener;", "removeNewMessageListener", "getMessageListView", "Landroidx/recyclerview/widget/RecyclerView;", "setMessageCellParams", "params", "", "Ljava/lang/Class;", "Lcom/ss/android/lark/biz/im/api/message/params/MessageCellParam;", "batchUpdate", "needUpdateMessage", "Lcom/ss/android/lark/chat/entity/message/IChatMessage;", "invalidateMessageViews", "needInvalidateMessageIds", "", "needInvalidateMessagePosition", "", "addMessageListChangeInterceptor", "interceptor", "Lcom/ss/android/lark/biz/im/api/MessageListChangeInterceptor;", "removeMessageListChangeInterceptor", "addMultiSelectMessageClickInterceptor", "Lcom/ss/android/lark/biz/im/api/extension/message/MultiSelectMessageClickInterceptor;", "removeMultiSelectMessageClickInterceptor", "addMessageActionPanelScrollStateInterceptor", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/Interceptor;", "", "removeMessageActionPanelScrollStateInterceptor", "dismissActionPanel", "getMessageActionHandlerManager", "Lcom/ss/android/lark/biz/im/api/messageaction/MessageActionHandlerManager;", "registerAdapterDataObserver", "observer", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "unregisterAdapterDataObserver", "getAllDisplayMessageItems", "getVisibleMessageIds", "getScrollDispatcher", "Lcom/ss/android/lark/biz/im/api/extension/scroll/ScrollDispatcher;", "isNewScrollEnable", "", "Companion", "MessageListKeyEventListener", "ScrollCallback", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ChatWindowMessageList extends LifecycleOwner, IComponent {

    public interface a {
        void a();

        void b();
    }

    com.ss.android.lark.biz.im.api.extension.scroll.c Ar();

    boolean Qv();

    void eM(jya.a r100);

    void hg(a r100);

    mya.h j5();
}
