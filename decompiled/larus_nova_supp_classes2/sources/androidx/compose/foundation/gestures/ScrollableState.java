package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001JA\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\b\nH¦@¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&R\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableState;", "", "scroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "", "delta", "isScrollInProgress", "", "()Z", "canScrollForward", "getCanScrollForward", "canScrollBackward", "getCanScrollBackward", "lastScrolledForward", "getLastScrolledForward", "lastScrolledBackward", "getLastScrolledBackward", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ScrollableState {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableState$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$getCanScrollBackward(ScrollableState r0) {
            return true;
        }

        public static boolean $default$getCanScrollForward(ScrollableState r0) {
            return true;
        }

        public static boolean $default$getLastScrolledBackward(ScrollableState r0) {
            return false;
        }

        public static boolean $default$getLastScrolledForward(ScrollableState r0) {
            return false;
        }

        public static /* synthetic */ boolean access$getCanScrollBackward$jd(ScrollableState r0) {
            return $default$getCanScrollBackward(r0);
        }

        public static /* synthetic */ boolean access$getCanScrollForward$jd(ScrollableState r0) {
            return $default$getCanScrollForward(r0);
        }

        public static /* synthetic */ boolean access$getLastScrolledBackward$jd(ScrollableState r0) {
            return $default$getLastScrolledBackward(r0);
        }

        public static /* synthetic */ boolean access$getLastScrolledForward$jd(ScrollableState r0) {
            return $default$getLastScrolledForward(r0);
        }

        public static /* synthetic */ Object scroll$default(ScrollableState r0, MutatePriority r1, Function2 r2, Continuation r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 1) == 0) goto L7;
            r1 = MutatePriority.Default;
        L7:
            return r0.scroll(r1, r2, r3);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scroll");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean getCanScrollBackward(ScrollableState r0) {
            return CC.access$getCanScrollBackward$jd(r0);
        }

        public static boolean getCanScrollForward(ScrollableState r0) {
            return CC.access$getCanScrollForward$jd(r0);
        }

        public static boolean getLastScrolledBackward(ScrollableState r0) {
            return CC.access$getLastScrolledBackward$jd(r0);
        }

        public static boolean getLastScrolledForward(ScrollableState r0) {
            return CC.access$getLastScrolledForward$jd(r0);
        }

        public static /* synthetic */ Object scroll$default(ScrollableState r0, MutatePriority r1, Function2 r2, Continuation r3, int r4, Object r5) {
            return CC.scroll$default(r0, r1, r2, r3, r4, r5);
        }
    }

    float dispatchRawDelta(float r1);

    boolean getCanScrollBackward();

    boolean getCanScrollForward();

    boolean getLastScrolledBackward();

    boolean getLastScrolledForward();

    boolean isScrollInProgress();

    Object scroll(MutatePriority r1, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super Unit> r3);
}
