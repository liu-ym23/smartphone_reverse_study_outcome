package com.larus.im.internal.core.message.utils;

import com.larus.im.bean.message.Message;
import com.larus.im.internal.core.message.converter.MessageEntityConverterKt;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.jni.observer.OmniMessageDispatcherKt;
import com.larus.im.observer.MessageListState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

/* JADX INFO: loaded from: classes4.dex */
public final class MessageDispatcher implements nf9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MessageDispatcher f347838a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final vt7.a<String, Set<nf9.b>> f347839b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final vt7.b<nf9.b> f347840c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final vt7.a<String, Set<nf9.d>> f347841d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final vt7.b<nf9.d> f347842e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final vt7.b<String> f347843f = null;

    /* JADX INFO: renamed from: com.larus.im.internal.core.message.utils.MessageDispatcher$onMessageListReplaced$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes29.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.message.utils.MessageDispatcher$onMessageListReplaced$1", f = "MessageDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $cid;
        final /* synthetic */ List<Message> $newMsgList;
        final /* synthetic */ List<Message> $oldMsgList;
        int label;

        public AnonymousClass1(List<Message> r100, String r101, List<Message> r102, Continuation<? super AnonymousClass1> r103) {
            this.$newMsgList = r100;
            this.$cid = r101;
            this.$oldMsgList = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$newMsgList, this.$cid, this.$oldMsgList, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L39;
            ResultKt.throwOnFailure(r100);
            Message r101 = (Message) CollectionsKt.firstOrNull(this.$newMsgList);
            boolean r102 = false;
            if (r101 != null) goto L7;
        L9:
            if (r102 == false) goto L26;
            Message r103 = (Message) CollectionsKt.firstOrNull(this.$newMsgList);
            if (r103 == null) goto L13;
            String r104 = r103.getThreadId();
        L14:
            if (r104 != null) goto L16;
            r104 = "";
        L16:
            Set<nf9.d> r105 = MessageDispatcher.f347841d.get(r104);
            if (r105 == null) goto L22;
            List<Message> r106 = this.$oldMsgList;
            List<Message> r107 = this.$newMsgList;
            Iterator<T> r108 = r105.iterator();
        L20:
            if (r108.hasNext() == false) goto L22;
            ((nf9.d) r108.next()).onMessageListReplaced(r104, r106, r107);
        L22:
            vt7.b<nf9.d> r109 = MessageDispatcher.f347842e;
            List<Message> r110 = this.$oldMsgList;
            List<Message> r111 = this.$newMsgList;
            Iterator<nf9.d> r112 = r109.iterator();
        L24:
            if (r112.hasNext() == false) goto L37;
            r112.next().onMessageListReplaced(r104, r110, r111);
        L37:
            return Unit.INSTANCE;
        L13:
            r104 = null;
            goto L14
        L26:
            Set<nf9.b> r113 = MessageDispatcher.f347839b.get(this.$cid);
            if (r113 == null) goto L32;
            String r114 = this.$cid;
            List<Message> r115 = this.$oldMsgList;
            List<Message> r116 = this.$newMsgList;
            Iterator<T> r117 = r113.iterator();
        L30:
            if (r117.hasNext() == false) goto L32;
            ((nf9.b) r117.next()).onMessageListReplaced(r114, r115, r116);
        L32:
            vt7.b<nf9.b> r118 = MessageDispatcher.f347840c;
            String r119 = this.$cid;
            List<Message> r120 = this.$oldMsgList;
            List<Message> r121 = this.$newMsgList;
            Iterator<nf9.b> r122 = r118.iterator();
        L34:
            if (r122.hasNext() == false) goto L37;
            r122.next().onMessageListReplaced(r119, r120, r121);
            goto L34
        L7:
            if (com.larus.im.bean.message.a.D0(r101) != true) goto L9;
            r102 = true;
            goto L9
        L39:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MessageDispatcher() {
    }

    static {
        f347838a = new MessageDispatcher();
        OmniMessageDispatcherKt.GetOmniMessageDispatcher().registerGlobal(new OmniMessageObserverInterceptor());
        f347839b = new vt7.a();
        f347840c = new vt7.b();
        f347841d = new vt7.a();
        f347842e = new vt7.b();
        f347843f = new vt7.b();
    }

    public static void i(List r100) {
        Intrinsics.checkNotNullParameter(r100, "msgIds");
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = (String) r101.next();
        f347843f.remove(r102);
        goto L4
    }

    @Override // nf9.b
    public final void a(String r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "msg");
        com.larus.im.internal.database.utils.e.d(new MessageDispatcher$onSendMessage$1(r101, r100, null));
    }

    @Override // nf9.b
    public final void d(String r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "msg");
        com.larus.im.internal.database.utils.e.d(new MessageDispatcher$onRegenMessage$1(r101, r100, null));
    }

    @Override // nf9.b
    public final void f(String r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (com.larus.im.bean.message.a.y0(r101) == false) goto L5;
        return;
    L5:
        if (com.larus.im.bean.message.a.x0(r101) == true) goto L10;
        com.larus.im.internal.database.utils.e.d(new MessageDispatcher$onMessageInvisible$1(r101, r100, null));
        return;
    }

    public static final Object g(MessageDispatcher r100, Message r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof MessageDispatcher$transformToParent$1) == false) goto L7;
        MessageDispatcher$transformToParent$1 r103 = (MessageDispatcher$transformToParent$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L17;
        if (r107 == 1) goto L16;
        if (r107 != 2) goto L15;
        ResultKt.throwOnFailure(r105);
    L35:
        return r105;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r101 = (Message) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L29:
        MessageEntity r108 = (MessageEntity) r105;
        if (r108 == null) goto L38;
        r103.L$0 = null;
        r103.label = 2;
        r105 = MessageEntityConverterKt.a(r108, r103);
        if (r105 != r106) goto L35;
    L36:
        return r106;
    L38:
        return r101;
    L17:
        ResultKt.throwOnFailure(r105);
        String r109 = com.larus.im.bean.message.a.D(r101);
        if (r109 != null) goto L20;
    L23:
        boolean r110 = true;
    L24:
        if (r110 == true) goto L37;
        be9.d r111 = ae9.e.a();
        r103.L$0 = r101;
        r103.label = 1;
        r105 = r111.a(r109, r103);
        if (r105 != r106) goto L29;
    L37:
        return r101;
    L20:
        if (r109.length() == 0) goto L23;
        r110 = false;
    L7:
        r103 = new MessageDispatcher$transformToParent$1(r100, r102);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x012e -> B:53:0x0132). Please report as a decompilation issue!!! */
    public static final Object h(MessageDispatcher r100, List r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof MessageDispatcher$transformToParent$2) == false) goto L7;
        MessageDispatcher$transformToParent$2 r101 = (MessageDispatcher$transformToParent$2) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        Collection r113 = (Collection) r101.L$5;
        Iterator r105 = (Iterator) r101.L$4;
        Collection r106 = (Collection) r101.L$3;
        List r107 = (List) r101.L$2;
        List r108 = (List) r101.L$1;
        List r109 = (List) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L53:
        r113.add((Message) r103);
        Object r114 = r112;
        r113 = r106;
        List r115 = r109;
    L48:
        if (r105.hasNext() == false) goto L54;
        MessageEntity r116 = (MessageEntity) r105.next();
        r101.L$0 = r115;
        r101.L$1 = r108;
        r101.L$2 = r107;
        r101.L$3 = r113;
        r101.L$4 = r105;
        r101.L$5 = r113;
        r101.label = 2;
        Object r117 = MessageEntityConverterKt.a(r116, r101);
        if (r117 == r114) goto L87;
        r109 = r115;
        r112 = r114;
        r103 = r117;
        r106 = r113;
        goto L53
    L87:
        return r114;
    L54:
        r107.addAll((List) r113);
        List r118 = r115;
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        Iterator r120 = r118.iterator();
    L56:
        if (r120.hasNext() == false) goto L58;
        r119.add(((Message) r120.next()).getMessageId());
        goto L56
    L58:
        ArrayList r121 = new ArrayList();
        Iterator r122 = r108.iterator();
    L60:
        if (r122.hasNext() == false) goto L64;
        Object r123 = r122.next();
        if (r119.contains(((Message) r123).getMessageId()) == true) goto L60;
        r121.add(r123);
        goto L60
    L64:
        r115.addAll(r121);
        return r115;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        List r124 = (List) r101.L$1;
        List r125 = (List) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L46:
        List r126 = (List) r103;
        ArrayList r127 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r126, 10));
        r108 = r124;
        r107 = r125;
        r113 = r127;
        r105 = r126.iterator();
        r114 = r112;
        r115 = r107;
        goto L48
    L16:
        ResultKt.throwOnFailure(r103);
        r125 = new ArrayList();
        List r128 = r110;
        ArrayList r129 = new ArrayList();
        Iterator r130 = r128.iterator();
    L18:
        if (r130.hasNext() == false) goto L22;
        String r131 = com.larus.im.bean.message.a.D((Message) r130.next());
        if (r131 == null) goto L18;
        r129.add(r131);
        goto L18
    L22:
        ArrayList r132 = new ArrayList();
        Iterator r133 = r129.iterator();
    L23:
        boolean r134 = false;
        if (r133.hasNext() == false) goto L30;
        Object r135 = r133.next();
        if (((String) r135).length() <= 0) goto L28;
        r134 = true;
    L28:
        if (r134 == false) goto L23;
        r132.add(r135);
        goto L23
    L30:
        Set r136 = CollectionsKt.toSet(r132);
        ArrayList r137 = new ArrayList();
        Iterator r138 = r128.iterator();
    L32:
        if (r138.hasNext() == false) goto L42;
        Object r139 = r138.next();
        String r140 = com.larus.im.bean.message.a.D((Message) r139);
        if (r140 != null) goto L36;
    L39:
        boolean r141 = true;
    L40:
        if (r141 == false) goto L32;
        r137.add(r139);
        goto L32
    L36:
        if (r140.length() == 0) goto L39;
        r141 = false;
        goto L40
    L42:
        be9.d r142 = ae9.e.a();
        List<String> r143 = CollectionsKt.toList(r136);
        r101.L$0 = r125;
        r101.L$1 = r137;
        r101.label = 1;
        r103 = r142.h(r143, r101);
        if (r103 == r112) goto L88;
        r124 = r137;
        goto L46
    L88:
        return r112;
    L7:
        r101 = new MessageDispatcher$transformToParent$2(r100, r111);
        goto L8
    }

    @Override // nf9.b
    public final void b(String r100, MessageListState r101, List<Message> r110) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r110, "msgList");
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r110.iterator();
    L4:
        if (r103.hasNext() == false) goto L14;
        Object r104 = r103.next();
        Message r105 = (Message) r104;
        if (com.larus.im.bean.message.a.y0(r105) == false) goto L8;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == true) goto L4;
        r102.add(r104);
        goto L4
    L8:
        if (com.larus.im.bean.message.a.x0(r105) == true) goto L11;
        r106 = false;
        goto L12
    L14:
        com.larus.im.internal.database.utils.e.d(new MessageDispatcher$onMessageListChanged$1(r101, r110, r102, r100, null));
    }

    @Override // nf9.b
    public final void c(String r100, Message r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "msg");
        com.larus.im.internal.database.utils.e.d(new MessageDispatcher$onUpdateMessage$1(r101, r100, r102, null));
    }

    @Override // nf9.b
    public final void e(String r100, Message r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (com.larus.im.bean.message.a.y0(r101) == false) goto L5;
        return;
    L5:
        if (com.larus.im.bean.message.a.x0(r101) == true) goto L10;
        com.larus.im.internal.database.utils.e.d(new MessageDispatcher$onReceiveMessage$1(r101, r100, r102, null));
        return;
    }

    @Override // nf9.b
    public final void onMessageListReplaced(String r100, List<Message> r101, List<Message> r102) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "oldMsgList");
        Intrinsics.checkNotNullParameter(r102, "newMsgList");
        com.larus.im.internal.database.utils.e.d(new AnonymousClass1(r102, r100, r101, null));
    }
}
