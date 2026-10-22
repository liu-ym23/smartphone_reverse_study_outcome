package com.bytedance.applet.event;

import com.larus.bmhome.chat.api.WidgetRenderDelegate;
import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.event.EventDispatcher$onMessageListChanged$1", f = "EventDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EventDispatcher$onMessageListChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cid;
    final /* synthetic */ List<Message> $msgList;
    final /* synthetic */ MessageListState $state;
    int label;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MessageListState.values().length];
            r0[MessageListState.UPDATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MessageListState.INSERT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MessageListState.DELETE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MessageListState.REFRESH_ALL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public EventDispatcher$onMessageListChanged$1(MessageListState r1, List<Message> r2, String r3, Continuation<? super EventDispatcher$onMessageListChanged$1> r4) {
        this.$state = r1;
        this.$msgList = r2;
        this.$cid = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new EventDispatcher$onMessageListChanged$1(this.$state, this.$msgList, this.$cid, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L30;
        ResultKt.throwOnFailure(r3);
        MessageListState r4 = this.$state;
        int r5 = a.a[r4.ordinal()];
        if (r5 != 1) goto L7;
    L23:
        List<Message> r6 = this.$msgList;
        String r0 = this.$cid;
        Iterator<T> r7 = r6.iterator();
    L25:
        if (r7.hasNext() == false) goto L28;
        EventDispatcher.i(r0, (Message) r7.next());
    L28:
        return Unit.INSTANCE;
    L7:
        if (r5 == 2) goto L23;
        if (r5 != 3) goto L11;
        List<Message> r8 = this.$msgList;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L17:
        if (r9.hasNext() == false) goto L22;
        String r2 = ((Message) r9.next()).getMessageId();
        if (r2 != null) goto L21;
        r2 = "";
    L21:
        r1.add(r2);
        goto L17
    L22:
        WidgetRenderDelegate.a.j(r1);
        goto L28
    L11:
        if (r5 == 4) goto L28;
        throw new NoWhenBranchMatchedException();
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
