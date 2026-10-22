package yn7;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import oo7.j;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements in7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference f568566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShareContent f568567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f568568c;

    /* JADX INFO: renamed from: yn7.a$a, reason: collision with other inner class name */
    public class RunnableC8361a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f568569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f568570b;

        @Override // java.lang.Runnable
        public final void run() {
            Bitmap r100 = this.f568569a;     // Catch: Throwable -> L14
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.isRecycled() == true) goto L21;
            Activity r101 = (Activity) this.f568570b.f568566a.get();     // Catch: Throwable -> L14
            if (r101 == null) goto L22;
            ShareContent r102 = this.f568570b.f568567b;     // Catch: Throwable -> L14
            if (r102 == null) goto L23;
            r102.setImage(this.f568569a);     // Catch: Throwable -> L14
            a r103 = this.f568570b;     // Catch: Throwable -> L14
            b r104 = r103.f568568c;     // Catch: Throwable -> L14
            ShareContent r105 = r103.f568567b;     // Catch: Throwable -> L14
            r104.getClass();     // Catch: Throwable -> L14
            b.b(r101, r105);     // Catch: Throwable -> L14
            return;
        L23:
            return;
        L22:
            return;
        L21:
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L24;
            throw th;
        }

        public RunnableC8361a(a r100, Bitmap r101) {
            this.f568570b = r100;
            this.f568569a = r101;
        }
    }

    @Override // in7.a
    public final void onFailed() {
        j.a();
    }

    @Override // in7.a
    public final void onSuccess(Bitmap r100) {
        j.a();
        new Handler(Looper.getMainLooper()).post(new RunnableC8361a(this, r100));
    }

    public a(b r100, WeakReference r101, ShareContent r102) {
        this.f568568c = r100;
        this.f568566a = r101;
        this.f568567b = r102;
    }
}
