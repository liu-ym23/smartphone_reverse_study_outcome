package ga4;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f480549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String[] f480550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f480551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c.a f480552d;

    public a(b r100, String[] r101, Activity r102, c.a r103) {
        this.f480549a = r100;
        this.f480550b = r101;
        this.f480551c = r102;
        this.f480552d = r103;
    }

    public final void a() {
        int[] r100 = new int[this.f480550b.length];
        PackageManager r101 = this.f480551c.getPackageManager();
        String r102 = this.f480551c.getPackageName();
        int r103 = this.f480550b.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r100[r104] = r101.checkPermission(this.f480550b[r104], r102);
        r104 = r104 + 1;
        goto L3
    L5:
        c.a r105 = this.f480552d;
        if (r105 == null) goto L8;
        r105.a(this.f480550b, r100);
    L8:
        CopyOnWriteArrayList<d> r106 = c.f480553a;
        b r107 = this.f480549a;
        c.f480553a.remove(r107);
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
