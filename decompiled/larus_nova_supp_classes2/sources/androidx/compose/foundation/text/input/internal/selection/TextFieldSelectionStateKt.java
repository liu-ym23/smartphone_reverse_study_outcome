package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a5\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0004\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0080\b\u001a\u0016\u0010\u0010\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0002\"\u000e\u0010\r\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"reverse", "Landroidx/compose/ui/text/TextRange;", "reverse-5zc-tL8", "(J)J", "menuItem", "Lkotlin/Function0;", "", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "enabled", "", "desiredState", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "operation", "DEBUG", "DEBUG_TAG", "", "logDebug", "text", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldSelectionStateKt {
    private static final boolean DEBUG = false;
    private static final String DEBUG_TAG = "TextFieldSelectionState";

    private static final void logDebug(Function0<String> r0) {
    }

    public static final /* synthetic */ void access$logDebug(Function0 r0) {
        logDebug(r0);
    }

    /* JADX INFO: renamed from: access$reverse-5zc-tL8, reason: not valid java name */
    public static final /* synthetic */ long m1731access$reverse5zctL8(long r0) {
        return m1732reverse5zctL8(r0);
    }

    /* JADX INFO: renamed from: reverse-5zc-tL8, reason: not valid java name */
    private static final long m1732reverse5zctL8(long r1) {
        return TextRangeKt.TextRange(TextRange.getEnd-impl(r1), TextRange.getStart-impl(r1));
    }

    public static final Function0<Unit> menuItem(final TextFieldSelectionState r0, boolean r1, final TextToolbarState r2, final Function0<Unit> r3) {
        if (r1 == true) goto L5;
        return null;
    L5:
        return new AnonymousClass1(r3, r0, r2);
    }
}
