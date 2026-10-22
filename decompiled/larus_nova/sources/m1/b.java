package m1;

import com.apm.lite.e;
import com.apm.lite.k.h;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import r1.m;
import r1.n;

/* JADX INFO: loaded from: classes39.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f511567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f511568b;

    public b() {
        this.f511568b = "apmliteb";
        this.f511567a = false;
    }

    public final void a() {
        if (c.f511569a != null) goto L20;
        c.f511569a = new HashMap();
        PolarisFileWrapper r100 = new PolarisFileWrapper(e.f29909a.getFilesDir(), "/apmlite/selflib/");
        String[] r101 = r100.list();
        if (r101 == null) goto L20;
        int r102 = r101.length;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L20;
        String r104 = r101[r103];
        if (r104.endsWith(".ver") == false) goto L17;
        String r105 = r104.substring(0, r104.length() - 4);
        c.f511569a.put(r105, h.b(r100.getAbsolutePath() + HTTP.URL_DEFAULT + r104));     // Catch: Throwable -> L15
    L19:
        r103 = r103 + 1;
    L15:
        com.apm.lite.c.a();
        goto L19
    L17:
        if (r104.endsWith(".so") == true) goto L19;
        h.k(new PolarisFileWrapper(r100, r104));
    L20:
        String r106 = this.f511568b;
        if ("0.0.2".equals(c.f511569a.get(r106)) == true) goto L24;
    L25:
        boolean r107 = false;
    L27:
        if (r107 == true) goto L57;
        n.c("updateSo", this.f511568b);
        PolarisFileWrapper r108 = new PolarisFileWrapper(c.a(this.f511568b));
        r108.getParentFile().mkdirs();
        if (r108.exists() == false) goto L31;
        r108.delete();
    L31:
        e.f29913e.isDebugMode();
        String r109 = d.a(e.f29909a, this.f511568b, r108);     // Catch: Throwable -> L34
    L35:
        if (r109 != null) goto L40;
        c.f511569a.put(r108.getName(), "0.0.2");
        h.h(new PolarisFileWrapper(e.f29909a.getFilesDir() + "/apmlite/selflib/" + this.f511568b + ".ver"), "0.0.2", false);     // Catch: Throwable -> L45
    L38:
        String r110 = "updateSoSuccess";
    L43:
        n.c(r110, this.f511568b);
        return;
    L40:
        if (this.f511567a == true) goto L42;
        this.f511567a = true;
        n.c("updateSoPostRetry", this.f511568b);
        m.a().b(this, 3000);
        return;
    L42:
        r110 = "updateSoFailed";
    L34:
        n.c("updateSoError", this.f511568b);
        com.apm.lite.c.a();
        r109 = null;
        goto L35
    L57:
        return;
    L24:
        if (new PolarisFileWrapper(c.a(r106)).exists() == false) goto L25;
        r107 = true;
        goto L27
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
