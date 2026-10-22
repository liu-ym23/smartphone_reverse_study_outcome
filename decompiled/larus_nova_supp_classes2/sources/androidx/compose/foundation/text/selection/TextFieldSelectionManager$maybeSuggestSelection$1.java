package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager$maybeSuggestSelection$1", f = "TextFieldSelectionManager.kt", i = {}, l = {539}, m = "invokeSuspend", n = {}, s = {})
public final class TextFieldSelectionManager$maybeSuggestSelection$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ PlatformSelectionBehaviors $platformSelectionBehaviors;
    final /* synthetic */ TextRange $selection;
    final /* synthetic */ String $text;
    final /* synthetic */ long $transformedSelection;
    int label;
    final /* synthetic */ TextFieldSelectionManager this$0;

    public TextFieldSelectionManager$maybeSuggestSelection$1(PlatformSelectionBehaviors r1, String r2, long r3, TextRange r5, TextFieldSelectionManager r6, OffsetMapping r7, Continuation<? super TextFieldSelectionManager$maybeSuggestSelection$1> r8) {
        this.$platformSelectionBehaviors = r1;
        this.$text = r2;
        this.$transformedSelection = r3;
        this.$selection = r5;
        this.this$0 = r6;
        this.$offsetMapping = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new TextFieldSelectionManager$maybeSuggestSelection$1(this.$platformSelectionBehaviors, this.$text, this.$transformedSelection, this.$selection, this.this$0, this.$offsetMapping, r11);
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
        ResultKt.throwOnFailure(r6);
    L11:
        TextRange r7 = (TextRange) r6;
        if (r7 == null) goto L23;
        OffsetMapping r2 = this.$offsetMapping;
        long r3 = r7.unbox-impl();
        long r4 = TextRangeKt.TextRange(r2.transformedToOriginal(TextRange.getStart-impl(r3)), r2.transformedToOriginal(TextRange.getEnd-impl(r3)));
        if (TextRange.equals-impl(r4, this.$selection) == true) goto L21;
        if (Intrinsics.areEqual(this.this$0.getValue$foundation_release().getText(), this.$text) == false) goto L21;
        if (this.$offsetMapping != this.this$0.getOffsetMapping$foundation_release()) goto L21;
        Function1<TextFieldValue, Unit> r8 = this.this$0.getOnValueChange$foundation_release();
        TextFieldSelectionManager r5 = this.this$0;
        r8.invoke(TextFieldSelectionManager.m1891access$createTextFieldValueFDrldGo(r5, r5.getValue$foundation_release().getAnnotatedString(), r4));
        this.this$0.m1907setLatestSelectionOEnZFl4$foundation_release(TextRange.box-impl(r4));
    L21:
        return Unit.INSTANCE;
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        PlatformSelectionBehaviors r9 = this.$platformSelectionBehaviors;
        String r10 = this.$text;
        long r11 = this.$transformedSelection;
        this.label = 1;
        r6 = r9.mo1837suggestSelectionForLongPressOrDoubleClickpYaCww(r10, r11, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
