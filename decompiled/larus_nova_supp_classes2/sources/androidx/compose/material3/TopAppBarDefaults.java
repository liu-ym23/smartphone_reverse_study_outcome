package androidx.compose.material3;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.AppBarLargeFlexibleTokens;
import androidx.compose.material3.tokens.AppBarLargeTokens;
import androidx.compose.material3.tokens.AppBarMediumFlexibleTokens;
import androidx.compose.material3.tokens.AppBarMediumTokens;
import androidx.compose.material3.tokens.AppBarSmallTokens;
import androidx.compose.material3.tokens.AppBarTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JK\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u001a\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JA\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001b\u0010\u0011J\r\u0010\u001c\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JA\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001d\u0010\u0011J\r\u0010\u001e\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JA\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001f\u0010\u0011J'\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0007¢\u0006\u0002\u0010'JK\u0010(\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010-H\u0007¢\u0006\u0002\u0010.JU\u0010(\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010-2\b\b\u0002\u0010/\u001a\u00020&H\u0007¢\u0006\u0002\u00100JK\u00101\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010-H\u0007¢\u0006\u0002\u0010.R\u0018\u0010\u0012\u001a\u00020\u0005*\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u00102\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0013\u00107\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\b8\u00105R\u0013\u00109\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\b:\u00105R\u0013\u0010;\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\b<\u00105R\u0013\u0010=\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\b>\u00105R\u0013\u0010?\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\b@\u00105R\u0013\u0010A\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\bB\u00105R\u0013\u0010C\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\bD\u00105R\u0013\u0010E\u001a\u000203¢\u0006\n\n\u0002\u00106\u001a\u0004\bF\u00105¨\u0006G"}, d2 = {"Landroidx/compose/material3/TopAppBarDefaults;", "", "<init>", "()V", "topAppBarColors", "Landroidx/compose/material3/TopAppBarColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TopAppBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "subtitleContentColor", "topAppBarColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarColors;", "topAppBarColors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarColors;", "defaultTopAppBarColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultTopAppBarColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/TopAppBarColors;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "centerAlignedTopAppBarColors", "centerAlignedTopAppBarColors-zjMxDiM", "mediumTopAppBarColors", "mediumTopAppBarColors-zjMxDiM", "largeTopAppBarColors", "largeTopAppBarColors-zjMxDiM", "pinnedScrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "state", "Landroidx/compose/material3/TopAppBarState;", "canScroll", "Lkotlin/Function0;", "", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "enterAlwaysScrollBehavior", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "reverseLayout", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "exitUntilCollapsedScrollBehavior", "TopAppBarExpandedHeight", "Landroidx/compose/ui/unit/Dp;", "getTopAppBarExpandedHeight-D9Ej5fM", "()F", "F", "MediumAppBarCollapsedHeight", "getMediumAppBarCollapsedHeight-D9Ej5fM", "MediumAppBarExpandedHeight", "getMediumAppBarExpandedHeight-D9Ej5fM", "MediumFlexibleAppBarWithoutSubtitleExpandedHeight", "getMediumFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM", "MediumFlexibleAppBarWithSubtitleExpandedHeight", "getMediumFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM", "LargeAppBarCollapsedHeight", "getLargeAppBarCollapsedHeight-D9Ej5fM", "LargeAppBarExpandedHeight", "getLargeAppBarExpandedHeight-D9Ej5fM", "LargeFlexibleAppBarWithoutSubtitleExpandedHeight", "getLargeFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM", "LargeFlexibleAppBarWithSubtitleExpandedHeight", "getLargeFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TopAppBarDefaults {
    public static final int $stable = 0;
    public static final TopAppBarDefaults INSTANCE = null;
    private static final float LargeAppBarCollapsedHeight = 0.0f;
    private static final float LargeAppBarExpandedHeight = 0.0f;
    private static final float LargeFlexibleAppBarWithSubtitleExpandedHeight = 0.0f;
    private static final float LargeFlexibleAppBarWithoutSubtitleExpandedHeight = 0.0f;
    private static final float MediumAppBarCollapsedHeight = 0.0f;
    private static final float MediumAppBarExpandedHeight = 0.0f;
    private static final float MediumFlexibleAppBarWithSubtitleExpandedHeight = 0.0f;
    private static final float MediumFlexibleAppBarWithoutSubtitleExpandedHeight = 0.0f;
    private static final float TopAppBarExpandedHeight = 0.0f;

    private TopAppBarDefaults() {
    }

    public static /* synthetic */ boolean a() {
        return exitUntilCollapsedScrollBehavior$lambda$10$lambda$9();
    }

    public static /* synthetic */ boolean b() {
        return pinnedScrollBehavior$lambda$2$lambda$1();
    }

    public static /* synthetic */ boolean c() {
        return enterAlwaysScrollBehavior$lambda$5$lambda$4();
    }

    public static /* synthetic */ boolean d() {
        return enterAlwaysScrollBehavior$lambda$7$lambda$6();
    }

    private static final boolean enterAlwaysScrollBehavior$lambda$5$lambda$4() {
        return true;
    }

    private static final boolean enterAlwaysScrollBehavior$lambda$7$lambda$6() {
        return true;
    }

    private static final boolean exitUntilCollapsedScrollBehavior$lambda$10$lambda$9() {
        return true;
    }

    private static final boolean pinnedScrollBehavior$lambda$2$lambda$1() {
        return true;
    }

    static {
        INSTANCE = new TopAppBarDefaults();
        AppBarSmallTokens r0 = AppBarSmallTokens.INSTANCE;
        TopAppBarExpandedHeight = r0.getContainerHeight-D9Ej5fM();
        MediumAppBarCollapsedHeight = r0.getContainerHeight-D9Ej5fM();
        MediumAppBarExpandedHeight = AppBarMediumTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        AppBarMediumFlexibleTokens r1 = AppBarMediumFlexibleTokens.INSTANCE;
        MediumFlexibleAppBarWithoutSubtitleExpandedHeight = r1.getContainerHeight-D9Ej5fM();
        MediumFlexibleAppBarWithSubtitleExpandedHeight = r1.getLargeContainerHeight-D9Ej5fM();
        LargeAppBarCollapsedHeight = r0.getContainerHeight-D9Ej5fM();
        LargeAppBarExpandedHeight = AppBarLargeTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        AppBarLargeFlexibleTokens r2 = AppBarLargeFlexibleTokens.INSTANCE;
        LargeFlexibleAppBarWithoutSubtitleExpandedHeight = r2.getContainerHeight-D9Ej5fM();
        LargeFlexibleAppBarWithSubtitleExpandedHeight = r2.getLargeContainerHeight-D9Ej5fM();
    }

    /* JADX INFO: renamed from: getLargeAppBarCollapsedHeight-D9Ej5fM, reason: not valid java name */
    public final float m3578getLargeAppBarCollapsedHeightD9Ej5fM() {
        return LargeAppBarCollapsedHeight;
    }

    /* JADX INFO: renamed from: getLargeAppBarExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m3579getLargeAppBarExpandedHeightD9Ej5fM() {
        return LargeAppBarExpandedHeight;
    }

    /* JADX INFO: renamed from: getLargeFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m3580getLargeFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM() {
        return LargeFlexibleAppBarWithSubtitleExpandedHeight;
    }

    /* JADX INFO: renamed from: getLargeFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m3581getLargeFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM() {
        return LargeFlexibleAppBarWithoutSubtitleExpandedHeight;
    }

    /* JADX INFO: renamed from: getMediumAppBarCollapsedHeight-D9Ej5fM, reason: not valid java name */
    public final float m3582getMediumAppBarCollapsedHeightD9Ej5fM() {
        return MediumAppBarCollapsedHeight;
    }

    /* JADX INFO: renamed from: getMediumAppBarExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m3583getMediumAppBarExpandedHeightD9Ej5fM() {
        return MediumAppBarExpandedHeight;
    }

    /* JADX INFO: renamed from: getMediumFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m3584getMediumFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM() {
        return MediumFlexibleAppBarWithSubtitleExpandedHeight;
    }

    /* JADX INFO: renamed from: getMediumFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m3585getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM() {
        return MediumFlexibleAppBarWithoutSubtitleExpandedHeight;
    }

    /* JADX INFO: renamed from: getTopAppBarExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m3586getTopAppBarExpandedHeightD9Ej5fM() {
        return TopAppBarExpandedHeight;
    }

    public final TopAppBarColors getDefaultTopAppBarColors$material3(ColorScheme r17) {
        TopAppBarColors r1 = r17.getDefaultTopAppBarColorsCached$material3();
        if (r1 != null) goto L6;
        AppBarTokens r2 = AppBarTokens.INSTANCE;
        TopAppBarColors r3 = new TopAppBarColors(ColorSchemeKt.fromToken(r17, r2.getContainerColor()), ColorSchemeKt.fromToken(r17, r2.getOnScrollContainerColor()), ColorSchemeKt.fromToken(r17, r2.getLeadingIconColor()), ColorSchemeKt.fromToken(r17, r2.getTitleColor()), ColorSchemeKt.fromToken(r17, r2.getTrailingIconColor()), ColorSchemeKt.fromToken(r17, r2.getSubtitleColor()), null);
        r17.setDefaultTopAppBarColorsCached$material3(r3);
        return r3;
    L6:
        return r1;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors()", imports = {}))
    public final TopAppBarColors centerAlignedTopAppBarColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(513940029, r5, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:1540)");
    L5:
        TopAppBarColors r6 = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final WindowInsets getWindowInsets(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(2143182847, r5, -1, "androidx.compose.material3.TopAppBarDefaults.<get-windowInsets> (AppBar.kt:1526)");
    L5:
        WindowInsets r6 = SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, r4, 6);
        WindowInsetsSides.Companion r7 = WindowInsetsSides.Companion;
        WindowInsets r8 = WindowInsetsKt.m1046onlybOOhFvg(r6, WindowInsetsSides.m1060plusgK_yJZ4(r7.m1070getHorizontalJoeWqyM(), r7.m1074getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r8;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors()", imports = {}))
    public final TopAppBarColors largeTopAppBarColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1744932393, r5, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:1639)");
    L5:
        TopAppBarColors r6 = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors()", imports = {}))
    public final TopAppBarColors mediumTopAppBarColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1268886463, r5, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:1589)");
    L5:
        TopAppBarColors r6 = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final TopAppBarColors topAppBarColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1388520854, r5, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:1444)");
    L5:
        TopAppBarColors r6 = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final TopAppBarScrollBehavior pinnedScrollBehavior(TopAppBarState r8, Function0<Boolean> r9, Composer r10, int r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r8 = AppBarKt.rememberTopAppBarState(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r10, 0, 7);
    L6:
        if ((r12 & 2) == 0) goto L12;
        Object r13 = r10.rememberedValue();
        if (r13 != Composer.Companion.getEmpty()) goto L10;
        r13 = new mx();
        r10.updateRememberedValue(r13);
    L10:
        r9 = (Function0) r13;
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(286497075, r11, -1, "androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior (AppBar.kt:1695)");
    L14:
        boolean r0 = false;
        if (((r11 & 14) ^ 6) <= 4) goto L19;
        if (r10.changed(r8) == false) goto L19;
    L20:
        boolean r14 = true;
    L23:
        if (((r11 & 112) ^ 48) <= 32) goto L27;
        if (r10.changed(r9) == false) goto L27;
    L28:
        r0 = true;
    L29:
        boolean r15 = r14 | r0;
        Object r16 = r10.rememberedValue();
        if (r15 == false) goto L32;
    L33:
        r16 = new PinnedScrollBehavior(r8, r9);
        r10.updateRememberedValue(r16);
    L34:
        PinnedScrollBehavior r17 = (PinnedScrollBehavior) r16;
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventEnd();
    L37:
        return r17;
    L32:
        if (r16 != Composer.Companion.getEmpty()) goto L34;
    L27:
        if ((r11 & 48) != 32) goto L29;
    L19:
        if ((r11 & 6) == 4) goto L20;
        r14 = false;
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public final /* synthetic */ TopAppBarScrollBehavior enterAlwaysScrollBehavior(TopAppBarState r10, Function0 r11, AnimationSpec r12, DecayAnimationSpec r13, Composer r14, int r15, int r16) {
        if ((r16 & 1) == 0) goto L5;
        TopAppBarState r1 = AppBarKt.rememberTopAppBarState(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r14, 0, 7);
    L7:
        if ((r16 & 2) == 0) goto L12;
        Object r0 = r14.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L11;
        r0 = new lx();
        r14.updateRememberedValue(r0);
    L11:
        Function0 r2 = (Function0) r0;
    L14:
        if ((r16 & 4) == 0) goto L16;
        AnimationSpec r3 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r14, 6);
    L18:
        if ((r16 & 8) == 0) goto L20;
        DecayAnimationSpec r4 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(r14, 0);
    L22:
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventStart(959086674, r15, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:1723)");
    L24:
        int r7 = (r15 << 3) & 458752;
        TopAppBarScrollBehavior r5 = enterAlwaysScrollBehavior(r1, r2, r3, r4, false, r14, r7 | (((((r15 & 14) | 24576) | (r15 & 112)) | (r15 & 896)) | (r15 & 7168)), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L27;
        ComposerKt.traceEventEnd();
    L27:
        return r5;
    L20:
        r4 = r13;
        goto L22
    L16:
        r3 = r12;
        goto L18
    L12:
        r2 = r11;
        goto L14
    L5:
        r1 = r10;
        goto L7
    }

    public final TopAppBarScrollBehavior exitUntilCollapsedScrollBehavior(TopAppBarState r8, Function0<Boolean> r9, AnimationSpec<Float> r10, DecayAnimationSpec<Float> r11, Composer r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r8 = AppBarKt.rememberTopAppBarState(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r12, 0, 7);
    L6:
        if ((r14 & 2) == 0) goto L12;
        Object r15 = r12.rememberedValue();
        if (r15 != Composer.Companion.getEmpty()) goto L10;
        r15 = new nx();
        r12.updateRememberedValue(r15);
    L10:
        r9 = (Function0) r15;
    L12:
        if ((r14 & 4) == 0) goto L14;
        r10 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r12, 6);
    L14:
        boolean r0 = false;
        if ((r14 & 8) == 0) goto L18;
        r11 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(r12, 0);
    L18:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(-1757023234, r13, -1, "androidx.compose.material3.TopAppBarDefaults.exitUntilCollapsedScrollBehavior (AppBar.kt:1801)");
    L21:
        if (((r13 & 14) ^ 6) <= 4) goto L25;
        if (r12.changed(r8) == false) goto L25;
    L26:
        boolean r16 = true;
    L29:
        if (((r13 & 112) ^ 48) <= 32) goto L33;
        if (r12.changed(r9) == false) goto L33;
    L34:
        r0 = true;
    L35:
        boolean r17 = ((r16 | r0) | r12.changed(r10)) | r12.changed(r11);
        Object r18 = r12.rememberedValue();
        if (r17 == false) goto L38;
    L39:
        r18 = new ExitUntilCollapsedScrollBehavior(r8, r10, r11, r9);
        r12.updateRememberedValue(r18);
    L40:
        ExitUntilCollapsedScrollBehavior r19 = (ExitUntilCollapsedScrollBehavior) r18;
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventEnd();
    L43:
        return r19;
    L38:
        if (r18 != Composer.Companion.getEmpty()) goto L40;
    L33:
        if ((r13 & 48) != 32) goto L35;
    L25:
        if ((r13 & 6) == 4) goto L26;
        r16 = false;
        goto L29
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors(containerColor, scrolledContainerColor, navigationIconContentColor, titleContentColor, actionIconContentColor)", imports = {}))
    /* JADX INFO: renamed from: centerAlignedTopAppBarColors-zjMxDiM, reason: not valid java name */
    public final TopAppBarColors m3577centerAlignedTopAppBarColorszjMxDiM(long r18, long r20, long r22, long r24, long r26, Composer r28, int r29, int r30) {
        if ((r30 & 1) == 0) goto L5;
        long r3 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r30 & 2) == 0) goto L9;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r30 & 4) == 0) goto L13;
        long r7 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r30 & 8) == 0) goto L17;
        long r9 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r30 & 16) == 0) goto L21;
        long r11 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if (ComposerKt.isTraceInProgress() == false) goto L25;
        ComposerKt.traceEventStart(1896017784, r29, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:1570)");
    L25:
        TopAppBarColors r0 = TopAppBarColors.m3568copytNS2XkQ$default(getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(r28, 6)), r3, r5, r7, r9, r11, 0, 32, null);
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
    L28:
        return r0;
    L21:
        r11 = r26;
        goto L23
    L17:
        r9 = r24;
        goto L19
    L13:
        r7 = r22;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r3 = r18;
        goto L7
    }

    public final TopAppBarScrollBehavior enterAlwaysScrollBehavior(TopAppBarState r8, Function0<Boolean> r9, AnimationSpec<Float> r10, DecayAnimationSpec<Float> r11, boolean r12, Composer r13, int r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        r8 = AppBarKt.rememberTopAppBarState(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r13, 0, 7);
    L5:
        TopAppBarState r1 = r8;
        if ((r15 & 2) == 0) goto L11;
        Object r16 = r13.rememberedValue();
        if (r16 != Composer.Companion.getEmpty()) goto L10;
        r16 = new kx();
        r13.updateRememberedValue(r16);
    L10:
        r9 = (Function0) r16;
    L11:
        Function0<Boolean> r4 = r9;
        if ((r15 & 4) == 0) goto L14;
        r10 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r13, 6);
    L14:
        AnimationSpec<Float> r2 = r10;
        boolean r17 = false;
        if ((r15 & 8) == 0) goto L17;
        r11 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(r13, 0);
    L17:
        DecayAnimationSpec<Float> r3 = r11;
        if ((r15 & 16) == 0) goto L20;
        boolean r5 = false;
    L22:
        if (ComposerKt.isTraceInProgress() == false) goto L25;
        ComposerKt.traceEventStart(53729710, r14, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:1762)");
    L25:
        if (((r14 & 14) ^ 6) <= 4) goto L29;
        if (r13.changed(r1) == false) goto L29;
    L30:
        boolean r18 = true;
    L33:
        if (((r14 & 112) ^ 48) <= 32) goto L37;
        if (r13.changed(r4) == false) goto L37;
    L38:
        boolean r19 = true;
    L40:
        boolean r20 = ((r18 | r19) | r13.changed(r2)) | r13.changed(r3);
        if (((57344 & r14) ^ 24576) <= 16384) goto L45;
        if (r13.changed(r5) == false) goto L45;
    L46:
        r17 = true;
    L47:
        boolean r21 = r20 | r17;
        Object r22 = r13.rememberedValue();
        if (r21 == false) goto L50;
    L51:
        r22 = new EnterAlwaysScrollBehavior(r1, r2, r3, r4, r5);
        r13.updateRememberedValue(r22);
    L52:
        EnterAlwaysScrollBehavior r23 = (EnterAlwaysScrollBehavior) r22;
        if (ComposerKt.isTraceInProgress() == false) goto L55;
        ComposerKt.traceEventEnd();
    L55:
        return r23;
    L50:
        if (r22 != Composer.Companion.getEmpty()) goto L52;
    L45:
        if ((r14 & 24576) != 16384) goto L47;
    L37:
        if ((r14 & 48) == 32) goto L38;
        r19 = false;
    L29:
        if ((r14 & 6) == 4) goto L30;
        r18 = false;
        goto L33
    L20:
        r5 = r12;
        goto L22
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors(containerColor, scrolledContainerColor, navigationIconContentColor, titleContentColor, actionIconContentColor)", imports = {}))
    /* JADX INFO: renamed from: largeTopAppBarColors-zjMxDiM, reason: not valid java name */
    public final TopAppBarColors m3587largeTopAppBarColorszjMxDiM(long r18, long r20, long r22, long r24, long r26, Composer r28, int r29, int r30) {
        if ((r30 & 1) == 0) goto L5;
        long r3 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r30 & 2) == 0) goto L9;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r30 & 4) == 0) goto L13;
        long r7 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r30 & 8) == 0) goto L17;
        long r9 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r30 & 16) == 0) goto L21;
        long r11 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if (ComposerKt.isTraceInProgress() == false) goto L25;
        ComposerKt.traceEventStart(-1471507700, r29, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:1670)");
    L25:
        TopAppBarColors r0 = TopAppBarColors.m3568copytNS2XkQ$default(getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(r28, 6)), r3, r5, r7, r9, r11, 0, 32, null);
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
    L28:
        return r0;
    L21:
        r11 = r26;
        goto L23
    L17:
        r9 = r24;
        goto L19
    L13:
        r7 = r22;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r3 = r18;
        goto L7
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors(containerColor, scrolledContainerColor, navigationIconContentColor, titleContentColor, actionIconContentColor)", imports = {}))
    /* JADX INFO: renamed from: mediumTopAppBarColors-zjMxDiM, reason: not valid java name */
    public final TopAppBarColors m3588mediumTopAppBarColorszjMxDiM(long r18, long r20, long r22, long r24, long r26, Composer r28, int r29, int r30) {
        if ((r30 & 1) == 0) goto L5;
        long r3 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r30 & 2) == 0) goto L9;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r30 & 4) == 0) goto L13;
        long r7 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r30 & 8) == 0) goto L17;
        long r9 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r30 & 16) == 0) goto L21;
        long r11 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if (ComposerKt.isTraceInProgress() == false) goto L25;
        ComposerKt.traceEventStart(-582474442, r29, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:1620)");
    L25:
        TopAppBarColors r0 = TopAppBarColors.m3568copytNS2XkQ$default(getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(r28, 6)), r3, r5, r7, r9, r11, 0, 32, null);
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
    L28:
        return r0;
    L21:
        r11 = r26;
        goto L23
    L17:
        r9 = r24;
        goto L19
    L13:
        r7 = r22;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r3 = r18;
        goto L7
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility in favor of topAppBarColors with subtitleContentColor")
    /* JADX INFO: renamed from: topAppBarColors-zjMxDiM, reason: not valid java name */
    public final /* synthetic */ TopAppBarColors m3590topAppBarColorszjMxDiM(long r20, long r22, long r24, long r26, long r28, Composer r30, int r31, int r32) {
        if ((r32 & 1) == 0) goto L5;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r32 & 2) == 0) goto L9;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r32 & 4) == 0) goto L13;
        long r8 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r32 & 8) == 0) goto L17;
        long r14 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r32 & 16) == 0) goto L21;
        long r12 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if (ComposerKt.isTraceInProgress() == false) goto L25;
        ComposerKt.traceEventStart(2142919275, r31, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:1499)");
    L25:
        long r10 = r14;
        TopAppBarColors r0 = m3589topAppBarColors5tl4gsc(r4, r6, r8, r10, r12, r14, r30, ((((((r31 & 14) | (r31 & 112)) | (r31 & 896)) | (r31 & 7168)) | (57344 & r31)) | ((r31 << 6) & 458752)) | ((r31 << 3) & 3670016), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
    L28:
        return r0;
    L21:
        r12 = r28;
        goto L23
    L17:
        r14 = r26;
        goto L19
    L13:
        r8 = r24;
        goto L15
    L9:
        r6 = r22;
        goto L11
    L5:
        r4 = r20;
        goto L7
    }

    /* JADX INFO: renamed from: topAppBarColors-5tl4gsc, reason: not valid java name */
    public final TopAppBarColors m3589topAppBarColors5tl4gsc(long r17, long r19, long r21, long r23, long r25, long r27, Composer r29, int r30, int r31) {
        if ((r31 & 1) == 0) goto L5;
        long r0 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r31 & 2) == 0) goto L9;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r31 & 4) == 0) goto L13;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r31 & 8) == 0) goto L17;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r31 & 16) == 0) goto L21;
        long r8 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r31 & 32) == 0) goto L25;
        long r10 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventStart(-1325733438, r30, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:1467)");
    L29:
        TopAppBarColors r1 = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(r29, 6)).m3570copytNS2XkQ(r0, r2, r4, r6, r8, r10);
        if (ComposerKt.isTraceInProgress() == false) goto L32;
        ComposerKt.traceEventEnd();
    L32:
        return r1;
    L25:
        r10 = r27;
        goto L27
    L21:
        r8 = r25;
        goto L23
    L17:
        r6 = r23;
        goto L19
    L13:
        r4 = r21;
        goto L15
    L9:
        r2 = r19;
        goto L11
    L5:
        r0 = r17;
        goto L7
    }
}
