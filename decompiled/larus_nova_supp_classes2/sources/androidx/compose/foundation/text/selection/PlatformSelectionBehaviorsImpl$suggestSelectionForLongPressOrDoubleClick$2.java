package androidx.compose.foundation.text.selection;

import android.os.Build;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/TextRange;", "Landroid/view/textclassifier/TextClassifier;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2", f = "PlatformSelectionBehaviors.android.kt", i = {0, 0, 0, 1}, l = {351, 158}, m = "invokeSuspend", n = {"suggestedSelection", "$this$withLock_u24default$iv", "newSelection", "newSelection"}, s = {"L$0", "L$1", "J$0", "J$0"})
public final class PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 extends SuspendLambda implements Function2<TextClassifier, Continuation<? super TextRange>, Object> {
    final /* synthetic */ long $selection;
    final /* synthetic */ CharSequence $text;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    public PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(CharSequence r1, long r2, PlatformSelectionBehaviorsImpl r4, Continuation<? super PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2> r5) {
        this.$text = r1;
        this.$selection = r2;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 r6 = new PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(this.$text, this.$selection, this.this$0, r9);
        r6.L$0 = r8;
        return r6;
    }

    public final Object invoke(TextClassifier r1, Continuation<? super TextRange> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((TextClassifier) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        long r2 = this.J$0;
        ResultKt.throwOnFailure(r18);
    L31:
        return TextRange.box-impl(r2);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r2 = this.J$0;
        CharSequence r3 = (CharSequence) this.L$3;
        PlatformSelectionBehaviorsImpl r4 = (PlatformSelectionBehaviorsImpl) this.L$2;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) this.L$1;
        TextSelection r6 = (TextSelection) this.L$0;
        ResultKt.throwOnFailure(r18);
        CharSequence r12 = r3;
    L32:
        TextClassification r15 = r6.getTextClassification();     // Catch: Throwable -> L23
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L23
        PlatformSelectionBehaviorsImpl.access$setTextClassificationResult(r4, new TextClassificationResult(r12, r2, r15, null));     // Catch: Throwable -> L23
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r5.unlock(null);
    L23:
        th = move-exception;
        r5.unlock(null);
        throw th;
    L10:
        ResultKt.throwOnFailure(r18);
        TextClassifier r8 = (TextClassifier) this.L$0;
        TextSelection.Request.Builder r9 = new TextSelection.Request.Builder(this.$text, TextRange.getMin-impl(this.$selection), TextRange.getMax-impl(this.$selection)).setDefaultLocales(PlatformSelectionBehaviorsImpl.access$getAndroidLocalList(this.this$0));
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 31) goto L13;
        r9.setIncludeTextClassification(true);
    L13:
        TextSelection r11 = r8.suggestSelection(r9.build());
        long r13 = TextRangeKt.TextRange(r11.getSelectionStartIndex(), r11.getSelectionEndIndex());
        if (r10 >= 31) goto L16;
    L26:
        PlatformSelectionBehaviorsImpl r14 = this.this$0;
        CharSequence r16 = this.$text;
        this.J$0 = r13;
        this.label = 2;
        if (PlatformSelectionBehaviorsImpl.m1838access$classifyTextM8tDOmk(r14, r16, r13, r8, this) != r0) goto L29;
        return r0;
    L29:
        r2 = r13;
        goto L31
    L16:
        if (r11.getTextClassification() == null) goto L26;
        r5 = PlatformSelectionBehaviorsImpl.access$getMutex$p(this.this$0);
        PlatformSelectionBehaviorsImpl r17 = this.this$0;
        CharSequence r19 = this.$text;
        this.L$0 = r11;
        this.L$1 = r5;
        this.L$2 = r17;
        this.L$3 = r19;
        this.J$0 = r13;
        this.label = 1;
        if (r5.a(null, this) != r0) goto L20;
        return r0;
    L20:
        r4 = r17;
        r12 = r19;
        r6 = r11;
        r2 = r13;
        goto L32
    }
}
