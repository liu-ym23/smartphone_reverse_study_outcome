package h84;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.o0;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AccountManager f484113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f484114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Account f484115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f484116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o0 f484117f;

    @Override // h84.e
    public final String[] f() {
        String r100 = a("sim_serial_number");
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return r100.split("\n");
    }

    @Override // h84.e, h84.n
    public final String a(String r100) {
        String r101 = i(r100);
        String r102 = this.f484116e.get(r101);
        if (TextUtils.isEmpty(r102) == true) goto L5;
        return r102;
    L5:
        Account r103 = this.f484115d;
        if (r103 != null) goto L13;
        return null;
    L13:
        return this.f484113b.getUserData(r103, r101);
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // h84.e
    public final void d(String[] r100) {
        if (r100 == null) goto L6;
        c("sim_serial_number", TextUtils.join("\n", r100));
        return;
    }

    @Override // h84.e
    public final void e(List<String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<String> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L15;
        String r102 = i(r101.next());
        this.f484116e.remove(r102);
        Account r103 = this.f484115d;     // Catch: Exception -> L14
        if (r103 == null) goto L6;
        AccountManager r104 = this.f484113b;     // Catch: Exception -> L14
        if (r104 == null) goto L6;
        r104.setUserData(r103, r102, null);     // Catch: Exception -> L14
        goto L6
    L15:
        super.e(r100);
    }

    public final String i(String r100) {
        StringBuffer r101 = new StringBuffer(r100);
        r101.append(this.f484114c);
        if (this.f484117f.O == true) goto L6;
        r101.append("_");
        r101.append(this.f484117f.a());
    L6:
        return r101.toString();
    }

    @Override // h84.e, h84.n
    public final void c(String r100, String r101) {
        String r102 = i(r100);
        Account r103 = this.f484115d;
        if (r103 != null) goto L6;
        this.f484116e.put(r102, r101);
        return;
    L6:
        if (r101 != null) goto L13;
        return;
    L13:
        this.f484113b.setUserData(r103, r102, r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public c(Context r100, String r101, o0 r102) {
        this.f484116e = new ConcurrentHashMap();
        this.f484113b = AccountManager.get(r100);
        this.f484114c = r101;
        this.f484117f = r102;
    }
}
