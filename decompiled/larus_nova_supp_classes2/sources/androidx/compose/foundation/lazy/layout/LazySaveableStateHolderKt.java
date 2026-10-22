package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.saveable.Saver;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"LazySaveableStateHolderProvider", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazySaveableStateHolderKt {
    private static final Unit LazySaveableStateHolderProvider$lambda$2(Function3 r0, int r1, Composer r2, int r3) {
        LazySaveableStateHolderProvider(r0, r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ LazySaveableStateHolder a(SaveableStateRegistry r0, SaveableStateHolder r1) {
        return LazySaveableStateHolderProvider$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit b(Function3 r0, int r1, Composer r2, int r3) {
        return LazySaveableStateHolderProvider$lambda$2(r0, r1, r2, r3);
    }

    private static final LazySaveableStateHolder LazySaveableStateHolderProvider$lambda$1$lambda$0(SaveableStateRegistry r2, SaveableStateHolder r3) {
        return new LazySaveableStateHolder(r2, MapsKt.emptyMap(), r3);
    }

    public static final void LazySaveableStateHolderProvider(final Function3<? super SaveableStateHolder, ? super Composer, ? super Integer, Unit> r8, Composer r9, final int r10) {
        Composer r11 = r9.startRestartGroup(-709502251);
        if ((r10 & 6) == 0) goto L5;
        int r1 = r10;
    L11:
        if ((r1 & 3) == 2) goto L13;
        boolean r2 = true;
    L15:
        if (r11.shouldExecute(r2, r1 & 1) == true) goto L17;
        r11.skipToGroupEnd();
    L28:
        ScopeUpdateScope r12 = r11.endRestartGroup();
        if (r12 == null) goto L32;
        r12.updateScope(new j0(r8, r10));
        return;
    L32:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-709502251, r1, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider (LazySaveableStateHolder.kt:39)");
    L19:
        final SaveableStateRegistry r0 = (SaveableStateRegistry) r11.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry());
        final SaveableStateHolder r3 = SaveableStateHolderKt.rememberSaveableStateHolder(r11, 0);
        Object[] r4 = {r0};
        Saver<LazySaveableStateHolder, Map<String, List<Object>>> r5 = LazySaveableStateHolder.Companion.saver(r0, r3);
        boolean r6 = r11.changedInstance(r0) | r11.changedInstance(r3);
        Object r7 = r11.rememberedValue();
        if (r6 == false) goto L22;
    L23:
        r7 = new i0(r0, r3);
        r11.updateRememberedValue(r7);
    L24:
        final LazySaveableStateHolder r13 = (LazySaveableStateHolder) RememberSaveableKt.rememberSaveable(r4, r5, (Function0) r7, r11, 0);
        CompositionLocalKt.CompositionLocalProvider(SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides(r13), ComposableLambdaKt.rememberComposableLambda(-412824043, true, new AnonymousClass1(r8, r13), r11, 54), r11, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
        goto L28
    L22:
        if (r7 != Composer.Companion.getEmpty()) goto L24;
    L13:
        r2 = false;
        goto L15
    L5:
        if (r11.changedInstance(r8) == false) goto L7;
        int r14 = 4;
    L8:
        r1 = r14 | r10;
        goto L11
    L7:
        r14 = 2;
        goto L8
    }
}
