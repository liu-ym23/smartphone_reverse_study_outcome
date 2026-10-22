package androidx.compose.foundation.text;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u0016J\u0015\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0014¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0014H\u0000¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0014H\u0000¢\u0006\u0004\b'\u0010%J\u0013\u0010(\u001a\u00020\u0014*\u00020\u0014H\u0002¢\u0006\u0004\b)\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006*"}, d2 = {"Landroidx/compose/foundation/text/TextLayoutResultProxy;", "", "value", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "decorationBoxCoordinates", "<init>", "(Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getValue", "()Landroidx/compose/ui/text/TextLayoutResult;", "getInnerTextFieldCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setInnerTextFieldCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getDecorationBoxCoordinates", "setDecorationBoxCoordinates", "getOffsetForPosition", "", "position", "Landroidx/compose/ui/geometry/Offset;", "coerceInVisibleBounds", "", "getOffsetForPosition-3MmeM6k", "(JZ)I", "getLineForVerticalPosition", "vertical", "", "getLineEnd", "lineIndex", "visibleEnd", "isPositionOnText", "offset", "isPositionOnText-k-4lQ0M", "(J)Z", "translateDecorationToInnerCoordinates", "translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release", "(J)J", "translateInnerToDecorationCoordinates", "translateInnerToDecorationCoordinates-MK-Hz9U$foundation_release", "coercedInVisibleBoundsOfInputText", "coercedInVisibleBoundsOfInputText-MK-Hz9U", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextLayoutResultProxy {
    public static final int $stable = 8;
    private LayoutCoordinates decorationBoxCoordinates;
    private LayoutCoordinates innerTextFieldCoordinates;
    private final TextLayoutResult value;

    public final LayoutCoordinates getDecorationBoxCoordinates() {
        return this.decorationBoxCoordinates;
    }

    public final LayoutCoordinates getInnerTextFieldCoordinates() {
        return this.innerTextFieldCoordinates;
    }

    public final TextLayoutResult getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U, reason: not valid java name */
    private final long m1479coercedInVisibleBoundsOfInputTextMKHz9U(long r6) {
        LayoutCoordinates r0 = this.innerTextFieldCoordinates;
        if (r0 != null) goto L5;
    L11:
        Rect r2 = Rect.Companion.getZero();
    L13:
        return TextLayoutResultProxyKt.m1485access$coerceIn3MmeM6k(r6, r2);
    L5:
        if (r0.isAttached() == false) goto L9;
        LayoutCoordinates r1 = this.decorationBoxCoordinates;
        r2 = null;
        if (r1 == null) goto L10;
        r2 = LayoutCoordinates.-CC.localBoundingBoxOf$default(r1, r0, false, 2, null);
    L10:
        if (r2 != null) goto L13;
    L9:
        r2 = Rect.Companion.getZero();
        goto L10
    }

    public final int getLineForVerticalPosition(float r7) {
        return this.value.getLineForVerticalPosition(Float.intBitsToFloat((int) (m1483translateDecorationToInnerCoordinatesMKHz9U$foundation_release(m1479coercedInVisibleBoundsOfInputTextMKHz9U(Offset.constructor-impl((Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget) << 32) | (((long) Float.floatToRawIntBits(r7)) & 4294967295L)))) & 4294967295L)));
    }

    /* JADX INFO: renamed from: isPositionOnText-k-4lQ0M, reason: not valid java name */
    public final boolean m1482isPositionOnTextk4lQ0M(long r4) {
        long r5 = m1483translateDecorationToInnerCoordinatesMKHz9U$foundation_release(m1479coercedInVisibleBoundsOfInputTextMKHz9U(r4));
        int r0 = this.value.getLineForVerticalPosition(Float.intBitsToFloat((int) (4294967295L & r5)));
        int r6 = (int) (r5 >> 32);
        if (Float.intBitsToFloat(r6) >= this.value.getLineLeft(r0)) goto L5;
    L7:
        return false;
    L5:
        if (Float.intBitsToFloat(r6) > this.value.getLineRight(r0)) goto L7;
        return true;
    }

    public final void setDecorationBoxCoordinates(LayoutCoordinates r1) {
        this.decorationBoxCoordinates = r1;
    }

    public final void setInnerTextFieldCoordinates(LayoutCoordinates r1) {
        this.innerTextFieldCoordinates = r1;
    }

    /* JADX INFO: renamed from: translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release, reason: not valid java name */
    public final long m1483translateDecorationToInnerCoordinatesMKHz9U$foundation_release(long r5) {
        LayoutCoordinates r0 = this.innerTextFieldCoordinates;
        if (r0 == null) goto L19;
        LayoutCoordinates r2 = null;
        if (r0.isAttached() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L21;
        LayoutCoordinates r1 = this.decorationBoxCoordinates;
        if (r1 != null) goto L13;
        return r5;
    L13:
        if (r1.isAttached() == false) goto L15;
        r2 = r1;
    L15:
        if (r2 != null) goto L18;
        return r5;
    L18:
        return r0.localPositionOf-R5De75A(r2, r5);
    L21:
        return r5;
    L19:
        return r5;
    }

    /* JADX INFO: renamed from: translateInnerToDecorationCoordinates-MK-Hz9U$foundation_release, reason: not valid java name */
    public final long m1484translateInnerToDecorationCoordinatesMKHz9U$foundation_release(long r5) {
        LayoutCoordinates r0 = this.innerTextFieldCoordinates;
        if (r0 == null) goto L19;
        LayoutCoordinates r2 = null;
        if (r0.isAttached() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L21;
        LayoutCoordinates r1 = this.decorationBoxCoordinates;
        if (r1 != null) goto L13;
        return r5;
    L13:
        if (r1.isAttached() == false) goto L15;
        r2 = r1;
    L15:
        if (r2 != null) goto L18;
        return r5;
    L18:
        return r2.localPositionOf-R5De75A(r0, r5);
    L21:
        return r5;
    L19:
        return r5;
    }

    public final int getLineEnd(int r2, boolean r3) {
        return this.value.getLineEnd(r2, r3);
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k, reason: not valid java name */
    public final int m1481getOffsetForPosition3MmeM6k(long r1, boolean r3) {
        if (r3 == false) goto L4;
        r1 = m1479coercedInVisibleBoundsOfInputTextMKHz9U(r1);
    L4:
        long r2 = m1483translateDecorationToInnerCoordinatesMKHz9U$foundation_release(r1);
        return this.value.getOffsetForPosition-k-4lQ0M(r2);
    }

    public TextLayoutResultProxy(TextLayoutResult r1, LayoutCoordinates r2, LayoutCoordinates r3) {
        this.value = r1;
        this.innerTextFieldCoordinates = r2;
        this.decorationBoxCoordinates = r3;
    }

    public /* synthetic */ TextLayoutResultProxy(TextLayoutResult r2, LayoutCoordinates r3, LayoutCoordinates r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4);
    }

    public static /* synthetic */ int getLineEnd$default(TextLayoutResultProxy r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.getLineEnd(r1, r2);
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k$default, reason: not valid java name */
    public static /* synthetic */ int m1480getOffsetForPosition3MmeM6k$default(TextLayoutResultProxy r0, long r1, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r3 = true;
    L6:
        return r0.m1481getOffsetForPosition3MmeM6k(r1, r3);
    }
}
