package com.larus.im.internal.core.message;

import androidx.collection.LruCache;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IMError;
import com.larus.im.internal.core.IMActionProcessor;
import com.larus.im.internal.database.delegate.MessageDaoSource;
import com.larus.im.internal.database.entity.ConversationEntity;
import com.larus.im.internal.jni.OmniSDKHelper;
import com.larus.im.internal.jni.bean.OmniRequestSubMessageRequest;
import com.larus.im.internal.protocol.bean.MixedTokens;
import com.larus.im.internal.protocol.bean.SendMessageAckDownlinkBody;
import com.larus.im.internal.protocol.bean.SendMessageUplinkBody;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes29.dex */
public final class RequestSubMessageProcessor extends IMActionProcessor<Message, Boolean> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final vt7.b<String> f347765d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LruCache<String, Integer> f347766e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final LruCache<String, Message> f347767f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f347768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f347769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f347770c;

    public static final class Companion {
        public Companion() {
        }

        public static void b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "questionId");
            Intrinsics.checkNotNullParameter(r101, "token");
            Message r102 = RequestSubMessageProcessor.f347767f.get(r100);
            if (r102 != null) goto L5;
            return;
        L5:
            Integer r103 = RequestSubMessageProcessor.f347766e.get(r101);
            if (r103 == null) goto L17;
            int r104 = r103.intValue();
            String r105 = r102.getMessageId();
            if (r105 != null) goto L10;
            String r106 = "";
        L11:
            String r107 = r102.getConversationId();
            if (r107 != null) goto L14;
            String r108 = "";
        L15:
            String r109 = r106 + '#' + r104;
            RequestSubMessageProcessor.f347765d.remove(r109);
            com.larus.im.internal.database.utils.e.c(new RequestSubMessageProcessor$Companion$onFirstPackageError$1(r109, r108, r106, r104, null));
            return;
        L14:
            r108 = r107;
            goto L15
        L10:
            r106 = r105;
            goto L11
        }

        public static final Object a(String r100, String r110, String r111, int r112, int r113, Continuation r114) {
            vt7.b<String> r101 = RequestSubMessageProcessor.f347765d;
            Object r102 = BuildersKt.withContext(Dispatchers.getIO(), new RequestSubMessageProcessor$Companion$updateSubMessageStatus$2(r111, r112, r100, r113, r110, null), r114);
            if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r102;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.message.RequestSubMessageProcessor$process$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.message.RequestSubMessageProcessor$process$1", f = "RequestSubMessageProcessor.kt", i = {0, 1, 1, 2, 2, 3, 4, 4}, l = {130, 142, 151, 165, 176}, m = "invokeSuspend", n = {"key", "key", "conversation", "key", "conversation", "key", "key", "result"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ RequestSubMessageProcessor this$0;

        public AnonymousClass1(RequestSubMessageProcessor r100, Continuation<? super AnonymousClass1> r101) {
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r410) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            String r110 = null;
            String r111 = "";
            if (r101 == 0) goto L17;
            if (r101 == 1) goto L15;
            if (r101 == 2) goto L14;
            if (r101 == 3) goto L13;
            if (r101 == 4) goto L12;
            if (r101 != 5) goto L11;
            com.larus.im.internal.network.e r102 = (com.larus.im.internal.network.e) this.L$1;
            String r103 = (String) this.L$0;
            ResultKt.throwOnFailure(r410);
        L94:
            com.larus.im.internal.delegate.a.f348188b.i(this.this$0.f347770c, "request sub message failed: key = " + r103 + ", code = " + r102.a().getCode() + ", tips = " + r102.a().getTips());
            this.this$0.onFailure(new IMError(r102.a().getCode(), r102.a().getTips(), r102.a().getException(), null, 8, null));
            Boxing.boxBoolean(RequestSubMessageProcessor.f347765d.remove(r103));
        L96:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            String r104 = (String) this.L$0;
            ResultKt.throwOnFailure(r410);
            String r105 = r104;
            Object r106 = r410;
        L73:
            com.larus.im.internal.network.e r112 = (com.larus.im.internal.network.e) r106;
            if ((r112 instanceof com.larus.im.internal.network.e.f) == false) goto L82;
            com.larus.im.internal.delegate.a.f348188b.i(this.this$0.f347770c, "request sub message success: key = " + r105);
            LruCache<String, Integer> r107 = RequestSubMessageProcessor.f347766e;
            MixedTokens r108 = ((SendMessageAckDownlinkBody) ((com.larus.im.internal.network.e.f) r112).f349185a).tokenMixed;
            if (r108 == null) goto L78;
            r110 = r108.sseToken;
        L78:
            if (r110 == null) goto L81;
            r111 = r110;
        L81:
            r107.put(r111, Boxing.boxInt(this.this$0.f347768a));
            this.this$0.onSuccess(Boolean.TRUE);
            goto L96
        L82:
            vt7.b<String> r109 = RequestSubMessageProcessor.f347765d;
            String r113 = RequestSubMessageProcessor.c(this.this$0).getConversationId();
            if (r113 != null) goto L85;
            String r114 = "";
        L86:
            String r115 = RequestSubMessageProcessor.c(this.this$0).getMessageId();
            if (r115 != null) goto L89;
            String r116 = "";
        L90:
            int r117 = this.this$0.f347768a;
            this.L$0 = r105;
            this.L$1 = r112;
            this.label = 5;
            if (Companion.a(r105, r114, r116, r117, 22, this) != r100) goto L93;
            return r100;
        L93:
            r103 = r105;
            r102 = r112;
            goto L94
        L89:
            r116 = r115;
            goto L90
        L85:
            r114 = r113;
            goto L86
        L13:
            ConversationEntity r118 = (ConversationEntity) this.L$1;
            String r119 = (String) this.L$0;
            ResultKt.throwOnFailure(r410);
            Object r120 = r410;
        L65:
            long r121 = ((Number) r120).longValue();
            String r122 = RequestSubMessageProcessor.c(this.this$0).getConversationId();
            Integer r123 = r118.getConversationType();
            if (r123 == null) goto L68;
            int r124 = r123.intValue();
        L69:
            String r210 = RequestSubMessageProcessor.c(this.this$0).getSenderId();
            SendMessageUplinkBody r125 = new SendMessageUplinkBody(r122, r124, com.larus.im.internal.delegate.b.f348193b.getUserId(), 1, "", null, this.this$0.f347769b, null, null, null, null, 0, null, r210, null, null, null, null, null, 0, null, RequestSubMessageProcessor.c(this.this$0).getMessageId() + '-' + this.this$0.f347768a, null, new com.larus.im.internal.protocol.bean.a(r118.getLastSectionId(), Boxing.boxLong(r121)), 6283168, null);
            RequestSubMessageProcessor r126 = this.this$0;
            RequestSubMessageProcessor$process$1$result$1 r127 = new RequestSubMessageProcessor$process$1$result$1(r125, null);
            this.L$0 = r119;
            this.L$1 = null;
            this.label = 4;
            r106 = r126.requestServer(r127, this);
            if (r106 != r100) goto L72;
            return r100;
        L72:
            r105 = r119;
            goto L73
        L68:
            r124 = 0;
            goto L69
        L14:
            r118 = (ConversationEntity) this.L$1;
            r119 = (String) this.L$0;
            ResultKt.throwOnFailure(r410);
        L59:
            be9.d r128 = ae9.e.a();
            String r129 = RequestSubMessageProcessor.c(this.this$0).getConversationId();
            if (r129 != null) goto L62;
            r129 = "";
        L62:
            this.L$0 = r119;
            this.L$1 = r118;
            this.label = 3;
            r120 = ((MessageDaoSource) r128).B(r129, this);
            if (r120 != r100) goto L65;
            return r100;
        L15:
            final String r130 = (String) this.L$0;
            ResultKt.throwOnFailure(r410);
            Object r131 = r410;
        L16:
            String r132 = r130;
            ConversationEntity r133 = (ConversationEntity) r131;
            if (r133 != null) goto L47;
            RequestSubMessageProcessor r134 = this.this$0;
            IMError r135 = new IMError(-17, "find conversation error", null, null, 12, null);
            vt7.b<String> r136 = RequestSubMessageProcessor.f347765d;
            r134.onFailure(r135);
            RequestSubMessageProcessor.f347765d.remove(r132);
            return Unit.INSTANCE;
        L47:
            com.larus.im.internal.delegate.a.f348188b.i(this.this$0.f347770c, "request sub message begin: key = " + r132);
            vt7.b<String> r137 = RequestSubMessageProcessor.f347765d;
            String r138 = RequestSubMessageProcessor.c(this.this$0).getConversationId();
            if (r138 != null) goto L50;
            String r139 = "";
        L51:
            String r140 = RequestSubMessageProcessor.c(this.this$0).getMessageId();
            if (r140 != null) goto L54;
            String r141 = "";
        L55:
            int r142 = this.this$0.f347768a;
            this.L$0 = r132;
            this.L$1 = r133;
            this.label = 2;
            if (Companion.a(r132, r139, r141, r142, 20, this) != r100) goto L58;
            return r100;
        L58:
            r119 = r132;
            r118 = r133;
            goto L59
        L54:
            r141 = r140;
            goto L55
        L50:
            r139 = r138;
            goto L51
        L17:
            ResultKt.throwOnFailure(r410);
            vt7.b<String> r143 = RequestSubMessageProcessor.f347765d;
            String r144 = RequestSubMessageProcessor.c(this.this$0).getMessageId();
            if (r144 != null) goto L20;
            r144 = "";
        L20:
            r130 = r144 + '#' + this.this$0.f347768a;
            vt7.b<String> r145 = RequestSubMessageProcessor.f347765d;
            if (r145.contains(r130) == false) goto L24;
            this.this$0.onFailure(new IMError(-104, "There is an ongoing identical request.", null, null, 12, null));
            return Unit.INSTANCE;
        L24:
            LruCache<String, Message> r146 = RequestSubMessageProcessor.f347767f;
            String r147 = RequestSubMessageProcessor.c(this.this$0).getReplyId();
            if (r147 != null) goto L27;
            r147 = "";
        L27:
            r146.put(r147, RequestSubMessageProcessor.c(this.this$0));
            r145.add(r130);
            Object r148 = com.larus.im.internal.core.message.utils.f.f347865a;
            String r149 = RequestSubMessageProcessor.c(this.this$0).getReplyId();
            if (r149 != null) goto L30;
            r149 = "";
        L30:
            Intrinsics.checkNotNullParameter(r149, "replyFor");
            vt7.b<String> r150 = com.larus.im.internal.core.message.utils.f.f347867c;
            r150.add(r149);
            if (r150.size() <= 100) goto L34;
            r150.remove(CollectionsKt.first(r150));
        L34:
            if (com.larus.im.bean.message.a.c0(RequestSubMessageProcessor.c(this.this$0)) == false) goto L37;
            com.larus.im.internal.delegate.a.f348188b.i(this.this$0.f347770c, "Parent Msg Id = " + RequestSubMessageProcessor.c(this.this$0).getMessageId() + " sub msg index = " + this.this$0.f347768a + " chat_next = 1");
            final RequestSubMessageProcessor r151 = this.this$0;
            r151.getClass();
            final OmniRequestSubMessageRequest r152 = new OmniRequestSubMessageRequest(r151.getRequest().getConversationId(), r151.getRequest().getSenderId(), r151.getRequest().getMessageId(), (long) r151.f347768a, r151.f347769b);
            OmniSDKHelper.getOmniSDK$default(OmniSDKHelper.INSTANCE, com.larus.im.internal.delegate.b.f348193b.getUserId(), false, 2, null).withMessageService(new s(r152, r151, r130));
            return Unit.INSTANCE;
        L37:
            be9.b r153 = ae9.b.a();
            String r154 = RequestSubMessageProcessor.c(this.this$0).getConversationId();
            if (r154 != null) goto L40;
            r154 = "";
        L40:
            this.L$0 = r130;
            this.label = 1;
            r131 = be9.b.C0295b.a(r153, r154, 0, this, 6);
            if (r131 != r100) goto L16;
            return r100;
        }
    }

    static {
        new Companion();
        f347765d = new vt7.b();
        f347766e = new LruCache(100);
        f347767f = new LruCache(100);
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final void process() {
        BuildersKt.launch$default(getScope(), null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final String getTAG() {
        return this.f347770c;
    }

    public static final /* synthetic */ Message c(RequestSubMessageProcessor r100) {
        return r100.getRequest();
    }

    public RequestSubMessageProcessor(Message r100, int r101, Map<String, String> r102, IIMCallback<Boolean> r103) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r102, "ext");
        super(r100, r103);
        this.f347768a = r101;
        this.f347769b = r102;
        this.f347770c = "RequestSubMessageProcessor";
    }
}
