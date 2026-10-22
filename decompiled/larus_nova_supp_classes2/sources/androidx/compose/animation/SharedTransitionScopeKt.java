package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LookaheadScopeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\t\u001a1\u0010\n\u001a\u00020\u00012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0007¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\f\u001a\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0003\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0010\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013\"\"\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0018\u001a\u00020\u00198\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0013\"\u000e\u0010\u001b\u001a\u00020\u001cX\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010#\u001a\u00020\u001c*\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%\"\u0018\u0010#\u001a\u00020\u001c*\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010&\".\u0010'\u001a\u001a\u0012\u0004\u0012\u00020 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001e0(0(8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b)\u0010\u0013¨\u0006*"}, d2 = {"SharedTransitionLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SharedTransitionScope", "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "DefaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/geometry/Rect;", "ParentClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "getParentClip$annotations", "()V", "DefaultClipInOverlayDuringTransition", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "DefaultBoundsTransform", "Landroidx/compose/animation/BoundsTransform;", "getDefaultBoundsTransform$annotations", "VisualDebugging", "", "ScaleToBoundsCached", "Landroidx/compose/animation/ScaleToBoundsImpl;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alignment", "Landroidx/compose/ui/Alignment;", "shouldCache", "getShouldCache", "(Landroidx/compose/ui/Alignment;)Z", "(Landroidx/compose/ui/layout/ContentScale;)Z", "cachedScaleToBoundsImplMap", "Landroidx/collection/MutableScatterMap;", "getCachedScaleToBoundsImplMap$annotations", "animation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SharedTransitionScopeKt {
    private static final BoundsTransform DefaultBoundsTransform = null;
    private static final Function2<LayoutDirection, Density, Path> DefaultClipInOverlayDuringTransition = null;
    private static final SpringSpec<Rect> DefaultSpring = null;
    private static final SharedTransitionScope.OverlayClip ParentClip = null;
    public static final boolean VisualDebugging = false;
    private static final MutableScatterMap<ContentScale, MutableScatterMap<Alignment, ScaleToBoundsImpl>> cachedScaleToBoundsImplMap = null;

    public static /* synthetic */ FiniteAnimationSpec a(Rect r0, Rect r1) {
        return DefaultBoundsTransform$lambda$0(r0, r1);
    }

    private static /* synthetic */ void getCachedScaleToBoundsImplMap$annotations() {
    }

    private static /* synthetic */ void getDefaultBoundsTransform$annotations() {
    }

    private static /* synthetic */ void getParentClip$annotations() {
    }

    static {
        DefaultSpring = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), 1, null);
        ParentClip = new SharedTransitionScopeKt$ParentClip$1();
        DefaultClipInOverlayDuringTransition = SharedTransitionScopeKt$DefaultClipInOverlayDuringTransition$1.INSTANCE;
        DefaultBoundsTransform = new c();
        cachedScaleToBoundsImplMap = new MutableScatterMap(0, 1, null);
    }

    public static final /* synthetic */ BoundsTransform access$getDefaultBoundsTransform$p() {
        return DefaultBoundsTransform;
    }

    public static final /* synthetic */ Function2 access$getDefaultClipInOverlayDuringTransition$p() {
        return DefaultClipInOverlayDuringTransition;
    }

    public static final /* synthetic */ SharedTransitionScope.OverlayClip access$getParentClip$p() {
        return ParentClip;
    }

    private static final boolean getShouldCache(Alignment r2) {
        Alignment.Companion r0 = Alignment.Companion;
        if (r2 != r0.getTopStart()) goto L5;
    L22:
        return true;
    L5:
        if (r2 == r0.getTopCenter()) goto L22;
        if (r2 == r0.getTopEnd()) goto L22;
        if (r2 == r0.getCenterStart()) goto L22;
        if (r2 == r0.getCenter()) goto L22;
        if (r2 == r0.getCenterEnd()) goto L22;
        if (r2 == r0.getBottomStart()) goto L22;
        if (r2 == r0.getBottomCenter()) goto L22;
        if (r2 == r0.getBottomEnd()) goto L22;
        return false;
    }

    private static final boolean getShouldCache(ContentScale r2) {
        ContentScale.Companion r0 = ContentScale.Companion;
        if (r2 != r0.getFillWidth()) goto L5;
    L18:
        return true;
    L5:
        if (r2 == r0.getFillHeight()) goto L18;
        if (r2 == r0.getFillBounds()) goto L18;
        if (r2 == r0.getFit()) goto L18;
        if (r2 == r0.getCrop()) goto L18;
        if (r2 == r0.getNone()) goto L18;
        if (r2 == r0.getInside()) goto L18;
        return false;
    }

    private static final FiniteAnimationSpec DefaultBoundsTransform$lambda$0(Rect r0, Rect r1) {
        return DefaultSpring;
    }

    private static final ScaleToBoundsImpl ScaleToBoundsCached(ContentScale r5, Alignment r6) {
        if (getShouldCache(r5) == false) goto L15;
        if (getShouldCache(r6) == false) goto L15;
        MutableScatterMap<ContentScale, MutableScatterMap<Alignment, ScaleToBoundsImpl>> r0 = cachedScaleToBoundsImplMap;
        MutableScatterMap<Alignment, ScaleToBoundsImpl> r1 = r0.get(r5);
        if (r1 != null) goto L9;
        r1 = new MutableScatterMap(0, 1, null);
        r0.set(r5, r1);
    L9:
        MutableScatterMap<Alignment, ScaleToBoundsImpl> r2 = r1;
        ScaleToBoundsImpl r3 = r2.get(r6);
        if (r3 != null) goto L13;
        r3 = new ScaleToBoundsImpl(r5, r6);
        r2.set(r6, r3);
    L13:
        return r3;
    L15:
        return new ScaleToBoundsImpl(r5, r6);
    }

    public static final /* synthetic */ ScaleToBoundsImpl access$ScaleToBoundsCached(ContentScale r0, Alignment r1) {
        return ScaleToBoundsCached(r0, r1);
    }

    public static final void SharedTransitionScope(final Function4<? super SharedTransitionScope, ? super Modifier, ? super Composer, ? super Integer, Unit> r5, Composer r6, final int r7) {
        Composer r8 = r6.startRestartGroup(1908320054);
        if ((r7 & 6) == 0) goto L5;
        int r1 = r7;
    L11:
        if ((r1 & 3) == 2) goto L13;
        boolean r2 = true;
    L15:
        if (r8.shouldExecute(r2, r1 & 1) == true) goto L17;
        r8.skipToGroupEnd();
    L23:
        ScopeUpdateScope r9 = r8.endRestartGroup();
        if (r9 == null) goto L27;
        r9.updateScope(new C01092(r5, r7));
        return;
    L27:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(1908320054, r1, -1, "androidx.compose.animation.SharedTransitionScope (SharedTransitionScope.kt:121)");
    L19:
        LookaheadScopeKt.LookaheadScope(ComposableLambdaKt.rememberComposableLambda(2062852661, true, new C01081(r5), r8, 54), r8, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
        goto L23
    L13:
        r2 = false;
        goto L15
    L5:
        if (r8.changedInstance(r5) == false) goto L7;
        int r3 = 4;
    L8:
        r1 = r3 | r7;
        goto L11
    L7:
        r3 = 2;
        goto L8
    }

    public static final void SharedTransitionLayout(final Modifier r6, final Function3<? super SharedTransitionScope, ? super Composer, ? super Integer, Unit> r7, Composer r8, final int r9, final int r10) {
        Composer r11 = r8.startRestartGroup(646379026);
        int r1 = r10 & 1;
        if (r1 == 0) goto L6;
        int r2 = r9 | 6;
    L14:
        if ((r10 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L24:
        if ((r2 & 19) == 18) goto L26;
        boolean r3 = true;
    L28:
        if (r11.shouldExecute(r3, r2 & 1) == false) goto L37;
        if (r1 == 0) goto L32;
        r6 = Modifier.Companion;
    L32:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(646379026, r2, -1, "androidx.compose.animation.SharedTransitionLayout (SharedTransitionScope.kt:98)");
    L34:
        SharedTransitionScope(ComposableLambdaKt.rememberComposableLambda(1948801580, true, new AnonymousClass1(r6, r7), r11, 54), r11, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventEnd();
    L38:
        ScopeUpdateScope r12 = r11.endRestartGroup();
        if (r12 == null) goto L42;
        r12.updateScope(new AnonymousClass2(r6, r7, r9, r10));
        return;
    L42:
        return;
    L37:
        r11.skipToGroupEnd();
        goto L38
    L26:
        r3 = false;
        goto L28
    L17:
        if ((r9 & 48) != 0) goto L24;
        if (r11.changedInstance(r7) == false) goto L21;
        int r4 = 32;
    L22:
        r2 = r2 | r4;
        goto L24
    L21:
        r4 = 16;
        goto L22
    L6:
        if ((r9 & 6) == 0) goto L8;
        r2 = r9;
        goto L14
    L8:
        if (r11.changed(r6) == false) goto L10;
        int r5 = 4;
    L11:
        r2 = r5 | r9;
        goto L14
    L10:
        r5 = 2;
        goto L11
    }
}
