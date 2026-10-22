package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u0003¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"SkippableItem", "", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "saveableStateHolder", "Landroidx/compose/foundation/lazy/layout/StableValue;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "index", "", "key", "", "SkippableItem-JVlU9Rs", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Ljava/lang/Object;ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutItemContentFactoryKt {
    private static final Unit SkippableItem_JVlU9Rs$lambda$0(LazyLayoutItemProvider r6, Object r7, int r8, Object r9, int r10, Composer r11, int r12) {
        m1156SkippableItemJVlU9Rs(r6, r7, r8, r9, r11, RecomposeScopeImplKt.updateChangedFlags(r10 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(LazyLayoutItemProvider r0, Object r1, int r2, Object r3, int r4, Composer r5, int r6) {
        return SkippableItem_JVlU9Rs$lambda$0(r0, r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: SkippableItem-JVlU9Rs, reason: not valid java name */
    private static final void m1156SkippableItemJVlU9Rs(final LazyLayoutItemProvider r7, final Object r8, final int r9, final Object r10, Composer r11, final int r12) {
        Composer r13 = r11.startRestartGroup(1439843069);
        if ((r12 & 6) == 0) goto L5;
        int r1 = r12;
    L11:
        if ((r12 & 48) != 0) goto L18;
        if (r13.changed(r8) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r12 & 384) != 0) goto L25;
        if (r13.changed(r9) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r12 & 3072) != 0) goto L32;
        if (r13.changed(r10) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r1 & 1171) == 1170) goto L34;
        boolean r5 = true;
    L36:
        if (r13.shouldExecute(r5, r1 & 1) == true) goto L38;
        r13.skipToGroupEnd();
    L44:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L48;
        r14.updateScope(new k(r7, r8, r9, r10, r12));
        return;
    L48:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(1439843069, r1, -1, "androidx.compose.foundation.lazy.layout.SkippableItem (LazyLayoutItemContentFactory.kt:124)");
    L40:
        ((SaveableStateHolder) r8).SaveableStateProvider(r10, ComposableLambdaKt.rememberComposableLambda(980966366, true, new LazyLayoutItemContentFactoryKt$SkippableItem$1(r7, r9, r10), r13, 54), r13, 48);
        if (ComposerKt.isTraceInProgress() == false) goto L44;
        ComposerKt.traceEventEnd();
        goto L44
    L34:
        r5 = false;
        goto L36
    L5:
        if (r13.changed(r7) == false) goto L7;
        int r6 = 4;
    L8:
        r1 = r6 | r12;
        goto L11
    L7:
        r6 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$SkippableItem-JVlU9Rs, reason: not valid java name */
    public static final /* synthetic */ void m1157access$SkippableItemJVlU9Rs(LazyLayoutItemProvider r0, Object r1, int r2, Object r3, Composer r4, int r5) {
        m1156SkippableItemJVlU9Rs(r0, r1, r2, r3, r4, r5);
    }
}
