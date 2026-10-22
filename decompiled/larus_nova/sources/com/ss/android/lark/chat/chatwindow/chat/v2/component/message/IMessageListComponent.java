package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import android.graphics.Rect;
import android.widget.RelativeLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowMessageList;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import com.ss.android.lark.biz.im.api.x0;
import com.ss.android.lark.chat.base.view.recycleview.ItemShineManager;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.ListMode;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.MessageListDecorationController;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.scaffold.IComponent;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0084\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\bf\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u001cµ\u0001¶\u0001·\u0001¸\u0001¹\u0001º\u0001»\u0001¼\u0001½\u0001¾\u0001¿\u0001À\u0001Á\u0001Â\u0001J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u001eH&J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u001eH&J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020!H&J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020!H&J\u001a\u0010#\u001a\u00020\u00102\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0$H&J\u001a\u0010%\u001a\u00020\u00102\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0$H&J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020'H&J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020)H&J\n\u0010*\u001a\u0004\u0018\u00010+H&J\n\u0010,\u001a\u0004\u0018\u00010-H&J\b\u0010.\u001a\u00020/H&J\b\u00100\u001a\u00020/H&J\b\u00101\u001a\u00020/H&JN\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020/2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u0001092\u0018\b\u0002\u0010:\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010<\u0012\u0004\u0012\u00020/\u0018\u00010;H&J\u0010\u0010=\u001a\u00020\u00102\u0006\u00103\u001a\u000204H&J\u0010\u0010>\u001a\u00020\u00102\u0006\u00103\u001a\u000204H&J$\u0010?\u001a\u00020\u00102\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0A2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DH&J\"\u0010F\u001a\u00020\u00102\u0018\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020E0H0\u0007H&J\u0012\u0010I\u001a\u0004\u0018\u00010E2\u0006\u0010J\u001a\u00020BH&J\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020E0\u00072\f\u0010L\u001a\b\u0012\u0004\u0012\u00020B0MH&J\u0010\u0010N\u001a\u00020\u00102\u0006\u0010O\u001a\u00020PH&J\u0012\u0010Q\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H&J\u0010\u0010R\u001a\u00020\u00102\u0006\u0010S\u001a\u000206H&J\u001e\u0010R\u001a\u00020\u00102\u0006\u0010S\u001a\u0002062\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00100UH&J\b\u0010V\u001a\u00020\u0010H&J\u0010\u0010W\u001a\u0002062\u0006\u0010X\u001a\u000206H&J\u0012\u0010Y\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H&J\u0018\u0010Z\u001a\u00020\u00102\u0006\u0010[\u001a\u0002062\u0006\u0010\\\u001a\u000206H&J \u0010]\u001a\u0002062\u0006\u0010^\u001a\u0002062\u0006\u0010_\u001a\u0002062\u0006\u0010\\\u001a\u000206H&J\u0016\u0010`\u001a\u00020\u00102\f\u0010L\u001a\b\u0012\u0004\u0012\u00020B0\u0007H&J\u0012\u0010a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H&J\u000e\u0010b\u001a\b\u0012\u0004\u0012\u00020B0\u0007H&J\u0018\u0010c\u001a\u00020\u00102\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u000206H&J$\u0010g\u001a\u00020\u00102\u0006\u0010h\u001a\u0002062\u0012\b\u0002\u0010i\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H&J\b\u0010j\u001a\u00020eH&J\b\u0010k\u001a\u00020\u0010H&J\n\u0010l\u001a\u0004\u0018\u00010mH&J\u0010\u0010n\u001a\u00020\u00102\u0006\u0010o\u001a\u00020BH&J\u0010\u0010p\u001a\u00020\u00102\u0006\u0010q\u001a\u00020/H&J\u0010\u0010r\u001a\u00020\u00102\u0006\u0010s\u001a\u00020/H&J\b\u0010t\u001a\u00020/H&J\u0016\u0010u\u001a\u00020\u00102\f\u0010v\u001a\b\u0012\u0002\b\u0003\u0018\u00010wH&J\u000e\u0010x\u001a\b\u0012\u0002\b\u0003\u0018\u00010wH&J\u0012\u0010y\u001a\u00020\u00102\b\u0010z\u001a\u0004\u0018\u00010{H&J\u0010\u0010|\u001a\u00020\u00102\u0006\u0010}\u001a\u000206H&J\u001d\u0010~\u001a\u0017\u0012\u0004\u0012\u00020<\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020<0\u0080\u0001\u0018\u00010\u007fH&J\u0012\u0010\u0081\u0001\u001a\u00020\u00102\u0007\u0010:\u001a\u00030\u0082\u0001H&J\u0012\u0010\u0083\u0001\u001a\u00020\u00102\u0007\u0010:\u001a\u00030\u0082\u0001H&J\t\u0010\u0084\u0001\u001a\u00020\u0010H&J\t\u0010\u0085\u0001\u001a\u000206H&J\t\u0010\u0086\u0001\u001a\u000206H&J\u0012\u0010\u0087\u0001\u001a\u00020\u00102\u0007\u0010z\u001a\u00030\u0088\u0001H&J\u0012\u0010\u0089\u0001\u001a\u00020\u00102\u0007\u0010z\u001a\u00030\u0088\u0001H&J\u0012\u0010\u008a\u0001\u001a\u00020\u00102\u0007\u0010\u0017\u001a\u00030\u008b\u0001H&J\u0012\u0010\u008c\u0001\u001a\u00020\u00102\u0007\u0010\u0017\u001a\u00030\u008b\u0001H&J\u0012\u0010\u008d\u0001\u001a\u00020\u00102\u0007\u0010\u008e\u0001\u001a\u00020BH&J\u001c\u0010\u008f\u0001\u001a\u00020\u00102\u0007\u0010\u008e\u0001\u001a\u00020B2\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H&J\u0012\u0010\u0092\u0001\u001a\u00020\u00102\u0007\u0010\u0017\u001a\u00030\u0093\u0001H&J\n\u0010\u0094\u0001\u001a\u00030\u0095\u0001H&J\n\u0010\u0096\u0001\u001a\u00030\u0097\u0001H&J\u0013\u0010\u0098\u0001\u001a\u00020\u00102\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H&J\u0012\u0010\u009b\u0001\u001a\u00020\u00102\u0007\u0010\u0017\u001a\u00030\u009c\u0001H'J\u0012\u0010\u009d\u0001\u001a\u00020\u00102\u0007\u0010\u0017\u001a\u00030\u009c\u0001H'J\u0012\u0010\u009e\u0001\u001a\u00020\u00102\u0007\u0010\u009f\u0001\u001a\u00020/H&J\"\u0010 \u0001\u001a\u00020\u00102\b\u0010¡\u0001\u001a\u00030¢\u00012\r\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020<0\u0007H&J\u0019\u0010¤\u0001\u001a\u00020\u00102\u000e\u0010¥\u0001\u001a\t\u0012\u0004\u0012\u00020<0¦\u0001H&J\u0013\u0010§\u0001\u001a\u00020\u00102\b\u0010¨\u0001\u001a\u00030©\u0001H&J\u000b\u0010ª\u0001\u001a\u0004\u0018\u00010<H\u0016J5\u0010«\u0001\u001a\u0005\u0018\u00010¬\u00012\u000f\u0010\u00ad\u0001\u001a\n\u0012\u0005\u0012\u00030¯\u00010®\u00012\f\u0010°\u0001\u001a\u0007\u0012\u0002\b\u00030±\u00012\b\u0010²\u0001\u001a\u00030³\u0001H&J\u0014\u0010´\u0001\u001a\u0004\u0018\u00010<2\u0007\u0010\u008e\u0001\u001a\u00020BH&R$\u0010\u0005\u001a\u0014\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007\u0018\u00010\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006Ã\u0001À\u0006\u0001"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent;", "Lcom/ss/android/lark/scaffold/IComponent;", "Lcom/ss/android/lark/biz/im/api/component/callback/IComponentCallbackManager;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$IListComponentCallbacks;", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowMessageList;", "messageList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "getMessageList", "()Landroidx/lifecycle/MutableLiveData;", "messageListParams", "Lcom/ss/android/lark/biz/im/api/MessageListParams;", "getMessageListParams", "()Lcom/ss/android/lark/biz/im/api/MessageListParams;", "setDependency", "", "dependency", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$IMessageListDependency;", "addMessageCallbackHandler", "handler", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/MessageCallbackHandler;", "addOnScrollListener", "listener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "addSelectedMessageChangeListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$ISelectedMessageChangeListener;", "addMessageClearedListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$IMessageClearedListener;", "addMessageBurnedListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$IMessageBurnedListener;", "removeMessageBurnedListener", "addMessageVisibleListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$IMessageVisibleListener;", "removeMessageVisibleListener", "addOnItemDetectedListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/widget/RecyclerViewItemDetector$ItemDetectListener;", "removeOnItemDetectedListener", "addAudioPlayModeChangeListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$OnAudioPlayerModeListener;", "addMessageSelectModeChangeListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$IMessageTipChangeListener;", "getRootLayout", "Landroid/widget/RelativeLayout;", "getMessagesRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isLastItemShown", "", "canLoadMore", "canLoadPre", "scrollToPosition", "scene", "Lcom/ss/android/lark/biz/im/api/extension/scroll/ScrollScene;", "messagePosition", "", "showAnim", "toBottom", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$OnLoadMessageStatusListener;", "interceptor", "Lkotlin/Function1;", "Lcom/ss/android/lark/chat/entity/message/MessageInfo;", "scrollToLatestMessageOfChatImmediately", "scrollToBottomIfNeed", "updateMsg", "key", "Lcom/ss/android/lark/biz/im/api/extension/store/ItemTwoKey;", "", "updater", "Lcom/ss/android/lark/biz/im/api/extension/store/IItemPatch;", "Lcom/ss/android/lark/chat/entity/message/IChatMessage;", "batchUpdateMsg", "patchProviderList", "Lcom/ss/android/lark/biz/im/api/extension/store/PatchProvider;", "getMsgById", "id", "getMsgListByIds", "ids", "", "serialExecute", "runnable", "Ljava/lang/Runnable;", "getCurrentPageMsg", "changeListBottomMargin", "height", "callback", "Lkotlin/Function0;", "ensureLastPageDataLoaded", "getMsgPosByAdapterPos", "adapterPos", "getAllMsg", "selectMsgFromPosition", "position", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "selectMsgBetweenAdapterPositions", "startAdapterPosition", "endAdapterPosition", "selectMsgByMsgIds", "getSelectedMsgList", "getFollowingSelectMessageIds", "changeListMode", "mode", "Lcom/ss/android/lark/chat/chatwindow/biz/component/messagelist/render/cell/ListMode;", "selectedPosition", "enterMultiSelectMode", "adapterPosition", "selected", "currentListMode", "refreshMessageList", "getMessageContext", "Lcom/ss/android/lark/chat/chatwindow/biz/component/messagelist/render/cell/IChatContext;", "onAuditedFailed", "msg", "setInterceptItemsTouch", "intercept", "setAllowItemShine", "allow", "getAllowItemShine", "setItemShineManager", "manager", "Lcom/ss/android/lark/chat/base/view/recycleview/ItemShineManager;", "getItemShineManager", "setChatWindowPreloadProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IChatWindowPreLoadTaskProvider;", "checkToClearMessages", "newFirstMsgPosition", "getChatWindowDataStore", "Lcom/ss/android/lark/chatbase/BasePageStore;", "Lcom/ss/android/lark/chat/core/model/BasePageData;", "addMessagePushInterceptor", "Lcom/ss/android/lark/biz/im/api/MessagePushInterceptor;", "removeMessagePushInterceptor", "notifyDataChange", "firstCompleteVisibleMessagePosition", "lastCompleteVisibleMessagePosition", "addReadMessageIdProvider", "Lcom/ss/android/lark/biz/im/api/ReadMessageIdProvider;", "removeReadMessageIdProvider", "addReadMessageListener", "Lcom/ss/android/lark/biz/im/api/IMessageReadListener;", "removeReadMessageListener", "readAudioMessage", "messageId", "prepareAudio", "successState", "Lcom/ss/android/lark/chat/entity/message/content/AudioContent$AudioState;", "addAudioDownloadListener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/audio/AudioDownloadListener;", "getMessageListConcatAdapter", "Lcom/ss/android/lark/chat/chatwindow/chat/IMessageListConcatAdapter;", "getChatAdapter", "Lcom/ss/android/lark/chat/chatwindow/chat/IChatAdapter;", "updateLayoutManager", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "addTitleAreaVisibilityListener", "Lcom/ss/android/lark/biz/im/api/TitleAreaVisibilityListener;", "removeTitleAreaVisibilityListener", "updateMessageReadable", "readable", "invalidateItemDecoration", "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "messageInfoList", "addDataStoreDecorator", "decorator", "Lcom/ss/android/lark/chatbase/IDataStoreDataDecorator;", "onListDecorationHeightChangeEvent", "event", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/MessageListDecorationController$DecorationHeightChangeEvent;", "getTopicMessageInfo", "showTextSelectMenu", "Lcom/ss/android/lark/chat/chatwindow/menu/ITextSelectMenuControl;", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "Lcom/ss/android/lark/blueprint/ICell;", "", "messageVo", "Lcom/ss/android/lark/chat/vo/AbsMessageVO;", "selectedTextRectOnWindow", "Landroid/graphics/Rect;", "getMessageInfoById", "IMessageVisibleListener", "IMessageClearedListener", "IMessageBurnedListener", "IMessageClearedCallback", "IListComponentCallbacks", "OnAudioPlayerModeListener", "ISelectedMessageChangeListener", "IKeyboardTipChangeListener", "IMessageTipChangeListener", "OnLoadMessageStatusListener", "IMessageListDependency", "IMessageListKeyboardDependency", "IMessageListTitleBarDependency", "IMessageListFooterHintDependency", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMessageListComponent extends IComponent, oxa.c<a>, ChatWindowMessageList {

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static MessageInfo $default$getTopicMessageInfo(IMessageListComponent r100) {
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void scrollToPosition$default(IMessageListComponent r100, ScrollScene r110, int r111, boolean r112, boolean r113, k r114, Function1 r115, int r116, Object r117) {
            if (r117 != null) goto L14;
            if ((r116 & 16) == 0) goto L6;
            k r101 = null;
        L8:
            if ((r116 & 32) == 0) goto L10;
            Function1 r102 = null;
        L11:
            r100.t3(r110, r111, r112, r113, r101, r102);
            return;
        L10:
            r102 = r115;
            goto L11
        L6:
            r101 = r114;
            goto L8
        L14:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToPosition");
        }
    }

    public interface a extends com.ss.android.lark.biz.im.api.extension.chat_window.e {
        @Deprecated(message = "use MessageListKeyEventListener")
        void A9();

        void B9(ChatChatter r100);

        void e(BasePageStore<MessageInfo, ? extends x4b.a<MessageInfo>> r100);

        void w9(ThreadTopic r100);

        void x9();

        void y9();

        void z9(Chat r100);
    }

    public interface b {
        void a();
    }

    public interface c {
        void a();
    }

    public interface d {
        void a();
    }

    public interface e {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d.b a();

        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.e b();

        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.f c();

        q4b.a getMessageSender();
    }

    public interface f {
        void a(MessageInfo r100, int r101);
    }

    public interface g {
        void a(ListMode r100);
    }

    public interface h {
        void a();

        void b();
    }

    public interface i {
        void a();
    }

    public interface j {
        void a();
    }

    public interface k {
        void a();

        void b();
    }

    void CU(ItemShineManager<?> r100);

    void Cs(boolean r100);

    SceneCoordinateRecyclerView Et();

    s2b.g FX();

    r4b.a H2(com.ss.android.lark.blueprint.m<Object> r100, y6b.a<?> r101, Rect r102);

    void H5(String r100);

    void IB(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.g r100);

    void MH(ScrollScene r100);

    void Ml(i r100);

    void N3();

    List<y6b.c<?>> Oq();

    void QE(o r100);

    int RT(int r100);

    boolean SP();

    com.ss.android.lark.chat.chatwindow.chat.a Tc();

    RelativeLayout UI();

    void Vk(com.ss.android.lark.chat.chatwindow.chat.v2.widget.c.InterfaceC4844c<y6b.c<?>> r100);

    s2b.d W2();

    void X70(com.ss.android.lark.chat.chatwindow.biz.plugin.a.d r100);

    void Y00(ListMode r100, int r101);

    void addOnScrollListener(RecyclerView.OnScrollListener r100);

    void batchUpdateMsg(List<? extends hya.c<String, f5b.b>> r100);

    void cN(MessageListDecorationController.c r100);

    boolean canLoadMore();

    void df(g r100);

    void g6(int r100);

    List<y6b.c<?>> gK();

    MessageInfo getMessageInfoById(String r100);

    MutableLiveData<List<y6b.c<?>>> getMessageList();

    MessageInfo getTopicMessageInfo();

    List<y6b.c<?>> h20();

    void jX(d r100);

    void mB(String r100, AudioContent.AudioState r101);

    ItemShineManager<?> oV();

    void onAuditedFailed(String r100);

    List<String> pP();

    BasePageStore<MessageInfo, x4b.a<MessageInfo>> qg();

    x0 rY();

    boolean sX();

    void sf(ScrollScene r100);

    void t3(ScrollScene r100, int r101, boolean r102, boolean r103, k r104, Function1<? super MessageInfo, Boolean> r105);

    void updateMsg(hya.b<String> r100, hya.a<f5b.b> r101);

    void wb(List<String> r100);

    void x4();

    MessageInfo y90(String r100);

    void yU(int r100);

    void z6(boolean r100);

    ListMode zO();
}
