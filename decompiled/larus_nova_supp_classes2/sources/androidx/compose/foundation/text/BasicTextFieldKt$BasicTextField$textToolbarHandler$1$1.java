package androidx.compose.foundation.text;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextToolbarHandler;
import androidx.compose.foundation.text.input.internal.selection.TextToolbarState;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"androidx/compose/foundation/text/BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarHandler;", "showTextToolbar", "", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hideTextToolbar", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 implements TextToolbarHandler {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ TextToolbar $currentTextToolbar;

    @Override // androidx.compose.foundation.text.input.internal.selection.TextToolbarHandler
    public void hideTextToolbar() {
        if (this.$currentTextToolbar.getStatus() != TextToolbarStatus.Shown) goto L6;
        this.$currentTextToolbar.hide();
        return;
    }

    public BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1(TextToolbar r1, CoroutineScope r2) {
        this.$currentTextToolbar = r1;
        this.$coroutineScope = r2;
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextToolbarHandler
    public Object showTextToolbar(final TextFieldSelectionState r9, Rect r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1) == false) goto L7;
        BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1 r0 = (BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1) r11;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r9 = (TextFieldSelectionState) r0.L$3;
        final CoroutineScope r13 = (CoroutineScope) r0.L$2;
        TextToolbar r4 = (TextToolbar) r0.L$1;
        Rect r5 = (Rect) r0.L$0;
        ResultKt.throwOnFailure(r12);
        Rect r6 = r5;
        TextToolbar r7 = r4;
    L18:
        boolean r14 = r9.canCopy();
        final TextToolbarState r8 = TextToolbarState.None;
        Function0<Unit> r15 = null;
        if (r14 == true) goto L21;
        Function0<Unit> r16 = null;
    L23:
        if (r9.canPaste() == true) goto L25;
        Function0<Unit> r17 = null;
    L27:
        if (r9.canCut() == true) goto L29;
        Function0<Unit> r18 = null;
    L30:
        boolean r19 = r9.canSelectAll();
        final TextToolbarState r20 = TextToolbarState.Selection;
        if (r19 == true) goto L33;
        Function0<Unit> r110 = null;
    L35:
        if (r9.canAutofill() == false) goto L38;
        r15 = new BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$5$$inlined$menuItem$5(r9, r8, r9);
    L38:
        r7.showMenu(r6, r16, r17, r18, r110, r15);
        return Unit.INSTANCE;
    L33:
        r110 = new BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$5$$inlined$menuItem$4(r9, r20, r9);
        goto L35
    L29:
        r18 = new BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$5$$inlined$menuItem$3(r9, r8, r13, r9);
        goto L30
    L25:
        r17 = new BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$5$$inlined$menuItem$2(r9, r8, r13, r9);
        goto L27
    L21:
        r16 = new BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$5$$inlined$menuItem$1(r9, r8, r13, r9);
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        TextToolbar r111 = this.$currentTextToolbar;
        CoroutineScope r21 = this.$coroutineScope;
        r0.L$0 = r10;
        r0.L$1 = r111;
        r0.L$2 = r21;
        r0.L$3 = r9;
        r0.label = 1;
        if (r9.updateClipboardEntry(r0) != r2) goto L17;
        return r2;
    L17:
        r6 = r10;
        r7 = r111;
        r13 = r21;
    L7:
        r0 = new BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1(this, r11);
        goto L8
    }
}
