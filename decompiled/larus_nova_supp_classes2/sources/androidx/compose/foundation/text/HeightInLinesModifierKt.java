package androidx.compose.foundation.text;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\u001a(\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u0084\u0002"}, d2 = {"DefaultMinLines", "", "heightInLines", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "minLines", "maxLines", "validateMinMaxLines", "", "foundation_release", "typeface", ""}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HeightInLinesModifierKt {
    public static final int DefaultMinLines = 1;

    public static final void validateMinMaxLines(int r4, int r5) {
        boolean r0 = true;
        if (r4 <= 0) goto L6;
        if (r5 <= 0) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("both minLines " + r4 + " and maxLines " + r5 + " must be greater than zero");
    L9:
        if (r4 <= r5) goto L12;
        r0 = false;
    L12:
        if (r0 == true) goto L15;
        InlineClassHelperKt.throwIllegalArgumentException("minLines " + r4 + " must be less than or equal to maxLines " + r5);
        return;
    L15:
        return;
    L6:
        r2 = false;
        goto L7
    }

    public static final Modifier heightInLines(Modifier r2, final TextStyle r3, final int r4, final int r5) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new HeightInLinesModifierKt$heightInLines$$inlined$debugInspectorInfo$1(r4, r5, r3);
    L7:
        return ComposedModifierKt.composed(r2, r0, new AnonymousClass2(r4, r5, r3));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    public static /* synthetic */ Modifier heightInLines$default(Modifier r0, TextStyle r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 1;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = Integer.MAX_VALUE;
    L9:
        return heightInLines(r0, r1, r2, r3);
    }
}
