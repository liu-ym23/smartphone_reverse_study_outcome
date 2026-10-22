package qh7;

import android.app.Application;
import android.os.Process;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.timonbase.report.TMDataCollector;
import com.bytedance.timonbase.scene.SensesUpdateBroadcastReceiver;
import com.bytedance.timonbase.scene.lifecycle.ForegroundState;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ph7.d;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static MappedByteBuffer f532971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static FileChannel f532972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f532973c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f532974d;

    static {
        f532973c = new Object();
    }

    public static ForegroundState a() {
        if (f532971a == null) goto L17;
        if (f532974d == true) goto L17;
        ForegroundState r100 = c();     // Catch: Exception -> L13
        if (new PolarisFileWrapper("/proc/" + r100.f270886a).exists() == true) goto L20;
        return new ForegroundState(r100.f270886a, false, r100.f270888c);
    L20:
        return r100;
    L13:
        e = move-exception;
        TMDataCollector.f270828e.g("ForegroundHolder_error", e, "getForegroundState failed ", MapsKt.emptyMap(), false);
        return new ForegroundState(Process.myPid(), f532974d, System.currentTimeMillis());
    L17:
        return new ForegroundState(Process.myPid(), f532974d, System.currentTimeMillis());
    }

    public static ForegroundState c() {
        Object r100 = f532973c;
        monitor-enter(r100);
        FileLock r101 = null;
        MappedByteBuffer r102 = f532971a;     // Catch: Throwable -> L20 Exception -> L22
        if (r102 != null) goto L8;
        Intrinsics.throwNpe();     // Catch: Throwable -> L20 Exception -> L22
    L8:
        FileChannel r103 = f532972b;     // Catch: Throwable -> L20 Exception -> L22
        if (r103 != null) goto L11;
        Intrinsics.throwNpe();     // Catch: Throwable -> L20 Exception -> L22
    L11:
        r101 = r103.lock();     // Catch: Throwable -> L20 Exception -> L22
        r102.position(0);     // Catch: Throwable -> L20 Exception -> L22
        int r104 = r102.getInt();     // Catch: Throwable -> L20 Exception -> L22
        byte r105 = r102.get();     // Catch: Throwable -> L20 Exception -> L22
        long r106 = r102.getLong();     // Catch: Throwable -> L20 Exception -> L22
        boolean r107 = true;
        if (r105 == 1) goto L15;
        r107 = false;
    L15:
        ForegroundState r108 = new ForegroundState(r104, r107, r106);     // Catch: Throwable -> L20 Exception -> L22
        if (r101 == null) goto L18;
        r101.release();     // Catch: Throwable -> L33
    L18:
        monitor-exit(r100);
        return r108;
    L33:
        th = move-exception;
        throw th;
    L22:
        e = move-exception;
        TMDataCollector.f270828e.g("ForegroundHolder_error", e, "readForegroundState failed ", MapsKt.emptyMap(), false);     // Catch: Throwable -> L20
        if (r101 == null) goto L29;
        r101.release();     // Catch: Throwable -> L33
    L29:
        return new ForegroundState(Process.myPid(), false, System.currentTimeMillis());
    L20:
        th = move-exception;
        if (r101 == null) goto L32;
        r101.release();     // Catch: Throwable -> L33
    L32:
        throw th;     // Catch: Throwable -> L33
    }

    public static void d(boolean r110) {
        f532974d = r110;
        MappedByteBuffer r100 = f532971a;
        if (r100 == null) goto L35;
        int r101 = com.bytedance.timonbase.b.f270799a;
        com.bytedance.timonbase.b.a("ForegroundHolder", Process.myPid() + " -> setForegroundState(" + r110 + ')');
        Object r102 = f532973c;
        monitor-enter(r102);
        FileLock r103 = null;
        FileChannel r104 = f532972b;     // Catch: Throwable -> L18 Exception -> L20
        if (r104 == null) goto L16;
        r103 = r104.lock();     // Catch: Throwable -> L18 Exception -> L20
        if (r110 == false) goto L12;
        r100.position(0);     // Catch: Throwable -> L18 Exception -> L20
        int r105 = Process.myPid();     // Catch: Throwable -> L18 Exception -> L20
        long r106 = System.currentTimeMillis();     // Catch: Throwable -> L18 Exception -> L20
        r100.putInt(r105);     // Catch: Throwable -> L18 Exception -> L20
        r100.put((byte) 1);     // Catch: Throwable -> L18 Exception -> L20
        r100.putLong(r106);     // Catch: Throwable -> L18 Exception -> L20
        e(r105, true, r106);     // Catch: Throwable -> L18 Exception -> L20
    L15:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L18 Exception -> L20
    L12:
        r100.position(0);     // Catch: Throwable -> L18 Exception -> L20
        int r107 = r100.getInt();     // Catch: Throwable -> L18 Exception -> L20
        if (Process.myPid() != r107) goto L15;
        r100.position(0);     // Catch: Throwable -> L18 Exception -> L20
        r100.putInt(r107);     // Catch: Throwable -> L18 Exception -> L20
        r100.put((byte) 0);     // Catch: Throwable -> L18 Exception -> L20
        long r108 = System.currentTimeMillis();     // Catch: Throwable -> L18 Exception -> L20
        r100.putLong(r108);     // Catch: Throwable -> L18 Exception -> L20
        e(r107, false, r108);     // Catch: Throwable -> L18 Exception -> L20
    L16:
        if (r103 != null) goto L24;
    L28:
        monitor-exit(r102);
        return;
    L24:
        r103.release();     // Catch: Throwable -> L26
    L20:
        e = move-exception;
        TMDataCollector.f270828e.g("ForegroundHolder_error", e, "setForeground failed " + r110, MapsKt.emptyMap(), false);     // Catch: Throwable -> L18
        e(Process.myPid(), false, System.currentTimeMillis());     // Catch: Throwable -> L18
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L18
        if (r103 == null) goto L28;
    L18:
        th = move-exception;
        if (r103 == null) goto L32;
        r103.release();     // Catch: Throwable -> L26
    L32:
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public static void b(Application r100, boolean r101) {
        f532974d = r101;
        RandomAccessFile r102 = new RandomAccessFile(new PolarisFileWrapper(r100.getFilesDir(), "foreground.status"), "rw");     // Catch: Exception -> L5
        f532972b = r102.getChannel();     // Catch: Exception -> L5
        f532971a = r102.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 13);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        TMDataCollector.f270828e.g("ForegroundHolder_error", e, "ForegroundHolder init failed ", MapsKt.emptyMap(), false);
    }

    public static void e(int r100, boolean r101, long r102) {
        ph7.c r103 = d.f529300a;
        if (r103 == null) goto L5;
        boolean r104 = r103.d();
    L6:
        if (r104 == false) goto L9;
        SensesUpdateBroadcastReceiver.a r105 = SensesUpdateBroadcastReceiver.f270877c;
        ForegroundState r106 = new ForegroundState(r100, r101, r102);
        r105.getClass();
        SensesUpdateBroadcastReceiver.a.a(3, r106);
        return;
    L9:
        return;
    L5:
        r104 = false;
        goto L6
    }
}
