package androidx.appcompat.app;

import android.os.Build;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.internal.view.SupportMenu;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDelegateImpl$AppCompatWindowCallback extends WindowCallbackWrapper {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public void onContentChanged() {
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r2) {
        if (this.this$0.dispatchKeyEvent(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.dispatchKeyEvent(r2) == true) goto L8;
        return false;
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r3) {
        if (super.dispatchKeyShortcutEvent(r3) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.this$0.onKeyShortcut(r3.getKeyCode(), r3) == true) goto L8;
        return false;
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r3) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return null;
    L7:
        if (this.this$0.isHandleNativeActionModesEnabled() == false) goto L11;
        return startAsSupportActionMode(r3);
    L11:
        return super.onWindowStartingActionMode(r3);
    }

    public final ActionMode startAsSupportActionMode(ActionMode.Callback r3) {
        SupportActionModeWrapper.CallbackWrapper r0 = new SupportActionModeWrapper.CallbackWrapper(this.this$0.mContext, r3);
        androidx.appcompat.view.ActionMode r4 = this.this$0.startSupportActionMode(r0);
        if (r4 != null) goto L5;
        return null;
    L5:
        return r0.getActionModeWrapper(r4);
    }

    public AppCompatDelegateImpl$AppCompatWindowCallback(AppCompatDelegateImpl r1, Window.Callback r2) {
        this.this$0 = r1;
        super(r2);
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r2, Menu r3) {
        if (r2 != 0) goto L8;
        if ((r3 instanceof MenuBuilder) == true) goto L8;
        return false;
    L8:
        return super.onCreatePanelMenu(r2, r3);
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public boolean onMenuOpened(int r1, Menu r2) {
        super.onMenuOpened(r1, r2);
        this.this$0.onMenuOpened(r1);
        return true;
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public void onPanelClosed(int r1, Menu r2) {
        super.onPanelClosed(r1, r2);
        this.this$0.onPanelClosed(r1);
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r2, int r3) {
        if (this.this$0.isHandleNativeActionModesEnabled() == false) goto L9;
        if (r3 != 0) goto L9;
        return startAsSupportActionMode(r2);
    L9:
        return super.onWindowStartingActionMode(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public boolean onPreparePanel(int r4, View r5, Menu r6) {
        if ((r6 instanceof MenuBuilder) == false) goto L5;
        MenuBuilder r0 = (MenuBuilder) r6;
    L7:
        if (r4 != 0) goto L10;
        if (r0 != null) goto L10;
        return false;
    L10:
        if (r0 == null) goto L12;
        r0.setOverrideVisibleItems(true);
    L12:
        boolean r7 = super.onPreparePanel(r4, r5, r6);
        if (r0 == null) goto L15;
        r0.setOverrideVisibleItems(false);
    L15:
        return r7;
    L5:
        r0 = null;
        goto L7
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> r4, Menu r5, int r6) {
        AppCompatDelegateImpl$PanelFeatureState r0 = this.this$0.getPanelState(0, true);
        if (r0 == null) goto L7;
        SupportMenu r1 = r0.menu;
        if (r1 == null) goto L7;
        super.onProvideKeyboardShortcuts(r4, r1, r6);
        return;
    L7:
        super.onProvideKeyboardShortcuts(r4, r5, r6);
    }
}
