package ebb;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.framework.assembly.diskmanage.DiskManageProvider$performRemoteClean$1;
import com.ss.android.lark.log.Log;
import java.util.Iterator;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f471977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cbb.d f471978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<Boolean> f471979c;

    public c(b r100, cbb.d r101, DiskManageProvider$performRemoteClean$1 r102) {
        this.f471977a = r100;
        this.f471978b = r101;
        this.f471979c = r102;
    }

    public final void a() {
        long r100 = System.currentTimeMillis();
        Iterator<g> r101 = this.f471977a.f471974a.values().iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L13;
        g r103 = r101.next();
        long r104 = System.currentTimeMillis();
        cbb.a r105 = r103.a(this.f471978b);
        long r110 = System.currentTimeMillis() - r104;
        if (r102 == false) goto L8;
    L11:
        r102 = true;
    L12:
        Log.i("DiskCleanTaskManager", "remoteClean, biz: " + r103.getBiz() + ", cost time: " + r110 + ", result: " + r105);
        goto L4
    L8:
        if (r105.f23115a == true) goto L11;
        r102 = false;
        goto L12
    L13:
        Log.i("DiskCleanTaskManager", "remoteClean, total cost: " + (System.currentTimeMillis() - r100));
        this.f471979c.onSuccess(Boolean.valueOf(r102));
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
}
