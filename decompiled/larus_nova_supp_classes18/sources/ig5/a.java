package ig5;

import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;
import rcb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements Runnable {
    public final /* synthetic */ EditText a;

    public a(EditText r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.h(this.a, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
