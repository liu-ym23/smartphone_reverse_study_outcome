package fl3;

import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f477690a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f477691a;

        @Override // java.lang.Runnable
        public final void run() {
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L9;
            return;
        L9:
            throw th;
        L13:
            this.f477691a.f477690a.f477721v.dismiss();     // Catch: Throwable -> L5 Exception -> L10
            goto L15
        L14:
            return;
        }

        public a(b r100) {
            this.f477691a = r100;
        }
    }

    public b(f r100) {
        this.f477690a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        f r101 = this.f477690a;
        if (r101.f477720u == true) goto L9;
        RelativeLayout r102 = r101.f477711l;
        if (r102 == null) goto L8;
        r102.post(new e(r102, false));
    L8:
        new Handler().postDelayed(new a(this), 100);
    L9:
        f r103 = this.f477690a;
        DialogInterface.OnClickListener r104 = r103.f477718s;
        if (r104 == null) goto L13;
        r104.onClick(r103.f477721v, 0);
        return;
    }
}
