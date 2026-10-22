package androidx.compose.material3;

import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\"\u0018\u0010\u0003\u001a\u00020\u0001*\u00020\u00048AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"fromToken", "Landroidx/compose/ui/text/TextStyle;", "Landroidx/compose/material3/Typography;", "value", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getValue", "(Landroidx/compose/material3/tokens/TypographyKeyTokens;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "LocalTypography", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalTypography", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TypographyKt {
    private static final ProvidableCompositionLocal<Typography> LocalTypography = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[TypographyKeyTokens.values().length];
            r0[TypographyKeyTokens.DisplayLarge.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L83:
            r0[TypographyKeyTokens.DisplayMedium.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L95:
            r0[TypographyKeyTokens.DisplaySmall.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L103:
            r0[TypographyKeyTokens.HeadlineLarge.ordinal()] = 4;     // Catch: NoSuchFieldError -> L38
        L107:
            r0[TypographyKeyTokens.HeadlineMedium.ordinal()] = 5;     // Catch: NoSuchFieldError -> L39
        L111:
            r0[TypographyKeyTokens.HeadlineSmall.ordinal()] = 6;     // Catch: NoSuchFieldError -> L40
        L121:
            r0[TypographyKeyTokens.TitleLarge.ordinal()] = 7;     // Catch: NoSuchFieldError -> L41
        L73:
            r0[TypographyKeyTokens.TitleMedium.ordinal()] = 8;     // Catch: NoSuchFieldError -> L42
        L85:
            r0[TypographyKeyTokens.TitleSmall.ordinal()] = 9;     // Catch: NoSuchFieldError -> L43
        L87:
            r0[TypographyKeyTokens.BodyLarge.ordinal()] = 10;     // Catch: NoSuchFieldError -> L44
        L99:
            r0[TypographyKeyTokens.BodyMedium.ordinal()] = 11;     // Catch: NoSuchFieldError -> L45
        L115:
            r0[TypographyKeyTokens.BodySmall.ordinal()] = 12;     // Catch: NoSuchFieldError -> L46
        L123:
            r0[TypographyKeyTokens.LabelLarge.ordinal()] = 13;     // Catch: NoSuchFieldError -> L47
        L65:
            r0[TypographyKeyTokens.LabelMedium.ordinal()] = 14;     // Catch: NoSuchFieldError -> L48
        L71:
            r0[TypographyKeyTokens.LabelSmall.ordinal()] = 15;     // Catch: NoSuchFieldError -> L49
        L91:
            r0[TypographyKeyTokens.DisplayLargeEmphasized.ordinal()] = 16;     // Catch: NoSuchFieldError -> L50
        L101:
            r0[TypographyKeyTokens.DisplayMediumEmphasized.ordinal()] = 17;     // Catch: NoSuchFieldError -> L51
        L105:
            r0[TypographyKeyTokens.DisplaySmallEmphasized.ordinal()] = 18;     // Catch: NoSuchFieldError -> L52
        L113:
            r0[TypographyKeyTokens.HeadlineLargeEmphasized.ordinal()] = 19;     // Catch: NoSuchFieldError -> L53
        L69:
            r0[TypographyKeyTokens.HeadlineMediumEmphasized.ordinal()] = 20;     // Catch: NoSuchFieldError -> L54
        L77:
            r0[TypographyKeyTokens.HeadlineSmallEmphasized.ordinal()] = 21;     // Catch: NoSuchFieldError -> L55
        L79:
            r0[TypographyKeyTokens.TitleLargeEmphasized.ordinal()] = 22;     // Catch: NoSuchFieldError -> L56
        L89:
            r0[TypographyKeyTokens.TitleMediumEmphasized.ordinal()] = 23;     // Catch: NoSuchFieldError -> L57
        L109:
            r0[TypographyKeyTokens.TitleSmallEmphasized.ordinal()] = 24;     // Catch: NoSuchFieldError -> L58
        L117:
            r0[TypographyKeyTokens.BodyLargeEmphasized.ordinal()] = 25;     // Catch: NoSuchFieldError -> L59
        L119:
            r0[TypographyKeyTokens.BodyMediumEmphasized.ordinal()] = 26;     // Catch: NoSuchFieldError -> L60
        L67:
            r0[TypographyKeyTokens.BodySmallEmphasized.ordinal()] = 27;     // Catch: NoSuchFieldError -> L61
        L81:
            r0[TypographyKeyTokens.LabelLargeEmphasized.ordinal()] = 28;     // Catch: NoSuchFieldError -> L62
        L93:
            r0[TypographyKeyTokens.LabelMediumEmphasized.ordinal()] = 29;     // Catch: NoSuchFieldError -> L63
        L97:
            r0[TypographyKeyTokens.LabelSmallEmphasized.ordinal()] = 30;     // Catch: NoSuchFieldError -> L64
        L33:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ Typography a() {
        return LocalTypography$lambda$0();
    }

    static {
        LocalTypography = CompositionLocalKt.staticCompositionLocalOf(new rx());
    }

    private static final Typography LocalTypography$lambda$0() {
        return new Typography(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public static final ProvidableCompositionLocal<Typography> getLocalTypography() {
        return LocalTypography;
    }

    public static final TextStyle fromToken(Typography r1, TypographyKeyTokens r2) {
        switch(WhenMappings.$EnumSwitchMapping$0[r2.ordinal()]) {
            case 1: goto L36;
            case 2: goto L65;
            case 3: goto L64;
            case 4: goto L63;
            case 5: goto L62;
            case 6: goto L61;
            case 7: goto L60;
            case 8: goto L59;
            case 9: goto L58;
            case 10: goto L57;
            case 11: goto L56;
            case 12: goto L55;
            case 13: goto L54;
            case 14: goto L53;
            case 15: goto L52;
            case 16: goto L51;
            case 17: goto L50;
            case 18: goto L49;
            case 19: goto L48;
            case 20: goto L47;
            case 21: goto L46;
            case 22: goto L45;
            case 23: goto L44;
            case 24: goto L43;
            case 25: goto L42;
            case 26: goto L41;
            case 27: goto L40;
            case 28: goto L39;
            case 29: goto L38;
            case 30: goto L37;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L37:
        return r1.getLabelSmallEmphasized$material3();
    L38:
        return r1.getLabelMediumEmphasized$material3();
    L39:
        return r1.getLabelLargeEmphasized$material3();
    L40:
        return r1.getBodySmallEmphasized$material3();
    L41:
        return r1.getBodyMediumEmphasized$material3();
    L42:
        return r1.getBodyLargeEmphasized$material3();
    L43:
        return r1.getTitleSmallEmphasized$material3();
    L44:
        return r1.getTitleMediumEmphasized$material3();
    L45:
        return r1.getTitleLargeEmphasized$material3();
    L46:
        return r1.getHeadlineSmallEmphasized$material3();
    L47:
        return r1.getHeadlineMediumEmphasized$material3();
    L48:
        return r1.getHeadlineLargeEmphasized$material3();
    L49:
        return r1.getDisplaySmallEmphasized$material3();
    L50:
        return r1.getDisplayMediumEmphasized$material3();
    L51:
        return r1.getDisplayLargeEmphasized$material3();
    L52:
        return r1.getLabelSmall();
    L53:
        return r1.getLabelMedium();
    L54:
        return r1.getLabelLarge();
    L55:
        return r1.getBodySmall();
    L56:
        return r1.getBodyMedium();
    L57:
        return r1.getBodyLarge();
    L58:
        return r1.getTitleSmall();
    L59:
        return r1.getTitleMedium();
    L60:
        return r1.getTitleLarge();
    L61:
        return r1.getHeadlineSmall();
    L62:
        return r1.getHeadlineMedium();
    L63:
        return r1.getHeadlineLarge();
    L64:
        return r1.getDisplaySmall();
    L65:
        return r1.getDisplayMedium();
    L36:
        return r1.getDisplayLarge();
    }

    public static final TextStyle getValue(TypographyKeyTokens r3, Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1049072145, r5, -1, "androidx.compose.material3.<get-value> (Typography.kt:524)");
    L5:
        TextStyle r6 = fromToken(MaterialTheme.INSTANCE.getTypography(r4, 6), r3);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }
}
