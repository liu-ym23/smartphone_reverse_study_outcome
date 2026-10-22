package com.larus.dora.impl.onboarding;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.util.DoraSKU;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0019J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00152\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001eH\u0004J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0004R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/dora/impl/onboarding/DoraOnboardingBaseViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "doraOnboardingDevice", "Lcom/larus/dora/impl/onboarding/DoraOnboardingDevice;", "getDoraOnboardingDevice", "()Lcom/larus/dora/impl/onboarding/DoraOnboardingDevice;", "setDoraOnboardingDevice", "(Lcom/larus/dora/impl/onboarding/DoraOnboardingDevice;)V", ECPromotion.SKU, "Lcom/larus/dora/impl/util/DoraSKU;", "getSku", "()Lcom/larus/dora/impl/util/DoraSKU;", "mac", "", "getMac", "()Ljava/lang/String;", "vuiModeDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "currentVuiMode", "Lcom/larus/dora/impl/onboarding/OnboardingVUIMode;", "isDoraSupportOnboarding", "", "caller", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startVUIMode", "", "mode", "onSuccess", "Lkotlin/Function0;", "stopVUIMode", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DoraOnboardingBaseViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "DoraOnboardingBaseViewM";
    private OnboardingVUIMode currentVuiMode;
    private DoraOnboardingDevice doraOnboardingDevice;
    private final ExecutorCoroutineDispatcher vuiModeDispatcher;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel$startVUIMode$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel$startVUIMode$2", f = "DoraOnboardingBaseViewModel.kt", i = {}, l = {47, 52}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ OnboardingVUIMode $mode;
        final /* synthetic */ Function0<Unit> $onSuccess;
        int label;
        final /* synthetic */ DoraOnboardingBaseViewModel this$0;

        public AnonymousClass2(DoraOnboardingBaseViewModel r100, OnboardingVUIMode r101, Function0<Unit> r102, Continuation<? super AnonymousClass2> r103) {
            this.this$0 = r100;
            this.$mode = r101;
            this.$onSuccess = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, this.$mode, this.$onSuccess, r101);
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
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 != 2) goto L8;
            ResultKt.throwOnFailure(r100);
        L22:
            boolean r103 = ((Boolean) r100).booleanValue();
            g49.d.d(DoraOnboardingBaseViewModel.TAG, "startVUIMode: " + this.$mode + ", result=" + r103);
            if (r103 == false) goto L26;
            DoraOnboardingBaseViewModel.access$setCurrentVuiMode$p(this.this$0, this.$mode);
            this.$onSuccess.invoke();
        L26:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
        L14:
            if (((Boolean) r100).booleanValue() == false) goto L26;
            if (DoraOnboardingBaseViewModel.access$getCurrentVuiMode$p(this.this$0) != this.$mode) goto L19;
            g49.d.d(DoraOnboardingBaseViewModel.TAG, "startVUIMode: " + this.$mode + ", already in this mode");
            return Unit.INSTANCE;
        L19:
            kj4.a r104 = kj4.a.g();
            int r105 = this.$mode.getValue();
            this.label = 2;
            r100 = DoraAdapterExtKt.N(r104, r105);
            if (r100 != r101) goto L22;
            return r101;
        L10:
            ResultKt.throwOnFailure(r100);
            DoraOnboardingBaseViewModel r106 = this.this$0;
            String r107 = this.$mode.name();
            this.label = 1;
            r100 = r106.isDoraSupportOnboarding(r107, this);
            if (r100 != r101) goto L14;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel$stopVUIMode$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel$stopVUIMode$1", f = "DoraOnboardingBaseViewModel.kt", i = {}, l = {64, 65}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ OnboardingVUIMode $mode;
        int label;
        final /* synthetic */ DoraOnboardingBaseViewModel this$0;

        public AnonymousClass1(DoraOnboardingBaseViewModel r100, OnboardingVUIMode r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$mode = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$mode, r101);
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
            if (r102 != 2) goto L8;
            ResultKt.throwOnFailure(r100);
        L18:
            g49.d.d(DoraOnboardingBaseViewModel.TAG, "stopVUIMode: " + this.$mode + ", result=" + ((Boolean) r100).booleanValue());
        L20:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
        L14:
            if (((Boolean) r100).booleanValue() == false) goto L20;
            kj4.a r103 = kj4.a.g();
            int r104 = this.$mode.getValue();
            this.label = 2;
            r100 = DoraAdapterExtKt.O(r103, r104);
            if (r100 != r101) goto L18;
            return r101;
        L10:
            ResultKt.throwOnFailure(r100);
            DoraOnboardingBaseViewModel r105 = this.this$0;
            String r106 = this.$mode.name();
            this.label = 1;
            r100 = r105.isDoraSupportOnboarding(r106, this);
            if (r100 != r101) goto L14;
            return r101;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Thread Mo(Runnable r100) {
        return vuiModeDispatcher$lambda$0(r100);
    }

    public static /* synthetic */ Unit yo() {
        return startVUIMode$lambda$1();
    }

    public abstract Object isDoraSupportOnboarding(String r100, Continuation<? super Boolean> r101);

    public final String getMac() {
        DoraOnboardingDevice r100 = this.doraOnboardingDevice;
        if (r100 == null) goto L5;
        String r101 = r100.f336552b;
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final DoraSKU getSku() {
        DoraSKU.a r100 = DoraSKU.Companion;
        DoraOnboardingDevice r101 = this.doraOnboardingDevice;
        Integer r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.f336555e);
    L6:
        DoraSKU r104 = DoraSKU.a.b(r100, r103);
        StringBuilder r105 = new StringBuilder("sku=");
        DoraOnboardingDevice r106 = this.doraOnboardingDevice;
        if (r106 == null) goto L9;
        r102 = Integer.valueOf(r106.f336555e);
    L9:
        r105.append(r102);
        r105.append(", doraSKU=");
        r105.append(r104);
        g49.d.d(TAG, r105.toString());
        return r104;
    L5:
        r103 = null;
        goto L6
    }

    public DoraOnboardingBaseViewModel() {
        this.vuiModeDispatcher = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new f()));
        g49.d.d(TAG, "init");
    }

    private static final Unit startVUIMode$lambda$1() {
        return Unit.INSTANCE;
    }

    public final DoraOnboardingDevice getDoraOnboardingDevice() {
        return this.doraOnboardingDevice;
    }

    public static final /* synthetic */ OnboardingVUIMode access$getCurrentVuiMode$p(DoraOnboardingBaseViewModel r100) {
        return r100.currentVuiMode;
    }

    private static final Thread vuiModeDispatcher$lambda$0(Runnable r100) {
        return new PthreadThreadV2(r100, "dora_onboarding#VUIMode");
    }

    public final void setDoraOnboardingDevice(DoraOnboardingDevice r100) {
        this.doraOnboardingDevice = r100;
    }

    public final void stopVUIMode(OnboardingVUIMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        BuildersKt.launch$default(GlobalScope.INSTANCE, this.vuiModeDispatcher, null, new AnonymousClass1(this, r100, null), 2, null);
    }

    public static final /* synthetic */ void access$setCurrentVuiMode$p(DoraOnboardingBaseViewModel r100, OnboardingVUIMode r101) {
        r100.currentVuiMode = r101;
    }

    public final void startVUIMode(OnboardingVUIMode r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, "onSuccess");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.vuiModeDispatcher, null, new AnonymousClass2(this, r100, r101, null), 2, null);
    }

    public static /* synthetic */ Object isDoraSupportOnboarding$default(DoraOnboardingBaseViewModel r100, String r101, Continuation r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L7;
        r101 = "";
    L7:
        return r100.isDoraSupportOnboarding(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isDoraSupportOnboarding");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startVUIMode$default(DoraOnboardingBaseViewModel r100, OnboardingVUIMode r101, Function0 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = new g();
    L6:
        r100.startVUIMode(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startVUIMode");
    }
}
