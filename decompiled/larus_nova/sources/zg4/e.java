package zg4;

import com.bytedance.crash.util.p;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends zg4.b implements IConfigListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile int f572060k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IConfigManager f572061l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f572062m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f572063n;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f572064a;

        @Override // java.lang.Runnable
        public final void run() {
            e.l(this.f572064a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(e r100) {
            this.f572064a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f572065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f572066b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f572066b.g(this.f572065a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(e r100, JSONObject r101) {
            this.f572066b = r100;
            this.f572065a = r101;
        }
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public final void onReady() {
    }

    @Override // zg4.b
    public final void c() {
        if (com.bytedance.crash.util.b.e(com.bytedance.crash.i.getContext(), com.bytedance.crash.util.b.c()) == true) goto L13;
        super.c();
        return;
    L13:
        IConfigManager r100 = (IConfigManager) ServiceManager.getService(IConfigManager.class);     // Catch: Throwable -> L11
        this.f572061l = r100;     // Catch: Throwable -> L11
        if (r100 == null) goto L9;
        r100.registerConfigListener(this);     // Catch: Throwable -> L11
    L9:
        wh4.b.postDelayed(this.f572062m, 2000);     // Catch: Throwable -> L11
        return;
    L11:
        super.c();
    }

    public e(com.bytedance.crash.monitor.f r100) {
        super(r100);
        this.f572063n = false;
        this.f572062m = new a(this);
    }

    public static void l(e r100) {
        r100.getClass();
        p.d("tryGetConfigFromApm isReady:" + r100.f572063n);
        if (r100.f572063n == true) goto L16;
        p.d("tryGetConfigFromApm mTryCount:" + r100.f572060k);
        if (r100.f572060k < 30) goto L9;
        wh4.b.f(r100.f572062m);
        super.c();
    L14:
        r100.f572060k++;
        return;
    L9:
        if (r100.f572061l != null) goto L13;
        IConfigManager r101 = (IConfigManager) ServiceManager.getService(IConfigManager.class);
        r100.f572061l = r101;
        if (r101 == null) goto L13;
        r101.registerConfigListener(r100);
    L13:
        wh4.b.f(r100.f572062m);
        wh4.b.postDelayed(r100.f572062m, 2000);
        goto L14
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public final void onRefresh(JSONObject r100, boolean r101) {
        this.f572063n = true;
        wh4.b.f(this);
        wh4.b.post(new b(this, r100));
    }
}
