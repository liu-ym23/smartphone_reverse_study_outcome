package androidx.appcompat.app;

import android.graphics.Rect;
import androidx.appcompat.widget.FitWindowsViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDelegateImpl$4 implements FitWindowsViewGroup.OnFitSystemWindowsListener {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$4(AppCompatDelegateImpl r1) {
        this.this$0 = r1;
    }

    @Override // androidx.appcompat.widget.FitWindowsViewGroup.OnFitSystemWindowsListener
    public void onFitSystemWindows(Rect r3) {
        r3.top = this.this$0.updateStatusGuard(null, r3);
    }
}
