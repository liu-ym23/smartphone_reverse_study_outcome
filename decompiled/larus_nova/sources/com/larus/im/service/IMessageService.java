package com.larus.im.service;

import com.flow.kmp.common.util.CoroutineExtKt;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageListRequest;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.callback.IIMCallback;
import com.larus.im.internal.core.conversation.FtsSearchParam;
import com.larus.im.internal.core.conversation.FtsSearchResult;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface IMessageService {

    /* JADX INFO: loaded from: classes30.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/im/service/IMessageService$RegenDirection;", "", "<init>", "(Ljava/lang/String;I)V", "PREVIOUS", "NEXT", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RegenDirection extends Enum<RegenDirection> {
        public static final RegenDirection NEXT = null;
        public static final RegenDirection PREVIOUS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RegenDirection[] f350615a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f350616b = null;

        public static EnumEntries<RegenDirection> getEntries() {
            return f350616b;
        }

        static {
            RegenDirection r100 = new RegenDirection("PREVIOUS", 0);
            PREVIOUS = r100;
            RegenDirection r101 = new RegenDirection("NEXT", 1);
            NEXT = r101;
            RegenDirection[] r102 = {r100, r101};
            f350615a = r102;
            f350616b = EnumEntriesKt.enumEntries(r102);
        }

        public static RegenDirection[] values() {
            return (RegenDirection[]) f350615a.clone();
        }

        public static RegenDirection valueOf(String r100) {
            return (RegenDirection) r27.a.a(RegenDirection.class, r100);
        }

        public RegenDirection(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes30.dex */
    public static final class a {
        public static void b(String r100, String r101, IIMCallback r102) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            Intrinsics.checkNotNullParameter(r101, "messageId");
            Intrinsics.checkNotNullParameter(r102, "callback");
            CoroutineExtKt.b(new IMessageService$loadFullMessage$1(r102, null));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void c(NativeMessageServiceImpl r100, String r101, MessageStatus r102, String r110, Map r111, int r112) {
            if ((r112 & 16) == 0) goto L5;
            r111 = null;
        L5:
            r100.y(r101, r102, r110, 3, r111, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(NativeMessageServiceImpl r100, String r101, List r102, boolean r110, boolean r111, boolean r112, IIMCallback r113, int r114) {
            if ((r114 & 16) == 0) goto L5;
            boolean r103 = false;
        L7:
            if ((r114 & 32) == 0) goto L9;
            r113 = null;
        L9:
            r100.h(r101, r102, r110, r111, r103, r113);
            return;
        L5:
            r103 = r112;
            goto L7
        }
    }

    void addMessage(yc9.f0 r100, IIMCallback<Message> r101);

    void addMessageConcatObserver(nf9.a r100);

    void batchAddMessage(List<yc9.f0> r100, IIMCallback<List<Message>> r101);

    void batchSendMessage(List<yc9.f0> r100, IIMCallback<List<Message>> r101);

    void getMessageListFromLocal(MessageListRequest r100, IIMCallback<List<Message>> r101);

    void getSendSuccessImageMessageList(long r100, long r101, IIMCallback<List<Message>> r102);

    void modifyMessageContent(yc9.e0 r100, IIMCallback<List<Message>> r101);

    void regenMessage(com.larus.im.internal.core.message.r r100, IIMCallback<Boolean> r101);

    void registerOnGlobalMessageObserver(nf9.b r100);

    void registerOnMessageChangedObserver(String r100, nf9.b r101);

    void registerOnThreadGlobalMessageObserver(nf9.d r100);

    void registerOnThreadMessageChangedObserver(String r100, nf9.d r101);

    void requestSubMessage(Message r100, int r101, Map<String, String> r102, IIMCallback<Boolean> r103);

    void searchMessageByFts(FtsSearchParam r100, IIMCallback<FtsSearchResult<Message>> r101);

    void sendMessage(yc9.f0 r100, IIMCallback<Message> r101);

    void unregisterOnGlobalMessageObserver(nf9.b r100);

    void unregisterOnMessageChangedObserver(String r100, nf9.b r101);

    void unregisterOnThreadMessageChangedObserver(String r100, nf9.d r101);
}
