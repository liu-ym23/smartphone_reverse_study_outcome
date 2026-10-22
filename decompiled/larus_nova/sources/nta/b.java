package nta;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import com.bytedance.common.utility.Logger;
import ita.j;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AccountManager f520537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Account f520538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f520539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Set<String> f520540e;

    public b(Context r100) {
        this.f520539d = new ConcurrentHashMap();
        this.f520540e = null;
        this.f520537b = AccountManager.get(r100);
    }

    @Override // nta.c
    public final void a(String r100) {
        Objects.toString(this.f520538c);
        if (this.f520538c != null) goto L6;
        this.f520539d.put("device_id", r100);
        return;
    L6:
        if (r100 == null) goto L21;
    L13:
        th = move-exception;
        if (Logger.debug() == false) goto L17;
        j.c("save string error,please fix it : ", th);
    L17:
        th.printStackTrace();
        return;
    L9:
        if (Logger.debug() == false) goto L11;
        j.b("AccountCacheHelper cache string : key = device_id,value = ".concat(r100), null);     // Catch: Throwable -> L13
    L11:
        this.f520537b.setUserData(this.f520538c, "device_id", r100);     // Catch: Throwable -> L13
        return;
    }

    @Override // nta.c
    public final void b(String r100) {
        ConcurrentHashMap<String, String> r101 = this.f520539d;
        if (r101 != null) goto L5;
    L32:
        monitor-enter(this);     // Catch: Exception -> L29
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L29
    L9:
        if (this.f520538c == null) goto L11;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L16
        Account r102 = this.f520538c;     // Catch: Exception -> L29
        if (r102 == null) goto L27;
        AccountManager r103 = this.f520537b;     // Catch: Exception -> L29
        if (r103 == null) goto L27;
        r103.setUserData(r102, r100, null);     // Catch: Exception -> L29
        goto L27
        goto L27
    L11:
        if (this.f520540e != null) goto L14;
        this.f520540e = new CopyOnWriteArraySet();     // Catch: Throwable -> L16
    L14:
        if (((CopyOnWriteArraySet) this.f520540e).contains(r100) == true) goto L18;
        ((CopyOnWriteArraySet) this.f520540e).add(r100);     // Catch: Throwable -> L16
    L27:
        Objects.toString(this.f520538c);
        c(r100);
        super.b(r100);
        return;
    L5:
        if (r101.containsKey(r100) == false) goto L32;
        this.f520539d.remove(r100);
        goto L32
    }

    @Override // nta.c
    public final String c(String r100) {
        Account r101 = this.f520538c;
        if (r101 != null) goto L15;
        return null;
    L15:
        String r102 = this.f520537b.getUserData(r101, r100);     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L8;
        j.b("AccountCacheHelper get cached string : key = " + r100 + ",value = " + r102, null);     // Catch: Throwable -> L9
    L8:
        return r102;
    L9:
        th = move-exception;
        if (Logger.debug() == false) goto L13;
        j.c("get string error,please fix it : ", null);
    L13:
        th.printStackTrace();
        return null;
    }
}
