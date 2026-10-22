package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$5$1$1", f = "ContextMenu.android.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
public final class ContextMenu_androidKt$ContextMenuArea$5$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<MenuItemsAvailability> $menuItemsAvailability;
    final /* synthetic */ TextFieldSelectionState $selectionState;
    Object L$0;
    int label;

    public ContextMenu_androidKt$ContextMenuArea$5$1$1(MutableState<MenuItemsAvailability> r1, TextFieldSelectionState r2, Continuation<? super ContextMenu_androidKt$ContextMenuArea$5$1$1> r3) {
        this.$menuItemsAvailability = r1;
        this.$selectionState = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ContextMenu_androidKt$ContextMenuArea$5$1$1(this.$menuItemsAvailability, this.$selectionState, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        MutableState<MenuItemsAvailability> r2 = (MutableState) this.L$0;
        ResultKt.throwOnFailure(r4);
    L12:
        r2.setValue(r4);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        MutableState<MenuItemsAvailability> r5 = this.$menuItemsAvailability;
        TextFieldSelectionState r3 = this.$selectionState;
        this.L$0 = r5;
        this.label = 1;
        Object r6 = ContextMenu_androidKt.getContextMenuItemsAvailability(r3, this);
        if (r6 != r0) goto L11;
        return r0;
    L11:
        r2 = r5;
        r4 = r6;
        goto L12
    }
}
