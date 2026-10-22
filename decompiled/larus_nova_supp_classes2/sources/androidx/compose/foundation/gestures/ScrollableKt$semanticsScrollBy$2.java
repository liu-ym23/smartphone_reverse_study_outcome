package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2", f = "Scrollable.kt", i = {}, l = {1052}, m = "invokeSuspend", n = {}, s = {})
public final class ScrollableKt$semanticsScrollBy$2 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $offset;
    final /* synthetic */ Ref.FloatRef $previousValue;
    final /* synthetic */ ScrollingLogic $this_semanticsScrollBy;
    private /* synthetic */ Object L$0;
    int label;

    public ScrollableKt$semanticsScrollBy$2(ScrollingLogic r1, long r2, Ref.FloatRef r4, Continuation<? super ScrollableKt$semanticsScrollBy$2> r5) {
        this.$this_semanticsScrollBy = r1;
        this.$offset = r2;
        this.$previousValue = r4;
        super(2, r5);
    }

    public static /* synthetic */ Unit a(Ref.FloatRef r0, ScrollingLogic r1, NestedScrollScope r2, float r3, float r4) {
        return invokeSuspend$lambda$0(r0, r1, r2, r3, r4);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        ScrollableKt$semanticsScrollBy$2 r6 = new ScrollableKt$semanticsScrollBy$2(this.$this_semanticsScrollBy, this.$offset, this.$previousValue, r9);
        r6.L$0 = r8;
        return r6;
    }

    public final Object invoke(NestedScrollScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((NestedScrollScope) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        final NestedScrollScope r13 = (NestedScrollScope) this.L$0;
        float r4 = this.$this_semanticsScrollBy.m701toFloatk4lQ0M(this.$offset);
        final Ref.FloatRef r2 = this.$previousValue;
        final ScrollingLogic r7 = this.$this_semanticsScrollBy;
        Function2 r8 = new e2(r2, r7, r13);
        this.label = 1;
        if (SuspendAnimationKt.animate$default(MenuKt.ClosedAlphaTarget, r4, MenuKt.ClosedAlphaTarget, null, r8, this, 12, null) != r0) goto L12;
        return r0;
    }

    private static final Unit invokeSuspend$lambda$0(Ref.FloatRef r1, ScrollingLogic r2, NestedScrollScope r3, float r4, float r5) {
        r1.element += r2.reverseIfNeeded(r2.m701toFloatk4lQ0M(r3.mo614scrollByOzD1aCk(r2.m702toOffsettuRUvjQ(r2.reverseIfNeeded(r4 - r1.element)), NestedScrollSource.Companion.getUserInput-WNlRxjI())));
        return Unit.INSTANCE;
    }
}
