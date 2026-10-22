package androidx.compose.foundation;

import android.view.View;
import androidx.collection.SieveCacheKt;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u009b\u0001\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u0012\u001b\b\u0002\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u008f\u0001\u0010S\u001a\u00020\u000e2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0019\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00122\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\bT\u0010UJ\b\u0010V\u001a\u00020\u000eH\u0016J\b\u0010W\u001a\u00020\u000eH\u0016J\b\u0010X\u001a\u00020\u000eH\u0016J\b\u0010Y\u001a\u00020\u000eH\u0002J\b\u0010Z\u001a\u00020\u000eH\u0002J\b\u0010[\u001a\u00020\u000eH\u0002J\f\u0010\\\u001a\u00020\u000e*\u00020]H\u0016J\u0010\u0010^\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020BH\u0016J\f\u0010`\u001a\u00020\u000e*\u00020aH\u0016R+\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR-\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u0013\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b1\u0010%\"\u0004\b2\u0010'R\u001c\u0010\u0016\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b4\u0010%\"\u0004\b5\u0010'R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010)\"\u0004\b7\u0010+R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010C\u001a\u0004\u0018\u00010B2\b\u0010A\u001a\u0004\u0018\u00010B8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0016\u0010J\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010L\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010-R\u0010\u0010N\u001a\u00020\tX\u0082\u000e¢\u0006\u0004\n\u0002\u00100R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Landroidx/compose/foundation/MagnifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "useTextDefault", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSourceCenter", "()Lkotlin/jvm/functions/Function1;", "setSourceCenter", "(Lkotlin/jvm/functions/Function1;)V", "getMagnifierCenter", "setMagnifierCenter", "getOnSizeChanged", "setOnSizeChanged", "getZoom", "()F", "setZoom", "(F)V", "getUseTextDefault", "()Z", "setUseTextDefault", "(Z)V", "getSize-MYxV2XQ", "()J", "setSize-EaSLcWc", "(J)V", "J", "getCornerRadius-D9Ej5fM", "setCornerRadius-0680j_4", "F", "getElevation-D9Ej5fM", "setElevation-0680j_4", "getClippingEnabled", "setClippingEnabled", "getPlatformMagnifierFactory", "()Landroidx/compose/foundation/PlatformMagnifierFactory;", "setPlatformMagnifierFactory", "(Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "view", "Landroid/view/View;", "density", "magnifier", "Landroidx/compose/foundation/PlatformMagnifier;", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutCoordinates", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "layoutCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "anchorPositionInRootState", "Landroidx/compose/runtime/State;", "anchorPositionInRoot", "getAnchorPositionInRoot-F1C5BW0", "sourceCenterInRoot", "previousSize", "Landroidx/compose/ui/unit/IntSize;", "drawSignalChannel", "Lkotlinx/coroutines/channels/Channel;", "update", "update-5F03MCQ", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "onAttach", "onDetach", "onObservedReadsChanged", "recreateMagnifier", "updateMagnifier", "updateSizeIfNecessary", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "onGloballyPositioned", "coordinates", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MagnifierNode extends Modifier.Node implements GlobalPositionAwareModifierNode, DrawModifierNode, SemanticsModifierNode, ObserverModifierNode {
    public static final int $stable = 8;
    private State<Offset> anchorPositionInRootState;
    private boolean clippingEnabled;
    private float cornerRadius;
    private Density density;
    private Channel<Unit> drawSignalChannel;
    private float elevation;
    private final MutableState layoutCoordinates$delegate;
    private PlatformMagnifier magnifier;
    private Function1<? super Density, Offset> magnifierCenter;
    private Function1<? super DpSize, Unit> onSizeChanged;
    private PlatformMagnifierFactory platformMagnifierFactory;
    private IntSize previousSize;
    private long size;
    private Function1<? super Density, Offset> sourceCenter;
    private long sourceCenterInRoot;
    private boolean useTextDefault;
    private View view;
    private float zoom;

    /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierNode$onAttach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.MagnifierNode$onAttach$1", f = "Magnifier.android.kt", i = {}, l = {382, 386}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MagnifierNode this$0;

        public AnonymousClass1(MagnifierNode r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public static /* synthetic */ Unit a(long r0) {
            return invokeSuspend$lambda$0(r0);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        private static final Unit invokeSuspend$lambda$0(long r0) {
            return Unit.INSTANCE;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x003b -> B:11:0x0024). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0048 -> B:21:0x004b). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r5);
            AnonymousClass1 r6 = this;
        L21:
            PlatformMagnifier r2 = MagnifierNode.access$getMagnifier$p(r6.this$0);
            if (r2 != null) goto L23;
        L11:
            Channel r3 = MagnifierNode.access$getDrawSignalChannel$p(r6.this$0);
            if (r3 == null) goto L17;
            r6.label = 1;
            if (r3.receive(r6) != r0) goto L17;
            return r0;
        L17:
            if (MagnifierNode.access$getMagnifier$p(r6.this$0) == null) goto L11;
            Function1 r4 = new v0();
            r6.label = 2;
            if (MonotonicFrameClockKt.withFrameMillis(r4, r6) != r0) goto L21;
            return r0;
        L23:
            r2.updateContent();
            goto L11
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
            r6 = this;
            goto L17
        L10:
            ResultKt.throwOnFailure(r5);
            r6 = this;
            goto L11
        }
    }

    public /* synthetic */ MagnifierNode(Function1 r1, Function1 r2, Function1 r3, float r4, boolean r5, long r6, float r8, float r9, boolean r10, PlatformMagnifierFactory r11, DefaultConstructorMarker r12) {
        this(r1, r2, r3, r4, r5, r6, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit a(MagnifierNode r0) {
        return onObservedReadsChanged$lambda$1(r0);
    }

    public static /* synthetic */ Offset b(MagnifierNode r0) {
        return applySemantics$lambda$8(r0);
    }

    public static /* synthetic */ Offset c(MagnifierNode r0) {
        return getAnchorPositionInRoot_F1C5BW0$lambda$0(r0);
    }

    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldClearDescendantSemantics(this);
    }

    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldMergeDescendantSemantics(this);
    }

    public final /* synthetic */ boolean isImportantForBounds() {
        return SemanticsModifierNode.-CC.$default$isImportantForBounds(this);
    }

    public final /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.-CC.$default$onMeasureResultChanged(this);
    }

    /* JADX INFO: renamed from: getAnchorPositionInRoot-F1C5BW0, reason: not valid java name */
    private final long m414getAnchorPositionInRootF1C5BW0() {
        if (this.anchorPositionInRootState != null) goto L5;
        this.anchorPositionInRootState = SnapshotStateKt.derivedStateOf(new u0(this));
    L5:
        State<Offset> r0 = this.anchorPositionInRootState;
        if (r0 == null) goto L9;
        return ((Offset) r0.getValue()).unbox-impl();
    L9:
        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    private final LayoutCoordinates getLayoutCoordinates() {
        return (LayoutCoordinates) this.layoutCoordinates$delegate.getValue();
    }

    private final void recreateMagnifier() {
        PlatformMagnifier r0 = this.magnifier;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        View r1 = this.view;
        if (r1 != null) goto L8;
        r1 = DelegatableNode_androidKt.requireView(this);
    L8:
        View r2 = r1;
        this.view = r2;
        Density r3 = this.density;
        if (r3 != null) goto L11;
        r3 = DelegatableNodeKt.requireDensity(this);
    L11:
        Density r9 = r3;
        this.density = r9;
        this.magnifier = this.platformMagnifierFactory.mo449createnHHXs2Y(r2, this.useTextDefault, this.size, this.cornerRadius, this.elevation, this.clippingEnabled, r9, this.zoom);
        updateSizeIfNecessary();
    }

    private final void updateMagnifier() {
        Density r0 = this.density;
        if (r0 != null) goto L5;
        r0 = DelegatableNodeKt.requireDensity(this);
        this.density = r0;
    L5:
        long r1 = ((Offset) this.sourceCenter.invoke(r0)).unbox-impl();
        boolean r7 = true;
        if ((r1 & SieveCacheKt.InvalidMapping) == 9205357640488583168L) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == true) goto L11;
    L35:
        this.sourceCenterInRoot = Offset.Companion.getUnspecified-F1C5BW0();
        PlatformMagnifier r2 = this.magnifier;
        if (r2 == null) goto L39;
        r2.dismiss();
        return;
    L39:
        return;
    L11:
        if ((m414getAnchorPositionInRootF1C5BW0() & SieveCacheKt.InvalidMapping) == 9205357640488583168L) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L35;
        this.sourceCenterInRoot = Offset.plus-MK-Hz9U(m414getAnchorPositionInRootF1C5BW0(), r1);
        Function1<? super Density, Offset> r3 = this.magnifierCenter;
        if (r3 == null) goto L26;
        Offset r4 = Offset.box-impl(((Offset) r3.invoke(r0)).unbox-impl());
        if ((r4.unbox-impl() & SieveCacheKt.InvalidMapping) != 9205357640488583168L) goto L21;
        r7 = false;
    L21:
        if (r7 == true) goto L24;
        r4 = null;
    L24:
        if (r4 == null) goto L26;
        long r8 = r4.unbox-impl();
        long r9 = Offset.plus-MK-Hz9U(m414getAnchorPositionInRootF1C5BW0(), r8);
    L27:
        long r10 = r9;
        if (this.magnifier != null) goto L30;
        recreateMagnifier();
    L30:
        PlatformMagnifier r11 = this.magnifier;
        if (r11 == null) goto L33;
        r11.mo448updateWko1d7g(this.sourceCenterInRoot, r10, this.zoom);
    L33:
        updateSizeIfNecessary();
        return;
    L26:
        r9 = Offset.Companion.getUnspecified-F1C5BW0();
        goto L27
    L13:
        r6 = false;
        goto L14
    L8:
        r5 = false;
        goto L9
    }

    private final void updateSizeIfNecessary() {
        PlatformMagnifier r0 = this.magnifier;
        if (r0 != null) goto L5;
        return;
    L5:
        Density r1 = this.density;
        if (r1 != null) goto L9;
        return;
    L9:
        if (IntSize.equals-impl(r0.mo447getSizeYbymL2g(), this.previousSize) == true) goto L15;
        Function1<? super DpSize, Unit> r2 = this.onSizeChanged;
        if (r2 == null) goto L13;
        r2.invoke(DpSize.box-impl(r1.toDpSize-k-rfVVM(IntSizeKt.toSize-ozmzZPI(r0.mo447getSizeYbymL2g()))));
    L13:
        this.previousSize = IntSize.box-impl(r0.mo447getSizeYbymL2g());
        return;
    }

    public void onDetach() {
        PlatformMagnifier r0 = this.magnifier;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        this.magnifier = null;
    }

    public void onObservedReadsChanged() {
        ObserverModifierNodeKt.observeReads(this, new t0(this));
    }

    public void onAttach() {
        onObservedReadsChanged();
        this.drawSignalChannel = ChannelKt.Channel$default(0, null, null, 7, null);
        BuildersKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this, null), 1, null);
    }

    public final boolean getClippingEnabled() {
        return this.clippingEnabled;
    }

    /* JADX INFO: renamed from: getCornerRadius-D9Ej5fM, reason: not valid java name */
    public final float m415getCornerRadiusD9Ej5fM() {
        return this.cornerRadius;
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m416getElevationD9Ej5fM() {
        return this.elevation;
    }

    public final Function1<Density, Offset> getMagnifierCenter() {
        return this.magnifierCenter;
    }

    public final Function1<DpSize, Unit> getOnSizeChanged() {
        return this.onSizeChanged;
    }

    public final PlatformMagnifierFactory getPlatformMagnifierFactory() {
        return this.platformMagnifierFactory;
    }

    /* JADX INFO: renamed from: getSize-MYxV2XQ, reason: not valid java name */
    public final long m417getSizeMYxV2XQ() {
        return this.size;
    }

    public final Function1<Density, Offset> getSourceCenter() {
        return this.sourceCenter;
    }

    public final boolean getUseTextDefault() {
        return this.useTextDefault;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public static final /* synthetic */ Channel access$getDrawSignalChannel$p(MagnifierNode r0) {
        return r0.drawSignalChannel;
    }

    public static final /* synthetic */ PlatformMagnifier access$getMagnifier$p(MagnifierNode r0) {
        return r0.magnifier;
    }

    private static final Offset applySemantics$lambda$8(MagnifierNode r2) {
        return Offset.box-impl(r2.sourceCenterInRoot);
    }

    private static final Offset getAnchorPositionInRoot_F1C5BW0$lambda$0(MagnifierNode r2) {
        LayoutCoordinates r3 = r2.getLayoutCoordinates();
        if (r3 == null) goto L5;
        long r0 = LayoutCoordinatesKt.positionInRoot(r3);
    L7:
        return Offset.box-impl(r0);
    L5:
        r0 = Offset.Companion.getUnspecified-F1C5BW0();
        goto L7
    }

    private static final Unit onObservedReadsChanged$lambda$1(MagnifierNode r0) {
        r0.updateMagnifier();
        return Unit.INSTANCE;
    }

    private final void setLayoutCoordinates(LayoutCoordinates r2) {
        this.layoutCoordinates$delegate.setValue(r2);
    }

    public void applySemantics(SemanticsPropertyReceiver r3) {
        r3.set(Magnifier_androidKt.getMagnifierPositionInRoot(), new s0(this));
    }

    public void draw(ContentDrawScope r2) {
        r2.drawContent();
        Channel<Unit> r3 = this.drawSignalChannel;
        if (r3 == null) goto L6;
        r3.trySend-JP2dKIU(Unit.INSTANCE);
        return;
    }

    public void onGloballyPositioned(LayoutCoordinates r1) {
        setLayoutCoordinates(r1);
    }

    public final void setClippingEnabled(boolean r1) {
        this.clippingEnabled = r1;
    }

    /* JADX INFO: renamed from: setCornerRadius-0680j_4, reason: not valid java name */
    public final void m418setCornerRadius0680j_4(float r1) {
        this.cornerRadius = r1;
    }

    /* JADX INFO: renamed from: setElevation-0680j_4, reason: not valid java name */
    public final void m419setElevation0680j_4(float r1) {
        this.elevation = r1;
    }

    public final void setMagnifierCenter(Function1<? super Density, Offset> r1) {
        this.magnifierCenter = r1;
    }

    public final void setOnSizeChanged(Function1<? super DpSize, Unit> r1) {
        this.onSizeChanged = r1;
    }

    public final void setPlatformMagnifierFactory(PlatformMagnifierFactory r1) {
        this.platformMagnifierFactory = r1;
    }

    /* JADX INFO: renamed from: setSize-EaSLcWc, reason: not valid java name */
    public final void m420setSizeEaSLcWc(long r1) {
        this.size = r1;
    }

    public final void setSourceCenter(Function1<? super Density, Offset> r1) {
        this.sourceCenter = r1;
    }

    public final void setUseTextDefault(boolean r1) {
        this.useTextDefault = r1;
    }

    public final void setZoom(float r1) {
        this.zoom = r1;
    }

    private MagnifierNode(Function1<? super Density, Offset> r1, Function1<? super Density, Offset> r2, Function1<? super DpSize, Unit> r3, float r4, boolean r5, long r6, float r8, float r9, boolean r10, PlatformMagnifierFactory r11) {
        this.sourceCenter = r1;
        this.magnifierCenter = r2;
        this.onSizeChanged = r3;
        this.zoom = r4;
        this.useTextDefault = r5;
        this.size = r6;
        this.cornerRadius = r8;
        this.elevation = r9;
        this.clippingEnabled = r10;
        this.platformMagnifierFactory = r11;
        this.layoutCoordinates$delegate = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.sourceCenterInRoot = Offset.Companion.getUnspecified-F1C5BW0();
    }

    /* JADX INFO: renamed from: update-5F03MCQ, reason: not valid java name */
    public final void m421update5F03MCQ(Function1<? super Density, Offset> r21, Function1<? super Density, Offset> r22, float r23, boolean r24, long r25, float r27, float r28, boolean r29, Function1<? super DpSize, Unit> r30, PlatformMagnifierFactory r31) {
        float r9 = this.zoom;
        long r10 = this.size;
        float r12 = this.cornerRadius;
        boolean r13 = this.useTextDefault;
        float r14 = this.elevation;
        boolean r15 = this.clippingEnabled;
        PlatformMagnifierFactory r16 = this.platformMagnifierFactory;
        View r17 = this.view;
        Density r18 = this.density;
        this.sourceCenter = r21;
        this.magnifierCenter = r22;
        this.zoom = r23;
        this.useTextDefault = r24;
        this.size = r25;
        this.cornerRadius = r27;
        this.elevation = r28;
        this.clippingEnabled = r29;
        this.onSizeChanged = r30;
        this.platformMagnifierFactory = r31;
        View r19 = DelegatableNode_androidKt.requireView(this);
        Density r110 = DelegatableNodeKt.requireDensity(this);
        if (this.magnifier != null) goto L5;
    L24:
        boolean r1 = false;
    L25:
        if (r1 == false) goto L27;
        recreateMagnifier();
    L27:
        updateMagnifier();
        return;
    L5:
        if (Magnifier_androidKt.equalsIncludingNaN(r23, r9) == true) goto L9;
        if (r31.getCanUpdateZoom() == true) goto L9;
    L23:
        r1 = true;
    L9:
        if (DpSize.equals-impl0(r25, r10) == false) goto L23;
        if (Dp.equals-impl0(r27, r12) == false) goto L23;
        if (Dp.equals-impl0(r28, r14) == false) goto L23;
        if (r24 != r13) goto L23;
        if (r29 != r15) goto L23;
        if (Intrinsics.areEqual(r31, r16) == false) goto L23;
        if (Intrinsics.areEqual(r19, r17) == false) goto L23;
        if (Intrinsics.areEqual(r110, r18) == true) goto L24;
        goto L23
    }

    public /* synthetic */ MagnifierNode(Function1 r17, Function1 r18, Function1 r19, float r20, boolean r21, long r22, float r24, float r25, boolean r26, PlatformMagnifierFactory r27, int r28, DefaultConstructorMarker r29) {
        if ((r28 & 2) == 0) goto L5;
        Function1 r5 = null;
    L7:
        if ((r28 & 4) == 0) goto L9;
        Function1 r6 = null;
    L11:
        if ((r28 & 8) == 0) goto L13;
        float r7 = Float.NaN;
    L15:
        if ((r28 & 16) == 0) goto L17;
        boolean r8 = false;
    L19:
        if ((r28 & 32) == 0) goto L21;
        long r9 = DpSize.Companion.getUnspecified-MYxV2XQ();
    L23:
        if ((r28 & 64) == 0) goto L25;
        float r11 = Dp.Companion.getUnspecified-D9Ej5fM();
    L27:
        if ((r28 & 128) == 0) goto L29;
        float r12 = Dp.Companion.getUnspecified-D9Ej5fM();
    L31:
        if ((r28 & 256) == 0) goto L33;
        boolean r13 = true;
    L35:
        if ((r28 & 512) == 0) goto L37;
        PlatformMagnifierFactory r14 = PlatformMagnifierFactory.Companion.getForCurrentPlatform();
    L38:
        this(r17, r5, r6, r7, r8, r9, r11, r12, r13, r14, null);
        return;
    L37:
        r14 = r27;
        goto L38
    L33:
        r13 = r26;
        goto L35
    L29:
        r12 = r25;
        goto L31
    L25:
        r11 = r24;
        goto L27
    L21:
        r9 = r22;
        goto L23
    L17:
        r8 = r21;
        goto L19
    L13:
        r7 = r20;
        goto L15
    L9:
        r6 = r19;
        goto L11
    L5:
        r5 = r18;
        goto L7
    }
}
