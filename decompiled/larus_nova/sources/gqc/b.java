package gqc;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import dqc.d;
import dqc.e;
import java.util.concurrent.atomic.AtomicBoolean;
import mqc.t;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f482288b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f482289a;

    public static b a() {
        if (f482288b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f482288b != null) goto L9;
        f482288b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f482288b;
    }

    public final void b() {
    L10:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "SecondaryDex2oatTrigger performSecondaryDex2Oat33P failed.", th);
        return;
    L4:
        if (Build.VERSION.SDK_INT < 33) goto L15;
        ZeusLogger.i(ZeusLogger.TAG_DEX2OAT, "performSecondaryDex2Oat33P start, force:false");     // Catch: Throwable -> L10
        Application r100 = Zeus.getAppApplication();     // Catch: Throwable -> L10
        if (r100 != null) goto L8;
        return;
    L8:
        c(r100);     // Catch: Throwable -> L10
        return;
    }

    public b() {
        this.f482289a = new AtomicBoolean(false);
    }

    public static void d(String r100) {
        ZeusLogger.i(ZeusLogger.TAG_DEX2OAT, "reportSecondaryDex33P start, apkPath:" + r100);     // Catch: Throwable -> L7
        if (Build.VERSION.SDK_INT < 33) goto L12;
        c.f(r100);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "SecondaryDex2oatTrigger reportSecondaryDex failed.", th);
    }

    public final void c(Context r110) {
        Context r111 = r110.getApplicationContext();
        if (d.d(r111) == true) goto L5;
        return;
    L5:
        t r100 = t.c();
        if (r100.i("SECONDARY_DEX2OAT_33P") == false) goto L9;
    L10:
        ZeusLogger.i(ZeusLogger.TAG_DEX2OAT, "skipByInterval because rom_update.");     // Catch: Throwable -> L47
        boolean r101 = true;
    L48:
        String r102 = mqc.b.a(r111);     // Catch: Throwable -> L21
        String r103 = r100.f514970a.getString("SECONDARY_DEX2OAT_HOST_IDENTITY", "");     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r102) == true) goto L23;
        if (TextUtils.isEmpty(r103) == false) goto L18;
    L19:
        ZeusLogger.i(ZeusLogger.TAG_DEX2OAT, "skipByInterval because host_update.");     // Catch: Throwable -> L21
        r101 = true;
        goto L23
    L18:
        if (TextUtils.equals(r103, r102) == false) goto L19;
    L23:
        if (r101 == true) goto L54;
        long r104 = r100.f514970a.getLong("SECONDARY_DEX2OAT_LAST_TRIGGER_TIME", 0);     // Catch: Throwable -> L32
    L34:
        if (r104 > 0) goto L37;
    L39:
        boolean r105 = false;
    L40:
        if (r105 == false) goto L43;
        return;
    L43:
        if (this.f482289a.compareAndSet(false, true) == true) goto L45;
        return;
    L45:
        e.b(new a(this, r111));
        return;
    L37:
        if ((System.currentTimeMillis() - r104) >= com.heytap.mcssdk.constant.a.f276320g) goto L39;
        r105 = true;
    L32:
        r104 = 0;
        goto L34
    L54:
        r100.p(0);     // Catch: Throwable -> L29
        String r106 = mqc.b.a(r111);     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r106) == true) goto L27;
        r100.o(r106);     // Catch: Throwable -> L29
    L27:
        r100.n("SECONDARY_DEX2OAT_33P");     // Catch: Throwable -> L29
        goto L39
    L9:
        if (r100.f("SECONDARY_DEX2OAT_33P") == false) goto L10;
    L12:
        r101 = false;
        goto L48
    }
}
