package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/text/input/internal/CursorAnchorInfoApi34Helper;", "", "<init>", "()V", "addVisibleLineBounds", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "builder", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CursorAnchorInfoApi34Helper {
    public static final int $stable = 0;
    public static final CursorAnchorInfoApi34Helper INSTANCE = null;

    static {
        INSTANCE = new CursorAnchorInfoApi34Helper();
    }

    private CursorAnchorInfoApi34Helper() {
    }

    @JvmStatic
    public static final CursorAnchorInfo.Builder addVisibleLineBounds(CursorAnchorInfo.Builder r5, TextLayoutResult r6, Rect r7) {
        if (r7.isEmpty() == true) goto L9;
        int r0 = r6.getLineForVerticalPosition(r7.getTop());
        int r8 = r6.getLineForVerticalPosition(r7.getBottom());
        if (r0 > r8) goto L9;
    L6:
        r5.addVisibleLineBounds(r6.getLineLeft(r0), r6.getLineTop(r0), r6.getLineRight(r0), r6.getLineBottom(r0));
        if (r0 == r8) goto L9;
        r0 = r0 + 1;
    L9:
        return r5;
    }
}
