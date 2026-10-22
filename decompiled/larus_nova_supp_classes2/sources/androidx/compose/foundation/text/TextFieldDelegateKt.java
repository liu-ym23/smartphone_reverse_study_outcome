package androidx.compose.foundation.text;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0010\u001a.\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001a"}, d2 = {"DefaultWidthCharCount", "", "EmptyTextReplacement", "", "getEmptyTextReplacement", "()Ljava/lang/String;", "computeSizeForDefaultText", "Landroidx/compose/ui/unit/IntSize;", "style", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "text", "maxLines", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/lang/String;I)J", "focusedRectInRoot", "Landroidx/compose/ui/geometry/Rect;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusOffset", "sizeForDefaultText", "Lkotlin/Function0;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldDelegateKt {
    public static final int DefaultWidthCharCount = 10;
    private static final String EmptyTextReplacement = null;

    static {
        EmptyTextReplacement = StringsKt.repeat("H", 10);
    }

    public static final String getEmptyTextReplacement() {
        return EmptyTextReplacement;
    }

    public static final Rect focusedRectInRoot(TextLayoutResult r8, LayoutCoordinates r9, int r10, Function0<IntSize> r11) {
        if (r10 >= r8.getLayoutInput().getText().length()) goto L5;
        Rect r12 = r8.getBoundingBox(r10);
    L8:
        float r13 = r12.getLeft();
        float r14 = r12.getTop();
        long r3 = Float.floatToRawIntBits(r13);
        long r15 = r9.localToRoot-MK-Hz9U(Offset.constructor-impl((((long) Float.floatToRawIntBits(r14)) & 4294967295L) | (r3 << 32)));
        float r16 = Float.intBitsToFloat((int) (r15 >> 32));
        float r17 = Float.intBitsToFloat((int) (r15 & 4294967295L));
        long r18 = Offset.constructor-impl((Float.floatToRawIntBits(r16) << 32) | (Float.floatToRawIntBits(r17) & 4294967295L));
        float r19 = r12.getRight() - r12.getLeft();
        float r4 = r12.getBottom() - r12.getTop();
        long r5 = Float.floatToRawIntBits(r19);
        return RectKt.Rect-tz77jQw(r18, Size.constructor-impl((Float.floatToRawIntBits(r4) & 4294967295L) | (r5 << 32)));
    L5:
        if (r10 == 0) goto L7;
        r12 = r8.getBoundingBox(r10 - 1);
        goto L8
    L7:
        r12 = new Rect(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 1.0f, (int) (((IntSize) r11.invoke()).unbox-impl() & 4294967295L));
        goto L8
    }

    public static final long computeSizeForDefaultText(TextStyle r12, Density r13, FontFamily.Resolver r14, String r15, int r16) {
        List r6 = CollectionsKt.emptyList();
        int r9 = TextOverflow.Companion.getClip-gIe3tQ8();
        Paragraph r0 = ParagraphKt.Paragraph-Ul8oQg4$default(r15, r12, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), r13, r14, r6, null, r16, r9, 64, null);
        int r1 = TextDelegateKt.ceilToIntPx(r0.getMinIntrinsicWidth());
        return IntSize.constructor-impl((((long) r1) << 32) | (((long) TextDelegateKt.ceilToIntPx(r0.getHeight())) & 4294967295L));
    }

    public static /* synthetic */ long computeSizeForDefaultText$default(TextStyle r0, Density r1, FontFamily.Resolver r2, String r3, int r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r3 = EmptyTextReplacement;
    L6:
        if ((r5 & 16) == 0) goto L9;
        r4 = 1;
    L9:
        return computeSizeForDefaultText(r0, r1, r2, r3, r4);
    }
}
