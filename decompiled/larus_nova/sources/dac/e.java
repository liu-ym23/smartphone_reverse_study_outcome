package dac;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.usersetting.base.UserSetting;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserSetting f467776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f467777b;

    @Override // java.lang.Runnable
    public final void run() {
        UserSetting r100 = this.f467776a;     // Catch: Throwable -> L13
        if (r100 == null) goto L8;
        long r101 = r100.getDoNotDisturbEndTime();     // Catch: Throwable -> L13
        if (r101 == 0) goto L8;
        int r102 = (r101 > cac.b.a.f22984a.a(0) ? 1 : (r101 == cac.b.a.f22984a.a(0) ? 0 : -1));
    L8:
        Iterator r103 = ((ConcurrentHashMap) this.f467777b.f467769a).keySet().iterator();     // Catch: Throwable -> L13
    L9:
        if (r103.hasNext() == false) goto L21;
        ((b) r103.next()).a();     // Catch: Throwable -> L13
        goto L9
    L21:
        return;
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L17;
        return;
    L17:
        throw th;
    }

    public e(c r100, UserSetting r101) {
        this.f467777b = r100;
        this.f467776a = r101;
    }
}
