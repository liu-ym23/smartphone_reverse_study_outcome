package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\b\u0018\u0000 &2\u00020\u0001:\u0001&B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0010J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JB\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006'"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "", "visible", "", "position", "Landroidx/compose/ui/geometry/Offset;", "lineHeight", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "<init>", "(ZJFLandroidx/compose/ui/text/style/ResolvedTextDirection;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getVisible", "()Z", "getPosition-F1C5BW0", "()J", "J", "getLineHeight", "()F", "getDirection", "()Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getHandlesCrossed", "component1", "component2", "component2-F1C5BW0", "component3", "component4", "component5", "copy", "copy-YqVAtuI", "(ZJFLandroidx/compose/ui/text/style/ResolvedTextDirection;Z)Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "equals", "other", "hashCode", "", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldHandleState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final TextFieldHandleState Hidden = null;
    private final ResolvedTextDirection direction;
    private final boolean handlesCrossed;
    private final float lineHeight;
    private final long position;
    private final boolean visible;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState$Companion;", "", "<init>", "()V", "Hidden", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "getHidden", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final TextFieldHandleState getHidden() {
            return TextFieldHandleState.access$getHidden$cp();
        }
    }

    public /* synthetic */ TextFieldHandleState(boolean r1, long r2, float r4, ResolvedTextDirection r5, boolean r6, DefaultConstructorMarker r7) {
        this(r1, r2, r4, r5, r6);
    }

    /* JADX INFO: renamed from: copy-YqVAtuI$default, reason: not valid java name */
    public static /* synthetic */ TextFieldHandleState m1702copyYqVAtuI$default(TextFieldHandleState r4, boolean r5, long r6, float r8, ResolvedTextDirection r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.visible;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.position;
    L8:
        long r0 = r6;
        if ((r11 & 4) == 0) goto L11;
        r8 = r4.lineHeight;
    L11:
        float r13 = r8;
        if ((r11 & 8) == 0) goto L14;
        r9 = r4.direction;
    L14:
        ResolvedTextDirection r2 = r9;
        if ((r11 & 16) == 0) goto L17;
        r10 = r4.handlesCrossed;
    L17:
        boolean r7 = r5;
        return r4.m1704copyYqVAtuI(r7, r0, r13, r2, r10);
    }

    public final boolean component1() {
        return this.visible;
    }

    /* JADX INFO: renamed from: component2-F1C5BW0, reason: not valid java name */
    public final long m1703component2F1C5BW0() {
        return this.position;
    }

    public final float component3() {
        return this.lineHeight;
    }

    public final ResolvedTextDirection component4() {
        return this.direction;
    }

    public final boolean component5() {
        return this.handlesCrossed;
    }

    /* JADX INFO: renamed from: copy-YqVAtuI, reason: not valid java name */
    public final TextFieldHandleState m1704copyYqVAtuI(boolean r10, long r11, float r13, ResolvedTextDirection r14, boolean r15) {
        return new TextFieldHandleState(r10, r11, r13, r14, r15, null);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof TextFieldHandleState) == true) goto L8;
        return false;
    L8:
        TextFieldHandleState r9 = (TextFieldHandleState) r8;
        if (this.visible == r9.visible) goto L12;
        return false;
    L12:
        if (Offset.equals-impl0(this.position, r9.position) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.lineHeight, r9.lineHeight) == 0) goto L18;
        return false;
    L18:
        if (this.direction == r9.direction) goto L21;
        return false;
    L21:
        if (this.handlesCrossed == r9.handlesCrossed) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.visible == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((((((r0 * 31) + Offset.hashCode-impl(this.position)) * 31) + Float.floatToIntBits(this.lineHeight)) * 31) + this.direction.hashCode()) * 31;
        if (this.handlesCrossed == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "TextFieldHandleState(visible=" + this.visible + ", position=" + Offset.toString-impl(this.position) + ", lineHeight=" + this.lineHeight + ", direction=" + this.direction + ", handlesCrossed=" + this.handlesCrossed + ')';
    }

    static {
        Companion = new Companion(null);
        Hidden = new TextFieldHandleState(false, Offset.Companion.getUnspecified-F1C5BW0(), MenuKt.ClosedAlphaTarget, ResolvedTextDirection.Ltr, false, null);
    }

    public static final /* synthetic */ TextFieldHandleState access$getHidden$cp() {
        return Hidden;
    }

    public final ResolvedTextDirection getDirection() {
        return this.direction;
    }

    public final boolean getHandlesCrossed() {
        return this.handlesCrossed;
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }

    /* JADX INFO: renamed from: getPosition-F1C5BW0, reason: not valid java name */
    public final long m1705getPositionF1C5BW0() {
        return this.position;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    private TextFieldHandleState(boolean r1, long r2, float r4, ResolvedTextDirection r5, boolean r6) {
        this.visible = r1;
        this.position = r2;
        this.lineHeight = r4;
        this.direction = r5;
        this.handlesCrossed = r6;
    }
}
