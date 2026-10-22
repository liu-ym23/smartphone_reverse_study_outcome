package androidx.compose.material;

import androidx.appcompat.widget.RtlSpacingHelper;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SliderKt", f = "Slider.kt", i = {0}, l = {901}, m = "awaitSlop-8vUncbI", n = {"initialDelta"}, s = {"L$0"})
public final class SliderKt$awaitSlop$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public SliderKt$awaitSlop$1(Continuation<? super SliderKt$awaitSlop$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= RtlSpacingHelper.UNDEFINED;
        return SliderKt.m2151access$awaitSlop8vUncbI(null, 0, 0, this);
    }
}
