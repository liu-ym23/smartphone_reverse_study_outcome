package com.ss.android.lark.compose.chatsetting.add_chatter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lark.kmp.pb.basic.v1.LarkError;
import com.lark.kmp.pb.im.v1.AddChatChattersResponse;
import com.lark.kmp.rustclient.api.d;
import com.lark.kmp.rustclient.api.model.RustClientException;
import com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepository;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/add_chatter/AddMemberViewModel;", "Landroidx/lifecycle/ViewModel;", "chatId", "", "rustClient", "Lcom/lark/kmp/rustclient/api/IRustClient;", "<init>", "(Ljava/lang/String;Lcom/lark/kmp/rustclient/api/IRustClient;)V", "repository", "Lcom/ss/android/lark/compose/chatsetting/common/repository/ChatSettingRepository;", "_loading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "loading", "Lkotlinx/coroutines/flow/StateFlow;", "getLoading", "()Lkotlinx/coroutines/flow/StateFlow;", "_actionEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/ss/android/lark/compose/chatsetting/add_chatter/AddMemberViewModel$ActionEvent;", "actionEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getActionEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "addMembers", "", "chatterIds", "", "ActionEvent", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddMemberViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableSharedFlow<a> _actionEvent;
    private final z0<Boolean> _loading;
    private final d1<a> actionEvent;
    private final String chatId;
    private final i1<Boolean> loading;
    private final ChatSettingRepository repository;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.add_chatter.AddMemberViewModel$a$a, reason: collision with other inner class name */
        public static final class C4888a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4888a f417352a = null;

            static {
                f417352a = new C4888a();
            }

            public C4888a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f417353a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f417353a, ((b) r100).f417353a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                String r100 = this.f417353a;
                if (r100 != null) goto L6;
                return 0;
            L6:
                return r100.hashCode();
            }

            public final String toString() {
                return "OverLimit(message=" + this.f417353a + ')';
            }

            public b(String r100) {
                this.f417353a = r100;
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f417354a = null;

            static {
                f417354a = new c();
            }

            public c() {
            }
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.add_chatter.AddMemberViewModel$addMembers$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.add_chatter.AddMemberViewModel$addMembers$1", f = "AddMemberViewModel.kt", i = {}, l = {35, 46, 48, 53}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $chatterIds;
        Object L$0;
        int label;
        final /* synthetic */ AddMemberViewModel this$0;

        public AnonymousClass1(AddMemberViewModel r100, List<String> r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$chatterIds = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$chatterIds, r101);
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
            if (r101 == 0) goto L13;
            if (r101 == 1) goto L12;
            if (r101 == 2) goto L11;
            if (r101 == 3) goto L11;
            if (r101 == 4) goto L11;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r110);
        L48:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r110);
            Object r102 = ((Result) r110).m9458unboximpl();
        L16:
            AddMemberViewModel r103 = this.this$0;
            String r104 = null;
            int r105 = 0;
            if (Result.m9456isSuccessimpl(r102) == false) goto L19;
            AddChatChattersResponse r106 = (AddChatChattersResponse) r102;
            AddMemberViewModel.access$get_loading$p(r103).setValue(Boxing.boxBoolean(false));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(r103), null, null, new AddMemberViewModel$addMembers$1$1$1(r103, null), 3, null);
        L19:
            AddMemberViewModel r107 = this.this$0;
            Throwable r108 = Result.m9452exceptionOrNullimpl(r102);
            if (r108 == null) goto L48;
            AddMemberViewModel.access$get_loading$p(r107).setValue(Boxing.boxBoolean(false));
            if ((r108 instanceof RustClientException) == false) goto L42;
            RustClientException r109 = (RustClientException) r108;
            LarkError r111 = r109.getRustError();
            if (r111 == null) goto L28;
            Integer r112 = r111.getCode();
            if (r112 == null) goto L28;
            r105 = r112.intValue();
        L28:
            LarkError r113 = r109.getRustError();
            if (r113 == null) goto L32;
            r104 = r113.getDisplay_message();
        L32:
            if (r105 != 4013) goto L34;
        L38:
            MutableSharedFlow r114 = AddMemberViewModel.access$get_actionEvent$p(r107);
            a.b r115 = new a.b(r104);
            this.L$0 = r102;
            this.label = 2;
            if (r114.emit(r115, this) != r100) goto L48;
            return r100;
        L34:
            if (r105 == 6002) goto L38;
            MutableSharedFlow r116 = AddMemberViewModel.access$get_actionEvent$p(r107);
            a.C4888a r117 = a.C4888a.f417352a;
            this.L$0 = r102;
            this.label = 3;
            if (r116.emit(r117, this) != r100) goto L48;
            return r100;
        L42:
            if ((r108 instanceof CancellationException) == true) goto L48;
            MutableSharedFlow r118 = AddMemberViewModel.access$get_actionEvent$p(r107);
            a.C4888a r119 = a.C4888a.f417352a;
            this.L$0 = r102;
            this.label = 4;
            if (r118.emit(r119, this) != r100) goto L48;
            return r100;
        L13:
            ResultKt.throwOnFailure(r110);
            AddMemberViewModel.access$get_loading$p(this.this$0).setValue(Boxing.boxBoolean(true));
            ChatSettingRepository r120 = AddMemberViewModel.access$getRepository$p(this.this$0);
            String r121 = AddMemberViewModel.access$getChatId$p(this.this$0);
            List<String> r122 = this.$chatterIds;
            this.label = 1;
            r102 = r120.a(r121, r122, this);
            if (r102 != r100) goto L16;
            return r100;
        }
    }

    public final d1<a> getActionEvent() {
        return this.actionEvent;
    }

    public final i1<Boolean> getLoading() {
        return this.loading;
    }

    public static final /* synthetic */ String access$getChatId$p(AddMemberViewModel r100) {
        return r100.chatId;
    }

    public static final /* synthetic */ ChatSettingRepository access$getRepository$p(AddMemberViewModel r100) {
        return r100.repository;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_actionEvent$p(AddMemberViewModel r100) {
        return r100._actionEvent;
    }

    public static final /* synthetic */ z0 access$get_loading$p(AddMemberViewModel r100) {
        return r100._loading;
    }

    public final void addMembers(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "chatterIds");
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r100, null), 3, null);
    }

    public AddMemberViewModel(String r100, d r101) {
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
}
