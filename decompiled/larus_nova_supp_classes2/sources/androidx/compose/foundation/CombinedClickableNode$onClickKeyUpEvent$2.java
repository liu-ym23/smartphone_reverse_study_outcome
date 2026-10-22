package androidx.compose.foundation;

import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.CombinedClickableNode$onClickKeyUpEvent$2", f = "Clickable.kt", i = {0, 0}, l = {1268, 1272}, m = "invokeSuspend", n = {"minTime", "timeout"}, s = {"J$0", "J$1"})
public final class CombinedClickableNode$onClickKeyUpEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $keyCode;
    long J$0;
    long J$1;
    int label;
    final /* synthetic */ CombinedClickableNode this$0;

    public CombinedClickableNode$onClickKeyUpEvent$2(CombinedClickableNode r1, long r2, Continuation<? super CombinedClickableNode$onClickKeyUpEvent$2> r4) {
        this.this$0 = r1;
        this.$keyCode = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CombinedClickableNode$onClickKeyUpEvent$2(this.this$0, this.$keyCode, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L19:
        this.this$0.getOnClick().invoke();
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        long r4 = this.J$1;
        long r6 = this.J$0;
        ResultKt.throwOnFailure(r11);
    L13:
        CombinedClickableNode.DoubleKeyClickState r12 = (CombinedClickableNode.DoubleKeyClickState) CombinedClickableNode.access$getDoubleKeyClickStates$p(this.this$0).get(this.$keyCode);
        if (r12 == null) goto L16;
        r12.setDoubleTapMinTimeMillisElapsed(true);
    L16:
        this.label = 2;
        if (DelayKt.delay(r4 - r6, this) != r0) goto L19;
        return r0;
    L10:
        ResultKt.throwOnFailure(r11);
        ViewConfiguration r13 = (ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, CompositionLocalsKt.getLocalViewConfiguration());
        r6 = r13.getDoubleTapMinTimeMillis();
        r4 = r13.getDoubleTapTimeoutMillis();
        this.J$0 = r6;
        this.J$1 = r4;
        this.label = 1;
        if (DelayKt.delay(r6, this) != r0) goto L13;
        return r0;
    }
}
