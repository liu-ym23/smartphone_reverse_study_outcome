package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"LazyLayoutPinnableItem", "", "key", "", "index", "", "pinnedItemList", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;ILandroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutPinnableItemKt {
    private static final Unit LazyLayoutPinnableItem$lambda$4(Object r6, int r7, LazyLayoutPinnedItemList r8, Function2 r9, int r10, Composer r11, int r12) {
        LazyLayoutPinnableItem(r6, r7, r8, r9, r11, RecomposeScopeImplKt.updateChangedFlags(r10 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Object r0, int r1, LazyLayoutPinnedItemList r2, Function2 r3, int r4, Composer r5, int r6) {
        return LazyLayoutPinnableItem$lambda$4(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ DisposableEffectResult b(LazyLayoutPinnableItem r0, DisposableEffectScope r1) {
        return LazyLayoutPinnableItem$lambda$3$lambda$2(r0, r1);
    }

    private static final DisposableEffectResult LazyLayoutPinnableItem$lambda$3$lambda$2(final LazyLayoutPinnableItem r0, DisposableEffectScope r1) {
        return new LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$lambda$3$lambda$2$$inlined$onDispose$1(r0);
    }

    public static final void LazyLayoutPinnableItem(final Object r7, final int r8, final LazyLayoutPinnedItemList r9, final Function2<? super Composer, ? super Integer, Unit> r10, Composer r11, final int r12) {
        Composer r13 = r11.startRestartGroup(872548579);
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
        if (r13.changedInstance(r9) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r12 & 3072) != 0) goto L32;
        if (r13.changedInstance(r10) == false) goto L29;
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
    L54:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L58;
        r14.updateScope(new v(r7, r8, r9, r10, r12));
        return;
    L58:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(872548579, r1, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem (LazyLayoutPinnableItem.kt:50)");
    L40:
        boolean r0 = r13.changed(r7) | r13.changed(r9);
        Object r6 = r13.rememberedValue();
        if (r0 == false) goto L43;
    L44:
        r6 = new LazyLayoutPinnableItem(r7, r9);
        r13.updateRememberedValue(r6);
    L45:
        final LazyLayoutPinnableItem r15 = (LazyLayoutPinnableItem) r6;
        r15.setIndex(r8);
        r15.setParentPinnableContainer((PinnableContainer) r13.consume(PinnableContainerKt.getLocalPinnableContainer()));
        boolean r16 = r13.changed(r15);
        Object r17 = r13.rememberedValue();
        if (r16 == false) goto L48;
    L49:
        r17 = new u(r15);
        r13.updateRememberedValue(r17);
    L50:
        EffectsKt.DisposableEffect(r15, (Function1) r17, r13, 0);
        int r18 = (r1 >> 6) & 112;
        CompositionLocalKt.CompositionLocalProvider(PinnableContainerKt.getLocalPinnableContainer().provides(r15), r10, r13, r18 | ProvidedValue.$stable);
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventEnd();
        goto L54
    L48:
        if (r17 != Composer.Companion.getEmpty()) goto L50;
    L43:
        if (r6 != Composer.Companion.getEmpty()) goto L45;
    L34:
        r5 = false;
        goto L36
    L5:
        if (r13.changedInstance(r7) == false) goto L7;
        int r19 = 4;
    L8:
        r1 = r19 | r12;
        goto L11
    L7:
        r19 = 2;
        goto L8
    }
}
