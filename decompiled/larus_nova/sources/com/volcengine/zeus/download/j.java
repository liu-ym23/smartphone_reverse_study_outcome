package com.volcengine.zeus.download;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile j f462689d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f462690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Runnable> f462691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, com.volcengine.zeus.download.a> f462692c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f462693a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f462693a.c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r100) {
            this.f462693a = r100;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f462694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f462695b;

        public final void a() {
            Application r100 = Zeus.getAppApplication();
            String r101 = r100.getPackageName();
            if (TextUtils.isEmpty(r101) == true) goto L14;
            boolean r102 = true;
            List<ActivityManager.RunningTaskInfo> r103 = ((ActivityManager) r100.getSystemService("activity")).getRunningTasks(1);
            if (r103 == null) goto L14;
            if (r103.isEmpty() == true) goto L14;
            ComponentName r104 = ((ActivityManager.RunningTaskInfo) ListProtector.get(r103, 0)).topActivity;
            if (r104 == null) goto L14;
            if (r101.equals(r104.getPackageName()) == false) goto L14;
        L15:
            if (r102 == false) goto L18;
            this.f462695b.a(this.f462694a, false);
            this.f462695b.f462690a.postDelayed(this, 1800000);
            return;
        L18:
            return;
        L14:
            r102 = false;
            goto L15
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

        public b(j r100, String r101) {
            this.f462695b = r100;
            this.f462694a = r101;
        }
    }

    public static j b() {
        if (f462689d != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f462689d != null) goto L9;
        f462689d = new j();     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return f462689d;
    }

    public j() {
        this.f462690a = new Handler(Looper.getMainLooper());
        this.f462691b = new ConcurrentHashMap();
        this.f462692c = new ConcurrentHashMap();
    }

    public final void c(String r100) {
        Runnable r101 = (Runnable) ((ConcurrentHashMap) this.f462691b).get(r100);
        if (r101 == null) goto L5;
        this.f462690a.removeCallbacks(r101);
    L5:
        b r102 = new b(this, r100);
        ((ConcurrentHashMap) this.f462691b).put(r100, r102);
        this.f462690a.postDelayed(r102, 1800000);
    }

    public final synchronized void a(String r100, boolean r101) {
        monitor-enter(this);
        ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, "start asyncFetchPlugins:" + r100);     // Catch: Throwable -> L11
        if (((ConcurrentHashMap) this.f462692c).containsKey(r100) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        c r102 = new c(this, r101, r100);     // Catch: Throwable -> L11
        ((ConcurrentHashMap) this.f462692c).put(r100, r102);     // Catch: Throwable -> L11
        dqc.e.b(new a(r102));     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
