package h84;

import android.accounts.Account;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Account f484111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f484112b;

    public final void a() {
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.f484112b.f484116e.size() <= 0) goto L16;
        c r100 = this.f484112b;     // Catch: Exception -> L17
        if (r100.f484113b == null) goto L28;
        Iterator<Map.Entry<String, String>> r101 = r100.f484116e.entrySet().iterator();     // Catch: Exception -> L17
    L9:
        if (r101.hasNext() == false) goto L14;
        Map.Entry<String, String> r102 = r101.next();     // Catch: Exception -> L17
        if (r102 == null) goto L9;
        this.f484112b.f484113b.setUserData(this.f484111a, r102.getKey(), r102.getValue());     // Catch: Exception -> L17
        goto L9
    L14:
        this.f484112b.f484116e.clear();     // Catch: Exception -> L17
        return;
    L28:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(c r100, Account r101) {
        this.f484112b = r100;
        this.f484111a = r101;
    }
}
