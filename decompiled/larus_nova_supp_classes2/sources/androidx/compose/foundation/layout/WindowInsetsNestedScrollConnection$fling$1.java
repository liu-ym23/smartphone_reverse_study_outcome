package androidx.compose.foundation.layout;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.material3.MenuKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection", f = "WindowInsetsConnection.android.kt", i = {0, 0, 1, 1, 2}, l = {301, 327, 352}, m = "fling-huYlsQE", n = {"available", "flingAmount", "endVelocity", "available", "available"}, s = {"J$0", "F$0", "L$0", "J$0", "J$0"})
public final class WindowInsetsNestedScrollConnection$fling$1 extends ContinuationImpl {
    float F$0;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

    public WindowInsetsNestedScrollConnection$fling$1(WindowInsetsNestedScrollConnection r1, Continuation<? super WindowInsetsNestedScrollConnection$fling$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= RtlSpacingHelper.UNDEFINED;
        return WindowInsetsNestedScrollConnection.m1047access$flinghuYlsQE(this.this$0, 0, MenuKt.ClosedAlphaTarget, false, this);
    }
}
