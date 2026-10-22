package com.obric.assistant.settings.memory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.nova.NovaApplication;
import com.larus.nova.R;
import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import com.obric.assistant.settings.d1;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0019J*\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0019J\u001e\u0010\u001d\u001a\u00020\u00062\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u001fH\u0002J,\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020\u00172\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u001fH\u0002JH\u0010$\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\"0%2\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00172\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u001fH\u0002J\b\u0010)\u001a\u00020\u0017H\u0002J.\u0010*\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u00172\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u001fH\u0002J,\u0010,\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0019H\u0002J@\u0010,\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u001f2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0019H\u0002J$\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u001f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010/\u001a\u00020\u00172\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u001fH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/assistant/settings/memory/ObricReferenceMemorySettingViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/assistant/settings/memory/ObricReferenceMemoryUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "personalContextSettingsDelegate", "Lcom/obric/assistant/settings/ObricPersonalContextSettingApiDelegate;", "getPersonalContextSettingsDelegate", "()Lcom/obric/assistant/settings/ObricPersonalContextSettingApiDelegate;", "personalContextSettingsDelegate$delegate", "Lkotlin/Lazy;", "setSwitchJob", "Lkotlinx/coroutines/Job;", "refresh", "", "setMainSwitchEnabled", "enabled", "", "onResult", "Lkotlin/Function1;", "setChildSwitchEnabled", "storageKey", "", "buildState", "overrideValues", "", "buildChildRows", "", "Lcom/obric/assistant/settings/memory/ObricReferenceMemoryRow;", "mainSwitchEnabled", "addMemoryRow", "", "id", "title", "subtitle", "isMainSwitchEnabled", "getSwitchEnabled", "defVal", "setSwitchEnabled", "buildChildSwitchTargetValues", "buildMainSwitchTargetValues", "hasEnabledChildSwitch", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricReferenceMemorySettingViewModel extends ViewModel {
    private final z0<f0> _uiState;
    private final Lazy personalContextSettingsDelegate$delegate;
    private Job setSwitchJob;
    private final i1<f0> uiState;

    /* JADX INFO: renamed from: com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$refresh$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$refresh$1", f = "ObricReferenceMemorySettingViewModel.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ ObricReferenceMemorySettingViewModel this$0;

        /* JADX INFO: renamed from: com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$refresh$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/memory/ObricReferenceMemoryUiState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$refresh$1$1", f = "ObricReferenceMemorySettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C46281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super f0>, Object> {
            int label;
            final /* synthetic */ ObricReferenceMemorySettingViewModel this$0;

            public C46281(ObricReferenceMemorySettingViewModel r100, Continuation<? super C46281> r101) {
                this.this$0 = r100;
                super(2, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C46281(this.this$0, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super f0> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super f0> r101) {
                return ((C46281) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r100);
                return ObricReferenceMemorySettingViewModel.buildState$default(this.this$0, null, 1, null);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(ObricReferenceMemorySettingViewModel r100, Continuation<? super AnonymousClass1> r101) {
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
            z0 r103 = (z0) this.L$0;
            ResultKt.throwOnFailure(r100);
        L12:
            r103.setValue(r100);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            z0 r104 = ObricReferenceMemorySettingViewModel.access$get_uiState$p(this.this$0);
            CoroutineDispatcher r105 = Dispatchers.getIO();
            C46281 r106 = new C46281(this.this$0, null);
            this.L$0 = r104;
            this.label = 1;
            Object r107 = BuildersKt.withContext(r105, r106, this);
            if (r107 != r101) goto L11;
            return r101;
        L11:
            r103 = r104;
            r100 = r107;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$setSwitchEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$setSwitchEnabled$1", f = "ObricReferenceMemorySettingViewModel.kt", i = {2}, l = {141, 144, 147}, m = "invokeSuspend", n = {"success"}, s = {"Z$0"})
    public static final class C116451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ Function1<Boolean, Unit> $onResult;
        final /* synthetic */ Map<String, Boolean> $overrideValues;
        final /* synthetic */ String $storageKey;
        Object L$0;
        boolean Z$0;
        int label;
        final /* synthetic */ ObricReferenceMemorySettingViewModel this$0;

        /* JADX INFO: renamed from: com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$setSwitchEnabled$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/memory/ObricReferenceMemoryUiState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$setSwitchEnabled$1$1", f = "ObricReferenceMemorySettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C46291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super f0>, Object> {
            final /* synthetic */ Map<String, Boolean> $overrideValues;
            int label;
            final /* synthetic */ ObricReferenceMemorySettingViewModel this$0;

            public C46291(ObricReferenceMemorySettingViewModel r100, Map<String, Boolean> r101, Continuation<? super C46291> r102) {
                this.this$0 = r100;
                this.$overrideValues = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C46291(this.this$0, this.$overrideValues, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super f0> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super f0> r101) {
                return ((C46291) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r100);
                return ObricReferenceMemorySettingViewModel.access$buildState(this.this$0, this.$overrideValues);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$setSwitchEnabled$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/memory/ObricReferenceMemoryUiState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$setSwitchEnabled$1$2", f = "ObricReferenceMemorySettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super f0>, Object> {
            int label;
            final /* synthetic */ ObricReferenceMemorySettingViewModel this$0;

            public AnonymousClass2(ObricReferenceMemorySettingViewModel r100, Continuation<? super AnonymousClass2> r101) {
                this.this$0 = r100;
                super(2, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new AnonymousClass2(this.this$0, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super f0> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super f0> r101) {
                return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r100);
                return ObricReferenceMemorySettingViewModel.buildState$default(this.this$0, null, 1, null);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C116451(ObricReferenceMemorySettingViewModel r100, Function1<? super Boolean, Unit> r101, Map<String, Boolean> r102, String r103, boolean r104, Continuation<? super C116451> r105) {
            this.this$0 = r100;
            this.$onResult = r101;
            this.$overrideValues = r102;
            this.$storageKey = r103;
            this.$enabled = r104;
            super(2, r105);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C116451(this.this$0, this.$onResult, this.$overrideValues, this.$storageKey, this.$enabled, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C116451) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L12;
            if (r101 == 1) goto L11;
            if (r101 == 2) goto L10;
            if (r101 != 3) goto L9;
            boolean r102 = this.Z$0;
            z0 r103 = (z0) this.L$0;
            ResultKt.throwOnFailure(r110);
        L22:
            r103.setValue(r110);
            this.$onResult.invoke(Boxing.boxBoolean(r102));
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r110);
        L18:
            boolean r111 = ((Boolean) r110).booleanValue();
            r103 = ObricReferenceMemorySettingViewModel.access$get_uiState$p(this.this$0);
            CoroutineDispatcher r104 = Dispatchers.getIO();
            AnonymousClass2 r105 = new AnonymousClass2(this.this$0, null);
            this.L$0 = r103;
            this.Z$0 = r111;
            this.label = 3;
            Object r106 = BuildersKt.withContext(r104, r105, this);
            if (r106 != r100) goto L21;
            return r100;
        L21:
            r102 = r111;
            r110 = r106;
            goto L22
        L11:
            z0 r107 = (z0) this.L$0;
            ResultKt.throwOnFailure(r110);
        L15:
            r107.setValue(r110);
            CoroutineDispatcher r112 = Dispatchers.getIO();
            ObricReferenceMemorySettingViewModel$setSwitchEnabled$1$success$1 r108 = new ObricReferenceMemorySettingViewModel$setSwitchEnabled$1$success$1(this.this$0, this.$storageKey, this.$enabled, null);
            this.L$0 = null;
            this.label = 2;
            r110 = BuildersKt.withContext(r112, r108, this);
            if (r110 != r100) goto L18;
            return r100;
        L12:
            ResultKt.throwOnFailure(r110);
            r107 = ObricReferenceMemorySettingViewModel.access$get_uiState$p(this.this$0);
            CoroutineDispatcher r113 = Dispatchers.getIO();
            C46291 r109 = new C46291(this.this$0, this.$overrideValues, null);
            this.L$0 = r107;
            this.label = 1;
            r110 = BuildersKt.withContext(r113, r109, this);
            if (r110 != r100) goto L15;
            return r100;
        }
    }

    public static /* synthetic */ ObricPersonalContextSettingApiDelegate yo() {
        return personalContextSettingsDelegate_delegate$lambda$0();
    }

    private final ObricPersonalContextSettingApiDelegate getPersonalContextSettingsDelegate() {
        return (ObricPersonalContextSettingApiDelegate) this.personalContextSettingsDelegate$delegate.getValue();
    }

    private final boolean isMainSwitchEnabled() {
        return getSwitchEnabled$default(this, "reference_memory", false, null, 4, null);
    }

    public ObricReferenceMemorySettingViewModel() {
        StateFlowImpl r100 = j1.a(new f0(0));
        this._uiState = r100;
        this.uiState = r100;
        this.personalContextSettingsDelegate$delegate = LazyKt.lazy(new e0());
    }

    public final void refresh() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new AnonymousClass1(this, null), 2, null);
    }

    private static final ObricPersonalContextSettingApiDelegate personalContextSettingsDelegate_delegate$lambda$0() {
        return ObricPersonalContextSettingApiDelegate.f391714b;
    }

    public final i1<f0> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ ObricPersonalContextSettingApiDelegate access$getPersonalContextSettingsDelegate(ObricReferenceMemorySettingViewModel r100) {
        return r100.getPersonalContextSettingsDelegate();
    }

    public static final /* synthetic */ z0 access$get_uiState$p(ObricReferenceMemorySettingViewModel r100) {
        return r100._uiState;
    }

    private final Map<String, Boolean> buildMainSwitchTargetValues(boolean r100) {
        boolean r101 = isMainSwitchEnabled();
        if (r100 == false) goto L7;
        Boolean r102 = Boolean.TRUE;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("reference_memory", r102), TuplesKt.to("reference_memory_personal_info", r102)});
    L7:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("reference_memory", Boolean.FALSE), TuplesKt.to("reference_memory_personal_info", Boolean.valueOf(getSwitchEnabled$default(this, "reference_memory_personal_info", r101, null, 4, null)))});
    }

    private final f0 buildState(Map<String, Boolean> r110) {
        gd9.i r100 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r100);
        NovaApplication r101 = r100.getApplication();
        boolean r102 = getSwitchEnabled("reference_memory", false, r110);
        List r103 = CollectionsKt.createListBuilder();
        r103.add(new y("reference_memory", r101.getString(R.string.obric_setting_reference_memory), r101.getString(R.string.obric_setting_reference_memory_main_switch_subtitle), r102, true, ObricReferenceMemorySwitchGroup.MAIN));
        r103.addAll(buildChildRows(r102, r110));
        return new f0(CollectionsKt.build(r103));
    }

    private final boolean hasEnabledChildSwitch(Map<String, Boolean> r100) {
        return getSwitchEnabled("reference_memory_personal_info", getSwitchEnabled("reference_memory", false, r100), r100);
    }

    public static final /* synthetic */ f0 access$buildState(ObricReferenceMemorySettingViewModel r100, Map r101) {
        return r100.buildState(r101);
    }

    private final List<y> buildChildRows(boolean r110, Map<String, Boolean> r111) {
        gd9.i r100 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r100);
        NovaApplication r101 = r100.getApplication();
        List<y> r102 = CollectionsKt.createListBuilder();
        addMemoryRow(r102, "reference_memory_personal_info", r101.getString(R.string.obric_setting_reference_memory_personal_info_title), r101.getString(R.string.obric_setting_reference_memory_personal_info_subtitle), r110, r111);
        return CollectionsKt.build(r102);
    }

    private final Map<String, Boolean> buildChildSwitchTargetValues(String r100, boolean r101) {
        Map<String, Boolean> r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r100, Boolean.valueOf(r101))});
        if (r101 == false) goto L5;
    L7:
        return r102;
    L5:
        if (hasEnabledChildSwitch(r102) == true) goto L7;
        r102.put("reference_memory", Boolean.FALSE);
        goto L7
    }

    public final void setMainSwitchEnabled(boolean r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "onResult");
        setSwitchEnabled("reference_memory", r100, buildMainSwitchTargetValues(r100), r101);
    }

    private final boolean getSwitchEnabled(String r100, boolean r101, Map<String, Boolean> r102) {
        Boolean r103 = r102.get(r100);
        if (r103 != null) goto L5;
        d1 r104 = getPersonalContextSettingsDelegate().f();
        if (Intrinsics.areEqual(r100, "reference_memory") == false) goto L11;
        if (r104 != null) goto L16;
        return r101;
    L16:
        return r104.f392019a;
    L11:
        if (Intrinsics.areEqual(r100, "reference_memory_personal_info") == false) goto L17;
        if (r104 != null) goto L14;
        return r101;
    L14:
        return r104.f392020b;
    L17:
        return r101;
    L5:
        return r103.booleanValue();
    }

    private final void setSwitchEnabled(String r100, boolean r101, Function1<? super Boolean, Unit> r102) {
        setSwitchEnabled(r100, r101, MapsKt.mapOf(TuplesKt.to(r100, Boolean.valueOf(r101))), r102);
    }

    public final void setChildSwitchEnabled(String r100, boolean r101, Function1<? super Boolean, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "storageKey");
        Intrinsics.checkNotNullParameter(r102, "onResult");
        if (isMainSwitchEnabled() == true) goto L6;
        refresh();
        r102.invoke(Boolean.FALSE);
        return;
    L6:
        setSwitchEnabled(r100, r101, buildChildSwitchTargetValues(r100, r101), r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ f0 buildState$default(ObricReferenceMemorySettingViewModel r100, Map r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = MapsKt.emptyMap();
    L6:
        return r100.buildState(r101);
    }

    private final void setSwitchEnabled(String r110, boolean r111, Map<String, Boolean> r112, Function1<? super Boolean, Unit> r113) {
        Job r100 = this.setSwitchJob;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.setSwitchJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C116451(this, r113, r112, r110, r111, null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List buildChildRows$default(ObricReferenceMemorySettingViewModel r100, boolean r101, Map r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = MapsKt.emptyMap();
    L6:
        return r100.buildChildRows(r101, r102);
    }

    private final void addMemoryRow(List<y> r100, String r110, String r111, String r112, boolean r113, Map<String, Boolean> r114) {
        r100.add(new y(r110, r111, r112, getSwitchEnabled(r110, r113, r114), r113, ObricReferenceMemorySwitchGroup.CHILD));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean getSwitchEnabled$default(ObricReferenceMemorySettingViewModel r100, String r101, boolean r102, Map r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = MapsKt.emptyMap();
    L6:
        return r100.getSwitchEnabled(r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addMemoryRow$default(ObricReferenceMemorySettingViewModel r100, List r101, String r102, String r110, String r111, boolean r112, Map r113, int r114, Object r115) {
        if ((r114 & 16) == 0) goto L5;
        r113 = MapsKt.emptyMap();
    L5:
        r100.addMemoryRow(r101, r102, r110, r111, r112, r113);
    }
}
