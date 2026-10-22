package com.bytedance.sysoptimizer.appcompact;

import android.view.ActionMode;
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

/* JADX INFO: loaded from: classes22.dex */
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

    public WindowCallbackWrapper(Window.Callback r100) {
        if (r100 == null) goto L7;
        this.mWrapped = r100;
        return;
    L7:
        throw new IllegalArgumentException("Window callback may not be null");
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent r100) {
        return this.mWrapped.dispatchGenericMotionEvent(r100);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r100) {
        return this.mWrapped.dispatchKeyEvent(r100);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r100) {
        return this.mWrapped.dispatchKeyShortcutEvent(r100);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r100) {
        return this.mWrapped.dispatchPopulateAccessibilityEvent(r100);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r100) {
        return this.mWrapped.dispatchTouchEvent(r100);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent r100) {
        return this.mWrapped.dispatchTrackballEvent(r100);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode r100) {
        this.mWrapped.onActionModeFinished(r100);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode r100) {
        this.mWrapped.onActionModeStarted(r100);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int r100) {
        return this.mWrapped.onCreatePanelView(r100);
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean r100) {
        this.mWrapped.onPointerCaptureChanged(r100);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent r100) {
        return this.mWrapped.onSearchRequested(r100);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams r100) {
        this.mWrapped.onWindowAttributesChanged(r100);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean r100) {
        this.mWrapped.onWindowFocusChanged(r100);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r100) {
        return this.mWrapped.onWindowStartingActionMode(r100);
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int r100, Menu r101) {
        return this.mWrapped.onCreatePanelMenu(r100, r101);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int r100, MenuItem r101) {
        return this.mWrapped.onMenuItemSelected(r100, r101);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int r100, Menu r101) {
        return this.mWrapped.onMenuOpened(r100, r101);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int r100, Menu r101) {
        this.mWrapped.onPanelClosed(r100, r101);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r100, int r101) {
        return this.mWrapped.onWindowStartingActionMode(r100, r101);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int r100, View r101, Menu r102) {
        return this.mWrapped.onPreparePanel(r100, r101, r102);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> r100, Menu r101, int r102) {
        this.mWrapped.onProvideKeyboardShortcuts(r100, r101, r102);
    }
}
