package androidx.appcompat.app;

import android.view.Window;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class AppCompatDelegateImpl$PanelMenuPresenterCallback implements MenuPresenter.Callback {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$PanelMenuPresenterCallback(AppCompatDelegateImpl r1) {
        this.this$0 = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(MenuBuilder r3) {
        if (r3 != r3.getRootMenu()) goto L13;
        AppCompatDelegateImpl r0 = this.this$0;
        if (r0.mHasActionBar == false) goto L14;
        Window.Callback r1 = r0.getWindowCallback();
        if (r1 != null) goto L9;
        return true;
    L9:
        if (this.this$0.mIsDestroyed == true) goto L16;
        r1.onMenuOpened(108, r3);
        return true;
    L16:
        return true;
    L14:
        return true;
    L13:
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void onCloseMenu(MenuBuilder r5, boolean r6) {
        SupportMenu r0 = r5.getRootMenu();
        if (r0 == r5) goto L5;
        boolean r2 = true;
    L6:
        AppCompatDelegateImpl r3 = this.this$0;
        SupportMenu r7 = r5;
        if (r2 == false) goto L9;
        r7 = r0;
    L9:
        AppCompatDelegateImpl$PanelFeatureState r8 = r3.findMenuPanel(r7);
        if (r8 == null) goto L15;
        if (r2 == false) goto L13;
        this.this$0.callOnPanelClosed(r8.featureId, r8, r0);
        this.this$0.closePanel(r8, true);
        return;
    L13:
        this.this$0.closePanel(r8, r6);
        return;
    L15:
        return;
    L5:
        r2 = false;
        goto L6
    }
}
