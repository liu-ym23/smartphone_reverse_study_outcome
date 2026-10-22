package ss3;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static ts3.b a(Context r8) {
        ts3.b r0 = new ts3.b();
        long r1 = Runtime.getRuntime().totalMemory();     // Catch: Exception -> L14
        long r3 = Runtime.getRuntime().freeMemory();     // Catch: Exception -> L14
        r0.a = r1;     // Catch: Exception -> L14
        r0.b = r3;     // Catch: Exception -> L14
        r0.c = r1 - r3;     // Catch: Exception -> L14
        Debug.MemoryInfo r9 = com.bytedance.apm.util.b.e(Process.myPid(), r8);     // Catch: Exception -> L14
        if (r9 == null) goto L11;
        int r4 = r9.dalvikPss;     // Catch: Exception -> L14
        int r5 = r9.nativePss;     // Catch: Exception -> L14
        int r6 = r9.getTotalPss();     // Catch: Exception -> L14
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r0.g = ((long) CastIntegerProtector.parseInt(r9.getMemoryStat("summary.graphics"))) * 1024;     // Catch: Exception -> L13
        CastIntegerProtector.parseInt(r9.getMemoryStat("summary.java-heap"));     // Catch: Exception -> L13
        CastIntegerProtector.parseInt(r9.getMemoryStat("summary.native-heap"));     // Catch: Exception -> L13
        CastIntegerProtector.parseInt(r9.getMemoryStat("summary.code"));     // Catch: Exception -> L13
        CastIntegerProtector.parseInt(r9.getMemoryStat("summary.stack"));     // Catch: Exception -> L13
        CastIntegerProtector.parseInt(r9.getMemoryStat("summary.private-other"));     // Catch: Exception -> L13
        r0.j = ((long) CastIntegerProtector.parseInt(r9.getMemoryStat("summary.system"))) * 1024;     // Catch: Exception -> L13
        r0.i = ((long) CastIntegerProtector.parseInt(r9.getMemoryStat("summary.total-pss"))) * 1024;     // Catch: Exception -> L13
        CastIntegerProtector.parseInt(r9.getMemoryStat("summary.total-swap"));     // Catch: Exception -> L13
    L10:
        r0.d = ((long) r4) * 1024;     // Catch: Exception -> L14
        r0.e = ((long) r5) * 1024;     // Catch: Exception -> L14
        r0.f = ((long) r6) * 1024;     // Catch: Exception -> L14
        int r7 = r9.dalvikPrivateDirty;     // Catch: Exception -> L14
        int r10 = r9.dalvikSharedDirty;     // Catch: Exception -> L14
        int r11 = r9.otherPss;     // Catch: Exception -> L14
        int r12 = r9.otherPrivateDirty;     // Catch: Exception -> L14
        int r13 = r9.otherSharedDirty;     // Catch: Exception -> L14
        r9.getTotalSwappablePss();     // Catch: Exception -> L14
        r9.getTotalPrivateDirty();     // Catch: Exception -> L14
        r9.getTotalSharedClean();     // Catch: Exception -> L14
    L11:
        r0.h = com.bytedance.apm.util.b.k() * 1024;     // Catch: Exception -> L14
    L12:
        return r0;
    }
}
