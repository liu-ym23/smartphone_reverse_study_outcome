package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Deprecated(message = "Replaced by the new RippleNode implementation")
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0004\b\f\u0010\rJ\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u001b\u0010\u001d\u001a\u00020\u0016*\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001f\u0010 J\b\u0010!\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/compose/material/ripple/CommonRippleIndicationInstance;", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "Landroidx/compose/runtime/RememberObserver;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "<init>", "(ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "ripples", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "Landroidx/compose/material/ripple/RippleAnimation;", "targetRadius", "", "drawIndication", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "addRipple", "interaction", "scope", "Lkotlinx/coroutines/CoroutineScope;", "removeRipple", "drawRipples", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawRipples-4WTKRHQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "onRemembered", "onForgotten", "onAbandoned", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CommonRippleIndicationInstance extends RippleIndicationInstance implements RememberObserver {
    private final boolean bounded;
    private final State<Color> color;
    private final float radius;
    private final State<RippleAlpha> rippleAlpha;
    private final SnapshotStateMap<PressInteraction.Press, RippleAnimation> ripples;
    private float targetRadius;

    /* JADX INFO: renamed from: androidx.compose.material.ripple.CommonRippleIndicationInstance$addRipple$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.ripple.CommonRippleIndicationInstance$addRipple$2", f = "CommonRipple.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PressInteraction.Press $interaction;
        final /* synthetic */ RippleAnimation $rippleAnimation;
        int label;
        final /* synthetic */ CommonRippleIndicationInstance this$0;

        public AnonymousClass2(RippleAnimation r1, CommonRippleIndicationInstance r2, PressInteraction.Press r3, Continuation<? super AnonymousClass2> r4) {
            this.$rippleAnimation = r1;
            this.this$0 = r2;
            this.$interaction = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.$rippleAnimation, this.this$0, this.$interaction, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L7
        L15:
            CommonRippleIndicationInstance.access$getRipples$p(this.this$0).remove(this.$interaction);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r4);
            RippleAnimation r5 = this.$rippleAnimation;     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            if (r5.animate(this) != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            CommonRippleIndicationInstance.access$getRipples$p(this.this$0).remove(this.$interaction);
            throw th;
        }
    }

    public /* synthetic */ CommonRippleIndicationInstance(boolean r1, float r2, State r3, State r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    public void onRemembered() {
    }

    public void onAbandoned() {
        this.ripples.clear();
    }

    public void onForgotten() {
        this.ripples.clear();
    }

    public static final /* synthetic */ SnapshotStateMap access$getRipples$p(CommonRippleIndicationInstance r0) {
        return r0.ripples;
    }

    @Override // androidx.compose.foundation.IndicationInstance
    public void drawIndication(ContentDrawScope r4) {
        if (Float.isNaN(this.radius) == false) goto L5;
        float r0 = RippleAnimationKt.m2264getRippleEndRadiuscSwnlzA(r4, this.bounded, r4.getSize-NH-jbRc());
    L6:
        this.targetRadius = r0;
        long r1 = ((Color) this.color.getValue()).unbox-impl();
        r4.drawContent();
        m2268drawStateLayerH2RKhps(r4, this.radius, r1);
        m2261drawRipples4WTKRHQ(r4, r1);
        return;
    L5:
        r0 = r4.toPx-0680j_4(this.radius);
        goto L6
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void removeRipple(PressInteraction.Press r2) {
        RippleAnimation r3 = (RippleAnimation) this.ripples.get(r2);
        if (r3 == null) goto L6;
        r3.finish();
        return;
    }

    /* JADX INFO: renamed from: drawRipples-4WTKRHQ, reason: not valid java name */
    private final void m2261drawRipples4WTKRHQ(DrawScope r12, long r13) {
        Iterator r0 = this.ripples.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        RippleAnimation r1 = (RippleAnimation) ((Map.Entry) r0.next()).getValue();
        float r5 = ((RippleAlpha) this.rippleAlpha.getValue()).getPressedAlpha();
        if (r5 != MenuKt.ClosedAlphaTarget) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L4;
        r1.m2263draw4WTKRHQ(r12, Color.copy-wmQWz5c$default(r13, r5, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null));
        goto L4
    L8:
        r2 = false;
        goto L9
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void addRipple(PressInteraction.Press r10, CoroutineScope r11) {
        Iterator r0 = this.ripples.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        ((RippleAnimation) ((Map.Entry) r0.next()).getValue()).finish();
        goto L4
    L7:
        if (this.bounded == false) goto L9;
        Offset r1 = Offset.box-impl(r10.m743getPressPositionF1C5BW0());
    L10:
        RippleAnimation r2 = new RippleAnimation(r1, this.targetRadius, this.bounded, null);
        this.ripples.put(r10, r2);
        BuildersKt.launch$default(r11, null, null, new AnonymousClass2(r2, this, r10, null), 3, null);
        return;
    L9:
        r1 = null;
        goto L10
    }

    private CommonRippleIndicationInstance(boolean r1, float r2, State<Color> r3, State<RippleAlpha> r4) {
        super(r1, r4);
        this.bounded = r1;
        this.radius = r2;
        this.color = r3;
        this.rippleAlpha = r4;
        this.ripples = SnapshotStateKt.mutableStateMapOf();
        this.targetRadius = Float.NaN;
    }
}
