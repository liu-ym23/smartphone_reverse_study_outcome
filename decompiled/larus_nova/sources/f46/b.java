package f46;

import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f475522a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f475523a;

        @Override // java.lang.Runnable
        public final void run() {
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L9;
            return;
        L9:
            throw th;
        L13:
            this.f475523a.f475522a.f475556y.dismiss();     // Catch: Throwable -> L5 Exception -> L10
            goto L15
        L14:
            return;
        }

        public a(b r100) {
            this.f475523a = r100;
        }
    }

    public b(g r100) {
        this.f475522a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        g r101 = this.f475522a;
        if (r101.f475554w == true) goto L9;
        RelativeLayout r102 = r101.f475543l;
        if (r102 == null) goto L8;
        r102.post(new e(r102, false));
    L8:
        new Handler().postDelayed(new a(this), 100);
    L9:
        g r103 = this.f475522a;
        DialogInterface.OnClickListener r104 = r103.f475551t;
        if (r104 == null) goto L13;
        r104.onClick(r103.f475556y, 0);
        return;
    }
}
