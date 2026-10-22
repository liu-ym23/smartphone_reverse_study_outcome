package androidx.compose.foundation.text.contextmenu.internal;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/PrimaryTextActionModeCallback;", "Landroid/view/ActionMode$Callback;", "textActionModeCallback", "Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;)V", "onCreateActionMode", "", "mode", "Landroid/view/ActionMode;", "menu", "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroyActionMode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PrimaryTextActionModeCallback implements ActionMode.Callback {
    private final TextActionModeCallback textActionModeCallback;

    public PrimaryTextActionModeCallback(TextActionModeCallback r1) {
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
}
