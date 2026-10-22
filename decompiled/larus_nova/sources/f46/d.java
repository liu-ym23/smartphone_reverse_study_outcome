package f46;

import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f475526a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f475527a;

        @Override // java.lang.Runnable
        public final void run() {
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L9;
            return;
        L9:
            throw th;
        L13:
            this.f475527a.f475526a.f475556y.dismiss();     // Catch: Throwable -> L5 Exception -> L10
            goto L15
        L14:
            return;
        }

        public a(d r100) {
            this.f475527a = r100;
        }
    }

    public d(g r100) {
        this.f475526a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        RelativeLayout r101 = this.f475526a.f475543l;
        if (r101 == null) goto L6;
        r101.post(new e(r101, false));
    L6:
        new Handler().postDelayed(new a(this), 100);
    }
}
