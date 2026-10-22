package com.volcengine.zeus.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqc.p;

/* JADX INFO: loaded from: classes5.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f462809a = null;

    public i() {
    }

    static {
        f462809a = new LinkedHashSet();
    }

    public static void b() {
        p.b(new h(false));
    }

    public static final void a(String r110) {
        Application r100 = Zeus.getAppApplication();
        String r101 = r100.getPackageName();
        int r102 = Process.myUid();
        int r103 = Process.myPid();
        Object r104 = r100.getSystemService("activity");
        if ((r104 instanceof ActivityManager) == true) goto L5;
        r104 = null;
    L5:
        ActivityManager r105 = (ActivityManager) r104;
        if (r105 == null) goto L8;
        List<ActivityManager.RunningAppProcessInfo> r106 = r105.getRunningAppProcesses();
    L9:
        if (r106 != null) goto L12;
        r106 = CollectionsKt.emptyList();
    L12:
        LinkedHashSet r107 = new LinkedHashSet();
        Iterator<ActivityManager.RunningAppProcessInfo> r108 = r106.iterator();
    L14:
        if (r108.hasNext() == false) goto L26;
        ActivityManager.RunningAppProcessInfo r109 = r108.next();
        String r111 = r109.processName;
        if (r111 == null) goto L14;
        boolean r112 = false;
        if (Intrinsics.areEqual(r111, r101) == true) goto L22;
        if (StringsKt.startsWith$default(r111, r101 + ':', false, 2, null) == true) goto L22;
    L24:
        if (r112 == false) goto L14;
        r107.add(Integer.valueOf(r109.pid));
    L22:
        if (r109.uid != r102) goto L24;
        r112 = true;
        goto L24
    L26:
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginReloadManager force-stop app " + r101 + " processes due to plugin update, plugin=" + r110 + ", pids=" + r107);
        r107.toString();
        Iterator r113 = r107.iterator();
    L28:
        if (r113.hasNext() == false) goto L35;
        Integer r114 = (Integer) r113.next();
        if (r114 == null) goto L34;
        if (r114.intValue() == r103) goto L28;
    L34:
        Process.killProcess(r114.intValue());
        goto L28
    L35:
        Process.killProcess(r103);
        return;
    L8:
        r106 = null;
        goto L9
    }
}
