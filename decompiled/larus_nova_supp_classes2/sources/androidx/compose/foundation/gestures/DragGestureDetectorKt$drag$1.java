package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0}, l = {111}, m = "drag-jO51t88", n = {"$this$drag_u2djO51t88", "onDrag"}, s = {"L$0", "L$1"})
public final class DragGestureDetectorKt$drag$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public DragGestureDetectorKt$drag$1(Continuation<? super DragGestureDetectorKt$drag$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= RtlSpacingHelper.UNDEFINED;
        return DragGestureDetectorKt.m584dragjO51t88(null, 0, null, this);
    }
}
