package com.ss.android.lark.compose.chatsetting.update_manager;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.pb.im.v1.PatchChatAdminUsersResponse;
import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001f\u001a\u00020 H\u0002J\u0014\u0010!\u001a\u00020 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00150\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00150\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/update_manager/UpdateManagerViewModel;", "Landroidx/lifecycle/ViewModel;", "chatId", "", "rustClient", "Lcom/lark/kmp/rustclient/api/IRustClient;", "<init>", "(Ljava/lang/String;Lcom/lark/kmp/rustclient/api/IRustClient;)V", "repository", "Lcom/ss/android/lark/compose/chatsetting/common/repository/ChatSettingRepository;", "_loading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "loading", "Lkotlinx/coroutines/flow/StateFlow;", "getLoading", "()Lkotlinx/coroutines/flow/StateFlow;", "_adminLoaded", "adminLoaded", "getAdminLoaded", "_currentAdminIds", "", "currentAdminIds", "getCurrentAdminIds", "_actionEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/ss/android/lark/compose/chatsetting/update_manager/UpdateManagerViewModel$ActionEvent;", "actionEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getActionEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "fetchCurrentAdmins", "", "updateAdmins", "selectedAdminIds", "ActionEvent", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateManagerViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableSharedFlow<a> _actionEvent;
    private final z0<Boolean> _adminLoaded;
    private final z0<Set<String>> _currentAdminIds;
    private final z0<Boolean> _loading;
    private final d1<a> actionEvent;
    private final i1<Boolean> adminLoaded;
    private final String chatId;
    private final i1<Set<String>> currentAdminIds;
    private final i1<Boolean> loading;
    private final ChatSettingRepository repository;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerViewModel$a$a, reason: collision with other inner class name */
        public static final class C4904a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4904a f417521a = null;

            static {
                f417521a = new C4904a();
            }

            public C4904a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f417522a = null;

            static {
                f417522a = new b();
            }

            public b() {
            }
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerViewModel$fetchCurrentAdmins$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerViewModel$fetchCurrentAdmins$1", f = "UpdateManagerViewModel.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ UpdateManagerViewModel this$0;

        public AnonymousClass1(UpdateManagerViewModel r100, Continuation<? super AnonymousClass1> r101) {
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
            Object r103 = ((Result) r100).m9458unboximpl();
        L11:
            UpdateManagerViewModel r104 = this.this$0;
            if (Result.m9456isSuccessimpl(r103) == false) goto L18;
            z0 r105 = UpdateManagerViewModel.access$get_currentAdminIds$p(r104);
            List r106 = (List) r103;
            ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
            Iterator r108 = r106.iterator();
        L15:
            if (r108.hasNext() == false) goto L17;
            r107.add(((Chatter) r108.next()).getId());
            goto L15
        L17:
            r105.setValue(CollectionsKt.toSet(r107));
            UpdateManagerViewModel.access$get_adminLoaded$p(r104).setValue(Boxing.boxBoolean(true));
        L18:
            UpdateManagerViewModel r109 = this.this$0;
            Throwable r110 = Result.m9452exceptionOrNullimpl(r103);
            if (r110 == null) goto L24;
            if ((r110 instanceof CancellationException) == true) goto L24;
            UpdateManagerViewModel.access$get_currentAdminIds$p(r109).setValue(SetsKt.emptySet());
            UpdateManagerViewModel.access$get_adminLoaded$p(r109).setValue(Boxing.boxBoolean(true));
        L24:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ChatSettingRepository r111 = UpdateManagerViewModel.access$getRepository$p(this.this$0);
            String r112 = UpdateManagerViewModel.access$getChatId$p(this.this$0);
            this.label = 1;
            r103 = r111.f(r112, this);
            if (r103 != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerViewModel$updateAdmins$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerViewModel$updateAdmins$1", f = "UpdateManagerViewModel.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    public static final class C117861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ UpdateManagerViewModel this$0;

        public C117861(UpdateManagerViewModel r100, Continuation<? super C117861> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C117861(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C117861) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            MutableSharedFlow r103 = UpdateManagerViewModel.access$get_actionEvent$p(this.this$0);
            a.b r104 = a.b.f417522a;
            this.label = 1;
            if (r103.emit(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerViewModel$updateAdmins$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerViewModel$updateAdmins$2", f = "UpdateManagerViewModel.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<String> $selectedAdminIds;
        final /* synthetic */ List<String> $toAdd;
        final /* synthetic */ List<String> $toDel;
        int label;
        final /* synthetic */ UpdateManagerViewModel this$0;

        public AnonymousClass2(UpdateManagerViewModel r100, List<String> r101, List<String> r102, Set<String> r103, Continuation<? super AnonymousClass2> r104) {
            this.this$0 = r100;
            this.$toAdd = r101;
            this.$toDel = r102;
            this.$selectedAdminIds = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, this.$toAdd, this.$toDel, this.$selectedAdminIds, r101);
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
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
            Object r111 = ((Result) r110).m9458unboximpl();
        L11:
            UpdateManagerViewModel r102 = this.this$0;
            Set<String> r103 = this.$selectedAdminIds;
            if (Result.m9456isSuccessimpl(r111) == false) goto L14;
            PatchChatAdminUsersResponse r104 = (PatchChatAdminUsersResponse) r111;
            UpdateManagerViewModel.access$get_loading$p(r102).setValue(Boxing.boxBoolean(false));
            UpdateManagerViewModel.access$get_currentAdminIds$p(r102).setValue(r103);
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(r102), null, null, new UpdateManagerViewModel$updateAdmins$2$1$1(r102, null), 3, null);
        L14:
            UpdateManagerViewModel r105 = this.this$0;
            Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
            if (r112 == null) goto L20;
            if ((r112 instanceof CancellationException) == true) goto L20;
            UpdateManagerViewModel.access$get_loading$p(r105).setValue(Boxing.boxBoolean(false));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(r105), null, null, new UpdateManagerViewModel$updateAdmins$2$2$1(r105, null), 3, null);
        L20:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            UpdateManagerViewModel.access$get_loading$p(this.this$0).setValue(Boxing.boxBoolean(true));
            ChatSettingRepository r113 = UpdateManagerViewModel.access$getRepository$p(this.this$0);
            String r106 = UpdateManagerViewModel.access$getChatId$p(this.this$0);
            List<String> r107 = this.$toAdd;
            List<String> r108 = this.$toDel;
            this.label = 1;
            r111 = r113.l(r106, r107, r108, this);
            if (r111 != r100) goto L11;
            return r100;
        }
    }

    private final void fetchCurrentAdmins() {
        if (StringsKt.isBlank(this.chatId) == false) goto L6;
        this._adminLoaded.setValue(Boolean.TRUE);
        return;
    L6:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final d1<a> getActionEvent() {
        return this.actionEvent;
    }

    public final i1<Boolean> getAdminLoaded() {
        return this.adminLoaded;
    }

    public final i1<Set<String>> getCurrentAdminIds() {
        return this.currentAdminIds;
    }

    public final i1<Boolean> getLoading() {
        return this.loading;
    }

    public static final /* synthetic */ String access$getChatId$p(UpdateManagerViewModel r100) {
        return r100.chatId;
    }

    public static final /* synthetic */ ChatSettingRepository access$getRepository$p(UpdateManagerViewModel r100) {
        return r100.repository;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_actionEvent$p(UpdateManagerViewModel r100) {
        return r100._actionEvent;
    }

    public static final /* synthetic */ z0 access$get_adminLoaded$p(UpdateManagerViewModel r100) {
        return r100._adminLoaded;
    }

    public static final /* synthetic */ z0 access$get_currentAdminIds$p(UpdateManagerViewModel r100) {
        return r100._currentAdminIds;
    }

    public static final /* synthetic */ z0 access$get_loading$p(UpdateManagerViewModel r100) {
        return r100._loading;
    }

    public final void updateAdmins(Set<String> r110) {
        Intrinsics.checkNotNullParameter(r110, "selectedAdminIds");
        if (StringsKt.isBlank(this.chatId) == false) goto L5;
        return;
    L5:
        Set<String> r100 = this._currentAdminIds.getValue();
        List r101 = CollectionsKt.toList(SetsKt.minus(r110, r100));
        List r102 = CollectionsKt.toList(SetsKt.minus(r100, r110));
        if (r101.isEmpty() == true) goto L8;
    L11:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, r101, r102, r110, null), 3, null);
        return;
    L8:
        if (r102.isEmpty() == false) goto L11;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C117861(this, null), 3, null);
    }

    public UpdateManagerViewModel(String r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "rustClient");
        this.chatId = r100;
        this.repository = new ChatSettingRepository(r101);
        Boolean r102 = Boolean.FALSE;
        StateFlowImpl r103 = j1.a(r102);
        this._loading = r103;
        this.loading = e.b(r103);
        StateFlowImpl r104 = j1.a(r102);
        this._adminLoaded = r104;
        this.adminLoaded = e.b(r104);
        StateFlowImpl r105 = j1.a(SetsKt.emptySet());
        this._currentAdminIds = r105;
        this.currentAdminIds = e.b(r105);
        MutableSharedFlow<a> r106 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._actionEvent = r106;
        this.actionEvent = e.a(r106);
        fetchCurrentAdmins();
    }
}
