package fra;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.apm.impl.protector.RunnableProtector;
import ita.k;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f478631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f478632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f478633c;

    public d(List r100, Context r101) {
        this.f478631a = r100;
        this.f478632b = r101;
        this.f478633c = "key_account_info";
    }

    public final void a() {
        Iterator r100 = this.f478631a.iterator();
    L4:
        if (r100.hasNext() == false) goto L42;
        a r101 = (a) r100.next();
    L40:
        e = move-exception;
        e.printStackTrace();
        dra.b r102 = new dra.b();
        r102.b("share_sdk_read_data_err");
        r102.a(LocationMonitorConst.ERR_MSG, e.getMessage());
        r102.a("err_msg_stack", Log.getStackTraceString(e));
        r102.c();
        goto L4
    L7:
        if (k.h(this.f478632b, r101.f478619a) == false) goto L4;
        Context r103 = f.f478636a;     // Catch: Exception -> L40
        if (f.d(r101.f478619a) == false) goto L4;
        if (f.f478639d == true) goto L14;
        if (r101.f478621c == false) goto L24;
        c r104 = f.a(r101, this.f478633c);     // Catch: Exception -> L40
        if (r104.f478628d == false) goto L24;
        if (TextUtils.isEmpty(r104.f478626b) == true) goto L4;
        f.f(r104);     // Catch: Exception -> L40
        return;
    L24:
        if (f.f478639d == true) goto L25;
        if (r101.f478622d == false) goto L35;
        c r105 = f.b(r101, this.f478633c);     // Catch: Exception -> L40
        if (r105.f478628d == false) goto L35;
        if (TextUtils.isEmpty(r105.f478626b) == true) goto L4;
        f.f(r105);     // Catch: Exception -> L40
        return;
    L35:
        if (r101.f478623e == false) goto L4;
        if (f.f478641f == true) goto L4;
        f.f478641f = true;     // Catch: Exception -> L40
        String r106 = this.f478633c;     // Catch: Exception -> L40
        f.f478638c.post(new e(r106, r101));     // Catch: Exception -> L40
        goto L4
    L25:
        return;
    L14:
        return;
    L42:
        Context r107 = f.f478636a;
        if (f.f478641f == true) goto L73;
        f.c(new c("", false, "no valid query pkg", 8, 0));
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
}
