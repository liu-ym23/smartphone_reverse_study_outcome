package gw2;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livesdk.widgetdescriptor.matchroom.publish.LivePortraitPublishLoadingWidget;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Callable;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public final class b<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LivePortraitPublishLoadingWidget f483022a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f483023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f483024b;

        public a(Bitmap r100, b r101) {
            this.f483023a = r100;
            this.f483024b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LivePortraitPublishLoadingWidget r100 = this.f483024b.f483022a;     // Catch: Throwable -> L6
            Bitmap r101 = this.f483023a;     // Catch: Throwable -> L6
            r100.f162429d = r101;     // Catch: Throwable -> L6
            ImageView r102 = r100.f162427b;     // Catch: Throwable -> L6
            if (r102 == null) goto L9;
            r102.setImageBitmap(r101);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public b(LivePortraitPublishLoadingWidget r100) {
        this.f483022a = r100;
    }

    @Override // java.util.concurrent.Callable
    public final Bitmap call() {
        IHostShare r100 = (IHostShare) k.f(IHostShare.class);
        if (r100 == null) goto L9;
        Bitmap r101 = r100.getPublishCover();
        if (r101 == null) goto L9;
        ImageView r102 = this.f483022a.f162427b;
        if (r102 == null) goto L11;
        r102.post(new a(r101, this));
        return r101;
    L11:
        return r101;
    L9:
        return null;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
