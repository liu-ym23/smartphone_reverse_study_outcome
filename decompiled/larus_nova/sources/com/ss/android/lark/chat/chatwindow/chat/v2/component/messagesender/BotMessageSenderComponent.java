package com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.chat.entity.message.MessageParams;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012J \u0010\u0017\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b2\u000e\u0010\u000b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\bH\u0016J\"\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016RG\u0010\u0006\u001a/\u0012\u001b\u0012\u0019\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/messagesender/BotMessageSenderComponent;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/messagesender/MessageSenderComponent;", KtvSubElement.CONTAINER, "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "<init>", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "messageParamsPacker", "Lkotlin/Function1;", "Lcom/ss/android/lark/chat/entity/message/MessageParams$Builder;", "Lkotlin/ParameterName;", "name", "params", "getMessageParamsPacker", "()Lkotlin/jvm/functions/Function1;", "setMessageParamsPacker", "(Lkotlin/jvm/functions/Function1;)V", "quasiListeners", "", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/messagesender/BotMessageSenderComponent$IQuasiMessageSendListener;", "addQuasiMessageCallback", "", "callback", "removeQuasiMessageCallback", "onInterceptMessageParams", "onQuasiMessageSendStart", "cid", "", "messageParams", "Lcom/ss/android/lark/chat/entity/message/MessageParams;", "onQuasiMessageSendEnd", "IQuasiMessageSendListener", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotMessageSenderComponent extends MessageSenderComponent {
    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender.BaseMessageSenderComponent, j4b.a.d
    public final void R() {
        new ArrayList(CollectionsKt.collectionSizeOrDefault(null, 10));
        throw null;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender.BaseMessageSenderComponent, j4b.a.c
    public final MessageParams.a<?, ?> j(MessageParams.a<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r100, "params");
        return r100;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender.MessageSenderComponent, com.ss.android.lark.chat.chatwindow.chat.v2.component.messagesender.BaseMessageSenderComponent, j4b.a.d
    public final void g(String r100, MessageParams<?, ?> r101) {
        Intrinsics.checkNotNullParameter(r101, "messageParams");
        super.g(r100, r101);
        new ArrayList(CollectionsKt.collectionSizeOrDefault(null, 10));
        throw null;
    }
}
