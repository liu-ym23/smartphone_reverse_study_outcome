package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001as\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015H\u0000¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"ceilToIntPx", "", "", "updateTextDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "current", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "updateTextDelegate-rm0N8CA", "(Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;ZIIILjava/util/List;)Landroidx/compose/foundation/text/TextDelegate;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextDelegateKt {
    public static final int ceilToIntPx(float r2) {
        return Math.round((float) Math.ceil(r2));
    }

    /* JADX INFO: renamed from: updateTextDelegate-rm0N8CA, reason: not valid java name */
    public static final TextDelegate m1447updateTextDelegaterm0N8CA(TextDelegate r12, AnnotatedString r13, TextStyle r14, Density r15, FontFamily.Resolver r16, boolean r17, int r18, int r19, int r20, List<AnnotatedString.Range<Placeholder>> r21) {
        if (Intrinsics.areEqual(r12.getText(), r13) == false) goto L35;
        if (Intrinsics.areEqual(r12.getStyle(), r14) == false) goto L35;
        if (r12.getSoftWrap() != r17) goto L35;
        if (TextOverflow.equals-impl0(r12.m1445getOverflowgIe3tQ8(), r18) == false) goto L35;
        if (r12.getMaxLines() != r19) goto L35;
        if (r12.getMinLines() != r20) goto L35;
        if (Intrinsics.areEqual(r12.getDensity(), r15) == false) goto L35;
        if (Intrinsics.areEqual(r12.getPlaceholders(), r21) == false) goto L35;
        if (r12.getFontFamilyResolver() != r16) goto L35;
        return r12;
    L35:
        return new TextDelegate(r13, r14, r19, r20, r17, r18, r15, r16, r21, null);
    }

    /* JADX INFO: renamed from: updateTextDelegate-rm0N8CA$default, reason: not valid java name */
    public static /* synthetic */ TextDelegate m1448updateTextDelegaterm0N8CA$default(TextDelegate r13, AnnotatedString r14, TextStyle r15, Density r16, FontFamily.Resolver r17, boolean r18, int r19, int r20, int r21, List r22, int r23, Object r24) {
        if ((r23 & 32) == 0) goto L5;
        boolean r8 = true;
    L7:
        if ((r23 & 64) == 0) goto L9;
        int r9 = TextOverflow.Companion.getClip-gIe3tQ8();
    L11:
        if ((r23 & 128) == 0) goto L13;
        int r10 = Integer.MAX_VALUE;
    L15:
        if ((r23 & 256) == 0) goto L17;
        int r11 = 1;
    L19:
        return m1447updateTextDelegaterm0N8CA(r13, r14, r15, r16, r17, r8, r9, r10, r11, r22);
    L17:
        r11 = r21;
        goto L19
    L13:
        r10 = r20;
        goto L15
    L9:
        r9 = r19;
        goto L11
    L5:
        r8 = r18;
        goto L7
    }
}
