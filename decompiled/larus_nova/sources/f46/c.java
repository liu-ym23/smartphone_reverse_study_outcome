package f46;

import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f475524a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f475525a;

        @Override // java.lang.Runnable
        public final void run() {
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L9;
            return;
        L9:
            throw th;
        L13:
            this.f475525a.f475524a.f475556y.dismiss();     // Catch: Throwable -> L5 Exception -> L10
            goto L15
        L14:
            return;
        }

        public a(c r100) {
            this.f475525a = r100;
        }
    }

    public c(g r100) {
        this.f475524a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        g r101 = this.f475524a;
        if (r101.f475553v == true) goto L9;
        RelativeLayout r102 = r101.f475543l;
        if (r102 == null) goto L8;
        r102.post(new e(r102, false));
    L8:
        new Handler().postDelayed(new a(this), 100);
    L9:
        g r103 = this.f475524a;
        DialogInterface.OnClickListener r104 = r103.f475550s;
        if (r104 == null) goto L13;
        r104.onClick(r103.f475556y, 1);
        return;
    }
}
