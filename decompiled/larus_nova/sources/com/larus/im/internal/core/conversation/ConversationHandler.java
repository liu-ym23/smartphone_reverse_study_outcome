package com.larus.im.internal.core.conversation;

import be9.d;
import com.larus.im.bean.conversation.ConversationStatus;
import com.larus.im.bean.conversation.ConversationType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageTag;
import com.larus.im.internal.core.conversation.converter.ConversationConverterKt;
import com.larus.im.internal.core.conversation.converter.WriteCvsInfo2EntityFrom;
import com.larus.im.internal.core.conversation.receiver.ConversationDispatcher;
import com.larus.im.internal.core.message.converter.MessageEntityConverterKt;
import com.larus.im.internal.database.delegate.ConversationDaoSource;
import com.larus.im.internal.database.delegate.MessageDaoSource;
import com.larus.im.internal.database.entity.ConversationEntity;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.database.utils.OmniDatabaseExtKt;
import com.larus.im.internal.database.utils.l;
import com.larus.im.internal.protocol.bean.ConversationInfo;
import com.larus.im.j;
import com.larus.im.service.z;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import wc9.e;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002J*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0010J&\u0010\n\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0013J,\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0080@¢\u0006\u0004\b\u001b\u0010\u001cJ*\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010\u0018\u001a\u00020\u000eH\u0080@¢\u0006\u0004\b\u001b\u0010 J \u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0080@¢\u0006\u0004\b$\u0010%J\"\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00052\b\b\u0001\u0010(\u001a\u00020\u0015H\u0080@¢\u0006\u0004\b)\u0010*J4\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010-\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010.J\u0018\u0010/\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u00100J4\u00101\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00122\u0006\u00102\u001a\u00020\u00052\b\b\u0003\u00103\u001a\u00020\u00152\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u00105J\u0019\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000107H\u0002¢\u0006\u0002\u00109J \u0010:\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u00052\u0006\u0010;\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/larus/im/internal/core/conversation/ConversationHandler;", "", "<init>", "()V", "TAG", "", "logI", "", "methodName", "msg", "updateConversationLastMessage", "message", "Lcom/larus/im/internal/database/entity/MessageEntity;", "needNotify", "", "ignoreChange", "(Lcom/larus/im/internal/database/entity/MessageEntity;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messages", "", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConversation", "", "info", "Lcom/larus/im/internal/protocol/bean/ConversationInfo;", "notify", "from", "Lcom/larus/im/internal/core/conversation/converter/WriteCvsInfo2EntityFrom;", "updateConversation$core_release", "(Lcom/larus/im/internal/protocol/bean/ConversationInfo;ZLcom/larus/im/internal/core/conversation/converter/WriteCvsInfo2EntityFrom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "old", "Lcom/larus/im/internal/database/entity/ConversationEntity;", "new", "(Lcom/larus/im/internal/database/entity/ConversationEntity;Lcom/larus/im/internal/database/entity/ConversationEntity;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSection", "conversationId", "sectionId", "updateSection$core_release", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConversationStatus", "cvsId", "status", "updateConversationStatus$core_release", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replaceOrCreate", "localCvsId", "conversationInfo", "(Ljava/lang/String;Lcom/larus/im/internal/protocol/bean/ConversationInfo;ZLcom/larus/im/internal/core/conversation/converter/WriteCvsInfo2EntityFrom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteConversation", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConversationByBotId", "botId", "conversationType", "customSuffix", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMicroSecond", "", "time", "(Ljava/lang/Long;)Ljava/lang/Long;", "updateConversationBadgeCount", "badgeCount", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationHandler {
    public static final ConversationHandler INSTANCE = null;
    private static final String TAG = "ConversationHandler";

    /* JADX INFO: renamed from: com.larus.im.internal.core.conversation.ConversationHandler$deleteConversation$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.conversation.ConversationHandler$deleteConversation$2", f = "ConversationHandler.kt", i = {1}, l = {322, 323}, m = "invokeSuspend", n = {"localConversation"}, s = {"L$0"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $cvsId;
        Object L$0;
        int label;

        public AnonymousClass2(String r100, Continuation<? super AnonymousClass2> r101) {
            this.$cvsId = r100;
            super(1, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass2(this.$cvsId, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Boolean> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Boolean> r100) {
            return ((AnonymousClass2) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r510) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            boolean r102 = false;
            boolean r103 = true;
            if (r101 == 0) goto L10;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            ConversationEntity r104 = (ConversationEntity) this.L$0;
            ResultKt.throwOnFailure(r510);
            Object r105 = r510;
            ConversationEntity r106 = r104;
        L18:
            if (((Number) r105).intValue() <= 0) goto L21;
            if (r106 == null) goto L21;
            com.larus.im.internal.delegate.a.f348188b.i(ConversationHandler.TAG, "deleteConversation success, cvsId:" + this.$cvsId);
            CopyOnWriteArrayList<z<List<e>>> r107 = ConversationDispatcher.f347638a;
            ConversationDispatcher.a(CollectionsKt.listOf(ConversationConverterKt.c(ConversationEntity.copy$default(r106, null, null, null, 0, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, null, null, null, null, null, null, Boxing.boxInt(2), null, null, null, null, false, null, null, null, null, null, null, null, null, null, -16777217, 127, null))));
            r102 = true;
        L26:
            return Boxing.boxBoolean(r102);
        L21:
            if (r106 != null) goto L24;
            r103 = false;
        L24:
            com.larus.im.internal.delegate.a.f348188b.i(ConversationHandler.TAG, "deleteConversation failed, cvsId:" + this.$cvsId + ",hasLocal:" + r103);
            goto L26
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r510);
            Object r108 = r510;
        L13:
            ConversationEntity r109 = (ConversationEntity) r108;
            be9.b r110 = ae9.b.a();
            String r111 = this.$cvsId;
            this.L$0 = r109;
            this.label = 2;
            r105 = ((ConversationDaoSource) r110).a(r111, this);
            if (r105 != r100) goto L16;
            return r100;
        L16:
            r106 = r109;
            goto L18
        L10:
            ResultKt.throwOnFailure(r510);
            be9.b r112 = ae9.b.a();
            String r113 = this.$cvsId;
            this.label = 1;
            r108 = be9.b.C0295b.a(r112, r113, 0, this, 6);
            if (r108 != r100) goto L13;
            return r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.conversation.ConversationHandler$getConversationByBotId$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/im/internal/database/entity/ConversationEntity;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.conversation.ConversationHandler$getConversationByBotId$2", f = "ConversationHandler.kt", i = {1}, l = {346, 347}, m = "invokeSuspend", n = {"localCvs"}, s = {"L$0"})
    public static final class C114592 extends SuspendLambda implements Function1<Continuation<? super List<? extends ConversationEntity>>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ int $conversationType;
        final /* synthetic */ String $localCvsId;
        Object L$0;
        int label;

        public C114592(String r100, int r101, String r102, Continuation<? super C114592> r103) {
            this.$localCvsId = r100;
            this.$conversationType = r101;
            this.$botId = r102;
            super(1, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new C114592(this.$localCvsId, this.$conversationType, this.$botId, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super List<? extends ConversationEntity>> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super List<ConversationEntity>> r100) {
            return ((C114592) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 != 2) goto L8;
            ConversationEntity r103 = (ConversationEntity) this.L$0;
            ResultKt.throwOnFailure(r100);
        L17:
            List r104 = (List) r100;
            if (r103 == null) goto L33;
            String r105 = this.$localCvsId;
            Iterator r106 = r104.iterator();
        L21:
            if (r106.hasNext() == false) goto L25;
            Object r107 = r106.next();
            if (Intrinsics.areEqual(((ConversationEntity) r107).getConversationId(), r105) == false) goto L21;
        L26:
            if (r107 == null) goto L29;
            return r104;
        L29:
            return CollectionsKt.plus(r104, CollectionsKt.listOf(r103));
        L25:
            r107 = null;
            goto L26
        L33:
            return r104;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
        L13:
            ConversationEntity r108 = (ConversationEntity) r100;
            be9.b r109 = ae9.b.a();
            String r110 = this.$botId;
            int r111 = this.$conversationType;
            this.L$0 = r108;
            this.label = 2;
            Object r112 = ((ConversationDaoSource) r109).l(r110, r111, this);
            if (r112 != r101) goto L16;
            return r101;
        L16:
            r103 = r108;
            r100 = r112;
            goto L17
        L10:
            ResultKt.throwOnFailure(r100);
            be9.b r113 = ae9.b.a();
            String r114 = this.$localCvsId;
            int r115 = this.$conversationType;
            this.label = 1;
            r100 = be9.b.C0295b.a(r113, r114, r115, this, 4);
            if (r100 != r101) goto L13;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.conversation.ConversationHandler$replaceOrCreate$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.conversation.ConversationHandler$replaceOrCreate$2", f = "ConversationHandler.kt", i = {1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5}, l = {253, 262, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, 274, 274}, m = "invokeSuspend", n = {"localCvs", "localCvs", "deleteRet", "localCvs", "deleteRet", "insertOrUpdate", "localCvs", "deleteRet", "insertOrUpdate", "localCvs", "deleteRet", "insertOrUpdate"}, s = {"L$0", "L$0", "I$0", "L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "L$0", "I$0", "I$1"})
    public static final class C114602 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ConversationInfo $conversationInfo;
        final /* synthetic */ WriteCvsInfo2EntityFrom $from;
        final /* synthetic */ String $localCvsId;
        final /* synthetic */ boolean $notify;
        int I$0;
        int I$1;
        Object L$0;
        int label;

        public C114602(String r100, boolean r101, WriteCvsInfo2EntityFrom r102, ConversationInfo r103, Continuation<? super C114602> r104) {
            this.$localCvsId = r100;
            this.$notify = r101;
            this.$from = r102;
            this.$conversationInfo = r103;
            super(1, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new C114602(this.$localCvsId, this.$notify, this.$from, this.$conversationInfo, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r100) {
            return ((C114602) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r510) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            String r101 = "";
            boolean r102 = false;
            e r103 = null;
            switch(this.label) {
                case 0: goto L12;
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            int r104 = this.I$1;
            int r105 = this.I$0;
            ConversationEntity r106 = (ConversationEntity) this.L$0;
            ResultKt.throwOnFailure(r510);
            ConversationEntity r110 = r106;
            Object r107 = r510;
        L66:
            ConversationEntity r111 = (ConversationEntity) r107;
            int r108 = r105;
            int r109 = r104;
        L67:
            com.larus.im.internal.delegate.a r112 = com.larus.im.internal.delegate.a.f348188b;
            StringBuilder r113 = new StringBuilder("replaceOrCreate——delete local success(");
            if (r108 <= 0) goto L70;
            boolean r114 = true;
        L71:
            r113.append(r114);
            r113.append("), local cvs(");
            r113.append(r110);
            r113.append("); insert remote cvs success(");
            if (r109 <= 0) goto L74;
            r102 = true;
        L74:
            r113.append(r102);
            r113.append("), remote cvs(");
            r113.append(r111);
            r113.append(") from = ");
            r113.append(this.$from);
            r112.i(ConversationHandler.TAG, r113.toString());
            if (this.$notify == false) goto L77;
            if (r109 > 0) goto L84;
            if (r110 == null) goto L82;
            if (r108 <= 0) goto L82;
            r112.i(ConversationHandler.TAG, "replaceOrCreate——insert remote cvs failed delete local cvs success from = " + this.$from);
            CopyOnWriteArrayList<z<List<e>>> r115 = ConversationDispatcher.f347638a;
            ConversationDispatcher.a(CollectionsKt.listOf(ConversationConverterKt.c(r110)));
        L96:
            return Unit.INSTANCE;
        L82:
            r112.i(ConversationHandler.TAG, "replaceOrCreate——insert remote cvs and delete local cvs failed " + this.$from);
            goto L96
        L84:
            if (r108 <= 0) goto L94;
            r112.i(ConversationHandler.TAG, "replaceOrCreate——insert remote cvs and delete local cvs success cvsId = " + this.$localCvsId + " from = " + this.$from);
            CopyOnWriteArrayList<z<List<e>>> r116 = ConversationDispatcher.f347638a;
            if (r110 == null) goto L91;
            String r117 = r110.getConversationId();
            if (r117 == null) goto L91;
            r101 = r117;
        L91:
            if (r110 == null) goto L93;
            r103 = ConversationConverterKt.c(r110);
        L93:
            ConversationDispatcher.b(r101, r103, ConversationConverterKt.c(r111));
            goto L96
        L94:
            r112.i(ConversationHandler.TAG, "replaceOrCreate——insert remote cvs success, delete local cvs failed cvsId = " + this.$localCvsId + " from = " + this.$from);
            CopyOnWriteArrayList<z<List<e>>> r118 = ConversationDispatcher.f347638a;
            ConversationDispatcher.a(CollectionsKt.listOf(ConversationConverterKt.c(r111)));
            goto L96
        L77:
            return Unit.INSTANCE;
        L70:
            r114 = false;
            goto L71
        L7:
            r109 = this.I$1;
            r108 = this.I$0;
            r110 = (ConversationEntity) this.L$0;
            ResultKt.throwOnFailure(r510);
            Object r119 = r510;
        L60:
            r111 = (ConversationEntity) r119;
            if (r111 != null) goto L67;
            ConversationInfo r120 = this.$conversationInfo;
            WriteCvsInfo2EntityFrom r121 = this.$from;
            this.L$0 = r110;
            this.I$0 = r108;
            this.I$1 = r109;
            this.label = 6;
            r107 = ConversationConverterKt.b(r120, r121, this);
            if (r107 != r100) goto L65;
            return r100;
        L65:
            r104 = r109;
            r105 = r108;
            goto L66
        L8:
            int r122 = this.I$1;
            r108 = this.I$0;
            ConversationEntity r123 = (ConversationEntity) this.L$0;
            ResultKt.throwOnFailure(r510);
        L52:
            ConversationEntity r511 = r123;
            int r124 = r122;
            ConversationEntity r125 = r511;
        L53:
            be9.b r126 = ae9.b.a();
            String r127 = this.$conversationInfo.conversationId;
            if (r127 != null) goto L56;
            r127 = "";
        L56:
            this.L$0 = r125;
            this.I$0 = r108;
            this.I$1 = r124;
            this.label = 5;
            r119 = be9.b.C0295b.a(r126, r127, 0, this, 6);
            if (r119 != r100) goto L59;
            return r100;
        L59:
            int r512 = r124;
            r110 = r125;
            r109 = r512;
            goto L60
        L9:
            int r128 = this.I$0;
            ConversationEntity r129 = (ConversationEntity) this.L$0;
            ResultKt.throwOnFailure(r510);
            Object r130 = r510;
            r108 = r128;
            r125 = r129;
        L43:
            r124 = ((Number) r130).intValue();
            if (r125 == null) goto L53;
            be9.b r131 = ae9.b.a();
            String r132 = this.$conversationInfo.conversationId;
            if (r132 != null) goto L48;
            r132 = "";
        L48:
            boolean r133 = r125.getTtsEnable();
            this.L$0 = r125;
            this.I$0 = r108;
            this.I$1 = r124;
            this.label = 4;
            if (((ConversationDaoSource) r131).H(r132, r133, this) != r100) goto L51;
            return r100;
        L51:
            r123 = r125;
            r122 = r124;
            goto L52
        L10:
            r125 = (ConversationEntity) this.L$0;
            ResultKt.throwOnFailure(r510);
            Object r134 = r510;
        L38:
            r108 = ((Number) r134).intValue();
        L40:
            ConversationHandler r135 = ConversationHandler.INSTANCE;
            ConversationInfo r136 = this.$conversationInfo;
            WriteCvsInfo2EntityFrom r137 = this.$from;
            this.L$0 = r125;
            this.I$0 = r108;
            this.label = 3;
            r130 = r135.updateConversation$core_release(r136, false, r137, this);
            if (r130 != r100) goto L43;
            return r100;
        L11:
            ResultKt.throwOnFailure(r510);
            Object r138 = r510;
        L23:
            ConversationEntity r139 = (ConversationEntity) r138;
            if (r139 == null) goto L26;
            r125 = ConversationEntity.copy$default(r139, null, null, null, 0, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, null, null, null, null, null, null, Boxing.boxInt(2), null, null, null, null, false, null, null, null, null, null, null, null, null, null, -16777217, 127, null);
        L27:
            String r140 = this.$localCvsId;
            if (r140 != null) goto L30;
        L33:
            boolean r141 = true;
        L34:
            if (r141 == true) goto L39;
            be9.b r142 = ae9.b.a();
            String r143 = this.$localCvsId;
            this.L$0 = r125;
            this.label = 2;
            r134 = ((ConversationDaoSource) r142).a(r143, this);
            if (r134 != r100) goto L38;
            return r100;
        L39:
            r108 = 0;
            goto L40
        L30:
            if (StringsKt.isBlank(r140) == true) goto L33;
            r141 = false;
        L26:
            r125 = null;
            goto L27
        L12:
            ResultKt.throwOnFailure(r510);
            com.larus.im.internal.delegate.a.f348188b.i(ConversationHandler.TAG, "replaceOrCreate——local cvsId(" + this.$localCvsId + "),  notify =（" + this.$notify + "）from = " + this.$from + " info(" + this.$conversationInfo + ')');
            String r144 = this.$localCvsId;
            if (r144 != null) goto L15;
        L18:
            boolean r145 = true;
        L19:
            if (r145 == true) goto L26;
            be9.b r146 = ae9.b.a();
            String r147 = this.$localCvsId;
            this.label = 1;
            r138 = be9.b.C0295b.a(r146, r147, 0, this, 6);
            if (r138 != r100) goto L23;
            return r100;
        L15:
            if (StringsKt.isBlank(r144) == true) goto L18;
            r145 = false;
            goto L19
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.conversation.ConversationHandler$updateConversationBadgeCount$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.conversation.ConversationHandler", f = "ConversationHandler.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_200}, m = "updateConversationBadgeCount", n = {"cvsId"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ConversationHandler this$0;

        public AnonymousClass1(ConversationHandler r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.updateConversationBadgeCount(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.conversation.ConversationHandler$updateConversationLastMessage$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.conversation.ConversationHandler$updateConversationLastMessage$2", f = "ConversationHandler.kt", i = {1, 2, 2, 2, 3}, l = {40, 42, 50, 58}, m = "invokeSuspend", n = {"oldCvs", "oldCvs", "briefId", "version", "newCvs"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0"})
    public static final class C114612 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $cvsId;
        final /* synthetic */ boolean $ignoreChange;
        final /* synthetic */ MessageEntity $message;
        final /* synthetic */ boolean $needNotify;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public C114612(String r100, MessageEntity r101, boolean r102, boolean r103, Continuation<? super C114612> r104) {
            this.$cvsId = r100;
            this.$message = r101;
            this.$needNotify = r102;
            this.$ignoreChange = r103;
            super(1, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new C114612(this.$cvsId, this.$message, this.$needNotify, this.$ignoreChange, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r100) {
            return ((C114612) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r510) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L14;
            if (r101 == 1) goto L13;
            if (r101 == 2) goto L12;
            if (r101 == 3) goto L11;
            if (r101 != 4) goto L10;
            ConversationEntity r102 = (ConversationEntity) this.L$0;
            ResultKt.throwOnFailure(r510);
            Object r103 = r510;
        L63:
            boolean r104 = ((Boolean) r103).booleanValue();
            if (this.$needNotify == false) goto L70;
            if (r104 == false) goto L67;
        L68:
            CopyOnWriteArrayList<z<List<e>>> r105 = ConversationDispatcher.f347638a;
            ConversationDispatcher.a(CollectionsKt.listOf(ConversationConverterKt.c(r102)));
            goto L70
        L67:
            if (this.$ignoreChange == true) goto L68;
        L70:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            Long r106 = (Long) this.L$2;
            String r107 = (String) this.L$1;
            ConversationEntity r108 = (ConversationEntity) this.L$0;
            ResultKt.throwOnFailure(r510);
            Long r310 = r106;
            String r210 = r107;
            ConversationEntity r109 = r108;
            Object r110 = r510;
        L46:
            List<Integer> r111 = ((Message) r110).getTags();
            MessageTag.Companion.getClass();
            if (MessageTag.a.a(r111) == true) goto L49;
            Long r112 = Boxing.boxLong(this.$message.getCreateTime());
        L50:
            Long r113 = r112;
            Integer r114 = r109.getStatus();
            if (r114 != null) goto L54;
        L58:
            Integer r115 = r109.getStatus();
        L59:
            ConversationEntity r116 = ConversationEntity.copy$default(r109, null, null, null, 0, null, null, null, r113, null, 0, null, null, null, null, false, null, null, null, null, r210, null, null, null, r310, r115, null, null, null, null, false, null, null, null, null, null, null, null, null, null, -25690241, 127, null);
            be9.b r117 = ae9.b.a();
            this.L$0 = r116;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 4;
            r103 = ((ConversationDaoSource) r117).B(r109, r116, this);
            if (r103 != r100) goto L62;
            return r100;
        L62:
            r102 = r116;
            goto L63
        L54:
            if (r114.intValue() != 2) goto L58;
            if (r109.isDeleted() == true) goto L58;
            r115 = Boxing.boxInt(1);
            goto L59
        L49:
            r112 = r109.getUpdateTime();
            goto L50
        L12:
            r109 = (ConversationEntity) this.L$0;
            ResultKt.throwOnFailure(r510);
            Object r118 = r510;
        L24:
            MessageEntity r119 = (MessageEntity) r118;
            if (r119 == null) goto L28;
            String r120 = r119.getLocalMessageId();
            if (r120 == null) goto L28;
        L29:
            if (r119 == null) goto L32;
            r119.getSectionId();
        L32:
            if (Intrinsics.areEqual(r120, this.$message.getLocalMessageId()) == true) goto L34;
            Long r121 = r109.getVersion();
        L42:
            MessageEntity r122 = this.$message;
            this.L$0 = r109;
            this.L$1 = r120;
            this.L$2 = r121;
            this.label = 3;
            r110 = MessageEntityConverterKt.a(r122, this);
            if (r110 != r100) goto L45;
            return r100;
        L45:
            r310 = r121;
            r210 = r120;
            goto L46
        L34:
            Long r123 = r109.getVersion();
            long r124 = 0;
            if (r123 == null) goto L37;
            long r125 = r123.longValue();
        L38:
            Long r126 = ConversationHandler.access$toMicroSecond(ConversationHandler.INSTANCE, Boxing.boxLong(this.$message.getCreateTime()));
            if (r126 == null) goto L41;
            r124 = r126.longValue();
        L41:
            r121 = Boxing.boxLong(Math.max(r125, r124));
            goto L42
        L37:
            r125 = 0;
        L28:
            r120 = "";
            goto L29
        L13:
            ResultKt.throwOnFailure(r510);
            Object r127 = r510;
        L17:
            r109 = (ConversationEntity) r127;
            if (r109 == null) goto L20;
            d r128 = ae9.e.a();
            String r129 = this.$cvsId;
            this.L$0 = r109;
            this.label = 2;
            r118 = ((MessageDaoSource) r128).C(r129, this);
            if (r118 != r100) goto L24;
            return r100;
        L20:
            return Unit.INSTANCE;
        L14:
            ResultKt.throwOnFailure(r510);
            be9.b r130 = ae9.b.a();
            String r131 = this.$cvsId;
            this.label = 1;
            r127 = be9.b.C0295b.a(r130, r131, 0, this, 6);
            if (r127 != r100) goto L17;
            return r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.conversation.ConversationHandler$updateConversationLastMessage$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.conversation.ConversationHandler$updateConversationLastMessage$4", f = "ConversationHandler.kt", i = {1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {73, 77, 90, 91, 102}, m = "invokeSuspend", n = {"updatedConversations", "conversationEntity", "updatedConversations", "conversationEntity", "lastMessage", "briefId", "version", "updatedConversations", "conversationEntity", "lastMessage", "updatedConversations", "conversationEntity", "lastMessage"}, s = {"L$0", "L$2", "L$0", "L$2", "L$3", "L$4", "L$5", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3"})
    public static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, List<MessageEntity>> $map;
        final /* synthetic */ boolean $needNotify;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(Map<String, ? extends List<MessageEntity>> r100, boolean r101, Continuation<? super AnonymousClass4> r102) {
            this.$map = r100;
            this.$needNotify = r101;
            super(1, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass4(this.$map, this.$needNotify, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r100) {
            return ((AnonymousClass4) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x0289 -> B:89:0x028c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r610) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            String r102 = null;
            int r110 = 2;
            if (r101 == 0) goto L16;
            if (r101 == 1) goto L15;
            if (r101 == 2) goto L14;
            if (r101 == 3) goto L13;
            if (r101 == 4) goto L12;
            if (r101 != 5) goto L11;
            MessageEntity r103 = (MessageEntity) this.L$3;
            ConversationEntity r111 = (ConversationEntity) this.L$2;
            Iterator r112 = (Iterator) this.L$1;
            List r104 = (List) this.L$0;
            ResultKt.throwOnFailure(r610);
            AnonymousClass4 r105 = this;
            String r113 = null;
            Iterator r106 = r112;
            ConversationEntity r114 = r111;
            MessageEntity r115 = r103;
            Object r107 = r610;
        L89:
            ConversationEntity r108 = (ConversationEntity) r107;
            if (CollectionsKt.contains(r104, r108) == true) goto L98;
            if (r108 == null) goto L93;
            r104.add(r108);
        L93:
            com.larus.im.internal.delegate.a r109 = com.larus.im.internal.delegate.a.f348188b;
            StringBuilder r116 = new StringBuilder("updateConversationLastMessage briefId = ");
            if (r115 == null) goto L96;
            String r117 = r115.getLocalMessageId();
        L97:
            r116.append(r117);
            r116.append(" update ids = ");
            r116.append(r114.getBriefMessageLocalId());
            r116.append("update ids = ");
            r116.append(r114.getConversationId());
            r116.append('}');
            r109.i(ConversationHandler.TAG, r116.toString());
            goto L99
        L96:
            r117 = r113;
        L99:
            Iterator r118 = r106;
            AnonymousClass4 r119 = r105;
            r102 = r113;
            r110 = 2;
        L21:
            if (r118.hasNext() == false) goto L101;
            ConversationEntity r120 = (ConversationEntity) r118.next();
            d r121 = ae9.e.a();
            String r122 = r120.getConversationId();
            r119.L$0 = r104;
            r119.L$1 = r118;
            r119.L$2 = r120;
            r119.L$3 = r102;
            r119.label = r110;
            Object r123 = ((MessageDaoSource) r121).C(r122, r119);
            if (r123 != r100) goto L25;
            return r100;
        L25:
            r114 = r120;
            List r124 = r104;
            AnonymousClass4 r611 = r119;
            r106 = r118;
            AnonymousClass4 r125 = r611;
        L26:
            r115 = (MessageEntity) r123;
            if (r115 == null) goto L30;
            String r126 = r115.getLocalMessageId();
            if (r126 == null) goto L30;
        L31:
            if (r115 == null) goto L34;
            r115.getSectionId();
        L34:
            if (Intrinsics.areEqual(r114.getBriefMessageLocalId(), r126) == false) goto L36;
            Long r127 = r114.getVersion();
        L48:
            com.larus.im.internal.delegate.a r128 = com.larus.im.internal.delegate.a.f348188b;
            StringBuilder r129 = new StringBuilder("updateConversationLastMessage briefId = ");
            if (r115 == null) goto L51;
            String r130 = r115.getLocalMessageId();
        L52:
            r129.append(r130);
            r129.append(" conversation ids = ");
            r129.append(r114.getConversationId());
            r129.append('}');
            r128.i(ConversationHandler.TAG, r129.toString());
            if (r115 == null) goto L63;
            r125.L$0 = r124;
            r125.L$1 = r106;
            r125.L$2 = r114;
            r125.L$3 = r115;
            r125.L$4 = r126;
            r125.L$5 = r127;
            r125.label = 3;
            Object r131 = MessageEntityConverterKt.a(r115, r125);
            if (r131 != r100) goto L57;
            return r100;
        L57:
            Long r612 = r127;
            r105 = r125;
            Long r132 = r612;
        L58:
            Message r133 = (Message) r131;
            if (r133 == null) goto L61;
            List<Integer> r134 = r133.getTags();
            Long r410 = r132;
            String r411 = r126;
        L64:
            be9.b r135 = ae9.b.a();
            MessageTag.Companion.getClass();
            if (MessageTag.a.a(r134) == true) goto L69;
            if (r115 == null) goto L68;
            Long r136 = Boxing.boxLong(r115.getCreateTime());
        L70:
            Long r210 = r136;
        L71:
            Integer r137 = r114.getStatus();
            if (r137 != null) goto L75;
        L79:
            Integer r412 = r114.getStatus();
        L80:
            ConversationEntity r138 = ConversationEntity.copy$default(r114, null, null, null, 0, null, null, null, r210, null, 0, null, null, null, null, false, null, null, null, null, r411, null, null, null, r410, r412, null, null, null, null, false, null, null, null, null, null, null, null, null, null, -25690241, 127, null);
            r105.L$0 = r124;
            r105.L$1 = r106;
            r105.L$2 = r114;
            r105.L$3 = r115;
            r113 = null;
            r105.L$4 = null;
            r105.L$5 = null;
            r105.label = 4;
            Object r139 = ((ConversationDaoSource) r135).B(r114, r138, r105);
            if (r139 != r100) goto L83;
            return r100;
        L83:
            r104 = r124;
        L85:
            if (((Boolean) r139).booleanValue() == false) goto L99;
            be9.b r140 = ae9.b.a();
            String r141 = r114.getConversationId();
            r105.L$0 = r104;
            r105.L$1 = r106;
            r105.L$2 = r114;
            r105.L$3 = r115;
            r105.label = 5;
            r107 = be9.b.C0295b.a(r140, r141, 0, r105, 6);
            if (r107 != r100) goto L89;
            return r100;
        L75:
            if (r137.intValue() != 2) goto L79;
            if (r114.isDeleted() == true) goto L79;
            r412 = Boxing.boxInt(1);
            goto L80
        L68:
            r210 = null;
            goto L71
        L69:
            r136 = r114.getUpdateTime();
            goto L70
        L61:
            AnonymousClass4 r613 = r105;
            r127 = r132;
            r125 = r613;
        L63:
            r410 = r127;
            r411 = r126;
            r134 = null;
            r105 = r125;
            goto L64
        L51:
            r130 = null;
            goto L52
        L36:
            Long r142 = r114.getVersion();
            long r143 = 0;
            if (r142 == null) goto L39;
            long r144 = r142.longValue();
        L40:
            ConversationHandler r145 = ConversationHandler.INSTANCE;
            if (r115 == null) goto L43;
            Long r146 = Boxing.boxLong(r115.getCreateTime());
        L44:
            Long r147 = ConversationHandler.access$toMicroSecond(r145, r146);
            if (r147 == null) goto L47;
            r143 = r147.longValue();
        L47:
            r127 = Boxing.boxLong(Math.max(r144, r143));
            goto L48
        L43:
            r146 = null;
            goto L44
        L39:
            r144 = 0;
        L30:
            r126 = "";
            goto L31
        L101:
            if (r119.$needNotify == false) goto L118;
            if ((!r104.isEmpty()) == false) goto L118;
            com.larus.im.internal.delegate.a r148 = com.larus.im.internal.delegate.a.f348188b;
            StringBuilder r149 = new StringBuilder("updateConversationLastMessage do update size = ");
            r149.append(r104.size());
            r149.append(" update ids = ");
            List r150 = r104;
            ArrayList r151 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r150, 10));
            Iterator r152 = r150.iterator();
        L106:
            if (r152.hasNext() == false) goto L108;
            r151.add(((ConversationEntity) r152.next()).getBriefMessageLocalId());
            goto L106
        L108:
            r149.append(r151);
            r149.append("update ids = ");
            ArrayList r153 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r150, 10));
            Iterator r154 = r150.iterator();
        L110:
            if (r154.hasNext() == false) goto L112;
            r153.add(((ConversationEntity) r154.next()).getConversationId());
            goto L110
        L112:
            r149.append(r153);
            r148.i(ConversationHandler.TAG, r149.toString());
            CopyOnWriteArrayList<z<List<e>>> r155 = ConversationDispatcher.f347638a;
            ArrayList r156 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r150, 10));
            Iterator r157 = r150.iterator();
        L114:
            if (r157.hasNext() == false) goto L116;
            r156.add(ConversationConverterKt.c((ConversationEntity) r157.next()));
            goto L114
        L116:
            ConversationDispatcher.a(r156);
        L118:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            MessageEntity r158 = (MessageEntity) this.L$3;
            ConversationEntity r159 = (ConversationEntity) this.L$2;
            Iterator r160 = (Iterator) this.L$1;
            List r161 = (List) this.L$0;
            ResultKt.throwOnFailure(r610);
            r105 = this;
            r113 = null;
            r106 = r160;
            r115 = r158;
            r139 = r610;
            r114 = r159;
            r104 = r161;
            goto L85
        L13:
            r132 = (Long) this.L$5;
            r126 = (String) this.L$4;
            r115 = (MessageEntity) this.L$3;
            r114 = (ConversationEntity) this.L$2;
            r106 = (Iterator) this.L$1;
            r124 = (List) this.L$0;
            ResultKt.throwOnFailure(r610);
            r131 = r610;
            r105 = this;
            goto L58
        L14:
            ConversationEntity r162 = (ConversationEntity) this.L$2;
            Iterator r163 = (Iterator) this.L$1;
            List r164 = (List) this.L$0;
            ResultKt.throwOnFailure(r610);
            r123 = r610;
            r114 = r162;
            r124 = r164;
            r125 = this;
            r106 = r163;
            goto L26
        L15:
            ResultKt.throwOnFailure(r610);
            Object r165 = r610;
        L19:
            r104 = new ArrayList();
            r118 = ((List) r165).iterator();
            r119 = this;
            goto L21
        L16:
            ResultKt.throwOnFailure(r610);
            be9.b r166 = ae9.b.a();
            List<String> r167 = CollectionsKt.toList(this.$map.keySet());
            this.label = 1;
            r165 = ((ConversationDaoSource) r166).h(r167, this);
            if (r165 != r100) goto L19;
            return r100;
        }
    }

    static {
        INSTANCE = new ConversationHandler();
    }

    private ConversationHandler() {
    }

    private final Long toMicroSecond(Long r100) {
        if (r100 == null) goto L11;
        r100.longValue();
        int r101 = r100.toString().length();
        if (r101 == 10) goto L10;
        if (r101 == 13) goto L13;
        return r100;
    L13:
        return Long.valueOf(r100.longValue() * ((long) 1000));
    L10:
        return Long.valueOf(r100.longValue() * ((long) 1000000));
    L11:
        return null;
    }

    public static final /* synthetic */ Long access$toMicroSecond(ConversationHandler r100, Long r101) {
        return r100.toMicroSecond(r101);
    }

    private final void logI(String r100, String r101) {
        com.larus.im.internal.delegate.a.f348188b.i(TAG, "<" + r100 + "> " + r101);
    }

    public final Object deleteConversation(String r100, Continuation<? super Boolean> r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L13;
        return Boxing.boxBoolean(false);
    L13:
        return OmniDatabaseExtKt.e(new AnonymousClass2(r100, null), r101);
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    public static final /* synthetic */ void access$logI(ConversationHandler r100, String r101, String r102) {
        r100.logI(r101, r102);
    }

    public final Object updateConversationBadgeCount(String r100, int r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r103 = (AnonymousClass1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        ResultKt.throwOnFailure(r105);
    L29:
        ConversationEntity r108 = (ConversationEntity) r105;
    L30:
        if (r108 == null) goto L33;
        CopyOnWriteArrayList<z<List<e>>> r109 = ConversationDispatcher.f347638a;
        ConversationDispatcher.a(CollectionsKt.listOf(ConversationConverterKt.c(r108)));
    L33:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L24:
        int r110 = ((Number) r105).intValue();
        r108 = null;
        if (r110 <= 0) goto L30;
        be9.b r111 = ae9.b.a();
        r103.L$0 = null;
        r103.label = 2;
        r105 = be9.b.C0295b.a(r111, r100, 0, r103, 6);
        if (r105 != r106) goto L29;
        return r106;
    L16:
        ResultKt.throwOnFailure(r105);
        if (r100 == null) goto L19;
        if (r101 <= 0) goto L33;
        be9.b r112 = ae9.b.a();
        r103.L$0 = r100;
        r103.label = 1;
        r105 = ((ConversationDaoSource) r112).z(r100, r101, r103);
        if (r105 != r106) goto L24;
        return r106;
    L19:
        return Unit.INSTANCE;
    L7:
        r103 = new AnonymousClass1(this, r102);
        goto L8
    }

    public final Object updateConversationLastMessage(List<MessageEntity> r100, boolean r101, Continuation<? super Unit> r102) {
        Object r103 = OmniDatabaseExtKt.e(new AnonymousClass4(l.a(r100), r101, null), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public final Object updateConversationStatus$core_release(String r510, @ConversationStatus int r511, Continuation<? super Boolean> r512) {
        if ((r512 instanceof ConversationHandler$updateConversationStatus$1) == false) goto L7;
        ConversationHandler$updateConversationStatus$1 r100 = (ConversationHandler$updateConversationStatus$1) r512;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = true;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ConversationEntity r106 = (ConversationEntity) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L35:
        if (((Boolean) r102).booleanValue() == false) goto L37;
        e r107 = ConversationConverterKt.c(r106);
        CopyOnWriteArrayList<z<List<e>>> r108 = ConversationDispatcher.f347638a;
        ConversationDispatcher.a(CollectionsKt.listOf(r107));
    L39:
        return Boxing.boxBoolean(r105);
    L37:
        r105 = false;
        goto L39
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r109 = r100.I$0;
        ResultKt.throwOnFailure(r102);
    L19:
        ConversationEntity r110 = (ConversationEntity) r102;
        if (r110 == null) goto L22;
        Integer r111 = r110.getStatus();
        if (r111 != null) goto L27;
    L30:
        ConversationEntity r112 = ConversationEntity.copy$default(r110, null, null, null, 0, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, null, null, null, null, null, null, Boxing.boxInt(r109), null, null, null, null, false, null, null, null, null, null, null, null, null, null, -16777217, 127, null);
        be9.b r113 = ae9.b.a();
        r100.L$0 = r112;
        r100.label = 2;
        r102 = ((ConversationDaoSource) r113).B(r110, r112, r100);
        if (r102 != r103) goto L33;
        return r103;
    L33:
        r106 = r112;
        goto L35
    L27:
        if (r111.intValue() != r109) goto L30;
        return Boxing.boxBoolean(false);
    L22:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r102);
        be9.b r114 = ae9.b.a();
        r109 = r511;
        r100.I$0 = r109;
        r100.label = 1;
        r102 = be9.b.C0295b.a(r114, r510, 0, r100, 6);
        if (r102 != r103) goto L19;
        return r103;
    L7:
        r100 = new ConversationHandler$updateConversationStatus$1(this, r512);
        goto L8
    }

    public final Object updateSection$core_release(String r100, String r101, Continuation<? super Unit> r110) {
        if ((r110 instanceof ConversationHandler$updateSection$1) == false) goto L7;
        ConversationHandler$updateSection$1 r102 = (ConversationHandler$updateSection$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        boolean r106 = false;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r101 = (String) r102.L$1;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r111);
    L28:
        ConversationEntity r112 = (ConversationEntity) r111;
        StringBuilder r107 = new StringBuilder("cvs(");
        r107.append(r100);
        r107.append(") updateSection ");
        r107.append(r101);
        r107.append(" (");
        if (r112 == null) goto L31;
        r106 = true;
    L31:
        r107.append(r106);
        r107.append(')');
        logI("updateSection", r107.toString());
        if (r112 == null) goto L35;
        CopyOnWriteArrayList<z<List<e>>> r108 = ConversationDispatcher.f347638a;
        ConversationDispatcher.a(CollectionsKt.listOf(ConversationConverterKt.c(r112)));
    L35:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        if (r100.length() != 0) goto L17;
        boolean r113 = true;
    L18:
        if (r113 == true) goto L37;
        if (r101.length() != 0) goto L22;
        boolean r114 = true;
    L23:
        if (r114 == true) goto L37;
        logI("updateSection", "cvs(" + r100 + "), sectionId: " + r101);
        ConversationHandler$updateSection$entity$1 r115 = new ConversationHandler$updateSection$entity$1(r100, r101, null);
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.label = 1;
        r111 = OmniDatabaseExtKt.e(r115, r102);
        if (r111 != r104) goto L28;
        return r104;
    L22:
        r114 = false;
    L37:
        return Unit.INSTANCE;
    L17:
        r113 = false;
    L7:
        r102 = new ConversationHandler$updateSection$1(this, r110);
        goto L8
    }

    public final Object getConversationByBotId(String r100, @ConversationType int r101, String r102, Continuation<? super List<ConversationEntity>> r103) {
        return OmniDatabaseExtKt.e(new C114592(j.c(r100, r102), r101, r100, null), r103);
    }

    public final Object updateConversation$core_release(ConversationInfo r110, boolean r111, WriteCvsInfo2EntityFrom r112, Continuation<? super Integer> r113) {
        if ((r113 instanceof ConversationHandler$updateConversation$1) == false) goto L7;
        ConversationHandler$updateConversation$1 r100 = (ConversationHandler$updateConversation$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r111 = r100.Z$0;
        Ref.LongRef r115 = (Ref.LongRef) r100.L$1;
        r112 = (WriteCvsInfo2EntityFrom) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L28:
        ConversationEntity r116 = (ConversationEntity) r114;
        if (r116 == null) goto L33;
        if (r111 == false) goto L33;
        CopyOnWriteArrayList<z<List<e>>> r117 = ConversationDispatcher.f347638a;
        ConversationDispatcher.a(CollectionsKt.listOf(ConversationConverterKt.c(r116)));
    L33:
        if (r112 != WriteCvsInfo2EntityFrom.CMD_CREATE) goto L36;
        r115.element = 1;
    L36:
        return Boxing.boxInt((int) r115.element);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        String r104 = r110.conversationId;
        if (r104 != null) goto L17;
    L20:
        boolean r105 = true;
    L21:
        if (r105 == true) goto L23;
        Ref.LongRef r118 = new Ref.LongRef();
        ConversationHandler$updateConversation$entity$1 r106 = new ConversationHandler$updateConversation$entity$1(r110, r112, r104, r118, null);
        r100.L$0 = r112;
        r100.L$1 = r118;
        r100.Z$0 = r111;
        r100.label = 1;
        Object r119 = OmniDatabaseExtKt.e(r106, r100);
        if (r119 != r102) goto L27;
        return r102;
    L27:
        r114 = r119;
        r115 = r118;
        goto L28
    L23:
        return Boxing.boxInt(0);
    L17:
        if (StringsKt.isBlank(r104) == true) goto L20;
        r105 = false;
    L7:
        r100 = new ConversationHandler$updateConversation$1(this, r113);
        goto L8
    }

    public final Object updateConversationLastMessage(MessageEntity r110, boolean r111, boolean r112, Continuation<? super Unit> r113) {
        com.larus.im.internal.delegate.a.f348188b.i(TAG, "update cvs message id = " + r110.getMessageId() + "  need notify = " + r111);
        String r100 = r110.getConversationId();
        if (r100 == null) goto L5;
        r110.getLocalIndex();
        Object r114 = OmniDatabaseExtKt.e(new C114612(r100, r110, r111, r112, null), r113);
        if (r114 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r114;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public final Object updateConversation$core_release(ConversationEntity r100, ConversationEntity r101, boolean r102, Continuation<? super Unit> r103) {
        if ((r103 instanceof ConversationHandler$updateConversation$2) == false) goto L7;
        ConversationHandler$updateConversation$2 r104 = (ConversationHandler$updateConversation$2) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        r102 = r104.Z$0;
        ResultKt.throwOnFailure(r106);
    L17:
        ConversationEntity r109 = (ConversationEntity) r106;
        if (r109 == null) goto L22;
        if (r102 == false) goto L22;
        CopyOnWriteArrayList<z<List<e>>> r110 = ConversationDispatcher.f347638a;
        ConversationDispatcher.a(CollectionsKt.listOf(ConversationConverterKt.c(r109)));
    L22:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        ConversationHandler$updateConversation$entity$2 r111 = new ConversationHandler$updateConversation$entity$2(r100, r101, null);
        r104.Z$0 = r102;
        r104.label = 1;
        r106 = OmniDatabaseExtKt.e(r111, r104);
        if (r106 != r107) goto L17;
        return r107;
    L7:
        r104 = new ConversationHandler$updateConversation$2(this, r103);
        goto L8
    }

    public final Object replaceOrCreate(String r100, ConversationInfo r101, boolean r110, WriteCvsInfo2EntityFrom r111, Continuation<? super Unit> r112) {
        Object r102 = OmniDatabaseExtKt.e(new C114602(r100, r110, r111, r101, null), r112);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object updateConversationLastMessage$default(ConversationHandler r100, List r101, boolean r102, Continuation r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = true;
    L6:
        return r100.updateConversationLastMessage(r101, r102, r103);
    }

    public static /* synthetic */ Object getConversationByBotId$default(ConversationHandler r100, String r101, int r102, String r103, Continuation r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = null;
    L9:
        return r100.getConversationByBotId(r101, r102, r103, r104);
    }

    public static /* synthetic */ Object updateConversation$core_release$default(ConversationHandler r100, ConversationInfo r101, boolean r102, WriteCvsInfo2EntityFrom r103, Continuation r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = true;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = WriteCvsInfo2EntityFrom.UNKNOWN;
    L9:
        return r100.updateConversation$core_release(r101, r102, r103, r104);
    }

    public static /* synthetic */ Object updateConversationLastMessage$default(ConversationHandler r100, MessageEntity r101, boolean r102, boolean r103, Continuation r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = true;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return r100.updateConversationLastMessage(r101, r102, r103, r104);
    }

    public static /* synthetic */ Object updateConversation$core_release$default(ConversationHandler r100, ConversationEntity r101, ConversationEntity r102, boolean r103, Continuation r104, int r105, Object r106) {
        if ((r105 & 4) == 0) goto L6;
        r103 = true;
    L6:
        return r100.updateConversation$core_release(r101, r102, r103, r104);
    }

    public static /* synthetic */ Object replaceOrCreate$default(ConversationHandler r100, String r101, ConversationInfo r102, boolean r103, WriteCvsInfo2EntityFrom r110, Continuation r111, int r112, Object r113) {
        if ((r112 & 4) == 0) goto L5;
        boolean r104 = true;
    L7:
        if ((r112 & 8) == 0) goto L10;
        r110 = WriteCvsInfo2EntityFrom.UNKNOWN;
    L10:
        return r100.replaceOrCreate(r101, r102, r104, r110, r111);
    L5:
        r104 = r103;
        goto L7
    }
}
