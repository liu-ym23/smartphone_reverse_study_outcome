package androidx.compose.foundation.layout;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.graphics.Insets;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bA\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\".\u0010\n\u001a\u00020\t*\u00020\u000b2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\".\u0010\n\u001a\u00020\t*\u00020\u00122\u0006\u0010\b\u001a\u00020\t8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014\"\u0004\b\u0010\u0010\u0015\"\u0015\u0010\u0016\u001a\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0015\u0010\u001b\u001a\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001a\"\u0015\u0010\u001d\u001a\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001a\"\u0015\u0010\u001f\u001a\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001a\u0004\b \u0010\u001a\"\u0015\u0010!\u001a\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001a\u0004\b\"\u0010\u001a\"\u0015\u0010#\u001a\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001a\u0004\b$\u0010\u001a\"\u0015\u0010%\u001a\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001a\u0004\b&\u0010\u001a\"\u0015\u0010'\u001a\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001a\u0004\b(\u0010\u001a\"\u0015\u0010)\u001a\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001a\u0004\b*\u0010\u001a\"\u0015\u0010+\u001a\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001a\u0004\b,\u0010\u001a\"\u0015\u0010-\u001a\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001a\u0004\b.\u0010\u001a\"\u0015\u0010/\u001a\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001a\u0004\b0\u0010\u001a\"\u0015\u00101\u001a\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001a\u0004\b2\u0010\u001a\"\u001e\u00103\u001a\u00020\u0017*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\b4\u00105\u001a\u0004\b6\u0010\u001a\"\u001e\u00107\u001a\u00020\u0017*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u00105\u001a\u0004\b9\u0010\u001a\"\u001e\u0010:\u001a\u00020\u0017*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\b;\u00105\u001a\u0004\b<\u0010\u001a\"\u001e\u0010=\u001a\u00020\u0017*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\b>\u00105\u001a\u0004\b?\u0010\u001a\"\u001e\u0010@\u001a\u00020\u0017*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bA\u00105\u001a\u0004\bB\u0010\u001a\"\u001e\u0010C\u001a\u00020\t*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bD\u00105\u001a\u0004\bC\u0010E\"\u001e\u0010F\u001a\u00020\t*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bG\u00105\u001a\u0004\bF\u0010E\"\u001e\u0010H\u001a\u00020\t*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bI\u00105\u001a\u0004\bJ\u0010E\"\u001e\u0010K\u001a\u00020\t*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bL\u00105\u001a\u0004\bM\u0010E\"\u001e\u0010N\u001a\u00020\t*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bO\u00105\u001a\u0004\bP\u0010E\"\u001e\u0010Q\u001a\u00020\t*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bR\u00105\u001a\u0004\bQ\u0010E\"\u001e\u0010S\u001a\u00020\u0017*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bT\u00105\u001a\u0004\bU\u0010\u001a\"\u001e\u0010V\u001a\u00020\u0017*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bW\u00105\u001a\u0004\bX\u0010\u001a¨\u0006Y"}, d2 = {"toInsetsValues", "Landroidx/compose/foundation/layout/InsetsValues;", "Landroidx/core/graphics/Insets;", "ValueInsets", "Landroidx/compose/foundation/layout/ValueInsets;", "insets", HintConstants.AUTOFILL_HINT_NAME, "", "value", "", "consumeWindowInsets", "Landroidx/compose/ui/platform/AbstractComposeView;", "getConsumeWindowInsets$annotations", "(Landroidx/compose/ui/platform/AbstractComposeView;)V", "getConsumeWindowInsets", "(Landroidx/compose/ui/platform/AbstractComposeView;)Z", "setConsumeWindowInsets", "(Landroidx/compose/ui/platform/AbstractComposeView;Z)V", "Landroidx/compose/ui/platform/ComposeView;", "(Landroidx/compose/ui/platform/ComposeView;)V", "(Landroidx/compose/ui/platform/ComposeView;)Z", "(Landroidx/compose/ui/platform/ComposeView;Z)V", "captionBar", "Landroidx/compose/foundation/layout/WindowInsets;", "Landroidx/compose/foundation/layout/WindowInsets$Companion;", "getCaptionBar", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "displayCutout", "getDisplayCutout", "ime", "getIme", "mandatorySystemGestures", "getMandatorySystemGestures", "navigationBars", "getNavigationBars", "statusBars", "getStatusBars", "systemBars", "getSystemBars", "systemGestures", "getSystemGestures", "tappableElement", "getTappableElement", "waterfall", "getWaterfall", "safeDrawing", "getSafeDrawing", "safeGestures", "getSafeGestures", "safeContent", "getSafeContent", "captionBarIgnoringVisibility", "getCaptionBarIgnoringVisibility$annotations", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;)V", "getCaptionBarIgnoringVisibility", "navigationBarsIgnoringVisibility", "getNavigationBarsIgnoringVisibility$annotations", "getNavigationBarsIgnoringVisibility", "statusBarsIgnoringVisibility", "getStatusBarsIgnoringVisibility$annotations", "getStatusBarsIgnoringVisibility", "systemBarsIgnoringVisibility", "getSystemBarsIgnoringVisibility$annotations", "getSystemBarsIgnoringVisibility", "tappableElementIgnoringVisibility", "getTappableElementIgnoringVisibility$annotations", "getTappableElementIgnoringVisibility", "isCaptionBarVisible", "isCaptionBarVisible$annotations", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Z", "isImeVisible", "isImeVisible$annotations", "areStatusBarsVisible", "getAreStatusBarsVisible$annotations", "getAreStatusBarsVisible", "areNavigationBarsVisible", "getAreNavigationBarsVisible$annotations", "getAreNavigationBarsVisible", "areSystemBarsVisible", "getAreSystemBarsVisible$annotations", "getAreSystemBarsVisible", "isTappableElementVisible", "isTappableElementVisible$annotations", "imeAnimationSource", "getImeAnimationSource$annotations", "getImeAnimationSource", "imeAnimationTarget", "getImeAnimationTarget$annotations", "getImeAnimationTarget", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WindowInsets_androidKt {
    public static /* synthetic */ void getAreNavigationBarsVisible$annotations(WindowInsets.Companion r0) {
    }

    public static /* synthetic */ void getAreStatusBarsVisible$annotations(WindowInsets.Companion r0) {
    }

    public static /* synthetic */ void getAreSystemBarsVisible$annotations(WindowInsets.Companion r0) {
    }

    public static /* synthetic */ void getCaptionBarIgnoringVisibility$annotations(WindowInsets.Companion r0) {
    }

    public static /* synthetic */ void getConsumeWindowInsets$annotations(AbstractComposeView r0) {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use AbstractComposeView.consumeWindowInsets")
    public static /* synthetic */ void getConsumeWindowInsets$annotations(ComposeView r0) {
    }

    public static /* synthetic */ void getImeAnimationSource$annotations(WindowInsets.Companion r0) {
    }

    public static /* synthetic */ void getImeAnimationTarget$annotations(WindowInsets.Companion r0) {
    }

    public static /* synthetic */ void getNavigationBarsIgnoringVisibility$annotations(WindowInsets.Companion r0) {
    }

    public static /* synthetic */ void getStatusBarsIgnoringVisibility$annotations(WindowInsets.Companion r0) {
    }

    public static /* synthetic */ void getSystemBarsIgnoringVisibility$annotations(WindowInsets.Companion r0) {
    }

    public static /* synthetic */ void getTappableElementIgnoringVisibility$annotations(WindowInsets.Companion r0) {
    }

    public static /* synthetic */ void isCaptionBarVisible$annotations(WindowInsets.Companion r0) {
    }

    public static /* synthetic */ void isImeVisible$annotations(WindowInsets.Companion r0) {
    }

    public static /* synthetic */ void isTappableElementVisible$annotations(WindowInsets.Companion r0) {
    }

    public static final boolean getConsumeWindowInsets(AbstractComposeView r1) {
        Object r2 = r1.getTag(2131367706);
        if ((r2 instanceof Boolean) == false) goto L5;
        Boolean r3 = (Boolean) r2;
    L6:
        if (r3 == null) goto L9;
        return r3.booleanValue();
    L9:
        if (ComposeFoundationLayoutFlags.isWindowInsetsDefaultPassThroughEnabled == true) goto L11;
        return true;
    L11:
        return false;
    L5:
        r3 = null;
        goto L6
    }

    public static final InsetsValues toInsetsValues(Insets r4) {
        return new InsetsValues(r4.left, r4.top, r4.right, r4.bottom);
    }

    public static final /* synthetic */ boolean getConsumeWindowInsets(ComposeView r1) {
        Object r2 = r1.getTag(2131367706);
        if ((r2 instanceof Boolean) == false) goto L5;
        Boolean r3 = (Boolean) r2;
    L6:
        if (r3 == null) goto L9;
        return r3.booleanValue();
    L9:
        if (ComposeFoundationLayoutFlags.isWindowInsetsDefaultPassThroughEnabled == true) goto L11;
        return true;
    L11:
        return false;
    L5:
        r3 = null;
        goto L6
    }

    public static final ValueInsets ValueInsets(Insets r1, String r2) {
        return new ValueInsets(toInsetsValues(r1), r2);
    }

    public static final void setConsumeWindowInsets(AbstractComposeView r1, boolean r2) {
        r1.setTag(2131367706, Boolean.valueOf(r2));
    }

    public static final /* synthetic */ void setConsumeWindowInsets(ComposeView r1, boolean r2) {
        r1.setTag(2131367706, Boolean.valueOf(r2));
    }

    public static final boolean getAreNavigationBarsVisible(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(710310464, r4, -1, "androidx.compose.foundation.layout.<get-areNavigationBarsVisible> (WindowInsets.android.kt:307)");
    L5:
        boolean r5 = WindowInsetsHolder.Companion.current(r3, 6).getNavigationBars().isVisible();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final boolean getAreStatusBarsVisible(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1613283456, r4, -1, "androidx.compose.foundation.layout.<get-areStatusBarsVisible> (WindowInsets.android.kt:297)");
    L5:
        boolean r5 = WindowInsetsHolder.Companion.current(r3, 6).getStatusBars().isVisible();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final boolean getAreSystemBarsVisible(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1985490720, r4, -1, "androidx.compose.foundation.layout.<get-areSystemBarsVisible> (WindowInsets.android.kt:315)");
    L5:
        boolean r5 = WindowInsetsHolder.Companion.current(r3, 6).getSystemBars().isVisible();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getCaptionBar(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1832025528, r4, -1, "androidx.compose.foundation.layout.<get-captionBar> (WindowInsets.android.kt:143)");
    L5:
        AndroidWindowInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getCaptionBar();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getCaptionBarIgnoringVisibility(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1731251574, r4, -1, "androidx.compose.foundation.layout.<get-captionBarIgnoringVisibility> (WindowInsets.android.kt:230)");
    L5:
        ValueInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getCaptionBarIgnoringVisibility();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getDisplayCutout(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1324817724, r4, -1, "androidx.compose.foundation.layout.<get-displayCutout> (WindowInsets.android.kt:150)");
    L5:
        AndroidWindowInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getDisplayCutout();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getIme(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1466917860, r4, -1, "androidx.compose.foundation.layout.<get-ime> (WindowInsets.android.kt:162)");
    L5:
        AndroidWindowInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getIme();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getImeAnimationSource(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1126064918, r4, -1, "androidx.compose.foundation.layout.<get-imeAnimationSource> (WindowInsets.android.kt:334)");
    L5:
        ValueInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getImeAnimationSource();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getImeAnimationTarget(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-466319786, r4, -1, "androidx.compose.foundation.layout.<get-imeAnimationTarget> (WindowInsets.android.kt:344)");
    L5:
        ValueInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getImeAnimationTarget();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getMandatorySystemGestures(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1369492988, r4, -1, "androidx.compose.foundation.layout.<get-mandatorySystemGestures> (WindowInsets.android.kt:171)");
    L5:
        AndroidWindowInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getMandatorySystemGestures();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getNavigationBars(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1596175702, r4, -1, "androidx.compose.foundation.layout.<get-navigationBars> (WindowInsets.android.kt:178)");
    L5:
        AndroidWindowInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getNavigationBars();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getNavigationBarsIgnoringVisibility(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1990981160, r4, -1, "androidx.compose.foundation.layout.<get-navigationBarsIgnoringVisibility> (WindowInsets.android.kt:241)");
    L5:
        ValueInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getNavigationBarsIgnoringVisibility();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getSafeContent(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-2026663876, r4, -1, "androidx.compose.foundation.layout.<get-safeContent> (WindowInsets.android.kt:220)");
    L5:
        WindowInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getSafeContent();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getSafeDrawing(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-49441252, r4, -1, "androidx.compose.foundation.layout.<get-safeDrawing> (WindowInsets.android.kt:205)");
    L5:
        WindowInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getSafeDrawing();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getSafeGestures(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1594247780, r4, -1, "androidx.compose.foundation.layout.<get-safeGestures> (WindowInsets.android.kt:213)");
    L5:
        WindowInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getSafeGestures();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getStatusBars(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-675090670, r4, -1, "androidx.compose.foundation.layout.<get-statusBars> (WindowInsets.android.kt:182)");
    L5:
        AndroidWindowInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getStatusBars();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getStatusBarsIgnoringVisibility(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(594020756, r4, -1, "androidx.compose.foundation.layout.<get-statusBarsIgnoringVisibility> (WindowInsets.android.kt:251)");
    L5:
        ValueInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getStatusBarsIgnoringVisibility();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getSystemBars(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-282936756, r4, -1, "androidx.compose.foundation.layout.<get-systemBars> (WindowInsets.android.kt:186)");
    L5:
        AndroidWindowInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getSystemBars();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getSystemBarsIgnoringVisibility(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1564566798, r4, -1, "androidx.compose.foundation.layout.<get-systemBarsIgnoringVisibility> (WindowInsets.android.kt:262)");
    L5:
        ValueInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getSystemBarsIgnoringVisibility();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getSystemGestures(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(989216224, r4, -1, "androidx.compose.foundation.layout.<get-systemGestures> (WindowInsets.android.kt:190)");
    L5:
        AndroidWindowInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getSystemGestures();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getTappableElement(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1994205284, r4, -1, "androidx.compose.foundation.layout.<get-tappableElement> (WindowInsets.android.kt:194)");
    L5:
        AndroidWindowInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getTappableElement();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getTappableElementIgnoringVisibility(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1488788292, r4, -1, "androidx.compose.foundation.layout.<get-tappableElementIgnoringVisibility> (WindowInsets.android.kt:273)");
    L5:
        ValueInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getTappableElementIgnoringVisibility();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final WindowInsets getWaterfall(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1943241020, r4, -1, "androidx.compose.foundation.layout.<get-waterfall> (WindowInsets.android.kt:198)");
    L5:
        ValueInsets r5 = WindowInsetsHolder.Companion.current(r3, 6).getWaterfall();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final boolean isCaptionBarVisible(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-501076620, r4, -1, "androidx.compose.foundation.layout.<get-isCaptionBarVisible> (WindowInsets.android.kt:281)");
    L5:
        boolean r5 = WindowInsetsHolder.Companion.current(r3, 6).getCaptionBar().isVisible();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final boolean isImeVisible(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1873571424, r4, -1, "androidx.compose.foundation.layout.<get-isImeVisible> (WindowInsets.android.kt:289)");
    L5:
        boolean r5 = WindowInsetsHolder.Companion.current(r3, 6).getIme().isVisible();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final boolean isTappableElementVisible(WindowInsets.Companion r2, Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1737201120, r4, -1, "androidx.compose.foundation.layout.<get-isTappableElementVisible> (WindowInsets.android.kt:324)");
    L5:
        boolean r5 = WindowInsetsHolder.Companion.current(r3, 6).getTappableElement().isVisible();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }
}
