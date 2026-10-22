package com.larus.dora.impl.device.settings.unbind;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eR\"\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_unbindStateFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlin/Pair;", "Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindState;", "Lcom/bytedance/dora/device/DoraDevice;", "unbindStateFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getUnbindStateFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "unbind", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraUnbindViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "DoraUnbindViewModel";
    private final MutableSharedFlow<Pair<DoraUnbindState, DoraDevice>> _unbindStateFlow;
    private final d1<Pair<DoraUnbindState, DoraDevice>> unbindStateFlow;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.unbind.DoraUnbindViewModel$unbind$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.unbind.DoraUnbindViewModel$unbind$1", f = "DoraUnbindViewModel.kt", i = {1}, l = {28, 31, 33}, m = "invokeSuspend", n = {"device"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ DoraUnbindViewModel this$0;

        public AnonymousClass1(DoraUnbindViewModel r100, Continuation<? super AnonymousClass1> r101) {
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
            if (r102 == 0) goto L12;
            if (r102 == 1) goto L11;
            if (r102 == 2) goto L10;
            if (r102 != 3) goto L9;
            ResultKt.throwOnFailure(r100);
        L26:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            DoraDevice r103 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r100);
        L22:
            DoraUnbindState r104 = (DoraUnbindState) r100;
            g49.d.d(DoraUnbindViewModel.TAG, "unbind finish, state: " + r104);
            MutableSharedFlow r105 = DoraUnbindViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r106 = new Pair(r104, r103);
            this.L$0 = null;
            this.label = 3;
            if (r105.emit(r106, this) != r101) goto L26;
            return r101;
        L11:
            ResultKt.throwOnFailure(r100);
        L18:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r100);
            r103 = kj4.a.g().c();
            if (r103 != null) goto L19;
            MutableSharedFlow r107 = DoraUnbindViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r108 = new Pair(DoraUnbindState.NO_DEVICE_CONNECTED, null);
            this.label = 1;
            if (r107.emit(r108, this) != r101) goto L18;
            return r101;
        L19:
            DoraUnbindService r109 = DoraUnbindService.f334932a;
            this.L$0 = r103;
            this.label = 2;
            r100 = r109.a(this);
            if (r100 != r101) goto L22;
            return r101;
        }
    }

    static {
        Companion = new a();
    }

    public DoraUnbindViewModel() {
        MutableSharedFlow<Pair<DoraUnbindState, DoraDevice>> r100 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._unbindStateFlow = r100;
        this.unbindStateFlow = r100;
    }

    public final void unbind() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final d1<Pair<DoraUnbindState, DoraDevice>> getUnbindStateFlow() {
        return this.unbindStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_unbindStateFlow$p(DoraUnbindViewModel r100) {
        return r100._unbindStateFlow;
    }
}
