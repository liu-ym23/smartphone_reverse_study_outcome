package com.larus.extension.chat_extension.impl.ltm;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.extension.chat_extension.impl.ltm.view.ChatLtmBaseHolder;
import com.larus.im.bean.bot.BotMemoryConfig;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 K2\u00020\u0001:\u0001KB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\u000e\u00107\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\u0016\u00108\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0082@¢\u0006\u0002\u00109J\u0006\u0010:\u001a\u00020;J\u0010\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010\u0007J\u0010\u0010>\u001a\u0002042\b\u0010=\u001a\u0004\u0018\u00010\u0007J\u001a\u0010?\u001a\u0004\u0018\u00010@2\b\u0010=\u001a\u0004\u0018\u00010\u0007H\u0082@¢\u0006\u0002\u0010AJ\u0014\u0010B\u001a\u0002042\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070!J\u001c\u0010D\u001a\u00020;2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070!H\u0082@¢\u0006\u0002\u0010EJ\u0006\u0010F\u001a\u000204J\u000e\u0010G\u001a\u00020;H\u0082@¢\u0006\u0002\u00109J \u0010H\u001a\u0002012\b\u0010I\u001a\u0004\u0018\u00010\u00072\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020)0-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "value", "", "botID", "getBotID", "()Ljava/lang/String;", "setBotID", "(Ljava/lang/String;)V", "conversationID", "getConversationID", "setConversationID", "currentPage", "getCurrentPage", "setCurrentPage", "previousPage", "getPreviousPage", "setPreviousPage", "targetMemoryContent", "getTargetMemoryContent", "setTargetMemoryContent", "config", "Lcom/larus/im/bean/bot/BotMemoryConfig;", "getConfig", "()Lcom/larus/im/bean/bot/BotMemoryConfig;", "setConfig", "(Lcom/larus/im/bean/bot/BotMemoryConfig;)V", "_itemListData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmItemData;", "itemListData", "Landroidx/lifecycle/LiveData;", "getItemListData", "()Landroidx/lifecycle/LiveData;", "_insertStatus", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/extension/chat_extension/impl/ltm/InsertBotRespStatus;", "get_insertStatus", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "insertStatus", "Lkotlinx/coroutines/flow/SharedFlow;", "getInsertStatus", "()Lkotlinx/coroutines/flow/SharedFlow;", "ids", "", "testContentList", "loadData", "", "initNoNetwork", "initList", "localList", "_requireLtmList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isOverCnt", "", "isOverSize", "content", "requireInsertLtmItem", "_requireInsertLtmItem", "Lcom/larus/extension/chat_extension/impl/ltm/InsertBotMemoryData;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireDeleteLtmItem", "memoryIDS", "_requireDeleteLtmItem", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireClearLtmItem", "_requireClearLtm", "findMemoryIndex", "memoryTipSubTitle", "list", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatLtmViewModel extends AndroidViewModel {
    public static final a Companion = null;
    private static final String TAG = "ChatLtmViewModel";
    private final MutableSharedFlow<InsertBotRespStatus> _insertStatus;
    private final MutableLiveData<List<r>> _itemListData;
    private String botID;
    private BotMemoryConfig config;
    private String conversationID;
    private String currentPage;
    private final List<Integer> ids;
    private final d1<InsertBotRespStatus> insertStatus;
    private final LiveData<List<r>> itemListData;
    private String previousPage;
    private String targetMemoryContent;
    private final List<String> testContentList;

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$_requireClearLtm$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel", f = "ChatLtmViewModel.kt", i = {}, l = {304}, m = "_requireClearLtm", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ChatLtmViewModel this$0;

        public AnonymousClass1(ChatLtmViewModel r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return ChatLtmViewModel.access$_requireClearLtm(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$_requireDeleteLtmItem$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel", f = "ChatLtmViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME}, m = "_requireDeleteLtmItem", n = {}, s = {})
    public static final class C114371 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ChatLtmViewModel this$0;

        public C114371(ChatLtmViewModel r100, Continuation<? super C114371> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return ChatLtmViewModel.access$_requireDeleteLtmItem(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$_requireInsertLtmItem$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel", f = "ChatLtmViewModel.kt", i = {}, l = {VideoRef.VALUE_VIDEO_REF_CATEGORY}, m = "_requireInsertLtmItem", n = {}, s = {})
    public static final class C114381 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ChatLtmViewModel this$0;

        public C114381(ChatLtmViewModel r100, Continuation<? super C114381> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return ChatLtmViewModel.access$_requireInsertLtmItem(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$_requireLtmList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel", f = "ChatLtmViewModel.kt", i = {}, l = {126}, m = "_requireLtmList", n = {}, s = {})
    public static final class C114391 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ChatLtmViewModel this$0;

        public C114391(ChatLtmViewModel r100, Continuation<? super C114391> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return ChatLtmViewModel.access$_requireLtmList(this.this$0, this);
        }
    }

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$loadData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$loadData$1", f = "ChatLtmViewModel.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    public static final class C114401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatLtmViewModel this$0;

        public C114401(ChatLtmViewModel r100, Continuation<? super C114401> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C114401(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C114401) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            List r103 = (List) r100;
            if (r103 == null) goto L14;
        L17:
            ChatLtmViewModel.access$get_itemListData$p(this.this$0).postValue(r103);
            return Unit.INSTANCE;
        L14:
            if (this.this$0.getBotID() == null) goto L16;
            r103 = ChatLtmViewModel.access$initNoNetwork(this.this$0);
            goto L17
        L16:
            r103 = ChatLtmViewModel.access$initList(this.this$0);
            goto L17
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ChatLtmViewModel r104 = this.this$0;
            this.label = 1;
            r100 = ChatLtmViewModel.access$_requireLtmList(r104, this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireClearLtmItem$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireClearLtmItem$1", f = "ChatLtmViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE}, m = "invokeSuspend", n = {}, s = {})
    public static final class C114411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatLtmViewModel this$0;

        public C114411(ChatLtmViewModel r100, Continuation<? super C114411> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C114411(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C114411) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            if (((Boolean) r100).booleanValue() == false) goto L15;
            ChatLtmViewModel.access$get_itemListData$p(this.this$0).postValue(ChatLtmViewModel.access$initNoNetwork(this.this$0));
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ChatLtmViewModel r103 = this.this$0;
            this.label = 1;
            r100 = ChatLtmViewModel.access$_requireClearLtm(r103, this);
            if (r100 != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireDeleteLtmItem$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireDeleteLtmItem$1", f = "ChatLtmViewModel.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
    public static final class C114421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $memoryIDS;
        int label;
        final /* synthetic */ ChatLtmViewModel this$0;

        public C114421(ChatLtmViewModel r100, List<String> r101, Continuation<? super C114421> r102) {
            this.this$0 = r100;
            this.$memoryIDS = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C114421(this.this$0, this.$memoryIDS, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C114421) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r210);
            Object r102 = r210;
        L12:
            if (((Boolean) r102).booleanValue() == false) goto L34;
            List r103 = (List) ChatLtmViewModel.access$get_itemListData$p(this.this$0).getValue();
            if (r103 == null) goto L34;
            List r104 = CollectionsKt.toMutableList(r103);
            if (r104 == null) goto L34;
            ChatLtmViewModel r105 = this.this$0;
            final List<String> r106 = this.$memoryIDS;
            CollectionsKt.removeAll(r104, new s(r106));
            ArrayList r107 = new ArrayList();
            Iterator r108 = r104.iterator();
            int r109 = 0;
        L19:
            if (r108.hasNext() == false) goto L32;
            Object r110 = r108.next();
            int r111 = r109 + 1;
            if (r109 >= 0) goto L23;
            CollectionsKt.throwIndexOverflow();
        L23:
            r r112 = (r) r110;
            if (r109 != 1) goto L26;
            boolean r113 = true;
        L28:
            if (r109 != (r104.size() - 1)) goto L30;
            boolean r114 = true;
        L31:
            String r115 = r112.f342870a;
            String r116 = r112.f342871b;
            ChatLtmStatus r117 = r112.f342872c;
            String r118 = r112.f342873d;
            int r119 = r112.f342874e;
            boolean r120 = r112.f342877h;
            r112.getClass();
            Intrinsics.checkNotNullParameter(r115, "id");
            Intrinsics.checkNotNullParameter(r116, "content");
            Intrinsics.checkNotNullParameter(r117, "status");
            Intrinsics.checkNotNullParameter(r118, "date");
            r107.add(new r(r115, r116, r117, r118, r119, r114, r113, r120));
            r109 = r111;
            goto L19
        L30:
            r114 = false;
            goto L31
        L26:
            r113 = false;
            goto L28
        L32:
            ChatLtmViewModel.access$get_itemListData$p(r105).postValue(r107);
        L34:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r210);
            ChatLtmViewModel r121 = this.this$0;
            List<String> r122 = this.$memoryIDS;
            this.label = 1;
            r102 = ChatLtmViewModel.access$_requireDeleteLtmItem(r121, r122, this);
            if (r102 != r100) goto L12;
            return r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$1", f = "ChatLtmViewModel.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
    public static final class C114431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatLtmViewModel this$0;

        public C114431(ChatLtmViewModel r100, Continuation<? super C114431> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C114431(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C114431) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            MutableSharedFlow<InsertBotRespStatus> r103 = this.this$0.get_insertStatus();
            InsertBotRespStatus r104 = InsertBotRespStatus.StartInsert;
            this.label = 1;
            if (r103.emit(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$2", f = "ChatLtmViewModel.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatLtmViewModel this$0;

        public AnonymousClass2(ChatLtmViewModel r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            MutableSharedFlow<InsertBotRespStatus> r103 = this.this$0.get_insertStatus();
            InsertBotRespStatus r104 = InsertBotRespStatus.OutOfCntLimit;
            this.label = 1;
            if (r103.emit(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$3", f = "ChatLtmViewModel.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatLtmViewModel this$0;

        public AnonymousClass3(ChatLtmViewModel r100, Continuation<? super AnonymousClass3> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass3(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            MutableSharedFlow<InsertBotRespStatus> r103 = this.this$0.get_insertStatus();
            InsertBotRespStatus r104 = InsertBotRespStatus.OutOfSizeLimit;
            this.label = 1;
            if (r103.emit(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$4", f = "ChatLtmViewModel.kt", i = {0, 1, 2, 3, 4, 5, 6}, l = {183, 199, 203, 207, 211, 215, 219}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "$this$launch", "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0"})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $content;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChatLtmViewModel this$0;

        /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$4$a */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f342845a = null;

            static {
                int[] r100 = new int[InsertBotRespStatus.values().length];
                r100[InsertBotRespStatus.Success.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r100[InsertBotRespStatus.OutOfCntLimit.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r100[InsertBotRespStatus.OutOfSizeLimit.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r100[InsertBotRespStatus.ReviewNotPass.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r100[InsertBotRespStatus.RepeatedMemory.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f342845a = r100;
            }
        }

        public AnonymousClass4(ChatLtmViewModel r100, String r101, Continuation<? super AnonymousClass4> r102) {
            this.this$0 = r100;
            this.$content = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass4 r102 = new AnonymousClass4(this.this$0, this.$content, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L8;
                case 1: goto L7;
                case 2: goto L6;
                case 3: goto L6;
                case 4: goto L6;
                case 5: goto L6;
                case 6: goto L6;
                case 7: goto L6;
                default: goto L5;
            };
        L6:
            CoroutineScope r101 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r110);
        L64:
            return Unit.INSTANCE;
        L7:
            CoroutineScope r102 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r110);
            Object r103 = r110;
        L11:
            InsertBotMemoryData r104 = (InsertBotMemoryData) r103;
            if (r104 == null) goto L62;
            ChatLtmViewModel r105 = this.this$0;
            String r106 = this.$content;
            InsertBotRespStatus r107 = r104.getStatus();
            if (r107 != null) goto L16;
            int r108 = -1;
        L18:
            if (r108 == 1) goto L42;
            if (r108 != 2) goto L22;
            MutableSharedFlow<InsertBotRespStatus> r109 = r105.get_insertStatus();
            InsertBotRespStatus r111 = InsertBotRespStatus.OutOfCntLimit;
            this.L$0 = r102;
            this.label = 3;
            if (r109.emit(r111, this) != r100) goto L64;
            return r100;
        L22:
            if (r108 != 3) goto L24;
            MutableSharedFlow<InsertBotRespStatus> r112 = r105.get_insertStatus();
            InsertBotRespStatus r113 = InsertBotRespStatus.OutOfSizeLimit;
            this.L$0 = r102;
            this.label = 4;
            if (r112.emit(r113, this) != r100) goto L64;
            return r100;
        L24:
            if (r108 == 4) goto L32;
            if (r108 == 5) goto L29;
            MutableSharedFlow<InsertBotRespStatus> r114 = r105.get_insertStatus();
            InsertBotRespStatus r115 = InsertBotRespStatus.FailInsert;
            this.L$0 = r102;
            this.label = 7;
            if (r114.emit(r115, this) != r100) goto L64;
            return r100;
        L29:
            MutableSharedFlow<InsertBotRespStatus> r116 = r105.get_insertStatus();
            InsertBotRespStatus r117 = InsertBotRespStatus.RepeatedMemory;
            this.L$0 = r102;
            this.label = 6;
            if (r116.emit(r117, this) != r100) goto L64;
            return r100;
        L32:
            MutableSharedFlow<InsertBotRespStatus> r118 = r105.get_insertStatus();
            InsertBotRespStatus r119 = InsertBotRespStatus.ReviewNotPass;
            this.L$0 = r102;
            this.label = 5;
            if (r118.emit(r119, this) != r100) goto L64;
            return r100;
        L42:
            if (r104.getMemoryId() == null) goto L64;
            if (((List) ChatLtmViewModel.access$get_itemListData$p(r105).getValue()) == null) goto L58;
            List r120 = (List) ChatLtmViewModel.access$get_itemListData$p(r105).getValue();
            if (r120 == null) goto L58;
            ArrayList r121 = new ArrayList();
            Iterator r122 = r120.iterator();
        L50:
            if (r122.hasNext() == false) goto L57;
            Object r123 = r122.next();
            if (((r) r123).f342872c != ChatLtmStatus.PLACEHOLDER) goto L54;
            boolean r124 = true;
        L55:
            if (r124 == true) goto L50;
            r121.add(r123);
            goto L50
        L54:
            r124 = false;
            goto L55
        L57:
            List r125 = CollectionsKt.toMutableList(r121);
            int r126 = 2;
            ListProtector.add(r125, 2, new r(r104.getMemoryId(), r106, ChatLtmStatus.NORMAL, null, 0, false, false, false, 248));
            ChatLtmViewModel.access$get_itemListData$p(r105).postValue(r125);
        L59:
            MutableSharedFlow<InsertBotRespStatus> r127 = r105.get_insertStatus();
            InsertBotRespStatus r128 = InsertBotRespStatus.Success;
            this.L$0 = r102;
            this.label = r126;
            if (r127.emit(r128, this) != r100) goto L64;
            return r100;
        L58:
            r126 = 2;
            goto L59
        L16:
            r108 = a.f342845a[r107.ordinal()];
            goto L18
        L62:
            ChatLtmViewModel r129 = this.this$0;
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(r129), null, null, new ChatLtmViewModel$requireInsertLtmItem$4$2$1(r129, null), 3, null);
            goto L64
        L8:
            ResultKt.throwOnFailure(r110);
            r102 = (CoroutineScope) this.L$0;
            ChatLtmViewModel r130 = this.this$0;
            String r131 = this.$content;
            this.L$0 = r102;
            this.label = 1;
            r103 = ChatLtmViewModel.access$_requireInsertLtmItem(r130, r131, this);
            if (r103 != r100) goto L11;
            return r100;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    private final List<r> initList() {
        return CollectionsKt.listOf(new r("-1", "", ChatLtmStatus.NO_STATUS, null, ChatLtmBaseHolder.Companion.ChatItemViewType.TITLE.getValue(), false, false, false, VideoRef.VALUE_VIDEO_REF_CATEGORY));
    }

    private final List<r> initNoNetwork() {
        return CollectionsKt.listOf(new r("-1", "", ChatLtmStatus.NO_STATUS, null, ChatLtmBaseHolder.Companion.ChatItemViewType.TITLE.getValue(), false, false, false, VideoRef.VALUE_VIDEO_REF_CATEGORY));
    }

    public final boolean isOverCnt() {
        List<r> r100 = this.itemListData.getValue();
        if (r100 == null) goto L5;
        int r101 = r100.size();
    L6:
        int r102 = r101 - 1;
        BotMemoryConfig r103 = this.config;
        if (r103 == null) goto L11;
        Integer r104 = r103.getBotMemoryCntLimit();
        if (r104 == null) goto L11;
        int r105 = r104.intValue();
    L12:
        if (r102 < r105) goto L15;
        return true;
    L15:
        return false;
    L11:
        r105 = Integer.MAX_VALUE;
        goto L12
    L5:
        r101 = 0;
        goto L6
    }

    private final List<r> localList() {
        return CollectionsKt.toMutableList(initList());
    }

    public final void loadData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C114401(this, null), 2, null);
    }

    public final void requireClearLtmItem() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C114411(this, null), 2, null);
    }

    public final String getBotID() {
        return this.botID;
    }

    public final BotMemoryConfig getConfig() {
        return this.config;
    }

    public final String getConversationID() {
        return this.conversationID;
    }

    public final String getCurrentPage() {
        return this.currentPage;
    }

    public final d1<InsertBotRespStatus> getInsertStatus() {
        return this.insertStatus;
    }

    public final LiveData<List<r>> getItemListData() {
        return this.itemListData;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getTargetMemoryContent() {
        return this.targetMemoryContent;
    }

    public final MutableSharedFlow<InsertBotRespStatus> get_insertStatus() {
        return this._insertStatus;
    }

    public ChatLtmViewModel(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        super(r100);
        MutableLiveData<List<r>> r101 = new MutableLiveData();
        this._itemListData = r101;
        this.itemListData = r101;
        MutableSharedFlow<InsertBotRespStatus> r102 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._insertStatus = r102;
        this.insertStatus = r102;
        loadData();
        List<Integer> r103 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.string.larus_add_memory_1), Integer.valueOf(R.string.larus_add_memory_2), Integer.valueOf(R.string.larus_add_memory_3), Integer.valueOf(R.string.larus_add_memory_4)});
        this.ids = r103;
        List<Integer> r104 = r103;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L10;
        int r107 = ((Number) r106.next()).intValue();
        if (com.larus.utils.i.h(r100) == true) goto L8;
        String r108 = r100.getString(R.string.larus_add_memory_example_text) + r100.getString(r107);
    L9:
        r105.add(r108);
        goto L4
    L8:
        r108 = r100.getString(r107) + r100.getString(R.string.larus_add_memory_example_text);
        goto L9
    L10:
        this.testContentList = r105;
    }

    private final Object _requireClearLtm(Continuation<? super Boolean> r110) {
        if ((r110 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r100 = (AnonymousClass1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        AnonymousClass1 r111 = r100;
        Object r102 = r111.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r111.label;
        boolean r112 = true;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L21:
        com.larus.network.http.a r105 = (com.larus.network.http.a) r102;
        if ((r105 instanceof com.larus.network.http.f) == false) goto L25;
        FLogger.f375446a.e(TAG, "_requireClearLtm error, msg is " + ((com.larus.network.http.f) r105).f360157d.getMessage());
        r112 = false;
    L25:
        return Boxing.boxBoolean(r112);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (this.botID == null) goto L17;
        JSONObject r106 = new JSONObject();
        r106.put("bot_id", this.botID);
        Unit r107 = Unit.INSTANCE;
        r111.label = 1;
        r102 = HttpExtKt.k(ServiceType.IM, ClearOrDeleteResponse.class, "/chat/memory/clear", r106, null, null, false, null, null, null, r111, 1008);
        if (r102 != r103) goto L21;
        return r103;
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r100 = new AnonymousClass1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object _requireLtmList(Continuation<? super List<r>> r210) {
        if ((r210 instanceof C114391) == false) goto L7;
        C114391 r100 = (C114391) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        C114391 r110 = r100;
        Object r102 = r110.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        List r111 = null;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L23:
        com.larus.network.http.a r105 = (com.larus.network.http.a) r102;
        if ((r105 instanceof com.larus.network.http.f) == false) goto L26;
        FLogger.f375446a.e(TAG, "getUserLtmList error, msg is " + ((com.larus.network.http.f) r105).f360157d.getMessage());
        return null;
    L26:
        ListBotMemoryDataV2 r106 = (ListBotMemoryDataV2) r105.f360135b;
        if (r106 == null) goto L34;
        List<BotMemoryItemV2> r107 = r106.getSavedMemory();
        if (r107 == null) goto L34;
        if ((!r107.isEmpty()) == false) goto L34;
    L36:
        if (r107 == null) goto L64;
        List<BotMemoryItemV2> r108 = r107;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r112 = r108.iterator();
        int r113 = 0;
    L39:
        if (r112.hasNext() == false) goto L63;
        Object r114 = r112.next();
        int r115 = r113 + 1;
        if (r113 >= 0) goto L43;
        CollectionsKt.throwIndexOverflow();
    L43:
        BotMemoryItemV2 r116 = (BotMemoryItemV2) r114;
        String r117 = r116.getId();
        if (r117 != null) goto L46;
        String r118 = "";
    L47:
        String r119 = r116.getContent();
        if (r119 != null) goto L50;
        String r120 = "";
    L51:
        ChatLtmStatus r121 = ChatLtmStatus.NORMAL;
        String r122 = r116.getDate();
        if (r122 != null) goto L54;
        String r123 = "";
    L55:
        if (r113 != 0) goto L57;
        boolean r124 = true;
    L59:
        if (r113 != (r107.size() - 1)) goto L61;
        boolean r125 = true;
    L62:
        r109.add(new r(r118, r120, r121, r123, 0, r125, r124, Intrinsics.areEqual(r116.getContent(), this.targetMemoryContent), 16));
        r113 = r115;
        goto L39
    L61:
        r125 = false;
        goto L62
    L57:
        r124 = false;
        goto L59
    L54:
        r123 = r122;
        goto L55
    L50:
        r120 = r119;
        goto L51
    L46:
        r118 = r117;
        goto L47
    L63:
        r111 = CollectionsKt.toMutableList(r109);
    L64:
        List r126 = r111;
        if (r126 == null) goto L67;
        Boxing.boxBoolean(r126.addAll(0, initList()));
    L67:
        if (r126 != null) goto L70;
        return localList();
    L70:
        return r126;
    L34:
        r107 = null;
        goto L36
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (this.botID != null) goto L18;
        FLogger.f375446a.e(TAG, "botID is null");
        Unit r127 = Unit.INSTANCE;
    L18:
        if (this.botID != null) goto L20;
        return null;
    L20:
        JSONObject r128 = new JSONObject();
        r128.put("bot_id", this.botID);
        Unit r129 = Unit.INSTANCE;
        r110.label = 1;
        r102 = HttpExtKt.k(ServiceType.IM, ListBotMemoryDataV2.class, "/chat/memory/list", r128, null, null, false, null, null, null, r110, 1008);
        if (r102 != r103) goto L23;
        return r103;
    L7:
        r100 = new C114391(this, r210);
        goto L8
    }

    public static final /* synthetic */ MutableLiveData access$get_itemListData$p(ChatLtmViewModel r100) {
        return r100._itemListData;
    }

    public static final /* synthetic */ List access$initList(ChatLtmViewModel r100) {
        return r100.initList();
    }

    public static final /* synthetic */ List access$initNoNetwork(ChatLtmViewModel r100) {
        return r100.initNoNetwork();
    }

    public final boolean isOverSize(String r100) {
        if (r100 == null) goto L5;
        int r101 = r100.length();
    L6:
        BotMemoryConfig r102 = this.config;
        if (r102 == null) goto L11;
        Integer r103 = r102.getBotMemorySizeLimit();
        if (r103 == null) goto L11;
        int r104 = r103.intValue();
    L12:
        if (r101 <= r104) goto L15;
        return true;
    L15:
        return false;
    L11:
        r104 = Integer.MAX_VALUE;
        goto L12
    L5:
        r101 = 0;
        goto L6
    }

    public final void requireDeleteLtmItem(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "memoryIDS");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C114421(this, r100, null), 2, null);
    }

    public final void requireInsertLtmItem(String r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C114431(this, null), 3, null);
        if (isOverCnt() == false) goto L8;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, null), 3, null);
        return;
    L8:
        int r100 = r110.length();
        BotMemoryConfig r101 = this.config;
        if (r101 == null) goto L13;
        Integer r102 = r101.getBotMemorySizeLimit();
        if (r102 == null) goto L13;
        int r103 = r102.intValue();
    L14:
        if (r100 <= r103) goto L17;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass3(this, null), 3, null);
        return;
    L17:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass4(this, r110, null), 2, null);
        return;
    L13:
        r103 = Integer.MAX_VALUE;
        goto L14
    }

    public final void setBotID(String r100) {
        this.botID = r100;
        loadData();
    }

    public final void setConfig(BotMemoryConfig r100) {
        this.config = r100;
    }

    public final void setConversationID(String r100) {
        this.conversationID = r100;
    }

    public final void setCurrentPage(String r100) {
        this.currentPage = r100;
    }

    public final void setPreviousPage(String r100) {
        this.previousPage = r100;
    }

    public final void setTargetMemoryContent(String r100) {
        this.targetMemoryContent = r100;
    }

    private final Object _requireDeleteLtmItem(List<String> r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof C114371) == false) goto L7;
        C114371 r100 = (C114371) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        C114371 r112 = r100;
        Object r102 = r112.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r112.label;
        boolean r113 = true;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L21:
        com.larus.network.http.a r105 = (com.larus.network.http.a) r102;
        if ((r105 instanceof com.larus.network.http.f) == false) goto L25;
        FLogger.f375446a.e(TAG, "requireDeleteLtmItem error, msg is " + ((com.larus.network.http.f) r105).f360157d.getMessage());
        r113 = false;
    L25:
        return Boxing.boxBoolean(r113);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (this.botID == null) goto L17;
        JSONObject r106 = new JSONObject();
        r106.put("bot_id", this.botID);
        JSONObject r107 = new JSONObject();
        r107.put("saved_memory", new JSONArray(r110));
        Unit r108 = Unit.INSTANCE;
        r106.put("memory_ids", r107);
        r112.label = 1;
        r102 = HttpExtKt.k(ServiceType.IM, ClearOrDeleteResponse.class, "/chat/memory/delete", r106, null, null, false, null, null, null, r112, 1008);
        if (r102 != r103) goto L21;
        return r103;
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r100 = new C114371(this, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object _requireInsertLtmItem(String r110, Continuation<? super InsertBotMemoryData> r111) {
        if ((r111 instanceof C114381) == false) goto L7;
        C114381 r100 = (C114381) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        C114381 r112 = r100;
        Object r102 = r112.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r112.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L20:
        com.larus.network.http.a r105 = (com.larus.network.http.a) r102;
        if ((r105 instanceof com.larus.network.http.f) == false) goto L24;
        FLogger.f375446a.e(TAG, "requireInsertLtmItem error, msg is " + ((com.larus.network.http.f) r105).f360157d.getMessage());
        return null;
    L24:
        return (InsertBotMemoryData) r105.f360135b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (this.botID != null) goto L17;
        return null;
    L17:
        JSONObject r106 = new JSONObject();
        r106.put("bot_id", this.botID);
        r106.put("memory_content", r110);
        Unit r107 = Unit.INSTANCE;
        r112.label = 1;
        r102 = HttpExtKt.k(ServiceType.IM, InsertBotMemoryData.class, "/alice/bot/insert_memory", r106, null, null, false, null, null, null, r112, 1008);
        if (r102 != r103) goto L20;
        return r103;
    L7:
        r100 = new C114381(this, r111);
        goto L8
    }

    public static final /* synthetic */ Object access$_requireClearLtm(ChatLtmViewModel r100, Continuation r101) {
        return r100._requireClearLtm(r101);
    }

    public static final /* synthetic */ Object access$_requireLtmList(ChatLtmViewModel r100, Continuation r101) {
        return r100._requireLtmList(r101);
    }

    public final int findMemoryIndex(String r100, List<r> r110) {
        Integer r101 = null;
        if (r100 == null) goto L5;
        String r102 = StringsKt.trim(r100).toString();
    L6:
        if (r110 != null) goto L9;
        r110 = CollectionsKt.emptyList();
    L9:
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == false) goto L17;
        return 0;
    L17:
        if (r110.isEmpty() == true) goto L52;
        int r104 = r110.size();
        int r105 = 0;
    L20:
        if (r105 >= r104) goto L39;
        r r106 = (r) ListProtector.get(r110, r105);
        if (r106.f342872c == ChatLtmStatus.NO_STATUS) goto L38;
        String r107 = r106.f342871b;
        if (r107.length() != 0) goto L26;
        boolean r108 = true;
    L27:
        if (r108 == true) goto L38;
        if (Intrinsics.areEqual(r107, r102) == true) goto L30;
        if (StringsKt.equals(r107, r102, true) == true) goto L33;
        if (r101 != null) goto L38;
        if (StringsKt.contains(r107, r102, true) == false) goto L38;
        r101 = Integer.valueOf(r105);
        goto L38
    L33:
        return r105;
    L30:
        return r105;
    L26:
        r108 = false;
    L38:
        r105 = r105 + 1;
        goto L20
    L39:
        if (r101 != null) goto L41;
        return 0;
    L41:
        return r101.intValue();
    L52:
        return 0;
    L11:
        if (r102.length() == 0) goto L14;
        r103 = false;
        goto L15
    L5:
        r102 = null;
        goto L6
    }

    public static final /* synthetic */ Object access$_requireDeleteLtmItem(ChatLtmViewModel r100, List r101, Continuation r102) {
        return r100._requireDeleteLtmItem(r101, r102);
    }

    public static final /* synthetic */ Object access$_requireInsertLtmItem(ChatLtmViewModel r100, String r101, Continuation r102) {
        return r100._requireInsertLtmItem(r101, r102);
    }
}
