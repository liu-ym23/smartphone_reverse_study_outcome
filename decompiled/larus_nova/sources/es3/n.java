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

/* JADX INFO: loaded from: classes14.dex */
public abstract class n implements Window.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window.Callback f473767a;

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f473767a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        this.f473767a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f473767a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f473767a.onSearchRequested();
    }

    public n(Window.Callback r100) {
        this.f473767a = r100;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent r100) {
        return this.f473767a.dispatchGenericMotionEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent r100) {
        return this.f473767a.dispatchKeyShortcutEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r100) {
        return this.f473767a.dispatchPopulateAccessibilityEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent r100) {
        return this.f473767a.dispatchTrackballEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode r100) {
        this.f473767a.onActionModeFinished(r100);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode r100) {
        this.f473767a.onActionModeStarted(r100);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int r100) {
        return this.f473767a.onCreatePanelView(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent r100) {
        return this.f473767a.onSearchRequested(r100);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams r100) {
        this.f473767a.onWindowAttributesChanged(r100);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r100) {
        this.f473767a.onWindowFocusChanged(r100);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback r100) {
        return this.f473767a.onWindowStartingActionMode(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int r100, Menu r101) {
        return this.f473767a.onCreatePanelMenu(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int r100, MenuItem r101) {
        return this.f473767a.onMenuItemSelected(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int r100, Menu r101) {
        return this.f473767a.onMenuOpened(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int r100, Menu r101) {
        this.f473767a.onPanelClosed(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback r100, int r101) {
        return this.f473767a.onWindowStartingActionMode(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int r100, View r101, Menu r102) {
        return this.f473767a.onPreparePanel(r100, r101, r102);
    }
}
