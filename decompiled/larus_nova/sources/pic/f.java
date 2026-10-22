package pic;

import android.os.Build;
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

/* JADX INFO: loaded from: classes40.dex */
public class f implements Window.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window.Callback f529439a;

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f529439a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        this.f529439a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f529439a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f529439a.onSearchRequested();
    }

    public f(Window.Callback r100) {
        if (r100 == null) goto L7;
        this.f529439a = r100;
        return;
    L7:
        throw new IllegalArgumentException("Window callback may not be null");
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent r100) {
        return this.f529439a.dispatchGenericMotionEvent(r100);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r100) {
        return this.f529439a.dispatchKeyEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent r100) {
        return this.f529439a.dispatchKeyShortcutEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r100) {
        return this.f529439a.dispatchPopulateAccessibilityEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        return this.f529439a.dispatchTouchEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent r100) {
        return this.f529439a.dispatchTrackballEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode r100) {
        this.f529439a.onActionModeFinished(r100);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode r100) {
        this.f529439a.onActionModeStarted(r100);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int r100) {
        return this.f529439a.onCreatePanelView(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        return this.f529439a.onSearchRequested(r100);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams r100) {
        this.f529439a.onWindowAttributesChanged(r100);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r100) {
        this.f529439a.onWindowFocusChanged(r100);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback r100) {
        return this.f529439a.onWindowStartingActionMode(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int r100, Menu r101) {
        return this.f529439a.onCreatePanelMenu(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int r100, MenuItem r101) {
        return this.f529439a.onMenuItemSelected(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int r100, Menu r101) {
        return this.f529439a.onMenuOpened(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int r100, Menu r101) {
        this.f529439a.onPanelClosed(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback r100, int r101) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return null;
    L5:
        return this.f529439a.onWindowStartingActionMode(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int r100, View r101, Menu r102) {
        return this.f529439a.onPreparePanel(r100, r101, r102);
    }
}
