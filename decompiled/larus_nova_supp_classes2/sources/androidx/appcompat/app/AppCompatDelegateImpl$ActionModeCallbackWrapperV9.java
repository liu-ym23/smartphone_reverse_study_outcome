package androidx.appcompat.app;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.view.ActionMode;
import androidx.compose.material3.MenuKt;
import androidx.core.view.ViewCompat;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDelegateImpl$ActionModeCallbackWrapperV9 implements ActionMode.Callback {
    private ActionMode.Callback mWrapped;
    final /* synthetic */ AppCompatDelegateImpl this$0;

    public static View INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl$ActionModeCallbackWrapperV9_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode r3) {
        this.mWrapped.onDestroyActionMode(r3);
        AppCompatDelegateImpl r4 = this.this$0;
        if (r4.mActionModePopup == null) goto L5;
        INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl$ActionModeCallbackWrapperV9_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r4.mWindow).removeCallbacks(this.this$0.mShowActionModePopup);
    L5:
        AppCompatDelegateImpl r5 = this.this$0;
        if (r5.mActionModeView == null) goto L8;
        r5.endOnGoingFadeAnimation();
        AppCompatDelegateImpl r6 = this.this$0;
        r6.mFadeAnim = ViewCompat.animate(r6.mActionModeView).alpha(MenuKt.ClosedAlphaTarget);
        this.this$0.mFadeAnim.setListener(new AnonymousClass1(this));
    L8:
        AppCompatDelegateImpl r7 = this.this$0;
        AppCompatCallback r0 = r7.mAppCompatCallback;
        if (r0 == null) goto L11;
        r0.onSupportActionModeFinished(r7.mActionMode);
    L11:
        AppCompatDelegateImpl r8 = this.this$0;
        r8.mActionMode = null;
        ViewCompat.requestApplyInsets(r8.mSubDecor);
    }

    public AppCompatDelegateImpl$ActionModeCallbackWrapperV9(AppCompatDelegateImpl r1, ActionMode.Callback r2) {
        this.this$0 = r1;
        this.mWrapped = r2;
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode r2, MenuItem r3) {
        return this.mWrapped.onActionItemClicked(r2, r3);
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode r2, Menu r3) {
        return this.mWrapped.onCreateActionMode(r2, r3);
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode r2, Menu r3) {
        ViewCompat.requestApplyInsets(this.this$0.mSubDecor);
        return this.mWrapped.onPrepareActionMode(r2, r3);
    }
}
