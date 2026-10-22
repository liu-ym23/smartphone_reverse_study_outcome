package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.compose.animation.core.Transition;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u0085\u00012\u00020\u00012\u00020\u0002:\u0004\u0085\u0001\u0086\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0016H\u0016J>\u0010\u0017\u001a\u00020\u0016*\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0\u001dH\u0016JD\u0010!\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020+H\u0016J\\\u0010,\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u0010&\u001a\u00020'2\u0006\u00101\u001a\u0002022\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020+H\u0016JD\u00103\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u00104\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020+H\u0016JS\u00105\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u00104\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020+H\u0000¢\u0006\u0002\b6J\u0010\u00107\u001a\u00020+2\u0006\u00108\u001a\u000209H\u0016J\u0015\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020<H\u0017¢\u0006\u0002\u0010=J\b\u0010@\u001a\u00020?H\u0002Jp\u0010B\u001a\u00020\u0016\"\u0004\b\u0000\u0010C*\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u0002HC\u0018\u00010E2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u000b0A2\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020+H\u0002JM\u0010G\u001a\u00020H2\u0006\u0010!\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010(\u001a\u00020)2\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010LJ\u0010\u0010]\u001a\u00020I2\u0006\u0010;\u001a\u00020<H\u0002J\u0015\u0010^\u001a\u00020?2\u0006\u0010_\u001a\u00020`H\u0000¢\u0006\u0002\baJ\u0015\u0010b\u001a\u00020?2\u0006\u0010c\u001a\u00020HH\u0000¢\u0006\u0002\bdJ\u0015\u0010e\u001a\u00020?2\u0006\u0010c\u001a\u00020HH\u0000¢\u0006\u0002\bfJ\u0015\u0010g\u001a\u00020?2\u0006\u0010h\u001a\u00020ZH\u0000¢\u0006\u0002\biJ\u0015\u0010j\u001a\u00020?2\u0006\u0010h\u001a\u00020ZH\u0000¢\u0006\u0002\bkJ\r\u0010l\u001a\u00020?H\u0000¢\u0006\u0002\bmJ\b\u0010r\u001a\u00020?H\u0002J7\u0010s\u001a\u00020?2\u0006\u0010_\u001a\u00020I2\u0012\u0010t\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020?0A2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020?0\u0019H\u0000¢\u0006\u0002\bvJ\u0015\u0010w\u001a\u00020?2\u0006\u0010_\u001a\u00020<H\u0000¢\u0006\u0002\bxJ,\u0010y\u001a\u00020z*\u00020N2\u0006\u0010{\u001a\u00020N2\u0006\u0010|\u001a\u00020z2\u0006\u0010}\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b~\u0010\u007fJ\u000e\u0010\u0080\u0001\u001a\u00020N*\u00020NH\u0096\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR+\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0011\u0010\u0012R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020?0AX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010M\u001a\u00020NX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020N8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bT\u0010PR\u001c\u0010U\u001a\u0004\u0018\u00010NX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010P\"\u0004\bW\u0010RR\u0014\u0010X\u001a\b\u0012\u0004\u0012\u00020Z0YX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020I0\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010n\u001a\u00020o8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bp\u0010qR\u001a\u0010\u0081\u0001\u001a\u00020N*\u00030\u0082\u0001X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001¨\u0006\u0087\u0001"}, d2 = {"Landroidx/compose/animation/SharedTransitionScopeImpl;", "Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/ui/layout/LookaheadScope;", "lookaheadScope", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroidx/compose/ui/layout/LookaheadScope;Lkotlinx/coroutines/CoroutineScope;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "value", "", "disposed", "getDisposed$animation", "()Z", "<set-?>", "isTransitionActive", "setTransitionActive", "(Z)V", "isTransitionActive$delegate", "Landroidx/compose/runtime/MutableState;", "skipToLookaheadSize", "Landroidx/compose/ui/Modifier;", "renderInSharedTransitionScopeOverlay", "renderInOverlay", "Lkotlin/Function0;", "zIndexInOverlay", "", "clipInOverlayDuringTransition", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "sharedElement", "sharedContentState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "animatedVisibilityScope", "Landroidx/compose/animation/AnimatedVisibilityScope;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "placeHolderSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "renderInOverlayDuringTransition", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "sharedBounds", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "resizeMode", "Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "sharedElementWithCallerManagedVisibility", "visible", "sharedBoundsWithCallerManagedVisibility", "sharedBoundsWithCallerManagedVisibility$animation", "OverlayClip", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "rememberSharedContentState", "key", "", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "observeAnimatingBlock", "", "updateTransitionActiveness", "Lkotlin/Function1;", "sharedBoundsImpl", "T", "parentTransition", "Landroidx/compose/animation/core/Transition;", "renderOnlyWhenVisible", "rememberSharedElementState", "Landroidx/compose/animation/SharedElementInternalState;", "Landroidx/compose/animation/SharedElement;", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsAnimation;Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;ZLandroidx/compose/animation/SharedTransitionScope$SharedContentState;Landroidx/compose/animation/SharedTransitionScope$OverlayClip;FZLandroidx/compose/runtime/Composer;I)Landroidx/compose/animation/SharedElementInternalState;", "root", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getRoot$animation", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setRoot$animation", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "lookaheadRoot", "getLookaheadRoot$animation", "nullableLookaheadRoot", "getNullableLookaheadRoot$animation", "setNullableLookaheadRoot$animation", "renderers", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/LayerRenderer;", "sharedElements", "Landroidx/collection/MutableScatterMap;", "sharedElementsFor", "drawInOverlay", "scope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawInOverlay$animation", "onStateRemoved", "sharedElementState", "onStateRemoved$animation", "onStateAdded", "onStateAdded$animation", "onLayerRendererCreated", "renderer", "onLayerRendererCreated$animation", "onLayerRendererRemoved", "onLayerRendererRemoved$animation", "onDispose", "onDispose$animation", "observerForTest", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "getObserverForTest$animation", "()Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "observeIsAnimating", "observeReads", "onValueChangedForScope", "block", "observeReads$animation", "clearObservation", "clearObservation$animation", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "sourceCoordinates", "relativeToSource", "includeMotionFrameOfReference", "localLookaheadPositionOf-au-aQtc", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "toLookaheadCoordinates", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "Companion", "ShapeBasedClip", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SharedTransitionScopeImpl implements SharedTransitionScope, LookaheadScope {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Lazy<SnapshotStateObserver> SharedTransitionObserver$delegate = null;
    private final /* synthetic */ LookaheadScope $$delegate_0;
    private final CoroutineScope coroutineScope;
    private boolean disposed;
    private final MutableState isTransitionActive$delegate;
    private LayoutCoordinates nullableLookaheadRoot;
    private final Function0<Unit> observeAnimatingBlock;
    private final SnapshotStateList<LayerRenderer> renderers;
    public LayoutCoordinates root;
    private final MutableScatterMap<Object, SharedElement> sharedElements;
    private final Function1<SharedTransitionScope, Unit> updateTransitionActiveness;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/animation/SharedTransitionScopeImpl$Companion;", "", "<init>", "()V", "SharedTransitionObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "getSharedTransitionObserver", "()Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SharedTransitionObserver$delegate", "Lkotlin/Lazy;", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final SnapshotStateObserver getSharedTransitionObserver() {
            return (SnapshotStateObserver) SharedTransitionScopeImpl.access$getSharedTransitionObserver$delegate$cp().getValue();
        }

        public static final /* synthetic */ SnapshotStateObserver access$getSharedTransitionObserver(Companion r0) {
            return r0.getSharedTransitionObserver();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/animation/SharedTransitionScopeImpl$ShapeBasedClip;", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(Landroidx/compose/ui/graphics/Shape;)V", "getClipShape", "()Landroidx/compose/ui/graphics/Shape;", "path", "Landroidx/compose/ui/graphics/Path;", "getClipPath", "sharedContentState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ShapeBasedClip implements SharedTransitionScope.OverlayClip {
        private final Shape clipShape;
        private final Path path;

        public final Shape getClipShape() {
            return this.clipShape;
        }

        public ShapeBasedClip(Shape r1) {
            this.clipShape = r1;
            this.path = AndroidPath_androidKt.Path();
        }

        @Override // androidx.compose.animation.SharedTransitionScope.OverlayClip
        public Path getClipPath(SharedTransitionScope.SharedContentState r4, Rect r5, LayoutDirection r6, Density r7) {
            this.path.reset();
            OutlineKt.addOutline(this.path, this.clipShape.createOutline-Pq9zytI(r5.getSize-NH-jbRc(), r6, r7));
            this.path.translate-k-4lQ0M(r5.getTopLeft-F1C5BW0());
            return this.path;
        }
    }

    public LayoutCoordinates getLookaheadScopeCoordinates(Placeable.PlacementScope r2) {
        return this.$$delegate_0.getLookaheadScopeCoordinates(r2);
    }

    /* JADX INFO: renamed from: localLookaheadPositionOf-au-aQtc, reason: not valid java name */
    public long m204localLookaheadPositionOfauaQtc(LayoutCoordinates r7, LayoutCoordinates r8, long r9, boolean r11) {
        return this.$$delegate_0.localLookaheadPositionOf-au-aQtc(r7, r8, r9, r11);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public final /* synthetic */ EnterTransition scaleInSharedContentToBounds(ContentScale r1, Alignment r2) {
        return SharedTransitionScope.CC.$default$scaleInSharedContentToBounds(this, r1, r2);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public final /* synthetic */ ExitTransition scaleOutSharedContentToBounds(ContentScale r1, Alignment r2) {
        return SharedTransitionScope.CC.$default$scaleOutSharedContentToBounds(this, r1, r2);
    }

    public LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates r2) {
        return this.$$delegate_0.toLookaheadCoordinates(r2);
    }

    static {
        Companion = new Companion(null);
        SharedTransitionObserver$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, SharedTransitionScopeImpl$Companion$SharedTransitionObserver$2.INSTANCE);
    }

    private final void observeIsAnimating() {
        if (this.disposed == true) goto L6;
        Companion.access$getSharedTransitionObserver(Companion).observeReads(this, this.updateTransitionActiveness, this.observeAnimatingBlock);
        return;
    }

    private final void updateTransitionActiveness() {
        MutableScatterMap<Object, SharedElement> r1 = this.sharedElements;
        Object[] r2 = r1.keys;
        Object[] r3 = r1.values;
        long[] r4 = r1.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L21;
        int r15 = 0;
    L5:
        long r13 = r4[r15];
        if (((((~r13) << 7) & r13) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r6 = 8 - ((~(r15 - r5)) >>> 31);
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L18;
        if ((r13 & 255) >= 128) goto L12;
        boolean r18 = true;
    L13:
        if (r18 == false) goto L17;
        int r19 = (r15 << 3) + r7;
        Object r110 = r2[r19];
        if (((SharedElement) r3[r19]).isAnimating() == false) goto L17;
        boolean r8 = true;
    L23:
        if (r8 == isTransitionActive()) goto L43;
        setTransitionActive(r8);
        if (r8 == true) goto L43;
        MutableScatterMap<Object, SharedElement> r9 = this.sharedElements;
        Object[] r10 = r9.keys;
        Object[] r11 = r9.values;
        long[] r12 = r9.metadata;
        int r14 = r12.length - 2;
        if (r14 < 0) goto L43;
        int r16 = 0;
    L29:
        long r17 = r12[r16];
        if (((((~r17) << 7) & r17) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L41;
        int r20 = 8 - ((~(r16 - r14)) >>> 31);
        int r21 = 0;
    L32:
        if (r21 >= r20) goto L40;
        if ((r17 & 255) >= 128) goto L36;
        boolean r22 = true;
    L37:
        if (r22 == false) goto L39;
        int r23 = (r16 << 3) + r21;
        Object r111 = r10[r23];
        ((SharedElement) r11[r23]).onSharedTransitionFinished();
    L39:
        r17 = r17 >> 8;
        r21 = r21 + 1;
        goto L32
    L36:
        r22 = false;
        goto L37
    L40:
        if (r20 != 8) goto L43;
    L41:
        if (r16 == r14) goto L43;
        r16 = r16 + 1;
    L43:
        MutableScatterMap<Object, SharedElement> r24 = this.sharedElements;
        Object[] r25 = r24.keys;
        Object[] r26 = r24.values;
        long[] r27 = r24.metadata;
        int r28 = r27.length - 2;
        if (r28 < 0) goto L63;
        int r29 = 0;
    L46:
        long r30 = r27[r29];
        if (((((~r30) << 7) & r30) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L61;
        int r31 = 8 - ((~(r29 - r28)) >>> 31);
        int r112 = 0;
    L49:
        if (r112 >= r31) goto L58;
        if ((r30 & 255) >= 128) goto L53;
        boolean r113 = true;
    L54:
        if (r113 == false) goto L56;
        int r114 = (r29 << 3) + r112;
        Object r115 = r25[r114];
        ((SharedElement) r26[r114]).updateMatch();
    L56:
        r30 = r30 >> 8;
        r112 = r112 + 1;
        goto L49
    L53:
        r113 = false;
        goto L54
    L58:
        if (r31 != 8) goto L63;
    L61:
        if (r29 == r28) goto L63;
        r29 = r29 + 1;
    L63:
        observeIsAnimating();
        return;
    L17:
        r13 = r13 >> 8;
        r7 = r7 + 1;
        goto L8
    L12:
        r18 = false;
        goto L13
    L18:
        if (r6 != 8) goto L21;
    L19:
        if (r15 == r5) goto L21;
        r15 = r15 + 1;
    L21:
        r8 = false;
        goto L23
    }

    public final LayoutCoordinates getLookaheadRoot$animation() {
        LayoutCoordinates r0 = this.nullableLookaheadRoot;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Error: Uninitialized LayoutCoordinates. Please make sure when using the SharedTransitionScope composable function, the modifier passed to the child content is being used, or use SharedTransitionLayout instead.".toString());
    }

    public final SnapshotStateObserver getObserverForTest$animation() {
        return Companion.access$getSharedTransitionObserver(Companion);
    }

    public final LayoutCoordinates getRoot$animation() {
        LayoutCoordinates r0 = this.root;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("root");
        return null;
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public boolean isTransitionActive() {
        return ((Boolean) this.isTransitionActive$delegate.getValue()).booleanValue();
    }

    public final void onDispose$animation() {
        Companion.access$getSharedTransitionObserver(Companion).clear(this);
        this.disposed = true;
    }

    public static final /* synthetic */ Lazy access$getSharedTransitionObserver$delegate$cp() {
        return SharedTransitionObserver$delegate;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final boolean getDisposed$animation() {
        return this.disposed;
    }

    public final LayoutCoordinates getNullableLookaheadRoot$animation() {
        return this.nullableLookaheadRoot;
    }

    public static final /* synthetic */ MutableScatterMap access$getSharedElements$p(SharedTransitionScopeImpl r0) {
        return r0.sharedElements;
    }

    public static final /* synthetic */ void access$updateTransitionActiveness(SharedTransitionScopeImpl r0) {
        r0.updateTransitionActiveness();
    }

    private void setTransitionActive(boolean r2) {
        this.isTransitionActive$delegate.setValue(Boolean.valueOf(r2));
    }

    private final SharedElement sharedElementsFor(Object r3) {
        SharedElement r0 = this.sharedElements.get(r3);
        if (r0 != null) goto L6;
        SharedElement r1 = new SharedElement(r3, this);
        this.sharedElements.set(r3, r1);
        return r1;
    L6:
        return r0;
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public SharedTransitionScope.OverlayClip OverlayClip(Shape r2) {
        return new ShapeBasedClip(r2);
    }

    public final void clearObservation$animation(Object r2) {
        Companion.access$getSharedTransitionObserver(Companion).clear(r2);
    }

    public final void drawInOverlay$animation(ContentDrawScope r5) {
        SnapshotStateList<LayerRenderer> r0 = this.renderers;
        if (r0.size() <= 1) goto L5;
        CollectionsKt.sortWith(r0, new SharedTransitionScopeImpl$drawInOverlay$$inlined$sortBy$1());
    L5:
        SnapshotStateList<LayerRenderer> r1 = this.renderers;
        int r2 = r1.size();
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        ((LayerRenderer) ListProtector.get(r1, r3)).drawInOverlay(r5);
        r3 = r3 + 1;
        goto L6
    }

    public final void onLayerRendererCreated$animation(LayerRenderer r2) {
        this.renderers.add(r2);
    }

    public final void onLayerRendererRemoved$animation(LayerRenderer r2) {
        this.renderers.remove(r2);
    }

    public final void onStateAdded$animation(SharedElementInternalState r7) {
        SharedElement r0 = r7.getSharedElement();
        r0.addState(r7);
        this.updateTransitionActiveness.invoke(this);
        r0.getScope().observeIsAnimating();
        Iterator r1 = this.renderers.iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L15;
        LayerRenderer r3 = (LayerRenderer) r1.next();
        SharedElement r5 = null;
        if ((r3 instanceof SharedElementInternalState) == false) goto L8;
        SharedElementInternalState r4 = (SharedElementInternalState) r3;
    L9:
        if (r4 == null) goto L12;
        r5 = r4.getSharedElement();
    L12:
        if (Intrinsics.areEqual(r5, r7.getSharedElement()) == true) goto L17;
        r2 = r2 + 1;
    L17:
        if (r2 == (this.renderers.size() - 1)) goto L21;
        if (r2 == (-1)) goto L21;
        this.renderers.add(r2 + 1, r7);
        return;
    L21:
        this.renderers.add(r7);
        return;
    L8:
        r4 = null;
        goto L9
    L15:
        r2 = -1;
        goto L17
    }

    public final void onStateRemoved$animation(SharedElementInternalState r8) {
        SharedElement r0 = r8.getSharedElement();
        r0.removeState(r8);
        this.updateTransitionActiveness.invoke(this);
        r0.getScope().observeIsAnimating();
        this.renderers.remove(r8);
        if (r0.getStates().isEmpty() == false) goto L6;
        BuildersKt.launch$default(r0.getScope().coroutineScope, null, null, new SharedTransitionScopeImpl$onStateRemoved$1$1(r0, null), 3, null);
        return;
    }

    public final void setNullableLookaheadRoot$animation(LayoutCoordinates r1) {
        this.nullableLookaheadRoot = r1;
    }

    public final void setRoot$animation(LayoutCoordinates r1) {
        this.root = r1;
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier skipToLookaheadSize(Modifier r4) {
        ScaleToBoundsImpl r1 = null;
        return r4.then(new SkipToLookaheadElement(r1, r1, 3, r1));
    }

    public SharedTransitionScopeImpl(LookaheadScope r3, CoroutineScope r4) {
        this.$$delegate_0 = r3;
        this.coroutineScope = r4;
        this.isTransitionActive$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.observeAnimatingBlock = new SharedTransitionScopeImpl$observeAnimatingBlock$1(this);
        this.updateTransitionActiveness = new C01071(this);
        this.renderers = SnapshotStateKt.mutableStateListOf();
        int r5 = 0;
        int r1 = 1;
        this.sharedElements = new MutableScatterMap(r5, r1, null);
    }

    public static final /* synthetic */ SharedElement access$sharedElementsFor(SharedTransitionScopeImpl r0, Object r1) {
        return r0.sharedElementsFor(r1);
    }

    public final void observeReads$animation(SharedElement r2, Function1<? super SharedElement, Unit> r3, Function0<Unit> r4) {
        if (this.disposed == true) goto L6;
        Companion.access$getSharedTransitionObserver(Companion).observeReads(r2, r3, r4);
        return;
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public SharedTransitionScope.SharedContentState rememberSharedContentState(Object r4, Composer r5, int r6) {
        r5.startReplaceGroup(799702514);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(799702514, r6, -1, "androidx.compose.animation.SharedTransitionScopeImpl.rememberSharedContentState (SharedTransitionScope.kt:874)");
    L5:
        boolean r7 = r5.changed(r4);
        Object r0 = r5.rememberedValue();
        if (r7 == false) goto L8;
    L9:
        r0 = new SharedTransitionScope.SharedContentState(r4);
        r5.updateRememberedValue(r0);
    L10:
        SharedTransitionScope.SharedContentState r1 = (SharedTransitionScope.SharedContentState) r0;
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        r5.endReplaceGroup();
        return r1;
    L8:
        if (r0 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier renderInSharedTransitionScopeOverlay(Modifier r2, Function0<Boolean> r3, float r4, Function2<? super LayoutDirection, ? super Density, ? extends Path> r5) {
        return r2.then(new RenderInTransitionOverlayNodeElement(this, r3, r4, r5));
    }

    public final Modifier sharedBoundsWithCallerManagedVisibility$animation(Modifier r12, SharedTransitionScope.SharedContentState r13, final boolean r14, BoundsTransform r15, SharedTransitionScope.PlaceHolderSize r16, boolean r17, float r18, SharedTransitionScope.OverlayClip r19) {
        return sharedBoundsImpl(r12, r13, null, new SharedTransitionScopeImpl$sharedBoundsWithCallerManagedVisibility$1(r14), r15, r16, false, r17, r18, r19);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier sharedElement(Modifier r12, SharedTransitionScope.SharedContentState r13, AnimatedVisibilityScope r14, BoundsTransform r15, SharedTransitionScope.PlaceHolderSize r16, boolean r17, float r18, SharedTransitionScope.OverlayClip r19) {
        return sharedBoundsImpl(r12, r13, r14.getTransition(), C01051.INSTANCE, r15, r16, true, r17, r18, r19);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier sharedElementWithCallerManagedVisibility(Modifier r12, SharedTransitionScope.SharedContentState r13, final boolean r14, BoundsTransform r15, SharedTransitionScope.PlaceHolderSize r16, boolean r17, float r18, SharedTransitionScope.OverlayClip r19) {
        return sharedBoundsImpl(r12, r13, null, new C01061(r14), r15, r16, true, r17, r18, r19);
    }

    private final SharedElementInternalState rememberSharedElementState(SharedElement r12, BoundsAnimation r13, SharedTransitionScope.PlaceHolderSize r14, boolean r15, SharedTransitionScope.SharedContentState r16, SharedTransitionScope.OverlayClip r17, float r18, boolean r19, Composer r20, int r21) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(2066772852, r21, -1, "androidx.compose.animation.SharedTransitionScopeImpl.rememberSharedElementState (SharedTransitionScope.kt:992)");
    L5:
        Object r0 = r20.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L8;
        SharedElementInternalState r10 = new SharedElementInternalState(r12, r13, r14, r15, r17, r19, r16, r18);
        r20.updateRememberedValue(r10);
        r0 = r10;
    L8:
        SharedElementInternalState r1 = (SharedElementInternalState) r0;
        r16.setInternalState$animation(r1);
        r1.setSharedElement(r12);
        r1.setRenderOnlyWhenVisible(r15);
        r1.setBoundsAnimation(r13);
        r1.setPlaceHolderSize(r14);
        r1.setOverlayClip(r17);
        r1.setZIndex(r18);
        r1.setRenderInOverlayDuringTransition(r19);
        r1.setUserState(r16);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        return r1;
    }

    private final <T> Modifier sharedBoundsImpl(Modifier r13, final SharedTransitionScope.SharedContentState r14, final Transition<T> r15, final Function1<? super T, Boolean> r16, final BoundsTransform r17, final SharedTransitionScope.PlaceHolderSize r18, final boolean r19, final boolean r20, final float r21, final SharedTransitionScope.OverlayClip r22) {
        return ComposedModifierKt.composed$default(r13, null, new C01041(r14, r15, r16, this, r18, r19, r22, r21, r20, r17), 1, null);
    }

    public static final /* synthetic */ SharedElementInternalState access$rememberSharedElementState(SharedTransitionScopeImpl r0, SharedElement r1, BoundsAnimation r2, SharedTransitionScope.PlaceHolderSize r3, boolean r4, SharedTransitionScope.SharedContentState r5, SharedTransitionScope.OverlayClip r6, float r7, boolean r8, Composer r9, int r10) {
        return r0.rememberSharedElementState(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Modifier sharedBoundsWithCallerManagedVisibility$animation$default(SharedTransitionScopeImpl r10, Modifier r11, SharedTransitionScope.SharedContentState r12, boolean r13, BoundsTransform r14, SharedTransitionScope.PlaceHolderSize r15, boolean r16, float r17, SharedTransitionScope.OverlayClip r18, int r19, Object r20) {
        if ((r19 & 4) == 0) goto L5;
        BoundsTransform r5 = SharedTransitionScopeKt.access$getDefaultBoundsTransform$p();
    L7:
        if ((r19 & 8) == 0) goto L9;
        SharedTransitionScope.PlaceHolderSize r6 = SharedTransitionScope.PlaceHolderSize.Companion.getContentSize();
    L11:
        if ((r19 & 16) == 0) goto L13;
        boolean r7 = true;
    L15:
        if ((r19 & 32) == 0) goto L17;
        float r8 = MenuKt.ClosedAlphaTarget;
    L19:
        if ((r19 & 64) == 0) goto L21;
        SharedTransitionScope.OverlayClip r9 = SharedTransitionScopeKt.access$getParentClip$p();
    L23:
        return r10.sharedBoundsWithCallerManagedVisibility$animation(r11, r12, r13, r5, r6, r7, r8, r9);
    L21:
        r9 = r18;
        goto L23
    L17:
        r8 = r17;
        goto L19
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public Modifier sharedBounds(Modifier r12, final SharedTransitionScope.SharedContentState r13, final AnimatedVisibilityScope r14, final EnterTransition r15, final ExitTransition r16, BoundsTransform r17, final SharedTransitionScope.ResizeMode r18, SharedTransitionScope.PlaceHolderSize r19, boolean r20, float r21, SharedTransitionScope.OverlayClip r22) {
        return ComposedModifierKt.composed$default(sharedBoundsImpl(r12, r13, r14.getTransition(), AnonymousClass1.INSTANCE, r17, r19, false, r20, r21, r22), null, new AnonymousClass2(r14, r15, r16, r13, r18), 1, null);
    }

    public static /* synthetic */ Modifier sharedBoundsImpl$default(SharedTransitionScopeImpl r12, Modifier r13, SharedTransitionScope.SharedContentState r14, Transition r15, Function1 r16, BoundsTransform r17, SharedTransitionScope.PlaceHolderSize r18, boolean r19, boolean r20, float r21, SharedTransitionScope.OverlayClip r22, int r23, Object r24) {
        if ((r23 & 16) == 0) goto L5;
        SharedTransitionScope.PlaceHolderSize r7 = SharedTransitionScope.PlaceHolderSize.Companion.getContentSize();
    L7:
        return r12.sharedBoundsImpl(r13, r14, r15, r16, r17, r7, r19, r20, r21, r22);
    L5:
        r7 = r18;
        goto L7
    }
}
