package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.text.input.internal.PartialGapBuffer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1 implements PointerInputEventHandler {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ State<Function1<Offset, Unit>> $onTapState;
    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
    final /* synthetic */ CoroutineScope $scope;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1", f = "TextFieldPressGestureFilter.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
        final /* synthetic */ CoroutineScope $scope;
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$1", f = "TextFieldPressGestureFilter.kt", i = {1}, l = {60, PartialGapBuffer.SURROUNDING_SIZE}, m = "invokeSuspend", n = {"interaction"}, s = {"L$0"})
        public static final class C00341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ MutableInteractionSource $interactionSource;
            final /* synthetic */ long $it;
            final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
            Object L$0;
            int label;

            public C00341(MutableState<PressInteraction.Press> r1, long r2, MutableInteractionSource r4, Continuation<? super C00341> r5) {
                this.$pressedInteraction = r1;
                this.$it = r2;
                this.$interactionSource = r4;
                super(2, r5);
            }

            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                return new C00341(this.$pressedInteraction, this.$it, this.$interactionSource, r8);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r8) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L9;
                if (r1 != 2) goto L8;
                PressInteraction.Press r2 = (PressInteraction.Press) this.L$0;
                ResultKt.throwOnFailure(r8);
            L26:
                PressInteraction.Press r9 = r2;
            L27:
                this.$pressedInteraction.setValue(r9);
                return Unit.INSTANCE;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                MutableState<PressInteraction.Press> r3 = (MutableState) this.L$0;
                ResultKt.throwOnFailure(r8);
            L18:
                MutableState<PressInteraction.Press> r5 = r3;
            L19:
                r5.setValue(null);
            L20:
                r9 = new PressInteraction.Press(this.$it, null);
                MutableInteractionSource r4 = this.$interactionSource;
                if (r4 == null) goto L27;
                this.L$0 = r9;
                this.label = 2;
                if (r4.emit(r9, this) != r0) goto L25;
                return r0;
            L25:
                r2 = r9;
                goto L26
            L10:
                ResultKt.throwOnFailure(r8);
                PressInteraction.Press r10 = (PressInteraction.Press) this.$pressedInteraction.getValue();
                if (r10 == null) goto L20;
                MutableInteractionSource r6 = this.$interactionSource;
                r5 = this.$pressedInteraction;
                PressInteraction.Cancel r7 = new PressInteraction.Cancel(r10);
                if (r6 == null) goto L19;
                this.L$0 = r5;
                this.label = 1;
                if (r6.emit(r7, this) != r0) goto L17;
                return r0;
            L17:
                r3 = r5;
                goto L18
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$2", f = "TextFieldPressGestureFilter.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ MutableInteractionSource $interactionSource;
            final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
            final /* synthetic */ boolean $success;
            Object L$0;
            int label;

            public AnonymousClass2(MutableState<PressInteraction.Press> r1, boolean r2, MutableInteractionSource r3, Continuation<? super AnonymousClass2> r4) {
                this.$pressedInteraction = r1;
                this.$success = r2;
                this.$interactionSource = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new AnonymousClass2(this.$pressedInteraction, this.$success, this.$interactionSource, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                MutableState<PressInteraction.Press> r2 = (MutableState) this.L$0;
                ResultKt.throwOnFailure(r6);
            L19:
                MutableState<PressInteraction.Press> r4 = r2;
            L20:
                r4.setValue(null);
            L22:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                PressInteraction.Press r7 = (PressInteraction.Press) this.$pressedInteraction.getValue();
                if (r7 == null) goto L22;
                boolean r3 = this.$success;
                MutableInteractionSource r5 = this.$interactionSource;
                r4 = this.$pressedInteraction;
                if (r3 == false) goto L13;
                Interaction r8 = new PressInteraction.Release(r7);
            L14:
                if (r5 == null) goto L20;
                this.L$0 = r4;
                this.label = 1;
                if (r5.emit(r8, this) != r0) goto L18;
                return r0;
            L18:
                r2 = r4;
                goto L19
            L13:
                r8 = new PressInteraction.Cancel(r7);
                goto L14
            }
        }

        public AnonymousClass1(CoroutineScope r1, MutableState<PressInteraction.Press> r2, MutableInteractionSource r3, Continuation<? super AnonymousClass1> r4) {
            this.$scope = r1;
            this.$pressedInteraction = r2;
            this.$interactionSource = r3;
            super(3, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
            return m1471invoked4ec7I((PressGestureScope) r3, ((Offset) r4).unbox-impl(), (Continuation) r5);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m1471invoked4ec7I(PressGestureScope r5, long r6, Continuation<? super Unit> r8) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$scope, this.$pressedInteraction, this.$interactionSource, r8);
            r0.L$0 = r5;
            r0.J$0 = r6;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L11:
            boolean r15 = ((Boolean) r14).booleanValue();
            BuildersKt.launch$default(this.$scope, null, null, new AnonymousClass2(this.$pressedInteraction, r15, this.$interactionSource, null), 3, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            PressGestureScope r16 = (PressGestureScope) this.L$0;
            long r5 = this.J$0;
            BuildersKt.launch$default(this.$scope, null, null, new C00341(this.$pressedInteraction, r5, this.$interactionSource, null), 3, null);
            this.label = 1;
            r14 = r16.tryAwaitRelease(this);
            if (r14 != r0) goto L11;
            return r0;
        }
    }

    public TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1(CoroutineScope r1, MutableState<PressInteraction.Press> r2, MutableInteractionSource r3, State<? extends Function1<? super Offset, Unit>> r4) {
        this.$scope = r1;
        this.$pressedInteraction = r2;
        this.$interactionSource = r3;
        this.$onTapState = r4;
    }

    public static /* synthetic */ Unit a(State r0, Offset r1) {
        return invoke$lambda$0(r0, r1);
    }

    private static final Unit invoke$lambda$0(State r0, Offset r1) {
        ((Function1) r0.getValue()).invoke(r1);
        return Unit.INSTANCE;
    }

    public final Object invoke(PointerInputScope r6, Continuation<? super Unit> r7) {
        AnonymousClass1 r0 = new AnonymousClass1(this.$scope, this.$pressedInteraction, this.$interactionSource, null);
        final State<Function1<Offset, Unit>> r1 = this.$onTapState;
        Object r8 = TapGestureDetectorKt.detectTapAndPress(r6, r0, new x3(r1), r7);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }
}
