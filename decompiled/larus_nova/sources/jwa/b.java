package jwa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.audit.AuditManager;
import gwa.g;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static b f500736f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f500737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f500738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f500739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f500740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g.b f500741e;

    public final boolean c() {
        if (this.f500738b == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f500739c == true) goto L8;
        return false;
    }

    public b(Context r100) {
        this.f500737a = r100.getApplicationContext();
        this.f500738b = DevEnvUtil.isDebugMode(r100);
        this.f500739c = DevEnvUtil.isDevelopPackage(r100);
        this.f500740d = new Handler(Looper.getMainLooper());
        this.f500741e = AuditManager.getInstance().getDependency().getSecurityComplianceDependency();
    }

    public static b b(Context r100) {
        if (f500736f != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f500736f != null) goto L9;
        f500736f = new b(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f500736f;
    }

    public final void a(final String r100) {
        if (c() == true) goto L5;
        return;
    L5:
        if (this.f500741e.b().getBoolean("toastSwitch_AuthoritySDK_Debug", false) == false) goto L9;
        this.f500740d.post(new a(this, r100));
        return;
    }
}
