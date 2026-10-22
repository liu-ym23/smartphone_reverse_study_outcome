package com.volcengine.zeus.oat;

import android.os.Build;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: loaded from: classes41.dex */
    public static class a implements Runnable {
        public a() {
        }

        public static void a() {
            SystemClock.sleep(GlobalParam.getInstance().getDexOptDelayTime());
            monitor-enter(f.class);
            Map<String, ?> r100 = Zeus.getAppApplication().getApplicationContext().getSharedPreferences("plugin_oat_info", 0).getAll();     // Catch: Throwable -> L30
            if (r100.size() <= 0) goto L28;
            Iterator<Map.Entry<String, ?>> r101 = r100.entrySet().iterator();     // Catch: Throwable -> L30
        L7:
            if (r101.hasNext() == false) goto L28;
            Map.Entry<String, ?> r102 = r101.next();     // Catch: Throwable -> L30
            int r103 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L30
            boolean r104 = true;
            if (r103 >= 29) goto L12;
        L14:
            boolean r105 = false;
        L15:
            if (r105 == false) goto L18;
            b r106 = new FullDexOpt29_30();     // Catch: Throwable -> L30
        L25:
            if (r106.a(r102.getKey(), ((Integer) r102.getValue()).intValue()) == false) goto L7;
            Zeus.getAppApplication().getApplicationContext().getSharedPreferences("plugin_oat_info", 0).edit().remove(r102.getKey()).apply();     // Catch: Throwable -> L30
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat:" + r102.getKey());     // Catch: Throwable -> L30
            goto L7
        L18:
            if (r103 <= 25) goto L21;
            r104 = false;
        L21:
            if (r104 == false) goto L23;
            r106 = new e();     // Catch: Throwable -> L30
            goto L25
        L23:
            r106 = new g();     // Catch: Throwable -> L30
            goto L25
        L12:
            if (r103 > 30) goto L14;
            r105 = true;
        L28:
            monitor-exit(f.class);
            return;
        L30:
            th = move-exception;
            throw th;
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

    /* JADX INFO: loaded from: classes41.dex */
    public interface b {
        boolean a(String r100, int r101);
    }

    public static void a() {
        int r100 = Build.VERSION.SDK_INT;
        boolean r101 = true;
        if (r100 > 25) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L16;
        if (r100 >= 29) goto L10;
    L12:
        r101 = false;
    L13:
        if (r101 == true) goto L16;
        return;
    L10:
        if (r100 > 30) goto L12;
    L16:
        if (dqc.d.d(Zeus.getAppApplication()) == true) goto L18;
        return;
    L18:
        dqc.e.b(new a());
        return;
    L5:
        r102 = false;
        goto L6
    }
}
