package es3;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class n implements Window.Callback {
    public final Window.Callback a;

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        this.a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.a.onSearchRequested();
    }

    public n(Window.Callback r1) {
        this.a = r1;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent r2) {
        return this.a.dispatchGenericMotionEvent(r2);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent r2) {
        return this.a.dispatchKeyShortcutEvent(r2);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r2) {
        return this.a.dispatchPopulateAccessibilityEvent(r2);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent r2) {
        return this.a.dispatchTrackballEvent(r2);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode r2) {
        this.a.onActionModeFinished(r2);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode r2) {
        this.a.onActionModeStarted(r2);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int r2) {
        return this.a.onCreatePanelView(r2);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent r2) {
        return this.a.onSearchRequested(r2);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams r2) {
        this.a.onWindowAttributesChanged(r2);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r2) {
        this.a.onWindowFocusChanged(r2);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback r2) {
        return this.a.onWindowStartingActionMode(r2);
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int r2, Menu r3) {
        return this.a.onCreatePanelMenu(r2, r3);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int r2, MenuItem r3) {
        return this.a.onMenuItemSelected(r2, r3);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int r2, Menu r3) {
        return this.a.onMenuOpened(r2, r3);
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int r2, Menu r3) {
        this.a.onPanelClosed(r2, r3);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback r2, int r3) {
        return this.a.onWindowStartingActionMode(r2, r3);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int r2, View r3, Menu r4) {
        return this.a.onPreparePanel(r2, r3, r4);
    }
}
