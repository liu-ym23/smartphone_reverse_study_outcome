package androidx.compose.material;

import androidx.appcompat.widget.RtlSpacingHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SwipeableState", f = "Swipeable.kt", i = {1, 1, 2, 2}, l = {154, 179, 182}, m = "processNewAnchors$material", n = {"newAnchors", "targetOffset", "newAnchors", "targetOffset"}, s = {"L$0", "F$0", "L$0", "F$0"})
public final class SwipeableState$processNewAnchors$1 extends ContinuationImpl {
    float F$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SwipeableState<T> this$0;

    public SwipeableState$processNewAnchors$1(SwipeableState<T> r1, Continuation<? super SwipeableState$processNewAnchors$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= RtlSpacingHelper.UNDEFINED;
        return this.this$0.processNewAnchors$material(null, null, (Continuation<? super Unit>) this);
    }
}
