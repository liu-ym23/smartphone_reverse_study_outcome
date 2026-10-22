package fl3;

import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ f a;

    public class a implements Runnable {
        public final /* synthetic */ b a;

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

        public a(b r1) {
            this.a = r1;
        }
    }

    public b(f r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        f r6 = this.a;
        if (r6.u == true) goto L9;
        RelativeLayout r7 = r6.l;
        if (r7 == null) goto L8;
        r7.post(new e(r7, false));
    L8:
        new Handler().postDelayed(new a(this), 100);
    L9:
        f r8 = this.a;
        DialogInterface.OnClickListener r0 = r8.s;
        if (r0 == null) goto L13;
        r0.onClick(r8.v, 0);
        return;
    }
}
