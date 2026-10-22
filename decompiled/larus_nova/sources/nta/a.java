package nta;

import android.accounts.Account;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Account f520535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f520536b;

    public final void a() {
        ConcurrentHashMap<String, String> r100 = this.f520536b.f520539d;     // Catch: Exception -> L19
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() <= 0) goto L30;
        b r101 = this.f520536b;     // Catch: Exception -> L19
        if (r101.f520537b == null) goto L31;
        Iterator<Map.Entry<String, String>> r102 = r101.f520539d.entrySet().iterator();     // Catch: Exception -> L19
    L11:
        if (r102.hasNext() == false) goto L16;
        Map.Entry<String, String> r103 = r102.next();     // Catch: Exception -> L19
        if (r103 == null) goto L11;
        this.f520536b.f520537b.setUserData(this.f520535a, r103.getKey(), r103.getValue());     // Catch: Exception -> L19
        goto L11
    L16:
        this.f520536b.f520539d.clear();     // Catch: Exception -> L19
        return;
    L31:
        return;
    L30:
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
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

    public a(b r100, Account r101) {
        this.f520536b = r100;
        this.f520535a = r101;
    }
}
