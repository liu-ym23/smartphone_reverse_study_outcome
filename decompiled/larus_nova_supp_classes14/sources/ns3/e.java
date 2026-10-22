package ns3;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.apm.util.t;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import d27.d;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {

    public static class a implements Comparator<t> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(t r3, t r4) {
            return (int) (r4.c - r3.c);
        }
    }

    public static class b {
        public long a;
        public long b;
        public long c;
        public long d;
        public double e;
        public long f;
        public long g;
        public double h;
        public double i;
        public double j;
        public long k;
        public long l;
        public long m;
        public long n;
        public List<String> o;
        public long p;
        public long q;
        public List<t> r;

        public final String toString() {
            return "LaunchTraceData{gcCount=" + this.a + ", gcTime=" + this.b + ", blockGcCount=" + this.c + ", blockGcTime=" + this.d + ", cpuTime=" + this.e + ", voluntarySwitches=" + this.f + ", inVoluntarySwitches=" + this.g + ", iowaitTime=" + this.h + ", runnableTime=" + this.i + ", sleepTime=" + this.j + ", minorFault=" + this.l + ", majorFault=" + this.m + ", allThreadCount=" + this.n + ", javaThreadNameList=" + this.o + ", lockTime=-1, binderTime=" + this.k + '}';
        }

        public b() {
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = -1.0d;
            this.f = -1;
            this.g = -1;
            this.h = -1.0d;
            this.i = -1.0d;
            this.j = -1.0d;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = null;
            this.p = -1;
            this.q = -1;
        }
    }

    public static void b(b r7) {
        int r0 = 0;
        int r1 = new PolarisFileWrapper("/proc/self/task/").listFiles().length;     // Catch: Throwable -> L5
    L6:
        if (r1 != 0) goto L8;
        return;
    L8:
        ThreadGroup r2 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getThreadGroup();
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.getParent() == null) goto L14;
        r2 = r2.getParent();
        goto L12
    L14:
        int r3 = r2.activeCount();
        Thread[] r4 = new Thread[r3 + (r3 / 2)];
        int r5 = r2.enumerate(r4);
        LinkedList r6 = new LinkedList();
    L15:
        if (r0 >= r5) goto L20;
        String r8 = r4[r0].getName();
        if (TextUtils.isEmpty(r8) == true) goto L19;
        r6.add(r8);
    L19:
        r0 = r0 + 1;
        goto L15
    L20:
        r7.n = r1;
        r7.o = r6;
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public static void a(b r14, int r15, int r16, long r17) {
        long r6 = -1;
        BufferedReader r8 = null;
        BufferedReader r9 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/stat")), ECDraweeView.SQUARE);     // Catch: Throwable -> L8 Exception -> L11
    L48:
        String r5 = r9.readLine();     // Catch: Throwable -> L6 Exception -> L41
        r9.close();     // Catch: Throwable -> L6 Exception -> L41
        String[] r7 = r5.split(" ");     // Catch: Throwable -> L6 Exception -> L41
        long r10 = Long.parseLong(r7[13]) + Long.parseLong(r7[14]);
        d.a(r9);
    L13:
        r14.p = r10;
        BufferedReader r11 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + r15 + "/stat"));     // Catch: Throwable -> L23 Throwable -> L40
        String r3 = r11.readLine();     // Catch: Throwable -> L20 Throwable -> L22
        if (r3 == null) goto L19;
        r6 = ((SystemClock.elapsedRealtime() * com.bytedance.apm.util.b.f()) / 1000) - Long.parseLong(r3.split(" ")[21]);
        goto L19
    L19:
        d.a(r11);
    L27:
        r14.q = r6;
        long r2 = (com.bytedance.apm.util.b.f() * r17) / 1000;
        if (r14.q <= (2 * r2)) goto L36;
        if (com.bytedance.apm.d.j() == false) goto L34;
        av3.a r4 = av3.b.a;
        if (r4 == null) goto L34;
        r4.a();
    L34:
        r14.q = r2;
    L36:
        if (com.bytedance.apm.d.j() == false) goto L38;
        av3.b.d("LaunchPerfData", "processCpuTime: " + r14.p + " processDuration: " + r14.q);
    L38:
        LinkedList r1 = com.bytedance.apm.util.b.h(r15, true, r14.q);
        Collections.sort(r1, new a());
        r14.r = r1.subList(0, Math.min(r1.size(), r16));
        return;
    L22:
        r8 = r11;
    L20:
        th = th;
        r8 = r11;
    L24:
        d.a(r8);
        throw th;
    L23:
        th = th;
    L26:
        d.a(r8);
        goto L27
    L6:
        th = th;
        r8 = r9;
    L9:
        d.a(r8);
        throw th;
    L12:
        d.a(r9);
        r10 = -1;
    L11:
        r9 = null;
    L8:
        th = th;
        goto L9
    }
}
