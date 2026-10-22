package com.larus.im.internal.core.message;

import com.larus.im.bean.message.ClientControllerParam;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.callback.IMError;
import com.larus.im.internal.core.IMActionProcessor;
import com.larus.im.internal.core.message.converter.MessageEntityConverterKt;
import com.larus.im.internal.core.message.utils.MessageDispatcher;
import com.larus.im.internal.database.delegate.MessageDaoSource;
import com.larus.im.internal.database.entity.ConversationEntity;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.database.utils.OmniDatabaseExtKt;
import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.protocol.bean.RegenQuestionGroup;
import com.larus.im.internal.protocol.bean.RegenerateMsgUplinkBody;
import com.larus.im.observer.MessageListState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
public final class RegenMessageProcessor extends IMActionProcessor<r, Boolean> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f347759d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque<Integer> f347760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<MessageEntity> f347761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f347762c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.message.RegenMessageProcessor$process$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.message.RegenMessageProcessor$process$1", f = "RegenMessageProcessor.kt", i = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 9}, l = {67, 76, 86, 103, 106, 110, 115, 116, 170, 178}, m = "invokeSuspend", n = {"message", "message", com.bytedance.android.ec.core.event.a.VALUE_QUESTION, "message", com.bytedance.android.ec.core.event.a.VALUE_QUESTION, "conversation", "message", com.bytedance.android.ec.core.event.a.VALUE_QUESTION, "conversation", "collectionId", "message", com.bytedance.android.ec.core.event.a.VALUE_QUESTION, "conversation", "collectionId", "sameCollectionMessage", "message", com.bytedance.android.ec.core.event.a.VALUE_QUESTION, "conversation", "collectionId", "sameCollectionMessage", "message", com.bytedance.android.ec.core.event.a.VALUE_QUESTION, "conversation", "collectionId", "sameCollectionMessage", "result"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $conversationId;
        final /* synthetic */ String $messageId;
        final /* synthetic */ String $replyId;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        final /* synthetic */ RegenMessageProcessor this$0;

        /* JADX INFO: renamed from: com.larus.im.internal.core.message.RegenMessageProcessor$process$1$a */
        public static final class a<T> implements Comparator {
            public a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T r100, T r101) {
                return ComparisonsKt.compareValues(Long.valueOf(((MessageEntity) r100).getLocalIndex()), Long.valueOf(((MessageEntity) r101).getLocalIndex()));
            }
        }

        public AnonymousClass1(String r100, RegenMessageProcessor r101, String r102, String r103, Continuation<? super AnonymousClass1> r104) {
            this.$messageId = r100;
            this.this$0 = r101;
            this.$replyId = r102;
            this.$conversationId = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$messageId, this.this$0, this.$replyId, this.$conversationId, r101);
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
        public final Object invokeSuspend(Object r310) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            String r101 = "";
            boolean r102 = true;
            switch(this.label) {
                case 0: goto L16;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                case 10: goto L6;
                default: goto L5;
            };
        L6:
            com.larus.im.internal.network.e r103 = (com.larus.im.internal.network.e) this.L$0;
            ResultKt.throwOnFailure(r310);
        L162:
            RegenMessageProcessor r104 = this.this$0;
            IIMError r105 = r103.a();
            int r106 = RegenMessageProcessor.f347759d;
            r104.onFailure(r105);
        L164:
            return Unit.INSTANCE;
        L7:
            ResultKt.throwOnFailure(r310);
            Object r107 = r310;
        L146:
            com.larus.im.internal.network.e r108 = (com.larus.im.internal.network.e) r107;
            if ((r108 instanceof com.larus.im.internal.network.e.f) == false) goto L150;
            RegenMessageProcessor r109 = this.this$0;
            int r110 = RegenMessageProcessor.f347759d;
            r109.onSuccess(Boolean.TRUE);
            goto L164
        L150:
            if (RegenMessageProcessor.c(this.this$0).f347810a.getContentType() != 6) goto L152;
        L160:
            com.larus.im.internal.delegate.a.f348188b.i(this.this$0.f347762c, "skip recover.");
        L161:
            r103 = r108;
            goto L162
        L152:
            if (com.larus.im.bean.message.a.E(RegenMessageProcessor.c(this.this$0).f347810a) == true) goto L160;
            RegenMessageProcessor r111 = this.this$0;
            String r112 = RegenMessageProcessor.c(r111).f347810a.getConversationId();
            if (r112 == null) goto L157;
            r101 = r112;
        L157:
            this.L$0 = r108;
            this.label = 10;
            if (RegenMessageProcessor.d(r111, r101, this) != r100) goto L161;
            return r100;
        L8:
            List r113 = (List) this.L$4;
            String r114 = (String) this.L$3;
            ConversationEntity r115 = (ConversationEntity) this.L$2;
            MessageEntity r116 = (MessageEntity) this.L$1;
            MessageEntity r117 = (MessageEntity) this.L$0;
            ResultKt.throwOnFailure(r310);
            MessageEntity r118 = r117;
            ConversationEntity r119 = r115;
            List r120 = r113;
            Object r121 = r310;
        L81:
            long r122 = ((Number) r121).longValue();
            if (r120.size() > 1) goto L110;
            String r123 = this.$conversationId;
            Integer r124 = r119.getConversationType();
            if (r124 == null) goto L86;
            int r125 = r124.intValue();
        L87:
            String r210 = r116.getMessageId();
            if (com.larus.im.internal.database.utils.k.e(r118) != 6) goto L90;
        L93:
            boolean r211 = true;
        L94:
            RegenQuestionGroup r212 = null;
            Map<String, String> r126 = RegenMessageProcessor.c(this.this$0).f347813d;
            Map<String, String> r127 = RegenMessageProcessor.c(this.this$0).f347814e;
            String r213 = null;
            String r128 = RegenMessageProcessor.c(this.this$0).f347811b;
            ClientControllerParam r129 = RegenMessageProcessor.c(this.this$0).f347812c;
            if (r129 == null) goto L97;
            r102 = r129.answerWithSuggest;
        L97:
            ClientControllerParam r130 = RegenMessageProcessor.c(this.this$0).f347812c;
            if (r130 == null) goto L100;
            String r131 = r130.languageCode;
        L101:
            ClientControllerParam r132 = RegenMessageProcessor.c(this.this$0).f347812c;
            if (r132 == null) goto L104;
            String r133 = r132.voiceId;
        L105:
            ClientControllerParam r134 = RegenMessageProcessor.c(this.this$0).f347812c;
            if (r134 == null) goto L108;
            String r135 = r134.nickname;
        L109:
            RegenerateMsgUplinkBody r136 = new RegenerateMsgUplinkBody(r123, r125, r210, r211, r212, r126, r127, r213, r128, new com.larus.im.internal.protocol.bean.ClientControllerParam(r102, r131, r133, r135), new com.larus.im.internal.protocol.bean.a(r119.getLastSectionId(), Boxing.boxLong(r122)), 144, null);
        L143:
            RegenMessageProcessor r137 = this.this$0;
            RegenMessageProcessor$process$1$result$1 r138 = new RegenMessageProcessor$process$1$result$1(r136, null);
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.label = 9;
            r107 = r137.requestServer(r138, this);
            if (r107 != r100) goto L146;
            return r100;
        L108:
            r135 = null;
            goto L109
        L104:
            r133 = null;
            goto L105
        L100:
            r131 = null;
            goto L101
        L90:
            if (com.larus.im.bean.message.a.E(RegenMessageProcessor.c(this.this$0).f347810a) == true) goto L93;
            r211 = false;
            goto L94
        L86:
            r125 = 0;
            goto L87
        L110:
            List r139 = CollectionsKt.sortedWith(r120, new a());
            ArrayList r140 = new ArrayList();
            Iterator r141 = r139.iterator();
        L112:
            if (r141.hasNext() == false) goto L116;
            String r142 = ((MessageEntity) r141.next()).getMessageId();
            if (r142 == null) goto L112;
            r140.add(r142);
            goto L112
        L116:
            RegenQuestionGroup r143 = new RegenQuestionGroup(r114, r140);
            String r144 = this.$conversationId;
            Integer r145 = r119.getConversationType();
            if (r145 == null) goto L119;
            int r146 = r145.intValue();
        L120:
            String r214 = null;
            if (com.larus.im.internal.database.utils.k.e(r118) != 6) goto L123;
        L126:
            boolean r215 = true;
        L127:
            Map<String, String> r147 = RegenMessageProcessor.c(this.this$0).f347813d;
            Map<String, String> r148 = RegenMessageProcessor.c(this.this$0).f347814e;
            String r216 = null;
            String r149 = RegenMessageProcessor.c(this.this$0).f347811b;
            ClientControllerParam r150 = RegenMessageProcessor.c(this.this$0).f347812c;
            if (r150 == null) goto L130;
            r102 = r150.answerWithSuggest;
        L130:
            ClientControllerParam r151 = RegenMessageProcessor.c(this.this$0).f347812c;
            if (r151 == null) goto L133;
            String r152 = r151.languageCode;
        L134:
            ClientControllerParam r153 = RegenMessageProcessor.c(this.this$0).f347812c;
            if (r153 == null) goto L137;
            String r154 = r153.voiceId;
        L138:
            ClientControllerParam r155 = RegenMessageProcessor.c(this.this$0).f347812c;
            if (r155 == null) goto L141;
            String r156 = r155.nickname;
        L142:
            r136 = new RegenerateMsgUplinkBody(r144, r146, r214, r215, r143, r147, r148, r216, r149, new com.larus.im.internal.protocol.bean.ClientControllerParam(r102, r152, r154, r156), new com.larus.im.internal.protocol.bean.a(r119.getLastSectionId(), Boxing.boxLong(r122)), 132, null);
            goto L143
        L141:
            r156 = null;
            goto L142
        L137:
            r154 = null;
            goto L138
        L133:
            r152 = null;
            goto L134
        L123:
            if (com.larus.im.bean.message.a.E(RegenMessageProcessor.c(this.this$0).f347810a) == true) goto L126;
            r215 = false;
            goto L127
        L119:
            r146 = 0;
            goto L120
        L9:
            String r157 = (String) this.L$6;
            MessageDispatcher r158 = (MessageDispatcher) this.L$5;
            List r159 = (List) this.L$4;
            String r160 = (String) this.L$3;
            r119 = (ConversationEntity) this.L$2;
            MessageEntity r161 = (MessageEntity) this.L$1;
            r118 = (MessageEntity) this.L$0;
            ResultKt.throwOnFailure(r310);
            Object r162 = r310;
            List r163 = r159;
        L77:
            r158.d(r157, (Message) r162);
            be9.d r164 = ae9.e.a();
            String r165 = this.$conversationId;
            this.L$0 = r118;
            this.L$1 = r161;
            this.L$2 = r119;
            this.L$3 = r160;
            this.L$4 = r163;
            this.L$5 = null;
            this.L$6 = null;
            this.label = 8;
            r121 = ((MessageDaoSource) r164).B(r165, this);
            if (r121 != r100) goto L80;
            return r100;
        L80:
            r114 = r160;
            r116 = r161;
            r120 = r163;
            goto L81
        L10:
            List r166 = (List) this.L$4;
            String r167 = (String) this.L$3;
            ConversationEntity r168 = (ConversationEntity) this.L$2;
            MessageEntity r169 = (MessageEntity) this.L$1;
            MessageEntity r170 = (MessageEntity) this.L$0;
            ResultKt.throwOnFailure(r310);
            List r171 = r166;
        L71:
            List r172 = r171;
            MessageEntity r173 = r170;
        L73:
            MessageDispatcher r174 = MessageDispatcher.f347838a;
            String r175 = this.$conversationId;
            this.L$0 = r173;
            this.L$1 = r169;
            this.L$2 = r168;
            this.L$3 = r167;
            this.L$4 = r172;
            this.L$5 = r174;
            this.L$6 = r175;
            this.label = 7;
            r162 = MessageEntityConverterKt.a(r169, this);
            if (r162 != r100) goto L76;
            return r100;
        L76:
            r118 = r173;
            r157 = r175;
            MessageEntity r311 = r169;
            r160 = r167;
            r158 = r174;
            r119 = r168;
            r163 = r172;
            r161 = r311;
            goto L77
        L11:
            String r176 = (String) this.L$3;
            ConversationEntity r177 = (ConversationEntity) this.L$2;
            MessageEntity r178 = (MessageEntity) this.L$1;
            MessageEntity r179 = (MessageEntity) this.L$0;
            ResultKt.throwOnFailure(r310);
            Object r180 = r310;
            r167 = r176;
            r173 = r179;
            r169 = r178;
            r168 = r177;
        L54:
            ArrayList r181 = new ArrayList();
            Iterator r182 = ((Iterable) r180).iterator();
        L56:
            if (r182.hasNext() == false) goto L61;
            Object r183 = r182.next();
            if (com.larus.im.internal.database.utils.o.a((MessageEntity) r183) == false) goto L56;
            r181.add(r183);
            goto L56
        L61:
            if (RegenMessageProcessor.c(this.this$0).f347810a.getContentType() != 6) goto L63;
        L72:
            com.larus.im.internal.delegate.a.f348188b.i(this.this$0.f347762c, "skip remove.");
            r172 = r181;
            goto L73
        L63:
            if (com.larus.im.bean.message.a.E(RegenMessageProcessor.c(this.this$0).f347810a) == true) goto L72;
            RegenMessageProcessor r184 = this.this$0;
            String r185 = this.$conversationId;
            String r186 = r169.getMessageId();
            if (r186 != null) goto L67;
            r186 = "";
        L67:
            this.L$0 = r173;
            this.L$1 = r169;
            this.L$2 = r168;
            this.L$3 = r167;
            this.L$4 = r181;
            this.label = 6;
            if (RegenMessageProcessor.e(r184, r185, r186, this) != r100) goto L70;
            return r100;
        L70:
            r170 = r173;
            r171 = r181;
            goto L71
        L12:
            ConversationEntity r187 = (ConversationEntity) this.L$2;
            MessageEntity r188 = (MessageEntity) this.L$1;
            MessageEntity r189 = (MessageEntity) this.L$0;
            ResultKt.throwOnFailure(r310);
            MessageEntity r190 = r189;
            MessageEntity r191 = r188;
            Object r192 = r310;
        L50:
            r167 = com.larus.im.bean.message.a.g((Message) r192);
            be9.d r193 = ae9.e.a();
            String r194 = this.$conversationId;
            this.L$0 = r190;
            this.L$1 = r191;
            this.L$2 = r187;
            this.L$3 = r167;
            this.label = 5;
            r180 = ((MessageDaoSource) r193).K(r194, r167, this);
            if (r180 != r100) goto L53;
            return r100;
        L53:
            MessageEntity r312 = r191;
            r168 = r187;
            r173 = r190;
            r169 = r312;
            goto L54
        L13:
            MessageEntity r195 = (MessageEntity) this.L$1;
            MessageEntity r196 = (MessageEntity) this.L$0;
            ResultKt.throwOnFailure(r310);
            Object r197 = r310;
        L34:
            ConversationEntity r198 = (ConversationEntity) r197;
            if (r198 != null) goto L38;
            RegenMessageProcessor r199 = this.this$0;
            IMError r200 = new IMError(-17, "Cannot find conversation by conversation_id(" + this.$conversationId + ").", null, null, 12, null);
            int r201 = RegenMessageProcessor.f347759d;
            r199.onFailure(r200);
            return Unit.INSTANCE;
        L38:
            Integer r202 = r196.getRegenIndex();
            if (r202 == null) goto L41;
            int r203 = r202.intValue();
        L43:
            if (r203 < y0.i().b("message_regen_max_count", 10)) goto L46;
            RegenMessageProcessor r204 = this.this$0;
            IMError r205 = new IMError(-15, null, null, null, 14, null);
            int r206 = RegenMessageProcessor.f347759d;
            r204.onFailure(r205);
            return Unit.INSTANCE;
        L46:
            this.L$0 = r196;
            this.L$1 = r195;
            this.L$2 = r198;
            this.label = 4;
            r192 = MessageEntityConverterKt.a(r195, this);
            if (r192 != r100) goto L49;
            return r100;
        L49:
            MessageEntity r313 = r196;
            r191 = r195;
            r187 = r198;
            r190 = r313;
            goto L50
        L41:
            r203 = 0;
            goto L43
        L14:
            MessageEntity r207 = (MessageEntity) this.L$0;
            ResultKt.throwOnFailure(r310);
            Object r1100 = r310;
        L26:
            MessageEntity r1101 = (MessageEntity) r1100;
            if (r1101 != null) goto L30;
            RegenMessageProcessor r208 = this.this$0;
            IMError r209 = new IMError(-16, "Cannot find question by reply_id(" + this.$replyId + ").", null, null, 12, null);
            int r217 = RegenMessageProcessor.f347759d;
            r208.onFailure(r209);
            return Unit.INSTANCE;
        L30:
            be9.b r1102 = ae9.b.a();
            String r1103 = this.$conversationId;
            this.L$0 = r207;
            this.L$1 = r1101;
            this.label = 3;
            r197 = be9.b.C0295b.a(r1102, r1103, 0, this, 6);
            if (r197 != r100) goto L33;
            return r100;
        L33:
            r196 = r207;
            r195 = r1101;
            goto L34
        L15:
            ResultKt.throwOnFailure(r310);
            Object r218 = r310;
        L19:
            r207 = (MessageEntity) r218;
            if (r207 != null) goto L23;
            RegenMessageProcessor r219 = this.this$0;
            IMError r220 = new IMError(-16, "Cannot find message by message_id(" + this.$messageId + ").", null, null, 12, null);
            int r221 = RegenMessageProcessor.f347759d;
            r219.onFailure(r220);
            return Unit.INSTANCE;
        L23:
            be9.d r1104 = ae9.e.a();
            String r1105 = this.$replyId;
            this.L$0 = r207;
            this.label = 2;
            r1100 = ((MessageDaoSource) r1104).a(r1105, this);
            if (r1100 != r100) goto L26;
            return r100;
        L16:
            ResultKt.throwOnFailure(r310);
            be9.d r222 = ae9.e.a();
            String r1106 = this.$messageId;
            this.label = 1;
            r218 = ((MessageDaoSource) r222).a(r1106, this);
            if (r218 != r100) goto L19;
            return r100;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final void process() {
        String r100 = getRequest().f347810a.getMessageId();
        if (r100 != null) goto L5;
        String r101 = "";
    L6:
        String r102 = getRequest().f347810a.getReplyId();
        String r103 = getRequest().f347810a.getConversationId();
        if (r103 != null) goto L9;
        String r104 = "";
    L11:
        if (StringsKt.isBlank(r104) == false) goto L15;
        onFailure(new IMError(-2, "regen message\\'s conversation_id must not be Null or Blank.", null, null, 12, null));
        return;
    L15:
        if (StringsKt.isBlank(r101) == true) goto L26;
        if (r102 != null) goto L18;
    L21:
        boolean r105 = true;
    L22:
        if (r105 == true) goto L26;
        BuildersKt.launch$default(getScope(), null, null, new AnonymousClass1(r101, this, r102, r104, null), 3, null);
        return;
    L18:
        if (StringsKt.isBlank(r102) == true) goto L21;
        r105 = false;
    L26:
        onFailure(new IMError(-2, "regen message\\'s message_id and reply_id must not be Null or Blank.", null, null, 12, null));
        return;
    L9:
        r104 = r103;
        goto L11
    L5:
        r101 = r100;
        goto L6
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final String getTAG() {
        return this.f347762c;
    }

    public static final /* synthetic */ r c(RegenMessageProcessor r100) {
        return r100.getRequest();
    }

    public RegenMessageProcessor(r r100, IIMCallback<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        super(r100, r101);
        this.f347760a = new ArrayDeque();
        this.f347762c = "QueryLocalMessageProcessor";
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00e2 -> B:33:0x00e3). Please report as a decompilation issue!!! */
    public static final Object d(RegenMessageProcessor r100, String r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof RegenMessageProcessor$recoverCurrentReply$1) == false) goto L7;
        RegenMessageProcessor$recoverCurrentReply$1 r101 = (RegenMessageProcessor$recoverCurrentReply$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        Collection r105 = (Collection) r101.L$5;
        MessageListState r113 = (MessageListState) r101.L$4;
        String r106 = (String) r101.L$3;
        MessageDispatcher r107 = (MessageDispatcher) r101.L$2;
        Iterator r108 = (Iterator) r101.L$1;
        Collection r109 = (Collection) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L33:
        r105.add((Message) r112);
        r105 = r109;
    L28:
        if (r108.hasNext() == false) goto L34;
        MessageEntity r114 = (MessageEntity) r108.next();
        r101.L$0 = r105;
        r101.L$1 = r108;
        r101.L$2 = r107;
        r101.L$3 = r106;
        r101.L$4 = r113;
        r101.L$5 = r105;
        r101.label = 2;
        r112 = MessageEntityConverterKt.a(r114, r101);
        if (r112 == r103) goto L38;
        r109 = r105;
        goto L33
    L38:
        return r103;
    L34:
        r107.b(r106, r113, (List) r105);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        List<MessageEntity> r115 = (List) r101.L$1;
        r110 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L26:
        MessageDispatcher r116 = MessageDispatcher.f347838a;
        MessageListState r117 = MessageListState.UPDATE;
        List<MessageEntity> r118 = r115;
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        r108 = r118.iterator();
        r105 = r119;
        r107 = r116;
        r106 = r110;
        r113 = r117;
        goto L28
    L16:
        ResultKt.throwOnFailure(r112);
        List<MessageEntity> r120 = r100.f347761b;
        if (r120 != null) goto L20;
        r120 = CollectionsKt.emptyList();
    L20:
        if (r120.isEmpty() == true) goto L36;
        com.larus.im.internal.delegate.a.f348188b.i(r100.f347762c, "recover message, conversationId:" + r110 + ", replyList size: " + r120.size());
        RegenMessageProcessor$recoverCurrentReply$2 r121 = new RegenMessageProcessor$recoverCurrentReply$2(r120, r100, null);
        r101.L$0 = r110;
        r101.L$1 = r120;
        r101.label = 1;
        if (OmniDatabaseExtKt.e(r121, r101) == r103) goto L37;
        r115 = r120;
        goto L26
    L37:
        return r103;
    L36:
        return Unit.INSTANCE;
    L7:
        r101 = new RegenMessageProcessor$recoverCurrentReply$1(r100, r111);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0132 -> B:45:0x0133). Please report as a decompilation issue!!! */
    public static final Object e(RegenMessageProcessor r100, String r101, String r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof RegenMessageProcessor$removeCurrentReply$1) == false) goto L7;
        RegenMessageProcessor$removeCurrentReply$1 r102 = (RegenMessageProcessor$removeCurrentReply$1) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r112 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        Collection r106 = (Collection) r102.L$5;
        MessageListState r107 = (MessageListState) r102.L$4;
        String r113 = (String) r102.L$3;
        MessageDispatcher r108 = (MessageDispatcher) r102.L$2;
        Iterator r109 = (Iterator) r102.L$1;
        Collection r114 = (Collection) r102.L$0;
        ResultKt.throwOnFailure(r112);
    L45:
        r106.add((Message) r112);
        r106 = r114;
    L40:
        if (r109.hasNext() == false) goto L46;
        MessageEntity r115 = (MessageEntity) r109.next();
        r102.L$0 = r106;
        r102.L$1 = r109;
        r102.L$2 = r108;
        r102.L$3 = r113;
        r102.L$4 = r107;
        r102.L$5 = r106;
        r102.label = 3;
        r112 = MessageEntityConverterKt.a(r115, r102);
        if (r112 == r104) goto L56;
        r114 = r106;
        goto L45
    L56:
        return r104;
    L46:
        r108.b(r113, r107, (List) r106);
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        List<MessageEntity> r116 = (List) r102.L$1;
        String r117 = (String) r102.L$0;
        ResultKt.throwOnFailure(r112);
    L38:
        MessageDispatcher r118 = MessageDispatcher.f347838a;
        MessageListState r119 = MessageListState.DELETE;
        List<MessageEntity> r120 = r116;
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r120, 10));
        r109 = r120.iterator();
        r106 = r121;
        r108 = r118;
        r113 = r117;
        r107 = r119;
        goto L40
    L17:
        RegenMessageProcessor r122 = (RegenMessageProcessor) r102.L$2;
        r110 = (String) r102.L$1;
        String r123 = (String) r102.L$0;
        ResultKt.throwOnFailure(r112);
    L22:
        ArrayList r124 = new ArrayList();
        Iterator r125 = ((Iterable) r112).iterator();
    L24:
        if (r125.hasNext() == false) goto L28;
        Object r126 = r125.next();
        if (((MessageEntity) r126).getRegenVisible() == false) goto L24;
        r124.add(r126);
        goto L24
    L28:
        r122.f347761b = r124;
        List<MessageEntity> r127 = r100.f347761b;
        if (r127 != null) goto L32;
        r127 = CollectionsKt.emptyList();
    L32:
        if (r127.isEmpty() == true) goto L53;
        com.larus.im.internal.delegate.a.f348188b.i(r100.f347762c, "remove message, questionId:" + r110 + ", replyList size: " + r127.size());
        RegenMessageProcessor$removeCurrentReply$3 r128 = new RegenMessageProcessor$removeCurrentReply$3(r127, r100, null);
        r102.L$0 = r123;
        r102.L$1 = r127;
        r102.L$2 = null;
        r102.label = 2;
        if (OmniDatabaseExtKt.e(r128, r102) == r104) goto L55;
        r116 = r127;
        r117 = r123;
        goto L38
    L55:
        return r104;
    L53:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r112);
        be9.d r129 = ae9.e.a();
        r102.L$0 = r101;
        r102.L$1 = r110;
        r102.L$2 = r100;
        r102.label = 1;
        r112 = r129.i(r101, r110, r102);
        if (r112 == r104) goto L54;
        r123 = r101;
        r122 = r100;
        goto L22
    L54:
        return r104;
    L7:
        r102 = new RegenMessageProcessor$removeCurrentReply$1(r100, r111);
        goto L8
    }
}
