package androidx.compose.foundation.text.selection;

import android.view.textclassifier.TextClassifier;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroid/view/textclassifier/TextClassifier;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$onShowContextMenu$2", f = "PlatformSelectionBehaviors.android.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
public final class PlatformSelectionBehaviorsImpl$onShowContextMenu$2 extends SuspendLambda implements Function2<TextClassifier, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $selection;
    final /* synthetic */ CharSequence $text;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    public PlatformSelectionBehaviorsImpl$onShowContextMenu$2(PlatformSelectionBehaviorsImpl r1, CharSequence r2, long r3, Continuation<? super PlatformSelectionBehaviorsImpl$onShowContextMenu$2> r5) {
        this.this$0 = r1;
        this.$text = r2;
        this.$selection = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        PlatformSelectionBehaviorsImpl$onShowContextMenu$2 r6 = new PlatformSelectionBehaviorsImpl$onShowContextMenu$2(this.this$0, this.$text, this.$selection, r9);
        r6.L$0 = r8;
        return r6;
    }

    public final Object invoke(TextClassifier r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((TextClassifier) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        TextClassifier r7 = (TextClassifier) this.L$0;
        PlatformSelectionBehaviorsImpl r3 = this.this$0;
        CharSequence r4 = this.$text;
        long r5 = this.$selection;
        this.label = 1;
        if (PlatformSelectionBehaviorsImpl.m1838access$classifyTextM8tDOmk(r3, r4, r5, r7, this) != r0) goto L12;
        return r0;
    }
}
