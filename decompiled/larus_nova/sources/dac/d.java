package dac;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.usersetting.base.UserSetting;
import java.util.Iterator;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserSetting f467773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserSetting f467774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f467775c;

    public final void a() {
        UserSetting r100 = this.f467773a;
        if (r100 != null) goto L5;
        return;
    L5:
        long r101 = r100.getDoNotDisturbEndTime();
        UserSetting r102 = this.f467774b;
        if (r102 != null) goto L8;
    L11:
        Iterator<a> r103 = this.f467775c.f467770b.keySet().iterator();
    L13:
        if (r103.hasNext() == false) goto L19;
        a r104 = r103.next();
        if (r101 == 0) goto L18;
        cac.b.a.f22984a.a(0);
    L18:
        r104.a();
        goto L13
    L19:
        return;
    L8:
        if (r102.getDoNotDisturbEndTime() != r101) goto L11;
        Log.i("ZenSettingServiceImpl", "time format is not changed");
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

    public d(c r100, UserSetting r101, UserSetting r102) {
        this.f467775c = r100;
        this.f467773a = r101;
        this.f467774b = r102;
    }
}
