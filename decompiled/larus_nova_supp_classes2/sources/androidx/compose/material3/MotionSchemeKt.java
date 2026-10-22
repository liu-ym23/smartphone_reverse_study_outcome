package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"fromToken", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "T", "Landroidx/compose/material3/MotionScheme;", "value", "Landroidx/compose/material3/tokens/MotionSchemeKeyTokens;", "(Landroidx/compose/material3/tokens/MotionSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/FiniteAnimationSpec;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MotionSchemeKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[MotionSchemeKeyTokens.values().length];
            r0[MotionSchemeKeyTokens.DefaultSpatial.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[MotionSchemeKeyTokens.FastSpatial.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[MotionSchemeKeyTokens.SlowSpatial.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[MotionSchemeKeyTokens.DefaultEffects.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[MotionSchemeKeyTokens.FastEffects.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[MotionSchemeKeyTokens.SlowEffects.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final <T> FiniteAnimationSpec<T> fromToken(MotionScheme r1, MotionSchemeKeyTokens r2) {
        switch(WhenMappings.$EnumSwitchMapping$0[r2.ordinal()]) {
            case 1: goto L12;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L13:
        return r1.slowEffectsSpec();
    L14:
        return r1.fastEffectsSpec();
    L15:
        return r1.defaultEffectsSpec();
    L16:
        return r1.slowSpatialSpec();
    L17:
        return r1.fastSpatialSpec();
    L12:
        return r1.defaultSpatialSpec();
    }

    public static final <T> FiniteAnimationSpec<T> value(MotionSchemeKeyTokens r3, Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-19828261, r5, -1, "androidx.compose.material3.value (MotionScheme.kt:288)");
    L5:
        FiniteAnimationSpec<T> r6 = fromToken(MaterialTheme.INSTANCE.getMotionScheme(r4, 6), r3);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }
}
