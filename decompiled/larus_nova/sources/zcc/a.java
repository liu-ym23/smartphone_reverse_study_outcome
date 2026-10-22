package zcc;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f571282a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f571282a.finish();     // Catch: Throwable -> L4
        this.f571282a.overridePendingTransition(0, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(FragmentActivity r100) {
        this.f571282a = r100;
    }
}
