package com.larus.im.internal.core;

import com.larus.im.bean.message.Message;
import com.larus.im.internal.core.conversation.converter.WriteCvsInfo2EntityFrom;
import com.larus.im.internal.core.message.RemoteMessageListHandler;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.database.utils.OmniDatabaseExtKt;
import com.larus.im.internal.protocol.bean.ConversationInfo;
import com.larus.im.internal.protocol.bean.MessageBody;
import com.larus.im.internal.stream.PendingHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
public final class IMHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IMHandler f347513a = null;

    /* JADX INFO: loaded from: classes29.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/im/internal/core/IMHandler$LocalMessageHandleStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "MIGRATE", "DELETE", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LocalMessageHandleStrategy extends Enum<LocalMessageHandleStrategy> {
        public static final LocalMessageHandleStrategy DELETE = null;
        public static final LocalMessageHandleStrategy MIGRATE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LocalMessageHandleStrategy[] f347514a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f347515b = null;

        public static EnumEntries<LocalMessageHandleStrategy> getEntries() {
            return f347515b;
        }

        static {
            LocalMessageHandleStrategy r100 = new LocalMessageHandleStrategy("MIGRATE", 0);
            MIGRATE = r100;
            LocalMessageHandleStrategy r101 = new LocalMessageHandleStrategy("DELETE", 1);
            DELETE = r101;
            LocalMessageHandleStrategy[] r102 = {r100, r101};
            f347514a = r102;
            f347515b = EnumEntriesKt.enumEntries(r102);
        }

        public static LocalMessageHandleStrategy[] values() {
            return (LocalMessageHandleStrategy[]) f347514a.clone();
        }

        public static LocalMessageHandleStrategy valueOf(String r100) {
            return (LocalMessageHandleStrategy) r27.a.a(LocalMessageHandleStrategy.class, r100);
        }

        public LocalMessageHandleStrategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f347513a = new IMHandler();
    }

    public IMHandler() {
    }

    public static Object a(String r100, Continuation r101) {
        Object r102 = OmniDatabaseExtKt.e(new IMHandler$deleteConversation$2(r100, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public static Object b(String r100, Continuation r101) {
        Object r102 = OmniDatabaseExtKt.e(new IMHandler$deleteConversationByBotId$2(r100, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public static Object e(String r100, Continuation r101) {
        return OmniDatabaseExtKt.e(new IMHandler$softDeleteConversation$2(r100, null), r101);
    }

    public final Object c(String r100, List<MessageBody> r101, Map<String, MessageBody> r110, Function2<? super List<MessageEntity>, ? super Continuation<? super Unit>, ? extends Object> r111, Continuation<? super List<Message>> r112) {
        if ((r112 instanceof IMHandler$handleRemoteMessageList$1) == false) goto L7;
        IMHandler$handleRemoteMessageList$1 r102 = (IMHandler$handleRemoteMessageList$1) r112;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        IMHandler$handleRemoteMessageList$1 r104 = r102;
        Object r113 = r104.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r110 = (Map) r104.L$2;
        r101 = (List) r104.L$1;
        r100 = (String) r104.L$0;
        ResultKt.throwOnFailure(r113);
    L27:
        List r114 = (List) r113;
        com.larus.im.internal.delegate.a r115 = com.larus.im.internal.delegate.a.f348188b;
        StringBuilder r107 = new StringBuilder("handleRemoteMessageList, from:");
        r107.append(r100);
        r107.append(",msgSize:");
        if (r101 != null) goto L30;
        r101 = CollectionsKt.emptyList();
    L30:
        r107.append(r101.size());
        r107.append(",regenSize:");
        if (r110 != null) goto L33;
        r110 = MapsKt.emptyMap();
    L33:
        r107.append(r110.size());
        r107.append(", resultSize:");
        r107.append(r114.size());
        r115.i("IMHandler", r107.toString());
        return r114;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if (r101 == null) goto L23;
        ArrayList r108 = new ArrayList();
        Iterator<T> r116 = r101.iterator();
    L18:
        if (r116.hasNext() == false) goto L22;
        Object r109 = r116.next();
        PendingHandler r117 = PendingHandler.f350084a;
        if ((!PendingHandler.d(((MessageBody) r109).messageId)) == false) goto L18;
        r108.add(r109);
        goto L18
    L22:
        ArrayList r118 = r108;
    L24:
        RemoteMessageListHandler r119 = RemoteMessageListHandler.f347763a;
        r104.L$0 = r100;
        r104.L$1 = r101;
        r104.L$2 = r110;
        r104.label = 1;
        r113 = r119.b(r100, r118, r110, r111, r104);
        if (r113 != r105) goto L27;
        return r105;
    L23:
        r118 = null;
    L7:
        r102 = new IMHandler$handleRemoteMessageList$1(this, r112);
        goto L8
    }

    public static Object d(String r110, String r111, ConversationInfo r112, List r113, LocalMessageHandleStrategy r114, WriteCvsInfo2EntityFrom r115, Continuation r116) {
        Object r100 = OmniDatabaseExtKt.e(new IMHandler$replaceOrCreateConversation$2(false, r110, r112, r115, r114, r111, r113, null), r116);
        if (r100 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r100;
    L6:
        return Unit.INSTANCE;
    }
}
