package ig5;

import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;
import rcb.c;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditText f489736a;

    public a(EditText r100) {
        this.f489736a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.h(this.f489736a, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
