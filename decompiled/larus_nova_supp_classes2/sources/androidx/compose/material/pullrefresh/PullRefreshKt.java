package androidx.compose.material.pullrefresh;

import androidx.autofill.HintConstants;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001aq\u0010\u0000\u001a\u00020\u0001*\u00020\u00012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b0\u000721\u0010\f\u001a-\b\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"pullRefresh", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "enabled", "", "onPull", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "pullDelta", "onRelease", "Lkotlin/Function2;", "flingVelocity", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Z)Landroidx/compose/ui/Modifier;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PullRefreshKt {

    /* JADX INFO: renamed from: androidx.compose.material.pullrefresh.PullRefreshKt$pullRefresh$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Float, Float> {
        public AnonymousClass1(Object r8) {
            super(1, r8, PullRefreshState.class, "onPull", "onPull$material(F)F", 0);
        }

        public final Float invoke(float r2) {
            return Float.valueOf(((PullRefreshState) ((CallableReference) this).receiver).onPull$material(r2));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Number) r1).floatValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.pullrefresh.PullRefreshKt$pullRefresh$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends AdaptedFunctionReference implements Function2<Float, Continuation<? super Float>, Object>, SuspendFunction {
        public AnonymousClass2(Object r8) {
            super(2, r8, PullRefreshState.class, "onRelease", "onRelease$material(F)F", 4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Number) r1).floatValue(), (Continuation) r2);
        }

        public final Object invoke(float r2, Continuation<? super Float> r3) {
            return PullRefreshKt.access$pullRefresh$onRelease((PullRefreshState) ((AdaptedFunctionReference) this).receiver, r2, r3);
        }
    }

    public static final /* synthetic */ Object access$pullRefresh$onRelease(PullRefreshState r0, float r1, Continuation r2) {
        return pullRefresh$onRelease(r0, r1, r2);
    }

    public static final Modifier pullRefresh(Modifier r2, PullRefreshState r3, boolean r4) {
        return pullRefresh(r2, new AnonymousClass1(r3), new AnonymousClass2(r3), r4);
    }

    private static final /* synthetic */ Object pullRefresh$onRelease(PullRefreshState r0, float r1, Continuation r2) {
        return Boxing.boxFloat(r0.onRelease$material(r1));
    }

    public static final Modifier pullRefresh(Modifier r1, Function1<? super Float, Float> r2, Function2<? super Float, ? super Continuation<? super Float>, ? extends Object> r3, boolean r4) {
        return NestedScrollModifierKt.nestedScroll$default(r1, new PullRefreshNestedScrollConnection(r2, r3, r4), null, 2, null);
    }

    public static /* synthetic */ Modifier pullRefresh$default(Modifier r0, PullRefreshState r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return pullRefresh(r0, r1, r2);
    }

    public static /* synthetic */ Modifier pullRefresh$default(Modifier r0, Function1 r1, Function2 r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = true;
    L6:
        return pullRefresh(r0, r1, r2, r3);
    }
}
