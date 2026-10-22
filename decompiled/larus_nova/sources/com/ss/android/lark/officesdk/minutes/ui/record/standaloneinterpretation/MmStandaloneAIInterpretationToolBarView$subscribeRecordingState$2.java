package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MMRecordingState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MMRecordingState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationToolBarView$subscribeRecordingState$2", f = "MmStandaloneAIInterpretationToolBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmStandaloneAIInterpretationToolBarView$subscribeRecordingState$2 extends SuspendLambda implements Function2<MMRecordingState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationToolBarView this$0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f436740a = null;

        static {
            int[] r100 = new int[MMRecordingState.values().length];
            r100[MMRecordingState.RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MMRecordingState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f436740a = r100;
        }
    }

    public MmStandaloneAIInterpretationToolBarView$subscribeRecordingState$2(MmStandaloneAIInterpretationToolBarView r100, Continuation<? super MmStandaloneAIInterpretationToolBarView$subscribeRecordingState$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmStandaloneAIInterpretationToolBarView$subscribeRecordingState$2 r102 = new MmStandaloneAIInterpretationToolBarView$subscribeRecordingState$2(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(MMRecordingState r100, Continuation<? super Unit> r101) {
        return ((MmStandaloneAIInterpretationToolBarView$subscribeRecordingState$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(MMRecordingState r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        MMRecordingState r101 = (MMRecordingState) this.L$0;
        int r102 = a.f436740a[r101.ordinal()];
        if (r102 != 1) goto L7;
        MmStandaloneAIInterpretationToolBarView r103 = this.this$0;
        int r104 = MmStandaloneAIInterpretationToolBarView.f436731f;
        r103.S5(r103.T5().b(), this.this$0.T5().d(), this.this$0.T5().h());
        this.this$0.f436732a.f516040h.setEnabled(true);
        this.this$0.f436735d.setEnabled(true);
        this.this$0.f436732a.f516035c.g();
    L12:
        return Unit.INSTANCE;
    L7:
        if (r102 == 2) goto L9;
        MmStandaloneAIInterpretationToolBarView r105 = this.this$0;
        int r106 = MmStandaloneAIInterpretationToolBarView.f436731f;
        r105.S5(r105.T5().j(), this.this$0.T5().i(), this.this$0.T5().g());
        this.this$0.f436732a.f516040h.setEnabled(false);
        this.this$0.f436735d.setEnabled(false);
        this.this$0.f436732a.f516035c.b();
        goto L12
    L9:
        MmStandaloneAIInterpretationToolBarView r107 = this.this$0;
        int r108 = MmStandaloneAIInterpretationToolBarView.f436731f;
        r107.S5(r107.T5().j(), this.this$0.T5().d(), this.this$0.T5().h());
        this.this$0.f436732a.f516040h.setEnabled(true);
        this.this$0.f436735d.setEnabled(true);
        this.this$0.f436732a.f516035c.b();
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
