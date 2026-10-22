package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\b\u0001\u0018\u00002\u00020\u0001Bì\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u0012\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\u0002\b\u0007¢\u0006\u0002\b\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001e\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\n\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u001e\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\n\n\u0002\u0010'\u001a\u0004\b-\u0010&R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R \u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\n\n\u0002\u0010'\u001a\u0004\b/\u0010&R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010)R \u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\n\n\u0002\u0010'\u001a\u0004\b1\u0010&R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010)R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001e\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\n\n\u0002\u0010'\u001a\u0004\b5\u0010&R)\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\u0002\b\u0007¢\u0006\u0002\b\u0018¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107R\u0013\u0010\u0019\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010,\u001a\u0004\b9\u0010+R\u0013\u0010\u001a\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010,\u001a\u0004\b:\u0010+R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@¨\u0006A"}, d2 = {"Landroidx/compose/material3/TwoRowsTopAppBarOverrideScope;", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "titleBottomPadding", "Landroidx/compose/ui/unit/Dp;", "smallTitle", "smallTitleTextStyle", "subtitle", "subtitleTextStyle", "smallSubtitle", "smallSubtitleTextStyle", "titleHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "navigationIcon", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "collapsedHeight", "expandedHeight", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "colors", "Landroidx/compose/material3/TopAppBarColors;", "scrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "<init>", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getModifier", "()Landroidx/compose/ui/Modifier;", "getTitle", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getTitleTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "getTitleBottomPadding-D9Ej5fM", "()F", "F", "getSmallTitle", "getSmallTitleTextStyle", "getSubtitle", "getSubtitleTextStyle", "getSmallSubtitle", "getSmallSubtitleTextStyle", "getTitleHorizontalAlignment", "()Landroidx/compose/ui/Alignment$Horizontal;", "getNavigationIcon", "getActions", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "getCollapsedHeight-D9Ej5fM", "getExpandedHeight-D9Ej5fM", "getWindowInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "getColors", "()Landroidx/compose/material3/TopAppBarColors;", "getScrollBehavior", "()Landroidx/compose/material3/TopAppBarScrollBehavior;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TwoRowsTopAppBarOverrideScope {
    public static final int $stable = 0;
    private final Function3<RowScope, Composer, Integer, Unit> actions;
    private final float collapsedHeight;
    private final TopAppBarColors colors;
    private final float expandedHeight;
    private final Modifier modifier;
    private final Function2<Composer, Integer, Unit> navigationIcon;
    private final TopAppBarScrollBehavior scrollBehavior;
    private final Function2<Composer, Integer, Unit> smallSubtitle;
    private final TextStyle smallSubtitleTextStyle;
    private final Function2<Composer, Integer, Unit> smallTitle;
    private final TextStyle smallTitleTextStyle;
    private final Function2<Composer, Integer, Unit> subtitle;
    private final TextStyle subtitleTextStyle;
    private final Function2<Composer, Integer, Unit> title;
    private final float titleBottomPadding;
    private final Alignment.Horizontal titleHorizontalAlignment;
    private final TextStyle titleTextStyle;
    private final WindowInsets windowInsets;

    public /* synthetic */ TwoRowsTopAppBarOverrideScope(Modifier r1, Function2 r2, TextStyle r3, float r4, Function2 r5, TextStyle r6, Function2 r7, TextStyle r8, Function2 r9, TextStyle r10, Alignment.Horizontal r11, Function2 r12, Function3 r13, float r14, float r15, WindowInsets r16, TopAppBarColors r17, TopAppBarScrollBehavior r18, DefaultConstructorMarker r19) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public final Function3<RowScope, Composer, Integer, Unit> getActions() {
        return this.actions;
    }

    /* JADX INFO: renamed from: getCollapsedHeight-D9Ej5fM, reason: not valid java name */
    public final float m3599getCollapsedHeightD9Ej5fM() {
        return this.collapsedHeight;
    }

    public final TopAppBarColors getColors() {
        return this.colors;
    }

    /* JADX INFO: renamed from: getExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m3600getExpandedHeightD9Ej5fM() {
        return this.expandedHeight;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final Function2<Composer, Integer, Unit> getNavigationIcon() {
        return this.navigationIcon;
    }

    public final TopAppBarScrollBehavior getScrollBehavior() {
        return this.scrollBehavior;
    }

    public final Function2<Composer, Integer, Unit> getSmallSubtitle() {
        return this.smallSubtitle;
    }

    public final TextStyle getSmallSubtitleTextStyle() {
        return this.smallSubtitleTextStyle;
    }

    public final Function2<Composer, Integer, Unit> getSmallTitle() {
        return this.smallTitle;
    }

    public final TextStyle getSmallTitleTextStyle() {
        return this.smallTitleTextStyle;
    }

    public final Function2<Composer, Integer, Unit> getSubtitle() {
        return this.subtitle;
    }

    public final TextStyle getSubtitleTextStyle() {
        return this.subtitleTextStyle;
    }

    public final Function2<Composer, Integer, Unit> getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: getTitleBottomPadding-D9Ej5fM, reason: not valid java name */
    public final float m3601getTitleBottomPaddingD9Ej5fM() {
        return this.titleBottomPadding;
    }

    public final Alignment.Horizontal getTitleHorizontalAlignment() {
        return this.titleHorizontalAlignment;
    }

    public final TextStyle getTitleTextStyle() {
        return this.titleTextStyle;
    }

    public final WindowInsets getWindowInsets() {
        return this.windowInsets;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TwoRowsTopAppBarOverrideScope(Modifier r3, Function2<? super Composer, ? super Integer, Unit> r4, TextStyle r5, float r6, Function2<? super Composer, ? super Integer, Unit> r7, TextStyle r8, Function2<? super Composer, ? super Integer, Unit> r9, TextStyle r10, Function2<? super Composer, ? super Integer, Unit> r11, TextStyle r12, Alignment.Horizontal r13, Function2<? super Composer, ? super Integer, Unit> r14, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r15, float r16, float r17, WindowInsets r18, TopAppBarColors r19, TopAppBarScrollBehavior r20) {
        this.modifier = r3;
        this.title = r4;
        this.titleTextStyle = r5;
        this.titleBottomPadding = r6;
        this.smallTitle = r7;
        this.smallTitleTextStyle = r8;
        this.subtitle = r9;
        this.subtitleTextStyle = r10;
        this.smallSubtitle = r11;
        this.smallSubtitleTextStyle = r12;
        this.titleHorizontalAlignment = r13;
        this.navigationIcon = r14;
        this.actions = r15;
        this.collapsedHeight = r16;
        this.expandedHeight = r17;
        this.windowInsets = r18;
        this.colors = r19;
        this.scrollBehavior = r20;
    }
}
