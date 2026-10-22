package com.bytedance.timonbase.scene.silenceimpl;

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

/* JADX INFO: loaded from: classes22.dex */
public final class d implements Window.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window.Callback f270898a;

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f270898a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        this.f270898a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f270898a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f270898a.onSearchRequested();
    }

    public d(Window.Callback r100) {
        this.f270898a = r100;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent r100) {
        return this.f270898a.dispatchGenericMotionEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        b.a();
        return this.f270898a.dispatchKeyEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent r100) {
        b.a();
        return this.f270898a.dispatchKeyShortcutEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r100) {
        return this.f270898a.dispatchPopulateAccessibilityEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100.getAction() != 0) goto L6;
        b.a();
    L6:
        return this.f270898a.dispatchTouchEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent r100) {
        return this.f270898a.dispatchTrackballEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode r100) {
        this.f270898a.onActionModeFinished(r100);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode r100) {
        this.f270898a.onActionModeStarted(r100);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int r100) {
        return this.f270898a.onCreatePanelView(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent r100) {
        return this.f270898a.onSearchRequested(r100);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams r100) {
        this.f270898a.onWindowAttributesChanged(r100);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r100) {
        this.f270898a.onWindowFocusChanged(r100);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback r100) {
        return this.f270898a.onWindowStartingActionMode(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int r100, Menu r101) {
        return this.f270898a.onCreatePanelMenu(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int r100, MenuItem r101) {
        return this.f270898a.onMenuItemSelected(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int r100, Menu r101) {
        return this.f270898a.onMenuOpened(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int r100, Menu r101) {
        this.f270898a.onPanelClosed(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback r100, int r101) {
        return this.f270898a.onWindowStartingActionMode(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int r100, View r101, Menu r102) {
        return this.f270898a.onPreparePanel(r100, r101, r102);
    }
}
