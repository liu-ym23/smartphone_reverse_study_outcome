package fl3;

import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ f a;

    public class a implements Runnable {
        public final /* synthetic */ d a;

        @Override // java.lang.Runnable
        public final void run() {
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L9;
            return;
        L9:
            throw th;
        L13:
            this.a.a.v.dismiss();     // Catch: Throwable -> L5 Exception -> L10
            goto L15
        L14:
            return;
        }

        public a(d r1) {
            this.a = r1;
        }
    }

    public d(f r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        RelativeLayout r5 = this.a.l;
        if (r5 == null) goto L6;
        r5.post(new e(r5, false));
    L6:
        new Handler().postDelayed(new a(this), 100);
    }
}
