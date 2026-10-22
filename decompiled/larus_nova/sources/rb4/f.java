package rb4;

import android.text.TextUtils;
import com.bytedance.bdturing.EventReport;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import java.io.File;
import java.util.HashMap;
import qb4.n;

/* JADX INFO: loaded from: classes12.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f536930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f536931b;

    public final void a() {
        String r100 = c.e().g();     // Catch: Exception -> L28
        if (TextUtils.isEmpty(r100) == true) goto L34;
        this.f536931b.getClass();     // Catch: Exception -> L28
        String r101 = r100 + File.separator + "turing_latest_index_1";     // Catch: Exception -> L28
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);     // Catch: Exception -> L28
        if (r102.exists() == false) goto L26;
        String r103 = r101 + ChameleonResConstants.TEMP_SUFFIX;     // Catch: Exception -> L28
        hc4.c.e(r103);     // Catch: Exception -> L28
        c r104 = c.e();     // Catch: Exception -> L28
        String r105 = this.f536930a;     // Catch: Exception -> L28
        r104.getClass();     // Catch: Exception -> L28
        File r106 = c.h(r105, r103);     // Catch: Exception -> L28
        if (r106 != null) goto L10;
        return;
    L10:
        if (r106.exists() == false) goto L36;
        boolean r107 = hc4.c.g(r102).equals(hc4.c.g(r106));     // Catch: Exception -> L28
        int r108 = n.f532367a;     // Catch: Exception -> L28
        if (r107 == true) goto L14;
        hc4.c.e(r101);     // Catch: Exception -> L28
        h r109 = new h();     // Catch: Exception -> L28
        r109.f536933a = "captcha.zip";     // Catch: Exception -> L28
        c.e().c(r109);     // Catch: Exception -> L28
        EventReport.u(2, "url=" + this.f536930a);     // Catch: Exception -> L28
    L14:
        c r110 = c.e();     // Catch: Exception -> L28
        this.f536931b.getClass();     // Catch: Exception -> L28
        Object r111 = r110.f536924f;     // Catch: Exception -> L28
        monitor-enter(r111);     // Catch: Exception -> L28
        if (r107 == false) goto L18;
        int r112 = 0;
    L31:
        r110.f536925g = r112;     // Catch: Throwable -> L23
        ((HashMap) r110.f536919a).put(1, Boolean.valueOf(r107));     // Catch: Throwable -> L23
        monitor-exit(r111);     // Catch: Throwable -> L23
        hc4.c.e(r103);     // Catch: Exception -> L28
        return;
    L23:
        th = move-exception;
        throw th;     // Catch: Exception -> L28
    L18:
        r112 = 3;
        goto L31
    L36:
        return;
    L26:
        c r113 = c.e();     // Catch: Exception -> L28
        String r114 = this.f536930a;     // Catch: Exception -> L28
        r113.getClass();     // Catch: Exception -> L28
        c.h(r114, r101);     // Catch: Exception -> L28
        int r115 = n.f532367a;     // Catch: Exception -> L28
        return;
    L34:
        return;
    L28:
        e = move-exception;
        e.printStackTrace();
        int r116 = n.f532367a;
        EventReport.u(4, "url=" + this.f536930a);
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

    public f(g r100, String r101) {
        this.f536931b = r100;
        this.f536930a = r101;
    }
}
