package com.larus.im.internal.memory.cache;

import androidx.collection.LruCache;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.internal.database.delegate.MessageDaoSource;
import com.larus.im.internal.database.entity.MessageEntity;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class MessageCache extends MemoryCache<List<? extends MessageEntity>> implements be9.d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f348955m = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MessageDaoSource f348956j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f348957k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LruCache<String, String> f348958l;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.im.internal.memory.cache.MemoryCache
    public final Object N(String r100, Continuation<? super List<? extends MessageEntity>> r101) {
        return null;
    }

    @Override // com.larus.im.internal.memory.cache.MemoryCache
    public final int S() {
        Iterator r100 = this.f348952g.snapshot().values().iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + ((List) r100.next()).size();
        goto L4
    L6:
        return r101;
    }

    public MessageCache(int r100) {
        super(r100);
        be9.d.f18789c.getClass();
        this.f348956j = new MessageDaoSource();
        Lazy r101 = com.larus.im.internal.memory.c.f348938a;
        int r102 = com.larus.im.internal.memory.c.a().f348587e;
        this.f348957k = r102;
        this.f348958l = new LruCache((r100 * r102) * 3);
    }

    public static String g0(String r100) {
        return "queryLen=" + r100.length() + ", queryHash=" + r100.hashCode();
    }

    @Override // com.larus.im.internal.memory.cache.MemoryCache
    public final String M(List<? extends MessageEntity> r100) {
        List<? extends MessageEntity> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        MessageEntity r102 = (MessageEntity) CollectionsKt.firstOrNull(r101);
        if (r102 == null) goto L5;
        String r103 = r102.getConversationId();
    L6:
        if (r103 != null) goto L9;
        return "";
    L9:
        return r103;
    L5:
        r103 = null;
        goto L6
    }

    public final MessageEntity b0(String r100) {
        List<? extends MessageEntity> r101 = K(j0(r100));
        Object r102 = null;
        if (r101 == null) goto L23;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L17;
        Object r104 = r103.next();
        MessageEntity r105 = (MessageEntity) r104;
        if (Intrinsics.areEqual(r105.getLocalMessageId(), r100) == false) goto L10;
    L13:
        boolean r106 = true;
    L14:
        if (r106 == false) goto L6;
        r102 = r104;
        goto L17
    L10:
        if (Intrinsics.areEqual(r105.getMessageId(), r100) == true) goto L13;
        r106 = false;
    L17:
        return (MessageEntity) r102;
    L23:
        return null;
    }

    public final List<MessageEntity> d0(String r100) {
        List<? extends MessageEntity> r101 = K(r100);
        if (r101 == null) goto L10;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L17;
        Object r104 = r103.next();
        if (com.larus.im.internal.database.utils.k.n((MessageEntity) r104) == false) goto L6;
        r102.add(r104);
        goto L6
    L17:
        return r102;
    L10:
        return null;
    }

    public final void f0(MessageEntity r100) {
        String r101 = r100.getConversationId();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return;
    L11:
        String r104 = r100.getLocalMessageId();
        if (r104.length() <= 0) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == false) goto L17;
        this.f348958l.put(r104, r101);
    L17:
        String r106 = r100.getMessageId();
        if (r106 != null) goto L20;
    L21:
        r102 = true;
    L22:
        if (r102 == true) goto L25;
        this.f348958l.put(r106, r101);
        return;
    L25:
        return;
    L20:
        if (r106.length() != 0) goto L22;
    L14:
        r105 = false;
        goto L15
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public final String j0(String r100) {
        String r101 = this.f348958l.get(r100);
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    public static final MessageEntity Z(MessageCache r100, String r101) {
        List<MessageEntity> r102 = r100.d0(r101);
        if (r102 == null) goto L20;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L14;
        Object r105 = r104.next();
        String r106 = ((MessageEntity) r105).getTags();
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        if (StringsKt.contains$default(r106, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, false, 2, null) == true) goto L6;
        r103.add(r105);
        goto L6
    L14:
        return (MessageEntity) CollectionsKt.firstOrNull(r103);
    L20:
        return null;
    }

    @Override // be9.d
    public final Object A(String r100, Continuation<? super MessageEntity> r101) {
        return W(new MessageCache$getMessageByLocalId$2(this, r100, null), r101);
    }

    @Override // be9.d
    public final Object C(String r100, Continuation<? super MessageEntity> r101) {
        return W(new MessageCache$getLastLocalMessage$2(this, r100, null), r101);
    }

    @Override // be9.d
    public final Object H(String r100, Continuation<? super Integer> r101) {
        return W(new MessageCache$deleteMessageByConversationId$2(this, r100, null), r101);
    }

    @Override // com.larus.im.internal.memory.cache.MemoryCache
    public final Object U(Function1<? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super Unit> r101) {
        Object r102 = r100.invoke(r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Override // be9.d
    public final Object a(String r100, Continuation<? super MessageEntity> r101) {
        return W(new MessageCache$getMessageById$2(this, r100, null), r101);
    }

    @Override // be9.d
    public final Object b(List<String> r100, Continuation<? super List<MessageEntity>> r101) {
        return W(new MessageCache$getVisibleMessageListById$2(this, r100, null), r101);
    }

    public final void e0(List r100, MessageEntity r110) {
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((MessageEntity) r102).getLocalMessageId(), r110.getLocalMessageId()) == false) goto L4;
    L9:
        MessageEntity r103 = (MessageEntity) r102;
        if (r103 == null) goto L15;
        int r104 = r100.indexOf(r103);
        if (r104 < 0) goto L31;
        ListProtector.set(r100, r104, r110);
    L31:
        if (r100.size() <= this.f348957k) goto L39;
        ListProtector.remove(r100, CollectionsKt.getLastIndex(r100));
        return;
    L39:
        return;
    L15:
        if (r100.isEmpty() == false) goto L17;
        r100.add(r110);
        goto L31
    L17:
        Iterator r105 = r100.iterator();
        int r106 = 0;
    L19:
        if (r105.hasNext() == false) goto L27;
        if (((MessageEntity) r105.next()).getLocalIndex() >= r110.getLocalIndex()) goto L23;
        boolean r107 = true;
    L24:
        if (r107 == true) goto L28;
        r106 = r106 + 1;
    L28:
        if (r106 < 0) goto L31;
        ListProtector.add(r100, r106, r110);
        goto L31
    L23:
        r107 = false;
        goto L24
    L27:
        r106 = -1;
        goto L28
    L8:
        r102 = null;
        goto L9
    }

    @Override // be9.d
    public final Object h(List<String> r100, Continuation<? super List<MessageEntity>> r101) {
        return W(new MessageCache$getMessagesByMessageIds$2(this, r100, null), r101);
    }

    public final Object i0(String r100, Continuation<? super Unit> r101) {
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        final MessageEntity r103 = b0(r100);
        if (r103 == null) goto L20;
        String r104 = r103.getConversationId();
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        Object r105 = update(r104, new o(r103), r101);
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r105;
    L18:
        return Unit.INSTANCE;
    L20:
        return Unit.INSTANCE;
    L8:
        return Unit.INSTANCE;
    L5:
        r102 = false;
        goto L6
    }

    @Override // be9.d
    public final Object o(List<String> r100, Continuation<? super Integer> r101) {
        return W(new MessageCache$deleteMessageByCvsIds$2(this, r100, null), r101);
    }

    @Override // be9.d
    public final Object z(int r100, Continuation<? super List<MessageEntity>> r101) {
        return W(new MessageCache$getMessageByStatus$2(this, r100, null), r101);
    }

    public static final Object X(final MessageCache r100, final MessageEntity r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof MessageCache$addOrUpdate$1) == false) goto L7;
        MessageCache$addOrUpdate$1 r103 = (MessageCache$addOrUpdate$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = (MessageEntity) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L20:
        r100.f0(r101);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        String r108 = r101.getConversationId();
        if (r108 != null) goto L17;
        r108 = "";
    L17:
        Function1 r109 = new n(r100, r101);
        r103.L$0 = r101;
        r103.label = 1;
        if (r100.update(r108, r109, r103) != r106) goto L20;
        return r106;
    L7:
        r103 = new MessageCache$addOrUpdate$1(r100, r102);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00a9 -> B:32:0x00ac). Please report as a decompilation issue!!! */
    public static final Object Y(final MessageCache r100, List r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof MessageCache$addOrUpdate$3) == false) goto L7;
        MessageCache$addOrUpdate$3 r103 = (MessageCache$addOrUpdate$3) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        final Map.Entry r108 = (Map.Entry) r103.L$1;
        Iterator r109 = (Iterator) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L32:
        Iterator r110 = ((List) r108.getValue()).iterator();
    L34:
        if (r110.hasNext() == false) goto L28;
        r100.f0((MessageEntity) r110.next());
    L28:
        if (r109.hasNext() == false) goto L37;
        r108 = (Map.Entry) r109.next();
        String r111 = (String) r108.getKey();
        Function1 r112 = new m(r100, r108);
        r103.L$0 = r109;
        r103.L$1 = r108;
        r103.label = 1;
        if (r100.update(r111, r112, r103) != r106) goto L32;
        return r106;
    L37:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        LinkedHashMap r113 = new LinkedHashMap();
        Iterator r114 = r101.iterator();
    L16:
        if (r114.hasNext() == false) goto L26;
        MessageEntity r115 = (MessageEntity) r114.next();
        String r116 = r115.getConversationId();
        if (r116 != null) goto L21;
        r116 = "";
    L21:
        if (r113.containsKey(r116) == true) goto L23;
        r113.put(r116, new ArrayList());
    L23:
        List r117 = (List) r113.get(r116);
        if (r117 == null) goto L16;
        Boxing.boxBoolean(r117.add(r115));
        goto L16
    L26:
        r109 = r113.entrySet().iterator();
    L7:
        r103 = new MessageCache$addOrUpdate$3(r100, r102);
        goto L8
    }

    @Override // be9.d
    public final Object D(String r100, int r101, Continuation<? super Integer> r102) {
        return W(new MessageCache$updateLocalStatus$2(this, r100, r101, null), r102);
    }

    public final Object h0(String r100, final Function1<? super MessageEntity, Boolean> r101, Continuation<? super Unit> r110) {
        if ((r110 instanceof MessageCache$removeAllMessage$1) == false) goto L7;
        MessageCache$removeAllMessage$1 r102 = (MessageCache$removeAllMessage$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        Iterator r106 = (Iterator) r102.L$1;
        r101 = (Function1) r102.L$0;
        ResultKt.throwOnFailure(r111);
    L28:
        if (r106.hasNext() == false) goto L46;
        List r112 = (List) r106.next();
        Iterator r107 = r112.iterator();
    L30:
        String r108 = null;
        if (r107.hasNext() == false) goto L35;
        Object r109 = r107.next();
        if (r101.invoke(r109).booleanValue() == false) goto L30;
    L36:
        if (r109 == null) goto L28;
        Intrinsics.checkNotNullParameter(r112, "<this>");
        MessageEntity r113 = (MessageEntity) CollectionsKt.firstOrNull(r112);
        if (r113 == null) goto L40;
        r108 = r113.getConversationId();
    L40:
        if (r108 != null) goto L42;
        r108 = "";
    L42:
        Function1 r114 = new l(r101);
        r102.L$0 = r101;
        r102.L$1 = r106;
        r102.label = 2;
        if (update(r108, r114, r102) != r104) goto L28;
        return r104;
    L35:
        r109 = null;
        goto L36
    L46:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
    L25:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r111);
        if (r100.length() <= 0) goto L19;
        boolean r115 = true;
    L20:
        if (r115 == false) goto L26;
        Function1 r116 = new k(r101);
        r102.label = 1;
        if (update(r100, r116, r102) != r104) goto L25;
        return r104;
    L26:
        r106 = this.f348952g.snapshot().values().iterator();
        goto L28
    L19:
        r115 = false;
    L7:
        r102 = new MessageCache$removeAllMessage$1(this, r110);
        goto L8
    }

    @Override // be9.d
    public final Object i(String r100, String r101, Continuation<? super List<MessageEntity>> r102) {
        return W(new MessageCache$getMessageListByQuestionId$2(this, r100, r101, null), r102);
    }

    @Override // be9.d
    public final Object r(String r100, int r101, Continuation<? super Integer> r102) {
        return W(new MessageCache$updateServerStatus$2(this, r100, r101, null), r102);
    }

    @Override // be9.d
    public final Object x(String r100, boolean r101, Continuation<? super Integer> r102) {
        return W(new MessageCache$updateRegenVisible$2(this, r100, r101, null), r102);
    }

    public static final Object a0(final MessageCache r100, String r101, Function1 r102, Continuation r103) {
        r100.getClass();
        if ((r103 instanceof MessageCache$updateMessage$1) == false) goto L7;
        MessageCache$updateMessage$1 r104 = (MessageCache$updateMessage$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L16;
        if (r108 == 1) goto L15;
        if (r108 != 2) goto L14;
        final MessageEntity r109 = (MessageEntity) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L36:
        r100.f0(r109);
    L38:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r109 = (MessageEntity) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L30:
        String r110 = r109.getConversationId();
        if (r110 != null) goto L33;
        r110 = "";
    L33:
        Function1 r111 = new j(r100, r109);
        r104.L$0 = r109;
        r104.label = 2;
        if (r100.update(r110, r111, r104) != r107) goto L36;
        return r107;
    L16:
        ResultKt.throwOnFailure(r106);
        if (r101.length() != 0) goto L19;
        boolean r112 = true;
    L20:
        if (r112 == true) goto L39;
        MessageEntity r113 = r100.b0(r101);
        if (r113 == null) goto L38;
        MessageEntity r114 = (MessageEntity) r102.invoke(r113);
        if (Intrinsics.areEqual(r114.getConversationId(), r113.getConversationId()) == true) goto L29;
        r104.L$0 = r114;
        r104.label = 1;
        if (r100.i0(r101, r104) != r107) goto L29;
        return r107;
    L29:
        r109 = r114;
        goto L30
    L39:
        return Unit.INSTANCE;
    L19:
        r112 = false;
    L7:
        r104 = new MessageCache$updateMessage$1(r100, r103);
        goto L8
    }

    public final Object c0(String r110, int r111, boolean r112, Continuation<? super List<MessageEntity>> r113) {
        if ((r113 instanceof MessageCache$getLatestMessageListEnsureVisible$1) == false) goto L7;
        MessageCache$getLatestMessageListEnsureVisible$1 r100 = (MessageCache$getLatestMessageListEnsureVisible$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L15;
        if (r103 != 1) goto L14;
        ResultKt.throwOnFailure(r114);     // Catch: Throwable -> L24
    L30:
        return r114;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r114);
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L24
        if (r112 == false) goto L19;
        boolean r104 = true;
    L20:
        MessageCache$getLatestMessageListEnsureVisible$2$1 r116 = new MessageCache$getLatestMessageListEnsureVisible$2$1(this, r110, r111, r104, null);     // Catch: Throwable -> L24
        r100.label = 1;     // Catch: Throwable -> L24
        r114 = W(r116, r100);     // Catch: Throwable -> L24
        if (r114 != r102) goto L30;
        return r102;
    L19:
        r104 = false;
    L24:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Object r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 == null) goto L33;
        O("getLatestMessageListEnsureVisible error: " + r119.getMessage(), "");
        return CollectionsKt.emptyList();
    L33:
        return r118;
    L7:
        r100 = new MessageCache$getLatestMessageListEnsureVisible$1(this, r113);
        goto L8
    }
}
