package fl3;

import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f477694a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f477695a;

        @Override // java.lang.Runnable
        public final void run() {
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L9;
            return;
        L9:
            throw th;
        L13:
            this.f477695a.f477694a.f477721v.dismiss();     // Catch: Throwable -> L5 Exception -> L10
            goto L15
        L14:
            return;
        }

        public a(d r100) {
            this.f477695a = r100;
        }
    }

    public d(f r100) {
        this.f477694a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        RelativeLayout r101 = this.f477694a.f477711l;
        if (r101 == null) goto L6;
        r101.post(new e(r101, false));
    L6:
        new Handler().postDelayed(new a(this), 100);
    }
}
