package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1", f = "TextFieldSelectionState.kt", i = {}, l = {516, 524}, m = "invokeSuspend", n = {}, s = {})
public final class TextFieldSelectionState$detectTextFieldTapGestures$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PressGestureScope $$this$detectTapAndPress;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $offset;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1$1", f = "TextFieldSelectionState.kt", i = {1}, l = {508, 513}, m = "invokeSuspend", n = {"press"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ long $offset;
        Object L$0;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        public AnonymousClass1(TextFieldSelectionState r1, long r2, MutableInteractionSource r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$offset = r2;
            this.$interactionSource = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$offset, this.$interactionSource, r8);
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
        L21:
            TextFieldSelectionState.access$setPressInteraction$p(this.this$0, r2);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            TextFieldSelectionState r3 = (TextFieldSelectionState) this.L$0;
            ResultKt.throwOnFailure(r8);
        L16:
            TextFieldSelectionState.access$setPressInteraction$p(r3, null);
        L17:
            PressInteraction.Press r9 = new PressInteraction.Press(this.$offset, null);
            MutableInteractionSource r4 = this.$interactionSource;
            this.L$0 = r9;
            this.label = 2;
            if (r4.emit(r9, this) != r0) goto L20;
            return r0;
        L20:
            r2 = r9;
            goto L21
        L10:
            ResultKt.throwOnFailure(r8);
            PressInteraction.Press r10 = TextFieldSelectionState.access$getPressInteraction$p(this.this$0);
            if (r10 == null) goto L17;
            MutableInteractionSource r5 = this.$interactionSource;
            TextFieldSelectionState r6 = this.this$0;
            PressInteraction.Cancel r7 = new PressInteraction.Cancel(r10);
            this.L$0 = r6;
            this.label = 1;
            if (r5.emit(r7, this) != r0) goto L15;
            return r0;
        L15:
            r3 = r6;
            goto L16
        }
    }

    public TextFieldSelectionState$detectTextFieldTapGestures$2$1$1(PressGestureScope r1, TextFieldSelectionState r2, long r3, MutableInteractionSource r5, Continuation<? super TextFieldSelectionState$detectTextFieldTapGestures$2$1$1> r6) {
        this.$$this$detectTapAndPress = r1;
        this.this$0 = r2;
        this.$offset = r3;
        this.$interactionSource = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        TextFieldSelectionState$detectTextFieldTapGestures$2$1$1 r7 = new TextFieldSelectionState$detectTextFieldTapGestures$2$1$1(this.$$this$detectTapAndPress, this.this$0, this.$offset, this.$interactionSource, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L22:
        TextFieldSelectionState.access$setPressInteraction$p(this.this$0, null);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
    L13:
        boolean r15 = ((Boolean) r14).booleanValue();
        PressInteraction.Press r2 = TextFieldSelectionState.access$getPressInteraction$p(this.this$0);
        if (r2 == null) goto L22;
        MutableInteractionSource r3 = this.$interactionSource;
        if (r15 == false) goto L18;
        Interaction r16 = new PressInteraction.Release(r2);
    L19:
        this.label = 2;
        if (r3.emit(r16, this) != r0) goto L22;
        return r0;
    L18:
        r16 = new PressInteraction.Cancel(r2);
        goto L19
    L10:
        ResultKt.throwOnFailure(r14);
        BuildersKt.launch$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(this.this$0, this.$offset, this.$interactionSource, null), 3, null);
        PressGestureScope r17 = this.$$this$detectTapAndPress;
        this.label = 1;
        r14 = r17.tryAwaitRelease(this);
        if (r14 != r0) goto L13;
        return r0;
    }
}
