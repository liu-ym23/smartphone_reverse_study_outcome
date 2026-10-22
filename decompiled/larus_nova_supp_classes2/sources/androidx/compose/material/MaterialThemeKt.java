package androidx.compose.material;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"MaterialTheme", "", "colors", "Landroidx/compose/material/Colors;", "typography", "Landroidx/compose/material/Typography;", "shapes", "Landroidx/compose/material/Shapes;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material/Colors;Landroidx/compose/material/Typography;Landroidx/compose/material/Shapes;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MaterialThemeKt {
    private static final Unit MaterialTheme$lambda$2(Colors r7, Typography r8, Shapes r9, Function2 r10, int r11, int r12, Composer r13, int r14) {
        MaterialTheme(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Colors r0, Typography r1, Shapes r2, Function2 r3, int r4, int r5, Composer r6, int r7) {
        return MaterialTheme$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static final void MaterialTheme(Colors r42, Typography r43, Shapes r44, final Function2<? super Composer, ? super Integer, Unit> r45, Composer r46, final int r47, final int r48) {
        Composer r1 = r46.startRestartGroup(53836214);
        if ((r47 & 6) == 0) goto L5;
        Colors r2 = r42;
        int r7 = r47;
    L14:
        if ((r47 & 48) == 0) goto L16;
        final Typography r8 = r43;
    L25:
        if ((r47 & 384) == 0) goto L27;
        Shapes r9 = r44;
    L36:
        if ((r48 & 8) == 0) goto L39;
        r7 = r7 | 3072;
    L46:
        if ((r7 & 1171) == 1170) goto L48;
        boolean r10 = true;
    L50:
        if (r1.shouldExecute(r10, r7 & 1) == false) goto L84;
        r1.startDefaults();
        if ((r47 & 1) == 0) goto L66;
        if (r1.getDefaultsInvalid() == true) goto L66;
        r1.skipToGroupEnd();
        if ((r48 & 1) == 0) goto L60;
        r7 = r7 & (-15);
    L60:
        if ((r48 & 2) == 0) goto L63;
        r7 = r7 & (-113);
    L63:
        if ((r48 & 4) != 0) goto L74;
    L75:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L78;
        ComposerKt.traceEventStart(53836214, r7, -1, "androidx.compose.material.MaterialTheme (MaterialTheme.kt:62)");
    L78:
        Object r0 = r1.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L81;
        r0 = Colors.m1990copypvPzIIM$default(r2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 8191, null);
        r1.updateRememberedValue(r0);
    L81:
        Colors r3 = (Colors) r0;
        ColorsKt.updateColorsFrom(r3, r2);
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ColorsKt.getLocalColors().provides(r3), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(r1, 6))), IndicationKt.getLocalIndication().provides(RippleKt.m2139rippleH2RKhps$default(false, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0, 7, null)), ShapesKt.getLocalShapes().provides(r9), TextSelectionColorsKt.getLocalTextSelectionColors().provides(MaterialTextSelectionColorsKt.rememberTextSelectionColors(r3, r1, 0)), TypographyKt.getLocalTypography().provides(r8)}, ComposableLambdaKt.rememberComposableLambda(496803446, true, new AnonymousClass1(r8, r45), r1, 54), r1, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L85;
        ComposerKt.traceEventEnd();
    L85:
        final Shapes r4 = r9;
        ScopeUpdateScope r11 = r1.endRestartGroup();
        if (r11 == null) goto L89;
        final Colors r5 = r2;
        final Typography r6 = r8;
        r11.updateScope(new x5(r5, r6, r4, r45, r47, r48));
        return;
    L89:
        return;
    L74:
        r7 = r7 & (-897);
    L66:
        if ((r48 & 1) == 0) goto L69;
        r2 = MaterialTheme.INSTANCE.getColors(r1, 6);
        r7 = r7 & (-15);
    L69:
        if ((r48 & 2) == 0) goto L72;
        r8 = MaterialTheme.INSTANCE.getTypography(r1, 6);
        r7 = r7 & (-113);
    L72:
        if ((r48 & 4) == 0) goto L75;
        r9 = MaterialTheme.INSTANCE.getShapes(r1, 6);
        goto L74
    L84:
        r1.skipToGroupEnd();
        goto L85
    L48:
        r10 = false;
        goto L50
    L39:
        if ((r47 & 3072) != 0) goto L46;
        if (r1.changedInstance(r45) == false) goto L43;
        int r12 = 2048;
    L44:
        r7 = r7 | r12;
        goto L46
    L43:
        r12 = 1024;
        goto L44
    L27:
        if ((r48 & 4) != 0) goto L31;
        r9 = r44;
        if (r1.changed(r9) == false) goto L32;
        int r13 = 256;
    L33:
        r7 = r7 | r13;
    L32:
        r13 = 128;
        goto L33
    L31:
        r9 = r44;
        goto L32
    L16:
        if ((r48 & 2) != 0) goto L20;
        r8 = r43;
        if (r1.changed(r8) == false) goto L21;
        int r14 = 32;
    L22:
        r7 = r7 | r14;
    L21:
        r14 = 16;
        goto L22
    L20:
        r8 = r43;
        goto L21
    L5:
        if ((r48 & 1) != 0) goto L9;
        r2 = r42;
        if (r1.changed(r2) == false) goto L10;
        int r15 = 4;
    L11:
        r7 = r15 | r47;
    L10:
        r15 = 2;
        goto L11
    L9:
        r2 = r42;
        goto L10
    }
}
