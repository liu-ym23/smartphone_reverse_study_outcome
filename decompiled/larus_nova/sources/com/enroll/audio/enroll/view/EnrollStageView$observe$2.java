package com.enroll.audio.enroll.view;

import com.enroll.audio.enroll.IBtHeadsetEnrollService;
import com.enroll.audio.enroll.recorder.RecordState;
import com.enroll.audio.enroll.ui.VoicePrintEnrollActivity;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.enroll.audio.enroll.view.EnrollStageView$observe$2", f = "EnrollStageView.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
public final class EnrollStageView$observe$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EnrollStageView this$0;

    /* JADX INFO: renamed from: com.enroll.audio.enroll.view.EnrollStageView$observe$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EnrollStageView f273898a;

        /* JADX INFO: renamed from: com.enroll.audio.enroll.view.EnrollStageView$observe$2$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.enroll.audio.enroll.view.EnrollStageView$observe$2$1$1", f = "EnrollStageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C38331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $taskId;
            int label;
            final /* synthetic */ EnrollStageView this$0;

            public C38331(EnrollStageView r100, String r101, Continuation<? super C38331> r102) {
                this.this$0 = r100;
                this.$taskId = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C38331(this.this$0, this.$taskId, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C38331) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L42;
                ResultKt.throwOnFailure(r100);
                if (this.this$0.getViewModel().getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.DORA_BT) goto L36;
                AtomicReference<com.enroll.audio.enroll.b.a> r101 = com.enroll.audio.enroll.b.f273720a;
                String r102 = this.$taskId;
                EnrollStageView r103 = this.this$0;
                Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
                Intrinsics.checkNotNullParameter(r103, "callback");
                if (StringsKt.isBlank(r102) == true) goto L10;
                com.enroll.audio.enroll.b.f273720a.set(new com.enroll.audio.enroll.b.a(r102, r103));
            L10:
                int r104 = gt7.a.f482578a;
                FLogger.f375446a.i("EnrollDoraWakeupService", "enableVUI");
                Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L16
                IDoraService r106 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L16
                if (r106 == null) goto L18;
                Result.m9449constructorimpl(Integer.valueOf(r106.d().e()));     // Catch: Throwable -> L16
            L18:
                int r107 = gt7.a.f482578a;
                IDoraService r108 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L33
                if (r108 == null) goto L47;
                SessionService r109 = r108.d();     // Catch: Throwable -> L33
                if (r109 == null) goto L47;
                DeviceService r110 = r108.device();     // Catch: Throwable -> L33
                if (r110 != null) goto L28;
            L30:
                boolean r111 = false;
            L31:
                FLogger.f375446a.i("EnrollDoraWakeupService", "startVUIForEnroll isOta3p5: " + r111);     // Catch: Throwable -> L33
                Result.m9449constructorimpl(Integer.valueOf(r109.l(18, true)));     // Catch: Throwable -> L33
                goto L47
            L28:
                if (r110.n0("ota3p5") != true) goto L30;
                r111 = true;
            L47:
                return Unit.INSTANCE;
            L33:
                th = move-exception;
                Result.Companion r112 = Result.Companion;
                Result.m9449constructorimpl(ResultKt.createFailure(th));
            L16:
                th = move-exception;
                Result.Companion r113 = Result.Companion;
                Result.m9449constructorimpl(ResultKt.createFailure(th));
                goto L18
            L36:
                IBtHeadsetEnrollService.f273707a.getClass();
                IBtHeadsetEnrollService r114 = IBtHeadsetEnrollService.a.a();
                if (r114 == null) goto L39;
                r114.d(this.$taskId, this.this$0);
                return Unit.INSTANCE;
            L39:
                return null;
            L42:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.enroll.audio.enroll.view.EnrollStageView$observe$2$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.enroll.audio.enroll.view.EnrollStageView$observe$2$1$2", f = "EnrollStageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $taskId;
            int label;
            final /* synthetic */ EnrollStageView this$0;

            public AnonymousClass2(String r100, EnrollStageView r101, Continuation<? super AnonymousClass2> r102) {
                this.$taskId = r100;
                this.this$0 = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new AnonymousClass2(this.$taskId, this.this$0, r101);
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
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L13;
                ResultKt.throwOnFailure(r100);
                IBtHeadsetEnrollService.f273707a.getClass();
                IBtHeadsetEnrollService r101 = IBtHeadsetEnrollService.a.a();
                if (r101 == null) goto L8;
                r101.a(this.$taskId);
            L8:
                if (this.this$0.getViewModel().getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.DORA_BT) goto L11;
                com.enroll.audio.enroll.b.f273720a.set(null);
                gt7.a.b();
                gt7.a.a();
            L11:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.enroll.audio.enroll.view.EnrollStageView$observe$2$1$a */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f273899a = null;

            static {
                int[] r100 = new int[RecordState.values().length];
                r100[RecordState.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[RecordState.STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f273899a = r100;
            }
        }

        public AnonymousClass1(EnrollStageView r100) {
            this.f273898a = r100;
        }

        public final Object a(com.enroll.audio.enroll.recorder.b r110, Continuation<? super Unit> r111) {
            if ((r111 instanceof EnrollStageView$observe$2$1$emit$1) == false) goto L7;
            EnrollStageView$observe$2$1$emit$1 r100 = (EnrollStageView$observe$2$1$emit$1) r111;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r112 = r100.result;
            Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r103 = r100.label;
            if (r103 == 0) goto L16;
            if (r103 == 1) goto L15;
            if (r103 != 2) goto L14;
            ResultKt.throwOnFailure(r112);
        L36:
            this.f273898a.getViewModel().getAsrState().setValue(Boxing.boxInt(0));
        L44:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r112);
        L42:
            this.f273898a.getViewModel().getAsrState().setValue(Boxing.boxInt(1));
            goto L44
        L16:
            ResultKt.throwOnFailure(r112);
            FLogger.f375446a.i("EnrollStageView", "observe recordingEvent " + r110);
            Iterator<T> r113 = this.f273898a.f273892b.iterator();
        L18:
            if (r113.hasNext() == false) goto L25;
            T r104 = r113.next();
            if (((EnrollTeamView) r104).getIndex() != r110.f273778a) goto L22;
            boolean r105 = true;
        L23:
            if (r105 == false) goto L18;
        L26:
            EnrollTeamView r106 = r104;
            if (r106 == null) goto L29;
            int r114 = a.f273899a[r110.f273779b.ordinal()];
            if (r114 == 1) goto L39;
            if (r114 != 2) goto L38;
            String r115 = r106.T5();
            CoroutineDispatcher r116 = Dispatchers.getIO();
            AnonymousClass2 r107 = new AnonymousClass2(r115, this.f273898a, null);
            r100.label = 2;
            if (BuildersKt.withContext(r116, r107, r100) != r102) goto L36;
            return r102;
        L38:
            throw new NoWhenBranchMatchedException();
        L39:
            String r117 = r106.T5();
            CoroutineDispatcher r118 = Dispatchers.getIO();
            C38331 r108 = new C38331(this.f273898a, r117, null);
            r100.label = 1;
            if (BuildersKt.withContext(r118, r108, r100) != r102) goto L42;
            return r102;
        L29:
            return Unit.INSTANCE;
        L22:
            r105 = false;
            goto L23
        L25:
            r104 = (T) null;
        L7:
            r100 = new EnrollStageView$observe$2$1$emit$1(this, r111);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a((com.enroll.audio.enroll.recorder.b) r100, r101);
        }
    }

    public EnrollStageView$observe$2(EnrollStageView r100, Continuation<? super EnrollStageView$observe$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new EnrollStageView$observe$2(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((EnrollStageView$observe$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L6;
        ResultKt.throwOnFailure(r100);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        MutableSharedFlow<com.enroll.audio.enroll.recorder.b> r103 = this.this$0.getViewModel().getRecordingEvent();
        AnonymousClass1 r104 = new AnonymousClass1(this.this$0);
        this.label = 1;
        if (r103.collect(r104, this) != r101) goto L12;
        return r101;
    }
}
