package com.larus.im.internal.core.conversation.check;

import androidx.collection.LruCache;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageListRequest;
import com.larus.im.internal.database.entity.ConversationEntity;
import com.larus.im.internal.protocol.bean.ConsistencyUplinkBody;
import com.larus.im.internal.protocol.bean.MessageListReport;
import com.larus.im.internal.protocol.bean.MessageReportInfo;
import com.larus.im.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.check.MessageCheckManager$check$1", f = "MessageCheckManager.kt", i = {0, 0, 0}, l = {42}, m = "invokeSuspend", n = {"cvsId", "firstServerMsg", "cvsType"}, s = {"L$0", "L$1", "I$0"})
public final class MessageCheckManager$check$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Message> $list;
    final /* synthetic */ MessageListRequest $request;
    int I$0;
    Object L$0;
    Object L$1;
    int label;

    public MessageCheckManager$check$1(MessageListRequest r100, List<Message> r101, Continuation<? super MessageCheckManager$check$1> r102) {
        this.$request = r100;
        this.$list = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MessageCheckManager$check$1(this.$request, this.$list, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MessageCheckManager$check$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        int r102 = this.I$0;
        Message r103 = (Message) this.L$1;
        String r104 = (String) this.L$0;
        ResultKt.throwOnFailure(r110);
        String r105 = r104;
        Object r106 = r110;
    L54:
        ConversationEntity r107 = (ConversationEntity) r106;
        if (r107 == null) goto L80;
        Long r108 = r107.getLatestMessageIndex();
        if (r108 == null) goto L80;
        if (r103.getServerIndex() > (r108.longValue() - ((long) ((Number) d.f347575c.getValue()).intValue()))) goto L78;
        LruCache<String, Boolean> r109 = MessageCheckManager.f347569a;
        List<Message> r111 = this.$list;
        ArrayList r112 = new ArrayList();
        Iterator<T> r113 = r111.iterator();
    L62:
        if (r113.hasNext() == false) goto L67;
        Object r114 = r113.next();
        if (com.larus.im.bean.message.a.s0((Message) r114) == false) goto L62;
        r112.add(r114);
        goto L62
    L67:
        if (r112.isEmpty() == false) goto L69;
        com.larus.im.internal.delegate.a.f348188b.w("MessageCheckManager", "disable or list is null, skip");
        goto L78
    L69:
        MessageListReport r115 = new MessageListReport(null, null, null, null, null, null, 63, null);
        r115.conversationId = r105;
        r115.conversationType = Integer.valueOf(r102);
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator r117 = r112.iterator();
    L71:
        if (r117.hasNext() == false) goto L76;
        Message r118 = (Message) r117.next();
        String r119 = r118.getMessageId();
        if (r119 != null) goto L75;
        r119 = "";
    L75:
        r116.add(new MessageReportInfo(r119, Long.valueOf(r118.getServerIndex())));
        goto L71
    L76:
        r115.messageReportList = r116;
        r115.latestMsgIndex = Long.valueOf(((Message) CollectionsKt.first(r112)).getServerIndex());
        r115.startIndex = Long.valueOf(((Message) CollectionsKt.last(r112)).getServerIndex());
        r115.endIndex = Long.valueOf(((Message) CollectionsKt.first(r112)).getServerIndex());
        int r120 = ReportCheckResultProcessor.f347570c;
        ReportCheckResultProcessor.a.a("checkMore", new ConsistencyUplinkBody(r115));
    L78:
        return Unit.INSTANCE;
    L80:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        String r121 = this.$request.getConversationId();
        if (this.$request.getMaxIndex() != Long.MAX_VALUE) goto L11;
        boolean r122 = true;
    L12:
        LruCache<String, Boolean> r123 = MessageCheckManager.f347569a;
        if (((Boolean) d.f347574b.getValue()).booleanValue() == true) goto L16;
        com.larus.im.internal.delegate.a.f348188b.w("MessageCheckManager", "cvsId:" + r121 + ", disable, skip");
    L31:
        boolean r124 = true;
    L33:
        if (r124 == true) goto L35;
        int r125 = this.$request.getConversationType();
        List<Message> r126 = this.$list;
        if (r126 == null) goto L82;
        Iterator<T> r127 = r126.iterator();
    L40:
        if (r127.hasNext() == false) goto L44;
        Object r128 = r127.next();
        if (com.larus.im.bean.message.a.s0((Message) r128) == false) goto L40;
    L45:
        Message r129 = (Message) r128;
        if (r129 == null) goto L82;
        if (r122 == false) goto L50;
        LruCache<String, Boolean> r130 = MessageCheckManager.f347569a;
        MessageListReport r131 = new MessageListReport(null, null, null, null, null, null, 63, null);
        r131.conversationId = r121;
        r131.conversationType = Integer.valueOf(r125);
        r131.latestMsgIndex = Long.valueOf(r129.getServerIndex());
        int r132 = ReportCheckResultProcessor.f347570c;
        ReportCheckResultProcessor.a.a("checkLatest", new ConsistencyUplinkBody(r131));
        goto L78
    L50:
        be9.b r133 = ae9.b.a();
        this.L$0 = r121;
        this.L$1 = r129;
        this.I$0 = r125;
        this.label = 1;
        r106 = be9.b.C0295b.a(r133, r121, 0, this, 6);
        if (r106 != r100) goto L53;
        return r100;
    L53:
        r105 = r121;
        r102 = r125;
        r103 = r129;
        goto L54
    L44:
        r128 = null;
    L82:
        return Unit.INSTANCE;
    L35:
        return Unit.INSTANCE;
    L16:
        if (com.larus.im.internal.delegate.b.f348193b.e() == false) goto L19;
        com.larus.im.internal.delegate.a.f348188b.w("MessageCheckManager", "cvsId:" + r121 + ", check is tourist mode, skip");
        goto L31
    L19:
        if (j.f(r121) == false) goto L21;
        com.larus.im.internal.delegate.a.f348188b.w("MessageCheckManager", "cvsId:" + r121 + ", local cvs, skip");
        goto L31
    L21:
        LruCache<String, Boolean> r134 = MessageCheckManager.f347569a;
        Boolean r135 = r134.get(r121);
        Boolean r136 = Boolean.TRUE;
        if (Intrinsics.areEqual(r135, r136) == false) goto L24;
        com.larus.im.internal.delegate.a.f348188b.w("MessageCheckManager", "cvsId:" + r121 + ", has checked, skip");
        goto L31
    L24:
        if (r122 == true) goto L26;
    L32:
        r124 = false;
        goto L33
    L26:
        if (r134.get(r121) != null) goto L29;
        r134.put(r121, Boolean.FALSE);
        goto L32
    L29:
        if (Intrinsics.areEqual(r134.get(r121), Boolean.FALSE) == false) goto L32;
        r134.put(r121, r136);
        goto L31
    L11:
        r122 = false;
        goto L12
    }
}
