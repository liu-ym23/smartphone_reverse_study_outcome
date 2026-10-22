package eh2;

import android.content.Context;
import android.os.Handler;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.bytedance.android.livesdk.livecommerce.broadcast.bindcoupon.ui.ECBindCouponFragment;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements Runnable {
    public final /* synthetic */ ECBindCouponFragment a;

    @Override // java.lang.Runnable
    public final void run() {
        ECBindCouponFragment r0 = this.a;     // Catch: Throwable -> L8
        int r1 = ECBindCouponFragment.y;     // Catch: Throwable -> L8
        Context r2 = r0.getContext();     // Catch: Throwable -> L8
        if (r2 == null) goto L11;
        EditText r3 = r0.j;     // Catch: Throwable -> L8
        Handler r4 = k.a;     // Catch: Throwable -> L8
        InputMethodManager r5 = (InputMethodManager) r2.getSystemService("input_method");     // Catch: Throwable -> L8
        if (r5 == null) goto L15;
        r3.requestFocus();     // Catch: Throwable -> L8
        r5.showSoftInput(r3, 0);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }

    public g(ECBindCouponFragment r1) {
        this.a = r1;
    }
}
