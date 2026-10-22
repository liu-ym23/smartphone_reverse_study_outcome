package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R,\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u00058G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/material3/SwipeToDismissBoxDefaults;", "", "<init>", "()V", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "totalDistance", "getPositionalThreshold", "(Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function1;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwipeToDismissBoxDefaults {
    public static final int $stable = 0;
    public static final SwipeToDismissBoxDefaults INSTANCE = null;

    static {
        INSTANCE = new SwipeToDismissBoxDefaults();
    }

    private SwipeToDismissBoxDefaults() {
    }

    public static /* synthetic */ float a(Density r0, float r1) {
        return _get_positionalThreshold_$lambda$2$lambda$1$lambda$0(r0, r1);
    }

    private static final float _get_positionalThreshold_$lambda$2$lambda$1$lambda$0(Density r0, float r1) {
        return r0.toPx-0680j_4(Dp.constructor-impl(56));
    }

    public final Function1<Float, Float> getPositionalThreshold(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1545861529, r5, -1, "androidx.compose.material3.SwipeToDismissBoxDefaults.<get-positionalThreshold> (SwipeToDismissBox.kt:362)");
    L5:
        r4.startReplaceGroup(-485754360);
        final Density r6 = (Density) r4.consume(CompositionLocalsKt.getLocalDensity());
        boolean r0 = r4.changed(r6);
        Object r1 = r4.rememberedValue();
        if (r0 == false) goto L8;
    L9:
        r1 = new gr(r6);
        r4.updateRememberedValue(r1);
    L10:
        Function1<Float, Float> r2 = (Function1) r1;
        r4.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        return r2;
    L8:
        if (r1 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }
}
