package androidx.compose.material3;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\fB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/RippleNodeFactory;", "Landroidx/compose/foundation/IndicationNodeFactory;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "colorProducer", "Landroidx/compose/ui/graphics/ColorProducer;", "color", "Landroidx/compose/ui/graphics/Color;", "<init>", "(ZFLandroidx/compose/ui/graphics/ColorProducer;J)V", "(ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ZFJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "J", "create", "Landroidx/compose/ui/node/DelegatableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "equals", "other", "", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class RippleNodeFactory implements IndicationNodeFactory {
    private final boolean bounded;
    private final long color;
    private final ColorProducer colorProducer;
    private final float radius;

    public /* synthetic */ RippleNodeFactory(boolean r1, float r2, long r3, DefaultConstructorMarker r5) {
        this(r1, r2, r3);
    }

    public /* synthetic */ RippleNodeFactory(boolean r1, float r2, ColorProducer r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    @Override // androidx.compose.foundation.Indication
    public final /* synthetic */ IndicationInstance rememberUpdatedInstance(InteractionSource r1, Composer r2, int r3) {
        return Indication.CC.$default$rememberUpdatedInstance(this, r1, r2, r3);
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public int hashCode() {
        if (this.bounded == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + Dp.hashCode-impl(this.radius)) * 31;
        ColorProducer r2 = this.colorProducer;
        if (r2 == null) goto L9;
        int r3 = r2.hashCode();
    L11:
        return ((r1 + r3) * 31) + Color.hashCode-impl(this.color);
    L9:
        r3 = 0;
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public static final /* synthetic */ long access$getColor$p(RippleNodeFactory r2) {
        return r2.color;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public DelegatableNode create(InteractionSource r8) {
        ColorProducer r0 = this.colorProducer;
        if (r0 != null) goto L5;
        r0 = new RippleNodeFactory$create$colorProducer$1(this);
    L5:
        boolean r3 = this.bounded;
        float r4 = this.radius;
        return new DelegatingThemeAwareRippleNode(r8, r3, r4, r0, null);
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RippleNodeFactory) == true) goto L8;
        return false;
    L8:
        RippleNodeFactory r6 = (RippleNodeFactory) r5;
        if (this.bounded == r6.bounded) goto L12;
        return false;
    L12:
        if (Dp.equals-impl0(this.radius, r6.radius) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.colorProducer, r6.colorProducer) == true) goto L18;
        return false;
    L18:
        return Color.equals-impl0(this.color, r6.color);
    }

    private RippleNodeFactory(boolean r8, float r9, ColorProducer r10) {
        this(r8, r9, r10, Color.Companion.getUnspecified-0d7_KjU());
    }

    private RippleNodeFactory(boolean r7, float r8, long r9) {
        this(r7, r8, null, r9);
    }

    private RippleNodeFactory(boolean r1, float r2, ColorProducer r3, long r4) {
        this.bounded = r1;
        this.radius = r2;
        this.colorProducer = r3;
        this.color = r4;
    }
}
