package androidx.compose.foundation;

import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/FixedMotionDurationScale;", "Landroidx/compose/ui/MotionDurationScale;", "<init>", "()V", "scaleFactor", "", "getScaleFactor", "()F", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class FixedMotionDurationScale implements MotionDurationScale {
    public static final FixedMotionDurationScale INSTANCE = null;

    static {
        INSTANCE = new FixedMotionDurationScale();
    }

    private FixedMotionDurationScale() {
    }

    public final /* synthetic */ CoroutineContext.Key getKey() {
        return MotionDurationScale.-CC.$default$getKey(this);
    }

    public float getScaleFactor() {
        return 1.0f;
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r1) {
        return (E) MotionDurationScale.DefaultImpls.get(this, r1);
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> r1) {
        return MotionDurationScale.DefaultImpls.minusKey(this, r1);
    }

    public CoroutineContext plus(CoroutineContext r1) {
        return MotionDurationScale.DefaultImpls.plus(this, r1);
    }

    public <R> R fold(R r1, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r2) {
        return (R) MotionDurationScale.DefaultImpls.fold(this, r1, r2);
    }
}
