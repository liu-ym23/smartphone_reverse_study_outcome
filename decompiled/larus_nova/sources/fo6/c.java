package fo6;

import android.app.Activity;
import android.os.SystemClock;
import com.bytedance.locallife.biz.router.NoActivityStartedCallbackException;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f478163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f478164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f478165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f478166d;

    public c(b r100, String r101, long r102, String r103) {
        this.f478163a = r100;
        this.f478164b = r101;
        this.f478165c = r102;
        this.f478166d = r103;
    }

    public final void a() {
        b.C5935b r100 = this.f478163a.f478151b.get(this.f478164b);
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.f478157f == true) goto L9;
        NoActivityStartedCallbackException r101 = new NoActivityStartedCallbackException("任务[" + this.f478164b + "]延迟" + this.f478165c + "ms结束，未收到任何Activity的onActivityStarted回调（触发Activity：" + this.f478166d + 65289);
        com.bytedance.locallife.biz.common.utils.c.a("ActivityStartedDelayedExecutor", "任务[" + this.f478164b + "]延迟" + this.f478165c + "ms结束，未收到任何Activity的onActivityStarted回调（触发Activity：" + this.f478166d + 65289);
        r100.f478159h.invoke(r101);
        this.f478163a.a(this.f478164b);
        return;
    L9:
        if ((SystemClock.uptimeMillis() - r100.f478154c) < r100.f478153b) goto L15;
        WeakReference<Activity> r102 = r100.f478158g;
        if (r102 == null) goto L13;
        Activity r103 = r102.get();
    L14:
        r100.f478155d.invoke(r103);
        this.f478163a.a(this.f478164b);
        com.bytedance.locallife.biz.common.utils.c.a("ActivityStartedDelayedExecutor", "已收到回调，且延迟时间已到，触发Activity：" + this.f478166d);
        return;
    L13:
        r103 = null;
        goto L14
    L15:
        com.bytedance.locallife.biz.common.utils.c.a("ActivityStartedDelayedExecutor", "已收到回调，但延迟时间未到，暂不处理，触发Activity：" + this.f478166d);
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
}
