package pt3;

import android.system.Os;
import android.system.OsConstants;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.sva.sdk.controller.Global;
import com.optimize.statistics.FrescoMonitorConst;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f530639d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f530640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f530641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ByteBuffer f530642c;

    public class a implements FileFilter {
        public a() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File r100) {
            String r101 = r100.getName();
            if (r101.endsWith(".log") == false) goto L6;
            return true;
        L6:
            if (r101.endsWith(Global.SUFFIX_TXT_FILE) == true) goto L8;
            xu3.b.a(r100);
            return false;
        L8:
            if (r100.renameTo(new PolarisFileWrapper(r100.getParentFile(), r101.substring(0, r101.length() - 4) + ".log")) == false) goto L10;
            return true;
        L10:
            return false;
        }
    }

    public final synchronized String[] d() {
        monitor-enter(this);
        File[] r100 = this.f530640a.listFiles(new a());     // Catch: Throwable -> L17
        if (r100 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L17
        int r102 = r100.length;     // Catch: Throwable -> L17
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L14;
        String r104 = r100[r103].getName();     // Catch: Throwable -> L17
        if (r104.endsWith(Global.SUFFIX_TXT_FILE) == false) goto L13;
        r104 = r104.substring(0, r104.length() - 4) + ".log";     // Catch: Throwable -> L17
    L13:
        r101.add(r104);     // Catch: Throwable -> L17
        r103 = r103 + 1;     // Catch: Throwable -> L17
        goto L9
    L14:
        String[] r105 = (String[]) r101.toArray(new String[r101.size()]);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r105;
    L17:
        th = move-exception;
        throw th;
    }

    static {
        int r100 = (int) Os.sysconf(OsConstants._SC_PAGESIZE);
    L5:
        f530639d = r100;
        return;
    L4:
        r100 = 4096;
        goto L5
    }

    public final synchronized void b() {
        monitor-enter(this);
        boolean r100 = false;
        short r101 = this.f530642c.getShort(0);     // Catch: Throwable -> L51
        long r102 = this.f530642c.getLong(2);     // Catch: Throwable -> L51
        int r110 = this.f530642c.getInt(10);     // Catch: Throwable -> L51
        int r111 = this.f530642c.getInt(14);     // Catch: Throwable -> L51
        if (r101 != 2082) goto L46;
        if (r111 <= 0) goto L46;
        if (r110 <= 0) goto L46;
        if (xu3.a.a() == false) goto L12;
        List<String> r103 = mt3.a.f515607a;     // Catch: Throwable -> L51
        av3.b.a("APM-Slardar", "flushing: headerId=" + r102 + " totalCount=" + r110 + " totalBytes=" + r111 + " dir=" + this.f530640a.getName());     // Catch: Throwable -> L51
    L12:
        long r104 = System.nanoTime();     // Catch: Throwable -> L51
        FileChannel r105 = null;
        String r106 = System.currentTimeMillis() + "_" + UUID.randomUUID().toString();     // Catch: Throwable -> L35
    L22:
        th = move-exception;
        List<String> r112 = mt3.a.f515607a;     // Catch: Throwable -> L35
        av3.b.c("APM-Slardar", "flushDir create error.", th);     // Catch: Throwable -> L35
    L24:
        PolarisFileWrapper r107 = new PolarisFileWrapper(this.f530640a, r106 + Global.SUFFIX_TXT_FILE);     // Catch: Throwable -> L35
        if (r107.exists() == false) goto L27;
        List<String> r113 = mt3.a.f515607a;     // Catch: Throwable -> L35
        av3.b.b("APM-Slardar", "file is exist:" + r107.getName());     // Catch: Throwable -> L35
    L27:
        r105 = new PolarisFileOutputStreamWrapper(r107, false).getChannel();     // Catch: Throwable -> L35
        this.f530642c.position(r111 + 18);     // Catch: Throwable -> L35
        this.f530642c.flip();     // Catch: Throwable -> L35
        r105.write(this.f530642c);     // Catch: Throwable -> L35
        if (r107.renameTo(new PolarisFileWrapper(this.f530640a, r106 + ".log")) == false) goto L30;
        r100 = true;
    L32:
        if (xu3.a.a() == false) goto L37;
        List<String> r108 = mt3.a.f515607a;     // Catch: Throwable -> L35
        av3.b.a("APM-Slardar", "flush to file success. flushFile=" + r107.getAbsolutePath());     // Catch: Throwable -> L35
    L37:
        xu3.c.a(r105);     // Catch: Throwable -> L51
        if (r100 == true) goto L40;
        c();     // Catch: Throwable -> L51
    L40:
        f();     // Catch: Throwable -> L51
        if (xu3.a.a() == false) goto L43;
        List<String> r109 = mt3.a.f515607a;     // Catch: Throwable -> L51
        av3.b.a("APM-Slardar", "flush cost=" + (System.nanoTime() - r104));     // Catch: Throwable -> L51
    L43:
        monitor-exit(this);
        return;
    L30:
        List<String> r114 = mt3.a.f515607a;     // Catch: Throwable -> L35
        av3.b.b("APM-Slardar", "rename error" + r107.getAbsolutePath());     // Catch: Throwable -> L35
        goto L32
    L16:
        if (this.f530640a.exists() == true) goto L24;
        File r115 = this.f530640a.getParentFile();     // Catch: Throwable -> L22
        if (r115.exists() == true) goto L20;
        r115.mkdirs();     // Catch: Throwable -> L22
    L20:
        this.f530640a.mkdirs();     // Catch: Throwable -> L22
    L35:
        th = move-exception;
        List<String> r116 = mt3.a.f515607a;     // Catch: Throwable -> L54
        av3.b.c("APM-Slardar", this.f530640a.exists() + " flush to file failed.", th);     // Catch: Throwable -> L54
    L46:
        if (xu3.a.a() == false) goto L48;
        List<String> r117 = mt3.a.f515607a;     // Catch: Throwable -> L51
        av3.b.a("APM-Slardar", "flushing: Skipped. no data to flush. reset buffer now. dir=" + this.f530640a.getName());     // Catch: Throwable -> L51
    L48:
        f();     // Catch: Throwable -> L51
        monitor-exit(this);
        return;
    L51:
        th = move-exception;
        throw th;
    }

    public final void c() {
        this.f530642c.position(this.f530642c.getInt(14) + 18);
        this.f530642c.flip();
        pt3.a r100 = pt3.a.b(this.f530642c);
        if (xu3.a.a() == false) goto L5;
        List<String> r101 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "flush to memory success. logFile=" + r100);
    L5:
        mt3.c r102 = mt3.c.e.f515622a;
        if (r100 != null) goto L8;
        r102.getClass();
        return;
    L8:
        r102.f515615c.c(r100);
    }

    public final void f() {
        this.f530642c.clear();
        this.f530642c.putShort(2082);
        this.f530642c.putLong(this.f530641b);
        this.f530642c.putInt(0);
        this.f530642c.putInt(0);
    }

    public static void a(FileChannel r100) throws IOException {
        long r101 = r100.size();
        if (r101 < 0) goto L22;
        if (r101 < 262162) goto L7;
        return;
    L7:
        ByteBuffer r102 = ByteBuffer.allocate(1);
        r102.put(0, (byte) 0);
        int r103 = f530639d;
    L8:
        r101 = r101 + ((long) r103);
        if (r101 >= 262162) goto L15;
        r102.position(0);
        r100.position(r101 - 1);
    L12:
        if (r102.hasRemaining() == false) goto L14;
        r100.write(r102);
        goto L12
    L14:
        r103 = f530639d;
        goto L8
    L15:
        r102.position(0);
        r100.position(262161);
    L17:
        if (r102.hasRemaining() == false) goto L19;
        r100.write(r102);
        goto L17
    L19:
        r100.force(true);
        return;
    L22:
        throw new IOException("file size < 0");
    }

    public final synchronized void e(JSONObject r100) {
        monitor-enter(this);
        if (r100 != null) goto L34;
        monitor-exit(this);
        return;
    L34:
        String r101 = r100.toString();     // Catch: Throwable -> L28
        if (xu3.a.a() == false) goto L10;
        AtomicInteger r102 = ls3.a.f510531a;     // Catch: Throwable -> L28
        DoctorManager.getInstance().a("DATA_SAVE_TO_DB", new JSONObject(r100.toString()));     // Catch: Exception -> L31 Throwable -> L28
    L10:
        byte[] r103 = r101.getBytes();     // Catch: Throwable -> L28
        int r104 = r103.length + 4;     // Catch: Throwable -> L28
        if (r104 <= 262144) goto L16;
        nu3.b.a(new d(r100.optJSONObject("service"), r100.optJSONObject(FrescoMonitorConst.LOG_TYPE)));     // Catch: Throwable -> L28
        monitor-exit(this);
        return;
    L16:
        if (r104 <= this.f530642c.remaining()) goto L18;
        b();     // Catch: Throwable -> L28
    L18:
        this.f530642c.putInt(r103.length);     // Catch: Throwable -> L28
        this.f530642c.put(r103);     // Catch: Throwable -> L28
        this.f530642c.putInt(10, this.f530642c.getInt(10) + 1);     // Catch: Throwable -> L28
        this.f530642c.putInt(14, this.f530642c.getInt(14) + r104);     // Catch: Throwable -> L28
        if (xu3.a.a() == false) goto L22;
        String r105 = String.format("push success: totalCount=%s, totalBytes=%s, dir=%s, logItem=%s", new Object[]{Integer.valueOf(this.f530642c.getInt(10)), Integer.valueOf(this.f530642c.getInt(14)), this.f530640a.getName(), r101});     // Catch: Throwable -> L28
        List<String> r106 = mt3.a.f515607a;     // Catch: Throwable -> L28
        av3.b.a("APM-Slardar", r105);     // Catch: Throwable -> L28
    L22:
        if (this.f530642c.position() < 262134) goto L24;
    L25:
        b();     // Catch: Throwable -> L28
    L26:
        monitor-exit(this);
        return;
    L24:
        if (this.f530642c.getInt(10) < 256) goto L26;
    L28:
        th = move-exception;
        throw th;
    }

    public c(long r100, File r101, File r110) {
        this.f530640a = r110;
        this.f530641b = r100;
        FileChannel r102 = new RandomAccessFile(r101, "rw").getChannel();     // Catch: Throwable -> L5
        r102.tryLock();     // Catch: Throwable -> L5
        a(r102);     // Catch: Throwable -> L5
        this.f530642c = r102.map(FileChannel.MapMode.READ_WRITE, 0, 262162);     // Catch: Throwable -> L5
        b();     // Catch: Throwable -> L5
    L8:
        if (this.f530642c != null) goto L10;
        this.f530642c = ByteBuffer.allocate(262162);
    L10:
        f();
        return;
    L5:
        th = move-exception;
        List<String> r103 = mt3.a.f515607a;
        av3.b.c("APM-Slardar", "create MappedByteBuffer failed. will fallback into HeapByteBuffer", th);
        goto L8
    }
}
