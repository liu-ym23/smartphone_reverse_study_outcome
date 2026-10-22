package da4;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f467686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f467687b;

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap r100 = this.f467686a;     // Catch: Throwable -> L7
        if (r100 == null) goto L10;
        this.f467687b.setImageBitmap(r100);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }

    public c(Bitmap r100, ImageView r101) {
        this.f467686a = r100;
        this.f467687b = r101;
    }
}
