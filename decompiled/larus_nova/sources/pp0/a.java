package pp0;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import yo2.f;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f530158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f530159b;

    public a(b r100, View r101) {
        this.f530158a = r100;
        this.f530159b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r100 = this.f530158a.f530162c;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.i(this.f530159b, 2, 3, s1.f(12.0f), s1.f(12.0f));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
