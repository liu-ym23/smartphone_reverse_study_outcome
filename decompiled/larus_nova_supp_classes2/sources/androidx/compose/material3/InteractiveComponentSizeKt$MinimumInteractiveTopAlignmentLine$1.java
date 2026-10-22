package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class InteractiveComponentSizeKt$MinimumInteractiveTopAlignmentLine$1 extends FunctionReferenceImpl implements Function2<Integer, Integer, Integer> {
    public static final InteractiveComponentSizeKt$MinimumInteractiveTopAlignmentLine$1 INSTANCE = null;

    static {
        INSTANCE = new InteractiveComponentSizeKt$MinimumInteractiveTopAlignmentLine$1();
    }

    public InteractiveComponentSizeKt$MinimumInteractiveTopAlignmentLine$1() {
        super(2, MathKt.class, "min", "min(II)I", 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), ((Number) r2).intValue());
    }

    public final Integer invoke(int r1, int r2) {
        return Integer.valueOf(Math.min(r1, r2));
    }
}
