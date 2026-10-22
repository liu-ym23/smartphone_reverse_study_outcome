package androidx.appcompat.app;

import android.view.View;
import android.widget.PopupWindow;
import androidx.compose.material3.MenuKt;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDelegateImpl$6 implements Runnable {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    @Override // java.lang.Runnable
    public void run() {
        androidx_appcompat_app_AppCompatDelegateImpl$6_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void androidx_appcompat_app_AppCompatDelegateImpl$6__run$___twin___() {
        AppCompatDelegateImpl r0 = this.this$0;
        INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl$6_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(r0.mActionModePopup, r0.mActionModeView, 55, 0, 0);
        this.this$0.endOnGoingFadeAnimation();
        if (this.this$0.shouldAnimateActionModeView() == false) goto L5;
        this.this$0.mActionModeView.setAlpha(MenuKt.ClosedAlphaTarget);
        AppCompatDelegateImpl r1 = this.this$0;
        r1.mFadeAnim = ViewCompat.animate(r1.mActionModeView).alpha(1.0f);
        this.this$0.mFadeAnim.setListener(new AnonymousClass1(this));
        return;
    L5:
        this.this$0.mActionModeView.setAlpha(1.0f);
        this.this$0.mActionModeView.setVisibility(0);
    }

    public AppCompatDelegateImpl$6(AppCompatDelegateImpl r1) {
        this.this$0 = r1;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_appcompat_app_AppCompatDelegateImpl$6_com_larus_apm_impl_protector_RunnableLancet_run(AppCompatDelegateImpl$6 r1) {
        r1.androidx_appcompat_app_AppCompatDelegateImpl$6__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public static void INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDelegateImpl$6_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(PopupWindow r7, View r8, int r9, int r10, int r11) {
        if (PopupWindowLancet.hasSubWindowToken(r8) == false) goto L6;
        return;
    L6:
        if ((r7 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r0 = PopupWindowLancet.resolveSource(r8);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r7, r8, r0, r9, r10, r11) == false) goto L14;
        return;
    L14:
        r7.showAtLocation(r8, r9, r10, r11);
        PopupWindowLancet.trackAfterShow(r7, r0, r8);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r7) == false) goto L11;
        r7.showAtLocation(r8, r9, r10, r11);
    }
}
