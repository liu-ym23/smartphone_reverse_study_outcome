package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic2D", f = "Scrollable2D.kt", i = {0}, l = {444}, m = "doFlingAnimation-QWom1Mo", n = {"result"}, s = {"L$0"})
public final class ScrollingLogic2D$doFlingAnimation$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScrollingLogic2D this$0;

    public ScrollingLogic2D$doFlingAnimation$1(ScrollingLogic2D r1, Continuation<? super ScrollingLogic2D$doFlingAnimation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= RtlSpacingHelper.UNDEFINED;
        return this.this$0.mo656doFlingAnimationQWom1Mo(0, this);
    }
}
