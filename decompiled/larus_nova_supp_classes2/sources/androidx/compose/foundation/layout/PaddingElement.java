package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BP\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\"\u001a\u00020\u0002H\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0002H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0013\u0010'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0002J\f\u0010*\u001a\u00020\r*\u00020\fH\u0016R\u001c\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006+"}, d2 = {"Landroidx/compose/foundation/layout/PaddingElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/PaddingNode;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "rtlAware", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-D9Ej5fM", "()F", "setStart-0680j_4", "(F)V", "F", "getTop-D9Ej5fM", "setTop-0680j_4", "getEnd-D9Ej5fM", "setEnd-0680j_4", "getBottom-D9Ej5fM", "setBottom-0680j_4", "getRtlAware", "()Z", "setRtlAware", "(Z)V", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "create", "update", "node", "hashCode", "", "equals", "other", "", "inspectableProperties", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PaddingElement extends ModifierNodeElement<PaddingNode> {
    private float bottom;
    private float end;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private boolean rtlAware;
    private float start;
    private float top;

    public /* synthetic */ PaddingElement(float r1, float r2, float r3, float r4, boolean r5, Function1 r6, DefaultConstructorMarker r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

    public PaddingNode create() {
        return new PaddingNode(this.start, this.top, this.end, this.bottom, this.rtlAware, null);
    }

    public int hashCode() {
        int r0 = ((((((Dp.hashCode-impl(this.start) * 31) + Dp.hashCode-impl(this.top)) * 31) + Dp.hashCode-impl(this.end)) * 31) + Dp.hashCode-impl(this.bottom)) * 31;
        if (this.rtlAware == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m944getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getEnd-D9Ej5fM, reason: not valid java name */
    public final float m945getEndD9Ej5fM() {
        return this.end;
    }

    public final Function1<InspectorInfo, Unit> getInspectorInfo() {
        return this.inspectorInfo;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    /* JADX INFO: renamed from: getStart-D9Ej5fM, reason: not valid java name */
    public final float m946getStartD9Ej5fM() {
        return this.start;
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m947getTopD9Ej5fM() {
        return this.top;
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m952create() {
        return create();
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof PaddingElement) == false) goto L5;
        PaddingElement r5 = (PaddingElement) r4;
    L7:
        if (r5 != null) goto L10;
        return false;
    L10:
        if (Dp.equals-impl0(this.start, r5.start) == true) goto L12;
        return false;
    L12:
        if (Dp.equals-impl0(this.top, r5.top) == true) goto L14;
        return false;
    L14:
        if (Dp.equals-impl0(this.end, r5.end) == true) goto L16;
        return false;
    L16:
        if (Dp.equals-impl0(this.bottom, r5.bottom) == true) goto L18;
        return false;
    L18:
        if (this.rtlAware != r5.rtlAware) goto L25;
        return true;
    L25:
        return false;
    L5:
        r5 = null;
        goto L7
    }

    public void inspectableProperties(InspectorInfo r2) {
        this.inspectorInfo.invoke(r2);
    }

    /* JADX INFO: renamed from: setBottom-0680j_4, reason: not valid java name */
    public final void m948setBottom0680j_4(float r1) {
        this.bottom = r1;
    }

    /* JADX INFO: renamed from: setEnd-0680j_4, reason: not valid java name */
    public final void m949setEnd0680j_4(float r1) {
        this.end = r1;
    }

    public final void setRtlAware(boolean r1) {
        this.rtlAware = r1;
    }

    /* JADX INFO: renamed from: setStart-0680j_4, reason: not valid java name */
    public final void m950setStart0680j_4(float r1) {
        this.start = r1;
    }

    /* JADX INFO: renamed from: setTop-0680j_4, reason: not valid java name */
    public final void m951setTop0680j_4(float r1) {
        this.top = r1;
    }

    public void update(PaddingNode r2) {
        r2.m972setStart0680j_4(this.start);
        r2.m973setTop0680j_4(this.top);
        r2.m971setEnd0680j_4(this.end);
        r2.m970setBottom0680j_4(this.bottom);
        r2.setRtlAware(this.rtlAware);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((PaddingNode) r1);
    }

    private PaddingElement(float r1, float r2, float r3, float r4, boolean r5, Function1<? super InspectorInfo, Unit> r6) {
        this.start = r1;
        this.top = r2;
        this.end = r3;
        this.bottom = r4;
        this.rtlAware = r5;
        this.inspectorInfo = r6;
        boolean r7 = false;
        if (r1 < MenuKt.ClosedAlphaTarget) goto L5;
    L8:
        boolean r8 = true;
    L9:
        float r9 = this.top;
        if (r9 < MenuKt.ClosedAlphaTarget) goto L12;
    L15:
        boolean r10 = true;
    L16:
        boolean r11 = r8 & r10;
        float r12 = this.end;
        if (r12 < MenuKt.ClosedAlphaTarget) goto L19;
    L22:
        boolean r13 = true;
    L23:
        boolean r14 = r11 & r13;
        float r15 = this.bottom;
        if (r15 < MenuKt.ClosedAlphaTarget) goto L26;
    L27:
        r7 = true;
    L29:
        if ((r14 & r7) == true) goto L32;
        InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        return;
    L32:
        return;
    L26:
        if (Float.isNaN(r15) == false) goto L29;
    L19:
        if (Float.isNaN(r12) == true) goto L22;
        r13 = false;
        goto L23
    L12:
        if (Float.isNaN(r9) == true) goto L15;
        r10 = false;
        goto L16
    L5:
        if (Float.isNaN(r1) == true) goto L8;
        r8 = false;
        goto L9
    }

    public /* synthetic */ PaddingElement(float r11, float r12, float r13, float r14, boolean r15, Function1 r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 1) == 0) goto L5;
        float r3 = Dp.constructor-impl(0);
    L7:
        if ((r17 & 2) == 0) goto L9;
        float r4 = Dp.constructor-impl(0);
    L11:
        if ((r17 & 4) == 0) goto L13;
        float r5 = Dp.constructor-impl(0);
    L15:
        if ((r17 & 8) == 0) goto L17;
        float r6 = Dp.constructor-impl(0);
    L18:
        this(r3, r4, r5, r6, r15, r16, null);
        return;
    L17:
        r6 = r14;
        goto L18
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }
}
