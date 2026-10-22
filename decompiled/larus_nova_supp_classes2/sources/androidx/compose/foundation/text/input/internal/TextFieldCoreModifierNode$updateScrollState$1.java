package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.ui.geometry.Rect;
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
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$updateScrollState$1", f = "TextFieldCoreModifier.kt", i = {}, l = {503, 509}, m = "invokeSuspend", n = {}, s = {})
public final class TextFieldCoreModifierNode$updateScrollState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $offsetDifference;
    final /* synthetic */ Rect $rawCursorRect;
    final /* synthetic */ boolean $shouldBringIntoView;
    int label;
    final /* synthetic */ TextFieldCoreModifierNode this$0;

    public TextFieldCoreModifierNode$updateScrollState$1(TextFieldCoreModifierNode r1, float r2, boolean r3, Rect r4, Continuation<? super TextFieldCoreModifierNode$updateScrollState$1> r5) {
        this.this$0 = r1;
        this.$offsetDifference = r2;
        this.$shouldBringIntoView = r3;
        this.$rawCursorRect = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new TextFieldCoreModifierNode$updateScrollState$1(this.this$0, this.$offsetDifference, this.$shouldBringIntoView, this.$rawCursorRect, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r5);
    L19:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L14:
        if (this.$shouldBringIntoView == false) goto L19;
        BringIntoViewRequester r6 = TextFieldCoreModifierNode.access$getTextLayoutState$p(this.this$0).getBringIntoViewRequester();
        Rect r2 = this.$rawCursorRect;
        this.label = 2;
        if (r6.bringIntoView(r2, this) != r0) goto L19;
        return r0;
    L10:
        ResultKt.throwOnFailure(r5);
        ScrollState r7 = TextFieldCoreModifierNode.access$getScrollState$p(this.this$0);
        float r3 = TextFieldCoreModifierKt.access$roundToNext(this.$offsetDifference);
        this.label = 1;
        if (ScrollExtensionsKt.scrollBy(r7, r3, this) != r0) goto L14;
        return r0;
    }
}
