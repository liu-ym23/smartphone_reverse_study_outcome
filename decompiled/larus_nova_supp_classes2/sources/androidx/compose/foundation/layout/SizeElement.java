package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BP\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\f\u0010\u0015\u001a\u00020\r*\u00020\fH\u0016J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/layout/SizeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/SizeNode;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "create", "update", "node", "inspectableProperties", "equals", "other", "", "hashCode", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SizeElement extends ModifierNodeElement<SizeNode> {
    private final boolean enforceIncoming;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final float maxHeight;
    private final float maxWidth;
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ SizeElement(float r1, float r2, float r3, float r4, boolean r5, Function1 r6, DefaultConstructorMarker r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

    public SizeNode create() {
        return new SizeNode(this.minWidth, this.minHeight, this.maxWidth, this.maxHeight, this.enforceIncoming, null);
    }

    public int hashCode() {
        int r0 = ((((((Dp.hashCode-impl(this.minWidth) * 31) + Dp.hashCode-impl(this.minHeight)) * 31) + Dp.hashCode-impl(this.maxWidth)) * 31) + Dp.hashCode-impl(this.maxHeight)) * 31;
        if (this.enforceIncoming == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m997create() {
        return create();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SizeElement) == true) goto L8;
        return false;
    L8:
        SizeElement r6 = (SizeElement) r5;
        if (Dp.equals-impl0(this.minWidth, r6.minWidth) == true) goto L12;
        return false;
    L12:
        if (Dp.equals-impl0(this.minHeight, r6.minHeight) == true) goto L15;
        return false;
    L15:
        if (Dp.equals-impl0(this.maxWidth, r6.maxWidth) == true) goto L18;
        return false;
    L18:
        if (Dp.equals-impl0(this.maxHeight, r6.maxHeight) == true) goto L21;
        return false;
    L21:
        if (this.enforceIncoming == r6.enforceIncoming) goto L23;
        return false;
    L23:
        return true;
    }

    public void inspectableProperties(InspectorInfo r2) {
        this.inspectorInfo.invoke(r2);
    }

    public void update(SizeNode r2) {
        r2.m1031setMinWidth0680j_4(this.minWidth);
        r2.m1030setMinHeight0680j_4(this.minHeight);
        r2.m1029setMaxWidth0680j_4(this.maxWidth);
        r2.m1028setMaxHeight0680j_4(this.maxHeight);
        r2.setEnforceIncoming(this.enforceIncoming);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((SizeNode) r1);
    }

    private SizeElement(float r1, float r2, float r3, float r4, boolean r5, Function1<? super InspectorInfo, Unit> r6) {
        this.minWidth = r1;
        this.minHeight = r2;
        this.maxWidth = r3;
        this.maxHeight = r4;
        this.enforceIncoming = r5;
        this.inspectorInfo = r6;
    }

    public /* synthetic */ SizeElement(float r10, float r11, float r12, float r13, boolean r14, Function1 r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 1) == 0) goto L5;
        float r2 = Dp.Companion.getUnspecified-D9Ej5fM();
    L7:
        if ((r16 & 2) == 0) goto L9;
        float r3 = Dp.Companion.getUnspecified-D9Ej5fM();
    L11:
        if ((r16 & 4) == 0) goto L13;
        float r4 = Dp.Companion.getUnspecified-D9Ej5fM();
    L15:
        if ((r16 & 8) == 0) goto L17;
        float r5 = Dp.Companion.getUnspecified-D9Ej5fM();
    L18:
        this(r2, r3, r4, r5, r14, r15, null);
        return;
    L17:
        r5 = r13;
        goto L18
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }
}
