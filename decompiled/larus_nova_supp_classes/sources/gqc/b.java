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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public static volatile b b;
    public final AtomicBoolean a;

    public static b a() {
        if (b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public final void b() {
    L10:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "SecondaryDex2oatTrigger performSecondaryDex2Oat33P failed.", th);
        return;
    L4:
        if (Build.VERSION.SDK_INT < 33) goto L15;
        ZeusLogger.i(ZeusLogger.TAG_DEX2OAT, "performSecondaryDex2Oat33P start, force:false");     // Catch: Throwable -> L10
        Application r1 = Zeus.getAppApplication();     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        return;
    L8:
        c(r1);     // Catch: Throwable -> L10
        return;
    }

    public b() {
        this.a = new AtomicBoolean(false);
    }

    public static void d(String r3) {
        ZeusLogger.i(ZeusLogger.TAG_DEX2OAT, "reportSecondaryDex33P start, apkPath:" + r3);     // Catch: Throwable -> L7
        if (Build.VERSION.SDK_INT < 33) goto L12;
        c.f(r3);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "SecondaryDex2oatTrigger reportSecondaryDex failed.", th);
    }

    public final void c(Context r11) {
        Context r12 = r11.getApplicationContext();
        if (d.d(r12) == true) goto L5;
        return;
    L5:
        t r2 = t.c();
        if (r2.i("SECONDARY_DEX2OAT_33P") == false) goto L9;
    L10:
        ZeusLogger.i(ZeusLogger.TAG_DEX2OAT, "skipByInterval because rom_update.");     // Catch: Throwable -> L47
        boolean r5 = true;
    L48:
        String r6 = mqc.b.a(r12);     // Catch: Throwable -> L21
        String r7 = r2.a.getString("SECONDARY_DEX2OAT_HOST_IDENTITY", XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r6) == true) goto L23;
        if (TextUtils.isEmpty(r7) == false) goto L18;
    L19:
        ZeusLogger.i(ZeusLogger.TAG_DEX2OAT, "skipByInterval because host_update.");     // Catch: Throwable -> L21
        r5 = true;
        goto L23
    L18:
        if (TextUtils.equals(r7, r6) == false) goto L19;
    L23:
        if (r5 == true) goto L54;
        long r0 = r2.a.getLong("SECONDARY_DEX2OAT_LAST_TRIGGER_TIME", 0);     // Catch: Throwable -> L32
    L34:
        if (r0 > 0) goto L37;
    L39:
        boolean r1 = false;
    L40:
        if (r1 == false) goto L43;
        return;
    L43:
        if (this.a.compareAndSet(false, true) == true) goto L45;
        return;
    L45:
        e.b(new a(this, r12));
        return;
    L37:
        if ((System.currentTimeMillis() - r0) >= 43200000) goto L39;
        r1 = true;
    L32:
        r0 = 0;
        goto L34
    L54:
        r2.p(0);     // Catch: Throwable -> L29
        String r3 = mqc.b.a(r12);     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r3) == true) goto L27;
        r2.o(r3);     // Catch: Throwable -> L29
    L27:
        r2.n("SECONDARY_DEX2OAT_33P");     // Catch: Throwable -> L29
        goto L39
    L9:
        if (r2.f("SECONDARY_DEX2OAT_33P") == false) goto L10;
    L12:
        r5 = false;
        goto L48
    }
}
