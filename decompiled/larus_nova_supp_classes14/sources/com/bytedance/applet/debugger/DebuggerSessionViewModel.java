package com.bytedance.applet.debugger;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.ai.api.DebugEntranceMode;
import com.bytedance.ai.api.DebuggerMode;
import com.bytedance.ai.api.DebuggerOpenArgs;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.applet.utils.MessageUtils;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import yc9.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001c\b\u0000\u0018\u0000 F2\u00020\u0001:\u0001FB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0003J\u000e\u0010-\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0003J\b\u0010.\u001a\u0004\u0018\u00010#J\u0006\u0010/\u001a\u00020#J\u0006\u00100\u001a\u00020+J\u0006\u00101\u001a\u00020+J\u000e\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020\u0014J\u0016\u00104\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u00105J\u0006\u00106\u001a\u00020\u001dJ\u000e\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020#J\b\u00109\u001a\u00020+H\u0014J\u0010\u0010:\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010;\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00108\u001a\u00020#H\u0002J\u0010\u0010<\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0016\u0010=\u001a\u00020\u001d2\u0006\u00108\u001a\u00020#H\u0082@¢\u0006\u0002\u0010>J\u0016\u0010?\u001a\u00020\u001d2\u0006\u00108\u001a\u00020#H\u0082@¢\u0006\u0002\u0010>J\u0010\u0010@\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0003H\u0002J\b\u0010A\u001a\u00020+H\u0002J\b\u0010B\u001a\u00020\u0018H\u0002J\b\u0010C\u001a\u00020\u0014H\u0002J\b\u0010D\u001a\u00020+H\u0002J\b\u0010E\u001a\u00020+H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010'\u001a\u0012\u0012\u0004\u0012\u00020#0(j\b\u0012\u0004\u0012\u00020#`)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/bytedance/applet/debugger/DebuggerSessionViewModel;", "Landroidx/lifecycle/ViewModel;", "initialArgs", "Lcom/bytedance/ai/api/DebuggerOpenArgs;", "conversationCreator", "Lcom/bytedance/applet/debugger/DebuggerConversationCreator;", "<init>", "(Lcom/bytedance/ai/api/DebuggerOpenArgs;Lcom/bytedance/applet/debugger/DebuggerConversationCreator;)V", "_sessionState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/applet/debugger/DebuggerSessionState;", "sessionState", "Lkotlinx/coroutines/flow/StateFlow;", "getSessionState", "()Lkotlinx/coroutines/flow/StateFlow;", "_mode", "Lcom/bytedance/ai/api/DebuggerMode;", "mode", "getMode", "_debugEntranceMode", "Lcom/bytedance/ai/api/DebugEntranceMode;", "debugEntranceMode", "getDebugEntranceMode", "_debugChannelState", "Lcom/bytedance/applet/debugger/DebuggerDebugChannelState;", "debugChannelState", "getDebugChannelState", "_clearChatHistoryResult", "Landroidx/lifecycle/MutableLiveData;", "", "clearChatHistoryResult", "Landroidx/lifecycle/LiveData;", "getClearChatHistoryResult", "()Landroidx/lifecycle/LiveData;", "botId", "", "generation", "", "lynxDevToolEnabled", "ownedConversationIds", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "handleNewOpenArgs", "", "args", "cleanupUnusedOpenArgs", "currentConversationId", "currentBotId", "refreshDebugChannelState", "onDebuggerPageReady", "switchDebugEntranceMode", "target", "switchMode", "(Lcom/bytedance/ai/api/DebuggerMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showConversationEnable", "clearHistory", "conversationId", "onCleared", "syncAISDKDebugMode", "rollbackModeSwitch", "createDebugLocalMsgIfNeeded", "hasChatHistory", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearHistoryInternal", "cleanupUnusedNewConversation", "cleanupOwnedConversations", "currentDebugChannelState", "currentDebugEntranceMode", "enableLynxDevToolIfNeeded", "disableLynxDevToolIfNeeded", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DebuggerSessionViewModel extends ViewModel {
    private static final CoroutineScope CLEANUP_SCOPE = null;
    private static final a Companion = null;
    public static final int MESSAGE_CONTENT_TYPE_WIDGET = 100;
    public static final long MODE_SWITCH_TIMEOUT_MS = 10000;
    public static final String TAG = "DebuggerSessionViewModel";
    private final MutableLiveData<Boolean> _clearChatHistoryResult;
    private final z0<DebuggerDebugChannelState> _debugChannelState;
    private final z0<DebugEntranceMode> _debugEntranceMode;
    private final z0<DebuggerMode> _mode;
    private final z0<y> _sessionState;
    private String botId;
    private final LiveData<Boolean> clearChatHistoryResult;
    private final DebuggerConversationCreator conversationCreator;
    private final i1<DebuggerDebugChannelState> debugChannelState;
    private final i1<DebugEntranceMode> debugEntranceMode;
    private long generation;
    private boolean lynxDevToolEnabled;
    private final i1<DebuggerMode> mode;
    private final LinkedHashSet<String> ownedConversationIds;
    private final i1<y> sessionState;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DebuggerMode.values().length];
            r0[DebuggerMode.ONLINE_PREVIEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[DebuggerMode.LOCAL_DEBUG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.applet.debugger.DebuggerSessionViewModel$cleanupOwnedConversations$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.debugger.DebuggerSessionViewModel$cleanupOwnedConversations$1", f = "DebuggerSessionViewModel.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $cleanupBotId;
        final /* synthetic */ List<String> $ids;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ DebuggerSessionViewModel this$0;

        public AnonymousClass1(List<String> r1, DebuggerSessionViewModel r2, String r3, Continuation<? super AnonymousClass1> r4) {
            this.$ids = r1;
            this.this$0 = r2;
            this.$cleanupBotId = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$ids, this.this$0, this.$cleanupBotId, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Iterator r2 = (Iterator) this.L$2;
            String r3 = (String) this.L$1;
            DebuggerSessionViewModel r4 = (DebuggerSessionViewModel) this.L$0;
            ResultKt.throwOnFailure(r8);
        L11:
            if (r2.hasNext() == false) goto L16;
            String r5 = (String) r2.next();
            DebuggerConversationCreator r6 = DebuggerSessionViewModel.access$getConversationCreator$p(r4);
            this.L$0 = r4;
            this.L$1 = r3;
            this.L$2 = r2;
            this.label = 1;
            if (r6.a(r5, r3, this) != r0) goto L11;
            return r0;
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            List<String> r9 = this.$ids;
            DebuggerSessionViewModel r7 = this.this$0;
            r3 = this.$cleanupBotId;
            r4 = r7;
            r2 = r9.iterator();
            goto L11
        }
    }

    /* JADX INFO: renamed from: com.bytedance.applet.debugger.DebuggerSessionViewModel$cleanupUnusedNewConversation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.debugger.DebuggerSessionViewModel$cleanupUnusedNewConversation$1", f = "DebuggerSessionViewModel.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DebuggerOpenArgs $args;
        int label;
        final /* synthetic */ DebuggerSessionViewModel this$0;

        public C02081(DebuggerSessionViewModel r1, DebuggerOpenArgs r2, Continuation<? super C02081> r3) {
            this.this$0 = r1;
            this.$args = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02081(this.this$0, this.$args, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            DebuggerConversationCreator r6 = DebuggerSessionViewModel.access$getConversationCreator$p(this.this$0);
            String r2 = this.$args.getConversationId();
            String r3 = this.$args.getBotId();
            this.label = 1;
            if (r6.a(r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.applet.debugger.DebuggerSessionViewModel$clearHistory$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.debugger.DebuggerSessionViewModel$clearHistory$1", f = "DebuggerSessionViewModel.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $conversationId;
        int label;
        final /* synthetic */ DebuggerSessionViewModel this$0;

        public C02091(DebuggerSessionViewModel r1, String r2, Continuation<? super C02091> r3) {
            this.this$0 = r1;
            this.$conversationId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02091(this.this$0, this.$conversationId, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            boolean r5 = ((Boolean) r4).booleanValue();
            DebuggerSessionViewModel.access$get_clearChatHistoryResult$p(this.this$0).postValue(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            DebuggerSessionViewModel r6 = this.this$0;
            String r2 = this.$conversationId;
            this.label = 1;
            r4 = DebuggerSessionViewModel.access$clearHistoryInternal(r6, r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.applet.debugger.DebuggerSessionViewModel$clearHistoryInternal$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.debugger.DebuggerSessionViewModel$clearHistoryInternal$2", f = "DebuggerSessionViewModel.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $conversationId;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(String r1, Continuation<? super AnonymousClass2> r2) {
            this.$conversationId = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$conversationId, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L15
        L13:
            Object r5 = Result.constructor-impl(Boxing.boxBoolean(ub8.d.a((ub8.b) r4)));     // Catch: Throwable -> L15
        L17:
            Boolean r2 = Boxing.boxBoolean(false);
            if (Result.isFailure-impl(r5) == true) goto L20;
            return r5;
        L20:
            return r2;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r4);
            CoroutineScope r6 = (CoroutineScope) this.L$0;
            String r7 = this.$conversationId;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
            IConversationRepoService r8 = zh8.a.b;     // Catch: Throwable -> L15
            this.label = 1;     // Catch: Throwable -> L15
            r4 = r8.q(r7, this);     // Catch: Throwable -> L15
            if (r4 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r5 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L17
        }
    }

    /* JADX INFO: renamed from: com.bytedance.applet.debugger.DebuggerSessionViewModel$hasChatHistory$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.debugger.DebuggerSessionViewModel$hasChatHistory$2", f = "DebuggerSessionViewModel.kt", i = {}, l = {194}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02102 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $conversationId;
        private /* synthetic */ Object L$0;
        int label;

        public C02102(String r1, Continuation<? super C02102> r2) {
            this.$conversationId = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02102 r0 = new C02102(this.$conversationId, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r3 = true;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L28
        L13:
            wc9.e r12 = (wc9.e) r11;     // Catch: Throwable -> L28
            if (r12 == null) goto L16;
            String r13 = r12.n;     // Catch: Throwable -> L28
        L17:
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            r3 = false;
        L26:
            Object r15 = Result.constructor-impl(Boxing.boxBoolean(r3));     // Catch: Throwable -> L28
        L30:
            Boolean r2 = Boxing.boxBoolean(false);
            if (Result.isFailure-impl(r15) == true) goto L33;
            return r15;
        L33:
            return r2;
        L19:
            if (StringsKt.isBlank(r13) == true) goto L22;
            r14 = false;
            goto L23
        L16:
            r13 = null;
            goto L17
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r11);
            CoroutineScope r16 = (CoroutineScope) this.L$0;
            String r5 = this.$conversationId;
            Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L28
            IConversationRepoService r4 = zh8.a.b;     // Catch: Throwable -> L28
            this.label = 1;     // Catch: Throwable -> L28
            r11 = IConversationRepoService.a.c(r4, r5, false, null, this, 6);     // Catch: Throwable -> L28
            if (r11 != r0) goto L13;
            return r0;
        L28:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L30
        }
    }

    /* JADX INFO: renamed from: com.bytedance.applet.debugger.DebuggerSessionViewModel$switchMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.debugger.DebuggerSessionViewModel", f = "DebuggerSessionViewModel.kt", i = {0, 0}, l = {121}, m = "switchMode", n = {"target", "currentConversationId"}, s = {"L$0", "L$1"})
    public static final class C02111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DebuggerSessionViewModel this$0;

        public C02111(DebuggerSessionViewModel r1, Continuation<? super C02111> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.switchMode(null, this);
        }
    }

    static {
        Companion = new a();
        CLEANUP_SCOPE = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    private final void cleanupOwnedConversations() {
        if (this.ownedConversationIds.isEmpty() == false) goto L5;
        return;
    L5:
        this.generation++;
        List r0 = CollectionsKt.toList(this.ownedConversationIds);
        this.ownedConversationIds.clear();
        String r1 = this.botId;
        FLogger.a.i(TAG, "cleanup Debugger conversations, count=" + r0.size());
        BuildersKt.launch$default(CLEANUP_SCOPE, null, null, new AnonymousClass1(r0, this, r1, null), 3, null);
    }

    private final DebuggerDebugChannelState currentDebugChannelState() {
        if (IAISDKDebugService.a.Q() == true) goto L6;
        return DebuggerDebugChannelState.DISCONNECTED;
    L6:
        return DebuggerDebugChannelState.CONNECTED;
    }

    private final DebugEntranceMode currentDebugEntranceMode() {
        if (IAISDKDebugService.a.n() == false) goto L6;
        return DebugEntranceMode.OPEN;
    L6:
        return DebugEntranceMode.CLOSE;
    }

    private final void disableLynxDevToolIfNeeded() {
        if (this.lynxDevToolEnabled == true) goto L14;
        return;
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        IAISDKDebugService.a.u();     // Catch: Throwable -> L7
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L12;
        FLogger.a.e(TAG, "disable Lynx DevTool failed", r2);
    L12:
        this.lynxDevToolEnabled = false;
        return;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    private final void enableLynxDevToolIfNeeded() {
        if (this.lynxDevToolEnabled == false) goto L13;
        return;
    L13:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        IAISDKDebugService.a.m();     // Catch: Throwable -> L7
        this.lynxDevToolEnabled = true;     // Catch: Throwable -> L7
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L15;
        FLogger.a.e(TAG, "enable Lynx DevTool failed", r2);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public final String currentConversationId() {
        Object r0 = this._sessionState.getValue();
        if ((r0 instanceof y.a) == false) goto L5;
        y.a r1 = (y.a) r0;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.a;
    L5:
        r1 = null;
        goto L6
    }

    public void onCleared() {
        FLogger.a.i(TAG, "Debugger ViewModel cleared, reset AISDK debug mode");
        disableLynxDevToolIfNeeded();
        IAISDKDebugService.a.C(IAISDKDebugService.DebugMode.NORMAL);
        cleanupOwnedConversations();
        super.onCleared();
    }

    public final void refreshDebugChannelState() {
        this._debugChannelState.setValue(currentDebugChannelState());
    }

    public final boolean showConversationEnable() {
        IAISDKDebugService.Companion r0 = IAISDKDebugService.a;
        boolean r3 = false;
        if (r0.getDebugMode() != IAISDKDebugService.DebugMode.LOCAL_DEBUG) goto L12;
        String r1 = r0.b();
        if (r1 != null) goto L7;
    L8:
        r3 = true;
    L10:
        return !r3;
    L7:
        if (StringsKt.isBlank(r1) == false) goto L10;
    L12:
        if (r0.getDebugMode() != IAISDKDebugService.DebugMode.SCAN_PREVIEW) goto L14;
        return true;
    L14:
        return false;
    }

    public static final /* synthetic */ CoroutineScope access$getCLEANUP_SCOPE$cp() {
        return CLEANUP_SCOPE;
    }

    public final String currentBotId() {
        return this.botId;
    }

    public final LiveData<Boolean> getClearChatHistoryResult() {
        return this.clearChatHistoryResult;
    }

    public final i1<DebuggerDebugChannelState> getDebugChannelState() {
        return this.debugChannelState;
    }

    public final i1<DebugEntranceMode> getDebugEntranceMode() {
        return this.debugEntranceMode;
    }

    public final i1<DebuggerMode> getMode() {
        return this.mode;
    }

    public final i1<y> getSessionState() {
        return this.sessionState;
    }

    public final void onDebuggerPageReady() {
        enableLynxDevToolIfNeeded();
    }

    public static final /* synthetic */ DebuggerConversationCreator access$getConversationCreator$p(DebuggerSessionViewModel r0) {
        return r0.conversationCreator;
    }

    public static final /* synthetic */ MutableLiveData access$get_clearChatHistoryResult$p(DebuggerSessionViewModel r0) {
        return r0._clearChatHistoryResult;
    }

    private final void cleanupUnusedNewConversation(DebuggerOpenArgs r8) {
        if (StringsKt.isBlank(r8.getConversationId()) == false) goto L5;
        return;
    L5:
        if (this.ownedConversationIds.contains(r8.getConversationId()) == true) goto L10;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02081(this, r8, null), 2, null);
        return;
    }

    private final void createDebugLocalMsgIfNeeded(DebuggerOpenArgs r25) {
        String r6 = r25.getMsgContent();
        if (Intrinsics.areEqual(r25.getEntryFrom(), "debug") == true) goto L5;
        return;
    L5:
        if (r25.getMode() != DebuggerMode.LOCAL_DEBUG) goto L17;
        if (r6 != null) goto L8;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == true) goto L18;
        MessageUtils r1 = MessageUtils.a;
        String r2 = r25.getConversationId();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r6, "content");
        String r3 = AccountService.a.getUserId();
        int r4 = wf9.b.a;
        List r5 = CollectionsKt.listOf(new f0(r2, null, r3, 0, 100, r6, com.flow.kmp.common.util.i.a(), null, 11, null, false, null, null, null, null, null, "Applet Widget Debug", null, null, null, null, 534772426));
        com.larus.im.d.e().batchAddMessage(r5, new com.bytedance.applet.utils.l());
        FLogger.a.i(TAG, "create debug local message");
        return;
    L18:
        return;
    L8:
        if (StringsKt.isBlank(r6) == true) goto L11;
        r0 = false;
        goto L12
    }

    private final void syncAISDKDebugMode(DebuggerMode r5) {
        int r0 = b.a[r5.ordinal()];
        if (r0 != 1) goto L5;
        IAISDKDebugService.DebugMode r1 = IAISDKDebugService.DebugMode.SCAN_PREVIEW;
    L10:
        FLogger.a.i(TAG, "sync AISDK debug mode: debuggerMode=" + r5 + ", aisdkDebugMode=" + r1);
        IAISDKDebugService.a.C(r1);
        return;
    L5:
        if (r0 != 2) goto L8;
        r1 = IAISDKDebugService.DebugMode.LOCAL_DEBUG;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void cleanupUnusedOpenArgs(DebuggerOpenArgs r2) {
        Intrinsics.checkNotNullParameter(r2, "args");
        cleanupUnusedNewConversation(r2);
    }

    public final void clearHistory(String r8) {
        Intrinsics.checkNotNullParameter(r8, "conversationId");
        if (StringsKt.isBlank(r8) == false) goto L6;
        this._clearChatHistoryResult.postValue(Boolean.FALSE);
        return;
    L6:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02091(this, r8, null), 3, null);
    }

    public final void handleNewOpenArgs(DebuggerOpenArgs r11) {
        Intrinsics.checkNotNullParameter(r11, "args");
        String r2 = currentConversationId();
        if (r2 != null) goto L5;
        return;
    L5:
        createDebugLocalMsgIfNeeded(DebuggerOpenArgs.copy$default(r11, r2, this.botId, null, null, null, null, 60, null));
        cleanupUnusedNewConversation(r11);
    }

    public final void switchDebugEntranceMode(DebugEntranceMode r3) {
        Intrinsics.checkNotNullParameter(r3, "target");
        if (r3 != this._debugEntranceMode.getValue()) goto L5;
        return;
    L5:
        IAISDKDebugService.Companion r0 = IAISDKDebugService.a;
        if (r3 != DebugEntranceMode.OPEN) goto L8;
        boolean r1 = true;
    L9:
        r0.M(r1);
        this._debugEntranceMode.setValue(r3);
        return;
    L8:
        r1 = false;
        goto L9
    }

    public DebuggerSessionViewModel(DebuggerOpenArgs r2, DebuggerConversationCreator r3) {
        Intrinsics.checkNotNullParameter(r2, "initialArgs");
        Intrinsics.checkNotNullParameter(r3, "conversationCreator");
        this.conversationCreator = r3;
        StateFlowImpl r4 = j1.a(new y.a(r2.getConversationId()));
        this._sessionState = r4;
        this.sessionState = kotlinx.coroutines.flow.e.b(r4);
        StateFlowImpl r5 = j1.a(r2.getMode());
        this._mode = r5;
        this.mode = kotlinx.coroutines.flow.e.b(r5);
        StateFlowImpl r6 = j1.a(currentDebugEntranceMode());
        this._debugEntranceMode = r6;
        this.debugEntranceMode = kotlinx.coroutines.flow.e.b(r6);
        StateFlowImpl r7 = j1.a(currentDebugChannelState());
        this._debugChannelState = r7;
        this.debugChannelState = kotlinx.coroutines.flow.e.b(r7);
        MutableLiveData<Boolean> r8 = new MutableLiveData();
        this._clearChatHistoryResult = r8;
        this.clearChatHistoryResult = r8;
        this.botId = r2.getBotId();
        LinkedHashSet<String> r9 = new LinkedHashSet();
        r9.add(r2.getConversationId());
        this.ownedConversationIds = r9;
        syncAISDKDebugMode(r2.getMode());
        createDebugLocalMsgIfNeeded(r2);
    }

    private final Object clearHistoryInternal(String r4, Continuation<? super Boolean> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(r4, null), r5);
    }

    private final Object hasChatHistory(String r4, Continuation<? super Boolean> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C02102(r4, null), r5);
    }

    private final void rollbackModeSwitch(DebuggerMode r2, String r3) {
        syncAISDKDebugMode(r2);
        this._sessionState.setValue(new y.a(r3));
    }

    public final Object switchMode(DebuggerMode r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof C02111) == false) goto L7;
        C02111 r0 = (C02111) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r14 = (String) r0.L$1;
        DebuggerMode r4 = (DebuggerMode) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L45:
        if (((Boolean) r13).booleanValue() == false) goto L47;
        clearHistory(r14);
        FLogger.a.i(TAG, "clear history before mode switch");
    L47:
        this._mode.setValue(r4);
        this._sessionState.setValue(new y.a(r14));
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        if (r11 != this._mode.getValue()) goto L19;
        return Boxing.boxBoolean(true);
    L19:
        if ((this._sessionState.getValue() instanceof y.a) == false) goto L21;
        DebuggerMode r15 = (DebuggerMode) this._mode.getValue();
        syncAISDKDebugMode(r11);
        refreshDebugChannelState();
        if (r11 == DebuggerMode.LOCAL_DEBUG) goto L25;
    L28:
        Object r5 = this._sessionState.getValue();
        if ((r5 instanceof y.a) == false) goto L31;
        y.a r6 = (y.a) r5;
    L32:
        if (r6 == null) goto L50;
        String r7 = r6.a;
        if (r7 == null) goto L50;
        long r8 = this.generation + 1;
        this.generation = r8;
        this._sessionState.setValue(new y.b(r7, r11));
        if (r8 == this.generation) goto L40;
        rollbackModeSwitch(r15, r7);
        return Boxing.boxBoolean(false);
    L40:
        r0.L$0 = r11;
        r0.L$1 = r7;
        r0.label = 1;
        r13 = hasChatHistory(r7, r0);
        if (r13 != r2) goto L43;
        return r2;
    L43:
        r4 = r11;
        r14 = r7;
    L50:
        return Boxing.boxBoolean(false);
    L31:
        r6 = null;
        goto L32
    L25:
        if (this._debugChannelState.getValue() == DebuggerDebugChannelState.CONNECTED) goto L28;
        syncAISDKDebugMode(r15);
        return Boxing.boxBoolean(false);
    L21:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new C02111(this, r12);
        goto L8
    }

    public static final /* synthetic */ Object access$clearHistoryInternal(DebuggerSessionViewModel r0, String r1, Continuation r2) {
        return r0.clearHistoryInternal(r1, r2);
    }

    public static final /* synthetic */ Object access$hasChatHistory(DebuggerSessionViewModel r0, String r1, Continuation r2) {
        return r0.hasChatHistory(r1, r2);
    }
}
