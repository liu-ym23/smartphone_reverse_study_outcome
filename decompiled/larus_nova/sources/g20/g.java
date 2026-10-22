package g20;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f479664a;

    public g(TextView r100) {
        this.f479664a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup.LayoutParams r100 = this.f479664a.getLayoutParams();     // Catch: Throwable -> L7
        if (r100 == null) goto L6;
        LinearLayout.LayoutParams r101 = (LinearLayout.LayoutParams) r100;     // Catch: Throwable -> L7
        r101.setMargins(s1.f(4.0f), 0, 0, 0);     // Catch: Throwable -> L7
        this.f479664a.setLayoutParams(r101);     // Catch: Throwable -> L7
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
