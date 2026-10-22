package androidx.compose.foundation.contextmenu;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0011Jl\u0010\u0012\u001a\u00020\u000b2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192*\b\u0002\u0010\u001a\u001a$\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\u0002\b\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u000bR4\u0010\u0004\u001a(\u0012$\u0012\"\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0002\b\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "", "<init>", "()V", "composables", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "colors", "", "Landroidx/compose/runtime/Composable;", "Content", "Content$foundation_release", "(Landroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/runtime/Composer;I)V", "clear", "clear$foundation_release", "item", "label", "Lkotlin/Function0;", "", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "leadingIcon", "Landroidx/compose/ui/graphics/Color;", "iconColor", "onClick", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "separator", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextMenuScope {
    public static final int $stable = 0;
    private final SnapshotStateList<Function3<ContextMenuColors, Composer, Integer, Unit>> composables;

    private static final Unit Content$lambda$1(ContextMenuScope r0, ContextMenuColors r1, int r2, Composer r3, int r4) {
        r0.Content$foundation_release(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(ContextMenuScope r0, ContextMenuColors r1, int r2, Composer r3, int r4) {
        return Content$lambda$1(r0, r1, r2, r3, r4);
    }

    public final void clear$foundation_release() {
        this.composables.clear();
    }

    public final void separator() {
        this.composables.add(ComposableSingletons$ContextMenuUi_androidKt.INSTANCE.m467getLambda$355168742$foundation_release());
    }

    public ContextMenuScope() {
        this.composables = SnapshotStateKt.mutableStateListOf();
    }

    public final void Content$foundation_release(final ContextMenuColors r7, Composer r8, final int r9) {
        Composer r10 = r8.startRestartGroup(1320309496);
        if ((r9 & 6) == 0) goto L5;
        int r1 = r9;
    L11:
        if ((r9 & 48) == 0) goto L13;
    L17:
        int r4 = 0;
        if ((r1 & 19) == 18) goto L20;
        boolean r2 = true;
    L22:
        if (r10.shouldExecute(r2, r1 & 1) == true) goto L24;
        r10.skipToGroupEnd();
    L33:
        ScopeUpdateScope r11 = r10.endRestartGroup();
        if (r11 == null) goto L38;
        r11.updateScope(new h(this, r7, r9));
        return;
    L38:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(1320309496, r1, -1, "androidx.compose.foundation.contextmenu.ContextMenuScope.Content (ContextMenuUi.android.kt:248)");
    L26:
        SnapshotStateList<Function3<ContextMenuColors, Composer, Integer, Unit>> r0 = this.composables;
        int r3 = r0.size();
    L27:
        if (r4 >= r3) goto L30;
        ((Function3) ListProtector.get(r0, r4)).invoke(r7, r10, Integer.valueOf(r1 & 14));
        r4 = r4 + 1;
        goto L27
    L30:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventEnd();
        goto L33
    L20:
        r2 = false;
        goto L22
    L13:
        if (r10.changed(this) == false) goto L15;
        int r5 = 32;
    L16:
        r1 = r1 | r5;
        goto L17
    L15:
        r5 = 16;
        goto L16
    L5:
        if (r10.changed(r7) == false) goto L7;
        int r6 = 4;
    L8:
        r1 = r6 | r9;
        goto L11
    L7:
        r6 = 2;
        goto L8
    }

    public final void item(final Function2<? super Composer, ? super Integer, String> r9, final Modifier r10, final boolean r11, final Function3<? super Color, ? super Composer, ? super Integer, Unit> r12, final Function0<Unit> r13) {
        this.composables.add(ComposableLambdaKt.composableLambdaInstance(424163756, true, new AnonymousClass1(r9, r11, r10, r12, r13)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void item$default(ContextMenuScope r6, Function2 r7, Modifier r8, boolean r9, Function3 r10, Function0 r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = Modifier.Companion;
    L5:
        Modifier r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        boolean r3 = true;
    L10:
        if ((r12 & 8) == 0) goto L12;
        r10 = null;
    L12:
        r6.item(r7, r2, r3, r10, r11);
        return;
    L8:
        r3 = r9;
        goto L10
    }
}
