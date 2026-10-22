package androidx.appcompat.view;

import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class WindowCallbackWrapper implements Window.Callback {
    final Window.Callback mWrapped;

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.mWrapped.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.mWrapped.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.mWrapped.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.mWrapped.onSearchRequested();
    }

    public final Window.Callback getWrapped() {
        return this.mWrapped;
    }

    public WindowCallbackWrapper(Window.Callback r2) {
        if (r2 == null) goto L7;
        this.mWrapped = r2;
        return;
    L7:
        throw new IllegalArgumentException("Window callback may not be null");
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent r2) {
        return this.mWrapped.dispatchGenericMotionEvent(r2);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r2) {
        return this.mWrapped.dispatchKeyEvent(r2);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r2) {
        return this.mWrapped.dispatchKeyShortcutEvent(r2);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r2) {
        return this.mWrapped.dispatchPopulateAccessibilityEvent(r2);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r2) {
        return this.mWrapped.dispatchTouchEvent(r2);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent r2) {
        return this.mWrapped.dispatchTrackballEvent(r2);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(android.view.ActionMode r2) {
        this.mWrapped.onActionModeFinished(r2);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(android.view.ActionMode r2) {
        this.mWrapped.onActionModeStarted(r2);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int r2) {
        return this.mWrapped.onCreatePanelView(r2);
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean r2) {
        this.mWrapped.onPointerCaptureChanged(r2);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent r2) {
        return this.mWrapped.onSearchRequested(r2);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams r2) {
        this.mWrapped.onWindowAttributesChanged(r2);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean r2) {
        this.mWrapped.onWindowFocusChanged(r2);
    }

    @Override // android.view.Window.Callback
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r2) {
        return this.mWrapped.onWindowStartingActionMode(r2);
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int r2, Menu r3) {
        return this.mWrapped.onCreatePanelMenu(r2, r3);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int r2, MenuItem r3) {
        return this.mWrapped.onMenuItemSelected(r2, r3);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int r2, Menu r3) {
        return this.mWrapped.onMenuOpened(r2, r3);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int r2, Menu r3) {
        this.mWrapped.onPanelClosed(r2, r3);
    }

    @Override // android.view.Window.Callback
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r2, int r3) {
        return this.mWrapped.onWindowStartingActionMode(r2, r3);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int r2, View r3, Menu r4) {
        return this.mWrapped.onPreparePanel(r2, r3, r4);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> r2, Menu r3, int r4) {
        this.mWrapped.onProvideKeyboardShortcuts(r2, r3, r4);
    }
}
