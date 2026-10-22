package r48;

import com.bytedance.platform.godzilla.common.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends t57.c {
    @Override // t57.a
    public final String b() {
        return "CustomerExtensionPlugin";
    }

    @Override // t57.c
    public final void f() {
    }

    public b() {
    }

    @Override // p57.g
    public final boolean a(Thread r100, Throwable r101) throws Throwable {
        boolean r102 = false;
        if (r101 != null) goto L32;
        return false;
    L32:
        String r103 = r101.getClass().getName();     // Catch: Throwable -> L13
        if ("android.app.RemoteServiceException".equals(r103) == false) goto L9;
    L10:
        if (r101.getMessage().trim().startsWith("Bad notification") == false) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == false) goto L30;
    L26:
        r102 = true;
    L27:
        if (r102 == false) goto L29;
        Logger.a("CustomerExtensionPlugin", "Hint CustomerExtensionPlugin case ,fix it.");
    L29:
        return r102;
    L30:
    L22:
        th = move-exception;
        Logger.a("CustomerExtensionPlugin", "isKillPkgException error: " + th.getMessage());
    L24:
        boolean r105 = false;
    L25:
        if (r105 == false) goto L27;
    L18:
        if ((r101 instanceof SecurityException) == false) goto L24;
        if (r101.getMessage().trim().contains("cannot kill pkg:") == false) goto L24;
        r105 = true;
    L15:
        r104 = false;
        goto L16
    L9:
        if ("android.app.RemoteServiceException$CannotPostForegroundServiceNotificationException".equals(r103) == false) goto L15;
    L13:
        th = move-exception;
        Logger.a("CustomerExtensionPlugin", "isRemoteServiceBadNotificationException error: " + th.getMessage());
        goto L15
    }
}
