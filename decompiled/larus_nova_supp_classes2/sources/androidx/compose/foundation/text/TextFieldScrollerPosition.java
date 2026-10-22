package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextRange;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\r\b\u0001\u0018\u0000 :2\u00020\u0001:\u0001:B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ&\u0010-\u001a\u00020.2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u0015J%\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0015H\u0000¢\u0006\u0002\b5J\u0015\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020 ¢\u0006\u0004\b8\u00109R+\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00158F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010&\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006;"}, d2 = {"Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "", "initialOrientation", "Landroidx/compose/foundation/gestures/Orientation;", "initial", "", "<init>", "(Landroidx/compose/foundation/gestures/Orientation;F)V", "()V", "<set-?>", "offset", "getOffset", "()F", "setOffset", "(F)V", "offset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "maximum", "getMaximum", "setMaximum", "maximum$delegate", "", "viewportSize", "getViewportSize", "()I", "setViewportSize", "(I)V", "viewportSize$delegate", "Landroidx/compose/runtime/MutableIntState;", "previousCursorRect", "Landroidx/compose/ui/geometry/Rect;", "previousSelection", "Landroidx/compose/ui/text/TextRange;", "getPreviousSelection-d9O1mEE", "()J", "setPreviousSelection-5zc-tL8", "(J)V", "J", "orientation", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation", "(Landroidx/compose/foundation/gestures/Orientation;)V", "orientation$delegate", "Landroidx/compose/runtime/MutableState;", "update", "", "cursorRect", "containerSize", "textFieldSize", "coerceOffset", "cursorStart", "cursorEnd", "coerceOffset$foundation_release", "getOffsetToFollow", "selection", "getOffsetToFollow-5zc-tL8", "(J)I", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldScrollerPosition {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Saver<TextFieldScrollerPosition, Object> Saver = null;
    private final MutableFloatState maximum$delegate;
    private final MutableFloatState offset$delegate;
    private final MutableState orientation$delegate;
    private Rect previousCursorRect;
    private long previousSelection;
    private final MutableIntState viewportSize$delegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text/TextFieldScrollerPosition$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Saver<TextFieldScrollerPosition, Object> getSaver() {
            return TextFieldScrollerPosition.access$getSaver$cp();
        }
    }

    public static /* synthetic */ List a(SaverScope r0, TextFieldScrollerPosition r1) {
        return Saver$lambda$0(r0, r1);
    }

    public static /* synthetic */ TextFieldScrollerPosition b(List r0) {
        return Saver$lambda$1(r0);
    }

    static {
        Companion = new Companion(null);
        Saver = ListSaverKt.listSaver(new b4(), new c4());
    }

    public TextFieldScrollerPosition() {
        float r3 = MenuKt.ClosedAlphaTarget;
        this(Orientation.Vertical, r3, 2, null);
    }

    public final float getMaximum() {
        return this.maximum$delegate.getFloatValue();
    }

    public final float getOffset() {
        return this.offset$delegate.getFloatValue();
    }

    public final Orientation getOrientation() {
        return (Orientation) this.orientation$delegate.getValue();
    }

    public final int getViewportSize() {
        return this.viewportSize$delegate.getIntValue();
    }

    public static final /* synthetic */ Saver access$getSaver$cp() {
        return Saver;
    }

    /* JADX INFO: renamed from: getPreviousSelection-d9O1mEE, reason: not valid java name */
    public final long m1473getPreviousSelectiond9O1mEE() {
        return this.previousSelection;
    }

    private static final TextFieldScrollerPosition Saver$lambda$1(List r3) {
        Object r1 = ListProtector.get(r3, 1);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Boolean");
        if (((Boolean) r1).booleanValue() == false) goto L5;
        Orientation r2 = Orientation.Vertical;
    L6:
        Object r4 = ListProtector.get(r3, 0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        return new TextFieldScrollerPosition(r2, ((Float) r4).floatValue());
    L5:
        r2 = Orientation.Horizontal;
        goto L6
    }

    private final void setMaximum(float r2) {
        this.maximum$delegate.setFloatValue(r2);
    }

    private final void setViewportSize(int r2) {
        this.viewportSize$delegate.setIntValue(r2);
    }

    /* JADX INFO: renamed from: getOffsetToFollow-5zc-tL8, reason: not valid java name */
    public final int m1472getOffsetToFollow5zctL8(long r4) {
        if (TextRange.getStart-impl(r4) == TextRange.getStart-impl(this.previousSelection)) goto L6;
        return TextRange.getStart-impl(r4);
    L6:
        if (TextRange.getEnd-impl(r4) == TextRange.getEnd-impl(this.previousSelection)) goto L9;
        return TextRange.getEnd-impl(r4);
    L9:
        return TextRange.getMin-impl(r4);
    }

    public final void setOffset(float r2) {
        this.offset$delegate.setFloatValue(r2);
    }

    public final void setOrientation(Orientation r2) {
        this.orientation$delegate.setValue(r2);
    }

    /* JADX INFO: renamed from: setPreviousSelection-5zc-tL8, reason: not valid java name */
    public final void m1474setPreviousSelection5zctL8(long r1) {
        this.previousSelection = r1;
    }

    public TextFieldScrollerPosition(Orientation r3, float r4) {
        this.offset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(r4);
        this.maximum$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(MenuKt.ClosedAlphaTarget);
        this.viewportSize$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.previousCursorRect = Rect.Companion.getZero();
        this.previousSelection = TextRange.Companion.getZero-d9O1mEE();
        this.orientation$delegate = SnapshotStateKt.mutableStateOf(r3, SnapshotStateKt.structuralEqualityPolicy());
    }

    private static final List Saver$lambda$0(SaverScope r3, TextFieldScrollerPosition r4) {
        Object[] r5 = new Object[2];
        boolean r1 = false;
        r5[0] = Float.valueOf(r4.getOffset());
        if (r4.getOrientation() != Orientation.Vertical) goto L5;
        r1 = true;
    L5:
        r5[1] = Boolean.valueOf(r1);
        return CollectionsKt.listOf(r5);
    }

    public final void coerceOffset$foundation_release(float r5, float r6, int r7) {
        float r0 = getOffset();
        float r8 = r7;
        float r1 = r0 + r8;
        if (r6 <= r1) goto L6;
    L4:
        float r9 = r6 - r1;
    L15:
        setOffset(getOffset() + r9);
        return;
    L6:
        if (r5 < r0) goto L8;
    L10:
        if (r5 < r0) goto L12;
    L14:
        r9 = MenuKt.ClosedAlphaTarget;
        goto L15
    L12:
        if ((r6 - r5) > r8) goto L14;
        r9 = r5 - r0;
        goto L15
    L8:
        if ((r6 - r5) <= r8) goto L10;
        goto L10
    }

    public /* synthetic */ TextFieldScrollerPosition(Orientation r1, float r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = MenuKt.ClosedAlphaTarget;
    L5:
        this(r1, r2);
    }

    public final void update(Orientation r5, Rect r6, int r7, int r8) {
        float r9 = r8 - r7;
        setMaximum(r9);
        boolean r2 = true;
        if (r6.getLeft() != this.previousCursorRect.getLeft()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L13;
        if (r6.getTop() != this.previousCursorRect.getTop()) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
    L23:
        setOffset(RangesKt.coerceIn(getOffset(), MenuKt.ClosedAlphaTarget, r9));
        setViewportSize(r7);
        return;
    L10:
        r1 = false;
    L13:
        if (r5 == Orientation.Vertical) goto L16;
        r2 = false;
    L16:
        if (r2 == false) goto L18;
        float r10 = r6.getTop();
    L19:
        if (r2 == false) goto L21;
        float r3 = r6.getBottom();
    L22:
        coerceOffset$foundation_release(r10, r3, r7);
        this.previousCursorRect = r6;
        goto L23
    L21:
        r3 = r6.getRight();
        goto L22
    L18:
        r10 = r6.getLeft();
        goto L19
    L5:
        r0 = false;
        goto L6
    }
}
