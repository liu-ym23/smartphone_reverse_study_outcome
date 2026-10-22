package com.ss.android.lark.compose.groupinfo;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lark.kmp.pb.im.v1.UpdateChatResponse;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003J\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0003J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0$H\u0082@¢\u0006\u0004\b%\u0010&J\u0006\u0010'\u001a\u00020\u001fJ\u0006\u0010(\u001a\u00020\u001fJ\u0006\u0010)\u001a\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006*"}, d2 = {"Lcom/ss/android/lark/compose/groupinfo/GroupInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "chatId", "", "initialAvatarKey", "initialChatName", "canEdit", "", "repository", "Lcom/ss/android/lark/compose/groupinfo/GroupInfoRepository;", "platformService", "Lcom/ss/android/lark/compose/groupinfo/GroupInfoPlatformService;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/ss/android/lark/compose/groupinfo/GroupInfoRepository;Lcom/ss/android/lark/compose/groupinfo/GroupInfoPlatformService;)V", "getChatId", "()Ljava/lang/String;", "viewModelState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ss/android/lark/compose/groupinfo/GroupInfoState;", "_effect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/ss/android/lark/compose/groupinfo/GroupInfoEffect;", "effect", "Lkotlinx/coroutines/flow/SharedFlow;", "getEffect", "()Lkotlinx/coroutines/flow/SharedFlow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "onNameChange", "", "name", "changeSelectedImageUri", "uri", "updateGroupInfo", "Lkotlin/Result;", "updateGroupInfo-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onConfirmClick", "onCancelClick", "onAvatarClick", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupInfoViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableSharedFlow<b> _effect;
    private final String chatId;
    private final d1<b> effect;
    private final d platformService;
    private final GroupInfoRepository repository;
    private final i1<e> uiState;
    private final z0<e> viewModelState;

    /* JADX INFO: renamed from: com.ss.android.lark.compose.groupinfo.GroupInfoViewModel$onAvatarClick$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.groupinfo.GroupInfoViewModel$onAvatarClick$1", f = "GroupInfoViewModel.kt", i = {}, l = {135, 137}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupInfoViewModel this$0;

        public AnonymousClass1(GroupInfoViewModel r100, Continuation<? super AnonymousClass1> r101) {
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
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
        L19:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r100);
            if (((e) GroupInfoViewModel.access$getViewModelState$p(this.this$0).getValue()).f417716d == false) goto L15;
            MutableSharedFlow r103 = GroupInfoViewModel.access$get_effect$p(this.this$0);
            b.C4911b r104 = b.C4911b.f417708a;
            this.label = 1;
            if (r103.emit(r104, this) != r101) goto L19;
            return r101;
        L15:
            MutableSharedFlow r105 = GroupInfoViewModel.access$get_effect$p(this.this$0);
            b.d r106 = new b.d(GroupInfoToast.EDIT_NOT_ALLOWED);
            this.label = 2;
            if (r105.emit(r106, this) != r101) goto L19;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.groupinfo.GroupInfoViewModel$onCancelClick$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.groupinfo.GroupInfoViewModel$onCancelClick$1", f = "GroupInfoViewModel.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
    public static final class C117871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupInfoViewModel this$0;

        public C117871(GroupInfoViewModel r100, Continuation<? super C117871> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C117871(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C117871) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            MutableSharedFlow r103 = GroupInfoViewModel.access$get_effect$p(this.this$0);
            b.a r104 = b.a.f417707a;
            this.label = 1;
            if (r103.emit(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.groupinfo.GroupInfoViewModel$onConfirmClick$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.groupinfo.GroupInfoViewModel$onConfirmClick$1", f = "GroupInfoViewModel.kt", i = {}, l = {115, 117, 118, 121}, m = "invokeSuspend", n = {}, s = {})
    public static final class C117881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ GroupInfoViewModel this$0;

        public C117881(GroupInfoViewModel r100, Continuation<? super C117881> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C117881(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C117881) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L15;
            if (r101 == 1) goto L13;
            if (r101 == 2) goto L12;
            if (r101 == 3) goto L11;
            if (r101 != 4) goto L10;
            ResultKt.throwOnFailure(r110);
        L38:
            z0 r102 = GroupInfoViewModel.access$getViewModelState$p(this.this$0);
        L39:
            Object r111 = r102.getValue();
            if (r102.compareAndSet(r111, e.a((e) r111, null, null, null, 0, false, 63)) == false) goto L39;
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            Object r103 = this.L$0;
            ResultKt.throwOnFailure(r110);
        L31:
            GroupInfoViewModel r112 = this.this$0;
            Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
            if (r104 == null) goto L38;
            if (GroupInfoViewModel.access$getPlatformService$p(r112).b(r104) == true) goto L38;
            MutableSharedFlow r113 = GroupInfoViewModel.access$get_effect$p(r112);
            b.c r105 = new b.c(r104);
            this.L$0 = r103;
            this.label = 4;
            if (r113.emit(r105, this) != r100) goto L38;
            return r100;
        L12:
            GroupInfoViewModel r106 = (GroupInfoViewModel) this.L$1;
            Object r107 = this.L$0;
            ResultKt.throwOnFailure(r110);
        L27:
            MutableSharedFlow r114 = GroupInfoViewModel.access$get_effect$p(r106);
            b.a r108 = b.a.f417707a;
            this.L$0 = r107;
            this.L$1 = null;
            this.label = 3;
            if (r114.emit(r108, this) != r100) goto L30;
            return r100;
        L30:
            r103 = r107;
            goto L31
        L13:
            ResultKt.throwOnFailure(r110);
            Object r115 = ((Result) r110).m9458unboximpl();
        L14:
            r103 = r115;
            GroupInfoViewModel r116 = this.this$0;
            if (Result.m9456isSuccessimpl(r103) == false) goto L31;
            Unit r109 = (Unit) r103;
            c.b("GroupInfoViewModel updateInfo success");
            MutableSharedFlow r117 = GroupInfoViewModel.access$get_effect$p(r116);
            b.d r118 = new b.d(GroupInfoToast.SAVE_SUCCESS);
            this.L$0 = r103;
            this.L$1 = r116;
            this.label = 2;
            if (r117.emit(r118, this) != r100) goto L26;
            return r100;
        L26:
            r107 = r103;
            r106 = r116;
            goto L27
        L15:
            ResultKt.throwOnFailure(r110);
            z0 r119 = GroupInfoViewModel.access$getViewModelState$p(this.this$0);
        L16:
            Object r120 = r119.getValue();
            if (r119.compareAndSet(r120, e.a((e) r120, null, null, null, 0, true, 63)) == false) goto L16;
            GroupInfoViewModel r121 = this.this$0;
            this.label = 1;
            r115 = GroupInfoViewModel.m8634access$updateGroupInfoIoAF18A(r121, this);
            if (r115 != r100) goto L14;
            return r100;
        }
    }

    public final void onConfirmClick() {
        if (f.a(this.viewModelState.getValue()) == true) goto L5;
        return;
    L5:
        if (this.viewModelState.getValue().f417719g == true) goto L10;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C117881(this, null), 3, null);
        return;
    }

    public final void onAvatarClick() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void onCancelClick() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C117871(this, null), 3, null);
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final d1<b> getEffect() {
        return this.effect;
    }

    public final i1<e> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ d access$getPlatformService$p(GroupInfoViewModel r100) {
        return r100.platformService;
    }

    public static final /* synthetic */ z0 access$getViewModelState$p(GroupInfoViewModel r100) {
        return r100.viewModelState;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_effect$p(GroupInfoViewModel r100) {
        return r100._effect;
    }

    /* JADX INFO: renamed from: updateGroupInfo-IoAF18A, reason: not valid java name */
    private final Object m8635updateGroupInfoIoAF18A(Continuation<? super Result<Unit>> r210) {
        if ((r210 instanceof GroupInfoViewModel$updateGroupInfo$1) == false) goto L7;
        GroupInfoViewModel$updateGroupInfo$1 r100 = (GroupInfoViewModel$updateGroupInfo$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r106 = ((Result) r102).m9458unboximpl();
    L50:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L54;
        int r108 = c.f417711a;
        c.a("GroupInfoViewModel updateAvatar rust failed: " + r107.getMessage());
        return Result.m9449constructorimpl(ResultKt.createFailure(r107));
    L54:
        this.platformService.a(this.chatId, r105);
    L59:
        Result.Companion r109 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r102);
        Object r110 = ((Result) r102).m9458unboximpl();
    L44:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 != null) goto L55;
        String r112 = (String) r110;
        c.b("GroupInfoViewModel onAvatarUploaded start rust update");
        GroupInfoRepository r113 = this.repository;
        String r114 = this.chatId;
        r100.L$0 = r112;
        r100.label = 3;
        Object r115 = r113.a(r114, r112, r100);
        if (r115 != r103) goto L49;
        return r103;
    L49:
        r105 = r112;
        r106 = r115;
        goto L50
    L55:
        int r116 = c.f417711a;
        c.a("GroupInfoViewModel upload avatar failed: " + r111.getMessage());
        return Result.m9449constructorimpl(ResultKt.createFailure(r111));
    L17:
        String r117 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r118 = ((Result) r102).m9458unboximpl();
    L24:
        if (Result.m9456isSuccessimpl(r118) == false) goto L30;
        UpdateChatResponse r119 = (UpdateChatResponse) r118;
        z0<e> r120 = this.viewModelState;
    L26:
        e r121 = r120.getValue();
        z0<e> r122 = r120;
        if (r122.compareAndSet(r121, e.a(r121, r117, null, null, 0, false, 126)) == true) goto L30;
        r120 = r122;
    L30:
        Throwable r123 = Result.m9452exceptionOrNullimpl(r118);
        if (r123 == null) goto L34;
        int r124 = c.f417711a;
        c.a("GroupInfoViewModel updateName failed: " + r123.getMessage());
        return Result.m9449constructorimpl(ResultKt.createFailure(r123));
    L34:
        String r125 = this.viewModelState.getValue().f417717e;
        if (r125.length() <= 0) goto L37;
        boolean r126 = true;
    L38:
        if (r126 == false) goto L59;
        Object r127 = this.platformService.c(r125);
        Throwable r128 = Result.m9452exceptionOrNullimpl(r127);
        if (r128 != null) goto L57;
        c.b("GroupInfoViewModel start upload avatar");
        d r129 = this.platformService;
        r100.L$0 = null;
        r100.label = 2;
        r110 = r129.d((String) r127, r100);
        if (r110 != r103) goto L44;
        return r103;
    L57:
        int r130 = c.f417711a;
        c.a("GroupInfoViewModel resolve avatar path failed: " + r128.getMessage());
        return Result.m9449constructorimpl(ResultKt.createFailure(r128));
    L37:
        r126 = false;
        goto L38
    L18:
        ResultKt.throwOnFailure(r102);
        r117 = this.viewModelState.getValue().f417715c;
        if (Intrinsics.areEqual(r117, this.viewModelState.getValue().f417713a) == true) goto L34;
        c.b("GroupInfoViewModel updateName start");
        GroupInfoRepository r131 = this.repository;
        String r132 = this.chatId;
        String r133 = StringsKt.trim(r117).toString();
        r100.L$0 = r117;
        r100.label = 1;
        r118 = r131.b(r132, r133, r100);
        if (r118 != r103) goto L24;
        return r103;
    L7:
        r100 = new GroupInfoViewModel$updateGroupInfo$1(this, r210);
        goto L8
    }

    public final void changeSelectedImageUri(String r110) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        if (Intrinsics.areEqual(this.viewModelState.getValue().f417717e, r110) == false) goto L8;
        z0<e> r100 = this.viewModelState;
    L5:
        e r111 = r100.getValue();
        e r101 = r111;
        if (r100.compareAndSet(r111, e.a(r101, null, null, null, r101.f417718f + 1, false, 95)) == false) goto L5;
        return;
    L8:
        z0<e> r102 = this.viewModelState;
    L9:
        e r103 = r102.getValue();
        if (r102.compareAndSet(r103, e.a(r103, null, null, r110, 0, false, 111)) == false) goto L9;
    }

    public final void onNameChange(String r110) {
        Intrinsics.checkNotNullParameter(r110, "name");
        z0<e> r100 = this.viewModelState;
    L3:
        e r101 = r100.getValue();
        if (r100.compareAndSet(r101, e.a(r101, null, r110, null, 0, false, 123)) == false) goto L3;
    }

    /* JADX INFO: renamed from: access$updateGroupInfo-IoAF18A, reason: not valid java name */
    public static final /* synthetic */ Object m8634access$updateGroupInfoIoAF18A(GroupInfoViewModel r100, Continuation r101) {
        return r100.m8635updateGroupInfoIoAF18A(r101);
    }

    public GroupInfoViewModel(String r110, String r111, String r112, boolean r113, GroupInfoRepository r114, d r210) {
        Intrinsics.checkNotNullParameter(r110, "chatId");
        Intrinsics.checkNotNullParameter(r111, "initialAvatarKey");
        Intrinsics.checkNotNullParameter(r112, "initialChatName");
        Intrinsics.checkNotNullParameter(r114, "repository");
        Intrinsics.checkNotNullParameter(r210, "platformService");
        this.chatId = r110;
        this.repository = r114;
        this.platformService = r210;
        StateFlowImpl r100 = j1.a(new e(r112, r111, r112, r113, "", 0, false));
        this.viewModelState = r100;
        MutableSharedFlow<b> r101 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._effect = r101;
        this.effect = kotlinx.coroutines.flow.e.a(r101);
        this.uiState = kotlinx.coroutines.flow.e.b(r100);
    }
}
