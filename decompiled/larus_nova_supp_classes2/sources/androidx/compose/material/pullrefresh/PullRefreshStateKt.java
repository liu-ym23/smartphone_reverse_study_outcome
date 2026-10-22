package androidx.compose.material.pullrefresh;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b\"\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"rememberPullRefreshState", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "refreshing", "", "onRefresh", "Lkotlin/Function0;", "", "refreshThreshold", "Landroidx/compose/ui/unit/Dp;", "refreshingOffset", "rememberPullRefreshState-UuyPYSY", "(ZLkotlin/jvm/functions/Function0;FFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/pullrefresh/PullRefreshState;", "DragMultiplier", "", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PullRefreshStateKt {
    private static final float DragMultiplier = 0.5f;

    public static /* synthetic */ Unit a(PullRefreshState r0, boolean r1, Ref.FloatRef r2, Ref.FloatRef r3) {
        return rememberPullRefreshState_UuyPYSY$lambda$4$lambda$3(r0, r1, r2, r3);
    }

    private static final Unit rememberPullRefreshState_UuyPYSY$lambda$4$lambda$3(PullRefreshState r0, boolean r1, Ref.FloatRef r2, Ref.FloatRef r3) {
        r0.setRefreshing$material(r1);
        r0.setThreshold$material(r2.element);
        r0.setRefreshingOffset$material(r3.element);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: rememberPullRefreshState-UuyPYSY, reason: not valid java name */
    public static final PullRefreshState m2258rememberPullRefreshStateUuyPYSY(final boolean r6, Function0<Unit> r7, float r8, float r9, Composer r10, int r11, int r12) {
        if ((r12 & 4) == 0) goto L6;
        r8 = PullRefreshDefaults.INSTANCE.m2248getRefreshThresholdD9Ej5fM();
    L6:
        if ((r12 & 8) == 0) goto L9;
        r9 = PullRefreshDefaults.INSTANCE.m2249getRefreshingOffsetD9Ej5fM();
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-174977512, r11, -1, "androidx.compose.material.pullrefresh.rememberPullRefreshState (PullRefreshState.kt:61)");
    L11:
        boolean r1 = true;
        if (Dp.compareTo-0680j_4(r8, Dp.constructor-impl(0)) <= 0) goto L14;
        boolean r0 = true;
    L15:
        if (r0 == false) goto L42;
        Object r2 = r10.rememberedValue();
        Composer.Companion r3 = Composer.Companion;
        if (r2 != r3.getEmpty()) goto L19;
        r2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r10);
        r10.updateRememberedValue(r2);
    L19:
        CoroutineScope r4 = (CoroutineScope) r2;
        State r13 = SnapshotStateKt.rememberUpdatedState(r7, r10, (r11 >> 3) & 14);
        final Ref.FloatRef r5 = new Ref.FloatRef();
        final Ref.FloatRef r14 = new Ref.FloatRef();
        Density r15 = (Density) r10.consume(CompositionLocalsKt.getLocalDensity());
        r5.element = r15.toPx-0680j_4(r8);
        r14.element = r15.toPx-0680j_4(r9);
        boolean r16 = r10.changed(r4);
        Object r17 = r10.rememberedValue();
        if (r16 == false) goto L22;
    L23:
        r17 = new PullRefreshState(r4, r13, r14.element, r5.element);
        r10.updateRememberedValue(r17);
    L24:
        final PullRefreshState r18 = (PullRefreshState) r17;
        boolean r19 = r10.changedInstance(r18);
        if (((r11 & 14) ^ 6) <= 4) goto L29;
        if (r10.changed(r6) == false) goto L29;
    L32:
        boolean r20 = ((r19 | r1) | r10.changed(r5.element)) | r10.changed(r14.element);
        Object r21 = r10.rememberedValue();
        if (r20 == false) goto L35;
    L36:
        r21 = new k(r18, r6, r5, r14);
        r10.updateRememberedValue(r21);
    L37:
        EffectsKt.SideEffect((Function0) r21, r10, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventEnd();
    L40:
        return r18;
    L35:
        if (r21 != r3.getEmpty()) goto L37;
    L29:
        if ((r11 & 6) == 4) goto L32;
        r1 = false;
        goto L32
    L22:
        if (r17 != r3.getEmpty()) goto L24;
    L42:
        throw new IllegalArgumentException("The refresh trigger must be greater than zero!".toString());
    L14:
        r0 = false;
        goto L15
    }
}
