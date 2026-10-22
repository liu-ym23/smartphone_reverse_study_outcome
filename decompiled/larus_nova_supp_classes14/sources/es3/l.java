package es3;

import android.os.Build;
import android.view.FrameMetrics;
import android.view.Window;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l implements Window.OnFrameMetricsAvailableListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ h b;

    public class a implements Runnable {
        public final /* synthetic */ long a;
        public final /* synthetic */ l b;

        public final void a() {
            com.bytedance.apm.block.a r0 = h.B;
            if (r0 == null) goto L7;
            l r1 = this.b;
            if (r1.b.w == false) goto L7;
            r0.f(r1.a, this.a);
            return;
        L7:
            Iterator r2 = ((CopyOnWriteArrayList) this.b.b.d).iterator();
        L9:
            if (r2.hasNext() == false) goto L13;
            ((com.bytedance.apm.block.a) r2.next()).f(this.b.a, this.a);
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(l r1, long r2, int r4) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ FrameMetrics a;
        public final /* synthetic */ l b;

        public final void a() {
            com.bytedance.apm.block.a r0 = h.B;
            if (r0 == null) goto L7;
            l r1 = this.b;
            if (r1.b.w == false) goto L7;
            r0.g(r1.a, this.a);
            return;
        L7:
            Iterator r2 = ((CopyOnWriteArrayList) this.b.b.d).iterator();
        L9:
            if (r2.hasNext() == false) goto L13;
            ((com.bytedance.apm.block.a) r2.next()).g(this.b.a, this.a);
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(l r1, FrameMetrics r2, int r3) {
            this.b = r1;
            this.a = r2;
        }
    }

    public l(h r1, String r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // android.view.Window.OnFrameMetricsAvailableListener
    public final void onFrameMetricsAvailable(Window r18, FrameMetrics r19, int r20) {
        if (Build.VERSION.SDK_INT < 36) goto L9;
        long r3 = r19.getMetric(11);
        long r5 = this.b.y;
        if (r3 != this.b.y) goto L7;
        return;
    L7:
        this.b.y = r3;
    L9:
        if (this.b.u == true) goto L11;
        FrameMetrics r4 = new FrameMetrics(r19);
        if (r4.getMetric(9) != 0) goto L28;
        this.b.getClass();
        long r11 = (((((r4.getMetric(0) + r4.getMetric(1)) + r4.getMetric(2)) + r4.getMetric(3)) + r4.getMetric(4)) + r4.getMetric(5)) / 1000000;
        h r1 = this.b;
        long r6 = r1.x;
        if (r6 > 0) goto L22;
    L23:
        r1.o.a(new b(this, r4, r20));
        return;
    L22:
        if (r11 > r6) goto L23;
        return;
    L28:
        return;
    L11:
        if (r19.getMetric(9) != 0) goto L25;
        long r12 = (((((r19.getMetric(0) + r19.getMetric(1)) + r19.getMetric(2)) + r19.getMetric(3)) + r19.getMetric(4)) + r19.getMetric(5)) / 1000000;
        this.b.getClass();
        h r2 = this.b;
        long r7 = r2.x;
        if (r7 > 0) goto L15;
    L16:
        r2.o.a(new a(this, r12, r20));
        return;
    L15:
        if (r12 > r7) goto L16;
        return;
    }
}
