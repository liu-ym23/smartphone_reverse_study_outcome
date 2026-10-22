package androidx.appcompat.app;

import android.view.Window;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class AppCompatDelegateImpl$ActionMenuPresenterCallback implements MenuPresenter.Callback {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$ActionMenuPresenterCallback(AppCompatDelegateImpl r1) {
        this.this$0 = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(MenuBuilder r3) {
        Window.Callback r0 = this.this$0.getWindowCallback();
        if (r0 == null) goto L7;
        r0.onMenuOpened(108, r3);
        return true;
    L7:
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void onCloseMenu(MenuBuilder r1, boolean r2) {
        this.this$0.checkCloseActionMenu(r1);
    }
}
