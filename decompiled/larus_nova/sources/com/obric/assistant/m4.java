package com.obric.assistant;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f390286a = 0;

    static {
    }

    public static void a(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Object r101 = r100.getSystemService("activity");
        ActivityManager.RunningAppProcessInfo r102 = null;
        if ((r101 instanceof ActivityManager) == false) goto L7;
        ActivityManager r103 = (ActivityManager) r101;
    L8:
        if (r103 != null) goto L10;
        return;
    L10:
        String r104 = r100.getPackageName();
        List<ActivityManager.RunningAppProcessInfo> r105 = r103.getRunningAppProcesses();
        if (r105 == null) goto L26;
        Iterator<T> r106 = r105.iterator();
        ActivityManager.RunningAppProcessInfo r107 = null;
    L14:
        if (r106.hasNext() == false) goto L25;
        ActivityManager.RunningAppProcessInfo r108 = (ActivityManager.RunningAppProcessInfo) r106.next();
        if (Intrinsics.areEqual(r108.processName, r104) == true) goto L17;
        String r109 = r108.processName;
        Intrinsics.checkNotNull(r104);
        if (StringsKt.contains$default(r109, r104, false, 2, null) == false) goto L14;
        if (Intrinsics.areEqual(r108.processName, r104) == true) goto L14;
        Process.killProcess(r108.pid);     // Catch: Exception -> L24
        goto L14
    L17:
        r107 = r108;
        goto L14
    L25:
        r102 = r107;
    L26:
        if (r102 != null) goto L34;
    L30:
        System.exit(0);
        return;
    L34:
        Process.killProcess(r102.pid);     // Catch: Exception -> L29
        goto L30
    L7:
        r103 = null;
        goto L8
    }
}
