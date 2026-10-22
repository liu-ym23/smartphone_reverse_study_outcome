package com.larus.extension.offline_message.api;

import com.larus.bmhome.chat.component.list.ChatListComponent;
import com.larus.im.bean.message.Message;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import k99.b;
import k99.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J(\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0096A¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\fH\u0096\u0001Jh\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u001c\u0010\u001b\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\fH\u0096A¢\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%H\u0096\u0001J\u001e\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\fH\u0096A¢\u0006\u0002\u0010)J.\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u00192\u0006\u0010+\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0096A¢\u0006\u0002\u0010.J,\u0010/\u001a\u00020\u00052\u0006\u0010+\u001a\u00020,2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\b\u001a\u00020\u001eH\u0096A¢\u0006\u0002\u00101J,\u00102\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0096A¢\u0006\u0002\u00104J\u0019\u00105\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%H\u0096\u0001J%\u00106\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001cH\u0096\u0001¨\u00068"}, d2 = {"Lcom/larus/extension/offline_message/api/OfflineMessageServiceDelegate;", "Lcom/larus/extension/offline_message/api/IOfflineMessageService;", "<init>", "()V", "clearOfflineMessageSession", "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "", "executeSingleChainAfterSync", "cmdUplinkListSize", "", "cvsId", "", "generateLocalConversation", "Lcom/larus/extension/offline_message/api/LocalConversationResponse;", "botId", "query", "answer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOfflineMessageSession", "Lcom/larus/extension/offline_message/api/model/OfflineMessageSession;", "getRemoteCvsIdByLocalCvsId", "localCvsId", "handleOfflineMessages", "offlineMessages", "", "Lcom/larus/extension/offline_message/api/OfflineMessage;", "predicate", "Lkotlin/Function1;", "Lcom/larus/im/bean/message/Message;", "", "anchorIndex", "fixLocalIndex", "scrollToMsgLocalId", "(JLjava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/lang/Long;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerOfflineMessageSessionListener", "listener", "Lcom/larus/extension/offline_message/api/IOfflineMessageSessionListener;", "replaceLocalConversation", "localConversationId", "conversationId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveOfflineLocalMessage", "offlineMessageContext", "Lcom/larus/extension/offline_message/api/OfflineMessageContext;", "addLocalList", "(Lcom/larus/extension/offline_message/api/OfflineMessageContext;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncOfflineMessageByCmdUplink", "cmdUplinkList", "(Lcom/larus/extension/offline_message/api/OfflineMessageContext;Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncOfflineMessageBySendExt", "sendExtList", "(JLcom/larus/extension/offline_message/api/OfflineMessageContext;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterOfflineMessageSessionListener", "updateOfflineMessageSession", "updater", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfflineMessageServiceDelegate implements IOfflineMessageService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final OfflineMessageServiceDelegate f342907b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOfflineMessageService f342908a;

    static {
        f342907b = new OfflineMessageServiceDelegate();
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "localCvsId");
        return this.f342908a.a(r100);
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final Object b(c r100, List r101, Continuation r102) {
        return this.f342908a.b(r100, r101, r102);
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final void c(long r100, ChatListComponent.f r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f342908a.c(r100, r101);
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final void d(long r100) {
        this.f342908a.d(r100);
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final Object e(c r100, List<? extends b> r101, Continuation<? super List<Message>> r102) {
        return this.f342908a.e(r100, r101, r102);
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final void f(long r100) {
        this.f342908a.f(r100);
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final Object g(long r100, c r101, List<? extends b> r110, Continuation<? super Unit> r111) {
        return this.f342908a.g(r100, r101, r110, r111);
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageService
    public final void h(long r100, ChatListComponent.f r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f342908a.h(r100, r101);
    }

    private OfflineMessageServiceDelegate() {
        IOfflineMessageService r100 = (IOfflineMessageService) ServiceManager.get().getService(IOfflineMessageService.class);
        if (r100 != null) goto L5;
        r100 = new OfflineMessageServiceNoop();
    L5:
        this.f342908a = r100;
    }
}
