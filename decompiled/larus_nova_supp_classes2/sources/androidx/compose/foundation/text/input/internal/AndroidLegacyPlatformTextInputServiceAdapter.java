package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.PlatformTextInputSession;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\n0\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\n0\u0014H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u001e\u0010\u000e\u001a\u00020\n2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014H\u0002J\b\u0010\u001a\u001a\u00020\nH\u0016J\u001a\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0016JD\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\n0\u00142\u0006\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020 H\u0016J\b\u0010+\u001a\u00020\nH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006,"}, d2 = {"Landroidx/compose/foundation/text/input/internal/AndroidLegacyPlatformTextInputServiceAdapter;", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "<init>", "()V", "job", "Lkotlinx/coroutines/Job;", "currentRequest", "Landroidx/compose/foundation/text/input/internal/LegacyTextInputMethodRequest;", "backingStylusHandwritingTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "stylusHandwritingTrigger", "getStylusHandwritingTrigger", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "startInput", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onEditCommand", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/input/EditCommand;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "initializeRequest", "stopInput", "updateState", "oldValue", "newValue", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateTextLayoutResult", "textFieldValue", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "textFieldToRootTransform", "Landroidx/compose/ui/graphics/Matrix;", "innerTextFieldBounds", "decorationBoxBounds", "startStylusHandwriting", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidLegacyPlatformTextInputServiceAdapter extends LegacyPlatformTextInputServiceAdapter {
    public static final int $stable = 8;
    private MutableSharedFlow<Unit> backingStylusHandwritingTrigger;
    private LegacyTextInputMethodRequest currentRequest;
    private Job job;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/PlatformTextInputSession;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2", f = "LegacyPlatformTextInputServiceAdapter.android.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<PlatformTextInputSession, Continuation<?>, Object> {
        final /* synthetic */ Function1<LegacyTextInputMethodRequest, Unit> $initializeRequest;
        final /* synthetic */ LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode $node;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1", f = "LegacyPlatformTextInputServiceAdapter.android.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            final /* synthetic */ PlatformTextInputSession $$this$launchTextInputSession;
            final /* synthetic */ Function1<LegacyTextInputMethodRequest, Unit> $initializeRequest;
            final /* synthetic */ LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode $node;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter this$0;

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1", f = "LegacyPlatformTextInputServiceAdapter.android.kt", i = {}, l = {140, 141}, m = "invokeSuspend", n = {}, s = {})
            public static final class C00361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ InputMethodManager $inputMethodManager;
                int label;
                final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter this$0;

                public C00361(AndroidLegacyPlatformTextInputServiceAdapter r1, InputMethodManager r2, Continuation<? super C00361> r3) {
                    this.this$0 = r1;
                    this.$inputMethodManager = r2;
                    super(2, r3);
                }

                public static /* synthetic */ Unit a(long r0) {
                    return invokeSuspend$lambda$0(r0);
                }

                public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                    return new C00361(this.this$0, this.$inputMethodManager, r4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((CoroutineScope) r1, (Continuation) r2);
                }

                public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                    return create(r1, r2).invokeSuspend(Unit.INSTANCE);
                }

                private static final Unit invokeSuspend$lambda$0(long r0) {
                    return Unit.INSTANCE;
                }

                public final Object invokeSuspend(Object r5) {
                    Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r1 = this.label;
                    if (r1 == 0) goto L10;
                    if (r1 == 1) goto L9;
                    if (r1 != 2) goto L7;
                    ResultKt.throwOnFailure(r5);
                L19:
                    throw new KotlinNothingValueException();
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L9:
                    ResultKt.throwOnFailure(r5);
                L13:
                    MutableSharedFlow r6 = AndroidLegacyPlatformTextInputServiceAdapter.access$getStylusHandwritingTrigger(this.this$0);
                    if (r6 == null) goto L21;
                    final InputMethodManager r3 = this.$inputMethodManager;
                    FlowCollector r2 = new C00372(r3);
                    this.label = 2;
                    if (r6.collect(r2, this) != r0) goto L19;
                    return r0;
                L21:
                    return Unit.INSTANCE;
                L10:
                    ResultKt.throwOnFailure(r5);
                    Function1 r7 = new b();
                    this.label = 1;
                    if (MonotonicFrameClockKt.withFrameMillis(r7, this) != r0) goto L13;
                    return r0;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(PlatformTextInputSession r1, Function1<? super LegacyTextInputMethodRequest, Unit> r2, AndroidLegacyPlatformTextInputServiceAdapter r3, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode r4, Continuation<? super AnonymousClass1> r5) {
                this.$$this$launchTextInputSession = r1;
                this.$initializeRequest = r2;
                this.this$0 = r3;
                this.$node = r4;
                super(2, r5);
            }

            public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
                AnonymousClass1 r6 = new AnonymousClass1(this.$$this$launchTextInputSession, this.$initializeRequest, this.this$0, this.$node, r9);
                r6.L$0 = r8;
                return r6;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<?> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r11) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L11;
                if (r1 != 1) goto L6;
                ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L9
            L22:
                throw new KotlinNothingValueException();     // Catch: Throwable -> L9
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                ResultKt.throwOnFailure(r11);
                CoroutineScope r4 = (CoroutineScope) this.L$0;
                InputMethodManager r12 = (InputMethodManager) LegacyPlatformTextInputServiceAdapter_androidKt.getInputMethodManagerFactory().invoke(this.$$this$launchTextInputSession.getView());
                LegacyTextInputMethodRequest r2 = new LegacyTextInputMethodRequest(this.$$this$launchTextInputSession.getView(), new AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1(this.$node), r12);
                if (StylusHandwriting_androidKt.isStylusHandwritingSupported() == false) goto L14;
                BuildersKt.launch$default(r4, null, null, new C00361(this.this$0, r12, null), 3, null);
            L14:
                Function1<LegacyTextInputMethodRequest, Unit> r13 = this.$initializeRequest;
                if (r13 == null) goto L17;
                r13.invoke(r2);
            L17:
                AndroidLegacyPlatformTextInputServiceAdapter.access$setCurrentRequest$p(this.this$0, r2);
                PlatformTextInputSession r14 = this.$$this$launchTextInputSession;     // Catch: Throwable -> L9
                this.label = 1;     // Catch: Throwable -> L9
                if (r14.startInputMethod(r2, this) != r0) goto L22;
                return r0;
            L9:
                th = move-exception;
                AndroidLegacyPlatformTextInputServiceAdapter.access$setCurrentRequest$p(this.this$0, null);
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super LegacyTextInputMethodRequest, Unit> r1, AndroidLegacyPlatformTextInputServiceAdapter r2, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode r3, Continuation<? super AnonymousClass2> r4) {
            this.$initializeRequest = r1;
            this.this$0 = r2;
            this.$node = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$initializeRequest, this.this$0, this.$node, r6);
            r0.L$0 = r5;
            return r0;
        }

        public final Object invoke(PlatformTextInputSession r1, Continuation<?> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((PlatformTextInputSession) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r10);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            AnonymousClass1 r11 = new AnonymousClass1((PlatformTextInputSession) this.L$0, this.$initializeRequest, this.this$0, this.$node, null);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(r11, this) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ Unit a(TextFieldValue r0, AndroidLegacyPlatformTextInputServiceAdapter r1, ImeOptions r2, Function1 r3, Function1 r4, LegacyTextInputMethodRequest r5) {
        return startInput$lambda$1(r0, r1, r2, r3, r4, r5);
    }

    @Override // androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter
    public void startInput() {
        startInput(null);
    }

    private final MutableSharedFlow<Unit> getStylusHandwritingTrigger() {
        MutableSharedFlow<Unit> r0 = this.backingStylusHandwritingTrigger;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (StylusHandwriting_androidKt.isStylusHandwritingSupported() == true) goto L8;
        return null;
    L8:
        MutableSharedFlow<Unit> r1 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_LATEST, 2, null);
        this.backingStylusHandwritingTrigger = r1;
        return r1;
    }

    public void stopInput() {
        Job r0 = this.job;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.job = null;
        MutableSharedFlow<Unit> r1 = getStylusHandwritingTrigger();
        if (r1 == null) goto L9;
        r1.resetReplayCache();
        return;
    }

    @Override // androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter
    public void startStylusHandwriting() {
        MutableSharedFlow<Unit> r0 = getStylusHandwritingTrigger();
        if (r0 == null) goto L6;
        r0.tryEmit(Unit.INSTANCE);
        return;
    }

    public AndroidLegacyPlatformTextInputServiceAdapter() {
    }

    public static final /* synthetic */ MutableSharedFlow access$getStylusHandwritingTrigger(AndroidLegacyPlatformTextInputServiceAdapter r0) {
        return r0.getStylusHandwritingTrigger();
    }

    private final void startInput(Function1<? super LegacyTextInputMethodRequest, Unit> r4) {
        LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode r0 = getTextInputModifierNode();
        if (r0 != null) goto L5;
        return;
    L5:
        this.job = r0.launchTextInputSession(new AnonymousClass2(r4, this, r0, null));
    }

    @Override // androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter
    public void notifyFocusedRect(Rect r2) {
        LegacyTextInputMethodRequest r0 = this.currentRequest;
        if (r0 == null) goto L6;
        r0.notifyFocusedRect(r2);
        return;
    }

    public static final /* synthetic */ void access$setCurrentRequest$p(AndroidLegacyPlatformTextInputServiceAdapter r0, LegacyTextInputMethodRequest r1) {
        r0.currentRequest = r1;
    }

    public static final /* synthetic */ void access$startInput$localToScreen(LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode r0, float[] r1) {
        startInput$localToScreen(r0, r1);
    }

    private static final void startInput$localToScreen(LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode r1, float[] r2) {
        LayoutCoordinates r3 = r1.getLayoutCoordinates();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isAttached() == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L13;
        r3.transformToScreen-58bKbWc(r2);
        return;
    }

    public void updateState(TextFieldValue r2, TextFieldValue r3) {
        LegacyTextInputMethodRequest r0 = this.currentRequest;
        if (r0 == null) goto L6;
        r0.updateState(r2, r3);
        return;
    }

    public void startInput(final TextFieldValue r8, final ImeOptions r9, final Function1<? super List<? extends EditCommand>, Unit> r10, final Function1<? super ImeAction, Unit> r11) {
        startInput(new a(r8, this, r9, r10, r11));
    }

    private static final Unit startInput$lambda$1(TextFieldValue r6, AndroidLegacyPlatformTextInputServiceAdapter r7, ImeOptions r8, Function1 r9, Function1 r10, LegacyTextInputMethodRequest r11) {
        r11.startInput(r6, r7.getTextInputModifierNode(), r8, r9, r10);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter
    public void updateTextLayoutResult(TextFieldValue r7, OffsetMapping r8, TextLayoutResult r9, Function1<? super Matrix, Unit> r10, Rect r11, Rect r12) {
        LegacyTextInputMethodRequest r0 = this.currentRequest;
        if (r0 == null) goto L6;
        r0.updateTextLayoutResult(r7, r8, r9, r11, r12);
        return;
    }
}
