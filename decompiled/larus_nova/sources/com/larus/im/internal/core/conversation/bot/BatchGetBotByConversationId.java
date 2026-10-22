package com.larus.im.internal.core.conversation.bot;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IMError;
import com.larus.im.internal.core.IMActionProcessor;
import com.larus.im.internal.database.delegate.BotDaoSource;
import com.larus.im.internal.database.delegate.ConversationDaoSource;
import com.larus.im.internal.database.delegate.ParticipantDaoSource;
import com.larus.im.internal.database.entity.BotEntity;
import com.larus.im.internal.database.entity.ConversationEntity;
import com.larus.im.internal.database.entity.ParticipantEntity;
import com.larus.im.internal.database.utils.OmniDatabaseExtKt;
import com.larus.im.internal.protocol.bean.BatchGetConversationInfoDownlinkBody;
import com.larus.im.internal.protocol.bean.ConversationInfo;
import com.larus.im.internal.protocol.model.BotBody;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
public final class BatchGetBotByConversationId extends IMActionProcessor<c, Map<String, ? extends List<? extends BotModel>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f347541a;

    /* JADX INFO: renamed from: com.larus.im.internal.core.conversation.bot.BatchGetBotByConversationId$process$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.conversation.bot.BatchGetBotByConversationId$process$1", f = "BatchGetBotByConversationId.kt", i = {0}, l = {86, 96}, m = "invokeSuspend", n = {"fetchInfo"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $conversationIdList;
        Object L$0;
        int label;
        final /* synthetic */ BatchGetBotByConversationId this$0;

        /* JADX INFO: renamed from: com.larus.im.internal.core.conversation.bot.BatchGetBotByConversationId$process$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.im.internal.core.conversation.bot.BatchGetBotByConversationId$process$1$1", f = "BatchGetBotByConversationId.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
        public static final class C43421 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ List<String> $conversationIdList;
            final /* synthetic */ Ref.ObjectRef<f> $fetchInfo;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ BatchGetBotByConversationId this$0;

            public C43421(List<String> r100, Ref.ObjectRef<f> r101, BatchGetBotByConversationId r102, Continuation<? super C43421> r103) {
                this.$conversationIdList = r100;
                this.$fetchInfo = r101;
                this.this$0 = r102;
                super(1, r103);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> r100) {
                return new C43421(this.$conversationIdList, this.$fetchInfo, this.this$0, r100);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
                return invoke2(r100);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Unit> r100) {
                return ((C43421) create(r100)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Type inference failed for: r9v9, types: [T, com.larus.im.internal.core.conversation.bot.f] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0054 -> B:15:0x0058). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r102 = this.label;
                if (r102 == 0) goto L8;
                if (r102 != 1) goto L7;
                f r103 = (f) this.L$2;
                Ref.ObjectRef<f> r104 = (Ref.ObjectRef) this.L$1;
                Iterator<String> r105 = (Iterator) this.L$0;
                ResultKt.throwOnFailure(r100);
                f r106 = r103;
                Object r107 = r101;
                C43421 r108 = this;
            L15:
                r104.element = b.a(r106, (f) r100);
                C43421 r109 = r108;
                r101 = r107;
            L10:
                if (r105.hasNext() == false) goto L17;
                String r110 = r105.next();
                r104 = r109.$fetchInfo;
                r106 = r104.element;
                BatchGetBotByConversationId r111 = r109.this$0;
                r109.L$0 = r105;
                r109.L$1 = r104;
                r109.L$2 = r106;
                r109.label = 1;
                Object r112 = BatchGetBotByConversationId.c(r111, r110, r109);
                if (r112 != r101) goto L14;
                return r101;
            L14:
                Object r113 = r101;
                r108 = r109;
                r100 = r112;
                r107 = r113;
                goto L15
            L17:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r100);
                r105 = this.$conversationIdList.iterator();
                r109 = this;
                goto L10
            }
        }

        public AnonymousClass1(BatchGetBotByConversationId r100, List<String> r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$conversationIdList = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$conversationIdList, r101);
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
        /* JADX WARN: Type inference failed for: r14v1, types: [T, com.larus.im.internal.core.conversation.bot.f] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            Set r102 = null;
            Object[] r103 = 0;
            if (r101 == 0) goto L10;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            ResultKt.throwOnFailure(r110);
        L24:
            Map r111 = (Map) r110;
            com.larus.im.internal.delegate.a r104 = com.larus.im.internal.delegate.a.f348188b;
            String r105 = this.this$0.f347541a;
            StringBuilder r106 = new StringBuilder("request result: ");
            LinkedHashMap r107 = new LinkedHashMap(MapsKt.mapCapacity(r111.size()));
            Iterator r108 = r111.entrySet().iterator();
        L26:
            if (r108.hasNext() == false) goto L32;
            Map.Entry r109 = (Map.Entry) r108.next();
            Object r112 = r109.getKey();
            Iterable r113 = (Iterable) r109.getValue();
            ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
            Iterator r115 = r113.iterator();
        L29:
            if (r115.hasNext() == false) goto L31;
            r114.add(((BotModel) r115.next()).getBotId());
            goto L29
        L31:
            r107.put(r112, r114);
            goto L26
        L32:
            r106.append(r107);
            r104.i(r105, r106.toString());
            this.this$0.onSuccess(r111);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Ref.ObjectRef r116 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r110);
        L13:
            com.larus.im.internal.delegate.a r117 = com.larus.im.internal.delegate.a.f348188b;
            String r118 = this.this$0.f347541a;
            StringBuilder r119 = new StringBuilder("fetch info, need fetch conv id set: ");
            r119.append(((f) r116.element).f347563a);
            r119.append(", \n conv available bot id set: ");
            Map<String, List<BotModel>> r120 = ((f) r116.element).f347565c;
            LinkedHashMap r121 = new LinkedHashMap(MapsKt.mapCapacity(r120.size()));
            Iterator<T> r122 = r120.entrySet().iterator();
        L15:
            if (r122.hasNext() == false) goto L21;
            Map.Entry r123 = (Map.Entry) r122.next();
            Object r124 = r123.getKey();
            Iterable r125 = (Iterable) r123.getValue();
            ArrayList r126 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r125, 10));
            Iterator r127 = r125.iterator();
        L18:
            if (r127.hasNext() == false) goto L20;
            r126.add(((BotModel) r127.next()).getBotId());
            goto L18
        L20:
            r121.put(r124, r126);
            goto L15
        L21:
            r119.append(r121);
            r119.append(" \n fetch info, need fetch bot id set: ");
            r119.append(((f) r116.element).f347564b);
            r117.i(r118, r119.toString());
            BatchGetBotByConversationId r128 = this.this$0;
            f r129 = (f) r116.element;
            this.L$0 = null;
            this.label = 2;
            r110 = BatchGetBotByConversationId.d(r128, r129, this);
            if (r110 != r100) goto L24;
            return r100;
        L10:
            ResultKt.throwOnFailure(r110);
            r116 = new Ref.ObjectRef();
            Object[] r130 = r103 == true ? 1 : 0;
            r116.element = new f(r102, r130, 7);
            C43421 r131 = new C43421(this.$conversationIdList, r116, this.this$0, null);
            this.L$0 = r116;
            this.label = 1;
            if (OmniDatabaseExtKt.e(r131, this) != r100) goto L13;
            return r100;
        }
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final void process() {
        List r100 = CollectionsKt.filterNotNull(getRequest().f347562a);
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Object r103 = r102.next();
        if ((!StringsKt.isBlank((String) r103)) == false) goto L4;
        r101.add(r103);
        goto L4
    L9:
        if (r101.isEmpty() == false) goto L12;
        com.larus.im.internal.delegate.a.f348188b.e(this.f347541a, "invalid request.");
        onFailure(new IMError(-2, null, null, null, 14, null));
        return;
    L12:
        BuildersKt.launch$default(getScope(), null, null, new AnonymousClass1(this, r101, null), 3, null);
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final String getTAG() {
        return this.f347541a;
    }

    public BatchGetBotByConversationId(c r100, IIMCallback<Map<String, List<BotModel>>> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        super(r100, r101);
        this.f347541a = "BatchGetBotByConversationId";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f g(String r100, List r101) {
        if (r101.isEmpty() == false) goto L6;
        Set r102 = null;
        Object[] r103 = 0 == true ? 1 : 0;
        return new f(r102, r103, 7);
    L6:
        List r104 = r101;
        ArrayList r105 = new ArrayList();
        Iterator r106 = r104.iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        Object r107 = r106.next();
        if (com.larus.im.internal.utils.e.a((BotModel) r107) == false) goto L8;
        r105.add(r107);
        goto L8
    L12:
        List r108 = zd9.e.a(r104, r105, new a());
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r110 = r105.iterator();
    L14:
        if (r110.hasNext() == false) goto L19;
        String r111 = ((BotModel) r110.next()).getBotId();
        if (r111 != null) goto L18;
        r111 = "";
    L18:
        r109.add(r111);
        goto L14
    L19:
        Map r112 = MapsKt.mapOf(TuplesKt.to(r100, CollectionsKt.toSet(r109)));
        HashSet r113 = new HashSet();
        ArrayList r114 = new ArrayList();
        Iterator r115 = ((ArrayList) r108).iterator();
    L21:
        if (r115.hasNext() == false) goto L25;
        Object r116 = r115.next();
        if (r113.add(((BotModel) r116).getBotId()) == false) goto L21;
        r114.add(r116);
        goto L21
    L25:
        Map r117 = MapsKt.mapOf(TuplesKt.to(r100, r114));
        return new f(SetsKt.emptySet(), r112, r117);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0100 -> B:62:0x0101). Please report as a decompilation issue!!! */
    public final Object e(Set<String> r110, Continuation<? super f> r111) {
        if ((r111 instanceof BatchGetBotByConversationId$batchGetConversation$1) == false) goto L7;
        BatchGetBotByConversationId$batchGetConversation$1 r100 = (BatchGetBotByConversationId$batchGetConversation$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        int r104 = 7;
        Set r105 = null;
        Object[] r106 = 0;
        Object[] r107 = 0;
        Object[] r108 = 0;
        Object[] r109 = 0;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        Map r113 = (Map) r100.L$2;
        Iterator<ConversationInfo> r114 = (Iterator) r100.L$1;
        Map r115 = (Map) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L62:
        r113.putAll((Map) r112);
        r113 = r115;
    L48:
        if (r114.hasNext() == false) goto L64;
        ConversationInfo r116 = r114.next();
        r100.L$0 = r113;
        r100.L$1 = r114;
        r100.L$2 = r113;
        r100.label = 3;
        String r117 = r116.conversationId;
        if (r117 != null) goto L52;
    L55:
        boolean r118 = true;
    L56:
        if (r118 == false) goto L58;
        r112 = MapsKt.emptyMap();
    L59:
        if (r112 != r102) goto L61;
        return r102;
    L61:
        r115 = r113;
        goto L62
    L58:
        r112 = OmniDatabaseExtKt.e(new BatchGetBotByConversationId$handleConvResult$2(r117, r116, null), r100);
        goto L59
    L52:
        if (StringsKt.isBlank(r117) == true) goto L55;
        r118 = false;
        goto L56
    L64:
        return new f(r105, r113, 5);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r112);
    L32:
        com.larus.im.internal.network.e r119 = (com.larus.im.internal.network.e) r112;
        if ((r119 instanceof com.larus.im.internal.network.e.f) == false) goto L35;
        List<ConversationInfo> r120 = ((BatchGetConversationInfoDownlinkBody) ((com.larus.im.internal.network.e.f) r119).f349185a).conversationInfoList;
    L36:
        List<ConversationInfo> r121 = r120;
        if (r121 != null) goto L39;
    L42:
        boolean r122 = true;
    L43:
        if (r122 == true) goto L45;
        LinkedHashMap r123 = new LinkedHashMap();
        r114 = r120.iterator();
        r113 = r123;
        goto L48
    L45:
        return new f(r109 == true ? 1 : 0, r108 == true ? 1 : 0, r104);
    L39:
        if (r121.isEmpty() == true) goto L42;
        r122 = false;
        goto L43
    L35:
        r120 = null;
        goto L36
    L17:
        r110 = (Set) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L26:
        if (((List) r112).size() != r110.size()) goto L28;
        boolean r124 = true;
    L29:
        BatchGetBotByConversationId$batchGetConversation$ret$1 r125 = new BatchGetBotByConversationId$batchGetConversation$ret$1(r110, r124, null);
        r100.L$0 = null;
        r100.label = 2;
        r112 = requestServer(r125, r100);
        if (r112 != r102) goto L32;
        return r102;
    L28:
        r124 = false;
        goto L29
    L18:
        ResultKt.throwOnFailure(r112);
        if (r110.isEmpty() == true) goto L21;
        be9.b r126 = ae9.b.a();
        List<String> r127 = CollectionsKt.toList(r110);
        r100.L$0 = r110;
        r100.label = 1;
        r112 = ((ConversationDaoSource) r126).h(r127, r100);
        if (r112 != r102) goto L26;
        return r102;
    L21:
        return new f(r107 == true ? 1 : 0, r106 == true ? 1 : 0, r104);
    L7:
        r100 = new BatchGetBotByConversationId$batchGetConversation$1(this, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v30, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.util.ArrayList] */
    public static final Object c(BatchGetBotByConversationId r110, String r111, Continuation r112) {
        String r100 = r111;
        r110.getClass();
        if ((r112 instanceof BatchGetBotByConversationId$analyze$1) == false) goto L7;
        BatchGetBotByConversationId$analyze$1 r101 = (BatchGetBotByConversationId$analyze$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = 7;
        int r106 = 6;
        Map r107 = null;
        Object[] r108 = 0;
        Object[] r109 = 0;
        boolean r113 = true;
        switch(r101.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L14;
            default: goto L11;
        };
    L12:
        ConversationEntity r114 = (ConversationEntity) r101.L$1;
        String r115 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L73:
        ArrayList r116 = new ArrayList();
        Iterator r117 = ((List) r103).iterator();
    L75:
        if (r117.hasNext() == false) goto L86;
        Object r118 = r117.next();
        Integer r119 = ((ParticipantEntity) r118).getType();
        if (r119 != null) goto L80;
    L82:
        boolean r120 = false;
    L83:
        if (r120 == false) goto L75;
        r116.add(r118);
        goto L75
    L80:
        if (r119.intValue() != 2) goto L82;
        r120 = true;
        goto L83
    L86:
        if (com.larus.im.j.f(r115) == true) goto L99;
        if (r114 == null) goto L94;
        Integer r121 = r114.getConversationType();
        if (r121 == null) goto L94;
        if (r121.intValue() != 3) goto L94;
    L95:
        if (r113 == false) goto L99;
        if (r116.isEmpty() == false) goto L99;
        return new f(SetsKt.setOf(r115), r107, r106);
    L94:
        r113 = false;
    L99:
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator r123 = r116.iterator();
    L101:
        if (r123.hasNext() == false) goto L103;
        r122.add(((ParticipantEntity) r123.next()).getParticipantId());
        goto L101
    L103:
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 7;
        r103 = r110.f(r115, r122, r101);
        if (r103 != r104) goto L107;
        return r104;
    L107:
        return r103;
    L13:
        String r124 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r115 = r124;
    L70:
        r114 = (ConversationEntity) r103;
        be9.e r125 = ae9.h.a();
        r101.L$0 = r115;
        r101.L$1 = r114;
        r101.label = 6;
        r103 = ((ParticipantDaoSource) r125).c(r115, r101);
        if (r103 != r104) goto L73;
        return r104;
    L14:
        ResultKt.throwOnFailure(r103);
        goto L107
    L15:
        Ref.ObjectRef r126 = (Ref.ObjectRef) r101.L$2;
        Ref.ObjectRef r127 = (Ref.ObjectRef) r101.L$1;
        String r128 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L56:
        Iterable r129 = (Iterable) r103;
        ArrayList r130 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r129, 10));
        Iterator r131 = r129.iterator();
    L58:
        if (r131.hasNext() == false) goto L60;
        r130.add(d.c((BotEntity) r131.next()));
        goto L58
    L60:
        r126.element = CollectionsKt.toMutableList(r130);
        r126 = r127;
    L62:
        if ((!((Collection) r126.element).isEmpty()) == false) goto L66;
        List r132 = (List) r126.element;
        r101.L$0 = null;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.label = 4;
        r103 = g(r128, r132);
        if (r103 != r104) goto L107;
        return r104;
    L66:
        be9.b r133 = ae9.b.a();
        r101.L$0 = r128;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.label = 5;
        r103 = be9.b.C0295b.a(r133, r128, 0, r101, 6);
        if (r103 == r104) goto L121;
        r115 = r128;
        goto L70
    L121:
        return r104;
    L16:
        r126 = (Ref.ObjectRef) r101.L$1;
        String r134 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L45:
        BotEntity r135 = (BotEntity) r103;
        if (r135 == null) goto L48;
        Boxing.boxBoolean(((List) r126.element).add(d.c(r135)));
    L48:
        r128 = r134;
    L51:
        if (((List) r126.element).isEmpty() == false) goto L62;
        be9.a r136 = ae9.a.a();
        r101.L$0 = r128;
        r101.L$1 = r126;
        r101.L$2 = r126;
        r101.label = 3;
        r103 = ((BotDaoSource) r136).b(r128, r101);
        if (r103 == r104) goto L119;
        r127 = r126;
        goto L56
    L119:
        return r104;
    L17:
        Ref.ObjectRef r137 = (Ref.ObjectRef) r101.L$1;
        String r138 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Ref.ObjectRef r139 = r137;
        r100 = r138;
        Object r140 = r103;
    L30:
        ConversationEntity r141 = (ConversationEntity) r140;
        if (r141 == null) goto L33;
        String r142 = r141.getBotId();
    L34:
        if (r142 != null) goto L36;
    L39:
        boolean r143 = true;
    L40:
        if (r143 == true) goto L49;
        be9.a r144 = ae9.a.a();
        r101.L$0 = r100;
        r101.L$1 = r139;
        r101.label = 2;
        Object r145 = ((BotDaoSource) r144).j(r142, r101);
        if (r145 == r104) goto L118;
        r134 = r100;
        r126 = r139;
        r103 = r145;
        goto L45
    L118:
        return r104;
    L49:
        r128 = r100;
        r126 = r139;
        goto L51
    L36:
        if (r142.length() == 0) goto L39;
        r143 = false;
        goto L40
    L33:
        r142 = null;
        goto L34
    L18:
        ResultKt.throwOnFailure(r103);
        if (r100 != null) goto L21;
    L24:
        boolean r146 = true;
    L25:
        if (r146 == true) goto L115;
        r139 = new Ref.ObjectRef();
        r139.element = new ArrayList();
        be9.b r147 = ae9.b.a();
        r101.L$0 = r100;
        r101.L$1 = r139;
        r101.label = 1;
        r140 = be9.b.C0295b.a(r147, r100, 0, r101, 6);
        if (r140 != r104) goto L30;
        return r104;
    L115:
        return new f(r109 == true ? 1 : 0, r108 == true ? 1 : 0, r105);
    L21:
        if (StringsKt.isBlank(r111) == true) goto L24;
        r146 = false;
        goto L25
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r101 = new BatchGetBotByConversationId$analyze$1(r110, r112);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.HashMap] */
    public static final Object d(BatchGetBotByConversationId r110, f r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof BatchGetBotByConversationId$requestBy$1) == false) goto L7;
        BatchGetBotByConversationId$requestBy$1 r100 = (BatchGetBotByConversationId$requestBy$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        Iterator r114 = (Iterator) r100.L$3;
        List r115 = (List) r100.L$2;
        HashMap r104 = (HashMap) r100.L$1;
        f r105 = (f) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L53:
        if (r114.hasNext() == false) goto L57;
        BotEntity r116 = (BotEntity) r114.next();
        BotHandler r106 = BotHandler.f347542a;
        r100.L$0 = r105;
        r100.L$1 = r104;
        r100.L$2 = r115;
        r100.L$3 = r114;
        r100.label = 3;
        if (r106.c(r116, r100) != r102) goto L53;
    L99:
        return r102;
    L57:
        Iterator r117 = r115.iterator();
    L59:
        if (r117.hasNext() == false) goto L65;
        BotModel r118 = (BotModel) r117.next();
        String r119 = r118.getBotId();
        if (r119 != null) goto L63;
        r119 = "";
    L63:
        r104.put(r119, r118);
    L65:
        r111 = r105;
    L66:
        r102 = new HashMap();
        Iterator r120 = SetsKt.plus(r111.f347564b.keySet(), r111.f347565c.keySet()).iterator();
    L68:
        if (r120.hasNext() == false) goto L99;
        String r121 = (String) r120.next();
        ArrayList r107 = new ArrayList();
        Set<String> r108 = r111.f347564b.get(r121);
        Set<String> r109 = r108;
        if (r109 != null) goto L72;
    L75:
        boolean r122 = true;
    L76:
        if (r122 == true) goto L83;
        Iterator<String> r123 = r108.iterator();
    L79:
        if (r123.hasNext() == false) goto L83;
        BotModel r124 = (BotModel) r104.get(r123.next());
        if (r124 == null) goto L79;
        r107.add(r124);
    L83:
        List<BotModel> r125 = r111.f347565c.get(r121);
        if (r125 != null) goto L86;
    L89:
        boolean r126 = true;
    L90:
        if (r126 == true) goto L92;
        r107.addAll(r125);
    L92:
        HashSet r127 = new HashSet();
        ArrayList r128 = new ArrayList();
        Iterator r129 = r107.iterator();
    L94:
        if (r129.hasNext() == false) goto L98;
        Object r130 = r129.next();
        if (r127.add(((BotModel) r130).getBotId()) == false) goto L94;
        r128.add(r130);
        goto L94
    L98:
        r102.put(r121, r128);
        goto L68
    L86:
        if (r125.isEmpty() == true) goto L89;
        r126 = false;
        goto L90
    L72:
        if (r109.isEmpty() == true) goto L75;
        r122 = false;
        goto L76
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        HashMap r131 = (HashMap) r100.L$1;
        f r132 = (f) r100.L$0;
        ResultKt.throwOnFailure(r113);
        r105 = r132;
        r104 = r131;
    L41:
        com.larus.im.internal.network.e r133 = (com.larus.im.internal.network.e) r113;
        if ((r133 instanceof com.larus.im.internal.network.e.f) == false) goto L64;
        Iterable r134 = (Iterable) ((com.larus.im.internal.network.e.f) r133).f349185a;
        ArrayList r135 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r134, 10));
        Iterator r136 = r134.iterator();
    L45:
        if (r136.hasNext() == false) goto L47;
        r135.add(d.b((BotBody) r136.next()));
        goto L45
    L47:
        ArrayList r137 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r135, 10));
        Iterator r138 = r135.iterator();
    L49:
        if (r138.hasNext() == false) goto L51;
        r137.add(d.c((BotEntity) r138.next()));
        goto L49
    L51:
        Iterator r139 = r135.iterator();
        r115 = r137;
        r114 = r139;
        goto L53
    L64:
        com.larus.im.internal.delegate.a.f348188b.i(r110.f347541a, "Get remote bots error = " + r133.a());
        goto L65
    L17:
        r111 = (f) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L34:
        r111 = b.a(r111, (f) r113);
    L35:
        Set r140 = CollectionsKt.toMutableSet(CollectionsKt.flatten(r111.f347564b.values()));
        r104 = new HashMap();
        if ((!r140.isEmpty()) == false) goto L66;
        BatchGetBotByConversationId$requestBy$ret$1 r141 = new BatchGetBotByConversationId$requestBy$ret$1(r140, null);
        r100.L$0 = r111;
        r100.L$1 = r104;
        r100.label = 2;
        r113 = r110.requestServer(r141, r100);
        if (r113 == r102) goto L99;
        r105 = r111;
        goto L41
    L18:
        ResultKt.throwOnFailure(r113);
        Set<String> r142 = r111.f347563a;
        ArrayList r143 = new ArrayList();
        Iterator<T> r144 = r142.iterator();
    L20:
        if (r144.hasNext() == false) goto L29;
        Object r145 = r144.next();
        String r146 = (String) r145;
        if ((!StringsKt.isBlank(r146)) == true) goto L24;
    L26:
        boolean r147 = false;
    L27:
        if (r147 == false) goto L20;
        r143.add(r145);
        goto L20
    L24:
        if (com.larus.im.j.f(r146) == true) goto L26;
        r147 = true;
        goto L27
    L29:
        Set<String> r148 = CollectionsKt.toSet(r143);
        if ((!r148.isEmpty()) == false) goto L35;
        r100.L$0 = r111;
        r100.label = 1;
        r113 = r110.e(r148, r100);
        if (r113 != r102) goto L34;
    L7:
        r100 = new BatchGetBotByConversationId$requestBy$1(r110, r112);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object f(String r100, List<String> r110, Continuation<? super f> r111) {
        if ((r111 instanceof BatchGetBotByConversationId$retrieveBotIdList$1) == false) goto L7;
        BatchGetBotByConversationId$retrieveBotIdList$1 r101 = (BatchGetBotByConversationId$retrieveBotIdList$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        Set r105 = null;
        Object[] r106 = 0;
        Object[] r107 = 0;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        f r108 = (f) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L29:
        return b.a(r108, (f) r112);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Set r109 = (Set) r101.L$2;
        List r113 = (List) r101.L$1;
        String r114 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
        Set r115 = r109;
        r100 = r114;
    L24:
        f r116 = new f(r105, MapsKt.mapOf(TuplesKt.to(r100, r115)), 5);
        r101.L$0 = r116;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.label = 2;
        f r117 = g(r100, r113);
        if (r117 != r103) goto L27;
        return r103;
    L27:
        r112 = r117;
        r108 = r116;
        goto L29
    L16:
        ResultKt.throwOnFailure(r112);
        ArrayList r118 = (ArrayList) r110;
        if (r118.isEmpty() == false) goto L20;
        Object[] r119 = r107 == true ? 1 : 0;
        Object[] r120 = r106 == true ? 1 : 0;
        return new f(r119, r120, 7);
    L20:
        ArrayList r121 = new ArrayList();
        r115 = new LinkedHashSet();
        BatchGetBotByConversationId$retrieveBotIdList$2 r122 = new BatchGetBotByConversationId$retrieveBotIdList$2(new BatchGetBotByConversationId$retrieveBotIdList$block$1(r118, r115, r121, null), null);
        r101.L$0 = r100;
        r101.L$1 = r121;
        r101.L$2 = r115;
        r101.label = 1;
        if (OmniDatabaseExtKt.e(r122, r101) != r103) goto L23;
        return r103;
    L23:
        r113 = r121;
    L7:
        r101 = new BatchGetBotByConversationId$retrieveBotIdList$1(this, r111);
        goto L8
    }
}
