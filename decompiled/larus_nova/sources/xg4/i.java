package xg4;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.ttm.player.MediaPlayer;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f563655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f563656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f563657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PolarisFileWrapper f563658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f563659e;

    /* JADX INFO: loaded from: classes15.dex */
    public class a extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final PolarisFileWrapper f563660v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final /* synthetic */ i f563661w;

        public final void l() {
            com.bytedance.crash.util.p.e("AnrInfoMonitor:prepare lock：" + com.bytedance.crash.util.b.c());
            int r100 = NativeBridge.p(this.f563660v.getAbsolutePath());
            com.bytedance.crash.util.p.e("AnrInfoMonitor:run：" + com.bytedance.crash.util.b.c());
            ActivityManager r101 = (ActivityManager) this.f563661w.f563657c.getSystemService("activity");
            long r102 = zg4.i.f572086b;
            ActivityManager.ProcessErrorStateInfo r103 = null;
        L4:
            if (this.f563661w.f563655a == false) goto L39;
            SystemClock.sleep(r102);
            if (r101 != null) goto L8;
            r101 = (ActivityManager) this.f563661w.f563657c.getSystemService("activity");
        L8:
            if (r101 == null) goto L4;
            List<ActivityManager.ProcessErrorStateInfo> r104 = r101.getProcessesInErrorState();     // Catch: Throwable -> L37
            if (r104 == null) goto L4;
            Iterator<ActivityManager.ProcessErrorStateInfo> r105 = r104.iterator();     // Catch: Throwable -> L37
        L15:
            if (r105.hasNext() == false) goto L4;
            ActivityManager.ProcessErrorStateInfo r106 = r105.next();     // Catch: Throwable -> L37
            if (r106.condition != 2) goto L15;
            if (r103 == null) goto L23;
            if (j.f(r103, r106) == true) goto L15;
        L23:
            long r107 = System.currentTimeMillis();     // Catch: Throwable -> L37
            int r110 = r106.pid;     // Catch: Throwable -> L37
            if (Process.myPid() != r106.pid) goto L26;
            boolean r111 = true;
        L27:
            PolarisFileWrapper r112 = new PolarisFileWrapper(this.f563661w.f563658d, i.b(r107, r110, r111));     // Catch: Throwable -> L37
            com.bytedance.crash.util.h.h(r112, j.d(r106), false);     // Catch: Exception -> L42 Throwable -> L37
        L30:
            if (r112.exists() == false) goto L15;
            if (Process.myPid() != r106.pid) goto L34;
            p.b(r107, r112);     // Catch: Throwable -> L36
        L34:
            SystemClock.sleep(20 * r102);     // Catch: Throwable -> L36
            r103 = r106;
        L36:
            r103 = r106;
            goto L4
        L26:
            r111 = false;
            goto L27
        L39:
            if (r100 == (-1)) goto L72;
            NativeBridge.g0(r100);     // Catch: Throwable -> L43
            return;
        L73:
            return;
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(i r100, PolarisFileWrapper r101) {
            this.f563661w = r100;
            super("NPTH-AnrInfoPolling");
            this.f563660v = com.bytedance.crash.util.g.d(r101, "monitor.lock");
        }
    }

    public static class b extends FileObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PolarisFileWrapper f563662a;

        public b(String r100) {
            super(r100, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME);
            this.f563662a = new PolarisFileWrapper(r100);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int r100, String r101) {
            if ((r100 & 8) != 0) goto L5;
            return;
        L5:
            if (r101.startsWith("ai_") == true) goto L7;
            return;
        L7:
            if (i.d(r101) == Process.myPid()) goto L9;
            return;
        L9:
            if (r101.endsWith("_other") == false) goto L15;
            p.b(i.c(r101), new PolarisFileWrapper(this.f563662a, r101));
            return;
        }
    }

    public class c extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final LinkedBlockingQueue<Long> f563663v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final /* synthetic */ i f563664w;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
        L8:
            Long r100 = this.f563663v.take();     // Catch: Throwable -> L7
            if (r100 != null) goto L4;
            System.out.println("get_anr_info_start_time_null");     // Catch: Throwable -> L7
            goto L8
        L4:
            e(r100.longValue());     // Catch: Throwable -> L7
            goto L8
        }

        public c(i r100) {
            this.f563664w = r100;
            super("FetchingAnrInfo");
            this.f563663v = new LinkedBlockingQueue();
        }

        public final void e(long r100) {
            System.out.println("get_anr_info_start_" + r100);     // Catch: Throwable -> L10
            String r101 = xg4.a.a(this.f563664w.f563657c);     // Catch: Throwable -> L10
            if (TextUtils.isEmpty(r101) == false) goto L6;
            System.out.println("get_anr_info_is_empty");     // Catch: Throwable -> L10
            r101 = "silent anr no anr info";
        L6:
            PolarisFileWrapper r102 = new PolarisFileWrapper(this.f563664w.f563658d, i.b(r100, Process.myPid(), true));     // Catch: Throwable -> L10
            com.bytedance.crash.util.h.h(r102, r101, false);     // Catch: Exception -> L14 Throwable -> L10
        L8:
            p.b(r100, r102);     // Catch: Throwable -> L10
            return;
        L10:
            PolarisFileWrapper r103 = new PolarisFileWrapper(this.f563664w.f563658d, i.b(r100, Process.myPid(), true));
            com.bytedance.crash.util.h.h(r103, "silent anr no anr info", false);     // Catch: Exception -> L15
        L12:
            p.b(r100, r103);
        }
    }

    public static long c(String r100) {
        String[] r101 = r100.split("_");
        if (r101.length != 4) goto L8;
        return Long.decode(r101[1]).longValue();
    L8:
        return System.currentTimeMillis();
    }

    public static int d(String r100) {
        String[] r101 = r100.split("_");
        if (r101.length == 4) goto L10;
        return 0;
    L10:
        return Integer.decode(r101[2]).intValue();
    L12:
        return 0;
    }

    public final void e(PolarisFileWrapper r110) {
        if (this.f563658d.exists() == true) goto L5;
        File[] r100 = null;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        int r101 = r100.length;
        int r102 = 0;
    L9:
        if (r102 >= r101) goto L25;
        File r103 = r100[r102];
        int r104 = d(r103.getName());     // Catch: Throwable -> L22
        long r105 = c(r103.getName());     // Catch: Throwable -> L22
        if (r104 != 0) goto L14;
    L20:
        r103.delete();     // Catch: Throwable -> L22
        xg4.a.c(new Exception("Invalid ANR Info File Name :{" + r103.getName() + com.alipay.sdk.m.u.i.f25855d));     // Catch: Throwable -> L22
    L24:
        r102 = r102 + 1;
        goto L9
    L14:
        if (r105 == 0) goto L20;
        StringBuffer r106 = new StringBuffer();     // Catch: Throwable -> L22
        File r107 = a(r110, r105, r104, r106);     // Catch: Throwable -> L22
        if (r107 != null) goto L19;
        r103.delete();     // Catch: Throwable -> L22
        xg4.a.c(new Exception("Not found matched directory pid:" + r104 + "_" + r103.getName() + "_:reason:" + r106));     // Catch: Throwable -> L22
        goto L24
    L19:
        r103.renameTo(new PolarisFileWrapper(r107, "anr_info.txt"));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        ch4.c.d("NPTH_ANR_ERROR", th);
        goto L24
    L25:
        return;
    L5:
        r100 = this.f563658d.listFiles(new g());
        goto L6
    }

    public i(Context r100, PolarisFileWrapper r101) {
        this.f563657c = r100;
        PolarisFileWrapper r102 = com.bytedance.crash.util.g.b(r101, "anr_info");
        this.f563658d = r102;
        this.f563656b = new b(r102.getAbsolutePath());
    }

    public static String b(long r100, int r101, boolean r102) {
        if (r102 == false) goto L4;
        String r103 = "_current";
    L6:
        return "ai_" + r100 + "_" + r101 + r103;
    L4:
        r103 = "_other";
        goto L6
    }

    public static File a(PolarisFileWrapper r210, long r211, long r212, StringBuffer r213) {
        File[] r100 = r210.listFiles(new h(r212));
        if (r100 != null) goto L5;
    L56:
        r213.append("processDirs==null");
        return null;
    L5:
        if (r100.length == 0) goto L56;
        int r101 = r100.length;
        char r102 = 0;
        int r103 = 0;
    L8:
        if (r103 >= r101) goto L54;
        File r104 = r100[r103];
        if (r104.isDirectory() == true) goto L12;
    L11:
        int r105 = r101;
    L53:
        r103 = r103 + 1;
        r101 = r105;
        r102 = 0;
        goto L8
    L12:
        String[] r106 = r104.getName().split("-");
        if (r106.length != 2) goto L11;
        long r110 = CastLongProtector.parseLong(r106[r102]);     // Catch: Throwable -> L18
    L20:
        if (r110 != 0) goto L22;
    L52:
        r105 = r101;
        r213.append("startTime:" + r110 + "_" + r211);
        goto L53
    L22:
        if (r110 > r211) goto L52;
        File[] r107 = r104.listFiles();
        if (r107 != null) goto L27;
        r213.append("crashDirs is null ");
        goto L11
    L27:
        int r111 = r107.length;
        int r112 = 0;
    L28:
        if (r112 >= r111) goto L11;
        File r113 = r107[r112];
        if (r113.isDirectory() == true) goto L32;
        r213.append("crashDirs is not directory ");
    L38:
        r101 = r101;
    L51:
        r112 = r112 + 1;
        r101 = r101;
        goto L28
    L32:
        String r114 = w.f563732g;
        if (new PolarisFileWrapper(r113, w.f563732g).exists() == true) goto L36;
        r213.append("hasSummaryFile is false ");
        goto L38
    L36:
        if (new PolarisFileWrapper(r113, "anr_info.txt").exists() == false) goto L58;
        r213.append("anrinfo exist:");
        goto L38
    L58:
        long r108 = CastLongProtector.parseLong(r113.getName());     // Catch: Throwable -> L41
    L43:
        if (r108 != 0) goto L45;
    L50:
        r213.append("last error:" + r108 + "_" + r211);
        goto L51
    L45:
        if (Math.abs(r108 - r211) > 35000) goto L47;
        boolean r115 = true;
    L48:
        if (r115 == false) goto L50;
        return r113;
    L47:
        r115 = false;
    L41:
        r108 = 0;
    L18:
        r110 = 0;
        goto L20
    L54:
        return null;
    }
}
