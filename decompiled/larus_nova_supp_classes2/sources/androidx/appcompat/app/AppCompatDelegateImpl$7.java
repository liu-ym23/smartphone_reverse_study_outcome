package androidx.appcompat.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDelegateImpl$7 extends ViewPropertyAnimatorListenerAdapter {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$7(AppCompatDelegateImpl r1) {
        this.this$0 = r1;
    }

    public void onAnimationEnd(View r2) {
        this.this$0.mActionModeView.setAlpha(1.0f);
        this.this$0.mFadeAnim.setListener(null);
        this.this$0.mFadeAnim = null;
    }

    public void onAnimationStart(View r2) {
        this.this$0.mActionModeView.setVisibility(0);
        this.this$0.mActionModeView.sendAccessibilityEvent(32);
        if ((this.this$0.mActionModeView.getParent() instanceof View) == false) goto L6;
        ViewCompat.requestApplyInsets((View) this.this$0.mActionModeView.getParent());
        return;
    }
}
