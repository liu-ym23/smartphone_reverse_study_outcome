package fl3;

import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ f a;

    public class a implements Runnable {
        public final /* synthetic */ c a;

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

        public a(c r1) {
            this.a = r1;
        }
    }

    public c(f r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        f r5 = this.a;
        if (r5.t == true) goto L9;
        RelativeLayout r6 = r5.l;
        if (r6 == null) goto L8;
        r6.post(new e(r6, false));
    L8:
        new Handler().postDelayed(new a(this), 100);
    L9:
        f r7 = this.a;
        DialogInterface.OnClickListener r0 = r7.r;
        if (r0 == null) goto L13;
        r0.onClick(r7.v, 1);
        return;
    }
}
