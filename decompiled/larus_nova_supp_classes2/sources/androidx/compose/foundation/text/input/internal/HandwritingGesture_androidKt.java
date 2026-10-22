package androidx.compose.foundation.text.input.internal;

import android.graphics.PointF;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.EditCommand;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\u001a\u001b\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0001H\u0002\u001a\f\u0010\u000b\u001a\u00020\n*\u00020\u0001H\u0002\u001a\f\u0010\f\u001a\u00020\n*\u00020\u0001H\u0002\u001a\f\u0010\r\u001a\u00020\n*\u00020\u0001H\u0002\u001a\u0011\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0011\u001a+\u0010\u0012\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a3\u0010\u001c\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010 \u001a+\u0010\u0012\u001a\u00020\u0004*\u00020!2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\"\u001a3\u0010\u001c\u001a\u00020\u0004*\u00020!2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010#\u001a\u0019\u0010$\u001a\u00020\u0004*\u00020\u00062\u0006\u0010%\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010&\u001a%\u0010'\u001a\u00020\u0001*\u00020\u00132\u0006\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0004\b+\u0010,\u001a#\u0010'\u001a\u00020\u0001*\u00020!2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*H\u0002¢\u0006\u0004\b+\u0010-\u001a\u0014\u0010.\u001a\u00020\n*\u00020/2\u0006\u0010%\u001a\u00020\u0001H\u0002\u001a7\u0010\u0012\u001a\u00020\u0004*\u0004\u0018\u0001002\u0006\u0010\u0014\u001a\u00020\u00152\b\u00101\u001a\u0004\u0018\u0001022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0004\b3\u00104\u001a/\u0010'\u001a\u00020\u0001*\u0002002\u0006\u0010(\u001a\u00020\u000f2\b\u00101\u001a\u0004\u0018\u0001022\b\u0010)\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0004\b5\u00106\u001a9\u00107\u001a\u00020\u0004*\u0004\u0018\u00010/2\u0006\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u000f2\b\u00101\u001a\u0004\u0018\u0001022\b\u0010)\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0004\b:\u0010;\u001a%\u0010<\u001a\u00020\u0001*\u0002002\u0006\u0010=\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0004\b>\u0010?\u001a!\u0010@\u001a\u00020A2\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0C\"\u00020AH\u0002¢\u0006\u0002\u0010D\u001a\u001f\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u0004H\u0002¢\u0006\u0004\bH\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"LINE_FEED_CODE_POINT", "", "NBSP_CODE_POINT", "adjustHandwritingDeleteGestureRange", "Landroidx/compose/ui/text/TextRange;", "text", "", "adjustHandwritingDeleteGestureRange-72CqOWE", "(JLjava/lang/CharSequence;)J", "isNewline", "", "isWhitespace", "isWhitespaceExceptNewline", "isPunctuation", "toOffset", "Landroidx/compose/ui/geometry/Offset;", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)J", "getRangeForScreenRect", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "rectInScreen", "Landroidx/compose/ui/geometry/Rect;", "granularity", "Landroidx/compose/ui/text/TextGranularity;", "inclusionStrategy", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getRangeForScreenRect-OH9lIzo", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getRangeForScreenRects", "startRectInScreen", "endRectInScreen", "getRangeForScreenRects-O048IG0", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "rangeOfWhitespaces", "offset", "(Ljava/lang/CharSequence;I)J", "getOffsetForHandwritingGesture", "pointInScreen", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getOffsetForHandwritingGesture-d-4ec7I", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "(Landroidx/compose/foundation/text/LegacyTextFieldState;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "isBiDiBoundary", "Landroidx/compose/ui/text/TextLayoutResult;", "Landroidx/compose/ui/text/MultiParagraph;", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getRangeForScreenRect-O048IG0", "(Landroidx/compose/ui/text/MultiParagraph;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/layout/LayoutCoordinates;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getOffsetForHandwritingGesture-ubNVwUQ", "(Landroidx/compose/ui/text/MultiParagraph;JLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/platform/ViewConfiguration;)I", "getRangeForRemoveSpaceGesture", "startPointInScreen", "endPointerInScreen", "getRangeForRemoveSpaceGesture-5iVPX68", "(Landroidx/compose/ui/text/TextLayoutResult;JJLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/platform/ViewConfiguration;)J", "getLineForHandwritingGesture", "localPoint", "getLineForHandwritingGesture-d-4ec7I", "(Landroidx/compose/ui/text/MultiParagraph;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "compoundEditCommand", "Landroidx/compose/ui/text/input/EditCommand;", "editCommands", "", "([Landroidx/compose/ui/text/input/EditCommand;)Landroidx/compose/ui/text/input/EditCommand;", "enclosure", "a", "b", "enclosure-pWDy79M", "(JJ)J", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HandwritingGesture_androidKt {
    private static final int LINE_FEED_CODE_POINT = 10;
    private static final int NBSP_CODE_POINT = 160;

    public static final /* synthetic */ EditCommand access$compoundEditCommand(EditCommand... r0) {
        return compoundEditCommand(r0);
    }

    public static final /* synthetic */ long access$toOffset(PointF r2) {
        return toOffset(r2);
    }

    private static final EditCommand compoundEditCommand(final EditCommand... r1) {
        return new AnonymousClass1(r1);
    }

    private static final boolean isNewline(int r2) {
        int r0 = Character.getType(r2);
        if (r0 != 14) goto L5;
    L10:
        return true;
    L5:
        if (r0 == 13) goto L10;
        if (r2 == 10) goto L10;
        return false;
    }

    private static final boolean isPunctuation(int r1) {
        int r2 = Character.getType(r1);
        if (r2 != 23) goto L5;
    L18:
        return true;
    L5:
        if (r2 == 20) goto L18;
        if (r2 == 22) goto L18;
        if (r2 == 30) goto L18;
        if (r2 == 29) goto L18;
        if (r2 == 24) goto L18;
        if (r2 == 21) goto L18;
        return false;
    }

    private static final boolean isWhitespace(int r1) {
        if (Character.isWhitespace(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (r1 == NBSP_CODE_POINT) goto L8;
        return false;
    }

    private static final boolean isWhitespaceExceptNewline(int r1) {
        if (isWhitespace(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (isNewline(r1) == true) goto L7;
        return true;
    }

    private static final long toOffset(PointF r6) {
        float r0 = r6.x;
        float r7 = r6.y;
        return Offset.constructor-impl((Float.floatToRawIntBits(r0) << 32) | (((long) Float.floatToRawIntBits(r7)) & 4294967295L));
    }

    /* JADX INFO: renamed from: access$adjustHandwritingDeleteGestureRange-72CqOWE, reason: not valid java name */
    public static final /* synthetic */ long m1586access$adjustHandwritingDeleteGestureRange72CqOWE(long r0, CharSequence r2) {
        return m1594adjustHandwritingDeleteGestureRange72CqOWE(r0, r2);
    }

    public static final /* synthetic */ boolean access$isBiDiBoundary(TextLayoutResult r0, int r1) {
        return isBiDiBoundary(r0, r1);
    }

    public static final /* synthetic */ long access$rangeOfWhitespaces(CharSequence r0, int r1) {
        return rangeOfWhitespaces(r0, r1);
    }

    /* JADX INFO: renamed from: adjustHandwritingDeleteGestureRange-72CqOWE, reason: not valid java name */
    private static final long m1594adjustHandwritingDeleteGestureRange72CqOWE(long r5, CharSequence r7) {
        int r0 = TextRange.getStart-impl(r5);
        int r1 = TextRange.getEnd-impl(r5);
        int r2 = 10;
        if (r0 <= 0) goto L5;
        int r3 = Character.codePointBefore(r7, r0);
    L7:
        if (r1 >= r7.length()) goto L10;
        r2 = Character.codePointAt(r7, r1);
    L10:
        if (isWhitespaceExceptNewline(r3) == false) goto L22;
        if (isWhitespace(r2) == true) goto L15;
        if (isPunctuation(r2) == false) goto L22;
    L15:
        r0 = r0 - Character.charCount(r3);
        if (r0 == 0) goto L20;
        r3 = Character.codePointBefore(r7, r0);
        if (isWhitespaceExceptNewline(r3) == true) goto L15;
    L20:
        return TextRangeKt.TextRange(r0, r1);
    L22:
        if (isWhitespaceExceptNewline(r2) == true) goto L24;
        return r5;
    L24:
        if (isWhitespace(r3) == true) goto L27;
        if (isPunctuation(r3) == true) goto L27;
        return r5;
    L27:
        r1 = r1 + Character.charCount(r2);
        if (r1 == r7.length()) goto L32;
        r2 = Character.codePointAt(r7, r1);
        if (isWhitespaceExceptNewline(r2) == true) goto L27;
    L32:
        return TextRangeKt.TextRange(r0, r1);
    L5:
        r3 = 10;
        goto L7
    }

    /* JADX INFO: renamed from: enclosure-pWDy79M, reason: not valid java name */
    private static final long m1595enclosurepWDy79M(long r1, long r3) {
        return TextRangeKt.TextRange(Math.min(TextRange.getStart-impl(r1), TextRange.getStart-impl(r1)), Math.max(TextRange.getEnd-impl(r3), TextRange.getEnd-impl(r3)));
    }

    private static final boolean isBiDiBoundary(TextLayoutResult r5, int r6) {
        int r0 = r5.getLineForOffset(r6);
        if (r6 == r5.getLineStart(r0)) goto L13;
        if (r6 == TextLayoutResult.getLineEnd$default(r5, r0, false, 2, null)) goto L13;
        if (r5.getBidiRunDirection(r6) != r5.getBidiRunDirection(r6 - 1)) goto L17;
        return false;
    L17:
        return true;
    L13:
        if (r5.getParagraphDirection(r6) != r5.getBidiRunDirection(r6)) goto L18;
        return false;
    L18:
        return true;
    }

    private static final long rangeOfWhitespaces(CharSequence r3, int r4) {
        int r0 = r4;
    L3:
        if (r0 <= 0) goto L9;
        int r1 = CodepointHelpers_jvmKt.codePointBefore(r3, r0);
        if (isWhitespace(r1) == false) goto L9;
        r0 = r0 - Character.charCount(r1);
    L9:
        if (r4 >= r3.length()) goto L15;
        int r2 = CodepointHelpers_jvmKt.codePointAt(r3, r4);
        if (isWhitespace(r2) == false) goto L15;
        r4 = r4 + CodepointHelpers_jvmKt.charCount(r2);
    L15:
        return TextRangeKt.TextRange(r0, r4);
    }

    /* JADX INFO: renamed from: access$getOffsetForHandwritingGesture-d-4ec7I, reason: not valid java name */
    public static final /* synthetic */ int m1587access$getOffsetForHandwritingGestured4ec7I(LegacyTextFieldState r0, long r1, ViewConfiguration r3) {
        return m1597getOffsetForHandwritingGestured4ec7I(r0, r1, r3);
    }

    /* JADX INFO: renamed from: getLineForHandwritingGesture-d-4ec7I, reason: not valid java name */
    private static final int m1596getLineForHandwritingGestured4ec7I(MultiParagraph r5, long r6, ViewConfiguration r8) {
        if (r8 == null) goto L4;
        float r9 = r8.getHandwritingGestureLineMargin();
    L5:
        int r1 = (int) (4294967295L & r6);
        int r0 = r5.getLineForVerticalPosition(Float.intBitsToFloat(r1));
        if (Float.intBitsToFloat(r1) >= (r5.getLineTop(r0) - r9)) goto L8;
    L16:
        return -1;
    L8:
        if (Float.intBitsToFloat(r1) > (r5.getLineBottom(r0) + r9)) goto L16;
        int r7 = (int) (r6 >> 32);
        if (Float.intBitsToFloat(r7) < (-r9)) goto L16;
        if (Float.intBitsToFloat(r7) > (r5.getWidth() + r9)) goto L16;
        return r0;
    L4:
        r9 = MenuKt.ClosedAlphaTarget;
        goto L5
    }

    /* JADX INFO: renamed from: getOffsetForHandwritingGesture-d-4ec7I, reason: not valid java name */
    private static final int m1597getOffsetForHandwritingGestured4ec7I(LegacyTextFieldState r1, long r2, ViewConfiguration r4) {
        TextLayoutResultProxy r0 = r1.getLayoutResult();
        if (r0 == null) goto L9;
        TextLayoutResult r3 = r0.getValue();
        if (r3 == null) goto L9;
        MultiParagraph r5 = r3.getMultiParagraph();
        if (r5 == null) goto L9;
        return m1599getOffsetForHandwritingGestureubNVwUQ(r5, r2, r1.getLayoutCoordinates(), r4);
    L9:
        return -1;
    }

    /* JADX INFO: renamed from: access$getOffsetForHandwritingGesture-d-4ec7I, reason: not valid java name */
    public static final /* synthetic */ int m1588access$getOffsetForHandwritingGestured4ec7I(TextLayoutState r0, long r1, ViewConfiguration r3) {
        return m1598getOffsetForHandwritingGestured4ec7I(r0, r1, r3);
    }

    /* JADX INFO: renamed from: getOffsetForHandwritingGesture-d-4ec7I, reason: not valid java name */
    private static final int m1598getOffsetForHandwritingGestured4ec7I(TextLayoutState r1, long r2, ViewConfiguration r4) {
        TextLayoutResult r0 = r1.getLayoutResult();
        if (r0 == null) goto L7;
        MultiParagraph r3 = r0.getMultiParagraph();
        if (r3 == null) goto L7;
        return m1599getOffsetForHandwritingGestureubNVwUQ(r3, r2, r1.getTextLayoutNodeCoordinates(), r4);
    L7:
        return -1;
    }

    /* JADX INFO: renamed from: access$getRangeForScreenRect-OH9lIzo, reason: not valid java name */
    public static final /* synthetic */ long m1590access$getRangeForScreenRectOH9lIzo(LegacyTextFieldState r0, Rect r1, int r2, TextInclusionStrategy r3) {
        return m1602getRangeForScreenRectOH9lIzo(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: getOffsetForHandwritingGesture-ubNVwUQ, reason: not valid java name */
    private static final int m1599getOffsetForHandwritingGestureubNVwUQ(MultiParagraph r7, long r8, LayoutCoordinates r10, ViewConfiguration r11) {
        if (r10 == null) goto L9;
        long r1 = r10.screenToLocal-MK-Hz9U(r8);
        int r9 = m1596getLineForHandwritingGestured4ec7I(r7, r1, r11);
        if (r9 != (-1)) goto L8;
        return -1;
    L8:
        return r7.getOffsetForPosition-k-4lQ0M(Offset.copy-dBAh8RU$default(r1, MenuKt.ClosedAlphaTarget, (r7.getLineTop(r9) + r7.getLineBottom(r9)) / 2.0f, 1, null));
    L9:
        return -1;
    }

    /* JADX INFO: renamed from: getRangeForScreenRect-OH9lIzo, reason: not valid java name */
    private static final long m1602getRangeForScreenRectOH9lIzo(LegacyTextFieldState r1, Rect r2, int r3, TextInclusionStrategy r4) {
        TextLayoutResultProxy r0 = r1.getLayoutResult();
        if (r0 == null) goto L7;
        TextLayoutResult r5 = r0.getValue();
        if (r5 == null) goto L7;
        MultiParagraph r6 = r5.getMultiParagraph();
    L9:
        return m1601getRangeForScreenRectO048IG0(r6, r2, r1.getLayoutCoordinates(), r3, r4);
    L7:
        r6 = null;
        goto L9
    }

    /* JADX INFO: renamed from: access$getRangeForScreenRect-OH9lIzo, reason: not valid java name */
    public static final /* synthetic */ long m1591access$getRangeForScreenRectOH9lIzo(TextLayoutState r0, Rect r1, int r2, TextInclusionStrategy r3) {
        return m1603getRangeForScreenRectOH9lIzo(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: getRangeForScreenRect-OH9lIzo, reason: not valid java name */
    private static final long m1603getRangeForScreenRectOH9lIzo(TextLayoutState r1, Rect r2, int r3, TextInclusionStrategy r4) {
        TextLayoutResult r0 = r1.getLayoutResult();
        if (r0 == null) goto L5;
        MultiParagraph r5 = r0.getMultiParagraph();
    L7:
        return m1601getRangeForScreenRectO048IG0(r5, r2, r1.getTextLayoutNodeCoordinates(), r3, r4);
    L5:
        r5 = null;
        goto L7
    }

    /* JADX INFO: renamed from: access$getRangeForRemoveSpaceGesture-5iVPX68, reason: not valid java name */
    public static final /* synthetic */ long m1589access$getRangeForRemoveSpaceGesture5iVPX68(TextLayoutResult r0, long r1, long r3, LayoutCoordinates r5, ViewConfiguration r6) {
        return m1600getRangeForRemoveSpaceGesture5iVPX68(r0, r1, r3, r5, r6);
    }

    /* JADX INFO: renamed from: access$getRangeForScreenRects-O048IG0, reason: not valid java name */
    public static final /* synthetic */ long m1592access$getRangeForScreenRectsO048IG0(LegacyTextFieldState r0, Rect r1, Rect r2, int r3, TextInclusionStrategy r4) {
        return m1604getRangeForScreenRectsO048IG0(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: getRangeForRemoveSpaceGesture-5iVPX68, reason: not valid java name */
    private static final long m1600getRangeForRemoveSpaceGesture5iVPX68(TextLayoutResult r1, long r2, long r4, LayoutCoordinates r6, ViewConfiguration r7) {
        if (r1 == null) goto L17;
        if (r6 == null) goto L17;
        long r3 = r6.screenToLocal-MK-Hz9U(r2);
        long r5 = r6.screenToLocal-MK-Hz9U(r4);
        int r8 = m1596getLineForHandwritingGestured4ec7I(r1.getMultiParagraph(), r3, r7);
        int r9 = m1596getLineForHandwritingGestured4ec7I(r1.getMultiParagraph(), r5, r7);
        if (r8 != (-1)) goto L10;
        if (r9 == (-1)) goto L9;
    L14:
        float r10 = (r1.getLineTop(r9) + r1.getLineBottom(r9)) / 2;
        int r11 = (int) (r3 >> 32);
        int r12 = (int) (r5 >> 32);
        return r1.getMultiParagraph().getRangeForRect-8-6BmAI(new Rect(Math.min(Float.intBitsToFloat(r11), Float.intBitsToFloat(r12)), r10 - 0.1f, Math.max(Float.intBitsToFloat(r11), Float.intBitsToFloat(r12)), r10 + 0.1f), TextGranularity.Companion.getCharacter-DRrd7Zo(), TextInclusionStrategy.Companion.getAnyOverlap());
    L9:
        return TextRange.Companion.getZero-d9O1mEE();
    L10:
        if (r9 == (-1)) goto L13;
        r8 = Math.min(r8, r9);
    L13:
        r9 = r8;
    L17:
        return TextRange.Companion.getZero-d9O1mEE();
    }

    /* JADX INFO: renamed from: getRangeForScreenRect-O048IG0, reason: not valid java name */
    private static final long m1601getRangeForScreenRectO048IG0(MultiParagraph r2, Rect r3, LayoutCoordinates r4, int r5, TextInclusionStrategy r6) {
        if (r2 == null) goto L8;
        if (r4 == null) goto L8;
        return r2.getRangeForRect-8-6BmAI(r3.translate-k-4lQ0M(r4.screenToLocal-MK-Hz9U(Offset.Companion.getZero-F1C5BW0())), r5, r6);
    L8:
        return TextRange.Companion.getZero-d9O1mEE();
    }

    /* JADX INFO: renamed from: getRangeForScreenRects-O048IG0, reason: not valid java name */
    private static final long m1604getRangeForScreenRectsO048IG0(LegacyTextFieldState r2, Rect r3, Rect r4, int r5, TextInclusionStrategy r6) {
        long r0 = m1602getRangeForScreenRectOH9lIzo(r2, r3, r5, r6);
        if (TextRange.getCollapsed-impl(r0) == true) goto L5;
        long r7 = m1602getRangeForScreenRectOH9lIzo(r2, r4, r5, r6);
        if (TextRange.getCollapsed-impl(r7) == false) goto L11;
        return TextRange.Companion.getZero-d9O1mEE();
    L11:
        return m1595enclosurepWDy79M(r0, r7);
    L5:
        return TextRange.Companion.getZero-d9O1mEE();
    }

    /* JADX INFO: renamed from: access$getRangeForScreenRects-O048IG0, reason: not valid java name */
    public static final /* synthetic */ long m1593access$getRangeForScreenRectsO048IG0(TextLayoutState r0, Rect r1, Rect r2, int r3, TextInclusionStrategy r4) {
        return m1605getRangeForScreenRectsO048IG0(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: getRangeForScreenRects-O048IG0, reason: not valid java name */
    private static final long m1605getRangeForScreenRectsO048IG0(TextLayoutState r2, Rect r3, Rect r4, int r5, TextInclusionStrategy r6) {
        long r0 = m1603getRangeForScreenRectOH9lIzo(r2, r3, r5, r6);
        if (TextRange.getCollapsed-impl(r0) == true) goto L5;
        long r7 = m1603getRangeForScreenRectOH9lIzo(r2, r4, r5, r6);
        if (TextRange.getCollapsed-impl(r7) == false) goto L11;
        return TextRange.Companion.getZero-d9O1mEE();
    L11:
        return m1595enclosurepWDy79M(r0, r7);
    L5:
        return TextRange.Companion.getZero-d9O1mEE();
    }
}
