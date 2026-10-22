package f83;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements Runnable {
    public final /* synthetic */ ImageView a;

    public h(ImageView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageView r0 = this.a;     // Catch: Throwable -> L9
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();     // Catch: Throwable -> L9
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r1 = null;
    L5:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;     // Catch: Throwable -> L9
        if (r2 == null) goto L12;
        r2.rightMargin = com.bytedance.android.shopping.extensions.b.b(4);     // Catch: Throwable -> L9
        r0.setLayoutParams(r2);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
