package com.ss.android.lark.compose.chatsetting.remove_chatter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lark.kmp.pb.im.v1.DeleteChatChattersResponse;
import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepository;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/remove_chatter/RemoveChatterViewModel;", "Landroidx/lifecycle/ViewModel;", "chatId", "", "rustClient", "Lcom/lark/kmp/rustclient/api/IRustClient;", "<init>", "(Ljava/lang/String;Lcom/lark/kmp/rustclient/api/IRustClient;)V", "repository", "Lcom/ss/android/lark/compose/chatsetting/common/repository/ChatSettingRepository;", "_loading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "loading", "Lkotlinx/coroutines/flow/StateFlow;", "getLoading", "()Lkotlinx/coroutines/flow/StateFlow;", "_actionEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/ss/android/lark/compose/chatsetting/remove_chatter/RemoveChatterViewModel$ActionEvent;", "actionEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getActionEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "removeMembers", "", "chatterIds", "", "withdraw", "ActionEvent", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoveChatterViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableSharedFlow<a> _actionEvent;
    private final z0<Boolean> _loading;
    private final d1<a> actionEvent;
    private final String chatId;
    private final i1<Boolean> loading;
    private final ChatSettingRepository repository;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.remove_chatter.RemoveChatterViewModel$a$a, reason: collision with other inner class name */
        public static final class C4901a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4901a f417481a = null;

            static {
                f417481a = new C4901a();
            }

            public C4901a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f417482a = null;

            static {
                f417482a = new b();
            }

            public b() {
            }
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.remove_chatter.RemoveChatterViewModel$removeMembers$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.remove_chatter.RemoveChatterViewModel$removeMembers$1", f = "RemoveChatterViewModel.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<String> $chatterIds;
        final /* synthetic */ boolean $withdraw;
        int label;
        final /* synthetic */ RemoveChatterViewModel this$0;

        public AnonymousClass1(RemoveChatterViewModel r100, Set<String> r101, boolean r102, Continuation<? super AnonymousClass1> r103) {
            this.this$0 = r100;
            this.$chatterIds = r101;
            this.$withdraw = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$chatterIds, this.$withdraw, r101);
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
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
            Object r111 = ((Result) r110).m9458unboximpl();
        L11:
            RemoveChatterViewModel r102 = this.this$0;
            if (Result.m9456isSuccessimpl(r111) == false) goto L14;
            DeleteChatChattersResponse r103 = (DeleteChatChattersResponse) r111;
            RemoveChatterViewModel.access$get_loading$p(r102).setValue(Boxing.boxBoolean(false));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(r102), null, null, new RemoveChatterViewModel$removeMembers$1$1$1(r102, null), 3, null);
        L14:
            RemoveChatterViewModel r104 = this.this$0;
            Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
            if (r112 == null) goto L20;
            if ((r112 instanceof CancellationException) == true) goto L20;
            RemoveChatterViewModel.access$get_loading$p(r104).setValue(Boxing.boxBoolean(false));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(r104), null, null, new RemoveChatterViewModel$removeMembers$1$2$1(r104, null), 3, null);
        L20:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            RemoveChatterViewModel.access$get_loading$p(this.this$0).setValue(Boxing.boxBoolean(true));
            ChatSettingRepository r113 = RemoveChatterViewModel.access$getRepository$p(this.this$0);
            String r105 = RemoveChatterViewModel.access$getChatId$p(this.this$0);
            List<String> r106 = CollectionsKt.toList(this.$chatterIds);
            boolean r107 = this.$withdraw;
            this.label = 1;
            r111 = r113.n(r105, r106, r107, this);
            if (r111 != r100) goto L11;
            return r100;
        }
    }

    public final d1<a> getActionEvent() {
        return this.actionEvent;
    }

    public final i1<Boolean> getLoading() {
        return this.loading;
    }

    public static final /* synthetic */ String access$getChatId$p(RemoveChatterViewModel r100) {
        return r100.chatId;
    }

    public static final /* synthetic */ ChatSettingRepository access$getRepository$p(RemoveChatterViewModel r100) {
        return r100.repository;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_actionEvent$p(RemoveChatterViewModel r100) {
        return r100._actionEvent;
    }

    public static final /* synthetic */ z0 access$get_loading$p(RemoveChatterViewModel r100) {
        return r100._loading;
    }

    public RemoveChatterViewModel(String r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "rustClient");
        this.chatId = r100;
        this.repository = new ChatSettingRepository(r101);
        StateFlowImpl r102 = j1.a(Boolean.FALSE);
        this._loading = r102;
        this.loading = e.b(r102);
        MutableSharedFlow<a> r103 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._actionEvent = r103;
        this.actionEvent = e.a(r103);
    }

    public final void removeMembers(Set<String> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "chatterIds");
        if (StringsKt.isBlank(this.chatId) == false) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L10;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r100, r101, null), 3, null);
        return;
    }

    public static /* synthetic */ void removeMembers$default(RemoveChatterViewModel r100, Set r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        r100.removeMembers(r101, r102);
    }
}
