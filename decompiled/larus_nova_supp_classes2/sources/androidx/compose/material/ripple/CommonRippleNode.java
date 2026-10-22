package androidx.compose.material.ripple;

import androidx.collection.MutableScatterMap;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DrawModifierNodeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\f\u0010\u001d\u001a\u00020\u0014*\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/material/ripple/CommonRippleNode;", "Landroidx/compose/material/ripple/RippleNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "ripples", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "Landroidx/compose/material/ripple/RippleAnimation;", "addRipple", "", "interaction", "size", "Landroidx/compose/ui/geometry/Size;", "targetRadius", "", "addRipple-12SF9DM", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;JF)V", "removeRipple", "drawRipples", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "onDetach", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CommonRippleNode extends RippleNode {
    public static final int $stable = 8;
    private final MutableScatterMap<PressInteraction.Press, RippleAnimation> ripples;

    public /* synthetic */ CommonRippleNode(InteractionSource r1, boolean r2, float r3, ColorProducer r4, Function0 r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r4, r5);
    }

    public void onDetach() {
        this.ripples.clear();
    }

    public static final /* synthetic */ MutableScatterMap access$getRipples$p(CommonRippleNode r0) {
        return r0.ripples;
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void drawRipples(DrawScope r24) {
        float r0 = ((RippleAlpha) getRippleAlpha().invoke()).getPressedAlpha();
        if (r0 != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L29;
        MutableScatterMap<PressInteraction.Press, RippleAnimation> r2 = this.ripples;
        Object[] r12 = r2.keys;
        Object[] r13 = r2.values;
        long[] r14 = r2.metadata;
        int r15 = r14.length - 2;
        if (r15 < 0) goto L35;
        int r8 = 0;
    L11:
        long r3 = r14[r8];
        if (((((~r3) << 7) & r3) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L26;
        int r6 = 8 - ((~(r8 - r15)) >>> 31);
        long r16 = r3;
        int r5 = 0;
    L14:
        if (r5 >= r6) goto L23;
        if ((r16 & 255) >= 128) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == false) goto L22;
        int r7 = (r8 << 3) + r5;
        PressInteraction.Press r9 = (PressInteraction.Press) r12[r7];
        ((RippleAnimation) r13[r7]).m2263draw4WTKRHQ(r24, Color.copy-wmQWz5c$default(m2271getRippleColor0d7_KjU(), r0, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null));
    L22:
        r16 = r16 >> 8;
        r5 = r5 + 1;
        r8 = r8;
        r6 = r6;
        r0 = r0;
        goto L14
    L18:
        r4 = false;
        goto L19
    L23:
        float r20 = r0;
        int r10 = r8;
        if (r6 != 8) goto L36;
    L27:
        if (r10 == r15) goto L37;
        r8 = r10 + 1;
        r0 = r20;
        goto L11
    L37:
        return;
    L36:
        return;
    L26:
        r20 = r0;
        r10 = r8;
        goto L27
    L35:
        return;
    L29:
        return;
    L5:
        r1 = false;
        goto L7
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void removeRipple(PressInteraction.Press r2) {
        RippleAnimation r3 = this.ripples.get(r2);
        if (r3 == null) goto L6;
        r3.finish();
        return;
    }

    @Override // androidx.compose.material.ripple.RippleNode
    /* JADX INFO: renamed from: addRipple-12SF9DM */
    public void mo2259addRipple12SF9DM(PressInteraction.Press r19, long r20, float r22) {
        MutableScatterMap<PressInteraction.Press, RippleAnimation> r2 = this.ripples;
        Object[] r3 = r2.keys;
        Object[] r4 = r2.values;
        long[] r5 = r2.metadata;
        int r6 = r5.length - 2;
        if (r6 < 0) goto L20;
        int r7 = 0;
    L5:
        long r8 = r5[r7];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r10 = 8 - ((~(r7 - r6)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L16;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L15;
        int r14 = (r7 << 3) + r12;
        PressInteraction.Press r15 = (PressInteraction.Press) r3[r14];
        ((RippleAnimation) r4[r14]).finish();
    L15:
        r8 = r8 >> 8;
        r12 = r12 + 1;
        goto L8
    L12:
        r13 = false;
        goto L13
    L16:
        if (r10 != 8) goto L20;
    L17:
        if (r7 == r6) goto L20;
        r7 = r7 + 1;
    L20:
        if (getBounded() == false) goto L22;
        Offset r9 = Offset.box-impl(r19.m743getPressPositionF1C5BW0());
    L23:
        RippleAnimation r11 = new RippleAnimation(r9, r22, getBounded(), null);
        this.ripples.set(r19, r11);
        BuildersKt.launch$default(getCoroutineScope(), null, null, new CommonRippleNode$addRipple$2(r11, this, r19, null), 3, null);
        DrawModifierNodeKt.invalidateDraw(this);
        return;
    L22:
        r9 = null;
        goto L23
    }

    private CommonRippleNode(InteractionSource r8, boolean r9, float r10, ColorProducer r11, Function0<RippleAlpha> r12) {
        super(r8, r9, r10, r11, r12, null);
        this.ripples = new MutableScatterMap(0, 1, null);
    }
}
