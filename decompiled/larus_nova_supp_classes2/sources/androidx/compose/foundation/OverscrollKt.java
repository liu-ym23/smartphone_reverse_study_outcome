package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u001a\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0007\"\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"withoutVisualEffect", "Landroidx/compose/foundation/OverscrollEffect;", "withoutEventHandling", "overscroll", "Landroidx/compose/ui/Modifier;", "overscrollEffect", "rememberOverscrollEffect", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/OverscrollEffect;", "LocalOverscrollFactory", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/OverscrollFactory;", "getLocalOverscrollFactory", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class OverscrollKt {
    private static final ProvidableCompositionLocal<OverscrollFactory> LocalOverscrollFactory = null;

    public static /* synthetic */ OverscrollFactory a(CompositionLocalAccessorScope r0) {
        return LocalOverscrollFactory$lambda$1(r0);
    }

    static {
        LocalOverscrollFactory = CompositionLocalKt.compositionLocalWithComputedDefaultOf(new c1());
    }

    public static final ProvidableCompositionLocal<OverscrollFactory> getLocalOverscrollFactory() {
        return LocalOverscrollFactory;
    }

    private static final OverscrollFactory LocalOverscrollFactory$lambda$1(CompositionLocalAccessorScope r0) {
        return AndroidOverscroll_androidKt.defaultOverscrollFactory(r0);
    }

    public static final OverscrollEffect withoutEventHandling(OverscrollEffect r3) {
        return new WrappedOverscrollEffect(true, false, r3);
    }

    public static final OverscrollEffect withoutVisualEffect(OverscrollEffect r3) {
        return new WrappedOverscrollEffect(false, true, r3);
    }

    public static final Modifier overscroll(Modifier r2, OverscrollEffect r3) {
        if (r3 == null) goto L5;
        Modifier r0 = r3.getEffectModifier();
        if (r0 == null) goto L5;
    L7:
        if (r0 != Modifier.Companion) goto L11;
        r0 = new OverscrollModifierElement(r3);
    L11:
        return r2.then(r0);
    L5:
        r0 = Modifier.Companion;
        goto L7
    }

    public static final OverscrollEffect rememberOverscrollEffect(Composer r3, int r4) {
        r3.startReplaceGroup(282942128);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(282942128, r4, -1, "androidx.compose.foundation.rememberOverscrollEffect (Overscroll.kt:343)");
    L5:
        OverscrollFactory r5 = (OverscrollFactory) r3.consume(LocalOverscrollFactory);
        if (r5 == null) goto L8;
        boolean r0 = r3.changed(r5);
        Object r1 = r3.rememberedValue();
        if (r0 == false) goto L15;
    L16:
        r1 = r5.createOverscrollEffect();
        r3.updateRememberedValue(r1);
    L17:
        OverscrollEffect r2 = (OverscrollEffect) r1;
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventEnd();
    L20:
        r3.endReplaceGroup();
        return r2;
    L15:
        if (r1 != Composer.Companion.getEmpty()) goto L17;
    L8:
        if (ComposerKt.isTraceInProgress() == false) goto L10;
        ComposerKt.traceEventEnd();
    L10:
        r3.endReplaceGroup();
        return null;
    }
}
