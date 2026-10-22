package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cBA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\f\u0010\u0016\u001a\u00020\u0014*\u00020\u0017H\u0016J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/layout/WrapContentElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/WrapContentNode;", "direction", "Landroidx/compose/foundation/layout/Direction;", "unbounded", "", "alignmentCallback", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/IntOffset;", "align", "", "inspectorName", "", "<init>", "(Landroidx/compose/foundation/layout/Direction;ZLkotlin/jvm/functions/Function2;Ljava/lang/Object;Ljava/lang/String;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "hashCode", "", "Companion", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class WrapContentElement extends ModifierNodeElement<WrapContentNode> {
    public static final Companion Companion = null;
    private final Object align;
    private final Function2<IntSize, LayoutDirection, IntOffset> alignmentCallback;
    private final Direction direction;
    private final String inspectorName;
    private final boolean unbounded;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/layout/WrapContentElement$Companion;", "", "<init>", "()V", "width", "Landroidx/compose/foundation/layout/WrapContentElement;", "align", "Landroidx/compose/ui/Alignment$Horizontal;", "unbounded", "", "height", "Landroidx/compose/ui/Alignment$Vertical;", "size", "Landroidx/compose/ui/Alignment;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ IntOffset a(Alignment.Vertical r0, IntSize r1, LayoutDirection r2) {
            return height$lambda$1(r0, r1, r2);
        }

        public static /* synthetic */ IntOffset b(Alignment r0, IntSize r1, LayoutDirection r2) {
            return size$lambda$2(r0, r1, r2);
        }

        public static /* synthetic */ IntOffset c(Alignment.Horizontal r0, IntSize r1, LayoutDirection r2) {
            return width$lambda$0(r0, r1, r2);
        }

        public final WrapContentElement height(final Alignment.Vertical r8, boolean r9) {
            return new WrapContentElement(Direction.Vertical, r9, new u2(r8), r8, "wrapContentHeight");
        }

        public final WrapContentElement size(final Alignment r8, boolean r9) {
            return new WrapContentElement(Direction.Both, r9, new t2(r8), r8, "wrapContentSize");
        }

        public final WrapContentElement width(final Alignment.Horizontal r8, boolean r9) {
            return new WrapContentElement(Direction.Horizontal, r9, new s2(r8), r8, "wrapContentWidth");
        }

        private static final IntOffset height$lambda$1(Alignment.Vertical r4, IntSize r5, LayoutDirection r6) {
            int r7 = r4.align(0, (int) (r5.unbox-impl() & 4294967295L));
            return IntOffset.box-impl(IntOffset.constructor-impl((((long) 0) << 32) | (4294967295L & ((long) r7))));
        }

        private static final IntOffset size$lambda$2(Alignment r7, IntSize r8, LayoutDirection r9) {
            return IntOffset.box-impl(r7.align-KFBX0sM(IntSize.Companion.getZero-YbymL2g(), r8.unbox-impl(), r9));
        }

        private static final IntOffset width$lambda$0(Alignment.Horizontal r4, IntSize r5, LayoutDirection r6) {
            return IntOffset.box-impl(IntOffset.constructor-impl((((long) r4.align(0, (int) (r5.unbox-impl() >> 32), r6)) << 32) | (((long) 0) & 4294967295L)));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WrapContentNode create() {
        return new WrapContentNode(this.direction, this.unbounded, this.alignmentCallback);
    }

    public int hashCode() {
        int r0 = this.direction.hashCode() * 31;
        if (this.unbounded == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.align.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m1078create() {
        return create();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (WrapContentElement.class == r5.getClass()) goto L11;
        return false;
    L11:
        WrapContentElement r6 = (WrapContentElement) r5;
        if (this.direction == r6.direction) goto L15;
        return false;
    L15:
        if (this.unbounded == r6.unbounded) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.align, r6.align) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName(this.inspectorName);
        r4.getProperties().set("align", this.align);
        r4.getProperties().set("unbounded", Boolean.valueOf(this.unbounded));
    }

    public void update(WrapContentNode r2) {
        r2.setDirection(this.direction);
        r2.setUnbounded(this.unbounded);
        r2.setAlignmentCallback(this.alignmentCallback);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((WrapContentNode) r1);
    }

    public WrapContentElement(Direction r1, boolean r2, Function2<? super IntSize, ? super LayoutDirection, IntOffset> r3, Object r4, String r5) {
        this.direction = r1;
        this.unbounded = r2;
        this.alignmentCallback = r3;
        this.align = r4;
        this.inspectorName = r5;
    }
}
