package androidx.compose.foundation.text.contextmenu.internal;

import android.os.Build;
import android.view.ActionMode;
import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/TextToolbarHelper;", "", "<init>", "()V", "startActionMode", "Landroid/view/ActionMode;", "view", "Landroid/view/View;", "textActionModeCallback", "Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;", "invalidateContentRect", "", "actionMode", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TextToolbarHelper {
    public static final TextToolbarHelper INSTANCE = null;

    static {
        INSTANCE = new TextToolbarHelper();
    }

    private TextToolbarHelper() {
    }

    public final void invalidateContentRect(ActionMode r3) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        TextToolbarHelperApi23.INSTANCE.invalidateContentRect(r3);
        return;
    }

    public final ActionMode startActionMode(View r3, TextActionModeCallback r4) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return TextToolbarHelperApi23.INSTANCE.startActionMode(r3, new FloatingTextActionModeCallback(r4), 1);
    L6:
        return r3.startActionMode(new PrimaryTextActionModeCallback(r4));
    }
}
