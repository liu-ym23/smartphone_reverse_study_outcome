package ss3;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class c {
    public static ts3.b a(Context r100) {
        ts3.b r101 = new ts3.b();
        long r102 = Runtime.getRuntime().totalMemory();     // Catch: Exception -> L14
        long r103 = Runtime.getRuntime().freeMemory();     // Catch: Exception -> L14
        r101.f547365a = r102;     // Catch: Exception -> L14
        r101.f547366b = r103;     // Catch: Exception -> L14
        r101.f547367c = r102 - r103;     // Catch: Exception -> L14
        Debug.MemoryInfo r104 = com.bytedance.apm.util.b.e(Process.myPid(), r100);     // Catch: Exception -> L14
        if (r104 == null) goto L11;
        int r105 = r104.dalvikPss;     // Catch: Exception -> L14
        int r106 = r104.nativePss;     // Catch: Exception -> L14
        int r107 = r104.getTotalPss();     // Catch: Exception -> L14
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r101.f547371g = ((long) CastIntegerProtector.parseInt(r104.getMemoryStat("summary.graphics"))) * 1024;     // Catch: Exception -> L13
        CastIntegerProtector.parseInt(r104.getMemoryStat("summary.java-heap"));     // Catch: Exception -> L13
        CastIntegerProtector.parseInt(r104.getMemoryStat("summary.native-heap"));     // Catch: Exception -> L13
        CastIntegerProtector.parseInt(r104.getMemoryStat("summary.code"));     // Catch: Exception -> L13
        CastIntegerProtector.parseInt(r104.getMemoryStat("summary.stack"));     // Catch: Exception -> L13
        CastIntegerProtector.parseInt(r104.getMemoryStat("summary.private-other"));     // Catch: Exception -> L13
        r101.f547374j = ((long) CastIntegerProtector.parseInt(r104.getMemoryStat("summary.system"))) * 1024;     // Catch: Exception -> L13
        r101.f547373i = ((long) CastIntegerProtector.parseInt(r104.getMemoryStat("summary.total-pss"))) * 1024;     // Catch: Exception -> L13
        CastIntegerProtector.parseInt(r104.getMemoryStat("summary.total-swap"));     // Catch: Exception -> L13
    L10:
        r101.f547368d = ((long) r105) * 1024;     // Catch: Exception -> L14
        r101.f547369e = ((long) r106) * 1024;     // Catch: Exception -> L14
        r101.f547370f = ((long) r107) * 1024;     // Catch: Exception -> L14
        int r108 = r104.dalvikPrivateDirty;     // Catch: Exception -> L14
        int r109 = r104.dalvikSharedDirty;     // Catch: Exception -> L14
        int r110 = r104.otherPss;     // Catch: Exception -> L14
        int r111 = r104.otherPrivateDirty;     // Catch: Exception -> L14
        int r112 = r104.otherSharedDirty;     // Catch: Exception -> L14
        r104.getTotalSwappablePss();     // Catch: Exception -> L14
        r104.getTotalPrivateDirty();     // Catch: Exception -> L14
        r104.getTotalSharedClean();     // Catch: Exception -> L14
    L11:
        r101.f547372h = com.bytedance.apm.util.b.k() * 1024;     // Catch: Exception -> L14
    L12:
        return r101;
    }
}
