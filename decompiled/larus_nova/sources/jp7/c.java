package jp7;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f499996c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jf7.b f499997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f499998b;

    public static c a() {
        if (f499996c != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f499996c != null) goto L9;
        f499996c = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f499996c;
    }

    public final boolean b() {
        if (this.f499998b != (-1)) goto L18;
        Class<?> r100 = this.f499997a.b("android.os.SystemProperties");     // Catch: Exception -> L22
        String r101 = (String) if7.b.a().a(r100, MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(null, new Object[]{"ro.miui.ui.version.name", ""});     // Catch: Exception -> L22
        if (r101 == null) goto L16;
        if (r101.length() <= 0) goto L16;
        if (r101.startsWith("V") == false) goto L16;
        if (r101.length() <= 3) goto L13;
        String r102 = r101.substring(1, 3);     // Catch: Exception -> L22
    L14:
        this.f499998b = CastIntegerProtector.parseInt(r102);     // Catch: Exception -> L22
    L13:
        r102 = r101.substring(1);     // Catch: Exception -> L22
    L16:
        this.f499998b = 0;
    L18:
        if (this.f499998b >= 12) goto L25;
        return false;
    L25:
        return true;
    }

    public c() {
        this.f499997a = if7.b.a();
        this.f499998b = -1;
    }
}
