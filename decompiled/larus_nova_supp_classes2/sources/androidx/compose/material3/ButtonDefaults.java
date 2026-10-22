package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.BaselineButtonTokens;
import androidx.compose.material3.tokens.ButtonSmallTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.ElevatedButtonTokens;
import androidx.compose.material3.tokens.FilledButtonTokens;
import androidx.compose.material3.tokens.FilledTonalButtonTokens;
import androidx.compose.material3.tokens.OutlinedButtonTokens;
import androidx.compose.material3.tokens.TextButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010-\u001a\u00020.H\u0007¢\u0006\u0002\u0010/J7\u0010-\u001a\u00020.2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u000201H\u0007¢\u0006\u0004\b5\u00106J\r\u0010;\u001a\u00020.H\u0007¢\u0006\u0002\u0010/J7\u0010;\u001a\u00020.2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u000201H\u0007¢\u0006\u0004\b<\u00106J\r\u0010?\u001a\u00020.H\u0007¢\u0006\u0002\u0010/J7\u0010?\u001a\u00020.2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u000201H\u0007¢\u0006\u0004\b@\u00106J\r\u0010C\u001a\u00020.H\u0007¢\u0006\u0002\u0010/J7\u0010C\u001a\u00020.2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u000201H\u0007¢\u0006\u0004\bD\u00106J\r\u0010G\u001a\u00020.H\u0007¢\u0006\u0002\u0010/J7\u0010G\u001a\u00020.2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u000201H\u0007¢\u0006\u0004\bH\u00106JA\u0010K\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010O\u001a\u00020\u00052\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010Q\u001a\u00020\u0005H\u0007¢\u0006\u0004\bR\u0010SJA\u0010T\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010O\u001a\u00020\u00052\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010Q\u001a\u00020\u0005H\u0007¢\u0006\u0004\bU\u0010SJA\u0010V\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010O\u001a\u00020\u00052\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010Q\u001a\u00020\u0005H\u0007¢\u0006\u0004\bW\u0010SJ\u0017\u0010X\u001a\u00020Y2\b\b\u0002\u0010\\\u001a\u00020]H\u0007¢\u0006\u0002\u0010^R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0010\u0010\u0012\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0010\u0010\u0015\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0016\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u0018\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u001e\u0010\u001aR\u0013\u0010\u001f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b \u0010\u001aR\u0011\u0010!\u001a\u00020\"8G¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\"8G¢\u0006\u0006\u001a\u0004\b&\u0010$R\u0011\u0010'\u001a\u00020\"8G¢\u0006\u0006\u001a\u0004\b(\u0010$R\u0011\u0010)\u001a\u00020\"8G¢\u0006\u0006\u001a\u0004\b*\u0010$R\u0011\u0010+\u001a\u00020\"8G¢\u0006\u0006\u001a\u0004\b,\u0010$R\u0018\u00107\u001a\u00020.*\u0002088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0018\u0010=\u001a\u00020.*\u0002088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b>\u0010:R\u0018\u0010A\u001a\u00020.*\u0002088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bB\u0010:R\u0018\u0010E\u001a\u00020.*\u0002088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010:R\u0018\u0010I\u001a\u00020.*\u0002088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010:R\u0011\u0010X\u001a\u00020Y8G¢\u0006\u0006\u001a\u0004\bZ\u0010[¨\u0006_"}, d2 = {"Landroidx/compose/material3/ButtonDefaults;", "", "<init>", "()V", "ButtonLeadingSpace", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonTrailingSpace", "ButtonWithIconStartpadding", "SmallStartPadding", "SmallEndPadding", "ButtonVerticalPadding", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "ButtonWithIconContentPadding", "getButtonWithIconContentPadding", "TextButtonHorizontalPadding", "TextButtonContentPadding", "getTextButtonContentPadding", "TextButtonWithIconHorizontalEndPadding", "TextButtonWithIconContentPadding", "getTextButtonWithIconContentPadding", "MinWidth", "getMinWidth-D9Ej5fM", "()F", "MinHeight", "getMinHeight-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "IconSpacing", "getIconSpacing-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "elevatedShape", "getElevatedShape", "filledTonalShape", "getFilledTonalShape", "outlinedShape", "getOutlinedShape", "textShape", "getTextShape", "buttonColors", "Landroidx/compose/material3/ButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonColors;", "defaultButtonColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ButtonColors;", "elevatedButtonColors", "elevatedButtonColors-ro_MJ88", "defaultElevatedButtonColors", "getDefaultElevatedButtonColors$material3", "filledTonalButtonColors", "filledTonalButtonColors-ro_MJ88", "defaultFilledTonalButtonColors", "getDefaultFilledTonalButtonColors$material3", "outlinedButtonColors", "outlinedButtonColors-ro_MJ88", "defaultOutlinedButtonColors", "getDefaultOutlinedButtonColors$material3", "textButtonColors", "textButtonColors-ro_MJ88", "defaultTextButtonColors", "getDefaultTextButtonColors$material3", "buttonElevation", "Landroidx/compose/material3/ButtonElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "buttonElevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonElevation;", "elevatedButtonElevation", "elevatedButtonElevation-R_JCAzs", "filledTonalButtonElevation", "filledTonalButtonElevation-R_JCAzs", "outlinedButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedButtonBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonLeadingSpace = 0.0f;
    private static final float ButtonTrailingSpace = 0.0f;
    private static final float ButtonVerticalPadding = 0.0f;
    private static final PaddingValues ButtonWithIconContentPadding = null;
    private static final float ButtonWithIconStartpadding = 0.0f;
    private static final PaddingValues ContentPadding = null;
    public static final ButtonDefaults INSTANCE = null;
    private static final float IconSize = 0.0f;
    private static final float IconSpacing = 0.0f;
    private static final float MinHeight = 0.0f;
    private static final float MinWidth = 0.0f;
    private static final float SmallEndPadding = 0.0f;
    private static final float SmallStartPadding = 0.0f;
    private static final PaddingValues TextButtonContentPadding = null;
    private static final float TextButtonHorizontalPadding = 0.0f;
    private static final PaddingValues TextButtonWithIconContentPadding = null;
    private static final float TextButtonWithIconHorizontalEndPadding = 0.0f;

    private ButtonDefaults() {
    }

    static {
        INSTANCE = new ButtonDefaults();
        BaselineButtonTokens r0 = BaselineButtonTokens.INSTANCE;
        float r1 = r0.getLeadingSpace-D9Ej5fM();
        ButtonLeadingSpace = r1;
        float r2 = r0.getTrailingSpace-D9Ej5fM();
        ButtonTrailingSpace = r2;
        float r3 = 16;
        float r4 = Dp.constructor-impl(r3);
        ButtonWithIconStartpadding = r4;
        ButtonSmallTokens r5 = ButtonSmallTokens.INSTANCE;
        SmallStartPadding = r5.getLeadingSpace-D9Ej5fM();
        SmallEndPadding = r5.getTrailingSpace-D9Ej5fM();
        float r6 = Dp.constructor-impl(8);
        ButtonVerticalPadding = r6;
        PaddingValues r7 = PaddingKt.m956PaddingValuesa9UjIt4(r1, r6, r2, r6);
        ContentPadding = r7;
        ButtonWithIconContentPadding = PaddingKt.m956PaddingValuesa9UjIt4(r4, r6, r2, r6);
        float r8 = Dp.constructor-impl(12);
        TextButtonHorizontalPadding = r8;
        TextButtonContentPadding = PaddingKt.m956PaddingValuesa9UjIt4(r8, r7.mo901calculateTopPaddingD9Ej5fM(), r8, r7.mo898calculateBottomPaddingD9Ej5fM());
        float r9 = Dp.constructor-impl(r3);
        TextButtonWithIconHorizontalEndPadding = r9;
        TextButtonWithIconContentPadding = PaddingKt.m956PaddingValuesa9UjIt4(r8, r7.mo901calculateTopPaddingD9Ej5fM(), r9, r7.mo898calculateBottomPaddingD9Ej5fM());
        MinWidth = Dp.constructor-impl(58);
        MinHeight = r5.getContainerHeight-D9Ej5fM();
        IconSize = Dp.constructor-impl(18);
        IconSpacing = r5.getIconLabelSpace-D9Ej5fM();
    }

    public final PaddingValues getButtonWithIconContentPadding() {
        return ButtonWithIconContentPadding;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2356getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m2357getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m2358getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m2359getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    public final PaddingValues getTextButtonWithIconContentPadding() {
        return TextButtonWithIconContentPadding;
    }

    public final ButtonColors getDefaultButtonColors$material3(ColorScheme r19) {
        ButtonColors r1 = r19.getDefaultButtonColorsCached$material3();
        if (r1 != null) goto L6;
        FilledButtonTokens r2 = FilledButtonTokens.INSTANCE;
        ButtonColors r3 = new ButtonColors(ColorSchemeKt.fromToken(r19, r2.getContainerColor()), ColorSchemeKt.fromToken(r19, r2.getLabelTextColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r19, r2.getDisabledContainerColor()), r2.getDisabledContainerOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r19, r2.getDisabledLabelTextColor()), r2.getDisabledLabelTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r19.setDefaultButtonColorsCached$material3(r3);
        return r3;
    L6:
        return r1;
    }

    public final ButtonColors getDefaultElevatedButtonColors$material3(ColorScheme r19) {
        ButtonColors r1 = r19.getDefaultElevatedButtonColorsCached$material3();
        if (r1 != null) goto L6;
        ElevatedButtonTokens r2 = ElevatedButtonTokens.INSTANCE;
        ButtonColors r3 = new ButtonColors(ColorSchemeKt.fromToken(r19, r2.getContainerColor()), ColorSchemeKt.fromToken(r19, r2.getLabelTextColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r19, r2.getDisabledContainerColor()), r2.getDisabledContainerOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r19, r2.getDisabledLabelTextColor()), r2.getDisabledLabelTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r19.setDefaultElevatedButtonColorsCached$material3(r3);
        return r3;
    L6:
        return r1;
    }

    public final ButtonColors getDefaultFilledTonalButtonColors$material3(ColorScheme r18) {
        ButtonColors r1 = r18.getDefaultFilledTonalButtonColorsCached$material3();
        if (r1 != null) goto L6;
        FilledTonalButtonTokens r2 = FilledTonalButtonTokens.INSTANCE;
        ButtonColors r3 = new ButtonColors(ColorSchemeKt.fromToken(r18, r2.getContainerColor()), ColorSchemeKt.fromToken(r18, r2.getLabelTextColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r18, r2.getDisabledContainerColor()), 0.12f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r18, r2.getDisabledLabelTextColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r18.setDefaultFilledTonalButtonColorsCached$material3(r3);
        return r3;
    L6:
        return r1;
    }

    public final ButtonColors getDefaultOutlinedButtonColors$material3(ColorScheme r19) {
        ButtonColors r1 = r19.getDefaultOutlinedButtonColorsCached$material3();
        if (r1 != null) goto L6;
        Color.Companion r2 = Color.Companion;
        long r3 = r2.getTransparent-0d7_KjU();
        OutlinedButtonTokens r5 = OutlinedButtonTokens.INSTANCE;
        ButtonColors r4 = new ButtonColors(r3, ColorSchemeKt.fromToken(r19, r5.getLabelTextColor()), r2.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r19, r5.getDisabledLabelTextColor()), r5.getDisabledLabelTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r19.setDefaultOutlinedButtonColorsCached$material3(r4);
        return r4;
    L6:
        return r1;
    }

    public final ButtonColors getDefaultTextButtonColors$material3(ColorScheme r19) {
        ButtonColors r1 = r19.getDefaultTextButtonColorsCached$material3();
        if (r1 != null) goto L6;
        Color.Companion r2 = Color.Companion;
        long r3 = r2.getTransparent-0d7_KjU();
        long r5 = ColorSchemeKt.fromToken(r19, ColorSchemeKeyTokens.Primary);
        long r7 = r2.getTransparent-0d7_KjU();
        TextButtonTokens r4 = TextButtonTokens.INSTANCE;
        ButtonColors r6 = new ButtonColors(r3, r5, r7, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r19, r4.getDisabledLabelColor()), r4.getDisabledLabelOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r19.setDefaultTextButtonColorsCached$material3(r6);
        return r6;
    L6:
        return r1;
    }

    public final ButtonColors buttonColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1449248637, r5, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:572)");
    L5:
        ButtonColors r6 = getDefaultButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final ButtonColors elevatedButtonColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(2025043443, r5, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:617)");
    L5:
        ButtonColors r6 = getDefaultElevatedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final ButtonColors filledTonalButtonColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(824987837, r5, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:663)");
    L5:
        ButtonColors r6 = getDefaultFilledTonalButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getElevatedShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(2143958791, r5, -1, "androidx.compose.material3.ButtonDefaults.<get-elevatedShape> (Button.kt:554)");
    L5:
        Shape r6 = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getFilledTonalShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-886584987, r5, -1, "androidx.compose.material3.ButtonDefaults.<get-filledTonalShape> (Button.kt:558)");
    L5:
        Shape r6 = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    @Deprecated(message = "Please use the version that takes an `enabled` param to get the `BorderStroke` with the correct opacity", replaceWith = @ReplaceWith(expression = "outlinedButtonBorder(enabled)", imports = {}))
    public final BorderStroke getOutlinedButtonBorder(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-563957672, r5, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedButtonBorder> (Button.kt:886)");
    L5:
        BorderStroke r6 = BorderStrokeKt.m369BorderStrokecXLIe8U(ButtonSmallTokens.INSTANCE.getOutlinedOutlineWidth-D9Ej5fM(), ColorSchemeKt.getValue(OutlinedButtonTokens.INSTANCE.getOutlineColor(), r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getOutlinedShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-2045213065, r5, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedShape> (Button.kt:562)");
    L5:
        Shape r6 = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1234923021, r5, -1, "androidx.compose.material3.ButtonDefaults.<get-shape> (Button.kt:550)");
    L5:
        Shape r6 = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getTextShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-349121587, r5, -1, "androidx.compose.material3.ButtonDefaults.<get-textShape> (Button.kt:566)");
    L5:
        Shape r6 = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final ButtonColors outlinedButtonColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1344886725, r5, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:709)");
    L5:
        ButtonColors r6 = getDefaultOutlinedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final ButtonColors textButtonColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1880341584, r5, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:752)");
    L5:
        ButtonColors r6 = getDefaultTextButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final BorderStroke outlinedButtonBorder(boolean r10, Composer r11, int r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r10 = true;
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(-626854767, r12, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonBorder (Button.kt:898)");
    L8:
        float r14 = ButtonSmallTokens.INSTANCE.getOutlinedOutlineWidth-D9Ej5fM();
        if (r10 == false) goto L11;
        r11.startReplaceGroup(-112346942);
        long r0 = ColorSchemeKt.getValue(OutlinedButtonTokens.INSTANCE.getOutlineColor(), r11, 6);
        r11.endReplaceGroup();
    L12:
        BorderStroke r15 = BorderStrokeKt.m369BorderStrokecXLIe8U(r14, r0);
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventEnd();
    L15:
        return r15;
    L11:
        r11.startReplaceGroup(-112259336);
        OutlinedButtonTokens r16 = OutlinedButtonTokens.INSTANCE;
        r0 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r16.getOutlineColor(), r11, 6), r16.getDisabledContainerOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        r11.endReplaceGroup();
        goto L12
    }

    /* JADX INFO: renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m2350buttonColorsro_MJ88(long r13, long r15, long r17, long r19, Composer r21, int r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        long r0 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r23 & 2) == 0) goto L9;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r23 & 4) == 0) goto L13;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r23 & 8) == 0) goto L17;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(-339300779, r22, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:590)");
    L21:
        ButtonColors r1 = getDefaultButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r21, 6)).m2345copyjRlVdoo(r0, r2, r4, r6);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r1;
    L17:
        r6 = r19;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r2 = r15;
        goto L11
    L5:
        r0 = r13;
        goto L7
    }

    /* JADX INFO: renamed from: elevatedButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m2352elevatedButtonColorsro_MJ88(long r13, long r15, long r17, long r19, Composer r21, int r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        long r0 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r23 & 2) == 0) goto L9;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r23 & 4) == 0) goto L13;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r23 & 8) == 0) goto L17;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(1507908383, r22, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:635)");
    L21:
        ButtonColors r1 = getDefaultElevatedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r21, 6)).m2345copyjRlVdoo(r0, r2, r4, r6);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r1;
    L17:
        r6 = r19;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r2 = r15;
        goto L11
    L5:
        r0 = r13;
        goto L7
    }

    /* JADX INFO: renamed from: filledTonalButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m2354filledTonalButtonColorsro_MJ88(long r13, long r15, long r17, long r19, Composer r21, int r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        long r0 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r23 & 2) == 0) goto L9;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r23 & 4) == 0) goto L13;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r23 & 8) == 0) goto L17;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(1670757653, r22, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:682)");
    L21:
        ButtonColors r1 = getDefaultFilledTonalButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r21, 6)).m2345copyjRlVdoo(r0, r2, r4, r6);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r1;
    L17:
        r6 = r19;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r2 = r15;
        goto L11
    L5:
        r0 = r13;
        goto L7
    }

    /* JADX INFO: renamed from: outlinedButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m2360outlinedButtonColorsro_MJ88(long r13, long r15, long r17, long r19, Composer r21, int r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        long r0 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r23 & 2) == 0) goto L9;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r23 & 4) == 0) goto L13;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r23 & 8) == 0) goto L17;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(-1778526249, r22, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:727)");
    L21:
        ButtonColors r1 = getDefaultOutlinedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r21, 6)).m2345copyjRlVdoo(r0, r2, r4, r6);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r1;
    L17:
        r6 = r19;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r2 = r15;
        goto L11
    L5:
        r0 = r13;
        goto L7
    }

    /* JADX INFO: renamed from: textButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m2361textButtonColorsro_MJ88(long r13, long r15, long r17, long r19, Composer r21, int r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        long r0 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r23 & 2) == 0) goto L9;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r23 & 4) == 0) goto L13;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r23 & 8) == 0) goto L17;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(-1402274782, r22, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:770)");
    L21:
        ButtonColors r1 = getDefaultTextButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r21, 6)).m2345copyjRlVdoo(r0, r2, r4, r6);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r1;
    L17:
        r6 = r19;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r2 = r15;
        goto L11
    L5:
        r0 = r13;
        goto L7
    }

    /* JADX INFO: renamed from: buttonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m2351buttonElevationR_JCAzs(float r5, float r6, float r7, float r8, float r9, Composer r10, int r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r5 = FilledButtonTokens.INSTANCE.getContainerElevation-D9Ej5fM();
    L6:
        if ((r12 & 2) == 0) goto L8;
        r6 = FilledButtonTokens.INSTANCE.getPressedContainerElevation-D9Ej5fM();
    L8:
        float r13 = r6;
        if ((r12 & 4) == 0) goto L11;
        r7 = FilledButtonTokens.INSTANCE.getFocusedContainerElevation-D9Ej5fM();
    L11:
        float r0 = r7;
        if ((r12 & 8) == 0) goto L14;
        r8 = FilledButtonTokens.INSTANCE.getHoveredContainerElevation-D9Ej5fM();
    L14:
        float r1 = r8;
        if ((r12 & 16) == 0) goto L17;
        r9 = FilledButtonTokens.INSTANCE.getDisabledContainerElevation-D9Ej5fM();
    L17:
        float r14 = r9;
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventStart(1827791191, r11, -1, "androidx.compose.material3.ButtonDefaults.buttonElevation (Button.kt:811)");
    L20:
        ButtonElevation r2 = new ButtonElevation(r5, r13, r0, r1, r14, null);
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
    L23:
        return r2;
    }

    /* JADX INFO: renamed from: elevatedButtonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m2353elevatedButtonElevationR_JCAzs(float r5, float r6, float r7, float r8, float r9, Composer r10, int r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r5 = ElevatedButtonTokens.INSTANCE.getContainerElevation-D9Ej5fM();
    L6:
        if ((r12 & 2) == 0) goto L8;
        r6 = ElevatedButtonTokens.INSTANCE.getPressedContainerElevation-D9Ej5fM();
    L8:
        float r13 = r6;
        if ((r12 & 4) == 0) goto L11;
        r7 = ElevatedButtonTokens.INSTANCE.getFocusedContainerElevation-D9Ej5fM();
    L11:
        float r0 = r7;
        if ((r12 & 8) == 0) goto L14;
        r8 = ElevatedButtonTokens.INSTANCE.getHoveredContainerElevation-D9Ej5fM();
    L14:
        float r1 = r8;
        if ((r12 & 16) == 0) goto L17;
        r9 = ElevatedButtonTokens.INSTANCE.getDisabledContainerElevation-D9Ej5fM();
    L17:
        float r14 = r9;
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventStart(1065482445, r11, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonElevation (Button.kt:838)");
    L20:
        ButtonElevation r2 = new ButtonElevation(r5, r13, r0, r1, r14, null);
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
    L23:
        return r2;
    }

    /* JADX INFO: renamed from: filledTonalButtonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m2355filledTonalButtonElevationR_JCAzs(float r5, float r6, float r7, float r8, float r9, Composer r10, int r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r5 = FilledTonalButtonTokens.INSTANCE.getContainerElevation-D9Ej5fM();
    L6:
        if ((r12 & 2) == 0) goto L8;
        r6 = FilledTonalButtonTokens.INSTANCE.getPressedContainerElevation-D9Ej5fM();
    L8:
        float r13 = r6;
        if ((r12 & 4) == 0) goto L11;
        r7 = FilledTonalButtonTokens.INSTANCE.getFocusContainerElevation-D9Ej5fM();
    L11:
        float r0 = r7;
        if ((r12 & 8) == 0) goto L14;
        r8 = FilledTonalButtonTokens.INSTANCE.getHoverContainerElevation-D9Ej5fM();
    L14:
        float r1 = r8;
        if ((r12 & 16) == 0) goto L17;
        r9 = Dp.constructor-impl(0);
    L17:
        float r14 = r9;
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventStart(5982871, r11, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonElevation (Button.kt:868)");
    L20:
        ButtonElevation r2 = new ButtonElevation(r5, r13, r0, r1, r14, null);
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
    L23:
        return r2;
    }
}
