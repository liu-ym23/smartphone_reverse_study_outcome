package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u00101\u001a\u0002022\u0006\u00103\u001a\u000204¢\u0006\u0004\b5\u00106R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u00020\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001a\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001b\u0010\u0007R\u0013\u0010\u001c\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001d\u0010\u0007R\u0013\u0010\u001e\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001f\u0010\u0007R\u0013\u0010 \u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b!\u0010\u0007R\u0013\u0010\"\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b#\u0010\u0007R\u0013\u0010$\u001a\u00020%¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u00020%¢\u0006\n\n\u0002\u0010(\u001a\u0004\b.\u0010'R\u0013\u0010/\u001a\u00020%¢\u0006\n\n\u0002\u0010(\u001a\u0004\b0\u0010'¨\u00067"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuSpec;", "", "<init>", "()V", "ContainerWidthMin", "Landroidx/compose/ui/unit/Dp;", "getContainerWidthMin-D9Ej5fM", "()F", "F", "ContainerWidthMax", "getContainerWidthMax-D9Ej5fM", "ListItemHeight", "getListItemHeight-D9Ej5fM", "MenuContainerElevation", "getMenuContainerElevation-D9Ej5fM", "CornerRadius", "getCornerRadius-D9Ej5fM", "LabelVerticalTextAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "getLabelVerticalTextAlignment", "()Landroidx/compose/ui/Alignment$Vertical;", "LabelHorizontalTextAlignment", "Landroidx/compose/ui/text/style/TextAlign;", "getLabelHorizontalTextAlignment-e0LSkKk", "()I", "I", "HorizontalPadding", "getHorizontalPadding-D9Ej5fM", "VerticalPadding", "getVerticalPadding-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "DividerHeight", "getDividerHeight-D9Ej5fM", "DividerVerticalPadding", "getDividerVerticalPadding-D9Ej5fM", "FontSize", "Landroidx/compose/ui/unit/TextUnit;", "getFontSize-XSAIIZE", "()J", "J", "FontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "LineHeight", "getLineHeight-XSAIIZE", "LetterSpacing", "getLetterSpacing-XSAIIZE", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "textStyle-8_81llA", "(J)Landroidx/compose/ui/text/TextStyle;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextMenuSpec {
    public static final int $stable = 0;
    private static final float ContainerWidthMax = 0.0f;
    private static final float ContainerWidthMin = 0.0f;
    private static final float CornerRadius = 0.0f;
    private static final float DividerHeight = 0.0f;
    private static final float DividerVerticalPadding = 0.0f;
    private static final long FontSize = 0;
    private static final FontWeight FontWeight = null;
    private static final float HorizontalPadding = 0.0f;
    public static final ContextMenuSpec INSTANCE = null;
    private static final float IconSize = 0.0f;
    private static final int LabelHorizontalTextAlignment = 0;
    private static final Alignment.Vertical LabelVerticalTextAlignment = null;
    private static final long LetterSpacing = 0;
    private static final long LineHeight = 0;
    private static final float ListItemHeight = 0.0f;
    private static final float MenuContainerElevation = 0.0f;
    private static final float VerticalPadding = 0.0f;

    private ContextMenuSpec() {
    }

    static {
        INSTANCE = new ContextMenuSpec();
        ContainerWidthMin = Dp.constructor-impl(112);
        ContainerWidthMax = Dp.constructor-impl(280);
        ListItemHeight = Dp.constructor-impl(48);
        MenuContainerElevation = Dp.constructor-impl(3);
        CornerRadius = Dp.constructor-impl(4);
        LabelVerticalTextAlignment = Alignment.Companion.getCenterVertically();
        LabelHorizontalTextAlignment = TextAlign.Companion.getStart-e0LSkKk();
        HorizontalPadding = Dp.constructor-impl(12);
        float r0 = 8;
        VerticalPadding = Dp.constructor-impl(r0);
        IconSize = Dp.constructor-impl(24);
        DividerHeight = Dp.constructor-impl(1);
        DividerVerticalPadding = Dp.constructor-impl(r0);
        FontSize = TextUnitKt.getSp(14);
        FontWeight = FontWeight.Companion.getMedium();
        LineHeight = TextUnitKt.getSp(20);
        LetterSpacing = TextUnitKt.getSp(0.1f);
    }

    /* JADX INFO: renamed from: getContainerWidthMax-D9Ej5fM, reason: not valid java name */
    public final float m474getContainerWidthMaxD9Ej5fM() {
        return ContainerWidthMax;
    }

    /* JADX INFO: renamed from: getContainerWidthMin-D9Ej5fM, reason: not valid java name */
    public final float m475getContainerWidthMinD9Ej5fM() {
        return ContainerWidthMin;
    }

    /* JADX INFO: renamed from: getCornerRadius-D9Ej5fM, reason: not valid java name */
    public final float m476getCornerRadiusD9Ej5fM() {
        return CornerRadius;
    }

    /* JADX INFO: renamed from: getDividerHeight-D9Ej5fM, reason: not valid java name */
    public final float m477getDividerHeightD9Ej5fM() {
        return DividerHeight;
    }

    /* JADX INFO: renamed from: getDividerVerticalPadding-D9Ej5fM, reason: not valid java name */
    public final float m478getDividerVerticalPaddingD9Ej5fM() {
        return DividerVerticalPadding;
    }

    /* JADX INFO: renamed from: getFontSize-XSAIIZE, reason: not valid java name */
    public final long m479getFontSizeXSAIIZE() {
        return FontSize;
    }

    public final FontWeight getFontWeight() {
        return FontWeight;
    }

    /* JADX INFO: renamed from: getHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m480getHorizontalPaddingD9Ej5fM() {
        return HorizontalPadding;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m481getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getLabelHorizontalTextAlignment-e0LSkKk, reason: not valid java name */
    public final int m482getLabelHorizontalTextAlignmente0LSkKk() {
        return LabelHorizontalTextAlignment;
    }

    public final Alignment.Vertical getLabelVerticalTextAlignment() {
        return LabelVerticalTextAlignment;
    }

    /* JADX INFO: renamed from: getLetterSpacing-XSAIIZE, reason: not valid java name */
    public final long m483getLetterSpacingXSAIIZE() {
        return LetterSpacing;
    }

    /* JADX INFO: renamed from: getLineHeight-XSAIIZE, reason: not valid java name */
    public final long m484getLineHeightXSAIIZE() {
        return LineHeight;
    }

    /* JADX INFO: renamed from: getListItemHeight-D9Ej5fM, reason: not valid java name */
    public final float m485getListItemHeightD9Ej5fM() {
        return ListItemHeight;
    }

    /* JADX INFO: renamed from: getMenuContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m486getMenuContainerElevationD9Ej5fM() {
        return MenuContainerElevation;
    }

    /* JADX INFO: renamed from: getVerticalPadding-D9Ej5fM, reason: not valid java name */
    public final float m487getVerticalPaddingD9Ej5fM() {
        return VerticalPadding;
    }

    /* JADX INFO: renamed from: textStyle-8_81llA, reason: not valid java name */
    public final TextStyle m488textStyle8_81llA(long r34) {
        int r20 = LabelHorizontalTextAlignment;
        long r3 = FontSize;
        FontWeight r5 = FontWeight;
        long r22 = LineHeight;
        return new TextStyle(r34, r3, r5, null, null, null, null, LetterSpacing, null, null, null, 0, null, null, null, r20, 0, r22, null, null, null, 0, 0, null, 16613240, null);
    }
}
