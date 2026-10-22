package ij7;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.ug.sdk.luckycat.impl.model.PageLoadReason;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ij7.a f490090a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f490091a;

        @Override // java.lang.Runnable
        public final void run() {
            ij7.a r100 = this.f490091a.f490090a;     // Catch: Throwable -> L6
            pi7.i r101 = r100.f490081i;     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            r101.Kn(r100.f490079g, PageLoadReason.MANUAL_RETRY);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(b r100) {
            this.f490091a = r100;
        }
    }

    public b(ij7.a r100) {
        this.f490090a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        new Handler(Looper.getMainLooper()).postDelayed(new a(this), 200);
        ij7.a r101 = this.f490090a;
        i r102 = r101.f490086n;
        if (r102 == null) goto L6;
        r102.c(r101.f490082j);
        return;
    }
}
