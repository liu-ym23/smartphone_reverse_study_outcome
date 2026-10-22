package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$modifier$1$1", f = "ContextMenu.android.kt", i = {}, l = {88, 89}, m = "invokeSuspend", n = {}, s = {})
public final class ContextMenu_androidKt$ContextMenuArea$modifier$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ TextFieldSelectionState $selectionState;
    int label;

    public ContextMenu_androidKt$ContextMenuArea$modifier$1$1(TextFieldSelectionState r1, Continuation<? super ContextMenu_androidKt$ContextMenuArea$modifier$1$1> r2) {
        this.$selectionState = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        return new ContextMenu_androidKt$ContextMenuArea$modifier$1$1(this.$selectionState, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L19:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L13:
        PlatformSelectionBehaviors r7 = this.$selectionState.getPlatformSelectionBehaviors$foundation_release();
        if (r7 == null) goto L19;
        CharSequence r2 = this.$selectionState.getTextFieldState$foundation_release().getVisualText().getText();
        long r3 = this.$selectionState.getTextFieldState$foundation_release().getVisualText().m1535getSelectiond9O1mEE();
        this.label = 2;
        if (r7.mo1836onShowContextMenuSbBc2M(r2, r3, this) != r0) goto L19;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        TextFieldSelectionState r8 = this.$selectionState;
        this.label = 1;
        if (r8.updateClipboardEntry(this) != r0) goto L13;
        return r0;
    }
}
