package androidx.appcompat.app;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDelegateImpl$3 implements OnApplyWindowInsetsListener {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$3(AppCompatDelegateImpl r1) {
        this.this$0 = r1;
    }

    public WindowInsetsCompat onApplyWindowInsets(View r5, WindowInsetsCompat r6) {
        int r0 = r6.getSystemWindowInsetTop();
        int r1 = this.this$0.updateStatusGuard(r6, null);
        if (r0 == r1) goto L6;
        r6 = r6.replaceSystemWindowInsets(r6.getSystemWindowInsetLeft(), r1, r6.getSystemWindowInsetRight(), r6.getSystemWindowInsetBottom());
    L6:
        return ViewCompat.onApplyWindowInsets(r5, r6);
    }
}
