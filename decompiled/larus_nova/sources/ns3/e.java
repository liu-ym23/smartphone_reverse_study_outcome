package ns3;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.util.t;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    public static class a implements Comparator<t> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(t r100, t r101) {
            return (int) (r101.f190686c - r100.f190686c);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f520300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f520301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f520302c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f520303d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public double f520304e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f520305f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f520306g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public double f520307h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public double f520308i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public double f520309j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f520310k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f520311l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f520312m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f520313n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public List<String> f520314o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public long f520315p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public long f520316q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public List<t> f520317r;

        public final String toString() {
            return "LaunchTraceData{gcCount=" + this.f520300a + ", gcTime=" + this.f520301b + ", blockGcCount=" + this.f520302c + ", blockGcTime=" + this.f520303d + ", cpuTime=" + this.f520304e + ", voluntarySwitches=" + this.f520305f + ", inVoluntarySwitches=" + this.f520306g + ", iowaitTime=" + this.f520307h + ", runnableTime=" + this.f520308i + ", sleepTime=" + this.f520309j + ", minorFault=" + this.f520311l + ", majorFault=" + this.f520312m + ", allThreadCount=" + this.f520313n + ", javaThreadNameList=" + this.f520314o + ", lockTime=-1, binderTime=" + this.f520310k + '}';
        }

        public b() {
            this.f520300a = -1;
            this.f520301b = -1;
            this.f520302c = -1;
            this.f520303d = -1;
            this.f520304e = -1.0d;
            this.f520305f = -1;
            this.f520306g = -1;
            this.f520307h = -1.0d;
            this.f520308i = -1.0d;
            this.f520309j = -1.0d;
            this.f520310k = -1;
            this.f520311l = -1;
            this.f520312m = -1;
            this.f520313n = -1;
            this.f520314o = null;
            this.f520315p = -1;
            this.f520316q = -1;
        }
    }

    public static void b(b r100) {
        int r101 = 0;
        int r102 = new PolarisFileWrapper("/proc/self/task/").listFiles().length;     // Catch: Throwable -> L5
    L6:
        if (r102 != 0) goto L8;
        return;
    L8:
        ThreadGroup r103 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getThreadGroup();
        if (r103 != null) goto L12;
        return;
    L12:
        if (r103.getParent() == null) goto L14;
        r103 = r103.getParent();
        goto L12
    L14:
        int r104 = r103.activeCount();
        Thread[] r105 = new Thread[r104 + (r104 / 2)];
        int r106 = r103.enumerate(r105);
        LinkedList r107 = new LinkedList();
    L15:
        if (r101 >= r106) goto L20;
        String r108 = r105[r101].getName();
        if (TextUtils.isEmpty(r108) == true) goto L19;
        r107.add(r108);
    L19:
        r101 = r101 + 1;
        goto L15
    L20:
        r100.f520313n = r102;
        r100.f520314o = r107;
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public static void a(b r110, int r111, int r112, long r113) {
        long r100 = -1;
        BufferedReader r101 = null;
        BufferedReader r102 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L8 Exception -> L11
    L48:
        String r103 = r102.readLine();     // Catch: Throwable -> L6 Exception -> L41
        r102.close();     // Catch: Throwable -> L6 Exception -> L41
        String[] r104 = r103.split(" ");     // Catch: Throwable -> L6 Exception -> L41
        long r114 = Long.parseLong(r104[13]) + Long.parseLong(r104[14]);
        d27.d.a(r102);
    L13:
        r110.f520315p = r114;
        BufferedReader r105 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + r111 + "/stat"));     // Catch: Throwable -> L23 Throwable -> L40
        String r106 = r105.readLine();     // Catch: Throwable -> L20 Throwable -> L22
        if (r106 == null) goto L19;
        r100 = ((SystemClock.elapsedRealtime() * com.bytedance.apm.util.b.f()) / 1000) - Long.parseLong(r106.split(" ")[21]);
        goto L19
    L19:
        d27.d.a(r105);
    L27:
        r110.f520316q = r100;
        long r107 = (com.bytedance.apm.util.b.f() * r113) / 1000;
        if (r110.f520316q <= (2 * r107)) goto L36;
        if (com.bytedance.apm.d.j() == false) goto L34;
        av3.a r108 = av3.b.f16366a;
        if (r108 == null) goto L34;
        r108.a();
    L34:
        r110.f520316q = r107;
    L36:
        if (com.bytedance.apm.d.j() == false) goto L38;
        av3.b.d("LaunchPerfData", "processCpuTime: " + r110.f520315p + " processDuration: " + r110.f520316q);
    L38:
        LinkedList<t> r109 = com.bytedance.apm.util.b.h(r111, true, r110.f520316q);
        Collections.sort(r109, new a());
        r110.f520317r = r109.subList(0, Math.min(r109.size(), r112));
        return;
    L22:
        r101 = r105;
    L20:
        th = th;
        r101 = r105;
    L24:
        d27.d.a(r101);
        throw th;
    L23:
        th = th;
    L26:
        d27.d.a(r101);
        goto L27
    L6:
        th = th;
        r101 = r102;
    L9:
        d27.d.a(r101);
        throw th;
    L12:
        d27.d.a(r102);
        r114 = -1;
    L11:
        r102 = null;
    L8:
        th = th;
        goto L9
    }
}
