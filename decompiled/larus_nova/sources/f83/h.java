package f83;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f475852a;

    public h(ImageView r100) {
        this.f475852a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageView r100 = this.f475852a;     // Catch: Throwable -> L9
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();     // Catch: Throwable -> L9
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;     // Catch: Throwable -> L9
        if (r102 == null) goto L12;
        r102.rightMargin = com.bytedance.android.shopping.extensions.b.b(4);     // Catch: Throwable -> L9
        r100.setLayoutParams(r102);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
