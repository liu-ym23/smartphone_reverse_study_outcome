package com.larus.im.internal.core.message;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageListRequest;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IMError;
import com.larus.im.internal.core.IMActionProcessor;
import com.larus.im.internal.core.message.converter.MessageEntityConverterKt;
import com.larus.im.internal.database.delegate.MessageDaoSource;
import com.larus.im.internal.database.entity.MessageEntity;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
public final class LocalMessageProcessor extends IMActionProcessor<MessageListRequest, List<? extends Message>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f347750b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f347751a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.message.LocalMessageProcessor$process$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.message.LocalMessageProcessor$process$1", f = "LocalMessageProcessor.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LocalMessageProcessor this$0;

        public AnonymousClass1(LocalMessageProcessor r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
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
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            LocalMessageProcessor r103 = this.this$0;
            int r104 = LocalMessageProcessor.f347750b;
            String r105 = r103.getRequest().getConversationId();
            if (this.this$0.getRequest().getMaxIndex() != Long.MAX_VALUE) goto L11;
            boolean r106 = true;
        L12:
            this.label = 1;
            if (LocalMessageProcessor.c(r103, r105, r106, this) != r101) goto L16;
            return r101;
        L11:
            r106 = false;
            goto L12
        }
    }

    static {
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final void process() {
        BuildersKt.launch$default(getScope(), null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final String getTAG() {
        return this.f347751a;
    }

    public LocalMessageProcessor(MessageListRequest r100, IIMCallback<List<Message>> r101) {
        Intrinsics.checkNotNullParameter(r100, "msgListReq");
        super(r100, r101);
        this.f347751a = "LocalMessageProcessor";
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00ff -> B:42:0x0100). Please report as a decompilation issue!!! */
    public static final Object c(LocalMessageProcessor r110, String r111, boolean r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof LocalMessageProcessor$getMessageList$1) == false) goto L7;
        LocalMessageProcessor$getMessageList$1 r100 = (LocalMessageProcessor$getMessageList$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        Collection r115 = (Collection) r100.L$3;
        LocalMessageProcessor r116 = (LocalMessageProcessor) r100.L$2;
        Iterator r117 = (Iterator) r100.L$1;
        Collection r104 = (Collection) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L42:
        r115.add((Message) r114);
        r115 = r104;
    L37:
        if (r117.hasNext() == false) goto L43;
        MessageEntity r118 = (MessageEntity) r117.next();
        r100.L$0 = r115;
        r100.L$1 = r117;
        r100.L$2 = r116;
        r100.L$3 = r115;
        r100.label = 2;
        r114 = MessageEntityConverterKt.a(r118, r100);
        if (r114 == r102) goto L47;
        r104 = r115;
        goto L42
    L47:
        return r102;
    L43:
        r116.onSuccess((List) r115);
    L45:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r111 = (String) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L32:
        List r119 = (List) r114;
        if (r119 != null) goto L35;
        r110.onFailure(new IMError(-17, "Invalid conversation id to get db info.[cid=" + r111 + ']', null, null, 12, null));
        goto L45
    L35:
        List r120 = r119;
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r120, 10));
        r117 = r120.iterator();
        r116 = r110;
        r115 = r121;
        goto L37
    L16:
        ResultKt.throwOnFailure(r114);
        long r105 = r110.getRequest().getMaxIndex();
        r100.L$0 = r111;
        r100.label = 1;
        int r122 = r110.getRequest().getMessageLimit();
        if (r122 > 0) goto L19;
        int r106 = 20;
    L20:
        if (r112 == false) goto L25;
        Object r123 = ((MessageDaoSource) ae9.e.a()).v(r111, r106, false, r100);
        if (r123 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        r123 = (List) r123;
    L29:
        r114 = r123;
        if (r114 != r102) goto L32;
        return r102;
    L25:
        r123 = ((MessageDaoSource) ae9.e.a()).S(r111, r105, r106, false, r100);
        if (r123 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        r123 = (List) r123;
        goto L29
    L19:
        r106 = r122;
    L7:
        r100 = new LocalMessageProcessor$getMessageList$1(r110, r113);
        goto L8
    }
}
