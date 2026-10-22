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

/* JADX INFO: loaded from: classes14.dex */
public final class c extends PthreadThreadV2 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayBlockingQueue<f> f558937v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public a f558938w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AtomicBoolean f558939x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final AtomicBoolean f558940y;

    public final void l() {
    L3:
        if (this.f558940y.get() == true) goto L14;
        f r100 = this.f558937v.take();     // Catch: Exception -> L12
        this.f558939x.set(false);     // Catch: Exception -> L12
        long r101 = System.currentTimeMillis();     // Catch: Exception -> L12
        ImageDataWrapper r102 = ImageUtil.buildBitmap(r100);     // Catch: Exception -> L12
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L12
        hc4.d.b(r103, "convert_camera_data_time_use", Long.valueOf(System.currentTimeMillis() - r101));     // Catch: Exception -> L12
        a r104 = this.f558938w;     // Catch: Exception -> L12
        if (r104 == null) goto L10;
        if (r102 == null) goto L10;
        if (r102.bitmap == null) goto L10;
        ((LiveDetectView) r104).e(r102, r103);     // Catch: Exception -> L12
    L10:
        this.f558939x.set(true);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L3
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

    public c(a r100) {
        super("CameraImageHandleTask");
        this.f558937v = new ArrayBlockingQueue(1);
        this.f558939x = new AtomicBoolean(true);
        this.f558940y = new AtomicBoolean(false);
        this.f558938w = r100;
        ThreadMethodProxy.setName(this, "turing_live_detect");
    }

    public final void m(f r100) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.f558937v.isEmpty() == true) goto L5;
        return;
    L5:
        if (this.f558939x.get() == false) goto L14;
        this.f558937v.put(r100);     // Catch: Exception -> L8
        return;
    }
}
