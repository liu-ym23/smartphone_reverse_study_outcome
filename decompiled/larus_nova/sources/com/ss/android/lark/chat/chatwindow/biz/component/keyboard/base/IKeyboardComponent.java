package com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base;

import com.larksuite.framework.callback.IGetDataCallback;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.KeyboardWrapperConfigurator;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.b;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.scaffold.IComponent;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oxa.c;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005:\u0001aJ\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\b\u0010\u001f\u001a\u00020 H&J\u001c\u0010!\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\f2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\"H&J\u001c\u0010#\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\f2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030$H&J*\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020 2\b\b\u0002\u0010*\u001a\u00020 H&J\u0018\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020\tH&J\b\u0010.\u001a\u00020\u0007H&J\b\u0010/\u001a\u00020\fH&J\b\u00100\u001a\u00020\fH&J6\u00101\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u00010\f2\b\u00105\u001a\u0004\u0018\u0001032\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020807H&J(\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020 H&J\u0010\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\fH&J\b\u0010?\u001a\u00020\u0007H&J\u0018\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH&J\u0018\u0010E\u001a\u00020\u00072\u0006\u0010A\u001a\u00020B2\u0006\u0010F\u001a\u00020DH&J4\u0010E\u001a\u00020\u00072\u0006\u0010A\u001a\u00020B2\u0006\u0010F\u001a\u00020D2\b\u0010G\u001a\u0004\u0018\u00010H2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010IH&JF\u0010E\u001a\u00020\u00072\u0006\u0010A\u001a\u00020B2\u0006\u0010F\u001a\u00020D2\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010J\u001a\u00020 2\b\b\u0002\u0010*\u001a\u00020 2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010IH&J(\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\f2\u0006\u00104\u001a\u00020\f2\u0006\u0010M\u001a\u0002032\u0006\u0010N\u001a\u00020DH&J\u001c\u0010O\u001a\u00020\u00072\u0012\u0010P\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030R0QH&J\u0010\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020 H&J\n\u0010U\u001a\u0004\u0018\u00010VH&J\b\u0010W\u001a\u00020\u0007H&J\b\u0010X\u001a\u00020\u0007H&J\n\u0010Y\u001a\u0004\u0018\u00010ZH&J\b\u0010[\u001a\u00020\u0007H&J\b\u0010\\\u001a\u00020DH&J\n\u0010]\u001a\u0004\u0018\u00010^H&J\u001c\u0010_\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\f2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030`H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006bÀ\u0006\u0001"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/base/IKeyboardComponent;", "Lcom/ss/android/lark/scaffold/IComponent;", "Lcom/ss/android/lark/biz/im/api/component/callback/IComponentCallbackManager;", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowKeyboard$IKeyboardComponentCallbacks;", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowKeyboard;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardwrapper/IKeyboardCommon;", "changeKeyboardInputState", "", "state", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/inputstate/InputState;", "bannedKeyboardShown", "reason", "", "banReason", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardwrapper/BannedKeyboardReason;", "bindKeyboardEventHandler", "handler", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/base/IKeyboardEventHandler;", "unBindKeyboardEventHandler", "registerKeyboardControlStatusChangeListener", "listener", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/base/IKeyboardComponent$OnKeyboardControlStatusChangeListener;", "unRegisterKeyboardControlStatusChangeListener", "registerKBPlugin", "name", CloudControlInf.PLUGIN, "Lcom/ss/android/lark/keyboard/keyboard2/KeyboardMenuItem;", "registerKeyboardCallback", "callback", "getInputEditor", "Lcom/ss/android/lark/keyboard/plugin/input/base/ISendKeyboardEditor;", "isInGeneralMode", "", "registerInputBottomPlugin", "Lcom/ss/android/lark/keyboard/base/IIMInputBottomPlugin;", "registerKeyboardLogicPlugin", "Lcom/ss/android/lark/keyboard/base/IIMKeyboardLogicPlugin;", "enterReplyMode", "replyInfo", "Lcom/ss/android/lark/chatwindow/model/data/ReplyInfo;", "isReEdit", "resetOnStart", "closeIme", "onEnterReEditMode", "fromDraft", "inputState", "finishReplyMode", "getReplyRootMsgId", "getReplyParentMsgId", "appendText", "text", "Lcom/ss/android/lark/widget/richtext/RichText;", "title", "postText", "fileAttachments", "", "Lcom/ss/android/lark/keyboard/base/ChatAttachmentEntity;", "insertAt", "chatterId", "chatterOriginName", "isOutChat", "closeTypingTranslate", "chatId", "openTypingTranslate", "onEditMessage", "messageInfo", "Lcom/ss/android/lark/chat/entity/message/MessageInfo;", "position", "", "onReplyMessage", "adapterPosition", "partialReplyInfo", "Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo;", "Lcom/larksuite/framework/callback/IGetDataCallback;", "needPrefix", "onRetryEditMessage", "messageId", "content", "messageVersion", "onReEdit", "messageVO", "Lcom/ss/android/lark/chat/vo/AbsMessageVO;", "Lcom/ss/android/lark/chat/export/vo/ContentVO;", "inhibitSystemKeyboard", "shouldInhibit", "getInputStateController", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/inputstate/IInputStateController;", "showSystemKeyboard", "hideSystemKeyboard", "getKeyboardMenu", "Lcom/ss/android/lark/keyboard/keyboard2/IKeyboardMenu;", "performSaveInputState", "getKeyboardTopHeight", "getKeyboardMessageSender", "Lcom/ss/android/lark/chat/chatwindow/keyboard/KeyboardMessageSender;", "registerInputInnerPlugin", "Lcom/ss/android/lark/keyboard/base/inputinner/IIMInputInnerPlugin;", "OnKeyboardControlStatusChangeListener", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKeyboardComponent extends IComponent, c<ChatWindowKeyboard.a>, ChatWindowKeyboard, b {

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$registerKeyboardCallback(IKeyboardComponent r100, ChatWindowKeyboard.a r101) {
            Intrinsics.checkNotNullParameter(r101, "callback");
            r100.m(r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onReplyMessage$default(IKeyboardComponent r100, MessageInfo r101, int r102, PartialReplyInfo r103, IGetDataCallback r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L6;
            r104 = null;
        L6:
            r100.oc(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onReplyMessage");
        }
    }

    public interface a {
        void a(boolean r100);
    }

    void F20(KeyboardWrapperConfigurator.e r100);

    void GA(boolean r100);

    void K6(y6b.a<? extends v5b.a<?>> r100);

    void P3(String r100, String r101, RichText r102, int r103);

    void PE(MessageInfo r100, int r101, PartialReplyInfo r102, boolean r103, boolean r104, IGetDataCallback<i7b.c> r105);

    int UJ();

    void f6(com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a r100);

    void lD(j2b.a r100);

    void lS(com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.a r100);

    boolean m10(String r100, String r101, String r102);

    void m7(ChatWindowKeyboard.a r100);

    void oN(MessageInfo r100);

    void oc(MessageInfo r100, int r101, PartialReplyInfo r102, IGetDataCallback<i7b.c> r103);

    void qk(KeyboardWrapperConfigurator.e r100);
}
