package es3;

import android.os.Build;
import android.view.FrameMetrics;
import android.view.Window;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes14.dex */
public final class l implements Window.OnFrameMetricsAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f473756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f473757b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f473758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f473759b;

        public final void a() {
            com.bytedance.apm.block.a r100 = h.B;
            if (r100 == null) goto L7;
            l r101 = this.f473759b;
            if (r101.f473757b.f473740w == false) goto L7;
            r100.f(r101.f473756a, this.f473758a);
            return;
        L7:
            Iterator r102 = ((CopyOnWriteArrayList) this.f473759b.f473757b.f473721d).iterator();
        L9:
            if (r102.hasNext() == false) goto L13;
            ((com.bytedance.apm.block.a) r102.next()).f(this.f473759b.f473756a, this.f473758a);
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

        public a(l r100, long r101, int r102) {
            this.f473759b = r100;
            this.f473758a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameMetrics f473760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f473761b;

        public final void a() {
            com.bytedance.apm.block.a r100 = h.B;
            if (r100 == null) goto L7;
            l r101 = this.f473761b;
            if (r101.f473757b.f473740w == false) goto L7;
            r100.g(r101.f473756a, this.f473760a);
            return;
        L7:
            Iterator r102 = ((CopyOnWriteArrayList) this.f473761b.f473757b.f473721d).iterator();
        L9:
            if (r102.hasNext() == false) goto L13;
            ((com.bytedance.apm.block.a) r102.next()).g(this.f473761b.f473756a, this.f473760a);
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

        public b(l r100, FrameMetrics r101, int r102) {
            this.f473761b = r100;
            this.f473760a = r101;
        }
    }

    public l(h r100, String r101) {
        this.f473757b = r100;
        this.f473756a = r101;
    }

    @Override // android.view.Window.OnFrameMetricsAvailableListener
    public final void onFrameMetricsAvailable(Window r110, FrameMetrics r111, int r210) {
        if (Build.VERSION.SDK_INT < 36) goto L9;
        long r100 = r111.getMetric(11);
        long r101 = this.f473757b.f473742y;
        if (r100 != this.f473757b.f473742y) goto L7;
        return;
    L7:
        this.f473757b.f473742y = r100;
    L9:
        if (this.f473757b.f473738u == true) goto L11;
        FrameMetrics r102 = new FrameMetrics(r111);
        if (r102.getMetric(9) != 0) goto L28;
        this.f473757b.getClass();
        long r112 = (((((r102.getMetric(0) + r102.getMetric(1)) + r102.getMetric(2)) + r102.getMetric(3)) + r102.getMetric(4)) + r102.getMetric(5)) / 1000000;
        h r103 = this.f473757b;
        long r104 = r103.f473741x;
        if (r104 > 0) goto L22;
    L23:
        r103.f473732o.a(new b(this, r102, r210));
        return;
    L22:
        if (r112 > r104) goto L23;
        return;
    L28:
        return;
    L11:
        if (r111.getMetric(9) != 0) goto L25;
        long r113 = (((((r111.getMetric(0) + r111.getMetric(1)) + r111.getMetric(2)) + r111.getMetric(3)) + r111.getMetric(4)) + r111.getMetric(5)) / 1000000;
        this.f473757b.getClass();
        h r105 = this.f473757b;
        long r106 = r105.f473741x;
        if (r106 > 0) goto L15;
    L16:
        r105.f473732o.a(new a(this, r113, r210));
        return;
    L15:
        if (r113 > r106) goto L16;
        return;
    }
}
