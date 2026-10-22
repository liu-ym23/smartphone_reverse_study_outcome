package androidx.compose.foundation.text.contextmenu.internal;

import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/FloatingTextActionModeCallback;", "Landroid/view/ActionMode$Callback2;", "Landroid/view/ActionMode$Callback;", "textActionModeCallback", "Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;)V", "onCreateActionMode", "", "mode", "Landroid/view/ActionMode;", "menu", "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroyActionMode", "", "onGetContentRect", "view", "Landroid/view/View;", "outRect", "Landroid/graphics/Rect;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class FloatingTextActionModeCallback extends ActionMode.Callback2 implements ActionMode.Callback {
    private final TextActionModeCallback textActionModeCallback;

    public FloatingTextActionModeCallback(TextActionModeCallback r1) {
        this.textActionModeCallback = r1;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode r2) {
        this.textActionModeCallback.onDestroyActionMode(r2);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode r2, MenuItem r3) {
        return this.textActionModeCallback.onActionItemClicked(r2, r3);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode r2, Menu r3) {
        return this.textActionModeCallback.onCreateActionMode(r2, r3);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode r2, Menu r3) {
        return this.textActionModeCallback.onPrepareActionMode(r2, r3);
    }

    @Override // android.view.ActionMode.Callback2
    public void onGetContentRect(ActionMode r3, View r4, Rect r5) {
        androidx.compose.ui.geometry.Rect r6 = this.textActionModeCallback.onGetContentRect(r3, r4);
        r5.set(Math.round(r6.getLeft()), Math.round(r6.getTop()), Math.round(r6.getRight()), Math.round(r6.getBottom()));
    }
}
