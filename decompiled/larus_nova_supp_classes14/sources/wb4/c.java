package wb4;

import com.bytedance.bdturing.livedetect.camera.ImageDataWrapper;
import com.bytedance.bdturing.livedetect.camera.ImageUtil;
import com.bytedance.bdturing.livedetect.view.LiveDetectView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends PthreadThreadV2 {
    public final ArrayBlockingQueue<f> v;
    public a w;
    public final AtomicBoolean x;
    public final AtomicBoolean y;

    public final void l() {
    L3:
        if (this.y.get() == true) goto L14;
        f r0 = this.v.take();     // Catch: Exception -> L12
        this.x.set(false);     // Catch: Exception -> L12
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L12
        ImageDataWrapper r2 = ImageUtil.buildBitmap(r0);     // Catch: Exception -> L12
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L12
        hc4.d.b(r3, "convert_camera_data_time_use", Long.valueOf(System.currentTimeMillis() - r1));     // Catch: Exception -> L12
        a r4 = this.w;     // Catch: Exception -> L12
        if (r4 == null) goto L10;
        if (r2 == null) goto L10;
        if (r2.bitmap == null) goto L10;
        ((LiveDetectView) r4).e(r2, r3);     // Catch: Exception -> L12
    L10:
        this.x.set(true);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L3
    }

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

    /* JADX WARN: Multi-variable type inference failed */
    public c(a r3) {
        super("CameraImageHandleTask");
        this.v = new ArrayBlockingQueue(1);
        this.x = new AtomicBoolean(true);
        this.y = new AtomicBoolean(false);
        this.w = r3;
        ThreadMethodProxy.setName(this, "turing_live_detect");
    }

    public final void m(f r2) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.v.isEmpty() == true) goto L5;
        return;
    L5:
        if (this.x.get() == false) goto L14;
        this.v.put(r2);     // Catch: Exception -> L8
        return;
    }
}
