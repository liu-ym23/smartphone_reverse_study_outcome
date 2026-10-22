package l87;

import android.text.TextUtils;
import com.bytedance.common.push.ThreadPlus;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f508064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f508065b;

    public final void a() {
        a r100 = this.f508065b;
        String r101 = this.f508064a;
        monitor-enter(r100);
        r100.f508056a.getLogger().i("UidSync", "[onAccountSwitchV2]");     // Catch: Throwable -> L10
        if (TextUtils.equals(r100.f508060e, r101) == true) goto L7;
        r100.f508056a.getLogger().i("UidSync", "[onAccountSwitchV2]find uid changed,upload token now");     // Catch: Throwable -> L10
        r100.f508060e = r101;     // Catch: Throwable -> L10
        ThreadPlus.submitRunnable(new i87.c(r100.f508056a, "passport_switch"));     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);
        return;
    L7:
        r100.f508056a.getLogger().i("UidSync", "[onAccountSwitchV2]uid not changed,do nothing");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
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

    public b(a r100, String r101) {
        this.f508065b = r100;
        this.f508064a = r101;
    }
}
