package com.bytedance.kmp.performance.platform;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import kotlin.jvm.internal.Intrinsics;
import md6.f1;

/* JADX INFO: loaded from: classes19.dex */
public final class v {
    public static final f1 a() {
        long r100 = Runtime.getRuntime().maxMemory();
        long r101 = Runtime.getRuntime().freeMemory();
        long r102 = Runtime.getRuntime().totalMemory();
        Context r103 = com.bytedance.kmp.performance.b.f252707a.getContext();
        if (r103 == null) goto L15;
        Object r104 = r103.getSystemService("activity");
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.app.ActivityManager");
        boolean r105 = true;
        Debug.MemoryInfo[] r106 = ((ActivityManager) r104).getProcessMemoryInfo(new int[]{Process.myPid()});
        if (r106 != null) goto L7;
    L13:
        if (r105 == true) goto L15;
        long r107 = r106[0].getTotalPss();
        Debug.MemoryInfo r108 = r106[0];
        long r110 = r108.nativePss;
        long r111 = r108.dalvikPss;
        long r112 = r108.otherPss;
        long r109 = r110;
        long r113 = r107;
    L17:
        return new f1(r102, r101, r100, r109, r113, r111, r112, 10747903);
    L7:
        if (r106.length != 0) goto L9;
        boolean r114 = true;
    L10:
        if (r114 == true) goto L13;
        r105 = false;
        goto L13
    L9:
        r114 = false;
    L15:
        r109 = 0;
        r113 = 0;
        r111 = 0;
        r112 = 0;
        goto L17
    }
}
